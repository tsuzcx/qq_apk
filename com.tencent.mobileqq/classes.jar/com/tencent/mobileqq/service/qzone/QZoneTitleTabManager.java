package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.st_report_info;
import ajjy;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.service.qzone.QZoneTitleTabManager.TabInfo;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mpl;
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
    QLog.i("QZoneTitleTabManager", 1, "getTabInfos:" + localArrayList);
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      QLog.i("QZoneTitleTabManager", 2, "processConfig:" + paramArrayList);
    }
    do
    {
      return null;
      if (paramArrayList.size() == 1)
      {
        localObject2 = new ArrayList(1);
        QZoneTitleTabManager.TabInfo localTabInfo = (QZoneTitleTabManager.TabInfo)paramArrayList.get(0);
        if ((localTabInfo != null) && (localTabInfo.jdField_a_of_type_Int == 50))
        {
          localObject1 = localTabInfo.jdField_a_of_type_JavaLangString;
          paramArrayList = (ArrayList<QZoneTitleTabManager.TabInfo>)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramArrayList = ajjy.a(2131654130);
          }
          ((ArrayList)localObject2).add(new QZoneTitleTabManager.TabInfo(localTabInfo.jdField_a_of_type_Int, paramArrayList));
        }
        return localObject2;
      }
    } while (paramArrayList.size() < 2);
    Object localObject1 = new ArrayList(2);
    Object localObject2 = (QZoneTitleTabManager.TabInfo)paramArrayList.get(0);
    paramArrayList = (QZoneTitleTabManager.TabInfo)paramArrayList.get(1);
    if (((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_Int == 50) {
      if (!TextUtils.isEmpty(((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_JavaLangString)) {}
    }
    for (((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_JavaLangString = ajjy.a(2131646591);; ((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_JavaLangString = ajjy.a(2131646592))
    {
      ((ArrayList)localObject1).add(localObject2);
      if (!a(paramArrayList)) {
        break;
      }
      ((ArrayList)localObject1).add(paramArrayList);
      return localObject1;
      ((QZoneTitleTabManager.TabInfo)localObject2).jdField_a_of_type_Int = 50;
    }
    QLog.e("QZoneTitleTabManager", 1, "procesConfig not support secondTab:" + paramArrayList);
    return localObject1;
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
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
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        QLog.i("QZoneTitleTabManager", 2, "下发的标题栏的配置是空的,使用本地配置");
        return;
      }
      parammobile_count_rsp_new = new ArrayList(2);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        entrance_cfg localentrance_cfg = (entrance_cfg)((Iterator)localObject).next();
        if (localentrance_cfg != null)
        {
          QZoneTitleTabManager.TabInfo localTabInfo = new QZoneTitleTabManager.TabInfo(localentrance_cfg.iEntranceId, localentrance_cfg.sEntranceName);
          localTabInfo.jdField_b_of_type_JavaLangString = localentrance_cfg.sEntranceAction;
          if (localentrance_cfg.isAnchor != 0) {}
          for (boolean bool = true;; bool = false)
          {
            localTabInfo.jdField_a_of_type_Boolean = bool;
            if (localentrance_cfg.stReportInfo != null)
            {
              localTabInfo.jdField_b_of_type_Int = localentrance_cfg.stReportInfo.report_first_page;
              localTabInfo.c = localentrance_cfg.stReportInfo.report_second_page;
            }
            parammobile_count_rsp_new.add(localTabInfo);
            break;
          }
        }
      }
      parammobile_count_rsp_new = a(parammobile_count_rsp_new);
    } while ((parammobile_count_rsp_new == null) || (parammobile_count_rsp_new.size() <= 0));
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(parammobile_count_rsp_new);
    a(paramQQAppInterface, jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    jdField_a_of_type_Int = 3;
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
    BaseApplicationImpl.getApplication().getSharedPreferences("qzone_tab_info_" + paramQQAppInterface.getAccount(), 0).edit().remove("qzone_tab_key").apply();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, List<QZoneTitleTabManager.TabInfo> paramList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(((QZoneTitleTabManager.TabInfo)paramList.next()).a());
      }
      return;
    }
    catch (JSONException paramList)
    {
      QLog.e("QZoneTitleTabManager", 2, paramList, new Object[0]);
      for (paramList = null; TextUtils.isEmpty(paramList); paramList = localJSONArray.toString())
      {
        a(paramQQAppInterface);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneTitleTabManager", 2, "save config:" + paramList);
      }
      BaseApplicationImpl.getApplication().getSharedPreferences("qzone_tab_info_" + paramQQAppInterface.getAccount(), 0).edit().putString("qzone_tab_key", paramList).apply();
    }
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Int > 1) {}
    for (;;)
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_tab_info_" + paramString, 0).getString("qzone_tab_key", "");
      if (QLog.isColorLevel()) {
        QLog.i("QZoneTitleTabManager", 2, "loadTabInfo:" + paramString);
      }
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONArray(paramString);
          if ((paramString == null) || (paramString.length() <= 0)) {
            continue;
          }
          int j = paramString.length();
          ArrayList localArrayList = new ArrayList(2);
          int i = 0;
          while (i < j)
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            QZoneTitleTabManager.TabInfo localTabInfo = new QZoneTitleTabManager.TabInfo();
            localTabInfo.a(localJSONObject);
            localArrayList.add(localTabInfo);
            i += 1;
          }
          a(localArrayList);
          if (jdField_a_of_type_Int > 1) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(localArrayList);
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QZoneTitleTabManager", 2, paramString, new Object[0]);
        return;
      }
    }
    QLog.i("QZoneTitleTabManager", 2, "本地没有title上发现tab的配置");
  }
  
  static boolean a(QZoneTitleTabManager.TabInfo paramTabInfo)
  {
    if (paramTabInfo == null) {}
    do
    {
      do
      {
        return false;
        if ((mpl.a(paramTabInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramTabInfo.jdField_a_of_type_JavaLangString))) {
          return true;
        }
        if (paramTabInfo.jdField_a_of_type_Int != 51) {
          break;
        }
      } while (TextUtils.isEmpty(paramTabInfo.jdField_a_of_type_JavaLangString));
      return true;
      if (paramTabInfo.jdField_a_of_type_Int == 15)
      {
        if (!mpl.a(paramTabInfo.jdField_b_of_type_JavaLangString)) {
          paramTabInfo.jdField_b_of_type_JavaLangString = "https://h5.qzone.qq.com/secret/list/{uin}/secret?_proxy=1&_wv=3&source=tab";
        }
        return true;
      }
    } while (paramTabInfo.jdField_a_of_type_Int != 51);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneTitleTabManager
 * JD-Core Version:    0.7.0.1
 */