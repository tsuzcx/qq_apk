import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class leu
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static leu a()
  {
    lao locallao = kvz.a(BaseApplicationImpl.getContext());
    if (!locallao.a())
    {
      leu localleu = new leu();
      if (localleu.a(locallao)) {}
      return localleu;
    }
    return null;
  }
  
  public boolean a(lao paramlao)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlao.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramlao.a("OpenGLBlowUp/width", 0);
      this.c = paramlao.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramlao.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramlao) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     leu
 * JD-Core Version:    0.7.0.1
 */