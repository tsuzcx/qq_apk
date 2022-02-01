package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate.CallBack;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsVideoUIDelegate
  implements SeekBar.OnSeekBarChangeListener, IVideoFeedsVideoUIDelegate
{
  BaseVideoItemHolder a;
  Handler b;
  VideoFeedsPlayManager c;
  boolean d;
  private boolean e;
  private boolean f = true;
  private boolean g;
  private long h = 0L;
  private boolean i = true;
  private boolean j = false;
  private IVideoFeedsVideoUIDelegate.CallBack k = null;
  private boolean l = false;
  
  public VideoFeedsVideoUIDelegate(BaseVideoItemHolder paramBaseVideoItemHolder, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.c = paramVideoFeedsPlayManager;
    this.a = paramBaseVideoItemHolder;
    this.a.ai.setOnSeekBarChangeListener(this);
    this.e = paramBoolean;
    this.b = new VideoFeedsVideoUIDelegate.1(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.a.ao == null) {
      return;
    }
    VideoFeedsHelper.b(this.a.ao, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper)) {
      VideoFeedsHelper.a(paramTextView, (VideoPlayerWrapper)paramIVideoPlayerWrapper, paramVideoInfo.b, paramVideoInfo.l, paramVideoInfo.e, paramVideoInfo.a, null);
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt, 500);
  }
  
  private void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("innerChangePlayButton() what = ");
      paramString.append(paramInt);
      QLog.d("VideoFeedsVideoUIDelegate", 2, paramString.toString());
    }
    this.f = false;
    this.a.ad.clearAnimation();
    this.a.ad.setVisibility(0);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                return;
              }
              this.a.ad.clearAnimation();
              this.a.ad.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.a.ad.getContext(), 2130844327));
              this.a.ae.setVisibility(8);
              return;
            }
            this.a.ad.clearAnimation();
            this.a.ad.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.a.ad.getContext(), 2130844327));
            this.a.ae.setVisibility(0);
            return;
          }
          this.a.ad.clearAnimation();
          this.a.ad.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.a.ad.getContext(), 2130844326));
          this.a.ae.setVisibility(8);
          if ((this.a.aq.getVisibility() == 0) && (NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())))
          {
            this.a.ad.setVisibility(0);
            this.a.aq.setVisibility(8);
            this.a.as.setVisibility(8);
          }
        }
        else
        {
          this.a.ad.clearAnimation();
          this.a.ad.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.a.ad.getContext(), 2130844326));
          this.a.ae.setVisibility(0);
        }
      }
      else
      {
        this.a.ad.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.a.ad.getContext(), 2130844325));
        this.a.ad.clearAnimation();
        paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        paramString.setDuration(500L);
        paramString.setRepeatCount(-1);
        paramString.setRepeatMode(1);
        paramString.setStartTime(-1L);
        paramString.setInterpolator(new LinearInterpolator());
        this.a.ad.startAnimation(paramString);
        this.a.ae.setVisibility(0);
      }
    }
    else
    {
      this.a.ad.clearAnimation();
      this.a.ad.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.a.ad.getContext(), 2130844327));
      this.a.ae.setVisibility(0);
    }
  }
  
  private void d()
  {
    Object localObject = this.a;
    if ((localObject instanceof ShortVideoItemHolder)) {
      localObject = (ShortVideoItemHolder)localObject;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((ShortVideoItemHolder)localObject).j != null) && ((((ShortVideoItemHolder)localObject).j.getDrawable() instanceof ReadInJoyLottieDrawable))) {
      ((ReadInJoyLottieDrawable)((ShortVideoItemHolder)localObject).j.getDrawable()).playAnimation();
    }
  }
  
  private void j(VideoPlayParam paramVideoPlayParam)
  {
    if (k(paramVideoPlayParam)) {
      a(paramVideoPlayParam.c);
    }
    a(4);
    if (paramVideoPlayParam.b != null) {
      paramVideoPlayParam.b.setVisibility(0);
    }
    d();
  }
  
  private boolean k(VideoPlayParam paramVideoPlayParam)
  {
    if (!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) {
      return false;
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null))
    {
      if (!this.d) {
        return false;
      }
      return this.l ^ true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.i)
    {
      long l1 = this.c.b();
      long l2 = this.c.t();
      double d1 = (float)l1 * 100.0F / (float)l2;
      Double.isNaN(d1);
      int n = (int)(d1 + 0.5D) + 1;
      int m = n;
      if (n >= 100) {
        m = 100;
      }
      this.a.ai.setProgress(m);
      this.a.aj.setProgress(m);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.f = false;
    this.b.post(new VideoFeedsVideoUIDelegate.7(this, paramInt, paramString));
  }
  
  public void a(IVideoFeedsVideoUIDelegate.CallBack paramCallBack)
  {
    this.k = paramCallBack;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (this.e)
    {
      paramVideoInfo = HardCodeUtil.a(2131913448);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913348));
      ((StringBuilder)localObject).append(VideoFeedsHelper.c(paramVideoInfo.n));
      localObject = ((StringBuilder)localObject).toString();
      if (paramVideoInfo.n <= 0L) {
        paramVideoInfo = HardCodeUtil.a(2131913451);
      } else {
        paramVideoInfo = (VideoInfo)localObject;
      }
    }
    Object localObject = this.a.ar;
    ((TextView)localObject).setText(paramVideoInfo);
    VideoFeedsHelper.a((View)localObject, 0);
    this.l = true;
    this.b.postAtTime(new VideoFeedsVideoUIDelegate.8(this, (TextView)localObject), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    a(0);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131913421);
    }
    this.b.post(new VideoFeedsVideoUIDelegate.2(this, str, paramVideoPlayParam));
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt > 300) {
        paramInt -= 300;
      } else {
        paramInt = 0;
      }
      this.a.aw.setVisibility(0);
      paramVideoPlayParam = new AlphaAnimation(0.0F, 1.0F);
      paramVideoPlayParam.setDuration(300L);
      paramVideoPlayParam.setStartOffset(paramInt);
      this.a.aw.setAnimation(paramVideoPlayParam);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new VideoFeedsVideoUIDelegate.5(this));
      paramVideoPlayParam.setAnimationListener(new VideoFeedsVideoUIDelegate.6(this, localAlphaAnimation));
      paramVideoPlayParam.start();
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, long paramLong1, long paramLong2)
  {
    if ((paramVideoPlayParam != null) && (this.a.ai != null) && (this.a.ak != null) && (this.a.am != null))
    {
      if (paramLong2 == 0L)
      {
        if (this.i)
        {
          this.a.ai.setProgress(0);
          this.a.aj.setProgress(0);
        }
      }
      else if (paramLong1 != 0L)
      {
        double d1 = (float)paramLong1 * 100.0F / (float)paramLong2;
        Double.isNaN(d1);
        int n = (int)(d1 + 0.5D) + 1;
        int m = n;
        if (n >= 100) {
          m = 100;
        }
        if (this.i)
        {
          this.a.ai.setProgress(m);
          this.a.aj.setProgress(m);
        }
        VideoFeedsHelper.a(this.a.ak, paramLong1);
      }
      if (paramLong2 > 0L) {
        VideoFeedsHelper.a(this.a.am, paramLong2);
      }
      a(this.a.al, paramVideoPlayParam.c, paramVideoPlayParam.h);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    this.b.removeMessages(-1);
    if ((!this.j) && (!paramVideoPlayParam.n)) {
      a(0, 0);
    }
    this.j = false;
    if (paramBoolean)
    {
      a(1);
      return;
    }
    this.f = true;
    this.b.sendEmptyMessageDelayed(-1, 1200L);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.j = true;
      this.b.post(new VideoFeedsVideoUIDelegate.3(this));
      return;
    }
    this.b.post(new VideoFeedsVideoUIDelegate.4(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b(VideoPlayParam paramVideoPlayParam) {}
  
  public void b(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j(paramVideoPlayParam);
      a(8, 0);
      return;
    }
    a(paramVideoPlayParam, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public long c()
  {
    return this.h;
  }
  
  public void c(VideoPlayParam paramVideoPlayParam)
  {
    j(paramVideoPlayParam);
  }
  
  public void d(VideoPlayParam paramVideoPlayParam)
  {
    a(0);
  }
  
  public void e(VideoPlayParam paramVideoPlayParam)
  {
    b(8);
    if ((paramVideoPlayParam != null) && (this.a.af.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void f(VideoPlayParam paramVideoPlayParam)
  {
    this.j = false;
  }
  
  public void g(VideoPlayParam paramVideoPlayParam)
  {
    a(1);
  }
  
  public void h(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.h != null) && (paramVideoPlayParam.h.m()))
    {
      a(0);
      return;
    }
    if ((paramVideoPlayParam != null) && (this.a.af.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void i(VideoPlayParam paramVideoPlayParam)
  {
    a(0, 0);
    a(0);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.h = System.currentTimeMillis();
    long l1 = this.c.t();
    if (l1 > 0L)
    {
      double d1 = paramInt;
      Double.isNaN(d1);
      d1 /= 100.0D;
      double d2 = l1;
      Double.isNaN(d2);
      paramInt = (int)(d1 * d2);
      VideoFeedsHelper.a(this.a.ak, paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.g = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.g = false;
    int m = paramSeekBar.getProgress();
    long l1 = this.c.t();
    if (l1 > 0L)
    {
      double d1 = m;
      Double.isNaN(d1);
      d1 /= 100.0D;
      double d2 = l1;
      Double.isNaN(d2);
      m = (int)(d1 * d2);
      this.c.a(m);
    }
    if ((this.k != null) && (paramSeekBar == this.a.ai)) {
      this.k.p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsVideoUIDelegate
 * JD-Core Version:    0.7.0.1
 */