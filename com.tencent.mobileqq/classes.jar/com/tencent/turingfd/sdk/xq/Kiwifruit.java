package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.IBinder;

public abstract class Kiwifruit
  implements Guava
{
  public Hickory a;
  
  /* Error */
  public final int a(Context arg1, java.util.concurrent.atomic.AtomicReference<IBinder> paramAtomicReference, java.util.concurrent.atomic.AtomicReference<android.content.ServiceConnection> paramAtomicReference1)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 12	java/lang/Object:<init>	()V
    //   7: astore 4
    //   9: new 16	android/content/Intent
    //   12: dup
    //   13: getstatic 22	com/tencent/turingfd/sdk/xq/import:k	[I
    //   16: invokestatic 25	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   19: invokespecial 28	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   22: astore 5
    //   24: aload 5
    //   26: new 30	android/content/ComponentName
    //   29: dup
    //   30: getstatic 33	com/tencent/turingfd/sdk/xq/import:g	[I
    //   33: invokestatic 25	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   36: getstatic 36	com/tencent/turingfd/sdk/xq/import:h	[I
    //   39: invokestatic 25	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   42: invokespecial 39	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: invokevirtual 43	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   48: pop
    //   49: aload_1
    //   50: aload 5
    //   52: new 45	com/tencent/turingfd/sdk/xq/Kiwifruit$do
    //   55: dup
    //   56: aload_0
    //   57: aload_2
    //   58: aload_3
    //   59: aload 4
    //   61: invokespecial 48	com/tencent/turingfd/sdk/xq/Kiwifruit$do:<init>	(Lcom/tencent/turingfd/sdk/xq/Kiwifruit;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   64: iconst_1
    //   65: invokevirtual 54	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   68: ifne +6 -> 74
    //   71: bipush 156
    //   73: ireturn
    //   74: aload_2
    //   75: invokevirtual 60	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   78: ifnonnull +26 -> 104
    //   81: aload 4
    //   83: monitorenter
    //   84: aload 4
    //   86: ldc2_w 61
    //   89: invokevirtual 66	java/lang/Object:wait	(J)V
    //   92: aload 4
    //   94: monitorexit
    //   95: goto +9 -> 104
    //   98: astore_1
    //   99: aload 4
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    //   104: aload_2
    //   105: invokevirtual 60	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   108: ifnonnull +6 -> 114
    //   111: bipush 151
    //   113: ireturn
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_1
    //   117: goto -25 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	Kiwifruit
    //   0	120	2	paramAtomicReference	java.util.concurrent.atomic.AtomicReference<IBinder>
    //   0	120	3	paramAtomicReference1	java.util.concurrent.atomic.AtomicReference<android.content.ServiceConnection>
    //   7	93	4	localObject	Object
    //   22	29	5	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   92	95	98	finally
    //   99	102	98	finally
    //   84	92	116	finally
  }
  
  /* Error */
  public final int a(Context arg1, java.util.concurrent.atomic.AtomicReference<IBinder> paramAtomicReference, java.util.concurrent.atomic.AtomicReference<android.content.ServiceConnection> paramAtomicReference1, java.util.concurrent.atomic.AtomicReference<String> paramAtomicReference2)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 12	java/lang/Object:<init>	()V
    //   7: astore 5
    //   9: new 56	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokespecial 78	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   20: astore 6
    //   22: new 80	com/tencent/turingfd/sdk/xq/Kiwifruit$if
    //   25: dup
    //   26: aload_0
    //   27: aload_2
    //   28: aload 6
    //   30: aload 4
    //   32: aload_1
    //   33: aload_3
    //   34: aload 5
    //   36: invokespecial 83	com/tencent/turingfd/sdk/xq/Kiwifruit$if:<init>	(Lcom/tencent/turingfd/sdk/xq/Kiwifruit;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   39: invokevirtual 88	java/lang/Thread:start	()V
    //   42: aload 5
    //   44: monitorenter
    //   45: aload 5
    //   47: ldc2_w 61
    //   50: invokevirtual 66	java/lang/Object:wait	(J)V
    //   53: aload 5
    //   55: monitorexit
    //   56: aload 6
    //   58: invokevirtual 60	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   61: checkcast 71	java/lang/Integer
    //   64: invokevirtual 92	java/lang/Integer:intValue	()I
    //   67: ireturn
    //   68: astore_1
    //   69: aload 5
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: goto -22 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	Kiwifruit
    //   0	78	2	paramAtomicReference	java.util.concurrent.atomic.AtomicReference<IBinder>
    //   0	78	3	paramAtomicReference1	java.util.concurrent.atomic.AtomicReference<android.content.ServiceConnection>
    //   0	78	4	paramAtomicReference2	java.util.concurrent.atomic.AtomicReference<String>
    //   7	63	5	localObject	Object
    //   20	37	6	localAtomicReference	java.util.concurrent.atomic.AtomicReference
    // Exception table:
    //   from	to	target	type
    //   53	56	68	finally
    //   69	72	68	finally
    //   45	53	74	finally
  }
  
  public Hickory a(Context paramContext)
  {
    Hickory localHickory = this.a;
    if ((localHickory == null) || (localHickory.b != 0)) {
      this.a = c(paramContext);
    }
    return this.a;
  }
  
  public abstract String a(IBinder paramIBinder);
  
  public void b(Context paramContext)
  {
    this.a = c(paramContext);
  }
  
  /* Error */
  public final Hickory c(Context paramContext)
  {
    // Byte code:
    //   0: new 56	java/util/concurrent/atomic/AtomicReference
    //   3: dup
    //   4: invokespecial 108	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 110
    //   13: invokevirtual 113	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   16: new 56	java/util/concurrent/atomic/AtomicReference
    //   19: dup
    //   20: invokespecial 108	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   23: astore 5
    //   25: new 56	java/util/concurrent/atomic/AtomicReference
    //   28: dup
    //   29: invokespecial 108	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   32: astore 6
    //   34: aload_0
    //   35: aload_1
    //   36: aload 5
    //   38: aload 6
    //   40: invokevirtual 115	com/tencent/turingfd/sdk/xq/Kiwifruit:a	(Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;)I
    //   43: istore_3
    //   44: iload_3
    //   45: istore_2
    //   46: iload_3
    //   47: ifne +20 -> 67
    //   50: aload_0
    //   51: aload_1
    //   52: aload 5
    //   54: aload 6
    //   56: aload 4
    //   58: invokevirtual 117	com/tencent/turingfd/sdk/xq/Kiwifruit:a	(Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;)I
    //   61: istore_2
    //   62: goto +5 -> 67
    //   65: iconst_m1
    //   66: istore_2
    //   67: new 98	com/tencent/turingfd/sdk/xq/Hickory
    //   70: dup
    //   71: aload 4
    //   73: invokevirtual 60	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   76: checkcast 119	java/lang/String
    //   79: iload_2
    //   80: invokespecial 122	com/tencent/turingfd/sdk/xq/Hickory:<init>	(Ljava/lang/String;I)V
    //   83: areturn
    //   84: astore_1
    //   85: goto -20 -> 65
    //   88: astore_1
    //   89: iload_3
    //   90: istore_2
    //   91: goto -24 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	Kiwifruit
    //   0	94	1	paramContext	Context
    //   45	46	2	i	int
    //   43	47	3	j	int
    //   7	65	4	localAtomicReference1	java.util.concurrent.atomic.AtomicReference
    //   23	30	5	localAtomicReference2	java.util.concurrent.atomic.AtomicReference
    //   32	23	6	localAtomicReference3	java.util.concurrent.atomic.AtomicReference
    // Exception table:
    //   from	to	target	type
    //   16	44	84	finally
    //   50	62	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Kiwifruit
 * JD-Core Version:    0.7.0.1
 */