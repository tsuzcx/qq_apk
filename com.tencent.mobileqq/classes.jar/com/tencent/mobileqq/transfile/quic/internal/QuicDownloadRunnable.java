package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class QuicDownloadRunnable
  extends AbTransportRunnable
{
  private static final int INIT_TASK_ID = 65534;
  private static HashMap<String, Integer> allRunningTaskMap = new HashMap();
  private static AtomicInteger sUniqueID = new AtomicInteger(65534);
  private static ConcurrentHashMap<String, QuicDownloadTask> taskHashMap = new ConcurrentHashMap();
  protected QuicDownloadTask task;
  
  private void dataReceiving(Bundle paramBundle)
  {
    Iterator localIterator = taskHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
      if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == paramBundle.getInt("ID", 0))) {
        ((QuicDownloadTask)localObject).receiveResponse(paramBundle.getByteArray("DATA"), paramBundle.getInt("LEN", 0));
      }
    }
  }
  
  public static int getTaskID(String paramString)
  {
    try
    {
      paramString = (Integer)allRunningTaskMap.get(paramString);
      if (paramString != null)
      {
        int i = paramString.intValue();
        return i;
      }
      throw new IllegalArgumentException("task id is null!!");
    }
    finally {}
  }
  
  public static boolean isExistTaskAddIfNeed(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return false;
      }
      bool = allRunningTaskMap.containsKey(paramString);
      if (bool) {
        return true;
      }
      allRunningTaskMap.put(paramString, Integer.valueOf(sUniqueID.incrementAndGet()));
      return false;
    }
    finally {}
  }
  
  public static void removeRunningTask(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      paramString = (Integer)allRunningTaskMap.remove(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("quic", 4, new Object[] { "removeTask: ", paramString });
      }
      if (allRunningTaskMap.isEmpty()) {
        sUniqueID.set(65534);
      }
      if (QLog.isColorLevel())
      {
        int i = allRunningTaskMap.size();
        paramString = new StringBuilder();
        paramString.append(" sUniqueID: ");
        paramString.append(sUniqueID);
        QLog.d("quic", 4, new Object[] { "allTaskSize: ", Integer.valueOf(i), paramString.toString() });
      }
      return;
    }
    finally {}
  }
  
  private void serverClose(Bundle paramBundle)
  {
    Iterator localIterator = taskHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
      if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == paramBundle.getInt("ID", 0))) {
        ((QuicDownloadTask)localObject).connectionClose(paramBundle.getInt("CODE", 0), paramBundle.getString("DESC"));
      }
    }
  }
  
  private void taskConnected(Bundle paramBundle)
  {
    Iterator localIterator = taskHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
      if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == paramBundle.getInt("ID", 0))) {
        ((QuicDownloadTask)localObject).sendData();
      }
    }
  }
  
  private void taskFail(Message paramMessage)
  {
    paramMessage = (Task)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.netListener != null))
    {
      if (!paramMessage.running) {
        return;
      }
      if ((paramMessage.netListener instanceof DownloadListener)) {
        ((DownloadListener)paramMessage.netListener).onDownloadFailed(paramMessage.report.url, paramMessage.report);
      }
    }
  }
  
  private void taskFinish(Message paramMessage)
  {
    this.task = ((QuicDownloadTask)paramMessage.obj);
    if (taskHashMap.containsValue(this.task)) {
      taskHashMap.remove(this.task.report.tempPath);
    }
    removeRunningTask(this.task.report.tempPath);
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, new Object[] { "taskHashMap.size: ", Integer.valueOf(taskHashMap.size()) });
    }
  }
  
  private void taskSuccess(Message paramMessage)
  {
    paramMessage = (Task)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.netListener != null))
    {
      if (!paramMessage.running) {
        return;
      }
      if ((paramMessage.netListener instanceof DownloadListener)) {
        ((DownloadListener)paramMessage.netListener).onDownloadSucceed(paramMessage.report.url, paramMessage.report);
      }
    }
  }
  
  public void enqueue(QuicDownloadTask paramQuicDownloadTask)
  {
    this.message.what = 9;
    this.message.obj = paramQuicDownloadTask;
    handleMessage(this.message);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    case 5: 
    default: 
      return;
    case 9: 
      this.task = ((QuicDownloadTask)paramMessage.obj);
      taskHashMap.put(this.task.report.tempPath, this.task);
      this.task.prepare(this);
      this.task.startConnect();
      return;
    case 8: 
      taskFail(paramMessage);
      return;
    case 7: 
      taskFinish(paramMessage);
      return;
    case 6: 
      taskSuccess(paramMessage);
      return;
    case 4: 
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage.getInt("ID", 0) == 0) {
        return;
      }
      serverClose(paramMessage);
      return;
    case 2: 
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage.getByteArray("DATA") == null) {
        return;
      }
      dataReceiving(paramMessage);
      return;
    }
    paramMessage = (Bundle)paramMessage.obj;
    if (paramMessage.getInt("ID", 0) == 0) {
      return;
    }
    taskConnected(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */