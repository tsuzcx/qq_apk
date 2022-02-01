import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/AdLoadReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "lastAdDistance", "", "lastAdTime", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oic
  extends ohv
{
  private String a;
  private String b;
  
  @NotNull
  public String a()
  {
    return "adload";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "lastAdDistance", this.a);
    ohy.a(localJSONObject, "lastAdTime", this.b);
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    try
    {
      this.a = paramufw.e().optJSONObject("exposure_info_report").optString("last_ad_distance");
      this.b = paramufw.e().optJSONObject("exposure_info_report").optString("last_ad_time");
      return;
    }
    catch (Throwable paramufw) {}
  }
  
  public boolean a()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oic
 * JD-Core Version:    0.7.0.1
 */