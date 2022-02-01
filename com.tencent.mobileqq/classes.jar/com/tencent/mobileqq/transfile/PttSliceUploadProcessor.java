package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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
  private static final byte[] HEAD = RecordParams.a(1, 16000);
  private static final int SIMPLE_RATE = 16000;
  public static final String TAG = "PttSliceUploadProcessor";
  private SmartPttTranHelper.PttSliceInfoBean mCurInfo;
  private int offset = 0;
  private String pcmPath;
  private AudioCompositeProcessor processor;
  private String result = "";
  private Transaction trans;
  private long vadSegEndPos = 0L;
  private long vadSegStartPos = 0L;
  private String voiceID;
  
  public PttSliceUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private void checkIsLast(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mIsCancel)
    {
      sendMessageToUpdate(1004);
      return;
    }
    if (paramBoolean1)
    {
      sendMessageToUpdate(2003);
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "sendMessageToUpdate send finished!");
      }
    }
    else
    {
      processVADSegSlice();
      if (paramBoolean2) {
        sendMessageToUpdate(2002);
      }
    }
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
      if ((localObject == null) || (((IAudioProcessor.ProcessData)localObject).jdField_a_of_type_Int == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttSliceUploadProcessor", 2, "last p silk len is 0 ");
        }
        paramPttSliceInfoBean.isLast = true;
        this.offset = 0;
      }
    }
  }
  
  private File checkPCMFile()
  {
    Object localObject = new File(this.pcmPath);
    if (!((File)localObject).exists())
    {
      localObject = this.mProcessorReport;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendFile not exist ");
      localStringBuilder.append(this.pcmPath);
      ((ProcessorReport)localObject).setError(9042, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
      onError();
      return null;
    }
    return localObject;
  }
  
  private SmartPttTranHelper.PttSliceInfoBean getTranBean()
  {
    SmartPttTranHelper.PttSliceInfoBean localPttSliceInfoBean = new SmartPttTranHelper.PttSliceInfoBean();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.voiceID);
    localStringBuilder.append(this.mUiRequest.pcmForVadPos);
    localPttSliceInfoBean.voiceId = localStringBuilder.toString();
    localPttSliceInfoBean.offset = this.offset;
    localPttSliceInfoBean.md5 = this.mMd5Str;
    localPttSliceInfoBean.chatType = this.mUiRequest.chatType;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mUiRequest.mLocalPath.substring(0, this.mUiRequest.mLocalPath.lastIndexOf(File.separator)));
    localStringBuilder.append("/tmp_");
    localStringBuilder.append(localPttSliceInfoBean.voiceId);
    localStringBuilder.append("_");
    localStringBuilder.append(this.offset);
    localStringBuilder.append(".silk");
    localPttSliceInfoBean.filePath = localStringBuilder.toString();
    localPttSliceInfoBean.encodeType = 6;
    if (this.offset == 0) {
      localPttSliceInfoBean.isfirst = true;
    } else {
      localPttSliceInfoBean.isfirst = false;
    }
    localPttSliceInfoBean.vegNum = this.mUiRequest.pcmForVadNum;
    localPttSliceInfoBean.vegPos = this.mUiRequest.pcmForVadPos;
    return localPttSliceInfoBean;
  }
  
  private void handleSuceess(byte[] paramArrayOfByte)
  {
    Smartptt.RspBody localRspBody = new Smartptt.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("onSuccess  text =");
          paramArrayOfByte.append(localRspBody.msg_ptttrans_rsp.str_text.get());
          paramArrayOfByte.append(" id=");
          paramArrayOfByte.append(localRspBody.msg_ptttrans_rsp.str_voice_id.get());
          paramArrayOfByte.append(" pos=");
          paramArrayOfByte.append(this.mUiRequest.pcmForVadPos);
          paramArrayOfByte.append(" uint32_is_final=");
          paramArrayOfByte.append(localRspBody.msg_ptttrans_rsp.uint32_is_final.get());
          QLog.d("PttSliceUploadProcessor", 2, paramArrayOfByte.toString());
        }
        this.file.fileType = 327696;
        paramArrayOfByte = this.file;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.result);
        localStringBuilder.append(localRspBody.msg_ptttrans_rsp.str_text.get());
        paramArrayOfByte.pttSliceText = localStringBuilder.toString();
        this.file.commandId = 68;
        this.file.pttSlicePos = this.mUiRequest.pcmForVadPos;
        if (localRspBody.msg_ptttrans_rsp.uint32_is_final.get() == 1) {
          break label275;
        }
        if (!this.mCurInfo.isLast) {
          break label270;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      checkIsLast(bool, true);
      this.mProcessorReport.mStepTrans.logFinishTime();
      this.mProcessorReport.mStepTrans.result = 1;
      return;
      label270:
      boolean bool = false;
      continue;
      label275:
      bool = true;
    }
  }
  
  private boolean initRandomFile()
  {
    if (this.mRaf == null)
    {
      try
      {
        this.mRaf = new RandomAccessFile(this.pcmPath, "r");
        this.mRaf.seek(0L);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        this.mRaf = null;
      }
      if (this.mRaf == null)
      {
        this.mProcessorReport.setError(9303, "read file error", null, null);
        onError();
        return true;
      }
    }
    return false;
  }
  
  private void processVADSeg()
  {
    if ((this.mUiRequest.vadSeg != null) && ((this.mUiRequest.vadSeg instanceof WXVadSeg)))
    {
      Object localObject = this.mUiRequest.vadSeg;
      this.vadSegStartPos = (((WXVadSeg)localObject).mbtm * 32L);
      this.vadSegEndPos = (((WXVadSeg)localObject).metm * 32L);
      this.offset = 0;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("generateFileByOneSeg, vadSegStartPos=");
        ((StringBuilder)localObject).append(this.vadSegStartPos);
        ((StringBuilder)localObject).append(" EPS=");
        ((StringBuilder)localObject).append(this.vadSegEndPos);
        ((StringBuilder)localObject).append(" segPos=");
        ((StringBuilder)localObject).append(this.mUiRequest.pcmForVadPos);
        ((StringBuilder)localObject).append(" size=");
        ((StringBuilder)localObject).append(this.mUiRequest.pcmForVadNum);
        QLog.d("PttSliceUploadProcessor", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        this.mRaf.seek(this.vadSegStartPos);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      processVADSegSlice();
    }
  }
  
  private void processVADSegSlice()
  {
    if (this.mIsCancel) {
      return;
    }
    SmartPttTranHelper.PttSliceInfoBean localPttSliceInfoBean = getTranBean();
    try
    {
      int i;
      if (this.vadSegEndPos - this.vadSegStartPos > 6400L)
      {
        localObject = new byte[6400];
        i = this.mRaf.read((byte[])localObject, 0, 6400);
        this.vadSegStartPos += 6400L;
        localPttSliceInfoBean.isLast = false;
      }
      else
      {
        localObject = new byte[(int)(this.vadSegEndPos - this.vadSegStartPos)];
        i = this.mRaf.read((byte[])localObject, 0, (int)(this.vadSegEndPos - this.vadSegStartPos));
        localPttSliceInfoBean.isLast = true;
        this.offset = 0;
      }
      checkNextDataIsValid(localPttSliceInfoBean, i);
      Object localObject = this.processor.a((byte[])localObject, 0, i);
      if ((localObject != null) && (((IAudioProcessor.ProcessData)localObject).jdField_a_of_type_Int != 0))
      {
        writeToTmpFile(localPttSliceInfoBean, (IAudioProcessor.ProcessData)localObject);
        this.mCurInfo = localPttSliceInfoBean;
        submitSlice(localPttSliceInfoBean);
        return;
      }
      checkIsLast(localPttSliceInfoBean.isLast, false);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void submitSlice(SmartPttTranHelper.PttSliceInfoBean paramPttSliceInfoBean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("submitSlice, info:");
      ((StringBuilder)localObject).append(paramPttSliceInfoBean);
      QLog.d("PttSliceUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new PttSliceUploadProcessor.1(this, SystemClock.uptimeMillis());
    this.trans = new Transaction(this.app.getCurrentAccountUin(), 68, paramPttSliceInfoBean.filePath, (int)this.mStartOffset, getMd5(paramPttSliceInfoBean.filePath), (ITransactionCallback)localObject, SmartPttTranHelper.getSmartPttReqBody(paramPttSliceInfoBean).toByteArray(), false);
    int i = this.app.getHwEngine().submitTransactionTask(this.trans);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction submit RetCode:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" T_ID:");
      ((StringBuilder)localObject).append(this.trans.getTransationId());
      ((StringBuilder)localObject).append(" UniSeq:");
      ((StringBuilder)localObject).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject).append(" bean:");
      ((StringBuilder)localObject).append(paramPttSliceInfoBean);
      ((StringBuilder)localObject).append(" Cmd:");
      QLog.d("PttSliceUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 0)
    {
      this.mProcessorReport.setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  /* Error */
  private void writeToTmpFile(SmartPttTranHelper.PttSliceInfoBean paramPttSliceInfoBean, IAudioProcessor.ProcessData paramProcessData)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: new 133	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 231	com/tencent/mobileqq/transfile/SmartPttTranHelper$PttSliceInfoBean:filePath	Ljava/lang/String;
    //   17: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aload 4
    //   24: astore_3
    //   25: aload 6
    //   27: invokevirtual 141	java/io/File:exists	()Z
    //   30: ifeq +12 -> 42
    //   33: aload 4
    //   35: astore_3
    //   36: aload 6
    //   38: invokevirtual 460	java/io/File:delete	()Z
    //   41: pop
    //   42: aload 4
    //   44: astore_3
    //   45: new 462	java/io/FileOutputStream
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 465	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore 4
    //   56: aload_1
    //   57: getfield 237	com/tencent/mobileqq/transfile/SmartPttTranHelper$PttSliceInfoBean:isfirst	Z
    //   60: ifeq +32 -> 92
    //   63: aload 4
    //   65: getstatic 45	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:HEAD	[B
    //   68: invokevirtual 468	java/io/FileOutputStream:write	([B)V
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 60	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   76: aload_2
    //   77: getfield 127	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:jdField_a_of_type_Int	I
    //   80: getstatic 45	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:HEAD	[B
    //   83: arraylength
    //   84: iadd
    //   85: iadd
    //   86: putfield 60	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   89: goto +23 -> 112
    //   92: aload_1
    //   93: getfield 102	com/tencent/mobileqq/transfile/SmartPttTranHelper$PttSliceInfoBean:isLast	Z
    //   96: ifne +16 -> 112
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 60	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   104: aload_2
    //   105: getfield 127	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:jdField_a_of_type_Int	I
    //   108: iadd
    //   109: putfield 60	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:offset	I
    //   112: aload 4
    //   114: aload_2
    //   115: getfield 470	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:jdField_a_of_type_ArrayOfByte	[B
    //   118: aload_2
    //   119: getfield 473	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:b	I
    //   122: aload_2
    //   123: getfield 127	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:jdField_a_of_type_Int	I
    //   126: invokevirtual 476	java/io/FileOutputStream:write	([BII)V
    //   129: aload 4
    //   131: invokevirtual 479	java/io/FileOutputStream:flush	()V
    //   134: aload 4
    //   136: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   139: return
    //   140: astore_1
    //   141: goto +42 -> 183
    //   144: astore_2
    //   145: aload 4
    //   147: astore_1
    //   148: goto +14 -> 162
    //   151: astore_1
    //   152: aload_3
    //   153: astore 4
    //   155: goto +28 -> 183
    //   158: astore_2
    //   159: aload 5
    //   161: astore_1
    //   162: aload_1
    //   163: astore_3
    //   164: aload_2
    //   165: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   168: aload_1
    //   169: ifnull +13 -> 182
    //   172: aload_1
    //   173: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   176: return
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 483	java/lang/Exception:printStackTrace	()V
    //   182: return
    //   183: aload 4
    //   185: ifnull +16 -> 201
    //   188: aload 4
    //   190: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   193: goto +8 -> 201
    //   196: astore_2
    //   197: aload_2
    //   198: invokevirtual 483	java/lang/Exception:printStackTrace	()V
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	PttSliceUploadProcessor
    //   0	203	1	paramPttSliceInfoBean	SmartPttTranHelper.PttSliceInfoBean
    //   0	203	2	paramProcessData	IAudioProcessor.ProcessData
    //   8	156	3	localObject1	Object
    //   4	185	4	localObject2	Object
    //   1	159	5	localObject3	Object
    //   20	30	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   56	89	140	finally
    //   92	112	140	finally
    //   112	134	140	finally
    //   56	89	144	java/io/IOException
    //   92	112	144	java/io/IOException
    //   112	134	144	java/io/IOException
    //   9	22	151	finally
    //   25	33	151	finally
    //   36	42	151	finally
    //   45	56	151	finally
    //   164	168	151	finally
    //   9	22	158	java/io/IOException
    //   25	33	158	java/io/IOException
    //   36	42	158	java/io/IOException
    //   45	56	158	java/io/IOException
    //   134	139	177	java/lang/Exception
    //   172	176	177	java/lang/Exception
    //   188	193	196	java/lang/Exception
  }
  
  public int cancel()
  {
    int i = super.cancel();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "cancel");
    }
    Transaction localTransaction = this.trans;
    if (localTransaction != null) {
      localTransaction.cancelTransaction();
    }
    return i;
  }
  
  /* Error */
  byte[] getMd5(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: new 494	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 495	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload 4
    //   24: aload_0
    //   25: getfield 294	com/tencent/mobileqq/transfile/PttSliceUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   28: getfield 498	com/tencent/mobileqq/transfile/FileMsg:fileSize	J
    //   31: invokestatic 504	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   34: astore 8
    //   36: aload 8
    //   38: astore_1
    //   39: goto +69 -> 108
    //   42: astore_3
    //   43: aload 4
    //   45: astore_1
    //   46: aload_3
    //   47: astore 4
    //   49: goto +89 -> 138
    //   52: aload 4
    //   54: astore_3
    //   55: new 133	java/io/File
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 8
    //   65: aload 4
    //   67: astore_3
    //   68: aload 8
    //   70: invokevirtual 141	java/io/File:exists	()Z
    //   73: istore_2
    //   74: aload 7
    //   76: astore_1
    //   77: iload_2
    //   78: ifeq +30 -> 108
    //   81: aload 4
    //   83: astore_3
    //   84: aload 8
    //   86: invokestatic 509	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +196 -> 287
    //   94: goto +3 -> 97
    //   97: aload 4
    //   99: astore_3
    //   100: aload_1
    //   101: invokestatic 514	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   104: astore_1
    //   105: goto -66 -> 39
    //   108: aload_1
    //   109: astore_3
    //   110: aload 4
    //   112: invokevirtual 515	java/io/FileInputStream:close	()V
    //   115: aload_1
    //   116: astore_3
    //   117: goto +91 -> 208
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   125: goto +83 -> 208
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_3
    //   131: goto +121 -> 252
    //   134: astore 4
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_1
    //   139: astore_3
    //   140: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +48 -> 191
    //   146: aload_1
    //   147: astore_3
    //   148: new 147	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   155: astore 7
    //   157: aload_1
    //   158: astore_3
    //   159: aload 7
    //   161: ldc_w 517
    //   164: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_1
    //   169: astore_3
    //   170: aload 7
    //   172: aload 4
    //   174: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_1
    //   179: astore_3
    //   180: ldc 22
    //   182: iconst_2
    //   183: aload 7
    //   185: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload 5
    //   193: astore_3
    //   194: aload_1
    //   195: ifnull +13 -> 208
    //   198: aload 6
    //   200: astore_3
    //   201: aload_1
    //   202: invokevirtual 515	java/io/FileInputStream:close	()V
    //   205: aload 5
    //   207: astore_3
    //   208: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +38 -> 249
    //   214: new 147	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   221: astore_1
    //   222: aload_1
    //   223: ldc_w 519
    //   226: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_1
    //   231: aload_3
    //   232: invokestatic 523	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   235: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 22
    //   241: iconst_2
    //   242: aload_1
    //   243: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_3
    //   250: areturn
    //   251: astore_1
    //   252: aload_3
    //   253: ifnull +15 -> 268
    //   256: aload_3
    //   257: invokevirtual 515	java/io/FileInputStream:close	()V
    //   260: goto +8 -> 268
    //   263: astore_3
    //   264: aload_3
    //   265: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   268: goto +5 -> 273
    //   271: aload_1
    //   272: athrow
    //   273: goto -2 -> 271
    //   276: astore_3
    //   277: goto -225 -> 52
    //   280: astore_1
    //   281: aload 7
    //   283: astore_1
    //   284: goto -176 -> 108
    //   287: ldc 52
    //   289: astore_1
    //   290: goto -193 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	PttSliceUploadProcessor
    //   0	293	1	paramString	String
    //   73	5	2	bool	boolean
    //   21	1	3	localObject1	Object
    //   42	5	3	localIOException1	IOException
    //   54	203	3	localObject2	Object
    //   263	2	3	localIOException2	IOException
    //   276	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   17	94	4	localObject3	Object
    //   134	39	4	localIOException3	IOException
    //   4	202	5	localObject4	Object
    //   1	198	6	localObject5	Object
    //   7	275	7	localStringBuilder	StringBuilder
    //   34	51	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   22	36	42	java/io/IOException
    //   55	65	42	java/io/IOException
    //   68	74	42	java/io/IOException
    //   110	115	120	java/io/IOException
    //   201	205	120	java/io/IOException
    //   9	19	128	finally
    //   9	19	134	java/io/IOException
    //   22	36	251	finally
    //   55	65	251	finally
    //   68	74	251	finally
    //   84	90	251	finally
    //   100	105	251	finally
    //   140	146	251	finally
    //   148	157	251	finally
    //   159	168	251	finally
    //   170	178	251	finally
    //   180	191	251	finally
    //   256	260	263	java/io/IOException
    //   22	36	276	java/lang/UnsatisfiedLinkError
    //   84	90	280	java/io/IOException
    //   100	105	280	java/io/IOException
  }
  
  public void start()
  {
    this.pcmPath = this.mUiRequest.pcmForVadPath;
    if (this.pcmPath == null)
    {
      this.mProcessorReport.setError(9042, "No pcm source", null, null);
      onError();
      return;
    }
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      this.mProcessorReport.setError(9041, "No Local MD5", null, null);
      onError();
      return;
    }
    if (initRandomFile()) {
      return;
    }
    File localFile = checkPCMFile();
    if (localFile == null) {
      return;
    }
    this.mFileSize = localFile.length();
    this.voiceID = this.mMd5Str;
    this.processor = new AudioCompositeProcessor();
    this.processor.a(new SilkCodecWrapper(BaseApplication.getContext()));
    try
    {
      this.processor.a(16000, 16000, 1);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    processVADSeg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttSliceUploadProcessor
 * JD-Core Version:    0.7.0.1
 */