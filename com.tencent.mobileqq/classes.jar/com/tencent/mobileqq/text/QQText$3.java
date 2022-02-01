package com.tencent.mobileqq.text;

import agqd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import bcef;
import bfrj;
import bjnw;
import bjoe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class QQText$3
  implements bjoe
{
  QQText$3(QQText paramQQText, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, int paramInt2, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      ((ClipboardManager)this.val$context.getSystemService("clipboard")).setText(this.val$numberLink);
      bcef.b(this.val$app, "dc00898", "", "", "0X800A926", "0X800A926", this.val$reportFromType, 0, "", "", "", "");
      QQText.access$300("2", "1");
      continue;
      agqd.a(this.val$app, (Activity)this.val$context, (ChatMessage)this.val$msg, this.val$numberLink);
      bcef.b(this.val$app, "dc00898", "", "", "0X800A927", "0X800A927", this.val$reportFromType, 0, "", "", "", "");
      continue;
      if (this.val$isQQNumber == 2)
      {
        paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.val$numberLink)), this.val$context.getString(2131693561));
        paramView.putExtra("big_brother_source_key", QQText.access$500(this.this$0));
        this.val$context.startActivity(paramView);
        bcef.b(this.val$app, "dc00898", "", "", "0X800A92D", "0X800A92D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.val$numberLink));
        paramView.putExtra("big_brother_source_key", QQText.access$500(this.this$0));
        this.val$context.startActivity(paramView);
        bcef.b(this.val$app, "dc00898", "", "", "0X800A92A", "0X800A92A", this.val$reportFromType, 0, "", "", "", "");
        QQText.access$300("1", "2");
        continue;
        QQText.showAddContactsDialog(this.val$context, this.val$numberLink);
        bcef.b(this.val$app, "dc00898", "", "", "0X800A92B", "0X800A92B", this.val$reportFromType, 0, "", "", "", "");
        QQText.access$400("0X800A00A", "0X800A00A");
        continue;
        bfrj.a((Activity)this.val$context, this.val$app.getCurrentUin(), this.val$msg.frienduin, this.val$msg.istroop, this.val$numberLink);
        bcef.b(this.val$app, "dc00898", "", "", "0X800A92C", "0X800A92C", this.val$reportFromType, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.3
 * JD-Core Version:    0.7.0.1
 */