package com.tencent.qav;

import android.content.Context;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.observer.FilterableObserver;
import com.tencent.qav.observer.ObserverDispatcher;

public class QavSDK
  implements IQavSDK
{
  private static volatile QavSDK jdField_a_of_type_ComTencentQavQavSDK;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoChannelInterface jdField_a_of_type_ComTencentQavChannelVideoChannelInterface;
  private QavCtrl jdField_a_of_type_ComTencentQavControllerQavCtrl;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static QavSDK a()
  {
    if (jdField_a_of_type_ComTencentQavQavSDK == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQavQavSDK == null) {
        jdField_a_of_type_ComTencentQavQavSDK = new QavSDK();
      }
      return jdField_a_of_type_ComTencentQavQavSDK;
    }
    finally {}
  }
  
  public IMultiOperator a()
  {
    IMultiOperator localIMultiOperator = null;
    if (this.jdField_a_of_type_ComTencentQavControllerQavCtrl != null) {
      localIMultiOperator = this.jdField_a_of_type_ComTencentQavControllerQavCtrl.a();
    }
    return localIMultiOperator;
  }
  
  public void a()
  {
    try
    {
      ObserverDispatcher.a().a();
      if (this.jdField_a_of_type_ComTencentQavControllerQavCtrl != null)
      {
        this.jdField_a_of_type_ComTencentQavControllerQavCtrl.a();
        this.jdField_a_of_type_ComTencentQavControllerQavCtrl = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 50
    //   4: ldc 52
    //   6: iconst_3
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_2
    //   17: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: aload 4
    //   25: aastore
    //   26: invokestatic 64	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokestatic 70	com/tencent/qav/log/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 19	com/tencent/qav/QavSDK:jdField_a_of_type_Boolean	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 50
    //   41: ldc 72
    //   43: invokestatic 75	com/tencent/qav/log/AVLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 81	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 41	com/tencent/qav/QavSDK:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 43	com/tencent/qav/QavSDK:jdField_a_of_type_Long	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 45	com/tencent/qav/QavSDK:jdField_a_of_type_ComTencentQavChannelVideoChannelInterface	Lcom/tencent/qav/channel/VideoChannelInterface;
    //   68: aload_0
    //   69: getfield 27	com/tencent/qav/QavSDK:jdField_a_of_type_ComTencentQavControllerQavCtrl	Lcom/tencent/qav/controller/QavCtrl;
    //   72: ifnonnull +39 -> 111
    //   75: new 83	com/tencent/qav/controller/multi/MultiOperatorImpl
    //   78: dup
    //   79: aload_0
    //   80: getfield 41	com/tencent/qav/QavSDK:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   83: aload_0
    //   84: getfield 43	com/tencent/qav/QavSDK:jdField_a_of_type_Long	J
    //   87: aload_0
    //   88: getfield 45	com/tencent/qav/QavSDK:jdField_a_of_type_ComTencentQavChannelVideoChannelInterface	Lcom/tencent/qav/channel/VideoChannelInterface;
    //   91: invokespecial 85	com/tencent/qav/controller/multi/MultiOperatorImpl:<init>	(Landroid/content/Context;JLcom/tencent/qav/channel/VideoChannelInterface;)V
    //   94: astore_1
    //   95: aload_0
    //   96: new 29	com/tencent/qav/controller/QavCtrl
    //   99: dup
    //   100: aload_0
    //   101: getfield 41	com/tencent/qav/QavSDK:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   104: aload_1
    //   105: invokespecial 88	com/tencent/qav/controller/QavCtrl:<init>	(Landroid/content/Context;Lcom/tencent/qav/controller/multi/MultiOperatorImpl;)V
    //   108: putfield 27	com/tencent/qav/QavSDK:jdField_a_of_type_ComTencentQavControllerQavCtrl	Lcom/tencent/qav/controller/QavCtrl;
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 19	com/tencent/qav/QavSDK:jdField_a_of_type_Boolean	Z
    //   116: goto -70 -> 46
    //   119: astore_1
    //   120: ldc 50
    //   122: ldc 90
    //   124: aload_1
    //   125: invokestatic 93	com/tencent/qav/log/AVLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 27	com/tencent/qav/QavSDK:jdField_a_of_type_ComTencentQavControllerQavCtrl	Lcom/tencent/qav/controller/QavCtrl;
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 19	com/tencent/qav/QavSDK:jdField_a_of_type_Boolean	Z
    //   138: goto -92 -> 46
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	QavSDK
    //   0	146	1	paramContext	Context
    //   0	146	2	paramLong	long
    //   0	146	4	paramVideoChannelInterface	VideoChannelInterface
    // Exception table:
    //   from	to	target	type
    //   49	111	119	java/lang/Throwable
    //   111	116	119	java/lang/Throwable
    //   2	46	141	finally
    //   49	111	141	finally
    //   111	116	141	finally
    //   120	138	141	finally
  }
  
  public void a(QavCtrl paramQavCtrl)
  {
    this.jdField_a_of_type_ComTencentQavControllerQavCtrl = paramQavCtrl;
  }
  
  public void a(FilterableObserver paramFilterableObserver)
  {
    ObserverDispatcher.a().a(paramFilterableObserver, true);
  }
  
  public void b(FilterableObserver paramFilterableObserver)
  {
    ObserverDispatcher.a().a(paramFilterableObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.QavSDK
 * JD-Core Version:    0.7.0.1
 */