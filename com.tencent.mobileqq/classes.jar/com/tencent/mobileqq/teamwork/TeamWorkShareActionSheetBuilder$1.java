package com.tencent.mobileqq.teamwork;

import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import beby;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class TeamWorkShareActionSheetBuilder$1
  implements Runnable
{
  public TeamWorkShareActionSheetBuilder$1(beby parambeby, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (RelativeLayout.LayoutParams)beby.a(this.this$0).getLayoutParams();
    int j = beby.a(this.this$0).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - 80 - beby.a(this.this$0).getWidth() - beby.b(this.this$0).getWidth();
    if (beby.c(this.this$0).getPaint().measureText(this.a + this.b) > j)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= this.a.length()) || (beby.c(this.this$0).getPaint().measureText(this.a.substring(0, i) + beby.a(this.this$0).getString(2131690173) + this.b) > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.a.substring(0, i - 1);
          beby.c(this.this$0).setText(this.b + (String)localObject + beby.a(this.this$0).getString(2131690173));
          return;
        }
        i += 1;
      }
      beby.c(this.this$0).setText(this.b + this.a.substring(0) + beby.a(this.this$0).getString(2131690173));
      return;
    }
    localObject = this.b + this.a;
    beby.c(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */