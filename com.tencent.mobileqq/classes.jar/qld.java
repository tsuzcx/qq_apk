import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class qld
  implements onx
{
  qld(qlf paramqlf, HashMap paramHashMap) {}
  
  public void a(ooa paramooa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + qlc.a().get() + ", vid = " + paramooa.jdField_b_of_type_JavaLangString);
    }
    if ((qlc.a().get()) || (!this.jdField_a_of_type_Qlf.jdField_a_of_type_JavaLangString.equals(paramooa.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramooa = paramooa.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramooa.hasNext())
      {
        ooa localooa = (ooa)paramooa.next();
        if ((localooa.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localooa.jdField_c_of_type_JavaLangString)) && (localooa.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Qlf.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Qlf.jdField_b_of_type_Int = localooa.jdField_b_of_type_Int;
          this.jdField_a_of_type_Qlf.jdField_c_of_type_Int = localooa.jdField_c_of_type_Int;
          qlc.a(this.jdField_a_of_type_Qlf, localooa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Qlf.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Qlf.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qld
 * JD-Core Version:    0.7.0.1
 */