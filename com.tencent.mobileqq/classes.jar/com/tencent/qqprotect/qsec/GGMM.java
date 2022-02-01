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
  private static final String[] a = { "mc", "md", "mg", "wfm", "sno", "fg", "brd", "hw", "dv", "tm", "ts", "rs", "rc", "rc2" };
  private static final Set<String> b = new HashSet();
  private static final byte[] c = { 74, 39, 2, -61, -88, -75, -36, 105, -102, 39, 2, 69, -72, -11, -84, 50 };
  private static final byte[] d = { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, -61, -88, -75, -68, 105 };
  
  static
  {
    b.add("mg");
    b.add("wfm");
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
    //   0: new 163	java/util/HashMap
    //   3: dup
    //   4: invokespecial 164	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: new 166	java/io/BufferedReader
    //   16: dup
    //   17: new 168	java/io/InputStreamReader
    //   20: dup
    //   21: aload_0
    //   22: ldc 170
    //   24: invokespecial 173	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   27: invokespecial 176	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 179	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +32 -> 69
    //   40: aload_1
    //   41: aload_2
    //   42: invokeinterface 184 2 0
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull -18 -> 31
    //   52: aload 4
    //   54: aload_2
    //   55: getfield 190	android/util/Pair:first	Ljava/lang/Object;
    //   58: aload_2
    //   59: getfield 193	android/util/Pair:second	Ljava/lang/Object;
    //   62: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: goto -35 -> 31
    //   69: aload_0
    //   70: invokevirtual 200	java/io/BufferedReader:close	()V
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
    //   98: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   101: aload_0
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: invokevirtual 200	java/io/BufferedReader:close	()V
    //   109: aload 4
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   117: aload 4
    //   119: areturn
    //   120: aload_2
    //   121: ifnull +15 -> 136
    //   124: aload_2
    //   125: invokevirtual 200	java/io/BufferedReader:close	()V
    //   128: goto +8 -> 136
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 134	java/lang/Exception:printStackTrace	()V
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
    Map localMap = i();
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
      if (b.contains(str))
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
            localObject2 = h();
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
                localObject1 = d();
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
    if ((m > 0) || (j()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "update to sdcard.");
      }
      a(localHashSet, localHashMap);
    }
    return localHashMap;
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
    //   0: invokestatic 282	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: new 284	javax/crypto/spec/IvParameterSpec
    //   17: dup
    //   18: getstatic 74	com/tencent/qqprotect/qsec/GGMM:d	[B
    //   21: invokespecial 285	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   24: astore 5
    //   26: aload_3
    //   27: astore_2
    //   28: new 287	javax/crypto/spec/SecretKeySpec
    //   31: dup
    //   32: getstatic 69	com/tencent/qqprotect/qsec/GGMM:c	[B
    //   35: ldc_w 289
    //   38: invokespecial 292	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   41: astore 6
    //   43: aload_3
    //   44: astore_2
    //   45: ldc_w 294
    //   48: invokestatic 300	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   51: astore 7
    //   53: aload_3
    //   54: astore_2
    //   55: aload 7
    //   57: iconst_1
    //   58: aload 6
    //   60: aload 5
    //   62: invokevirtual 304	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   65: aload_3
    //   66: astore_2
    //   67: new 306	javax/crypto/CipherOutputStream
    //   70: dup
    //   71: new 308	java/io/FileOutputStream
    //   74: dup
    //   75: invokestatic 311	com/tencent/qqprotect/qsec/GGMM:f	()Ljava/lang/String;
    //   78: invokespecial 312	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   81: aload 7
    //   83: invokespecial 315	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   86: astore_3
    //   87: aload_1
    //   88: invokeinterface 254 1 0
    //   93: invokeinterface 258 1 0
    //   98: astore_1
    //   99: aload_1
    //   100: invokeinterface 263 1 0
    //   105: ifeq +117 -> 222
    //   108: aload_1
    //   109: invokeinterface 267 1 0
    //   114: checkcast 269	java/util/Map$Entry
    //   117: astore_2
    //   118: aload_0
    //   119: aload_2
    //   120: invokeinterface 272 1 0
    //   125: invokeinterface 208 2 0
    //   130: ifeq +6 -> 136
    //   133: goto -34 -> 99
    //   136: new 87	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   143: astore 4
    //   145: aload 4
    //   147: aload_2
    //   148: invokeinterface 272 1 0
    //   153: checkcast 16	java/lang/String
    //   156: invokevirtual 122	java/lang/String:getBytes	()[B
    //   159: iconst_2
    //   160: invokestatic 319	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   163: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 4
    //   169: ldc_w 324
    //   172: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: aload_2
    //   179: invokeinterface 277 1 0
    //   184: checkcast 16	java/lang/String
    //   187: invokevirtual 122	java/lang/String:getBytes	()[B
    //   190: iconst_2
    //   191: invokestatic 319	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   194: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: ldc_w 326
    //   203: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_3
    //   208: aload 4
    //   210: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokevirtual 122	java/lang/String:getBytes	()[B
    //   216: invokevirtual 331	java/io/OutputStream:write	([B)V
    //   219: goto -120 -> 99
    //   222: aload_3
    //   223: invokevirtual 332	java/io/OutputStream:close	()V
    //   226: return
    //   227: astore_0
    //   228: goto +34 -> 262
    //   231: astore_1
    //   232: aload_3
    //   233: astore_0
    //   234: goto +13 -> 247
    //   237: astore_0
    //   238: aload_2
    //   239: astore_3
    //   240: goto +22 -> 262
    //   243: astore_1
    //   244: aload 4
    //   246: astore_0
    //   247: aload_0
    //   248: astore_2
    //   249: aload_1
    //   250: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   253: aload_0
    //   254: ifnull +7 -> 261
    //   257: aload_0
    //   258: invokevirtual 332	java/io/OutputStream:close	()V
    //   261: return
    //   262: aload_3
    //   263: ifnull +7 -> 270
    //   266: aload_3
    //   267: invokevirtual 332	java/io/OutputStream:close	()V
    //   270: goto +5 -> 275
    //   273: aload_0
    //   274: athrow
    //   275: goto -2 -> 273
    //   278: astore_0
    //   279: return
    //   280: astore_1
    //   281: goto -11 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramSet	Set<String>
    //   0	284	1	paramMap	Map<String, String>
    //   13	236	2	localObject1	Object
    //   11	256	3	localObject2	Object
    //   8	237	4	localStringBuilder	StringBuilder
    //   24	37	5	localIvParameterSpec	IvParameterSpec
    //   41	18	6	localSecretKeySpec	SecretKeySpec
    //   51	31	7	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   87	99	227	finally
    //   99	133	227	finally
    //   136	219	227	finally
    //   87	99	231	java/lang/Exception
    //   99	133	231	java/lang/Exception
    //   136	219	231	java/lang/Exception
    //   14	26	237	finally
    //   28	43	237	finally
    //   45	53	237	finally
    //   55	65	237	finally
    //   67	87	237	finally
    //   249	253	237	finally
    //   14	26	243	java/lang/Exception
    //   28	43	243	java/lang/Exception
    //   45	53	243	java/lang/Exception
    //   55	65	243	java/lang/Exception
    //   67	87	243	java/lang/Exception
    //   222	226	278	java/io/IOException
    //   257	261	278	java/io/IOException
    //   266	270	280	java/io/IOException
  }
  
  private static String b(Map<String, String> paramMap, String paramString)
  {
    if (paramString.equals("wfm"))
    {
      paramMap = QPMiscUtils.c(2);
    }
    else if (paramString.equals("mc"))
    {
      paramMap = e();
    }
    else if (paramString.equals("md"))
    {
      paramMap = c();
    }
    else if (paramString.equals("mg"))
    {
      paramString = new StringBuilder();
      paramString.append(DeviceInfoUtil.j());
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
      paramMap = Long.toString(DeviceInfoUtil.q()[0]);
    }
    else if (paramString.equals("rs"))
    {
      paramMap = DeviceInfoUtil.x();
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
  
  public static void b()
  {
    if (!QSecFramework.c().a(1002).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "door closed.");
      }
      return;
    }
    Object localObject2 = BaseApplication.getContext().getSharedPreferences("di_time", 0);
    if (localObject2 != null)
    {
      Object localObject1 = l();
      if (localObject1 == null) {
        return;
      }
      long l2 = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
      long l3 = new Date().getTime();
      long l1 = 604800000L;
      if (l3 - l2 > 604800000L)
      {
        k();
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
    String str = QPMiscUtils.c(1);
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
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("A");
    localStringBuilder.append(a(15));
    return localStringBuilder.toString();
  }
  
  private static String e()
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
  
  private static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Tencent/MobileQQ/kf2.dat");
    return localStringBuilder.toString();
  }
  
  private static InputStream g()
  {
    if (!SystemUtil.a()) {
      return null;
    }
    Object localObject = new File(f());
    if (!((File)localObject).exists()) {
      return null;
    }
    if (((File)localObject).length() > 102400L) {
      return null;
    }
    try
    {
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(d);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(c, "AES");
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
  
  private static Map<String, String> h()
  {
    HashMap localHashMap = new HashMap();
    InputStream localInputStream = g();
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
  
  private static Map<String, String> i()
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
  
  private static boolean j()
  {
    File localFile = new File(f());
    return (SystemUtil.a()) && (!localFile.exists());
  }
  
  private static void k()
  {
    Map localMap = a(a);
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = a;
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
  
  private static String l()
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
      ((StringBuilder)localObject).append(DeviceInfoUtil.e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.GGMM
 * JD-Core Version:    0.7.0.1
 */