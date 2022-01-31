import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.LightAppUtil.GetLightAppSettingListener;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qia
  implements BusinessObserver
{
  public qia(LightAppUtil paramLightAppUtil) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (!paramBoolean)
    {
      ToastUtil.a().a(2131427730);
      if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
    }
    do
    {
      return;
      if (paramBundle.getInt("cgiResultCode", -1) == 0) {
        break;
      }
      ToastUtil.a().a(2131427730);
    } while (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null);
    this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
    return;
    int j;
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        j = paramBundle.optInt("ret", -1);
        if (j != 0)
        {
          LogUtility.a("LightAppUtil", "GETLightAppSettingCallBack failed,resultCode=" + j);
          ToastUtil.a().a(2131427730);
          if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
            this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
          }
          if (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null) {
            break label920;
          }
          paramInt = this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
          label223:
          if (!this.a.c) {
            break label909;
          }
          SmartDeviceReport.a(this.a.jdField_a_of_type_MqqAppAppRuntime, "Net_Get_LiteappSetting", 0, j, paramInt);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      try
      {
        paramBundle = paramBundle.getJSONArray("list");
        if (((paramBundle != null) && (paramBundle.length() != 0)) || (!this.a.b)) {
          break label429;
        }
        ToastUtil.a().a(2131427730);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_AndroidAppActivity != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
          this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(true);
        }
        SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        ToastUtil.a().a(2131427730);
      }
      if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null)
      {
        this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
        continue;
        label429:
        if (paramBundle != null) {
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      if (paramInt < paramBundle.length())
      {
        Object localObject1 = paramBundle.getJSONObject(paramInt);
        LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
        localLightAppSettingInfo.jdField_c_of_type_Int = ((JSONObject)localObject1).optInt("pid");
        localLightAppSettingInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("template_type");
        localLightAppSettingInfo.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("has_own_app");
        localLightAppSettingInfo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("h5_url");
        localLightAppSettingInfo.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("public_url");
        localLightAppSettingInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_appid");
        localLightAppSettingInfo.jdField_d_of_type_Int = ((JSONObject)localObject1).optInt("device_type");
        localLightAppSettingInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_pkgname");
        localLightAppSettingInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("openid");
        localLightAppSettingInfo.f = ((JSONObject)localObject1).optString("openkey");
        localLightAppSettingInfo.g = ((JSONObject)localObject1).optString("appname");
        localLightAppSettingInfo.jdField_e_of_type_Int = ((JSONObject)localObject1).optInt("bindtype", 1);
        Object localObject2 = ((JSONObject)localObject1).optString("pub_propertyids");
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("config_list");
        localLightAppSettingInfo.jdField_a_of_type_JavaUtilHashMap = this.a.a(localJSONArray);
        localLightAppSettingInfo.h = ((JSONObject)localObject1).optString("comment");
        localObject1 = ((String)localObject2).split(",");
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            ((ArrayList)localObject2).add(Integer.valueOf(localObject1[i]));
            i += 1;
          }
          localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        }
        for (;;)
        {
          if (!LightAppUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int)))
          {
            LightAppUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int), localLightAppSettingInfo);
            LightAppUtil.jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
          }
          if ((!this.a.b) || (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId != localLightAppSettingInfo.jdField_c_of_type_Int)) {
            break;
          }
          this.a.a(this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo, this.a.jdField_a_of_type_AndroidOsBundle, this.a.d);
          break label925;
          LogUtility.e("LightAppUtil", "no ids!");
        }
        if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
          this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
        }
      }
      else
      {
        if ((this.a.c) || (LightAppUtil.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        paramBundle = BaseApplicationImpl.getApplication().getRuntime();
        if (!(paramBundle instanceof QQAppInterface)) {
          break;
        }
        ((SmartDeviceProxyMgr)((QQAppInterface)paramBundle).a(51)).a(LightAppUtil.jdField_a_of_type_JavaUtilArrayList);
        break;
        label909:
        SmartDeviceReport.a(null, "Net_Get_LiteappSetting", 0, j, paramInt);
        return;
        label920:
        paramInt = 0;
        break label223;
      }
      label925:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qia
 * JD-Core Version:    0.7.0.1
 */