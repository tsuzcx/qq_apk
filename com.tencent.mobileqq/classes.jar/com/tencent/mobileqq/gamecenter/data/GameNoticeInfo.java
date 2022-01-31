package com.tencent.mobileqq.gamecenter.data;

import aahi;
import alud;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import aslu;
import awge;
import awhp;
import awhs;
import bdhb;
import bdiv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class GameNoticeInfo
  extends awge
  implements Cloneable
{
  private static final String DOWNLOAD_MANAGER_PAGE = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  private static final String GAME_DETAIL_PAGE_TEMPLATE = "https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1";
  private static final long MILLISECONDS_DELAY = 300000L;
  private static final long MILLISECONDS_INTERVAL = 28800000L;
  private static final String TAG = "GameNoticeInfo";
  public static final int TYPE_INSTALL = 1;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_REGISTER = 2;
  public String apkChannel;
  @awhs
  public String appId = "";
  public String appName;
  public int bannerType;
  public long createTime;
  public long endTime;
  public String filePath;
  @awhp
  public boolean infoRequested;
  public String jumpUrl;
  public String packageName;
  @awhp
  public boolean registered;
  public boolean shown;
  public long startTime;
  public String title;
  
  public GameNoticeInfo() {}
  
  public GameNoticeInfo(aslu paramaslu, Context paramContext)
  {
    this.appId = paramaslu.a;
    this.appName = paramaslu.e;
    this.packageName = paramaslu.b;
    this.apkChannel = paramaslu.g;
    this.filePath = paramaslu.l;
    this.createTime = paramaslu.c;
    this.bannerType = convertToBannerType(paramaslu);
    init(paramContext);
  }
  
  public static int convertToBannerType(aslu paramaslu)
  {
    int j = 0;
    int i;
    if (bdiv.a(BaseApplicationImpl.getContext(), paramaslu.b)) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramaslu.d != 6);
      i = j;
    } while (!bdhb.a(paramaslu.l));
    return 1;
  }
  
  private void init(Context paramContext)
  {
    long l1 = 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeInfo", 2, "init...bannerType=" + this.bannerType);
    }
    if (paramContext == null) {}
    long l2;
    long l3;
    label101:
    do
    {
      do
      {
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
        l2 = aahi.a("MILLISECONDS_DELAY");
        l3 = aahi.a("MILLISECONDS_INTERVAL");
        if (l2 > 0L) {
          break label316;
        }
        l2 = l3;
        if (l3 <= 0L) {
          l2 = 28800000L;
        }
        this.startTime = (l1 + paramContext.lastModified());
        this.endTime = (l2 + this.startTime);
      } while (readTipInfo(this));
      this.title = (this.appName + alud.a(2131705445));
      this.jumpUrl = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
      return;
    } while (this.bannerType != 2);
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(this.packageName, 0);
        if (paramContext == null) {
          break;
        }
        l2 = aahi.a("MILLISECONDS_DELAY");
        l3 = aahi.a("MILLISECONDS_INTERVAL");
        if (l2 > 0L) {
          break label310;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        return;
      }
      this.startTime = (l1 + paramContext.firstInstallTime);
      this.endTime = (l2 + this.startTime);
      if (readTipInfo(this)) {
        break;
      }
      this.title = (this.appName + alud.a(2131705444));
      this.jumpUrl = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=%s&_wv=2164260896&_wwv=448&autolaunch=1", new Object[] { this.appId });
      return;
      label310:
      l1 = l2;
      break label322;
      label316:
      l1 = l2;
      break label101;
      label322:
      l2 = l3;
      if (l3 <= 0L) {
        l2 = 28800000L;
      }
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
            break label347;
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
      label347:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeInfo
 * JD-Core Version:    0.7.0.1
 */