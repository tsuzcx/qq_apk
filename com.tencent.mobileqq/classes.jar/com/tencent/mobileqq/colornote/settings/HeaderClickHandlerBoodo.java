package com.tencent.mobileqq.colornote.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicJumpActivity.ComicParam;

public class HeaderClickHandlerBoodo
  implements IOnHeaderClickHandler
{
  public String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(2131690765);
  }
  
  public void a(View paramView, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = new Intent("android.intent.action.MAIN");
    paramView = paramView.getContext();
    localObject = VipComicJumpActivity.a((Intent)localObject);
    if (VipComicJumpActivity.a(localQQAppInterface, (Activity)paramView, (VipComicJumpActivity.ComicParam)localObject)) {
      VipComicJumpActivity.a(localQQAppInterface, true);
    }
    ReportController.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", ColorNoteUtils.b(paramInt), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HeaderClickHandlerBoodo
 * JD-Core Version:    0.7.0.1
 */