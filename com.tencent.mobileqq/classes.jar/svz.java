import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class svz
{
  private static int jdField_a_of_type_Int;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static svz jdField_a_of_type_Svz;
  public FaceDrawable a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private svz b;
  
  static svz a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Svz != null)
      {
        svz localsvz = jdField_a_of_type_Svz;
        jdField_a_of_type_Svz = localsvz.b;
        localsvz.b = null;
        jdField_a_of_type_Int -= 1;
        return localsvz;
      }
      return new svz();
    }
  }
  
  public static svz a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LebaQZoneFacePlayHelper.a(), 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    svz localsvz = a();
    localsvz.jdField_a_of_type_JavaLangString = paramString;
    localsvz.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable = FaceDrawable.a(paramQQAppInterface, 1, paramString);
    localsvz.jdField_a_of_type_Boolean = false;
    return localsvz;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(LebaQZoneFacePlayHelper.a(), 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
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
        this.b = jdField_a_of_type_Svz;
        jdField_a_of_type_Svz = this;
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
 * Qualified Name:     svz
 * JD-Core Version:    0.7.0.1
 */