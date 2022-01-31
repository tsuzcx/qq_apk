import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class slr
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static slr jdField_a_of_type_Slr;
  private String jdField_a_of_type_JavaLangString = "WeishiNewService";
  
  public static slr a()
  {
    if (jdField_a_of_type_Slr == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Slr == null) {
        jdField_a_of_type_Slr = new slr();
      }
      return jdField_a_of_type_Slr;
    }
  }
  
  public int a(sls paramsls, slj paramslj)
  {
    if (paramsls == null) {}
    for (;;)
    {
      return 1000004;
      paramsls.a(paramslj);
      paramsls.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), slu.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((slv)paramslj);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramslj = BaseApplicationImpl.getApplication().getRuntime();
          if (paramslj != null)
          {
            paramslj.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramsls.uniKey() + ", pkgId=" + paramsls.a() + " submit to MSF, isLogin: " + paramslj.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramsls)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramsls.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slr
 * JD-Core Version:    0.7.0.1
 */