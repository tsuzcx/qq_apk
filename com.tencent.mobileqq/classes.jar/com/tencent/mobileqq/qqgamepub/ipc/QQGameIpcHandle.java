package com.tencent.mobileqq.qqgamepub.ipc;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QQGameIpcHandle
{
  private static volatile QQGameIpcHandle jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle;
  private Map<String, QQGameIpcHandle.QGameIPCTask> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static QQGameIpcHandle a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle == null) {
          jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle = new QQGameIpcHandle();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle;
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if ((localObject != null) && (((Map)localObject).size() == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey("task_qgame_task_all_complete")))
    {
      localObject = (QQGameIpcHandle.QGameIPCTask)this.jdField_a_of_type_JavaUtilMap.get("task_qgame_task_all_complete");
      if ((localObject != null) && (QQGameIpcHandle.QGameIPCTask.a((QQGameIpcHandle.QGameIPCTask)localObject) != null))
      {
        QQGameIpcHandle.QGameIPCTask.a((QQGameIpcHandle.QGameIPCTask)localObject).a("task_qgame_task_all_complete", new EIPCResult());
        this.jdField_a_of_type_JavaUtilMap.remove(localObject);
      }
    }
  }
  
  public void a()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null)
    {
      localMap.clear();
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_msg", new QQGameIpcHandle.QGameIPCTask("findMessage"));
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_session_msg", new QQGameIpcHandle.QGameIPCTask("getGameMsg"));
      this.jdField_a_of_type_JavaUtilMap.put("task_qgame_task_all_complete", new QQGameIpcHandle.QGameIPCTask("task_qgame_task_all_complete"));
    }
  }
  
  public void a(String paramString)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      QQGameIpcHandle.QGameIPCTask.a((QQGameIpcHandle.QGameIPCTask)this.jdField_a_of_type_JavaUtilMap.get(paramString), null);
    }
  }
  
  public void a(String paramString, QQGameIpcHandle.QGameIpcCallBack paramQGameIpcCallBack)
  {
    if (paramQGameIpcCallBack != null)
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      if ((localMap != null) && (localMap.containsKey(paramString))) {
        QQGameIpcHandle.QGameIPCTask.a((QQGameIpcHandle.QGameIPCTask)this.jdField_a_of_type_JavaUtilMap.get(paramString), paramQGameIpcCallBack);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject == null) {
      return;
    }
    localObject = (QQGameIpcHandle.QGameIPCTask)((Map)localObject).get(paramString);
    if (localObject == null) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", QQGameIpcHandle.QGameIPCTask.a((QQGameIpcHandle.QGameIPCTask)localObject), null, new QQGameIpcHandle.1(this, (QQGameIpcHandle.QGameIPCTask)localObject, paramString, paramBoolean));
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((QQGameIpcHandle.QGameIPCTask)((Map.Entry)localIterator.next()).getValue()).a();
        }
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.ipc.QQGameIpcHandle
 * JD-Core Version:    0.7.0.1
 */