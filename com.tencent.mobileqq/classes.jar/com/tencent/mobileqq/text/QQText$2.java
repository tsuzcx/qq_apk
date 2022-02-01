package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import bkzi;
import bkzq;
import com.tencent.mobileqq.activity.AddFriendActivity;

final class QQText$2
  implements bkzq
{
  QQText$2(int paramInt, String paramString1, Context paramContext, String paramString2, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      if (this.val$isQQNumber == 2)
      {
        paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.val$numberLink)), this.val$context.getString(2131693745));
        paramView.putExtra("big_brother_source_key", this.val$bizSrc);
        this.val$context.startActivity(paramView);
      }
      else
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.val$numberLink));
        paramView.putExtra("big_brother_source_key", this.val$bizSrc);
        this.val$context.startActivity(paramView);
        QQText.access$300("1", "2");
        continue;
        ((ClipboardManager)this.val$context.getSystemService("clipboard")).setText(this.val$numberLink);
        QQText.access$300("2", "1");
        continue;
        QQText.showAddContactsDialog(this.val$context, this.val$numberLink);
        QQText.access$400("0X800A00A", "0X800A00A");
        continue;
        AddFriendActivity.a(this.val$context, false, this.val$numberLink, true);
        QQText.access$300("3", "1");
        continue;
        AddFriendActivity.a(this.val$context, true, this.val$numberLink, true);
        QQText.access$300("4", "1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.2
 * JD-Core Version:    0.7.0.1
 */