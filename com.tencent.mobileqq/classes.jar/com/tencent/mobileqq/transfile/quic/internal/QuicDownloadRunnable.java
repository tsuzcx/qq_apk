package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QuicDownloadRunnable
  extends AbTransportRunnable
{
  private static ConcurrentHashMap<String, QuicDownloadTask> taskHashMap = new ConcurrentHashMap();
  protected QuicDownloadTask task;
  
  public static boolean isExistTask(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("quic", 4, "isExistTask url is null.");
      return true;
    }
    return taskHashMap.containsKey(paramString);
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
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            this.task = ((QuicDownloadTask)paramMessage.obj);
            if (isExistTask(this.task.report.url))
            {
              QLog.d("quic", 4, "enqueue task is running.");
              return;
            }
            taskHashMap.put(this.task.report.url, this.task);
            this.task.prepare(this);
            this.task.startConnect();
            return;
            this.bundle = ((Bundle)paramMessage.obj);
            if (this.bundle.getInt("ID", 0) != 0)
            {
              paramMessage = taskHashMap.entrySet().iterator();
              Object localObject;
              while (paramMessage.hasNext())
              {
                localObject = (Map.Entry)paramMessage.next();
                localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
                if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == this.bundle.getInt("ID", 0))) {
                  ((QuicDownloadTask)localObject).sendData();
                }
              }
              continue;
              this.bundle = ((Bundle)paramMessage.obj);
              if (this.bundle.getByteArray("DATA") != null)
              {
                paramMessage = taskHashMap.entrySet().iterator();
                while (paramMessage.hasNext())
                {
                  localObject = (Map.Entry)paramMessage.next();
                  localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
                  if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == this.bundle.getInt("ID", 0))) {
                    ((QuicDownloadTask)localObject).receiveResponse(this.bundle.getByteArray("DATA"), this.bundle.getInt("LEN", 0));
                  }
                }
                continue;
                this.bundle = ((Bundle)paramMessage.obj);
                if (this.bundle.getInt("ID", 0) != 0)
                {
                  paramMessage = taskHashMap.entrySet().iterator();
                  while (paramMessage.hasNext())
                  {
                    localObject = (Map.Entry)paramMessage.next();
                    localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
                    if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == this.bundle.getInt("ID", 0))) {
                      ((QuicDownloadTask)localObject).connectionClose(this.bundle.getInt("CODE", 0), this.bundle.getString("DESC"));
                    }
                  }
                }
              }
            }
          }
          paramMessage = (Task)paramMessage.obj;
        } while ((paramMessage == null) || (paramMessage.netListener == null) || (!paramMessage.running) || (!(paramMessage.netListener instanceof DownloadListener)));
        ((DownloadListener)paramMessage.netListener).onDownloadSucceed(paramMessage.report.url, paramMessage.report);
        return;
        paramMessage = (Task)paramMessage.obj;
      } while ((paramMessage == null) || (paramMessage.netListener == null) || (!paramMessage.running) || (!(paramMessage.netListener instanceof DownloadListener)));
      ((DownloadListener)paramMessage.netListener).onDownloadFailed(paramMessage.report.url, paramMessage.report);
      return;
      this.task = ((QuicDownloadTask)paramMessage.obj);
      if (taskHashMap.containsValue(this.task)) {
        taskHashMap.remove(this.task.report.url);
      }
    } while (!QLog.isColorLevel());
    QLog.d("quic", 4, "taskHashMap.size: " + taskHashMap.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */