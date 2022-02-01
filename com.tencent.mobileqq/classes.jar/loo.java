import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class loo
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static loo a()
  {
    lkq locallkq = lfu.a(BaseApplicationImpl.getContext());
    if (!locallkq.a())
    {
      loo localloo = new loo();
      if (localloo.a(locallkq)) {}
      return localloo;
    }
    return null;
  }
  
  public boolean a(lkq paramlkq)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlkq.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramlkq.a("OpenGLBlowUp/width", 0);
      this.c = paramlkq.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramlkq.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramlkq) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     loo
 * JD-Core Version:    0.7.0.1
 */