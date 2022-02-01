package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class DownloadManager$17$1
  implements DialogInterface.OnClickListener
{
  DownloadManager$17$1(DownloadManager.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.putBoolean(DownloadConstants.s, false);
    DownloadApi.a(this.a.b, this.a.a, this.a.c, this.a.d, this.a.e);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.17.1
 * JD-Core Version:    0.7.0.1
 */