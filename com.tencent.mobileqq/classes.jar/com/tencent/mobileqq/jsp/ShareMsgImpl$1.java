package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import org.json.JSONObject;

class ShareMsgImpl$1
  implements Runnable
{
  ShareMsgImpl$1(ShareMsgImpl paramShareMsgImpl, HashMap paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, String paramString11, int paramInt2, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject4 = HttpUtil.shortenUrlBatch(this.a);
    Object localObject2 = (String)((HashMap)localObject4).get("share_url");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.b;
    }
    Object localObject3 = (String)((HashMap)localObject4).get("image_url");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = this.c;
    }
    localObject4 = (String)((HashMap)localObject4).get("flash_url");
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = this.d;
    }
    localObject1 = new ShareMsgImpl.1.1(this, (String)localObject1, (String)localObject2, (String)localObject3);
    if (this.p.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
    {
      this.p.runOnUiThread((Runnable)localObject1);
      return;
    }
    this.this$0.o.runOnUiThread((Runnable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.1
 * JD-Core Version:    0.7.0.1
 */