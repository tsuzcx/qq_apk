package com.tencent.mobileqq.troop.quickat.ui;

import afou;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import azcy;
import azdw;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AIOAtSearchManager
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private azcy jdField_a_of_type_Azcy;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<afou> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private ConcurrentHashMap<String, Runnable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(1);
  private Handler b;
  
  public AIOAtSearchManager(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AIOAtSearchManager");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.b = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public List<afou> a()
  {
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AIOAtSearchManager.AtSearchRunnable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null)
      {
        ((AIOAtSearchManager.AtSearchRunnable)localObject).a = true;
        this.b.removeCallbacks((Runnable)localObject);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(azcy paramazcy)
  {
    this.jdField_a_of_type_Azcy = paramazcy;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a();
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      AIOAtSearchManager.AtSearchRunnable localAtSearchRunnable = new AIOAtSearchManager.AtSearchRunnable(paramString, a(), this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localAtSearchRunnable);
      this.b.post(localAtSearchRunnable);
      if (QLog.isColorLevel()) {
        QLog.e("AIOAtSearchManager", 2, "taa putTask: " + System.currentTimeMillis());
      }
      return;
    }
  }
  
  /* Error */
  public void a(List<afou> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: invokeinterface 174 1 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 47	com/tencent/mobileqq/troop/quickat/ui/AIOAtSearchManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: goto -8 -> 17
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	AIOAtSearchManager
    //   0	33	1	paramList	List<afou>
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	13	28	finally
    //   20	25	28	finally
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.b.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AIOAtSearchManager", 2, "taa handleMessage  " + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Azcy == null) {}
    do
    {
      do
      {
        return true;
      } while (paramMessage.what != 1);
      paramMessage = (azdw)paramMessage.obj;
    } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessage.a));
    this.jdField_a_of_type_Azcy.a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager
 * JD-Core Version:    0.7.0.1
 */