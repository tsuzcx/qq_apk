import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class lpk
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static lpk a()
  {
    lle locallle = lgo.a(BaseApplicationImpl.getContext());
    if (!locallle.a())
    {
      lpk locallpk = new lpk();
      if (locallpk.a(locallle)) {}
      return locallpk;
    }
    return null;
  }
  
  public boolean a(lle paramlle)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlle.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramlle.a("OpenGLBlowUp/width", 0);
      this.c = paramlle.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramlle.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramlle) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpk
 * JD-Core Version:    0.7.0.1
 */