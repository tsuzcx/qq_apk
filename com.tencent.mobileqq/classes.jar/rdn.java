import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class rdn
  implements moc
{
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  
  public rdn(rdm paramrdm, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("TemplateFactory", 2, "loaded: bid : " + this.jdField_a_of_type_JavaLangString + " param1 " + paramString + " code : " + paramInt);
    if (paramInt == 0)
    {
      if (paramString == null) {}
      try
      {
        QLog.d("TemplateFactory", 2, "下载离线样式包完成 : " + this.jdField_a_of_type_JavaLangString + " param1 " + paramString);
        rdz.a(rdm.a(this.jdField_a_of_type_Rdm));
        if ((paramString == null) && (rdz.a(this.jdField_a_of_type_JavaLangString).a))
        {
          QLog.d("TemplateFactory", 2, "加载离线包 : " + this.jdField_a_of_type_JavaLangString + " param1 " + paramString);
          new rdo().a(5);
          rsk.a(2, rdm.a(this.jdField_a_of_type_Rdm));
          rdg localrdg = this.jdField_a_of_type_Rdm.a(BaseApplicationImpl.getApplication());
          if (localrdg == null)
          {
            QLog.d("TemplateFactory", 2, "templateFactory == null  bid : " + this.jdField_a_of_type_JavaLangString + " param1 " + paramString + " code : " + paramInt);
            return;
          }
          localrdg.a(rdm.a().incrementAndGet());
          rdz.a(this.jdField_a_of_type_JavaLangString, localrdg);
          rdg.a();
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString, paramString);
      }
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rdn
 * JD-Core Version:    0.7.0.1
 */