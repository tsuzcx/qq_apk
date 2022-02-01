import org.json.JSONObject;

public class omj
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
  
  public static omj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      omj localomj = new omj();
      try
      {
        localomj.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localomj.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localomj.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localomj.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localomj.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localomj.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localomj.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localomj.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localomj.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localomj.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localomj.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localomj.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localomj;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localomj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omj
 * JD-Core Version:    0.7.0.1
 */