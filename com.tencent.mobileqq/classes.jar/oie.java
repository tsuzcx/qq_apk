import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/CommonReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "action", "", "actionEntity", "", "Ljava/lang/Integer;", "actionTime", "", "Ljava/lang/Long;", "adSlot", "adSlotOffTop", "clickPos", "exposeDuration", "exposePercent", "exposeType", "jumpMode", "sceneAdNumber", "splashClickDuration", "statisticsSource", "uiType", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "setActionEntity", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/ActionEntity;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oie
  extends ohv
{
  private Integer jdField_a_of_type_JavaLangInteger;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private Integer jdField_b_of_type_JavaLangInteger;
  private String jdField_b_of_type_JavaLangString;
  private Integer c;
  private Integer d;
  private Integer e;
  private Integer f;
  private Integer g;
  private Integer h;
  private Integer i;
  private Integer j;
  private Integer k;
  
  @NotNull
  public String a()
  {
    return "common";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "action", this.jdField_a_of_type_JavaLangString);
    ohy.a(localJSONObject, "actionTime", this.jdField_a_of_type_JavaLangLong);
    ohy.a(localJSONObject, "uiType", this.jdField_a_of_type_JavaLangInteger);
    ohy.a(localJSONObject, "adSlot", this.jdField_b_of_type_JavaLangInteger);
    ohy.a(localJSONObject, "adSlotOffTop", this.c);
    ohy.a(localJSONObject, "sceneAdNumber", this.d);
    ohy.a(localJSONObject, "exposeType", this.e);
    ohy.a(localJSONObject, "clickPos", this.f);
    ohy.a(localJSONObject, "splashClickDuration", this.g);
    ohy.a(localJSONObject, "exposeDuration", this.h);
    ohy.a(localJSONObject, "exposePercent", this.i);
    ohy.a(localJSONObject, "statisticsSource", this.jdField_b_of_type_JavaLangString);
    ohy.a(localJSONObject, "jumpMode", this.j);
    ohy.a(localJSONObject, "actionEntity", this.k);
    return localJSONObject;
  }
  
  public final void a(@NotNull ActionEntity paramActionEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramActionEntity, "actionEntity");
    this.k = Integer.valueOf(paramActionEntity.getValue());
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    ReportAction localReportAction = oik.a(paramufw);
    Intrinsics.checkExpressionValueIsNotNull(localReportAction, "reportAction");
    this.jdField_a_of_type_JavaLangString = localReportAction.getValue();
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
    Object localObject;
    if (paramufw.a() == null)
    {
      localObject = oik.a(paramufw);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AdReportUtil.parseActionEntity(adReportData)");
      localObject = Integer.valueOf(((ActionEntity)localObject).getValue());
      this.k = ((Integer)localObject);
      if ((localReportAction != ReportAction.CLICK) && (localReportAction != ReportAction.CLOSE)) {
        break label245;
      }
      this.f = Integer.valueOf(paramufw.d());
      if ((paramufw.a() != null) && (paramufw.a().mSoftAdType != 0) && (paramufw.a().adClickPos != null))
      {
        localObject = paramufw.a().adClickPos;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "adReportData.advertisementInfo.adClickPos");
        this.f = Integer.valueOf(((AdClickPos)localObject).getValue());
      }
      this.j = oik.a(paramufw);
      label151:
      if (localReportAction == ReportAction.EXPOSE)
      {
        if ((!paramufw.b()) && (paramufw.a() != ExposeMode.LOOSE)) {
          break label261;
        }
        this.e = Integer.valueOf(2);
        this.i = Integer.valueOf(1);
      }
    }
    for (this.h = Integer.valueOf(0);; this.h = Integer.valueOf(1000))
    {
      if (paramufw.a() != null) {
        this.c = Integer.valueOf(paramufw.a().mAdKdPos + 1);
      }
      return;
      localObject = paramufw.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adReportData.actionEntity");
      localObject = Integer.valueOf(((ActionEntity)localObject).getValue());
      break;
      label245:
      this.j = Integer.valueOf(JumpMode.UNKNOWN.getValue());
      break label151;
      label261:
      this.e = Integer.valueOf(1);
      this.i = Integer.valueOf(50);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oie
 * JD-Core Version:    0.7.0.1
 */