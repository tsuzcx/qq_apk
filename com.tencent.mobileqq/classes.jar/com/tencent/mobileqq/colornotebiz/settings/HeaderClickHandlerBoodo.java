package com.tencent.mobileqq.colornotebiz.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.settings.IOnHeaderClickHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class HeaderClickHandlerBoodo
  implements IOnHeaderClickHandler
{
  public int a()
  {
    return 16908292;
  }
  
  public String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(2131690693);
  }
  
  public void a(View paramView, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    paramView = paramView.getContext();
    ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).initPluginBeforeEnter(localQQAppInterface, (Activity)paramView, localIntent);
    ReportController.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).getHistoryType(paramInt), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornotebiz.settings.HeaderClickHandlerBoodo
 * JD-Core Version:    0.7.0.1
 */