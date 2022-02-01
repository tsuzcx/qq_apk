package com.tencent.mobileqq.nearby.interestTag.impl;

import com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfoUtils;
import org.json.JSONObject;

public class InterestTagInfoUtilsImpl
  implements IInterestTagInfoUtils
{
  private InterestTagInfoUtils mInterestTagInfoUtils = new InterestTagInfoUtils();
  
  public Object convertFrom(Object paramObject)
  {
    return this.mInterestTagInfoUtils.a(paramObject);
  }
  
  public Object convertFrom(JSONObject paramJSONObject)
  {
    return this.mInterestTagInfoUtils.a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.impl.InterestTagInfoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */