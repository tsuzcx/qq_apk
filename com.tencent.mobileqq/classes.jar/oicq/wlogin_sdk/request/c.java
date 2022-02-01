package oicq.wlogin_sdk.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.report.event.a;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class c
{
  private static final Object e = new Object();
  private static final Object f = new Object();
  private static b g = null;
  private static b h = null;
  Context a;
  TreeMap<Long, WloginAllSigInfo> b = new TreeMap();
  TreeMap<String, UinInfo> c = new TreeMap();
  public int d;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.c = a(this.a, "name_file", 0L);
    if (this.c == null) {
      this.c = new TreeMap();
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 53	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_0
    //   16: aload_1
    //   17: aload 8
    //   19: invokestatic 57	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   22: aload_1
    //   23: ldc 59
    //   25: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: istore_3
    //   29: iload_3
    //   30: ifeq +53 -> 83
    //   33: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   36: ifnonnull +17 -> 53
    //   39: new 67	oicq/wlogin_sdk/request/b
    //   42: dup
    //   43: aload_0
    //   44: aload_1
    //   45: aconst_null
    //   46: iconst_1
    //   47: invokespecial 70	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   50: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   53: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   56: invokevirtual 74	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore 4
    //   61: goto +54 -> 115
    //   64: astore_0
    //   65: aconst_null
    //   66: astore 4
    //   68: aload 6
    //   70: astore 5
    //   72: goto +604 -> 676
    //   75: astore 6
    //   77: aconst_null
    //   78: astore 4
    //   80: goto +395 -> 475
    //   83: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnonnull +17 -> 107
    //   93: new 67	oicq/wlogin_sdk/request/b
    //   96: dup
    //   97: aload_0
    //   98: aload_1
    //   99: aconst_null
    //   100: iconst_1
    //   101: invokespecial 70	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   104: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   107: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   110: invokevirtual 74	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   113: astore 4
    //   115: aload 4
    //   117: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   120: iconst_1
    //   121: invokestatic 83	oicq/wlogin_sdk/request/c:b	(Ljava/lang/String;Z)V
    //   124: new 85	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   131: astore 5
    //   133: aload 5
    //   135: ldc 88
    //   137: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: aload_1
    //   144: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: ldc 94
    //   152: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: aload_1
    //   159: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 5
    //   165: ldc 96
    //   167: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 4
    //   173: aload 5
    //   175: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   181: aload 4
    //   183: astore 5
    //   185: aload 4
    //   187: aload_1
    //   188: iconst_1
    //   189: anewarray 61	java/lang/String
    //   192: dup
    //   193: iconst_0
    //   194: ldc 105
    //   196: aastore
    //   197: ldc 107
    //   199: aconst_null
    //   200: aconst_null
    //   201: aconst_null
    //   202: aconst_null
    //   203: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   206: astore 6
    //   208: aload 6
    //   210: invokeinterface 117 1 0
    //   215: ifne +77 -> 292
    //   218: new 85	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   225: astore 4
    //   227: aload 4
    //   229: ldc 119
    //   231: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 4
    //   237: aload_1
    //   238: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 4
    //   244: ldc 121
    //   246: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 4
    //   252: aload_1
    //   253: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 4
    //   259: ldc 123
    //   261: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 5
    //   267: aload 4
    //   269: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: iconst_2
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: iconst_0
    //   279: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: dup
    //   284: iconst_1
    //   285: iconst_1
    //   286: newarray byte
    //   288: aastore
    //   289: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: new 85	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   299: astore 4
    //   301: aload 4
    //   303: ldc 134
    //   305: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 4
    //   311: aload_1
    //   312: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 4
    //   318: ldc 136
    //   320: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 4
    //   326: aload_1
    //   327: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 4
    //   333: ldc 138
    //   335: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 5
    //   341: aload 4
    //   343: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: iconst_1
    //   347: anewarray 4	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: aload_2
    //   353: aastore
    //   354: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload 6
    //   359: ifnull +20 -> 379
    //   362: aload 6
    //   364: invokeinterface 142 1 0
    //   369: ifne +10 -> 379
    //   372: aload 6
    //   374: invokeinterface 145 1 0
    //   379: aload 5
    //   381: ifnull +9 -> 390
    //   384: aload 5
    //   386: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   389: pop
    //   390: aload_0
    //   391: aload_1
    //   392: invokestatic 151	oicq/wlogin_sdk/request/c:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   395: iconst_0
    //   396: ireturn
    //   397: astore_0
    //   398: aload_0
    //   399: ldc 153
    //   401: invokestatic 159	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   404: iconst_0
    //   405: ireturn
    //   406: astore_0
    //   407: aload 5
    //   409: astore 4
    //   411: aload 6
    //   413: astore 5
    //   415: goto +261 -> 676
    //   418: astore 7
    //   420: aload 5
    //   422: astore 4
    //   424: aload 6
    //   426: astore 5
    //   428: aload 7
    //   430: astore 6
    //   432: goto +43 -> 475
    //   435: astore_0
    //   436: goto +9 -> 445
    //   439: astore 5
    //   441: goto +9 -> 450
    //   444: astore_0
    //   445: goto +16 -> 461
    //   448: astore 5
    //   450: aload 5
    //   452: astore 6
    //   454: goto +18 -> 472
    //   457: astore_0
    //   458: aconst_null
    //   459: astore 4
    //   461: aconst_null
    //   462: astore 5
    //   464: goto +212 -> 676
    //   467: astore 6
    //   469: aconst_null
    //   470: astore 4
    //   472: aconst_null
    //   473: astore 5
    //   475: aload_1
    //   476: ldc 59
    //   478: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   481: ifeq +10 -> 491
    //   484: aconst_null
    //   485: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   488: goto +7 -> 495
    //   491: aconst_null
    //   492: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   495: aload 8
    //   497: ldc 161
    //   499: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   502: pop
    //   503: aload 8
    //   505: aload 6
    //   507: invokestatic 168	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   510: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   513: pop
    //   514: aload_0
    //   515: aload_1
    //   516: aload_2
    //   517: aload 8
    //   519: invokestatic 171	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;[BLjava/lang/StringBuffer;)Z
    //   522: istore_3
    //   523: goto +188 -> 711
    //   526: astore_2
    //   527: aload 8
    //   529: ldc 173
    //   531: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   534: pop
    //   535: aload 8
    //   537: aload_2
    //   538: invokestatic 168	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   541: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   544: pop
    //   545: iconst_0
    //   546: istore_3
    //   547: goto +164 -> 711
    //   550: aload_0
    //   551: aload_1
    //   552: aload 8
    //   554: aload_2
    //   555: invokestatic 176	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/lang/String;)V
    //   558: aload 6
    //   560: ldc 153
    //   562: invokestatic 159	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   565: new 85	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   572: astore_0
    //   573: aload_0
    //   574: ldc 178
    //   576: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload_0
    //   581: aload 6
    //   583: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   586: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload_0
    //   591: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: ldc 153
    //   596: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: iload_3
    //   600: ifeq +38 -> 638
    //   603: aload 5
    //   605: ifnull +20 -> 625
    //   608: aload 5
    //   610: invokeinterface 142 1 0
    //   615: ifne +10 -> 625
    //   618: aload 5
    //   620: invokeinterface 145 1 0
    //   625: aload 4
    //   627: ifnull +9 -> 636
    //   630: aload 4
    //   632: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   635: pop
    //   636: iconst_0
    //   637: ireturn
    //   638: aload 5
    //   640: ifnull +20 -> 660
    //   643: aload 5
    //   645: invokeinterface 142 1 0
    //   650: ifne +10 -> 660
    //   653: aload 5
    //   655: invokeinterface 145 1 0
    //   660: aload 4
    //   662: ifnull +9 -> 671
    //   665: aload 4
    //   667: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   670: pop
    //   671: sipush -1022
    //   674: ireturn
    //   675: astore_0
    //   676: aload 5
    //   678: ifnull +20 -> 698
    //   681: aload 5
    //   683: invokeinterface 142 1 0
    //   688: ifne +10 -> 698
    //   691: aload 5
    //   693: invokeinterface 145 1 0
    //   698: aload 4
    //   700: ifnull +9 -> 709
    //   703: aload 4
    //   705: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   708: pop
    //   709: aload_0
    //   710: athrow
    //   711: iload_3
    //   712: ifeq +9 -> 721
    //   715: ldc 187
    //   717: astore_2
    //   718: goto -168 -> 550
    //   721: ldc 189
    //   723: astore_2
    //   724: goto -174 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	paramContext	Context
    //   0	727	1	paramString	String
    //   0	727	2	paramArrayOfByte	byte[]
    //   28	684	3	bool	boolean
    //   59	645	4	localObject1	Object
    //   13	414	5	localObject2	Object
    //   439	1	5	localException1	Exception
    //   448	3	5	localException2	Exception
    //   462	230	5	localObject3	Object
    //   10	59	6	localObject4	Object
    //   75	1	6	localException3	Exception
    //   206	247	6	localObject5	Object
    //   467	115	6	localException4	Exception
    //   418	11	7	localException5	Exception
    //   7	546	8	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   33	53	64	finally
    //   53	61	64	finally
    //   93	107	64	finally
    //   33	53	75	java/lang/Exception
    //   53	61	75	java/lang/Exception
    //   93	107	75	java/lang/Exception
    //   390	395	397	java/lang/Exception
    //   208	292	406	finally
    //   292	357	406	finally
    //   208	292	418	java/lang/Exception
    //   292	357	418	java/lang/Exception
    //   185	208	435	finally
    //   185	208	439	java/lang/Exception
    //   115	181	444	finally
    //   115	181	448	java/lang/Exception
    //   15	29	457	finally
    //   83	88	457	finally
    //   107	115	457	finally
    //   15	29	467	java/lang/Exception
    //   83	88	467	java/lang/Exception
    //   107	115	467	java/lang/Exception
    //   514	523	526	java/lang/Exception
    //   475	488	675	finally
    //   491	495	675	finally
    //   495	514	675	finally
    //   514	523	675	finally
    //   527	545	675	finally
    //   550	599	675	finally
  }
  
  public static int a(Context paramContext, TreeMap paramTreeMap, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveTKTreeMap start fileName=");
    ((StringBuilder)localObject).append(paramString);
    util.LOGI(((StringBuilder)localObject).toString(), "");
    try
    {
      localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      localObjectOutputStream.writeObject(paramTreeMap);
      localObjectOutputStream.flush();
      paramTreeMap = ((ByteArrayOutputStream)localObject).toByteArray();
      int i = a(paramContext, paramString, cryptor.encrypt(paramTreeMap, 0, paramTreeMap.length, paramArrayOfByte));
      localObjectOutputStream.close();
      ((ByteArrayOutputStream)localObject).close();
      paramContext = new StringBuilder();
      paramContext.append("saveTKTreeMap end=");
      paramContext.append(paramString);
      util.LOGI(paramContext.toString(), "");
      return i;
    }
    catch (Throwable paramContext)
    {
      paramTreeMap = new StringBuilder();
      paramTreeMap.append("saveTKTreeMap failed ");
      paramTreeMap.append(paramContext.getStackTrace().toString());
      util.LOGI(paramTreeMap.toString(), "");
      util.printThrowable(paramContext, "");
    }
    return -1022;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int i = paramInt;
    while (i < paramArrayOfByte1.length - paramArrayOfByte2.length - paramInt)
    {
      int k = 0;
      int j = 0;
      while (j < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[(i + j)] != paramArrayOfByte2[j])
        {
          j = k;
          break label58;
        }
        j += 1;
      }
      j = 1;
      label58:
      if (j != 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static TreeMap a(Context paramContext, String paramString, long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("loadTKTreeMap sigfile start ");
    ((StringBuilder)localObject1).append(paramString);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = a(paramContext, paramString);
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadTKTreeMap len:");
      ((StringBuilder)localObject2).append(localObject1.length);
      ((StringBuilder)localObject2).append(" at ");
      ((StringBuilder)localObject2).append(t.m());
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      try
      {
        localObject2 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, t.C);
        if (localObject2 != null)
        {
          localObject2 = new ByteArrayInputStream((byte[])localObject2);
          localObject3 = new ObjectInputStream((InputStream)localObject2);
          localObject1 = (TreeMap)((ObjectInputStream)localObject3).readObject();
          ((ObjectInputStream)localObject3).close();
          ((ByteArrayInputStream)localObject2).close();
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("loadTKTreeMap tree size: ");
            ((StringBuilder)localObject2).append(((TreeMap)localObject1).size());
            util.LOGI(((StringBuilder)localObject2).toString(), "");
            boolean bool = "tk_file".equals(paramString);
            if (bool) {
              if (0L != paramLong) {}
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject3;
        label235:
        Object localObject4;
        StringBuilder localStringBuilder2;
        util.printThrowable(localThrowable, "");
      }
    }
    try
    {
      localObject2 = ((TreeMap)localObject1).keySet().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label696;
      }
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localObject3);
      localStringBuilder2.append(" allsig: ");
      localStringBuilder2.append(((WloginAllSigInfo)localObject4)._tk_map);
      localObject4 = localStringBuilder2.toString();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(localObject3);
      util.LOGI((String)localObject4, localStringBuilder2.toString());
      break label235;
      localObject2 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramLong);
      ((StringBuilder)localObject3).append(" allsig: ");
      ((StringBuilder)localObject3).append(((WloginAllSigInfo)localObject2)._tk_map);
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramLong);
      util.LOGI((String)localObject2, ((StringBuilder)localObject3).toString());
      return localObject1;
    }
    catch (Exception paramContext) {}
    localObject2 = ((TreeMap)localObject1).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (UinInfo)((TreeMap)localObject1).get(localObject3);
      if (localObject4 != null)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localObject3);
        localStringBuilder2.append(" is uin: ");
        localStringBuilder2.append(((UinInfo)localObject4)._uin);
        util.LOGI(localStringBuilder2.toString(), "");
      }
    }
    util.LOGI("tree is null", "");
    return null;
    localObject3 = new SecretKeySpec(t.C, "DESede");
    localObject2 = Cipher.getInstance("DESede");
    ((Cipher)localObject2).init(2, (Key)localObject3);
    localObject1 = new ByteArrayInputStream((byte[])localObject1);
    localObject2 = new ObjectInputStream(new CipherInputStream((InputStream)localObject1, (Cipher)localObject2));
    localObject3 = (TreeMap)((ObjectInputStream)localObject2).readObject();
    StringBuilder localStringBuilder1;
    if (localObject3 != null)
    {
      ((ObjectInputStream)localObject2).close();
      ((ByteArrayInputStream)localObject1).close();
      return localObject3;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("loadTKTreeMap dbdata is null at ");
      localStringBuilder1.append(t.m());
      util.LOGI(localStringBuilder1.toString(), "");
    }
    return d(paramContext, paramString);
    label696:
    return localStringBuilder1;
  }
  
  public static void a(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append("stashDbFileBefore");
    b(paramContext, paramString, paramStringBuffer);
  }
  
  public static void a(Context paramContext, String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    paramStringBuffer.append(",printDbFileWhenError");
    b(paramContext, paramString1, paramStringBuffer);
    paramContext = paramStringBuffer.toString();
    util.LOGI(paramContext, "");
    oicq.wlogin_sdk.report.event.b.a(new a("wtlogin_db_error", paramString2, paramContext).a(true).b(true));
  }
  
  public static void a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = a(paramContext, "tk_file");
    if (localObject1 != null) {}
    try
    {
      localObject1 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, paramArrayOfByte1);
      if (localObject1 != null)
      {
        localObject2 = new ByteArrayInputStream((byte[])localObject1);
        Object localObject3 = new ObjectInputStream((InputStream)localObject2);
        localObject1 = (TreeMap)((ObjectInputStream)localObject3).readObject();
        ((ObjectInputStream)localObject3).close();
        ((ByteArrayInputStream)localObject2).close();
        if (localObject1 != null)
        {
          localObject2 = ((TreeMap)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            Object localObject4 = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject3);
            localStringBuilder.append(" change guid allsig: ");
            localStringBuilder.append(((WloginAllSigInfo)localObject4)._tk_map);
            localObject4 = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(localObject3);
            util.LOGI((String)localObject4, localStringBuilder.toString());
          }
          a(paramContext, (TreeMap)localObject1, "tk_file", paramArrayOfByte2);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          paramArrayOfByte1 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, paramArrayOfByte1);
          if (paramArrayOfByte1 != null)
          {
            paramArrayOfByte1 = new ByteArrayInputStream(paramArrayOfByte1);
            localObject1 = new ObjectInputStream(paramArrayOfByte1);
            localObject2 = (TreeMap)((ObjectInputStream)localObject1).readObject();
            ((ObjectInputStream)localObject1).close();
            paramArrayOfByte1.close();
            if (localObject2 != null) {
              a(paramContext, (TreeMap)localObject2, "name_file", paramArrayOfByte2);
            }
          }
          return;
        }
        catch (Throwable paramContext) {}
        localThrowable = localThrowable;
      }
    }
    localObject1 = a(paramContext, "name_file");
    if (localObject1 != null) {}
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 391	oicq/wlogin_sdk/request/c:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aload_3
    //   7: ldc_w 393
    //   10: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   13: pop
    //   14: aload_3
    //   15: aload_0
    //   16: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   19: pop
    //   20: aload_0
    //   21: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: aload_3
    //   28: ldc_w 400
    //   31: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   34: pop
    //   35: iconst_0
    //   36: ireturn
    //   37: new 402	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 404	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 407	java/io/File:exists	()Z
    //   50: ifne +68 -> 118
    //   53: aload_0
    //   54: invokevirtual 411	java/io/File:getParentFile	()Ljava/io/File;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +38 -> 97
    //   62: aload_1
    //   63: invokevirtual 407	java/io/File:exists	()Z
    //   66: ifne +31 -> 97
    //   69: aload_1
    //   70: invokevirtual 414	java/io/File:mkdirs	()Z
    //   73: istore 4
    //   75: aload_3
    //   76: ldc_w 416
    //   79: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: aload_3
    //   84: iload 4
    //   86: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   89: pop
    //   90: iload 4
    //   92: ifne +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_0
    //   98: invokevirtual 422	java/io/File:createNewFile	()Z
    //   101: istore 4
    //   103: aload_3
    //   104: ldc_w 424
    //   107: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   110: pop
    //   111: aload_3
    //   112: iload 4
    //   114: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: aload_0
    //   119: invokevirtual 407	java/io/File:exists	()Z
    //   122: ifeq +102 -> 224
    //   125: aload_0
    //   126: invokevirtual 427	java/io/File:canWrite	()Z
    //   129: ifne +6 -> 135
    //   132: goto +92 -> 224
    //   135: new 429	java/io/FileOutputStream
    //   138: dup
    //   139: aload_0
    //   140: iconst_0
    //   141: invokespecial 432	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   144: astore 5
    //   146: aconst_null
    //   147: astore_0
    //   148: aload 5
    //   150: aload_2
    //   151: invokevirtual 435	java/io/FileOutputStream:write	([B)V
    //   154: aload 5
    //   156: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   159: aload_3
    //   160: ldc_w 438
    //   163: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   166: pop
    //   167: aload_3
    //   168: aload_2
    //   169: arraylength
    //   170: invokevirtual 441	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   173: pop
    //   174: iconst_1
    //   175: ireturn
    //   176: astore_1
    //   177: goto +8 -> 185
    //   180: astore_1
    //   181: aload_1
    //   182: astore_0
    //   183: aload_1
    //   184: athrow
    //   185: aload_0
    //   186: ifnull +11 -> 197
    //   189: aload 5
    //   191: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   194: goto +8 -> 202
    //   197: aload 5
    //   199: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   202: aload_1
    //   203: athrow
    //   204: astore_0
    //   205: aload_3
    //   206: ldc_w 443
    //   209: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: aload_3
    //   214: aload_0
    //   215: invokestatic 168	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   218: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: iconst_0
    //   223: ireturn
    //   224: aload_3
    //   225: ldc_w 445
    //   228: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   231: pop
    //   232: aload_3
    //   233: aload_0
    //   234: invokevirtual 407	java/io/File:exists	()Z
    //   237: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   240: pop
    //   241: aload_3
    //   242: ldc_w 447
    //   245: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   248: pop
    //   249: aload_3
    //   250: aload_0
    //   251: invokevirtual 427	java/io/File:canWrite	()Z
    //   254: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   257: pop
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_0
    //   261: goto -59 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   0	264	1	paramString	String
    //   0	264	2	paramArrayOfByte	byte[]
    //   0	264	3	paramStringBuffer	StringBuffer
    //   73	40	4	bool	boolean
    //   144	54	5	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   148	154	176	finally
    //   183	185	176	finally
    //   148	154	180	java/lang/Throwable
    //   135	146	204	java/lang/Exception
    //   154	159	204	java/lang/Exception
    //   189	194	204	java/lang/Exception
    //   197	202	204	java/lang/Exception
    //   202	204	204	java/lang/Exception
    //   189	194	260	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 452	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore 9
    //   6: new 53	java/lang/StringBuffer
    //   9: dup
    //   10: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 8
    //   18: aload_0
    //   19: aload_1
    //   20: aload 10
    //   22: invokestatic 57	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   25: aload_1
    //   26: ldc 59
    //   28: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +33 -> 64
    //   34: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   37: ifnonnull +17 -> 54
    //   40: new 67	oicq/wlogin_sdk/request/b
    //   43: dup
    //   44: aload_0
    //   45: aload_1
    //   46: aconst_null
    //   47: iconst_1
    //   48: invokespecial 70	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   51: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   54: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   57: invokevirtual 455	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   60: astore_3
    //   61: goto +30 -> 91
    //   64: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   67: ifnonnull +17 -> 84
    //   70: new 67	oicq/wlogin_sdk/request/b
    //   73: dup
    //   74: aload_0
    //   75: aload_1
    //   76: aconst_null
    //   77: iconst_1
    //   78: invokespecial 70	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   81: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   84: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   87: invokevirtual 455	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   90: astore_3
    //   91: aload_3
    //   92: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   95: iconst_0
    //   96: invokestatic 83	oicq/wlogin_sdk/request/c:b	(Ljava/lang/String;Z)V
    //   99: new 85	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   106: astore 4
    //   108: aload 4
    //   110: ldc_w 457
    //   113: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 4
    //   119: aload_1
    //   120: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: ldc_w 459
    //   129: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_3
    //   134: aload 4
    //   136: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aconst_null
    //   140: invokevirtual 463	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   143: astore 6
    //   145: aload 9
    //   147: astore 7
    //   149: aload_3
    //   150: astore 4
    //   152: aload 6
    //   154: astore 5
    //   156: aload 6
    //   158: invokeinterface 466 1 0
    //   163: ifeq +38 -> 201
    //   166: aload 9
    //   168: astore 7
    //   170: aload_3
    //   171: astore 4
    //   173: aload 6
    //   175: astore 5
    //   177: aload 6
    //   179: iconst_0
    //   180: invokeinterface 470 2 0
    //   185: ifle +16 -> 201
    //   188: aload_3
    //   189: astore 4
    //   191: aload 6
    //   193: astore 5
    //   195: iconst_1
    //   196: invokestatic 452	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   199: astore 7
    //   201: aload 6
    //   203: ifnull +34 -> 237
    //   206: aload_3
    //   207: astore 4
    //   209: aload 6
    //   211: astore 5
    //   213: aload 6
    //   215: invokeinterface 142 1 0
    //   220: ifne +17 -> 237
    //   223: aload_3
    //   224: astore 4
    //   226: aload 6
    //   228: astore 5
    //   230: aload 6
    //   232: invokeinterface 145 1 0
    //   237: aload_3
    //   238: astore 4
    //   240: aload 6
    //   242: astore 5
    //   244: aload 7
    //   246: invokevirtual 473	java/lang/Boolean:booleanValue	()Z
    //   249: istore_2
    //   250: iload_2
    //   251: ifne +36 -> 287
    //   254: aload 6
    //   256: ifnull +20 -> 276
    //   259: aload 6
    //   261: invokeinterface 142 1 0
    //   266: ifne +10 -> 276
    //   269: aload 6
    //   271: invokeinterface 145 1 0
    //   276: aload_3
    //   277: ifnull +8 -> 285
    //   280: aload_3
    //   281: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   284: pop
    //   285: aconst_null
    //   286: areturn
    //   287: aload_3
    //   288: astore 4
    //   290: aload 6
    //   292: astore 5
    //   294: aload_3
    //   295: aload_1
    //   296: iconst_1
    //   297: anewarray 61	java/lang/String
    //   300: dup
    //   301: iconst_0
    //   302: aload_1
    //   303: aastore
    //   304: ldc 107
    //   306: aconst_null
    //   307: aconst_null
    //   308: aconst_null
    //   309: aconst_null
    //   310: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   313: astore 7
    //   315: aload 7
    //   317: ifnonnull +36 -> 353
    //   320: aload 7
    //   322: ifnull +20 -> 342
    //   325: aload 7
    //   327: invokeinterface 142 1 0
    //   332: ifne +10 -> 342
    //   335: aload 7
    //   337: invokeinterface 145 1 0
    //   342: aload_3
    //   343: ifnull +8 -> 351
    //   346: aload_3
    //   347: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   350: pop
    //   351: aconst_null
    //   352: areturn
    //   353: aload 7
    //   355: invokeinterface 476 1 0
    //   360: ifeq +54 -> 414
    //   363: aload 7
    //   365: iconst_0
    //   366: invokeinterface 480 2 0
    //   371: astore 4
    //   373: aload 7
    //   375: invokeinterface 145 1 0
    //   380: aload 7
    //   382: ifnull +20 -> 402
    //   385: aload 7
    //   387: invokeinterface 142 1 0
    //   392: ifne +10 -> 402
    //   395: aload 7
    //   397: invokeinterface 145 1 0
    //   402: aload_3
    //   403: ifnull +8 -> 411
    //   406: aload_3
    //   407: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   410: pop
    //   411: aload 4
    //   413: areturn
    //   414: aload 7
    //   416: invokeinterface 145 1 0
    //   421: aload 7
    //   423: ifnull +20 -> 443
    //   426: aload 7
    //   428: invokeinterface 142 1 0
    //   433: ifne +10 -> 443
    //   436: aload 7
    //   438: invokeinterface 145 1 0
    //   443: aload_3
    //   444: ifnull +8 -> 452
    //   447: aload_3
    //   448: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   451: pop
    //   452: aconst_null
    //   453: areturn
    //   454: astore_0
    //   455: aload 7
    //   457: astore_1
    //   458: goto +272 -> 730
    //   461: astore 5
    //   463: aload 7
    //   465: astore 4
    //   467: goto +9 -> 476
    //   470: astore 5
    //   472: aload 6
    //   474: astore 4
    //   476: aload 5
    //   478: astore 6
    //   480: aload_3
    //   481: astore 7
    //   483: aload 4
    //   485: astore_3
    //   486: goto +39 -> 525
    //   489: astore_0
    //   490: aconst_null
    //   491: astore_1
    //   492: goto +238 -> 730
    //   495: astore 6
    //   497: aconst_null
    //   498: astore 4
    //   500: aload_3
    //   501: astore 7
    //   503: aload 4
    //   505: astore_3
    //   506: goto +19 -> 525
    //   509: astore_0
    //   510: aconst_null
    //   511: astore_3
    //   512: aload_3
    //   513: astore_1
    //   514: goto +216 -> 730
    //   517: astore 6
    //   519: aconst_null
    //   520: astore 7
    //   522: aload 7
    //   524: astore_3
    //   525: aload 7
    //   527: astore 4
    //   529: aload_3
    //   530: astore 5
    //   532: aload_1
    //   533: ldc 59
    //   535: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   538: ifeq +17 -> 555
    //   541: aload 7
    //   543: astore 4
    //   545: aload_3
    //   546: astore 5
    //   548: aconst_null
    //   549: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   552: goto +14 -> 566
    //   555: aload 7
    //   557: astore 4
    //   559: aload_3
    //   560: astore 5
    //   562: aconst_null
    //   563: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   566: aload 7
    //   568: astore 4
    //   570: aload_3
    //   571: astore 5
    //   573: aload 10
    //   575: ldc 161
    //   577: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   580: pop
    //   581: aload 7
    //   583: astore 4
    //   585: aload_3
    //   586: astore 5
    //   588: aload 10
    //   590: aload 6
    //   592: invokestatic 168	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   595: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   598: pop
    //   599: aload 7
    //   601: astore 4
    //   603: aload_3
    //   604: astore 5
    //   606: aload_0
    //   607: aload_1
    //   608: aload 10
    //   610: invokestatic 483	oicq/wlogin_sdk/request/c:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)[B
    //   613: astore 9
    //   615: aload 9
    //   617: astore 8
    //   619: goto +141 -> 760
    //   622: astore 9
    //   624: aload 7
    //   626: astore 4
    //   628: aload_3
    //   629: astore 5
    //   631: aload 10
    //   633: ldc 173
    //   635: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   638: pop
    //   639: aload 7
    //   641: astore 4
    //   643: aload_3
    //   644: astore 5
    //   646: aload 10
    //   648: aload 9
    //   650: invokestatic 168	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   653: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   656: pop
    //   657: goto +103 -> 760
    //   660: aload 7
    //   662: astore 4
    //   664: aload_3
    //   665: astore 5
    //   667: aload_0
    //   668: aload_1
    //   669: aload 10
    //   671: aload 9
    //   673: invokestatic 176	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/lang/String;)V
    //   676: aload 7
    //   678: astore 4
    //   680: aload_3
    //   681: astore 5
    //   683: aload 6
    //   685: ldc 153
    //   687: invokestatic 159	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   690: aload_3
    //   691: ifnull +18 -> 709
    //   694: aload_3
    //   695: invokeinterface 142 1 0
    //   700: ifne +9 -> 709
    //   703: aload_3
    //   704: invokeinterface 145 1 0
    //   709: aload 7
    //   711: ifnull +9 -> 720
    //   714: aload 7
    //   716: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   719: pop
    //   720: aload 8
    //   722: areturn
    //   723: astore_0
    //   724: aload 5
    //   726: astore_1
    //   727: aload 4
    //   729: astore_3
    //   730: aload_1
    //   731: ifnull +18 -> 749
    //   734: aload_1
    //   735: invokeinterface 142 1 0
    //   740: ifne +9 -> 749
    //   743: aload_1
    //   744: invokeinterface 145 1 0
    //   749: aload_3
    //   750: ifnull +8 -> 758
    //   753: aload_3
    //   754: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   757: pop
    //   758: aload_0
    //   759: athrow
    //   760: aload 8
    //   762: ifnull +11 -> 773
    //   765: ldc_w 485
    //   768: astore 9
    //   770: goto -110 -> 660
    //   773: ldc_w 487
    //   776: astore 9
    //   778: goto -118 -> 660
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	paramContext	Context
    //   0	781	1	paramString	String
    //   249	2	2	bool	boolean
    //   60	694	3	localObject1	Object
    //   106	622	4	localObject2	Object
    //   154	139	5	localObject3	Object
    //   461	1	5	localException1	Exception
    //   470	7	5	localException2	Exception
    //   530	195	5	localObject4	Object
    //   143	336	6	localObject5	Object
    //   495	1	6	localException3	Exception
    //   517	167	6	localException4	Exception
    //   147	568	7	localObject6	Object
    //   16	745	8	localObject7	Object
    //   4	612	9	localObject8	Object
    //   622	50	9	localException5	Exception
    //   768	9	9	str	String
    //   13	657	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   353	380	454	finally
    //   414	421	454	finally
    //   353	380	461	java/lang/Exception
    //   414	421	461	java/lang/Exception
    //   156	166	470	java/lang/Exception
    //   177	188	470	java/lang/Exception
    //   195	201	470	java/lang/Exception
    //   213	223	470	java/lang/Exception
    //   230	237	470	java/lang/Exception
    //   244	250	470	java/lang/Exception
    //   294	315	470	java/lang/Exception
    //   91	145	489	finally
    //   91	145	495	java/lang/Exception
    //   18	54	509	finally
    //   54	61	509	finally
    //   64	84	509	finally
    //   84	91	509	finally
    //   18	54	517	java/lang/Exception
    //   54	61	517	java/lang/Exception
    //   64	84	517	java/lang/Exception
    //   84	91	517	java/lang/Exception
    //   606	615	622	java/lang/Exception
    //   156	166	723	finally
    //   177	188	723	finally
    //   195	201	723	finally
    //   213	223	723	finally
    //   230	237	723	finally
    //   244	250	723	finally
    //   294	315	723	finally
    //   532	541	723	finally
    //   548	552	723	finally
    //   562	566	723	finally
    //   573	581	723	finally
    //   588	599	723	finally
    //   606	615	723	finally
    //   631	639	723	finally
    //   646	657	723	finally
    //   667	676	723	finally
    //   683	690	723	finally
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = c(paramContext, paramString);
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    paramContext = new File(paramContext);
    if (paramContext.exists())
    {
      boolean bool = paramContext.delete();
      paramContext = new StringBuilder();
      paramContext.append("delSigFile result = ");
      paramContext.append(bool);
      util.LOGI(paramContext.toString(), "");
    }
  }
  
  public static void b(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    try
    {
      paramStringBuffer.append(",table=");
      paramStringBuffer.append(paramString);
      paramContext = paramContext.getDatabasePath(paramString);
      paramStringBuffer.append(",file=");
      paramStringBuffer.append(paramContext.getAbsolutePath());
      paramStringBuffer.append(",isExists=");
      paramStringBuffer.append(paramContext.exists());
      paramStringBuffer.append(",canRead=");
      paramStringBuffer.append(paramContext.canRead());
      paramStringBuffer.append(",canWrite=");
      paramStringBuffer.append(paramContext.canWrite());
      paramStringBuffer.append(",canExecute=");
      paramStringBuffer.append(paramContext.canExecute());
      paramStringBuffer.append(",lastModified=");
      paramStringBuffer.append(paramContext.lastModified());
      paramContext = paramContext.getParentFile();
      paramStringBuffer.append(",isParentExists=");
      paramStringBuffer.append(paramContext.exists());
      return;
    }
    catch (Exception paramContext)
    {
      paramStringBuffer.append(",exception=");
      paramStringBuffer.append(util.getThrowableInfo(paramContext));
    }
  }
  
  private static void b(String paramString, boolean paramBoolean)
  {
    long l = new File(paramString).lastModified();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" last update time ");
    localStringBuilder.append(l);
    localStringBuilder.append(",beforeWrite=");
    localStringBuilder.append(paramBoolean);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public static String c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getFilesDir();
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("wtlogin");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static byte[] c(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 391	oicq/wlogin_sdk/request/c:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aload_2
    //   7: ldc_w 552
    //   10: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   13: pop
    //   14: aload_2
    //   15: aload_0
    //   16: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   19: pop
    //   20: aload_0
    //   21: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: aload_2
    //   28: ldc_w 400
    //   31: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   34: pop
    //   35: aconst_null
    //   36: areturn
    //   37: new 402	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 404	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 407	java/io/File:exists	()Z
    //   50: ifeq +120 -> 170
    //   53: aload_0
    //   54: invokevirtual 515	java/io/File:canRead	()Z
    //   57: ifne +6 -> 63
    //   60: goto +110 -> 170
    //   63: new 554	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 557	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual 560	java/io/FileInputStream:available	()I
    //   76: newarray byte
    //   78: astore_1
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 564	java/io/FileInputStream:read	([B)I
    //   84: pop
    //   85: aload_3
    //   86: invokevirtual 565	java/io/FileInputStream:close	()V
    //   89: aload_2
    //   90: ldc_w 567
    //   93: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   96: pop
    //   97: aload_2
    //   98: aload_1
    //   99: arraylength
    //   100: invokevirtual 441	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 524
    //   108: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   111: pop
    //   112: aload_2
    //   113: aload_0
    //   114: invokevirtual 528	java/io/File:lastModified	()J
    //   117: invokevirtual 531	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   120: pop
    //   121: aload_1
    //   122: areturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: goto +7 -> 133
    //   129: astore_0
    //   130: aload_0
    //   131: athrow
    //   132: astore_1
    //   133: aload_0
    //   134: ifnull +10 -> 144
    //   137: aload_3
    //   138: invokevirtual 565	java/io/FileInputStream:close	()V
    //   141: goto +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 565	java/io/FileInputStream:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_0
    //   151: aload_2
    //   152: ldc_w 569
    //   155: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: aload_2
    //   160: aload_0
    //   161: invokestatic 168	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   164: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   167: pop
    //   168: aconst_null
    //   169: areturn
    //   170: aload_2
    //   171: ldc_w 445
    //   174: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   177: pop
    //   178: aload_2
    //   179: aload_0
    //   180: invokevirtual 407	java/io/File:exists	()Z
    //   183: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   186: pop
    //   187: aload_2
    //   188: ldc_w 571
    //   191: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   194: pop
    //   195: aload_2
    //   196: aload_0
    //   197: invokevirtual 515	java/io/File:canRead	()Z
    //   200: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   203: pop
    //   204: aconst_null
    //   205: areturn
    //   206: astore_0
    //   207: goto -59 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramContext	Context
    //   0	210	1	paramString	String
    //   0	210	2	paramStringBuffer	StringBuffer
    //   71	74	3	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   72	85	123	finally
    //   72	85	129	java/lang/Throwable
    //   130	132	132	finally
    //   63	72	150	java/lang/Exception
    //   85	89	150	java/lang/Exception
    //   137	141	150	java/lang/Exception
    //   144	148	150	java/lang/Exception
    //   148	150	150	java/lang/Exception
    //   137	141	206	java/lang/Throwable
  }
  
  private static TreeMap d(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.C, "DESede");
      localObject2 = Cipher.getInstance("DESede");
      ((Cipher)localObject2).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject2));
      try
      {
        localObject2 = (TreeMap)((ObjectInputStream)localObject1).readObject();
        paramString = (String)localObject2;
      }
      catch (Throwable localThrowable3)
      {
        localObject2 = localObject1;
      }
      if ((localThrowable4 instanceof FileNotFoundException)) {}
    }
    catch (Throwable localThrowable4)
    {
      localObject2 = null;
    }
    try
    {
      localObject1 = new byte[256];
      localObject3 = paramContext.openFileInput(paramString);
      for (;;)
      {
        i = ((FileInputStream)localObject3).read((byte[])localObject1, 0, localObject1.length);
        if (i <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string((byte[])localObject1, i));
      }
      ((FileInputStream)localObject3).close();
    }
    catch (Exception localException1)
    {
      Object localObject3;
      int i;
      label139:
      label219:
      break label139;
    }
    try
    {
      localObject1 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
      localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject3));
    }
    catch (Throwable localThrowable1)
    {
      break label223;
    }
    try
    {
      localObject2 = (TreeMap)((ObjectInputStream)localObject1).readObject();
      paramString = (String)localObject2;
    }
    catch (Throwable localThrowable2)
    {
      break label219;
    }
    Object localObject2 = localObject1;
    label223:
    Object localObject1 = localObject2;
    try
    {
      localObject3 = new byte[256];
      localObject1 = localObject2;
      i = localObject3.length - 40;
      localObject1 = localObject2;
      localFileInputStream = paramContext.openFileInput(paramString);
      localObject1 = localObject2;
      localFileOutputStream = paramContext.openFileOutput("tmp_tk_file", 0);
      paramString = (String)localObject2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        FileInputStream localFileInputStream;
        FileOutputStream localFileOutputStream;
        int m;
        int k;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        continue;
        int j = 0;
        continue;
        continue;
        String str = paramString;
        j = 0;
        continue;
        j = 0;
        continue;
        continue;
        j = 0;
        continue;
        continue;
        paramString = str;
      }
    }
    localObject1 = paramString;
    m = localFileInputStream.read((byte[])localObject3, 40, i);
    if (m > 0)
    {
      j = 40 + m;
      for (;;)
      {
        localObject1 = paramString;
        if (j >= localObject3.length) {
          break;
        }
        localObject3[j] = 0;
        j += 1;
      }
      if (j < 0) {
        break label1461;
      }
      localObject1 = paramString;
      localObject2 = new String("WloginAllSigInfo").getBytes();
      localObject1 = paramString;
      j = a((byte[])localObject3, j, (byte[])localObject2);
      if (j < 0) {
        break label1461;
      }
      localObject1 = paramString;
      j += localObject2.length;
      localObject1 = paramString;
      if (j + 8 <= localObject3.length)
      {
        k = j + 0;
        if (localObject3[k] == -127)
        {
          n = j + 1;
          if (localObject3[n] == 64)
          {
            i1 = j + 2;
            if (localObject3[i1] == 1)
            {
              i2 = j + 3;
              if (localObject3[i2] == 111)
              {
                i3 = j + 4;
                if (localObject3[i3] == -111)
                {
                  i4 = j + 5;
                  if (localObject3[i4] == -44)
                  {
                    i5 = j + 6;
                    i6 = localObject3[i5];
                    if (i6 == 26)
                    {
                      i6 = j + 7;
                      if (localObject3[i6] == -101)
                      {
                        localObject3[k] = 0;
                        localObject3[n] = 0;
                        localObject3[i1] = 0;
                        localObject3[i2] = 0;
                        localObject3[i3] = 0;
                        localObject3[i4] = 0;
                        localObject3[i5] = 0;
                        localObject3[i6] = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    else
    {
      for (;;)
      {
        if (j < 0) {
          break label1469;
        }
        paramString = (String)localObject1;
        label1423:
        try
        {
          localObject2 = new String("WloginSigInfo").getBytes();
          paramString = (String)localObject1;
          j = a((byte[])localObject3, j, (byte[])localObject2);
          if (j < 0) {
            break label1469;
          }
          paramString = (String)localObject1;
          k = j + localObject2.length;
          j = k;
          paramString = (String)localObject1;
          if (k + 8 <= localObject3.length)
          {
            n = k + 0;
            j = k;
            if (localObject3[n] == 0)
            {
              i1 = k + 1;
              j = k;
              if (localObject3[i1] == 0)
              {
                i2 = k + 2;
                j = k;
                if (localObject3[i2] == 0)
                {
                  i3 = k + 3;
                  j = k;
                  if (localObject3[i3] == 0)
                  {
                    i4 = k + 4;
                    j = k;
                    if (localObject3[i4] == 0)
                    {
                      i5 = k + 5;
                      j = k;
                      if (localObject3[i5] == 0)
                      {
                        i6 = k + 6;
                        j = k;
                        if (localObject3[i6] == 0)
                        {
                          int i7 = k + 7;
                          j = k;
                          if (localObject3[i7] == 0)
                          {
                            localObject3[n] = 0;
                            localObject3[i1] = 0;
                            localObject3[i2] = 0;
                            localObject3[i3] = 0;
                            localObject3[i4] = 0;
                            localObject3[i5] = 0;
                            localObject3[i6] = 0;
                            localObject3[i7] = 1;
                            j = k;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        catch (Exception localException2)
        {
          label1392:
          label1401:
          break label1392;
        }
      }
      if (j < 0) {
        break label1477;
      }
      paramString = (String)localObject1;
      localObject2 = new String("WloginSimpleInfo").getBytes();
      paramString = (String)localObject1;
      j = a((byte[])localObject3, j, (byte[])localObject2);
      if (j < 0) {
        break label1477;
      }
      paramString = (String)localObject1;
      j += localObject2.length;
      paramString = (String)localObject1;
      if (j + 8 > localObject3.length) {
        break label1474;
      }
      k = j + 0;
      if (localObject3[k] != 57) {
        break label1474;
      }
      n = j + 1;
      if (localObject3[n] != -69) {
        break label1474;
      }
      i1 = j + 2;
      if (localObject3[i1] != -84) {
        break label1474;
      }
      i2 = j + 3;
      if (localObject3[i2] != 110) {
        break label1474;
      }
      i3 = j + 4;
      if (localObject3[i3] != -46) {
        break label1474;
      }
      i4 = j + 5;
      if (localObject3[i4] != 98) {
        break label1474;
      }
      i5 = j + 6;
      if (localObject3[i5] != -31) {
        break label1474;
      }
      i6 = j + 7;
      if (localObject3[i6] != -113) {
        break label1474;
      }
      localObject3[k] = 0;
      localObject3[n] = 0;
      localObject3[i1] = 0;
      localObject3[i2] = 0;
      localObject3[i3] = 0;
      localObject3[i4] = 0;
      localObject3[i5] = 0;
      localObject3[i6] = 1;
      break label1474;
      if (j >= 0)
      {
        paramString = (String)localObject1;
        localObject2 = new String("UinInfo").getBytes();
        paramString = (String)localObject1;
        j = a((byte[])localObject3, j, (byte[])localObject2);
        if (j >= 0)
        {
          paramString = (String)localObject1;
          j += localObject2.length;
          paramString = (String)localObject1;
          if (j + 8 > localObject3.length) {
            break label1482;
          }
          k = j + 0;
          if (localObject3[k] != -118) {
            break label1482;
          }
          n = j + 1;
          if (localObject3[n] != -23) {
            break label1482;
          }
          i1 = j + 2;
          if (localObject3[i1] != -128) {
            break label1482;
          }
          i2 = j + 3;
          if (localObject3[i2] != -19) {
            break label1482;
          }
          i3 = j + 4;
          if (localObject3[i3] != -26) {
            break label1482;
          }
          i4 = j + 5;
          if (localObject3[i4] != 99) {
            break label1482;
          }
          i5 = j + 6;
          if (localObject3[i5] != 41) {
            break label1482;
          }
          i6 = j + 7;
          if (localObject3[i6] != 14) {
            break label1482;
          }
          localObject3[k] = 0;
          localObject3[n] = 0;
          localObject3[i1] = 0;
          localObject3[i2] = 0;
          localObject3[i3] = 0;
          localObject3[i4] = 0;
          localObject3[i5] = 0;
          localObject3[i6] = 1;
          break label1482;
        }
      }
      paramString = (String)localObject1;
      localFileOutputStream.write((byte[])localObject3, 40, m);
      if (m <= 40) {
        break label1485;
      }
      paramString = (String)localObject1;
      System.arraycopy(localObject3, m, localObject3, 0, 40);
      break label1485;
      localObject1 = paramString;
      paramString = (String)localObject1;
      localFileInputStream.close();
      paramString = (String)localObject1;
      localFileOutputStream.close();
      paramString = (String)localObject1;
      localObject2 = new ObjectInputStream(paramContext.openFileInput("tmp_tk_file"));
      localObject1 = localObject2;
      paramString = (TreeMap)((ObjectInputStream)localObject2).readObject();
      localObject1 = localObject2;
      break label1401;
      paramString = (String)localObject1;
      localObject2 = null;
      localObject1 = paramString;
      paramString = (String)localObject2;
      paramContext.deleteFile("tmp_tk_file");
      if (paramString != null) {}
      try
      {
        ((ObjectInputStream)localObject1).close();
        return paramString;
      }
      catch (Exception paramContext)
      {
        break label1423;
      }
      return null;
    }
  }
  
  public int a(long paramLong1, long paramLong2)
  {
    try
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start clear_da2 ");
      ((StringBuilder)???).append(paramLong2);
      ??? = ((StringBuilder)???).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramLong1);
      util.LOGI((String)???, ((StringBuilder)localObject3).toString());
      ??? = this.a;
      int i = 0;
      int j = 0;
      if (??? != null) {
        synchronized (e)
        {
          localObject3 = a(this.a, "tk_file", paramLong1);
          i = j;
          if (localObject3 != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject3).get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return -1;
            }
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("");
            localStringBuilder2.append(paramLong1);
            util.LOGI("clear_da2 clear DA2 in file", localStringBuilder2.toString());
            localWloginAllSigInfo.put_da2(paramLong2, new byte[0]);
            i = a((TreeMap)localObject3, "tk_file");
            this.b = ((TreeMap)localObject3);
          }
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("end clear_da2 ret ");
      ((StringBuilder)???).append(i);
      ??? = ((StringBuilder)???).toString();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("");
      localStringBuilder1.append(paramLong1);
      util.LOGI((String)???, localStringBuilder1.toString());
      return i;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start put_siginfo ");
      ((StringBuilder)localObject1).append(paramLong2);
      localObject1 = ((StringBuilder)localObject1).toString();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("");
      ((StringBuilder)???).append(paramLong1);
      util.LOGI((String)localObject1, ((StringBuilder)???).toString());
      localObject1 = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong1));
      if (localObject1 == null) {
        return -1;
      }
      int i = ((WloginAllSigInfo)localObject1).put_siginfo(paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
      if (this.a != null) {
        synchronized (e)
        {
          paramArrayOfByte2 = a(this.a, "tk_file", paramLong1);
          paramArrayOfByte1 = paramArrayOfByte2;
          if (paramArrayOfByte2 == null) {
            paramArrayOfByte1 = new TreeMap();
          }
          paramArrayOfByte1.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
          a(paramArrayOfByte1, "tk_file");
        }
      }
      return i;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] arg5, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start put_siginfo skey ");
        ((StringBuilder)localObject1).append(util.getMaskBytes(paramArrayOfByte10, 2, 2));
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramLong1);
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        if (this.a == null) {
          continue;
        }
      }
      finally
      {
        Object localObject1;
        Object localObject2;
        Object localObject7;
        Object localObject3;
        Object localObject14;
        Object localObject13;
        Object localObject12;
        Object localObject11;
        Object localObject8;
        Object localObject9;
        Object localObject10;
        WloginSigInfo localWloginSigInfo;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        continue;
        throw ???;
        continue;
        continue;
        continue;
      }
      synchronized (e)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramLong1);
        util.LOGI("put_siginfo load file", ((StringBuilder)localObject1).toString());
        localObject1 = a(this.a, "tk_file", paramLong1);
        localObject7 = localObject1;
        if (localObject1 == null) {
          localObject7 = new TreeMap();
        }
        localObject2 = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong1));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = (WloginAllSigInfo)((TreeMap)localObject7).get(Long.valueOf(paramLong1));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new WloginAllSigInfo();
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("put_siginfo mainSigMap 0x");
        ((StringBuilder)localObject2).append(Integer.toHexString(this.d));
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramLong1);
        util.LOGI((String)localObject2, ((StringBuilder)localObject3).toString());
        ((WloginAllSigInfo)localObject1).mainSigMap = this.d;
        localObject14 = new byte[0];
        localObject13 = new byte[0];
        localObject12 = new byte[0];
        localObject11 = new byte[0];
        localObject8 = new byte[0];
        localObject9 = new byte[0];
        localObject2 = ((WloginAllSigInfo)localObject1)._tk_map;
        localObject10 = new byte[0];
        localWloginSigInfo = (WloginSigInfo)((TreeMap)localObject2).get(Long.valueOf(paramLong2));
        localObject2 = localObject14;
        localObject3 = localObject13;
        localObject4 = localObject12;
        localObject5 = localObject11;
        localObject6 = localObject8;
        if (localWloginSigInfo != null)
        {
          localObject2 = localObject14;
          localObject3 = localObject13;
          if (localWloginSigInfo._en_A1 != null)
          {
            localObject4 = (byte[])localWloginSigInfo._en_A1.clone();
            localObject2 = localObject4;
            localObject3 = localObject13;
            if (localWloginSigInfo._noPicSig != null)
            {
              localObject3 = (byte[])localWloginSigInfo._noPicSig.clone();
              localObject2 = localObject4;
            }
          }
          localObject4 = localObject12;
          if (localWloginSigInfo._G != null) {
            localObject4 = (byte[])localWloginSigInfo._G.clone();
          }
          localObject5 = localObject11;
          if (localWloginSigInfo._dpwd != null) {
            localObject5 = (byte[])localWloginSigInfo._dpwd.clone();
          }
          localObject6 = localObject8;
          if (localWloginSigInfo._randseed != null) {
            localObject6 = (byte[])localWloginSigInfo._randseed.clone();
          }
          localObject9 = localWloginSigInfo._psKey;
          localObject10 = localWloginSigInfo._pt4Token;
        }
        if ((paramArrayOfByte14[6] != null) && (paramArrayOfByte14[6].length > 2))
        {
          localObject11 = new HashMap();
          localObject12 = new HashMap();
          localObject8 = new HashMap();
          localObject13 = new HashMap();
          Ticket.parsePsBuf((byte[])localObject9, paramLong5, (Map)localObject11, (Map)localObject12, true);
          Ticket.parsePsBuf((byte[])localObject10, paramLong5, (Map)localObject8, (Map)localObject13, false);
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append("put_siginfo current pskey size:");
          ((StringBuilder)localObject9).append(((Map)localObject11).size());
          ((StringBuilder)localObject9).append(":");
          ((StringBuilder)localObject9).append(((Map)localObject12).size());
          util.LOGI(((StringBuilder)localObject9).toString(), "");
          localObject9 = ((Map)localObject12).entrySet().iterator();
          if (((Iterator)localObject9).hasNext())
          {
            localObject14 = (Map.Entry)((Iterator)localObject9).next();
            localObject10 = (String)((Map.Entry)localObject14).getKey();
            if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject14).getValue()).longValue())) {
              continue;
            }
            ((Iterator)localObject9).remove();
            ((Map)localObject11).remove(localObject10);
            localObject14 = new StringBuilder();
            ((StringBuilder)localObject14).append("put_siginfo delete expired pskey from file,key:");
            ((StringBuilder)localObject14).append((String)localObject10);
            util.LOGI(((StringBuilder)localObject14).toString(), "");
            continue;
          }
          localObject9 = ((Map)localObject13).entrySet().iterator();
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("put_siginfo current pt4token size:");
          ((StringBuilder)localObject10).append(((Map)localObject8).size());
          ((StringBuilder)localObject10).append(":");
          ((StringBuilder)localObject10).append(((Map)localObject13).size());
          util.LOGI(((StringBuilder)localObject10).toString(), "");
          if (((Iterator)localObject9).hasNext())
          {
            localObject14 = (Map.Entry)((Iterator)localObject9).next();
            localObject10 = (String)((Map.Entry)localObject14).getKey();
            if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject14).getValue()).longValue())) {
              continue;
            }
            ((Iterator)localObject9).remove();
            ((Map)localObject8).remove(localObject10);
            localObject14 = new StringBuilder();
            ((StringBuilder)localObject14).append("put_siginfo delete expired pt4token from file,key:");
            ((StringBuilder)localObject14).append((String)localObject10);
            util.LOGI(((StringBuilder)localObject14).toString(), "");
            continue;
          }
          Ticket.parseSvrPs(paramArrayOfByte14[6], paramLong5, (Map)localObject11, (Map)localObject12, (Map)localObject8, (Map)localObject13);
          try
          {
            paramArrayOfByte14[6] = Ticket.packPsBuf((Map)localObject11, paramLong5, (Map)localObject12);
            paramArrayOfByte14[12] = Ticket.packPsBuf((Map)localObject8, paramLong5, (Map)localObject13);
          }
          catch (Exception ???)
          {
            util.printException(???, String.valueOf(paramLong1));
            oicq.wlogin_sdk.report.event.b.a(new a("wtlogin_alarm", "pskey_other_exception", Log.getStackTraceString(???)).a(String.valueOf(paramLong1)).a(true).b(true));
            return -2006;
          }
          catch (BufferOverflowException ???)
          {
            paramWloginSimpleInfo = new StringBuilder();
            paramWloginSimpleInfo.append("map size ");
            paramWloginSimpleInfo.append(((Map)localObject11).size());
            paramWloginSimpleInfo.append("is too large");
            util.LOGI(paramWloginSimpleInfo.toString(), String.valueOf(paramLong1));
            oicq.wlogin_sdk.report.event.b.a(new a("wtlogin_alarm", "pskey_buffer_overflow", Log.getStackTraceString(???)).a(String.valueOf(paramLong1)).a(true).b(true));
            return -1023;
          }
        }
        ((WloginAllSigInfo)localObject1).put_simpleinfo(paramWloginSimpleInfo);
        ((WloginAllSigInfo)localObject1).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
        if ((??? != null) && (???[0] != null) && (???[0].length > 0))
        {
          paramWloginSimpleInfo = new StringBuilder();
          paramWloginSimpleInfo.append("A1_INFO: update A1 form ser : ");
          paramWloginSimpleInfo.append(MD5.getMD5String(???[0]));
          paramWloginSimpleInfo = paramWloginSimpleInfo.toString();
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("");
          paramArrayOfByte2.append(paramLong1);
          util.LOGI(paramWloginSimpleInfo, paramArrayOfByte2.toString());
        }
        ((WloginAllSigInfo)localObject1).put_siginfo(paramLong2, ???, paramLong5);
        ((TreeMap)localObject7).put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
        synchronized (e)
        {
          paramInt = a((TreeMap)localObject7, "tk_file");
          paramWloginSimpleInfo = new StringBuilder();
          paramWloginSimpleInfo.append("put_siginfo save key result:tk_file:");
          paramWloginSimpleInfo.append(paramInt);
          util.LOGI(paramWloginSimpleInfo.toString(), "");
          if (paramInt == 0) {
            continue;
          }
          ??? = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
          if (??? != null)
          {
            ???._en_A1 = ((byte[])((byte[])localObject2).clone());
            ???._noPicSig = ((byte[])((byte[])localObject3).clone());
            ???._G = ((byte[])((byte[])localObject4).clone());
            ???._dpwd = ((byte[])((byte[])localObject5).clone());
            ???._randseed = ((byte[])((byte[])localObject6).clone());
          }
          ??? = new StringBuilder();
          ???.append("");
          ???.append(paramLong1);
          util.LOGI("put_siginfo sig in memory changed", ???.toString());
          this.b.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
        }
      }
    }
    paramInt = 0;
    return paramInt;
  }
  
  public int a(TreeMap paramTreeMap, String paramString)
  {
    int i = 0;
    try
    {
      if (("tk_file".equals(paramString)) || ("name_file".equals(paramString))) {
        i = b(paramTreeMap, paramString);
      }
      return i;
    }
    finally {}
  }
  
  public String a(Long paramLong)
  {
    try
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        UinInfo localUinInfo = (UinInfo)this.c.get(str);
        if (localUinInfo != null)
        {
          boolean bool = localUinInfo._uin.equals(paramLong);
          if (bool) {
            return str;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramLong;
    }
  }
  
  public List<WloginLoginInfo> a(boolean paramBoolean)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.a != null)
      {
        Object localObject6 = a(this.a, "tk_file", 0L);
        if (localObject6 == null) {
          return localArrayList;
        }
        Object localObject5 = ((TreeMap)localObject6).keySet().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          Long localLong1 = (Long)((Iterator)localObject5).next();
          Object localObject3 = (WloginAllSigInfo)this.b.get(localLong1);
          Object localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = (WloginAllSigInfo)((TreeMap)localObject6).get(localLong1);
            if (localObject1 != null) {
              this.b.put(localLong1, localObject1);
            }
          }
          else
          {
            Iterator localIterator = ((WloginAllSigInfo)localObject1)._tk_map.keySet().iterator();
            Object localObject4 = localObject5;
            localObject3 = localObject6;
            for (;;)
            {
              localObject6 = localObject3;
              localObject5 = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              Long localLong2 = (Long)localIterator.next();
              WloginSigInfo localWloginSigInfo = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(localLong2);
              if (localWloginSigInfo != null)
              {
                localObject6 = a(localLong1);
                localObject5 = localObject6;
                if (localObject6 == null) {
                  localObject5 = String.valueOf(localLong1);
                }
                if (((WloginAllSigInfo)localObject1)._useInfo == null)
                {
                  util.LOGI("get_all_logined_account useInfo is null");
                }
                else
                {
                  if (((WloginAllSigInfo)localObject1)._useInfo._img_url == null) {
                    ((WloginAllSigInfo)localObject1)._useInfo._img_url = new byte[0];
                  }
                  long l1 = localLong1.longValue();
                  long l2 = localLong2.longValue();
                  localObject6 = new String(((WloginAllSigInfo)localObject1)._useInfo._img_url);
                  long l3 = localWloginSigInfo._create_time;
                  int i;
                  if (paramBoolean) {
                    i = WloginLoginInfo.TYPE_LOACL;
                  } else {
                    i = WloginLoginInfo.TYPE_REMOTE;
                  }
                  localArrayList.add(new WloginLoginInfo((String)localObject5, l1, l2, (String)localObject6, l3, i, localWloginSigInfo._login_bitmap));
                }
              }
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public UinInfo a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = (UinInfo)this.c.get(paramString);
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mem got_account name: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" uin: ");
        localStringBuilder.append(((UinInfo)localObject)._uin);
        localStringBuilder.append(", ");
        localStringBuilder.append(((UinInfo)localObject).getHasPassword());
        util.LOGI(localStringBuilder.toString(), "");
        return localObject;
      }
      localObject = this.a;
      if (localObject == null) {
        return null;
      }
      localObject = a(this.a, "name_file", 0L);
      if (localObject == null) {
        return null;
      }
      localObject = (UinInfo)((TreeMap)localObject).get(paramString);
      if (localObject == null) {
        return null;
      }
      this.c.put(paramString, localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file got_account name: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" uin: ");
      localStringBuilder.append(((UinInfo)localObject)._uin);
      localStringBuilder.append(", ");
      localStringBuilder.append(((UinInfo)localObject).getHasPassword());
      util.LOGI(localStringBuilder.toString(), "");
      return localObject;
    }
    finally {}
  }
  
  public WloginAllSigInfo a(long paramLong)
  {
    try
    {
      Object localObject1 = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        util.LOGI("get_all_siginfo in mem", "");
        return localObject1;
      }
      localObject1 = this.a;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = a(this.a, "tk_file", paramLong);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong));
      if (localObject1 == null) {
        return null;
      }
      util.LOGI("got in file", "");
      this.b.put(Long.valueOf(paramLong), localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      util.LOGI("refresh_all_siginfo ...", "");
      this.b = a(this.a, "tk_file", 0L);
      if (this.b == null) {
        this.b = new TreeMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    try
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start put_randseed ");
      ((StringBuilder)???).append(paramLong2);
      ??? = ((StringBuilder)???).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramLong1);
      util.LOGI((String)???, ((StringBuilder)localObject2).toString());
      if (this.a != null) {
        synchronized (e)
        {
          localObject2 = a(this.a, "tk_file", paramLong1);
          if (localObject2 != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject2).get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null)
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("fileInfo is null ");
              paramArrayOfByte.append(paramLong2);
              paramArrayOfByte = paramArrayOfByte.toString();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("");
              ((StringBuilder)localObject2).append(paramLong1);
              util.LOGI(paramArrayOfByte, ((StringBuilder)localObject2).toString());
              return;
            }
            localWloginAllSigInfo.put_randseed(paramLong2, paramArrayOfByte);
            int i = a((TreeMap)localObject2, "tk_file");
            if (i != 0)
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("put_randseed refreshTKTreeMap failed ret ");
              paramArrayOfByte.append(i);
              paramArrayOfByte.append(" appid ");
              paramArrayOfByte.append(paramLong2);
              paramArrayOfByte = paramArrayOfByte.toString();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("");
              ((StringBuilder)localObject2).append(paramLong1);
              util.LOGI(paramArrayOfByte, ((StringBuilder)localObject2).toString());
              return;
            }
            this.b = ((TreeMap)localObject2);
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("");
            paramArrayOfByte.append(paramLong1);
            util.LOGI("end put_randseed", paramArrayOfByte.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    try
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("");
      ((StringBuilder)???).append(paramLong1);
      util.LOGI("start clear_sig", ((StringBuilder)???).toString());
      ??? = (WloginAllSigInfo)this.b.get(paramLong1);
      if (??? != null)
      {
        ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("uin ");
        ((StringBuilder)???).append(paramLong1);
        ((StringBuilder)???).append(" appid ");
        ((StringBuilder)???).append(paramLong2);
        ((StringBuilder)???).append(" sig has been cleared");
        util.LOGI(((StringBuilder)???).toString());
      }
      if (this.a != null) {
        synchronized (e)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1.longValue());
          if (localTreeMap == null) {
            return;
          }
          paramLong1 = (WloginAllSigInfo)localTreeMap.get(paramLong1);
          if (paramLong1 == null) {
            return;
          }
          paramLong1._tk_map.remove(paramLong2);
          a(localTreeMap, "tk_file");
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      this.c.remove(paramString);
      if (this.a != null) {
        synchronized (f)
        {
          TreeMap localTreeMap2 = a(this.a, "name_file", 0L);
          TreeMap localTreeMap1 = localTreeMap2;
          if (localTreeMap2 == null) {
            localTreeMap1 = new TreeMap();
          }
          localTreeMap1.remove(paramString);
          a(localTreeMap1, "name_file");
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("put account ");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramLong);
      util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject2 = a(paramLong);
      if (localObject2 != null) {
        this.c.remove(localObject2);
      }
      UinInfo localUinInfo = new UinInfo(paramLong, paramBoolean);
      this.c.put(paramString, localUinInfo);
      if (this.a != null) {
        synchronized (f)
        {
          localObject1 = a(this.a, "name_file", 0L);
          paramLong = (Long)localObject1;
          if (localObject1 == null) {
            paramLong = new TreeMap();
          }
          if (localObject2 != null) {
            paramLong.remove(localObject2);
          }
          paramLong.put(paramString, localUinInfo);
          a(paramLong, "name_file");
        }
      }
      return;
    }
    finally {}
  }
  
  public int b(TreeMap paramTreeMap, String paramString)
  {
    return a(this.a, paramTreeMap, paramString, t.C);
  }
  
  public WloginSimpleInfo b(long paramLong)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uin=");
      ((StringBuilder)localObject1).append(paramLong);
      util.LOGI("start get_simpleinfo", ((StringBuilder)localObject1).toString());
      localObject1 = a(paramLong);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((WloginAllSigInfo)localObject1)._useInfo.get_clone();
      return localObject1;
    }
    finally {}
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    try
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start clearNewST ");
      ((StringBuilder)???).append(paramLong2);
      ??? = ((StringBuilder)???).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramLong1);
      util.LOGI((String)???, ((StringBuilder)localObject3).toString());
      ??? = this.a;
      int i = 0;
      int j = 0;
      if (??? != null) {
        synchronized (e)
        {
          localObject3 = a(this.a, "tk_file", paramLong1);
          i = j;
          if (localObject3 != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject3).get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return;
            }
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("");
            localStringBuilder2.append(paramLong1);
            util.LOGI("clearNewST clear newST in file", localStringBuilder2.toString());
            localWloginAllSigInfo.putNewST(paramLong2, new byte[0], new byte[0]);
            i = a((TreeMap)localObject3, "tk_file");
            this.b = ((TreeMap)localObject3);
          }
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("end clearNewST ret ");
      ((StringBuilder)???).append(i);
      ??? = ((StringBuilder)???).toString();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("");
      localStringBuilder1.append(paramLong1);
      util.LOGI((String)???, localStringBuilder1.toString());
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      this.c.remove(paramString);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("clear_account ");
      ((StringBuilder)???).append(paramString);
      util.LOGI(((StringBuilder)???).toString(), "");
      if (this.a != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "name_file", 0L);
          if (localTreeMap == null) {
            return;
          }
          localTreeMap.remove(paramString);
          a(localTreeMap, "name_file");
        }
      }
      return;
    }
    finally {}
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clear_pskey ");
      ((StringBuilder)localObject1).append(paramLong2);
      localObject1 = ((StringBuilder)localObject1).toString();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("");
      ((StringBuilder)???).append(paramLong1);
      util.LOGI((String)localObject1, ((StringBuilder)???).toString());
      localObject1 = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong1));
      if (localObject1 == null) {
        return;
      }
      ??? = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
      if (??? == null) {
        return;
      }
      ((WloginSigInfo)???)._pt4Token = new byte[0];
      ((WloginSigInfo)???)._psKey = new byte[0];
      ((WloginSigInfo)???).cacheTickets = null;
      ((WloginSigInfo)???).cacheUpdateStamp = 0L;
      ((WloginAllSigInfo)localObject1)._tk_map.put(Long.valueOf(paramLong1), ???);
      if (this.a != null) {
        synchronized (e)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap != null)
          {
            localTreeMap.put(Long.valueOf(paramLong1), localObject1);
            a(localTreeMap, "tk_file");
            this.b = localTreeMap;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public WloginSigInfo d(long paramLong1, long paramLong2)
  {
    try
    {
      Object localObject1 = a(paramLong1);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
      if (localObject1 == null) {
        return null;
      }
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */