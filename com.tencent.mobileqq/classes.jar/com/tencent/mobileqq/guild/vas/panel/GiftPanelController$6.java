package com.tencent.mobileqq.guild.vas.panel;

import android.content.Context;
import android.widget.TextView;

class GiftPanelController$6
  implements Runnable
{
  GiftPanelController$6(GiftPanelController paramGiftPanelController, long paramLong, String paramString) {}
  
  public void run()
  {
    if (GiftPanelController.d(this.this$0) != null)
    {
      TextView localTextView = GiftPanelController.e(this.this$0);
      long l = this.a;
      if (l <= 0L) {
        str = GiftPanelController.d(this.this$0).getString(2131914245);
      } else {
        str = String.valueOf(l);
      }
      localTextView.setText(str);
    }
    String str = this.b;
    if ((str != null) && (str.length() > 0)) {
      GiftPanelController.a(this.this$0, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.panel.GiftPanelController.6
 * JD-Core Version:    0.7.0.1
 */