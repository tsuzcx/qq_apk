package com.tencent.tfd.sdk.wxa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class import
{
  public static Map<String, Set<String>> ic = new HashMap();
  public static Map<String, Integer> jc = new HashMap();
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("18C867F0717AA67B2AB7347505BA07ED");
    ic.put(const.get(const.Xa), localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("31223B0BDF1DEF1FE8252971ADA3B577");
    localHashSet.add("CCD4AD38DC6669F875BC37E3F8840648");
    localHashSet.add("AA3978F41FD96FF9914A669E186474C7");
    localHashSet.add("775E696D09856872FDD8AB4F3F06B1E0");
    localHashSet.add("A6B745BF24A2C277527716F6F36EB68D");
    localHashSet.add("A01EECAB85E9E3BA2B0F6A158C855C29");
    ic.put(const.get(const.Ya), localHashSet);
    jc.put(const.get(const.Xa), Integer.valueOf(105118));
    jc.put(const.get(const.Ya), Integer.valueOf(105178));
  }
  
  /* Error */
  public static java.util.ArrayList<strictfp> n(android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 77	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 78	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 84	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore 4
    //   14: aload 4
    //   16: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +5 -> 24
    //   22: aload_3
    //   23: areturn
    //   24: aconst_null
    //   25: astore_2
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: invokevirtual 94	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   32: astore 5
    //   34: new 96	java/io/ByteArrayInputStream
    //   37: dup
    //   38: aload 5
    //   40: aload 5
    //   42: aload_0
    //   43: invokevirtual 94	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   46: aload 4
    //   48: iconst_0
    //   49: invokevirtual 102	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   52: getfield 108	android/content/pm/ApplicationInfo:uid	I
    //   55: invokevirtual 112	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   58: iconst_0
    //   59: aaload
    //   60: bipush 64
    //   62: invokevirtual 116	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   65: getfield 122	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   68: iconst_0
    //   69: aaload
    //   70: invokevirtual 128	android/content/pm/Signature:toByteArray	()[B
    //   73: invokespecial 131	java/io/ByteArrayInputStream:<init>	([B)V
    //   76: astore_0
    //   77: ldc 133
    //   79: invokestatic 139	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   82: aload_0
    //   83: invokevirtual 143	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   86: checkcast 145	java/security/cert/X509Certificate
    //   89: invokevirtual 148	java/security/cert/X509Certificate:getEncoded	()[B
    //   92: invokestatic 154	com/tencent/tfd/sdk/wxa/void:c	([B)Ljava/lang/String;
    //   95: astore_1
    //   96: aload_0
    //   97: invokevirtual 157	java/io/ByteArrayInputStream:close	()V
    //   100: aload_1
    //   101: astore_0
    //   102: goto +36 -> 138
    //   105: astore_2
    //   106: aload_0
    //   107: astore_1
    //   108: aload_2
    //   109: astore_0
    //   110: goto +7 -> 117
    //   113: goto +14 -> 127
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 157	java/io/ByteArrayInputStream:close	()V
    //   125: aload_0
    //   126: athrow
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 157	java/io/ByteArrayInputStream:close	()V
    //   135: ldc 159
    //   137: astore_0
    //   138: new 161	com/tencent/tfd/sdk/wxa/strictfp
    //   141: dup
    //   142: invokespecial 162	com/tencent/tfd/sdk/wxa/strictfp:<init>	()V
    //   145: astore_1
    //   146: new 164	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   153: astore_2
    //   154: aload_2
    //   155: getstatic 171	com/tencent/tfd/sdk/wxa/short:Tb	Ljava/lang/String;
    //   158: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_2
    //   163: getstatic 178	com/tencent/tfd/sdk/wxa/short:Ub	Ljava/lang/String;
    //   166: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: aload_2
    //   172: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: putfield 184	com/tencent/tfd/sdk/wxa/strictfp:l	Ljava/lang/String;
    //   178: new 164	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   185: astore_2
    //   186: aload_2
    //   187: aload 4
    //   189: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: ldc 186
    //   196: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: aload_0
    //   202: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: aload_2
    //   208: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: putfield 189	com/tencent/tfd/sdk/wxa/strictfp:m	Ljava/lang/String;
    //   214: aload_3
    //   215: aload_1
    //   216: invokevirtual 190	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   219: pop
    //   220: aload_3
    //   221: areturn
    //   222: astore_0
    //   223: aload_2
    //   224: astore_0
    //   225: goto -98 -> 127
    //   228: astore_1
    //   229: goto -116 -> 113
    //   232: astore_0
    //   233: aload_1
    //   234: astore_0
    //   235: goto -97 -> 138
    //   238: astore_1
    //   239: goto -114 -> 125
    //   242: astore_0
    //   243: goto -108 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	android.content.Context
    //   27	189	1	localObject1	Object
    //   228	6	1	localThrowable1	java.lang.Throwable
    //   238	1	1	localThrowable2	java.lang.Throwable
    //   25	1	2	localObject2	Object
    //   105	4	2	localObject3	Object
    //   153	71	2	localStringBuilder	java.lang.StringBuilder
    //   7	214	3	localArrayList	java.util.ArrayList
    //   12	176	4	str	String
    //   32	9	5	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   77	96	105	finally
    //   28	77	116	finally
    //   28	77	222	java/lang/Throwable
    //   77	96	228	java/lang/Throwable
    //   96	100	232	java/lang/Throwable
    //   121	125	238	java/lang/Throwable
    //   131	135	242	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.import
 * JD-Core Version:    0.7.0.1
 */