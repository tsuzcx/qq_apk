package com.tencent.qav;

import android.content.Context;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qav.log.AVLog;
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
    if (jdField_a_of_type_ComTencentQavQavSDK == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQavQavSDK == null) {
          jdField_a_of_type_ComTencentQavQavSDK = new QavSDK();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQavQavSDK;
  }
  
  public IMultiOperator a()
  {
    QavCtrl localQavCtrl = this.jdField_a_of_type_ComTencentQavControllerQavCtrl;
    if (localQavCtrl != null) {
      return localQavCtrl.a();
    }
    return null;
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
  
  public void a(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    try
    {
      AVLog.c("QavSDK", String.format("initSDK context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), paramVideoChannelInterface }));
      if (this.jdField_a_of_type_Boolean)
      {
        AVLog.b("QavSDK", "initSDK has init before");
        return;
      }
      try
      {
        this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
        this.jdField_a_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface = paramVideoChannelInterface;
        if (this.jdField_a_of_type_ComTencentQavControllerQavCtrl == null)
        {
          paramContext = new MultiOperatorImpl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface);
          this.jdField_a_of_type_ComTencentQavControllerQavCtrl = new QavCtrl(this.jdField_a_of_type_AndroidContentContext, paramContext);
        }
        this.jdField_a_of_type_Boolean = true;
      }
      catch (Throwable paramContext)
      {
        AVLog.a("QavSDK", "initSDK fail.", paramContext);
        this.jdField_a_of_type_ComTencentQavControllerQavCtrl = null;
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.QavSDK
 * JD-Core Version:    0.7.0.1
 */