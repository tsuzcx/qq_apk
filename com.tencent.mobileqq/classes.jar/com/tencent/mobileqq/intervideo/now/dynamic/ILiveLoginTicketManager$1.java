package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.Doraemon.APICallback;
import org.json.JSONObject;

class ILiveLoginTicketManager$1
  implements APICallback
{
  ILiveLoginTicketManager$1(ILiveLoginTicketManager paramILiveLoginTicketManager, APICallback paramAPICallback) {}
  
  public void a()
  {
    APICallback localAPICallback = this.a;
    if (localAPICallback != null) {
      localAPICallback.a();
    }
  }
  
  public void a(int paramInt)
  {
    APICallback localAPICallback = this.a;
    if (localAPICallback != null) {
      localAPICallback.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    APICallback localAPICallback = this.a;
    if (localAPICallback != null) {
      localAPICallback.a(paramInt, paramString);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    ILiveLoginTicketManager.a(this.b, paramJSONObject.optString("access_token"));
    ILiveLoginTicketManager.b(this.b, paramJSONObject.optString("openid"));
    APICallback localAPICallback = this.a;
    if (localAPICallback != null) {
      localAPICallback.a(paramJSONObject);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    APICallback localAPICallback = this.a;
    if (localAPICallback != null) {
      localAPICallback.b(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.ILiveLoginTicketManager.1
 * JD-Core Version:    0.7.0.1
 */