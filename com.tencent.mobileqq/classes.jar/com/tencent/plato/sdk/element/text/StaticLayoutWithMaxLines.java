package com.tencent.plato.sdk.element.text;

import android.os.Build.VERSION;
import android.text.StaticLayout;
import java.lang.reflect.Constructor;

public class StaticLayoutWithMaxLines
{
  private static final boolean DEG = false;
  private static final String TAG = StaticLayoutWithMaxLines.class.getSimpleName();
  private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
  private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
  private static final String TEXT_DIR_FIRSTSTRONG_LTR = "FIRSTSTRONG_LTR";
  private static Constructor<StaticLayout> sConstructor;
  private static Object[] sConstructorArgs;
  private static boolean sInitialized;
  private static Object sTextDirection;
  
  /* Error */
  public static StaticLayout create(java.lang.CharSequence paramCharSequence, int paramInt1, int paramInt2, android.text.TextPaint paramTextPaint, int paramInt3, android.text.Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, android.text.TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 47	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:ensureInitialized	()V
    //   6: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   15: iconst_1
    //   16: iload_1
    //   17: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   24: iconst_2
    //   25: iload_2
    //   26: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   33: iconst_3
    //   34: aload_3
    //   35: aastore
    //   36: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   39: iconst_4
    //   40: iload 4
    //   42: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   49: iconst_5
    //   50: aload 5
    //   52: aastore
    //   53: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   56: bipush 6
    //   58: getstatic 57	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   61: aastore
    //   62: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   65: bipush 7
    //   67: fload 6
    //   69: invokestatic 62	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   72: aastore
    //   73: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   76: bipush 8
    //   78: fload 7
    //   80: invokestatic 62	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   83: aastore
    //   84: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   87: bipush 9
    //   89: iload 8
    //   91: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   98: bipush 10
    //   100: aload 9
    //   102: aastore
    //   103: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   106: bipush 11
    //   108: iload 10
    //   110: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   117: bipush 12
    //   119: iload 11
    //   121: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: getstatic 69	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   128: getstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   131: invokevirtual 75	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 77	android/text/StaticLayout
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: areturn
    //   143: astore_0
    //   144: new 79	java/lang/IllegalStateException
    //   147: dup
    //   148: new 81	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   155: ldc 84
    //   157: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: invokestatic 94	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   164: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 100	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   173: athrow
    //   174: astore_0
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramCharSequence	java.lang.CharSequence
    //   0	180	1	paramInt1	int
    //   0	180	2	paramInt2	int
    //   0	180	3	paramTextPaint	android.text.TextPaint
    //   0	180	4	paramInt3	int
    //   0	180	5	paramAlignment	android.text.Layout.Alignment
    //   0	180	6	paramFloat1	float
    //   0	180	7	paramFloat2	float
    //   0	180	8	paramBoolean	boolean
    //   0	180	9	paramTruncateAt	android.text.TextUtils.TruncateAt
    //   0	180	10	paramInt4	int
    //   0	180	11	paramInt5	int
    // Exception table:
    //   from	to	target	type
    //   6	138	143	java/lang/Exception
    //   3	6	174	finally
    //   6	138	174	finally
    //   144	174	174	finally
  }
  
  /* Error */
  @android.annotation.TargetApi(18)
  public static void ensureInitialized()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 113	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 119	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 18
    //   20: if_icmplt +134 -> 154
    //   23: ldc 121
    //   25: astore_1
    //   26: getstatic 126	android/text/TextDirectionHeuristics:FIRSTSTRONG_LTR	Landroid/text/TextDirectionHeuristic;
    //   29: putstatic 57	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   32: bipush 13
    //   34: anewarray 30	java/lang/Class
    //   37: astore_2
    //   38: aload_2
    //   39: iconst_0
    //   40: ldc 128
    //   42: aastore
    //   43: aload_2
    //   44: iconst_1
    //   45: getstatic 132	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   48: aastore
    //   49: aload_2
    //   50: iconst_2
    //   51: getstatic 132	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   54: aastore
    //   55: aload_2
    //   56: iconst_3
    //   57: ldc 134
    //   59: aastore
    //   60: aload_2
    //   61: iconst_4
    //   62: getstatic 132	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   65: aastore
    //   66: aload_2
    //   67: iconst_5
    //   68: ldc 136
    //   70: aastore
    //   71: aload_2
    //   72: bipush 6
    //   74: aload_1
    //   75: aastore
    //   76: aload_2
    //   77: bipush 7
    //   79: getstatic 137	java/lang/Float:TYPE	Ljava/lang/Class;
    //   82: aastore
    //   83: aload_2
    //   84: bipush 8
    //   86: getstatic 137	java/lang/Float:TYPE	Ljava/lang/Class;
    //   89: aastore
    //   90: aload_2
    //   91: bipush 9
    //   93: getstatic 138	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   96: aastore
    //   97: aload_2
    //   98: bipush 10
    //   100: ldc 140
    //   102: aastore
    //   103: aload_2
    //   104: bipush 11
    //   106: getstatic 132	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   109: aastore
    //   110: aload_2
    //   111: bipush 12
    //   113: getstatic 132	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   116: aastore
    //   117: ldc 77
    //   119: aload_2
    //   120: invokevirtual 144	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   123: putstatic 69	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   126: getstatic 69	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   129: iconst_1
    //   130: invokevirtual 148	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   133: aload_2
    //   134: arraylength
    //   135: anewarray 4	java/lang/Object
    //   138: putstatic 49	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   141: iconst_1
    //   142: putstatic 113	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   145: goto -134 -> 11
    //   148: astore_1
    //   149: ldc 2
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: ldc 2
    //   156: invokevirtual 152	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: astore_2
    //   160: aload_2
    //   161: ldc 15
    //   163: invokevirtual 158	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   166: astore_1
    //   167: aload_2
    //   168: ldc 12
    //   170: invokevirtual 158	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   173: astore_2
    //   174: aload_2
    //   175: ldc 18
    //   177: invokevirtual 162	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   180: aload_2
    //   181: invokevirtual 168	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: putstatic 57	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   187: goto -155 -> 32
    //   190: astore_1
    //   191: getstatic 36	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   194: ldc 170
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload_1
    //   203: invokestatic 94	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   206: aastore
    //   207: invokestatic 176	com/tencent/plato/core/utils/PLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   210: pop
    //   211: iconst_1
    //   212: putstatic 113	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   215: goto -204 -> 11
    //   218: astore_1
    //   219: getstatic 36	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   222: ldc 178
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_1
    //   231: invokestatic 94	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   234: aastore
    //   235: invokestatic 176	com/tencent/plato/core/utils/PLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   238: pop
    //   239: iconst_1
    //   240: putstatic 113	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   243: goto -232 -> 11
    //   246: astore_1
    //   247: getstatic 36	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   250: ldc 180
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_1
    //   259: invokestatic 94	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   262: aastore
    //   263: invokestatic 176	com/tencent/plato/core/utils/PLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   266: pop
    //   267: iconst_1
    //   268: putstatic 113	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   271: goto -260 -> 11
    //   274: astore_1
    //   275: getstatic 36	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   278: ldc 182
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload_1
    //   287: invokestatic 94	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   290: aastore
    //   291: invokestatic 176	com/tencent/plato/core/utils/PLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   294: pop
    //   295: iconst_1
    //   296: putstatic 113	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   299: goto -288 -> 11
    //   302: astore_1
    //   303: iconst_1
    //   304: putstatic 113	com/tencent/plato/sdk/element/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   307: aload_1
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   25	50	1	localTextDirectionHeuristic	android.text.TextDirectionHeuristic
    //   148	5	1	localObject1	Object
    //   166	1	1	localClass	Class
    //   190	13	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   218	13	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   246	13	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   274	13	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   302	6	1	localObject2	Object
    //   37	144	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	148	finally
    //   141	145	148	finally
    //   211	215	148	finally
    //   239	243	148	finally
    //   267	271	148	finally
    //   295	299	148	finally
    //   303	309	148	finally
    //   15	23	190	java/lang/NoSuchMethodException
    //   26	32	190	java/lang/NoSuchMethodException
    //   32	38	190	java/lang/NoSuchMethodException
    //   43	55	190	java/lang/NoSuchMethodException
    //   60	66	190	java/lang/NoSuchMethodException
    //   76	97	190	java/lang/NoSuchMethodException
    //   103	141	190	java/lang/NoSuchMethodException
    //   154	187	190	java/lang/NoSuchMethodException
    //   15	23	218	java/lang/ClassNotFoundException
    //   26	32	218	java/lang/ClassNotFoundException
    //   32	38	218	java/lang/ClassNotFoundException
    //   43	55	218	java/lang/ClassNotFoundException
    //   60	66	218	java/lang/ClassNotFoundException
    //   76	97	218	java/lang/ClassNotFoundException
    //   103	141	218	java/lang/ClassNotFoundException
    //   154	187	218	java/lang/ClassNotFoundException
    //   15	23	246	java/lang/NoSuchFieldException
    //   26	32	246	java/lang/NoSuchFieldException
    //   32	38	246	java/lang/NoSuchFieldException
    //   43	55	246	java/lang/NoSuchFieldException
    //   60	66	246	java/lang/NoSuchFieldException
    //   76	97	246	java/lang/NoSuchFieldException
    //   103	141	246	java/lang/NoSuchFieldException
    //   154	187	246	java/lang/NoSuchFieldException
    //   15	23	274	java/lang/IllegalAccessException
    //   26	32	274	java/lang/IllegalAccessException
    //   32	38	274	java/lang/IllegalAccessException
    //   43	55	274	java/lang/IllegalAccessException
    //   60	66	274	java/lang/IllegalAccessException
    //   76	97	274	java/lang/IllegalAccessException
    //   103	141	274	java/lang/IllegalAccessException
    //   154	187	274	java/lang/IllegalAccessException
    //   15	23	302	finally
    //   26	32	302	finally
    //   32	38	302	finally
    //   43	55	302	finally
    //   60	66	302	finally
    //   76	97	302	finally
    //   103	141	302	finally
    //   154	187	302	finally
    //   191	211	302	finally
    //   219	239	302	finally
    //   247	267	302	finally
    //   275	295	302	finally
  }
  
  public static boolean isSupported()
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      return false;
      ensureInitialized();
    } while (sConstructor == null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.element.text.StaticLayoutWithMaxLines
 * JD-Core Version:    0.7.0.1
 */