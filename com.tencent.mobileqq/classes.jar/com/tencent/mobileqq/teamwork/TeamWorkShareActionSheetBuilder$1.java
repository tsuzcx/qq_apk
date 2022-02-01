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
    Object localObject1 = (RelativeLayout.LayoutParams)TeamWorkShareActionSheetBuilder.a(this.this$0).getLayoutParams();
    int i = TeamWorkShareActionSheetBuilder.a(this.this$0).getWidth();
    int j = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
    int k = TeamWorkShareActionSheetBuilder.a(this.this$0).getWidth();
    int m = TeamWorkShareActionSheetBuilder.b(this.this$0).getWidth();
    localObject1 = TeamWorkShareActionSheetBuilder.c(this.this$0).getPaint();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(this.b);
    float f1 = ((TextPaint)localObject1).measureText(((StringBuilder)localObject2).toString());
    float f2 = i - j - 80 - k - m;
    if (f1 > f2)
    {
      i = 0;
      while (i < this.a.length())
      {
        localObject1 = TeamWorkShareActionSheetBuilder.c(this.this$0).getPaint();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.a.substring(0, i));
        ((StringBuilder)localObject2).append(TeamWorkShareActionSheetBuilder.a(this.this$0).getString(2131690218));
        ((StringBuilder)localObject2).append(this.b);
        if (((TextPaint)localObject1).measureText(((StringBuilder)localObject2).toString()) > f2) {
          break;
        }
        i += 1;
      }
      if (i != 0)
      {
        localObject1 = this.a.substring(0, i - 1);
        localObject2 = TeamWorkShareActionSheetBuilder.c(this.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(TeamWorkShareActionSheetBuilder.a(this.this$0).getString(2131690218));
        ((TextView)localObject2).setText(localStringBuilder.toString());
        return;
      }
      localObject1 = TeamWorkShareActionSheetBuilder.c(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(this.a.substring(0));
      ((StringBuilder)localObject2).append(TeamWorkShareActionSheetBuilder.a(this.this$0).getString(2131690218));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(this.a);
    localObject1 = ((StringBuilder)localObject1).toString();
    TeamWorkShareActionSheetBuilder.c(this.this$0).setText((CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */