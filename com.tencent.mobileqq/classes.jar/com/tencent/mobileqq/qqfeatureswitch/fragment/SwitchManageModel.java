package com.tencent.mobileqq.qqfeatureswitch.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqfeatureswitch.impl.FeatureRuntimeServiceImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class SwitchManageModel
{
  private FeatureRuntimeServiceImpl a;
  private Map<String, FeatureSwitch> b;
  private List<FeatureSwitch> c;
  private List<FeatureSwitch> d;
  private String e;
  
  public SwitchManageModel(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      this.a = ((FeatureRuntimeServiceImpl)paramAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all"));
    }
  }
  
  public List<FeatureSwitch> a(String paramString)
  {
    if (this.c == null) {
      b();
    }
    if (paramString == null) {
      return null;
    }
    if (this.d == null) {
      this.d = new ArrayList();
    }
    Object localObject = this.e;
    if ((localObject != null) && (((String)localObject).equals(paramString))) {
      return this.d;
    }
    int i;
    if ((this.e != null) && (!paramString.equals("")) && (paramString.contains(this.e))) {
      i = 0;
    } else {
      i = 1;
    }
    this.e = paramString;
    if (i != 0)
    {
      this.d.clear();
      this.d.addAll(this.c);
    }
    if ("".equals(paramString)) {
      return this.d;
    }
    localObject = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      FeatureSwitch localFeatureSwitch = (FeatureSwitch)localIterator.next();
      if (a(localFeatureSwitch, paramString)) {
        ((List)localObject).add(localFeatureSwitch);
      }
    }
    return localObject;
  }
  
  public void a()
  {
    this.a.resetSwitchState();
    this.b.clear();
    this.b = null;
  }
  
  protected boolean a(FeatureSwitch paramFeatureSwitch, String paramString)
  {
    if (a(paramFeatureSwitch.mSwitchName, paramString)) {
      return true;
    }
    if (a(paramFeatureSwitch.mOwner, paramString)) {
      return true;
    }
    return a(paramFeatureSwitch.mSwitchInfo, paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (paramString2.length() > paramString1.length()) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(".*");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".*");
      return Pattern.matches(localStringBuilder.toString(), paramString1);
    }
    return false;
  }
  
  public List<FeatureSwitch> b()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    if (this.b == null) {
      this.b = ((FeatureRuntimeServiceImpl)localObject).getSwitchList();
    }
    localObject = this.b;
    if (localObject == null) {
      this.c = Collections.emptyList();
    } else {
      this.c = new ArrayList(((Map)localObject).values());
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.fragment.SwitchManageModel
 * JD-Core Version:    0.7.0.1
 */