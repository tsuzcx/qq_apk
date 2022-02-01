package com.tencent.mobileqq.troop.honor;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;

final class TroopHonorAIOUtils$3
  implements View.OnTouchListener
{
  long jdField_a_of_type_Long = 0L;
  
  TroopHonorAIOUtils$3(boolean paramBoolean, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) || (!(paramView instanceof ImageView))) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof MutualMarkForDisplayInfo))) {}
    for (paramMotionEvent = (MutualMarkForDisplayInfo)paramView.getTag();; paramMotionEvent = null)
    {
      switch (i)
      {
      }
      for (;;)
      {
        return true;
        if (paramMotionEvent != null)
        {
          paramView.setAlpha(paramMotionEvent.a() * 0.5F);
        }
        else
        {
          paramView.setAlpha(0.5F);
          continue;
          if (paramMotionEvent != null) {
            paramView.setAlpha(paramMotionEvent.a());
          }
          while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 800L)
          {
            return true;
            paramView.setAlpha(1.0F);
          }
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          if ((paramMotionEvent == null) || (TextUtils.isEmpty(paramMotionEvent.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if (paramMotionEvent.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131699394)))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "AIO_Luckyword_clk", 0, 0, "", "", "", "");
            paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            paramView.putExtra("url", "https://qun.qq.com/v2/luckyword/index?qunid={GROUPCODE}&_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=enter".replace("{GROUPCODE}", this.jdField_a_of_type_JavaLangString));
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800A852", "0X800A852", 0, 0, "" + paramMotionEvent.jdField_a_of_type_Long, "", "", "");
            paramView = TroopLinkManager.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            paramMotionEvent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            paramMotionEvent.putExtra("url", paramView);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramMotionEvent);
            continue;
            if (paramMotionEvent != null) {
              paramView.setAlpha(paramMotionEvent.a());
            } else {
              paramView.setAlpha(1.0F);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils.3
 * JD-Core Version:    0.7.0.1
 */