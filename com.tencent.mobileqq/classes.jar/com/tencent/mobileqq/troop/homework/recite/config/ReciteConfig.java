package com.tencent.mobileqq.troop.homework.recite.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReciteConfig
{
  public int a;
  public Context a;
  public String a;
  public int b;
  public String b;
  public int c = 40;
  public int d = 50;
  
  public ReciteConfig(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = 10;
    this.jdField_b_of_type_JavaLangString = "WXARS1005SNG1523440966";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    b();
  }
  
  private SharedPreferences a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_JavaLangString + "_" + "HWTroopReciteConfig", 0);
  }
  
  private void a()
  {
    a().edit().putInt("max_remind_num", this.jdField_a_of_type_Int).putInt("max_allow_wrong_num", this.d).putInt("max_detect_num_in_article", this.jdField_b_of_type_Int).putInt("max_detect_num_in_recite", this.c).putString("wx_voice_app_id", this.jdField_b_of_type_JavaLangString).commit();
    if (QLog.isColorLevel()) {
      QLog.i("ReciteConfig", 2, "saveConfig: " + toString());
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove(paramString + "_" + "troop_hw_recite_cfg_version").commit();
  }
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString + "_" + "troop_hw_recite_cfg_version", paramInt).commit();
  }
  
  private void a(ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReciteConfig", 2, "parseConfig: list.size() " + paramConfig.msg_content_list.size());
      }
      Iterator localIterator = paramConfig.msg_content_list.get().iterator();
      if (!localIterator.hasNext()) {
        break label298;
      }
      paramConfig = (ConfigurationService.Content)localIterator.next();
      if ((paramConfig != null) && (paramConfig.content.has())) {
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = ConfigServlet.b(paramConfig.content.get().toByteArray());
          if (paramConfig == null) {
            break label299;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("ReciteConfig", 2, "parseConfig: contentitem.content =  " + paramConfig);
        }
        if ((TextUtils.isEmpty(paramConfig)) || (!a(paramConfig))) {
          break;
        }
        a();
      }
      catch (Exception paramConfig)
      {
        QLog.e("ReciteConfig", 1, "parseConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("ReciteConfig", 1, "empty contentitem");
      break;
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("ReciteConfig", 2, "handleReceiptConfig:msg_content_list is empty ,version: " + paramConfig.version.get());
      }
      label298:
      return;
      label299:
      paramConfig = null;
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {}
    while (!QLog.isColorLevel())
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("HWTroopReciteConfig"))
        {
          paramString = paramString.getJSONObject("HWTroopReciteConfig");
          if (paramString.has("max_remind_num")) {
            this.jdField_a_of_type_Int = paramString.getInt("max_remind_num");
          }
          if (paramString.has("max_allow_wrong_num")) {
            this.d = paramString.getInt("max_allow_wrong_num");
          }
          if (paramString.has("max_detect_num_in_article")) {
            this.jdField_b_of_type_Int = paramString.getInt("max_detect_num_in_article");
          }
          if (paramString.has("max_detect_num_in_recite")) {
            this.c = paramString.getInt("max_detect_num_in_recite");
          }
          if (paramString.has("wx_voice_app_id"))
          {
            paramString = paramString.getString("wx_voice_app_id");
            if (!TextUtils.isEmpty(paramString)) {
              this.jdField_b_of_type_JavaLangString = paramString;
            }
          }
        }
        bool = true;
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("ReciteConfig", 2, paramString, new Object[0]);
        return false;
      }
      return bool;
    }
    QLog.i("ReciteConfig", 2, "parseConfig:config_content is null");
    return false;
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = a();
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("max_remind_num", this.jdField_a_of_type_Int);
    this.d = localSharedPreferences.getInt("max_allow_wrong_num", this.d);
    this.jdField_b_of_type_Int = localSharedPreferences.getInt("max_detect_num_in_article", this.jdField_b_of_type_Int);
    this.c = localSharedPreferences.getInt("max_detect_num_in_recite", this.c);
    this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("wx_voice_app_id", this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("ReciteConfig", 2, "loadConfig: " + toString());
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "troop_hw_recite_cfg_version", 0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("ReciteConfig", 2, "handleConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, i);
      a(paramConfig);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("ReciteConfig", 2, "handleConfig:localVersion == version ");
  }
  
  public String toString()
  {
    return "ReciteConfig{mMaxRemindNum=" + this.jdField_a_of_type_Int + ", mMaxDetectNumInArticle=" + this.jdField_b_of_type_Int + ", mMaxDetectNumInRecite=" + this.c + ", mMaxAllowWrongNum=" + this.d + ", mWXVoiceAppId='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig
 * JD-Core Version:    0.7.0.1
 */