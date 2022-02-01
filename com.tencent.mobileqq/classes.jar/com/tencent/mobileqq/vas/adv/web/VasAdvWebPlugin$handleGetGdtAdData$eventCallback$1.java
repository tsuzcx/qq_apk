package com.tencent.mobileqq.vas.adv.web;

import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Callback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/web/VasAdvWebPlugin$handleGetGdtAdData$eventCallback$1", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "onResult", "", "data", "", "errMsg", "", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebPlugin$handleGetGdtAdData$eventCallback$1
  implements VasAdvWebEvent.Callback
{
  VasAdvWebPlugin$handleGetGdtAdData$eventCallback$1(String paramString) {}
  
  public void onResult(@Nullable Object paramObject, @Nullable String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramObject != null)
    {
      if ((paramObject instanceof String)) {
        paramObject = (String)paramObject;
      } else {
        paramObject = paramObject.toString();
      }
      localJSONObject.put("returnCode", 0);
      localJSONObject.put("data", paramObject);
    }
    else
    {
      localJSONObject.put("errorMsg", paramString);
      localJSONObject.put("returnCode", 1);
    }
    this.a.callJs(this.b, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.VasAdvWebPlugin.handleGetGdtAdData.eventCallback.1
 * JD-Core Version:    0.7.0.1
 */