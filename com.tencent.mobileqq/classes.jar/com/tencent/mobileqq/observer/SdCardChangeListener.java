package com.tencent.mobileqq.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class SdCardChangeListener
  extends BroadcastReceiver
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  
  /* Error */
  public int a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_m1
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 13	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +9 -> 22
    //   16: iload_2
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: new 21	java/io/File
    //   25: dup
    //   26: new 23	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   33: aload_0
    //   34: getfield 13	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 33
    //   42: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   48: invokevirtual 42	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: ldc 44
    //   53: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 4
    //   64: aload 4
    //   66: invokevirtual 55	java/io/File:createNewFile	()Z
    //   69: pop
    //   70: aload 4
    //   72: invokevirtual 58	java/io/File:delete	()Z
    //   75: pop
    //   76: iload_1
    //   77: bipush 254
    //   79: if_icmpne +3 -> 82
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 60	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_Int	I
    //   87: invokestatic 66	android/os/Message:obtain	()Landroid/os/Message;
    //   90: astore 4
    //   92: aload 4
    //   94: sipush 28929
    //   97: putfield 69	android/os/Message:what	I
    //   100: new 71	android/os/Bundle
    //   103: dup
    //   104: invokespecial 72	android/os/Bundle:<init>	()V
    //   107: astore 5
    //   109: aload 5
    //   111: ldc 74
    //   113: aload_0
    //   114: getfield 60	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_Int	I
    //   117: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   120: aload 5
    //   122: ldc 80
    //   124: aload_0
    //   125: getfield 13	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   128: invokevirtual 84	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload 4
    //   133: aload 5
    //   135: invokevirtual 88	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   138: aload_0
    //   139: getfield 90	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   142: aload 4
    //   144: invokevirtual 96	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   147: pop
    //   148: aload_0
    //   149: getfield 60	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_Int	I
    //   152: istore_1
    //   153: goto -135 -> 18
    //   156: astore 4
    //   158: aload 4
    //   160: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   163: iload_1
    //   164: bipush 254
    //   166: if_icmpne +18 -> 184
    //   169: aload_0
    //   170: iload_1
    //   171: putfield 60	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_Int	I
    //   174: goto -87 -> 87
    //   177: astore 4
    //   179: aload_0
    //   180: monitorexit
    //   181: aload 4
    //   183: athrow
    //   184: aload_0
    //   185: iconst_m1
    //   186: putfield 60	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_Int	I
    //   189: goto -102 -> 87
    //   192: astore 4
    //   194: iload_1
    //   195: bipush 254
    //   197: if_icmpne +11 -> 208
    //   200: aload_0
    //   201: iload_1
    //   202: putfield 60	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_Int	I
    //   205: aload 4
    //   207: athrow
    //   208: aload_0
    //   209: iconst_m1
    //   210: putfield 60	com/tencent/mobileqq/observer/SdCardChangeListener:jdField_a_of_type_Int	I
    //   213: goto -8 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	SdCardChangeListener
    //   0	216	1	paramInt	int
    //   3	14	2	i	int
    //   11	2	3	bool	boolean
    //   62	81	4	localObject1	java.lang.Object
    //   156	3	4	localException	java.lang.Exception
    //   177	5	4	localObject2	java.lang.Object
    //   192	14	4	localObject3	java.lang.Object
    //   107	27	5	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   22	76	156	java/lang/Exception
    //   4	12	177	finally
    //   82	87	177	finally
    //   87	153	177	finally
    //   169	174	177	finally
    //   184	189	177	finally
    //   200	205	177	finally
    //   205	208	177	finally
    //   208	213	177	finally
    //   22	76	192	finally
    //   158	163	192	finally
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.MEDIA_UNMOUNTED"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_UNMOUNTED");
      }
      this.jdField_a_of_type_Int = -2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int);
      return;
      if (paramContext.equals("android.intent.action.MEDIA_MOUNTED"))
      {
        this.jdField_a_of_type_Int = 0;
        if (QLog.isColorLevel()) {
          QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_MOUNTED");
        }
      }
      else if (paramContext.equals("android.intent.action.MEDIA_REMOVED"))
      {
        this.jdField_a_of_type_Int = -2;
        if (QLog.isColorLevel()) {
          QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_REMOVED");
        }
      }
      else if (paramContext.equals("android.intent.action.MEDIA_EJECT"))
      {
        this.jdField_a_of_type_Int = -2;
        if (QLog.isColorLevel()) {
          QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_EJECT");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.observer.SdCardChangeListener
 * JD-Core Version:    0.7.0.1
 */