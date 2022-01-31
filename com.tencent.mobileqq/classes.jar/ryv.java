import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class ryv
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ryv jdField_a_of_type_Ryv;
  private String jdField_a_of_type_JavaLangString = "WeishiNewService";
  
  public static ryv a()
  {
    if (jdField_a_of_type_Ryv == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ryv == null) {
        jdField_a_of_type_Ryv = new ryv();
      }
      return jdField_a_of_type_Ryv;
    }
  }
  
  public int a(ryw paramryw, ryn paramryn)
  {
    if (paramryw == null) {}
    for (;;)
    {
      return 1000004;
      paramryw.a(paramryn);
      paramryw.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), ryy.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((ryz)paramryn);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramryn = BaseApplicationImpl.getApplication().getRuntime();
          if (paramryn != null)
          {
            paramryn.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramryw.uniKey() + ", pkgId=" + paramryw.a() + " submit to MSF, isLogin: " + paramryn.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramryw)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramryw.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryv
 * JD-Core Version:    0.7.0.1
 */