package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.util.LongSparseArray;

@TargetApi(16)
public class b
  extends LongSparseArray
{
  LongSparseArray<Integer> a;
  LongSparseArray<ColorStateList> b;
  SkinEngine c;
  
  /* Error */
  public b(SkinEngine paramSkinEngine, android.content.res.Resources paramResources, LongSparseArray paramLongSparseArray, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 21	android/util/LongSparseArray:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 23	com/tencent/theme/b:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload_3
    //   11: putfield 25	com/tencent/theme/b:b	Landroid/util/LongSparseArray;
    //   14: aload_0
    //   15: new 4	android/util/LongSparseArray
    //   18: dup
    //   19: iload 4
    //   21: bipush 10
    //   23: iadd
    //   24: invokespecial 28	android/util/LongSparseArray:<init>	(I)V
    //   27: putfield 30	com/tencent/theme/b:a	Landroid/util/LongSparseArray;
    //   30: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   33: lstore 7
    //   35: new 38	android/util/TypedValue
    //   38: dup
    //   39: invokespecial 39	android/util/TypedValue:<init>	()V
    //   42: astore_1
    //   43: iload 5
    //   45: iload 6
    //   47: if_icmpgt +97 -> 144
    //   50: aload_2
    //   51: iload 5
    //   53: aload_1
    //   54: iconst_1
    //   55: invokevirtual 45	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   58: aload_1
    //   59: getfield 49	android/util/TypedValue:type	I
    //   62: bipush 28
    //   64: if_icmplt +15 -> 79
    //   67: aload_1
    //   68: getfield 49	android/util/TypedValue:type	I
    //   71: bipush 31
    //   73: if_icmpgt +6 -> 79
    //   76: goto +115 -> 191
    //   79: aload_1
    //   80: getfield 53	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   83: invokeinterface 59 1 0
    //   88: ldc 61
    //   90: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   93: ifeq +98 -> 191
    //   96: aload_0
    //   97: getfield 30	com/tencent/theme/b:a	Landroid/util/LongSparseArray;
    //   100: aload_1
    //   101: getfield 70	android/util/TypedValue:assetCookie	I
    //   104: i2l
    //   105: bipush 32
    //   107: lshl
    //   108: aload_1
    //   109: getfield 73	android/util/TypedValue:data	I
    //   112: i2l
    //   113: lor
    //   114: iload 5
    //   116: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokevirtual 83	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   122: goto +69 -> 191
    //   125: astore_1
    //   126: goto +16 -> 142
    //   129: astore_3
    //   130: ldc 85
    //   132: iconst_1
    //   133: ldc 87
    //   135: aload_3
    //   136: invokestatic 93	com/tencent/theme/h:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto +52 -> 191
    //   142: aload_1
    //   143: athrow
    //   144: getstatic 99	com/tencent/theme/SkinEngine:DEBUG	Z
    //   147: ifeq +43 -> 190
    //   150: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   153: lstore 9
    //   155: new 101	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   162: astore_1
    //   163: aload_1
    //   164: ldc 104
    //   166: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: lload 9
    //   173: lload 7
    //   175: lsub
    //   176: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 113
    //   182: aload_1
    //   183: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: return
    //   191: iload 5
    //   193: iconst_1
    //   194: iadd
    //   195: istore 5
    //   197: goto -154 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	b
    //   0	200	1	paramSkinEngine	SkinEngine
    //   0	200	2	paramResources	android.content.res.Resources
    //   0	200	3	paramLongSparseArray	LongSparseArray
    //   0	200	4	paramInt1	int
    //   0	200	5	paramInt2	int
    //   0	200	6	paramInt3	int
    //   33	141	7	l1	long
    //   153	19	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   50	76	125	finally
    //   79	122	125	finally
    //   130	139	125	finally
    //   50	76	129	android/content/res/Resources$NotFoundException
    //   79	122	129	android/content/res/Resources$NotFoundException
  }
  
  public Object get(long paramLong)
  {
    Integer localInteger = (Integer)this.a.get(paramLong);
    if (localInteger == null) {
      return this.b.get(paramLong);
    }
    return this.c.loadColorStateList(localInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.b
 * JD-Core Version:    0.7.0.1
 */