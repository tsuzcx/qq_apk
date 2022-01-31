package com.tencent.mobileqq.troop.activity;

import ajya;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.widget.TextView;
import axqy;
import baxn;
import bbkb;
import com.tencent.biz.qqstory.view.widget.TipsView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tribe.view.TEditText;

class TroopBarPublishActivity$11
  implements Runnable
{
  TroopBarPublishActivity$11(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void run()
  {
    TroopBarPublishActivity localTroopBarPublishActivity = this.this$0;
    TEditText localTEditText = this.this$0.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
    String str = ajya.a(2131715226);
    int j = baxn.a(this.this$0, 71.0F);
    if (Build.VERSION.SDK_INT < 19)
    {
      i = baxn.a(this.this$0, 20.0F);
      TipsView.a(localTroopBarPublishActivity, localTEditText, str, 1, 1, j, i, baxn.a(this.this$0, 20.0F), 5000, Color.argb(204, 0, 0, 0));
      bbkb.b(this.this$0, this.this$0.app.getCurrentAccountUin(), "tribe_video_post_has_show_tips", true);
      if ((this.this$0.jdField_b_of_type_AndroidWidgetTextView == null) || (this.this$0.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label157;
      }
    }
    label157:
    for (int i = 2;; i = 1)
    {
      axqy.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_guide", i, 0, "", "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.11
 * JD-Core Version:    0.7.0.1
 */