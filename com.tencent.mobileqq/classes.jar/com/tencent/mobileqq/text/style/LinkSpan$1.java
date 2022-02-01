package com.tencent.mobileqq.text.style;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class LinkSpan$1
  implements ActionSheet.OnButtonClickListener
{
  LinkSpan$1(LinkSpan paramLinkSpan, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, int paramInt2, ActionSheet paramActionSheet) {}
  
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
              ProfileCardUtil.a((Activity)this.a, this.c.getCurrentUin(), this.e.frienduin, this.e.istroop, this.b);
              ReportController.b(this.c, "dc00898", "", "", "0X800A92C", "0X800A92C", this.d, 0, "", "", "", "");
            }
          }
          else
          {
            LinkSpan.a(this.a, this.b);
            ReportController.b(this.c, "dc00898", "", "", "0X800A92B", "0X800A92B", this.d, 0, "", "", "", "");
            LinkSpan.b("0X800A00A", "0X800A00A");
          }
        }
        else if (this.f == 2)
        {
          paramView = new StringBuilder();
          paramView.append("mailto:");
          paramView.append(this.b);
          paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(paramView.toString())), this.a.getString(2131891477));
          paramView.putExtra("big_brother_source_key", LinkSpan.a(this.h));
          this.a.startActivity(paramView);
          ReportController.b(this.c, "dc00898", "", "", "0X800A92D", "0X800A92D", 0, 0, "", "", "", "");
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("tel:");
          paramView.append(this.b);
          paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
          paramView.putExtra("big_brother_source_key", LinkSpan.a(this.h));
          this.a.startActivity(paramView);
          ReportController.b(this.c, "dc00898", "", "", "0X800A92A", "0X800A92A", this.d, 0, "", "", "", "");
          LinkSpan.a("1", "2");
        }
      }
      else
      {
        TextItemBuilder.a(this.c, (Activity)this.a, (ChatMessage)this.e, this.b);
        ReportController.b(this.c, "dc00898", "", "", "0X800A927", "0X800A927", this.d, 0, "", "", "", "");
      }
    }
    else
    {
      ((ClipboardManager)this.a.getSystemService("clipboard")).setText(this.b);
      ReportController.b(this.c, "dc00898", "", "", "0X800A926", "0X800A926", this.d, 0, "", "", "", "");
      LinkSpan.a("2", "1");
    }
    this.g.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan.1
 * JD-Core Version:    0.7.0.1
 */