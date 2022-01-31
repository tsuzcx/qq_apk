import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class lpf
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static lpf a()
  {
    lkz locallkz = lgj.a(BaseApplicationImpl.getContext());
    if (!locallkz.a())
    {
      lpf locallpf = new lpf();
      if (locallpf.a(locallkz)) {}
      return locallpf;
    }
    return null;
  }
  
  public boolean a(lkz paramlkz)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlkz.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramlkz.a("OpenGLBlowUp/width", 0);
      this.c = paramlkz.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramlkz.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramlkz) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpf
 * JD-Core Version:    0.7.0.1
 */