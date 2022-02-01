package com.tencent.mobileqq.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class SdCardChangeListener
  extends BroadcastReceiver
{
  private int a;
  private Handler b;
  private String c;
  
  /* Error */
  public int a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_m1
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 15	com/tencent/mobileqq/observer/SdCardChangeListener:c	Ljava/lang/String;
    //   8: invokestatic 21	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +7 -> 20
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_m1
    //   19: ireturn
    //   20: new 23	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: getfield 15	com/tencent/mobileqq/observer/SdCardChangeListener:c	Ljava/lang/String;
    //   35: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: ldc 33
    //   43: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   52: invokevirtual 42	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: ldc 44
    //   60: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: new 46	java/io/File
    //   67: dup
    //   68: aload 4
    //   70: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 4
    //   78: aload 4
    //   80: invokevirtual 57	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: aload 4
    //   86: invokevirtual 60	java/io/File:delete	()Z
    //   89: pop
    //   90: iconst_0
    //   91: istore_2
    //   92: aload_0
    //   93: iload_2
    //   94: putfield 62	com/tencent/mobileqq/observer/SdCardChangeListener:a	I
    //   97: goto +26 -> 123
    //   100: astore 4
    //   102: goto +91 -> 193
    //   105: astore 4
    //   107: aload 4
    //   109: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   112: iload_1
    //   113: bipush 254
    //   115: if_icmpne -23 -> 92
    //   118: aload_0
    //   119: iload_1
    //   120: putfield 62	com/tencent/mobileqq/observer/SdCardChangeListener:a	I
    //   123: invokestatic 71	android/os/Message:obtain	()Landroid/os/Message;
    //   126: astore 4
    //   128: aload 4
    //   130: sipush 28929
    //   133: putfield 74	android/os/Message:what	I
    //   136: new 76	android/os/Bundle
    //   139: dup
    //   140: invokespecial 77	android/os/Bundle:<init>	()V
    //   143: astore 5
    //   145: aload 5
    //   147: ldc 79
    //   149: aload_0
    //   150: getfield 62	com/tencent/mobileqq/observer/SdCardChangeListener:a	I
    //   153: invokevirtual 83	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   156: aload 5
    //   158: ldc 85
    //   160: aload_0
    //   161: getfield 15	com/tencent/mobileqq/observer/SdCardChangeListener:c	Ljava/lang/String;
    //   164: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 4
    //   169: aload 5
    //   171: invokevirtual 93	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   174: aload_0
    //   175: getfield 95	com/tencent/mobileqq/observer/SdCardChangeListener:b	Landroid/os/Handler;
    //   178: aload 4
    //   180: invokevirtual 101	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   183: pop
    //   184: aload_0
    //   185: getfield 62	com/tencent/mobileqq/observer/SdCardChangeListener:a	I
    //   188: istore_1
    //   189: aload_0
    //   190: monitorexit
    //   191: iload_1
    //   192: ireturn
    //   193: iload_1
    //   194: bipush 254
    //   196: if_icmpne +11 -> 207
    //   199: aload_0
    //   200: iload_1
    //   201: putfield 62	com/tencent/mobileqq/observer/SdCardChangeListener:a	I
    //   204: goto +8 -> 212
    //   207: aload_0
    //   208: iconst_m1
    //   209: putfield 62	com/tencent/mobileqq/observer/SdCardChangeListener:a	I
    //   212: aload 4
    //   214: athrow
    //   215: astore 4
    //   217: aload_0
    //   218: monitorexit
    //   219: goto +6 -> 225
    //   222: aload 4
    //   224: athrow
    //   225: goto -3 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	SdCardChangeListener
    //   0	228	1	paramInt	int
    //   3	91	2	i	int
    //   11	2	3	bool	boolean
    //   27	58	4	localObject1	java.lang.Object
    //   100	1	4	localObject2	java.lang.Object
    //   105	3	4	localException	java.lang.Exception
    //   126	87	4	localMessage	android.os.Message
    //   215	8	4	localObject3	java.lang.Object
    //   143	27	5	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   20	90	100	finally
    //   107	112	100	finally
    //   20	90	105	java/lang/Exception
    //   4	12	215	finally
    //   92	97	215	finally
    //   118	123	215	finally
    //   123	189	215	finally
    //   199	204	215	finally
    //   207	212	215	finally
    //   212	215	215	finally
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.MEDIA_UNMOUNTED"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_UNMOUNTED");
      }
      this.a = -2;
    }
    else if (paramContext.equals("android.intent.action.MEDIA_MOUNTED"))
    {
      this.a = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_MOUNTED");
      }
    }
    else if (paramContext.equals("android.intent.action.MEDIA_REMOVED"))
    {
      this.a = -2;
      if (QLog.isColorLevel()) {
        QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_REMOVED");
      }
    }
    else if (paramContext.equals("android.intent.action.MEDIA_EJECT"))
    {
      this.a = -2;
      if (QLog.isColorLevel()) {
        QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_EJECT");
      }
    }
    this.a = a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.observer.SdCardChangeListener
 * JD-Core Version:    0.7.0.1
 */