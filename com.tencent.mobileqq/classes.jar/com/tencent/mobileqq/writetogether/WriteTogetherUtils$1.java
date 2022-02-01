package com.tencent.mobileqq.writetogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class WriteTogetherUtils$1
  implements DialogInterface.OnClickListener
{
  WriteTogetherUtils$1(WriteTogetherUtils.OnDialogConfirmButtonClickListener paramOnDialogConfirmButtonClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
    WriteTogetherUtils.a().edit().putBoolean(WTConstants.b, false).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.WriteTogetherUtils.1
 * JD-Core Version:    0.7.0.1
 */