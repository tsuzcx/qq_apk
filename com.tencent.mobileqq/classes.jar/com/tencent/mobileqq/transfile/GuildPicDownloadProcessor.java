package com.tencent.mobileqq.transfile;

import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GuildPicDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.List;

public class GuildPicDownloadProcessor
  extends GroupPicDownloadProcessor
{
  private static final String TAG = "GuildPicDownloadProcessor.<gld>";
  
  public GuildPicDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    paramBaseTransFileController = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramTransferRequest.mPeerUin);
    if (paramBaseTransFileController != null) {
      paramBaseTransFileController = paramBaseTransFileController.getGuildId();
    } else {
      paramBaseTransFileController = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromAio(paramTransferRequest.mPeerUin);
    }
    if (!TextUtils.isEmpty(paramBaseTransFileController)) {
      this.mUiRequest.mSecondId = paramBaseTransFileController;
    }
    if (TextUtils.isEmpty(this.mUiRequest.mSecondId))
    {
      paramBaseTransFileController = new StringBuilder();
      paramBaseTransFileController.append("getDownloadInfo error");
      paramBaseTransFileController.append(QLog.getStackTraceString(new Throwable()));
      QLog.d("GuildPicDownloadProcessor.<gld>", 1, paramBaseTransFileController.toString());
    }
    this.mEncryptPic = false;
    this.mEncryptUrl = false;
  }
  
  protected void refreshURLDrawable(MessageForPic paramMessageForPic, URL paramURL, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramURL.toString());
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append("guildStuff");
    localObject = ((StringBuilder)localObject).toString();
    if (GlobalImageCache.a.get(localObject) == null) {
      return;
    }
    GlobalImageCache.a.remove(localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "guildStuff";
    paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject);
    paramURL.setTag(paramMessageForPic);
    if (paramURL != null)
    {
      if (paramMessageForPic.thumbWidthHeightDP == null)
      {
        paramURL.downloadImediatly(true);
        return;
      }
      paramURL.invalidateSelf();
    }
  }
  
  void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    this.mDirectMsgUrlDown = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GuildPicDownReq localGuildPicDownReq = new RichProto.RichProtoReq.GuildPicDownReq();
    localGuildPicDownReq.index = this.mUiRequest.mExtentionInfo;
    localGuildPicDownReq.selfUin = this.mUiRequest.mSelfUin;
    localGuildPicDownReq.peerUin = this.mUiRequest.mPeerUin;
    localGuildPicDownReq.secondUin = this.mUiRequest.mSecondId;
    localGuildPicDownReq.uinType = this.mUiRequest.mUinType;
    localGuildPicDownReq.fileType = this.mUiRequest.mFileType;
    localGuildPicDownReq.groupFileID = this.mGroupFileID;
    localGuildPicDownReq.md5 = this.mMsgFileMd5;
    localGuildPicDownReq.msgTime = ((int)this.mUiRequest.mMsgTime);
    localGuildPicDownReq.protocolType = 0;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "gld_pic_dw";
    localRichProtoReq.reqs.add(localGuildPicDownReq);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GuildPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */