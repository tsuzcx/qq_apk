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
      paramString = new StringBuilder();
      paramString.append("doPendingIPCTask enter----size = ");
      paramString.append(localQueue.size());
      QLog.i("PendingIPCTaskManager", 1, paramString.toString());
      for (paramString = (PendingIPCTask)localQueue.poll(); paramString != null; paramString = (PendingIPCTask)localQueue.poll())
      {
        StringBuilder localStringBuilder;
        if (System.currentTimeMillis() - paramString.jdField_a_of_type_Long <= 10000L)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doPendingIPCTask action = ");
          localStringBuilder.append(paramString.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(" will Run");
          QLog.i("PendingIPCTaskManager", 1, localStringBuilder.toString());
          QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", paramString.jdField_a_of_type_JavaLangString, paramString.jdField_a_of_type_AndroidOsBundle);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doPendingIPCTask action = ");
          localStringBuilder.append(paramString.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(" already expire, will discard");
          QLog.i("PendingIPCTaskManager", 1, localStringBuilder.toString());
        }
      }
      paramString = new StringBuilder();
      paramString.append("doPendingIPCTask end----size = ");
      paramString.append(localQueue.size());
      QLog.i("PendingIPCTaskManager", 1, paramString.toString());
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = (Queue)this.a.get(paramString);
    return (paramString == null) || (paramString.isEmpty());
  }
  
  public boolean a(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject2 = (Queue)this.a.get(paramString1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentLinkedQueue();
      this.a.put(paramString1, localObject1);
    }
    localObject2 = ((Queue)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramString1 = (PendingIPCTask)((Iterator)localObject2).next();
      if ((paramString2.equals(paramString1.jdField_a_of_type_JavaLangString)) && (!paramString2.equals("Action_Client_customizedBizSDKService")) && (!paramString2.equals("Action_Client_CustomizedBizModules")))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addPendingTask----action = ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" already exist, update and return");
        QLog.e("PendingIPCTaskManager", 1, ((StringBuilder)localObject1).toString());
        paramString1.jdField_a_of_type_Long = System.currentTimeMillis();
        paramString1.jdField_a_of_type_AndroidOsBundle = paramBundle;
        return true;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("addPendingTask----action = ");
    paramString1.append(paramString2);
    QLog.i("PendingIPCTaskManager", 1, paramString1.toString());
    paramString1 = new PendingIPCTask();
    paramString1.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    paramString1.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return ((Queue)localObject1).add(paramString1);
  }
  
  public void b(String paramString)
  {
    paramString = (Queue)this.a.get(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.PendingIPCTaskManager
 * JD-Core Version:    0.7.0.1
 */