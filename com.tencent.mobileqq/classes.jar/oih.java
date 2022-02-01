import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/GameReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "downloadWay", "", "Ljava/lang/Integer;", "horizonPos", "isGetYyb", "operModule", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oih
  extends ohv
{
  private Integer a;
  private Integer b;
  private Integer c;
  private Integer d;
  
  @NotNull
  public String a()
  {
    return "soft";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "operModule", this.a);
    ohy.a(localJSONObject, "horizonPos", this.b);
    ohy.a(localJSONObject, "downloadWay", this.c);
    ohy.a(localJSONObject, "isGetYyb", this.d);
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    throw ((Throwable)new NotImplementedError("An operation is not implemented: " + "Not yet implemented"));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oih
 * JD-Core Version:    0.7.0.1
 */