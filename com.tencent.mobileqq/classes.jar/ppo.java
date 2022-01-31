import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.1;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.2;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ppo
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile ppo jdField_a_of_type_Ppo;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String b = "4044";
  private final String c = "readinjoy_pts_jsc";
  private final String d = "libjsc.so";
  private final String e = "pts_jsc_config.json";
  private final String f = mzk.a("4044") + "4044";
  private final String g = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/" + "readinjoy_pts_jsc";
  
  public static ppo a()
  {
    if (jdField_a_of_type_Ppo == null) {}
    try
    {
      if (jdField_a_of_type_Ppo == null) {
        jdField_a_of_type_Ppo = new ppo();
      }
      return jdField_a_of_type_Ppo;
    }
    finally {}
  }
  
  private void b()
  {
    beiw.a(new PTSJSCLoader.3(this), 128, null, true);
  }
  
  private boolean b()
  {
    Object localObject = this.g + "/" + "pts_jsc_config.json";
    boolean bool1 = bbdj.a(this.g + "/" + "libjsc.so");
    boolean bool2 = ppq.a((String)localObject);
    jdField_a_of_type_JavaLangString = ppq.b((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSJSCIsValid]").append("\n").append(", ptsJSCVersion = ").append(jdField_a_of_type_JavaLangString).append("\n").append(", isJSCSoExists = ").append(bool1).append("\n").append(", isVersionSupport = ").append(bool2).append("\n");
    QLog.i("PTSJSCLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  private void c()
  {
    try
    {
      beiw.a(new PTSJSCLoader.4(this), 64, null, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      PTSJSCLoader.1 local1 = new PTSJSCLoader.1(this);
      beiw.a().postDelayed(local1, 10000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (a())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (paramRunnable != null) {
        beiw.b().post(paramRunnable);
      }
      return;
    }
    if (b())
    {
      paramRunnable = new PTSJSCLoader.2(this, paramRunnable);
      beiw.b().post(paramRunnable);
      return;
    }
    QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], pts jsc is not valid, load jsc so failed.");
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppo
 * JD-Core Version:    0.7.0.1
 */