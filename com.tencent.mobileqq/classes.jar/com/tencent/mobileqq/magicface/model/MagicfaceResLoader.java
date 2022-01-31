package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MagicfaceResLoader
{
  public static String a;
  public static String b;
  private String c;
  
  public MagicfaceResLoader(String paramString)
  {
    this(paramString, 1);
  }
  
  public MagicfaceResLoader(String paramString, int paramInt)
  {
    this.c = paramString;
    a(paramInt);
  }
  
  public static String a()
  {
    return a(1);
  }
  
  public static String a(int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceResLoader", 2, "func getVideoPath begins.");
    }
    if ((b != null) && (paramInt == 1))
    {
      a = b;
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[1]. videoPath:" + a);
      }
      return a;
    }
    if ((paramInt == 2) || (paramInt == 3))
    {
      a = "video";
      return a;
    }
    long l = Math.min(DeviceInfoUtil.h(), DeviceInfoUtil.i());
    boolean bool = DeviceInfoUtil.d();
    if (DeviceInfoUtil.b() >= 2)
    {
      paramInt = i;
      if (l < 852L) {
        break label199;
      }
      if (!bool) {
        break label179;
      }
      a = "sbig";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[2]. videoPath:" + a);
      }
      b = a;
      return a;
      paramInt = 0;
      break;
      label179:
      if (paramInt != 0)
      {
        a = "xbig";
      }
      else
      {
        a = "big";
        continue;
        label199:
        if (l >= 640L)
        {
          if (paramInt != 0) {
            a = "xbig";
          } else {
            a = "big";
          }
        }
        else if (l >= 480L) {
          a = "big";
        } else {
          a = "small";
        }
      }
    }
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 96	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 8
    //   16: aload 8
    //   18: astore 5
    //   20: aload 8
    //   22: invokevirtual 101	java/io/File:exists	()Z
    //   25: ifne +47 -> 72
    //   28: new 96	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: ldc 83
    //   35: ldc 85
    //   37: invokevirtual 107	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   40: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: aload 5
    //   47: invokevirtual 101	java/io/File:exists	()Z
    //   50: istore 4
    //   52: iload 4
    //   54: ifne +18 -> 72
    //   57: iconst_0
    //   58: ifeq +11 -> 69
    //   61: new 109	java/lang/NullPointerException
    //   64: dup
    //   65: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   68: athrow
    //   69: aload 6
    //   71: areturn
    //   72: new 112	java/io/FileInputStream
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: astore 5
    //   83: aload 5
    //   85: invokevirtual 120	java/io/InputStream:available	()I
    //   88: istore_2
    //   89: iload_2
    //   90: newarray byte
    //   92: astore_1
    //   93: aload 5
    //   95: aload_1
    //   96: invokevirtual 124	java/io/InputStream:read	([B)I
    //   99: istore_3
    //   100: iload_3
    //   101: iload_2
    //   102: if_icmpeq +3 -> 105
    //   105: aload 5
    //   107: ifnull +8 -> 115
    //   110: aload 5
    //   112: invokevirtual 127	java/io/InputStream:close	()V
    //   115: aload_1
    //   116: areturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull -52 -> 69
    //   124: aload_1
    //   125: invokevirtual 127	java/io/InputStream:close	()V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_1
    //   131: aconst_null
    //   132: areturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 7
    //   139: astore_1
    //   140: aload_1
    //   141: astore 6
    //   143: aload 5
    //   145: ifnull -76 -> 69
    //   148: aload 5
    //   150: invokevirtual 127	java/io/InputStream:close	()V
    //   153: aload_1
    //   154: areturn
    //   155: astore 5
    //   157: aload_1
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: areturn
    //   162: astore 5
    //   164: goto -49 -> 115
    //   167: astore_1
    //   168: aload 7
    //   170: astore_1
    //   171: goto -31 -> 140
    //   174: astore 6
    //   176: goto -36 -> 140
    //   179: astore_1
    //   180: aload 5
    //   182: astore_1
    //   183: goto -63 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	MagicfaceResLoader
    //   0	186	1	paramString	String
    //   88	15	2	i	int
    //   99	4	3	j	int
    //   50	3	4	bool	boolean
    //   18	131	5	localObject1	Object
    //   155	1	5	localException1	java.lang.Exception
    //   162	19	5	localException2	java.lang.Exception
    //   4	138	6	localObject2	Object
    //   174	1	6	localObject3	Object
    //   1	168	7	localObject4	Object
    //   14	7	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   6	16	117	java/lang/Exception
    //   20	52	117	java/lang/Exception
    //   72	83	117	java/lang/Exception
    //   124	128	130	java/lang/Exception
    //   6	16	133	finally
    //   20	52	133	finally
    //   72	83	133	finally
    //   148	153	155	java/lang/Exception
    //   61	69	159	java/lang/Exception
    //   110	115	162	java/lang/Exception
    //   83	93	167	finally
    //   93	100	174	finally
    //   83	93	179	java/lang/Exception
    //   93	100	179	java/lang/Exception
  }
  
  public MagicfaceData a(String paramString1, String paramString2)
  {
    MagicfaceData localMagicfaceData = new MagicfaceData();
    localMagicfaceData.b = a(this.c + a + File.separator + paramString1);
    localMagicfaceData.a = a(this.c + a + File.separator + paramString2);
    return localMagicfaceData;
  }
  
  public String a(String paramString)
  {
    return c(this.c + a + File.separator + paramString);
  }
  
  public String b(String paramString)
  {
    return this.c + "audio" + File.separator + paramString;
  }
  
  /* Error */
  public String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 96	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: aload 5
    //   18: astore_3
    //   19: aload 5
    //   21: invokevirtual 101	java/io/File:exists	()Z
    //   24: ifne +45 -> 69
    //   27: new 96	java/io/File
    //   30: dup
    //   31: aload_1
    //   32: ldc 83
    //   34: ldc 85
    //   36: invokevirtual 107	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   39: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 101	java/io/File:exists	()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +20 -> 69
    //   52: aload 4
    //   54: astore_1
    //   55: iconst_0
    //   56: ifeq +11 -> 67
    //   59: new 109	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: aload_1
    //   68: areturn
    //   69: new 112	java/io/FileInputStream
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore 4
    //   79: aload 4
    //   81: astore_1
    //   82: aload 4
    //   84: invokevirtual 120	java/io/InputStream:available	()I
    //   87: newarray byte
    //   89: astore_3
    //   90: aload 4
    //   92: astore_1
    //   93: aload 4
    //   95: aload_3
    //   96: invokevirtual 124	java/io/InputStream:read	([B)I
    //   99: pop
    //   100: aload 4
    //   102: astore_1
    //   103: new 103	java/lang/String
    //   106: dup
    //   107: aload_3
    //   108: ldc 148
    //   110: invokespecial 151	java/lang/String:<init>	([BLjava/lang/String;)V
    //   113: astore_3
    //   114: aload 4
    //   116: astore_1
    //   117: aload_3
    //   118: ldc 153
    //   120: ldc 155
    //   122: invokevirtual 159	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 5
    //   129: astore_3
    //   130: aload_3
    //   131: astore_1
    //   132: aload 4
    //   134: ifnull -67 -> 67
    //   137: aload 4
    //   139: invokevirtual 127	java/io/InputStream:close	()V
    //   142: aload_3
    //   143: areturn
    //   144: astore_1
    //   145: aload_3
    //   146: areturn
    //   147: astore 5
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 6
    //   154: astore_3
    //   155: aload 4
    //   157: astore_1
    //   158: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +35 -> 196
    //   164: aload 4
    //   166: astore_1
    //   167: ldc 31
    //   169: iconst_2
    //   170: new 43	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   177: ldc 161
    //   179: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 5
    //   184: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_3
    //   197: astore_1
    //   198: aload 4
    //   200: ifnull -133 -> 67
    //   203: aload 4
    //   205: invokevirtual 127	java/io/InputStream:close	()V
    //   208: aload_3
    //   209: areturn
    //   210: astore_1
    //   211: aload_3
    //   212: areturn
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 127	java/io/InputStream:close	()V
    //   224: aload_3
    //   225: athrow
    //   226: astore_1
    //   227: aconst_null
    //   228: areturn
    //   229: astore_1
    //   230: goto -6 -> 224
    //   233: astore_3
    //   234: goto -18 -> 216
    //   237: astore 5
    //   239: aload 6
    //   241: astore_3
    //   242: goto -87 -> 155
    //   245: astore 5
    //   247: goto -92 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	MagicfaceResLoader
    //   0	250	1	paramString	String
    //   47	2	2	bool	boolean
    //   18	194	3	localObject1	Object
    //   213	12	3	localObject2	Object
    //   233	1	3	localObject3	Object
    //   241	1	3	localObject4	Object
    //   4	200	4	localFileInputStream	java.io.FileInputStream
    //   14	114	5	localObject5	Object
    //   147	36	5	localException1	java.lang.Exception
    //   237	1	5	localException2	java.lang.Exception
    //   245	1	5	localException3	java.lang.Exception
    //   1	239	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   137	142	144	java/lang/Exception
    //   6	16	147	java/lang/Exception
    //   19	48	147	java/lang/Exception
    //   69	79	147	java/lang/Exception
    //   203	208	210	java/lang/Exception
    //   6	16	213	finally
    //   19	48	213	finally
    //   69	79	213	finally
    //   59	67	226	java/lang/Exception
    //   220	224	229	java/lang/Exception
    //   82	90	233	finally
    //   93	100	233	finally
    //   103	114	233	finally
    //   117	127	233	finally
    //   158	164	233	finally
    //   167	196	233	finally
    //   82	90	237	java/lang/Exception
    //   93	100	237	java/lang/Exception
    //   103	114	237	java/lang/Exception
    //   117	127	245	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceResLoader
 * JD-Core Version:    0.7.0.1
 */