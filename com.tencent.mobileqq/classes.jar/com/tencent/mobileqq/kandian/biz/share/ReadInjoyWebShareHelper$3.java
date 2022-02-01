package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class ReadInjoyWebShareHelper$3
  implements Runnable
{
  ReadInjoyWebShareHelper$3(ReadInjoyWebShareHelper paramReadInjoyWebShareHelper, HashMap paramHashMap, String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject3 = HttpUtil.shortenUrlBatch(this.jdField_a_of_type_JavaUtilHashMap);
    Object localObject2 = (String)((HashMap)localObject3).get("share_url");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    localObject3 = (String)((HashMap)localObject3).get("image_url");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = this.b;
    }
    localObject1 = new ReadInjoyWebShareHelper.3.1(this, (String)localObject1, (String)localObject2);
    if (ReadInjoyWebShareHelper.a(this.this$0).getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity"))
    {
      ReadInjoyWebShareHelper.a(this.this$0).runOnUiThread((Runnable)localObject1);
      return;
    }
    ReadInjoyWebShareHelper.a(this.this$0).a().runOnUiThread((Runnable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.3
 * JD-Core Version:    0.7.0.1
 */