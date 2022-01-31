import org.json.JSONObject;

public class nmp
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
  
  public static nmp a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      nmp localnmp = new nmp();
      try
      {
        localnmp.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localnmp.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localnmp.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localnmp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localnmp.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localnmp.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localnmp.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localnmp.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localnmp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localnmp.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localnmp.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localnmp.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localnmp;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localnmp;
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
 * Qualified Name:     nmp
 * JD-Core Version:    0.7.0.1
 */