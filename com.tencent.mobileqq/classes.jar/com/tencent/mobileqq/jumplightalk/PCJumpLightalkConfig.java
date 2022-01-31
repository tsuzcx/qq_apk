package com.tencent.mobileqq.jumplightalk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PCJumpLightalkConfig
{
  private static PCJumpLightalkConfig a;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + File.separator + "profile_card_jump_lightalk_config";
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "jumplightalkfiles";
  }
  
  public static void a(String paramString)
  {
    try
    {
      paramString = new File(b + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      jdField_a_of_type_ComTencentMobileqqJumplightalkPCJumpLightalkConfig = null;
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ProfileCardJumpLightalkConfig", 2, "delete config error");
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 88	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   4: ifne +24 -> 28
    //   7: aload_1
    //   8: invokestatic 88	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   11: ifne +17 -> 28
    //   14: aload_2
    //   15: invokestatic 88	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   18: ifne +10 -> 28
    //   21: aload_3
    //   22: invokestatic 88	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   25: ifeq +18 -> 43
    //   28: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 74
    //   36: iconst_2
    //   37: ldc 90
    //   39: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: new 33	java/io/File
    //   46: dup
    //   47: getstatic 47	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: invokevirtual 96	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: new 33	java/io/File
    //   60: dup
    //   61: new 12	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   68: getstatic 51	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:b	Ljava/lang/String;
    //   71: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 4
    //   76: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore 5
    //   87: aload 5
    //   89: invokevirtual 62	java/io/File:exists	()Z
    //   92: ifeq +9 -> 101
    //   95: aload 5
    //   97: invokevirtual 65	java/io/File:delete	()Z
    //   100: pop
    //   101: aconst_null
    //   102: astore 4
    //   104: aload 5
    //   106: invokevirtual 99	java/io/File:createNewFile	()Z
    //   109: pop
    //   110: new 12	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   117: astore 6
    //   119: aload 6
    //   121: aload_0
    //   122: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 6
    //   128: ldc 101
    //   130: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: aload_1
    //   137: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 6
    //   143: ldc 101
    //   145: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 6
    //   151: aload_2
    //   152: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: ldc 101
    //   160: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 6
    //   166: aload_3
    //   167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 6
    //   173: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: ldc 103
    //   178: invokevirtual 109	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   181: astore_2
    //   182: new 111	java/io/FileOutputStream
    //   185: dup
    //   186: aload 5
    //   188: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: aload_1
    //   195: aload_2
    //   196: invokevirtual 118	java/io/FileOutputStream:write	([B)V
    //   199: aload_1
    //   200: astore_0
    //   201: aload_1
    //   202: invokevirtual 121	java/io/FileOutputStream:flush	()V
    //   205: aload_1
    //   206: ifnull -164 -> 42
    //   209: aload_1
    //   210: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   213: return
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   219: return
    //   220: astore_2
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: astore_0
    //   225: aload_2
    //   226: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   229: aload_1
    //   230: ifnull -188 -> 42
    //   233: aload_1
    //   234: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   237: return
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   243: return
    //   244: astore_0
    //   245: aload 4
    //   247: astore_1
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   256: aload_0
    //   257: athrow
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   263: goto -7 -> 256
    //   266: astore_2
    //   267: aload_0
    //   268: astore_1
    //   269: aload_2
    //   270: astore_0
    //   271: goto -23 -> 248
    //   274: astore_2
    //   275: goto -52 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramString1	String
    //   0	278	1	paramString2	String
    //   0	278	2	paramString3	String
    //   0	278	3	paramString4	String
    //   0	278	4	paramString5	String
    //   85	102	5	localFile	File
    //   117	55	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   209	213	214	java/io/IOException
    //   104	192	220	java/io/IOException
    //   233	237	238	java/io/IOException
    //   104	192	244	finally
    //   252	256	258	java/io/IOException
    //   194	199	266	finally
    //   201	205	266	finally
    //   225	229	266	finally
    //   194	199	274	java/io/IOException
    //   201	205	274	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.jumplightalk.PCJumpLightalkConfig
 * JD-Core Version:    0.7.0.1
 */