package com.tencent.mobileqq.intervideo.now;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class NowDownloadEngineManager
  implements Manager
{
  private QQAppInterface a;
  
  public NowDownloadEngineManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("now_download_config", 4).getInt("key_now_download_engine", 0);
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if (StringUtil.a(paramString))
    {
      BaseApplicationImpl.getContext().getSharedPreferences("now_download_config", 4).edit().putInt("key_now_download_engine", 0).commit();
      QLog.e("NowDownloadEngineManager", 4, "NowDownloadEngineManager----parseJson---downloadEngine = 0");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("now_download_engine")) {
        i = paramString.getInt("now_download_engine");
      }
      QLog.e("NowDownloadEngineManager", 4, "NowDownloadEngineManager----parseJson---downloadEngine = " + i);
      BaseApplicationImpl.getContext().getSharedPreferences("now_download_config", 4).edit().putInt("key_now_download_engine", i).commit();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowDownloadEngineManager
 * JD-Core Version:    0.7.0.1
 */