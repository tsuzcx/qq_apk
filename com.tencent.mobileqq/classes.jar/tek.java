import org.json.JSONObject;

public class tek
  extends ted
{
  public long a;
  public boolean a;
  
  public tek(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static tek a(JSONObject paramJSONObject)
  {
    return new tek(paramJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tek
 * JD-Core Version:    0.7.0.1
 */