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
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManagerHotPicPageView", 2, "onReceive ===>" + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      HotPicPageView.b = true;
    }
    label49:
    do
    {
      do
      {
        do
        {
          do
          {
            break label49;
            break label49;
            do
            {
              return;
            } while ("android.intent.action.SCREEN_ON".equals(paramContext));
            if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
            {
              HotPicPageView.b = true;
              return;
            }
          } while (("tencent.av.v2q.StopVideoChat".equals(paramContext)) || (!paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")));
          paramContext = paramIntent.getStringExtra("reason");
          if (paramContext != null) {
            break;
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a == null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a.a != 3));
        paramContext = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a.a();
      } while (paramContext == null);
      paramContext.d();
      return;
    } while (!paramContext.equals("homekey"));
    HotPicPageView.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.2
 * JD-Core Version:    0.7.0.1
 */