package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.BusiType;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoFeedsPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private WeakReference<VideoPlayParam> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<VideoPlayerWrapper> b;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoPlayParam);
    this.b = new WeakReference(paramVideoPlayerWrapper);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=");
        localStringBuilder.append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
        QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 201, 60, 0, "video info busiType error", null);
      }
    }
    else
    {
      if (BusiType.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int))
      {
        c(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
        return;
      }
      if (BusiType.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString))
      {
        if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString != null)
        {
          a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, paramLong);
          return;
        }
        if (VideoFeedsPlayManager.a(this.this$0) != null) {
          VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 201, 61, 0, "vid null", null);
        }
      }
      else
      {
        if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int == 5)
        {
          b(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
          return;
        }
        if ((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int == 6) && (!TextUtils.isEmpty(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r))) {
          paramVideoPlayerWrapper.a("", paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r, 101, paramLong, 0L, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.d, true, true, paramVideoPlayParam.jdField_a_of_type_Boolean);
        }
      }
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, VideoUrlInfo paramVideoUrlInfo, ThirdVideoManager paramThirdVideoManager)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString, long paramLong)
  {
    ThirdVideoManager localThirdVideoManager = ThirdVideoManager.a();
    localThirdVideoManager.a(paramString, new VideoFeedsPlayManager.PlayStartVideoRunnable.1(this, paramLong, localThirdVideoManager));
  }
  
  private boolean a(VideoUrlInfo paramVideoUrlInfo, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoUrlInfo.c == 2)
    {
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 202, 108, 0, "vid2url failed, video deleted", null);
      }
      return false;
    }
    if (TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString))
    {
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 202, 107, 0, "vid2url failed, get null", null);
      }
      return false;
    }
    return true;
  }
  
  private boolean a(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayerWrapper == null) {
        return false;
      }
      if (VideoFeedsPlayManager.e(this.this$0))
      {
        paramVideoPlayerWrapper.l();
        return false;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!VideoFeedsPlayManager.a(this.this$0, paramVideoPlayerWrapper)))
      {
        VideoFeedsPlayManager.a(this.this$0, paramVideoPlayerWrapper);
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void b(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    Object localObject1 = VideoFeedsPlayManager.a(this.this$0);
    if (localObject1 != null)
    {
      paramVideoPlayerWrapper.b = ((VideoPreDownloadMgr)localObject1).a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("广告视频预下载: url:");
        ((StringBuilder)localObject2).append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" ;isPreDownloadHit: ");
        ((StringBuilder)localObject2).append(paramVideoPlayerWrapper.b);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject2).toString());
      }
      ((VideoPreDownloadMgr)localObject1).a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, paramVideoPlayerWrapper.b);
    }
    localObject1 = null;
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null) {
      localObject1 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.s;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString.startsWith("http")) {
        localObject2 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramVideoPlayerWrapper.a("", (String)localObject2, 101, paramLong, 0L, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.d, true, false, paramVideoPlayParam.jdField_a_of_type_Boolean);
      return;
    }
    c(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
  }
  
  private void c(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.this$0);
      paramVideoPlayerWrapper.b = localVideoPreDownloadMgr.a(null, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
      localVideoPreDownloadMgr.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, paramVideoPlayerWrapper.b);
    }
    paramVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, 1, paramLong, paramVideoPlayParam.jdField_a_of_type_Boolean);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    VideoPlayParam localVideoPlayParam = (VideoPlayParam)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)this.b.get();
    if (!a(localVideoPlayParam, localVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "PlayStartVideoRunnable: checkVideoStatus error return");
      }
      return;
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1 = true;
    if (!bool2) {
      VideoFeedsPlayManager.a(this.this$0, true);
    }
    long l = localVideoPlayParam.jdField_a_of_type_Long;
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.this$0;
    if (l <= 0L) {
      bool1 = false;
    }
    VideoFeedsPlayManager.f(localVideoFeedsPlayManager, bool1);
    a(localVideoPlayParam, localVideoPlayerWrapper, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */