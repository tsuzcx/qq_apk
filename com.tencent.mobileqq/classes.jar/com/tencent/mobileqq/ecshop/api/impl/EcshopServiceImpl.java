package com.tencent.mobileqq.ecshop.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.ecshop.api.IEcshopService;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class EcshopServiceImpl
  implements IEcshopService
{
  private static final String TAG = "EcshopServiceImpl";
  public static List<String> mDefaultPubList;
  private static List<String> mWalletGTKList;
  private static List<String> mWalletReportList = new ArrayList();
  private BaseQQAppInterface appInterface;
  private GdtAppReceiver mGdtAppReceiver;
  
  static
  {
    mWalletGTKList = new ArrayList();
    mDefaultPubList = new ArrayList();
    mDefaultPubList.add("3046055438");
    mDefaultPubList.add("2711679534");
  }
  
  public void enterGDTVideoActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString1, String paramString2, Activity paramActivity)
  {
    enterGDTVideoActivity(paramAdInfo, paramString1, ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).isReportForClick(paramString2), paramActivity);
  }
  
  public void enterGDTVideoActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString, boolean paramBoolean, Activity paramActivity)
  {
    try
    {
      paramAdInfo = new GdtAd(paramAdInfo);
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.jdField_c_of_type_Int = 1;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramAdInfo;
      localParams.jdField_a_of_type_Boolean = paramBoolean;
      localParams.jdField_b_of_type_Boolean = false;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.mGdtAppReceiver);
      localParams.jdField_c_of_type_Boolean = true;
      paramActivity = localParams.jdField_a_of_type_AndroidOsBundle;
      paramAdInfo = paramActivity;
      if (paramActivity == null) {
        paramAdInfo = new Bundle();
      }
      paramAdInfo.putString("big_brother_ref_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(paramString));
      localParams.jdField_a_of_type_AndroidOsBundle = paramAdInfo;
      GdtHandler.a(localParams);
      return;
    }
    catch (Throwable paramAdInfo)
    {
      paramString = new StringBuilder();
      paramString.append("enterGDTVideoActivity throw an exception: ");
      paramString.append(paramAdInfo);
      QLog.e("EcshopServiceImpl", 1, paramString.toString());
    }
  }
  
  public boolean enterGdtCanvasActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString1, String paramString2, Activity paramActivity)
  {
    return enterGdtCanvasActivity(paramAdInfo, paramString1, ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).isReportForClick(paramString2), paramActivity);
  }
  
  public boolean enterGdtCanvasActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString, boolean paramBoolean, Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        paramAdInfo = new GdtAd(paramAdInfo);
        if ("2711679534".equals(paramString)) {
          break label159;
        }
        if (!"3046055438".equals(paramString)) {
          break label153;
        }
      }
      catch (Exception paramAdInfo)
      {
        GdtHandler.Params localParams;
        return false;
      }
      localParams = new GdtHandler.Params();
      localParams.jdField_c_of_type_Int = 1;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramAdInfo;
      localParams.jdField_a_of_type_Boolean = paramBoolean;
      localParams.jdField_b_of_type_Boolean = bool;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.mGdtAppReceiver);
      paramActivity = localParams.jdField_a_of_type_AndroidOsBundle;
      paramAdInfo = paramActivity;
      if (paramActivity == null) {
        paramAdInfo = new Bundle();
      }
      paramAdInfo.putString("big_brother_ref_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(paramString));
      localParams.jdField_a_of_type_AndroidOsBundle = paramAdInfo;
      GdtHandler.a(localParams);
      return true;
      label153:
      boolean bool = true;
      continue;
      label159:
      bool = false;
    }
  }
  
  public boolean isInWalletGTKList(String paramString)
  {
    try
    {
      if (parseWalletConfigList("gdt_gtk_list", mWalletGTKList)) {}
      boolean bool;
      for (Object localObject = mWalletGTKList;; localObject = mDefaultPubList)
      {
        bool = ((List)localObject).contains(paramString);
        break;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isInWalletGTKList:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(",pUin:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("EcshopServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean isInWalletReportList(String paramString)
  {
    try
    {
      if (parseWalletConfigList("gdt_report_list", mWalletReportList)) {}
      boolean bool;
      for (Object localObject = mWalletReportList;; localObject = mDefaultPubList)
      {
        bool = ((List)localObject).contains(paramString);
        break;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isInWalletReportList:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(",pUin:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("EcshopServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appInterface = ((BaseQQAppInterface)paramAppRuntime);
    this.mGdtAppReceiver = new GdtAppReceiver();
    this.mGdtAppReceiver.register(MobileQQ.sMobileQQ);
  }
  
  public void onDestroy()
  {
    GdtAppReceiver localGdtAppReceiver = this.mGdtAppReceiver;
    if (localGdtAppReceiver != null) {
      localGdtAppReceiver.unregister(MobileQQ.sMobileQQ);
    }
  }
  
  public boolean parseWalletConfigList(String paramString, List<String> paramList)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    int i = 0;
    boolean bool2 = bool3;
    try
    {
      if (paramList.size() == 0)
      {
        bool2 = bool3;
        JSONArray localJSONArray = ((IQWalletConfigService)this.appInterface.getRuntimeService(IQWalletConfigService.class)).getArray("common", new String[] { "pub_ad_control", paramString });
        if (localJSONArray != null) {
          try
          {
            while (i < localJSONArray.length())
            {
              paramList.add(localJSONArray.optString(i));
              i += 1;
            }
            bool1 = true;
          }
          catch (Throwable paramString)
          {
            bool2 = true;
            break label195;
          }
        }
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          paramList = new StringBuilder();
          bool2 = bool1;
          paramList.append("parseWalletConfigList,key:");
          bool2 = bool1;
          paramList.append(paramString);
          bool2 = bool1;
          paramList.append(",jsonArray:");
          bool2 = bool1;
          paramList.append(localJSONArray);
          bool2 = bool1;
          QLog.i("EcshopServiceImpl", 2, paramList.toString());
          return bool1;
        }
      }
      else
      {
        return true;
      }
    }
    catch (Throwable paramString)
    {
      label195:
      paramString.printStackTrace();
      bool3 = bool2;
    }
    return bool3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.api.impl.EcshopServiceImpl
 * JD-Core Version:    0.7.0.1
 */