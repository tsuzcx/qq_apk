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
  public String a = "banner_config";
  public String b = "dialog_config";
  public String c = "banner_show_num";
  public String d = "dialog_show_num";
  AppInterface e;
  @NonNull
  List<String> f = new ArrayList(5);
  String g;
  String h;
  boolean i = false;
  public String j = HardCodeUtil.a(2131905252);
  public String k = HardCodeUtil.a(2131905246);
  String l = "";
  NearbyVideoChatManager.DialogConfig m;
  NearbyVideoChatManager.BannerConfig n;
  String o;
  String p;
  int q;
  int r;
  
  public NearbyVideoChatManager(AppInterface paramAppInterface)
  {
    this.e = paramAppInterface;
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.a = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.c = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.b = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(paramAppInterface);
    this.d = ((StringBuilder)localObject).toString();
    paramAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
    this.l = paramAppInterface.getString("config", "");
    if (!TextUtils.isEmpty(this.l)) {
      a(this.l);
    }
    this.i = paramAppInterface.getBoolean("enter_guide", true);
    localObject = paramAppInterface.getString(this.a, "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      a((String)localObject, true);
      localObject = this.n;
      if ((localObject != null) && (!TextUtils.isEmpty(((NearbyVideoChatManager.BannerConfig)localObject).a)))
      {
        this.r = a(paramAppInterface.getString(this.c, ""), this.n.a);
        this.p = this.n.a;
      }
    }
    localObject = paramAppInterface.getString(this.b, "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      b((String)localObject, true);
      localObject = this.m;
      if ((localObject != null) && (!TextUtils.isEmpty(((NearbyVideoChatManager.DialogConfig)localObject).a)))
      {
        this.q = a(paramAppInterface.getString(this.d, ""), this.m.a);
        this.o = this.m.a;
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
      this.n = new NearbyVideoChatManager.BannerConfig();
      this.n.a = paramString.optString("unique_key");
      this.n.b = paramString.optInt("display_times");
      this.n.c = paramString.optLong("start_timestamp", 0L);
      this.n.d = paramString.optLong("end_timestamp", 0L);
      this.n.e = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.n.f = ((JSONObject)localObject).optString("image_url");
        this.n.g = ((JSONObject)localObject).optString("jump_url");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.a, paramString.toString()).commit();
        if ((this.n.a != null) && (!this.n.a.equals(this.p)))
        {
          this.p = this.n.a;
          paramString = new JSONObject();
          paramString.put(this.p, 0);
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
      this.m = new NearbyVideoChatManager.DialogConfig();
      this.m.a = paramString.optString("unique_key");
      this.m.b = paramString.optInt("display_times");
      this.m.c = paramString.optLong("start_timestamp", 0L);
      this.m.d = paramString.optLong("end_timestamp", 0L);
      this.m.e = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.m.f = ((JSONObject)localObject).optString("header_url");
        this.m.g = ((JSONObject)localObject).optString("title");
        this.m.h = ((JSONObject)localObject).optString("content");
        this.m.i = ((JSONObject)localObject).optString("button_text");
        this.m.j = ((JSONObject)localObject).optString("jump_url");
        this.m.k = ((JSONObject)localObject).optString("button_text_color");
        this.m.l = ((JSONObject)localObject).optString("button_background_color");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.b, paramString.toString()).commit();
        if ((this.m.a != null) && (!this.m.a.equals(this.o)))
        {
          this.o = this.m.a;
          paramString = new JSONObject();
          paramString.put(this.o, 0);
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
      int i1 = new JSONObject(paramString1).optInt(paramString2);
      return i1;
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
    return this.l;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.f.clear();
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        this.g = null;
        this.h = null;
      }
      else
      {
        this.l = paramString;
        Object localObject = new JSONObject(paramString);
        this.j = ((JSONObject)localObject).optString("detail_default");
        this.k = ((JSONObject)localObject).optString("detail_num");
        this.g = ((JSONObject)localObject).optString("guide");
        this.h = ((JSONObject)localObject).optString("title");
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4);
        localSharedPreferences.edit().putString("detail_default", this.j).commit();
        localSharedPreferences.edit().putString("detail_num", this.k).commit();
        if (TextUtils.isEmpty(this.h)) {
          localSharedPreferences.edit().putString("title", HardCodeUtil.a(2131905251)).commit();
        } else {
          localSharedPreferences.edit().putString("title", this.h).commit();
        }
        localObject = ((JSONObject)localObject).optJSONArray("tips");
        int i1 = 0;
        while (i1 < ((JSONArray)localObject).length())
        {
          this.f.add(((JSONArray)localObject).optString(i1));
          i1 += 1;
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
    return this.h;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.NearbyVideoChatManager
 * JD-Core Version:    0.7.0.1
 */