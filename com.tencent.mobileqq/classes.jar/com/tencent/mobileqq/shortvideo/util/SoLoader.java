package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.SwitchFaceUtil;
import com.tencent.ttpic.util.VideoLibUtil;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;

public class SoLoader
{
  public static int a;
  private static final Object a;
  public static final String a;
  public static boolean a;
  public static int[] a;
  public static final String[] a;
  private static int jdField_b_of_type_Int;
  private static final Object jdField_b_of_type_JavaLangObject;
  public static final String b;
  public static boolean b;
  public static int[] b;
  public static final String[] b;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  public static final String[] c;
  private static int jdField_d_of_type_Int;
  private static boolean jdField_d_of_type_Boolean;
  public static final String[] d;
  private static boolean e;
  
  static
  {
    jdField_a_of_type_Int = -4;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libgnustl_shared.so", "libSNPE.so", "libQMCF_snpe.so" };
    jdField_a_of_type_ArrayOfInt = new int[] { -4, -4, -4 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "ccnf_patches_1_my36n.txt", "pdm_82_aligned_my36n.txt", "ufdmtcc.bin", "ufat.bin", "pdm.txt", "pdm_82.txt", "meshBasis.bin", "rotBasis.bin" };
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "pitu_tools", "ParticleSystem", "YTCommon", "image_filter_common", "image_filter_gpu", "algo_rithm_jni", "format_convert", "YTIllumination", "YTFaceTrackPro", "algo_youtu_jni" };
    jdField_a_of_type_JavaLangString = a(jdField_c_of_type_ArrayOfJavaLangString[0]);
    jdField_b_of_type_JavaLangString = a(jdField_c_of_type_ArrayOfJavaLangString[1]);
    jdField_b_of_type_ArrayOfInt = new int[] { -4, -4, -4, -4, -4, -4, -4, -4, -4, -4 };
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Int = 8114;
    jdField_c_of_type_Int = 25801;
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "libnnpack.so", "libsegmentern.so", "libsegmentero.so" };
    e = false;
    jdField_d_of_type_Int = -4;
    jdField_b_of_type_Boolean = false;
  }
  
  public static int a(String paramString)
  {
    try
    {
      boolean bool = j();
      if (bool)
      {
        System.loadLibrary(paramString);
        return 0;
      }
      SLog.a("SoLoader", "loadTestEnvSolib:isTestEnvSurpportVideoSo=" + bool, null);
      return -4;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      SLog.a("SoLoader", "loadTestEnvSolib:loaderr e=", paramString);
    }
    return -3;
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a()
  {
    if (jdField_d_of_type_Boolean) {}
    String[] arrayOfString;
    do
    {
      return;
      arrayOfString = a();
    } while (arrayOfString == null);
    FaceOffUtil.setNoEyeGrayImagePath(arrayOfString[0]);
    FaceOffUtil.setNoMouthGrayImagePath(arrayOfString[1]);
    FaceOffUtil.setCrazyFacePath(arrayOfString[3]);
    FaceOffUtil.setCropHeadFacePath(arrayOfString[4]);
    SwitchFaceUtil.setNoEyeGrayImagePath(arrayOfString[0]);
    SwitchFaceUtil.setNoMouthGrayImagePath(arrayOfString[1]);
    SwitchFaceUtil.setAllGrayImagePath(arrayOfString[2]);
    jdField_d_of_type_Boolean = true;
  }
  
  public static boolean a()
  {
    if (jdField_c_of_type_Boolean) {
      return true;
    }
    String str = SdkContext.a().a().a().b();
    if (str == null) {
      return false;
    }
    jdField_c_of_type_Boolean = FileUtils.a(str + "libQMCF.so");
    boolean bool = FileUtils.a(str + jdField_a_of_type_ArrayOfJavaLangString[2]);
    if (SLog.a()) {
      SLog.c("SoLoader", String.format("isQmcfSoExist, qmcf[%s], snpe[%s]", new Object[] { Boolean.valueOf(jdField_c_of_type_Boolean), Boolean.valueOf(bool) }));
    }
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean a(Context paramContext)
  {
    return i();
  }
  
  public static boolean a(Context arg0, boolean paramBoolean)
  {
    boolean bool = false;
    if (!jdField_d_of_type_Boolean) {
      a();
    }
    if (paramBoolean) {
      paramBoolean = c();
    }
    for (;;)
    {
      if ((!paramBoolean) || (!jdField_a_of_type_Boolean)) {}
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        try
        {
          YTCommonInterface.initAuth(SdkContext.a().a(), "youtusdk_mqq.licence", 0, true);
          jdField_a_of_type_Boolean = true;
          SLog.c("SoLoader", "getPtuLicense  suc after loadSo ");
          bool = e();
          return bool;
          paramBoolean = b(???);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (SLog.a()) {
              SLog.a("SoLoader", "YTCommonInterface failed after loadSo", localThrowable);
            }
          }
        }
      }
    }
  }
  
  public static String[] a()
  {
    String str = SdkContext.a().a().a().a();
    if ((FileUtils.a(str + "noeyegray.png")) && (FileUtils.a(str + "nomouthgray.png")) && (FileUtils.a(str + "allgray.png")) && (FileUtils.a(str + "crazyfacegray.png")) && (FileUtils.a(str + "faceheadcropgray.png"))) {}
    for (int i = 1; i != 0; i = 0) {
      return new String[] { str + "noeyegray.png", str + "nomouthgray.png", str + "allgray.png", str + "crazyfacegray.png", str + "faceheadcropgray.png" };
    }
    return null;
  }
  
  private static int b(String paramString)
  {
    int i;
    if (paramString == null) {
      i = -1;
    }
    do
    {
      return i;
      if (!new File(paramString).exists()) {
        return -2;
      }
      try
      {
        System.load(paramString);
        return 0;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        i = -3;
      }
    } while (!SLog.a());
    SLog.a("SoLoader", "LoadExtractedShortVideoFilterLib : exp=", paramString);
    return -3;
  }
  
  public static boolean b()
  {
    if (SLog.a()) {
      SLog.c("SoLoader", String.format("isLoadArtFilterSuccess, status=[%S]", new Object[] { Integer.valueOf(jdField_a_of_type_Int) }));
    }
    return jdField_a_of_type_Int == 0;
  }
  
  public static boolean b(Context paramContext)
  {
    if (d()) {
      return true;
    }
    String str = SdkContext.a().a().a().a();
    if (str == null)
    {
      SLog.a("SoLoader", "loadAllFilterSo: soRootPath==null", null);
      return false;
    }
    paramContext = jdField_b_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < jdField_c_of_type_ArrayOfJavaLangString.length)
        {
          if (jdField_b_of_type_ArrayOfInt[i] != 0) {
            jdField_b_of_type_ArrayOfInt[i] = b(str + a(jdField_c_of_type_ArrayOfJavaLangString[i]));
          }
        }
        else
        {
          boolean bool = d();
          if (SLog.a()) {
            SLog.c("EffectEnable", String.format("loadAllFilterSo, bSuc[%s], soPath[%s]", new Object[] { Boolean.valueOf(bool), str }));
          }
          return bool;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static boolean c()
  {
    Object localObject1 = jdField_b_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < jdField_c_of_type_ArrayOfJavaLangString.length)
      {
        jdField_b_of_type_ArrayOfInt[i] = a(jdField_c_of_type_ArrayOfJavaLangString[i]);
        i += 1;
      }
      boolean bool = d();
      if (SLog.a()) {
        SLog.c("EffectEnable", String.format("loadTestEnvFilterSo, PT_TEST_ENV[%s], bSuc[%s]", new Object[] { Boolean.valueOf(false), Boolean.valueOf(bool) }));
      }
      return bool;
    }
    finally {}
  }
  
  public static boolean d()
  {
    Object localObject3 = jdField_b_of_type_JavaLangObject;
    Object localObject1 = "isLoadFilterSuccess:";
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < jdField_b_of_type_ArrayOfInt.length)
        {
          localObject1 = (String)localObject1 + "SV_SO_LOAD_STATUS_pendant[" + i + "]=" + jdField_b_of_type_ArrayOfInt[i];
          i += 1;
          continue;
        }
        if (SLog.a()) {
          SLog.c("EffectEnable", (String)localObject1);
        }
        localObject1 = jdField_b_of_type_ArrayOfInt;
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          if (localObject1[i] != 0) {
            return false;
          }
        }
        else {
          return true;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static boolean e()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        int i = VideoLibUtil.getFilterLibVersion();
        boolean bool1;
        localUnsatisfiedLinkError1.printStackTrace();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        try
        {
          j = VideoLibUtil.getFaceDetectLibVersion();
          if (SLog.a()) {
            SLog.d("SoLoader", "isFilterFaceSoVersionOK:filterversion=" + i + " detectversion=" + j + " FILTER_SO_VERSION=" + jdField_b_of_type_Int + " FACE_DETECT_SO_VERSION=" + jdField_c_of_type_Int);
          }
          bool1 = bool2;
          if (i >= jdField_b_of_type_Int)
          {
            bool1 = bool2;
            if (j >= jdField_c_of_type_Int) {
              bool1 = true;
            }
          }
          return bool1;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          int j;
          break label101;
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        i = 0;
      }
      label101:
      j = 0;
    }
  }
  
  public static boolean f()
  {
    if (SLog.a()) {
      SLog.c("SoLoader", "isPortraitSoLoadSuccess, POR_SO_segment[" + jdField_d_of_type_Int + "], filterLoadSuccess:" + d());
    }
    if (jdField_d_of_type_Int == 0) {
      return d();
    }
    return false;
  }
  
  public static boolean g()
  {
    boolean bool5 = false;
    if (e) {
      return true;
    }
    String str = SdkContext.a().a().a().b();
    if (str == null) {
      return false;
    }
    int i = 0;
    if (i < jdField_d_of_type_ArrayOfJavaLangString.length) {
      if (FileUtil.a(str + jdField_d_of_type_ArrayOfJavaLangString[i])) {}
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool3;
      boolean bool2;
      if (bool1)
      {
        bool3 = FileUtil.a(str + "deploy.rapidnetproto");
        bool2 = FileUtil.a(str + "model.rapidnetmodel");
      }
      for (;;)
      {
        if (SLog.a()) {
          SLog.c("SoLoader", String.format("isPortraitSoExist, exist[%s], deploy[%s], model[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
        }
        boolean bool4 = bool5;
        if (bool1)
        {
          bool4 = bool5;
          if (bool3)
          {
            bool4 = bool5;
            if (bool2) {
              bool4 = true;
            }
          }
        }
        e = bool4;
        return e;
        i += 1;
        break;
        bool2 = false;
        bool3 = false;
      }
    }
  }
  
  /* Error */
  public static boolean h()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 186	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   8: invokevirtual 355	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/DpcSwitcher;
    //   11: invokeinterface 358 1 0
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +8 -> 26
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_0
    //   25: ireturn
    //   26: invokestatic 360	com/tencent/mobileqq/shortvideo/util/SoLoader:f	()Z
    //   29: ifeq +8 -> 37
    //   32: iconst_1
    //   33: istore_0
    //   34: goto -13 -> 21
    //   37: invokestatic 362	com/tencent/mobileqq/shortvideo/util/SoLoader:g	()Z
    //   40: ifeq +112 -> 152
    //   43: invokestatic 186	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   46: invokevirtual 189	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/mobileqq/shortvideo/resource/Resources;
    //   49: invokeinterface 253 1 0
    //   54: invokeinterface 338 1 0
    //   59: astore_2
    //   60: new 129	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   67: aload_2
    //   68: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: getstatic 105	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   74: iconst_0
    //   75: aaload
    //   76: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 279	java/lang/System:load	(Ljava/lang/String;)V
    //   85: new 129	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   92: aload_2
    //   93: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: getstatic 105	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   99: iconst_2
    //   100: aaload
    //   101: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 279	java/lang/System:load	(Ljava/lang/String;)V
    //   110: iconst_1
    //   111: putstatic 111	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_b_of_type_Boolean	Z
    //   114: iconst_0
    //   115: putstatic 109	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_Int	I
    //   118: getstatic 111	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_b_of_type_Boolean	Z
    //   121: ifne +31 -> 152
    //   124: new 129	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: getstatic 105	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   138: iconst_1
    //   139: aaload
    //   140: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 294	com/tencent/mobileqq/shortvideo/util/SoLoader:b	(Ljava/lang/String;)I
    //   149: putstatic 109	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_Int	I
    //   152: invokestatic 360	com/tencent/mobileqq/shortvideo/util/SoLoader:f	()Z
    //   155: istore_0
    //   156: goto -135 -> 21
    //   159: astore_3
    //   160: getstatic 111	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_b_of_type_Boolean	Z
    //   163: ifne -11 -> 152
    //   166: new 129	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   173: aload_2
    //   174: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: getstatic 105	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   180: iconst_1
    //   181: aaload
    //   182: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 294	com/tencent/mobileqq/shortvideo/util/SoLoader:b	(Ljava/lang/String;)I
    //   191: putstatic 109	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_Int	I
    //   194: goto -42 -> 152
    //   197: astore_2
    //   198: ldc 2
    //   200: monitorexit
    //   201: aload_2
    //   202: athrow
    //   203: astore_3
    //   204: getstatic 111	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_b_of_type_Boolean	Z
    //   207: ifne -55 -> 152
    //   210: new 129	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   217: aload_2
    //   218: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: getstatic 105	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   224: iconst_1
    //   225: aaload
    //   226: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 294	com/tencent/mobileqq/shortvideo/util/SoLoader:b	(Ljava/lang/String;)I
    //   235: putstatic 109	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_Int	I
    //   238: goto -86 -> 152
    //   241: astore_3
    //   242: getstatic 111	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_b_of_type_Boolean	Z
    //   245: ifne +31 -> 276
    //   248: new 129	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   255: aload_2
    //   256: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: getstatic 105	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   262: iconst_1
    //   263: aaload
    //   264: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 294	com/tencent/mobileqq/shortvideo/util/SoLoader:b	(Ljava/lang/String;)I
    //   273: putstatic 109	com/tencent/mobileqq/shortvideo/util/SoLoader:jdField_d_of_type_Int	I
    //   276: aload_3
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	155	0	bool1	boolean
    //   16	2	1	bool2	boolean
    //   59	115	2	str1	String
    //   197	59	2	str2	String
    //   159	1	3	localException	java.lang.Exception
    //   203	1	3	localError	java.lang.Error
    //   241	36	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	118	159	java/lang/Exception
    //   5	17	197	finally
    //   26	32	197	finally
    //   37	60	197	finally
    //   118	152	197	finally
    //   152	156	197	finally
    //   160	194	197	finally
    //   204	238	197	finally
    //   242	276	197	finally
    //   276	278	197	finally
    //   60	118	203	java/lang/Error
    //   60	118	241	finally
  }
  
  private static boolean i()
  {
    boolean bool = false;
    if (b()) {
      bool = true;
    }
    while (SdkContext.a().a() == null) {
      return bool;
    }
    String str = SdkContext.a().a().a().b();
    if (jdField_a_of_type_Int != 0)
    {
      jdField_a_of_type_Int = b(str + "libQMCF.so");
      if (FileUtils.a(str + jdField_a_of_type_ArrayOfJavaLangString[2]))
      {
        int i = 0;
        while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          if (jdField_a_of_type_ArrayOfInt[i] != 0) {
            jdField_a_of_type_ArrayOfInt[i] = b(str + jdField_a_of_type_ArrayOfJavaLangString[i]);
          }
          if (SLog.a()) {
            SLog.c("SoLoader", String.format("loadSnpeSo, idx[%d], bSuc[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(jdField_a_of_type_ArrayOfInt[i]) }));
          }
          i += 1;
        }
        int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
        int k = arrayOfInt.length;
        i = 0;
        int j = 1;
        while (i < k)
        {
          if (arrayOfInt[i] != 0) {
            j = 0;
          }
          i += 1;
        }
        if (j != 0) {
          QmcfManager.jdField_a_of_type_Boolean = true;
        }
      }
    }
    bool = b();
    if (SLog.a()) {
      SLog.c("SoLoader", String.format("loadArtFilterSo, bSuc[%s], snpeSuc[%s], soPath[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(QmcfManager.jdField_a_of_type_Boolean), str }));
    }
    return bool;
  }
  
  private static boolean j()
  {
    String str = Build.CPU_ABI;
    return (str != null) && (!"".equals(str)) && ("armeabi-v7a".equalsIgnoreCase(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SoLoader
 * JD-Core Version:    0.7.0.1
 */