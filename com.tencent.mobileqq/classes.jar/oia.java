import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/AMSReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "amsClickUrl", "", "amsConvUrl", "amsExpUrl", "amsNFBUrl", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oia
  extends ohv
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  @NotNull
  public String a()
  {
    return "report";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "amsExpUrl", this.a);
    ohy.a(localJSONObject, "amsClickUrl", this.b);
    ohy.a(localJSONObject, "amsConvUrl", this.c);
    ohy.a(localJSONObject, "amsNFBUrl", this.d);
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    ReportAction localReportAction = oik.a(paramufw);
    if (localReportAction == null) {}
    do
    {
      do
      {
        return;
        switch (oib.a[localReportAction.ordinal()])
        {
        default: 
          return;
        }
      } while (paramufw.a() == null);
      this.a = paramufw.a().mAdApurl;
      return;
    } while (paramufw.a() == null);
    this.b = paramufw.a().mAdEffectUrl;
    this.c = paramufw.a().mAdRl;
    return;
    this.d = oik.c(paramufw);
  }
  
  public boolean a()
  {
    return (this.a != null) || (this.b != null) || (this.c != null) || (this.d != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oia
 * JD-Core Version:    0.7.0.1
 */