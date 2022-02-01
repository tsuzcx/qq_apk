package com.tencent.qzonehub.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import cooperation.qzone.QZoneHelper;

final class QzonePluginProxyActivityProxyImpl$1
  implements DialogInterface.OnClickListener
{
  QzonePluginProxyActivityProxyImpl$1(Context paramContext, int paramInt, String paramString, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!QZoneHelper.forwardQZoneApp(this.a, this.b, Long.valueOf(this.c).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
      QZoneHelper.forwardH5QZone(this.d.getStringExtra("sid"), this.a);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */