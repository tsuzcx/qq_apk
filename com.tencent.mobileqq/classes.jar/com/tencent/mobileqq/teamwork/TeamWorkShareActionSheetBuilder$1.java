package com.tencent.mobileqq.teamwork;

import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class TeamWorkShareActionSheetBuilder$1
  implements Runnable
{
  TeamWorkShareActionSheetBuilder$1(TeamWorkShareActionSheetBuilder paramTeamWorkShareActionSheetBuilder, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (RelativeLayout.LayoutParams)TeamWorkShareActionSheetBuilder.a(this.this$0).getLayoutParams();
    int j = TeamWorkShareActionSheetBuilder.a(this.this$0).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - 80 - TeamWorkShareActionSheetBuilder.a(this.this$0).getWidth() - TeamWorkShareActionSheetBuilder.b(this.this$0).getWidth();
    if (TeamWorkShareActionSheetBuilder.c(this.this$0).getPaint().measureText(this.a + this.b) > j)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= this.a.length()) || (TeamWorkShareActionSheetBuilder.c(this.this$0).getPaint().measureText(this.a.substring(0, i) + TeamWorkShareActionSheetBuilder.a(this.this$0).getString(2131690300) + this.b) > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.a.substring(0, i - 1);
          TeamWorkShareActionSheetBuilder.c(this.this$0).setText(this.b + (String)localObject + TeamWorkShareActionSheetBuilder.a(this.this$0).getString(2131690300));
          return;
        }
        i += 1;
      }
      TeamWorkShareActionSheetBuilder.c(this.this$0).setText(this.b + this.a.substring(0) + TeamWorkShareActionSheetBuilder.a(this.this$0).getString(2131690300));
      return;
    }
    localObject = this.b + this.a;
    TeamWorkShareActionSheetBuilder.c(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */