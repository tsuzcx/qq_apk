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
  public String a;
  int b;
  int c;
  public int d;
  public int e;
  ArrayList<String> f;
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("reportId", this.a);
        localJSONObject.put("switch_qzone", this.b);
        localJSONObject.put("switch_qq", this.c);
        localJSONObject.put("report_count", this.d);
        localJSONObject.put("report_time", this.e);
        if ((this.f != null) && (this.f.size() > 0))
        {
          localObject = new JSONArray();
          Iterator localIterator = this.f.iterator();
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
  
  public boolean a(String paramString)
  {
    ArrayList localArrayList = this.f;
    return (localArrayList != null) && (localArrayList.size() > 0) && (this.f.contains(paramString));
  }
  
  public boolean b()
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
        this.a = ((JSONObject)localObject).optString("reportId");
        this.b = ((JSONObject)localObject).optInt("switch_qzone");
        this.c = ((JSONObject)localObject).optInt("switch_qq");
        this.d = ((JSONObject)localObject).optInt("report_count");
        this.e = ((JSONObject)localObject).optInt("report_time");
        localObject = ((JSONObject)localObject).optJSONArray("blacks");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          this.f = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            if (!TextUtils.isEmpty(((JSONArray)localObject).optString(i))) {
              this.f.add(((JSONArray)localObject).optString(i));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.WMDConfig
 * JD-Core Version:    0.7.0.1
 */