import com.tencent.common.config.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/DeviceReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "apnType", "", "Ljava/lang/Integer;", "guid", "", "omgid", "uin", "userAgent", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oig
  extends ohv
{
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private Integer jdField_b_of_type_JavaLangInteger;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  @NotNull
  public String a()
  {
    return "device";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "guid", this.jdField_a_of_type_JavaLangString);
    ohy.a(localJSONObject, "uin", this.jdField_a_of_type_JavaLangInteger);
    ohy.a(localJSONObject, "omgid", this.jdField_b_of_type_JavaLangString);
    ohy.a(localJSONObject, "apnType", this.jdField_b_of_type_JavaLangInteger);
    ohy.a(localJSONObject, "userAgent", this.c);
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    paramufw = pkh.a();
    Intrinsics.checkExpressionValueIsNotNull(paramufw, "ReadInJoyUtils.getAppRuntime()");
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramufw.getAccount());
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(ofj.a());
    this.c = AppSetting.e();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangInteger != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oig
 * JD-Core Version:    0.7.0.1
 */