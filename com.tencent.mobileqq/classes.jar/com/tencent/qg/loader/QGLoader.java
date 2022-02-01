package com.tencent.qg.loader;

import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class QGLoader
{
  public static AtomicBoolean a;
  public static final String[] a;
  public static AtomicBoolean b = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libicudata_53.so", "libicuuc_53.so", "libicui18n_53.so", "libJavaScriptCore.so", "libqg.so" };
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private static int a()
  {
    Object localObject = a();
    if (localObject == null) {
      return 0;
    }
    localObject = ((File)localObject).getName();
    try
    {
      i = Integer.parseInt(((String)localObject).substring(0, ((String)localObject).lastIndexOf(".")));
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int i;
      label54:
      label56:
      break label54;
    }
    try
    {
      QLog.d("QGLoader", 1, new Object[] { "getQGLocalVersion version success. version=", Integer.valueOf(i) });
      return i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label56;
    }
    i = 0;
    QLog.e("QGLoader", 1, new Object[] { "getQGLocalVersion version error. fileName=", localObject });
    return i;
  }
  
  private static File a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.a("1018"));
    ((StringBuilder)localObject).append("1018");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).isDirectory()) {
      return null;
    }
    localObject = ((File)localObject).listFiles(new QGLoader.2());
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return null;
      }
      return localObject[0];
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = b.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" load so enter. soloaded=");
      QLog.d("QGLoader", 2, new Object[] { localStringBuilder.toString(), Boolean.valueOf(bool2) });
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGLoader", 2, "load offline so");
      }
      if (a() < 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QGLoader", 2, new Object[] { "so version low. min version is: ", Integer.valueOf(6) });
        }
        return false;
      }
      bool2 = c("1018");
      bool1 = bool2;
      if (bool2)
      {
        b.set(true);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private static boolean b(String paramString)
  {
    paramString = new File(paramString).listFiles(new QGLoader.3());
    if ((paramString != null) && (paramString.length != 0))
    {
      Object localObject1 = new ArrayList();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramString[i];
        try
        {
          System.load(localObject2.getAbsolutePath());
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QGLoader", 1, new Object[] { "load so error=", localUnsatisfiedLinkError2.getMessage() });
          }
          ((ArrayList)localObject1).add(localObject2);
        }
        i += 1;
      }
      paramString = ((ArrayList)localObject1).iterator();
      boolean bool = true;
      while (paramString.hasNext())
      {
        localObject1 = (File)paramString.next();
        try
        {
          System.load(((File)localObject1).getAbsolutePath());
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QGLoader", 1, new Object[] { "load so again error=", localUnsatisfiedLinkError1.getMessage() });
          }
          bool = false;
        }
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QGLoader", 2, "load so files empty.");
    }
    return false;
  }
  
  /* Error */
  private static boolean c(String paramString)
  {
    // Byte code:
    //   0: invokestatic 193	com/tencent/mobileqq/utils/SoLoadUtil:a	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: new 85	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: invokestatic 93	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: getstatic 197	java/io/File:separator	Ljava/lang/String;
    //   35: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_2
    //   40: ldc 199
    //   42: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: getstatic 197	java/io/File:separator	Ljava/lang/String;
    //   50: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 4
    //   60: invokestatic 43	com/tencent/qg/loader/QGLoader:a	()Ljava/io/File;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnonnull +9 -> 74
    //   68: aload 4
    //   70: invokestatic 201	com/tencent/qg/loader/QGLoader:b	(Ljava/lang/String;)Z
    //   73: ireturn
    //   74: aconst_null
    //   75: astore_3
    //   76: aconst_null
    //   77: astore_0
    //   78: new 150	java/util/ArrayList
    //   81: dup
    //   82: invokespecial 151	java/util/ArrayList:<init>	()V
    //   85: astore 5
    //   87: new 203	java/io/BufferedReader
    //   90: dup
    //   91: new 205	java/io/FileReader
    //   94: dup
    //   95: aload_2
    //   96: invokespecial 208	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   99: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +20 -> 132
    //   115: aload 5
    //   117: aload_0
    //   118: invokeinterface 223 2 0
    //   123: pop
    //   124: aload_2
    //   125: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   128: astore_0
    //   129: goto -21 -> 108
    //   132: aload_2
    //   133: invokevirtual 226	java/io/BufferedReader:close	()V
    //   136: goto +13 -> 149
    //   139: astore_0
    //   140: ldc 66
    //   142: iconst_1
    //   143: ldc 228
    //   145: aload_0
    //   146: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: iconst_1
    //   150: istore_1
    //   151: goto +93 -> 244
    //   154: astore_3
    //   155: aload_2
    //   156: astore_0
    //   157: aload_3
    //   158: astore_2
    //   159: goto +196 -> 355
    //   162: astore_3
    //   163: goto +12 -> 175
    //   166: astore_2
    //   167: goto +188 -> 355
    //   170: astore_0
    //   171: aload_3
    //   172: astore_2
    //   173: aload_0
    //   174: astore_3
    //   175: aload_2
    //   176: astore_0
    //   177: new 85	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   184: astore 6
    //   186: aload_2
    //   187: astore_0
    //   188: aload 6
    //   190: ldc 234
    //   192: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_2
    //   197: astore_0
    //   198: aload 6
    //   200: aload_3
    //   201: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   204: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_2
    //   209: astore_0
    //   210: ldc 66
    //   212: iconst_1
    //   213: aload 6
    //   215: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 237	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_2
    //   222: ifnull +20 -> 242
    //   225: aload_2
    //   226: invokevirtual 226	java/io/BufferedReader:close	()V
    //   229: goto +13 -> 242
    //   232: astore_0
    //   233: ldc 66
    //   235: iconst_1
    //   236: ldc 228
    //   238: aload_0
    //   239: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   242: iconst_0
    //   243: istore_1
    //   244: iload_1
    //   245: ifne +9 -> 254
    //   248: aload 4
    //   250: invokestatic 201	com/tencent/qg/loader/QGLoader:b	(Ljava/lang/String;)Z
    //   253: ireturn
    //   254: aload 5
    //   256: invokeinterface 239 1 0
    //   261: ifne +92 -> 353
    //   264: aload 5
    //   266: invokeinterface 240 1 0
    //   271: astore_0
    //   272: aload_0
    //   273: invokeinterface 177 1 0
    //   278: ifeq +44 -> 322
    //   281: aload_0
    //   282: invokeinterface 181 1 0
    //   287: checkcast 12	java/lang/String
    //   290: astore_2
    //   291: new 85	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   298: astore_3
    //   299: aload_3
    //   300: aload 4
    //   302: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_3
    //   307: aload_2
    //   308: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_3
    //   313: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 159	java/lang/System:load	(Ljava/lang/String;)V
    //   319: goto -47 -> 272
    //   322: iload_1
    //   323: ireturn
    //   324: astore_0
    //   325: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +25 -> 353
    //   331: ldc 66
    //   333: iconst_1
    //   334: iconst_2
    //   335: anewarray 4	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: ldc 161
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: aload_0
    //   346: invokevirtual 164	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   349: aastore
    //   350: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   353: iconst_0
    //   354: ireturn
    //   355: aload_0
    //   356: ifnull +20 -> 376
    //   359: aload_0
    //   360: invokevirtual 226	java/io/BufferedReader:close	()V
    //   363: goto +13 -> 376
    //   366: astore_0
    //   367: ldc 66
    //   369: iconst_1
    //   370: ldc 228
    //   372: aload_0
    //   373: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   376: goto +5 -> 381
    //   379: aload_2
    //   380: athrow
    //   381: goto -2 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString	String
    //   150	173	1	bool	boolean
    //   15	144	2	localObject1	Object
    //   166	1	2	localObject2	Object
    //   172	208	2	localObject3	Object
    //   75	1	3	localObject4	Object
    //   154	4	3	localObject5	Object
    //   162	10	3	localException	java.lang.Exception
    //   174	139	3	localObject6	Object
    //   58	243	4	str	String
    //   85	180	5	localArrayList	ArrayList
    //   184	30	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   132	136	139	java/io/IOException
    //   103	108	154	finally
    //   108	129	154	finally
    //   103	108	162	java/lang/Exception
    //   108	129	162	java/lang/Exception
    //   87	103	166	finally
    //   177	186	166	finally
    //   188	196	166	finally
    //   198	208	166	finally
    //   210	221	166	finally
    //   87	103	170	java/lang/Exception
    //   225	229	232	java/io/IOException
    //   264	272	324	java/lang/UnsatisfiedLinkError
    //   272	319	324	java/lang/UnsatisfiedLinkError
    //   359	363	366	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.loader.QGLoader
 * JD-Core Version:    0.7.0.1
 */