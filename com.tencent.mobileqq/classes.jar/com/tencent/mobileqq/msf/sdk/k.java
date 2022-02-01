package com.tencent.mobileqq.msf.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class k
{
  FileOutputStream a = null;
  byte b = 0;
  byte c = 0;
  boolean d;
  
  public k(File paramFile, boolean paramBoolean)
  {
    int i = 1;
    this.d = true;
    if (paramBoolean) {}
    try
    {
      long l = paramFile.length();
      if (l >= 5L)
      {
        try
        {
          Object localObject = new FileInputStream(paramFile);
          try
          {
            byte[] arrayOfByte = new byte[5];
            int j = ((FileInputStream)localObject).read(arrayOfByte);
            if ((j >= 1) && (arrayOfByte[0] != 0))
            {
              this.d = false;
            }
            else
            {
              if ((j != 5) || (arrayOfByte[0] != 0)) {
                break label158;
              }
              this.d = true;
              this.b = 0;
              while (i < 5)
              {
                this.b = ((byte)(this.b ^ arrayOfByte[i]));
                i += 1;
              }
            }
            ((FileInputStream)localObject).close();
            this.a = new FileOutputStream(paramFile, paramBoolean);
            return;
            label158:
            ((FileInputStream)localObject).close();
            throw new Exception();
          }
          catch (Exception localException2)
          {
            paramFile = (File)localObject;
            localObject = localException2;
          }
          localException1.printStackTrace();
        }
        catch (Exception localException1)
        {
          paramFile = null;
        }
        paramFile.close();
        throw new IOException();
      }
      if (paramFile.length() > 0L)
      {
        this.d = false;
        this.a = new FileOutputStream(paramFile, paramBoolean);
        return;
        this.a = new FileOutputStream(paramFile, paramBoolean);
        if (this.d)
        {
          paramFile = new byte[4];
          while (this.b == 0)
          {
            new Random().nextBytes(paramFile);
            i = 0;
            while (i < 4)
            {
              this.b = ((byte)(this.b ^ paramFile[i]));
              i += 1;
            }
          }
          this.a.write(this.c);
          this.a.write(paramFile);
        }
      }
      return;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      this.a = null;
      paramFile = new IOException();
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: new 38	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 50	java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore 5
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore 6
    //   38: aload_0
    //   39: aload 5
    //   41: iconst_0
    //   42: iconst_5
    //   43: invokevirtual 82	java/io/FileInputStream:read	([BII)I
    //   46: iconst_5
    //   47: if_icmpne +66 -> 113
    //   50: aload 5
    //   52: iconst_0
    //   53: baload
    //   54: ifne +59 -> 113
    //   57: iconst_1
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: goto +276 -> 337
    //   64: aload_0
    //   65: invokevirtual 86	java/io/FileInputStream:available	()I
    //   68: ifle +28 -> 96
    //   71: aload_0
    //   72: aload 5
    //   74: invokevirtual 45	java/io/FileInputStream:read	([B)I
    //   77: istore 4
    //   79: iconst_0
    //   80: istore_3
    //   81: goto +276 -> 357
    //   84: aload_1
    //   85: aload 6
    //   87: iconst_0
    //   88: iload 4
    //   90: invokevirtual 89	java/io/FileOutputStream:write	([BII)V
    //   93: goto -29 -> 64
    //   96: aload_0
    //   97: invokevirtual 48	java/io/FileInputStream:close	()V
    //   100: aload_1
    //   101: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   111: iconst_1
    //   112: ireturn
    //   113: aload_0
    //   114: invokevirtual 48	java/io/FileInputStream:close	()V
    //   117: aload_1
    //   118: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore 6
    //   132: aload_0
    //   133: astore 5
    //   135: aload_1
    //   136: astore_0
    //   137: aload 6
    //   139: astore_1
    //   140: goto +161 -> 301
    //   143: astore 5
    //   145: aload_1
    //   146: astore 6
    //   148: aload 5
    //   150: astore_1
    //   151: goto +31 -> 182
    //   154: astore 5
    //   156: aload_1
    //   157: astore 6
    //   159: aload 5
    //   161: astore_1
    //   162: goto +33 -> 195
    //   165: astore_1
    //   166: aconst_null
    //   167: astore 6
    //   169: aload_0
    //   170: astore 5
    //   172: aload 6
    //   174: astore_0
    //   175: goto +126 -> 301
    //   178: astore_1
    //   179: aconst_null
    //   180: astore 6
    //   182: aload_0
    //   183: astore 5
    //   185: aload_1
    //   186: astore 7
    //   188: goto +30 -> 218
    //   191: astore_1
    //   192: aconst_null
    //   193: astore 6
    //   195: aload_0
    //   196: astore 5
    //   198: aload_1
    //   199: astore 7
    //   201: goto +59 -> 260
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_0
    //   207: aload_0
    //   208: astore 5
    //   210: goto +91 -> 301
    //   213: astore 7
    //   215: aconst_null
    //   216: astore 6
    //   218: aload 5
    //   220: astore_1
    //   221: aload 6
    //   223: astore_0
    //   224: aload 7
    //   226: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   229: aload 5
    //   231: ifnull +8 -> 239
    //   234: aload 5
    //   236: invokevirtual 48	java/io/FileInputStream:close	()V
    //   239: aload 6
    //   241: ifnull +50 -> 291
    //   244: aload 6
    //   246: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   249: iconst_0
    //   250: ireturn
    //   251: astore 7
    //   253: aconst_null
    //   254: astore 6
    //   256: aload 8
    //   258: astore 5
    //   260: aload 5
    //   262: astore_1
    //   263: aload 6
    //   265: astore_0
    //   266: aload 7
    //   268: invokevirtual 73	java/io/FileNotFoundException:printStackTrace	()V
    //   271: aload 5
    //   273: ifnull +8 -> 281
    //   276: aload 5
    //   278: invokevirtual 48	java/io/FileInputStream:close	()V
    //   281: aload 6
    //   283: ifnull +8 -> 291
    //   286: aload 6
    //   288: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   291: iconst_0
    //   292: ireturn
    //   293: astore 6
    //   295: aload_1
    //   296: astore 5
    //   298: aload 6
    //   300: astore_1
    //   301: aload 5
    //   303: ifnull +11 -> 314
    //   306: aload 5
    //   308: invokevirtual 48	java/io/FileInputStream:close	()V
    //   311: goto +3 -> 314
    //   314: aload_0
    //   315: ifnull +14 -> 329
    //   318: aload_0
    //   319: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   322: goto +7 -> 329
    //   325: aload_0
    //   326: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   329: goto +5 -> 334
    //   332: aload_1
    //   333: athrow
    //   334: goto -2 -> 332
    //   337: iload_3
    //   338: iconst_5
    //   339: if_icmpge -275 -> 64
    //   342: iload_2
    //   343: aload 5
    //   345: iload_3
    //   346: baload
    //   347: ixor
    //   348: i2b
    //   349: istore_2
    //   350: iload_3
    //   351: iconst_1
    //   352: iadd
    //   353: istore_3
    //   354: goto -17 -> 337
    //   357: iload_3
    //   358: iload 4
    //   360: if_icmpge -276 -> 84
    //   363: aload 6
    //   365: iload_3
    //   366: aload 5
    //   368: iload_3
    //   369: baload
    //   370: iload_2
    //   371: ixor
    //   372: i2b
    //   373: bastore
    //   374: iload_3
    //   375: iconst_1
    //   376: iadd
    //   377: istore_3
    //   378: goto -21 -> 357
    //   381: astore_0
    //   382: goto -57 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString1	String
    //   0	385	1	paramString2	String
    //   60	312	2	i	int
    //   58	320	3	j	int
    //   77	284	4	k	int
    //   4	130	5	localObject1	Object
    //   143	6	5	localIOException1	IOException
    //   154	6	5	localFileNotFoundException1	FileNotFoundException
    //   170	197	5	localObject2	Object
    //   36	50	6	arrayOfByte	byte[]
    //   130	8	6	localObject3	Object
    //   146	141	6	str1	String
    //   293	71	6	localObject4	Object
    //   186	14	7	str2	String
    //   213	12	7	localIOException2	IOException
    //   251	16	7	localFileNotFoundException2	FileNotFoundException
    //   1	256	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   96	104	106	java/io/IOException
    //   113	121	123	java/io/IOException
    //   234	239	123	java/io/IOException
    //   244	249	123	java/io/IOException
    //   276	281	123	java/io/IOException
    //   286	291	123	java/io/IOException
    //   24	50	130	finally
    //   64	79	130	finally
    //   84	93	130	finally
    //   24	50	143	java/io/IOException
    //   64	79	143	java/io/IOException
    //   84	93	143	java/io/IOException
    //   24	50	154	java/io/FileNotFoundException
    //   64	79	154	java/io/FileNotFoundException
    //   84	93	154	java/io/FileNotFoundException
    //   15	24	165	finally
    //   15	24	178	java/io/IOException
    //   15	24	191	java/io/FileNotFoundException
    //   6	15	204	finally
    //   6	15	213	java/io/IOException
    //   6	15	251	java/io/FileNotFoundException
    //   224	229	293	finally
    //   266	271	293	finally
    //   306	311	381	java/io/IOException
    //   318	322	381	java/io/IOException
  }
  
  public static byte[] b(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      try
      {
        paramString = paramString.getBytes("UTF-8");
        int j = paramString.length;
        byte[] arrayOfByte = new byte[j];
        int i = 0;
        while (i < j)
        {
          arrayOfByte[i] = ((byte)(paramString[i] ^ 0xCC));
          i += 1;
        }
        return arrayOfByte;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    FileOutputStream localFileOutputStream = this.a;
    if (localFileOutputStream != null) {
      localFileOutputStream.flush();
    }
  }
  
  public void a(String paramString)
  {
    if ((this.a != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return;
      }
      try
      {
        paramString = paramString.getBytes("UTF-8");
        int j = paramString.length;
        if (this.d)
        {
          byte[] arrayOfByte = new byte[j];
          int i = 0;
          while (i < j)
          {
            arrayOfByte[i] = ((byte)(paramString[i] ^ this.b));
            i += 1;
          }
          this.a.write(arrayOfByte);
          return;
        }
        this.a.write(paramString);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    FileOutputStream localFileOutputStream = this.a;
    if (localFileOutputStream != null) {
      localFileOutputStream.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.k
 * JD-Core Version:    0.7.0.1
 */