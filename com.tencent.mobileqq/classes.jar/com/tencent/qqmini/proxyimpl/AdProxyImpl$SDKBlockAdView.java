package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class AdProxyImpl$SDKBlockAdView
  extends AdProxy.AbsBlockAdView
{
  int jdField_a_of_type_Int = 53;
  BlockAdInfo jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo;
  BlockAdView jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView;
  AdProxy.IBlockAdListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  
  public AdProxyImpl$SDKBlockAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, int paramInt6, int paramInt7, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IBlockAdListener paramIBlockAdListener)
  {
    super(paramAdProxyImpl);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener = paramIBlockAdListener;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt6;
    this.jdField_c_of_type_Int = paramInt7;
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.d = paramString5;
    this.e = paramString6;
    this.f = paramString7;
    this.g = paramString8;
    this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo = new BlockAdInfo(paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void clearBlockAdAnimation(AdProxy.AbsBlockAdView paramAbsBlockAdView)
  {
    if (paramAbsBlockAdView != null)
    {
      if (!(paramAbsBlockAdView.getView() instanceof BlockAdView)) {
        return;
      }
      ((BlockAdView)paramAbsBlockAdView.getView()).clearBlockAdAnimation();
    }
  }
  
  public void destroy(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener = null;
    this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView = null;
  }
  
  public ArrayList<String> getReportUrl()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public View getView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView;
  }
  
  public void loadAD()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadAD, act is null, ");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.e("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener;
      if (localObject != null) {
        ((AdProxy.IBlockAdListener)localObject).onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    BlockAdManager.getInstance().initActivitySize((Activity)localObject);
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl.requestAdInfo((Context)localObject, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getAdUnitId(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString, this.d, this.e, this.f, this.g, this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getSize(), new AdProxyImpl.SDKBlockAdView.1(this, (Activity)localObject));
  }
  
  public void showBlockAdAnimation(AdProxy.AbsBlockAdView paramAbsBlockAdView)
  {
    if (paramAbsBlockAdView != null)
    {
      if (!(paramAbsBlockAdView.getView() instanceof BlockAdView)) {
        return;
      }
      ((BlockAdView)paramAbsBlockAdView.getView()).startBlockAnimation();
    }
  }
  
  public View updateAdInfo(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView == null) {
        return null;
      }
      ((BlockAdInfo)localObject).setLeft(paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.setTop(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView.setData(this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView.getRealAdNum() == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener;
        if (localObject != null)
        {
          ((AdProxy.IBlockAdListener)localObject).onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
          return null;
        }
      }
      return this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBlockAdView
 * JD-Core Version:    0.7.0.1
 */