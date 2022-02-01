package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.st_report_info;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.service.qzone.QZoneTitleTabManager.TabInfo;>;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneTitleTabManager
{
  private static volatile int jdField_a_of_type_Int = 0;
  private static final CopyOnWriteArrayList<QZoneTitleTabManager.TabInfo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public static ArrayList<QZoneTitleTabManager.TabInfo> a()
  {
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.addAll(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTabInfos:");
    localStringBuilder.append(localArrayList);
    QLog.i("QZoneTitleTabManager", 1, localStringBuilder.toString());
    return localArrayList;
  }
  
  public static ArrayList<QZoneTitleTabManager.TabInfo> a(Intent paramIntent)
  {
    if (paramIntent != null) {
      return paramIntent.getParcelableArrayListExtra("key_tab_intent");
    }
    return null;
  }
  
  private static ArrayList<QZoneTitleTabManager.TabInfo> a(ArrayList<QZoneTitleTabManager.TabInfo> paramArrayList)
  {
    Object localObject1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject2;
      if (paramArrayList.size() == 1)
      {
        localObject1 = new ArrayList(1);
        QZoneTitleTabManager.TabInfo localTabInfo = (QZoneTitleTabManager.TabInfo)paramArrayList.get(0);
        paramArrayList = (ArrayList<QZoneTitleTabManager.TabInfo>)localObject1;
        if (localTabInfo == null) {
          return paramArrayList;
        }
        paramArrayList = (ArrayList<QZoneTitleTabManager.TabInfo>)localObject1;
        if (localTabInfo.jdField_a_of_type_Int != 50) {
          return paramArrayList;
        }
        localObject2 = localTabInfo.jdField_a_of_type_JavaLangString;
        paramArrayList = (ArrayList<QZoneTitleTabManager.TabInfo>)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramArrayList = HardCodeUtil.a(2131719439);
        }
        ((ArrayList)localObject1).add(new QZoneTitleTabManager.TabInfo(localTabInfo.jdField_a_of_type_Int, paramArrayList));
        return localObject1;
      }
      if (paramArrayList.size() >= 2)
      {
        localObject1 = new ArrayList(2);
        localObject2 = (QZoneTitleTabManager.TabInfo)paramArrayList.get(0);
        paramArrayList = (QZoneTitleTabManager.TabInfo)paramArrayList.get(1);
        if (((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_Int == 50)
        {
          if (TextUtils.isEmpty(((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_JavaLangString)) {
            ((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712331);
          }
        }
        else
        {
          ((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_Int = 50;
          ((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712332);
        }
        ((ArrayList)localObject1).add(localObject2);
        if (a(paramArrayList))
        {
          ((ArrayList)localObject1).add(paramArrayList);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("procesConfig not support secondTab:");
          ((StringBuilder)localObject2).append(paramArrayList);
          QLog.e("QZoneTitleTabManager", 1, ((StringBuilder)localObject2).toString());
        }
        return localObject1;
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processConfig:");
      ((StringBuilder)localObject1).append(paramArrayList);
      QLog.i("QZoneTitleTabManager", 2, ((StringBuilder)localObject1).toString());
    }
    paramArrayList = null;
    return paramArrayList;
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (parammobile_count_rsp_new == null)
    {
      QLog.e("QZoneTitleTabManager", 2, "handleTabInfo rsp=null,使用本地配置");
      return;
    }
    if (parammobile_count_rsp_new.mapEntranceCfg == null)
    {
      QLog.e("QZoneTitleTabManager", 2, "handleTabInfo rsp.mapEntranceCfg==null,使用本地配置");
      return;
    }
    if (!parammobile_count_rsp_new.mapEntranceCfg.containsKey(Integer.valueOf(10)))
    {
      QLog.i("QZoneTitleTabManager", 2, "没有下发标题栏上tab的配置,使用本地配置");
      return;
    }
    Object localObject = (ArrayList)parammobile_count_rsp_new.mapEntranceCfg.get(Integer.valueOf(10));
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      parammobile_count_rsp_new = new ArrayList(2);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        entrance_cfg localentrance_cfg = (entrance_cfg)((Iterator)localObject).next();
        if (localentrance_cfg != null)
        {
          QZoneTitleTabManager.TabInfo localTabInfo = new QZoneTitleTabManager.TabInfo(localentrance_cfg.iEntranceId, localentrance_cfg.sEntranceName);
          localTabInfo.jdField_b_of_type_JavaLangString = localentrance_cfg.sEntranceAction;
          boolean bool;
          if (localentrance_cfg.isAnchor != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localTabInfo.jdField_a_of_type_Boolean = bool;
          if (localentrance_cfg.stReportInfo != null)
          {
            localTabInfo.jdField_b_of_type_Int = localentrance_cfg.stReportInfo.report_first_page;
            localTabInfo.c = localentrance_cfg.stReportInfo.report_second_page;
          }
          parammobile_count_rsp_new.add(localTabInfo);
        }
      }
      parammobile_count_rsp_new = a(parammobile_count_rsp_new);
      if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.size() > 0))
      {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(parammobile_count_rsp_new);
        a(paramQQAppInterface, jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
        jdField_a_of_type_Int = 3;
      }
    }
    else
    {
      QLog.i("QZoneTitleTabManager", 2, "下发的标题栏的配置是空的,使用本地配置");
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.putParcelableArrayListExtra("key_tab_intent", a());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneTitleTabManager", 2, "clearConfig");
    }
    jdField_a_of_type_Int = 2;
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone_tab_info_");
    localStringBuilder.append(paramQQAppInterface.getAccount());
    localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit().remove("qzone_tab_key").apply();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, List<QZoneTitleTabManager.TabInfo> paramList)
  {
    try
    {
      localObject = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONArray)localObject).put(((QZoneTitleTabManager.TabInfo)paramList.next()).a());
      }
      paramList = ((JSONArray)localObject).toString();
    }
    catch (JSONException paramList)
    {
      QLog.e("QZoneTitleTabManager", 2, paramList, new Object[0]);
      paramList = null;
    }
    if (TextUtils.isEmpty(paramList))
    {
      a(paramQQAppInterface);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save config:");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("QZoneTitleTabManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone_tab_info_");
    localStringBuilder.append(paramQQAppInterface.getAccount());
    ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("qzone_tab_key", paramList).apply();
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Int > 1) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("qzone_tab_info_");
    ((StringBuilder)localObject2).append(paramString);
    paramString = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qzone_tab_key", "");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadTabInfo:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("QZoneTitleTabManager", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONArray(paramString);
        if (paramString.length() > 0)
        {
          int j = paramString.length();
          localObject1 = new ArrayList(2);
          int i = 0;
          while (i < j)
          {
            localObject2 = paramString.getJSONObject(i);
            QZoneTitleTabManager.TabInfo localTabInfo = new QZoneTitleTabManager.TabInfo();
            localTabInfo.a((JSONObject)localObject2);
            ((ArrayList)localObject1).add(localTabInfo);
            i += 1;
          }
          a((ArrayList)localObject1);
          if (jdField_a_of_type_Int <= 1)
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)localObject1);
          }
        }
      }
      else
      {
        QLog.i("QZoneTitleTabManager", 2, "本地没有title上发现tab的配置");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneTitleTabManager", 2, paramString, new Object[0]);
    }
  }
  
  static boolean a(QZoneTitleTabManager.TabInfo paramTabInfo)
  {
    if (paramTabInfo == null) {
      return false;
    }
    if ((HttpUtil.isValidUrl(paramTabInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramTabInfo.jdField_a_of_type_JavaLangString))) {
      return true;
    }
    if (paramTabInfo.jdField_a_of_type_Int == 51) {
      return !TextUtils.isEmpty(paramTabInfo.jdField_a_of_type_JavaLangString);
    }
    if (paramTabInfo.jdField_a_of_type_Int == 15)
    {
      if (!HttpUtil.isValidUrl(paramTabInfo.jdField_b_of_type_JavaLangString)) {
        paramTabInfo.jdField_b_of_type_JavaLangString = "https://h5.qzone.qq.com/secret/list/{uin}/secret?_proxy=1&_wv=3&source=tab";
      }
      return true;
    }
    return paramTabInfo.jdField_a_of_type_Int == 51;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneTitleTabManager
 * JD-Core Version:    0.7.0.1
 */