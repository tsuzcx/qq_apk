package com.tencent.mobileqq.microapp.c;

import android.content.res.AssetManager;
import android.text.TextUtils;
import baip;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.apkg.q;
import com.tencent.mobileqq.microapp.apkg.r;
import com.tencent.mobileqq.microapp.apkg.s;
import com.tencent.mobileqq.microapp.b.a;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  public boolean a;
  public String b;
  public r c;
  public s d;
  public List e = new LinkedList();
  private Map f;
  private Map g = new HashMap();
  
  public static File a(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = new File(BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/tmp" + paramString);
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localFileOutputStream.close();
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      System.out.println();
      return null;
    }
    paramInputStream.close();
    return paramString;
  }
  
  public static File a(String paramString)
  {
    File localFile = null;
    Object localObject1 = BaseApplicationImpl.getContext().getAssets();
    try
    {
      localObject1 = ((AssetManager)localObject1).open(paramString);
      if (localObject1 != null) {
        localFile = a((InputStream)localObject1, paramString);
      }
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        String str = paramJSONArray.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localLinkedList.add(str);
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static Map a(JSONObject paramJSONObject, r paramr)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        r localr = paramr.b();
        localr.a(paramJSONObject.optJSONObject(str));
        localHashMap.put(str, localr);
      }
    }
    return localHashMap;
  }
  
  private static void a(File paramFile, byte[] paramArrayOfByte)
  {
    if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs())) {
      throw new RuntimeException("Create folder fail:" + paramFile.getParentFile().getAbsolutePath());
    }
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramString1, paramString2, "");
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +12 -> 19
    //   10: aload_1
    //   11: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifeq +10 -> 26
    //   19: iconst_0
    //   20: istore_3
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: new 37	java/io/File
    //   29: dup
    //   30: aload_1
    //   31: aload_2
    //   32: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokevirtual 190	java/io/File:exists	()Z
    //   38: ifeq +8 -> 46
    //   41: iconst_1
    //   42: istore_3
    //   43: goto -22 -> 21
    //   46: aload_0
    //   47: aload_1
    //   48: aload_2
    //   49: invokestatic 216	com/tencent/mobileqq/microapp/c/c:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   52: istore_3
    //   53: goto -32 -> 21
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramString1	String
    //   0	62	1	paramString2	String
    //   0	62	2	paramString3	String
    //   14	39	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	15	56	finally
    //   26	41	56	finally
    //   46	53	56	finally
  }
  
  public static c b(String paramString)
  {
    c localc = new c();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramString.optString(str1);
        localc.g.put(str1, str2);
      }
      localc.a = paramString.optBoolean("debug");
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return localc;
    }
    localc.b = paramString.optString("entryPagePath");
    localc.c = r.a();
    localc.c.a(paramString.optJSONObject("global"));
    localc.f = a(paramString.optJSONObject("page"), localc.c);
    a(paramString.optJSONArray("pages"));
    q.a(paramString.optJSONObject("networkTimeout"));
    localc.d = s.a(paramString.optJSONObject("tabBar"));
    localc.e = b(paramString.optJSONArray("subPackages"));
    return localc;
  }
  
  private static List b(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("root");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localLinkedList.add(localObject);
          }
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  /* Error */
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +80 -> 100
    //   23: new 39	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   30: new 37	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 283
    //   47: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 7
    //   57: new 285	java/io/RandomAccessFile
    //   60: dup
    //   61: aload_0
    //   62: ldc_w 287
    //   65: invokespecial 288	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 292	java/io/RandomAccessFile:readByte	()B
    //   73: bipush 190
    //   75: if_icmpeq +40 -> 115
    //   78: new 195	java/lang/RuntimeException
    //   81: dup
    //   82: ldc_w 294
    //   85: invokespecial 201	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_1
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: new 37	java/io/File
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: astore_2
    //   112: goto -58 -> 54
    //   115: aload_0
    //   116: ldc2_w 296
    //   119: invokevirtual 301	java/io/RandomAccessFile:seek	(J)V
    //   122: aload_0
    //   123: invokevirtual 304	java/io/RandomAccessFile:readInt	()I
    //   126: istore 4
    //   128: new 306	java/util/ArrayList
    //   131: dup
    //   132: iload 4
    //   134: invokespecial 309	java/util/ArrayList:<init>	(I)V
    //   137: astore 9
    //   139: iconst_0
    //   140: istore_3
    //   141: iload_3
    //   142: iload 4
    //   144: if_icmpge +141 -> 285
    //   147: aload_0
    //   148: invokevirtual 304	java/io/RandomAccessFile:readInt	()I
    //   151: istore 5
    //   153: iload 5
    //   155: newarray byte
    //   157: astore 7
    //   159: aload_0
    //   160: aload 7
    //   162: iconst_0
    //   163: iload 5
    //   165: invokevirtual 312	java/io/RandomAccessFile:read	([BII)I
    //   168: pop
    //   169: new 37	java/io/File
    //   172: dup
    //   173: new 165	java/lang/String
    //   176: dup
    //   177: aload 7
    //   179: iconst_0
    //   180: iload 5
    //   182: invokespecial 314	java/lang/String:<init>	([BII)V
    //   185: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: astore 8
    //   193: aload 8
    //   195: astore 7
    //   197: aload_2
    //   198: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +54 -> 255
    //   204: aload 8
    //   206: aload_2
    //   207: invokevirtual 317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   210: istore 6
    //   212: iload 6
    //   214: ifne +13 -> 227
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   225: iconst_0
    //   226: ireturn
    //   227: aload 8
    //   229: aload_2
    //   230: new 39	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   237: aload_2
    //   238: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 283
    //   244: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokevirtual 321	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: astore 7
    //   255: aload 9
    //   257: new 323	com/tencent/mobileqq/microapp/c/c$a
    //   260: dup
    //   261: aload 7
    //   263: aload_0
    //   264: invokevirtual 304	java/io/RandomAccessFile:readInt	()I
    //   267: aload_0
    //   268: invokevirtual 304	java/io/RandomAccessFile:readInt	()I
    //   271: invokespecial 326	com/tencent/mobileqq/microapp/c/c$a:<init>	(Ljava/lang/String;II)V
    //   274: invokevirtual 327	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   277: pop
    //   278: iload_3
    //   279: iconst_1
    //   280: iadd
    //   281: istore_3
    //   282: goto -141 -> 141
    //   285: aload 9
    //   287: invokevirtual 330	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   290: astore_2
    //   291: aload_2
    //   292: invokeinterface 159 1 0
    //   297: ifeq +86 -> 383
    //   300: aload_2
    //   301: invokeinterface 163 1 0
    //   306: checkcast 323	com/tencent/mobileqq/microapp/c/c$a
    //   309: astore 7
    //   311: new 37	java/io/File
    //   314: dup
    //   315: aload_1
    //   316: aload 7
    //   318: getfield 332	com/tencent/mobileqq/microapp/c/c$a:a	Ljava/lang/String;
    //   321: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: astore 8
    //   326: aload_0
    //   327: aload 7
    //   329: getfield 335	com/tencent/mobileqq/microapp/c/c$a:b	I
    //   332: i2l
    //   333: invokevirtual 301	java/io/RandomAccessFile:seek	(J)V
    //   336: aload 7
    //   338: getfield 337	com/tencent/mobileqq/microapp/c/c$a:c	I
    //   341: newarray byte
    //   343: astore 9
    //   345: aload_0
    //   346: aload 9
    //   348: iconst_0
    //   349: aload 7
    //   351: getfield 337	com/tencent/mobileqq/microapp/c/c$a:c	I
    //   354: invokevirtual 312	java/io/RandomAccessFile:read	([BII)I
    //   357: pop
    //   358: aload 8
    //   360: aload 9
    //   362: invokestatic 339	com/tencent/mobileqq/microapp/c/c:a	(Ljava/io/File;[B)V
    //   365: goto -74 -> 291
    //   368: astore_2
    //   369: aload_0
    //   370: astore_1
    //   371: aload_2
    //   372: astore_0
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   381: aload_0
    //   382: athrow
    //   383: aload_0
    //   384: ifnull +7 -> 391
    //   387: aload_0
    //   388: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   391: iconst_1
    //   392: ireturn
    //   393: astore_0
    //   394: goto -169 -> 225
    //   397: astore_0
    //   398: goto -7 -> 391
    //   401: astore_0
    //   402: goto -304 -> 98
    //   405: astore_1
    //   406: goto -25 -> 381
    //   409: astore_0
    //   410: aconst_null
    //   411: astore_1
    //   412: goto -39 -> 373
    //   415: astore_0
    //   416: aload 7
    //   418: astore_0
    //   419: goto -329 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	paramString1	String
    //   0	422	1	paramString2	String
    //   0	422	2	paramString3	String
    //   140	142	3	i	int
    //   126	19	4	j	int
    //   151	30	5	k	int
    //   210	3	6	bool	boolean
    //   55	362	7	localObject1	Object
    //   191	168	8	localObject2	Object
    //   137	224	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   69	89	89	java/lang/Exception
    //   115	139	89	java/lang/Exception
    //   147	193	89	java/lang/Exception
    //   197	212	89	java/lang/Exception
    //   227	255	89	java/lang/Exception
    //   255	278	89	java/lang/Exception
    //   285	291	89	java/lang/Exception
    //   291	365	89	java/lang/Exception
    //   69	89	368	finally
    //   115	139	368	finally
    //   147	193	368	finally
    //   197	212	368	finally
    //   227	255	368	finally
    //   255	278	368	finally
    //   285	291	368	finally
    //   291	365	368	finally
    //   221	225	393	java/lang/Exception
    //   387	391	397	java/lang/Exception
    //   94	98	401	java/lang/Exception
    //   377	381	405	java/lang/Exception
    //   57	69	409	finally
    //   57	69	415	java/lang/Exception
  }
  
  private static boolean c(String paramString1, String paramString2, String paramString3)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      String str1;
      do
      {
        String str2;
        do
        {
          return false;
          str1 = new File(paramString2, paramString3).getAbsolutePath();
          str2 = str1 + "Tmp";
          a.a(str2, false);
        } while (!b(paramString1, paramString2, paramString3));
        paramString1 = new File(str2);
      } while (!paramString1.exists());
      paramString2 = new File(str1);
      a.a(str1, false);
    } while ((!a.a(paramString1, paramString2)) || (!paramString2.exists()));
    return true;
  }
  
  public String c(String paramString)
  {
    if (baip.a(paramString)) {
      return "";
    }
    String str2 = a.c(paramString);
    Iterator localIterator = this.e.iterator();
    label123:
    label126:
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str1;
      if (str3.startsWith("/"))
      {
        paramString = str3.substring(1);
        str1 = paramString;
        if (paramString.endsWith("/")) {
          str1 = paramString.substring(0, paramString.length() - 1);
        }
        if (!str2.startsWith("/")) {
          break label123;
        }
      }
      for (paramString = str2.substring(1);; paramString = str2)
      {
        if (!paramString.startsWith(str1)) {
          break label126;
        }
        return str3;
        paramString = str3;
        break;
      }
    }
    return "";
  }
  
  public r d(String paramString)
  {
    paramString = a.c(paramString);
    r localr = (r)this.f.get(paramString);
    paramString = localr;
    if (localr == null) {
      paramString = this.c;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.c.c
 * JD-Core Version:    0.7.0.1
 */