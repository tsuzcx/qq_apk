package com.tencent.mobileqq.ptt.player;

import agyd;
import android.app.Application;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public final class SilkPlayer
  implements Handler.Callback, IPttPlayer
{
  private byte jdField_a_of_type_Byte = -1;
  private int jdField_a_of_type_Int = 3;
  private agyd jdField_a_of_type_Agyd;
  private Application jdField_a_of_type_AndroidAppApplication = BaseApplicationImpl.sApplication;
  private IPttPlayerListener jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  
  public int a()
  {
    return this.e * 20;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agyd == null)
    {
      this.jdField_a_of_type_Agyd = new agyd(this, this.jdField_a_of_type_AndroidAppApplication);
      if ((this.c == -1) && (this.e > 0)) {
        b(a());
      }
      this.jdField_a_of_type_Agyd.start();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, byte paramByte)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Byte = paramByte;
  }
  
  public void a(IPttPlayerListener paramIPttPlayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener = paramIPttPlayerListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Agyd != null) && (agyd.a(this.jdField_a_of_type_Agyd));
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Agyd = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "seekTo=" + paramInt);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Agyd != null) && (this.jdField_a_of_type_Agyd.isAlive()))
    {
      agyd.a(this.jdField_a_of_type_Agyd, false);
      this.jdField_a_of_type_Agyd = null;
    }
    this.b = -1;
    this.jdField_a_of_type_Byte = -1;
    this.d = 0;
    this.e = 0;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_Agyd != null) && (this.jdField_a_of_type_Agyd.isAlive()))
    {
      agyd.a(this.jdField_a_of_type_Agyd, false);
      this.jdField_a_of_type_Agyd = null;
    }
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mobileqq/ptt/player/SilkPlayer:b	I
    //   4: iconst_m1
    //   5: if_icmpeq +11 -> 16
    //   8: aload_0
    //   9: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   12: iconst_m1
    //   13: if_icmpne +67 -> 80
    //   16: new 132	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 63	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   34: iconst_m1
    //   35: if_icmpne +46 -> 81
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: aload_2
    //   42: invokestatic 139	com/tencent/mobileqq/utils/RecordParams:a	(Ljava/io/InputStream;)B
    //   45: putfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 28	com/tencent/mobileqq/ptt/player/SilkPlayer:b	I
    //   54: iconst_m1
    //   55: if_icmpne +17 -> 72
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   65: aload_2
    //   66: invokestatic 144	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: putfield 28	com/tencent/mobileqq/ptt/player/SilkPlayer:b	I
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 147	java/io/FileInputStream:close	()V
    //   80: return
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ldc2_w 148
    //   87: invokevirtual 153	java/io/FileInputStream:skip	(J)J
    //   90: pop2
    //   91: goto -43 -> 48
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +33 -> 133
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 101
    //   107: iconst_2
    //   108: new 103	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   115: ldc 155
    //   117: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_3
    //   121: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_2
    //   134: ifnull -54 -> 80
    //   137: aload_2
    //   138: invokevirtual 147	java/io/FileInputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: return
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 147	java/io/FileInputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_1
    //   158: return
    //   159: astore_1
    //   160: goto -5 -> 155
    //   163: astore_2
    //   164: goto -17 -> 147
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -75 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	SilkPlayer
    //   29	76	1	localFileInputStream1	java.io.FileInputStream
    //   142	1	1	localException1	java.lang.Exception
    //   146	6	1	localObject1	Object
    //   157	1	1	localException2	java.lang.Exception
    //   159	1	1	localException3	java.lang.Exception
    //   27	111	2	localFileInputStream2	java.io.FileInputStream
    //   144	12	2	localObject2	Object
    //   163	1	2	localObject3	Object
    //   169	1	2	localObject4	Object
    //   94	27	3	localException4	java.lang.Exception
    //   167	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	94	java/lang/Exception
    //   40	48	94	java/lang/Exception
    //   50	58	94	java/lang/Exception
    //   60	72	94	java/lang/Exception
    //   83	91	94	java/lang/Exception
    //   137	141	142	java/lang/Exception
    //   16	28	144	finally
    //   76	80	157	java/lang/Exception
    //   151	155	159	java/lang/Exception
    //   30	38	163	finally
    //   40	48	163	finally
    //   50	58	163	finally
    //   60	72	163	finally
    //   83	91	163	finally
    //   97	103	163	finally
    //   105	133	163	finally
    //   16	28	167	java/lang/Exception
  }
  
  public void h()
  {
    this.jdField_a_of_type_Agyd = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a(this, 0, 0);
      }
    }
    while ((paramMessage.what != 2) || (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener == null)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.SilkPlayer
 * JD-Core Version:    0.7.0.1
 */