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
  private long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  private IVideoFeedsVideoUIDelegate.CallBack jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate$CallBack = null;
  BaseVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  
  public VideoFeedsVideoUIDelegate(BaseVideoItemHolder paramBaseVideoItemHolder, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = paramBaseVideoItemHolder;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsVideoUIDelegate.1(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper)) {
      VideoFeedsHelper.a(paramTextView, (VideoPlayerWrapper)paramIVideoPlayerWrapper, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.d, paramVideoInfo.jdField_a_of_type_Int, null);
    }
  }
  
  private boolean a(VideoPlayParam paramVideoPlayParam)
  {
    if (!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) {
      return false;
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
    {
      if (!this.jdField_a_of_type_Boolean) {
        return false;
      }
      return this.g ^ true;
    }
    return false;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localObject instanceof ShortVideoItemHolder)) {
      localObject = (ShortVideoItemHolder)localObject;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((ShortVideoItemHolder)localObject).c != null) && ((((ShortVideoItemHolder)localObject).c.getDrawable() instanceof ReadInJoyLottieDrawable))) {
      ((ReadInJoyLottieDrawable)((ShortVideoItemHolder)localObject).c.getDrawable()).playAnimation();
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
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setVisibility(0);
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
              this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.clearAnimation();
              this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.getContext(), 2130843373));
              this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.clearAnimation();
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.getContext(), 2130843373));
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.clearAnimation();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.getContext(), 2130843372));
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
          if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.r.getVisibility() == 0) && (NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())))
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.r.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.t.setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.clearAnimation();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.getContext(), 2130843372));
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.getContext(), 2130843371));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.clearAnimation();
        paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        paramString.setDuration(500L);
        paramString.setRepeatCount(-1);
        paramString.setRepeatMode(1);
        paramString.setStartTime(-1L);
        paramString.setInterpolator(new LinearInterpolator());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.startAnimation(paramString);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g.getContext(), 2130843373));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  private void j(VideoPlayParam paramVideoPlayParam)
  {
    if (a(paramVideoPlayParam)) {
      a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    }
    a(4);
    if (paramVideoPlayParam.jdField_a_of_type_AndroidViewView != null) {
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if (this.e)
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a();
      long l2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.d();
      double d1 = (float)l1 * 100.0F / (float)l2;
      Double.isNaN(d1);
      int j = (int)(d1 + 0.5D) + 1;
      int i = j;
      if (j >= 100) {
        i = 100;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a.setProgress(i);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.b.setProgress(i);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.7(this, paramInt, paramString));
  }
  
  public void a(IVideoFeedsVideoUIDelegate.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate$CallBack = paramCallBack;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (this.b)
    {
      paramVideoInfo = HardCodeUtil.a(2131715996);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715892));
      ((StringBuilder)localObject).append(VideoFeedsHelper.b(paramVideoInfo.b));
      localObject = ((StringBuilder)localObject).toString();
      if (paramVideoInfo.b <= 0L) {
        paramVideoInfo = HardCodeUtil.a(2131715999);
      } else {
        paramVideoInfo = (VideoInfo)localObject;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.s;
    ((TextView)localObject).setText(paramVideoInfo);
    VideoFeedsHelper.a((View)localObject, 0);
    this.g = true;
    this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.8(this, (TextView)localObject), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    a(0);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131715967);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramVideoPlayParam));
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
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidViewView.setVisibility(0);
      paramVideoPlayParam = new AlphaAnimation(0.0F, 1.0F);
      paramVideoPlayParam.setDuration(300L);
      paramVideoPlayParam.setStartOffset(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidViewView.setAnimation(paramVideoPlayParam);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new VideoFeedsVideoUIDelegate.5(this));
      paramVideoPlayParam.setAnimationListener(new VideoFeedsVideoUIDelegate.6(this, localAlphaAnimation));
      paramVideoPlayParam.start();
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, long paramLong1, long paramLong2)
  {
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.q != null))
    {
      if (paramLong2 == 0L)
      {
        if (this.e)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a.setProgress(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.b.setProgress(0);
        }
      }
      else if (paramLong1 != 0L)
      {
        double d1 = (float)paramLong1 * 100.0F / (float)paramLong2;
        Double.isNaN(d1);
        int j = (int)(d1 + 0.5D) + 1;
        int i = j;
        if (j >= 100) {
          i = 100;
        }
        if (this.e)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a.setProgress(i);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.b.setProgress(i);
        }
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView, paramLong1);
      }
      if (paramLong2 > 0L) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.q, paramLong2);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.p, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    if ((!this.f) && (!paramVideoPlayParam.c)) {
      a(0, 0);
    }
    this.f = false;
    if (paramBoolean)
    {
      a(1);
      return;
    }
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-1, 1200L);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.f = true;
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.3(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.4(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
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
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void f(VideoPlayParam paramVideoPlayParam)
  {
    this.f = false;
  }
  
  public void g(VideoPlayParam paramVideoPlayParam)
  {
    a(1);
  }
  
  public void h(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.e()))
    {
      a(0);
      return;
    }
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.d.getVisibility() == 0))
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
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.d();
    if (l > 0L)
    {
      double d1 = paramInt;
      Double.isNaN(d1);
      d1 /= 100.0D;
      double d2 = l;
      Double.isNaN(d2);
      paramInt = (int)(d1 * d2);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView, paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = false;
    int i = paramSeekBar.getProgress();
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.d();
    if (l > 0L)
    {
      double d1 = i;
      Double.isNaN(d1);
      d1 /= 100.0D;
      double d2 = l;
      Double.isNaN(d2);
      i = (int)(d1 * d2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(i);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate$CallBack != null) && (paramSeekBar == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate$CallBack.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsVideoUIDelegate
 * JD-Core Version:    0.7.0.1
 */