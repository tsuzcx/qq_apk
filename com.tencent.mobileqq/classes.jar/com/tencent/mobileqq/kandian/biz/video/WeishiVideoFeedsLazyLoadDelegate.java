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
  private static final String z = HardCodeUtil.a(2131913838);
  private WeishiRedDotInfo A;
  private boolean B = false;
  private boolean C = false;
  
  public WeishiVideoFeedsLazyLoadDelegate(IVideoFeedsLoadDelegate.LifeCycleCallBack paramLifeCycleCallBack, Bundle paramBundle, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramLifeCycleCallBack, paramBundle, paramQQAppInterface, paramBaseActivity, paramString1, paramString2, paramString3, paramBoolean, paramInt);
  }
  
  private void a(WeishiRedDotInfo paramWeishiRedDotInfo)
  {
    if (paramWeishiRedDotInfo == null)
    {
      super.f();
      return;
    }
    this.B = true;
    int i = this.r.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
    String str1 = this.r.getIntent().getStringExtra("VIDEO_SECOND_INDEX_INNER_ID");
    long l2 = this.r.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.r.getIntent().getStringExtra("VIDEO_COMMON_DATA");
    String str3 = this.r.getIntent().getStringExtra("VALUE_COOKIE");
    long l1 = this.r.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    if (l1 == 0L) {
      l1 = Long.parseLong(this.q.getCurrentAccountUin());
    }
    this.f.a(this.g, l1, g(), i, null, str1, l2, true, 0, str2, str3, paramWeishiRedDotInfo, 0, null, null, 0, null, 0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.setText(z);
      this.c.setImageResource(2130844278);
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
    if (this.B)
    {
      this.a = ((VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO"));
      if (this.a != null)
      {
        VideoFeedsHelper.a(this.a);
        this.r.getIntent().putExtra("VIDEO_ARTICLE_ID", this.a.l);
        RIJWeiShiLegacyUtils.a.a(this.r);
        return true;
      }
    }
    return super.a(paramBundle);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.aB == null) {
        VideoFeedsHelper.a(paramVideoInfo);
      }
      long l = NetConnInfoCenter.getServerTime();
      RIJWeiShiLegacyUtils.a.a(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBrief(this.q, paramVideoInfo.aB), l);
    }
  }
  
  protected void d()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.F());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)DeviceInfoUtil.G());
    ColorDrawable localColorDrawable = new ColorDrawable(this.r.getResources().getColor(2131165564));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/kan/images/rij_wehishi_bg.png", (URLDrawable.URLDrawableOptions)localObject);
    this.b.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void f()
  {
    if (!this.C)
    {
      this.C = true;
      ThreadManager.excute(new WeishiVideoFeedsLazyLoadDelegate.1(this), 32, null, true);
      return;
    }
    a(this.A);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.WeishiVideoFeedsLazyLoadDelegate
 * JD-Core Version:    0.7.0.1
 */