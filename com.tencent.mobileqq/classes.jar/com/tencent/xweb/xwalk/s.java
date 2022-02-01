package com.tencent.xweb.xwalk;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.xweb.i;
import com.tencent.xweb.j;
import com.tencent.xweb.k;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;

public class s
  implements k
{
  private ConcurrentMap<String, i> a = new ConcurrentHashMap();
  private j b;
  private ReflectMethod c;
  private ReflectMethod d;
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    paramString = XWalkCoreWrapper.invokeRuntimeChannel(80013, new Object[] { Boolean.valueOf(paramBoolean), paramString });
    return ((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue());
  }
  
  public static s b()
  {
    return s.a.a();
  }
  
  private void b(Object paramObject)
  {
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject[0] instanceof String))
    {
      if (paramObject.length < 2) {
        return;
      }
      String str = (String)paramObject[0];
      i locali = (i)this.a.get(str);
      if (locali != null) {
        locali.a(str, Arrays.copyOfRange(paramObject, 1, paramObject.length));
      }
    }
  }
  
  public void a()
  {
    a("xprofile.frameCost", 10000, 0);
  }
  
  public void a(j paramj)
  {
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {}
    try
    {
      if (this.d == null)
      {
        Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
        if (localClass == null) {
          return;
        }
        this.d = new ReflectMethod(localClass, "manualStopProfile", new Class[] { Integer.TYPE });
      }
      this.b = paramj;
      this.d.invoke(new Object[] { Integer.valueOf(0) });
      return;
    }
    catch (Exception paramj)
    {
      label82:
      break label82;
    }
    Log.e("XWebProfilerController", "manualStartOrStopTracingProfileUsingConfig reflect failed");
  }
  
  public void a(Object paramObject)
  {
    j localj = this.b;
    if (localj != null)
    {
      localj.a(paramObject);
      return;
    }
    b(paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {}
    try
    {
      if (this.c == null)
      {
        localObject = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
        if (localObject == null) {
          return;
        }
        this.c = new ReflectMethod((Class)localObject, "manualStartProfile", new Class[] { Integer.TYPE, Bundle.class });
      }
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("enabledTraceCategory", paramString);
      ((Bundle)localObject).putInt("traceSampleRatio", paramInt);
      this.c.invoke(new Object[] { Integer.valueOf(0), localObject });
      return;
    }
    catch (Exception paramString)
    {
      label108:
      break label108;
    }
    Log.e("XWebProfilerController", "manualStartOrStopTracingProfileUsingConfig reflect failed");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("enabledTraceCategory", paramString);
    localBundle.putInt("traceSampleRatio", paramInt1);
    localBundle.putInt("enableWindowPerformanceSampleRatio", paramInt2);
    if (XWalkCoreWrapper.getInstance().hasFeature(4))
    {
      Log.d("XWebProfilerController", "setProfileConfig via INTERNAL_XPROFILE_NG");
      XWalkCoreWrapper.invokeRuntimeChannel(80012, new Object[] { localBundle });
      return;
    }
    if (XWalkCoreWrapper.getInstance().hasFeature(0)) {}
    try
    {
      paramString = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
      if (paramString == null) {
        return;
      }
      new ReflectMethod(paramString, "setProfileConfig", new Class[] { Bundle.class }).invoke(new Object[] { localBundle });
      return;
    }
    catch (Exception paramString)
    {
      label123:
      break label123;
    }
    Log.e("XWebProfilerController", "setProfileConfig reflect failed");
  }
  
  public boolean a(String paramString, @Nullable i parami)
  {
    if (parami == null)
    {
      if (this.a.containsKey(paramString))
      {
        this.a.remove(paramString);
        a(false, paramString);
        return true;
      }
      return false;
    }
    if ((!this.a.containsKey(paramString)) && (!a(true, paramString))) {
      return false;
    }
    this.a.put(paramString, parami);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.s
 * JD-Core Version:    0.7.0.1
 */