package com.tencent.mobileqq.msgforward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import cooperation.weiyun.WeiyunAIOUtils;

class AIOShareActionSheet$7
  implements DialogInterface.OnClickListener
{
  AIOShareActionSheet$7(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (WeiyunAIOUtils.a(this.a.a, AIOShareActionSheet.b(this.a), AIOShareActionSheet.a(this.a).A(), this.a.c)) {
      AIOShareActionSheet.a(this.a).a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.7
 * JD-Core Version:    0.7.0.1
 */