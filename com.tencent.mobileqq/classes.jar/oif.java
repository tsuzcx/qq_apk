import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/ControlReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "debug", "", "noforwardAMS", "", "Ljava/lang/Integer;", "ticket", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oif
  extends ohv
{
  private Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  @NotNull
  public String a()
  {
    return "control";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "ticket", this.jdField_a_of_type_JavaLangString);
    ohy.a(localJSONObject, "debug", this.b);
    ohy.a(localJSONObject, "noForward", this.jdField_a_of_type_JavaLangInteger);
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    this.jdField_a_of_type_JavaLangString = oik.b(paramufw);
    ReportAction localReportAction = oik.a(paramufw);
    if ((localReportAction == ReportAction.VIDEO_SEE_TIME) || (localReportAction == ReportAction.NFB)) {}
    for (Integer localInteger = Integer.valueOf(0);; localInteger = Integer.valueOf(1))
    {
      this.jdField_a_of_type_JavaLangInteger = localInteger;
      if (paramufw.b() == 28) {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
      }
      if (((localReportAction == ReportAction.CLICK) || (localReportAction == ReportAction.EXPOSE)) && ((paramufw.b() == 31) || (paramufw.b() == 32))) {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oif
 * JD-Core Version:    0.7.0.1
 */