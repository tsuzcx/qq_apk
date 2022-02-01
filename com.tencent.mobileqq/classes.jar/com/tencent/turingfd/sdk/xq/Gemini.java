package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import java.lang.ref.WeakReference;

public class Gemini
  extends Handler
{
  public Handler a;
  public WeakReference<Window> b;
  public Cygnus c;
  public String d;
  
  public Gemini(Handler paramHandler, Window paramWindow, Looper paramLooper, Cygnus paramCygnus, String paramString)
  {
    super(paramLooper);
    this.a = paramHandler;
    this.c = paramCygnus;
    this.b = new WeakReference(paramWindow);
    this.d = paramString;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 46	android/os/Message:arg2	I
    //   4: istore_2
    //   5: aload_1
    //   6: getfield 49	android/os/Message:what	I
    //   9: istore_3
    //   10: aload_0
    //   11: getfield 20	com/tencent/turingfd/sdk/xq/Gemini:a	Landroid/os/Handler;
    //   14: aload_1
    //   15: invokevirtual 51	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   18: aload_0
    //   19: getfield 22	com/tencent/turingfd/sdk/xq/Gemini:c	Lcom/tencent/turingfd/sdk/xq/Cygnus;
    //   22: ifnonnull +4 -> 26
    //   25: return
    //   26: iload_3
    //   27: iconst_1
    //   28: if_icmpeq +4 -> 32
    //   31: return
    //   32: aload_0
    //   33: getfield 29	com/tencent/turingfd/sdk/xq/Gemini:b	Ljava/lang/ref/WeakReference;
    //   36: invokevirtual 55	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   39: checkcast 57	android/view/Window
    //   42: astore_1
    //   43: aload_1
    //   44: ifnonnull +4 -> 48
    //   47: return
    //   48: aload_1
    //   49: invokevirtual 61	android/view/Window:getDecorView	()Landroid/view/View;
    //   52: astore_1
    //   53: iload_2
    //   54: ifge +6 -> 60
    //   57: goto +84 -> 141
    //   60: aload_1
    //   61: ifnonnull +6 -> 67
    //   64: goto +77 -> 141
    //   67: ldc 63
    //   69: ldc 65
    //   71: iconst_1
    //   72: anewarray 67	java/lang/Class
    //   75: dup
    //   76: iconst_0
    //   77: getstatic 73	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   80: aastore
    //   81: invokevirtual 77	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   84: astore 4
    //   86: aload 4
    //   88: iconst_1
    //   89: invokevirtual 83	java/lang/reflect/Method:setAccessible	(Z)V
    //   92: aload 4
    //   94: aload_1
    //   95: iconst_1
    //   96: anewarray 85	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: iload_2
    //   102: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 63	android/view/View
    //   112: astore_1
    //   113: goto +30 -> 143
    //   116: astore_1
    //   117: goto +46 -> 163
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 97	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   125: goto +16 -> 141
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 98	java/lang/IllegalAccessException:printStackTrace	()V
    //   133: goto +8 -> 141
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 99	java/lang/NoSuchMethodException:printStackTrace	()V
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: ifnonnull +4 -> 148
    //   147: return
    //   148: aload_0
    //   149: getfield 22	com/tencent/turingfd/sdk/xq/Gemini:c	Lcom/tencent/turingfd/sdk/xq/Cygnus;
    //   152: aload_0
    //   153: getfield 31	com/tencent/turingfd/sdk/xq/Gemini:d	Ljava/lang/String;
    //   156: aload_1
    //   157: invokeinterface 104 3 0
    //   162: return
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	Gemini
    //   0	165	1	paramMessage	android.os.Message
    //   4	98	2	i	int
    //   9	20	3	j	int
    //   84	9	4	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   67	113	116	finally
    //   121	125	116	finally
    //   129	133	116	finally
    //   137	141	116	finally
    //   67	113	120	java/lang/reflect/InvocationTargetException
    //   67	113	128	java/lang/IllegalAccessException
    //   67	113	136	java/lang/NoSuchMethodException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Gemini
 * JD-Core Version:    0.7.0.1
 */