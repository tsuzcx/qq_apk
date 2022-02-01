import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class lob
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static lob a()
  {
    lke locallke = lfi.a(BaseApplicationImpl.getContext());
    if (!locallke.a())
    {
      lob locallob = new lob();
      if (locallob.a(locallke)) {}
      return locallob;
    }
    return null;
  }
  
  public boolean a(lke paramlke)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlke.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramlke.a("OpenGLBlowUp/width", 0);
      this.c = paramlke.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramlke.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramlke) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lob
 * JD-Core Version:    0.7.0.1
 */