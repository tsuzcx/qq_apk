package com.tencent.open.appstore.dl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadConstants;

class DownloadManagerV2$19$1
  implements DialogInterface.OnClickListener
{
  DownloadManagerV2$19$1(DownloadManagerV2.19 param19) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.putBoolean(DownloadConstants.s, false);
    DownloadProxy.a().a(this.a.b, this.a.a, this.a.c, this.a.d, this.a.e);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.19.1
 * JD-Core Version:    0.7.0.1
 */