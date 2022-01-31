import org.json.JSONObject;

public class rxl
  extends rxe
{
  public long a;
  public boolean a;
  
  public rxl(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static rxl a(JSONObject paramJSONObject)
  {
    return new rxl(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isPreloadVideoPlugin");
      this.jdField_a_of_type_Long = paramJSONObject.optLong("queryPluginTimeInterval");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 3600L;
  }
  
  public String toString()
  {
    return "WeSeeVideoPluginConfigInfo{mIsPreloadPluginInWsRecommend=" + this.jdField_a_of_type_Boolean + ", mQueryPluginTimeInterval=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxl
 * JD-Core Version:    0.7.0.1
 */