package com.tencent.qzonehub.api.impl;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper.StartActivity;
import mqq.os.MqqHandler;

final class QzonePluginProxyActivityProxyImpl$4
  implements QZoneHelper.StartActivity
{
  QzonePluginProxyActivityProxyImpl$4(Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, int paramInt, boolean paramBoolean, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivityProxyImpl.getActivityNameToIntent(this.jdField_a_of_type_AndroidContentIntent);
    Class localClass = QzonePluginProxyActivityProxyImpl.PluginProxyActivityClassFactory.a(str);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("click_time", System.currentTimeMillis());
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
    localPluginParams.jdField_e_of_type_JavaLangString = "QZone";
    localPluginParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
    localPluginParams.jdField_f_of_type_JavaLangString = str;
    localPluginParams.jdField_a_of_type_JavaLangClass = localClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidContentIntent;
    localPluginParams.c = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Boolean)
    {
      localPluginParams.jdField_e_of_type_Int = 2130772147;
      localPluginParams.jdField_f_of_type_Int = 2130772147;
    }
    localPluginParams.d = 60000;
    localPluginParams.g = null;
    localPluginParams.jdField_b_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new QzonePluginProxyActivityProxyImpl.4.1(this, str, paramBoolean1, paramBoolean2, localPluginParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */