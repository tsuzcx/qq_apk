package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.discovery.BubblePopupWindow;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;

public class VideoFeedsShareGuideController
{
  private static final String a = HardCodeUtil.a(2131913452);
  private VideoInfo A;
  private Handler B;
  private BaseActivity b;
  private View c;
  private ImageView d;
  private TextView e;
  private BubblePopupWindow f;
  private Animation g;
  private Animation h;
  private Animation i;
  private Animation j;
  private Animation k;
  private VideoFeedsRecommendPresenter l;
  private IFaceDecoder m;
  private RecentUser n;
  private RecentUser o;
  private BitmapDrawable p;
  private BitmapDrawable q;
  private boolean r;
  private boolean s;
  private boolean t;
  private float u;
  private float v;
  private int w;
  private boolean x;
  private long y;
  private int z;
  
  public VideoFeedsShareGuideController(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, View paramView)
  {
    boolean bool = false;
    this.r = false;
    this.t = true;
    this.B = new VideoFeedsShareGuideController.1(this);
    this.b = paramBaseActivity;
    this.c = paramView;
    this.l = paramVideoFeedsRecommendPresenter;
    paramVideoFeedsRecommendPresenter = Aladdin.getConfig(419);
    this.u = paramVideoFeedsRecommendPresenter.getFloatFromString("show_anim_percentage", 0.8F);
    this.v = paramVideoFeedsRecommendPresenter.getFloatFromString("dismiss_anim_percentage", 1.0F);
    this.w = (paramVideoFeedsRecommendPresenter.getIntegerFromString("is_short_video", 20) * 1000);
    if (paramVideoFeedsRecommendPresenter.getIntegerFromString("long_video_dismiss_anim_enable", 1) == 1) {
      bool = true;
    }
    this.x = bool;
    paramBaseActivity = VideoFeedsHelper.a(paramQQAppInterface, paramBaseActivity);
    this.n = VideoFeedsHelper.a(paramBaseActivity);
    this.o = VideoFeedsHelper.b(paramBaseActivity);
    this.m = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = this.i;
      if ((localObject == null) || (((Animation)localObject).hasEnded()))
      {
        if (this.j == null)
        {
          localObject = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject).setDuration(300L);
          this.j = ((Animation)localObject);
        }
        if (this.i == null)
        {
          localObject = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject).setDuration(300L);
          ((AlphaAnimation)localObject).setAnimationListener(new VideoFeedsShareGuideController.4(this));
          this.i = ((Animation)localObject);
        }
        if (paramBoolean)
        {
          this.c.setVisibility(0);
          this.c.startAnimation(this.j);
        }
        this.d.startAnimation(this.i);
        localObject = this.e;
        if (localObject != null) {
          VideoFeedsHelper.b((TextView)localObject, this.A.aw, "分享");
        }
      }
    }
    localObject = this.f;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      this.f.dismiss();
    }
  }
  
  private boolean e()
  {
    long l1 = System.currentTimeMillis();
    Integer localInteger = Integer.valueOf(0);
    if (l1 - ((Integer)RIJSPUtils.b("CONFIG_LAST_SHOW_SHARE_GUIDE_DATE", localInteger)).intValue() > TimeUnit.DAYS.toMillis(1L)) {
      RIJSPUtils.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", localInteger);
    }
    int i1 = Aladdin.getConfig(419).getIntegerFromString("max_show_times", 0);
    if (((Integer)RIJSPUtils.b("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", localInteger)).intValue() < i1)
    {
      RIJSPUtils.a("CONFIG_LAST_SHOW_SHARE_GUIDE_DATE", Long.valueOf(System.currentTimeMillis()));
      RIJSPUtils.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", localInteger);
      return true;
    }
    return false;
  }
  
  private void f()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    ((ImageView)localObject1).setImageDrawable(g());
    if (this.d.getVisibility() == 8)
    {
      if (this.h == null)
      {
        localObject1 = new AnimationSet(false);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.1F, 0.0F, 1.1F, 1, 0.5F, 1, 0.5F);
        Object localObject2 = new AlphaAnimation(0.0F, 1.0F);
        localScaleAnimation.setDuration(300L);
        ((AlphaAnimation)localObject2).setDuration(300L);
        ((AnimationSet)localObject1).addAnimation(localScaleAnimation);
        ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
        localObject2 = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject2).setDuration(600L);
        ((ScaleAnimation)localObject2).setRepeatMode(2);
        ((ScaleAnimation)localObject2).setRepeatCount(10);
        this.g = ((Animation)localObject2);
        localScaleAnimation.setAnimationListener(new VideoFeedsShareGuideController.2(this));
        this.h = ((Animation)localObject1);
      }
      if (this.c.getVisibility() == 0)
      {
        if (this.k == null)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new VideoFeedsShareGuideController.3(this));
          this.k = ((Animation)localObject1);
        }
        this.c.startAnimation(this.k);
      }
      this.r = true;
      this.d.setVisibility(0);
      this.d.startAnimation(this.h);
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setText("分享");
      }
      localObject1 = this.l;
      if (localObject1 != null) {
        ((VideoFeedsRecommendPresenter)localObject1).f().a("0X800B943", this.z);
      }
    }
  }
  
  private Drawable g()
  {
    int i1 = VideoFeedsShareController.f();
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return VideoFeedsResourceLoader.a(this.b, 2130844264);
        }
        this.z = 5;
        return VideoFeedsResourceLoader.a(this.b, 2130844263);
      }
      this.z = 4;
      return VideoFeedsResourceLoader.a(this.b, 2130844265);
    }
    return h();
  }
  
  private Drawable h()
  {
    int i1 = Aladdin.getConfig(419).getIntegerFromString("qq_guide_icon", 1);
    this.z = i1;
    if (i1 != 1)
    {
      Object localObject;
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          localObject = this.q;
          if (localObject != null) {
            return localObject;
          }
          localObject = this.o;
          if (localObject != null)
          {
            localObject = this.m.getBitmapFromCache(113, ((RecentUser)localObject).uin);
            if (localObject != null)
            {
              localObject = new BitmapDrawable((Bitmap)localObject);
              this.q = ((BitmapDrawable)localObject);
              return localObject;
            }
          }
        }
      }
      else
      {
        localObject = this.p;
        if (localObject != null) {
          return localObject;
        }
        localObject = this.n;
        if (localObject != null)
        {
          localObject = this.m.getBitmapFromCache(1, ((RecentUser)localObject).uin);
          if (localObject != null)
          {
            localObject = new BitmapDrawable((Bitmap)localObject);
            this.p = ((BitmapDrawable)localObject);
            return localObject;
          }
        }
      }
      this.z = 1;
      return VideoFeedsResourceLoader.a(this.b, 2130844264);
    }
    return VideoFeedsResourceLoader.a(this.b, 2130844264);
  }
  
  private void i()
  {
    BubblePopupWindow localBubblePopupWindow = this.f;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      try
      {
        this.f.dismiss();
        return;
      }
      catch (Exception localException)
      {
        this.f = null;
        if (QLog.isColorLevel()) {
          QLog.e("VideoFeedsShareGuideController", 2, "handleMessage: ", localException);
        }
      }
    }
  }
  
  public void a()
  {
    b(true);
    this.B.removeMessages(0);
    this.B.removeMessages(1);
    this.r = false;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    long l1 = this.y;
    int i3 = 0;
    int i1;
    if ((paramLong2 - l1 <= 800L) && (paramLong1 < 1000L)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i3;
    if (paramLong2 > this.w)
    {
      i2 = i3;
      if (this.x) {
        i2 = 1;
      }
    }
    if ((i2 != 0) && ((f1 >= this.v) || (i1 != 0))) {
      a();
    } else if (f1 >= this.u) {
      a(true);
    }
    this.y = paramLong1;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.c = paramVideoItemHolder.aX;
    this.d = paramVideoItemHolder.aY;
    Object localObject1 = paramVideoItemHolder.az;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = paramVideoItemHolder.az.c;
    } else {
      localObject1 = null;
    }
    this.A = ((VideoInfo)localObject1);
    localObject1 = localObject2;
    if ((paramVideoItemHolder instanceof TiktokVideoItemHolder)) {
      localObject1 = ((TiktokVideoItemHolder)paramVideoItemHolder).K();
    }
    this.e = ((TextView)localObject1);
    this.s = false;
    this.y = 0L;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c != null)
    {
      if (this.s) {
        return;
      }
      if ((this.t) && (!e()))
      {
        this.t = false;
        return;
      }
      this.s = true;
      if (paramBoolean)
      {
        f();
        return;
      }
      this.B.sendEmptyMessageDelayed(0, 1000L);
    }
  }
  
  public boolean b()
  {
    return this.r;
  }
  
  public void c()
  {
    i();
    this.B.removeCallbacksAndMessages(null);
    this.c = null;
    this.b = null;
  }
  
  public int d()
  {
    return this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareGuideController
 * JD-Core Version:    0.7.0.1
 */