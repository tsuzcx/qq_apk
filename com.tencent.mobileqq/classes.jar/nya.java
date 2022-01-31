import org.json.JSONObject;

public class nya
{
  public double a;
  public int a;
  public long a;
  public String a;
  public double b;
  public int b;
  public long b;
  public String b;
  public double c;
  public long c;
  public String c;
  public double d;
  
  public static nya a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      nya localnya = new nya();
      try
      {
        localnya.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localnya.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localnya.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localnya.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localnya.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localnya.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localnya.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localnya.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localnya.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localnya.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localnya.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localnya.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localnya;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localnya;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramJSONObject = null;
      }
    }
    localException1.printStackTrace();
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nya
 * JD-Core Version:    0.7.0.1
 */