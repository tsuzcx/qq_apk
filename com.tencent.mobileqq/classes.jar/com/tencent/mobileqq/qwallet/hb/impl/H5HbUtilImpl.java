package com.tencent.mobileqq.qwallet.hb.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.pluginshare.ITenCookie;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class H5HbUtilImpl
  implements IH5HbUtil
{
  private static final String TAG = "H5HbUtil";
  
  private JSONObject filterUinByNickName(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject != null)
    {
      localJSONObject = paramJSONObject.optJSONObject("send_object");
      String str = localJSONObject.optString("lucky_uin");
      localJSONObject.remove("lucky_uin");
      if (!StringUtil.a(str)) {
        localJSONObject.put("lucky_name", ((IComIPCUtils)QRoute.api(IComIPCUtils.class)).getFriendNickName(str));
      }
      paramJSONObject.remove("send_object");
      paramJSONObject.put("send_object", localJSONObject);
      return paramJSONObject;
    }
    return localJSONObject;
  }
  
  private void getHbDetail(AppInterface paramAppInterface, String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramAppInterface = new Bundle();
      paramAppInterface.putString("extra_data", paramString);
      paramAppInterface.putString("callbackSn", "0");
      paramString = new Bundle();
      paramString.putInt("PayInvokerId", 22);
      Parcel localParcel = Parcel.obtain();
      paramResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramString.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
      paramString.putBundle("_qwallet_payparams_data", paramAppInterface);
      paramString.putString("_qwallet_payparams_tag", "redgiftH5CommonDetail");
      QWalletPayBridge.launchBackground(MobileQQ.sMobileQQ, paramString);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  private String getPreCode(String paramString)
  {
    String str;
    if (paramString.contains("pre_code="))
    {
      str = paramString.substring(paramString.indexOf("pre_code="));
      paramString = str;
      if (str.contains("&")) {
        paramString = str.substring(0, str.indexOf("&"));
      }
      str = paramString;
      if (paramString.contains("=")) {
        return paramString.split("=")[1];
      }
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  public JSONObject getExtraDataForGrapH5CommonHbResult(AppInterface paramAppInterface, JSONObject paramJSONObject)
  {
    String str4 = paramJSONObject.optString("listid");
    String str1 = paramJSONObject.optString("uin");
    if ((!StringUtil.a(str1)) && (str1.equals(paramAppInterface.getCurrentAccountUin())) && (!StringUtil.a(str4)))
    {
      String str2 = paramJSONObject.optString("feedsid");
      String str3 = paramJSONObject.optString("token");
      paramAppInterface = new StringBuilder();
      paramAppInterface.append(str4);
      paramAppInterface.append("_");
      paramAppInterface.append(getPreCode(str3));
      str4 = paramAppInterface.toString();
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("cache key: ");
        paramAppInterface.append(str4);
        QLog.i("H5HbUtil", 2, paramAppInterface.toString());
      }
      paramJSONObject = ((ITenCookie)QRoute.api(ITenCookie.class)).getTempArgs(str4);
      paramAppInterface = paramJSONObject;
      if (StringUtil.a(paramJSONObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5HbUtil", 2, "get cache from disk");
        }
        paramAppInterface = SharedPreferencesProxyManager.getInstance();
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("qb_tenpay_h5_common_hb_");
        paramJSONObject.append(str1);
        paramAppInterface = paramAppInterface.getProxy(paramJSONObject.toString(), 4);
        paramAppInterface = ((ITenCookie)QRoute.api(ITenCookie.class)).getEncryptValue(str1, str4, paramAppInterface);
      }
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("paramForGarpH5CommonHb:");
        paramJSONObject.append(paramAppInterface);
        QLog.d("H5HbUtil", 2, paramJSONObject.toString());
      }
      if (!TextUtils.isEmpty(paramAppInterface))
      {
        paramAppInterface = new JSONObject(paramAppInterface);
        paramAppInterface.put("feedsid", str2);
        paramAppInterface.put("uin", str1);
        paramAppInterface.put("token", str3);
        paramAppInterface.put("viewTag", "grapH5CommonHb");
        return paramAppInterface;
      }
    }
    return null;
  }
  
  public void getGrapH5CommonHbResult(AppInterface paramAppInterface, String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramAppInterface == null) {
      return;
    }
    paramAppInterface = new Bundle();
    paramAppInterface.putString("extra_data", paramString);
    paramAppInterface.putString("callbackSn", "0");
    paramString = new Bundle();
    paramString.putInt("PayInvokerId", 22);
    Parcel localParcel = Parcel.obtain();
    paramResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    paramString.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
    paramString.putBundle("_qwallet_payparams_data", paramAppInterface);
    paramString.putString("_qwallet_payparams_tag", "grapH5CommonHb");
    QWalletPayBridge.launchBackground(MobileQQ.sMobileQQ, paramString);
  }
  
  public JSONObject getGrapHbResult(int paramInt, Bundle paramBundle, Activity paramActivity)
  {
    if (paramInt == 0) {}
    try
    {
      Object localObject = paramBundle.getString("grapH5CommonHbResult");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool)
      {
        paramBundle = new JSONObject((String)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("grapH5Json: ");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.i("H5HbUtil", 2, ((StringBuilder)localObject).toString());
        }
        if (paramBundle.optJSONObject("hb_data") != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("viewTag", "showHbDetail");
          ((JSONObject)localObject).put("extra_data", paramBundle.optJSONObject("hb_data"));
          paramBundle = new Bundle();
          paramBundle.putString("json", ((JSONObject)localObject).toString());
          paramBundle.putString("callbackSn", "0");
          PayBridgeActivity.tenpay(paramActivity, 5, paramBundle, null);
          return null;
        }
        paramActivity = filterUinByNickName(paramBundle.optJSONObject("detail"));
        paramBundle.remove("detail");
        paramBundle.put("detail_data", paramActivity);
      }
      else
      {
        paramActivity = new JSONObject();
        paramBundle = paramBundle.getString("detail");
        if (!TextUtils.isEmpty(paramBundle))
        {
          paramBundle = filterUinByNickName(new JSONObject(paramBundle));
          paramBundle.remove("retcode");
          paramBundle.remove("retmsg");
          paramActivity.put("detail_data", paramBundle);
        }
        paramActivity.put("retcode", 0);
        paramActivity.put("retmsg", "ok");
        paramBundle = paramActivity;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      return null;
    }
    paramActivity = new JSONObject();
    try
    {
      paramBundle = paramBundle.getString("retmsg");
      if (!TextUtils.isEmpty(paramBundle)) {
        paramActivity.put("retmsg", new JSONObject(paramBundle).optString("err_msg"));
      } else {
        paramActivity.put("retmsg", "error when grap hb");
      }
      paramActivity.put("retcode", paramInt);
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return paramActivity;
    return paramBundle;
  }
  
  public void getHbDetailInfo(AppInterface paramAppInterface, JSONObject paramJSONObject, String paramString, ResultReceiver paramResultReceiver)
  {
    Object localObject = paramJSONObject.optString("listid");
    String str1 = paramJSONObject.optString("uin");
    String str2 = paramJSONObject.optString("offset");
    String str3 = paramJSONObject.optString("limit");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(paramAppInterface.getCurrentAccountUin())) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("listid", localObject);
      paramJSONObject.put("uin", str1);
      paramJSONObject.put("offset", str2);
      paramJSONObject.put("limit", str3);
      localObject = ((ITenCookie)QRoute.api(ITenCookie.class)).getTempArgs((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        paramJSONObject.put("authkey", ((JSONObject)localObject).optString("authkey"));
        paramJSONObject.put("grouptype", ((JSONObject)localObject).optString("grouptype"));
        paramJSONObject.put("groupid", ((JSONObject)localObject).optString("groupid"));
      }
      paramJSONObject.put("viewTag", paramString);
      getHbDetail(paramAppInterface, paramJSONObject.toString(), paramResultReceiver);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("notifyViewUpdate extstr = ");
      paramAppInterface.append(paramJSONObject);
      QLog.d("H5HbUtil", 2, paramAppInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.H5HbUtilImpl
 * JD-Core Version:    0.7.0.1
 */