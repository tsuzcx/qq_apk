package com.tencent.mobileqq.nearby.interestTag;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IInterestTagInfoUtils
  extends QRouteApi
{
  public abstract Object convertFrom(Object paramObject);
  
  public abstract Object convertFrom(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils
 * JD-Core Version:    0.7.0.1
 */