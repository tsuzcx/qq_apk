package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import android.view.WindowManager;
import java.util.ArrayList;

public class UECPageStayController
{
  public static boolean a = false;
  private UECPageStayViewer b;
  private WindowManager c;
  private boolean d = false;
  
  public static UECPageStayController a()
  {
    return UECPageStayController.SingletonInstance.a();
  }
  
  public void a(ArrayList<QQStayTimeInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    if (a)
    {
      UECPageStayViewer localUECPageStayViewer = this.b;
      if (localUECPageStayViewer != null) {
        localUECPageStayViewer.a(paramArrayList);
      }
    }
  }
  
  public void b()
  {
    if (this.d) {
      this.c.removeViewImmediate(this.b);
    }
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayController
 * JD-Core Version:    0.7.0.1
 */