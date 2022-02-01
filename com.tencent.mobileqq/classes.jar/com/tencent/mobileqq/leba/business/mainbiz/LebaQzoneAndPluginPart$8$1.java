package com.tencent.mobileqq.leba.business.mainbiz;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.widget.CustomWidgetUtil;

class LebaQzoneAndPluginPart$8$1
  implements Runnable
{
  LebaQzoneAndPluginPart$8$1(LebaQzoneAndPluginPart.8 param8, int paramInt) {}
  
  public void run()
  {
    if (this.a > 0)
    {
      if (this.b.this$0.c != null) {
        this.b.this$0.c.setVisibility(0);
      }
      CustomWidgetUtil.a(this.b.this$0.c, 9, this.a, 0);
      if (AppSetting.e) {
        AccessibilityUtil.a(this.b.this$0.w, HardCodeUtil.a(2131903960), Button.class.getName());
      }
    }
    else
    {
      if (this.b.this$0.c != null) {
        this.b.this$0.c.setVisibility(8);
      }
      if (AppSetting.e) {
        AccessibilityUtil.a(this.b.this$0.w, HardCodeUtil.a(2131916999), Button.class.getName());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8.1
 * JD-Core Version:    0.7.0.1
 */