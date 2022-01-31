import org.json.JSONObject;

public class nxx
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
  
  public static nxx a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      nxx localnxx = new nxx();
      try
      {
        localnxx.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localnxx.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localnxx.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localnxx.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localnxx.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localnxx.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localnxx.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localnxx.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localnxx.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localnxx.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localnxx.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localnxx.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localnxx;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localnxx;
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
 * Qualified Name:     nxx
 * JD-Core Version:    0.7.0.1
 */