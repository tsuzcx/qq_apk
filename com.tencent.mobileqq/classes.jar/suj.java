import java.util.HashMap;

class suj
  implements ayrz
{
  suj(suh paramsuh) {}
  
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    while (!(paramaysw instanceof ayrv)) {
      return;
    }
    ayrv localayrv = (ayrv)paramaysw;
    localayrv.jdField_a_of_type_Long += paramaysx.c;
    paramaysx.c = 0L;
    paramaysx = "bytes=" + localayrv.jdField_a_of_type_Long + "-";
    localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
    String str1 = localayrv.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localayrv.jdField_a_of_type_JavaLangString = (str2 + "range=" + localayrv.jdField_a_of_type_Long);
    }
    paramaysw = paramaysw.a();
    if ((paramaysw != null) && ((paramaysw instanceof sul))) {
      ((sul)paramaysw).b = true;
    }
    veg.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { paramaysx, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suj
 * JD-Core Version:    0.7.0.1
 */