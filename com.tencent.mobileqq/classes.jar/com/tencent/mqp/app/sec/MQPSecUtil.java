package com.tencent.mqp.app.sec;

import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MQPSecUtil
{
  public static int a = 1;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 14	com/tencent/mqp/app/sec/MQPSecUtil:a	I
    //   4: invokestatic 20	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore_3
    //   8: new 22	java/io/File
    //   11: dup
    //   12: new 24	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   19: aload_3
    //   20: invokevirtual 33	android/content/Context:getFilesDir	()Ljava/io/File;
    //   23: invokevirtual 37	java/io/File:getParent	()Ljava/lang/String;
    //   26: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 43
    //   31: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 45
    //   36: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 47
    //   41: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 57	java/io/File:exists	()Z
    //   55: ifne +31 -> 86
    //   58: ldc 59
    //   60: astore_1
    //   61: getstatic 65	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   64: ldc 67
    //   66: invokevirtual 73	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +95 -> 164
    //   72: ldc 67
    //   74: astore_1
    //   75: aload_1
    //   76: ldc 75
    //   78: if_acmpeq +8 -> 86
    //   81: aload_3
    //   82: aload_1
    //   83: invokestatic 78	com/tencent/mqp/app/sec/MQPSecUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   86: aload_2
    //   87: astore_1
    //   88: aload_2
    //   89: invokevirtual 57	java/io/File:exists	()Z
    //   92: ifne +46 -> 138
    //   95: new 22	java/io/File
    //   98: dup
    //   99: new 24	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   106: aload_3
    //   107: invokevirtual 33	android/content/Context:getFilesDir	()Ljava/io/File;
    //   110: invokevirtual 37	java/io/File:getParent	()Ljava/lang/String;
    //   113: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 80
    //   118: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 45
    //   123: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 47
    //   128: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 57	java/io/File:exists	()Z
    //   142: ifeq +82 -> 224
    //   145: aload_1
    //   146: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   149: invokestatic 88	java/lang/System:load	(Ljava/lang/String;)V
    //   152: iconst_1
    //   153: istore_0
    //   154: iload_0
    //   155: ifne +8 -> 163
    //   158: ldc 45
    //   160: invokestatic 91	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   163: return
    //   164: getstatic 65	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   167: ldc 93
    //   169: invokevirtual 73	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   172: ifeq -97 -> 75
    //   175: ldc 75
    //   177: astore_1
    //   178: goto -103 -> 75
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 96	java/lang/Throwable:printStackTrace	()V
    //   186: goto -100 -> 86
    //   189: astore_2
    //   190: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +31 -> 224
    //   196: ldc 103
    //   198: iconst_2
    //   199: new 24	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   206: ldc 105
    //   208: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   215: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: iconst_0
    //   225: istore_0
    //   226: goto -72 -> 154
    //   229: astore_1
    //   230: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -70 -> 163
    //   236: ldc 103
    //   238: iconst_2
    //   239: ldc 111
    //   241: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   153	73	0	i	int
    //   60	118	1	localObject	Object
    //   181	31	1	localThrowable	java.lang.Throwable
    //   229	1	1	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   50	39	2	localFile	java.io.File
    //   189	1	2	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   7	100	3	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   61	72	181	java/lang/Throwable
    //   81	86	181	java/lang/Throwable
    //   164	175	181	java/lang/Throwable
    //   145	152	189	java/lang/UnsatisfiedLinkError
    //   158	163	229	java/lang/UnsatisfiedLinkError
  }
  
  /* Error */
  private static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 24	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   12: ldc 119
    //   14: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 121
    //   23: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 123
    //   28: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 5
    //   36: new 24	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   43: aload_0
    //   44: invokevirtual 33	android/content/Context:getFilesDir	()Ljava/io/File;
    //   47: invokevirtual 37	java/io/File:getParent	()Ljava/lang/String;
    //   50: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 125
    //   55: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 6
    //   63: new 24	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   70: aload 6
    //   72: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 121
    //   77: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 123
    //   82: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_1
    //   89: new 22	java/io/File
    //   92: dup
    //   93: aload 6
    //   95: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 128	java/io/File:mkdirs	()Z
    //   101: pop
    //   102: aload_0
    //   103: invokevirtual 132	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   106: aload 5
    //   108: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   111: astore_0
    //   112: new 140	java/io/FileOutputStream
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   120: astore_3
    //   121: sipush 4096
    //   124: newarray byte
    //   126: astore_1
    //   127: aload_0
    //   128: aload_1
    //   129: invokevirtual 147	java/io/InputStream:read	([B)I
    //   132: istore_2
    //   133: iload_2
    //   134: ifle +35 -> 169
    //   137: aload_3
    //   138: aload_1
    //   139: iconst_0
    //   140: iload_2
    //   141: invokevirtual 153	java/io/OutputStream:write	([BII)V
    //   144: goto -17 -> 127
    //   147: astore_1
    //   148: aload_0
    //   149: astore_1
    //   150: aload_3
    //   151: astore_0
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 156	java/io/InputStream:close	()V
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 157	java/io/OutputStream:close	()V
    //   168: return
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 156	java/io/InputStream:close	()V
    //   177: aload_3
    //   178: ifnull -10 -> 168
    //   181: aload_3
    //   182: invokevirtual 157	java/io/OutputStream:close	()V
    //   185: return
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   191: return
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   197: return
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: aload 4
    //   203: astore_3
    //   204: aload_0
    //   205: ifnull +7 -> 212
    //   208: aload_0
    //   209: invokevirtual 156	java/io/InputStream:close	()V
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 157	java/io/OutputStream:close	()V
    //   220: aload_1
    //   221: athrow
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   227: goto -7 -> 220
    //   230: astore_1
    //   231: aload 4
    //   233: astore_3
    //   234: goto -30 -> 204
    //   237: astore_1
    //   238: goto -34 -> 204
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_3
    //   245: astore_1
    //   246: goto -94 -> 152
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_3
    //   252: aload_0
    //   253: astore_1
    //   254: aload_3
    //   255: astore_0
    //   256: goto -104 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	android.content.Context
    //   0	259	1	paramString	String
    //   132	9	2	i	int
    //   4	251	3	localObject1	Object
    //   1	231	4	localObject2	Object
    //   34	73	5	str1	String
    //   61	33	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   121	127	147	java/lang/Exception
    //   127	133	147	java/lang/Exception
    //   137	144	147	java/lang/Exception
    //   173	177	186	java/io/IOException
    //   181	185	186	java/io/IOException
    //   156	160	192	java/io/IOException
    //   164	168	192	java/io/IOException
    //   102	112	198	finally
    //   208	212	222	java/io/IOException
    //   216	220	222	java/io/IOException
    //   112	121	230	finally
    //   121	127	237	finally
    //   127	133	237	finally
    //   137	144	237	finally
    //   102	112	241	java/lang/Exception
    //   112	121	249	java/lang/Exception
  }
  
  public static void do_report(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecUtil", 2, "report_tracer:" + paramString);
    }
    bdla.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Safe_MQPSecUtil", "", "AntiTrace", paramString, 0, 0, "", "", "", "");
  }
  
  public static native boolean memchk(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static native byte[] memreport(String paramString, int paramInt1, int paramInt2);
  
  public native void antitrace(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSecUtil
 * JD-Core Version:    0.7.0.1
 */