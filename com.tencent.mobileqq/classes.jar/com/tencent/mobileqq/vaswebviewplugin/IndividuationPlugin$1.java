package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

class IndividuationPlugin$1
  implements View.OnClickListener
{
  IndividuationPlugin$1(IndividuationPlugin paramIndividuationPlugin) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.this$0.mActivity, QQBrowserActivity.class);
    paramView.putExtra("hide_left_button", false);
    paramView.putExtra("show_right_close_button", false);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mActivity, IndividuationUrlHelper.a("myFont"), 67108864L, paramView, false, -1);
    ReportController.b(null, "CliOper", "", "", "font_switch", "clk_swtich", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin.1
 * JD-Core Version:    0.7.0.1
 */