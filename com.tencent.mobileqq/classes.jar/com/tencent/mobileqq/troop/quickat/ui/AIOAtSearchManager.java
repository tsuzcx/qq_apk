package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import bfiz;
import bfjx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
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
  private bfiz jdField_a_of_type_Bfiz;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<TroopMemberInfo> jdField_a_of_type_JavaUtilList = new ArrayList(0);
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
  
  public List<TroopMemberInfo> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      return localArrayList;
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
  
  public void a(bfiz parambfiz)
  {
    this.jdField_a_of_type_Bfiz = parambfiz;
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
  public void a(List<TroopMemberInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: invokeinterface 179 1 0
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
    //   0	33	1	paramList	List<TroopMemberInfo>
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	13	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/mobileqq/troop/quickat/ui/AIOAtSearchManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 47	com/tencent/mobileqq/troop/quickat/ui/AIOAtSearchManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 179 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifeq +9 -> 29
    //   23: iconst_1
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: goto -6 -> 25
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	AIOAtSearchManager
    //   18	13	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	34	finally
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
    if (this.jdField_a_of_type_Bfiz == null) {}
    do
    {
      do
      {
        return true;
      } while (paramMessage.what != 1);
      paramMessage = (bfjx)paramMessage.obj;
    } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessage.a));
    this.jdField_a_of_type_Bfiz.a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager
 * JD-Core Version:    0.7.0.1
 */