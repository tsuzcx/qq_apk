import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/VideoReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "videoBeginFrame", "", "videoBeginTime", "videoDuration", "videoEndFrame", "videoEndTime", "videoEndType", "videoPlayDuration", "Ljava/lang/Integer;", "videoPlayError", "videoPlayPostion", "videoPlayType", "videoReplayCount", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "parseVideoEndType", "json", "Lorg/json/JSONObject;", "parseVideoPlayError", "parseVideoPlayType", "toJsonObject", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oij
  extends ohv
{
  private int jdField_a_of_type_Int;
  private Integer jdField_a_of_type_JavaLangInteger;
  private int jdField_b_of_type_Int;
  private Integer jdField_b_of_type_JavaLangInteger;
  private int jdField_c_of_type_Int = 1;
  private Integer jdField_c_of_type_JavaLangInteger;
  private int jdField_d_of_type_Int = 1;
  private Integer jdField_d_of_type_JavaLangInteger;
  private int e;
  private int f = 1;
  private int g;
  
  private final int a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("isClickReplay") == true)) {
      return 12;
    }
    if ((paramJSONObject == null) || (paramJSONObject.optInt("videoReplayCount") != 0)) {
      return 13;
    }
    return 11;
  }
  
  private final int b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return 0;
    }
    return paramJSONObject.optInt("videoEndType", 0);
  }
  
  private final int c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return 0;
    }
    return paramJSONObject.optInt("ps", 0);
  }
  
  @NotNull
  public String a()
  {
    return "video";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "videoBeginTime", Integer.valueOf(this.jdField_a_of_type_Int));
    ohy.a(localJSONObject, "videoEndTime", Integer.valueOf(this.jdField_b_of_type_Int));
    ohy.a(localJSONObject, "videoBeginFrame", Integer.valueOf(this.jdField_c_of_type_Int));
    ohy.a(localJSONObject, "videoEndFrame", Integer.valueOf(this.jdField_d_of_type_Int));
    ohy.a(localJSONObject, "videoPlayPosition", Integer.valueOf(this.e));
    ohy.a(localJSONObject, "videoEndType", Integer.valueOf(this.f));
    ohy.a(localJSONObject, "videoDuration", Integer.valueOf(this.g));
    ohy.a(localJSONObject, "videoPlayError", this.jdField_a_of_type_JavaLangInteger);
    ohy.a(localJSONObject, "videoPlayDuration", this.jdField_b_of_type_JavaLangInteger);
    ohy.a(localJSONObject, "videoPlayType", this.jdField_c_of_type_JavaLangInteger);
    ohy.a(localJSONObject, "videoReplayCount", this.jdField_d_of_type_JavaLangInteger);
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    if (oik.a(paramufw) != ReportAction.VIDEO_SEE_TIME) {}
    do
    {
      return;
      paramufw = paramufw.a();
    } while (paramufw == null);
    try
    {
      this.jdField_a_of_type_Int = paramufw.optInt("bt");
      this.jdField_b_of_type_Int = paramufw.optInt("et");
      this.jdField_c_of_type_Int = paramufw.optInt("bf");
      this.jdField_d_of_type_Int = paramufw.optInt("ef");
      if (paramufw.optBoolean("isVideoFeedsRecommend")) {
        this.e = 11;
      }
      this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(a(paramufw));
      this.f = b(paramufw);
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(c(paramufw));
      this.g = paramufw.optInt("duration");
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
      this.jdField_d_of_type_JavaLangInteger = Integer.valueOf(paramufw.optInt("videoReplayCount"));
      return;
    }
    catch (Throwable paramufw) {}
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oij
 * JD-Core Version:    0.7.0.1
 */