package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.utils.QQGiftImageUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class DefaultBannerView
  extends BaseBannerView
{
  private RoundImageView l;
  private RoundImageView m;
  
  public DefaultBannerView(Context paramContext, BannerResManager paramBannerResManager)
  {
    super(paramContext, paramBannerResManager);
  }
  
  protected void a()
  {
    super.a();
    this.l = ((RoundImageView)findViewById(2131434930));
    this.m = ((RoundImageView)findViewById(2131434927));
    this.l.setmRadius(ImmersiveUtils.dpToPx(20.0F), false);
    this.m.setmRadius(ImmersiveUtils.dpToPx(14.0F), false);
  }
  
  public void a(GiftAnimData paramGiftAnimData, String paramString)
  {
    super.a(paramGiftAnimData, paramString);
    if (!TextUtils.isEmpty(paramGiftAnimData.k))
    {
      paramString = QQGiftImageUtil.a(paramGiftAnimData.k, null, null);
      this.l.setImageDrawable(paramString);
    }
    if (!TextUtils.isEmpty(paramGiftAnimData.l))
    {
      paramGiftAnimData = QQGiftImageUtil.a(paramGiftAnimData.l, null, null);
      this.m.setImageDrawable(paramGiftAnimData);
    }
  }
  
  int c()
  {
    return 2131627976;
  }
  
  public void d()
  {
    super.d();
    QLog.i("Gift_Banner_DBannerView", 1, "onHitStart");
    if (this.g != null) {
      this.g.c(this.f);
    }
  }
  
  public void e()
  {
    QLog.i("Gift_Banner_DBannerView", 1, "onHitEnd");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.DefaultBannerView
 * JD-Core Version:    0.7.0.1
 */