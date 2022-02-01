package com.tencent.mobileqq.profile;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class VipProfileCardPreviewActivity$2
  implements ViewPager.OnPageChangeListener
{
  boolean a = false;
  boolean b = false;
  
  VipProfileCardPreviewActivity$2(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageScrollStateChanged state = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      this.c.K.b();
      localObject = this.c;
      ((VipProfileCardPreviewActivity)localObject).a(((VipProfileCardPreviewActivity)localObject).ab);
      this.b = true;
    }
    if (paramInt == 2) {
      this.a = true;
    }
    if (paramInt == 0)
    {
      if (this.a)
      {
        localObject = this.c;
        ((VipProfileCardPreviewActivity)localObject).b(((VipProfileCardPreviewActivity)localObject).ab);
        this.a = false;
        this.c.K.a();
      }
      if (this.b)
      {
        this.c.K.a();
        this.b = false;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled pos = ");
      localStringBuilder.append(paramInt1);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, localStringBuilder.toString());
    }
    this.c.K.b();
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected pos = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.c.K.a();
    this.c.d(paramInt);
    Object localObject = this.c;
    ((VipProfileCardPreviewActivity)localObject).ab = paramInt;
    ReportController.b(((VipProfileCardPreviewActivity)localObject).app, "CliOper", "", "", "card_mall", "0X8004C26", 0, 0, "", "", "", VipUtils.a(this.c.app, this.c.app.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */