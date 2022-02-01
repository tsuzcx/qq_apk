package com.tencent.qqperf.monitor.sp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager.ISpLogCallback;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

public final class SPStatInspector
  implements SharedPreferencesProxyManager.ISpLogCallback
{
  private static String jdField_a_of_type_JavaLangString = null;
  public static final boolean a;
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<String, String[]> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, String[]> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  private static int a(String paramString1, String paramString2, String paramString3)
  {
    return (paramString1 + paramString2 + paramString3).hashCode();
  }
  
  private static SPStatInspector.StackInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split("\\|");
    } while (paramString.length != 3);
    return new SPStatInspector.StackInfo(paramString[0], paramString[1], paramString[2]);
  }
  
  public static SPStatInspector a()
  {
    return SPStatInspector.InspectorHolder.a;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.contains("com.oppo.embryo")) || (!paramString.contains("."))) {
      return true;
    }
    return false;
  }
  
  public void onIllegalModify(String paramString1, String paramString2, Object paramObject)
  {
    String str = null;
    int i = 1;
    if ((!jdField_a_of_type_Boolean) || (MobileQQ.sProcessId != 1)) {}
    label388:
    label392:
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = MobileQQ.getContext().getPackageName();
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && ((paramObject instanceof String)) && (!TextUtils.isEmpty((String)paramObject)))
      {
        boolean bool = jdField_a_of_type_JavaLangString.equals(paramString2);
        paramObject = (String)paramObject;
        if (bool)
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString1, new String[] { paramString2, null });
          label111:
          if (!bool) {
            break label353;
          }
          paramString2 = (String[])this.b.get(paramString1);
          if (paramString2 == null) {
            break label345;
          }
          paramObject = paramString2[0];
          paramString2 = paramString2[1];
          label142:
          if (TextUtils.isEmpty(paramObject)) {
            break label388;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label392;
          }
          Object localObject = a(paramString2);
          if (localObject == null) {
            break;
          }
          paramString2 = ((SPStatInspector.StackInfo)localObject).c;
          str = ((SPStatInspector.StackInfo)localObject).jdField_a_of_type_JavaLangString;
          localObject = ((SPStatInspector.StackInfo)localObject).b;
          if ((a(str)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty((CharSequence)localObject)) || (this.jdField_a_of_type_JavaUtilList.contains(paramString2))) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.add(paramString2);
          SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("sp_dm_report", 0).edit();
          localEditor.putString(String.valueOf(a(str, (String)localObject, paramObject)), paramString1 + '|' + str + '|' + paramObject + '|' + paramString2);
          localEditor.commit();
          return;
          this.b.put(paramString1, new String[] { paramString2, paramObject });
          break label111;
          label345:
          paramString2 = null;
          paramObject = str;
          break label142;
          label353:
          if ((String[])this.jdField_a_of_type_JavaUtilMap.get(paramString1) != null)
          {
            str = paramString2;
            paramString2 = paramObject;
            paramObject = str;
            break label142;
          }
          paramString2 = null;
          paramObject = str;
          break label142;
          i = 0;
        }
      }
    }
  }
  
  public void printLog(boolean paramBoolean, String paramString1, String paramString2, Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.sp.SPStatInspector
 * JD-Core Version:    0.7.0.1
 */