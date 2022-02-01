package com.tencent.mobileqq.kandian.biz.video;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLazyLoadDelegate;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.WeishiRedDotInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class WeishiVideoFeedsLazyLoadDelegate
  extends VideoFeedsLazyLoadDelegate
{
  private static final String jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131716398);
  private WeishiRedDotInfo a;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  public WeishiVideoFeedsLazyLoadDelegate(IVideoFeedsLoadDelegate.LifeCycleCallBack paramLifeCycleCallBack, Bundle paramBundle, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramLifeCycleCallBack, paramBundle, paramQQAppInterface, paramBaseActivity, paramString1, paramString2, paramString3, paramBoolean, paramInt);
  }
  
  private void a(WeishiRedDotInfo paramWeishiRedDotInfo)
  {
    if (paramWeishiRedDotInfo == null)
    {
      super.d();
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    int i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("VIDEO_SECOND_INDEX_INNER_ID");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("VIDEO_COMMON_DATA");
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("VALUE_COOKIE");
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    if (l1 == 0L) {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver, l1, a(), i, null, str1, l2, true, 0, str2, str3, paramWeishiRedDotInfo, 0, null, null, 0, null, 0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843324);
      return;
    }
    super.a(paramInt);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    b(paramVideoInfo);
    super.a(paramVideoInfo);
  }
  
  protected boolean a(Bundle paramBundle)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = ((VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO"));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)
      {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtra("VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g);
        RIJWeiShiLegacyUtils.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        return true;
      }
    }
    return super.a(paramBundle);
  }
  
  protected void b()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.k());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)DeviceInfoUtil.l());
    ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165327));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/kan/images/rij_wehishi_bg.png", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.a == null) {
        VideoFeedsHelper.a(paramVideoInfo);
      }
      long l = NetConnInfoCenter.getServerTime();
      RIJWeiShiLegacyUtils.a.a(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBrief(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVideoInfo.a), l);
    }
  }
  
  public void d()
  {
    if (!this.e)
    {
      this.e = true;
      ThreadManager.excute(new WeishiVideoFeedsLazyLoadDelegate.1(this), 32, null, true);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructWeishiRedDotInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.WeishiVideoFeedsLazyLoadDelegate
 * JD-Core Version:    0.7.0.1
 */