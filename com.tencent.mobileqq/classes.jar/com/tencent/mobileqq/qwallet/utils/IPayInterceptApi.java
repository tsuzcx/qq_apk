package com.tencent.mobileqq.qwallet.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONArray;

@QAPI(process={"all"})
public abstract interface IPayInterceptApi
  extends QRouteApi
{
  public abstract void saveConfig(JSONArray paramJSONArray, String paramString);
  
  public abstract boolean tryIntercept(String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.IPayInterceptApi
 * JD-Core Version:    0.7.0.1
 */