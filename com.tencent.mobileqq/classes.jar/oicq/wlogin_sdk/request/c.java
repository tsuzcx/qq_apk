package oicq.wlogin_sdk.request;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: new 53	java/lang/StringBuffer
    //   9: dup
    //   10: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   13: astore 8
    //   15: aload_0
    //   16: aload_1
    //   17: aload 8
    //   19: invokestatic 57	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   22: aload_1
    //   23: ldc 59
    //   25: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +256 -> 284
    //   31: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   34: ifnonnull +17 -> 51
    //   37: new 67	oicq/wlogin_sdk/request/b
    //   40: dup
    //   41: aload_0
    //   42: aload_1
    //   43: aconst_null
    //   44: iconst_1
    //   45: invokespecial 70	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   48: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   51: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   54: invokevirtual 74	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   57: astore 6
    //   59: aload 6
    //   61: astore 5
    //   63: aload 5
    //   65: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   68: iconst_1
    //   69: invokestatic 83	oicq/wlogin_sdk/request/c:b	(Ljava/lang/String;Z)V
    //   72: aload 5
    //   74: new 85	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   81: ldc 88
    //   83: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 94
    //   92: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 96
    //   101: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   110: aload 5
    //   112: aload_1
    //   113: iconst_1
    //   114: anewarray 61	java/lang/String
    //   117: dup
    //   118: iconst_0
    //   119: ldc 105
    //   121: aastore
    //   122: ldc 107
    //   124: aconst_null
    //   125: aconst_null
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   131: astore 6
    //   133: aload 6
    //   135: invokeinterface 117 1 0
    //   140: ifne +58 -> 198
    //   143: aload 5
    //   145: new 85	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   152: ldc 119
    //   154: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 121
    //   163: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 123
    //   172: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: iconst_0
    //   185: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: iconst_1
    //   192: newarray byte
    //   194: aastore
    //   195: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload 5
    //   200: new 85	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   207: ldc 134
    //   209: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_1
    //   213: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 136
    //   218: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_1
    //   222: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 138
    //   227: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_2
    //   240: aastore
    //   241: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload 6
    //   246: ifnull +20 -> 266
    //   249: aload 6
    //   251: invokeinterface 142 1 0
    //   256: ifne +10 -> 266
    //   259: aload 6
    //   261: invokeinterface 145 1 0
    //   266: aload 5
    //   268: ifnull +12 -> 280
    //   271: iconst_1
    //   272: aload 5
    //   274: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   277: if_icmpne +3 -> 280
    //   280: iconst_0
    //   281: istore_3
    //   282: iload_3
    //   283: ireturn
    //   284: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   287: ifnonnull +17 -> 304
    //   290: new 67	oicq/wlogin_sdk/request/b
    //   293: dup
    //   294: aload_0
    //   295: aload_1
    //   296: aconst_null
    //   297: iconst_1
    //   298: invokespecial 70	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   301: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   304: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   307: invokevirtual 74	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   310: astore 6
    //   312: aload 6
    //   314: astore 5
    //   316: goto -253 -> 63
    //   319: astore 6
    //   321: aconst_null
    //   322: astore_2
    //   323: aload_1
    //   324: ldc 59
    //   326: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   329: ifeq +97 -> 426
    //   332: aconst_null
    //   333: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   336: aload_0
    //   337: aload_1
    //   338: aload 8
    //   340: invokestatic 150	oicq/wlogin_sdk/request/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   343: aload 6
    //   345: ldc 152
    //   347: invokestatic 158	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   350: new 85	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   357: ldc 160
    //   359: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 6
    //   364: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   367: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: ldc 152
    //   375: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: sipush -1022
    //   381: istore 4
    //   383: aload_2
    //   384: ifnull +18 -> 402
    //   387: aload_2
    //   388: invokeinterface 142 1 0
    //   393: ifne +9 -> 402
    //   396: aload_2
    //   397: invokeinterface 145 1 0
    //   402: iload 4
    //   404: istore_3
    //   405: aload 5
    //   407: ifnull -125 -> 282
    //   410: iload 4
    //   412: istore_3
    //   413: iconst_1
    //   414: aload 5
    //   416: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   419: if_icmpne -137 -> 282
    //   422: sipush -1022
    //   425: ireturn
    //   426: aconst_null
    //   427: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   430: goto -94 -> 336
    //   433: astore_0
    //   434: aload 5
    //   436: astore_1
    //   437: aload_2
    //   438: ifnull +18 -> 456
    //   441: aload_2
    //   442: invokeinterface 142 1 0
    //   447: ifne +9 -> 456
    //   450: aload_2
    //   451: invokeinterface 145 1 0
    //   456: aload_1
    //   457: ifnull +11 -> 468
    //   460: iconst_1
    //   461: aload_1
    //   462: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   465: if_icmpne +3 -> 468
    //   468: aload_0
    //   469: athrow
    //   470: astore_0
    //   471: aconst_null
    //   472: astore_1
    //   473: aload 7
    //   475: astore_2
    //   476: goto -39 -> 437
    //   479: astore_0
    //   480: aload 5
    //   482: astore_1
    //   483: aload 7
    //   485: astore_2
    //   486: goto -49 -> 437
    //   489: astore_0
    //   490: aload 6
    //   492: astore_2
    //   493: aload 5
    //   495: astore_1
    //   496: goto -59 -> 437
    //   499: astore 6
    //   501: aconst_null
    //   502: astore_2
    //   503: goto -180 -> 323
    //   506: astore_2
    //   507: aload 6
    //   509: astore 7
    //   511: aload_2
    //   512: astore 6
    //   514: aload 7
    //   516: astore_2
    //   517: goto -194 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	paramContext	Context
    //   0	520	1	paramString	String
    //   0	520	2	paramArrayOfByte	byte[]
    //   281	132	3	i	int
    //   381	30	4	j	int
    //   4	490	5	localObject1	Object
    //   57	256	6	localObject2	Object
    //   319	172	6	localException1	Exception
    //   499	9	6	localException2	Exception
    //   512	1	6	arrayOfByte	byte[]
    //   1	514	7	localObject3	Object
    //   13	326	8	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   15	51	319	java/lang/Exception
    //   51	59	319	java/lang/Exception
    //   284	304	319	java/lang/Exception
    //   304	312	319	java/lang/Exception
    //   323	336	433	finally
    //   336	378	433	finally
    //   426	430	433	finally
    //   15	51	470	finally
    //   51	59	470	finally
    //   284	304	470	finally
    //   304	312	470	finally
    //   63	133	479	finally
    //   133	198	489	finally
    //   198	244	489	finally
    //   63	133	499	java/lang/Exception
    //   133	198	506	java/lang/Exception
    //   198	244	506	java/lang/Exception
  }
  
  public static int a(Context paramContext, TreeMap paramTreeMap, String paramString, byte[] paramArrayOfByte)
  {
    util.LOGI("saveTKTreeMap start fileName=" + paramString, "");
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramTreeMap);
      localObjectOutputStream.flush();
      paramTreeMap = localByteArrayOutputStream.toByteArray();
      int i = a(paramContext, paramString, cryptor.encrypt(paramTreeMap, 0, paramTreeMap.length, paramArrayOfByte));
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      util.LOGI("saveTKTreeMap end=" + paramString, "");
      return i;
    }
    catch (Throwable paramContext)
    {
      util.LOGI("saveTKTreeMap failed " + paramContext.getStackTrace().toString(), "");
      util.printThrowable(paramContext, "");
    }
    return -1022;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int i = paramInt;
    if (i < paramArrayOfByte1.length - paramArrayOfByte2.length - paramInt)
    {
      j = 0;
      label16:
      if (j >= paramArrayOfByte2.length) {
        break label64;
      }
      if (paramArrayOfByte1[(i + j)] == paramArrayOfByte2[j]) {}
    }
    label64:
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        return i;
        j += 1;
        break label16;
      }
      i += 1;
      break;
      return -1;
    }
  }
  
  public static TreeMap a(Context paramContext, String paramString, long paramLong)
  {
    util.LOGI("loadTKTreeMap sigfile start " + paramString, "");
    Object localObject1 = a(paramContext, paramString);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      util.LOGI("loadTKTreeMap len:" + localObject1.length + " at " + t.m(), "");
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
            util.LOGI("loadTKTreeMap tree size: " + ((TreeMap)localObject1).size(), "");
            boolean bool = "tk_file".equals(paramString);
            if (bool)
            {
              if (0L == paramLong) {}
              return b(paramContext, paramString);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          localObject2 = ((TreeMap)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            localObject4 = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
            util.LOGI(localObject3 + " allsig: " + ((WloginAllSigInfo)localObject4)._tk_map, "" + localObject3);
          }
          localObject2 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong));
          util.LOGI(paramLong + " allsig: " + ((WloginAllSigInfo)localObject2)._tk_map, "" + paramLong);
          return localObject1;
        }
        catch (Exception paramContext) {}
        localThrowable = localThrowable;
        util.printThrowable(localThrowable, "");
      }
    }
    ByteArrayInputStream localByteArrayInputStream;
    for (;;)
    {
      localObject2 = localThrowable.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (UinInfo)localThrowable.get(localObject3);
        if (localObject4 != null) {
          util.LOGI(localObject3 + " is uin: " + ((UinInfo)localObject4)._uin, "");
        }
      }
      util.LOGI("tree is null", "");
      return null;
      localObject3 = new SecretKeySpec(t.C, "DESede");
      localObject2 = Cipher.getInstance("DESede");
      ((Cipher)localObject2).init(2, (Key)localObject3);
      localByteArrayInputStream = new ByteArrayInputStream(localThrowable);
      localObject2 = new ObjectInputStream(new CipherInputStream(localByteArrayInputStream, (Cipher)localObject2));
      localObject3 = (TreeMap)((ObjectInputStream)localObject2).readObject();
      if (localObject3 != null)
      {
        ((ObjectInputStream)localObject2).close();
        localByteArrayInputStream.close();
        return localObject3;
        util.LOGI("loadTKTreeMap dbdata is null at " + t.m(), "");
      }
    }
    return localByteArrayInputStream;
  }
  
  public static void a(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append("stashDbFileBefore");
    c(paramContext, paramString, paramStringBuffer);
  }
  
  public static void a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = a(paramContext, "tk_file");
    Object localObject3;
    if (localObject1 != null) {
      try
      {
        localObject1 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, paramArrayOfByte1);
        if (localObject1 != null)
        {
          localObject3 = new ByteArrayInputStream((byte[])localObject1);
          Object localObject4 = new ObjectInputStream((InputStream)localObject3);
          localObject1 = (TreeMap)((ObjectInputStream)localObject4).readObject();
          ((ObjectInputStream)localObject4).close();
          ((ByteArrayInputStream)localObject3).close();
          if (localObject1 != null)
          {
            localObject3 = ((TreeMap)localObject1).keySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = ((Iterator)localObject3).next();
              WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject4);
              util.LOGI(localObject4 + " change guid allsig: " + localWloginAllSigInfo._tk_map, "" + localObject4);
            }
          }
        }
        localObject2 = a(paramContext, "name_file");
      }
      catch (Throwable localThrowable) {}
    }
    for (;;)
    {
      Object localObject2;
      if (localObject2 != null) {}
      try
      {
        paramArrayOfByte1 = cryptor.decrypt((byte[])localObject2, 0, localObject2.length, paramArrayOfByte1);
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1 = new ByteArrayInputStream(paramArrayOfByte1);
          localObject2 = new ObjectInputStream(paramArrayOfByte1);
          localObject3 = (TreeMap)((ObjectInputStream)localObject2).readObject();
          ((ObjectInputStream)localObject2).close();
          paramArrayOfByte1.close();
          if (localObject3 != null) {
            a(paramContext, (TreeMap)localObject3, "name_file", paramArrayOfByte2);
          }
        }
        return;
      }
      catch (Throwable paramContext) {}
      a(paramContext, (TreeMap)localObject2, "tk_file", paramArrayOfByte2);
    }
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: invokestatic 354	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7: astore 6
    //   9: new 53	java/lang/StringBuffer
    //   12: dup
    //   13: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   16: astore 8
    //   18: aload_0
    //   19: aload_1
    //   20: aload 8
    //   22: invokestatic 57	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   25: aload_1
    //   26: ldc 59
    //   28: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +174 -> 205
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
    //   57: invokevirtual 357	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   65: iconst_0
    //   66: invokestatic 83	oicq/wlogin_sdk/request/c:b	(Ljava/lang/String;Z)V
    //   69: aload_3
    //   70: new 85	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 359
    //   80: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 361
    //   90: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aconst_null
    //   97: invokevirtual 365	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore 4
    //   102: aload 6
    //   104: astore 5
    //   106: aload 4
    //   108: invokeinterface 368 1 0
    //   113: ifeq +24 -> 137
    //   116: aload 6
    //   118: astore 5
    //   120: aload 4
    //   122: iconst_0
    //   123: invokeinterface 372 2 0
    //   128: ifle +9 -> 137
    //   131: iconst_1
    //   132: invokestatic 354	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   135: astore 5
    //   137: aload 4
    //   139: ifnull +20 -> 159
    //   142: aload 4
    //   144: invokeinterface 142 1 0
    //   149: ifne +10 -> 159
    //   152: aload 4
    //   154: invokeinterface 145 1 0
    //   159: aload 5
    //   161: invokevirtual 375	java/lang/Boolean:booleanValue	()Z
    //   164: istore_2
    //   165: iload_2
    //   166: ifne +69 -> 235
    //   169: aload 4
    //   171: ifnull +20 -> 191
    //   174: aload 4
    //   176: invokeinterface 142 1 0
    //   181: ifne +10 -> 191
    //   184: aload 4
    //   186: invokeinterface 145 1 0
    //   191: aload_3
    //   192: ifnull +11 -> 203
    //   195: iconst_1
    //   196: aload_3
    //   197: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   200: if_icmpne +3 -> 203
    //   203: aconst_null
    //   204: areturn
    //   205: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   208: ifnonnull +17 -> 225
    //   211: new 67	oicq/wlogin_sdk/request/b
    //   214: dup
    //   215: aload_0
    //   216: aload_1
    //   217: aconst_null
    //   218: iconst_1
    //   219: invokespecial 70	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   222: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   225: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   228: invokevirtual 357	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   231: astore_3
    //   232: goto -171 -> 61
    //   235: aload_3
    //   236: aload_1
    //   237: iconst_1
    //   238: anewarray 61	java/lang/String
    //   241: dup
    //   242: iconst_0
    //   243: aload_1
    //   244: aastore
    //   245: ldc 107
    //   247: aconst_null
    //   248: aconst_null
    //   249: aconst_null
    //   250: aconst_null
    //   251: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   254: astore 5
    //   256: aload 5
    //   258: ifnonnull +39 -> 297
    //   261: aload 5
    //   263: ifnull +20 -> 283
    //   266: aload 5
    //   268: invokeinterface 142 1 0
    //   273: ifne +10 -> 283
    //   276: aload 5
    //   278: invokeinterface 145 1 0
    //   283: aload_3
    //   284: ifnull +11 -> 295
    //   287: iconst_1
    //   288: aload_3
    //   289: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   292: if_icmpne +3 -> 295
    //   295: aconst_null
    //   296: areturn
    //   297: aload 5
    //   299: invokeinterface 378 1 0
    //   304: ifeq +57 -> 361
    //   307: aload 5
    //   309: iconst_0
    //   310: invokeinterface 382 2 0
    //   315: astore 4
    //   317: aload 5
    //   319: invokeinterface 145 1 0
    //   324: aload 5
    //   326: ifnull +20 -> 346
    //   329: aload 5
    //   331: invokeinterface 142 1 0
    //   336: ifne +10 -> 346
    //   339: aload 5
    //   341: invokeinterface 145 1 0
    //   346: aload_3
    //   347: ifnull +11 -> 358
    //   350: iconst_1
    //   351: aload_3
    //   352: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   355: if_icmpne +3 -> 358
    //   358: aload 4
    //   360: areturn
    //   361: aload 5
    //   363: invokeinterface 145 1 0
    //   368: aload 5
    //   370: ifnull +20 -> 390
    //   373: aload 5
    //   375: invokeinterface 142 1 0
    //   380: ifne +10 -> 390
    //   383: aload 5
    //   385: invokeinterface 145 1 0
    //   390: aload_3
    //   391: ifnull +11 -> 402
    //   394: iconst_1
    //   395: aload_3
    //   396: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   399: if_icmpne +3 -> 402
    //   402: aconst_null
    //   403: areturn
    //   404: astore 5
    //   406: aconst_null
    //   407: astore_3
    //   408: aconst_null
    //   409: astore 4
    //   411: aload_1
    //   412: ldc 59
    //   414: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   417: ifeq +56 -> 473
    //   420: aconst_null
    //   421: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   424: aload_0
    //   425: aload_1
    //   426: aload 8
    //   428: invokestatic 150	oicq/wlogin_sdk/request/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   431: aload 5
    //   433: ldc 152
    //   435: invokestatic 158	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   438: aload_3
    //   439: ifnull +18 -> 457
    //   442: aload_3
    //   443: invokeinterface 142 1 0
    //   448: ifne +9 -> 457
    //   451: aload_3
    //   452: invokeinterface 145 1 0
    //   457: aload 4
    //   459: ifnull +12 -> 471
    //   462: iconst_1
    //   463: aload 4
    //   465: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   468: if_icmpne +3 -> 471
    //   471: aconst_null
    //   472: areturn
    //   473: aconst_null
    //   474: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   477: goto -53 -> 424
    //   480: astore_0
    //   481: aload_3
    //   482: astore_1
    //   483: aload_1
    //   484: ifnull +18 -> 502
    //   487: aload_1
    //   488: invokeinterface 142 1 0
    //   493: ifne +9 -> 502
    //   496: aload_1
    //   497: invokeinterface 145 1 0
    //   502: aload 4
    //   504: ifnull +12 -> 516
    //   507: iconst_1
    //   508: aload 4
    //   510: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   513: if_icmpne +3 -> 516
    //   516: aload_0
    //   517: athrow
    //   518: astore_0
    //   519: aconst_null
    //   520: astore 4
    //   522: aload 5
    //   524: astore_1
    //   525: goto -42 -> 483
    //   528: astore_0
    //   529: aload_3
    //   530: astore 4
    //   532: aload 5
    //   534: astore_1
    //   535: goto -52 -> 483
    //   538: astore_0
    //   539: aload 4
    //   541: astore_1
    //   542: aload_3
    //   543: astore 4
    //   545: goto -62 -> 483
    //   548: astore_0
    //   549: aload 5
    //   551: astore_1
    //   552: aload_3
    //   553: astore 4
    //   555: goto -72 -> 483
    //   558: astore 5
    //   560: aload_3
    //   561: astore 4
    //   563: aconst_null
    //   564: astore_3
    //   565: goto -154 -> 411
    //   568: astore 5
    //   570: aload_3
    //   571: astore 6
    //   573: aload 4
    //   575: astore_3
    //   576: aload 6
    //   578: astore 4
    //   580: goto -169 -> 411
    //   583: astore 7
    //   585: aload 5
    //   587: astore 4
    //   589: aload_3
    //   590: astore 6
    //   592: aload 7
    //   594: astore 5
    //   596: aload 4
    //   598: astore_3
    //   599: aload 6
    //   601: astore 4
    //   603: goto -192 -> 411
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	paramContext	Context
    //   0	606	1	paramString	String
    //   164	2	2	bool	boolean
    //   60	539	3	localObject1	Object
    //   100	502	4	localObject2	Object
    //   1	383	5	localObject3	Object
    //   404	146	5	localException1	Exception
    //   558	1	5	localException2	Exception
    //   568	18	5	localException3	Exception
    //   594	1	5	localObject4	Object
    //   7	593	6	localObject5	Object
    //   583	10	7	localException4	Exception
    //   16	411	8	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   18	54	404	java/lang/Exception
    //   54	61	404	java/lang/Exception
    //   205	225	404	java/lang/Exception
    //   225	232	404	java/lang/Exception
    //   411	424	480	finally
    //   424	438	480	finally
    //   473	477	480	finally
    //   18	54	518	finally
    //   54	61	518	finally
    //   205	225	518	finally
    //   225	232	518	finally
    //   61	102	528	finally
    //   106	116	538	finally
    //   120	137	538	finally
    //   142	159	538	finally
    //   159	165	538	finally
    //   235	256	538	finally
    //   297	324	548	finally
    //   361	368	548	finally
    //   61	102	558	java/lang/Exception
    //   106	116	568	java/lang/Exception
    //   120	137	568	java/lang/Exception
    //   142	159	568	java/lang/Exception
    //   159	165	568	java/lang/Exception
    //   235	256	568	java/lang/Exception
    //   297	324	583	java/lang/Exception
    //   361	368	583	java/lang/Exception
  }
  
  private static TreeMap b(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.C, "DESede");
      Object localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject3));
      if ((localThrowable2 instanceof FileNotFoundException)) {
        break label133;
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        localObject3 = (TreeMap)((ObjectInputStream)localObject1).readObject();
        paramString = (String)localObject1;
        paramContext = (Context)localObject3;
        if (paramContext != null) {
          break label1257;
        }
        return paramContext;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject5;
          continue;
          int i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
        }
      }
      localThrowable2 = localThrowable2;
      localObject1 = null;
    }
    try
    {
      byte[] arrayOfByte1 = new byte[256];
      localObject5 = paramContext.openFileInput(paramString);
      for (;;)
      {
        i = ((FileInputStream)localObject5).read(arrayOfByte1, 0, arrayOfByte1.length);
        if (i <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string(arrayOfByte1, i));
      }
      try
      {
        localObject4 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
        localObject5 = Cipher.getInstance("DESede");
        ((Cipher)localObject5).init(2, (Key)localObject4);
        localObject4 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject5));
      }
      catch (Throwable localThrowable3) {}
    }
    catch (Exception localException2) {}
    for (;;)
    {
      try
      {
        label133:
        Object localObject4;
        localObject1 = (TreeMap)((ObjectInputStream)localObject4).readObject();
        paramString = (String)localObject4;
        paramContext = (Context)localObject1;
      }
      catch (Throwable localThrowable1)
      {
        byte[] arrayOfByte2;
        byte[] arrayOfByte3;
        Object localObject2 = arrayOfByte2;
        continue;
      }
      ((FileInputStream)localObject5).close();
    }
    for (;;)
    {
      int m;
      label299:
      label334:
      try
      {
        arrayOfByte2 = new byte[256];
        int k = arrayOfByte2.length;
        paramString = paramContext.openFileInput(paramString);
        localObject5 = paramContext.openFileOutput("tmp_tk_file", 0);
        m = paramString.read(arrayOfByte2, 40, k - 40);
        if (m <= 0) {
          break label1221;
        }
        i = 40 + m;
        if (i >= arrayOfByte2.length) {
          break label1288;
        }
        arrayOfByte2[i] = 0;
        i += 1;
        continue;
        if (i < 0) {
          break label1293;
        }
        arrayOfByte3 = new String("WloginAllSigInfo").getBytes();
        i = a(arrayOfByte2, i, arrayOfByte3);
        if (i >= 0) {
          break;
        }
      }
      catch (Exception paramString) {}
      if (i < 0) {
        break label1298;
      }
      arrayOfByte3 = new String("WloginSigInfo").getBytes();
      i = a(arrayOfByte2, i, arrayOfByte3);
      if (i >= 0) {
        break label676;
      }
      break label1298;
      label369:
      if (i < 0) {
        break label1303;
      }
      arrayOfByte3 = new String("WloginSimpleInfo").getBytes();
      i = a(arrayOfByte2, i, arrayOfByte3);
      if (i >= 0) {
        break label847;
      }
      break label1303;
      label404:
      if (i >= 0)
      {
        arrayOfByte3 = new String("UinInfo").getBytes();
        i = a(arrayOfByte2, i, arrayOfByte3);
        if (i >= 0) {
          break label1034;
        }
      }
      ((FileOutputStream)localObject5).write(arrayOfByte2, 40, m);
      if (m > 40) {
        System.arraycopy(arrayOfByte2, m, arrayOfByte2, 0, 40);
      }
    }
    for (;;)
    {
      paramString = (String)localObject1;
      localObject1 = null;
      paramContext.deleteFile("tmp_tk_file");
      paramContext = (Context)localObject1;
      break;
      int j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != -127) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != 64) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != 1) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 111) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -111) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != -44) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 26) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != -101) {
        break label299;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
      break label299;
      label676:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != 0) {
        break label334;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
      break label334;
      label847:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != 57) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != -69) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != -84) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 110) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -46) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 98) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != -31) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != -113) {
        break label369;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
      break label369;
      label1034:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != -118) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != -23) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != -128) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != -19) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -26) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 99) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 41) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != 14) {
        break label404;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
      break label404;
      label1221:
      paramString.close();
      ((FileOutputStream)localObject5).close();
      paramString = new ObjectInputStream(paramContext.openFileInput("tmp_tk_file"));
      for (;;)
      {
        try
        {
          localObject1 = (TreeMap)paramString.readObject();
        }
        catch (Exception localException1)
        {
          label1257:
          String str = paramString;
        }
        try
        {
          paramString.close();
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
  }
  
  public static void b(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(",printDbFileWhenError");
    c(paramContext, paramString, paramStringBuffer);
    util.LOGI(paramStringBuffer.toString(), "");
  }
  
  private static void b(String paramString, boolean paramBoolean)
  {
    long l = new File(paramString).lastModified();
    util.LOGI("file " + paramString + " last update time " + l + ",beforeWrite=" + paramBoolean, "");
  }
  
  public static void c(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    try
    {
      paramStringBuffer.append(",table=").append(paramString);
      paramContext = paramContext.getDatabasePath(paramString);
      paramStringBuffer.append(",file=").append(paramContext.getAbsolutePath());
      paramStringBuffer.append(",isExists=").append(paramContext.exists());
      paramStringBuffer.append(",canRead=").append(paramContext.canRead());
      paramStringBuffer.append(",canWrite=").append(paramContext.canWrite());
      paramStringBuffer.append(",canExecute=").append(paramContext.canExecute());
      paramStringBuffer.append(",lastModified=").append(paramContext.lastModified());
      paramContext = paramContext.getParentFile();
      paramStringBuffer.append(",isParentExists=").append(paramContext.exists());
      return;
    }
    catch (Exception paramContext)
    {
      paramStringBuffer.append(",exception=").append(paramContext.getMessage());
    }
  }
  
  /* Error */
  public int a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 85	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 512
    //   18: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   35: ldc 152
    //   37: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   54: ifnull +116 -> 170
    //   57: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   69: ldc 59
    //   71: lload_1
    //   72: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +84 -> 167
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 284	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   98: astore 9
    //   100: aload 9
    //   102: ifnonnull +14 -> 116
    //   105: iconst_m1
    //   106: istore 5
    //   108: aload 7
    //   110: monitorexit
    //   111: aload_0
    //   112: monitorexit
    //   113: iload 5
    //   115: ireturn
    //   116: ldc_w 514
    //   119: new 85	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   126: ldc 152
    //   128: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: lload_1
    //   132: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 9
    //   143: lload_3
    //   144: iconst_0
    //   145: newarray byte
    //   147: invokevirtual 518	oicq/wlogin_sdk/request/WloginAllSigInfo:put_da2	(J[B)I
    //   150: pop
    //   151: aload_0
    //   152: aload 8
    //   154: ldc 59
    //   156: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   159: istore 5
    //   161: aload_0
    //   162: aload 8
    //   164: putfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   167: aload 7
    //   169: monitorexit
    //   170: new 85	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 523
    //   180: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload 5
    //   185: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: new 85	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   198: ldc 152
    //   200: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: lload_1
    //   204: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto -102 -> 111
    //   216: astore 7
    //   218: aload_0
    //   219: monitorexit
    //   220: aload 7
    //   222: athrow
    //   223: astore 8
    //   225: aload 7
    //   227: monitorexit
    //   228: aload 8
    //   230: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	c
    //   0	231	1	paramLong1	long
    //   0	231	3	paramLong2	long
    //   1	183	5	i	int
    //   4	74	6	j	int
    //   216	10	7	localObject2	Object
    //   75	88	8	localTreeMap	TreeMap
    //   223	6	8	localObject3	Object
    //   98	44	9	localWloginAllSigInfo	WloginAllSigInfo
    // Exception table:
    //   from	to	target	type
    //   8	50	216	finally
    //   50	65	216	finally
    //   170	213	216	finally
    //   228	231	216	finally
    //   65	77	223	finally
    //   86	100	223	finally
    //   108	111	223	finally
    //   116	167	223	finally
    //   167	170	223	finally
    //   225	228	223	finally
  }
  
  /* Error */
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 85	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 526
    //   12: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc 152
    //   31: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 284	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   58: astore 13
    //   60: aload 13
    //   62: ifnonnull +11 -> 73
    //   65: iconst_m1
    //   66: istore 11
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 11
    //   72: ireturn
    //   73: aload 13
    //   75: lload_3
    //   76: lload 5
    //   78: lload 7
    //   80: aload 9
    //   82: aload 10
    //   84: invokevirtual 530	oicq/wlogin_sdk/request/WloginAllSigInfo:put_siginfo	(JJJ[B[B)I
    //   87: istore 12
    //   89: iload 12
    //   91: istore 11
    //   93: aload_0
    //   94: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   97: ifnull -29 -> 68
    //   100: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   103: astore 14
    //   105: aload 14
    //   107: monitorenter
    //   108: aload_0
    //   109: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   112: ldc 59
    //   114: lload_1
    //   115: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   118: astore 10
    //   120: aload 10
    //   122: astore 9
    //   124: aload 10
    //   126: ifnonnull +12 -> 138
    //   129: new 36	java/util/TreeMap
    //   132: dup
    //   133: invokespecial 37	java/util/TreeMap:<init>	()V
    //   136: astore 9
    //   138: aload 9
    //   140: lload_1
    //   141: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: aload 13
    //   146: invokevirtual 534	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   149: invokevirtual 538	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload_0
    //   154: aload 9
    //   156: ldc 59
    //   158: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   161: pop
    //   162: aload 14
    //   164: monitorexit
    //   165: iload 12
    //   167: istore 11
    //   169: goto -101 -> 68
    //   172: astore 9
    //   174: aload 14
    //   176: monitorexit
    //   177: aload 9
    //   179: athrow
    //   180: astore 9
    //   182: aload_0
    //   183: monitorexit
    //   184: aload 9
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	c
    //   0	187	1	paramLong1	long
    //   0	187	3	paramLong2	long
    //   0	187	5	paramLong3	long
    //   0	187	7	paramLong4	long
    //   0	187	9	paramArrayOfByte1	byte[]
    //   0	187	10	paramArrayOfByte2	byte[]
    //   66	102	11	i	int
    //   87	79	12	j	int
    //   58	87	13	localWloginAllSigInfo	WloginAllSigInfo
    // Exception table:
    //   from	to	target	type
    //   108	120	172	finally
    //   129	138	172	finally
    //   138	165	172	finally
    //   174	177	172	finally
    //   2	60	180	finally
    //   73	89	180	finally
    //   93	108	180	finally
    //   177	180	180	finally
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] arg5, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    label1311:
    label1314:
    label1317:
    label1324:
    label1348:
    for (;;)
    {
      int i;
      TreeMap localTreeMap;
      Object localObject3;
      Object localObject8;
      byte[] arrayOfByte;
      Object localObject7;
      Object localObject9;
      HashMap localHashMap1;
      HashMap localHashMap2;
      String str;
      try
      {
        util.LOGI("start put_siginfo skey " + util.getMaskBytes(paramArrayOfByte10, 2, 2), "" + paramLong1);
        i = 0;
        if (this.a == null) {
          break label1223;
        }
        synchronized (e)
        {
          util.LOGI("put_siginfo load file", "" + paramLong1);
          localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap != null) {
            break label1348;
          }
          localTreeMap = new TreeMap();
          localObject1 = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong1));
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new WloginAllSigInfo();
            }
          }
          util.LOGI("put_siginfo mainSigMap 0x" + Integer.toHexString(this.d), "" + paramLong1);
          ((WloginAllSigInfo)localObject3).mainSigMap = this.d;
          localObject8 = new byte[0];
          localObject1 = new byte[0];
          arrayOfByte = new byte[0];
          localObject4 = new byte[0];
          localObject5 = new byte[0];
          localObject7 = new byte[0];
          localObject9 = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(Long.valueOf(paramLong2));
          if (localObject9 == null) {
            break label1324;
          }
          if (((WloginSigInfo)localObject9)._en_A1 == null) {
            break label1317;
          }
          localObject2 = (byte[])((WloginSigInfo)localObject9)._en_A1.clone();
          if (((WloginSigInfo)localObject9)._noPicSig == null) {
            break label1314;
          }
          localObject1 = (byte[])((WloginSigInfo)localObject9)._noPicSig.clone();
          if (((WloginSigInfo)localObject9)._G != null) {
            arrayOfByte = (byte[])((WloginSigInfo)localObject9)._G.clone();
          }
          if (((WloginSigInfo)localObject9)._dpwd != null) {
            localObject4 = (byte[])((WloginSigInfo)localObject9)._dpwd.clone();
          }
          if (((WloginSigInfo)localObject9)._randseed == null) {
            break label1311;
          }
          localObject5 = (byte[])((WloginSigInfo)localObject9)._randseed.clone();
          localObject6 = ((WloginSigInfo)localObject9)._psKey;
          localObject9 = ((WloginSigInfo)localObject9)._pt4Token;
          localObject7 = localObject5;
          localObject8 = localObject4;
          localObject5 = localObject2;
          localObject4 = localObject1;
          localObject2 = localObject8;
          localObject1 = localObject7;
          localObject7 = localObject9;
          if ((paramArrayOfByte14[6] == null) || (paramArrayOfByte14[6].length <= 2)) {
            break label891;
          }
          localObject8 = new HashMap();
          localObject9 = new HashMap();
          localHashMap1 = new HashMap();
          localHashMap2 = new HashMap();
          Ticket.parsePsBuf((byte[])localObject6, paramLong5, (Map)localObject8, (Map)localObject9, true);
          Ticket.parsePsBuf((byte[])localObject7, paramLong5, localHashMap1, localHashMap2, false);
          util.LOGI("put_siginfo current pskey size:" + ((Map)localObject8).size() + ":" + ((Map)localObject9).size(), "");
          localObject6 = ((Map)localObject9).entrySet().iterator();
          if (((Iterator)localObject6).hasNext())
          {
            localObject7 = (Map.Entry)((Iterator)localObject6).next();
            str = (String)((Map.Entry)localObject7).getKey();
            if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject7).getValue()).longValue())) {
              continue;
            }
            ((Iterator)localObject6).remove();
            ((Map)localObject8).remove(str);
            util.LOGI("put_siginfo delete expired pskey from file,key:" + str, "");
          }
        }
        localObject6 = localHashMap2.entrySet().iterator();
      }
      finally {}
      util.LOGI("put_siginfo current pt4token size:" + localHashMap1.size() + ":" + localHashMap2.size(), "");
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Map.Entry)((Iterator)localObject6).next();
        str = (String)((Map.Entry)localObject7).getKey();
        if (Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject7).getValue()).longValue()))
        {
          ((Iterator)localObject6).remove();
          localHashMap1.remove(str);
          util.LOGI("put_siginfo delete expired pt4token from file,key:" + str, "");
        }
      }
      Ticket.parseSvrPs(paramArrayOfByte14[6], paramLong5, (Map)localObject8, (Map)localObject9, localHashMap1, localHashMap2);
      try
      {
        paramArrayOfByte14[6] = Ticket.packPsBuf((Map)localObject8, paramLong5, (Map)localObject9);
        paramArrayOfByte14[12] = Ticket.packPsBuf(localHashMap1, paramLong5, localHashMap2);
        label891:
        ((WloginAllSigInfo)localObject3).put_simpleinfo(paramWloginSimpleInfo);
        ((WloginAllSigInfo)localObject3).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
        if ((??? != null) && (???[0] != null) && (???[0].length > 0)) {
          util.LOGI("A1_INFO: update A1 form ser : " + MD5.getMD5String(???[0]), "" + paramLong1);
        }
        ((WloginAllSigInfo)localObject3).put_siginfo(paramLong2, ???, paramLong5);
        localTreeMap.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject3).get_clone());
      }
      catch (BufferOverflowException ???)
      {
        synchronized (e)
        {
          i = a(localTreeMap, "tk_file");
          util.LOGI("put_siginfo save key result:tk_file:" + i, "");
          if (i != 0)
          {
            ??? = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(Long.valueOf(paramLong2));
            if (??? != null)
            {
              ???._en_A1 = ((byte[])((byte[])localObject5).clone());
              ???._noPicSig = ((byte[])((byte[])localObject4).clone());
              ???._G = ((byte[])arrayOfByte.clone());
              ???._dpwd = ((byte[])((byte[])localObject2).clone());
              ???._randseed = ((byte[])((byte[])localObject1).clone());
            }
          }
          util.LOGI("put_siginfo sig in memory changed", "" + paramLong1);
          this.b.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject3).get_clone());
          label1223:
          return i;
          ??? = ???;
          util.LOGI("map size " + ((Map)localObject8).size() + "is too large", "" + paramLong1);
          a(Long.valueOf(paramLong1));
          i = -1023;
        }
      }
      continue;
      Object localObject2 = localObject8;
      continue;
      Object localObject6 = new byte[0];
      localObject2 = localObject4;
      Object localObject4 = localObject1;
      Object localObject1 = localObject5;
      Object localObject5 = localObject8;
    }
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
  
  public List<WloginLoginInfo> a(boolean paramBoolean)
  {
    label338:
    for (;;)
    {
      ArrayList localArrayList;
      Long localLong1;
      Object localObject3;
      Long localLong2;
      WloginSigInfo localWloginSigInfo;
      try
      {
        localArrayList = new ArrayList();
        if (this.a == null) {
          break label338;
        }
        TreeMap localTreeMap = a(this.a, "tk_file", 0L);
        if (localTreeMap == null) {
          return localArrayList;
        }
        Iterator localIterator1 = localTreeMap.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break label338;
        }
        localLong1 = (Long)localIterator1.next();
        localObject3 = (WloginAllSigInfo)this.b.get(localLong1);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = (WloginAllSigInfo)localTreeMap.get(localLong1);
          if (localObject1 == null) {
            continue;
          }
          this.b.put(localLong1, localObject1);
        }
        Iterator localIterator2 = ((WloginAllSigInfo)localObject1)._tk_map.keySet().iterator();
        if (localIterator2.hasNext())
        {
          localLong2 = (Long)localIterator2.next();
          localWloginSigInfo = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(localLong2);
          if (localWloginSigInfo == null) {
            continue;
          }
          str = b(localLong1);
          localObject3 = str;
          if (str == null) {
            localObject3 = String.valueOf(localLong1);
          }
          if (((WloginAllSigInfo)localObject1)._useInfo == null) {
            util.LOGI("get_all_logined_account useInfo is null");
          }
        }
        else
        {
          continue;
        }
        if (localObject2._useInfo._img_url != null) {
          break label253;
        }
      }
      finally {}
      localObject2._useInfo._img_url = new byte[0];
      label253:
      long l1 = localLong1.longValue();
      long l2 = localLong2.longValue();
      String str = new String(localObject2._useInfo._img_url);
      long l3 = localWloginSigInfo._create_time;
      if (paramBoolean) {}
      for (int i = WloginLoginInfo.TYPE_LOACL;; i = WloginLoginInfo.TYPE_REMOTE)
      {
        localArrayList.add(new WloginLoginInfo((String)localObject3, l1, l2, str, l3, i, localWloginSigInfo._login_bitmap));
        break;
      }
    }
  }
  
  /* Error */
  public UinInfo a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: ifeq +76 -> 79
    //   6: aload_0
    //   7: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   10: aload_1
    //   11: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 305	oicq/wlogin_sdk/request/UinInfo
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +60 -> 79
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 722
    //   32: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 724
    //   42: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: getfield 311	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   49: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 726
    //   55: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 729	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   62: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 152
    //   70: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: aload_0
    //   80: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   83: ifnonnull +8 -> 91
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: aload_0
    //   92: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   95: ldc 45
    //   97: lconst_0
    //   98: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnonnull +8 -> 111
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -33 -> 75
    //   111: aload_3
    //   112: aload_1
    //   113: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 305	oicq/wlogin_sdk/request/UinInfo
    //   119: astore_3
    //   120: aload_3
    //   121: ifnonnull +8 -> 129
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -51 -> 75
    //   129: aload_0
    //   130: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   133: aload_1
    //   134: aload_3
    //   135: invokevirtual 538	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: new 85	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 731
    //   149: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 724
    //   159: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_3
    //   163: getfield 311	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   166: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: ldc_w 726
    //   172: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 729	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   179: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: ldc 152
    //   187: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: astore_1
    //   192: goto -117 -> 75
    //   195: astore_1
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	c
    //   0	200	1	paramString	String
    //   0	200	2	paramBoolean	boolean
    //   17	174	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	195	finally
    //   22	73	195	finally
    //   79	86	195	finally
    //   91	102	195	finally
    //   111	120	195	finally
    //   129	190	195	finally
  }
  
  /* Error */
  public WloginAllSigInfo a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   6: lload_1
    //   7: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 284	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +15 -> 33
    //   21: ldc_w 734
    //   24: ldc 152
    //   26: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: areturn
    //   33: aload_0
    //   34: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   37: ifnonnull +8 -> 45
    //   40: aconst_null
    //   41: astore_3
    //   42: goto -13 -> 29
    //   45: aload_0
    //   46: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   49: ldc 59
    //   51: lload_1
    //   52: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnonnull +8 -> 65
    //   60: aconst_null
    //   61: astore_3
    //   62: goto -33 -> 29
    //   65: aload_3
    //   66: lload_1
    //   67: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 284	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   76: astore_3
    //   77: aload_3
    //   78: ifnonnull +8 -> 86
    //   81: aconst_null
    //   82: astore_3
    //   83: goto -54 -> 29
    //   86: ldc_w 736
    //   89: ldc 152
    //   91: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   98: lload_1
    //   99: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: aload_3
    //   103: invokevirtual 538	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: goto -78 -> 29
    //   110: astore_3
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	c
    //   0	115	1	paramLong	long
    //   16	87	3	localObject1	Object
    //   110	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	110	finally
    //   21	29	110	finally
    //   33	40	110	finally
    //   45	56	110	finally
    //   65	77	110	finally
    //   86	107	110	finally
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
    label272:
    for (;;)
    {
      try
      {
        util.LOGI("start put_randseed " + paramLong2, "" + paramLong1);
        if (this.a != null) {}
        TreeMap localTreeMap;
        synchronized (e)
        {
          localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap == null) {
            break label272;
          }
          WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
          if (localWloginAllSigInfo == null)
          {
            util.LOGI("fileInfo is null " + paramLong2, "" + paramLong1);
            return;
          }
          localWloginAllSigInfo.put_randseed(paramLong2, paramArrayOfByte);
          int i = a(localTreeMap, "tk_file");
          if (i != 0) {
            util.LOGI("put_randseed refreshTKTreeMap failed ret " + i + " appid " + paramLong2, "" + paramLong1);
          }
        }
        this.b = localTreeMap;
      }
      finally {}
      util.LOGI("end put_randseed", "" + paramLong1);
    }
  }
  
  /* Error */
  public void a(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 754
    //   5: new 85	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   12: ldc 152
    //   14: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   31: aload_1
    //   32: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_0
    //   37: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   40: ifnull +29 -> 69
    //   43: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   53: ldc 59
    //   55: aload_1
    //   56: invokevirtual 618	java/lang/Long:longValue	()J
    //   59: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnonnull +8 -> 72
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_0
    //   79: aload_3
    //   80: ldc 59
    //   82: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   85: pop
    //   86: aload_2
    //   87: monitorexit
    //   88: goto -19 -> 69
    //   91: astore_1
    //   92: aload_2
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	c
    //   0	101	1	paramLong	Long
    //   62	18	3	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   49	63	91	finally
    //   67	69	91	finally
    //   72	88	91	finally
    //   92	94	91	finally
    //   2	49	96	finally
    //   94	96	96	finally
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    for (;;)
    {
      TreeMap localTreeMap;
      try
      {
        util.LOGI("start clear_sig", "" + paramLong1);
        ??? = (WloginAllSigInfo)this.b.get(paramLong1);
        if (??? != null)
        {
          ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
          util.LOGI("uin " + paramLong1 + " appid " + paramLong2 + " sig has been cleared");
        }
        if (this.a != null) {}
        synchronized (e)
        {
          localTreeMap = a(this.a, "tk_file", paramLong1.longValue());
          if (localTreeMap == null) {
            return;
          }
          paramLong1 = (WloginAllSigInfo)localTreeMap.get(paramLong1);
          if (paramLong1 != null) {}
        }
        paramLong1._tk_map.remove(paramLong2);
      }
      finally {}
      a(localTreeMap, "tk_file");
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   15: ifnull +53 -> 68
    //   18: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   30: ldc 45
    //   32: lconst_0
    //   33: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: ifnonnull +11 -> 51
    //   43: new 36	java/util/TreeMap
    //   46: dup
    //   47: invokespecial 37	java/util/TreeMap:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: aload_1
    //   53: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: aload_2
    //   59: ldc 45
    //   61: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   64: pop
    //   65: aload 4
    //   67: monitorexit
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload 4
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	c
    //   0	82	1	paramString	String
    //   38	21	2	localTreeMap1	TreeMap
    //   36	4	3	localTreeMap2	TreeMap
    // Exception table:
    //   from	to	target	type
    //   26	37	71	finally
    //   43	51	71	finally
    //   51	68	71	finally
    //   72	75	71	finally
    //   2	26	77	finally
    //   75	77	77	finally
  }
  
  /* Error */
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 85	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 763
    //   12: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc 152
    //   31: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: aload_2
    //   46: invokevirtual 679	oicq/wlogin_sdk/request/c:b	(Ljava/lang/Long;)Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +13 -> 66
    //   56: aload_0
    //   57: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   60: aload 5
    //   62: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: new 305	oicq/wlogin_sdk/request/UinInfo
    //   69: dup
    //   70: aload_2
    //   71: iload_3
    //   72: invokespecial 766	oicq/wlogin_sdk/request/UinInfo:<init>	(Ljava/lang/Long;Z)V
    //   75: astore 7
    //   77: aload_0
    //   78: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 538	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   92: ifnull +70 -> 162
    //   95: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   98: astore 6
    //   100: aload 6
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   107: ldc 45
    //   109: lconst_0
    //   110: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   113: astore 4
    //   115: aload 4
    //   117: astore_2
    //   118: aload 4
    //   120: ifnonnull +11 -> 131
    //   123: new 36	java/util/TreeMap
    //   126: dup
    //   127: invokespecial 37	java/util/TreeMap:<init>	()V
    //   130: astore_2
    //   131: aload 5
    //   133: ifnull +10 -> 143
    //   136: aload_2
    //   137: aload 5
    //   139: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_2
    //   144: aload_1
    //   145: aload 7
    //   147: invokevirtual 538	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: aload_2
    //   153: ldc 45
    //   155: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   158: pop
    //   159: aload 6
    //   161: monitorexit
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: astore_1
    //   166: aload 6
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	c
    //   0	176	1	paramString	String
    //   0	176	2	paramLong	Long
    //   0	176	3	paramBoolean	boolean
    //   113	6	4	localTreeMap	TreeMap
    //   49	89	5	str	String
    //   75	71	7	localUinInfo	UinInfo
    // Exception table:
    //   from	to	target	type
    //   103	115	165	finally
    //   123	131	165	finally
    //   136	143	165	finally
    //   143	162	165	finally
    //   166	169	165	finally
    //   2	51	171	finally
    //   56	66	171	finally
    //   66	103	171	finally
    //   169	171	171	finally
  }
  
  public int b(TreeMap paramTreeMap, String paramString)
  {
    return a(this.a, paramTreeMap, paramString, t.C);
  }
  
  /* Error */
  public String b(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   6: invokevirtual 264	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   9: invokeinterface 270 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 275 1 0
    //   23: ifeq +52 -> 75
    //   26: aload 4
    //   28: invokeinterface 278 1 0
    //   33: checkcast 61	java/lang/String
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   41: aload_3
    //   42: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 305	oicq/wlogin_sdk/request/UinInfo
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull -36 -> 16
    //   55: aload 5
    //   57: getfield 311	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   60: aload_1
    //   61: invokevirtual 767	java/lang/Long:equals	(Ljava/lang/Object;)Z
    //   64: istore_2
    //   65: iload_2
    //   66: ifeq -50 -> 16
    //   69: aload_3
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: areturn
    //   75: aconst_null
    //   76: astore_1
    //   77: goto -6 -> 71
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	c
    //   0	85	1	paramLong	Long
    //   64	2	2	bool	boolean
    //   36	34	3	str	String
    //   14	13	4	localIterator	Iterator
    //   48	8	5	localUinInfo	UinInfo
    // Exception table:
    //   from	to	target	type
    //   2	16	80	finally
    //   16	50	80	finally
    //   55	65	80	finally
  }
  
  /* Error */
  public WloginSimpleInfo b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 770
    //   5: new 85	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 772
    //   15: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: lload_1
    //   30: invokevirtual 774	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull +9 -> 44
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: aload_3
    //   45: getfield 686	oicq/wlogin_sdk/request/WloginAllSigInfo:_useInfo	Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   48: invokevirtual 777	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:get_clone	()Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   51: astore_3
    //   52: goto -12 -> 40
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	c
    //   0	60	1	paramLong	long
    //   33	19	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	55	finally
    //   44	52	55	finally
  }
  
  /* Error */
  public void b(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 85	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 780
    //   18: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   35: ldc 152
    //   37: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   54: ifnull +113 -> 167
    //   57: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   69: ldc 59
    //   71: lload_1
    //   72: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +81 -> 164
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 284	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   98: astore 9
    //   100: aload 9
    //   102: ifnonnull +9 -> 111
    //   105: aload 7
    //   107: monitorexit
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: ldc_w 782
    //   114: new 85	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   121: ldc 152
    //   123: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: lload_1
    //   127: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 9
    //   138: lload_3
    //   139: iconst_0
    //   140: newarray byte
    //   142: iconst_0
    //   143: newarray byte
    //   145: invokevirtual 786	oicq/wlogin_sdk/request/WloginAllSigInfo:putNewST	(J[B[B)V
    //   148: aload_0
    //   149: aload 8
    //   151: ldc 59
    //   153: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   156: istore 5
    //   158: aload_0
    //   159: aload 8
    //   161: putfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   164: aload 7
    //   166: monitorexit
    //   167: new 85	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 788
    //   177: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 5
    //   182: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: new 85	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   195: ldc 152
    //   197: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload_1
    //   201: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: goto -102 -> 108
    //   213: astore 7
    //   215: aload_0
    //   216: monitorexit
    //   217: aload 7
    //   219: athrow
    //   220: astore 8
    //   222: aload 7
    //   224: monitorexit
    //   225: aload 8
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	c
    //   0	228	1	paramLong1	long
    //   0	228	3	paramLong2	long
    //   1	180	5	i	int
    //   4	74	6	j	int
    //   213	10	7	localObject2	Object
    //   75	85	8	localTreeMap	TreeMap
    //   220	6	8	localObject3	Object
    //   98	39	9	localWloginAllSigInfo	WloginAllSigInfo
    // Exception table:
    //   from	to	target	type
    //   8	50	213	finally
    //   50	65	213	finally
    //   167	210	213	finally
    //   225	228	213	finally
    //   65	77	220	finally
    //   86	100	220	finally
    //   105	108	220	finally
    //   111	164	220	finally
    //   164	167	220	finally
    //   222	225	220	finally
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 85	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 790
    //   21: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: ldc 152
    //   33: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   40: ifnull +26 -> 66
    //   43: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   53: ldc 45
    //   55: lconst_0
    //   56: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   59: astore_3
    //   60: aload_3
    //   61: ifnonnull +8 -> 69
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: aload_3
    //   70: aload_1
    //   71: invokevirtual 755	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_3
    //   77: ldc 45
    //   79: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_2
    //   84: monitorexit
    //   85: goto -19 -> 66
    //   88: astore_1
    //   89: aload_2
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	c
    //   0	98	1	paramString	String
    //   59	18	3	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   49	60	88	finally
    //   64	66	88	finally
    //   69	85	88	finally
    //   89	91	88	finally
    //   2	49	93	finally
    //   91	93	93	finally
  }
  
  /* Error */
  public void c(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 85	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 792
    //   12: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc 152
    //   31: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 167	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 284	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   58: astore 5
    //   60: aload 5
    //   62: ifnonnull +6 -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload 5
    //   70: getfield 292	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   73: lload_3
    //   74: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 563	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   83: astore 6
    //   85: aload 6
    //   87: ifnull -22 -> 65
    //   90: aload 6
    //   92: iconst_0
    //   93: newarray byte
    //   95: putfield 588	oicq/wlogin_sdk/sharemem/WloginSigInfo:_pt4Token	[B
    //   98: aload 6
    //   100: iconst_0
    //   101: newarray byte
    //   103: putfield 585	oicq/wlogin_sdk/sharemem/WloginSigInfo:_psKey	[B
    //   106: aload 6
    //   108: aconst_null
    //   109: putfield 796	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheTickets	Ljava/util/List;
    //   112: aload 6
    //   114: lconst_0
    //   115: putfield 799	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheUpdateStamp	J
    //   118: aload 5
    //   120: getfield 292	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   123: lload_1
    //   124: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aload 6
    //   129: invokevirtual 538	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_0
    //   134: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   137: ifnull -72 -> 65
    //   140: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   143: astore 6
    //   145: aload 6
    //   147: monitorenter
    //   148: aload_0
    //   149: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   152: ldc 59
    //   154: lload_1
    //   155: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   158: astore 7
    //   160: aload 7
    //   162: ifnull +30 -> 192
    //   165: aload 7
    //   167: lload_1
    //   168: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: aload 5
    //   173: invokevirtual 538	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload_0
    //   178: aload 7
    //   180: ldc 59
    //   182: invokevirtual 521	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   185: pop
    //   186: aload_0
    //   187: aload 7
    //   189: putfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   192: aload 6
    //   194: monitorexit
    //   195: goto -130 -> 65
    //   198: astore 5
    //   200: aload 6
    //   202: monitorexit
    //   203: aload 5
    //   205: athrow
    //   206: astore 5
    //   208: aload_0
    //   209: monitorexit
    //   210: aload 5
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	c
    //   0	213	1	paramLong1	long
    //   0	213	3	paramLong2	long
    //   58	114	5	localWloginAllSigInfo	WloginAllSigInfo
    //   198	6	5	localObject1	Object
    //   206	5	5	localObject2	Object
    //   158	30	7	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   148	160	198	finally
    //   165	192	198	finally
    //   192	195	198	finally
    //   200	203	198	finally
    //   2	60	206	finally
    //   68	85	206	finally
    //   90	148	206	finally
    //   203	206	206	finally
  }
  
  /* Error */
  public WloginSigInfo d(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: invokevirtual 774	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   7: astore 5
    //   9: aload 5
    //   11: ifnonnull +11 -> 22
    //   14: aconst_null
    //   15: astore 5
    //   17: aload_0
    //   18: monitorexit
    //   19: aload 5
    //   21: areturn
    //   22: aload 5
    //   24: getfield 292	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   27: lload_3
    //   28: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: invokevirtual 282	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 563	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   37: astore 6
    //   39: aload 6
    //   41: astore 5
    //   43: aload 6
    //   45: ifnonnull -28 -> 17
    //   48: aconst_null
    //   49: astore 5
    //   51: goto -34 -> 17
    //   54: astore 5
    //   56: aload_0
    //   57: monitorexit
    //   58: aload 5
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	c
    //   0	61	1	paramLong1	long
    //   0	61	3	paramLong2	long
    //   7	43	5	localObject1	Object
    //   54	5	5	localObject2	Object
    //   37	7	6	localWloginSigInfo	WloginSigInfo
    // Exception table:
    //   from	to	target	type
    //   2	9	54	finally
    //   22	39	54	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */