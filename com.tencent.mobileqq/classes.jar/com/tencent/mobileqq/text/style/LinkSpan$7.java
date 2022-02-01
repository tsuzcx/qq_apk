package com.tencent.mobileqq.text.style;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class LinkSpan$7
  implements ActionSheet.OnButtonClickListener
{
  LinkSpan$7(int paramInt, String paramString1, Context paramContext, String paramString2, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              AddFriendActivity.startActivity(this.c, true, this.b, true);
              LinkSpan.a("4", "1");
            }
          }
          else
          {
            AddFriendActivity.startActivity(this.c, false, this.b, true);
            LinkSpan.a("3", "1");
          }
        }
        else
        {
          LinkSpan.a(this.c, this.b);
          LinkSpan.b("0X800A00A", "0X800A00A");
        }
      }
      else
      {
        ((ClipboardManager)this.c.getSystemService("clipboard")).setText(this.b);
        LinkSpan.a("2", "1");
      }
    }
    else if (this.a == 2)
    {
      paramView = new StringBuilder();
      paramView.append("mailto:");
      paramView.append(this.b);
      paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(paramView.toString())), this.c.getString(2131891477));
      paramView.putExtra("big_brother_source_key", this.d);
      this.c.startActivity(paramView);
    }
    else
    {
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.b);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      paramView.putExtra("big_brother_source_key", this.d);
      this.c.startActivity(paramView);
      LinkSpan.a("1", "2");
    }
    this.e.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan.7
 * JD-Core Version:    0.7.0.1
 */