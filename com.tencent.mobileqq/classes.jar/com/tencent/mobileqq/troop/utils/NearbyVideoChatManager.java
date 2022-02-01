package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyVideoChatManager
  implements Manager
{
  int jdField_a_of_type_Int;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  NearbyVideoChatManager.BannerConfig jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig;
  NearbyVideoChatManager.DialogConfig jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig;
  public String a;
  @NonNull
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList(5);
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public String b;
  public String c = "banner_show_num";
  public String d = "dialog_show_num";
  String e;
  String f;
  public String g = HardCodeUtil.a(2131707434);
  public String h = HardCodeUtil.a(2131707428);
  String i = "";
  String j;
  String k;
  
  public NearbyVideoChatManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "banner_config";
    this.jdField_b_of_type_JavaLangString = "dialog_config";
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.c = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.d = ((StringBuilder)localObject).toString();
    paramAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
    this.i = paramAppInterface.getString("config", "");
    if (!TextUtils.isEmpty(this.i)) {
      a(this.i);
    }
    this.jdField_a_of_type_Boolean = paramAppInterface.getBoolean("enter_guide", true);
    localObject = paramAppInterface.getString(this.jdField_a_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      a((String)localObject, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig;
      if ((localObject != null) && (!TextUtils.isEmpty(((NearbyVideoChatManager.BannerConfig)localObject).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_Int = a(paramAppInterface.getString(this.c, ""), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString);
        this.k = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString;
      }
    }
    localObject = paramAppInterface.getString(this.jdField_b_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      b((String)localObject, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig;
      if ((localObject != null) && (!TextUtils.isEmpty(((NearbyVideoChatManager.DialogConfig)localObject).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Int = a(paramAppInterface.getString(this.d, ""), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString);
        this.j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig = new NearbyVideoChatManager.BannerConfig();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString = paramString.optString("unique_key");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_Int = paramString.optInt("display_times");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_Long = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_Long = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_Int = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("image_url");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.c = ((JSONObject)localObject).optString("jump_url");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.jdField_a_of_type_JavaLangString, paramString.toString()).commit();
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString.equals(this.k)))
        {
          this.k = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString;
          paramString = new JSONObject();
          paramString.put(this.k, 0);
          ((SharedPreferences)localObject).edit().putString(this.c, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson JSONException", paramString);
      }
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig = new NearbyVideoChatManager.DialogConfig();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString = paramString.optString("unique_key");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_Int = paramString.optInt("display_times");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_Long = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_Long = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_Int = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("header_url");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.c = ((JSONObject)localObject).optString("title");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.d = ((JSONObject)localObject).optString("content");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.e = ((JSONObject)localObject).optString("button_text");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.f = ((JSONObject)localObject).optString("jump_url");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.g = ((JSONObject)localObject).optString("button_text_color");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.h = ((JSONObject)localObject).optString("button_background_color");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.jdField_b_of_type_JavaLangString, paramString.toString()).commit();
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString.equals(this.j)))
        {
          this.j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString;
          paramString = new JSONObject();
          paramString.put(this.j, 0);
          ((SharedPreferences)localObject).edit().putString(this.d, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson JSONException", paramString);
      }
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return 0;
      }
      int m = new JSONObject(paramString1).optInt(paramString2);
      return m;
    }
    catch (JSONException paramString2)
    {
      label24:
      break label24;
    }
    paramString2 = new StringBuilder();
    paramString2.append("getNumFromJson json:");
    paramString2.append(paramString1);
    QLog.e("Q.nearby.video_chat", 2, paramString2.toString());
    return 0;
  }
  
  public String a()
  {
    return this.i;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        this.e = null;
        this.f = null;
      }
      else
      {
        this.i = paramString;
        Object localObject = new JSONObject(paramString);
        this.g = ((JSONObject)localObject).optString("detail_default");
        this.h = ((JSONObject)localObject).optString("detail_num");
        this.e = ((JSONObject)localObject).optString("guide");
        this.f = ((JSONObject)localObject).optString("title");
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4);
        localSharedPreferences.edit().putString("detail_default", this.g).commit();
        localSharedPreferences.edit().putString("detail_num", this.h).commit();
        if (TextUtils.isEmpty(this.f)) {
          localSharedPreferences.edit().putString("title", HardCodeUtil.a(2131707433)).commit();
        } else {
          localSharedPreferences.edit().putString("title", this.f).commit();
        }
        localObject = ((JSONObject)localObject).optJSONArray("tips");
        int m = 0;
        while (m < ((JSONArray)localObject).length())
        {
          this.jdField_a_of_type_JavaUtilList.add(((JSONArray)localObject).optString(m));
          m += 1;
        }
      }
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4).edit().putString("config", paramString).commit();
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseJson JSONException", paramString);
      }
    }
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void c(String paramString)
  {
    b(paramString, false);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.NearbyVideoChatManager
 * JD-Core Version:    0.7.0.1
 */