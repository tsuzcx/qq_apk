package com.tencent.open.appcommon.now.download.js;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadConstants;

class DownloadJSApi$2$1
  implements DialogInterface.OnClickListener
{
  DownloadJSApi$2$1(DownloadJSApi.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.putBoolean(DownloadConstants.s, false);
    DownloadJSApi.a(this.a.b, this.a.a, this.a.c, this.a.d, this.a.e);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi.2.1
 * JD-Core Version:    0.7.0.1
 */