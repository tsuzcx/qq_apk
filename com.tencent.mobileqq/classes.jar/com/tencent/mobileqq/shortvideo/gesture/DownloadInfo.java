package com.tencent.mobileqq.shortvideo.gesture;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DownloadInfo
  extends ConfigInfo
{
  public static final String spKey_Config = "config";
  public static final String spKey_Ver = "ver";
  static final String spKey_gamemodel_zip_md5 = "gamemodel_zip_md5";
  static final String spKey_model_zip_md5 = "model_zip_md5";
  static final String spKey_so_zip_md5 = "so_zip_md5";
  public static final String spName = "config_qq.android.qavgesture";
  public String MD5_so;
  public String MD5_zip_gamemodel;
  public String MD5_zip_model;
  public String MD5_zip_so;
  public boolean enable;
  public boolean gameEnable;
  public String gamemodel_fullname;
  public String model_fullname;
  public String so_fullname;
  public String so_name;
  double time;
  public String url_zip_gamemodel;
  public String url_zip_model;
  public String url_zip_so;
  
  public static DownloadInfo get()
  {
    String str = getSP().getString("config", null);
    if (TextUtils.isEmpty(str)) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return null;
      localDownloadInfo = new DownloadInfo();
    } while (!localDownloadInfo.tryParse("QavGesture", str));
    return localDownloadInfo;
  }
  
  public static SharedPreferences getSP()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.qavgesture", 4);
  }
  
  public boolean parse(JSONObject paramJSONObject)
  {
    try
    {
      this.time = paramJSONObject.getDouble("time");
      this.enable = paramJSONObject.getBoolean("enable");
      this.url_zip_so = paramJSONObject.getString("url_zip_so");
      this.MD5_zip_so = paramJSONObject.getString("MD5_zip_so");
      this.url_zip_model = paramJSONObject.getString("url_zip_model");
      this.MD5_zip_model = paramJSONObject.getString("MD5_zip_model");
      this.MD5_so = paramJSONObject.getString("MD5_so");
      this.so_fullname = paramJSONObject.getString("so_fullname");
      this.so_name = paramJSONObject.getString("so_name");
      this.model_fullname = paramJSONObject.getString("model_fullname");
      this.gameEnable = paramJSONObject.optBoolean("gameenable");
      this.url_zip_gamemodel = paramJSONObject.optString("url_zip_gamemodel");
      this.MD5_zip_gamemodel = paramJSONObject.optString("MD5_zip_gamemodel");
      this.gamemodel_fullname = paramJSONObject.optString("gamemodel_fullname");
      return true;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("QavGesture", 1, String.format("parseJson, Exception\n%s", new Object[] { paramJSONObject }));
    }
    return false;
  }
  
  public String toString()
  {
    return String.format("task_id[%s], time[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], url_zip_model[%s], MD5_zip_model[%s], MD5_so[%s]", new Object[] { Integer.valueOf(this.task_id), Double.valueOf(this.time), Boolean.valueOf(this.enable), this.url_zip_so, this.MD5_zip_so, this.url_zip_model, this.MD5_zip_model, this.MD5_so });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */