import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class lof
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static lof a()
  {
    ljz localljz = lfh.a(BaseApplicationImpl.getContext());
    if (!localljz.a())
    {
      lof locallof = new lof();
      if (locallof.a(localljz)) {}
      return locallof;
    }
    return null;
  }
  
  public boolean a(ljz paramljz)
  {
    try
    {
      this.jdField_a_of_type_Int = paramljz.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramljz.a("OpenGLBlowUp/width", 0);
      this.c = paramljz.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramljz.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramljz) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lof
 * JD-Core Version:    0.7.0.1
 */