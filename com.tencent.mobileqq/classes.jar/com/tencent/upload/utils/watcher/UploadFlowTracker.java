package com.tencent.upload.utils.watcher;

import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.task.BaseTask;
import com.tencent.upload.uinterface.AbstractUploadTask;

public class UploadFlowTracker
{
  private static StringBuffer appendMessage(StringBuffer paramStringBuffer, String paramString)
  {
    if (paramStringBuffer == null) {
      return paramStringBuffer;
    }
    try
    {
      paramStringBuffer.append(paramString);
      return paramStringBuffer;
    }
    catch (Exception paramString) {}
    return paramStringBuffer;
  }
  
  public static void trackCancel(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    paramAbstractUploadTask = paramAbstractUploadTask.getFlowRecoder();
    appendMessage(paramAbstractUploadTask, "任务取消");
    appendMessage(paramAbstractUploadTask, "\n");
  }
  
  public static void trackException(BaseTask paramBaseTask, Throwable paramThrowable)
  {
    if (((paramBaseTask instanceof AbstractUploadTask)) && (paramThrowable != null))
    {
      paramBaseTask = ((AbstractUploadTask)paramBaseTask).getFlowRecoder();
      appendMessage(paramBaseTask, "异常");
      appendMessage(paramBaseTask, paramThrowable.getMessage());
      appendMessage(paramBaseTask, "\n");
    }
  }
  
  public static void trackFlow(BaseTask paramBaseTask, String paramString)
  {
    if (((paramBaseTask instanceof AbstractUploadTask)) && (paramString != null)) {
      ((AbstractUploadTask)paramBaseTask).getFlowRecoder().append(paramString).append("\n");
    }
  }
  
  public static void trackRoute(BaseTask paramBaseTask, IUploadSession paramIUploadSession)
  {
    if (((paramBaseTask instanceof AbstractUploadTask)) && (paramIUploadSession != null))
    {
      paramBaseTask = ((AbstractUploadTask)paramBaseTask).getFlowRecoder();
      String str = paramIUploadSession.getConnectedIp();
      paramIUploadSession = paramIUploadSession.getUploadRoute();
      if (str != null)
      {
        appendMessage(paramBaseTask, "connect ip:");
        appendMessage(paramBaseTask, str);
      }
      if (paramIUploadSession != null)
      {
        appendMessage(paramBaseTask, " route :");
        appendMessage(paramBaseTask, paramIUploadSession.toString());
      }
      paramBaseTask.append("\n");
    }
  }
  
  public static void trackStart(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    StringBuffer localStringBuffer = paramAbstractUploadTask.getFlowRecoder();
    appendMessage(localStringBuffer, "flow id :");
    appendMessage(localStringBuffer, String.valueOf(paramAbstractUploadTask.flowId));
    appendMessage(localStringBuffer, "\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.watcher.UploadFlowTracker
 * JD-Core Version:    0.7.0.1
 */