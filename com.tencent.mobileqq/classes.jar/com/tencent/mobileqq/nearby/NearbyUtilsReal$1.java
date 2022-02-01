package com.tencent.mobileqq.nearby;

import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

final class NearbyUtilsReal$1
  implements Runnable
{
  NearbyUtilsReal$1(String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("targetuin", Long.parseLong(this.a));
      ((JSONObject)localObject).put("type", this.b);
      NewIntent localNewIntent = new NewIntent(this.c.getApplication().getApplicationContext(), ProtoServlet.class);
      localNewIntent.putExtra("cmd", "NearbySvr.get_chat_signature");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localObject = ((JSONObject)localObject).toString();
      localWebSsoRequestBody.data.set((String)localObject);
      localNewIntent.putExtra("data", localWebSsoRequestBody.toByteArray());
      localNewIntent.setObserver(new NearbyUtilsReal.1.1(this));
      this.c.startServlet(localNewIntent);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUtilsReal.1
 * JD-Core Version:    0.7.0.1
 */