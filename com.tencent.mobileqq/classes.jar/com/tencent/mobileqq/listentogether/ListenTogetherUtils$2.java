package com.tencent.mobileqq.listentogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

final class ListenTogetherUtils$2
  implements DialogInterface.OnClickListener
{
  ListenTogetherUtils$2(BaseChatPie paramBaseChatPie, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 1)
    {
      if (ListenTogetherUtils.b(this.a, this.b, this.c)) {
        ListenTogetherUtils.a(this.a.aX(), this.b, this.c, 3, false, null);
      }
      paramDialogInterface.dismiss();
      if (this.b == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, "clk_joinframe_join", this.c);
      return;
    }
    if (paramInt == 0)
    {
      paramDialogInterface.dismiss();
      bool1 = bool2;
      if (this.b == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, "clk_joinframe_cancel", this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherUtils.2
 * JD-Core Version:    0.7.0.1
 */