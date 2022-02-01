package com.weibo.ssosdk;

import org.json.JSONObject;

public final class WeiboSsoSdk$VisitorLoginInfo
{
  private String mAid = "";
  private String mSubCookie = "";
  
  static VisitorLoginInfo parseJson(String paramString)
  {
    VisitorLoginInfo localVisitorLoginInfo = new VisitorLoginInfo();
    JSONObject localJSONObject;
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("retcode", "");
      localJSONObject = paramString.getJSONObject("data");
      if ((!str.equals("20000000")) || (localJSONObject == null)) {
        throw new Exception("error： " + str + " msg:" + paramString.optString("msg", ""));
      }
    }
    catch (Exception paramString)
    {
      throw paramString;
    }
    localVisitorLoginInfo.mAid = localJSONObject.optString("aid", "");
    localVisitorLoginInfo.mSubCookie = localJSONObject.optString("sub", "");
    return localVisitorLoginInfo;
  }
  
  final VisitorLoginInfo cloneAidInfo()
  {
    VisitorLoginInfo localVisitorLoginInfo = new VisitorLoginInfo();
    localVisitorLoginInfo.mAid = this.mAid;
    localVisitorLoginInfo.mSubCookie = this.mSubCookie;
    return localVisitorLoginInfo;
  }
  
  public final String getAid()
  {
    return this.mAid;
  }
  
  public final String getVisitorSub()
  {
    return this.mSubCookie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo
 * JD-Core Version:    0.7.0.1
 */