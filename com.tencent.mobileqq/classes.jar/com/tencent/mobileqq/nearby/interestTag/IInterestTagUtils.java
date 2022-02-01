package com.tencent.mobileqq.nearby.interestTag;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IInterestTagUtils
  extends QRouteApi
{
  public abstract Object convertFrom(Object paramObject);
  
  public abstract Object convertFromJSONObject(JSONObject paramJSONObject);
  
  public abstract Object convertTo(InterestTag paramInterestTag);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils
 * JD-Core Version:    0.7.0.1
 */