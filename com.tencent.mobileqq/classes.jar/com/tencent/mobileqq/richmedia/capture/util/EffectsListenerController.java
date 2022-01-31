package com.tencent.mobileqq.richmedia.capture.util;

import agwr;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.richmedia.QIMShortVideoEntryDialog;
import com.tencent.mobileqq.activity.richmedia.subtitles.AnimDrawerFactory;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.ProviderViewListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;

public class EffectsListenerController
  implements DialogInterface.OnDismissListener, ProviderView.ProviderViewListener
{
  public static final int[] a;
  public View a;
  public AppInterface a;
  public QIMShortVideoEntryDialog a;
  public CaptureVideoFilterViewPager a;
  public EffectsCameraCaptureView a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 25, 43, 60, 78, 95 };
  }
  
  public EffectsListenerController(AppInterface paramAppInterface, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog = null;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366903));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager = ((CaptureVideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131368928));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (paramInt >= 0) && (paramInt <= 5))
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putInt("sv_beauty_level", paramInt).commit();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(jdField_a_of_type_ArrayOfInt[paramInt]);
      if (QLog.isColorLevel()) {
        QLog.d("sv_beauty_level", 2, "beauty level : " + jdField_a_of_type_ArrayOfInt[paramInt]);
      }
      CaptureReportUtil.b(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    SubtitleLayout localSubtitleLayout = (SubtitleLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369951);
    if (localSubtitleLayout != null)
    {
      SubtitleDataManager.a().c = AnimDrawerFactory.a(paramInt);
      if (paramInt == 0)
      {
        localSubtitleLayout.setAnimType(0, null, null, 0, 0);
        localSubtitleLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    localSubtitleLayout.setVisibility(0);
    localSubtitleLayout.setAnimType(paramInt, paramString, null, 0, 0);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.setCurrentItem(paramFilterCategoryItem);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFilter(paramFilterCategoryItem);
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800859F", "0X800859F", 1, 0, "", "", paramPtvTemplateInfo.id, "");
    if (paramPtvTemplateInfo.popup)
    {
      boolean bool = a(paramPtvTemplateInfo.androidopenurlheader);
      if (bool) {}
      for (String str = "1";; str = "0")
      {
        ReportController.b(null, "dc00898", "", "", "0X80085A0", "0X80085A0", 1, 0, str, "", "", "");
        if (!bool) {
          break;
        }
        a(paramPtvTemplateInfo.popupimgurl, paramPtvTemplateInfo.popupcontent, paramPtvTemplateInfo.popupbtn, paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl, paramPtvTemplateInfo.buttonbgcolor, 1, bool);
        return;
      }
      a(paramPtvTemplateInfo.popupimgurl, paramPtvTemplateInfo.popupcontent2, paramPtvTemplateInfo.popupbtn2, paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl, paramPtvTemplateInfo.buttonbgcolor, 1, bool);
      return;
    }
    a(paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl);
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString)
  {
    EffectsCameraCaptureView localEffectsCameraCaptureView;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null)
    {
      CapturePtvTemplateManager.a();
      if (RedBagVideoManager.a(CapturePtvTemplateManager.a))
      {
        localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
        if (paramPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) {
          break label53;
        }
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      localEffectsCameraCaptureView.e(bool);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
      return;
    }
  }
  
  void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_AndroidViewView.getContext() != null)) {}
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.jdField_a_of_type_AndroidViewView.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("EffectsListenerController", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    try
    {
      if (!StringUtil.a(paramString2)) {}
      for (paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2)); paramString1 != null; paramString1 = this.jdField_a_of_type_AndroidViewView.getContext().getPackageManager().getLaunchIntentForPackage(paramString1))
      {
        paramString1.addCategory("android.intent.category.DEFAULT");
        this.jdField_a_of_type_AndroidViewView.getContext().startActivity(paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("EffectsListenerController", 1, "TryJumpToQIM catch an Exception.", paramString1);
      new QQToastNotifier(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()).a("跳转失败。", 100, 0, 1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (a(paramString1))
    {
      a(paramString1, paramString2);
      return;
    }
    a(paramString3);
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog == null))
    {
      QIMShortVideoEntryDialog localQIMShortVideoEntryDialog = new QIMShortVideoEntryDialog(this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog = localQIMShortVideoEntryDialog;
      localQIMShortVideoEntryDialog.a(paramString1, paramString2, paramString3, paramString7);
      localQIMShortVideoEntryDialog.a(new agwr(this, paramInt, paramBoolean, paramString4, paramString5, paramString6));
      localQIMShortVideoEntryDialog.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog.setOnDismissListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog.show();
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog.getWindow().getAttributes();
      paramString1.width = -1;
      paramString1.height = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog.getWindow().setAttributes(paramString1);
    }
  }
  
  public boolean a(String paramString)
  {
    QLog.d("EffectsListenerController", 1, "start CheckJumpAPPisInstall appPackageName is " + paramString);
    if (StringUtil.a(paramString)) {}
    do
    {
      return false;
      try
      {
        paramString = this.jdField_a_of_type_AndroidViewView.getContext().getPackageManager().getPackageInfo(paramString, 1);
        if (paramString == null)
        {
          QLog.d("EffectsListenerController", 1, "CheckJumpAPPisInstall PackageInfo is null");
          return false;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("EffectsListenerController", 1, "CheckJumpAPPisInstall catch an Exception.", paramString);
        return false;
      }
      paramString = paramString.activities[0].name;
      QLog.d("EffectsListenerController", 1, "start CheckJumpAPPisInstall qqAppActivity is " + paramString);
    } while (paramString == null);
    return true;
  }
  
  public void b(FilterCategoryItem paramFilterCategoryItem)
  {
    if (paramFilterCategoryItem == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800859F", "0X800859F", 2, 0, "", "", paramFilterCategoryItem.a, "");
    if (paramFilterCategoryItem.b)
    {
      boolean bool = a(paramFilterCategoryItem.g);
      if (bool) {}
      for (String str = "1";; str = "0")
      {
        ReportController.b(null, "dc00898", "", "", "0X80085A0", "0X80085A0", 2, 0, str, "", "", "");
        if (!bool) {
          break;
        }
        a(paramFilterCategoryItem.k, paramFilterCategoryItem.l, paramFilterCategoryItem.m, paramFilterCategoryItem.g, paramFilterCategoryItem.h, paramFilterCategoryItem.i, paramFilterCategoryItem.p, 2, bool);
        return;
      }
      a(paramFilterCategoryItem.k, paramFilterCategoryItem.n, paramFilterCategoryItem.o, paramFilterCategoryItem.g, paramFilterCategoryItem.h, paramFilterCategoryItem.i, paramFilterCategoryItem.p, 2, bool);
      return;
    }
    a(paramFilterCategoryItem.g, paramFilterCategoryItem.h, paramFilterCategoryItem.i);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.EffectsListenerController
 * JD-Core Version:    0.7.0.1
 */