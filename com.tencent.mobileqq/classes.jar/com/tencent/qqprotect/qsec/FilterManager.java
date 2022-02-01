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
  private static volatile FilterManager jdField_a_of_type_ComTencentQqprotectQsecFilterManager;
  private static String jdField_a_of_type_JavaLangString = "qp_fm_config";
  private static String b = "_last_time";
  private Map<String, Filter> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private long a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(b);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    return -1L;
  }
  
  public static FilterManager a()
  {
    if (jdField_a_of_type_ComTencentQqprotectQsecFilterManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqprotectQsecFilterManager == null) {
          jdField_a_of_type_ComTencentQqprotectQsecFilterManager = new FilterManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqprotectQsecFilterManager;
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new ICloudAVEngine.ApkDetectBundle(paramString);
    CloudAVEngineImpl.a().cloudDetect(paramString, true, false, null);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(b);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
      return true;
    }
    return false;
  }
  
  public Filter a(String paramString)
  {
    return (Filter)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public IScanner a(String paramString)
  {
    if (paramString.equalsIgnoreCase("App")) {
      return new PackageScanner(this);
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      long l1 = a((String)localObject, -1L);
      if (l1 != -1L)
      {
        long l2 = new Date().getTime();
        Filter localFilter = a((String)localObject);
        if (localFilter != null)
        {
          long l3 = l2 - l1;
          if (l3 < localFilter.a() * 1000L)
          {
            QLog.d("QSFM", 1, String.format("scan not start: %s:%d-%d=%d:%d", new Object[] { localObject, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(localFilter.a() * 1000L) }));
            continue;
          }
        }
      }
      localObject = a((String)localObject);
      if (localObject != null) {
        ThreadManager.post(new FilterManager.1(this, (IScanner)localObject), 5, null, true);
      }
    }
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
      this.jdField_a_of_type_JavaUtilMap.clear();
      paramArrayOfByte = new JSONArray(new String(paramArrayOfByte));
      int i = 0;
      while (i < paramArrayOfByte.length())
      {
        JSONObject localJSONObject = paramArrayOfByte.getJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.has("type"))) {
          this.jdField_a_of_type_JavaUtilMap.put(localJSONObject.getString("type"), new Filter(localJSONObject));
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
  
  public void b(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      Filter localFilter = a(paramString);
      if ((localFilter != null) && (localFilter.a(paramObject)))
      {
        a(FieldHelper.a(paramObject, "packageName").toString());
        if (localFilter.a() > 100000)
        {
          QSecRptHelper localQSecRptHelper = new QSecRptHelper();
          Iterator localIterator = localFilter.a().iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.FilterManager
 * JD-Core Version:    0.7.0.1
 */