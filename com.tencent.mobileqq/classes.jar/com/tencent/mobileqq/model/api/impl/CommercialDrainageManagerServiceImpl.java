package com.tencent.mobileqq.model.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class CommercialDrainageManagerServiceImpl
  implements ICommercialDrainageManagerService
{
  private static final String COMMERCIAL_SP = "commercial_sp";
  private static long DEFAULT_INTERVAL = 86400L;
  private static final String TAG = "CommercialDrainageManager";
  BaseQQAppInterface app;
  
  public int getShowCount(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = this.app.getApp();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("commercial_sp");
    ((StringBuilder)localObject3).append(this.app.getAccount());
    localObject3 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
    long l2 = ((SharedPreferences)localObject3).getLong("disPlayInteval", -1L);
    boolean bool = true;
    long l1 = l2;
    if (l2 == -1L) {}
    for (;;)
    {
      try
      {
        localObject4 = this.app;
        localObject1 = null;
        localObject4 = VasUpdateUtil.a((AppRuntime)localObject4, "vip_personal_card.json", false, null);
        if (localObject4 != null)
        {
          if (((JSONObject)localObject4).has("ipStackConfigDic")) {
            localObject1 = ((JSONObject)localObject4).getJSONObject("ipStackConfigDic");
          }
          if (!((JSONObject)localObject1).has("ipStackTimeInterval")) {
            break label680;
          }
          l1 = ((JSONObject)localObject1).getInt("ipStackTimeInterval");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getJson interval = ");
            ((StringBuilder)localObject1).append(l1);
            QLog.d("CommercialDrainageManager", 2, ((StringBuilder)localObject1).toString());
          }
          l2 = l1;
          if (l1 <= 0L) {
            l2 = DEFAULT_INTERVAL;
          }
          if (Build.VERSION.SDK_INT > 8) {
            ((SharedPreferences)localObject3).edit().putLong("disPlayInteval", l2).apply();
          } else {
            ((SharedPreferences)localObject3).edit().putLong("disPlayInteval", l2).commit();
          }
        }
        else
        {
          QLog.e("CommercialDrainageManager", 1, "getShowCount json not exist");
          l2 = DEFAULT_INTERVAL;
        }
        l1 = l2;
      }
      catch (Exception localException)
      {
        l1 = DEFAULT_INTERVAL;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getShowCount error = ");
        ((StringBuilder)localObject4).append(localException);
        QLog.e("CommercialDrainageManager", 1, ((StringBuilder)localObject4).toString());
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_lastDisPlayTime");
      if (((SharedPreferences)localObject3).getLong(((StringBuilder)localObject2).toString(), 9223372036854775807L) + l1 <= paramLong) {
        bool = false;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_count");
      int i = ((SharedPreferences)localObject3).getInt(((StringBuilder)localObject2).toString(), 0);
      localObject2 = ((SharedPreferences)localObject3).edit();
      if (!bool)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramString1);
        ((StringBuilder)localObject3).append("_lastDisPlayTime");
        ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), paramLong);
        i = 0;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append("_count");
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), i + 1);
      if (Build.VERSION.SDK_INT > 8) {
        ((SharedPreferences.Editor)localObject2).apply();
      } else {
        ((SharedPreferences.Editor)localObject2).commit();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getShowCount, haveShown = ");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(" count = ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" epId = ");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(" timestamp = ");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("interval = ");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" name = ");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(" type = ");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d("CommercialDrainageManager", 2, ((StringBuilder)localObject2).toString());
      }
      return i;
      label680:
      l1 = -1L;
    }
  }
  
  public boolean isIPSite(Emoticon paramEmoticon)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticon != null) {
      if (TextUtils.isEmpty(paramEmoticon.ipsiteUrl))
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramEmoticon.ipsiteName)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isIPSite(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticonPackage != null) {
      if ((TextUtils.isEmpty(paramEmoticonPackage.ipUrl)) && (TextUtils.isEmpty(paramEmoticonPackage.ipName)) && (TextUtils.isEmpty(paramEmoticonPackage.ipDetail)) && (TextUtils.isEmpty(paramEmoticonPackage.ipOpName)))
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramEmoticonPackage.ipJumpUrl)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isRichIPSite(VipIPSiteInfo paramVipIPSiteInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVipIPSiteInfo != null)
    {
      paramVipIPSiteInfo = paramVipIPSiteInfo.strType;
      if ((!"comic".equals(paramVipIPSiteInfo)) && (!"book".equals(paramVipIPSiteInfo)) && (!"video".equals(paramVipIPSiteInfo)) && (!"goods".equals(paramVipIPSiteInfo)))
      {
        bool1 = bool2;
        if (!"game".equals(paramVipIPSiteInfo)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((BaseQQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public boolean shouldHiden(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage.endTime != paramEmoticonPackage.beginTime) && ((paramEmoticonPackage.beginTime >= System.currentTimeMillis()) || (System.currentTimeMillis() >= paramEmoticonPackage.endTime));
  }
  
  public void updateDisPlayInteval(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateDisPlayInteval interval = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("CommercialDrainageManager", 2, ((StringBuilder)localObject).toString());
    }
    long l = paramLong;
    if (paramLong <= 0L) {
      l = DEFAULT_INTERVAL;
    }
    Object localObject = this.app.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commercial_sp");
    localStringBuilder.append(this.app.getAccount());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (Build.VERSION.SDK_INT > 8)
    {
      ((SharedPreferences)localObject).edit().putLong("disPlayInteval", l).apply();
      return;
    }
    ((SharedPreferences)localObject).edit().putLong("disPlayInteval", l).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.api.impl.CommercialDrainageManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */