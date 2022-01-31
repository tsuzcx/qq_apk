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
import java.io.IOException;
import java.io.ObjectOutputStream;

@TargetApi(16)
class g
{
  LongSparseArray<Integer> a;
  LongSparseArray<Drawable.ConstantState>[] b;
  SkinEngine c;
  i d;
  
  /* Error */
  public g(SkinEngine paramSkinEngine, Resources paramResources, int paramInt1, int paramInt2, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 28	com/tencent/theme/g:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload 6
    //   12: arraylength
    //   13: anewarray 30	android/util/LongSparseArray
    //   16: putfield 32	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   19: aload 6
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 32	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
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
    //   45: putfield 43	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
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
    //   109: getfield 43	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
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
    //   229: getfield 43	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
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
    //   0	387	0	this	g
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
  public g(SkinEngine paramSkinEngine, Resources paramResources, int[] paramArrayOfInt, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 28	com/tencent/theme/g:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload 5
    //   12: arraylength
    //   13: anewarray 30	android/util/LongSparseArray
    //   16: putfield 32	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   19: aload 5
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 32	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   26: iconst_0
    //   27: aload 5
    //   29: arraylength
    //   30: invokestatic 38	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   33: aload_0
    //   34: new 30	android/util/LongSparseArray
    //   37: dup
    //   38: aload_3
    //   39: arraylength
    //   40: invokespecial 41	android/util/LongSparseArray:<init>	(I)V
    //   43: putfield 43	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   46: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   49: lstore 9
    //   51: aload 4
    //   53: ifnull +87 -> 140
    //   56: aload 4
    //   58: invokevirtual 55	java/io/File:exists	()Z
    //   61: ifeq +79 -> 140
    //   64: new 57	java/io/ObjectInputStream
    //   67: dup
    //   68: new 59	java/io/BufferedInputStream
    //   71: dup
    //   72: new 61	java/io/FileInputStream
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: invokespecial 68	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 72	java/io/ObjectInputStream:available	()I
    //   92: ifle +185 -> 277
    //   95: aload_1
    //   96: invokevirtual 75	java/io/ObjectInputStream:readLong	()J
    //   99: lstore 11
    //   101: aload_1
    //   102: invokevirtual 78	java/io/ObjectInputStream:readInt	()I
    //   105: istore 6
    //   107: aload_0
    //   108: getfield 43	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   111: lload 11
    //   113: iload 6
    //   115: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   121: goto -33 -> 88
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
    //   148: aload_3
    //   149: arraylength
    //   150: istore 7
    //   152: iconst_0
    //   153: istore 6
    //   155: iload 6
    //   157: iload 7
    //   159: if_icmpge +163 -> 322
    //   162: aload_3
    //   163: iload 6
    //   165: iaload
    //   166: istore 8
    //   168: aload_2
    //   169: iload 8
    //   171: aload_1
    //   172: iconst_1
    //   173: invokevirtual 113	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   176: aload_1
    //   177: getfield 117	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   180: ifnull +88 -> 268
    //   183: aload_1
    //   184: getfield 117	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   187: invokeinterface 123 1 0
    //   192: astore 4
    //   194: aload 4
    //   196: ldc 125
    //   198: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   201: ifne +33 -> 234
    //   204: aload 4
    //   206: ldc 133
    //   208: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   211: ifne +23 -> 234
    //   214: aload 4
    //   216: ldc 135
    //   218: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   221: ifne +13 -> 234
    //   224: aload 4
    //   226: ldc 137
    //   228: invokevirtual 131	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   231: ifeq +37 -> 268
    //   234: aload_1
    //   235: getfield 141	android/util/TypedValue:assetCookie	I
    //   238: i2l
    //   239: lstore 11
    //   241: aload_1
    //   242: getfield 144	android/util/TypedValue:data	I
    //   245: i2l
    //   246: lstore 13
    //   248: aload_0
    //   249: getfield 43	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   252: lload 11
    //   254: bipush 32
    //   256: lshl
    //   257: lload 13
    //   259: lor
    //   260: iload 8
    //   262: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokevirtual 88	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   268: iload 6
    //   270: iconst_1
    //   271: iadd
    //   272: istore 6
    //   274: goto -119 -> 155
    //   277: aload_1
    //   278: invokevirtual 147	java/io/ObjectInputStream:close	()V
    //   281: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   284: ifeq +37 -> 321
    //   287: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   290: lstore 11
    //   292: ldc 96
    //   294: new 149	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   301: ldc 152
    //   303: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: lload 11
    //   308: lload 9
    //   310: lsub
    //   311: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   314: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   320: pop
    //   321: return
    //   322: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   325: ifeq -4 -> 321
    //   328: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   331: lstore 11
    //   333: ldc 96
    //   335: new 149	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   342: ldc 152
    //   344: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: lload 11
    //   349: lload 9
    //   351: lsub
    //   352: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   361: pop
    //   362: return
    //   363: astore_1
    //   364: getstatic 94	com/tencent/theme/SkinEngine:DEBUG	Z
    //   367: ifeq +37 -> 404
    //   370: invokestatic 49	android/os/SystemClock:uptimeMillis	()J
    //   373: lstore 11
    //   375: ldc 96
    //   377: new 149	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   384: ldc 152
    //   386: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: lload 11
    //   391: lload 9
    //   393: lsub
    //   394: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   397: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   403: pop
    //   404: aload_1
    //   405: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	g
    //   0	406	1	paramSkinEngine	SkinEngine
    //   0	406	2	paramResources	Resources
    //   0	406	3	paramArrayOfInt	int[]
    //   0	406	4	paramFile	File
    //   0	406	5	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   105	168	6	i	int
    //   150	10	7	j	int
    //   166	95	8	k	int
    //   49	343	9	l1	long
    //   99	291	11	l2	long
    //   246	12	13	l3	long
    // Exception table:
    //   from	to	target	type
    //   56	88	124	java/io/IOException
    //   88	121	124	java/io/IOException
    //   277	281	124	java/io/IOException
    //   56	88	363	finally
    //   88	121	363	finally
    //   125	140	363	finally
    //   140	152	363	finally
    //   168	234	363	finally
    //   234	268	363	finally
    //   277	281	363	finally
  }
  
  public static i a(SkinEngine paramSkinEngine, Resources paramResources)
  {
    return new i(paramSkinEngine, paramResources);
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
    throws IOException
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
 * Qualified Name:     com.tencent.theme.g
 * JD-Core Version:    0.7.0.1
 */