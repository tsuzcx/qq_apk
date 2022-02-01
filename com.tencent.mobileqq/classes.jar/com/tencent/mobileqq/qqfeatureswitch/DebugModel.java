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
  private final ISwitchModel jdField_a_of_type_ComTencentMobileqqQqfeatureswitchISwitchModel;
  private final Map<String, FeatureSwitch> jdField_a_of_type_JavaUtilMap;
  
  private boolean a(String paramString)
  {
    return a().containsKey(paramString) ^ true;
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (!b(paramString, paramBoolean))) {
      return;
    }
    c(paramString, paramBoolean);
  }
  
  private boolean b(String paramString, boolean paramBoolean)
  {
    if (a(paramString))
    {
      QLog.e("DebugModel", 1, new Object[] { "saveToMemoryCache, but no switch with this name : ", paramString });
      return false;
    }
    FeatureSwitch localFeatureSwitch = a(paramString, true);
    localFeatureSwitch.mSwitchEnable = paramBoolean;
    localFeatureSwitch.mSwitchName = paramString;
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localFeatureSwitch);
    return true;
  }
  
  private void c(String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramString, true);
    ((FeatureSwitch)localObject).mSwitchEnable = paramBoolean;
    ((FeatureSwitch)localObject).mSwitchName = paramString;
    localObject = new Gson().toJson(localObject);
    SharePreferenceUtils.a(BaseApplication.getContext(), "tabSwitchSp", paramString, (String)localObject);
  }
  
  protected FeatureSwitch a(String paramString)
  {
    paramString = SharePreferenceUtils.a(BaseApplication.getContext(), "tabSwitchSp", paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (FeatureSwitch)new Gson().fromJson(paramString, FeatureSwitch.class);
  }
  
  public FeatureSwitch a(String paramString, boolean paramBoolean)
  {
    FeatureSwitch localFeatureSwitch = b(paramString);
    if (localFeatureSwitch != null) {
      return localFeatureSwitch;
    }
    localFeatureSwitch = a(paramString);
    if (localFeatureSwitch != null)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localFeatureSwitch);
      return localFeatureSwitch;
    }
    return this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchISwitchModel.a(paramString, paramBoolean);
  }
  
  public Map<String, FeatureSwitch> a()
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchISwitchModel.a();
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
          this.jdField_a_of_type_JavaUtilMap.put(str, localFeatureSwitch);
          localMap.put(str, localFeatureSwitch);
        }
      }
    }
    return localMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    SharePreferenceUtils.b(BaseApplication.getContext(), "tabSwitchSp");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DebugModel", 1, "FeatureSwitch illegal");
      return;
    }
    b(paramString, paramBoolean);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean).mSwitchEnable;
  }
  
  protected FeatureSwitch b(String paramString)
  {
    return (FeatureSwitch)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.DebugModel
 * JD-Core Version:    0.7.0.1
 */