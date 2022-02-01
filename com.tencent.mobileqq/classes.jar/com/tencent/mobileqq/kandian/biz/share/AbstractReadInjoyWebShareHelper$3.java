package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import org.json.JSONObject;

class AbstractReadInjoyWebShareHelper$3
  implements Runnable
{
  AbstractReadInjoyWebShareHelper$3(AbstractReadInjoyWebShareHelper paramAbstractReadInjoyWebShareHelper, HashMap paramHashMap, String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject3 = HttpUtil.shortenUrlBatch(this.a);
    Object localObject2 = (String)((HashMap)localObject3).get("share_url");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.b;
    }
    localObject3 = (String)((HashMap)localObject3).get("image_url");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = this.c;
    }
    localObject1 = new AbstractReadInjoyWebShareHelper.3.1(this, (String)localObject1, (String)localObject2);
    if (this.this$0.b().getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity"))
    {
      this.this$0.b().runOnUiThread((Runnable)localObject1);
      return;
    }
    this.this$0.c().runOnUiThread((Runnable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.3
 * JD-Core Version:    0.7.0.1
 */