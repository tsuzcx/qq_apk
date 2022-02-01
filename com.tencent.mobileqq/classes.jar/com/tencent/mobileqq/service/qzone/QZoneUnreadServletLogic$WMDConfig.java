package com.tencent.mobileqq.service.qzone;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class QZoneUnreadServletLogic$WMDConfig
{
  int jdField_a_of_type_Int;
  public String a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  int b;
  public int c;
  public int d;
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("reportId", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("switch_qzone", this.jdField_a_of_type_Int);
        localJSONObject.put("switch_qq", this.b);
        localJSONObject.put("report_count", this.c);
        localJSONObject.put("report_time", this.d);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject = new JSONArray();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!TextUtils.isEmpty(str)) {
              ((JSONArray)localObject).put(str);
            }
          }
          localJSONObject.put("blacks", localObject);
        }
        LocalMultiProcConfig.putString4Uin("qzone_wmd_config", localJSONObject.toString(), BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        if (!QLog.isColorLevel()) {
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save wmd config:");
        ((StringBuilder)localObject).append(localJSONObject.toString());
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, localException, new Object[0]);
        return;
      }
    }
    else
    {
      LocalMultiProcConfig.putString4Uin("qzone_wmd_config", "", BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "save wmd config:null");
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      Object localObject = LocalMultiProcConfig.getString4Uin("qzone_wmd_config", "", BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load wmd config:");
        localStringBuilder.append((String)localObject);
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("reportId");
        this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch_qzone");
        this.b = ((JSONObject)localObject).optInt("switch_qq");
        this.c = ((JSONObject)localObject).optInt("report_count");
        this.d = ((JSONObject)localObject).optInt("report_time");
        localObject = ((JSONObject)localObject).optJSONArray("blacks");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            if (!TextUtils.isEmpty(((JSONArray)localObject).optString(i))) {
              this.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject).optString(i));
            }
            i += 1;
          }
        }
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(String paramString)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.WMDConfig
 * JD-Core Version:    0.7.0.1
 */