package com.tencent.mobileqq.qwallet.hb.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.File;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class HbThemeConfigApiImpl
  implements IHbThemeConfigApi
{
  private static final String HB_THEME_CONFIG_FILE_NAME = "hbThemeConfig.cfg";
  private static final String KEY_FACE_CONFIG = "hb_face";
  private static final String QB_TENPAY_SHARE_FACE = "qb_tenpay_share_face";
  private static final String TAG = "HbThemeConfigApi";
  private static String mConfigCache;
  private static byte[] mLock = new byte[0];
  private JSONObject configFace = null;
  
  private String getSaveDir(AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public String getConfigCache()
  {
    return mConfigCache;
  }
  
  public JSONObject getFaceConfig(Context paramContext)
  {
    if (this.configFace == null)
    {
      paramContext = paramContext.getSharedPreferences("qb_tenpay_share_face", 0).getString("hb_face", "");
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
      try
      {
        this.configFace = new JSONObject(paramContext);
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return this.configFace;
  }
  
  public void onDestory()
  {
    this.configFace = null;
  }
  
  public void setConfigCache(String paramString)
  {
    mConfigCache = paramString;
  }
  
  public void updateConfig(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramAppInterface.getCurrentAccountUin())))
    {
      ThreadManager.post(new HbThemeConfigApiImpl.2(this, paramString, paramAppInterface), 5, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigApi", 2, "update hbTheme config, but AppInterface is null or account is empty return. ");
    }
  }
  
  public void updateFaceConfig(AppInterface paramAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigApi", 2, "updateFaceConfig failed : config = null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFaceConfig config = ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("HbThemeConfigApi", 2, localStringBuilder.toString());
    }
    paramAppInterface = new HbThemeConfigApiImpl.1(this, paramAppInterface.getApp(), paramJSONObject, paramAppInterface);
    ThreadManager.getFileThreadHandler().post(paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.HbThemeConfigApiImpl
 * JD-Core Version:    0.7.0.1
 */