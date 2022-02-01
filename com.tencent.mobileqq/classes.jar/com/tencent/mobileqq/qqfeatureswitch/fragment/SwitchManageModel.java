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
  private FeatureRuntimeServiceImpl jdField_a_of_type_ComTencentMobileqqQqfeatureswitchImplFeatureRuntimeServiceImpl;
  private String jdField_a_of_type_JavaLangString;
  private List<FeatureSwitch> jdField_a_of_type_JavaUtilList;
  private Map<String, FeatureSwitch> jdField_a_of_type_JavaUtilMap;
  private List<FeatureSwitch> b;
  
  public SwitchManageModel(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchImplFeatureRuntimeServiceImpl = ((FeatureRuntimeServiceImpl)paramAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all"));
    }
  }
  
  public List<FeatureSwitch> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchImplFeatureRuntimeServiceImpl;
    if (localObject == null) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = ((FeatureRuntimeServiceImpl)localObject).getSwitchList();
    }
    localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject == null) {
      this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    } else {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(((Map)localObject).values());
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<FeatureSwitch> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    if (paramString == null) {
      return null;
    }
    if (this.b == null) {
      this.b = new ArrayList();
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).equals(paramString))) {
      return this.b;
    }
    int i;
    if ((this.jdField_a_of_type_JavaLangString != null) && (!paramString.equals("")) && (paramString.contains(this.jdField_a_of_type_JavaLangString))) {
      i = 0;
    } else {
      i = 1;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (i != 0)
    {
      this.b.clear();
      this.b.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    if ("".equals(paramString)) {
      return this.b;
    }
    localObject = new ArrayList();
    Iterator localIterator = this.b.iterator();
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
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchImplFeatureRuntimeServiceImpl.resetSwitchState();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.fragment.SwitchManageModel
 * JD-Core Version:    0.7.0.1
 */