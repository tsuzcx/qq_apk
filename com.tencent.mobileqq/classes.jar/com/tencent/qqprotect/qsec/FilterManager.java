package com.tencent.qqprotect.qsec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.common.QSecRptHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterManager
  implements OnScanListener
{
  private static volatile FilterManager a;
  private static String b = "qp_fm_config";
  private static String c = "_last_time";
  private Map<String, Filter> d = new HashMap();
  
  public static FilterManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FilterManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean a(String paramString, long paramLong)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences(b, 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(c);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
      return true;
    }
    return false;
  }
  
  private long b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(b, 0);
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(c);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    return -1L;
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new ICloudAVEngine.ApkDetectBundle(paramString);
    CloudAVEngineImpl.a().cloudDetect(paramString, true, false, null);
  }
  
  public Filter a(String paramString)
  {
    return (Filter)this.d.get(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    a(paramString, new Date().getTime());
    QLog.d("QSFM", 1, String.format("scan started: %s", new Object[] { paramString }));
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      this.d.clear();
      paramArrayOfByte = new JSONArray(new String(paramArrayOfByte));
      int i = 0;
      while (i < paramArrayOfByte.length())
      {
        JSONObject localJSONObject = paramArrayOfByte.getJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.has("type"))) {
          this.d.put(localJSONObject.getString("type"), new Filter(localJSONObject));
        }
        i += 1;
      }
      return true;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public IScanner b(String paramString)
  {
    if (paramString.equalsIgnoreCase("App")) {
      return new PackageScanner(this);
    }
    return null;
  }
  
  public void b()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      long l1 = b((String)localObject, -1L);
      if (l1 != -1L)
      {
        long l2 = new Date().getTime();
        Filter localFilter = a((String)localObject);
        if (localFilter != null)
        {
          long l3 = l2 - l1;
          if (l3 < localFilter.b() * 1000L)
          {
            QLog.d("QSFM", 1, String.format("scan not start: %s:%d-%d=%d:%d", new Object[] { localObject, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(localFilter.b() * 1000L) }));
            continue;
          }
        }
      }
      localObject = b((String)localObject);
      if (localObject != null) {
        ThreadManager.post(new FilterManager.1(this, (IScanner)localObject), 5, null, true);
      }
    }
  }
  
  public void b(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      Filter localFilter = a(paramString);
      if ((localFilter != null) && (localFilter.a(paramObject)))
      {
        c(FieldHelper.a(paramObject, "packageName").toString());
        if (localFilter.a() > 100000)
        {
          QSecRptHelper localQSecRptHelper = new QSecRptHelper();
          Iterator localIterator = localFilter.c().iterator();
          while (localIterator.hasNext())
          {
            paramString = FieldHelper.b(paramObject, (String)localIterator.next());
            if (paramString != null) {
              paramString = paramString.toString();
            } else {
              paramString = "";
            }
            localQSecRptHelper.a(paramString);
          }
          QSecRptController.a(localQSecRptHelper.toString(), localFilter.a());
        }
      }
    }
  }
  
  public void c(String paramString, Object paramObject)
  {
    QLog.d("QSFM", 1, String.format("scan completed: %s", new Object[] { paramString }));
    CloudAVEngineImpl.a().flushRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.FilterManager
 * JD-Core Version:    0.7.0.1
 */