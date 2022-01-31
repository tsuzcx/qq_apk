package cooperation.qzone;

import amre;

public final class CloseGuard
{
  private static volatile CloseGuard.Reporter jdField_a_of_type_CooperationQzoneCloseGuard$Reporter = new amre(null);
  private static final CloseGuard jdField_a_of_type_CooperationQzoneCloseGuard = new CloseGuard();
  private static volatile boolean jdField_a_of_type_Boolean = true;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  
  public static CloseGuard a()
  {
    if (!jdField_a_of_type_Boolean) {
      return jdField_a_of_type_CooperationQzoneCloseGuard;
    }
    return new CloseGuard();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangThrowable = null;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("closer == null");
    }
    if ((this == jdField_a_of_type_CooperationQzoneCloseGuard) || (!jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_JavaLangThrowable = new Throwable("Explicit termination method '" + paramString + "' not called");
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangThrowable == null) || (!jdField_a_of_type_Boolean)) {
      return;
    }
    jdField_a_of_type_CooperationQzoneCloseGuard$Reporter.a("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.jdField_a_of_type_JavaLangThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.CloseGuard
 * JD-Core Version:    0.7.0.1
 */