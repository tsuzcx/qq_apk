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
    return paramAppRuntime.getPreferences().getLong("sp_key_leba_plugin_user_sort_time" + paramInt, 0L);
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
      int i;
      JSONObject localJSONObject;
      GroupInfo localGroupInfo;
      int j;
      try
      {
        paramAppRuntime = new JSONArray(paramAppRuntime);
        i = 0;
        if (i < paramAppRuntime.length())
        {
          localJSONObject = paramAppRuntime.getJSONObject(i);
          JSONArray localJSONArray = localJSONObject.names();
          if (localJSONArray == null) {
            break label253;
          }
          localGroupInfo = new GroupInfo();
          j = 0;
          if (j >= localJSONArray.length()) {
            break label212;
          }
          String str = localJSONArray.getString(j);
          try
          {
            if ("uiResId".equals(str)) {
              localGroupInfo.jdField_a_of_type_Long = localJSONObject.getLong(str);
            } else if ("groudId".equals(str)) {
              localGroupInfo.jdField_a_of_type_Int = localJSONObject.getInt(str);
            }
          }
          catch (Exception localException)
          {
            a = true;
            QLog.e("LebaUtil", 1, "getGroupInfo", localException);
          }
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
      if ("index".equals(localException))
      {
        localGroupInfo.b = localJSONObject.getInt(localException);
        break label260;
        label212:
        localArrayList.add(localGroupInfo);
        if (QLog.isColorLevel()) {
          QLog.i("LebaUtil", 2, "" + localGroupInfo);
        }
        label253:
        i += 1;
        continue;
      }
      label260:
      j += 1;
    }
  }
  
  public static List<Integer> a(AppRuntime paramAppRuntime, int paramInt)
  {
    localArrayList = new ArrayList();
    AppRuntime localAppRuntime = null;
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences().getString("sp_key_leba_plugin_user_sort_list" + paramInt, "");
      localAppRuntime = paramAppRuntime;
      if (!TextUtils.isEmpty(paramAppRuntime))
      {
        localAppRuntime = paramAppRuntime;
        JSONArray localJSONArray = new JSONArray(paramAppRuntime);
        paramInt = 0;
        for (;;)
        {
          localAppRuntime = paramAppRuntime;
          if (paramInt >= localJSONArray.length()) {
            break;
          }
          localAppRuntime = paramAppRuntime;
          localArrayList.add(Integer.valueOf(localJSONArray.getInt(paramInt)));
          paramInt += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramAppRuntime)
    {
      a = true;
      QLog.i("leba_sort", 1, "getSortInfo " + localAppRuntime, paramAppRuntime);
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
      QPublicFragmentActivity.a(paramContext, LebaTableMgrFragment.class);
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
        paramSharedPreferences.putString("sp_key_leba_plugin_user_sort_list" + paramInt, localJSONArray.toString());
      }
    }
    catch (Exception paramSharedPreferences)
    {
      QLog.i("leba_sort", 1, "saveSortInfo", paramSharedPreferences);
      return;
    }
    if (paramLong != null) {
      paramSharedPreferences.putLong("sp_key_leba_plugin_user_sort_time" + paramInt, paramLong.longValue());
    }
    paramSharedPreferences.commit();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.e("LebaUtil", 1, "recordApiEmpty tag = " + paramString1 + ", method = " + paramString2 + ",apiName = " + paramString3);
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
    paramAppRuntime.putString("sp_key_leba_upgrade_info", "5105");
    paramAppRuntime.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtil", 2, String.format("update version, buildNum[%s]", new Object[] { "5105" }));
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaUtil", 2, "saveLebaGroupSeq，seq=" + paramInt);
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
    QLog.i("LebaUtil", 1, "saveLebaInfo,layoutType = " + paramInt1 + ",pluginType" + paramInt2);
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
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
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
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("uiResId", localGroupInfo.jdField_a_of_type_Long);
            localJSONObject.put("groudId", localGroupInfo.jdField_a_of_type_Int);
            localJSONObject.put("index", localGroupInfo.b);
            localJSONArray.put(localJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("LebaUtil", 2, "" + localGroupInfo);
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
    } while (!QLog.isColorLevel());
    QLog.i("LebaUtil", 2, "saveGroupInfo, result=" + true);
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
    if (paramLong == 100000L) {
      return (!paramBoolean) && (c(paramAppRuntime));
    }
    boolean bool;
    if (paramBoolean)
    {
      paramAppRuntime = (LebaPluginInfo)paramMap.get(Long.valueOf(paramLong));
      if ((paramAppRuntime != null) && ((paramAppRuntime == null) || (paramAppRuntime.showInSimpleMode != 0))) {
        break label132;
      }
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaUtil", 2, "needShowRedDot, id=" + paramLong + ", isSimpleMode=" + paramBoolean + ", needShow=" + bool);
      }
      return bool;
      if (!LebaShowListManager.a().a(paramLong)) {
        bool = false;
      } else {
        label132:
        bool = true;
      }
    }
  }
  
  public static int b(AppRuntime paramAppRuntime)
  {
    int i;
    if (paramAppRuntime == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = paramAppRuntime.getPreferences().getInt("sp_key_leba_group_seq", 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("LebaUtil", 2, "getLebaGroup, seq=" + j);
    return j;
  }
  
  public static void b(List<LebaViewItem> paramList, List<Integer> paramList1)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        QLog.i("leba_sort", 1, "userSortList == null || userSortList.isEmpty()");
        Collections.sort(paramList, new LebaUtil.LebaItemComparator());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("sortTableItem");
      localStringBuilder.append(" us=").append(paramList1);
      ArrayList localArrayList = new ArrayList();
      Collections.sort(paramList, new LebaUtil.LebaItemComparator());
      Iterator localIterator = paramList.iterator();
      LebaViewItem localLebaViewItem;
      while (localIterator.hasNext())
      {
        localLebaViewItem = (LebaViewItem)localIterator.next();
        for (;;)
        {
          try
          {
            j = paramList1.indexOf(Integer.valueOf((int)localLebaViewItem.jdField_a_of_type_Long));
            if (j < 0) {
              continue;
            }
            localLebaViewItem.b = j;
          }
          catch (Exception localException)
          {
            QLog.i("leba_sort", 1, "sortTableItem", localException);
            continue;
            localStringBuilder.append(",fix ").append(localLebaViewItem.jdField_a_of_type_Long);
          }
          if (localLebaViewItem.c()) {
            continue;
          }
          localArrayList.add(localLebaViewItem);
          break;
          localLebaViewItem.b = 2147483647;
        }
      }
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      Collections.sort(localArrayList, new LebaUtil.LebaTableComparator());
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
    if (!"5105".equals(paramAppRuntime)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaUtil", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramAppRuntime, "5105" }));
      }
      return bool;
    }
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
    QLog.i("LebaUtil", 1, "getLebaPluginType =" + i);
    return i;
  }
  
  public static int e(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    int i = paramAppRuntime.getPreferences().getInt("sp_key_leba_layout_type", 0);
    QLog.d("LebaUtil", 1, "getLebaLayoutType =" + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaUtil
 * JD-Core Version:    0.7.0.1
 */