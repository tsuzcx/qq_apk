package com.weibo.ssosdk;

import org.json.JSONObject;

public final class WeiboSsoSdk$VisitorLoginInfo
{
  private String mAid = "";
  private String mSubCookie = "";
  
  static VisitorLoginInfo parseJson(String paramString)
  {
    Object localObject = new VisitorLoginInfo();
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("retcode", "");
      JSONObject localJSONObject = paramString.getJSONObject("data");
      if ((str.equals("20000000")) && (localJSONObject != null))
      {
        ((VisitorLoginInfo)localObject).mAid = localJSONObject.optString("aid", "");
        ((VisitorLoginInfo)localObject).mSubCookie = localJSONObject.optString("sub", "");
        return localObject;
      }
      localObject = new StringBuilder("error： ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(paramString.optString("msg", ""));
      throw new Exception(((StringBuilder)localObject).toString());
    }
    catch (Exception paramString)
    {
      throw paramString;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo
 * JD-Core Version:    0.7.0.1
 */