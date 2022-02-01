package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$SDKBlockAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKBlockAdView$1(AdProxyImpl.SDKBlockAdView paramSDKBlockAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener != null) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    int i;
    String str2;
    label272:
    label278:
    label482:
    do
    {
      do
      {
        String str1;
        int k;
        do
        {
          return;
          for (;;)
          {
            try
            {
              for (;;)
              {
                i = paramJSONObject.getInt("retCode");
                str2 = paramJSONObject.getString("errMsg");
                str1 = paramJSONObject.getString("response");
                StringBuilder localStringBuilder = new StringBuilder().append("getBlockADInfo receive retCode= ").append(i).append(" adJson=");
                if ((str1 == null) || (str1.length() <= 1024)) {
                  break label272;
                }
                paramJSONObject = str1.substring(0, 1024);
                QLog.i("AdProxyImpl", 1, paramJSONObject);
                if (i != 0) {
                  break label482;
                }
                paramBoolean = TextUtils.isEmpty(str1);
                if (paramBoolean) {
                  break label482;
                }
                try
                {
                  if (new JSONObject(str1).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) == 0) {
                    break label278;
                  }
                  if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
                  return;
                }
                catch (Throwable paramJSONObject)
                {
                  QLog.e("AdProxyImpl", 1, "check adsJson exception:", paramJSONObject);
                }
              }
              if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
              return;
            }
            catch (JSONException paramJSONObject)
            {
              QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
            }
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
            return;
            paramJSONObject = str1;
          }
          paramJSONObject = AdUtils.convertJson2GdtAds(str1);
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.setAdMiniAppInfo(paramJSONObject);
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_JavaUtilArrayList = BlockAdManager.getInstance().getReportUrlList(paramJSONObject);
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView = BlockAdManager.getInstance().genarateBlockAdView(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo);
          i = this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView.getRealAdNum();
          j = this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getRealWidth();
          k = this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getRealHeight();
          if (i >= 1) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null);
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
        return;
        if (paramJSONObject != null)
        {
          if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener != null) {
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onADReceive(i, j, k);
          }
          AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, str1, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.b);
          return;
        }
      } while (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null);
      this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
    } while (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null);
    int j = PluginConst.AdConst.getRetCodeByServerResult(i);
    if (j != -1) {
      i = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBlockAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(i, str2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBlockAdView.1
 * JD-Core Version:    0.7.0.1
 */