import org.json.JSONObject;

public class obe
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
  
  public static obe a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      obe localobe = new obe();
      try
      {
        localobe.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localobe.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localobe.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localobe.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localobe.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localobe.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localobe.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localobe.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localobe.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localobe.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localobe.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localobe.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localobe;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localobe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obe
 * JD-Core Version:    0.7.0.1
 */