package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusConstants;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class OnlineStatusBean
{
  private ArrayList<OnlineStatusItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, OnlineStatusItem> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private ArrayList<OnlineStatusItem> b = new ArrayList(9);
  
  public OnlineStatusBean()
  {
    int i = 0;
    while (i < OnlineStatusConstants.a.length)
    {
      AppRuntime.Status localStatus = OnlineStatusConstants.a[i];
      OnlineStatusItem localOnlineStatusItem = new OnlineStatusItem(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localOnlineStatusItem);
      this.jdField_a_of_type_JavaUtilHashMap.put(OnlineStatusItem.a(localStatus, localOnlineStatusItem.jdField_a_of_type_Long), localOnlineStatusItem);
      i += 1;
    }
  }
  
  public static OnlineStatusBean a(String paramString)
  {
    OnlineStatusBean localOnlineStatusBean = new OnlineStatusBean();
    try
    {
      paramString = new JSONObject(paramString);
      a(paramString, "online_status", localOnlineStatusBean.jdField_a_of_type_JavaUtilHashMap, localOnlineStatusBean.jdField_a_of_type_JavaUtilArrayList);
      a(paramString, "online_mood", localOnlineStatusBean.jdField_a_of_type_JavaUtilHashMap, localOnlineStatusBean.b);
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localOnlineStatusBean.toString());
      QLog.d("OnlineStatusConfProcessor", 1, paramString.toString());
      return localOnlineStatusBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return localOnlineStatusBean;
  }
  
  private OnlineStatusItem a(AppRuntime.Status paramStatus, long paramLong, List<? extends OnlineStatusItem> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i = 0;
    while (i < paramList.size())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)paramList.get(i);
      if ((localOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (localOnlineStatusItem.jdField_a_of_type_Long == paramLong)) {
        return localOnlineStatusItem;
      }
      i += 1;
    }
    return null;
  }
  
  public static ArrayList<OnlineStatusItem> a(List<? extends OnlineStatusItem> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)paramList.next();
      if ((!bool) || (localOnlineStatusItem.jdField_a_of_type_Boolean)) {
        localArrayList.add(localOnlineStatusItem);
      }
    }
    return localArrayList;
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, HashMap<String, OnlineStatusItem> paramHashMap, ArrayList<OnlineStatusItem> paramArrayList)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          paramString = (JSONObject)paramJSONObject.get(i);
          if (paramString != null)
          {
            long l = paramString.optLong("id");
            Object localObject = paramString.optString("title");
            String str1 = paramString.optString("icon");
            String str2 = paramString.optString("big_icon");
            if ((l != 0L) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)))
            {
              if ((l == 1000L) && (a()))
              {
                QLog.d("OnlineStatusConfProcessor", 1, "incompatible for battery status");
              }
              else
              {
                localObject = new OnlineStatusItem(l, (String)localObject, str1, str2);
                ((OnlineStatusItem)localObject).f = paramString.optString("resUrl");
                ((OnlineStatusItem)localObject).g = paramString.optString("md5");
                ((OnlineStatusItem)localObject).jdField_a_of_type_Boolean = paramString.optBoolean("showInStudyMode", true);
                paramHashMap.put(OnlineStatusItem.a(AppRuntime.Status.online, ((OnlineStatusItem)localObject).jdField_a_of_type_Long), localObject);
                paramArrayList.add(localObject);
              }
            }
            else {
              QLog.d("OnlineStatusConfProcessor", 1, new Object[] { "error pamas:id=", Long.valueOf(l), " title=", localObject, " icon=", str1, " bigIcon=", str2 });
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse array:", paramJSONObject.toString() });
      }
    }
  }
  
  public static boolean a()
  {
    return OnLineStatusHelper.a() <= 0;
  }
  
  public OnlineStatusItem a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = OnlineStatusItem.a((AppRuntime.Status)localObject, paramLong);
    localObject = (OnlineStatusItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new OnlineStatusItem(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    ArrayList localArrayList1 = a(this.jdField_a_of_type_JavaUtilArrayList);
    ArrayList localArrayList2 = c();
    if (localArrayList1 == null) {
      return localArrayList2;
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  public ArrayList<OnlineStatusItem> a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!a(paramStatus, paramLong)) {
      return a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    paramStatus = a(paramStatus, paramLong, c());
    if (paramStatus == null) {
      return a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
      if ((!bool) || (localOnlineStatusItem.jdField_a_of_type_Boolean)) {
        if ((localOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online) && (localOnlineStatusItem.jdField_a_of_type_Long == 1055L)) {
          localArrayList.add(paramStatus);
        } else {
          localArrayList.add(localOnlineStatusItem);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    if ((paramLong == 1055L) && (paramStatus == AppRuntime.Status.online)) {
      return true;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
      if ((paramLong == localOnlineStatusItem.jdField_a_of_type_Long) && (paramStatus == localOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status)) {
        return true;
      }
    }
    return false;
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    return a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public ArrayList<OnlineStatusItem> c()
  {
    return a(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
      localStringBuilder.append("id:");
      localStringBuilder.append(localOnlineStatusItem.jdField_a_of_type_Long);
      localStringBuilder.append(" ");
      localStringBuilder.append("title:");
      localStringBuilder.append(localOnlineStatusItem.b);
      localStringBuilder.append(" ");
      localStringBuilder.append("icon:");
      localStringBuilder.append(localOnlineStatusItem.c);
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineStatusBean
 * JD-Core Version:    0.7.0.1
 */