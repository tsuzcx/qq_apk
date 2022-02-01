package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

@TargetApi(16)
class e
{
  LongSparseArray<Integer> a;
  LongSparseArray<Drawable.ConstantState>[] b;
  SkinEngine c;
  g d;
  
  /* Error */
  public e(SkinEngine paramSkinEngine, Resources paramResources, int paramInt1, int paramInt2, int paramInt3, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 28	com/tencent/theme/e:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload 7
    //   12: arraylength
    //   13: anewarray 30	android/util/LongSparseArray
    //   16: putfield 32	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   19: aload 7
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 32	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   26: iconst_0
    //   27: aload 7
    //   29: arraylength
    //   30: invokestatic 38	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   33: aload_0
    //   34: new 30	android/util/LongSparseArray
    //   37: dup
    //   38: iload_3
    //   39: bipush 10
    //   41: iadd
    //   42: invokespecial 41	android/util/LongSparseArray:<init>	(I)V
    //   45: putfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   48: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   51: lstore 8
    //   53: aload 6
    //   55: ifnull +140 -> 195
    //   58: aload 6
    //   60: invokevirtual 55	java/io/File:exists	()Z
    //   63: ifeq +132 -> 195
    //   66: new 57	java/io/ObjectInputStream
    //   69: dup
    //   70: new 59	java/io/BufferedInputStream
    //   73: dup
    //   74: new 61	java/io/FileInputStream
    //   77: dup
    //   78: aload 6
    //   80: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: invokespecial 68	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 72	java/io/ObjectInputStream:available	()I
    //   94: ifle +30 -> 124
    //   97: aload_1
    //   98: invokevirtual 75	java/io/ObjectInputStream:readLong	()J
    //   101: lstore 10
    //   103: aload_1
    //   104: invokevirtual 78	java/io/ObjectInputStream:readInt	()I
    //   107: istore_3
    //   108: aload_0
    //   109: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   112: lload 10
    //   114: iload_3
    //   115: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   121: goto -31 -> 90
    //   124: aload_1
    //   125: invokevirtual 91	java/io/ObjectInputStream:close	()V
    //   128: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   131: ifeq +43 -> 174
    //   134: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   137: lstore 10
    //   139: new 99	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   146: astore_1
    //   147: aload_1
    //   148: ldc 102
    //   150: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_1
    //   155: lload 10
    //   157: lload 8
    //   159: lsub
    //   160: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 111
    //   166: aload_1
    //   167: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: return
    //   175: astore_1
    //   176: goto +307 -> 483
    //   179: astore_1
    //   180: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   183: ifeq +12 -> 195
    //   186: ldc 111
    //   188: ldc 122
    //   190: aload_1
    //   191: invokestatic 126	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   194: pop
    //   195: new 128	android/util/TypedValue
    //   198: dup
    //   199: invokespecial 129	android/util/TypedValue:<init>	()V
    //   202: astore_1
    //   203: new 99	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   210: astore 6
    //   212: aload 6
    //   214: ldc 131
    //   216: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 6
    //   222: iload 4
    //   224: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 6
    //   230: ldc 136
    //   232: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 6
    //   238: iload 5
    //   240: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 111
    //   246: iconst_1
    //   247: aload 6
    //   249: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 141	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: iload 4
    //   257: istore_3
    //   258: iload 4
    //   260: iload 5
    //   262: if_icmpge +174 -> 436
    //   265: aload_2
    //   266: iload_3
    //   267: aload_1
    //   268: iconst_1
    //   269: invokevirtual 147	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   272: aload_1
    //   273: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   276: ifnull +87 -> 363
    //   279: aload_1
    //   280: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   283: invokeinterface 154 1 0
    //   288: astore 6
    //   290: aload 6
    //   292: ldc 156
    //   294: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   297: ifne +33 -> 330
    //   300: aload 6
    //   302: ldc 164
    //   304: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   307: ifne +23 -> 330
    //   310: aload 6
    //   312: ldc 166
    //   314: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   317: ifne +13 -> 330
    //   320: aload 6
    //   322: ldc 168
    //   324: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   327: ifeq +36 -> 363
    //   330: aload_1
    //   331: getfield 172	android/util/TypedValue:assetCookie	I
    //   334: i2l
    //   335: lstore 10
    //   337: aload_1
    //   338: getfield 175	android/util/TypedValue:data	I
    //   341: i2l
    //   342: lstore 12
    //   344: aload_0
    //   345: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   348: lload 10
    //   350: bipush 32
    //   352: lshl
    //   353: lload 12
    //   355: lor
    //   356: iload_3
    //   357: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   363: iload_3
    //   364: iconst_1
    //   365: iadd
    //   366: istore_3
    //   367: iload 4
    //   369: iconst_1
    //   370: iadd
    //   371: istore 4
    //   373: goto -115 -> 258
    //   376: astore 6
    //   378: new 99	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   385: astore 7
    //   387: aload 7
    //   389: ldc 177
    //   391: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 7
    //   397: iload_3
    //   398: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 7
    //   404: ldc 179
    //   406: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 7
    //   412: aload_1
    //   413: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   416: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: ldc 111
    //   422: iconst_1
    //   423: aload 7
    //   425: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: aload 6
    //   430: invokestatic 185	com/tencent/theme/h:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   433: goto -70 -> 363
    //   436: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   439: ifeq +43 -> 482
    //   442: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   445: lstore 10
    //   447: new 99	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   454: astore_1
    //   455: aload_1
    //   456: ldc 102
    //   458: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload_1
    //   463: lload 10
    //   465: lload 8
    //   467: lsub
    //   468: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: ldc 111
    //   474: aload_1
    //   475: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   481: pop
    //   482: return
    //   483: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   486: ifeq +43 -> 529
    //   489: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   492: lstore 10
    //   494: new 99	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   501: astore_2
    //   502: aload_2
    //   503: ldc 102
    //   505: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_2
    //   510: lload 10
    //   512: lload 8
    //   514: lsub
    //   515: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: ldc 111
    //   521: aload_2
    //   522: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   528: pop
    //   529: goto +5 -> 534
    //   532: aload_1
    //   533: athrow
    //   534: goto -2 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	e
    //   0	537	1	paramSkinEngine	SkinEngine
    //   0	537	2	paramResources	Resources
    //   0	537	3	paramInt1	int
    //   0	537	4	paramInt2	int
    //   0	537	5	paramInt3	int
    //   0	537	6	paramFile	File
    //   0	537	7	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   51	462	8	l1	long
    //   101	410	10	l2	long
    //   342	12	12	l3	long
    // Exception table:
    //   from	to	target	type
    //   58	90	175	finally
    //   90	121	175	finally
    //   124	128	175	finally
    //   180	195	175	finally
    //   195	255	175	finally
    //   265	330	175	finally
    //   330	363	175	finally
    //   378	433	175	finally
    //   58	90	179	java/io/IOException
    //   90	121	179	java/io/IOException
    //   124	128	179	java/io/IOException
    //   265	330	376	java/lang/Throwable
    //   330	363	376	java/lang/Throwable
  }
  
  /* Error */
  public e(SkinEngine paramSkinEngine, Resources paramResources, int[] paramArrayOfInt, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: ldc 111
    //   6: iconst_1
    //   7: ldc 191
    //   9: invokestatic 141	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: aload_0
    //   13: aload_1
    //   14: putfield 28	com/tencent/theme/e:c	Lcom/tencent/theme/SkinEngine;
    //   17: aload_0
    //   18: aload 5
    //   20: arraylength
    //   21: anewarray 30	android/util/LongSparseArray
    //   24: putfield 32	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   27: aload_0
    //   28: getfield 32	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   31: astore_1
    //   32: aload 5
    //   34: arraylength
    //   35: istore 7
    //   37: iconst_0
    //   38: istore 6
    //   40: aload 5
    //   42: iconst_0
    //   43: aload_1
    //   44: iconst_0
    //   45: iload 7
    //   47: invokestatic 38	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   50: aload_0
    //   51: new 30	android/util/LongSparseArray
    //   54: dup
    //   55: aload_3
    //   56: arraylength
    //   57: invokespecial 41	android/util/LongSparseArray:<init>	(I)V
    //   60: putfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   63: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   66: lstore 9
    //   68: aload 4
    //   70: ifnull +142 -> 212
    //   73: aload 4
    //   75: invokevirtual 55	java/io/File:exists	()Z
    //   78: ifeq +134 -> 212
    //   81: new 57	java/io/ObjectInputStream
    //   84: dup
    //   85: new 59	java/io/BufferedInputStream
    //   88: dup
    //   89: new 61	java/io/FileInputStream
    //   92: dup
    //   93: aload 4
    //   95: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   101: invokespecial 68	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 72	java/io/ObjectInputStream:available	()I
    //   109: ifle +32 -> 141
    //   112: aload_1
    //   113: invokevirtual 75	java/io/ObjectInputStream:readLong	()J
    //   116: lstore 11
    //   118: aload_1
    //   119: invokevirtual 78	java/io/ObjectInputStream:readInt	()I
    //   122: istore 7
    //   124: aload_0
    //   125: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   128: lload 11
    //   130: iload 7
    //   132: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   138: goto -33 -> 105
    //   141: aload_1
    //   142: invokevirtual 91	java/io/ObjectInputStream:close	()V
    //   145: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   148: ifeq +43 -> 191
    //   151: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   154: lstore 11
    //   156: new 99	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   163: astore_1
    //   164: aload_1
    //   165: ldc 102
    //   167: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_1
    //   172: lload 11
    //   174: lload 9
    //   176: lsub
    //   177: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 111
    //   183: aload_1
    //   184: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   190: pop
    //   191: return
    //   192: astore_1
    //   193: goto +200 -> 393
    //   196: astore_1
    //   197: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   200: ifeq +12 -> 212
    //   203: ldc 111
    //   205: ldc 122
    //   207: aload_1
    //   208: invokestatic 126	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   211: pop
    //   212: new 128	android/util/TypedValue
    //   215: dup
    //   216: invokespecial 129	android/util/TypedValue:<init>	()V
    //   219: astore_1
    //   220: aload_3
    //   221: arraylength
    //   222: istore 7
    //   224: iload 6
    //   226: iload 7
    //   228: if_icmpge +118 -> 346
    //   231: aload_3
    //   232: iload 6
    //   234: iaload
    //   235: istore 8
    //   237: aload_2
    //   238: iload 8
    //   240: aload_1
    //   241: iconst_1
    //   242: invokevirtual 147	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   245: aload_1
    //   246: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   249: ifnull +88 -> 337
    //   252: aload_1
    //   253: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   256: invokeinterface 154 1 0
    //   261: astore 4
    //   263: aload 4
    //   265: ldc 156
    //   267: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   270: ifne +33 -> 303
    //   273: aload 4
    //   275: ldc 164
    //   277: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   280: ifne +23 -> 303
    //   283: aload 4
    //   285: ldc 166
    //   287: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   290: ifne +13 -> 303
    //   293: aload 4
    //   295: ldc 168
    //   297: invokevirtual 162	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   300: ifeq +37 -> 337
    //   303: aload_1
    //   304: getfield 172	android/util/TypedValue:assetCookie	I
    //   307: i2l
    //   308: lstore 11
    //   310: aload_1
    //   311: getfield 175	android/util/TypedValue:data	I
    //   314: i2l
    //   315: lstore 13
    //   317: aload_0
    //   318: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   321: lload 11
    //   323: bipush 32
    //   325: lshl
    //   326: lload 13
    //   328: lor
    //   329: iload 8
    //   331: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   337: iload 6
    //   339: iconst_1
    //   340: iadd
    //   341: istore 6
    //   343: goto -119 -> 224
    //   346: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   349: ifeq +43 -> 392
    //   352: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   355: lstore 11
    //   357: new 99	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   364: astore_1
    //   365: aload_1
    //   366: ldc 102
    //   368: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_1
    //   373: lload 11
    //   375: lload 9
    //   377: lsub
    //   378: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 111
    //   384: aload_1
    //   385: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   391: pop
    //   392: return
    //   393: getstatic 97	com/tencent/theme/SkinEngine:DEBUG	Z
    //   396: ifeq +43 -> 439
    //   399: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   402: lstore 11
    //   404: new 99	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   411: astore_2
    //   412: aload_2
    //   413: ldc 102
    //   415: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_2
    //   420: lload 11
    //   422: lload 9
    //   424: lsub
    //   425: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: ldc 111
    //   431: aload_2
    //   432: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   438: pop
    //   439: goto +5 -> 444
    //   442: aload_1
    //   443: athrow
    //   444: goto -2 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	e
    //   0	447	1	paramSkinEngine	SkinEngine
    //   0	447	2	paramResources	Resources
    //   0	447	3	paramArrayOfInt	int[]
    //   0	447	4	paramFile	File
    //   0	447	5	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   38	304	6	i	int
    //   35	194	7	j	int
    //   235	95	8	k	int
    //   66	357	9	l1	long
    //   116	305	11	l2	long
    //   315	12	13	l3	long
    // Exception table:
    //   from	to	target	type
    //   73	105	192	finally
    //   105	138	192	finally
    //   141	145	192	finally
    //   197	212	192	finally
    //   212	224	192	finally
    //   237	303	192	finally
    //   303	337	192	finally
    //   73	105	196	java/io/IOException
    //   105	138	196	java/io/IOException
    //   141	145	196	java/io/IOException
  }
  
  public static g a(SkinEngine paramSkinEngine, Resources paramResources)
  {
    return new g(paramSkinEngine, paramResources);
  }
  
  public Drawable.ConstantState a(int paramInt, long paramLong)
  {
    Integer localInteger = (Integer)this.a.get(paramLong);
    if (localInteger == null) {
      return (Drawable.ConstantState)this.b[paramInt].get(paramLong);
    }
    if ((SkinEngine.mIconResourceID != null) && (SkinEngine.mIconResourceID.equals(localInteger)))
    {
      if (SkinEngine.DEBUG) {
        Log.d("SkinEngine", "To support Samsung multi-window, return default icon resource");
      }
      return null;
    }
    return this.c.a(localInteger.intValue());
  }
  
  public LongSparseArray<Integer> a()
  {
    return this.a;
  }
  
  void a(Resources paramResources, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    paramResources.getValue(paramInt, localTypedValue, true);
    if ((localTypedValue.string != null) && (localTypedValue.string.toString().endsWith(".xml"))) {
      this.a.put(localTypedValue.assetCookie << 32 | localTypedValue.data, Integer.valueOf(paramInt));
    }
  }
  
  void a(File paramFile)
  {
    if (paramFile != null)
    {
      if (paramFile.exists()) {
        paramFile.delete();
      }
      paramFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile)));
      int i = 0;
      while (i < this.a.size())
      {
        long l = this.a.keyAt(i);
        int j = ((Integer)this.a.valueAt(i)).intValue();
        paramFile.writeLong(l);
        paramFile.writeInt(j);
        i += 1;
      }
      paramFile.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.e
 * JD-Core Version:    0.7.0.1
 */