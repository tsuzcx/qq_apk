import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.1;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.2;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.3;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.4;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class pvy
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile pvy jdField_a_of_type_Pvy;
  public final boolean a;
  private final String jdField_b_of_type_JavaLangString = "3980";
  private volatile boolean jdField_b_of_type_Boolean;
  private final String c = "readinjoy_pts_engine";
  private final String d = "libpts.so";
  private final String e = "pts_config.json";
  private final String f = ncb.a("3980") + "3980";
  private final String g = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/" + "readinjoy_pts_engine";
  
  private pvy()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static pvy a()
  {
    if (jdField_a_of_type_Pvy == null) {}
    try
    {
      if (jdField_a_of_type_Pvy == null) {
        jdField_a_of_type_Pvy = new pvy();
      }
      return jdField_a_of_type_Pvy;
    }
    finally {}
  }
  
  private boolean b()
  {
    Object localObject = this.g + "/" + "libpts.so";
    String str = this.g + "/" + "pts_config.json";
    boolean bool1 = bdcs.a((String)localObject);
    boolean bool2 = pwc.a(str);
    jdField_a_of_type_JavaLangString = pwc.b(str);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSEngineIsValid]").append("\n").append(", ptsEngineVersion = ").append(jdField_a_of_type_JavaLangString).append("\n").append(", isSoExists = ").append(bool1).append("\n").append(", isVersionSupport = ").append(bool2).append("\n");
    QLog.i("PTSEngineLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  private void c()
  {
    ThreadManager.excute(new PTSEngineLoader.3(this), 128, null, true);
  }
  
  private boolean c()
  {
    return false;
  }
  
  private void d()
  {
    ThreadManager.excute(new PTSEngineLoader.4(this), 64, null, false);
  }
  
  private void e()
  {
    if (c()) {
      return;
    }
    if (a())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts engine is ready, do not load again.");
      return;
    }
    if (b())
    {
      PTSEngineLoader.5 local5 = new PTSEngineLoader.5(this);
      pwa.a().a(local5);
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], inner dir is not valid, load pts engine failed.");
    d();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    PTSEngineLoader.1 local1 = new PTSEngineLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      PTSEngineLoader.2 local2 = new PTSEngineLoader.2(this);
      ThreadManager.getFileThreadHandler().post(local2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvy
 * JD-Core Version:    0.7.0.1
 */