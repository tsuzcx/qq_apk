package com.tencent.mobileqq.jumplightalk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class CallTabLightalkConfig
{
  private static CallTabLightalkConfig a;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + File.separator + "call_tab_jump_lightalk_config";
  
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
      jdField_a_of_type_ComTencentMobileqqJumplightalkCallTabLightalkConfig = null;
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CallTabLightalkConfig", 2, "delete config error");
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 88	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   4: ifne +17 -> 21
    //   7: aload_1
    //   8: invokestatic 88	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   11: ifne +10 -> 21
    //   14: aload_3
    //   15: invokestatic 88	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   18: ifeq +18 -> 36
    //   21: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 74
    //   29: iconst_2
    //   30: ldc 90
    //   32: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: return
    //   36: new 33	java/io/File
    //   39: dup
    //   40: getstatic 47	com/tencent/mobileqq/jumplightalk/CallTabLightalkConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 96	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: new 33	java/io/File
    //   53: dup
    //   54: new 12	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   61: getstatic 51	com/tencent/mobileqq/jumplightalk/CallTabLightalkConfig:b	Ljava/lang/String;
    //   64: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 4
    //   69: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 62	java/io/File:exists	()Z
    //   85: ifeq +9 -> 94
    //   88: aload 5
    //   90: invokevirtual 65	java/io/File:delete	()Z
    //   93: pop
    //   94: aconst_null
    //   95: astore 4
    //   97: aload 5
    //   99: invokevirtual 99	java/io/File:createNewFile	()Z
    //   102: pop
    //   103: new 12	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   110: astore 6
    //   112: aload 6
    //   114: aload_0
    //   115: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 6
    //   121: ldc 101
    //   123: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 6
    //   129: aload_1
    //   130: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: ldc 101
    //   138: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 6
    //   144: aload_2
    //   145: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 6
    //   151: ldc 101
    //   153: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 6
    //   159: aload_3
    //   160: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 6
    //   166: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: ldc 103
    //   171: invokevirtual 109	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   174: astore_2
    //   175: new 111	java/io/FileOutputStream
    //   178: dup
    //   179: aload 5
    //   181: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   184: astore_1
    //   185: aload_1
    //   186: astore_0
    //   187: aload_1
    //   188: aload_2
    //   189: invokevirtual 118	java/io/FileOutputStream:write	([B)V
    //   192: aload_1
    //   193: astore_0
    //   194: aload_1
    //   195: invokevirtual 121	java/io/FileOutputStream:flush	()V
    //   198: aload_1
    //   199: ifnull -164 -> 35
    //   202: aload_1
    //   203: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   206: return
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   212: return
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: astore_0
    //   218: aload_2
    //   219: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   222: aload_1
    //   223: ifnull -188 -> 35
    //   226: aload_1
    //   227: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   230: return
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   236: return
    //   237: astore_0
    //   238: aload 4
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 124	java/io/FileOutputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 127	java/io/IOException:printStackTrace	()V
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
 * Qualified Name:     com.tencent.mobileqq.jumplightalk.CallTabLightalkConfig
 * JD-Core Version:    0.7.0.1
 */