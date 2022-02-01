package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ForwardSdkBaseOption$2
  implements DialogInterface.OnClickListener
{
  ForwardSdkBaseOption$2(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "handleSDForImageShare dismiss Exception:", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.2
 * JD-Core Version:    0.7.0.1
 */