package com.tencent.mobileqq.intervideo.now;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.IBaseApplicationImplUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class NowGeneralConfigManager
  implements Manager
{
  private AppInterface a;
  
  public NowGeneralConfigManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public void a(String paramString)
  {
    boolean bool = StringUtil.isEmpty(paramString);
    int j = 0;
    if (bool)
    {
      paramString = ((IBaseApplicationImplUtil)QRoute.api(IBaseApplicationImplUtil.class)).getContext().getSharedPreferences("now_download_config", 4);
      paramString.edit().putInt("key_now_download_engine", 0).commit();
      paramString.edit().putInt("key_now_channel", 0).commit();
      QLog.e("NowGeneralConfigManager", 4, "NowGeneralConfigManager----parseJson---downloadEngine = 0");
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("now_download_engine"))
        {
          i = paramString.getInt("now_download_engine");
          if (paramString.has("now_channel")) {
            j = paramString.getInt("now_channel");
          }
          paramString = new StringBuilder();
          paramString.append("NowGeneralConfigManager----parseJson---downloadEngine = ");
          paramString.append(i);
          paramString.append(", nowChannel = ");
          paramString.append(j);
          QLog.e("NowGeneralConfigManager", 4, paramString.toString());
          paramString = ((IBaseApplicationImplUtil)QRoute.api(IBaseApplicationImplUtil.class)).getContext().getSharedPreferences("now_download_config", 4);
          paramString.edit().putInt("key_now_download_engine", i).commit();
          paramString.edit().putInt("key_now_channel", j).commit();
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowGeneralConfigManager
 * JD-Core Version:    0.7.0.1
 */