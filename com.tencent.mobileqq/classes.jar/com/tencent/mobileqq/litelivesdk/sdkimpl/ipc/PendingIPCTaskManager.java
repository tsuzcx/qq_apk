package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PendingIPCTaskManager
{
  private Map<String, Queue<PendingIPCTask>> a = new ConcurrentHashMap();
  
  public void a(String paramString)
  {
    Queue localQueue = (Queue)this.a.get(paramString);
    if (localQueue != null)
    {
      QLog.i("PendingIPCTaskManager", 1, "doPendingIPCTask enter----size = " + localQueue.size());
      paramString = (PendingIPCTask)localQueue.poll();
      if (paramString != null)
      {
        if (System.currentTimeMillis() - paramString.jdField_a_of_type_Long <= 10000L)
        {
          QLog.i("PendingIPCTaskManager", 1, "doPendingIPCTask action = " + paramString.jdField_a_of_type_JavaLangString + " will Run");
          QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", paramString.jdField_a_of_type_JavaLangString, paramString.jdField_a_of_type_AndroidOsBundle);
        }
        for (;;)
        {
          paramString = (PendingIPCTask)localQueue.poll();
          break;
          QLog.i("PendingIPCTaskManager", 1, "doPendingIPCTask action = " + paramString.jdField_a_of_type_JavaLangString + " already expire, will discard");
        }
      }
      QLog.i("PendingIPCTaskManager", 1, "doPendingIPCTask end----size = " + localQueue.size());
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = (Queue)this.a.get(paramString);
    return (paramString == null) || (paramString.isEmpty());
  }
  
  public boolean a(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = (Queue)this.a.get(paramString1);
    if (localObject == null)
    {
      localObject = new ConcurrentLinkedQueue();
      this.a.put(paramString1, localObject);
    }
    for (paramString1 = (String)localObject;; paramString1 = (String)localObject)
    {
      localObject = paramString1.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendingIPCTask localPendingIPCTask = (PendingIPCTask)((Iterator)localObject).next();
        if ((paramString2.equals(localPendingIPCTask.jdField_a_of_type_JavaLangString)) && (!paramString2.equals("Action_Client_customizedBizSDKService")) && (!paramString2.equals("Action_Client_CustomizedBizModules")))
        {
          QLog.e("PendingIPCTaskManager", 1, "addPendingTask----action = " + paramString2 + " already exist, update and return");
          localPendingIPCTask.jdField_a_of_type_Long = System.currentTimeMillis();
          localPendingIPCTask.jdField_a_of_type_AndroidOsBundle = paramBundle;
          return true;
        }
      }
      QLog.i("PendingIPCTaskManager", 1, "addPendingTask----action = " + paramString2);
      localObject = new PendingIPCTask();
      ((PendingIPCTask)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
      ((PendingIPCTask)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((PendingIPCTask)localObject).jdField_a_of_type_AndroidOsBundle = paramBundle;
      return paramString1.add(localObject);
    }
  }
  
  public void b(String paramString)
  {
    paramString = (Queue)this.a.get(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.PendingIPCTaskManager
 * JD-Core Version:    0.7.0.1
 */