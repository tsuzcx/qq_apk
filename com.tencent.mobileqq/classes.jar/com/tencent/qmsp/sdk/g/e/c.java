package com.tencent.qmsp.sdk.g.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;

public class c
{
  public static volatile c g;
  public b a = new b("udid");
  public b b = new b("oaid");
  public b c = new b("aaid");
  public b d = new b("vaid");
  public Boolean e;
  public BroadcastReceiver f;
  
  public static final c a()
  {
    if (g == null) {
      try
      {
        g = new c();
      }
      finally {}
    }
    return g;
  }
  
  public static e a(Cursor paramCursor)
  {
    e locale = new e(null, 0);
    if (paramCursor == null) {
      paramCursor = "parseValue fail, cursor is null.";
    }
    for (;;)
    {
      b(paramCursor);
      return locale;
      if (!paramCursor.isClosed())
      {
        paramCursor.moveToFirst();
        int i = paramCursor.getColumnIndex("value");
        if (i >= 0) {
          locale.c = paramCursor.getString(i);
        } else {
          b("parseValue fail, index < 0.");
        }
        i = paramCursor.getColumnIndex("code");
        if (i >= 0) {
          locale.a = paramCursor.getInt(i);
        } else {
          b("parseCode fail, index < 0.");
        }
        i = paramCursor.getColumnIndex("expired");
        if (i >= 0)
        {
          locale.b = paramCursor.getLong(i);
          return locale;
        }
        paramCursor = "parseExpired fail, index < 0.";
      }
      else
      {
        paramCursor = "parseValue fail, cursor is closed.";
      }
    }
  }
  
  public static void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MzOpenIdManager ");
    localStringBuilder.append(paramString);
    com.tencent.qmsp.sdk.base.c.a(localStringBuilder.toString());
  }
  
  public b a(String paramString)
  {
    if ("oaid".equals(paramString)) {
      return this.b;
    }
    if ("vaid".equals(paramString)) {
      return this.d;
    }
    if ("aaid".equals(paramString)) {
      return this.c;
    }
    if (!"udid".equals(paramString)) {
      return null;
    }
    return this.a;
  }
  
  /* Error */
  public final String a(Context paramContext, b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_2
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_2
    //   13: invokevirtual 132	com/tencent/qmsp/sdk/g/e/b:a	()Z
    //   16: ifne +397 -> 413
    //   19: new 105	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: ldc 134
    //   32: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: aload_2
    //   39: getfield 135	com/tencent/qmsp/sdk/g/e/b:c	Ljava/lang/String;
    //   42: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   54: ldc 137
    //   56: invokestatic 143	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   59: astore 5
    //   61: aload_1
    //   62: invokevirtual 149	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   65: aload 5
    //   67: aconst_null
    //   68: aconst_null
    //   69: iconst_1
    //   70: anewarray 123	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: aload_2
    //   76: getfield 135	com/tencent/qmsp/sdk/g/e/b:c	Ljava/lang/String;
    //   79: aastore
    //   80: aconst_null
    //   81: invokevirtual 155	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore 5
    //   86: aload 5
    //   88: ifnonnull +61 -> 149
    //   91: aload_0
    //   92: aload_1
    //   93: iconst_0
    //   94: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   97: pop
    //   98: aload_0
    //   99: aload_1
    //   100: iconst_1
    //   101: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   104: istore 4
    //   106: new 105	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   113: astore_1
    //   114: aload_1
    //   115: ldc 160
    //   117: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: iload 4
    //   124: invokevirtual 163	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_1
    //   129: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   135: aload 5
    //   137: ifnull +10 -> 147
    //   140: aload 5
    //   142: invokeinterface 166 1 0
    //   147: aconst_null
    //   148: areturn
    //   149: aload 5
    //   151: invokestatic 168	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/database/Cursor;)Lcom/tencent/qmsp/sdk/g/e/e;
    //   154: astore 8
    //   156: aload 8
    //   158: getfield 77	com/tencent/qmsp/sdk/g/e/e:c	Ljava/lang/String;
    //   161: astore 7
    //   163: aload_2
    //   164: aload 7
    //   166: invokevirtual 169	com/tencent/qmsp/sdk/g/e/b:a	(Ljava/lang/String;)V
    //   169: aload_2
    //   170: aload 8
    //   172: getfield 99	com/tencent/qmsp/sdk/g/e/e:b	J
    //   175: invokevirtual 172	com/tencent/qmsp/sdk/g/e/b:a	(J)V
    //   178: aload_2
    //   179: aload 8
    //   181: getfield 88	com/tencent/qmsp/sdk/g/e/e:a	I
    //   184: invokevirtual 175	com/tencent/qmsp/sdk/g/e/b:a	(I)V
    //   187: new 105	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   194: astore 9
    //   196: aload 9
    //   198: aload_2
    //   199: getfield 135	com/tencent/qmsp/sdk/g/e/b:c	Ljava/lang/String;
    //   202: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 9
    //   208: ldc 177
    //   210: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 9
    //   216: aload_2
    //   217: getfield 178	com/tencent/qmsp/sdk/g/e/b:a	I
    //   220: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 9
    //   226: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   232: aload 8
    //   234: getfield 88	com/tencent/qmsp/sdk/g/e/e:a	I
    //   237: istore_3
    //   238: iload_3
    //   239: sipush 1000
    //   242: if_icmpne +18 -> 260
    //   245: aload 5
    //   247: ifnull +10 -> 257
    //   250: aload 5
    //   252: invokeinterface 166 1 0
    //   257: aload 7
    //   259: areturn
    //   260: aload_0
    //   261: aload_1
    //   262: invokevirtual 184	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;)V
    //   265: aload_0
    //   266: aload_1
    //   267: iconst_0
    //   268: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   271: istore 4
    //   273: iload 4
    //   275: ifeq +18 -> 293
    //   278: aload 5
    //   280: ifnull +10 -> 290
    //   283: aload 5
    //   285: invokeinterface 166 1 0
    //   290: aload 7
    //   292: areturn
    //   293: aload_0
    //   294: aload_1
    //   295: iconst_1
    //   296: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   299: istore 4
    //   301: new 105	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   308: astore_1
    //   309: aload_1
    //   310: ldc 186
    //   312: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: iload 4
    //   319: invokevirtual 163	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_1
    //   324: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   330: aload 5
    //   332: ifnull +10 -> 342
    //   335: aload 5
    //   337: invokeinterface 166 1 0
    //   342: aload 7
    //   344: areturn
    //   345: aload 6
    //   347: astore_1
    //   348: aload 5
    //   350: ifnull +68 -> 418
    //   353: goto +51 -> 404
    //   356: astore_2
    //   357: aload 5
    //   359: astore_1
    //   360: goto +21 -> 381
    //   363: aload 5
    //   365: ifnull +10 -> 375
    //   368: aload 5
    //   370: invokeinterface 166 1 0
    //   375: aconst_null
    //   376: areturn
    //   377: astore_2
    //   378: aload 7
    //   380: astore_1
    //   381: aload_1
    //   382: ifnull +9 -> 391
    //   385: aload_1
    //   386: invokeinterface 166 1 0
    //   391: aload_2
    //   392: athrow
    //   393: aconst_null
    //   394: astore 5
    //   396: aload 6
    //   398: astore_1
    //   399: aload 5
    //   401: ifnull +17 -> 418
    //   404: aload 5
    //   406: invokeinterface 166 1 0
    //   411: aconst_null
    //   412: areturn
    //   413: aload_2
    //   414: getfield 188	com/tencent/qmsp/sdk/g/e/b:d	Ljava/lang/String;
    //   417: astore_1
    //   418: aload_1
    //   419: areturn
    //   420: astore_1
    //   421: goto -28 -> 393
    //   424: astore_1
    //   425: goto -29 -> 396
    //   428: astore_1
    //   429: goto -66 -> 363
    //   432: astore_1
    //   433: goto -88 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	c
    //   0	436	1	paramContext	Context
    //   0	436	2	paramb	b
    //   237	6	3	i	int
    //   104	214	4	bool	boolean
    //   26	379	5	localObject1	Object
    //   1	396	6	localObject2	Object
    //   4	375	7	str	String
    //   154	79	8	locale	e
    //   194	31	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   91	114	356	finally
    //   114	135	356	finally
    //   149	163	356	finally
    //   163	206	356	finally
    //   206	238	356	finally
    //   260	273	356	finally
    //   293	309	356	finally
    //   309	330	356	finally
    //   61	86	377	finally
    //   61	86	420	java/lang/Exception
    //   91	114	424	java/lang/Exception
    //   114	135	424	java/lang/Exception
    //   149	163	428	java/lang/Exception
    //   163	206	432	java/lang/Exception
    //   206	238	432	java/lang/Exception
    //   260	273	432	java/lang/Exception
    //   293	309	432	java/lang/Exception
    //   309	330	432	java/lang/Exception
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      if (this.f == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        this.f = new a();
        BroadcastReceiver localBroadcastReceiver = this.f;
        paramContext.registerReceiver(localBroadcastReceiver, localIntentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   4: astore 4
    //   6: iconst_0
    //   7: invokestatic 215	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   10: astore 8
    //   12: aload 4
    //   14: ifnull +13 -> 27
    //   17: iload_2
    //   18: ifne +9 -> 27
    //   21: aload 4
    //   23: invokevirtual 218	java/lang/Boolean:booleanValue	()Z
    //   26: ireturn
    //   27: aload_1
    //   28: ifnonnull +8 -> 36
    //   31: iconst_0
    //   32: istore_3
    //   33: goto +35 -> 68
    //   36: aload_1
    //   37: invokevirtual 222	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnonnull +8 -> 52
    //   47: iconst_0
    //   48: istore_3
    //   49: goto +5 -> 54
    //   52: iconst_1
    //   53: istore_3
    //   54: aload 4
    //   56: ldc 224
    //   58: iconst_0
    //   59: invokevirtual 230	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   62: ifnonnull +6 -> 68
    //   65: goto -34 -> 31
    //   68: iload_3
    //   69: ifne +16 -> 85
    //   72: ldc 232
    //   74: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: aload 8
    //   80: putfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   83: iconst_0
    //   84: ireturn
    //   85: ldc 137
    //   87: invokestatic 143	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   90: astore 9
    //   92: aconst_null
    //   93: astore 7
    //   95: aconst_null
    //   96: astore 6
    //   98: aload 6
    //   100: astore 5
    //   102: aload 7
    //   104: astore 4
    //   106: aload_1
    //   107: invokevirtual 149	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   110: astore_1
    //   111: aload 6
    //   113: astore 5
    //   115: aload 7
    //   117: astore 4
    //   119: aload_1
    //   120: aload 9
    //   122: aconst_null
    //   123: aconst_null
    //   124: iconst_1
    //   125: anewarray 123	java/lang/String
    //   128: dup
    //   129: iconst_0
    //   130: ldc 234
    //   132: aastore
    //   133: aconst_null
    //   134: invokevirtual 155	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   137: astore_1
    //   138: aload_1
    //   139: ifnonnull +15 -> 154
    //   142: aload_1
    //   143: astore 5
    //   145: aload_1
    //   146: astore 4
    //   148: aload_0
    //   149: aload 8
    //   151: putfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   154: aload_1
    //   155: astore 5
    //   157: aload_1
    //   158: invokestatic 168	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/database/Cursor;)Lcom/tencent/qmsp/sdk/g/e/e;
    //   161: getfield 77	com/tencent/qmsp/sdk/g/e/e:c	Ljava/lang/String;
    //   164: astore 4
    //   166: aload_1
    //   167: astore 5
    //   169: new 105	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   176: astore 6
    //   178: aload_1
    //   179: astore 5
    //   181: aload 6
    //   183: ldc 236
    //   185: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_1
    //   190: astore 5
    //   192: aload 6
    //   194: aload 4
    //   196: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_1
    //   201: astore 5
    //   203: aload 6
    //   205: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   211: aload_1
    //   212: astore 5
    //   214: aload_0
    //   215: ldc 238
    //   217: aload 4
    //   219: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   222: invokestatic 215	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   225: putfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   228: aload_1
    //   229: astore 5
    //   231: aload_0
    //   232: getfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   235: invokevirtual 218	java/lang/Boolean:booleanValue	()Z
    //   238: istore_2
    //   239: aload_1
    //   240: ifnull +9 -> 249
    //   243: aload_1
    //   244: invokeinterface 166 1 0
    //   249: iload_2
    //   250: ireturn
    //   251: astore_1
    //   252: goto +10 -> 262
    //   255: aload_1
    //   256: ifnull +34 -> 290
    //   259: goto +25 -> 284
    //   262: aload 5
    //   264: ifnull +10 -> 274
    //   267: aload 5
    //   269: invokeinterface 166 1 0
    //   274: aload_1
    //   275: athrow
    //   276: aload 4
    //   278: ifnull +12 -> 290
    //   281: aload 4
    //   283: astore_1
    //   284: aload_1
    //   285: invokeinterface 166 1 0
    //   290: iconst_0
    //   291: ireturn
    //   292: astore_1
    //   293: goto -17 -> 276
    //   296: astore 4
    //   298: goto -43 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	c
    //   0	301	1	paramContext	Context
    //   0	301	2	paramBoolean	boolean
    //   32	37	3	i	int
    //   4	278	4	localObject1	Object
    //   296	1	4	localException	java.lang.Exception
    //   100	168	5	localObject2	Object
    //   96	108	6	localStringBuilder	StringBuilder
    //   93	23	7	localObject3	Object
    //   10	140	8	localBoolean	Boolean
    //   90	31	9	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   106	111	251	finally
    //   119	138	251	finally
    //   148	154	251	finally
    //   157	166	251	finally
    //   169	178	251	finally
    //   181	189	251	finally
    //   192	200	251	finally
    //   203	211	251	finally
    //   214	228	251	finally
    //   231	239	251	finally
    //   106	111	292	java/lang/Exception
    //   119	138	292	java/lang/Exception
    //   148	154	292	java/lang/Exception
    //   157	166	296	java/lang/Exception
    //   169	178	296	java/lang/Exception
    //   181	189	296	java/lang/Exception
    //   192	200	296	java/lang/Exception
    //   203	211	296	java/lang/Exception
    //   214	228	296	java/lang/Exception
    //   231	239	296	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.e.c
 * JD-Core Version:    0.7.0.1
 */