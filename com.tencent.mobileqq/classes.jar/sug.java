import java.util.HashMap;

class sug
  implements aysb
{
  sug(sue paramsue) {}
  
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    while (!(paramaysy instanceof ayrx)) {
      return;
    }
    ayrx localayrx = (ayrx)paramaysy;
    localayrx.jdField_a_of_type_Long += paramaysz.c;
    paramaysz.c = 0L;
    paramaysz = "bytes=" + localayrx.jdField_a_of_type_Long + "-";
    localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
    String str1 = localayrx.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localayrx.jdField_a_of_type_JavaLangString = (str2 + "range=" + localayrx.jdField_a_of_type_Long);
    }
    paramaysy = paramaysy.a();
    if ((paramaysy != null) && ((paramaysy instanceof sui))) {
      ((sui)paramaysy).b = true;
    }
    ved.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { paramaysz, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sug
 * JD-Core Version:    0.7.0.1
 */