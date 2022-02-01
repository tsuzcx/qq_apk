package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
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
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AIOAtSearchManager.RefreshUIListener jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager$RefreshUIListener;
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
  
  public void a(AIOAtSearchManager.RefreshUIListener paramRefreshUIListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager$RefreshUIListener = paramRefreshUIListener;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new AIOAtSearchManager.AtSearchRunnable(str, a(), this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
    this.b.post(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("taa putTask: ");
      paramString.append(System.currentTimeMillis());
      QLog.e("AIOAtSearchManager", 2, paramString.toString());
    }
  }
  
  public void a(List<TroopMemberInfo> paramList)
  {
    if (paramList != null) {
      try
      {
        if (!paramList.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilList = paramList;
          return;
        }
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        boolean bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("taa handleMessage  ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.e("AIOAtSearchManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager$RefreshUIListener == null) {
      return true;
    }
    if (paramMessage.what != 1) {
      return true;
    }
    paramMessage = (SearchTask.SearchResult)paramMessage.obj;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessage.a)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager$RefreshUIListener.a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager
 * JD-Core Version:    0.7.0.1
 */