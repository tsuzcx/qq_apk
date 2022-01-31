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

public class ost
{
  private static final LRULinkedHashMap<String, osw> jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static volatile ost jdField_a_of_type_Ost;
  private static volatile boolean jdField_a_of_type_Boolean;
  public static int b;
  private static final LRULinkedHashMap<String, osw> jdField_b_of_type_ComTencentUtilLRULinkedHashMap;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g = 5;
  protected int a;
  private long jdField_a_of_type_Long;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  private String jdField_a_of_type_JavaLangString;
  protected final osx a;
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
  
  public ost()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Osx = new osx(new osu(this));
  }
  
  public static ost a()
  {
    if (jdField_a_of_type_Ost == null) {
      jdField_a_of_type_Ost = new ost();
    }
    return jdField_a_of_type_Ost;
  }
  
  public static osw a(String paramString)
  {
    if ((AppSetting.g) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("viola.ReadInJoyWebRenderEngine", 2, "native_render  getRenderHtmlData url : " + paramString);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localosw = (osw)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
      if (localosw != null)
      {
        paramString = localosw;
        if (localosw.a()) {
          paramString = null;
        }
        return paramString;
      }
    }
    osw localosw = (osw)jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    if (localosw != null)
    {
      paramString = localosw;
      if (localosw.a()) {}
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
  public static void a(String paramString, osv paramosv)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 132	ost:jdField_a_of_type_Boolean	Z
    //   6: ifeq +20 -> 26
    //   9: aload_1
    //   10: ifnull +12 -> 22
    //   13: aload_1
    //   14: getstatic 47	ost:g	I
    //   17: invokeinterface 137 2 0
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: invokestatic 143	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   29: new 145	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$3
    //   32: dup
    //   33: aload_1
    //   34: aload_0
    //   35: invokespecial 148	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$3:<init>	(Losv;Ljava/lang/String;)V
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
    //   0	51	1	paramosv	osv
    // Exception table:
    //   from	to	target	type
    //   3	9	45	finally
    //   13	22	45	finally
    //   26	42	45	finally
  }
  
  public static void b()
  {
    if (!bhvh.n(onk.a())) {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [getWebRenderConfig], is:", Boolean.valueOf(false) });
      }
    }
    for (;;)
    {
      if (rwa.a()) {
        rwa.a();
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
    File localFile = new File(osz.a(), "libviola.so");
    if ((!jdField_a_of_type_Boolean) || (!localFile.exists()))
    {
      onk.a(onk.a(), true, 2);
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
    onk.a(onk.a(), true, 9);
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
    if (bcfx.a((String)localObject))
    {
      localObject = bcfx.a((String)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((bcfy)localObject).jdField_b_of_type_JavaLangString))) {
        this.jdField_e_of_type_JavaLangString = ((bcfy)localObject).jdField_b_of_type_JavaLangString;
      }
    }
    while (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_GetHtml mHtmlOffline is empty");
      }
      onk.a(onk.a(), true, 7);
      return a(paramBundle);
      localObject = mze.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        try
        {
          int i = ((mzi)localObject).a.available();
          if (i != 0)
          {
            byte[] arrayOfByte = new byte[i];
            if (i == ((mzi)localObject).a.read(arrayOfByte)) {
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
      if (!TextUtils.isEmpty(paramBundle.getString(rwx.jdField_a_of_type_JavaLangString))) {
        str1 = paramBundle.getString(rwx.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(rwx.jdField_e_of_type_JavaLangString))) {
        str2 = paramBundle.getString(rwx.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(rwx.jdField_c_of_type_JavaLangString))) {
        str3 = paramBundle.getString(rwx.jdField_c_of_type_JavaLangString);
      }
      str4 = str1;
      str5 = str2;
      str6 = str3;
      if (!TextUtils.isEmpty(paramBundle.getString(rwx.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_f_of_type_JavaLangString = paramBundle.getString(rwx.jdField_d_of_type_JavaLangString);
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
      jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new osw(this.jdField_e_of_type_JavaLangString, "utf-8", 1800000L));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render one result total cost[" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " ms]");
      }
      onk.a(onk.a(), true, 8);
      onk.a(onk.a(), true, 12, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      d();
      a();
      this.jdField_a_of_type_Int = 1;
      return -1;
      label131:
      jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new osw(this.jdField_e_of_type_JavaLangString, "utf-8"));
    }
  }
  
  public int j(Bundle paramBundle)
  {
    onk.a(onk.a(), true, 3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ost
 * JD-Core Version:    0.7.0.1
 */