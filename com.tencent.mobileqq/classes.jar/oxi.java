import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.viola.core.ViolaInstance;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class oxi
{
  private static final LRULinkedHashMap<String, oxl> jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static volatile oxi jdField_a_of_type_Oxi;
  private static volatile boolean jdField_a_of_type_Boolean;
  public static int b;
  private static final LRULinkedHashMap<String, oxl> jdField_b_of_type_ComTencentUtilLRULinkedHashMap;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g = 5;
  protected int a;
  private long jdField_a_of_type_Long;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  private String jdField_a_of_type_JavaLangString;
  protected final oxm a;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  private String f;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(4);
    jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(4);
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = 2;
    jdField_e_of_type_Int = 3;
    jdField_f_of_type_Int = 4;
  }
  
  public oxi()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Oxm = new oxm(new oxj(this));
  }
  
  public static oxi a()
  {
    if (jdField_a_of_type_Oxi == null) {
      jdField_a_of_type_Oxi = new oxi();
    }
    return jdField_a_of_type_Oxi;
  }
  
  public static oxl a(String paramString)
  {
    if ((AppSetting.f) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("viola.ReadInJoyWebRenderEngine", 2, "native_render  getRenderHtmlData url : " + paramString);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localoxl = (oxl)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
      if (localoxl != null)
      {
        paramString = localoxl;
        if (localoxl.a()) {
          paramString = null;
        }
        return paramString;
      }
    }
    oxl localoxl = (oxl)jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    if (localoxl != null)
    {
      paramString = localoxl;
      if (localoxl.a()) {}
    }
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "[notifyLibLoad], ret:", Integer.valueOf(paramInt) });
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      a(paramString, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static void a(String paramString, oxk paramoxk)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 132	oxi:jdField_a_of_type_Boolean	Z
    //   6: ifeq +20 -> 26
    //   9: aload_1
    //   10: ifnull +12 -> 22
    //   13: aload_1
    //   14: getstatic 47	oxi:g	I
    //   17: invokeinterface 137 2 0
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: invokestatic 143	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   29: new 145	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$3
    //   32: dup
    //   33: aload_1
    //   34: aload_0
    //   35: invokespecial 148	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$3:<init>	(Loxk;Ljava/lang/String;)V
    //   38: invokevirtual 154	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   41: pop
    //   42: goto -20 -> 22
    //   45: astore_0
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramString	String
    //   0	51	1	paramoxk	oxk
    // Exception table:
    //   from	to	target	type
    //   3	9	45	finally
    //   13	22	45	finally
    //   26	42	45	finally
  }
  
  public static void b()
  {
    if (!bjxj.o(ors.a())) {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [getWebRenderConfig], is:", Boolean.valueOf(false) });
      }
    }
    for (;;)
    {
      if (smk.a()) {
        smk.a();
      }
      return;
      if (!jdField_a_of_type_Boolean) {
        a("preload");
      } else if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [sLoadEngineLibDone], is:", Boolean.valueOf(true) });
      }
    }
  }
  
  public static boolean b()
  {
    boolean bool = true;
    File localFile = new File(oxo.a(), "libviola.so");
    if ((!jdField_a_of_type_Boolean) || (!localFile.exists()))
    {
      ors.a(ors.a(), true, 2);
      a("other ");
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(false) });
      }
      bool = false;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(true) });
    return true;
  }
  
  public static void c() {}
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public int a(Bundle paramBundle)
  {
    ors.a(ors.a(), true, 9);
    this.jdField_a_of_type_Int = 11;
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null)
    {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.destroy();
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = null;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b(Bundle paramBundle)
  {
    Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("_prenr");
    if ((!this.jdField_d_of_type_Boolean) && (a(this.jdField_a_of_type_JavaLangString) != null))
    {
      this.jdField_a_of_type_Int = 10;
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 1, "native_render doCreateLoopStep_Check has url cache");
      }
    }
    for (;;)
    {
      return 0;
      this.jdField_a_of_type_Int = 4;
    }
  }
  
  @Deprecated
  public int c(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int d(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int e(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int f(Bundle paramBundle)
  {
    return 0;
  }
  
  public int g(Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString.replace("_pbid", "_bid");
    if (befm.a((String)localObject))
    {
      localObject = befm.a((String)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((befn)localObject).jdField_b_of_type_JavaLangString))) {
        this.jdField_e_of_type_JavaLangString = ((befn)localObject).jdField_b_of_type_JavaLangString;
      }
    }
    while (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_GetHtml mHtmlOffline is empty");
      }
      ors.a(ors.a(), true, 7);
      return a(paramBundle);
      localObject = nbv.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        try
        {
          int i = ((nbz)localObject).a.available();
          if (i != 0)
          {
            byte[] arrayOfByte = new byte[i];
            if (i == ((nbz)localObject).a.read(arrayOfByte)) {
              this.jdField_e_of_type_JavaLangString = new String(arrayOfByte, "utf-8");
            }
          }
        }
        catch (IOException localIOException)
        {
          return a(paramBundle);
        }
      }
    }
    this.jdField_a_of_type_Int = 8;
    return 0;
  }
  
  public int h(Bundle paramBundle)
  {
    String str1 = "<!--native-render-->";
    String str3 = "<!--native-data-render-->";
    String str2 = "renderData";
    this.jdField_f_of_type_JavaLangString = "true;";
    String str4 = str1;
    String str5 = str2;
    String str6 = str3;
    if (paramBundle != null)
    {
      if (!TextUtils.isEmpty(paramBundle.getString(snh.jdField_a_of_type_JavaLangString))) {
        str1 = paramBundle.getString(snh.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(snh.jdField_e_of_type_JavaLangString))) {
        str2 = paramBundle.getString(snh.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(snh.jdField_c_of_type_JavaLangString))) {
        str3 = paramBundle.getString(snh.jdField_c_of_type_JavaLangString);
      }
      str4 = str1;
      str5 = str2;
      str6 = str3;
      if (!TextUtils.isEmpty(paramBundle.getString(snh.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_f_of_type_JavaLangString = paramBundle.getString(snh.jdField_d_of_type_JavaLangString);
        str6 = str3;
        str5 = str2;
        str4 = str1;
      }
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.replaceFirst(str4, this.jdField_d_of_type_JavaLangString);
    this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.replaceFirst(str6, "var " + str5 + " = " + this.jdField_f_of_type_JavaLangString + ";");
    this.jdField_a_of_type_Int = 9;
    return 0;
  }
  
  public int i(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      if (!this.jdField_c_of_type_Boolean) {
        break label131;
      }
      jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new oxl(this.jdField_e_of_type_JavaLangString, "utf-8", 1800000L));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render one result total cost[" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " ms]");
      }
      ors.a(ors.a(), true, 8);
      ors.a(ors.a(), true, 12, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      d();
      a();
      this.jdField_a_of_type_Int = 1;
      return -1;
      label131:
      jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new oxl(this.jdField_e_of_type_JavaLangString, "utf-8"));
    }
  }
  
  public int j(Bundle paramBundle)
  {
    ors.a(ors.a(), true, 3);
    d();
    a();
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
  
  public int k(Bundle paramBundle)
  {
    d();
    a();
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oxi
 * JD-Core Version:    0.7.0.1
 */