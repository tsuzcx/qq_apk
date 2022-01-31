package com.tencent.mobileqq.msf.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class j
{
  FileOutputStream a = null;
  byte b = 0;
  byte c = 0;
  boolean d = true;
  
  public j(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    label169:
    do
    {
      do
      {
        try
        {
          long l = paramFile.length();
          if (l < 5L) {}
        }
        catch (FileNotFoundException paramFile)
        {
          paramFile.printStackTrace();
          this.a = null;
          throw new IOException();
        }
        try
        {
          localFileInputStream = new FileInputStream(paramFile);
          try
          {
            byte[] arrayOfByte = new byte[5];
            int j = localFileInputStream.read(arrayOfByte);
            if ((j >= 1) && (arrayOfByte[0] != 0)) {
              this.d = false;
            }
            for (;;)
            {
              localFileInputStream.close();
              this.a = new FileOutputStream(paramFile, paramBoolean);
              return;
              if ((j != 5) || (arrayOfByte[0] != 0)) {
                break;
              }
              this.d = true;
              this.b = 0;
              while (i < 5)
              {
                this.b = ((byte)(this.b ^ arrayOfByte[i]));
                i += 1;
              }
            }
            localFileInputStream.close();
            throw new Exception();
          }
          catch (Exception paramFile) {}
        }
        catch (Exception paramFile)
        {
          localFileInputStream = null;
          break label169;
        }
        paramFile.printStackTrace();
        localFileInputStream.close();
        throw new IOException();
      } while (paramFile.length() <= 0L);
      this.d = false;
      this.a = new FileOutputStream(paramFile, paramBoolean);
      return;
      this.a = new FileOutputStream(paramFile, paramBoolean);
    } while (!this.d);
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
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: new 40	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 52	java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore 6
    //   27: aload_0
    //   28: astore 7
    //   30: sipush 1024
    //   33: newarray byte
    //   35: astore 8
    //   37: aload_1
    //   38: astore 6
    //   40: aload_0
    //   41: astore 7
    //   43: sipush 1024
    //   46: newarray byte
    //   48: astore 9
    //   50: aload_1
    //   51: astore 6
    //   53: aload_0
    //   54: astore 7
    //   56: aload_0
    //   57: aload 8
    //   59: iconst_0
    //   60: iconst_5
    //   61: invokevirtual 83	java/io/FileInputStream:read	([BII)I
    //   64: iconst_5
    //   65: if_icmpne +226 -> 291
    //   68: aload 8
    //   70: iconst_0
    //   71: baload
    //   72: ifne +219 -> 291
    //   75: iconst_1
    //   76: istore_3
    //   77: iconst_0
    //   78: istore_2
    //   79: goto +316 -> 395
    //   82: aload_1
    //   83: astore 6
    //   85: aload_0
    //   86: astore 7
    //   88: aload_1
    //   89: aload 9
    //   91: iconst_0
    //   92: iload 4
    //   94: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   97: aload_1
    //   98: astore 6
    //   100: aload_0
    //   101: astore 7
    //   103: aload_0
    //   104: invokevirtual 90	java/io/FileInputStream:available	()I
    //   107: ifle +159 -> 266
    //   110: aload_1
    //   111: astore 6
    //   113: aload_0
    //   114: astore 7
    //   116: aload_0
    //   117: aload 8
    //   119: invokevirtual 47	java/io/FileInputStream:read	([B)I
    //   122: istore 4
    //   124: iconst_0
    //   125: istore_3
    //   126: iload_3
    //   127: iload 4
    //   129: if_icmpge -47 -> 82
    //   132: aload 9
    //   134: iload_3
    //   135: aload 8
    //   137: iload_3
    //   138: baload
    //   139: iload_2
    //   140: ixor
    //   141: i2b
    //   142: bastore
    //   143: iload_3
    //   144: iconst_1
    //   145: iadd
    //   146: istore_3
    //   147: goto -21 -> 126
    //   150: astore 7
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 6
    //   156: astore_1
    //   157: aload 7
    //   159: astore 6
    //   161: aload 6
    //   163: invokevirtual 60	java/io/FileNotFoundException:printStackTrace	()V
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 50	java/io/FileInputStream:close	()V
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   182: iconst_0
    //   183: istore 5
    //   185: iload 5
    //   187: ireturn
    //   188: astore 8
    //   190: aconst_null
    //   191: astore_1
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_1
    //   195: astore 6
    //   197: aload_0
    //   198: astore 7
    //   200: aload 8
    //   202: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 50	java/io/FileInputStream:close	()V
    //   213: aload_1
    //   214: ifnull -32 -> 182
    //   217: aload_1
    //   218: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   221: goto -39 -> 182
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   229: goto -47 -> 182
    //   232: astore_1
    //   233: aconst_null
    //   234: astore 6
    //   236: aconst_null
    //   237: astore_0
    //   238: aload_0
    //   239: ifnull +7 -> 246
    //   242: aload_0
    //   243: invokevirtual 50	java/io/FileInputStream:close	()V
    //   246: aload 6
    //   248: ifnull +8 -> 256
    //   251: aload 6
    //   253: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   256: aload_1
    //   257: athrow
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   263: goto -7 -> 256
    //   266: aload_0
    //   267: ifnull +7 -> 274
    //   270: aload_0
    //   271: invokevirtual 50	java/io/FileInputStream:close	()V
    //   274: aload_1
    //   275: ifnull -90 -> 185
    //   278: aload_1
    //   279: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   282: iconst_1
    //   283: ireturn
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   289: iconst_1
    //   290: ireturn
    //   291: aload_0
    //   292: ifnull +7 -> 299
    //   295: aload_0
    //   296: invokevirtual 50	java/io/FileInputStream:close	()V
    //   299: aload_1
    //   300: ifnull -118 -> 182
    //   303: aload_1
    //   304: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   307: goto -125 -> 182
    //   310: astore_0
    //   311: goto -86 -> 225
    //   314: astore_0
    //   315: goto -90 -> 225
    //   318: astore_0
    //   319: goto -94 -> 225
    //   322: astore_0
    //   323: goto -98 -> 225
    //   326: astore_1
    //   327: aconst_null
    //   328: astore 6
    //   330: goto -92 -> 238
    //   333: astore_1
    //   334: aload 7
    //   336: astore_0
    //   337: goto -99 -> 238
    //   340: astore 6
    //   342: aload_1
    //   343: astore 7
    //   345: aload 6
    //   347: astore_1
    //   348: aload_0
    //   349: astore 6
    //   351: aload 7
    //   353: astore_0
    //   354: goto -116 -> 238
    //   357: astore 8
    //   359: aconst_null
    //   360: astore_1
    //   361: goto -167 -> 194
    //   364: astore 8
    //   366: goto -172 -> 194
    //   369: astore 6
    //   371: aconst_null
    //   372: astore 7
    //   374: aload_0
    //   375: astore_1
    //   376: aload 7
    //   378: astore_0
    //   379: goto -218 -> 161
    //   382: astore 6
    //   384: aload_0
    //   385: astore 7
    //   387: aload_1
    //   388: astore_0
    //   389: aload 7
    //   391: astore_1
    //   392: goto -231 -> 161
    //   395: iload_3
    //   396: iconst_5
    //   397: if_icmpge -300 -> 97
    //   400: iload_2
    //   401: aload 8
    //   403: iload_3
    //   404: baload
    //   405: ixor
    //   406: i2b
    //   407: istore_2
    //   408: iload_3
    //   409: iconst_1
    //   410: iadd
    //   411: istore_3
    //   412: goto -17 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	paramString1	String
    //   0	415	1	paramString2	String
    //   78	330	2	i	int
    //   76	336	3	j	int
    //   92	38	4	k	int
    //   4	182	5	bool	boolean
    //   1	328	6	localObject1	Object
    //   340	6	6	localObject2	Object
    //   349	1	6	str1	String
    //   369	1	6	localFileNotFoundException1	FileNotFoundException
    //   382	1	6	localFileNotFoundException2	FileNotFoundException
    //   28	87	7	str2	String
    //   150	8	7	localFileNotFoundException3	FileNotFoundException
    //   198	192	7	str3	String
    //   35	101	8	arrayOfByte1	byte[]
    //   188	13	8	localIOException1	IOException
    //   357	1	8	localIOException2	IOException
    //   364	38	8	localIOException3	IOException
    //   48	85	9	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	15	150	java/io/FileNotFoundException
    //   6	15	188	java/io/IOException
    //   217	221	224	java/io/IOException
    //   6	15	232	finally
    //   242	246	258	java/io/IOException
    //   251	256	258	java/io/IOException
    //   270	274	284	java/io/IOException
    //   278	282	284	java/io/IOException
    //   303	307	310	java/io/IOException
    //   295	299	314	java/io/IOException
    //   209	213	318	java/io/IOException
    //   170	174	322	java/io/IOException
    //   178	182	322	java/io/IOException
    //   15	24	326	finally
    //   30	37	333	finally
    //   43	50	333	finally
    //   56	68	333	finally
    //   88	97	333	finally
    //   103	110	333	finally
    //   116	124	333	finally
    //   200	205	333	finally
    //   161	166	340	finally
    //   15	24	357	java/io/IOException
    //   30	37	364	java/io/IOException
    //   43	50	364	java/io/IOException
    //   56	68	364	java/io/IOException
    //   88	97	364	java/io/IOException
    //   103	110	364	java/io/IOException
    //   116	124	364	java/io/IOException
    //   15	24	369	java/io/FileNotFoundException
    //   30	37	382	java/io/FileNotFoundException
    //   43	50	382	java/io/FileNotFoundException
    //   56	68	382	java/io/FileNotFoundException
    //   88	97	382	java/io/FileNotFoundException
    //   103	110	382	java/io/FileNotFoundException
    //   116	124	382	java/io/FileNotFoundException
  }
  
  public static byte[] b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
        int j = arrayOfByte2.length;
        byte[] arrayOfByte1 = new byte[j];
        int i = 0;
        for (;;)
        {
          paramString = arrayOfByte1;
          if (i >= j) {
            break;
          }
          arrayOfByte1[i] = ((byte)(arrayOfByte2[i] ^ 0xCC));
          i += 1;
        }
        return null;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a()
    throws IOException
  {
    if (this.a != null) {
      this.a.flush();
    }
  }
  
  public void a(String paramString)
    throws IOException
  {
    if ((this.a == null) || (paramString == null) || (paramString.length() == 0)) {
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
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    this.a.write(paramString);
  }
  
  public void b()
    throws IOException
  {
    if (this.a != null) {
      this.a.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.j
 * JD-Core Version:    0.7.0.1
 */