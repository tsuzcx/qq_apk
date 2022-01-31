import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class slo
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static slo jdField_a_of_type_Slo;
  private String jdField_a_of_type_JavaLangString = "WeishiNewService";
  
  public static slo a()
  {
    if (jdField_a_of_type_Slo == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Slo == null) {
        jdField_a_of_type_Slo = new slo();
      }
      return jdField_a_of_type_Slo;
    }
  }
  
  public int a(slp paramslp, slg paramslg)
  {
    if (paramslp == null) {}
    for (;;)
    {
      return 1000004;
      paramslp.a(paramslg);
      paramslp.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), slr.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((sls)paramslg);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramslg = BaseApplicationImpl.getApplication().getRuntime();
          if (paramslg != null)
          {
            paramslg.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramslp.uniKey() + ", pkgId=" + paramslp.a() + " submit to MSF, isLogin: " + paramslg.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramslp)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramslp.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slo
 * JD-Core Version:    0.7.0.1
 */