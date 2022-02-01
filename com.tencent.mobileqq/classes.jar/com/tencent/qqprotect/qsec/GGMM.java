package com.tencent.qqprotect.qsec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.util.QQDeviceInfo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
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
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.MobileQQ;

public class GGMM
{
  private static final Set<String> jdField_a_of_type_JavaUtilSet;
  private static final byte[] jdField_a_of_type_ArrayOfByte;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mc", "md", "mg", "wfm", "sno", "fg", "brd", "hw", "dv", "tm", "ts", "rs", "rc", "rc2" };
  private static final byte[] b;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_ArrayOfByte = new byte[] { 74, 39, 2, -61, -88, -75, -36, 105, -102, 39, 2, 69, -72, -11, -84, 50 };
    b = new byte[] { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, -61, -88, -75, -68, 105 };
    jdField_a_of_type_JavaUtilSet.add("mg");
    jdField_a_of_type_JavaUtilSet.add("wfm");
  }
  
  private static InputStream a()
  {
    if (!SystemUtil.a()) {
      return null;
    }
    Object localObject = new File(d());
    if (!((File)localObject).exists()) {
      return null;
    }
    if (((File)localObject).length() > 102400L) {
      return null;
    }
    try
    {
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(b);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(jdField_a_of_type_ArrayOfByte, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
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
    String str = QPMiscUtils.b(1);
    Object localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.length() > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("A");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("123456789ABCDEF");
        localObject = ((StringBuilder)localObject).toString().substring(0, 15);
      }
    }
    return localObject;
  }
  
  private static String a(int paramInt)
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    int j = 0;
    try
    {
      localObject = new SecureRandom();
      i = 0;
      for (;;)
      {
        localStringBuilder1 = localStringBuilder2;
        if (i >= paramInt) {
          break;
        }
        localStringBuilder2.append((char)(((SecureRandom)localObject).nextInt(25) + 65));
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      int i;
      StringBuilder localStringBuilder1;
      label54:
      break label54;
    }
    localStringBuilder2 = new StringBuilder();
    localObject = new Random();
    ((Random)localObject).setSeed(System.currentTimeMillis());
    i = j;
    for (;;)
    {
      localStringBuilder1 = localStringBuilder2;
      if (i >= paramInt) {
        break;
      }
      localStringBuilder2.append((char)(((Random)localObject).nextInt(25) + 65));
      i += 1;
    }
    return localStringBuilder1.toString();
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
  
  private static String a(Map<String, String> paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  public static Map<String, String> a()
  {
    try
    {
      Map localMap = a(new FileInputStream("/proc/cpuinfo"), new GGMM.1());
      return localMap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private static Map<String, String> a(InputStream paramInputStream, GGMM.LineSeperator paramLineSeperator)
  {
    // Byte code:
    //   0: new 234	java/util/HashMap
    //   3: dup
    //   4: invokespecial 235	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: new 237	java/io/BufferedReader
    //   16: dup
    //   17: new 239	java/io/InputStreamReader
    //   20: dup
    //   21: aload_0
    //   22: ldc 241
    //   24: invokespecial 244	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   27: invokespecial 247	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 250	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +32 -> 69
    //   40: aload_1
    //   41: aload_2
    //   42: invokeinterface 255 2 0
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull -18 -> 31
    //   52: aload 4
    //   54: aload_2
    //   55: getfield 261	android/util/Pair:first	Ljava/lang/Object;
    //   58: aload_2
    //   59: getfield 264	android/util/Pair:second	Ljava/lang/Object;
    //   62: invokevirtual 268	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: goto -35 -> 31
    //   69: aload_0
    //   70: invokevirtual 271	java/io/BufferedReader:close	()V
    //   73: aload 4
    //   75: areturn
    //   76: astore_1
    //   77: aload_0
    //   78: astore_2
    //   79: aload_1
    //   80: astore_0
    //   81: goto +39 -> 120
    //   84: astore_1
    //   85: goto +10 -> 95
    //   88: astore_0
    //   89: goto +31 -> 120
    //   92: astore_1
    //   93: aload_3
    //   94: astore_0
    //   95: aload_0
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   101: aload_0
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: invokevirtual 271	java/io/BufferedReader:close	()V
    //   109: aload 4
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   117: aload 4
    //   119: areturn
    //   120: aload_2
    //   121: ifnull +15 -> 136
    //   124: aload_2
    //   125: invokevirtual 271	java/io/BufferedReader:close	()V
    //   128: goto +8 -> 136
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   136: goto +5 -> 141
    //   139: aload_0
    //   140: athrow
    //   141: goto -2 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramInputStream	InputStream
    //   0	144	1	paramLineSeperator	GGMM.LineSeperator
    //   12	113	2	localObject1	Object
    //   10	84	3	localObject2	Object
    //   7	111	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   31	36	76	finally
    //   40	48	76	finally
    //   52	66	76	finally
    //   31	36	84	java/lang/Exception
    //   40	48	84	java/lang/Exception
    //   52	66	84	java/lang/Exception
    //   13	31	88	finally
    //   97	101	88	finally
    //   13	31	92	java/lang/Exception
    //   69	73	112	java/lang/Exception
    //   105	109	112	java/lang/Exception
    //   124	128	131	java/lang/Exception
  }
  
  private static Map<String, String> a(String[] paramArrayOfString)
  {
    Map localMap = c();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    int i1 = paramArrayOfString.length;
    int k = 0;
    Object localObject3 = null;
    int n = 0;
    int m = 0;
    while (k < i1)
    {
      String str = paramArrayOfString[k];
      Object localObject1;
      int i;
      int j;
      Object localObject4;
      if (jdField_a_of_type_JavaUtilSet.contains(str))
      {
        localObject1 = b(localHashMap, str);
        localHashSet.add(str);
        i = n;
        j = m;
        localObject4 = localObject3;
      }
      else
      {
        Object localObject2 = (String)localMap.get(str);
        i = n;
        j = m;
        localObject4 = localObject3;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          n += 1;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = b();
          }
          localObject3 = (String)((Map)localObject2).get(str);
          i = n;
          j = m;
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            m += 1;
            localObject3 = b(localHashMap, str);
            i = n;
            j = m;
            localObject4 = localObject2;
            localObject1 = localObject3;
            if (str.equals("md")) {
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                i = n - 1;
                j = m - 1;
                localHashSet.add("md");
                localObject4 = localObject2;
                localObject1 = localObject3;
              }
              else
              {
                localObject1 = b();
                localObject4 = localObject2;
                j = m;
                i = n;
              }
            }
          }
        }
      }
      localHashMap.put(str, localObject1);
      k += 1;
      n = i;
      m = j;
      localObject3 = localObject4;
    }
    if (n > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "update to sp.");
      }
      b(localHashSet, localHashMap);
    }
    if ((m > 0) || (a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "update to sdcard.");
      }
      a(localHashSet, localHashMap);
    }
    return localHashMap;
  }
  
  public static void a()
  {
    if (!QSecFramework.a().a(1002).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "door closed.");
      }
      return;
    }
    Object localObject2 = BaseApplication.getContext().getSharedPreferences("di_time", 0);
    if (localObject2 != null)
    {
      Object localObject1 = e();
      if (localObject1 == null) {
        return;
      }
      long l2 = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
      long l3 = new Date().getTime();
      long l1 = 604800000L;
      if (l3 - l2 > 604800000L)
      {
        b();
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putLong((String)localObject1, l3);
        ((SharedPreferences.Editor)localObject2).commit();
      }
      else
      {
        l1 = 604800000L - l3 + l2;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("rpt after: ");
        ((StringBuilder)localObject1).append(l1);
        QLog.d("GGMM", 2, ((StringBuilder)localObject1).toString());
      }
      QSecFramework.a().postDelayed(new GGMM.3(), l1);
    }
  }
  
  private static void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if (paramMap1 == null) {
      return;
    }
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
  
  /* Error */
  private static void a(Set<String> paramSet, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: invokestatic 88	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: new 108	javax/crypto/spec/IvParameterSpec
    //   17: dup
    //   18: getstatic 72	com/tencent/qqprotect/qsec/GGMM:b	[B
    //   21: invokespecial 111	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   24: astore 5
    //   26: aload_3
    //   27: astore_2
    //   28: new 113	javax/crypto/spec/SecretKeySpec
    //   31: dup
    //   32: getstatic 67	com/tencent/qqprotect/qsec/GGMM:jdField_a_of_type_ArrayOfByte	[B
    //   35: ldc 115
    //   37: invokespecial 118	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   40: astore 6
    //   42: aload_3
    //   43: astore_2
    //   44: ldc 120
    //   46: invokestatic 126	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   49: astore 7
    //   51: aload_3
    //   52: astore_2
    //   53: aload 7
    //   55: iconst_1
    //   56: aload 6
    //   58: aload 5
    //   60: invokevirtual 130	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   63: aload_3
    //   64: astore_2
    //   65: new 423	javax/crypto/CipherOutputStream
    //   68: dup
    //   69: new 425	java/io/FileOutputStream
    //   72: dup
    //   73: invokestatic 94	com/tencent/qqprotect/qsec/GGMM:d	()Ljava/lang/String;
    //   76: invokespecial 426	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   79: aload 7
    //   81: invokespecial 429	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   84: astore_3
    //   85: aload_1
    //   86: invokeinterface 397 1 0
    //   91: invokeinterface 401 1 0
    //   96: astore_1
    //   97: aload_1
    //   98: invokeinterface 406 1 0
    //   103: ifeq +117 -> 220
    //   106: aload_1
    //   107: invokeinterface 410 1 0
    //   112: checkcast 412	java/util/Map$Entry
    //   115: astore_2
    //   116: aload_0
    //   117: aload_2
    //   118: invokeinterface 415 1 0
    //   123: invokeinterface 279 2 0
    //   128: ifeq +6 -> 134
    //   131: goto -34 -> 97
    //   134: new 158	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   141: astore 4
    //   143: aload 4
    //   145: aload_2
    //   146: invokeinterface 415 1 0
    //   151: checkcast 14	java/lang/String
    //   154: invokevirtual 202	java/lang/String:getBytes	()[B
    //   157: iconst_2
    //   158: invokestatic 433	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   161: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 4
    //   167: ldc_w 435
    //   170: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 4
    //   176: aload_2
    //   177: invokeinterface 420 1 0
    //   182: checkcast 14	java/lang/String
    //   185: invokevirtual 202	java/lang/String:getBytes	()[B
    //   188: iconst_2
    //   189: invokestatic 433	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   192: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: ldc_w 437
    //   201: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_3
    //   206: aload 4
    //   208: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokevirtual 202	java/lang/String:getBytes	()[B
    //   214: invokevirtual 442	java/io/OutputStream:write	([B)V
    //   217: goto -120 -> 97
    //   220: aload_3
    //   221: invokevirtual 443	java/io/OutputStream:close	()V
    //   224: return
    //   225: astore_0
    //   226: goto +34 -> 260
    //   229: astore_1
    //   230: aload_3
    //   231: astore_0
    //   232: goto +13 -> 245
    //   235: astore_0
    //   236: aload_2
    //   237: astore_3
    //   238: goto +22 -> 260
    //   241: astore_1
    //   242: aload 4
    //   244: astore_0
    //   245: aload_0
    //   246: astore_2
    //   247: aload_1
    //   248: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   251: aload_0
    //   252: ifnull +7 -> 259
    //   255: aload_0
    //   256: invokevirtual 443	java/io/OutputStream:close	()V
    //   259: return
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 443	java/io/OutputStream:close	()V
    //   268: goto +5 -> 273
    //   271: aload_0
    //   272: athrow
    //   273: goto -2 -> 271
    //   276: astore_0
    //   277: return
    //   278: astore_1
    //   279: goto -11 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramSet	Set<String>
    //   0	282	1	paramMap	Map<String, String>
    //   13	234	2	localObject1	Object
    //   11	254	3	localObject2	Object
    //   8	235	4	localStringBuilder	StringBuilder
    //   24	35	5	localIvParameterSpec	IvParameterSpec
    //   40	17	6	localSecretKeySpec	SecretKeySpec
    //   49	31	7	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   85	97	225	finally
    //   97	131	225	finally
    //   134	217	225	finally
    //   85	97	229	java/lang/Exception
    //   97	131	229	java/lang/Exception
    //   134	217	229	java/lang/Exception
    //   14	26	235	finally
    //   28	42	235	finally
    //   44	51	235	finally
    //   53	63	235	finally
    //   65	85	235	finally
    //   247	251	235	finally
    //   14	26	241	java/lang/Exception
    //   28	42	241	java/lang/Exception
    //   44	51	241	java/lang/Exception
    //   53	63	241	java/lang/Exception
    //   65	85	241	java/lang/Exception
    //   220	224	276	java/io/IOException
    //   255	259	276	java/io/IOException
    //   264	268	278	java/io/IOException
  }
  
  private static boolean a()
  {
    File localFile = new File(d());
    return (SystemUtil.a()) && (!localFile.exists());
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("A");
    localStringBuilder.append(a(15));
    return localStringBuilder.toString();
  }
  
  private static String b(Map<String, String> paramMap, String paramString)
  {
    if (paramString.equals("wfm"))
    {
      paramMap = QPMiscUtils.b(2);
    }
    else if (paramString.equals("mc"))
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
      paramString.append(DeviceInfoUtil.f());
      paramString.append((String)paramMap.get("md"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append((String)paramMap.get("mc"));
      paramString.append(localStringBuilder.toString());
      paramMap = new StringBuilder();
      paramMap.append("A");
      paramMap.append(MD5FileUtil.b(paramString.toString()).substring(0, 15));
      paramMap = paramMap.toString();
    }
    else if (paramString.equals("sno"))
    {
      paramMap = QQDeviceInfo.getSerial(BaseActivity.sTopActivity);
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
      paramMap = Long.toString(DeviceInfoUtil.a());
    }
    else if (paramString.equals("ts"))
    {
      paramMap = Long.toString(DeviceInfoUtil.b()[0]);
    }
    else if (paramString.equals("rs"))
    {
      paramMap = DeviceInfoUtil.l();
    }
    else if (paramString.equals("hw"))
    {
      paramMap = Build.HARDWARE;
    }
    else if (paramString.equals("dv"))
    {
      paramMap = Build.DEVICE;
    }
    else if (paramString.equals("rc"))
    {
      paramMap = a(16);
    }
    else if (paramString.equals("rc2"))
    {
      paramMap = a(16);
    }
    else
    {
      paramMap = null;
    }
    paramString = paramMap;
    if (paramMap == null) {
      paramString = "";
    }
    return paramString;
  }
  
  private static Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    InputStream localInputStream = a();
    if (localInputStream == null) {
      return localHashMap;
    }
    a(a(localInputStream, new GGMM.2()), localHashMap);
    if (localInputStream != null) {
      try
      {
        localInputStream.close();
        return localHashMap;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
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
  
  private static void b(Set<String> paramSet, Map<String, String> paramMap)
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
  
  private static Map<String, String> c()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("dfp", 0);
    HashMap localHashMap = new HashMap();
    if (localSharedPreferences != null) {
      try
      {
        a(localSharedPreferences.getAll(), localHashMap);
        return localHashMap;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return localHashMap;
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Tencent/MobileQQ/kf2.dat");
    return localStringBuilder.toString();
  }
  
  private static String e()
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      if (localObject == null) {}
    }
    try
    {
      long l = Long.parseLong((String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(DeviceInfoUtil.c());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Long.toString(l ^ 0xADCD123));
      localObject = Base64.encodeToString(((StringBuilder)localObject).toString().getBytes(), 2);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.GGMM
 * JD-Core Version:    0.7.0.1
 */