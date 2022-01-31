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
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: ldc 53
    //   9: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +244 -> 256
    //   15: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   18: ifnonnull +17 -> 35
    //   21: new 61	oicq/wlogin_sdk/request/b
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: aconst_null
    //   28: iconst_1
    //   29: invokespecial 64	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   32: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   35: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   38: invokevirtual 68	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 74	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   46: iconst_1
    //   47: invokestatic 77	oicq/wlogin_sdk/request/c:b	(Ljava/lang/String;Z)V
    //   50: aload_0
    //   51: new 79	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   58: ldc 82
    //   60: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 88
    //   69: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 90
    //   78: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokevirtual 97	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: aload_1
    //   89: iconst_1
    //   90: anewarray 55	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: ldc 99
    //   97: aastore
    //   98: ldc 101
    //   100: aconst_null
    //   101: aconst_null
    //   102: aconst_null
    //   103: aconst_null
    //   104: invokevirtual 105	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   107: astore 5
    //   109: aload 5
    //   111: invokeinterface 111 1 0
    //   116: ifne +57 -> 173
    //   119: aload_0
    //   120: new 79	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   127: ldc 113
    //   129: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 115
    //   138: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 117
    //   147: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: iconst_2
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iconst_0
    //   160: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: iconst_1
    //   167: newarray byte
    //   169: aastore
    //   170: invokevirtual 126	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_0
    //   174: new 79	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   181: ldc 128
    //   183: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 130
    //   192: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 132
    //   201: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_2
    //   214: aastore
    //   215: invokevirtual 126	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload 5
    //   220: ifnull +20 -> 240
    //   223: aload 5
    //   225: invokeinterface 136 1 0
    //   230: ifne +10 -> 240
    //   233: aload 5
    //   235: invokeinterface 139 1 0
    //   240: aload_0
    //   241: ifnull +11 -> 252
    //   244: iconst_1
    //   245: aload_0
    //   246: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   249: if_icmpne +3 -> 252
    //   252: iconst_0
    //   253: istore_3
    //   254: iload_3
    //   255: ireturn
    //   256: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   259: ifnonnull +17 -> 276
    //   262: new 61	oicq/wlogin_sdk/request/b
    //   265: dup
    //   266: aload_0
    //   267: aload_1
    //   268: aconst_null
    //   269: iconst_1
    //   270: invokespecial 64	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   273: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   276: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   279: invokevirtual 68	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   282: astore_0
    //   283: goto -241 -> 42
    //   286: astore 6
    //   288: aconst_null
    //   289: astore_0
    //   290: aload 5
    //   292: astore_2
    //   293: aload 6
    //   295: astore 5
    //   297: aload_1
    //   298: ldc 53
    //   300: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   303: ifeq +88 -> 391
    //   306: aconst_null
    //   307: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   310: aload 5
    //   312: ldc 144
    //   314: invokestatic 150	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   317: new 79	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   324: ldc 152
    //   326: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 5
    //   331: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   334: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: ldc 144
    //   342: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: sipush -1022
    //   348: istore 4
    //   350: aload_0
    //   351: ifnull +18 -> 369
    //   354: aload_0
    //   355: invokeinterface 136 1 0
    //   360: ifne +9 -> 369
    //   363: aload_0
    //   364: invokeinterface 139 1 0
    //   369: iload 4
    //   371: istore_3
    //   372: aload_2
    //   373: ifnull -119 -> 254
    //   376: iload 4
    //   378: istore_3
    //   379: iconst_1
    //   380: aload_2
    //   381: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   384: if_icmpne -130 -> 254
    //   387: sipush -1022
    //   390: ireturn
    //   391: aconst_null
    //   392: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   395: goto -85 -> 310
    //   398: astore 5
    //   400: aload_2
    //   401: astore_1
    //   402: aload_0
    //   403: astore_2
    //   404: aload 5
    //   406: astore_0
    //   407: aload_2
    //   408: ifnull +18 -> 426
    //   411: aload_2
    //   412: invokeinterface 136 1 0
    //   417: ifne +9 -> 426
    //   420: aload_2
    //   421: invokeinterface 139 1 0
    //   426: aload_1
    //   427: ifnull +11 -> 438
    //   430: iconst_1
    //   431: aload_1
    //   432: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   435: if_icmpne +3 -> 438
    //   438: aload_0
    //   439: athrow
    //   440: astore_0
    //   441: aconst_null
    //   442: astore_1
    //   443: aload 6
    //   445: astore_2
    //   446: goto -39 -> 407
    //   449: astore_2
    //   450: aload_0
    //   451: astore_1
    //   452: aload_2
    //   453: astore_0
    //   454: aload 6
    //   456: astore_2
    //   457: goto -50 -> 407
    //   460: astore 6
    //   462: aload 5
    //   464: astore_2
    //   465: aload_0
    //   466: astore_1
    //   467: aload 6
    //   469: astore_0
    //   470: goto -63 -> 407
    //   473: astore 5
    //   475: aconst_null
    //   476: astore 6
    //   478: aload_0
    //   479: astore_2
    //   480: aload 6
    //   482: astore_0
    //   483: goto -186 -> 297
    //   486: astore 6
    //   488: aload_0
    //   489: astore_2
    //   490: aload 6
    //   492: astore_0
    //   493: aload 5
    //   495: astore 6
    //   497: aload_0
    //   498: astore 5
    //   500: aload 6
    //   502: astore_0
    //   503: goto -206 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramContext	Context
    //   0	506	1	paramString	String
    //   0	506	2	paramArrayOfByte	byte[]
    //   253	126	3	i	int
    //   348	29	4	j	int
    //   4	326	5	localObject1	Object
    //   398	65	5	localObject2	Object
    //   473	21	5	localException1	Exception
    //   498	1	5	localContext	Context
    //   1	1	6	localObject3	Object
    //   286	169	6	localException2	Exception
    //   460	8	6	localObject4	Object
    //   476	5	6	localObject5	Object
    //   486	5	6	localException3	Exception
    //   495	6	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   6	35	286	java/lang/Exception
    //   35	42	286	java/lang/Exception
    //   256	276	286	java/lang/Exception
    //   276	283	286	java/lang/Exception
    //   297	310	398	finally
    //   310	345	398	finally
    //   391	395	398	finally
    //   6	35	440	finally
    //   35	42	440	finally
    //   256	276	440	finally
    //   276	283	440	finally
    //   42	109	449	finally
    //   109	173	460	finally
    //   173	218	460	finally
    //   42	109	473	java/lang/Exception
    //   109	173	486	java/lang/Exception
    //   173	218	486	java/lang/Exception
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
        localObject2 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, t.B);
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
      localObject3 = new SecretKeySpec(t.B, "DESede");
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
    //   1: astore 4
    //   3: iconst_0
    //   4: invokestatic 339	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7: astore 5
    //   9: aload_1
    //   10: ldc 53
    //   12: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +165 -> 180
    //   18: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   21: ifnonnull +17 -> 38
    //   24: new 61	oicq/wlogin_sdk/request/b
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aconst_null
    //   31: iconst_1
    //   32: invokespecial 64	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   35: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   38: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   41: invokevirtual 342	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 74	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   49: iconst_0
    //   50: invokestatic 77	oicq/wlogin_sdk/request/c:b	(Ljava/lang/String;Z)V
    //   53: aload_0
    //   54: new 79	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 344
    //   64: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 346
    //   74: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: aconst_null
    //   81: invokevirtual 350	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_3
    //   85: aload 5
    //   87: astore 4
    //   89: aload_3
    //   90: invokeinterface 353 1 0
    //   95: ifeq +23 -> 118
    //   98: aload 5
    //   100: astore 4
    //   102: aload_3
    //   103: iconst_0
    //   104: invokeinterface 357 2 0
    //   109: ifle +9 -> 118
    //   112: iconst_1
    //   113: invokestatic 339	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: astore 4
    //   118: aload_3
    //   119: ifnull +18 -> 137
    //   122: aload_3
    //   123: invokeinterface 136 1 0
    //   128: ifne +9 -> 137
    //   131: aload_3
    //   132: invokeinterface 139 1 0
    //   137: aload 4
    //   139: invokevirtual 360	java/lang/Boolean:booleanValue	()Z
    //   142: istore_2
    //   143: iload_2
    //   144: ifne +66 -> 210
    //   147: aload_3
    //   148: ifnull +18 -> 166
    //   151: aload_3
    //   152: invokeinterface 136 1 0
    //   157: ifne +9 -> 166
    //   160: aload_3
    //   161: invokeinterface 139 1 0
    //   166: aload_0
    //   167: ifnull +11 -> 178
    //   170: iconst_1
    //   171: aload_0
    //   172: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   175: if_icmpne +3 -> 178
    //   178: aconst_null
    //   179: areturn
    //   180: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   183: ifnonnull +17 -> 200
    //   186: new 61	oicq/wlogin_sdk/request/b
    //   189: dup
    //   190: aload_0
    //   191: aload_1
    //   192: aconst_null
    //   193: iconst_1
    //   194: invokespecial 64	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   197: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   200: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   203: invokevirtual 342	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   206: astore_0
    //   207: goto -162 -> 45
    //   210: aload_0
    //   211: aload_1
    //   212: iconst_1
    //   213: anewarray 55	java/lang/String
    //   216: dup
    //   217: iconst_0
    //   218: aload_1
    //   219: aastore
    //   220: ldc 101
    //   222: aconst_null
    //   223: aconst_null
    //   224: aconst_null
    //   225: aconst_null
    //   226: invokevirtual 105	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   229: astore 4
    //   231: aload 4
    //   233: ifnonnull +39 -> 272
    //   236: aload 4
    //   238: ifnull +20 -> 258
    //   241: aload 4
    //   243: invokeinterface 136 1 0
    //   248: ifne +10 -> 258
    //   251: aload 4
    //   253: invokeinterface 139 1 0
    //   258: aload_0
    //   259: ifnull +11 -> 270
    //   262: iconst_1
    //   263: aload_0
    //   264: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   267: if_icmpne +3 -> 270
    //   270: aconst_null
    //   271: areturn
    //   272: aload 4
    //   274: invokeinterface 363 1 0
    //   279: ifeq +55 -> 334
    //   282: aload 4
    //   284: iconst_0
    //   285: invokeinterface 367 2 0
    //   290: astore_3
    //   291: aload 4
    //   293: invokeinterface 139 1 0
    //   298: aload 4
    //   300: ifnull +20 -> 320
    //   303: aload 4
    //   305: invokeinterface 136 1 0
    //   310: ifne +10 -> 320
    //   313: aload 4
    //   315: invokeinterface 139 1 0
    //   320: aload_0
    //   321: ifnull +11 -> 332
    //   324: iconst_1
    //   325: aload_0
    //   326: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   329: if_icmpne +3 -> 332
    //   332: aload_3
    //   333: areturn
    //   334: aload 4
    //   336: invokeinterface 139 1 0
    //   341: aload 4
    //   343: ifnull +20 -> 363
    //   346: aload 4
    //   348: invokeinterface 136 1 0
    //   353: ifne +10 -> 363
    //   356: aload 4
    //   358: invokeinterface 139 1 0
    //   363: aload_0
    //   364: ifnull +11 -> 375
    //   367: iconst_1
    //   368: aload_0
    //   369: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   372: if_icmpne +3 -> 375
    //   375: aconst_null
    //   376: areturn
    //   377: astore 4
    //   379: aconst_null
    //   380: astore_0
    //   381: aconst_null
    //   382: astore_3
    //   383: aload_1
    //   384: ldc 53
    //   386: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   389: ifeq +47 -> 436
    //   392: aconst_null
    //   393: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   396: aload 4
    //   398: ldc 144
    //   400: invokestatic 150	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   403: aload_0
    //   404: ifnull +18 -> 422
    //   407: aload_0
    //   408: invokeinterface 136 1 0
    //   413: ifne +9 -> 422
    //   416: aload_0
    //   417: invokeinterface 139 1 0
    //   422: aload_3
    //   423: ifnull +11 -> 434
    //   426: iconst_1
    //   427: aload_3
    //   428: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   431: if_icmpne +3 -> 434
    //   434: aconst_null
    //   435: areturn
    //   436: aconst_null
    //   437: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   440: goto -44 -> 396
    //   443: astore 4
    //   445: aload_0
    //   446: astore_1
    //   447: aload 4
    //   449: astore_0
    //   450: aload_1
    //   451: ifnull +18 -> 469
    //   454: aload_1
    //   455: invokeinterface 136 1 0
    //   460: ifne +9 -> 469
    //   463: aload_1
    //   464: invokeinterface 139 1 0
    //   469: aload_3
    //   470: ifnull +11 -> 481
    //   473: iconst_1
    //   474: aload_3
    //   475: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   478: if_icmpne +3 -> 481
    //   481: aload_0
    //   482: athrow
    //   483: astore_0
    //   484: aconst_null
    //   485: astore_3
    //   486: aload 4
    //   488: astore_1
    //   489: goto -39 -> 450
    //   492: astore_1
    //   493: aload_0
    //   494: astore_3
    //   495: aload_1
    //   496: astore_0
    //   497: aload 4
    //   499: astore_1
    //   500: goto -50 -> 450
    //   503: astore 4
    //   505: aload_3
    //   506: astore_1
    //   507: aload_0
    //   508: astore_3
    //   509: aload 4
    //   511: astore_0
    //   512: goto -62 -> 450
    //   515: astore 5
    //   517: aload 4
    //   519: astore_1
    //   520: aload_0
    //   521: astore_3
    //   522: aload 5
    //   524: astore_0
    //   525: goto -75 -> 450
    //   528: astore 4
    //   530: aload_0
    //   531: astore_3
    //   532: aconst_null
    //   533: astore_0
    //   534: goto -151 -> 383
    //   537: astore 4
    //   539: aload_0
    //   540: astore 5
    //   542: aload_3
    //   543: astore_0
    //   544: aload 5
    //   546: astore_3
    //   547: goto -164 -> 383
    //   550: astore 6
    //   552: aload 4
    //   554: astore_3
    //   555: aload_0
    //   556: astore 5
    //   558: aload 6
    //   560: astore 4
    //   562: aload_3
    //   563: astore_0
    //   564: aload 5
    //   566: astore_3
    //   567: goto -184 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	paramContext	Context
    //   0	570	1	paramString	String
    //   142	2	2	bool	boolean
    //   84	483	3	localObject1	Object
    //   1	356	4	localObject2	Object
    //   377	20	4	localException1	Exception
    //   443	55	4	localObject3	Object
    //   503	15	4	localObject4	Object
    //   528	1	4	localException2	Exception
    //   537	16	4	localException3	Exception
    //   560	1	4	localObject5	Object
    //   7	92	5	localBoolean	java.lang.Boolean
    //   515	8	5	localObject6	Object
    //   540	25	5	localContext	Context
    //   550	9	6	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   9	38	377	java/lang/Exception
    //   38	45	377	java/lang/Exception
    //   180	200	377	java/lang/Exception
    //   200	207	377	java/lang/Exception
    //   383	396	443	finally
    //   396	403	443	finally
    //   436	440	443	finally
    //   9	38	483	finally
    //   38	45	483	finally
    //   180	200	483	finally
    //   200	207	483	finally
    //   45	85	492	finally
    //   89	98	503	finally
    //   102	118	503	finally
    //   122	137	503	finally
    //   137	143	503	finally
    //   210	231	503	finally
    //   272	298	515	finally
    //   334	341	515	finally
    //   45	85	528	java/lang/Exception
    //   89	98	537	java/lang/Exception
    //   102	118	537	java/lang/Exception
    //   122	137	537	java/lang/Exception
    //   137	143	537	java/lang/Exception
    //   210	231	537	java/lang/Exception
    //   272	298	550	java/lang/Exception
    //   334	341	550	java/lang/Exception
  }
  
  private static TreeMap b(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.B, "DESede");
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
  
  private static void b(String paramString, boolean paramBoolean)
  {
    long l = new File(paramString).lastModified();
    util.LOGI("file " + paramString + " last update time " + l + ",beforeWrite=" + paramBoolean, "");
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
    //   8: new 79	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 447
    //   18: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 79	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   35: ldc 144
    //   37: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   54: ifnull +116 -> 170
    //   57: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   69: ldc 53
    //   71: lload_1
    //   72: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +84 -> 167
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 276	oicq/wlogin_sdk/request/WloginAllSigInfo
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
    //   116: ldc_w 449
    //   119: new 79	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   126: ldc 144
    //   128: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: lload_1
    //   132: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 9
    //   143: lload_3
    //   144: iconst_0
    //   145: newarray byte
    //   147: invokevirtual 453	oicq/wlogin_sdk/request/WloginAllSigInfo:put_da2	(J[B)I
    //   150: pop
    //   151: aload_0
    //   152: aload 8
    //   154: ldc 53
    //   156: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   159: istore 5
    //   161: aload_0
    //   162: aload 8
    //   164: putfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   167: aload 7
    //   169: monitorexit
    //   170: new 79	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 458
    //   180: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload 5
    //   185: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: new 79	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   198: ldc 144
    //   200: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: lload_1
    //   204: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 461
    //   12: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 79	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   29: ldc 144
    //   31: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 276	oicq/wlogin_sdk/request/WloginAllSigInfo
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
    //   84: invokevirtual 465	oicq/wlogin_sdk/request/WloginAllSigInfo:put_siginfo	(JJJ[B[B)I
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
    //   112: ldc 53
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
    //   141: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: aload 13
    //   146: invokevirtual 469	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   149: invokevirtual 473	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload_0
    //   154: aload 9
    //   156: ldc 53
    //   158: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   11: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 297	oicq/wlogin_sdk/request/UinInfo
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +60 -> 79
    //   22: new 79	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 657
    //   32: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 659
    //   42: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: getfield 303	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   49: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 661
    //   55: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 664	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   62: invokevirtual 444	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 144
    //   70: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   113: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 297	oicq/wlogin_sdk/request/UinInfo
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
    //   135: invokevirtual 473	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: new 79	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 666
    //   149: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 659
    //   159: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_3
    //   163: getfield 303	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   166: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: ldc_w 661
    //   172: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 664	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   179: invokevirtual 444	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: ldc 144
    //   187: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   7: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 276	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +15 -> 33
    //   21: ldc_w 669
    //   24: ldc 144
    //   26: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   49: ldc 53
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
    //   67: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 276	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   76: astore_3
    //   77: aload_3
    //   78: ifnonnull +8 -> 86
    //   81: aconst_null
    //   82: astore_3
    //   83: goto -54 -> 29
    //   86: ldc_w 671
    //   89: ldc 144
    //   91: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   98: lload_1
    //   99: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: aload_3
    //   103: invokevirtual 473	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   2: ldc_w 689
    //   5: new 79	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   12: ldc 144
    //   14: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   31: aload_1
    //   32: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   53: ldc 53
    //   55: aload_1
    //   56: invokevirtual 553	java/lang/Long:longValue	()J
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
    //   74: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_0
    //   79: aload_3
    //   80: ldc 53
    //   82: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   7: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   53: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: aload_2
    //   59: ldc 45
    //   61: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 698
    //   12: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 79	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   29: ldc 144
    //   31: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: aload_2
    //   46: invokevirtual 614	oicq/wlogin_sdk/request/c:b	(Ljava/lang/Long;)Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +13 -> 66
    //   56: aload_0
    //   57: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   60: aload 5
    //   62: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: new 297	oicq/wlogin_sdk/request/UinInfo
    //   69: dup
    //   70: aload_2
    //   71: iload_3
    //   72: invokespecial 701	oicq/wlogin_sdk/request/UinInfo:<init>	(Ljava/lang/Long;Z)V
    //   75: astore 7
    //   77: aload_0
    //   78: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 473	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   139: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_2
    //   144: aload_1
    //   145: aload 7
    //   147: invokevirtual 473	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: aload_2
    //   153: ldc 45
    //   155: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    return a(this.a, paramTreeMap, paramString, t.B);
  }
  
  /* Error */
  public String b(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   6: invokevirtual 256	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   9: invokeinterface 262 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 267 1 0
    //   23: ifeq +52 -> 75
    //   26: aload 4
    //   28: invokeinterface 270 1 0
    //   33: checkcast 55	java/lang/String
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 41	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   41: aload_3
    //   42: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 297	oicq/wlogin_sdk/request/UinInfo
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull -36 -> 16
    //   55: aload 5
    //   57: getfield 303	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   60: aload_1
    //   61: invokevirtual 702	java/lang/Long:equals	(Ljava/lang/Object;)Z
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
    //   2: ldc_w 705
    //   5: new 79	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 707
    //   15: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: lload_1
    //   30: invokevirtual 709	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
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
    //   45: getfield 621	oicq/wlogin_sdk/request/WloginAllSigInfo:_useInfo	Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   48: invokevirtual 712	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:get_clone	()Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
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
    //   8: new 79	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 715
    //   18: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 79	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   35: ldc 144
    //   37: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   54: ifnull +113 -> 167
    //   57: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 43	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   69: ldc 53
    //   71: lload_1
    //   72: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +81 -> 164
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 276	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   98: astore 9
    //   100: aload 9
    //   102: ifnonnull +9 -> 111
    //   105: aload 7
    //   107: monitorexit
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: ldc_w 717
    //   114: new 79	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   121: ldc 144
    //   123: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: lload_1
    //   127: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 9
    //   138: lload_3
    //   139: iconst_0
    //   140: newarray byte
    //   142: iconst_0
    //   143: newarray byte
    //   145: invokevirtual 721	oicq/wlogin_sdk/request/WloginAllSigInfo:putNewST	(J[B[B)V
    //   148: aload_0
    //   149: aload 8
    //   151: ldc 53
    //   153: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   156: istore 5
    //   158: aload_0
    //   159: aload 8
    //   161: putfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   164: aload 7
    //   166: monitorexit
    //   167: new 79	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 723
    //   177: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 5
    //   182: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: new 79	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   195: ldc 144
    //   197: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload_1
    //   201: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   7: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 79	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 725
    //   21: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: ldc 144
    //   33: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   71: invokevirtual 690	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_3
    //   77: ldc 45
    //   79: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 727
    //   12: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 79	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   29: ldc 144
    //   31: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 39	oicq/wlogin_sdk/request/c:b	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 276	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   58: astore 5
    //   60: aload 5
    //   62: ifnonnull +6 -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload 5
    //   70: getfield 284	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   73: lload_3
    //   74: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 498	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   83: astore 6
    //   85: aload 6
    //   87: ifnull -22 -> 65
    //   90: aload 6
    //   92: iconst_0
    //   93: newarray byte
    //   95: putfield 523	oicq/wlogin_sdk/sharemem/WloginSigInfo:_pt4Token	[B
    //   98: aload 6
    //   100: iconst_0
    //   101: newarray byte
    //   103: putfield 520	oicq/wlogin_sdk/sharemem/WloginSigInfo:_psKey	[B
    //   106: aload 6
    //   108: aconst_null
    //   109: putfield 731	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheTickets	Ljava/util/List;
    //   112: aload 6
    //   114: lconst_0
    //   115: putfield 734	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheUpdateStamp	J
    //   118: aload 5
    //   120: getfield 284	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   123: lload_1
    //   124: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aload 6
    //   129: invokevirtual 473	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   152: ldc 53
    //   154: lload_1
    //   155: invokestatic 48	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   158: astore 7
    //   160: aload 7
    //   162: ifnull +30 -> 192
    //   165: aload 7
    //   167: lload_1
    //   168: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: aload 5
    //   173: invokevirtual 473	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload_0
    //   178: aload 7
    //   180: ldc 53
    //   182: invokevirtual 456	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   4: invokevirtual 709	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
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
    //   24: getfield 284	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   27: lload_3
    //   28: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: invokevirtual 274	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 498	oicq/wlogin_sdk/sharemem/WloginSigInfo
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