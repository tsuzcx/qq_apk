package com.tencent.mobileqq.leba.business.mainbiz;

import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class LebaQzoneAndPluginPart$8$3
  implements Runnable
{
  LebaQzoneAndPluginPart$8$3(LebaQzoneAndPluginPart.8 param8, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (this.c.this$0.d != null)
      {
        this.c.this$0.d.setVisibility(0);
        this.c.this$0.d.setText(this.a);
      }
      if (this.c.this$0.b != null) {
        this.c.this$0.b.setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      if ((this.c.this$0.g != null) && (this.c.this$0.y != null)) {
        this.c.this$0.y.a(localArrayList);
      }
      if (this.c.this$0.w != null)
      {
        AccessibilityUtil.a(this.c.this$0.w, HardCodeUtil.a(2131903958));
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateQZoneRedFlag");
      localStringBuilder.append(localException);
      QLog.e("Leba", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8.3
 * JD-Core Version:    0.7.0.1
 */