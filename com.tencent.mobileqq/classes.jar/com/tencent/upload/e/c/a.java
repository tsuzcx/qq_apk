package com.tencent.upload.e.c;

import com.tencent.upload.d.b;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.uinterface.AbstractUploadTask;

public class a
{
  public static void a(b paramb, com.tencent.upload.network.a.a parama)
  {
    if (((paramb instanceof AbstractUploadTask)) && (parama != null))
    {
      paramb = ((AbstractUploadTask)paramb).getFlowRecoder();
      String str = parama.c();
      parama = parama.b();
      if (str != null) {
        paramb.append("connect ip:").append(str);
      }
      if (parama != null) {
        paramb.append(" route :").append(parama.toString());
      }
      paramb.append("\n");
    }
  }
  
  public static void a(b paramb, String paramString)
  {
    if (((paramb instanceof AbstractUploadTask)) && (paramString != null)) {
      ((AbstractUploadTask)paramb).getFlowRecoder().append(paramString).append("\n");
    }
  }
  
  public static void a(b paramb, Throwable paramThrowable)
  {
    if (((paramb instanceof AbstractUploadTask)) && (paramThrowable != null)) {
      ((AbstractUploadTask)paramb).getFlowRecoder().append("异常").append(paramThrowable.getMessage()).append("\n");
    }
  }
  
  public static void a(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    paramAbstractUploadTask.getFlowRecoder().append("flow id :").append(paramAbstractUploadTask.flowId).append("\n");
  }
  
  public static void b(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    paramAbstractUploadTask.getFlowRecoder().append("任务取消").append("\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.c.a
 * JD-Core Version:    0.7.0.1
 */