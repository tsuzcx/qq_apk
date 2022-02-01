package com.tencent.mobileqq.newnearby;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface INearbyCGIReporter
  extends QRouteApi
{
  public abstract void reportByJson(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.INearbyCGIReporter
 * JD-Core Version:    0.7.0.1
 */