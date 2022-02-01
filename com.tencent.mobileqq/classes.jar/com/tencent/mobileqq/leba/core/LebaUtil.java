package com.tencent.mobileqq.leba.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.leba.entity.GroupInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.more.LebaMoreFragment;
import com.tencent.mobileqq.leba.utils.LebaPluginGroupManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LebaUtil
{
  public static boolean a = false;
  
  public static int a(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return 0;
    }
    return paramGroupInfo.b * 1000 + paramGroupInfo.c;
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    int i = paramAppRuntime.getPreferences().getInt("sp_key_leba_group_seq", 0);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getLebaGroup, seq=");
      paramAppRuntime.append(i);
      QLog.d("LebaUtil", 2, paramAppRuntime.toString());
    }
    return i;
  }
  
  public static Map<Long, GroupInfo> a(List<GroupInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GroupInfo localGroupInfo = (GroupInfo)paramList.next();
      if (localGroupInfo != null) {
        localHashMap.put(Long.valueOf(localGroupInfo.a), localGroupInfo);
      }
    }
    return localHashMap;
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = new Intent();
    paramAppRuntime.putExtra("key_open_edit_mode", paramBoolean);
    QPublicFragmentActivity.start(paramContext, paramAppRuntime, LebaMoreFragment.class);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recordApiEmpty tag = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", method = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",apiName = ");
    localStringBuilder.append(paramString3);
    QLog.e("LebaUtil", 1, localStringBuilder.toString());
  }
  
  public static void a(List<LebaViewItem> paramList1, List<LebaViewItem> paramList2)
  {
    LebaPluginGroupManager.a(paramList1, paramList2);
    if (LebaPluginLogic.a() == 1) {
      return;
    }
    paramList2 = new LebaViewItem();
    paramList2.h = 2;
    paramList1.add(paramList2);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLebaGroupSeq，seq=");
      localStringBuilder.append(paramInt);
      QLog.d("LebaUtil", 2, localStringBuilder.toString());
    }
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.getPreferences().edit();
    paramAppRuntime.putInt("sp_key_leba_group_seq", paramInt);
    paramAppRuntime.commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveLebaInfo,layoutType = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",pluginType");
    localStringBuilder.append(paramInt2);
    QLog.i("LebaUtil", 1, localStringBuilder.toString());
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.getPreferences().edit();
    paramAppRuntime.putInt("sp_key_leba_plugin_type", paramInt2);
    paramAppRuntime.commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, List<GroupInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtil", 2, "saveGroupInfo");
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          GroupInfo localGroupInfo = (GroupInfo)paramList.next();
          if (localGroupInfo == null) {
            continue;
          }
          try
          {
            Object localObject = new JSONObject();
            ((JSONObject)localObject).put("uiResId", localGroupInfo.a);
            ((JSONObject)localObject).put("groudId", localGroupInfo.b);
            ((JSONObject)localObject).put("index", localGroupInfo.c);
            localJSONArray.put(localObject);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("");
              ((StringBuilder)localObject).append(localGroupInfo);
              QLog.i("LebaUtil", 2, ((StringBuilder)localObject).toString());
            }
          }
          catch (JSONException paramList)
          {
            QLog.e("LebaUtil", 1, "saveGroupInfo, exp=", paramList);
          }
        }
      }
      paramAppRuntime = paramAppRuntime.getPreferences().edit();
      paramAppRuntime.putString("sp_key_leba_group_info", localJSONArray.toString());
      paramAppRuntime.commit();
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("saveGroupInfo, result=");
        paramAppRuntime.append(true);
        QLog.i("LebaUtil", 2, paramAppRuntime.toString());
      }
    }
  }
  
  public static boolean a(LebaViewItem paramLebaViewItem)
  {
    if ((paramLebaViewItem.b.cDataType == 1) && (!TextUtils.isEmpty(paramLebaViewItem.b.strPkgName))) {
      return "qzone_feedlist".equals(paramLebaViewItem.b.strPkgName);
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, long paramLong, Set<Long> paramSet)
  {
    if (paramLong == 100000L) {
      return false;
    }
    return paramSet.contains(Long.valueOf(paramLong));
  }
  
  public static List<GroupInfo> b(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtil", 2, "getGroupInfo");
    }
    ArrayList localArrayList = new ArrayList();
    paramAppRuntime = paramAppRuntime.getPreferences().getString("sp_key_leba_group_info", "");
    for (;;)
    {
      int j;
      try
      {
        paramAppRuntime = new JSONArray(paramAppRuntime);
        int i = 0;
        if (i < paramAppRuntime.length())
        {
          Object localObject = paramAppRuntime.getJSONObject(i);
          JSONArray localJSONArray = ((JSONObject)localObject).names();
          if (localJSONArray != null)
          {
            GroupInfo localGroupInfo = new GroupInfo();
            j = 0;
            if (j < localJSONArray.length())
            {
              String str = localJSONArray.getString(j);
              try
              {
                if ("uiResId".equals(str)) {
                  localGroupInfo.a = ((JSONObject)localObject).getLong(str);
                } else if ("groudId".equals(str)) {
                  localGroupInfo.b = ((JSONObject)localObject).getInt(str);
                } else if ("index".equals(str)) {
                  localGroupInfo.c = ((JSONObject)localObject).getInt(str);
                }
              }
              catch (Exception localException)
              {
                a = true;
                QLog.e("LebaUtil", 1, "getGroupInfo", localException);
              }
            }
            localArrayList.add(localGroupInfo);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("");
              ((StringBuilder)localObject).append(localGroupInfo);
              QLog.i("LebaUtil", 2, ((StringBuilder)localObject).toString());
            }
          }
          i += 1;
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramAppRuntime)
      {
        a = true;
        QLog.e("LebaUtil", 1, "getGroupInfo", paramAppRuntime);
      }
      j += 1;
    }
  }
  
  public static void b(List<LebaViewItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramList.size());
    localLinkedHashSet.addAll(paramList);
    paramList.clear();
    paramList.addAll(localLinkedHashSet);
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getPreferences().getString("sp_key_leba_upgrade_info", "");
    boolean bool = "5770".equals(paramAppRuntime) ^ true;
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtil", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramAppRuntime, "5770" }));
    }
    return bool;
  }
  
  public static void d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getPreferences().edit();
    paramAppRuntime.putString("sp_key_leba_upgrade_info", "5770");
    paramAppRuntime.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtil", 2, String.format("update version, buildNum[%s]", new Object[] { "5770" }));
    }
  }
  
  public static int e(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    int i = paramAppRuntime.getPreferences().getInt("sp_key_leba_plugin_type", 0);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getLebaPluginType =");
    paramAppRuntime.append(i);
    QLog.i("LebaUtil", 1, paramAppRuntime.toString());
    return i;
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaUtil
 * JD-Core Version:    0.7.0.1
 */