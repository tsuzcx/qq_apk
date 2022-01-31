import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class rak
  implements osi
{
  rak(ram paramram, HashMap paramHashMap) {}
  
  public void a(osl paramosl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + raj.a().get() + ", vid = " + paramosl.jdField_b_of_type_JavaLangString);
    }
    if ((raj.a().get()) || (!this.jdField_a_of_type_Ram.jdField_a_of_type_JavaLangString.equals(paramosl.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramosl = paramosl.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramosl.hasNext())
      {
        osl localosl = (osl)paramosl.next();
        if ((localosl.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localosl.jdField_c_of_type_JavaLangString)) && (localosl.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Ram.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Ram.jdField_b_of_type_Int = localosl.jdField_b_of_type_Int;
          this.jdField_a_of_type_Ram.jdField_c_of_type_Int = localosl.jdField_c_of_type_Int;
          raj.a(this.jdField_a_of_type_Ram, localosl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Ram.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Ram.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rak
 * JD-Core Version:    0.7.0.1
 */