package com.tencent.mobileqq.hotpic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$2
  extends BroadcastReceiver
{
  private final String jdField_a_of_type_JavaLangString = "reason";
  private final String b = "homekey";
  
  HotPicPageView$2(HotPicPageView paramHotPicPageView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive ===>");
      localStringBuilder.append(paramContext);
      QLog.d("HotPicManagerHotPicPageView", 2, localStringBuilder.toString());
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      HotPicPageView.b = true;
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext)) {
      return;
    }
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      HotPicPageView.b = true;
      return;
    }
    if ("tencent.av.v2q.StopVideoChat".equals(paramContext)) {
      return;
    }
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext == null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a.a == 3))
        {
          paramContext = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a.a();
          if (paramContext != null) {
            paramContext.d();
          }
        }
        return;
      }
      if (paramContext.equals("homekey")) {
        HotPicPageView.b = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.2
 * JD-Core Version:    0.7.0.1
 */