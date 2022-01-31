import java.util.HashMap;

class shn
  implements axrs
{
  shn(shl paramshl) {}
  
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
    while (!(paramaxsp instanceof axro)) {
      return;
    }
    axro localaxro = (axro)paramaxsp;
    localaxro.jdField_a_of_type_Long += paramaxsq.c;
    paramaxsq.c = 0L;
    paramaxsq = "bytes=" + localaxro.jdField_a_of_type_Long + "-";
    localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
    String str1 = localaxro.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localaxro.jdField_a_of_type_JavaLangString = (str2 + "range=" + localaxro.jdField_a_of_type_Long);
    }
    paramaxsp = paramaxsp.a();
    if ((paramaxsp != null) && ((paramaxsp instanceof shp))) {
      ((shp)paramaxsp).b = true;
    }
    urk.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { paramaxsq, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shn
 * JD-Core Version:    0.7.0.1
 */