import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.1;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.2;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class qzc
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile qzc jdField_a_of_type_Qzc;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String b = nvf.a("4044") + "4044";
  private final String c = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/" + "readinjoy_pts_jsc";
  
  public static qzc a()
  {
    if (jdField_a_of_type_Qzc == null) {}
    try
    {
      if (jdField_a_of_type_Qzc == null) {
        jdField_a_of_type_Qzc = new qzc();
      }
      return jdField_a_of_type_Qzc;
    }
    finally {}
  }
  
  private void b()
  {
    ThreadManager.excute(new PTSJSCLoader.3(this), 128, null, true);
  }
  
  private boolean b()
  {
    Object localObject = this.c + "/" + "pts_jsc_config.json";
    boolean bool1 = FileUtils.fileExists(this.c + "/" + "libjsc.so");
    boolean bool2 = qze.a((String)localObject);
    jdField_a_of_type_JavaLangString = qze.b((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSJSCIsValid]").append("\n").append(", ptsJSCVersion = ").append(jdField_a_of_type_JavaLangString).append("\n").append(", isJSCSoExists = ").append(bool1).append("\n").append(", isVersionSupport = ").append(bool2).append("\n");
    QLog.i("PTSJSCLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  private void c()
  {
    try
    {
      ThreadManager.excute(new PTSJSCLoader.4(this), 64, null, false);
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
      ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
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
        ThreadManager.getFileThreadHandler().post(paramRunnable);
      }
      return;
    }
    if (b())
    {
      paramRunnable = new PTSJSCLoader.2(this, paramRunnable);
      ThreadManager.getFileThreadHandler().post(paramRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzc
 * JD-Core Version:    0.7.0.1
 */