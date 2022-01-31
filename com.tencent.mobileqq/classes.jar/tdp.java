import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class tdp
{
  private static int jdField_a_of_type_Int;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static tdp jdField_a_of_type_Tdp;
  public FaceDrawable a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private tdp b;
  
  static tdp a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Tdp != null)
      {
        tdp localtdp = jdField_a_of_type_Tdp;
        jdField_a_of_type_Tdp = localtdp.b;
        localtdp.b = null;
        jdField_a_of_type_Int -= 1;
        return localtdp;
      }
      return new tdp();
    }
  }
  
  public static tdp a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    tdp localtdp = a();
    localtdp.jdField_a_of_type_JavaLangString = paramString;
    localtdp.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable = FaceDrawable.a(paramQQAppInterface, 1, paramString);
    localtdp.jdField_a_of_type_Boolean = false;
    return localtdp;
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
        this.b = jdField_a_of_type_Tdp;
        jdField_a_of_type_Tdp = this;
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
 * Qualified Name:     tdp
 * JD-Core Version:    0.7.0.1
 */