package com.tencent.mobileqq.intervideo.od;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.GetLoginKeyListener;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ODProxy
  implements ILoginKeyHelper.GetLoginKeyListener, Manager
{
  AppInterface a;
  
  public ODProxy(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public void a() {}
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XProxy|ODPROXY", 2, "onDestroy");
    }
    a();
    this.a = null;
  }
  
  public void onGetKeyComplete(String paramString, boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODProxy
 * JD-Core Version:    0.7.0.1
 */