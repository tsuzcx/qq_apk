package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.BDHCommonUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamExtendInfo;

public class BDHCommonUploadProcessor
  extends BaseUploadProcessor
{
  public static final int COMMAND_ID_AE_CAMERA_UPLOAD_ARK_VIDEO = 82;
  public static final int COMMAND_ID_AREA_GRAB = 35;
  public static final int COMMAND_ID_AV_GAME_RESULT = 78;
  public static final int COMMAND_ID_BUSINESS_CARD = 18;
  public static final int COMMAND_ID_C2B_PA_PIC = 10;
  public static final int COMMAND_ID_CAMERA_EMO_ROAMING = 70;
  public static final int COMMAND_ID_CMSHOW = 36;
  public static final int COMMAND_ID_CMSHOW_3D_FACE = 79;
  public static final int COMMAND_ID_DANCE_PKSHARE = 58;
  public static final int COMMAND_ID_FACE_SNAPCHAT_PIC = 7;
  public static final int COMMAND_ID_FAV_ROAMING = 9;
  public static final int COMMAND_ID_IDENTIFICATION = 61;
  public static final int COMMAND_ID_MINI_APP_ARK_SHARE = 62;
  public static final int COMMAND_ID_MINI_APP_USER_LOG = 65;
  public static final int COMMAND_ID_MULTIMSG = 27;
  public static final int COMMAND_ID_MULTIMSG_NEW = 77;
  public static final int COMMAND_ID_PIC_OCR = 76;
  public static final int COMMAND_ID_QAV_ENC_FILE = 64;
  public static final int COMMAND_ID_QQCOMIC = 20;
  public static final int COMMAND_ID_READINJOY_VIDEO = 54;
  public static final int COMMAND_ID_TRIBE_VIDEO_UPLOAD = 57;
  public static final int COMMAND_ID_TROOP_CHECKIN_PIC = 75;
  public static final int COMMAND_ID_TROOP_CHECKIN_VIDEO = 74;
  public static final int COMMAND_ID_UPLOAD_PIC_STUDY_ROOM = 80;
  public static final int COMMAND_ID_UPLOAD_WEBPIC = 51;
  public static final int COMMAND_ID_VOICE_SEARCH = 40;
  public static final int RET_ERR_COMIC_PIC_LIMITED = 120509;
  public static final int RET_ERR_FAV_EMO_NORMAL_LIMITED = 400010;
  public static final int RET_ERR_FAV_EMO_SVIP_LIMITED = 400011;
  public static final String TAG = "BDHCommonUploadProcessor";
  private int mCommandId;
  private byte[] mExtention;
  private long mFileID;
  private cmd0x388.ExpRoamExtendInfo mResid = new cmd0x388.ExpRoamExtendInfo();
  private String mRichTag;
  private String mSessionKey;
  private Bdh_extinfo.UploadPicExtInfo mUploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
  Transaction trans = null;
  
  public BDHCommonUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mCommandId = paramTransferRequest.mCommandId;
    this.file.commandId = paramTransferRequest.mCommandId;
    this.mRichTag = paramTransferRequest.mRichTag;
    this.mExtention = paramTransferRequest.mExtentionInfo;
  }
  
  private final void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = buildRichProtoReq();
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
    if (localRichProtoReq != null)
    {
      this.mRichProtoReq = localRichProtoReq;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BDHCommonUploadProcessor commonId: ");
      localStringBuilder.append(this.mCommandId);
      QLog.i("BDHCommonUploadProcessor", 1, localStringBuilder.toString());
      RichProtoProc.procRichProtoReq(localRichProtoReq);
    }
  }
  
  protected RichProto.RichProtoReq buildRichProtoReq()
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    localPicUpReq.isRaw = this.mIsRawPic;
    localPicUpReq.selfUin = this.app.getCurrentAccountUin();
    localPicUpReq.isSnapChat = this.mUiRequest.mIsSecSnapChatPic;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "bdh_common_up";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    localRichProtoReq.commandId = this.mCommandId;
    localRichProtoReq.extention = this.mExtention;
    return localRichProtoReq;
  }
  
  public final int cancel()
  {
    super.cancel();
    if (this.trans != null) {
      this.app.getHwEngine().cancelTransactionTask(this.trans);
    }
    return 0;
  }
  
  public final int checkParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    if (!TextUtils.isEmpty(this.mUiRequest.mLocalPath))
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      BaseImageUtil.a(this.mUiRequest.mLocalPath, (BitmapFactory.Options)localObject1);
      this.mHeight = ((BitmapFactory.Options)localObject1).outHeight;
      this.mWidth = ((BitmapFactory.Options)localObject1).outWidth;
    }
    Object localObject1 = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
      onError();
      return -1;
    }
    Object localObject2 = new File((String)localObject1);
    StringBuilder localStringBuilder;
    if (!((File)localObject2).exists())
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendFile not exist ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9042, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
      onError();
      return -1;
    }
    if (!((File)localObject2).canRead())
    {
      localObject1 = this.mProcessorReport;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendFile not readable ");
      ((StringBuilder)localObject2).append(this.file.filePath);
      ((ProcessorReport)localObject1).setError(9070, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
      onError();
      return -1;
    }
    long l = ((File)localObject2).length();
    this.file.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file size 0 ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9071, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
      onError();
      return -1;
    }
    localObject1 = FileUtils.estimateFileType((String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.mExtName = ((String)localObject1);
    }
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
      this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
    }
    return 0;
  }
  
  byte[] constructReqBody()
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
    localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(this.app.getCurrentUin()));
    try
    {
      String str2 = this.app.getCurrentUin();
      String str1 = str2;
      if (str2.startsWith("+")) {
        str1 = str2.substring(1);
      }
      long l = Long.valueOf(str1).longValue();
      localApplyUploadReq.uint64_recver_uin.set(l);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localApplyUploadReq.uint32_file_type.set(2);
    localApplyUploadReq.str_file_name.set(this.mFileName);
    localApplyUploadReq.uint64_file_size.set(this.mFileSize);
    localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
    localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
    cmd0x346.ExtensionReq localExtensionReq = new cmd0x346.ExtensionReq();
    localExtensionReq.uint64_id.set(3L);
    localExtensionReq.uint32_ptt_format.set(0);
    localExtensionReq.uint32_ptt_time.set(this.mUiRequest.mRequestLength);
    int i = BaseHandler.getHandlerNetType();
    localExtensionReq.uint32_net_type.set(i);
    localExtensionReq.uint32_voice_type.set(2);
    localExtensionReq.uint64_type.set(0);
    localReqBody.msg_extension_req.set(localExtensionReq);
    return localReqBody.toByteArray();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if (!this.mProcessorReport.mIsOldDbRec)
    {
      int i = 2;
      if ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0))
      {
        if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
          return;
        }
        Object localObject = this.mProcessorReport;
        int j = this.mProcessorReport.mReportedFlag;
        if (!paramBoolean) {
          i = 1;
        }
        ((ProcessorReport)localObject).mReportedFlag = (i | j);
        this.mProcessorReport.mEndTime = System.currentTimeMillis();
        long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
        HashMap localHashMap = this.mProcessorReport.mReportInfo;
        String str = this.mSessionKey;
        localObject = str;
        if (str == null) {
          localObject = "null";
        }
        localHashMap.put("param_sessionKey", localObject);
        if (paramBoolean)
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.mRichTag, true, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        else
        {
          if (this.mProcessorReport.errCode != -9527) {
            this.mProcessorReport.mReportInfo.remove("param_rspHeader");
          }
          this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
          this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
          this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.mRichTag, false, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        setReportFlag();
      }
    }
  }
  
  protected final void doStatistic(HashMap<String, String> paramHashMap)
  {
    try
    {
      Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    }
    catch (Exception localException1)
    {
      label20:
      label55:
      label90:
      label125:
      break label20;
    }
    if (QLog.isColorLevel()) {
      QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Wifi : number format exception !");
    }
    try
    {
      Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    }
    catch (Exception localException2)
    {
      break label55;
    }
    if (QLog.isColorLevel()) {
      QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Wifi : number format exception !");
    }
    try
    {
      Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    }
    catch (Exception localException3)
    {
      break label90;
    }
    if (QLog.isColorLevel()) {
      QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Xg : number format exception !");
    }
    try
    {
      Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    }
    catch (Exception localException4)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      break label125;
    }
    if (QLog.isColorLevel()) {
      QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Xg : number format exception !");
    }
    str1 = (String)paramHashMap.get("tc_p:");
    str2 = (String)paramHashMap.get("rep_bdhTrans");
    str3 = (String)paramHashMap.get("segspercnt");
    str4 = (String)paramHashMap.get("param_conf_segSize");
    str5 = (String)paramHashMap.get("param_conf_segNum");
    str6 = (String)paramHashMap.get("param_conf_connNum");
    paramHashMap = (String)paramHashMap.get("param_fin_lost");
    if (str1 != null) {
      this.mProcessorReport.mReportInfo.put("X-piccachetime", str1);
    }
    if (paramHashMap != null) {
      this.mProcessorReport.mReportInfo.put("param_fin_lost", paramHashMap);
    }
    this.mProcessorReport.mReportInfo.put("param_BdhTrans", str2);
    this.mProcessorReport.mReportInfo.put("param_segspercnt", str3);
    this.mProcessorReport.mReportInfo.put("param_conf_segSize", str4);
    this.mProcessorReport.mReportInfo.put("param_conf_segNum", str5);
    this.mProcessorReport.mReportInfo.put("param_conf_connNum", str6);
  }
  
  protected final long getBlockSize(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.mSSCMSpanned) {
      paramLong = Math.min(paramLong, this.sscmObject.a(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));
    } else {
      paramLong = Math.min(paramLong, 14600L);
    }
    return Math.min(paramLong, 131072L);
  }
  
  public final void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.BDHCommonUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onBusiProtoResp()------response.result = ");
          ((StringBuilder)localObject).append(paramRichProtoReq.result);
          QLog.d("BDHCommonUploadProcessor", 2, ((StringBuilder)localObject).toString());
        }
        if (paramRichProtoReq.result == 0)
        {
          this.mSessionKey = paramRichProtoReq.mUkey;
          this.mTransferedSize = this.mFileSize;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onBusiProtoResp()---- sessionKey: ");
            ((StringBuilder)localObject).append(this.mSessionKey);
            QLog.d("BDHCommonUploadProcessor", 2, ((StringBuilder)localObject).toString());
          }
          this.file.downDomain = paramRichProtoReq.downDomain;
          this.file.orgiDownUrl = paramRichProtoReq.orgiDownUrl;
          this.file.thumbDownUrl = paramRichProtoReq.thumbDownUrl;
          this.file.bigDownUrl = paramRichProtoReq.bigDownUrl;
          localObject = this.file;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(paramRichProtoReq.downDomain);
          localStringBuilder.append(paramRichProtoReq.orgiDownUrl);
          ((FileMsg)localObject).fileUrl = localStringBuilder.toString();
          localObject = this.file;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(paramRichProtoReq.downDomain);
          localStringBuilder.append(paramRichProtoReq.thumbDownUrl);
          ((FileMsg)localObject).thumbUrl = localStringBuilder.toString();
          localObject = this.file;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(paramRichProtoReq.downDomain);
          localStringBuilder.append(paramRichProtoReq.bigDownUrl);
          ((FileMsg)localObject).compressUrl = localStringBuilder.toString();
          this.file.serverPath = paramRichProtoReq.resid;
          if (paramRichProtoReq.isExist)
          {
            this.file.closeInputStream();
            onSuccess();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onBusiProtoResp()---- file is Exsit! ");
              ((StringBuilder)localObject).append(this.mUiRequest.mLocalPath);
              QLog.d("BDHCommonUploadProcessor", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if ((this.mCommandId == 9) && (paramRichProtoReq.resid != null)) {
              this.mResid.bytes_resid.set(ByteStringMicro.copyFrom(paramRichProtoReq.resid.getBytes()));
            }
            if ((this.mCommandId == 20) && (paramRichProtoReq.resid != null)) {
              this.mUploadPicExtInfo.bytes_file_resid.set(ByteStringMicro.copyFrom(paramRichProtoReq.resid.getBytes()));
            }
            this.mUkey = paramRichProtoReq.mUkey;
            this.mTransferedSize = paramRichProtoReq.transferedSize;
            this.mStartOffset = paramRichProtoReq.startOffset;
            sendFile();
          }
          this.mFileID = paramRichProtoReq.groupFileID;
          this.file.fileID = this.mFileID;
          if (QLog.isColorLevel())
          {
            paramRichProtoReq = new StringBuilder();
            paramRichProtoReq.append("mFileID->");
            paramRichProtoReq.append(this.mFileID);
            paramRichProtoReq.append(" groupUin->");
            paramRichProtoReq.append(this.mUiRequest.mPeerUin);
            QLog.d("BDHCommonUploadProcessor", 2, paramRichProtoReq.toString());
          }
        }
        else
        {
          onError();
        }
        i += 1;
      }
    }
  }
  
  final void onError()
  {
    super.onError();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultError");
    }
    sendMessageToUpdate(1005);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uploadCustomEmoticon resultError ---- errCode: ");
      ((StringBuilder)localObject1).append(this.mProcessorReport.errCode);
      ((StringBuilder)localObject1).append(", errDesc:");
      ((StringBuilder)localObject1).append(this.mProcessorReport.errDesc);
      QLog.d("BDHCommonUploadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject1 = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject1).a = -1;
      ((UpCallBack.SendResult)localObject1).b = this.mProcessorReport.errCode;
      ((UpCallBack.SendResult)localObject1).c = this.mProcessorReport.errDesc;
      Object localObject2;
      if (this.mCommandId == 20)
      {
        localObject2 = this.mProcessorReport;
        if (ProcessorReport.getUrlReason(120509L).equals(this.mProcessorReport.mReportInfo.get("param_reason"))) {
          ((UpCallBack.SendResult)localObject1).b = 120509;
        }
      }
      if (this.mCommandId == 9)
      {
        localObject2 = (String)this.mProcessorReport.mReportInfo.get("param_reason");
        ProcessorReport localProcessorReport = this.mProcessorReport;
        if (ProcessorReport.getUrlReason(400010L).equals(localObject2))
        {
          ((UpCallBack.SendResult)localObject1).b = 400010;
        }
        else
        {
          localProcessorReport = this.mProcessorReport;
          if (ProcessorReport.getUrlReason(400011L).equals(localObject2)) {
            ((UpCallBack.SendResult)localObject1).b = 400011;
          }
        }
      }
      this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject1);
    }
  }
  
  public final void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
  }
  
  final void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultOk");
    }
    sendMessageToUpdate(1003);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "onSuccess().");
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = 0;
      if (this.mCommandId == 20) {
        localSendResult.f = this.file.serverPath;
      }
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    int i = this.mCommandId;
    if ((i == 9) || (i == 76)) {
      sendMessageToUpdate(1008);
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.pause()");
    }
    if (this.mCommandId == 54)
    {
      if (!this.mIsPause)
      {
        this.mIsPause = true;
        if (QLog.isColorLevel()) {
          logRichMediaEvent("pause", "");
        }
        sendMessageToUpdate(1006);
        if (this.trans != null) {
          this.app.getHwEngine().stopTransactionTask(this.trans);
        }
      }
    }
    else {
      super.pause();
    }
  }
  
  public final int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.resume()");
    }
    if (this.mCommandId == 54)
    {
      if (this.mIsPause)
      {
        this.mIsPause = false;
        if (QLog.isColorLevel()) {
          logRichMediaEvent("resume", "");
        }
        if (this.trans != null) {
          this.app.getHwEngine().resumeTransactionTask(this.trans);
        }
      }
      return super.resume();
    }
    cancel();
    sendRequest();
    return 0;
  }
  
  public final void sendFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHNormalUploadProcessor.sendFile()");
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    Object localObject = new BDHCommonUploadProcessor.1(this, SystemClock.uptimeMillis());
    int i = this.mCommandId;
    if (i == 9) {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, (ITransactionCallback)localObject, this.mResid.toByteArray());
    } else if (i == 20) {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, (ITransactionCallback)localObject, this.mUploadPicExtInfo.toByteArray());
    } else if (i == 36) {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject, constructReqBody(), false);
    } else if (i == 40) {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject, this.mUiRequest.mExtentionInfo, true);
    } else if (i == 54) {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject, this.mUiRequest.mExtentionInfo, false);
    } else if ((i != 51) && (i != 58) && (i != 62) && (i != 65) && (i != 70) && (i != 76) && (i != 78) && (i != 79) && (i != 80) && (i != 82)) {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, (ITransactionCallback)localObject);
    } else {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject, this.mUiRequest.mExtentionInfo, false);
    }
    i = this.app.getHwEngine().submitTransactionTask(this.trans);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction submit RetCode:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" T_ID:");
      ((StringBuilder)localObject).append(this.trans.getTransationId());
      ((StringBuilder)localObject).append(" UniSeq:");
      ((StringBuilder)localObject).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject).append(" MD5:");
      ((StringBuilder)localObject).append(this.mMd5Str);
      ((StringBuilder)localObject).append(" uuid:");
      ((StringBuilder)localObject).append(this.mUuid);
      ((StringBuilder)localObject).append(" Path:");
      ((StringBuilder)localObject).append(this.trans.filePath);
      ((StringBuilder)localObject).append(" Cmd:");
      ((StringBuilder)localObject).append(3);
      QLog.d("BDHCommonUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 0)
    {
      this.mProcessorReport.setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  public final void start()
  {
    super.start();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.start()");
    }
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return;
    }
    int i = this.mCommandId;
    if (36 == i)
    {
      this.mSessionKey = "null";
      this.file.filePath = this.mUiRequest.mLocalPath;
      sendFile();
    }
    else if (18 == i)
    {
      this.mSessionKey = "null";
      sendFile();
    }
    else if (40 == i)
    {
      sendFile();
    }
    else if (54 == i)
    {
      sendFile();
    }
    else if ((51 != i) && (62 != i))
    {
      if (58 == i)
      {
        sendFile();
      }
      else if (65 == i)
      {
        sendFile();
      }
      else if (70 == i)
      {
        sendFile();
      }
      else if (76 == i)
      {
        sendFile();
      }
      else if (78 == i)
      {
        this.file.compressUrl = ((String)this.mUiRequest.extraObject);
        sendFile();
      }
      else if (79 == i)
      {
        sendFile();
      }
      else if (80 == i)
      {
        sendFile();
      }
      else if (82 == i)
      {
        sendFile();
      }
      else
      {
        sendRequest();
      }
    }
    else
    {
      sendFile();
    }
    sendMessageToUpdate(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BDHCommonUploadProcessor
 * JD-Core Version:    0.7.0.1
 */