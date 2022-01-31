package com.tencent.qqprotect.qsec;

import alxf;
import alxg;
import alxh;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.MobileQQ;

public class GGMM
{
  private static final Set jdField_a_of_type_JavaUtilSet;
  private static final byte[] jdField_a_of_type_ArrayOfByte;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mc", "md", "mg", "wfm", "sno", "fg", "brd", "hw", "dv", "tm", "ts", "rs", "rc" };
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_ArrayOfByte = new byte[] { 74, 39, 2, -61, -88, -75, -36, 105 };
    jdField_a_of_type_JavaUtilSet.add("mg");
    jdField_a_of_type_JavaUtilSet.add("wfm");
  }
  
  private static InputStream a()
  {
    if (!SystemUtil.a()) {}
    Object localObject;
    do
    {
      return null;
      localObject = new File(d());
    } while ((!((File)localObject).exists()) || (((File)localObject).length() > 102400L));
    try
    {
      Cipher localCipher = Cipher.getInstance("DES");
      localCipher.init(2, new SecretKeySpec(jdField_a_of_type_ArrayOfByte, "DES"));
      localObject = new CipherInputStream(new BufferedInputStream(new FileInputStream((File)localObject)), localCipher);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private static String a()
  {
    String str2 = QPMiscUtils.b(1);
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 0) {
        str1 = ("A" + str2 + "123456789ABCDEF").substring(0, 15);
      }
    }
    return str1;
  }
  
  private static String a(int paramInt)
  {
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append((char)(localRandom.nextInt(25) + 65));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new String(Base64.decode(paramString.getBytes(), 2));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String a(Map paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  public static Map a()
  {
    try
    {
      Map localMap = a(new FileInputStream("/proc/cpuinfo"), new alxf());
      return localMap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private static Map a(InputStream paramInputStream, alxi paramalxi)
  {
    // Byte code:
    //   0: new 208	java/util/HashMap
    //   3: dup
    //   4: invokespecial 209	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 211	java/io/BufferedReader
    //   11: dup
    //   12: new 213	java/io/InputStreamReader
    //   15: dup
    //   16: aload_0
    //   17: ldc 215
    //   19: invokespecial 218	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: invokespecial 221	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 224	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +61 -> 97
    //   39: aload_2
    //   40: astore_0
    //   41: aload_1
    //   42: aload 4
    //   44: invokeinterface 229 2 0
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull -27 -> 26
    //   56: aload_2
    //   57: astore_0
    //   58: aload_3
    //   59: aload 4
    //   61: getfield 235	android/util/Pair:first	Ljava/lang/Object;
    //   64: aload 4
    //   66: getfield 238	android/util/Pair:second	Ljava/lang/Object;
    //   69: invokevirtual 242	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: goto -47 -> 26
    //   76: astore_0
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 245	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: areturn
    //   97: aload_2
    //   98: ifnull -3 -> 95
    //   101: aload_2
    //   102: invokevirtual 245	java/io/BufferedReader:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   112: aload_3
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   119: aload_3
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 245	java/io/BufferedReader:close	()V
    //   132: aload_1
    //   133: athrow
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_1
    //   143: goto -19 -> 124
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -68 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramInputStream	InputStream
    //   0	152	1	paramalxi	alxi
    //   25	77	2	localObject1	Object
    //   146	1	2	localException	Exception
    //   7	113	3	localHashMap	HashMap
    //   32	33	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	76	java/lang/Exception
    //   41	51	76	java/lang/Exception
    //   58	73	76	java/lang/Exception
    //   101	105	107	java/lang/Exception
    //   91	95	114	java/lang/Exception
    //   8	26	121	finally
    //   128	132	134	java/lang/Exception
    //   28	34	142	finally
    //   41	51	142	finally
    //   58	73	142	finally
    //   83	87	142	finally
    //   8	26	146	java/lang/Exception
  }
  
  private static Map a(String[] paramArrayOfString)
  {
    Map localMap = c();
    Object localObject2 = null;
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    int i1 = paramArrayOfString.length;
    int n = 0;
    int i = 0;
    int j = 0;
    String str;
    Object localObject3;
    Object localObject1;
    if (n < i1)
    {
      str = paramArrayOfString[n];
      if (jdField_a_of_type_JavaUtilSet.contains(str))
      {
        localObject3 = b(localHashMap, str);
        localHashSet.add(str);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localHashMap.put(str, localObject3);
      n += 1;
      localObject2 = localObject1;
      break;
      localObject1 = (String)localMap.get(str);
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      int k = i;
      int m = j;
      if (localObject1 == null)
      {
        j += 1;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = b();
        }
        localObject2 = (String)((Map)localObject1).get(str);
        localObject3 = localObject2;
        localObject4 = localObject1;
        k = i;
        m = j;
        if (localObject2 == null)
        {
          i += 1;
          localObject2 = b(localHashMap, str);
          localObject3 = localObject2;
          localObject4 = localObject1;
          k = i;
          m = j;
          if (str.equals("md"))
          {
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localHashSet.add("md");
              j -= 1;
              i -= 1;
              localObject3 = localObject2;
              continue;
            }
            localObject3 = b();
            continue;
            if (j > 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GGMM", 2, "update to sp.");
              }
              b(localHashSet, localHashMap);
            }
            if ((i > 0) || (a()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("GGMM", 2, "update to sdcard.");
              }
              a(localHashSet, localHashMap);
            }
            return localHashMap;
          }
        }
      }
      j = m;
      localObject1 = localObject4;
      i = k;
    }
  }
  
  public static void a()
  {
    long l1 = 604800000L;
    if (!QSecFramework.a().a(1002).booleanValue()) {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "door closed.");
      }
    }
    Object localObject;
    String str;
    do
    {
      do
      {
        return;
        localObject = BaseApplication.getContext().getSharedPreferences("di_time", 0);
      } while (localObject == null);
      str = e();
    } while (str == null);
    long l2 = ((SharedPreferences)localObject).getLong(str, 0L);
    long l3 = new Date().getTime();
    if (l3 - l2 > 604800000L)
    {
      b();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong(str, l3);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "rpt after: " + l1);
      }
      QSecFramework.a().postDelayed(new alxh(), l1);
      return;
      l1 = 604800000L - l3 + l2;
    }
  }
  
  private static void a(Map paramMap1, Map paramMap2)
  {
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Object localObject = (Map.Entry)paramMap1.next();
        String str = a((String)((Map.Entry)localObject).getKey());
        localObject = a((String)((Map.Entry)localObject).getValue());
        if ((str != null) && (localObject != null)) {
          paramMap2.put(str, localObject);
        }
      }
    }
  }
  
  /* Error */
  private static void a(Set paramSet, Map paramMap)
  {
    // Byte code:
    //   0: invokestatic 73	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_3
    //   9: ldc 93
    //   11: invokestatic 99	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   14: astore_2
    //   15: aload_2
    //   16: iconst_1
    //   17: new 101	javax/crypto/spec/SecretKeySpec
    //   20: dup
    //   21: getstatic 57	com/tencent/qqprotect/qsec/GGMM:jdField_a_of_type_ArrayOfByte	[B
    //   24: ldc 93
    //   26: invokespecial 104	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   29: invokevirtual 108	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   32: new 394	javax/crypto/CipherOutputStream
    //   35: dup
    //   36: new 396	java/io/FileOutputStream
    //   39: dup
    //   40: invokestatic 79	com/tencent/qqprotect/qsec/GGMM:d	()Ljava/lang/String;
    //   43: invokespecial 397	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   46: aload_2
    //   47: invokespecial 400	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   50: astore_2
    //   51: aload_1
    //   52: invokeinterface 369 1 0
    //   57: invokeinterface 373 1 0
    //   62: astore_1
    //   63: aload_1
    //   64: invokeinterface 378 1 0
    //   69: ifeq +116 -> 185
    //   72: aload_1
    //   73: invokeinterface 382 1 0
    //   78: checkcast 384	java/util/Map$Entry
    //   81: astore_3
    //   82: aload_0
    //   83: aload_3
    //   84: invokeinterface 387 1 0
    //   89: invokeinterface 252 2 0
    //   94: ifne -31 -> 63
    //   97: aload_2
    //   98: new 137	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   105: aload_3
    //   106: invokeinterface 387 1 0
    //   111: checkcast 12	java/lang/String
    //   114: invokevirtual 177	java/lang/String:getBytes	()[B
    //   117: iconst_2
    //   118: invokestatic 404	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   121: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 406
    //   127: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokeinterface 392 1 0
    //   136: checkcast 12	java/lang/String
    //   139: invokevirtual 177	java/lang/String:getBytes	()[B
    //   142: iconst_2
    //   143: invokestatic 404	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   146: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 408
    //   152: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 177	java/lang/String:getBytes	()[B
    //   161: invokevirtual 413	java/io/OutputStream:write	([B)V
    //   164: goto -101 -> 63
    //   167: astore_1
    //   168: aload_2
    //   169: astore_0
    //   170: aload_1
    //   171: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   174: aload_0
    //   175: ifnull -169 -> 6
    //   178: aload_0
    //   179: invokevirtual 414	java/io/OutputStream:close	()V
    //   182: return
    //   183: astore_0
    //   184: return
    //   185: aload_2
    //   186: ifnull -180 -> 6
    //   189: aload_2
    //   190: invokevirtual 414	java/io/OutputStream:close	()V
    //   193: return
    //   194: astore_0
    //   195: return
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 414	java/io/OutputStream:close	()V
    //   207: aload_0
    //   208: athrow
    //   209: astore_1
    //   210: goto -3 -> 207
    //   213: astore_0
    //   214: aload_2
    //   215: astore_1
    //   216: goto -17 -> 199
    //   219: astore_2
    //   220: aload_0
    //   221: astore_1
    //   222: aload_2
    //   223: astore_0
    //   224: goto -25 -> 199
    //   227: astore_1
    //   228: aload_3
    //   229: astore_0
    //   230: goto -60 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramSet	Set
    //   0	233	1	paramMap	Map
    //   14	201	2	localObject1	Object
    //   219	4	2	localObject2	Object
    //   8	221	3	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   51	63	167	java/lang/Exception
    //   63	164	167	java/lang/Exception
    //   178	182	183	java/io/IOException
    //   189	193	194	java/io/IOException
    //   9	51	196	finally
    //   203	207	209	java/io/IOException
    //   51	63	213	finally
    //   63	164	213	finally
    //   170	174	219	finally
    //   9	51	227	java/lang/Exception
  }
  
  private static boolean a()
  {
    File localFile = new File(d());
    return (SystemUtil.a()) && (!localFile.exists());
  }
  
  private static String b()
  {
    return "A" + a(15);
  }
  
  private static String b(Map paramMap, String paramString)
  {
    Object localObject = null;
    if (paramString.equals("wfm")) {
      paramMap = QPMiscUtils.b(2);
    }
    for (;;)
    {
      paramString = paramMap;
      if (paramMap == null) {
        paramString = "";
      }
      return paramString;
      if (paramString.equals("mc"))
      {
        paramMap = c();
      }
      else if (paramString.equals("md"))
      {
        paramMap = a();
      }
      else if (paramString.equals("mg"))
      {
        paramString = new StringBuilder();
        paramString.append(DeviceInfoUtil.g());
        paramString.append((String)paramMap.get("md"));
        paramString.append(Build.MANUFACTURER + Build.MODEL + (String)paramMap.get("mc"));
        paramMap = "A" + MD5FileUtil.b(paramString.toString()).substring(0, 15);
      }
      else if (paramString.equals("sno"))
      {
        paramMap = Build.SERIAL;
      }
      else if (paramString.equals("fg"))
      {
        paramMap = Build.FINGERPRINT;
      }
      else if (paramString.equals("brd"))
      {
        paramMap = Build.BOARD;
      }
      else if (paramString.equals("tm"))
      {
        paramMap = Long.toString(DeviceInfoUtil.e());
      }
      else if (paramString.equals("ts"))
      {
        paramMap = Long.toString(DeviceInfoUtil.b()[0]);
      }
      else if (paramString.equals("rs"))
      {
        paramMap = DeviceInfoUtil.m();
      }
      else if (paramString.equals("hw"))
      {
        paramMap = Build.HARDWARE;
      }
      else if (paramString.equals("dv"))
      {
        paramMap = Build.DEVICE;
      }
      else
      {
        paramMap = localObject;
        if (paramString.equals("rc")) {
          paramMap = a(16);
        }
      }
    }
  }
  
  private static Map b()
  {
    HashMap localHashMap = new HashMap();
    InputStream localInputStream = a();
    if (localInputStream == null) {}
    do
    {
      return localHashMap;
      a(a(localInputStream, new alxg()), localHashMap);
    } while (localInputStream == null);
    try
    {
      localInputStream.close();
      return localHashMap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localHashMap;
  }
  
  private static void b()
  {
    Map localMap = a(jdField_a_of_type_ArrayOfJavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = (String)localMap.get(arrayOfString[i]);
      localStringBuilder.append(",");
      localStringBuilder.append(str.replace(",", "&#44"));
      i += 1;
    }
    QSecRptController.b(localStringBuilder.toString().substring(1), 110);
  }
  
  private static void b(Set paramSet, Map paramMap)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("dfp", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (!paramSet.contains(localEntry.getKey())) {
            ((SharedPreferences.Editor)localObject).putString(Base64.encodeToString(((String)localEntry.getKey()).getBytes(), 2), Base64.encodeToString(((String)localEntry.getValue()).getBytes(), 2));
          }
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  private static String c()
  {
    Map localMap = a();
    if (localMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Features"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Processor"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "CPU architecture"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Hardware"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Serial"));
    return localStringBuilder.toString();
  }
  
  private static Map c()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("dfp", 0);
    HashMap localHashMap = new HashMap();
    if (localSharedPreferences != null) {}
    try
    {
      a(localSharedPreferences.getAll(), localHashMap);
      return localHashMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localHashMap;
  }
  
  private static String d()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/kf.dat";
  }
  
  private static String e()
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      if (localObject != null) {
        try
        {
          long l = Long.parseLong((String)localObject);
          localObject = Base64.encodeToString((DeviceInfoUtil.d() + "_" + Long.toString(l ^ 0xADCD123)).getBytes(), 2);
          return localObject;
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.GGMM
 * JD-Core Version:    0.7.0.1
 */