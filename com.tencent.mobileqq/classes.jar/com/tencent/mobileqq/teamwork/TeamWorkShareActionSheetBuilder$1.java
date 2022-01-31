package com.tencent.mobileqq.teamwork;

import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import badq;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class TeamWorkShareActionSheetBuilder$1
  implements Runnable
{
  public TeamWorkShareActionSheetBuilder$1(badq parambadq, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (RelativeLayout.LayoutParams)badq.a(this.this$0).getLayoutParams();
    int j = badq.a(this.this$0).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - 80 - badq.a(this.this$0).getWidth() - badq.b(this.this$0).getWidth();
    if (badq.c(this.this$0).getPaint().measureText(this.a + this.b) > j)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= this.a.length()) || (badq.c(this.this$0).getPaint().measureText(this.a.substring(0, i) + badq.a(this.this$0).getString(2131690331) + this.b) > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.a.substring(0, i - 1);
          badq.c(this.this$0).setText(this.b + (String)localObject + badq.a(this.this$0).getString(2131690331));
          return;
        }
        i += 1;
      }
      badq.c(this.this$0).setText(this.b + this.a.substring(0) + badq.a(this.this$0).getString(2131690331));
      return;
    }
    localObject = this.b + this.a;
    badq.c(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */