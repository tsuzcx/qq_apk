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
  public static final boolean a = false;
  private static String b;
  private List<String> c = new CopyOnWriteArrayList();
  private Map<String, String[]> d = new ConcurrentHashMap();
  private Map<String, String[]> e = new ConcurrentHashMap();
  
  private static int a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString().hashCode();
  }
  
  public static SPStatInspector a()
  {
    return SPStatInspector.InspectorHolder.a;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    if (paramString.contains("com.oppo.embryo")) {
      return true;
    }
    return paramString.contains(".") ^ true;
  }
  
  private static SPStatInspector.StackInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\|");
    if (paramString.length != 3) {
      return null;
    }
    return new SPStatInspector.StackInfo(paramString[0], paramString[1], paramString[2]);
  }
  
  public void onIllegalModify(String paramString1, String paramString2, Object paramObject)
  {
    if (a)
    {
      if (MobileQQ.sProcessId != 1) {
        return;
      }
      if (TextUtils.isEmpty(b)) {
        b = MobileQQ.getContext().getPackageName();
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && ((paramObject instanceof String)))
      {
        paramObject = (String)paramObject;
        if (TextUtils.isEmpty(paramObject)) {
          return;
        }
        boolean bool = b.equals(paramString2);
        if (bool) {
          this.d.put(paramString1, new String[] { paramString2, null });
        } else {
          this.e.put(paramString1, new String[] { paramString2, paramObject });
        }
        if (bool)
        {
          paramObject = (String[])this.e.get(paramString1);
          if (paramObject != null)
          {
            paramString2 = paramObject[0];
            paramObject = paramObject[1];
            break label186;
          }
        }
        else
        {
          if ((String[])this.d.get(paramString1) != null) {
            break label186;
          }
        }
        paramString2 = null;
        paramObject = paramString2;
        label186:
        if (!(TextUtils.isEmpty(paramString2) ^ true)) {
          return;
        }
        Object localObject1 = b(paramObject);
        if (localObject1 == null) {
          return;
        }
        paramObject = ((SPStatInspector.StackInfo)localObject1).c;
        String str = ((SPStatInspector.StackInfo)localObject1).a;
        Object localObject2 = ((SPStatInspector.StackInfo)localObject1).b;
        if ((!a(str)) && (!TextUtils.isEmpty(paramObject)))
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            return;
          }
          if (this.c.contains(paramObject)) {
            return;
          }
          this.c.add(paramObject);
          localObject1 = SharedPreferencesProxyManager.getInstance().getProxy("sp_dm_report", 0).edit();
          int i = a(str, (String)localObject2, paramString2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append('|');
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append('|');
          ((StringBuilder)localObject2).append(paramString2);
          ((StringBuilder)localObject2).append('|');
          ((StringBuilder)localObject2).append(paramObject);
          ((SharedPreferences.Editor)localObject1).putString(String.valueOf(i), ((StringBuilder)localObject2).toString());
          ((SharedPreferences.Editor)localObject1).commit();
        }
      }
    }
  }
  
  public void printLog(boolean paramBoolean, String paramString1, String paramString2, Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.sp.SPStatInspector
 * JD-Core Version:    0.7.0.1
 */