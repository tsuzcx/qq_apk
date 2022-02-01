package com.tencent.mobileqq.gamecenter.data;

import aceh;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import anni;
import ausa;
import bgmg;
import bgnw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class GameNoticeInfo
  extends Entity
  implements Cloneable
{
  private static final String DOWNLOAD_MANAGER_PAGE = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  private static final String GAME_DETAIL_PAGE_TEMPLATE = "https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1";
  private static final String KEY_END_TIME = "endts";
  private static final String KEY_INSTALL_DEF_TIPS = "default_install_bartips_text";
  private static final String KEY_INSTALL_TIPS = "install_bartips";
  private static final String KEY_JUMP_URL = "jumpurl";
  private static final String KEY_REG_DEF_TIPS = "default_register_bartips_text";
  private static final String KEY_REG_TIPS = "register_bartips";
  private static final String KEY_START_TIME = "startts";
  private static final String KEY_TEXT = "text";
  private static final String KEY_VALID = "valid";
  private static final String SP_NAME_WADL_TIPSINFO = "wadl_TipInfo";
  public static final String TAG = "GameNoticeInfo";
  public static final int TYPE_INSTALL = 1;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_REGISTER = 2;
  public String apkChannel;
  @unique
  public String appId = "";
  public String appName;
  public int bannerType;
  public long createTime;
  public long endTime;
  public String filePath;
  @notColumn
  public boolean infoRequested;
  public String jumpUrl;
  public String packageName;
  @notColumn
  public boolean registered;
  public boolean shown;
  public long startTime;
  public String title;
  public int versionCode;
  
  public GameNoticeInfo() {}
  
  public GameNoticeInfo(ausa paramausa, Context paramContext)
  {
    this.appId = paramausa.jdField_a_of_type_JavaLangString;
    this.appName = paramausa.e;
    this.packageName = paramausa.b;
    this.versionCode = paramausa.jdField_a_of_type_Int;
    this.apkChannel = paramausa.g;
    this.filePath = paramausa.l;
    this.createTime = paramausa.c;
    this.bannerType = convertToBannerType(paramausa);
    init(paramContext);
  }
  
  public static int convertToBannerType(ausa paramausa)
  {
    if (paramausa.d == 9)
    {
      if (bgnw.a(BaseApplicationImpl.getContext(), paramausa.b)) {
        return 2;
      }
      paramausa.d = 6;
    }
    if ((paramausa.d == 6) && (bgmg.a(paramausa.l))) {
      return 1;
    }
    return 0;
  }
  
  private void init(Context paramContext)
  {
    long l1 = 28800000L;
    long l2 = 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeInfo", 2, "init...bannerType=" + this.bannerType);
    }
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (this.bannerType != 1) {
          break;
        }
      } while (TextUtils.isEmpty(this.filePath));
      paramContext = new File(this.filePath);
    } while (!paramContext.exists());
    long l4 = aceh.a("MILLISECONDS_DELAY");
    long l3 = aceh.a("MILLISECONDS_INTERVAL");
    if (l4 < 1L) {}
    for (;;)
    {
      if (l3 < 1L) {}
      for (;;)
      {
        this.startTime = (paramContext.lastModified() + l2);
        this.endTime = (l1 + this.startTime);
        if (readTipInfo(this)) {
          break;
        }
        this.title = (this.appName + anni.a(2131703841));
        this.jumpUrl = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
        return;
        if (this.bannerType != 2) {
          break;
        }
        paramContext = aceh.a(this.packageName);
        if (paramContext == null) {
          break;
        }
        l4 = aceh.a("MILLISECONDS_DELAY");
        l3 = aceh.a("MILLISECONDS_INTERVAL");
        if (l4 < 1L) {}
        for (;;)
        {
          if (l3 < 1L) {}
          for (;;)
          {
            this.startTime = (paramContext.firstInstallTime + l2);
            this.endTime = (l1 + this.startTime);
            if (readTipInfo(this)) {
              break;
            }
            this.title = (this.appName + anni.a(2131703840));
            this.jumpUrl = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1", new Object[] { this.appId });
            return;
            l1 = l3;
          }
          l2 = l4;
        }
        l1 = l3;
      }
      l2 = l4;
    }
  }
  
  private static boolean readTipInfo(GameNoticeInfo paramGameNoticeInfo)
  {
    Object localObject3 = null;
    if (TextUtils.isEmpty(paramGameNoticeInfo.appId)) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = BaseApplicationImpl.getContext();
    } while (localObject1 == null);
    SharedPreferences localSharedPreferences = ((Context)localObject1).getSharedPreferences("wadl_TipInfo", 4);
    Object localObject2;
    if (paramGameNoticeInfo.bannerType == 1)
    {
      localObject2 = localSharedPreferences.getString("default_install_bartips_text", null);
      localObject1 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
    }
    for (;;)
    {
      boolean bool1;
      if ((localObject2 != null) && (localObject1 != null))
      {
        paramGameNoticeInfo.title = (paramGameNoticeInfo.appName + (String)localObject2);
        paramGameNoticeInfo.jumpUrl = ((String)localObject1);
        bool1 = true;
      }
      for (;;)
      {
        localObject1 = localSharedPreferences.getString(paramGameNoticeInfo.appId, null);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          return bool1;
          if (paramGameNoticeInfo.bannerType != 2) {
            break label344;
          }
          localObject2 = localSharedPreferences.getString("default_register_bartips_text", null);
          localObject1 = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1", new Object[] { paramGameNoticeInfo.appId });
          break;
        }
        try
        {
          localObject2 = new JSONObject((String)localObject1);
          if (paramGameNoticeInfo.bannerType == 1) {
            localObject1 = ((JSONObject)localObject2).optJSONObject("install_bartips");
          }
          for (;;)
          {
            bool2 = bool1;
            if (localObject1 == null) {
              return bool2;
            }
            long l1 = NetConnInfoCenter.getServerTime();
            long l2 = ((JSONObject)localObject1).optLong("startts", 0L);
            long l3 = ((JSONObject)localObject1).optLong("endts", 9223372036854775807L);
            bool2 = bool1;
            if (l2 > l1) {
              return bool2;
            }
            bool2 = bool1;
            if (l1 > l3) {
              return bool2;
            }
            paramGameNoticeInfo.title = ((JSONObject)localObject1).getString("text");
            paramGameNoticeInfo.jumpUrl = ((JSONObject)localObject1).getString("jumpurl");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("GameNoticeInfo", 2, new Object[] { "readTipInfo: ", paramGameNoticeInfo });
            break;
            localObject1 = localObject3;
            if (paramGameNoticeInfo.bannerType == 2) {
              localObject1 = ((JSONObject)localObject2).optJSONObject("register_bartips");
            }
          }
          bool1 = false;
        }
        catch (JSONException paramGameNoticeInfo)
        {
          QLog.e("GameNoticeInfo", 1, paramGameNoticeInfo, new Object[0]);
          bool2 = bool1;
        }
      }
      label344:
      localObject1 = null;
      localObject2 = null;
    }
    boolean bool2 = true;
    return bool2;
  }
  
  public static void saveTipInfo(String paramString, JSONObject paramJSONObject)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null)) {}
    do
    {
      return;
      localObject = BaseApplicationImpl.getContext();
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeInfo", 2, new Object[] { "saveTipInfo: ", paramJSONObject.toString() });
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = ((Context)localObject).getSharedPreferences("wadl_TipInfo", 4).edit();
    try
    {
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("install_bartips");
      if ((localJSONObject2 != null) && (localJSONObject2.optBoolean("valid", false))) {
        localJSONObject1.put("install_bartips", localJSONObject2);
      }
      localJSONObject2 = paramJSONObject.optJSONObject("register_bartips");
      if ((localJSONObject2 != null) && (localJSONObject2.optBoolean("valid", false))) {
        localJSONObject1.put("register_bartips", localJSONObject2);
      }
      if (paramJSONObject.has("default_install_bartips_text")) {
        ((SharedPreferences.Editor)localObject).putString("default_install_bartips_text", paramJSONObject.optString("default_install_bartips_text"));
      }
      if (paramJSONObject.has("default_register_bartips_text")) {
        ((SharedPreferences.Editor)localObject).putString("default_register_bartips_text", paramJSONObject.optString("default_register_bartips_text"));
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        QLog.e("GameNoticeInfo", 1, paramJSONObject, new Object[0]);
      }
    }
    if (localJSONObject1.length() > 0) {
      ((SharedPreferences.Editor)localObject).putString(paramString.trim(), localJSONObject1.toString());
    }
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  protected Object clone()
  {
    try
    {
      GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)super.clone();
      localGameNoticeInfo.appId = this.appId;
      localGameNoticeInfo.bannerType = this.bannerType;
      localGameNoticeInfo.jumpUrl = this.jumpUrl;
      localGameNoticeInfo.title = this.title;
      localGameNoticeInfo.appName = this.appName;
      localGameNoticeInfo.packageName = this.packageName;
      localGameNoticeInfo.versionCode = this.versionCode;
      localGameNoticeInfo.startTime = this.startTime;
      localGameNoticeInfo.endTime = this.endTime;
      localGameNoticeInfo.infoRequested = this.infoRequested;
      localGameNoticeInfo.filePath = this.filePath;
      localGameNoticeInfo.registered = this.registered;
      localGameNoticeInfo.shown = this.shown;
      localGameNoticeInfo.apkChannel = this.apkChannel;
      localGameNoticeInfo.createTime = this.createTime;
      return localGameNoticeInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (GameNoticeInfo)paramObject;
        bool1 = bool2;
      } while (this.bannerType != paramObject.bannerType);
      bool1 = bool2;
    } while (this.createTime != paramObject.createTime);
    return this.appId.equals(paramObject.appId);
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.appId)) && (this.bannerType != 0) && (this.startTime > 0L) && (this.endTime > 0L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameNoticeInfo {");
    localStringBuilder.append("appId=").append(this.appId).append(",packageName=").append(this.packageName).append(",appName=").append(this.appName).append(",filePath=").append(this.filePath).append(",bannerType=").append(this.bannerType).append(",startTime=").append(this.startTime).append(",endTime=").append(this.endTime).append(",title=").append(this.title).append(",jumpUrl=").append(this.jumpUrl).append(",shown=").append(this.shown).append(",createTime=").append(this.createTime).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeInfo
 * JD-Core Version:    0.7.0.1
 */