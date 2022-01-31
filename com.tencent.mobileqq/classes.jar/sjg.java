import org.json.JSONObject;

class sjg
  implements aabm
{
  sjg(sjf paramsjf) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    sne.d("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    sjf.a(this.a, false);
    if (paramInt == 1) {
      sjf.a(this.a);
    }
  }
  
  public void onPermission(int paramInt)
  {
    sne.b("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    sjf.a(this.a, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    sjf.a(this.a);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    sjf.a(this.a, false);
    if (paramJSONObject != null)
    {
      sne.b("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      sjf.a(this.a, paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjg
 * JD-Core Version:    0.7.0.1
 */