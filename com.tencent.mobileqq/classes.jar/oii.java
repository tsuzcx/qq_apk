import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/NFBReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "nfbActionID", "", "nfbActionTxt", "nfbRemark", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oii
  extends ohv
{
  private String a;
  private String b;
  private String c;
  
  @NotNull
  public String a()
  {
    return "nfb";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ohy.a(localJSONObject, "nfbActionID", this.a);
    ohy.a(localJSONObject, "nfbActionTxt", this.b);
    ohy.a(localJSONObject, "nfbRemark", this.c);
    return localJSONObject;
  }
  
  public void a(@NotNull ufw paramufw)
  {
    Intrinsics.checkParameterIsNotNull(paramufw, "adReportData");
    if (oik.a(paramufw) != ReportAction.NFB) {}
    String str;
    for (;;)
    {
      return;
      str = paramufw.a();
      Bundle localBundle = paramufw.a();
      if (localBundle == null) {
        break;
      }
      this.a = "101";
      this.b = "我要吐槽";
      this.c = localBundle.getString("ad_complain_txt", "");
      paramufw = localBundle.getString("ad_complain_tel", "");
      Intrinsics.checkExpressionValueIsNotNull(paramufw, "tel");
      if (((CharSequence)paramufw).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.c = Intrinsics.stringPlus(this.c, '_' + paramufw);
        return;
      }
    }
    if (TextUtils.isEmpty((CharSequence)str))
    {
      this.a = ("" + paramufw.a());
      return;
    }
    this.a = paramufw.a();
    this.b = paramufw.b();
  }
  
  public boolean a()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oii
 * JD-Core Version:    0.7.0.1
 */