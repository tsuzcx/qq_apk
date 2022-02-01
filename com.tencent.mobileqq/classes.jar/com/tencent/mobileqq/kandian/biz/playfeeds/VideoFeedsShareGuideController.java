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
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716000);
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
  private BubblePopupWindow jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private BitmapDrawable jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private RecentUser jdField_b_of_type_ComTencentMobileqqDataRecentUser;
  private boolean jdField_b_of_type_Boolean;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_c_of_type_Boolean;
  private Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_d_of_type_Boolean;
  private Animation e;
  
  public VideoFeedsShareGuideController(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, View paramView)
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsShareGuideController.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter;
    paramVideoFeedsRecommendPresenter = Aladdin.getConfig(419);
    this.jdField_a_of_type_Float = paramVideoFeedsRecommendPresenter.getFloatFromString("show_anim_percentage", 0.8F);
    this.jdField_b_of_type_Float = paramVideoFeedsRecommendPresenter.getFloatFromString("dismiss_anim_percentage", 1.0F);
    this.jdField_a_of_type_Int = (paramVideoFeedsRecommendPresenter.getIntegerFromString("is_short_video", 20) * 1000);
    if (paramVideoFeedsRecommendPresenter.getIntegerFromString("long_video_dismiss_anim_enable", 1) == 1) {
      bool = true;
    }
    this.jdField_d_of_type_Boolean = bool;
    paramBaseActivity = VideoFeedsHelper.a(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = VideoFeedsHelper.a(paramBaseActivity);
    this.jdField_b_of_type_ComTencentMobileqqDataRecentUser = VideoFeedsHelper.b(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
  }
  
  private Drawable a()
  {
    int i = VideoFeedsShareController.b();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130843310);
        }
        this.jdField_b_of_type_Int = 5;
        return VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130843309);
      }
      this.jdField_b_of_type_Int = 4;
      return VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130843311);
    }
    return b();
  }
  
  private Drawable b()
  {
    int i = Aladdin.getConfig(419).getIntegerFromString("qq_guide_icon", 1);
    this.jdField_b_of_type_Int = i;
    if (i != 1)
    {
      Object localObject;
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
          if (localObject != null) {
            return localObject;
          }
          localObject = this.jdField_b_of_type_ComTencentMobileqqDataRecentUser;
          if (localObject != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(113, ((RecentUser)localObject).uin);
            if (localObject != null)
            {
              localObject = new BitmapDrawable((Bitmap)localObject);
              this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)localObject);
              return localObject;
            }
          }
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
        if (localObject != null) {
          return localObject;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser;
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, ((RecentUser)localObject).uin);
          if (localObject != null)
          {
            localObject = new BitmapDrawable((Bitmap)localObject);
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)localObject);
            return localObject;
          }
        }
      }
      this.jdField_b_of_type_Int = 1;
      return VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130843310);
    }
    return VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130843310);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = this.jdField_c_of_type_AndroidViewAnimationAnimation;
      if ((localObject == null) || (((Animation)localObject).hasEnded()))
      {
        if (this.jdField_d_of_type_AndroidViewAnimationAnimation == null)
        {
          localObject = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject).setDuration(300L);
          this.jdField_d_of_type_AndroidViewAnimationAnimation = ((Animation)localObject);
        }
        if (this.jdField_c_of_type_AndroidViewAnimationAnimation == null)
        {
          localObject = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject).setDuration(300L);
          ((AlphaAnimation)localObject).setAnimationListener(new VideoFeedsShareGuideController.4(this));
          this.jdField_c_of_type_AndroidViewAnimationAnimation = ((Animation)localObject);
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          VideoFeedsHelper.b((TextView)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.v, "分享");
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow.dismiss();
    }
  }
  
  private boolean b()
  {
    long l = System.currentTimeMillis();
    Integer localInteger = Integer.valueOf(0);
    if (l - ((Integer)RIJSPUtils.a("CONFIG_LAST_SHOW_SHARE_GUIDE_DATE", localInteger)).intValue() > TimeUnit.DAYS.toMillis(1L)) {
      RIJSPUtils.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", localInteger);
    }
    int i = Aladdin.getConfig(419).getIntegerFromString("max_show_times", 0);
    if (((Integer)RIJSPUtils.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", localInteger)).intValue() < i)
    {
      RIJSPUtils.a("CONFIG_LAST_SHOW_SHARE_GUIDE_DATE", Long.valueOf(System.currentTimeMillis()));
      RIJSPUtils.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", localInteger);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject1 == null) {
      return;
    }
    ((ImageView)localObject1).setImageDrawable(a());
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
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
        this.jdField_a_of_type_AndroidViewAnimationAnimation = ((Animation)localObject2);
        localScaleAnimation.setAnimationListener(new VideoFeedsShareGuideController.2(this));
        this.jdField_b_of_type_AndroidViewAnimationAnimation = ((Animation)localObject1);
      }
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        if (this.e == null)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new VideoFeedsShareGuideController.3(this));
          this.e = ((Animation)localObject1);
        }
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.e);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText("分享");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
      if (localObject1 != null) {
        ((VideoFeedsRecommendPresenter)localObject1).a().a("0X800B943", this.jdField_b_of_type_Int);
      }
    }
  }
  
  private void d()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow.dismiss();
        return;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow = null;
        if (QLog.isColorLevel()) {
          QLog.e("VideoFeedsShareGuideController", 2, "handleMessage: ", localException);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    b(true);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    long l = this.jdField_a_of_type_Long;
    int k = 0;
    int i;
    if ((paramLong2 - l <= 800L) && (paramLong1 < 1000L)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (paramLong2 > this.jdField_a_of_type_Int)
    {
      j = k;
      if (this.jdField_d_of_type_Boolean) {
        j = 1;
      }
    }
    if ((j != 0) && ((f >= this.jdField_b_of_type_Float) || (i != 0))) {
      a();
    } else if (f >= this.jdField_a_of_type_Float) {
      a(true);
    }
    this.jdField_a_of_type_Long = paramLong1;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_a_of_type_AndroidViewView = paramVideoItemHolder.q;
    this.jdField_a_of_type_AndroidWidgetImageView = paramVideoItemHolder.n;
    Object localObject1 = paramVideoItemHolder.a;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = paramVideoItemHolder.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = ((VideoInfo)localObject1);
    localObject1 = localObject2;
    if ((paramVideoItemHolder instanceof TiktokVideoItemHolder)) {
      localObject1 = ((TiktokVideoItemHolder)paramVideoItemHolder).k();
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      if ((this.jdField_c_of_type_Boolean) && (!b()))
      {
        this.jdField_c_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      if (paramBoolean)
      {
        c();
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareGuideController
 * JD-Core Version:    0.7.0.1
 */