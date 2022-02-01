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
  private WeakReference<VideoPlayParam> a;
  private WeakReference<VideoPlayerWrapper> b;
  private boolean c;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean)
  {
    this.a = new WeakReference(paramVideoPlayParam);
    this.b = new WeakReference(paramVideoPlayerWrapper);
    this.c = paramBoolean;
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (paramVideoPlayParam.c.a == 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=");
        localStringBuilder.append(paramVideoPlayParam.c.b);
        QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
      }
      if (VideoFeedsPlayManager.m(this.this$0) != null) {
        VideoFeedsPlayManager.m(this.this$0).a(paramVideoPlayerWrapper, 201, 60, 0, "video info busiType error", null);
      }
    }
    else
    {
      if (BusiType.a(paramVideoPlayParam.c.a))
      {
        c(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
        return;
      }
      if (BusiType.a(paramVideoPlayParam.c.a, paramVideoPlayParam.c.b))
      {
        if (paramVideoPlayParam.c.b != null)
        {
          a(paramVideoPlayParam.c.b, paramLong);
          return;
        }
        if (VideoFeedsPlayManager.m(this.this$0) != null) {
          VideoFeedsPlayManager.m(this.this$0).a(paramVideoPlayerWrapper, 201, 61, 0, "vid null", null);
        }
      }
      else
      {
        if (paramVideoPlayParam.c.a == 5)
        {
          b(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
          return;
        }
        if ((paramVideoPlayParam.c.a == 6) && (!TextUtils.isEmpty(paramVideoPlayParam.c.D)))
        {
          paramVideoPlayerWrapper.c(false);
          paramVideoPlayerWrapper.a("", paramVideoPlayParam.c.D, 101, paramLong, 0L, paramVideoPlayParam.c.e, true, true, paramVideoPlayParam.i);
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
    if (paramVideoUrlInfo.k == 2)
    {
      if (VideoFeedsPlayManager.m(this.this$0) != null) {
        VideoFeedsPlayManager.m(this.this$0).a(paramVideoPlayerWrapper, 202, 108, 0, "vid2url failed, video deleted", null);
      }
      return false;
    }
    if (TextUtils.isEmpty(paramVideoUrlInfo.a))
    {
      if (VideoFeedsPlayManager.m(this.this$0) != null) {
        VideoFeedsPlayManager.m(this.this$0).a(paramVideoPlayerWrapper, 202, 107, 0, "vid2url failed, get null", null);
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
      if (VideoFeedsPlayManager.l(this.this$0))
      {
        paramVideoPlayerWrapper.D();
        return false;
      }
      if ((!this.c) && (!VideoFeedsPlayManager.a(this.this$0, paramVideoPlayerWrapper)))
      {
        VideoFeedsPlayManager.b(this.this$0, paramVideoPlayerWrapper);
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void b(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (paramVideoPlayParam.c.b == null) {
      return;
    }
    Object localObject1 = VideoFeedsPlayManager.d(this.this$0);
    if (localObject1 != null)
    {
      paramVideoPlayerWrapper.g = ((VideoPreDownloadMgr)localObject1).a(paramVideoPlayParam.c.b, paramVideoPlayParam.c.b);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("广告视频预下载: url:");
        ((StringBuilder)localObject2).append(paramVideoPlayParam.c.b);
        ((StringBuilder)localObject2).append(" ;isPreDownloadHit: ");
        ((StringBuilder)localObject2).append(paramVideoPlayerWrapper.g);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject2).toString());
      }
      ((VideoPreDownloadMgr)localObject1).a(paramVideoPlayParam.c.b, paramVideoPlayerWrapper.g);
    }
    localObject1 = null;
    if (paramVideoPlayParam.c.as != null) {
      localObject1 = paramVideoPlayParam.c.as.B;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (paramVideoPlayParam.c.b.startsWith("http")) {
        localObject2 = paramVideoPlayParam.c.b;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramVideoPlayerWrapper.c(true);
      paramVideoPlayerWrapper.a("", (String)localObject2, 101, paramLong, 0L, paramVideoPlayParam.c.e, true, false, paramVideoPlayParam.i);
      return;
    }
    paramVideoPlayerWrapper.c(false);
    c(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
  }
  
  private void c(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (VideoFeedsPlayManager.d(this.this$0) != null)
    {
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.d(this.this$0);
      paramVideoPlayerWrapper.g = localVideoPreDownloadMgr.a(null, paramVideoPlayParam.c.b);
      localVideoPreDownloadMgr.a(paramVideoPlayParam.c.b, paramVideoPlayerWrapper.g);
    }
    paramVideoPlayerWrapper.c(false);
    paramVideoPlayerWrapper.a(paramVideoPlayParam.c.b, 1, paramLong, paramVideoPlayParam.i);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    VideoPlayParam localVideoPlayParam = (VideoPlayParam)this.a.get();
    VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)this.b.get();
    if (!a(localVideoPlayParam, localVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "PlayStartVideoRunnable: checkVideoStatus error return");
      }
      return;
    }
    boolean bool2 = this.c;
    boolean bool1 = true;
    if (!bool2) {
      VideoFeedsPlayManager.a(this.this$0, true);
    }
    long l = localVideoPlayParam.j;
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.this$0;
    if (l <= 0L) {
      bool1 = false;
    }
    VideoFeedsPlayManager.f(localVideoFeedsPlayManager, bool1);
    a(localVideoPlayParam, localVideoPlayerWrapper, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */