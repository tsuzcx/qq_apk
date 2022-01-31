import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class mvu
  implements bauf
{
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    baub localbaub;
    do
    {
      do
      {
        return;
      } while (!(parambave instanceof baub));
      localbaub = (baub)parambave;
      localbaub.jdField_a_of_type_Long += parambavf.c;
      parambavf.c = 0L;
      parambavf = "bytes=" + localbaub.jdField_a_of_type_Long + "-";
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
      parambavf = localbaub.jdField_a_of_type_JavaLangString;
      if (parambavf.contains("range="))
      {
        parambavf = parambavf.substring(0, parambavf.lastIndexOf("range="));
        localbaub.jdField_a_of_type_JavaLangString = (parambavf + "range=" + localbaub.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "IBreakDownFix. url = " + ((baub)parambave).jdField_a_of_type_JavaLangString + ", offset=" + localbaub.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mvu
 * JD-Core Version:    0.7.0.1
 */