import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/ReportData;", "", "()V", "reportJson", "Lorg/json/JSONObject;", "reportJsonMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "appendData", "data", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "isEmpty", "", "toReportJsonMap", "toReportJsonObject", "toReportString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ohw
{
  public static final ohx a;
  private final HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  
  static
  {
    jdField_a_of_type_Ohx = new ohx(null);
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject.toString();
  }
  
  @NotNull
  public final HashMap<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  @NotNull
  public final ohw a(@Nullable ohv paramohv)
  {
    if (paramohv != null)
    {
      JSONObject localJSONObject = paramohv.a();
      if (localJSONObject != null)
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put(paramohv.a(), localJSONObject);
        paramohv = (String)this.jdField_a_of_type_JavaUtilHashMap.put(paramohv.a(), localJSONObject.toString());
      }
    }
    return this;
  }
  
  @Nullable
  public final JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohw
 * JD-Core Version:    0.7.0.1
 */