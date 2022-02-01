import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.DummyCallback.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class svg
  implements nmg
{
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  
  public svg(svf paramsvf, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString + " param " + paramString + " code : " + paramInt);
    if ((paramInt != 0) || (paramString == null)) {}
    try
    {
      QLog.d("TemplateFactory", 2, "下载离线样式包完成 : " + this.jdField_a_of_type_JavaLangString);
      svr.a(svf.a(this.jdField_a_of_type_Svf));
      if ((paramString == null) && (svr.a(this.jdField_a_of_type_JavaLangString).a))
      {
        QLog.d("TemplateFactory", 1, "加载离线包 : " + this.jdField_a_of_type_JavaLangString);
        tyd.a(2, svf.a(this.jdField_a_of_type_Svf));
        this.jdField_a_of_type_Svf.b(this.jdField_a_of_type_JavaLangString);
        bnrf.a("kandian_pts_style_update", Boolean.valueOf(true));
        svc.a().b();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString, paramString);
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new StyleLoaderHelper.DummyCallback.1(this, paramString, paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svg
 * JD-Core Version:    0.7.0.1
 */