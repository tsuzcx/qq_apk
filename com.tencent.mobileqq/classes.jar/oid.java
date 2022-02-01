import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/AppReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "appInstallStatus", "", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oid
  extends ohv
{
  private int a;
  
  @NotNull
  public String a()
  {
    return "app";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "appInstallStatus", Integer.valueOf(this.a));
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    if (paramufw.a() == null) {}
    for (;;)
    {
      return;
      String str = paramufw.a().packageName;
      Intrinsics.checkExpressionValueIsNotNull(str, "adReportData.advertisementInfo.packageName");
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (!oik.a((Context)BaseApplication.context, paramufw.a().getPackageName())) {
          break label76;
        }
        this.a = 1;
        return;
      }
    }
    label76:
    this.a = 2;
  }
  
  public boolean a()
  {
    return this.a != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oid
 * JD-Core Version:    0.7.0.1
 */