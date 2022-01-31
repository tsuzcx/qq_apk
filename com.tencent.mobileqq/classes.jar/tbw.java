import org.json.JSONObject;

class tbw
  implements absf
{
  tbw(tbv paramtbv) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    tlo.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    tbv.a(this.a, false);
    if (paramInt == 1) {
      tbv.a(this.a);
    }
  }
  
  public void onPermission(int paramInt)
  {
    tlo.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    tbv.a(this.a, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    tbv.a(this.a);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    tbv.a(this.a, false);
    if (paramJSONObject != null)
    {
      tlo.f("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      tbv.a(this.a, paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbw
 * JD-Core Version:    0.7.0.1
 */