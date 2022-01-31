import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.1;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.3;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.4;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class pdu
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile pdu jdField_a_of_type_Pdu;
  public final boolean a;
  private final String jdField_b_of_type_JavaLangString = "3980";
  private volatile boolean jdField_b_of_type_Boolean;
  private final String jdField_c_of_type_JavaLangString = "readinjoy_pts_engine";
  private volatile boolean jdField_c_of_type_Boolean;
  private final String d = "libpts.so";
  private final String e = "libjsc.so";
  private final String f = "pts_config.json";
  private final String g = mol.a("3980") + "3980";
  private final String h = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/" + "readinjoy_pts_engine";
  private final String i = "1";
  private final String j = "2";
  
  private pdu()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static pdu a()
  {
    if (jdField_a_of_type_Pdu == null) {}
    try
    {
      if (jdField_a_of_type_Pdu == null) {
        jdField_a_of_type_Pdu = new pdu();
      }
      return jdField_a_of_type_Pdu;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    pen.a("0X800A833", "", "", "", new peo().a("type", paramString2).a("msg", paramString1).a());
  }
  
  private void b(String paramString1, String paramString2)
  {
    pen.a("0X800A832", "", "", "", new peo().a("type", paramString2).a("msg", paramString1).a());
  }
  
  private boolean b()
  {
    Object localObject = this.h + "/" + "libpts.so";
    String str1 = this.h + "/" + "pts_config.json";
    String str2 = this.h + "/" + "libjsc.so";
    boolean bool1 = bace.a((String)localObject);
    boolean bool2 = bace.a(str2);
    boolean bool3 = pdw.a(str1);
    jdField_a_of_type_JavaLangString = pdw.b(str1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSEngineIsValid]").append("\n").append(", ptsEngineVersion = ").append(jdField_a_of_type_JavaLangString).append("\n").append(", isSoExists = ").append(bool1).append("\n").append(", isVersionSupport = ").append(bool3).append("\n").append(", isJscSoExists = ").append(bool2).append("\n");
    QLog.i("PTSEngineLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool3) && (bool2);
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
    ThreadManager.excute(new PTSEngineLoader.5(this), 64, null, false);
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
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 208	pdu:c	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 210	com/tencent/biz/pubaccount/readinjoy/pts/loader/PTSEngineLoader$2
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 211	com/tencent/biz/pubaccount/readinjoy/pts/loader/PTSEngineLoader$2:<init>	(Lpdu;)V
    //   22: bipush 64
    //   24: aconst_null
    //   25: iconst_0
    //   26: invokestatic 183	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   29: goto -18 -> 11
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	pdu
    //   6	2	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   14	29	32	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdu
 * JD-Core Version:    0.7.0.1
 */