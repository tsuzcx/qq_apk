import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class sgz
  implements sxa
{
  sgz(shb paramshb, HashMap paramHashMap) {}
  
  public void a(sxc paramsxc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + sgy.a().get() + ", vid = " + paramsxc.jdField_b_of_type_JavaLangString);
    }
    if ((sgy.a().get()) || (!this.jdField_a_of_type_Shb.jdField_a_of_type_JavaLangString.equals(paramsxc.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramsxc = paramsxc.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramsxc.hasNext())
      {
        sxc localsxc = (sxc)paramsxc.next();
        if ((localsxc.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localsxc.jdField_c_of_type_JavaLangString)) && (localsxc.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Shb.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Shb.jdField_b_of_type_Int = localsxc.jdField_b_of_type_Int;
          this.jdField_a_of_type_Shb.jdField_c_of_type_Int = localsxc.jdField_c_of_type_Int;
          sgy.a(this.jdField_a_of_type_Shb, localsxc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Shb.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Shb.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgz
 * JD-Core Version:    0.7.0.1
 */