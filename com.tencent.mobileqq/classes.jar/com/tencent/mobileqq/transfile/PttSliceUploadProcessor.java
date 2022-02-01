package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import baij;
import baim;
import bhhd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.smartptt.Smartptt.PttTransRsp;
import tencent.im.cs.smartptt.Smartptt.ReqBody;
import tencent.im.cs.smartptt.Smartptt.RspBody;

public class PttSliceUploadProcessor
  extends BaseUploadProcessor
{
  private static final int BLOCK_SIZE = 6400;
  private static final float BYTES_MSECOND = 32.0F;
  private static final int BYTES_SECOND = 32000;
  public static final int COMMAND_ID_PTT_SLICE_TRANS = 68;
  private static final byte[] HEAD = bhhd.a(1, 16000);
  private static final int SIMPLE_RATE = 16000;
  public static final String TAG = "PttSliceUploadProcessor";
  private SmartPttTranHelper.PttSliceInfoBean mCurInfo;
  private int offset;
  private String pcmPath;
  private baim processor;
  private String result = "";
  private Transaction trans;
  private long vadSegEndPos;
  private long vadSegStartPos;
  private String voiceID;
  
  public PttSliceUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private void checkIsLast(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mIsCancel) {
      sendMessageToUpdate(1004);
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        sendMessageToUpdate(2003);
      } while (!QLog.isColorLevel());
      QLog.d("PttSliceUploadProcessor", 2, "sendMessageToUpdate send finished!");
      return;
      processVADSegSlice();
    } while (!paramBoolean2);
    sendMessageToUpdate(2002);
  }
  
  private void checkNextDataIsValid(SmartPttTranHelper.PttSliceInfoBean paramPttSliceInfoBean, int paramInt)
  {
    if ((!paramPttSliceInfoBean.isLast) && (this.vadSegEndPos - this.vadSegStartPos < 6400L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "last p of seg ");
      }
      Object localObject = new byte[(int)(this.vadSegEndPos - this.vadSegStartPos)];
      paramInt = this.mRaf.read((byte[])localObject, 0, (int)(this.vadSegEndPos - this.vadSegStartPos));
      localObject = this.processor.a((byte[])localObject, 0, paramInt);
      if ((localObject == null) || (((baij)localObject).jdField_a_of_type_Int == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttSliceUploadProcessor", 2, "last p silk len is 0 ");
        }
        paramPttSliceInfoBean.isLast = true;
        this.offset = 0;
      }
    }
  }
  
  @Nullable
  private File checkPCMFile()
  {
    File localFile2 = new File(this.pcmPath);
    File localFile1 = localFile2;
    if (!localFile2.exists())
    {
      setError(9042, getExpStackString(new Exception("sendFile not exist " + this.pcmPath)));
      onError();
      localFile1 = null;
    }
    return localFile1;
  }
  
  private SmartPttTranHelper.PttSliceInfoBean getTranBean()
  {
    SmartPttTranHelper.PttSliceInfoBean localPttSliceInfoBean = new SmartPttTranHelper.PttSliceInfoBean();
    localPttSliceInfoBean.voiceId = (this.voiceID + this.mUiRequest.pcmForVadPos);
    localPttSliceInfoBean.offset = this.offset;
    localPttSliceInfoBean.md5 = this.mMd5Str;
    localPttSliceInfoBean.chatType = this.mUiRequest.chatType;
    localPttSliceInfoBean.filePath = (this.mUiRequest.mLocalPath.substring(0, this.mUiRequest.mLocalPath.lastIndexOf(File.separator)) + "/tmp_" + localPttSliceInfoBean.voiceId + "_" + this.offset + ".silk");
    localPttSliceInfoBean.encodeType = 6;
    if (this.offset == 0) {}
    for (localPttSliceInfoBean.isfirst = true;; localPttSliceInfoBean.isfirst = false)
    {
      localPttSliceInfoBean.vegNum = this.mUiRequest.pcmForVadNum;
      localPttSliceInfoBean.vegPos = this.mUiRequest.pcmForVadPos;
      return localPttSliceInfoBean;
    }
  }
  
  private void handleSuceess(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    Smartptt.RspBody localRspBody = new Smartptt.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "onSuccess  text =" + localRspBody.msg_ptttrans_rsp.str_text.get() + " id=" + localRspBody.msg_ptttrans_rsp.str_voice_id.get() + " pos=" + this.mUiRequest.pcmForVadPos + " uint32_is_final=" + localRspBody.msg_ptttrans_rsp.uint32_is_final.get());
      }
      this.file.fileType = 327696;
      this.file.pttSliceText = (this.result + localRspBody.msg_ptttrans_rsp.str_text.get());
      this.file.commandId = 68;
      this.file.pttSlicePos = this.mUiRequest.pcmForVadPos;
      boolean bool1 = bool2;
      if (localRspBody.msg_ptttrans_rsp.uint32_is_final.get() != 1) {
        if (!this.mCurInfo.isLast) {
          break label237;
        }
      }
      label237:
      for (bool1 = bool2;; bool1 = false)
      {
        checkIsLast(bool1, true);
        this.mStepTrans.logFinishTime();
        this.mStepTrans.result = 1;
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private boolean initRandomFile()
  {
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.pcmPath, "r");
        this.mRaf.seek(0L);
        if (this.mRaf == null)
        {
          setError(9303, "read file error");
          onError();
          return true;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mRaf = null;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private void processVADSeg()
  {
    if ((this.mUiRequest.vadSeg != null) && ((this.mUiRequest.vadSeg instanceof WXVadSeg)))
    {
      WXVadSeg localWXVadSeg = this.mUiRequest.vadSeg;
      this.vadSegStartPos = (localWXVadSeg.mbtm * 32L);
      this.vadSegEndPos = (localWXVadSeg.metm * 32L);
      this.offset = 0;
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "generateFileByOneSeg, vadSegStartPos=" + this.vadSegStartPos + " EPS=" + this.vadSegEndPos + " segPos=" + this.mUiRequest.pcmForVadPos + " size=" + this.mUiRequest.pcmForVadNum);
      }
    }
    try
    {
      this.mRaf.seek(this.vadSegStartPos);
      processVADSegSlice();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private void processVADSegSlice()
  {
    if (this.mIsCancel) {
      return;
    }
    SmartPttTranHelper.PttSliceInfoBean localPttSliceInfoBean = getTranBean();
    byte[] arrayOfByte;
    for (;;)
    {
      try
      {
        if (this.vadSegEndPos - this.vadSegStartPos > 6400L)
        {
          Object localObject = new byte[6400];
          i = this.mRaf.read((byte[])localObject, 0, 6400);
          this.vadSegStartPos += 6400L;
          localPttSliceInfoBean.isLast = false;
          checkNextDataIsValid(localPttSliceInfoBean, i);
          localObject = this.processor.a((byte[])localObject, 0, i);
          if ((localObject != null) && (((baij)localObject).jdField_a_of_type_Int != 0)) {
            break;
          }
          checkIsLast(localPttSliceInfoBean.isLast, false);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
      arrayOfByte = new byte[(int)(this.vadSegEndPos - this.vadSegStartPos)];
      int i = this.mRaf.read(arrayOfByte, 0, (int)(this.vadSegEndPos - this.vadSegStartPos));
      localPttSliceInfoBean.isLast = true;
      this.offset = 0;
    }
    writeToTmpFile(localPttSliceInfoBean, arrayOfByte);
    this.mCurInfo = localPttSliceInfoBean;
    submitSlice(localPttSliceInfoBean);
  }
  
  private void submitSlice(SmartPttTranHelper.PttSliceInfoBean paramPttSliceInfoBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "submitSlice, info:" + paramPttSliceInfoBean);
    }
    PttSliceUploadProcessor.1 local1 = new PttSliceUploadProcessor.1(this, SystemClock.uptimeMillis());
    this.trans = new Transaction(this.app.getCurrentAccountUin(), 68, paramPttSliceInfoBean.filePath, (int)this.mStartOffset, getMd5(paramPttSliceInfoBean.filePath), local1, SmartPttTranHelper.getSmartPttReqBody(paramPttSliceInfoBean).toByteArray(), false);
    int i = this.app.getHwEngine().submitTransactionTask(this.trans);
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " bean:" + paramPttSliceInfoBean + " Cmd:");
    }
    if (i != 0)
    {
      setError(i, "SubmitError.", "", this.mStepTrans);
      onError();
    }
  }
  
  /* Error */
  private void writeToTmpFile(SmartPttTranHelper.PttSliceInfoBean paramPttSliceInfoBean, baij parambaij)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 134	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: getfield 227	com/tencent/mobileqq/transfile/SmartPttTranHelper$PttSliceInfoBean:filePath	Ljava/lang/String;
    //   11: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 142	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_3
    //   23: invokevirtual 462	java/io/File:delete	()Z
    //   26: pop
    //   27: new 464	java/io/FileOutputStream
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 467	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_3
    //   36: aload_1
    //   37: getfield 233	com/tencent/mobileqq/transfile/SmartPttTranHelper$PttSliceInfoBean:isfirst	Z
    //   40: ifeq +57 -> 97
    //   43: aload_3
    //   44: getstatic 45	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:HEAD	[B
    //   47: invokevirtual 470	java/io/FileOutputStream:write	([B)V
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 129	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   55: aload_2
    //   56: getfield 125	baij:jdField_a_of_type_Int	I
    //   59: getstatic 45	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:HEAD	[B
    //   62: arraylength
    //   63: iadd
    //   64: iadd
    //   65: putfield 129	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   68: aload_3
    //   69: aload_2
    //   70: getfield 472	baij:jdField_a_of_type_ArrayOfByte	[B
    //   73: aload_2
    //   74: getfield 475	baij:b	I
    //   77: aload_2
    //   78: getfield 125	baij:jdField_a_of_type_Int	I
    //   81: invokevirtual 478	java/io/FileOutputStream:write	([BII)V
    //   84: aload_3
    //   85: invokevirtual 481	java/io/FileOutputStream:flush	()V
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: aload_1
    //   98: getfield 96	com/tencent/mobileqq/transfile/SmartPttTranHelper$PttSliceInfoBean:isLast	Z
    //   101: ifne -33 -> 68
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 129	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   109: aload_2
    //   110: getfield 125	baij:jdField_a_of_type_Int	I
    //   113: iadd
    //   114: putfield 129	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   117: goto -49 -> 68
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: invokevirtual 324	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull -32 -> 96
    //   131: aload_1
    //   132: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   135: return
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 485	java/lang/Exception:printStackTrace	()V
    //   141: return
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 485	java/lang/Exception:printStackTrace	()V
    //   147: return
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_2
    //   162: aload_2
    //   163: invokevirtual 485	java/lang/Exception:printStackTrace	()V
    //   166: goto -7 -> 159
    //   169: astore_1
    //   170: aload_3
    //   171: astore_2
    //   172: goto -21 -> 151
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: goto -29 -> 151
    //   183: astore_2
    //   184: aload 4
    //   186: astore_1
    //   187: goto -64 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	PttSliceUploadProcessor
    //   0	190	1	paramPttSliceInfoBean	SmartPttTranHelper.PttSliceInfoBean
    //   0	190	2	parambaij	baij
    //   14	157	3	localObject1	Object
    //   175	4	3	localObject2	Object
    //   1	184	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	68	120	java/io/IOException
    //   68	88	120	java/io/IOException
    //   97	117	120	java/io/IOException
    //   131	135	136	java/lang/Exception
    //   92	96	142	java/lang/Exception
    //   3	27	148	finally
    //   27	36	148	finally
    //   155	159	161	java/lang/Exception
    //   36	68	169	finally
    //   68	88	169	finally
    //   97	117	169	finally
    //   123	127	175	finally
    //   3	27	183	java/io/IOException
    //   27	36	183	java/io/IOException
  }
  
  public int cancel()
  {
    int i = super.cancel();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "cancel");
    }
    if (this.trans != null) {
      this.trans.cancelTransaction();
    }
    return i;
  }
  
  protected void finalize()
  {
    super.finalize();
  }
  
  /* Error */
  byte[] getMd5(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 499	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 500	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 4
    //   21: aload_0
    //   22: getfield 292	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   25: getfield 503	com/tencent/mobileqq/transfile/FileMsg:fileSize	J
    //   28: invokestatic 509	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   31: astore 7
    //   33: aload 7
    //   35: astore_1
    //   36: aload_1
    //   37: astore_3
    //   38: aload 4
    //   40: ifnull +10 -> 50
    //   43: aload 4
    //   45: invokevirtual 510	java/io/FileInputStream:close	()V
    //   48: aload_1
    //   49: astore_3
    //   50: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +32 -> 85
    //   56: ldc 22
    //   58: iconst_2
    //   59: new 146	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 512
    //   69: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_3
    //   73: invokestatic 518	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   76: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_3
    //   86: areturn
    //   87: astore_3
    //   88: aload 4
    //   90: astore_3
    //   91: new 134	java/io/File
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 7
    //   101: aload 4
    //   103: astore_3
    //   104: aload 7
    //   106: invokevirtual 142	java/io/File:exists	()Z
    //   109: istore_2
    //   110: aload 5
    //   112: astore_1
    //   113: iload_2
    //   114: ifeq -78 -> 36
    //   117: aload 4
    //   119: astore_3
    //   120: aload 7
    //   122: invokestatic 523	bkvq:a	(Ljava/io/File;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +14 -> 141
    //   130: aload 4
    //   132: astore_3
    //   133: aload_1
    //   134: invokestatic 526	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   137: astore_1
    //   138: goto -102 -> 36
    //   141: ldc 52
    //   143: astore_1
    //   144: goto -14 -> 130
    //   147: astore_3
    //   148: aload_3
    //   149: invokevirtual 324	java/io/IOException:printStackTrace	()V
    //   152: aload_1
    //   153: astore_3
    //   154: goto -104 -> 50
    //   157: astore 5
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_3
    //   163: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +32 -> 198
    //   169: aload_1
    //   170: astore_3
    //   171: ldc 22
    //   173: iconst_2
    //   174: new 146	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 528
    //   184: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 6
    //   200: astore_3
    //   201: aload_1
    //   202: ifnull -152 -> 50
    //   205: aload_1
    //   206: invokevirtual 510	java/io/FileInputStream:close	()V
    //   209: aload 6
    //   211: astore_3
    //   212: goto -162 -> 50
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 324	java/io/IOException:printStackTrace	()V
    //   220: aload 6
    //   222: astore_3
    //   223: goto -173 -> 50
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_3
    //   230: ifnull +7 -> 237
    //   233: aload_3
    //   234: invokevirtual 510	java/io/FileInputStream:close	()V
    //   237: aload_1
    //   238: athrow
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual 324	java/io/IOException:printStackTrace	()V
    //   244: goto -7 -> 237
    //   247: astore_1
    //   248: goto -19 -> 229
    //   251: astore 5
    //   253: aload 4
    //   255: astore_1
    //   256: goto -95 -> 161
    //   259: astore_1
    //   260: aload 5
    //   262: astore_1
    //   263: goto -227 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	PttSliceUploadProcessor
    //   0	266	1	paramString	String
    //   109	5	2	bool	boolean
    //   18	68	3	localObject1	Object
    //   87	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   90	43	3	localFileInputStream1	java.io.FileInputStream
    //   147	2	3	localIOException1	IOException
    //   153	81	3	localObject2	Object
    //   239	2	3	localIOException2	IOException
    //   14	240	4	localFileInputStream2	java.io.FileInputStream
    //   4	107	5	localObject3	Object
    //   157	31	5	localIOException3	IOException
    //   251	10	5	localIOException4	IOException
    //   1	220	6	localObject4	Object
    //   31	90	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   19	33	87	java/lang/UnsatisfiedLinkError
    //   43	48	147	java/io/IOException
    //   6	16	157	java/io/IOException
    //   205	209	215	java/io/IOException
    //   6	16	226	finally
    //   233	237	239	java/io/IOException
    //   19	33	247	finally
    //   91	101	247	finally
    //   104	110	247	finally
    //   120	126	247	finally
    //   133	138	247	finally
    //   163	169	247	finally
    //   171	198	247	finally
    //   19	33	251	java/io/IOException
    //   91	101	251	java/io/IOException
    //   104	110	251	java/io/IOException
    //   120	126	259	java/io/IOException
    //   133	138	259	java/io/IOException
  }
  
  public void start()
  {
    this.pcmPath = this.mUiRequest.pcmForVadPath;
    if (this.pcmPath == null)
    {
      setError(9042, "No pcm source");
      onError();
    }
    File localFile;
    do
    {
      do
      {
        return;
        if ((this.mLocalMd5 == null) && (!getMd5()))
        {
          setError(9041, "No Local MD5");
          onError();
          return;
        }
      } while (initRandomFile());
      localFile = checkPCMFile();
    } while (localFile == null);
    this.mFileSize = localFile.length();
    this.voiceID = this.mMd5Str;
    this.processor = new baim();
    this.processor.a(new SilkCodecWrapper(BaseApplication.getContext()));
    try
    {
      this.processor.a(16000, 16000, 1);
      processVADSeg();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttSliceUploadProcessor
 * JD-Core Version:    0.7.0.1
 */