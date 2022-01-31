package com.tencent.mobileqq.qmcf;

import ahac;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class QmcfManager
{
  private static QmcfManager jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager;
  private static QmcfReporter jdField_a_of_type_ComTencentMobileqqQmcfQmcfReporter;
  private static QmcfSwitchStrategy jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy;
  public static String a;
  public static boolean a;
  public static boolean b;
  private static int jdField_d_of_type_Int;
  public static boolean d;
  public static boolean e = true;
  public int a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(16);
  ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = null;
  public float[] a;
  private int b;
  public String b;
  private int c;
  public String c;
  public boolean c;
  private String jdField_d_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "qmcf_frame_type";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy = new QmcfSwitchStrategy();
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfReporter = new QmcfReporter();
    jdField_d_of_type_Int = 1;
    jdField_d_of_type_Boolean = false;
  }
  
  public QmcfManager()
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
  }
  
  public static QmcfManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager == null) {
      jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager = new QmcfManager();
    }
    return jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3) {
      return 2;
    }
    return 0;
  }
  
  public QmcfModelItem a()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      localObject2 = null;
    }
    label465:
    do
    {
      return localObject2;
      Object localObject7 = new File(this.jdField_d_of_type_JavaLangString + "params.json");
      if (!((File)localObject7).exists())
      {
        if (SLog.a()) {
          SLog.d("QMCF_MGR", "getQmcfModelItem file not exist " + ((File)localObject7).getAbsolutePath());
        }
        return null;
      }
      Object localObject5 = FileUtils.a((File)localObject7);
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        return null;
      }
      String str = null;
      Object localObject4 = null;
      int i = 0;
      Object localObject1 = localObject4;
      localObject2 = str;
      Object localObject3;
      try
      {
        localObject6 = new JSONObject((String)localObject5);
        localObject1 = localObject4;
        localObject2 = str;
        str = ((JSONObject)localObject6).getString("model_name");
        localObject1 = localObject4;
        localObject2 = str;
        localObject4 = ((JSONObject)localObject6).getString("model_struct");
        localObject1 = localObject4;
        localObject2 = str;
        localObject5 = ((JSONObject)localObject6).optString("model_dlc");
        localObject1 = localObject5;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject6;
          int j;
          long l;
          boolean bool2;
          boolean bool3;
          localObject5 = null;
          localException1.printStackTrace();
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        boolean bool1;
        if (SLog.a())
        {
          if (TextUtils.isEmpty((CharSequence)localObject7)) {
            break label566;
          }
          bool1 = true;
          SLog.d("QMCF_MGR", String.format("getQmcfModelItem modelValid[%s]", new Object[] { Boolean.valueOf(bool1) }));
        }
        for (;;)
        {
          localObject1 = null;
          break;
          bool1 = false;
          break label538;
          ((File)localObject7).delete();
        }
      }
      try
      {
        j = ((JSONObject)localObject6).optInt("model_encrypt");
        i = j;
        localObject5 = localObject1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null) {
          break label602;
        }
        l = System.currentTimeMillis();
        localObject2 = this.jdField_d_of_type_JavaLangString + str;
        localObject1 = this.jdField_d_of_type_JavaLangString + (String)localObject4;
        localObject6 = this.jdField_d_of_type_JavaLangString + (String)localObject5;
        bool2 = new File((String)localObject2).exists();
        bool3 = new File((String)localObject1).exists();
        if ((!bool2) || (!bool3)) {
          break label572;
        }
        localObject7 = a((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject7)) {
          break label521;
        }
        localObject1 = new QmcfModelItem();
        ((QmcfModelItem)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject7);
        ((QmcfModelItem)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
        ((QmcfModelItem)localObject1).jdField_c_of_type_JavaLangString = ((String)localObject6);
        ((QmcfModelItem)localObject1).jdField_a_of_type_Int = i;
        this.jdField_a_of_type_JavaUtilHashMap.put(str, localObject1);
        localObject2 = localObject1;
        if (SLog.a())
        {
          SLog.d("QMCF_MGR", String.format("getQmcfModelItem cost[%s], paramExit[%s], modelExist[%s], paramName[%s], modelName[%s], dlcName[%s]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), str, localObject4, localObject5 }));
          localObject2 = localObject1;
        }
      }
      catch (Exception localException2)
      {
        localObject5 = localObject1;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject3 = localException2;
        break;
        localObject2 = null;
        break label465;
      }
    } while (this.jdField_a_of_type_JavaUtilHashMap.get(str) == null);
    localObject1 = (QmcfModelItem)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    this.jdField_b_of_type_JavaLangString = str;
    return localObject1;
  }
  
  public QmcfSwitchStrategy a()
  {
    return jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 98	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 118	java/io/File:exists	()Z
    //   17: ifeq +198 -> 215
    //   20: new 212	java/io/FileInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore 5
    //   30: aload 5
    //   32: astore_1
    //   33: new 197	java/lang/String
    //   36: dup
    //   37: aload_0
    //   38: aload 5
    //   40: invokestatic 221	com/tencent/util/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   43: invokevirtual 224	com/tencent/mobileqq/qmcf/QmcfManager:a	([B)[B
    //   46: invokespecial 227	java/lang/String:<init>	([B)V
    //   49: astore 6
    //   51: aload 6
    //   53: astore_1
    //   54: aload 5
    //   56: ifnull +11 -> 67
    //   59: aload 5
    //   61: invokevirtual 230	java/io/FileInputStream:close	()V
    //   64: aload 6
    //   66: astore_1
    //   67: invokestatic 122	com/tencent/sveffects/SLog:a	()Z
    //   70: ifeq +55 -> 125
    //   73: new 100	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   80: ldc 232
    //   82: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   88: lload_2
    //   89: lsub
    //   90: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: ldc 237
    //   95: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: astore 5
    //   100: aload_1
    //   101: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +95 -> 199
    //   107: iconst_1
    //   108: istore 4
    //   110: ldc 124
    //   112: aload 5
    //   114: iload 4
    //   116: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 132	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_1
    //   126: areturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   132: aload 6
    //   134: astore_1
    //   135: goto -68 -> 67
    //   138: astore 6
    //   140: aconst_null
    //   141: astore 5
    //   143: aload 5
    //   145: astore_1
    //   146: aload 6
    //   148: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 230	java/io/FileInputStream:close	()V
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -96 -> 67
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -106 -> 67
    //   176: astore 5
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 230	java/io/FileInputStream:close	()V
    //   188: aload 5
    //   190: athrow
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   196: goto -8 -> 188
    //   199: iconst_0
    //   200: istore 4
    //   202: goto -92 -> 110
    //   205: astore 5
    //   207: goto -27 -> 180
    //   210: astore 6
    //   212: goto -69 -> 143
    //   215: aconst_null
    //   216: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	QmcfManager
    //   0	217	1	paramString	String
    //   3	86	2	l	long
    //   108	93	4	bool	boolean
    //   28	129	5	localObject1	Object
    //   176	13	5	localObject2	Object
    //   205	1	5	localObject3	Object
    //   49	84	6	str	String
    //   138	9	6	localException1	Exception
    //   210	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   59	64	127	java/lang/Exception
    //   20	30	138	java/lang/Exception
    //   156	161	166	java/lang/Exception
    //   20	30	176	finally
    //   184	188	191	java/lang/Exception
    //   33	51	205	finally
    //   146	151	205	finally
    //   33	51	210	java/lang/Exception
  }
  
  public void a()
  {
    if (SLog.a()) {
      SLog.d("QMCF_MGR", "destroy");
    }
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfReporter.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfReporter.a(paramInt1, paramInt2, paramString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (SLog.a()) {
      SLog.d("QMCF_MGR", "switchQmcfModel begin resFold" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (paramInt == this.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_b_of_type_Int = paramInt;
        if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null)
        {
          if (SLog.a()) {
            SLog.d("QMCF_MGR", "switchQmcfModel create singleThreadExecutor");
          }
          this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
        }
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ahac(this));
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  public void a(long paramLong)
  {
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfReporter.a(paramLong);
  }
  
  public void a(String paramString)
  {
    if (jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.c())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("svaf_gpuinfo", paramString);
      paramString = jdField_a_of_type_ComTencentMobileqqQmcfQmcfReporter;
      QmcfReporter.a("svaf_nosupport_ocl", localHashMap, true);
    }
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.b(false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.a(paramBoolean1, paramBoolean2, paramInt);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int != 0;
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return false;
      boolean bool3 = c(paramInt);
      boolean bool2 = SoLoader.b();
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (!bool2)
        {
          if (!paramBoolean) {
            break label98;
          }
          paramBoolean = SoLoader.a(SdkContext.a().a());
          bool1 = paramBoolean;
          if (SLog.a()) {
            SLog.d("QMCF_MGR", "reloadso :" + paramBoolean);
          }
        }
      }
      label98:
      for (bool1 = paramBoolean; (bool3) && (bool1); bool1 = SoLoader.a()) {
        return true;
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    return QMCF.nDrink(paramArrayOfByte, paramArrayOfByte.length, QMCF.getDefaultSign());
  }
  
  public int b()
  {
    if (this.jdField_c_of_type_Int == -1)
    {
      this.jdField_c_of_type_Int = SdkContext.a().a().getSharedPreferences("QmcfConfig", 4).getInt(jdField_a_of_type_JavaLangString, -1);
      if (SLog.a()) {
        SLog.d("QMCF_MGR", "getCurrFrameType:" + this.jdField_c_of_type_Int);
      }
    }
    return this.jdField_c_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfReporter.b(paramLong);
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.a(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b(int paramInt)
  {
    return paramInt >= jdField_d_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      SharedPreferences.Editor localEditor = SdkContext.a().a().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt(jdField_a_of_type_JavaLangString, paramInt);
      localEditor.commit();
      if (SLog.a()) {
        SLog.d("QMCF_MGR", "setCurrFrameType:" + paramInt);
      }
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public boolean c()
  {
    try
    {
      this.jdField_c_of_type_JavaLangString = SdkContext.a().a().a().c();
      File localFile = new File(this.jdField_c_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(this.jdField_c_of_type_JavaLangString + "binarys/");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return true;
    }
    catch (Exception localException)
    {
      if (SLog.a()) {
        SLog.d("QMCF_MGR", "createDir excep");
      }
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean c(int paramInt)
  {
    return jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.a(paramInt);
  }
  
  public boolean d()
  {
    return (jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.a(1)) || (jdField_a_of_type_ComTencentMobileqqQmcfQmcfSwitchStrategy.a(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfManager
 * JD-Core Version:    0.7.0.1
 */