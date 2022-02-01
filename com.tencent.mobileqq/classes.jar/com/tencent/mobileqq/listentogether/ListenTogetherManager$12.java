package com.tencent.mobileqq.listentogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Map;

class ListenTogetherManager$12
  implements DialogInterface.OnClickListener
{
  ListenTogetherManager$12(ListenTogetherManager paramListenTogetherManager, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.c.b();
      paramDialogInterface.dismiss();
      return;
    }
    if (paramInt == 0)
    {
      this.c.c();
      paramDialogInterface.dismiss();
      paramDialogInterface = this.c;
      ListenTogetherManager.b(paramDialogInterface, (ListenTogetherSession)ListenTogetherManager.b(paramDialogInterface).get(ListenTogetherUtils.a(this.a, this.b)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.12
 * JD-Core Version:    0.7.0.1
 */