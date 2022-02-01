package com.tencent.open.appcommon.now.download.local;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DownloadNativeApi$1$2
  implements DialogInterface.OnClickListener
{
  DownloadNativeApi$1$2(DownloadNativeApi.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      DownloadNativeApi.a(this.a.this$0).onDownloadCancel(this.a.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1.2
 * JD-Core Version:    0.7.0.1
 */