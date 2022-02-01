package com.tencent.mobileqq.leba.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.leba.business.ILebaRichApi;
import com.tencent.mobileqq.leba.entity.GroupInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.mgr.list.LebaListMgrActivity;
import com.tencent.mobileqq.leba.mgr.table.LebaTableMgrFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LebaUtil
{
  public static boolean a = false;
  
  public static int a(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static int a(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return 0;
    }
    return paramGroupInfo.jdField_a_of_type_Int * 1000 + paramGroupInfo.b;
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    int i = LebaShowListManager.a().a(paramAppRuntime).size();
    paramAppRuntime = (ILebaRichApi)QRoute.api(ILebaRichApi.class);
    if (paramAppRuntime != null)
    {
      if (paramAppRuntime.isShowQCircleEnter()) {
        return i + 1;
      }
    }
    else {
      a("LebaUtil", "getKidModlePluginSize", "QCirclePart");
    }
    return i;
  }
  
  public static long a(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = paramAppRuntime.getPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_leba_plugin_user_sort_time");
    localStringBuilder.append(paramInt);
    return paramAppRuntime.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static List<GroupInfo> a(AppRuntime paramAppRuntime)
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
                  localGroupInfo.jdField_a_of_type_Long = ((JSONObject)localObject).getLong(str);
                } else if ("groudId".equals(str)) {
                  localGroupInfo.jdField_a_of_type_Int = ((JSONObject)localObject).getInt(str);
                } else if ("index".equals(str)) {
                  localGroupInfo.b = ((JSONObject)localObject).getInt(str);
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
  
  public static List<Integer> a(AppRuntime paramAppRuntime, int paramInt)
  {
    localArrayList = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences();
      localObject1 = localObject2;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append("sp_key_leba_plugin_user_sort_list");
      localObject1 = localObject2;
      localStringBuilder.append(paramInt);
      localObject1 = localObject2;
      paramAppRuntime = paramAppRuntime.getString(localStringBuilder.toString(), "");
      localObject1 = paramAppRuntime;
      if (!TextUtils.isEmpty(paramAppRuntime))
      {
        localObject1 = paramAppRuntime;
        localObject2 = new JSONArray(paramAppRuntime);
        paramInt = 0;
        for (;;)
        {
          localObject1 = paramAppRuntime;
          if (paramInt >= ((JSONArray)localObject2).length()) {
            break;
          }
          localObject1 = paramAppRuntime;
          localArrayList.add(Integer.valueOf(((JSONArray)localObject2).getInt(paramInt)));
          paramInt += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramAppRuntime)
    {
      a = true;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSortInfo ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("leba_sort", 1, ((StringBuilder)localObject2).toString(), paramAppRuntime);
    }
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
        localHashMap.put(Long.valueOf(localGroupInfo.jdField_a_of_type_Long), localGroupInfo);
      }
    }
    return localHashMap;
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (c(paramAppRuntime))
    {
      QPublicFragmentActivity.start(paramContext, LebaTableMgrFragment.class);
      return;
    }
    paramContext.startActivity(new Intent(paramContext, LebaListMgrActivity.class));
  }
  
  public static void a(SharedPreferences paramSharedPreferences, List<Integer> paramList, Long paramLong, int paramInt)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Integer localInteger = (Integer)paramList.next();
          if (localInteger != null) {
            localJSONArray.put(localInteger);
          }
        }
        paramList = new StringBuilder();
        paramList.append("sp_key_leba_plugin_user_sort_list");
        paramList.append(paramInt);
        paramSharedPreferences.putString(paramList.toString(), localJSONArray.toString());
      }
      if (paramLong != null)
      {
        paramList = new StringBuilder();
        paramList.append("sp_key_leba_plugin_user_sort_time");
        paramList.append(paramInt);
        paramSharedPreferences.putLong(paramList.toString(), paramLong.longValue());
      }
      paramSharedPreferences.commit();
      return;
    }
    catch (Exception paramSharedPreferences)
    {
      QLog.i("leba_sort", 1, "saveSortInfo", paramSharedPreferences);
    }
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
  
  public static void a(List<LebaViewItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramList.size());
    localLinkedHashSet.addAll(paramList);
    paramList.clear();
    paramList.addAll(localLinkedHashSet);
  }
  
  public static void a(List<LebaViewItem> paramList1, List<LebaViewItem> paramList2)
  {
    Collections.sort(paramList2, new LebaUtil.LebaItemComparator());
    paramList2 = paramList2.iterator();
    int j;
    for (int i = -1; paramList2.hasNext(); i = j)
    {
      LebaViewItem localLebaViewItem1 = (LebaViewItem)paramList2.next();
      j = i;
      if (a(localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.sPriority) != i)
      {
        LebaViewItem localLebaViewItem2 = new LebaViewItem();
        localLebaViewItem2.jdField_a_of_type_JavaLangString = "empty_normal";
        paramList1.add(localLebaViewItem2);
        j = a(localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.sPriority);
      }
      paramList1.add(localLebaViewItem1);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getPreferences().edit();
    paramAppRuntime.putString("sp_key_leba_upgrade_info", "5295");
    paramAppRuntime.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtil", 2, String.format("update version, buildNum[%s]", new Object[] { "5295" }));
    }
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
    paramAppRuntime.putInt("sp_key_leba_layout_type", paramInt1);
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
            ((JSONObject)localObject).put("uiResId", localGroupInfo.jdField_a_of_type_Long);
            ((JSONObject)localObject).put("groudId", localGroupInfo.jdField_a_of_type_Int);
            ((JSONObject)localObject).put("index", localGroupInfo.b);
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
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences().edit();
      paramAppRuntime.putBoolean("sp_key_leba_need_req_has_closed_flag", paramBoolean);
      paramAppRuntime.apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.i("leba_study", 1, "setNeedReqHasClosedFlag", paramAppRuntime);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 4026;
  }
  
  public static boolean a(LebaViewItem paramLebaViewItem)
  {
    if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.cDataType == 1) && (!TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName))) {
      return "qzone_feedlist".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName);
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    try
    {
      boolean bool = paramAppRuntime.getPreferences().getBoolean("sp_key_leba_need_req_has_closed_flag", false);
      return bool;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.i("leba_sort", 1, "checkNeedReqHasClosedFlag", paramAppRuntime);
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, long paramLong, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    boolean bool2 = true;
    if (paramLong == 100000L) {
      return (!paramBoolean) && (c(paramAppRuntime));
    }
    if (paramBoolean)
    {
      paramAppRuntime = (LebaPluginInfo)paramMap.get(Long.valueOf(paramLong));
      if (paramAppRuntime != null)
      {
        bool1 = bool2;
        if (paramAppRuntime == null) {
          break label88;
        }
        bool1 = bool2;
        if (paramAppRuntime.showInSimpleMode != 0) {
          break label88;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (LebaShowListManager.a().a(paramLong)) {
        break label88;
      }
    }
    boolean bool1 = false;
    label88:
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("needShowRedDot, id=");
      paramAppRuntime.append(paramLong);
      paramAppRuntime.append(", isSimpleMode=");
      paramAppRuntime.append(paramBoolean);
      paramAppRuntime.append(", needShow=");
      paramAppRuntime.append(bool1);
      QLog.i("LebaUtil", 2, paramAppRuntime.toString());
    }
    return bool1;
  }
  
  public static int b(AppRuntime paramAppRuntime)
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
  
  public static void b(List<LebaViewItem> paramList, List<Integer> paramList1)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if ((paramList1 != null) && (!paramList1.isEmpty()))
      {
        StringBuilder localStringBuilder = new StringBuilder("sortTableItem");
        localStringBuilder.append(" us=");
        localStringBuilder.append(paramList1);
        ArrayList localArrayList = new ArrayList();
        Collections.sort(paramList, new LebaUtil.LebaItemComparator());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
          try
          {
            i = paramList1.indexOf(Integer.valueOf((int)localLebaViewItem.jdField_a_of_type_Long));
            if (i >= 0) {
              localLebaViewItem.b = i;
            } else {
              localLebaViewItem.b = 2147483647;
            }
          }
          catch (Exception localException)
          {
            QLog.i("leba_sort", 1, "sortTableItem", localException);
          }
          if (!localLebaViewItem.c())
          {
            localArrayList.add(localLebaViewItem);
          }
          else
          {
            localStringBuilder.append(",fix ");
            localStringBuilder.append(localLebaViewItem.jdField_a_of_type_Long);
          }
        }
        QLog.i("leba_sort", 1, localStringBuilder.toString());
        Collections.sort(localArrayList, new LebaUtil.LebaTableComparator());
        int i = 0;
        int k;
        for (int j = 0; i < paramList.size(); j = k)
        {
          k = j;
          if (!((LebaViewItem)paramList.get(i)).c())
          {
            k = j;
            if (j < localArrayList.size())
            {
              paramList.set(i, localArrayList.get(j));
              k = j + 1;
            }
          }
          i += 1;
        }
        return;
      }
      QLog.i("leba_sort", 1, "userSortList == null || userSortList.isEmpty()");
      Collections.sort(paramList, new LebaUtil.LebaItemComparator());
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences().edit();
      paramAppRuntime.putInt("sp_key_leba_net_has_closed_flag", paramInt);
      paramAppRuntime.apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.i("leba_study", 1, "setNetHasClosedFlag", paramAppRuntime);
    }
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getPreferences().getString("sp_key_leba_upgrade_info", "");
    boolean bool = "5295".equals(paramAppRuntime) ^ true;
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtil", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramAppRuntime, "5295" }));
    }
    return bool;
  }
  
  public static int c(AppRuntime paramAppRuntime)
  {
    try
    {
      int i = paramAppRuntime.getPreferences().getInt("sp_key_leba_net_has_closed_flag", 0);
      return i;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.i("leba_study", 1, "getNetReqHasClosedFlag", paramAppRuntime);
    }
    return 0;
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    return e(paramAppRuntime) == 1;
  }
  
  public static int d(AppRuntime paramAppRuntime)
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
  
  public static int e(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    int i = paramAppRuntime.getPreferences().getInt("sp_key_leba_layout_type", 0);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getLebaLayoutType =");
    paramAppRuntime.append(i);
    QLog.d("LebaUtil", 1, paramAppRuntime.toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaUtil
 * JD-Core Version:    0.7.0.1
 */