package com.tencent.mobileqq.jumplightalk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AIOJumpLightalkConfig
{
  private static AIOJumpLightalkConfig a;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + File.separator + "aio_jump_lightalk_config";
  public String c;
  public String d;
  public String e;
  public String f;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "jumplightalkfiles";
  }
  
  /* Error */
  public static AIOJumpLightalkConfig a(String paramString)
  {
    // Byte code:
    //   0: new 37	java/io/File
    //   3: dup
    //   4: new 16	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 55	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:b	Ljava/lang/String;
    //   14: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: getstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   31: ifnull +37 -> 68
    //   34: aload_0
    //   35: invokevirtual 69	java/io/File:exists	()Z
    //   38: ifeq +30 -> 68
    //   41: aload_0
    //   42: invokevirtual 73	java/io/File:length	()J
    //   45: lconst_0
    //   46: lcmp
    //   47: ifle +21 -> 68
    //   50: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +11 -> 64
    //   56: ldc 80
    //   58: iconst_2
    //   59: ldc 82
    //   61: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: getstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   67: areturn
    //   68: aconst_null
    //   69: putstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   72: aload_0
    //   73: invokevirtual 69	java/io/File:exists	()Z
    //   76: ifeq +203 -> 279
    //   79: aload_0
    //   80: invokevirtual 73	java/io/File:length	()J
    //   83: lconst_0
    //   84: lcmp
    //   85: ifle +194 -> 279
    //   88: new 87	java/io/FileInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore_1
    //   97: aload_1
    //   98: astore_0
    //   99: aload_1
    //   100: invokevirtual 94	java/io/FileInputStream:available	()I
    //   103: newarray byte
    //   105: astore_2
    //   106: aload_1
    //   107: astore_0
    //   108: aload_1
    //   109: aload_2
    //   110: invokevirtual 98	java/io/FileInputStream:read	([B)I
    //   113: pop
    //   114: aload_1
    //   115: astore_0
    //   116: new 100	java/lang/String
    //   119: dup
    //   120: aload_2
    //   121: ldc 102
    //   123: invokespecial 105	java/lang/String:<init>	([BLjava/lang/String;)V
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull +76 -> 204
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: ldc 107
    //   136: invokevirtual 111	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   139: astore_2
    //   140: aload_1
    //   141: astore_0
    //   142: aload_2
    //   143: arraylength
    //   144: iconst_4
    //   145: if_icmpne +59 -> 204
    //   148: aload_1
    //   149: astore_0
    //   150: new 2	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig
    //   153: dup
    //   154: invokespecial 112	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:<init>	()V
    //   157: putstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   160: aload_1
    //   161: astore_0
    //   162: getstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   165: aload_2
    //   166: iconst_0
    //   167: aaload
    //   168: putfield 114	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:c	Ljava/lang/String;
    //   171: aload_1
    //   172: astore_0
    //   173: getstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   176: aload_2
    //   177: iconst_1
    //   178: aaload
    //   179: putfield 116	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:d	Ljava/lang/String;
    //   182: aload_1
    //   183: astore_0
    //   184: getstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   187: aload_2
    //   188: iconst_2
    //   189: aaload
    //   190: putfield 118	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:e	Ljava/lang/String;
    //   193: aload_1
    //   194: astore_0
    //   195: getstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   198: aload_2
    //   199: iconst_3
    //   200: aaload
    //   201: putfield 120	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:f	Ljava/lang/String;
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 123	java/io/FileInputStream:close	()V
    //   212: getstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   215: areturn
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   221: goto -9 -> 212
    //   224: astore_2
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: astore_0
    //   229: aload_2
    //   230: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   233: aload_1
    //   234: astore_0
    //   235: aconst_null
    //   236: putstatic 65	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig	Lcom/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig;
    //   239: aload_1
    //   240: ifnull -28 -> 212
    //   243: aload_1
    //   244: invokevirtual 123	java/io/FileInputStream:close	()V
    //   247: goto -35 -> 212
    //   250: astore_0
    //   251: aload_0
    //   252: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   255: goto -43 -> 212
    //   258: astore_1
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 123	java/io/FileInputStream:close	()V
    //   269: aload_1
    //   270: athrow
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   276: goto -7 -> 269
    //   279: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -70 -> 212
    //   285: ldc 80
    //   287: iconst_2
    //   288: ldc 128
    //   290: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto -81 -> 212
    //   296: astore_1
    //   297: goto -36 -> 261
    //   300: astore_2
    //   301: goto -74 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString	String
    //   96	148	1	localFileInputStream	java.io.FileInputStream
    //   258	12	1	localObject1	Object
    //   296	1	1	localObject2	Object
    //   105	94	2	localObject3	Object
    //   224	6	2	localIOException1	java.io.IOException
    //   300	1	2	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   208	212	216	java/io/IOException
    //   88	97	224	java/io/IOException
    //   243	247	250	java/io/IOException
    //   88	97	258	finally
    //   265	269	271	java/io/IOException
    //   99	106	296	finally
    //   108	114	296	finally
    //   116	127	296	finally
    //   133	140	296	finally
    //   142	148	296	finally
    //   150	160	296	finally
    //   162	171	296	finally
    //   173	182	296	finally
    //   184	193	296	finally
    //   195	204	296	finally
    //   229	233	296	finally
    //   235	239	296	finally
    //   99	106	300	java/io/IOException
    //   108	114	300	java/io/IOException
    //   116	127	300	java/io/IOException
    //   133	140	300	java/io/IOException
    //   142	148	300	java/io/IOException
    //   150	160	300	java/io/IOException
    //   162	171	300	java/io/IOException
    //   173	182	300	java/io/IOException
    //   184	193	300	java/io/IOException
    //   195	204	300	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    try
    {
      paramString = new File(b + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig = null;
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AIOJumpLightalkConfig", 2, "delete config error");
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 143	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   4: ifne +17 -> 21
    //   7: aload_1
    //   8: invokestatic 143	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   11: ifne +10 -> 21
    //   14: aload_3
    //   15: invokestatic 143	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   18: ifeq +18 -> 36
    //   21: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 80
    //   29: iconst_2
    //   30: ldc 145
    //   32: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: return
    //   36: new 37	java/io/File
    //   39: dup
    //   40: getstatic 51	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 148	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: new 37	java/io/File
    //   53: dup
    //   54: new 16	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   61: getstatic 55	com/tencent/mobileqq/jumplightalk/AIOJumpLightalkConfig:b	Ljava/lang/String;
    //   64: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 4
    //   69: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 69	java/io/File:exists	()Z
    //   85: ifeq +9 -> 94
    //   88: aload 5
    //   90: invokevirtual 133	java/io/File:delete	()Z
    //   93: pop
    //   94: aconst_null
    //   95: astore 4
    //   97: aload 5
    //   99: invokevirtual 151	java/io/File:createNewFile	()Z
    //   102: pop
    //   103: new 16	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   110: astore 6
    //   112: aload 6
    //   114: aload_0
    //   115: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 6
    //   121: ldc 107
    //   123: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 6
    //   129: aload_1
    //   130: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: ldc 107
    //   138: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 6
    //   144: aload_2
    //   145: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 6
    //   151: ldc 107
    //   153: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 6
    //   159: aload_3
    //   160: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 6
    //   166: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: ldc 102
    //   171: invokevirtual 155	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   174: astore_2
    //   175: new 157	java/io/FileOutputStream
    //   178: dup
    //   179: aload 5
    //   181: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   184: astore_1
    //   185: aload_1
    //   186: astore_0
    //   187: aload_1
    //   188: aload_2
    //   189: invokevirtual 162	java/io/FileOutputStream:write	([B)V
    //   192: aload_1
    //   193: astore_0
    //   194: aload_1
    //   195: invokevirtual 165	java/io/FileOutputStream:flush	()V
    //   198: aload_1
    //   199: ifnull -164 -> 35
    //   202: aload_1
    //   203: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   206: return
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   212: return
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: astore_0
    //   218: aload_2
    //   219: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   222: aload_1
    //   223: ifnull -188 -> 35
    //   226: aload_1
    //   227: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   230: return
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   236: return
    //   237: astore_0
    //   238: aload 4
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   256: goto -7 -> 249
    //   259: astore_2
    //   260: aload_0
    //   261: astore_1
    //   262: aload_2
    //   263: astore_0
    //   264: goto -23 -> 241
    //   267: astore_2
    //   268: goto -52 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramString1	String
    //   0	271	1	paramString2	String
    //   0	271	2	paramString3	String
    //   0	271	3	paramString4	String
    //   0	271	4	paramString5	String
    //   78	102	5	localFile	File
    //   110	55	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   202	206	207	java/io/IOException
    //   97	185	213	java/io/IOException
    //   226	230	231	java/io/IOException
    //   97	185	237	finally
    //   245	249	251	java/io/IOException
    //   187	192	259	finally
    //   194	198	259	finally
    //   218	222	259	finally
    //   187	192	267	java/io/IOException
    //   194	198	267	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig
 * JD-Core Version:    0.7.0.1
 */