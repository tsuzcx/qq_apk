package com.tencent.mobileqq.hotpic;

import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotVideoData
  extends HotPicData
  implements URLDrawable.DownloadListener
{
  public static final int PREVIEWIMAGE_TYPE = 1;
  public static final String TAG = "HotVideoData";
  public static final int UNKNOW_TYPE = 0;
  public static final int VIDEO_TYPE = 2;
  public String mCertificatedIcon;
  public String mPreviewUUID;
  public String mVideoUUID;
  WeakReference<URLDrawable.DownloadListener> mWeakPreviewDownloadListener = null;
  public long videoLength;
  public String videoSource;
  
  private void GetURLByTypeAsync(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack)
  {
    if (paramHotVideoGetUrlCallBack == null) {
      return;
    }
    try
    {
      HotVideoData.HotVideoGetUrlResult localHotVideoGetUrlResult = new HotVideoData.HotVideoGetUrlResult();
      localHotVideoGetUrlResult.f = paramInt2;
      String str1;
      if (paramInt2 == 1) {
        str1 = this.mPreviewUUID;
      } else {
        str1 = this.mVideoUUID;
      }
      String str2;
      if (paramInt2 == 1) {
        str2 = this.md5;
      } else {
        str2 = this.originalMD5;
      }
      requestUrlByUuid(paramQQAppInterface, str1, str2, paramInt1, paramInt2, paramString, new HotVideoData.1(this, localHotVideoGetUrlResult, paramHotVideoGetUrlCallBack));
      return;
    }
    finally {}
  }
  
  private static boolean isIpv6()
  {
    return true;
  }
  
  private void requestUrlByUuid(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, RichProtoProc.RichProtoCallback paramRichProtoCallback)
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.seq = Calendar.getInstance().get(5);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendGetUrlReq()----busiReq.seq : ");
      localStringBuilder.append(localShortVideoDownReq.seq);
      QLog.d("HotVideoData", 2, localStringBuilder.toString());
    }
    localShortVideoDownReq.selfUin = paramString3;
    localShortVideoDownReq.peerUin = paramQQAppInterface.getCurrentUin();
    localShortVideoDownReq.secondUin = paramString3;
    localShortVideoDownReq.uinType = paramInt1;
    localShortVideoDownReq.agentType = 0;
    if (localShortVideoDownReq.uinType == 0) {
      localShortVideoDownReq.chatType = 0;
    } else if (1 == localShortVideoDownReq.uinType) {
      localShortVideoDownReq.chatType = 1;
    } else if (3000 == localShortVideoDownReq.uinType) {
      localShortVideoDownReq.chatType = 2;
    } else {
      localShortVideoDownReq.chatType = 3;
    }
    if ((localShortVideoDownReq.uinType != 0) && (1008 != localShortVideoDownReq.uinType)) {
      localShortVideoDownReq.troopUin = localShortVideoDownReq.peerUin;
    } else {
      localShortVideoDownReq.troopUin = null;
    }
    localShortVideoDownReq.clientType = 2;
    localShortVideoDownReq.fileId = paramString1;
    localShortVideoDownReq.md5 = HexUtil.hexStr2Bytes(paramString2);
    localShortVideoDownReq.busiType = 0;
    localShortVideoDownReq.subBusiType = 0;
    localShortVideoDownReq.fileType = paramInt2;
    localShortVideoDownReq.downType = 1;
    localShortVideoDownReq.sceneType = 1;
    localRichProtoReq.callback = paramRichProtoCallback;
    localRichProtoReq.protoKey = "short_video_dw";
    localRichProtoReq.reqs.add(localShortVideoDownReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)paramQQAppInterface.getRuntimeService(IProtoReqManager.class, ""));
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public boolean CheckIsNeedBlurBackground()
  {
    return this.width / this.height + 0.1F < 1.777778F;
  }
  
  public void GetPreviewURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 1, paramHotVideoGetUrlCallBack);
  }
  
  public void GetVideoURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 2, paramHotVideoGetUrlCallBack);
  }
  
  public void SetPreviewDownloadListener(URLDrawable.DownloadListener paramDownloadListener)
  {
    if ((paramDownloadListener != null) && (paramDownloadListener != this))
    {
      this.mWeakPreviewDownloadListener = new WeakReference(paramDownloadListener);
      return;
    }
    this.mWeakPreviewDownloadListener = null;
  }
  
  public URLDrawable.DownloadListener TryGetPreviewDownloadListener()
  {
    WeakReference localWeakReference = this.mWeakPreviewDownloadListener;
    if (localWeakReference == null) {
      return null;
    }
    return (URLDrawable.DownloadListener)localWeakReference.get();
  }
  
  public int getDataType()
  {
    return 2;
  }
  
  public String getVideoLengthString()
  {
    return new SimpleDateFormat("mm:ss").format(new Date(this.videoLength));
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadFailed(paramInt);
    }
  }
  
  public void onFileDownloadStarted()
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadStarted();
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadSucceed(paramLong);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("hotvideo:");
    localStringBuffer.append("version:");
    localStringBuffer.append(this.version);
    localStringBuffer.append(" ");
    localStringBuffer.append("md5:");
    localStringBuffer.append(this.md5);
    localStringBuffer.append(" ");
    localStringBuffer.append("fileSize:");
    localStringBuffer.append(this.fileSize);
    localStringBuffer.append(" ");
    localStringBuffer.append("width:");
    localStringBuffer.append(this.width);
    localStringBuffer.append(" ");
    localStringBuffer.append("height:");
    localStringBuffer.append(this.height);
    localStringBuffer.append(" ");
    localStringBuffer.append("mPreviewUUID:");
    localStringBuffer.append(this.mPreviewUUID);
    localStringBuffer.append(" ");
    localStringBuffer.append("picIndex:");
    localStringBuffer.append(this.picIndex);
    localStringBuffer.append(" ");
    localStringBuffer.append("iconUrl:");
    localStringBuffer.append(this.iconUrl);
    localStringBuffer.append(" ");
    localStringBuffer.append("jumpUrl:");
    localStringBuffer.append(this.jumpUrl);
    localStringBuffer.append(" ");
    localStringBuffer.append("name:");
    localStringBuffer.append(this.name);
    localStringBuffer.append(" ");
    localStringBuffer.append("videoSource:");
    localStringBuffer.append(this.videoSource);
    localStringBuffer.append(" ");
    localStringBuffer.append("videoLength:");
    localStringBuffer.append(this.videoLength);
    localStringBuffer.append(" ");
    localStringBuffer.append("originalWidth:");
    localStringBuffer.append(this.originalWidth);
    localStringBuffer.append(" ");
    localStringBuffer.append("originalHeight:");
    localStringBuffer.append(this.originalHeight);
    localStringBuffer.append(" ");
    localStringBuffer.append("mVideoUUID:");
    localStringBuffer.append(this.mVideoUUID);
    localStringBuffer.append(" ");
    localStringBuffer.append("originalMD5:");
    localStringBuffer.append(this.originalMD5);
    localStringBuffer.append(" ");
    localStringBuffer.append("mCertificatedIcon:");
    localStringBuffer.append(this.mCertificatedIcon);
    localStringBuffer.append(" ");
    localStringBuffer.append("oringinalSize:");
    localStringBuffer.append(this.oringinalSize);
    localStringBuffer.append(" ");
    localStringBuffer.append("tag:");
    localStringBuffer.append(this.tag);
    localStringBuffer.append(" ");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData
 * JD-Core Version:    0.7.0.1
 */