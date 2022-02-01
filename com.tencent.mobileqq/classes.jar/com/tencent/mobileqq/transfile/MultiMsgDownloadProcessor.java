package com.tencent.mobileqq.transfile;

import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.longconn.longmsg.LongMsg.MsgDownRsp;
import tencent.im.longconn.longmsg.LongMsg.RspBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

public class MultiMsgDownloadProcessor
  extends BaseDownloadProcessor
{
  QQAppInterface app;
  private int mChannelType;
  private byte[] mContent;
  private byte[] mMsgKey;
  private byte[] mMsgResId;
  private String mOutFilePath;
  private int mUinType;
  
  public MultiMsgDownloadProcessor() {}
  
  public MultiMsgDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.app = ((QQAppInterface)this.app);
    this.mMsgResId = this.mUiRequest.resIdStr.getBytes();
    this.mUinType = this.mUiRequest.mUinType;
  }
  
  /* Error */
  private byte[] getBodyData(String paramString)
  {
    // Byte code:
    //   0: new 59	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 66	java/io/File:exists	()Z
    //   11: ifne +36 -> 47
    //   14: new 68	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 71
    //   25: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: aload_1
    //   31: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_0
    //   36: ldc 77
    //   38: aload_3
    //   39: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aconst_null
    //   46: areturn
    //   47: new 87	java/io/RandomAccessFile
    //   50: dup
    //   51: aload_1
    //   52: ldc 89
    //   54: invokespecial 91	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: astore 5
    //   59: aload 5
    //   61: astore 4
    //   63: aload 5
    //   65: invokevirtual 95	java/io/RandomAccessFile:length	()J
    //   68: l2i
    //   69: newarray byte
    //   71: astore_3
    //   72: aload 5
    //   74: astore 4
    //   76: aload 5
    //   78: aload_3
    //   79: invokevirtual 99	java/io/RandomAccessFile:read	([B)I
    //   82: istore_2
    //   83: aload 5
    //   85: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   88: goto +225 -> 313
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   96: aload_0
    //   97: ldc 77
    //   99: aload_1
    //   100: invokevirtual 108	java/io/IOException:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: goto +207 -> 313
    //   109: astore 4
    //   111: aload_3
    //   112: astore_1
    //   113: aload 4
    //   115: astore_3
    //   116: goto +35 -> 151
    //   119: astore 6
    //   121: goto +103 -> 224
    //   124: astore_3
    //   125: aconst_null
    //   126: astore_1
    //   127: goto +24 -> 151
    //   130: astore 6
    //   132: aconst_null
    //   133: astore_3
    //   134: goto +90 -> 224
    //   137: astore_1
    //   138: aconst_null
    //   139: astore 4
    //   141: goto +302 -> 443
    //   144: astore_3
    //   145: aconst_null
    //   146: astore 5
    //   148: aload 5
    //   150: astore_1
    //   151: aload 5
    //   153: astore 4
    //   155: aload_0
    //   156: ldc 77
    //   158: ldc 110
    //   160: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 5
    //   165: astore 4
    //   167: aload_3
    //   168: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   171: aload_1
    //   172: astore 4
    //   174: aload 5
    //   176: ifnull +32 -> 208
    //   179: aload 5
    //   181: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   184: aload_1
    //   185: astore 4
    //   187: goto +21 -> 208
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   195: aload_0
    //   196: ldc 77
    //   198: aload_3
    //   199: invokevirtual 108	java/io/IOException:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_1
    //   206: astore 4
    //   208: iconst_0
    //   209: istore_2
    //   210: aload 4
    //   212: astore_3
    //   213: goto +100 -> 313
    //   216: astore 6
    //   218: aconst_null
    //   219: astore 5
    //   221: aload 5
    //   223: astore_3
    //   224: aload 5
    //   226: astore 4
    //   228: aload 6
    //   230: invokevirtual 111	java/io/FileNotFoundException:printStackTrace	()V
    //   233: aload 5
    //   235: astore 4
    //   237: new 68	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   244: astore 6
    //   246: aload 5
    //   248: astore 4
    //   250: aload 6
    //   252: ldc 71
    //   254: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 5
    //   260: astore 4
    //   262: aload 6
    //   264: aload_1
    //   265: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 5
    //   271: astore 4
    //   273: aload_0
    //   274: ldc 77
    //   276: aload 6
    //   278: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_3
    //   285: astore 4
    //   287: aload 5
    //   289: ifnull -81 -> 208
    //   292: aload 5
    //   294: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   297: aload_3
    //   298: astore 4
    //   300: goto -92 -> 208
    //   303: astore 4
    //   305: aload_3
    //   306: astore_1
    //   307: aload 4
    //   309: astore_3
    //   310: goto -119 -> 191
    //   313: aload_3
    //   314: ifnull +36 -> 350
    //   317: aload_3
    //   318: arraylength
    //   319: ifle +31 -> 350
    //   322: iload_2
    //   323: ifle +27 -> 350
    //   326: aload_3
    //   327: iconst_0
    //   328: baload
    //   329: bipush 40
    //   331: if_icmpne +19 -> 350
    //   334: aload_3
    //   335: aload_3
    //   336: arraylength
    //   337: iconst_1
    //   338: isub
    //   339: baload
    //   340: bipush 41
    //   342: if_icmpeq +6 -> 348
    //   345: goto +5 -> 350
    //   348: aload_3
    //   349: areturn
    //   350: aload_3
    //   351: ifnonnull +8 -> 359
    //   354: iconst_0
    //   355: istore_2
    //   356: goto +6 -> 362
    //   359: aload_3
    //   360: arraylength
    //   361: istore_2
    //   362: aload_3
    //   363: ifnonnull +9 -> 372
    //   366: ldc 113
    //   368: astore_1
    //   369: goto +8 -> 377
    //   372: aload_3
    //   373: invokevirtual 116	java/lang/Object:toString	()Ljava/lang/String;
    //   376: astore_1
    //   377: aload_1
    //   378: astore_3
    //   379: aload_1
    //   380: invokevirtual 119	java/lang/String:length	()I
    //   383: bipush 20
    //   385: if_icmple +11 -> 396
    //   388: aload_1
    //   389: iconst_0
    //   390: bipush 20
    //   392: invokevirtual 123	java/lang/String:substring	(II)Ljava/lang/String;
    //   395: astore_3
    //   396: new 68	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   403: astore_1
    //   404: aload_1
    //   405: ldc 125
    //   407: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_1
    //   412: iload_2
    //   413: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_1
    //   418: ldc 130
    //   420: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_1
    //   425: aload_3
    //   426: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_0
    //   431: ldc 77
    //   433: aload_1
    //   434: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aconst_null
    //   441: areturn
    //   442: astore_1
    //   443: aload 4
    //   445: ifnull +26 -> 471
    //   448: aload 4
    //   450: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   453: goto +18 -> 471
    //   456: astore_3
    //   457: aload_3
    //   458: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   461: aload_0
    //   462: ldc 77
    //   464: aload_3
    //   465: invokevirtual 108	java/io/IOException:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto +5 -> 476
    //   474: aload_1
    //   475: athrow
    //   476: goto -2 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	MultiMsgDownloadProcessor
    //   0	479	1	paramString	String
    //   82	331	2	i	int
    //   21	95	3	localObject1	Object
    //   124	1	3	localIOException1	java.io.IOException
    //   133	1	3	localObject2	Object
    //   144	24	3	localIOException2	java.io.IOException
    //   190	9	3	localIOException3	java.io.IOException
    //   212	214	3	localObject3	Object
    //   456	9	3	localIOException4	java.io.IOException
    //   61	14	4	localRandomAccessFile1	java.io.RandomAccessFile
    //   109	5	4	localIOException5	java.io.IOException
    //   139	160	4	localObject4	Object
    //   303	146	4	localIOException6	java.io.IOException
    //   57	236	5	localRandomAccessFile2	java.io.RandomAccessFile
    //   119	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   130	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   216	13	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   244	33	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   83	88	91	java/io/IOException
    //   76	83	109	java/io/IOException
    //   76	83	119	java/io/FileNotFoundException
    //   63	72	124	java/io/IOException
    //   63	72	130	java/io/FileNotFoundException
    //   47	59	137	finally
    //   47	59	144	java/io/IOException
    //   179	184	190	java/io/IOException
    //   47	59	216	java/io/FileNotFoundException
    //   292	297	303	java/io/IOException
    //   63	72	442	finally
    //   76	83	442	finally
    //   155	163	442	finally
    //   167	171	442	finally
    //   228	233	442	finally
    //   237	246	442	finally
    //   250	258	442	finally
    //   262	269	442	finally
    //   273	284	442	finally
    //   448	453	456	java/io/IOException
  }
  
  private boolean parseDownloadMsg(String paramString)
  {
    paramString = getBodyData(paramString);
    if (paramString == null) {
      return false;
    }
    return parsePBData(paramString);
  }
  
  private void recieveFile()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    if (this.mIpList.size() > 0)
    {
      localObject1 = (ServerAddr)this.mIpList.get(0);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiMsg_TAG", 2, "Multimsg download recieveFile  ipListSize = 0 ");
      }
      localObject1 = null;
    }
    int i = this.mChannelType;
    String str = "http://";
    if (i == 2)
    {
      localHttpNetReq.mIsHttps = true;
      if (localObject1 != null)
      {
        localHttpNetReq.mIsHostIP = true;
        if (((ServerAddr)localObject1).isIpv6) {
          localHttpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
        } else {
          localHttpNetReq.mHostForHttpsVerify = "ssl.htdata.qq.com";
        }
      }
      else
      {
        localHttpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
      }
      localObject3 = new ServerAddr();
      ((ServerAddr)localObject3).mIp = localHttpNetReq.mHostForHttpsVerify;
      ((ServerAddr)localObject3).port = 443;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localObject3;
      }
      this.mIpList.add(localObject3);
      localObject3 = "https://";
    }
    else
    {
      localObject2 = localObject1;
      localObject3 = str;
      if (localObject1 == null)
      {
        localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).mIp = "sslv6.htdata.qq.com";
        ((ServerAddr)localObject2).port = 8080;
        this.mIpList.add(localObject2);
        localObject3 = str;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Multimsg download recieveFile  url =");
      ((StringBuilder)localObject1).append((String)localObject3);
      QLog.i("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
    }
    if ((((ServerAddr)localObject2).isIpv6) && (!((ServerAddr)localObject2).mIp.startsWith("[")))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(((ServerAddr)localObject2).mIp);
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(((ServerAddr)localObject2).mIp);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject3 = localObject1;
    if (((ServerAddr)localObject2).port != 80)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(((ServerAddr)localObject2).port);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject3);
    ((StringBuilder)localObject1).append(this.mUrlPath);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" url:");
    ((StringBuilder)localObject2).append((String)localObject1);
    logRichMediaEvent("MultimsgDownload.recieveFile", ((StringBuilder)localObject2).toString());
    this.mOutFilePath = AbsDownloader.getFilePath((String)localObject1);
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = ((String)localObject1);
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mServerList = this.mIpList;
    localHttpNetReq.mOutPath = this.mOutFilePath;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("url:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(",downOffset:");
    ((StringBuilder)localObject2).append(localHttpNetReq.mStartDownOffset);
    logRichMediaEvent("httpDown", ((StringBuilder)localObject2).toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  private void sendReqest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq.MultiMsgDownReq localMultiMsgDownReq = new RichProto.RichProtoReq.MultiMsgDownReq();
    localMultiMsgDownReq.selfUin = this.mUiRequest.mSelfUin;
    localMultiMsgDownReq.peerUin = this.mUiRequest.mPeerUin;
    localMultiMsgDownReq.secondUin = this.mUiRequest.mSecondId;
    localMultiMsgDownReq.uinType = this.mUiRequest.mUinType;
    localMultiMsgDownReq.msgResId = this.mMsgResId;
    localMultiMsgDownReq.multiMsgType = this.mUiRequest.multiMsgType;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "multi_msg_dw";
    localRichProtoReq.reqs.add(localMultiMsgDownReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public int checkParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    return 0;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      Object localObject = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject).mReportedFlag = (j | i);
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepUrl.getReportInfo(1));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepTrans.getReportInfo(2));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepMsg.getReportInfo(3));
      localObject = ((StringBuilder)localObject).toString();
      this.mProcessorReport.mReportInfo.put("param_step", localObject);
      this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      this.mProcessorReport.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      if (paramBoolean)
      {
        reportForIpv6(true, l);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        reportForIpv6(false, l);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l, 0L, this.mProcessorReport.mReportInfo, "");
      }
      setReportFlag();
    }
  }
  
  protected String getReportTAG()
  {
    return "actMultiMsgDownload";
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp == null)
    {
      onError();
      return;
    }
    int i = 0;
    while (i < paramRichProtoResp.resps.size())
    {
      paramRichProtoReq = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.resps.get(i);
      if (QLog.isColorLevel()) {
        logRichMediaEvent("procUrl", paramRichProtoReq.toString());
      }
      this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
      if (paramRichProtoReq.result == 0)
      {
        this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.ipList);
        this.mUrlPath = paramRichProtoReq.urlParam;
        this.mMsgKey = paramRichProtoReq.msgkey;
        this.mChannelType = paramRichProtoReq.mChannelType;
        recieveFile();
        i += 1;
      }
      else
      {
        onError();
      }
    }
  }
  
  void onError()
  {
    super.onError();
    if (this.mUiRequest.mDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.b = -1;
      localDownResult.d = new PicInfoInterface.ErrInfo();
      localDownResult.d.b = "[MultiMsgDownloadProcessor] download failed";
      localDownResult.f = null;
      this.mUiRequest.mDownCallBack.a(localDownResult);
    }
    this.mContent = null;
    sendMessageToUpdate(2005);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = this.mProcessorReport;
    StepInfo localStepInfo = this.mProcessorReport.mStepTrans;
    int j = paramNetResp.mResult;
    int i = 0;
    boolean bool;
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ProcessorReport)localObject).copyStaticsInfoFromNetResp(localStepInfo, paramNetResp, bool);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" result:");
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
    this.mTotolLen = paramNetResp.mTotalFileLen;
    this.mNetReq = null;
    if (this.mTotolLen <= 0L) {
      this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
    }
    this.file.stepTrans.respHeader = ((String)paramNetResp.mRespProperties.get("param_rspHeader"));
    if ((paramNetResp.mResult == 0) && (parseDownloadMsg(this.mOutFilePath)))
    {
      paramNetResp = new File(this.mOutFilePath);
      try
      {
        localObject = FileUtils.getByte(paramNetResp);
        paramNetResp = new StringBuffer();
        paramNetResp.append("{");
        j = localObject.length;
        while (i < j)
        {
          paramNetResp.append(localObject[i]);
          paramNetResp.append(",");
          i += 1;
        }
        paramNetResp.deleteCharAt(paramNetResp.length() - 1);
        paramNetResp.append("}");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" multimsg_filedata:");
        ((StringBuilder)localObject).append(paramNetResp.toString());
        logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
      }
      catch (Exception paramNetResp)
      {
        paramNetResp.printStackTrace();
      }
      onSuccess();
      return;
    }
    if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
    {
      logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
      this.mNetworkChgRetryCount += 1;
      clearReprotInfo();
      sendReqest();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    Object localObject1;
    if (this.mUiRequest.mDownCallBack != null)
    {
      localObject1 = new DownCallBack.DownResult();
      ((DownCallBack.DownResult)localObject1).b = 0;
      ((DownCallBack.DownResult)localObject1).f = this.mContent;
      ((DownCallBack.DownResult)localObject1).g = this.mUiRequest.mMd5;
      ((DownCallBack.DownResult)localObject1).h = this.mUiRequest.mFileType;
      ((DownCallBack.DownResult)localObject1).i = this.mUiRequest.mDownMode;
      ((DownCallBack.DownResult)localObject1).k = this.mUiRequest.mRichTag;
      ((DownCallBack.DownResult)localObject1).l = this.mUiRequest.mUniseq;
      ((DownCallBack.DownResult)localObject1).m = this.mUiRequest.resIdStr;
      this.mUiRequest.mDownCallBack.a((DownCallBack.DownResult)localObject1);
    }
    else
    {
      localObject1 = new HashMap();
      Object localObject2 = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      localObject2 = this.app.getProxyManager().b().b(this.mContent, (HashMap)localObject1, (MessageRecord)localObject2, null);
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        MultiMsgManager.a().a((HashMap)localObject1, this.mUiRequest.mUniseq, this.app);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "BaseTransProcessoronSuccess.onDownload,MultiMsg ");
        }
      }
    }
    this.mContent = null;
    sendMessageToUpdate(2003);
  }
  
  protected boolean parsePBData(byte[] paramArrayOfByte)
  {
    try
    {
      localObject1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
      ((DataInputStream)localObject1).readByte();
      int j = ((DataInputStream)localObject1).readInt();
      int i = ((DataInputStream)localObject1).readInt();
      paramArrayOfByte = new byte[j];
      ((DataInputStream)localObject1).read(paramArrayOfByte);
      Object localObject2 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject2).mergeFrom(paramArrayOfByte);
      j = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();
      if ((i > 0) && (j == 0))
      {
        paramArrayOfByte = new byte[i];
        ((DataInputStream)localObject1).read(paramArrayOfByte);
        localObject1 = new Cryptor().decrypt(paramArrayOfByte, this.mMsgKey);
        localObject2 = new LongMsg.RspBody();
        ((LongMsg.RspBody)localObject2).mergeFrom((byte[])localObject1);
        localObject1 = (LongMsg.MsgDownRsp)((LongMsg.RspBody)localObject2).rpt_msg_down_rsp.get(0);
        if (((LongMsg.MsgDownRsp)localObject1).uint32_result.get() != 0)
        {
          logRichMediaEvent("parseDownloadMsg", "uint32_result != 0");
          return false;
        }
        this.mContent = ((LongMsg.MsgDownRsp)localObject1).bytes_msg_content.get().toByteArray();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("crypted data == ");
        ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(paramArrayOfByte));
        logRichMediaEvent("parseDownloadMsg", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("crypted data length == ");
        ((StringBuilder)localObject1).append(paramArrayOfByte.length);
        logRichMediaEvent("parseDownloadMsg", ((StringBuilder)localObject1).toString());
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("decrypted data == ");
        paramArrayOfByte.append(HexUtil.bytes2HexStr(this.mContent));
        logRichMediaEvent("parseDownloadMsg", paramArrayOfByte.toString());
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("decrypted data length == ");
        paramArrayOfByte.append(this.mContent.length);
        logRichMediaEvent("parseDownloadMsg", paramArrayOfByte.toString());
        return true;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("bodyLen= ");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append(" errCode= ");
      paramArrayOfByte.append(j);
      logRichMediaEvent("parseDownloadMsg", paramArrayOfByte.toString());
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" Exception:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
      logRichMediaEvent("parseDownloadMsg", ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      String str;
      if (UinTypeUtil.b(this.mUinType)) {
        str = "multimsgCd";
      } else if (this.mUinType == 1) {
        str = "multimsgGd";
      } else {
        str = "multimsgDd";
      }
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    sendMessageToUpdate(1000);
    sendMessageToUpdate(2001);
    sendReqest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */