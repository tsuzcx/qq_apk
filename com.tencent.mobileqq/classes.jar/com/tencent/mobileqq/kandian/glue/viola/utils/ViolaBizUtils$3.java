package com.tencent.mobileqq.kandian.glue.viola.utils;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class ViolaBizUtils$3
  implements Runnable
{
  ViolaBizUtils$3(List paramList, int paramInt, String paramString1, boolean paramBoolean, BridgeModule paramBridgeModule, String paramString2) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Collections.sort(this.a);
    JSONArray localJSONArray = RIJUgcUtils.a(this.a);
    ThreadManagerV2.getUIHandlerV2().post(new ViolaBizUtils.3.1(this, localJSONObject, localJSONArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.3
 * JD-Core Version:    0.7.0.1
 */