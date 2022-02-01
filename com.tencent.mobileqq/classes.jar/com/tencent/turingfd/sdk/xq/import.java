package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class import
{
  public static Map<String, Set<String>> Bf = new HashMap();
  public static Map<String, Integer> Cf = new HashMap();
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("18C867F0717AA67B2AB7347505BA07ED");
    Bf.put(const.get(const.oe), localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("31223B0BDF1DEF1FE8252971ADA3B577");
    localHashSet.add("CCD4AD38DC6669F875BC37E3F8840648");
    localHashSet.add("AA3978F41FD96FF9914A669E186474C7");
    localHashSet.add("775E696D09856872FDD8AB4F3F06B1E0");
    localHashSet.add("A6B745BF24A2C277527716F6F36EB68D");
    localHashSet.add("A01EECAB85E9E3BA2B0F6A158C855C29");
    Bf.put(const.get(const.pe), localHashSet);
    Cf.put(const.get(const.oe), Integer.valueOf(105118));
    Cf.put(const.get(const.pe), Integer.valueOf(105178));
  }
  
  /* Error */
  public static java.util.ArrayList<Ara> i(android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 77	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 78	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 84	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore_3
    //   13: aload_3
    //   14: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: aload_2
    //   21: areturn
    //   22: aload_0
    //   23: invokevirtual 94	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   26: astore_1
    //   27: new 96	java/io/ByteArrayInputStream
    //   30: dup
    //   31: aload_1
    //   32: aload_1
    //   33: aload_0
    //   34: invokevirtual 94	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   37: aload_3
    //   38: iconst_0
    //   39: invokevirtual 102	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   42: getfield 108	android/content/pm/ApplicationInfo:uid	I
    //   45: invokevirtual 112	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   48: iconst_0
    //   49: aaload
    //   50: bipush 64
    //   52: invokevirtual 116	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   55: getfield 122	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   58: iconst_0
    //   59: aaload
    //   60: invokevirtual 128	android/content/pm/Signature:toByteArray	()[B
    //   63: invokespecial 131	java/io/ByteArrayInputStream:<init>	([B)V
    //   66: astore_0
    //   67: ldc 133
    //   69: invokestatic 139	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   72: aload_0
    //   73: invokevirtual 143	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   76: checkcast 145	java/security/cert/X509Certificate
    //   79: invokevirtual 148	java/security/cert/X509Certificate:getEncoded	()[B
    //   82: invokestatic 154	com/tencent/turingfd/sdk/xq/this:e	([B)Ljava/lang/String;
    //   85: astore_1
    //   86: aload_0
    //   87: invokevirtual 157	java/io/ByteArrayInputStream:close	()V
    //   90: new 159	com/tencent/turingfd/sdk/xq/Ara
    //   93: dup
    //   94: invokespecial 160	com/tencent/turingfd/sdk/xq/Ara:<init>	()V
    //   97: astore_0
    //   98: aload_0
    //   99: new 162	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   106: getstatic 169	com/tencent/turingfd/sdk/xq/short:lf	Ljava/lang/String;
    //   109: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 176	com/tencent/turingfd/sdk/xq/short:mf	Ljava/lang/String;
    //   115: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: putfield 182	com/tencent/turingfd/sdk/xq/Ara:A	Ljava/lang/String;
    //   124: aload_0
    //   125: new 162	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   132: aload_3
    //   133: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 184
    //   138: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: putfield 187	com/tencent/turingfd/sdk/xq/Ara:B	Ljava/lang/String;
    //   151: aload_2
    //   152: aload_0
    //   153: invokevirtual 188	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   156: pop
    //   157: aload_2
    //   158: areturn
    //   159: astore_1
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 157	java/io/ByteArrayInputStream:close	()V
    //   168: ldc 190
    //   170: astore_1
    //   171: goto -81 -> 90
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: ifnull +7 -> 185
    //   181: aload_0
    //   182: invokevirtual 157	java/io/ByteArrayInputStream:close	()V
    //   185: aload_1
    //   186: athrow
    //   187: astore_0
    //   188: aconst_null
    //   189: astore_0
    //   190: goto -30 -> 160
    //   193: astore_0
    //   194: goto -104 -> 90
    //   197: astore_0
    //   198: goto -13 -> 185
    //   201: astore_0
    //   202: goto -34 -> 168
    //   205: astore_1
    //   206: goto -29 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramContext	android.content.Context
    //   26	116	1	localObject1	Object
    //   159	1	1	localThrowable	java.lang.Throwable
    //   170	1	1	str1	String
    //   174	12	1	localObject2	Object
    //   205	1	1	localObject3	Object
    //   7	151	2	localArrayList	java.util.ArrayList
    //   12	121	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   67	86	159	java/lang/Throwable
    //   22	67	174	finally
    //   22	67	187	java/lang/Throwable
    //   86	90	193	java/lang/Throwable
    //   181	185	197	java/lang/Throwable
    //   164	168	201	java/lang/Throwable
    //   67	86	205	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.import
 * JD-Core Version:    0.7.0.1
 */