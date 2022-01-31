package com.tencent.tvkbeacon.g;

import android.content.Context;
import com.tencent.tvkbeacon.core.c.a;

public final class d
{
  private static String a = "tencent/beacon/meta_";
  
  private static String a()
  {
    int k = 0;
    byte[] arrayOfByte1 = new byte[15];
    byte[] tmp8_7 = arrayOfByte1;
    tmp8_7[0] = 64;
    byte[] tmp13_8 = tmp8_7;
    tmp13_8[1] = 38;
    byte[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 40;
    byte[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 42;
    byte[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 35;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 72;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 78;
    byte[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 75;
    byte[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 74;
    byte[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 103;
    byte[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 49;
    byte[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 50;
    byte[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 33;
    byte[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 64;
    byte[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 41;
    tmp86_80;
    byte[] arrayOfByte2 = new byte[6];
    byte[] tmp101_99 = arrayOfByte2;
    tmp101_99[0] = 27;
    byte[] tmp106_101 = tmp101_99;
    tmp106_101[1] = 81;
    byte[] tmp111_106 = tmp106_101;
    tmp111_106[2] = 19;
    byte[] tmp116_111 = tmp111_106;
    tmp116_111[3] = 34;
    byte[] tmp121_116 = tmp116_111;
    tmp121_116[4] = 88;
    byte[] tmp126_121 = tmp121_116;
    tmp126_121[5] = 32;
    tmp126_121;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 15) {
        break;
      }
      arrayOfByte1[i] = ((byte)(arrayOfByte1[i] ^ arrayOfByte2[(i % 6)]));
      i += 1;
    }
    while (j < 15)
    {
      arrayOfByte1[j] = ((byte)(arrayOfByte1[j] ^ arrayOfByte2[(j % 6)]));
      j += 1;
    }
    return new String(arrayOfByte1);
  }
  
  public static String a(Context paramContext)
  {
    com.tencent.tvkbeacon.core.a.c localc = com.tencent.tvkbeacon.core.a.c.a(paramContext);
    Object localObject2 = localc.a("QIMEI_DENGTA", "");
    com.tencent.tvkbeacon.core.c.c.b("[qimei] get QIMEI:%s from sp", new Object[] { localObject2 });
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).trim().equals("")) {}
    }
    else
    {
      com.tencent.tvkbeacon.core.info.d.a(paramContext);
      localObject1 = localObject2;
      if (com.tencent.tvkbeacon.core.info.d.g())
      {
        localObject1 = localObject2;
        if (f(paramContext))
        {
          localObject1 = b(paramContext, a);
          com.tencent.tvkbeacon.core.c.c.b("[qimei] get QIMEI:%s from sdcard(AppKey)", new Object[] { localObject1 });
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (!((String)localObject1).trim().equals("")) {}
        }
        else
        {
          localObject2 = b(paramContext, "tencent/beacon/meta.dat");
          com.tencent.tvkbeacon.core.c.c.b("[qimei] get QIMEI:%s from sdcard", new Object[] { localObject2 });
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).trim().equals(""))
          {
            com.tencent.tvkbeacon.core.c.c.b("[qimei] Save QIMEI:%s to sp", new Object[] { localObject2 });
            localc.a().a("QIMEI_DENGTA", localObject2).b();
            localObject1 = localObject2;
          }
        }
      }
    }
    paramContext = (Context)localObject1;
    if (localObject1 == null) {
      paramContext = "";
    }
    com.tencent.tvkbeacon.core.c.c.a("[qimei] load QIMEI:%s from sp/sdcard", new Object[] { paramContext });
    return paramContext;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {
      return;
    }
    com.tencent.tvkbeacon.core.info.d.a(paramContext);
    if (com.tencent.tvkbeacon.core.info.d.g())
    {
      if (f(paramContext))
      {
        com.tencent.tvkbeacon.core.c.c.b("[qimei] Save QIMEI: %s to SDCard(AppKey)", new Object[] { paramString });
        a(paramContext, paramString, a);
      }
      com.tencent.tvkbeacon.core.c.c.b("[qimei] Save QIMEI:%s to SDCard", new Object[] { paramString });
      a(paramContext, paramString, "tencent/beacon/meta.dat");
    }
    com.tencent.tvkbeacon.core.a.c.a(paramContext).a().a("QIMEI_DENGTA", paramString).b();
    com.tencent.tvkbeacon.core.c.c.b("[qimei] update QIMEI:%s, and save to sp.", new Object[] { paramString });
  }
  
  /* Error */
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 118
    //   3: invokestatic 123	com/tencent/tvkbeacon/core/info/a:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifne +13 -> 19
    //   9: ldc 125
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 61	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: return
    //   19: new 127	java/io/File
    //   22: dup
    //   23: invokestatic 133	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   26: aload_2
    //   27: invokespecial 136	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_2
    //   31: aconst_null
    //   32: astore_0
    //   33: aload_2
    //   34: invokevirtual 139	java/io/File:getParentFile	()Ljava/io/File;
    //   37: invokevirtual 142	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: aload_2
    //   42: invokevirtual 145	java/io/File:createNewFile	()Z
    //   45: pop
    //   46: new 147	java/io/FileOutputStream
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: aload_2
    //   58: aload_1
    //   59: invokevirtual 154	java/lang/String:getBytes	()[B
    //   62: invokestatic 156	com/tencent/tvkbeacon/g/d:a	()Ljava/lang/String;
    //   65: invokestatic 161	com/tencent/tvkbeacon/core/c/a:a	([BLjava/lang/String;)[B
    //   68: invokevirtual 164	java/io/FileOutputStream:write	([B)V
    //   71: aload_2
    //   72: astore_0
    //   73: aload_2
    //   74: invokevirtual 167	java/io/FileOutputStream:flush	()V
    //   77: aload_2
    //   78: invokestatic 170	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   81: return
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: astore_0
    //   87: ldc 172
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 175	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_1
    //   97: invokestatic 170	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   100: return
    //   101: astore_1
    //   102: aload_0
    //   103: invokestatic 170	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -7 -> 102
    //   112: astore_0
    //   113: aload_2
    //   114: astore_1
    //   115: goto -30 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramContext	Context
    //   0	118	1	paramString1	String
    //   0	118	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   33	55	82	java/lang/Exception
    //   33	55	101	finally
    //   57	71	108	finally
    //   73	77	108	finally
    //   87	96	108	finally
    //   57	71	112	java/lang/Exception
    //   73	77	112	java/lang/Exception
  }
  
  /* Error */
  private static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 177
    //   3: invokestatic 123	com/tencent/tvkbeacon/core/info/a:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifne +14 -> 20
    //   9: ldc 179
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 61	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aconst_null
    //   19: areturn
    //   20: new 127	java/io/File
    //   23: dup
    //   24: invokestatic 133	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   27: aload_1
    //   28: invokespecial 136	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   31: astore_2
    //   32: new 181	java/io/FileInputStream
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: aload_2
    //   44: invokevirtual 186	java/io/File:length	()J
    //   47: l2i
    //   48: newarray byte
    //   50: astore_2
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: aload_2
    //   55: invokevirtual 190	java/io/FileInputStream:read	([B)I
    //   58: pop
    //   59: aload_1
    //   60: astore_0
    //   61: aload_1
    //   62: invokevirtual 193	java/io/FileInputStream:close	()V
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokestatic 156	com/tencent/tvkbeacon/g/d:a	()Ljava/lang/String;
    //   71: invokestatic 195	com/tencent/tvkbeacon/core/c/a:b	([BLjava/lang/String;)[B
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +20 -> 96
    //   79: aload_1
    //   80: astore_0
    //   81: new 36	java/lang/String
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 40	java/lang/String:<init>	([B)V
    //   89: astore_2
    //   90: aload_1
    //   91: invokestatic 170	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   94: aload_2
    //   95: areturn
    //   96: aload_1
    //   97: invokestatic 170	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: ldc 197
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: invokevirtual 200	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   119: aastore
    //   120: invokestatic 175	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_1
    //   124: invokestatic 170	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_0
    //   133: astore_1
    //   134: aload_2
    //   135: invokestatic 170	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_0
    //   142: astore_2
    //   143: goto -9 -> 134
    //   146: astore_2
    //   147: goto -42 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramContext	Context
    //   0	150	1	paramString	String
    //   31	64	2	localObject1	Object
    //   102	14	2	localException1	java.lang.Exception
    //   131	12	2	localObject2	Object
    //   146	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   32	41	102	java/lang/Exception
    //   32	41	129	finally
    //   43	51	140	finally
    //   53	59	140	finally
    //   61	65	140	finally
    //   67	75	140	finally
    //   81	90	140	finally
    //   107	123	140	finally
    //   43	51	146	java/lang/Exception
    //   53	59	146	java/lang/Exception
    //   61	65	146	java/lang/Exception
    //   67	75	146	java/lang/Exception
    //   81	90	146	java/lang/Exception
  }
  
  public static boolean b(Context paramContext)
  {
    return (a.a().equals(e(paramContext))) && (d(paramContext) >= b.a(paramContext).b());
  }
  
  public static void c(Context paramContext)
  {
    int i = d(paramContext);
    if (!a.a().equals(e(paramContext)))
    {
      com.tencent.tvkbeacon.core.a.c.a(paramContext).a().a("GEN_QIMEI", a.a()).b();
      i = 0;
    }
    com.tencent.tvkbeacon.core.a.c.a(paramContext).a().a("GEN_QIMEI_TIMES", Integer.valueOf(i + 1)).b();
  }
  
  private static int d(Context paramContext)
  {
    return com.tencent.tvkbeacon.core.a.c.a(paramContext).a("GEN_QIMEI_TIMES");
  }
  
  private static String e(Context paramContext)
  {
    return com.tencent.tvkbeacon.core.a.c.a(paramContext).a("GEN_QIMEI", "");
  }
  
  private static boolean f(Context paramContext)
  {
    paramContext = com.tencent.tvkbeacon.core.info.b.a(paramContext);
    String str = paramContext.b();
    if (paramContext.a().equals(str)) {
      return false;
    }
    if (!a.contains(str)) {
      a = a.concat(str).concat(".dat");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.g.d
 * JD-Core Version:    0.7.0.1
 */