package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.BDHCommonUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
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
  public static final int RET_ERR_FAV_EMO_NORMAL_LIMITED = 400010;
  public static final int RET_ERR_FAV_EMO_SVIP_LIMITED = 400011;
  public static final String TAG = "BDHCommonUploadProcessor";
  QQAppInterface app = (QQAppInterface)this.app;
  private int mCommandId;
  private byte[] mExtention;
  private long mFileID;
  private cmd0x388.ExpRoamExtendInfo mResid = new cmd0x388.ExpRoamExtendInfo();
  private String mRichTag;
  private String mSessionKey;
  private Bdh_extinfo.UploadPicExtInfo mUploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
  Transaction trans = null;
  
  public BDHCommonUploadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.mCommandId = paramTransferRequest.mCommandId;
    this.file.commandId = paramTransferRequest.mCommandId;
    this.mRichTag = paramTransferRequest.mRichTag;
    this.mExtention = paramTransferRequest.mExtentionInfo;
  }
  
  public static List<ExcitingTransferHostInfo> getBDHServerIp(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = ConfigManager.getInstance(BaseApplication.getContext(), ((QQAppInterface)localObject1).getHwEngine());
      if (localObject2 != null)
      {
        localObject2 = ((ConfigManager)localObject2).getOtherTypeIp(((QQAppInterface)localObject1).getApp().getBaseContext(), 21, paramBoolean);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          localObject1 = ((List)localObject2).iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EndPoint)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((EndPoint)localObject2).host)))
          {
            localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject2).host, ((EndPoint)localObject2).port, true));
            continue;
            HwServlet.getConfig((AppRuntime)localObject1, ((QQAppInterface)localObject1).getCurrentUin());
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static byte[] getHttpConnKey()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getSessionKey();
  }
  
  public static byte[] getHttpConnSig()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getHttpconn_sig_session();
  }
  
  private final void sendRequest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = buildRichProtoReq();
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while ((!canDoNextStep()) || (localRichProtoReq == null));
    this.mRichProtoReq = localRichProtoReq;
    QLog.i("BDHCommonUploadProcessor", 1, "BDHCommonUploadProcessor commonId: " + this.mCommandId);
    RichProtoProc.procRichProtoReq(localRichProtoReq);
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
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ImageUtil.a(this.mUiRequest.mLocalPath, (BitmapFactory.Options)localObject);
      this.mHeight = ((BitmapFactory.Options)localObject).outHeight;
      this.mWidth = ((BitmapFactory.Options)localObject).outWidth;
    }
    Object localObject = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      setError(9042, getExpStackString(new Exception("sendFile not exist " + (String)localObject)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      setError(9070, getExpStackString(new Exception("sendFile not readable " + this.file.filePath)));
      onError();
      return -1;
    }
    long l = localFile.length();
    this.file.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      setError(9071, getExpStackString(new Exception("file size 0 " + (String)localObject)));
      onError();
      return -1;
    }
    localObject = FileUtils.b((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.mExtName = ((String)localObject);
    }
    if ((this.mCommandId != 54) && (l >= PicUploadFileSizeLimit.getLimitC2C()))
    {
      setError(9063, (String)localObject, getClientReason((String)localObject), null);
      onError();
      return -1;
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
      String str = this.app.getCurrentUin();
      localObject = str;
      if (str.startsWith("+")) {
        localObject = str.substring(1);
      }
      long l = Long.valueOf((String)localObject).longValue();
      localApplyUploadReq.uint64_recver_uin.set(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        localException.printStackTrace();
      }
    }
    localApplyUploadReq.uint32_file_type.set(2);
    localApplyUploadReq.str_file_name.set(this.mFileName);
    localApplyUploadReq.uint64_file_size.set(this.mFileSize);
    localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
    localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
    localObject = new cmd0x346.ExtensionReq();
    ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
    ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(0);
    ((cmd0x346.ExtensionReq)localObject).uint32_ptt_time.set(this.mUiRequest.mRequestLength);
    i = BaseHandler.getHandlerNetType();
    ((cmd0x346.ExtensionReq)localObject).uint32_net_type.set(i);
    ((cmd0x346.ExtensionReq)localObject).uint32_voice_type.set(2);
    ((cmd0x346.ExtensionReq)localObject).uint64_type.set(0);
    localReqBody.msg_extension_req.set((MessageMicro)localObject);
    return localReqBody.toByteArray();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {}
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      HashMap localHashMap = this.mReportInfo;
      if (this.mSessionKey != null) {
        break label158;
      }
      str = "null";
      label105:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label167;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.mRichTag, true, l, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break;
      label158:
      str = this.mSessionKey;
      break label105;
      label167:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.mRichTag, false, l, this.mFileSize, this.mReportInfo, "");
    }
  }
  
  protected final void doStatistic(HashMap<String, String> paramHashMap)
  {
    try
    {
      Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    }
    catch (Exception localException3)
    {
      try
      {
        Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      }
      catch (Exception localException3)
      {
        try
        {
          Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
              String str1 = (String)paramHashMap.get("tc_p:");
              String str2 = (String)paramHashMap.get("rep_bdhTrans");
              String str3 = (String)paramHashMap.get("segspercnt");
              String str4 = (String)paramHashMap.get("param_conf_segSize");
              String str5 = (String)paramHashMap.get("param_conf_segNum");
              String str6 = (String)paramHashMap.get("param_conf_connNum");
              paramHashMap = (String)paramHashMap.get("param_fin_lost");
              if (str1 != null) {
                this.mReportInfo.put("X-piccachetime", str1);
              }
              if (paramHashMap != null) {
                this.mReportInfo.put("param_fin_lost", paramHashMap);
              }
              this.mReportInfo.put("param_BdhTrans", str2);
              this.mReportInfo.put("param_segspercnt", str3);
              this.mReportInfo.put("param_conf_segSize", str4);
              this.mReportInfo.put("param_conf_segNum", str5);
              this.mReportInfo.put("param_conf_connNum", str6);
              return;
              localException1 = localException1;
              if (QLog.isColorLevel())
              {
                QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Wifi : number format exception !");
                continue;
                localException2 = localException2;
                if (QLog.isColorLevel())
                {
                  QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Wifi : number format exception !");
                  continue;
                  localException3 = localException3;
                  if (QLog.isColorLevel()) {
                    QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Xg : number format exception !");
                  }
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Xg : number format exception !");
              }
            }
          }
        }
      }
    }
  }
  
  protected final long getBlockSize(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.mSSCMSpanned) {}
    for (paramLong = Math.min(paramLong, this.sscmObject.a(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  public final void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.BDHCommonUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.result);
        }
        if (paramRichProtoReq.result == 0)
        {
          this.mSessionKey = paramRichProtoReq.mUkey;
          this.mTransferedSize = this.mFileSize;
          if (QLog.isColorLevel()) {
            QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.mSessionKey);
          }
          this.file.downDomain = paramRichProtoReq.downDomain;
          this.file.orgiDownUrl = paramRichProtoReq.orgiDownUrl;
          this.file.thumbDownUrl = paramRichProtoReq.thumbDownUrl;
          this.file.bigDownUrl = paramRichProtoReq.bigDownUrl;
          this.file.fileUrl = ("http://" + paramRichProtoReq.downDomain + paramRichProtoReq.orgiDownUrl);
          this.file.thumbUrl = ("http://" + paramRichProtoReq.downDomain + paramRichProtoReq.thumbDownUrl);
          this.file.compressUrl = ("http://" + paramRichProtoReq.downDomain + paramRichProtoReq.bigDownUrl);
          this.file.serverPath = paramRichProtoReq.resid;
          if (paramRichProtoReq.isExist)
          {
            this.file.closeInputStream();
            onSuccess();
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.mUiRequest.mLocalPath);
            }
            label374:
            this.mFileID = paramRichProtoReq.groupFileID;
            this.file.fileID = this.mFileID;
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "mFileID->" + this.mFileID + " groupUin->" + this.mUiRequest.mPeerUin);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
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
          break label374;
          onError();
        }
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
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultError ---- errCode: " + this.errCode + ", errDesc:" + this.errDesc);
    }
    UpCallBack.SendResult localSendResult;
    String str;
    if (this.mUiRequest.mUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.errCode;
      localSendResult.jdField_a_of_type_JavaLangString = this.errDesc;
      if ((this.mCommandId == 20) && (BaseTransProcessor.getUrlReason(120509L).equals(this.mReportInfo.get("param_reason")))) {
        localSendResult.b = 120509;
      }
      if (this.mCommandId == 9)
      {
        str = (String)this.mReportInfo.get("param_reason");
        if (!BaseTransProcessor.getUrlReason(400010L).equals(str)) {
          break label207;
        }
        localSendResult.b = 400010;
      }
    }
    for (;;)
    {
      this.mUiRequest.mUpCallBack.b(localSendResult);
      return;
      label207:
      if (BaseTransProcessor.getUrlReason(400011L).equals(str)) {
        localSendResult.b = 400011;
      }
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
      localSendResult.jdField_a_of_type_Int = 0;
      if (this.mCommandId == 20) {
        localSendResult.c = this.file.serverPath;
      }
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    if ((this.mCommandId == 9) || (this.mCommandId == 76)) {
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
      return;
    }
    super.pause();
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
    this.mStepTrans.logStartTime();
    BDHCommonUploadProcessor.1 local1 = new BDHCommonUploadProcessor.1(this, SystemClock.uptimeMillis());
    if (this.mCommandId == 9) {
      this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, local1, this.mResid.toByteArray());
    }
    for (;;)
    {
      int i = this.app.getHwEngine().submitTransactionTask(this.trans);
      if (QLog.isColorLevel()) {
        QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:" + 3);
      }
      if (i != 0)
      {
        setError(i, "SubmitError.", "", this.mStepTrans);
        onError();
      }
      return;
      if (this.mCommandId == 20) {
        this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, local1, this.mUploadPicExtInfo.toByteArray());
      } else if (this.mCommandId == 36) {
        this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, local1, constructReqBody(), false);
      } else if (this.mCommandId == 40) {
        this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, local1, this.mUiRequest.mExtentionInfo, true);
      } else if (this.mCommandId == 54) {
        this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, local1, this.mUiRequest.mExtentionInfo, false);
      } else if ((this.mCommandId == 51) || (this.mCommandId == 58) || (this.mCommandId == 62) || (this.mCommandId == 65) || (this.mCommandId == 70) || (this.mCommandId == 76) || (this.mCommandId == 78) || (this.mCommandId == 79) || (this.mCommandId == 80) || (this.mCommandId == 82)) {
        this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mLocalMd5, local1, this.mUiRequest.mExtentionInfo, false);
      } else {
        this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, local1);
      }
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
    if (36 == this.mCommandId)
    {
      this.mSessionKey = "null";
      this.file.filePath = this.mUiRequest.mLocalPath;
      sendFile();
    }
    for (;;)
    {
      sendMessageToUpdate(1001);
      return;
      if (18 == this.mCommandId)
      {
        this.mSessionKey = "null";
        sendFile();
      }
      else if (40 == this.mCommandId)
      {
        sendFile();
      }
      else if (54 == this.mCommandId)
      {
        sendFile();
      }
      else if ((51 == this.mCommandId) || (62 == this.mCommandId))
      {
        sendFile();
      }
      else if (58 == this.mCommandId)
      {
        sendFile();
      }
      else if (65 == this.mCommandId)
      {
        sendFile();
      }
      else if (70 == this.mCommandId)
      {
        sendFile();
      }
      else if (76 == this.mCommandId)
      {
        sendFile();
      }
      else if (78 == this.mCommandId)
      {
        this.file.compressUrl = ((String)this.mUiRequest.extraObject);
        sendFile();
      }
      else if (79 == this.mCommandId)
      {
        sendFile();
      }
      else if (80 == this.mCommandId)
      {
        sendFile();
      }
      else if (82 == this.mCommandId)
      {
        sendFile();
      }
      else
      {
        sendRequest();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BDHCommonUploadProcessor
 * JD-Core Version:    0.7.0.1
 */