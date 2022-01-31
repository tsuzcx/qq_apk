import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class lri
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static lri a()
  {
    lnc locallnc = lim.a(BaseApplicationImpl.getContext());
    if (!locallnc.a())
    {
      lri locallri = new lri();
      if (locallri.a(locallnc)) {}
      return locallri;
    }
    return null;
  }
  
  public boolean a(lnc paramlnc)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlnc.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramlnc.a("OpenGLBlowUp/width", 0);
      this.c = paramlnc.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramlnc.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramlnc) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lri
 * JD-Core Version:    0.7.0.1
 */