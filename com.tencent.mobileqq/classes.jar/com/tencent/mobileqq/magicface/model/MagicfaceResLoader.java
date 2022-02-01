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
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceResLoader", 2, "func getVideoPath begins.");
    }
    Object localObject = b;
    int i = 1;
    if ((localObject != null) && (paramInt == 1))
    {
      a = (String)localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("func getVideoPath ends[1]. videoPath:");
        ((StringBuilder)localObject).append(a);
        QLog.d("MagicfaceResLoader", 2, ((StringBuilder)localObject).toString());
      }
      return a;
    }
    if ((paramInt != 2) && (paramInt != 3))
    {
      long l = Math.min(DeviceInfoUtil.B(), DeviceInfoUtil.C());
      boolean bool = DeviceInfoUtil.L();
      if (DeviceInfoUtil.h() >= 2) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      if (l >= 852L)
      {
        if (bool) {
          a = "sbig";
        } else if (paramInt != 0) {
          a = "xbig";
        } else {
          a = "big";
        }
      }
      else if (l >= 640L)
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("func getVideoPath ends[2]. videoPath:");
        ((StringBuilder)localObject).append(a);
        QLog.d("MagicfaceResLoader", 2, ((StringBuilder)localObject).toString());
      }
      localObject = a;
      b = (String)localObject;
      return localObject;
    }
    a = "video";
    return a;
  }
  
  /* Error */
  private byte[] d(String paramString)
  {
    // Byte code:
    //   0: new 44	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 99
    //   13: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 32
    //   26: iconst_1
    //   27: aload 4
    //   29: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: new 104	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: aload 5
    //   47: astore 4
    //   49: aload 5
    //   51: invokevirtual 109	java/io/File:exists	()Z
    //   54: ifne +31 -> 85
    //   57: new 104	java/io/File
    //   60: dup
    //   61: aload_1
    //   62: ldc 82
    //   64: ldc 84
    //   66: invokevirtual 115	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   69: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: aload_1
    //   74: astore 4
    //   76: aload_1
    //   77: invokevirtual 109	java/io/File:exists	()Z
    //   80: ifne +5 -> 85
    //   83: aconst_null
    //   84: areturn
    //   85: new 117	java/io/FileInputStream
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore 4
    //   96: aload 4
    //   98: invokevirtual 125	java/io/InputStream:available	()I
    //   101: istore_2
    //   102: iload_2
    //   103: newarray byte
    //   105: astore_1
    //   106: aload 4
    //   108: aload_1
    //   109: invokevirtual 129	java/io/InputStream:read	([B)I
    //   112: istore_3
    //   113: iload_3
    //   114: iload_2
    //   115: if_icmpeq +45 -> 160
    //   118: new 44	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   125: astore 5
    //   127: aload 5
    //   129: iload_3
    //   130: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 5
    //   136: ldc 134
    //   138: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 5
    //   144: iload_2
    //   145: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: ldc 32
    //   151: iconst_1
    //   152: aload 5
    //   154: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: new 44	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   167: astore 5
    //   169: aload 5
    //   171: ldc 136
    //   173: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 5
    //   179: iload_3
    //   180: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 32
    //   186: iconst_1
    //   187: aload 5
    //   189: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload 4
    //   197: invokevirtual 139	java/io/InputStream:close	()V
    //   200: aload_1
    //   201: areturn
    //   202: aconst_null
    //   203: astore_1
    //   204: goto +9 -> 213
    //   207: aconst_null
    //   208: astore 4
    //   210: aload 4
    //   212: astore_1
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 139	java/io/InputStream:close	()V
    //   223: aload_1
    //   224: areturn
    //   225: aconst_null
    //   226: astore 4
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 139	java/io/InputStream:close	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore_1
    //   241: goto -16 -> 225
    //   244: astore_1
    //   245: goto -38 -> 207
    //   248: astore_1
    //   249: goto -21 -> 228
    //   252: astore_1
    //   253: goto -51 -> 202
    //   256: astore 5
    //   258: goto -45 -> 213
    //   261: astore 4
    //   263: aload_1
    //   264: areturn
    //   265: astore 4
    //   267: aload_1
    //   268: areturn
    //   269: astore_1
    //   270: aconst_null
    //   271: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	MagicfaceResLoader
    //   0	272	1	paramString	String
    //   101	44	2	i	int
    //   112	68	3	j	int
    //   7	227	4	localObject1	Object
    //   261	1	4	localException1	java.lang.Exception
    //   265	1	4	localException2	java.lang.Exception
    //   43	145	5	localObject2	Object
    //   256	1	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	45	240	java/lang/Exception
    //   49	73	240	java/lang/Exception
    //   76	83	240	java/lang/Exception
    //   85	96	240	java/lang/Exception
    //   35	45	244	finally
    //   49	73	244	finally
    //   76	83	244	finally
    //   85	96	244	finally
    //   96	106	248	java/lang/Exception
    //   106	113	248	java/lang/Exception
    //   118	160	248	java/lang/Exception
    //   160	195	248	java/lang/Exception
    //   96	106	252	finally
    //   106	113	256	finally
    //   118	160	256	finally
    //   160	195	256	finally
    //   195	200	261	java/lang/Exception
    //   218	223	265	java/lang/Exception
    //   233	238	269	java/lang/Exception
  }
  
  public MagicfaceData a(String paramString1, String paramString2)
  {
    MagicfaceData localMagicfaceData = new MagicfaceData();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localMagicfaceData.d = d(localStringBuilder.toString());
    paramString1 = new StringBuilder();
    paramString1.append(this.c);
    paramString1.append(a);
    paramString1.append(File.separator);
    paramString1.append(paramString2);
    localMagicfaceData.c = d(paramString1.toString());
    return localMagicfaceData;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return c(localStringBuilder.toString());
  }
  
  public String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("audio");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_2
    //   9: new 104	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: astore_3
    //   22: aload 4
    //   24: astore_2
    //   25: aload 6
    //   27: invokevirtual 109	java/io/File:exists	()Z
    //   30: ifne +36 -> 66
    //   33: aload 4
    //   35: astore_2
    //   36: new 104	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: ldc 82
    //   43: ldc 84
    //   45: invokevirtual 115	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   48: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: astore_3
    //   54: aload 4
    //   56: astore_2
    //   57: aload_1
    //   58: invokevirtual 109	java/io/File:exists	()Z
    //   61: ifne +5 -> 66
    //   64: aconst_null
    //   65: areturn
    //   66: aload 4
    //   68: astore_2
    //   69: new 117	java/io/FileInputStream
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 125	java/io/InputStream:available	()I
    //   82: newarray byte
    //   84: astore_2
    //   85: aload_1
    //   86: aload_2
    //   87: invokevirtual 129	java/io/InputStream:read	([B)I
    //   90: pop
    //   91: new 111	java/lang/String
    //   94: dup
    //   95: aload_2
    //   96: ldc 160
    //   98: invokespecial 163	java/lang/String:<init>	([BLjava/lang/String;)V
    //   101: astore_3
    //   102: aload_3
    //   103: ldc 165
    //   105: ldc 167
    //   107: invokevirtual 171	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_2
    //   111: aload_1
    //   112: invokevirtual 139	java/io/InputStream:close	()V
    //   115: aload_2
    //   116: areturn
    //   117: astore 4
    //   119: goto +27 -> 146
    //   122: astore_3
    //   123: aload_1
    //   124: astore_2
    //   125: goto +86 -> 211
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_3
    //   132: goto +14 -> 146
    //   135: astore_3
    //   136: goto +75 -> 211
    //   139: astore 4
    //   141: aconst_null
    //   142: astore_3
    //   143: aload 5
    //   145: astore_1
    //   146: aload_1
    //   147: astore_2
    //   148: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +50 -> 201
    //   154: aload_1
    //   155: astore_2
    //   156: new 44	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   163: astore 5
    //   165: aload_1
    //   166: astore_2
    //   167: aload 5
    //   169: ldc 173
    //   171: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: astore_2
    //   177: aload 5
    //   179: aload 4
    //   181: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: astore_2
    //   190: ldc 32
    //   192: iconst_2
    //   193: aload 5
    //   195: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 38	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_1
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: invokevirtual 139	java/io/InputStream:close	()V
    //   209: aload_3
    //   210: areturn
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 139	java/io/InputStream:close	()V
    //   219: aload_3
    //   220: athrow
    //   221: astore_1
    //   222: aload_2
    //   223: areturn
    //   224: astore_1
    //   225: aload_3
    //   226: areturn
    //   227: astore_1
    //   228: goto -9 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	MagicfaceResLoader
    //   0	231	1	paramString	String
    //   8	215	2	localObject1	Object
    //   21	82	3	localObject2	Object
    //   122	1	3	localObject3	Object
    //   131	1	3	localObject4	Object
    //   135	1	3	localObject5	Object
    //   142	84	3	str	String
    //   4	63	4	localObject6	Object
    //   117	1	4	localException1	java.lang.Exception
    //   128	1	4	localException2	java.lang.Exception
    //   139	41	4	localException3	java.lang.Exception
    //   1	193	5	localStringBuilder	StringBuilder
    //   17	9	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   102	111	117	java/lang/Exception
    //   78	102	122	finally
    //   102	111	122	finally
    //   78	102	128	java/lang/Exception
    //   9	19	135	finally
    //   25	33	135	finally
    //   36	52	135	finally
    //   57	64	135	finally
    //   69	78	135	finally
    //   148	154	135	finally
    //   156	165	135	finally
    //   167	175	135	finally
    //   177	188	135	finally
    //   190	201	135	finally
    //   9	19	139	java/lang/Exception
    //   25	33	139	java/lang/Exception
    //   36	52	139	java/lang/Exception
    //   57	64	139	java/lang/Exception
    //   69	78	139	java/lang/Exception
    //   111	115	221	java/lang/Exception
    //   205	209	224	java/lang/Exception
    //   215	219	227	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceResLoader
 * JD-Core Version:    0.7.0.1
 */