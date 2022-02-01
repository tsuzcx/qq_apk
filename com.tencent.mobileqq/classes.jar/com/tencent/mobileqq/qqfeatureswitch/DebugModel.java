package com.tencent.mobileqq.qqfeatureswitch;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DebugModel
  implements ISwitchModel
{
  private final ISwitchModel a;
  private final Map<String, FeatureSwitch> b;
  
  private boolean c(String paramString)
  {
    return b().containsKey(paramString) ^ true;
  }
  
  private void d(String paramString, boolean paramBoolean)
  {
    if ((!this.b.containsKey(paramString)) && (!e(paramString, paramBoolean))) {
      return;
    }
    f(paramString, paramBoolean);
  }
  
  private boolean e(String paramString, boolean paramBoolean)
  {
    if (c(paramString))
    {
      QLog.e("DebugModel", 1, new Object[] { "saveToMemoryCache, but no switch with this name : ", paramString });
      return false;
    }
    FeatureSwitch localFeatureSwitch = b(paramString, true);
    localFeatureSwitch.mSwitchEnable = paramBoolean;
    localFeatureSwitch.mSwitchName = paramString;
    this.b.put(paramString, localFeatureSwitch);
    return true;
  }
  
  private void f(String paramString, boolean paramBoolean)
  {
    Object localObject = b(paramString, true);
    ((FeatureSwitch)localObject).mSwitchEnable = paramBoolean;
    ((FeatureSwitch)localObject).mSwitchName = paramString;
    localObject = new Gson().toJson(localObject);
    SharePreferenceUtils.a(BaseApplication.getContext(), "tabSwitchSp", paramString, (String)localObject);
  }
  
  protected FeatureSwitch a(String paramString)
  {
    paramString = SharePreferenceUtils.b(BaseApplication.getContext(), "tabSwitchSp", paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (FeatureSwitch)new Gson().fromJson(paramString, FeatureSwitch.class);
  }
  
  public void a()
  {
    this.b.clear();
    SharePreferenceUtils.c(BaseApplication.getContext(), "tabSwitchSp");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DebugModel", 1, "FeatureSwitch illegal");
      return;
    }
    d(paramString, paramBoolean);
  }
  
  protected FeatureSwitch b(String paramString)
  {
    return (FeatureSwitch)this.b.get(paramString);
  }
  
  public FeatureSwitch b(String paramString, boolean paramBoolean)
  {
    FeatureSwitch localFeatureSwitch = b(paramString);
    if (localFeatureSwitch != null) {
      return localFeatureSwitch;
    }
    localFeatureSwitch = a(paramString);
    if (localFeatureSwitch != null)
    {
      this.b.put(paramString, localFeatureSwitch);
      return localFeatureSwitch;
    }
    return this.a.b(paramString, paramBoolean);
  }
  
  public Map<String, FeatureSwitch> b()
  {
    Map localMap = this.a.b();
    if (localMap == null) {
      return Collections.emptyMap();
    }
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      FeatureSwitch localFeatureSwitch = b(str);
      if (localFeatureSwitch != null)
      {
        localMap.put(str, localFeatureSwitch);
      }
      else
      {
        localFeatureSwitch = a(str);
        if (localFeatureSwitch != null)
        {
          this.b.put(str, localFeatureSwitch);
          localMap.put(str, localFeatureSwitch);
        }
      }
    }
    return localMap;
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    return b(paramString, paramBoolean).mSwitchEnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.DebugModel
 * JD-Core Version:    0.7.0.1
 */