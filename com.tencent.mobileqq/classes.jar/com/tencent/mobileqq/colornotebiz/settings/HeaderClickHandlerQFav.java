package com.tencent.mobileqq.colornotebiz.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.IOnHeaderClickHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;

public class HeaderClickHandlerQFav
  implements IOnHeaderClickHandler
{
  public String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(2131889221);
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    boolean bool2 = paramView instanceof BaseActivity;
    boolean bool1 = true;
    if (bool2) {
      bool1 = true ^ ((BaseActivity)paramView).isInMultiWindow();
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QfavHelper.a((Activity)paramView, localQQAppInterface.getAccount(), null, -1, bool1);
    QfavReport.b(localQQAppInterface, 6, 0);
    QfavUtil.a(localQQAppInterface.getCurrentAccountUin());
    ReportController.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 2, 0, "", "", "", "");
  }
  
  public int b()
  {
    return 17104896;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornotebiz.settings.HeaderClickHandlerQFav
 * JD-Core Version:    0.7.0.1
 */