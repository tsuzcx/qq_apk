package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class GroupQzonePicUploadProcessor
  extends GroupPicUploadProcessor
{
  public GroupQzonePicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  protected int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    int i = this.mUiRequest.mUinType;
    if ((i != 1) && (i != 1026)) {
      this.mIsGroup = false;
    } else {
      this.mIsGroup = true;
    }
    Object localObject = getTransferRequest();
    if ((localObject != null) && (((TransferRequest)localObject).mIsFastForward))
    {
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
        this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
      }
      return 0;
    }
    if (TextUtils.isEmpty(this.mUiRequest.mMd5))
    {
      this.mProcessorReport.setError(9042, getExpStackString(new Exception("qzonePic md5 null!")), null, null);
      onError();
      return -1;
    }
    if ((this.mUiRequest.photoSendParams != null) && (!TextUtils.isEmpty(this.mUiRequest.photoSendParams.rawDownloadUrl)) && (!TextUtils.isEmpty(this.mUiRequest.photoSendParams.rawMd5)))
    {
      localObject = this.file;
      long l = this.mUiRequest.photoSendParams.fileSize;
      ((FileMsg)localObject).fileSize = l;
      this.mFileSize = l;
      if (this.mFileSize <= 0L)
      {
        this.mProcessorReport.setError(9071, getExpStackString(new Exception("qzonePic file size 0 ")), null, null);
        onError();
        return -1;
      }
      if (this.mFileSize >= ((IPicBus)QRoute.api(IPicBus.class)).getGroupPicSizeLimit())
      {
        setError(9063, getExpStackString(new Exception("qzonePic file size TooBig! ")), null, null);
        onError();
        return -1;
      }
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
        this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
      }
      return 0;
    }
    this.mProcessorReport.setError(9302, getExpStackString(new Exception("qzonePic param_check error!")), null, null);
    onError();
    return -1;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    super.doReport(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
      localHashMap.put("fail_url", this.mUiRequest.photoSendParams.rawDownloadUrl);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
    sendMessageToUpdate(1000);
    this.file.closeInputStream();
    sendMessageToUpdate(1001);
    Object localObject = getTransferRequest();
    if ((localObject != null) && (((TransferRequest)localObject).mIsFastForward))
    {
      this.mWidth = ((TransferRequest)localObject).mFastForwardWidth;
      this.mHeight = ((TransferRequest)localObject).mFastForwardHeight;
      this.mFileSize = ((TransferRequest)localObject).mFastForwardFileSize;
      this.mLocalMd5 = com.tencent.mobileqq.utils.HexUtil.hexStr2Bytes(((TransferRequest)localObject).mMd5);
      this.mFileName = ((TransferRequest)localObject).mMd5;
      this.mMd5Str = this.mFileName;
      this.file.fileMd5 = this.mFileName;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mFileName);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(this.mExtName);
      this.mFileName = ((StringBuilder)localObject).toString();
      this.app.getHwEngine().preConnect();
      sendRequest();
      return;
    }
    if (this.mUiRequest.photoSendParams != null)
    {
      this.mWidth = this.mUiRequest.photoSendParams.rawWidth;
      this.mHeight = this.mUiRequest.photoSendParams.rawHeight;
      this.mLocalMd5 = com.tencent.mobileqq.utils.HexUtil.hexStr2Bytes(this.mUiRequest.photoSendParams.rawMd5);
      this.mFileName = com.qq.taf.jce.HexUtil.bytes2HexStr(this.mLocalMd5);
      this.mMd5Str = this.mFileName;
      this.file.fileMd5 = this.mFileName;
      this.mExtName = "jpg";
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mFileName);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(this.mExtName);
      this.mFileName = ((StringBuilder)localObject).toString();
    }
    this.app.getHwEngine().preConnect();
    sendRequest();
  }
  
  protected void onGroupBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=");
          localStringBuilder.append(this.mProcessorReport.mSendByQuickHttp);
          QLog.e("http_sideway", 2, localStringBuilder.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp))
        {
          paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
          if (paramRichProtoReq.result == 0)
          {
            if (paramRichProtoReq.isExist)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:");
                localStringBuilder.append(paramRichProtoReq.groupFileID);
                localStringBuilder.append(", mFileSize:");
                localStringBuilder.append(this.file.fileSize);
                QLog.d("GroupPicUploadProcessor", 2, localStringBuilder.toString());
              }
              this.mIsPicSecondTransfered = true;
              this.file.transferedSize = this.file.fileSize;
              this.mFileID = paramRichProtoReq.groupFileID;
              this.mIpList = paramRichProtoReq.mIpList;
              sendMsg();
            }
            else
            {
              paramRichProtoResp = new StringBuilder();
              paramRichProtoResp.append("<BDH_LOG> onBusiProtoResp() picUpResp exist : ");
              paramRichProtoResp.append(paramRichProtoReq.isExist);
              paramRichProtoResp.append(" ,select HTTP channel");
              log(paramRichProtoResp.toString());
              this.mChannelStatus = 2;
              onError();
            }
          }
          else
          {
            paramRichProtoResp = new StringBuilder();
            paramRichProtoResp.append("<BDH_LOG> onBusiProtoResp() picUpResp error : ");
            paramRichProtoResp.append(paramRichProtoReq.result);
            paramRichProtoResp.append(" ,select HTTP channel");
            log(paramRichProtoResp.toString());
            this.mChannelStatus = 2;
            onError();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  protected void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    localPicUpReq.isRaw = this.mIsRawPic;
    localPicUpReq.busiType = this.mUiRequest.mBusiType;
    localPicUpReq.typeHotPic = 3;
    localPicUpReq.transferUrl = this.mUiRequest.photoSendParams.rawDownloadUrl;
    Object localObject = this.mUiRequest.mRec;
    if (MessageForPic.class.isInstance(localObject))
    {
      localObject = (MessageForPic)localObject;
      localPicUpReq.picType = ((MessageForPic)localObject).imageType;
      this.mPicType = ((MessageForPic)localObject).imageType;
    }
    localPicUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPicUpReq.secondUin = this.mUiRequest.mSecondId;
    localPicUpReq.uinType = this.mUiRequest.mUinType;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_pic_up";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupQzonePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */