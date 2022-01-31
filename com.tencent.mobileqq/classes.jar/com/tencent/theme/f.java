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
class f
{
  LongSparseArray<Integer> a;
  LongSparseArray<Drawable.ConstantState>[] b;
  SkinEngine c;
  h d;
  
  /* Error */
  public f(SkinEngine paramSkinEngine, Resources paramResources, int paramInt1, int paramInt2, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 28	com/tencent/theme/f:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload 6
    //   12: arraylength
    //   13: anewarray 30	android/util/LongSparseArray
    //   16: putfield 32	com/tencent/theme/f:b	[Landroid/util/LongSparseArray;
    //   19: aload 6
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 32	com/tencent/theme/f:b	[Landroid/util/LongSparseArray;
    //   26: iconst_0
    //   27: aload 6
    //   29: arraylength
    //   30: invokestatic 38	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   33: aload_0
    //   34: new 30	android/util/LongSparseArray
    //   37: dup
    //   38: iload_3
    //   39: bipush 10
    //   41: iadd
    //   42: invokespecial 41	android/util/LongSparseArray:<init>	(I)V
    //   45: putfield 43	com/tencent/theme/f:a	Landroid/util/LongSparseArray;
    //   48: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   51: lstore 7
    //   53: aload 5
    //   55: ifnull +85 -> 140
    //   58: aload 5
    //   60: invokevirtual 55	java/io/File:exists	()Z
    //   63: ifeq +77 -> 140
    //   66: new 57	java/io/ObjectInputStream
    //   69: dup
    //   70: new 59	java/io/BufferedInputStream
    //   73: dup
    //   74: new 61	java/io/FileInputStream
    //   77: dup
    //   78: aload 5
    //   80: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: invokespecial 68	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 72	java/io/ObjectInputStream:available	()I
    //   94: ifle +163 -> 257
    //   97: aload_1
    //   98: invokevirtual 75	java/io/ObjectInputStream:readLong	()J
    //   101: lstore 9
    //   103: aload_1
    //   104: invokevirtual 78	java/io/ObjectInputStream:readInt	()I
    //   107: istore_3
    //   108: aload_0
    //   109: getfield 43	com/tencent/theme/f:a	Landroid/util/LongSparseArray;
    //   112: lload 9
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
    //   148: aload_2
    //   149: iload 4
    //   151: aload_1
    //   152: iconst_1
    //   153: invokevirtual 113	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   156: aload_1
    //   157: getfield 117	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   160: ifnull +88 -> 248
    //   163: aload_1
    //   164: getfield 117	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   167: invokeinterface 123 1 0
    //   172: astore 5
    //   174: aload 5
    //   176: ldc 125
    //   178: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   181: ifne +33 -> 214
    //   184: aload 5
    //   186: ldc 133
    //   188: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   191: ifne +23 -> 214
    //   194: aload 5
    //   196: ldc 135
    //   198: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   201: ifne +13 -> 214
    //   204: aload 5
    //   206: ldc 137
    //   208: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   211: ifeq +37 -> 248
    //   214: aload_1
    //   215: getfield 141	android/util/TypedValue:assetCookie	I
    //   218: i2l
    //   219: lstore 9
    //   221: aload_1
    //   222: getfield 144	android/util/TypedValue:data	I
    //   225: i2l
    //   226: lstore 11
    //   228: aload_0
    //   229: getfield 43	com/tencent/theme/f:a	Landroid/util/LongSparseArray;
    //   232: lload 9
    //   234: bipush 32
    //   236: lshl
    //   237: lload 11
    //   239: lor
    //   240: iload 4
    //   242: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   248: iload 4
    //   250: iconst_1
    //   251: iadd
    //   252: istore 4
    //   254: goto -106 -> 148
    //   257: aload_1
    //   258: invokevirtual 147	java/io/ObjectInputStream:close	()V
    //   261: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   264: ifeq +37 -> 301
    //   267: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   270: lstore 9
    //   272: ldc 96
    //   274: new 149	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   281: ldc 152
    //   283: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: lload 9
    //   288: lload 7
    //   290: lsub
    //   291: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   300: pop
    //   301: return
    //   302: astore_1
    //   303: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   306: ifeq -5 -> 301
    //   309: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   312: lstore 9
    //   314: ldc 96
    //   316: new 149	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   323: ldc 152
    //   325: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: lload 9
    //   330: lload 7
    //   332: lsub
    //   333: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   342: pop
    //   343: return
    //   344: astore_1
    //   345: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   348: ifeq +37 -> 385
    //   351: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   354: lstore 9
    //   356: ldc 96
    //   358: new 149	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   365: ldc 152
    //   367: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: lload 9
    //   372: lload 7
    //   374: lsub
    //   375: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   384: pop
    //   385: aload_1
    //   386: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	f
    //   0	387	1	paramSkinEngine	SkinEngine
    //   0	387	2	paramResources	Resources
    //   0	387	3	paramInt1	int
    //   0	387	4	paramInt2	int
    //   0	387	5	paramFile	File
    //   0	387	6	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   51	322	7	l1	long
    //   101	270	9	l2	long
    //   226	12	11	l3	long
    // Exception table:
    //   from	to	target	type
    //   58	90	124	java/io/IOException
    //   90	121	124	java/io/IOException
    //   257	261	124	java/io/IOException
    //   148	214	302	android/content/res/Resources$NotFoundException
    //   214	248	302	android/content/res/Resources$NotFoundException
    //   58	90	344	finally
    //   90	121	344	finally
    //   125	140	344	finally
    //   140	148	344	finally
    //   148	214	344	finally
    //   214	248	344	finally
    //   257	261	344	finally
  }
  
  /* Error */
  public f(SkinEngine paramSkinEngine, Resources paramResources, int[] paramArrayOfInt, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: ldc 96
    //   6: iconst_1
    //   7: ldc 169
    //   9: invokestatic 174	com/tencent/theme/i:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: aload_0
    //   13: aload_1
    //   14: putfield 28	com/tencent/theme/f:c	Lcom/tencent/theme/SkinEngine;
    //   17: aload_0
    //   18: aload 5
    //   20: arraylength
    //   21: anewarray 30	android/util/LongSparseArray
    //   24: putfield 32	com/tencent/theme/f:b	[Landroid/util/LongSparseArray;
    //   27: aload 5
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 32	com/tencent/theme/f:b	[Landroid/util/LongSparseArray;
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
    //   51: putfield 43	com/tencent/theme/f:a	Landroid/util/LongSparseArray;
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
    //   116: getfield 43	com/tencent/theme/f:a	Landroid/util/LongSparseArray;
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
    //   181: invokevirtual 113	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   184: aload_1
    //   185: getfield 117	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   188: ifnull +88 -> 276
    //   191: aload_1
    //   192: getfield 117	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   195: invokeinterface 123 1 0
    //   200: astore 4
    //   202: aload 4
    //   204: ldc 125
    //   206: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   209: ifne +33 -> 242
    //   212: aload 4
    //   214: ldc 133
    //   216: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   219: ifne +23 -> 242
    //   222: aload 4
    //   224: ldc 135
    //   226: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   229: ifne +13 -> 242
    //   232: aload 4
    //   234: ldc 137
    //   236: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   239: ifeq +37 -> 276
    //   242: aload_1
    //   243: getfield 141	android/util/TypedValue:assetCookie	I
    //   246: i2l
    //   247: lstore 11
    //   249: aload_1
    //   250: getfield 144	android/util/TypedValue:data	I
    //   253: i2l
    //   254: lstore 13
    //   256: aload_0
    //   257: getfield 43	com/tencent/theme/f:a	Landroid/util/LongSparseArray;
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
    //   286: invokevirtual 147	java/io/ObjectInputStream:close	()V
    //   289: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   292: ifeq +37 -> 329
    //   295: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   298: lstore 11
    //   300: ldc 96
    //   302: new 149	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   309: ldc 152
    //   311: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: lload 11
    //   316: lload 9
    //   318: lsub
    //   319: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: return
    //   330: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   333: ifeq -4 -> 329
    //   336: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   339: lstore 11
    //   341: ldc 96
    //   343: new 149	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   350: ldc 152
    //   352: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: lload 11
    //   357: lload 9
    //   359: lsub
    //   360: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   369: pop
    //   370: return
    //   371: astore_1
    //   372: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   375: ifeq +37 -> 412
    //   378: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   381: lstore 11
    //   383: ldc 96
    //   385: new 149	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   392: ldc 152
    //   394: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: lload 11
    //   399: lload 9
    //   401: lsub
    //   402: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: aload_1
    //   413: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	f
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
  
  public static h a(SkinEngine paramSkinEngine, Resources paramResources)
  {
    return new h(paramSkinEngine, paramResources);
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
 * Qualified Name:     com.tencent.theme.f
 * JD-Core Version:    0.7.0.1
 */