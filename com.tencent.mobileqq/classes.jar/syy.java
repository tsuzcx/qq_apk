import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class syy
{
  private static int jdField_a_of_type_Int;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static syy jdField_a_of_type_Syy;
  public FaceDrawable a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private syy b;
  
  static syy a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Syy != null)
      {
        syy localsyy = jdField_a_of_type_Syy;
        jdField_a_of_type_Syy = localsyy.b;
        localsyy.b = null;
        jdField_a_of_type_Int -= 1;
        return localsyy;
      }
      return new syy();
    }
  }
  
  public static syy a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    syy localsyy = a();
    localsyy.jdField_a_of_type_JavaLangString = paramString;
    localsyy.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable = FaceDrawable.a(paramQQAppInterface, 1, paramString);
    localsyy.jdField_a_of_type_Boolean = false;
    return localsyy;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable.a();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Syy;
        jdField_a_of_type_Syy = this;
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    return (!this.jdField_a_of_type_Boolean) && (paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syy
 * JD-Core Version:    0.7.0.1
 */