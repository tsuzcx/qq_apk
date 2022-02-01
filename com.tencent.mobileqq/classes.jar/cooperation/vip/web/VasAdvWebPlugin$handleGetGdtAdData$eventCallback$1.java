package cooperation.vip.web;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/web/VasAdvWebPlugin$handleGetGdtAdData$eventCallback$1", "Lcooperation/vip/web/VasAdvWebEvent$Callback;", "onResult", "", "data", "", "errMsg", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebPlugin$handleGetGdtAdData$eventCallback$1
  implements VasAdvWebEvent.Callback
{
  VasAdvWebPlugin$handleGetGdtAdData$eventCallback$1(String paramString) {}
  
  public void a(@Nullable Object paramObject, @Nullable String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramObject != null) {
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        localJSONObject.put("returnCode", 0);
        localJSONObject.put("data", paramObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_CooperationVipWebVasAdvWebPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
      paramObject = paramObject.toString();
      break;
      localJSONObject.put("errorMsg", paramString);
      localJSONObject.put("returnCode", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.web.VasAdvWebPlugin.handleGetGdtAdData.eventCallback.1
 * JD-Core Version:    0.7.0.1
 */