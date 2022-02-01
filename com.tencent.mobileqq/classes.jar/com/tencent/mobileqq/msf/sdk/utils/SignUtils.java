package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec.Builder;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.Signature;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.security.auth.x500.X500Principal;

public class SignUtils
{
  public static final String KEYSTORE_PROVIDER_ANDROID_KEYSTORE = "AndroidKeyStore";
  public static final String SIGNATURE_SHA256withRSA = "SHA256withRSA";
  public static final String TAG = "SignUtils";
  public static final String TYPE_RSA = "RSA";
  
  private static void createKeys(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.add(1, 3);
    KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
    Object localObject = null;
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = new KeyGenParameterSpec.Builder(paramString, 4);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CN=");
      ((StringBuilder)localObject).append(paramString);
      localObject = paramContext.setCertificateSubject(new X500Principal(((StringBuilder)localObject).toString())).setDigests(new String[] { "SHA-256" }).setSignaturePaddings(new String[] { "PKCS1" }).setCertificateSerialNumber(BigInteger.valueOf(1337L)).setCertificateNotBefore(localGregorianCalendar1.getTime()).setCertificateNotAfter(localGregorianCalendar2.getTime()).build();
    }
    else if (Build.VERSION.SDK_INT >= 18)
    {
      paramContext = new KeyPairGeneratorSpec.Builder(paramContext).setAlias(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CN=");
      ((StringBuilder)localObject).append(paramString);
      localObject = paramContext.setSubject(new X500Principal(((StringBuilder)localObject).toString())).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(localGregorianCalendar1.getTime()).setEndDate(localGregorianCalendar2.getTime()).build();
    }
    if (localObject != null)
    {
      localKeyPairGenerator.initialize((AlgorithmParameterSpec)localObject);
      localKeyPairGenerator.generateKeyPair();
    }
  }
  
  public static boolean isSupportKeyStore()
  {
    boolean bool = false;
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
      Signature.getInstance("SHA256withRSA");
      KeyStore.Entry localEntry2 = localKeyStore.getEntry("test", null);
      KeyStore.Entry localEntry1 = localEntry2;
      if (localEntry2 == null)
      {
        createKeys(BaseApplication.getContext(), "test");
        localEntry1 = localKeyStore.getEntry("test", null);
      }
      if (localEntry1 != null) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  /* Error */
  public static String readFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 194	java/io/File:exists	()Z
    //   13: ifeq +278 -> 291
    //   16: aload_0
    //   17: invokevirtual 197	java/io/File:isFile	()Z
    //   20: ifne +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: new 199	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_2
    //   34: new 204	java/io/InputStreamReader
    //   37: dup
    //   38: aload_2
    //   39: ldc 206
    //   41: invokespecial 209	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   44: astore_3
    //   45: aload_2
    //   46: astore 4
    //   48: aload_3
    //   49: astore 5
    //   51: aload_0
    //   52: invokevirtual 213	java/io/File:length	()J
    //   55: l2i
    //   56: istore_1
    //   57: iload_1
    //   58: sipush 12288
    //   61: if_icmple +83 -> 144
    //   64: aload_2
    //   65: astore 4
    //   67: aload_3
    //   68: astore 5
    //   70: sipush 4096
    //   73: newarray char
    //   75: astore_0
    //   76: aload_2
    //   77: astore 4
    //   79: aload_3
    //   80: astore 5
    //   82: new 58	java/lang/StringBuilder
    //   85: dup
    //   86: sipush 12288
    //   89: invokespecial 216	java/lang/StringBuilder:<init>	(I)V
    //   92: astore 7
    //   94: aload_2
    //   95: astore 4
    //   97: aload_3
    //   98: astore 5
    //   100: aload_3
    //   101: aload_0
    //   102: invokevirtual 220	java/io/InputStreamReader:read	([C)I
    //   105: istore_1
    //   106: iconst_m1
    //   107: iload_1
    //   108: if_icmpeq +21 -> 129
    //   111: aload_2
    //   112: astore 4
    //   114: aload_3
    //   115: astore 5
    //   117: aload 7
    //   119: aload_0
    //   120: iconst_0
    //   121: iload_1
    //   122: invokevirtual 223	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: goto -32 -> 94
    //   129: aload_2
    //   130: astore 4
    //   132: aload_3
    //   133: astore 5
    //   135: aload 7
    //   137: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore_0
    //   141: goto +34 -> 175
    //   144: aload_2
    //   145: astore 4
    //   147: aload_3
    //   148: astore 5
    //   150: iload_1
    //   151: newarray char
    //   153: astore_0
    //   154: aload_2
    //   155: astore 4
    //   157: aload_3
    //   158: astore 5
    //   160: new 80	java/lang/String
    //   163: dup
    //   164: aload_0
    //   165: iconst_0
    //   166: aload_3
    //   167: aload_0
    //   168: invokevirtual 220	java/io/InputStreamReader:read	([C)I
    //   171: invokespecial 226	java/lang/String:<init>	([CII)V
    //   174: astore_0
    //   175: aload_2
    //   176: invokevirtual 231	java/io/InputStream:close	()V
    //   179: aload_0
    //   180: astore_2
    //   181: aload_3
    //   182: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   185: aload_2
    //   186: areturn
    //   187: astore 4
    //   189: aload_3
    //   190: astore_0
    //   191: aload 4
    //   193: astore_3
    //   194: goto +30 -> 224
    //   197: astore_0
    //   198: aconst_null
    //   199: astore 5
    //   201: goto +67 -> 268
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_0
    //   207: goto +17 -> 224
    //   210: astore_0
    //   211: aconst_null
    //   212: astore_2
    //   213: aload_2
    //   214: astore 5
    //   216: goto +52 -> 268
    //   219: astore_3
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: astore_0
    //   224: aload_2
    //   225: astore 4
    //   227: aload_0
    //   228: astore 5
    //   230: ldc 14
    //   232: iconst_1
    //   233: ldc 234
    //   235: aload_3
    //   236: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: aload_2
    //   240: ifnull +10 -> 250
    //   243: aload_2
    //   244: invokevirtual 231	java/io/InputStream:close	()V
    //   247: goto +3 -> 250
    //   250: aload_0
    //   251: ifnull +11 -> 262
    //   254: aload 6
    //   256: astore_2
    //   257: aload_0
    //   258: astore_3
    //   259: goto -78 -> 181
    //   262: aconst_null
    //   263: areturn
    //   264: astore_0
    //   265: aload 4
    //   267: astore_2
    //   268: aload_2
    //   269: ifnull +10 -> 279
    //   272: aload_2
    //   273: invokevirtual 231	java/io/InputStream:close	()V
    //   276: goto +3 -> 279
    //   279: aload 5
    //   281: ifnull +8 -> 289
    //   284: aload 5
    //   286: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   289: aload_0
    //   290: athrow
    //   291: aconst_null
    //   292: areturn
    //   293: astore_2
    //   294: aload_0
    //   295: astore_2
    //   296: goto -115 -> 181
    //   299: astore_0
    //   300: aload_2
    //   301: areturn
    //   302: astore_2
    //   303: goto -53 -> 250
    //   306: astore_2
    //   307: goto -28 -> 279
    //   310: astore_2
    //   311: goto -22 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramFile	java.io.File
    //   56	95	1	i	int
    //   33	240	2	localObject1	Object
    //   293	1	2	localException1	java.lang.Exception
    //   295	6	2	localFile1	java.io.File
    //   302	1	2	localException2	java.lang.Exception
    //   306	1	2	localException3	java.lang.Exception
    //   310	1	2	localException4	java.lang.Exception
    //   44	150	3	localObject2	Object
    //   204	1	3	localException5	java.lang.Exception
    //   219	17	3	localException6	java.lang.Exception
    //   258	1	3	localFile2	java.io.File
    //   46	110	4	localObject3	Object
    //   187	5	4	localException7	java.lang.Exception
    //   225	41	4	localObject4	Object
    //   49	236	5	localObject5	Object
    //   1	254	6	localObject6	Object
    //   92	44	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	57	187	java/lang/Exception
    //   70	76	187	java/lang/Exception
    //   82	94	187	java/lang/Exception
    //   100	106	187	java/lang/Exception
    //   117	126	187	java/lang/Exception
    //   135	141	187	java/lang/Exception
    //   150	154	187	java/lang/Exception
    //   160	175	187	java/lang/Exception
    //   34	45	197	finally
    //   34	45	204	java/lang/Exception
    //   25	34	210	finally
    //   25	34	219	java/lang/Exception
    //   51	57	264	finally
    //   70	76	264	finally
    //   82	94	264	finally
    //   100	106	264	finally
    //   117	126	264	finally
    //   135	141	264	finally
    //   150	154	264	finally
    //   160	175	264	finally
    //   230	239	264	finally
    //   175	179	293	java/lang/Exception
    //   181	185	299	java/lang/Exception
    //   243	247	302	java/lang/Exception
    //   272	276	306	java/lang/Exception
    //   284	289	310	java/lang/Exception
  }
  
  public static String signData(Context paramContext, String paramString1, String paramString2)
  {
    byte[] arrayOfByte = paramString1.getBytes();
    KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
    localKeyStore.load(null);
    KeyStore.Entry localEntry = localKeyStore.getEntry(paramString2, null);
    paramString1 = localEntry;
    if (localEntry == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("create new key for:");
        paramString1.append(paramString2);
        QLog.i("SignUtils", 2, paramString1.toString());
      }
      createKeys(paramContext, paramString2);
      paramString1 = localKeyStore.getEntry(paramString2, null);
    }
    if (paramString1 == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("null entry:");
      paramContext.append(paramString2);
      QLog.e("SignUtils", 1, paramContext.toString());
      return null;
    }
    if (!(paramString1 instanceof KeyStore.PrivateKeyEntry))
    {
      paramContext = new StringBuilder();
      paramContext.append("Not an instance of a PrivateKeyEntry:");
      paramContext.append(paramString2);
      QLog.e("SignUtils", 1, paramContext.toString());
      return null;
    }
    paramContext = Signature.getInstance("SHA256withRSA");
    paramContext.initSign(((KeyStore.PrivateKeyEntry)paramString1).getPrivateKey());
    paramContext.update(arrayOfByte);
    return Base64.encodeToString(paramContext.sign(), 0);
  }
  
  public static boolean verifyData(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = paramString1.getBytes();
    if (paramString2 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("Invalid signature:");
      paramString1.append(paramString3);
      QLog.e("SignUtils", 1, paramString1.toString());
      return false;
    }
    try
    {
      paramString2 = Base64.decode(paramString2, 0);
      Object localObject = KeyStore.getInstance("AndroidKeyStore");
      ((KeyStore)localObject).load(null);
      localObject = ((KeyStore)localObject).getEntry(paramString3, null);
      if (localObject == null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("No key found under alias:");
        paramString1.append(paramString3);
        QLog.e("SignUtils", 1, paramString1.toString());
        return false;
      }
      if (!(localObject instanceof KeyStore.PrivateKeyEntry))
      {
        paramString1 = new StringBuilder();
        paramString1.append("Not an instance of a PrivateKeyEntry:");
        paramString1.append(paramString3);
        QLog.e("SignUtils", 1, paramString1.toString());
        return false;
      }
      paramString3 = Signature.getInstance("SHA256withRSA");
      paramString3.initVerify(((KeyStore.PrivateKeyEntry)localObject).getCertificate());
      paramString3.update(paramString1);
      return paramString3.verify(paramString2);
    }
    catch (IllegalArgumentException paramString1)
    {
      QLog.e("SignUtils", 1, "decode signature error:", paramString1);
    }
    return false;
  }
  
  /* Error */
  public static void writeFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 191	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_2
    //   15: astore_0
    //   16: aload 4
    //   18: invokevirtual 194	java/io/File:exists	()Z
    //   21: ifne +11 -> 32
    //   24: aload_2
    //   25: astore_0
    //   26: aload 4
    //   28: invokevirtual 316	java/io/File:createNewFile	()Z
    //   31: pop
    //   32: aload_2
    //   33: astore_0
    //   34: new 318	java/io/FileOutputStream
    //   37: dup
    //   38: aload 4
    //   40: iconst_0
    //   41: invokespecial 321	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   44: astore_2
    //   45: aload_2
    //   46: aload_1
    //   47: invokevirtual 246	java/lang/String:getBytes	()[B
    //   50: invokevirtual 324	java/io/FileOutputStream:write	([B)V
    //   53: aload_2
    //   54: invokevirtual 327	java/io/FileOutputStream:flush	()V
    //   57: aload_2
    //   58: invokevirtual 328	java/io/FileOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: aload_2
    //   64: astore_0
    //   65: goto +39 -> 104
    //   68: astore_0
    //   69: aload_2
    //   70: astore_1
    //   71: aload_0
    //   72: astore_2
    //   73: goto +10 -> 83
    //   76: astore_1
    //   77: goto +27 -> 104
    //   80: astore_2
    //   81: aload_3
    //   82: astore_1
    //   83: aload_1
    //   84: astore_0
    //   85: ldc 14
    //   87: iconst_1
    //   88: ldc_w 330
    //   91: aload_2
    //   92: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 328	java/io/FileOutputStream:close	()V
    //   103: return
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 328	java/io/FileOutputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: return
    //   116: astore_0
    //   117: goto -5 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString1	String
    //   0	120	1	paramString2	String
    //   13	60	2	localObject1	Object
    //   80	12	2	localException	java.lang.Exception
    //   11	71	3	localObject2	Object
    //   8	31	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   45	57	62	finally
    //   45	57	68	java/lang/Exception
    //   16	24	76	finally
    //   26	32	76	finally
    //   34	45	76	finally
    //   85	95	76	finally
    //   16	24	80	java/lang/Exception
    //   26	32	80	java/lang/Exception
    //   34	45	80	java/lang/Exception
    //   57	61	114	java/lang/Exception
    //   99	103	114	java/lang/Exception
    //   108	112	116	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.SignUtils
 * JD-Core Version:    0.7.0.1
 */