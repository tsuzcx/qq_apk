package com.tencent.mobileqq.gamecenter.data;

import acik;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import anzj;
import bhmi;
import bhny;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class GameNoticeInfo
  extends Entity
  implements Cloneable
{
  private static final String DOWNLOAD_MANAGER_PAGE = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  private static final String GAME_DETAIL_PAGE_TEMPLATE = "https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1";
  public static final String KEY_APPID = "appid";
  private static final String KEY_APP_ICON = "app_icon";
  private static final String KEY_END_TIME = "endts";
  private static final String KEY_EXPE_KEY = "expe_key";
  public static final String KEY_ICON_URL = "iconURL";
  private static final String KEY_INSTALL_DEF_TIPS = "default_install_bartips_text";
  private static final String KEY_INSTALL_TIPS = "install_bartips";
  private static final String KEY_JUMP_URL = "jumpurl";
  private static final String KEY_REG_DEF_TIPS = "default_register_bartips_text";
  private static final String KEY_REG_TIPS = "register_bartips";
  private static final String KEY_START_TIME = "startts";
  private static final String KEY_TEXT = "text";
  public static final String KEY_TIPS = "tips";
  private static final String KEY_TIPS_GRAY = "install_tips_gray";
  public static final String KEY_URL = "url";
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
  public String iconUrl;
  @notColumn
  public boolean infoRequested;
  @notColumn
  public boolean isGray;
  public String jumpUrl;
  public String packageName;
  public long startTime;
  public String title;
  public int versionCode;
  
  public GameNoticeInfo() {}
  
  public GameNoticeInfo(WadlResult paramWadlResult, Context paramContext)
  {
    this.appId = paramWadlResult.a.a;
    this.appName = paramWadlResult.a.j;
    this.packageName = paramWadlResult.a.f;
    this.versionCode = paramWadlResult.a.e;
    this.apkChannel = paramWadlResult.a.c;
    this.filePath = paramWadlResult.jdField_b_of_type_JavaLangString;
    this.createTime = paramWadlResult.c;
    this.bannerType = convertToBannerType(paramWadlResult);
    setTipsInfo(paramContext);
  }
  
  public static int convertToBannerType(WadlResult paramWadlResult)
  {
    if (paramWadlResult.jdField_b_of_type_Int == 9)
    {
      if (bhny.a(BaseApplicationImpl.getContext(), paramWadlResult.a.f)) {
        return 2;
      }
      paramWadlResult.jdField_b_of_type_Int = 6;
    }
    if ((paramWadlResult.jdField_b_of_type_Int == 6) && (bhmi.a(paramWadlResult.jdField_b_of_type_JavaLangString))) {
      return 1;
    }
    return 0;
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
    Object localObject4 = ((Context)localObject1).getSharedPreferences("wadl_TipInfo", 4);
    Object localObject2;
    if (paramGameNoticeInfo.bannerType == 1)
    {
      localObject2 = ((SharedPreferences)localObject4).getString("default_install_bartips_text", null);
      localObject1 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
    }
    for (;;)
    {
      if ((localObject2 != null) && (localObject1 != null))
      {
        paramGameNoticeInfo.title = (paramGameNoticeInfo.appName + (String)localObject2);
        paramGameNoticeInfo.jumpUrl = ((String)localObject1);
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject1 = ((SharedPreferences)localObject4).getString(paramGameNoticeInfo.appId, null);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          return bool1;
          if (paramGameNoticeInfo.bannerType != 2) {
            break label414;
          }
          localObject2 = ((SharedPreferences)localObject4).getString("default_register_bartips_text", null);
          localObject1 = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1", new Object[] { paramGameNoticeInfo.appId });
          break;
        }
        for (;;)
        {
          try
          {
            localObject2 = new JSONObject((String)localObject1);
            if (paramGameNoticeInfo.bannerType == 1)
            {
              localObject1 = ((JSONObject)localObject2).optJSONObject("install_bartips");
              paramGameNoticeInfo.iconUrl = ((JSONObject)localObject2).optString("app_icon", null);
              localObject4 = ((JSONObject)localObject2).optString("install_tips_gray");
              localObject2 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                localObject2 = new JSONObject((String)localObject4);
              }
              if ((localObject2 != null) && (!TextUtils.isEmpty(((JSONObject)localObject2).optString("expe_key", null)))) {
                paramGameNoticeInfo.isGray = true;
              }
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
            }
            if (paramGameNoticeInfo.bannerType == 2) {
              localObject1 = ((JSONObject)localObject2).optJSONObject("register_bartips");
            } else {
              localObject1 = null;
            }
          }
          catch (JSONException paramGameNoticeInfo)
          {
            QLog.e("GameNoticeInfo", 1, paramGameNoticeInfo, new Object[0]);
            bool2 = bool1;
          }
        }
      }
      label414:
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
      if (paramJSONObject.has("app_icon")) {
        localJSONObject1.put("app_icon", paramJSONObject.optString("app_icon"));
      }
      if (paramJSONObject.has("install_tips_gray")) {
        localJSONObject1.put("install_tips_gray", paramJSONObject.optString("install_tips_gray"));
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
      localGameNoticeInfo.packageName = this.packageName;
      localGameNoticeInfo.versionCode = this.versionCode;
      localGameNoticeInfo.apkChannel = this.apkChannel;
      localGameNoticeInfo.appName = this.appName;
      localGameNoticeInfo.filePath = this.filePath;
      localGameNoticeInfo.bannerType = this.bannerType;
      localGameNoticeInfo.title = this.title;
      localGameNoticeInfo.jumpUrl = this.jumpUrl;
      localGameNoticeInfo.startTime = this.startTime;
      localGameNoticeInfo.endTime = this.endTime;
      localGameNoticeInfo.createTime = this.createTime;
      localGameNoticeInfo.infoRequested = this.infoRequested;
      localGameNoticeInfo.iconUrl = this.iconUrl;
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
    if ((TextUtils.isEmpty(this.appId)) || (this.bannerType == 0) || (this.startTime < 1L) || (this.endTime < 1L)) {}
    label268:
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              long l = System.currentTimeMillis();
              if (this.endTime >= l) {
                break;
              }
            } while (!QLog.isColorLevel());
            Date localDate = new Date();
            localDate.setTime(this.endTime);
            QLog.w("GameNoticeInfo", 1, "isValid time expired, continue! endTime=" + localDate);
            return false;
            if (this.bannerType != 1) {
              break label268;
            }
            if (!TextUtils.isEmpty(this.filePath)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("GameNoticeInfo", 1, "isValid filePath is empty");
          return false;
          if (new File(this.filePath).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("GameNoticeInfo", 1, "isValid file not exists filePath=" + this.filePath);
        return false;
        i = acik.a(this.packageName);
        if ((i <= 0) || (this.versionCode <= 0) || (i < this.versionCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("GameNoticeInfo", 1, "isValid installVersion=" + i + ",versionCode=" + this.versionCode);
      return false;
      return true;
    } while ((this.bannerType != 2) || (acik.a(this.packageName) < 1));
    return true;
  }
  
  protected void setTipsInfo(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      long l2;
      long l1;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                l2 = acik.a("MILLISECONDS_DELAY");
                long l3 = acik.a("MILLISECONDS_INTERVAL");
                l1 = l2;
                if (l2 < 1L) {
                  l1 = 300000L;
                }
                l2 = l3;
                if (l3 < 1L) {
                  l2 = 28800000L;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("GameNoticeInfo", 2, "setTipsInfo bannerType=" + this.bannerType + ",spDelay=" + l1 + ",spInterval=" + l2);
                }
                if (this.bannerType != 1) {
                  break;
                }
              } while (TextUtils.isEmpty(this.filePath));
              paramContext = new File(this.filePath);
            } while (!paramContext.exists());
            this.startTime = (l1 + paramContext.lastModified());
            this.endTime = (l2 + this.startTime);
          } while (readTipInfo(this));
          this.title = (this.appName + anzj.a(2131703948));
          this.jumpUrl = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
          return;
        } while (this.bannerType != 2);
        paramContext = acik.a(this.packageName);
      } while (paramContext == null);
      this.startTime = (l1 + paramContext.firstInstallTime);
      this.endTime = (l2 + this.startTime);
    } while (readTipInfo(this));
    this.title = (this.appName + anzj.a(2131703947));
    this.jumpUrl = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1", new Object[] { this.appId });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameNoticeInfo {");
    localStringBuilder.append("appId=").append(this.appId).append(",packageName=").append(this.packageName).append(",iconUrl=").append(this.iconUrl).append(",appName=").append(this.appName).append(",filePath=").append(this.filePath).append(",bannerType=").append(this.bannerType).append(",startTime=").append(this.startTime).append(",endTime=").append(this.endTime).append(",infoRequested=").append(this.infoRequested).append(",title=").append(this.title).append(",jumpUrl=").append(this.jumpUrl).append(",createTime=").append(this.createTime).append(",isGray=").append(this.isGray).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeInfo
 * JD-Core Version:    0.7.0.1
 */