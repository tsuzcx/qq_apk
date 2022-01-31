import org.json.JSONObject;

class sjd
  implements aabi
{
  sjd(sjc paramsjc) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    snb.d("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    sjc.a(this.a, false);
    if (paramInt == 1) {
      sjc.a(this.a);
    }
  }
  
  public void onPermission(int paramInt)
  {
    snb.b("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    sjc.a(this.a, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    sjc.a(this.a);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    sjc.a(this.a, false);
    if (paramJSONObject != null)
    {
      snb.b("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      sjc.a(this.a, paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjd
 * JD-Core Version:    0.7.0.1
 */