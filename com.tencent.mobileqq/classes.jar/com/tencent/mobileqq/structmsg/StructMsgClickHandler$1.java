package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class StructMsgClickHandler$1
  implements ActionSheet.OnButtonClickListener
{
  StructMsgClickHandler$1(String paramString, Context paramContext) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        ((ClipboardManager)this.b.getSystemService("clipboard")).setText(this.a);
      }
    }
    else
    {
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.a);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      this.b.startActivity(paramView);
    }
    StructMsgClickHandler.a().dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgClickHandler.1
 * JD-Core Version:    0.7.0.1
 */