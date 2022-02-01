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
    //   51: lstore 9
    //   53: aload 6
    //   55: ifnull +85 -> 140
    //   58: aload 6
    //   60: invokevirtual 55	java/io/File:exists	()Z
    //   63: ifeq +77 -> 140
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
    //   94: ifle +215 -> 309
    //   97: aload_1
    //   98: invokevirtual 75	java/io/ObjectInputStream:readLong	()J
    //   101: lstore 11
    //   103: aload_1
    //   104: invokevirtual 78	java/io/ObjectInputStream:readInt	()I
    //   107: istore_3
    //   108: aload_0
    //   109: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   112: lload 11
    //   114: iload_3
    //   115: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   121: goto -31 -> 90
    //   124: astore_1
    //   125: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   128: ifeq +12 -> 140
    //   131: ldc 96
    //   133: ldc 98
    //   135: aload_1
    //   136: invokestatic 104	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   139: pop
    //   140: new 106	android/util/TypedValue
    //   143: dup
    //   144: invokespecial 107	android/util/TypedValue:<init>	()V
    //   147: astore_1
    //   148: ldc 96
    //   150: iconst_1
    //   151: new 109	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   158: ldc 112
    //   160: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload 4
    //   165: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc 121
    //   170: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload 5
    //   175: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 130	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload 4
    //   186: istore_3
    //   187: iload 4
    //   189: iconst_1
    //   190: iadd
    //   191: istore 8
    //   193: iload 4
    //   195: iload 5
    //   197: if_icmpge +209 -> 406
    //   200: aload_2
    //   201: iload_3
    //   202: aload_1
    //   203: iconst_1
    //   204: invokevirtual 136	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   207: aload_1
    //   208: getfield 140	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   211: ifnull +87 -> 298
    //   214: aload_1
    //   215: getfield 140	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   218: invokeinterface 143 1 0
    //   223: astore 6
    //   225: aload 6
    //   227: ldc 145
    //   229: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   232: ifne +33 -> 265
    //   235: aload 6
    //   237: ldc 153
    //   239: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   242: ifne +23 -> 265
    //   245: aload 6
    //   247: ldc 155
    //   249: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   252: ifne +13 -> 265
    //   255: aload 6
    //   257: ldc 157
    //   259: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   262: ifeq +36 -> 298
    //   265: aload_1
    //   266: getfield 161	android/util/TypedValue:assetCookie	I
    //   269: i2l
    //   270: lstore 11
    //   272: aload_1
    //   273: getfield 164	android/util/TypedValue:data	I
    //   276: i2l
    //   277: lstore 13
    //   279: aload_0
    //   280: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   283: lload 11
    //   285: bipush 32
    //   287: lshl
    //   288: lload 13
    //   290: lor
    //   291: iload_3
    //   292: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   298: iload_3
    //   299: iconst_1
    //   300: iadd
    //   301: istore_3
    //   302: iload 8
    //   304: istore 4
    //   306: goto -119 -> 187
    //   309: aload_1
    //   310: invokevirtual 167	java/io/ObjectInputStream:close	()V
    //   313: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   316: ifeq +37 -> 353
    //   319: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   322: lstore 11
    //   324: ldc 96
    //   326: new 109	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   333: ldc 169
    //   335: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: lload 11
    //   340: lload 9
    //   342: lsub
    //   343: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   346: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 175	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: return
    //   354: astore 6
    //   356: ldc 96
    //   358: iconst_1
    //   359: new 109	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   366: ldc 177
    //   368: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload_3
    //   372: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: ldc 179
    //   377: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: getfield 140	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   384: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: aload 6
    //   392: invokestatic 185	com/tencent/theme/h:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: iload_3
    //   396: iconst_1
    //   397: iadd
    //   398: istore_3
    //   399: iload 8
    //   401: istore 4
    //   403: goto -216 -> 187
    //   406: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   409: ifeq -56 -> 353
    //   412: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   415: lstore 11
    //   417: ldc 96
    //   419: new 109	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   426: ldc 169
    //   428: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: lload 11
    //   433: lload 9
    //   435: lsub
    //   436: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   439: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 175	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   445: pop
    //   446: return
    //   447: astore_1
    //   448: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   451: ifeq +37 -> 488
    //   454: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   457: lstore 11
    //   459: ldc 96
    //   461: new 109	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   468: ldc 169
    //   470: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: lload 11
    //   475: lload 9
    //   477: lsub
    //   478: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 175	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   487: pop
    //   488: aload_1
    //   489: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	e
    //   0	490	1	paramSkinEngine	SkinEngine
    //   0	490	2	paramResources	Resources
    //   0	490	3	paramInt1	int
    //   0	490	4	paramInt2	int
    //   0	490	5	paramInt3	int
    //   0	490	6	paramFile	File
    //   0	490	7	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   191	209	8	i	int
    //   51	425	9	l1	long
    //   101	373	11	l2	long
    //   277	12	13	l3	long
    // Exception table:
    //   from	to	target	type
    //   58	90	124	java/io/IOException
    //   90	121	124	java/io/IOException
    //   309	313	124	java/io/IOException
    //   200	265	354	java/lang/Throwable
    //   265	298	354	java/lang/Throwable
    //   58	90	447	finally
    //   90	121	447	finally
    //   125	140	447	finally
    //   140	184	447	finally
    //   200	265	447	finally
    //   265	298	447	finally
    //   309	313	447	finally
    //   356	395	447	finally
  }
  
  /* Error */
  public e(SkinEngine paramSkinEngine, Resources paramResources, int[] paramArrayOfInt, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: ldc 96
    //   6: iconst_1
    //   7: ldc 191
    //   9: invokestatic 130	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: aload_0
    //   13: aload_1
    //   14: putfield 28	com/tencent/theme/e:c	Lcom/tencent/theme/SkinEngine;
    //   17: aload_0
    //   18: aload 5
    //   20: arraylength
    //   21: anewarray 30	android/util/LongSparseArray
    //   24: putfield 32	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   27: aload 5
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 32	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   34: iconst_0
    //   35: aload 5
    //   37: arraylength
    //   38: invokestatic 38	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   41: aload_0
    //   42: new 30	android/util/LongSparseArray
    //   45: dup
    //   46: aload_3
    //   47: arraylength
    //   48: invokespecial 41	android/util/LongSparseArray:<init>	(I)V
    //   51: putfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   54: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   57: lstore 9
    //   59: aload 4
    //   61: ifnull +87 -> 148
    //   64: aload 4
    //   66: invokevirtual 55	java/io/File:exists	()Z
    //   69: ifeq +79 -> 148
    //   72: new 57	java/io/ObjectInputStream
    //   75: dup
    //   76: new 59	java/io/BufferedInputStream
    //   79: dup
    //   80: new 61	java/io/FileInputStream
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: invokespecial 68	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 72	java/io/ObjectInputStream:available	()I
    //   100: ifle +185 -> 285
    //   103: aload_1
    //   104: invokevirtual 75	java/io/ObjectInputStream:readLong	()J
    //   107: lstore 11
    //   109: aload_1
    //   110: invokevirtual 78	java/io/ObjectInputStream:readInt	()I
    //   113: istore 6
    //   115: aload_0
    //   116: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   119: lload 11
    //   121: iload 6
    //   123: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   129: goto -33 -> 96
    //   132: astore_1
    //   133: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   136: ifeq +12 -> 148
    //   139: ldc 96
    //   141: ldc 98
    //   143: aload_1
    //   144: invokestatic 104	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   147: pop
    //   148: new 106	android/util/TypedValue
    //   151: dup
    //   152: invokespecial 107	android/util/TypedValue:<init>	()V
    //   155: astore_1
    //   156: aload_3
    //   157: arraylength
    //   158: istore 7
    //   160: iconst_0
    //   161: istore 6
    //   163: iload 6
    //   165: iload 7
    //   167: if_icmpge +163 -> 330
    //   170: aload_3
    //   171: iload 6
    //   173: iaload
    //   174: istore 8
    //   176: aload_2
    //   177: iload 8
    //   179: aload_1
    //   180: iconst_1
    //   181: invokevirtual 136	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   184: aload_1
    //   185: getfield 140	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   188: ifnull +88 -> 276
    //   191: aload_1
    //   192: getfield 140	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   195: invokeinterface 143 1 0
    //   200: astore 4
    //   202: aload 4
    //   204: ldc 145
    //   206: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   209: ifne +33 -> 242
    //   212: aload 4
    //   214: ldc 153
    //   216: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   219: ifne +23 -> 242
    //   222: aload 4
    //   224: ldc 155
    //   226: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   229: ifne +13 -> 242
    //   232: aload 4
    //   234: ldc 157
    //   236: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   239: ifeq +37 -> 276
    //   242: aload_1
    //   243: getfield 161	android/util/TypedValue:assetCookie	I
    //   246: i2l
    //   247: lstore 11
    //   249: aload_1
    //   250: getfield 164	android/util/TypedValue:data	I
    //   253: i2l
    //   254: lstore 13
    //   256: aload_0
    //   257: getfield 43	com/tencent/theme/e:a	Landroid/util/LongSparseArray;
    //   260: lload 11
    //   262: bipush 32
    //   264: lshl
    //   265: lload 13
    //   267: lor
    //   268: iload 8
    //   270: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   276: iload 6
    //   278: iconst_1
    //   279: iadd
    //   280: istore 6
    //   282: goto -119 -> 163
    //   285: aload_1
    //   286: invokevirtual 167	java/io/ObjectInputStream:close	()V
    //   289: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   292: ifeq +37 -> 329
    //   295: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   298: lstore 11
    //   300: ldc 96
    //   302: new 109	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   309: ldc 169
    //   311: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: lload 11
    //   316: lload 9
    //   318: lsub
    //   319: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 175	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: return
    //   330: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   333: ifeq -4 -> 329
    //   336: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   339: lstore 11
    //   341: ldc 96
    //   343: new 109	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   350: ldc 169
    //   352: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: lload 11
    //   357: lload 9
    //   359: lsub
    //   360: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 175	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   369: pop
    //   370: return
    //   371: astore_1
    //   372: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   375: ifeq +37 -> 412
    //   378: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   381: lstore 11
    //   383: ldc 96
    //   385: new 109	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   392: ldc 169
    //   394: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: lload 11
    //   399: lload 9
    //   401: lsub
    //   402: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 175	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: aload_1
    //   413: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	e
    //   0	414	1	paramSkinEngine	SkinEngine
    //   0	414	2	paramResources	Resources
    //   0	414	3	paramArrayOfInt	int[]
    //   0	414	4	paramFile	File
    //   0	414	5	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   113	168	6	i	int
    //   158	10	7	j	int
    //   174	95	8	k	int
    //   57	343	9	l1	long
    //   107	291	11	l2	long
    //   254	12	13	l3	long
    // Exception table:
    //   from	to	target	type
    //   64	96	132	java/io/IOException
    //   96	129	132	java/io/IOException
    //   285	289	132	java/io/IOException
    //   64	96	371	finally
    //   96	129	371	finally
    //   133	148	371	finally
    //   148	160	371	finally
    //   176	242	371	finally
    //   242	276	371	finally
    //   285	289	371	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.e
 * JD-Core Version:    0.7.0.1
 */