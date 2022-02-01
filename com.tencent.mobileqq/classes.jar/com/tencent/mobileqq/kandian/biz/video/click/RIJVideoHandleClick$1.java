package com.tencent.mobileqq.kandian.biz.video.click;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RIJVideoHandleClick$1
  implements DialogInterface.OnClickListener
{
  @TargetApi(11)
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("article", this.jdField_a_of_type_JavaLangString));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.1
 * JD-Core Version:    0.7.0.1
 */