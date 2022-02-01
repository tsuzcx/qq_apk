package com.tencent.mobileqq.transfile;

import ajpv;
import akgt;
import amwl;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import ayeo;
import ayep;
import azby;
import azcr;
import bcef;
import bcjc;
import bcms;
import bcmt;
import bftf;
import bgrn;
import bgrs;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class GroupPttUploadProcessor
  extends BaseUploadProcessor
  implements bgrs, INetEventHandler
{
  public static final boolean NEW_STORE_FLAG = true;
  public static final String TAG = "GroupPttUploadProcessor";
  QQAppInterface app;
  TransFileController mController;
  long mFileID;
  String mGroupFileKeyStr;
  private boolean mHasVirtualStarted;
  boolean mIsGroup = true;
  private String mPttFilePath;
  amwl messageObserver = new GroupPttUploadProcessor.5(this);
  private boolean netDown;
  private long netDownTime;
  private long timeStamp;
  
  public GroupPttUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.mController = paramTransFileController;
    this.app = ((QQAppInterface)this.app);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private void addInfoAndReport() {}
  
  private void checkConnErr()
  {
    String str;
    if (this.errCode == 9004)
    {
      str = (String)this.mReportInfo.get("param_reason");
      if (!"connError_unreachable".equalsIgnoreCase(str)) {
        break label45;
      }
      this.mReportInfo.put("param_reason", "N_1");
    }
    label45:
    while (!"connError_noroute".equalsIgnoreCase(str)) {
      return;
    }
    this.mReportInfo.put("param_reason", "N_2");
  }
  
  public static byte[] constructPTTExtraInfo(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    if (paramMessageForPtt != null)
    {
      ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
      ((ptt_reserve.ReserveStruct)localObject).uint32_redpack_type.set(akgt.a(paramMessageForPtt));
      ((ptt_reserve.ReserveStruct)localObject).uint32_autototext_voice.set(paramMessageForPtt.autoToText);
      if (paramMessageForPtt.hasSttTxt()) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
      }
      ByteStringMicro localByteStringMicro = akgt.a(paramMessageForPtt);
      if (localByteStringMicro != null) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_redpack_score_id.set(localByteStringMicro);
      }
    }
    localObject = ((ptt_reserve.ReserveStruct)localObject).toByteArray();
    if ((QLog.isColorLevel()) && (paramMessageForPtt != null)) {
      QLog.d("pttchangevoice", 2, "change flag is " + paramMessageForPtt.voiceChangeFlag);
    }
    return localObject;
  }
  
  private void fillPttRichTextExtraValue(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(bftf.a(paramMessageForPtt.voiceLength));
    }
  }
  
  private void fixStepTime()
  {
    if (this.mUiRequest.mIsPttPreSend)
    {
      this.mStepUrl.fixAtPttPreSend(this.mStartTime);
      this.mStepTrans.fixAtPttPreSend(this.mStartTime);
    }
  }
  
  private void logErro(boolean paramBoolean)
  {
    String str = "Q.richmedia." + RichMediaUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:" + this.mUiRequest.mUniseq + "  ");
    localStringBuilder.append("errCode:" + this.errCode + "  ");
    localStringBuilder.append("errDesc:" + this.errDesc);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  private RichProto.RichProtoReq.PttUpReq makePttUpReq()
  {
    RichProto.RichProtoReq.PttUpReq localPttUpReq = new RichProto.RichProtoReq.PttUpReq();
    localPttUpReq.fileName = this.mFileName;
    localPttUpReq.fileSize = ((int)this.mFileSize);
    localPttUpReq.md5 = this.mLocalMd5;
    localPttUpReq.voiceLength = QQRecorder.a(this.mUiRequest.mRec);
    localPttUpReq.audioPanelType = this.mUiRequest.mPttUploadPanel;
    localPttUpReq.voiceType = ((MessageForPtt)this.mUiRequest.mRec).voiceType;
    localPttUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPttUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPttUpReq.secondUin = this.mUiRequest.mSecondId;
    localPttUpReq.uinType = this.mUiRequest.mUinType;
    if (this.mUiRequest.mUinType == 1026)
    {
      localPttUpReq.uinType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    return localPttUpReq;
  }
  
  private void resetStatictisInfo()
  {
    this.file.stepSig.reset();
    this.file.stepUrl.reset();
    this.file.stepTrans.reset();
    this.file.stepNotify.reset();
    FileMsg localFileMsg = this.file;
    long l = System.nanoTime();
    localFileMsg.startTime = l;
    this.mStartTime = l;
    this.file.endTime = 0L;
  }
  
  public int cancel()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.cancel();
  }
  
  public int checkParam()
  {
    super.checkParam();
    if (!this.mUiRequest.mPttCompressFinish) {
      return 0;
    }
    return doCheckParam();
  }
  
  /* Error */
  protected im_msg_body.RichText constructPTTRichText()
  {
    // Byte code:
    //   0: new 211	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 427	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 430	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 124	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_3
    //   17: getfield 434	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   24: getfield 337	com/tencent/mobileqq/transfile/TransferRequest:mSelfUin	Ljava/lang/String;
    //   27: invokestatic 440	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 444	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_3
    //   34: getfield 447	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 449	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileID	J
    //   41: l2i
    //   42: invokevirtual 124	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 451	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mGroupFileKeyStr	Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_3
    //   55: getfield 454	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 451	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mGroupFileKeyStr	Ljava/lang/String;
    //   62: ldc_w 456
    //   65: invokevirtual 459	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 160	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 165	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 53	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: aload_0
    //   79: getfield 53	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   82: invokevirtual 462	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   85: invokestatic 467	bblk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   88: istore_1
    //   89: new 469	tencent/im/msg/im_msg_body$Elem
    //   92: dup
    //   93: invokespecial 470	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   96: astore 4
    //   98: new 472	tencent/im/msg/im_msg_body$ElemFlags2
    //   101: dup
    //   102: invokespecial 473	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: getfield 476	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: iload_1
    //   111: invokevirtual 124	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   114: aload 4
    //   116: getfield 480	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   119: aload_2
    //   120: invokevirtual 483	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   123: aload_3
    //   124: getfield 487	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   127: iconst_1
    //   128: invokevirtual 491	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   131: aload_3
    //   132: getfield 494	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   135: aload_0
    //   136: getfield 307	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileSize	J
    //   139: l2i
    //   140: invokevirtual 124	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   143: aload_3
    //   144: getfield 497	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: aload_0
    //   148: getfield 314	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mLocalMd5	[B
    //   151: invokestatic 160	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   154: invokevirtual 165	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   157: aload_3
    //   158: getfield 500	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   161: aload_0
    //   162: getfield 301	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileName	Ljava/lang/String;
    //   165: invokestatic 504	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 165	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   171: aload_0
    //   172: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   175: getfield 321	com/tencent/mobileqq/transfile/TransferRequest:mRec	Lcom/tencent/mobileqq/data/MessageRecord;
    //   178: checkcast 115	com/tencent/mobileqq/data/MessageForPtt
    //   181: invokestatic 506	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:constructPTTExtraInfo	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +14 -> 200
    //   189: aload_3
    //   190: getfield 509	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   193: aload_2
    //   194: invokestatic 160	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   197: invokevirtual 165	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   200: new 205	tencent/im/msg/im_msg_body$RichText
    //   203: dup
    //   204: invokespecial 510	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   207: astore_2
    //   208: aload_2
    //   209: getfield 209	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   212: aload_3
    //   213: invokevirtual 511	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   216: aload_2
    //   217: getfield 515	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   220: aload 4
    //   222: invokevirtual 520	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   225: aload_2
    //   226: areturn
    //   227: astore_3
    //   228: aconst_null
    //   229: astore_2
    //   230: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -8 -> 225
    //   236: ldc 15
    //   238: iconst_2
    //   239: ldc_w 522
    //   242: aload_3
    //   243: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   246: aconst_null
    //   247: areturn
    //   248: astore_2
    //   249: goto -175 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	GroupPttUploadProcessor
    //   88	23	1	i	int
    //   49	181	2	localObject	Object
    //   248	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   7	206	3	localPtt	im_msg_body.Ptt
    //   227	16	3	localException	Exception
    //   96	125	4	localElem	tencent.im.msg.im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	227	java/lang/Exception
    //   54	74	227	java/lang/Exception
    //   74	185	227	java/lang/Exception
    //   189	200	227	java/lang/Exception
    //   200	225	227	java/lang/Exception
    //   54	74	248	java/io/UnsupportedEncodingException
  }
  
  protected int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    switch (this.mUiRequest.mUinType)
    {
    }
    for (this.mIsGroup = false; this.mUiRequest.mRec == null; this.mIsGroup = true)
    {
      setError(9302, getExpStackString(new Exception("message null")));
      onError();
      return -1;
    }
    String str = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty(str))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      setError(9042, getExpStackString(new Exception("sendFile not exist " + str)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      setError(9070, getExpStackString(new Exception("sendFile not readable " + this.file.filePath)));
      onError();
      return -1;
    }
    this.mPttFilePath = str;
    long l = localFile.length();
    this.file.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      setError(9071, getExpStackString(new Exception("file size 0 " + str)));
      onError();
      return -1;
    }
    this.mExtName = "amr";
    return 0;
  }
  
  /* Error */
  public void doOnSendSuc(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 597	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 5
    //   5: new 599	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   8: dup
    //   9: invokespecial 600	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 604	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16: checkcast 599	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   19: getfield 607	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_tryup_ptt_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   22: invokevirtual 610	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +12 -> 39
    //   30: aload_1
    //   31: invokeinterface 615 1 0
    //   36: ifne +363 -> 399
    //   39: new 424	java/lang/Exception
    //   42: dup
    //   43: ldc_w 617
    //   46: invokespecial 538	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 620	java/lang/Exception:printStackTrace	()V
    //   55: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +13 -> 71
    //   61: ldc 15
    //   63: iconst_2
    //   64: ldc_w 622
    //   67: aload_1
    //   68: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_2
    //   72: ldc_w 624
    //   75: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: checkcast 87	java/lang/String
    //   81: invokestatic 628	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   84: invokevirtual 631	java/lang/Long:longValue	()J
    //   87: lstore 7
    //   89: aload_2
    //   90: ldc_w 633
    //   93: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 87	java/lang/String
    //   99: invokestatic 628	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   102: invokevirtual 631	java/lang/Long:longValue	()J
    //   105: lstore 9
    //   107: aload_2
    //   108: ldc_w 635
    //   111: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 87	java/lang/String
    //   117: invokestatic 628	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   120: invokevirtual 631	java/lang/Long:longValue	()J
    //   123: lstore 11
    //   125: aload_2
    //   126: ldc_w 637
    //   129: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 87	java/lang/String
    //   135: invokestatic 628	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   138: invokevirtual 631	java/lang/Long:longValue	()J
    //   141: lstore 13
    //   143: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +67 -> 213
    //   149: ldc 15
    //   151: iconst_2
    //   152: new 183	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 639
    //   162: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: lload 5
    //   167: lload_3
    //   168: lsub
    //   169: invokevirtual 284	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: ldc_w 641
    //   175: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: getfield 367	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   182: getfield 583	com/tencent/mobileqq/transfile/FileMsg:fileSize	J
    //   185: invokevirtual 284	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: ldc_w 643
    //   191: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: ldc_w 645
    //   198: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   201: checkcast 87	java/lang/String
    //   204: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_0
    //   214: aload_2
    //   215: invokevirtual 649	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:addBDHReportInfo	(Ljava/util/HashMap;)V
    //   218: aload_0
    //   219: getfield 254	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mStepTrans	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   222: invokevirtual 652	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:logFinishTime	()V
    //   225: aload_0
    //   226: getfield 254	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mStepTrans	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   229: iconst_1
    //   230: putfield 655	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:result	I
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 307	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileSize	J
    //   238: putfield 658	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mTransferedSize	J
    //   241: aload_0
    //   242: monitorenter
    //   243: aload_0
    //   244: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   247: getfield 238	com/tencent/mobileqq/transfile/TransferRequest:mIsPttPreSend	Z
    //   250: ifeq +13 -> 263
    //   253: aload_0
    //   254: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   257: getfield 661	com/tencent/mobileqq/transfile/TransferRequest:mCanSendMsg	Z
    //   260: ifeq +208 -> 468
    //   263: aload_0
    //   264: invokevirtual 664	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:sendMsg	()V
    //   267: aload_0
    //   268: getfield 367	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   271: invokevirtual 667	com/tencent/mobileqq/transfile/FileMsg:closeInputStream	()V
    //   274: aload_0
    //   275: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   278: getfield 238	com/tencent/mobileqq/transfile/TransferRequest:mIsPttPreSend	Z
    //   281: ifeq +33 -> 314
    //   284: invokestatic 670	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   287: ifeq +13 -> 300
    //   290: ldc_w 672
    //   293: iconst_4
    //   294: ldc_w 674
    //   297: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: getfield 53	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   304: invokestatic 679	azcr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lazcr;
    //   307: aload_0
    //   308: invokevirtual 682	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:getKey	()Ljava/lang/String;
    //   311: invokevirtual 684	azcr:a	(Ljava/lang/String;)V
    //   314: aload_0
    //   315: monitorexit
    //   316: new 686	com/tencent/mobileqq/transfile/GroupPttUploadProcessor$1
    //   319: dup
    //   320: aload_0
    //   321: lload 7
    //   323: lload 9
    //   325: lload 11
    //   327: lload 13
    //   329: invokespecial 689	com/tencent/mobileqq/transfile/GroupPttUploadProcessor$1:<init>	(Lcom/tencent/mobileqq/transfile/GroupPttUploadProcessor;JJJJ)V
    //   332: iconst_5
    //   333: aconst_null
    //   334: iconst_1
    //   335: invokestatic 695	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   338: aload_0
    //   339: getfield 367	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   342: invokevirtual 667	com/tencent/mobileqq/transfile/FileMsg:closeInputStream	()V
    //   345: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +12 -> 360
    //   351: ldc 15
    //   353: iconst_2
    //   354: ldc_w 697
    //   357: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload_0
    //   361: ldc_w 699
    //   364: iconst_1
    //   365: iconst_0
    //   366: aload_2
    //   367: ldc_w 701
    //   370: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   373: checkcast 87	java/lang/String
    //   376: aload_2
    //   377: ldc_w 703
    //   380: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: checkcast 87	java/lang/String
    //   386: aload_0
    //   387: getfield 706	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mMd5Str	Ljava/lang/String;
    //   390: aload_0
    //   391: getfield 709	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUuid	Ljava/lang/String;
    //   394: aconst_null
    //   395: invokevirtual 713	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:reportForServerMonitor	(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   398: return
    //   399: aload_1
    //   400: iconst_0
    //   401: invokeinterface 716 2 0
    //   406: checkcast 718	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp
    //   409: astore_1
    //   410: aload_1
    //   411: getfield 721	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_fileid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   414: invokevirtual 724	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   417: ifeq +14 -> 431
    //   420: aload_0
    //   421: aload_1
    //   422: getfield 721	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_fileid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   425: invokevirtual 726	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   428: putfield 449	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileID	J
    //   431: aload_1
    //   432: getfield 729	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   435: invokevirtual 730	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   438: ifeq -367 -> 71
    //   441: aload_0
    //   442: new 87	java/lang/String
    //   445: dup
    //   446: aload_1
    //   447: getfield 729	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   450: invokevirtual 733	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   453: invokevirtual 734	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   456: ldc_w 456
    //   459: invokespecial 737	java/lang/String:<init>	([BLjava/lang/String;)V
    //   462: putfield 451	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mGroupFileKeyStr	Ljava/lang/String;
    //   465: goto -394 -> 71
    //   468: aload_0
    //   469: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   472: iconst_1
    //   473: putfield 661	com/tencent/mobileqq/transfile/TransferRequest:mCanSendMsg	Z
    //   476: invokestatic 670	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   479: ifeq -165 -> 314
    //   482: ldc_w 672
    //   485: iconst_4
    //   486: ldc_w 739
    //   489: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: goto -178 -> 314
    //   495: astore_1
    //   496: aload_0
    //   497: monitorexit
    //   498: aload_1
    //   499: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	GroupPttUploadProcessor
    //   0	500	1	paramArrayOfByte	byte[]
    //   0	500	2	paramHashMap	HashMap<String, String>
    //   0	500	3	paramLong	long
    //   3	163	5	l1	long
    //   87	235	7	l2	long
    //   105	219	9	l3	long
    //   123	203	11	l4	long
    //   141	187	13	l5	long
    // Exception table:
    //   from	to	target	type
    //   5	26	50	java/lang/Exception
    //   30	39	50	java/lang/Exception
    //   39	50	50	java/lang/Exception
    //   399	431	50	java/lang/Exception
    //   431	465	50	java/lang/Exception
    //   243	263	495	finally
    //   263	300	495	finally
    //   300	314	495	finally
    //   314	316	495	finally
    //   468	492	495	finally
    //   496	498	495	finally
  }
  
  protected void doRealReport(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      collectChnlCostReport();
      if (this.mUiRequest.mIsPresend)
      {
        long l = 0L;
        if (this.mEnterAioTime != 0L) {
          l = (paramLong2 - this.mEnterAioTime) / 1000000L;
        }
        if (this.mUiRequest.myPresendInvalid) {
          l = paramLong1;
        }
        double d = l / paramLong1;
        ajpv.a(l, this.mFileSize, this.mIsPicSecondTransfered, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.mReportInfo.put("param_AIOPercent", d + "");
        }
        this.mReportInfo.put("param_AIODuration", l + "");
        if (QLog.isColorLevel()) {
          QLog.d("GroupPttUploadProcessor", 2, "doReport ,mStartTime = " + this.mStartTime + ",mEnterAioTime = " + this.mEnterAioTime + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.mUiRequest.myPresendInvalid + ",Percent = " + d);
        }
      }
      reportForIpv6(true, paramLong1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, paramLong1, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.remove("param_url");
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
      reportForIpv6(false, paramLong1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, paramLong1, this.mFileSize, this.mReportInfo, "");
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      logErro(paramBoolean);
      checkConnErr();
      if (this.shouldMsgReportSucc == 1)
      {
        this.mStepMsg.result = 1;
        paramBoolean = true;
      }
    }
    for (;;)
    {
      fixStepTime();
      Object localObject = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (this.mUiRequest.mBusiType == 1030)
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      int j = this.mReportedFlag;
      MessageForPtt localMessageForPtt;
      label261:
      long l1;
      label269:
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.mReportedFlag = (i | j);
        if (!TextUtils.isEmpty(this.mUiRequest.mLocalPath))
        {
          localMessageForPtt = (MessageForPtt)this.mUiRequest.mRec;
          String str = this.mUiRequest.mLocalPath;
          if (localMessageForPtt != null) {
            break label795;
          }
          i = 0;
          if (localMessageForPtt != null) {
            break label804;
          }
          l1 = 0L;
          PttInfoCollector.reportPttSendCost(str, true, paramBoolean, i, l1);
        }
        this.mEndTime = System.currentTimeMillis();
        l1 = System.nanoTime();
        l2 = (l1 - this.mStartTime) / 1000000L;
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.mStepTrans.finishTime - this.mStepTrans.startTime) / 1000000L);
        this.mReportInfo.put("param_step", localObject);
        this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
        this.mReportInfo.put("param_fileid", String.valueOf(this.mFileID));
        this.mReportInfo.put("param_picmd5", this.mFileName);
        this.mReportInfo.put("param_isPresend", this.mUiRequest.mIsPresend + "");
        this.mReportInfo.put("param_isSecondTrans", this.mIsPicSecondTransfered + "");
        this.mReportInfo.put("param_PhoneType", ajpv.a() + "");
        this.mReportInfo.put("param_NetType", NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
        this.mReportInfo.put("param_IsRawPic", this.mIsRawPic + "");
        this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
        this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
        this.mReportInfo.put("param_picType", String.valueOf(this.mPicType));
        this.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
        localObject = this.mReportInfo;
        if (!this.mUiRequest.isQzonePic) {
          break label814;
        }
      }
      label795:
      label804:
      label814:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject).put("param_source_type", String.valueOf(i));
        if (this.netDown)
        {
          this.mReportInfo.put("param_pttNetDown", String.valueOf(this.netDownTime / 1000000L));
          if (QLog.isColorLevel()) {
            QLog.d("weak_net", 2, String.valueOf(this.netDownTime / 1000000L));
          }
        }
        this.mReportInfo.put("param_pttOpt", String.valueOf(azby.a(this.app)));
        checkFailCodeReport(paramBoolean);
        doRealReport(paramBoolean, l2, l1);
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        i = 1;
        break;
        i = localMessageForPtt.voiceChangeFlag;
        break label261;
        l1 = localMessageForPtt.fileSize;
        break label269;
      }
    }
  }
  
  protected void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
    sendMessageToUpdate(1000);
    this.file.closeInputStream();
    sendMessageToUpdate(1001);
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return;
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
        if (this.mRaf == null)
        {
          setError(9303, "read file error");
          onError();
          return;
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
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)this.mUiRequest.mRec;
    String str = this.mUiRequest.mLocalPath;
    int i;
    if (localMessageForPtt == null)
    {
      i = 0;
      if (localMessageForPtt != null) {
        break label184;
      }
    }
    label184:
    for (long l = 0L;; l = localMessageForPtt.fileSize)
    {
      PttInfoCollector.reportPttSendCost(str, false, false, i, l);
      this.app.getHwEngine().preConnect();
      sendFileByBDH();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  public long getFileStatus()
  {
    if (this.mUiRequest.mPttCompressFinish) {
      return super.getFileStatus();
    }
    return 7000L;
  }
  
  public im_msg_body.RichText getNewestPTTRichText(MessageForPtt paramMessageForPtt)
  {
    im_msg_body.RichText localRichText = constructPTTRichText();
    fillPttRichTextExtraValue(localRichText, paramMessageForPtt);
    return localRichText;
  }
  
  protected String getReportTAG()
  {
    if (this.mIsGroup) {
      return "actGrpPttUp";
    }
    return "actDisscusPttUp";
  }
  
  void inter_retry()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.mUkey != null) && (this.mFileID != 0L))
    {
      if (this.mTransferedSize >= this.mFileSize)
      {
        sendMsg();
        return;
      }
      if ((this.mChannelStatus == 1) && (this.mTrans != null))
      {
        log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.app.getHwEngine().resumeTransactionTask(this.mTrans);
        return;
      }
      start();
      return;
    }
    start();
  }
  
  /* Error */
  public void onCompressFinished(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: iconst_1
    //   7: putfield 417	com/tencent/mobileqq/transfile/TransferRequest:mPttCompressFinish	Z
    //   10: aload_0
    //   11: getfield 233	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   14: getfield 321	com/tencent/mobileqq/transfile/TransferRequest:mRec	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 115	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 223	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 217	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 1047	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mHasVirtualStarted	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 420	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:doCheckParam	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 1049	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:doStart	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 420	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:doCheckParam	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 1049	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:doStart	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	GroupPttUploadProcessor
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    if (this.mUiRequest.mUpCallBack != null)
    {
      ayep localayep = new ayep();
      localayep.jdField_a_of_type_Int = -1;
      localayep.jdField_b_of_type_Int = this.errCode;
      localayep.jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.onSend(localayep);
    }
    if (this.mUiRequest.mIsPttPreSend) {
      azcr.a(this.app).a(getKey());
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.timeStamp > 0L) {
        this.netDownTime += System.nanoTime() - this.timeStamp;
      }
    }
    for (this.timeStamp = 0L;; this.timeStamp = System.nanoTime())
    {
      this.netDown = true;
      return;
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      ayep localayep = new ayep();
      localayep.jdField_a_of_type_Long = this.mFileSize;
      localayep.d = this.mMd5Str;
      localayep.c = this.mFileName;
      localayep.jdField_b_of_type_JavaLangString = this.mUiRequest.mLocalPath;
      localayep.jdField_b_of_type_Long = this.mFileID;
      this.mUiRequest.mUpCallBack.onSend(localayep);
    }
    for (;;)
    {
      sendMessageToUpdate(1003);
      return;
      updateMessageDataBaseContent(true);
    }
  }
  
  public void pause()
  {
    super.pause();
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("pause", "");
      }
      sendMessageToUpdate(1006);
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
    }
    switch (this.mChannelStatus)
    {
    default: 
      return;
    case 0: 
      log("<BDH_LOG> pause() BUT current status is INIT");
      return;
    }
    if (this.mTrans != null)
    {
      log("<BDH_LOG> pause() pause BDH channel, transation id=" + this.mTrans.getTransationId());
      this.app.getHwEngine().stopTransactionTask(this.mTrans);
      return;
    }
    log("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  public int resume()
  {
    if ((this.mUiRequest.mIsPttPreSend) && (this.mUiRequest.mCanSendMsg))
    {
      sendProgressMessage();
      sendMsg();
    }
    while (!this.mIsPause) {
      return 0;
    }
    this.mIsPause = false;
    this.mIsCancel = false;
    sendMessageToUpdate(1002);
    if (this.mChannelStatus != 1) {
      this.mUkey = null;
    }
    this.mServerRollbackCount = 0;
    this.mTryCount = 0;
    this.mReqUrlCount = 0;
    this.errCode = 0;
    this.errDesc = "";
    resetStatictisInfo();
    this.mController.mHandler.post(new GroupPttUploadProcessor.4(this));
    return 0;
  }
  
  void sendDiscussMsg()
  {
    Object localObject2 = constructPTTRichText();
    if (localObject2 == null)
    {
      setError(9368, "constructpberror", null, this.mStepMsg);
      onError();
    }
    label169:
    label196:
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mRec != null)
      {
        localObject1 = this.mUiRequest.mRec;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label196;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label169;
        }
      }
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        setError(9368, "msgtypeError", (String)localObject1, this.mStepMsg);
        onError();
        return;
        localObject1 = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.mUiRequest.mRec;
      fillPttRichTextExtraValue((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (this.needSendMsg)
      {
        if (akgt.a((MessageRecord)localObject1))
        {
          akgt.a().a((MessageRecord)localObject1, this.messageObserver, this.mFileID, this.mLocalMd5, null, this);
          return;
        }
        this.app.getMessageFacade().sendMessage((MessageRecord)localObject1, this.messageObserver);
        return;
      }
    } while (this.mUiRequest.mUpCallBack == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.mUiRequest.mLocalPath);
    localMessageForPtt.fileSize = this.mFileSize;
    localMessageForPtt.urlAtServer = this.mFileName;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.mFileID;
    localMessageForPtt.groupFileKeyStr = this.mGroupFileKeyStr;
    localMessageForPtt.md5 = this.mMd5Str;
    localMessageForPtt.serial();
    this.mUiRequest.mUpCallBack.attachRichText2Msg((im_msg_body.RichText)localObject2);
  }
  
  public void sendFileByBDH()
  {
    int i = 3;
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.mStepTrans.logStartTime();
    if (this.mTrans != null) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject1 = new cmd0x388.ReqBody();
    ((cmd0x388.ReqBody)localObject1).setHasFlag(true);
    ((cmd0x388.ReqBody)localObject1).uint32_subcmd.set(3);
    int j = BaseHandler.getHandlerNetType();
    ((cmd0x388.ReqBody)localObject1).uint32_net_type.set(j);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + j + "]");
    }
    Object localObject2 = makePttUpReq();
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(((RichProto.RichProtoReq.PttUpReq)localObject2).selfUin).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(((RichProto.RichProtoReq.PttUpReq)localObject2).peerUin).longValue());
    localTryUpPttReq.uint64_file_id.set(0L);
    localTryUpPttReq.uint64_file_size.set(((RichProto.RichProtoReq.PttUpReq)localObject2).fileSize);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(((RichProto.RichProtoReq.PttUpReq)localObject2).md5));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((RichProto.RichProtoReq.PttUpReq)localObject2).fileName));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (((RichProto.RichProtoReq.PttUpReq)localObject2).uinType == 1) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      localTryUpPttReq.uint32_voice_length.set(((RichProto.RichProtoReq.PttUpReq)localObject2).voiceLength);
      localTryUpPttReq.uint32_codec.set(((RichProto.RichProtoReq.PttUpReq)localObject2).voiceType);
      localTryUpPttReq.uint32_voice_type.set(((RichProto.RichProtoReq.PttUpReq)localObject2).audioPanelType);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + ((RichProto.RichProtoReq.PttUpReq)localObject2).audioPanelType + "] type[" + ((RichProto.RichProtoReq.PttUpReq)localObject2).voiceType + "] length[" + ((RichProto.RichProtoReq.PttUpReq)localObject2).voiceLength + "] size[" + ((RichProto.RichProtoReq.PttUpReq)localObject2).fileSize + "]");
      }
      ((cmd0x388.ReqBody)localObject1).rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      localObject1 = ((cmd0x388.ReqBody)localObject1).toByteArray();
      localObject2 = new GroupPttUploadProcessor.2(this, l);
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 29, this.mPttFilePath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      localObject1 = new GroupPttUploadProcessor.3(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject1);
      i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 29);
      }
      if (i == 0) {
        break;
      }
      setError(i, "sendFileByBDH SubmitError.", "", this.mStepTrans);
      onError();
      return;
      i = 4;
    }
  }
  
  void sendGroupMsg()
  {
    Object localObject2 = constructPTTRichText();
    if (localObject2 == null)
    {
      setError(9368, "constructpberror", null, this.mStepMsg);
      onError();
    }
    label165:
    label192:
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mRec != null)
      {
        localObject1 = this.mUiRequest.mRec;
        if ((localObject1 instanceof MessageForPtt)) {
          break label192;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label165;
        }
      }
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        setError(9368, "msgtypeError", (String)localObject1, this.mStepMsg);
        onError();
        return;
        localObject1 = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.mUiRequest.mRec;
      fillPttRichTextExtraValue((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if ((this.mUiRequest.mUinType == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
      }
      if (this.needSendMsg)
      {
        if (akgt.a((MessageRecord)localObject1))
        {
          akgt.a().a((MessageRecord)localObject1, this.messageObserver, this.mFileID, this.mLocalMd5, null, this);
          return;
        }
        this.app.getMessageFacade().sendMessage((MessageRecord)localObject1, this.messageObserver);
        return;
      }
    } while (this.mUiRequest.mUpCallBack == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.mUiRequest.mLocalPath);
    localMessageForPtt.fileSize = this.mFileSize;
    localMessageForPtt.urlAtServer = this.mFileName;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.mFileID;
    localMessageForPtt.groupFileKeyStr = this.mGroupFileKeyStr;
    localMessageForPtt.md5 = this.mMd5Str;
    localMessageForPtt.serial();
    this.mUiRequest.mUpCallBack.attachRichText2Msg((im_msg_body.RichText)localObject2);
  }
  
  void sendMsg()
  {
    if (!canDoNextStep()) {
      return;
    }
    this.mStepMsg.logStartTime();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if (this.mIsGroup)
    {
      sendGroupMsg();
      return;
    }
    sendDiscussMsg();
  }
  
  public void start()
  {
    super.start();
    if (!this.mUiRequest.mPttCompressFinish)
    {
      if (bgrn.a(this.mUiRequest.mLocalPath, this)) {
        try
        {
          if (this.mHasVirtualStarted)
          {
            sendMessageToUpdate(1001);
            this.mHasVirtualStarted = true;
          }
          return;
        }
        finally {}
      }
      if (doCheckParam() == 0) {
        doStart(false);
      }
    }
    else
    {
      doStart(false);
    }
  }
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mRec != null)
    {
      localMessageRecord = this.mUiRequest.mRec;
      if (localMessageRecord != null) {
        break label78;
      }
      logRichMediaEvent("updateDb", "msg null");
    }
    label78:
    Object localObject;
    label316:
    bcjc localbcjc;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localMessageRecord = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
            logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
            break;
            if (localMessageRecord.isMultiMsg)
            {
              logRichMediaEvent("updateDb", "is multiMsg");
              return;
            }
            if ((this.mUiRequest.mFileType != 2) || (!(localMessageRecord instanceof MessageForPtt))) {
              break label316;
            }
            localObject = (MessageForPtt)localMessageRecord;
            if (!this.mUiRequest.mIsPttPreSend) {
              ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.mUiRequest.mLocalPath);
            }
            ((MessageForPtt)localObject).fileSize = this.mFileSize;
            ((MessageForPtt)localObject).urlAtServer = this.mFileName;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.mFileID;
            ((MessageForPtt)localObject).groupFileKeyStr = this.mGroupFileKeyStr;
            ((MessageForPtt)localObject).md5 = this.mMd5Str;
            ((MessageForPtt)localObject).serial();
            this.app.getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
          } while ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((bcmt)this.app.getManager(17)).b((MessageForPtt)localMessageRecord)));
          bcef.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
          ((bcms)this.app.getManager(17)).b((MessageForPtt)localMessageRecord, 2);
          return;
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.mUiRequest.mLocalPath;
            ((MessageForPic)localObject).size = this.mFileSize;
            ((MessageForPic)localObject).uuid = this.mFileName;
            ((MessageForPic)localObject).groupFileID = this.mFileID;
            ((MessageForPic)localObject).md5 = this.mMd5Str;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.app.getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localbcjc = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localbcjc == null);
    localbcjc.ae = this.mMd5Str;
    localbcjc.ad = this.mFileName;
    localbcjc.d = this.mFileSize;
    localbcjc.c = this.mFileID;
    localbcjc.e = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.app.getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */