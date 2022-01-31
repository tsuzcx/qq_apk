import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.DummyCallback.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class sfx
  implements nbs
{
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  
  public sfx(sfw paramsfw, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("TemplateFactory", 2, "loaded: bid : " + this.jdField_a_of_type_JavaLangString + " param " + paramString + " code : " + paramInt);
    if (paramInt == 0)
    {
      if (paramString == null) {}
      try
      {
        QLog.d("TemplateFactory", 2, "下载离线样式包完成 : " + this.jdField_a_of_type_JavaLangString);
        sgi.a(sfw.a(this.jdField_a_of_type_Sfw));
        if ((paramString == null) && (sgi.a(this.jdField_a_of_type_JavaLangString).a))
        {
          QLog.d("TemplateFactory", 2, "加载离线包 : " + this.jdField_a_of_type_JavaLangString);
          swt.a(2, sfw.a(this.jdField_a_of_type_Sfw));
          paramString = this.jdField_a_of_type_Sfw.a(BaseApplicationImpl.getApplication());
          if (paramString == null)
          {
            QLog.d("TemplateFactory", 2, "templateFactory == null  bid : " + this.jdField_a_of_type_JavaLangString + " code : " + paramInt);
            return;
          }
          paramString.a(sfw.a().incrementAndGet());
          sgi.a(this.jdField_a_of_type_JavaLangString, paramString);
          sfq.a();
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString, paramString);
      }
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new StyleLoaderHelper.DummyCallback.1(this, paramInt, paramString));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sfx
 * JD-Core Version:    0.7.0.1
 */