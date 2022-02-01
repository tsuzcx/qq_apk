import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class rni
  implements sct
{
  rni(rnk paramrnk, HashMap paramHashMap) {}
  
  public void a(scv paramscv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + rnh.a().get() + ", vid = " + paramscv.jdField_b_of_type_JavaLangString);
    }
    if ((rnh.a().get()) || (!this.jdField_a_of_type_Rnk.jdField_a_of_type_JavaLangString.equals(paramscv.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramscv = paramscv.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramscv.hasNext())
      {
        scv localscv = (scv)paramscv.next();
        if ((localscv.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localscv.jdField_c_of_type_JavaLangString)) && (localscv.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Rnk.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Rnk.jdField_b_of_type_Int = localscv.jdField_b_of_type_Int;
          this.jdField_a_of_type_Rnk.jdField_c_of_type_Int = localscv.jdField_c_of_type_Int;
          rnh.a(this.jdField_a_of_type_Rnk, localscv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Rnk.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Rnk.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rni
 * JD-Core Version:    0.7.0.1
 */