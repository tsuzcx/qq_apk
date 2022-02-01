package com.tencent.theme;

import android.content.res.ColorStateList;
import android.util.SparseArray;

public class c
  extends SparseArray<ColorStateList>
{
  SparseArray<Integer> a;
  SparseArray<ColorStateList> b;
  SkinEngine c;
  
  /* Error */
  public c(SkinEngine paramSkinEngine, android.content.res.Resources paramResources, SparseArray<ColorStateList> paramSparseArray, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 18	android/util/SparseArray:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 20	com/tencent/theme/c:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload_3
    //   11: putfield 22	com/tencent/theme/c:b	Landroid/util/SparseArray;
    //   14: aload_0
    //   15: new 5	android/util/SparseArray
    //   18: dup
    //   19: iload 4
    //   21: bipush 10
    //   23: iadd
    //   24: invokespecial 25	android/util/SparseArray:<init>	(I)V
    //   27: putfield 27	com/tencent/theme/c:a	Landroid/util/SparseArray;
    //   30: invokestatic 33	android/os/SystemClock:uptimeMillis	()J
    //   33: lstore 7
    //   35: new 35	android/util/TypedValue
    //   38: dup
    //   39: invokespecial 36	android/util/TypedValue:<init>	()V
    //   42: astore_1
    //   43: iload 5
    //   45: iload 6
    //   47: if_icmpgt +95 -> 142
    //   50: aload_2
    //   51: iload 5
    //   53: aload_1
    //   54: iconst_1
    //   55: invokevirtual 42	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   58: aload_1
    //   59: getfield 46	android/util/TypedValue:type	I
    //   62: bipush 28
    //   64: if_icmplt +15 -> 79
    //   67: aload_1
    //   68: getfield 46	android/util/TypedValue:type	I
    //   71: bipush 31
    //   73: if_icmpgt +6 -> 79
    //   76: goto +113 -> 189
    //   79: aload_1
    //   80: getfield 50	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   83: invokeinterface 56 1 0
    //   88: ldc 58
    //   90: invokevirtual 64	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   93: ifeq +96 -> 189
    //   96: aload_0
    //   97: getfield 27	com/tencent/theme/c:a	Landroid/util/SparseArray;
    //   100: aload_1
    //   101: getfield 67	android/util/TypedValue:assetCookie	I
    //   104: bipush 24
    //   106: ishl
    //   107: aload_1
    //   108: getfield 70	android/util/TypedValue:data	I
    //   111: ior
    //   112: iload 5
    //   114: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokevirtual 80	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   120: goto +69 -> 189
    //   123: astore_1
    //   124: goto +16 -> 140
    //   127: astore_3
    //   128: ldc 82
    //   130: iconst_1
    //   131: ldc 84
    //   133: aload_3
    //   134: invokestatic 90	com/tencent/theme/h:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto +52 -> 189
    //   140: aload_1
    //   141: athrow
    //   142: getstatic 96	com/tencent/theme/SkinEngine:DEBUG	Z
    //   145: ifeq +43 -> 188
    //   148: invokestatic 33	android/os/SystemClock:uptimeMillis	()J
    //   151: lstore 9
    //   153: new 98	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   160: astore_1
    //   161: aload_1
    //   162: ldc 101
    //   164: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_1
    //   169: lload 9
    //   171: lload 7
    //   173: lsub
    //   174: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 110
    //   180: aload_1
    //   181: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 116	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: return
    //   189: iload 5
    //   191: iconst_1
    //   192: iadd
    //   193: istore 5
    //   195: goto -152 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	c
    //   0	198	1	paramSkinEngine	SkinEngine
    //   0	198	2	paramResources	android.content.res.Resources
    //   0	198	3	paramSparseArray	SparseArray<ColorStateList>
    //   0	198	4	paramInt1	int
    //   0	198	5	paramInt2	int
    //   0	198	6	paramInt3	int
    //   33	139	7	l1	long
    //   151	19	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   50	76	123	finally
    //   79	120	123	finally
    //   128	137	123	finally
    //   50	76	127	android/content/res/Resources$NotFoundException
    //   79	120	127	android/content/res/Resources$NotFoundException
  }
  
  public ColorStateList a(int paramInt)
  {
    Integer localInteger = (Integer)this.a.get(paramInt);
    if (localInteger == null) {
      return (ColorStateList)this.b.get(paramInt);
    }
    return this.c.loadColorStateList(localInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.c
 * JD-Core Version:    0.7.0.1
 */