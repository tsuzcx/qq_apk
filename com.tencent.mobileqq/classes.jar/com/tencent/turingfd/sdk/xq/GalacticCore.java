package com.tencent.turingfd.sdk.xq;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;

public class GalacticCore
  implements ViewTreeObserver.OnPreDrawListener
{
  public GalacticCore(Window paramWindow, String paramString, Cygnus paramCygnus) {}
  
  /* Error */
  public boolean onPreDraw()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/turingfd/sdk/xq/GalacticCore:a	Landroid/view/Window;
    //   4: invokevirtual 32	android/view/Window:getDecorView	()Landroid/view/View;
    //   7: invokevirtual 38	android/view/View:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   10: aload_0
    //   11: invokevirtual 44	android/view/ViewTreeObserver:removeOnPreDrawListener	(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V
    //   14: aload_0
    //   15: getfield 16	com/tencent/turingfd/sdk/xq/GalacticCore:a	Landroid/view/Window;
    //   18: astore_3
    //   19: invokestatic 49	com/tencent/turingfd/sdk/xq/implements:a	()I
    //   22: istore_1
    //   23: aconst_null
    //   24: astore 5
    //   26: iload_1
    //   27: bipush 30
    //   29: if_icmplt +6 -> 35
    //   32: goto +42 -> 74
    //   35: aload_3
    //   36: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   39: astore 4
    //   41: aload 4
    //   43: ldc 55
    //   45: iconst_0
    //   46: anewarray 57	java/lang/Class
    //   49: invokevirtual 61	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   52: astore 4
    //   54: aload 4
    //   56: iconst_1
    //   57: invokevirtual 67	java/lang/reflect/Method:setAccessible	(Z)V
    //   60: aload 4
    //   62: aload_3
    //   63: iconst_0
    //   64: anewarray 4	java/lang/Object
    //   67: invokevirtual 71	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   70: astore_3
    //   71: goto +5 -> 76
    //   74: aconst_null
    //   75: astore_3
    //   76: aload_3
    //   77: ifnonnull +5 -> 82
    //   80: iconst_1
    //   81: ireturn
    //   82: aload_3
    //   83: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   86: astore 4
    //   88: aload 4
    //   90: ldc 73
    //   92: iconst_0
    //   93: anewarray 57	java/lang/Class
    //   96: invokevirtual 61	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   99: astore 4
    //   101: aload 4
    //   103: iconst_1
    //   104: invokevirtual 67	java/lang/reflect/Method:setAccessible	(Z)V
    //   107: aload 4
    //   109: aload_3
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokevirtual 71	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   117: astore_3
    //   118: goto +5 -> 123
    //   121: aconst_null
    //   122: astore_3
    //   123: aload_3
    //   124: ifnonnull +5 -> 129
    //   127: iconst_1
    //   128: ireturn
    //   129: aload_3
    //   130: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   133: ldc 75
    //   135: invokevirtual 79	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   138: astore 4
    //   140: aload 4
    //   142: iconst_1
    //   143: invokevirtual 82	java/lang/reflect/Field:setAccessible	(Z)V
    //   146: aload 4
    //   148: aload_3
    //   149: invokevirtual 86	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   152: astore 4
    //   154: goto +6 -> 160
    //   157: aconst_null
    //   158: astore 4
    //   160: aload 4
    //   162: ifnull +125 -> 287
    //   165: aload 4
    //   167: instanceof 88
    //   170: istore_2
    //   171: iload_2
    //   172: ifeq +5 -> 177
    //   175: iconst_1
    //   176: ireturn
    //   177: aload 4
    //   179: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   182: astore 6
    //   184: aload 6
    //   186: ldc 90
    //   188: iconst_0
    //   189: anewarray 57	java/lang/Class
    //   192: invokevirtual 93	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   195: astore 6
    //   197: aload 6
    //   199: iconst_1
    //   200: invokevirtual 67	java/lang/reflect/Method:setAccessible	(Z)V
    //   203: aload 6
    //   205: aload 4
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokevirtual 71	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   214: astore 6
    //   216: aload 6
    //   218: astore 5
    //   220: aload 5
    //   222: checkcast 95	android/os/Looper
    //   225: astore 5
    //   227: aload 5
    //   229: ifnonnull +5 -> 234
    //   232: iconst_1
    //   233: ireturn
    //   234: new 88	com/tencent/turingfd/sdk/xq/Gemini
    //   237: dup
    //   238: aload 4
    //   240: checkcast 97	android/os/Handler
    //   243: aload_0
    //   244: getfield 16	com/tencent/turingfd/sdk/xq/GalacticCore:a	Landroid/view/Window;
    //   247: aload 5
    //   249: aload_0
    //   250: getfield 20	com/tencent/turingfd/sdk/xq/GalacticCore:c	Lcom/tencent/turingfd/sdk/xq/Cygnus;
    //   253: aload_0
    //   254: getfield 18	com/tencent/turingfd/sdk/xq/GalacticCore:b	Ljava/lang/String;
    //   257: invokespecial 100	com/tencent/turingfd/sdk/xq/Gemini:<init>	(Landroid/os/Handler;Landroid/view/Window;Landroid/os/Looper;Lcom/tencent/turingfd/sdk/xq/Cygnus;Ljava/lang/String;)V
    //   260: astore 4
    //   262: aload_3
    //   263: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   266: ldc 75
    //   268: invokevirtual 79	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   271: astore 5
    //   273: aload 5
    //   275: iconst_1
    //   276: invokevirtual 82	java/lang/reflect/Field:setAccessible	(Z)V
    //   279: aload 5
    //   281: aload_3
    //   282: aload 4
    //   284: invokevirtual 104	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   287: iconst_1
    //   288: ireturn
    //   289: astore_3
    //   290: iconst_1
    //   291: ireturn
    //   292: astore_3
    //   293: goto -219 -> 74
    //   296: astore_3
    //   297: goto -176 -> 121
    //   300: astore 4
    //   302: goto -145 -> 157
    //   305: astore 6
    //   307: goto -87 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	GalacticCore
    //   22	8	1	i	int
    //   170	2	2	bool	boolean
    //   18	264	3	localObject1	Object
    //   289	1	3	localObject2	Object
    //   292	1	3	localObject3	Object
    //   296	1	3	localObject4	Object
    //   39	244	4	localObject5	Object
    //   300	1	4	localObject6	Object
    //   24	256	5	localObject7	Object
    //   182	35	6	localObject8	Object
    //   305	1	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	289	finally
    //   165	171	289	finally
    //   220	227	289	finally
    //   234	287	289	finally
    //   35	41	292	finally
    //   41	71	292	finally
    //   82	88	296	finally
    //   88	118	296	finally
    //   129	154	300	finally
    //   177	184	305	finally
    //   184	216	305	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.GalacticCore
 * JD-Core Version:    0.7.0.1
 */