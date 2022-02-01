package com.tencent.mobileqq.gamecenter.web;

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
  private static volatile QQGameIpcHandle jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameIpcHandle;
  private Map<String, QQGameIpcHandle.QGameIPCTask> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static QQGameIpcHandle a()
  {
    if (jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameIpcHandle == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameIpcHandle == null) {
        jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameIpcHandle = new QQGameIpcHandle();
      }
      return jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameIpcHandle;
    }
    finally {}
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey("task_qgame_task_all_complete")))
    {
      QQGameIpcHandle.QGameIPCTask localQGameIPCTask = (QQGameIpcHandle.QGameIPCTask)this.jdField_a_of_type_JavaUtilMap.get("task_qgame_task_all_complete");
      if ((localQGameIPCTask != null) && (QQGameIpcHandle.QGameIPCTask.a(localQGameIPCTask) != null))
      {
        QQGameIpcHandle.QGameIPCTask.a(localQGameIPCTask).a("task_qgame_task_all_complete", new EIPCResult());
        this.jdField_a_of_type_JavaUtilMap.remove(localQGameIPCTask);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_msg", new QQGameIpcHandle.QGameIPCTask("findMessage"));
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_session_msg", new QQGameIpcHandle.QGameIPCTask("getGameMsg"));
      this.jdField_a_of_type_JavaUtilMap.put("task_qgame_task_all_complete", new QQGameIpcHandle.QGameIPCTask("task_qgame_task_all_complete"));
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      QQGameIpcHandle.QGameIPCTask.a((QQGameIpcHandle.QGameIPCTask)this.jdField_a_of_type_JavaUtilMap.get(paramString), null);
    }
  }
  
  public void a(String paramString, QQGameIpcHandle.QGameIpcCallBack paramQGameIpcCallBack)
  {
    if ((paramQGameIpcCallBack != null) && (this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      QQGameIpcHandle.QGameIPCTask.a((QQGameIpcHandle.QGameIPCTask)this.jdField_a_of_type_JavaUtilMap.get(paramString), paramQGameIpcCallBack);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    QQGameIpcHandle.QGameIPCTask localQGameIPCTask;
    do
    {
      return;
      localQGameIPCTask = (QQGameIpcHandle.QGameIPCTask)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while (localQGameIPCTask == null);
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", QQGameIpcHandle.QGameIPCTask.a(localQGameIPCTask), null, new QQGameIpcHandle.1(this, localQGameIPCTask, paramString, paramBoolean));
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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameIpcHandle = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameIpcHandle
 * JD-Core Version:    0.7.0.1
 */