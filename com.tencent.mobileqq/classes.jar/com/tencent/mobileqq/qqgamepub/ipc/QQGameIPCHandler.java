package com.tencent.mobileqq.qqgamepub.ipc;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QQGameIPCHandler
{
  private static volatile QQGameIPCHandler b;
  private Map<String, QQGameIPCHandler.QGameIPCTask> a = Collections.synchronizedMap(new HashMap());
  
  public static QQGameIPCHandler a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QQGameIPCHandler();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void d()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((Map)localObject).size() == 1) && (this.a.containsKey("task_qgame_task_all_complete")))
    {
      localObject = (QQGameIPCHandler.QGameIPCTask)this.a.get("task_qgame_task_all_complete");
      if ((localObject != null) && (QQGameIPCHandler.QGameIPCTask.b((QQGameIPCHandler.QGameIPCTask)localObject) != null))
      {
        QQGameIPCHandler.QGameIPCTask.b((QQGameIPCHandler.QGameIPCTask)localObject).a("task_qgame_task_all_complete", new EIPCResult());
        this.a.remove(localObject);
      }
    }
  }
  
  public void a(String paramString)
  {
    Map localMap = this.a;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      QQGameIPCHandler.QGameIPCTask.a((QQGameIPCHandler.QGameIPCTask)this.a.get(paramString), null);
    }
  }
  
  public void a(String paramString, QQGameIPCHandler.QGameIpcCallBack paramQGameIpcCallBack)
  {
    if (paramQGameIpcCallBack != null)
    {
      Map localMap = this.a;
      if ((localMap != null) && (localMap.containsKey(paramString))) {
        QQGameIPCHandler.QGameIPCTask.a((QQGameIPCHandler.QGameIPCTask)this.a.get(paramString), paramQGameIpcCallBack);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (QQGameIPCHandler.QGameIPCTask)((Map)localObject).get(paramString);
    if (localObject == null) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", QQGameIPCHandler.QGameIPCTask.a((QQGameIPCHandler.QGameIPCTask)localObject), null, new QQGameIPCHandler.1(this, (QQGameIPCHandler.QGameIPCTask)localObject, paramString, paramBoolean));
  }
  
  public void b()
  {
    Map localMap = this.a;
    if (localMap != null)
    {
      localMap.clear();
      this.a.put("task_get_qgame_msg", new QQGameIPCHandler.QGameIPCTask("findMessage"));
      this.a.put("task_get_qgame_session_msg", new QQGameIPCHandler.QGameIPCTask("getGameMsg"));
      this.a.put("task_qgame_task_all_complete", new QQGameIPCHandler.QGameIPCTask("task_qgame_task_all_complete"));
    }
  }
  
  public void c()
  {
    try
    {
      if (this.a != null)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((QQGameIPCHandler.QGameIPCTask)((Map.Entry)localIterator.next()).getValue()).a();
        }
        this.a.clear();
      }
      b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler
 * JD-Core Version:    0.7.0.1
 */