package com.tencent.mobileqq.leba.business.mainbiz;

import android.text.TextUtils;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;

class LebaQzoneAndPluginPart$8$7
  implements Runnable
{
  LebaQzoneAndPluginPart$8$7(LebaQzoneAndPluginPart.8 param8, int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a != -1)
        {
          if (this.e.this$0.b != null) {
            this.e.this$0.b.setVisibility(0);
          }
          CustomWidgetUtil.a(this.e.this$0.b, this.a, this.b, 0);
          CustomWidgetUtil.a(this.e.b, this.e.this$0.b, this.a, this.e.this$0.k());
          if (this.e.this$0.d != null) {
            this.e.this$0.d.setVisibility(8);
          }
        }
        else if (this.e.this$0.b != null)
        {
          this.e.this$0.b.setVisibility(8);
        }
        if ((!TextUtils.isEmpty(this.c)) && (this.e.this$0.e != null))
        {
          this.e.this$0.e.setText(this.c);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.e.this$0.e.getLayoutParams();
          if (this.e.this$0.y == null) {
            break label403;
          }
          i = this.e.this$0.y.f();
          if (i > 1) {
            localMarginLayoutParams.rightMargin = ViewUtils.dpToPx(80.0F);
          } else if (i == 1) {
            localMarginLayoutParams.rightMargin = ViewUtils.dpToPx(48.0F);
          } else {
            localMarginLayoutParams.rightMargin = ViewUtils.dpToPx(8.0F);
          }
          this.e.this$0.e.setVisibility(0);
        }
        else
        {
          this.e.this$0.e.setVisibility(8);
        }
        if (this.d)
        {
          CustomWidgetUtil.a(this.e.this$0.f, 8, this.b, 0);
          this.e.this$0.f.setVisibility(0);
          return;
        }
        this.e.this$0.f.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateQZoneRedFlag");
        localStringBuilder.append(localException);
        QLog.e("Leba", 1, localStringBuilder.toString());
        return;
      }
      label403:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8.7
 * JD-Core Version:    0.7.0.1
 */