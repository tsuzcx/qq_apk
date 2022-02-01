package com.tencent.open.wadl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;

class WadlJsBridgeCallBack$2$1
  implements DialogInterface.OnClickListener
{
  WadlJsBridgeCallBack$2$1(WadlJsBridgeCallBack.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.h = 1;
    WadlProxyServiceUtil.a().b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack.2.1
 * JD-Core Version:    0.7.0.1
 */