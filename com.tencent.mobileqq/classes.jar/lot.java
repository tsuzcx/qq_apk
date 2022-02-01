import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class lot
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static lot a()
  {
    lkk locallkk = lfo.a(BaseApplicationImpl.getContext());
    if (!locallkk.a())
    {
      lot locallot = new lot();
      if (locallot.a(locallkk)) {}
      return locallot;
    }
    return null;
  }
  
  public boolean a(lkk paramlkk)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlkk.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramlkk.a("OpenGLBlowUp/width", 0);
      this.c = paramlkk.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramlkk.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramlkk) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lot
 * JD-Core Version:    0.7.0.1
 */