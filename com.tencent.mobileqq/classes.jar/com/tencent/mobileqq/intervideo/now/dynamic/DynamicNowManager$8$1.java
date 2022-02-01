package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver.IBusinessInitFinish;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import org.json.JSONObject;

class DynamicNowManager$8$1
  extends DefaultLiveTicketObserver
{
  DynamicNowManager$8$1(DynamicNowManager.8 param8, IBusinessExpireObserver.IBusinessInitFinish paramIBusinessInitFinish) {}
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.a.a();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject = new BizLoginRequest();
    paramJSONObject.a = DynamicNowManager.a(this.b.c).b(this.b.a);
    paramJSONObject.b = 8;
    paramJSONObject.i = DynamicNowManager.d(this.b.c).c();
    paramJSONObject.h = DynamicNowManager.d(this.b.c).d();
    paramJSONObject.c = this.b.b;
    LiteLiveSDKFactory.a().a(paramJSONObject);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.8.1
 * JD-Core Version:    0.7.0.1
 */