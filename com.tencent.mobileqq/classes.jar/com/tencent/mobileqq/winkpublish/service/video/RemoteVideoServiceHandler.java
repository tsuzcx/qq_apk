package com.tencent.mobileqq.winkpublish.service.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue;
import com.tencent.mobileqq.winkpublish.task.compress.VideoCompressEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoteVideoServiceHandler
{
  private static final String e;
  private static RemoteVideoServiceHandler i;
  protected Object a = new Object();
  protected ConcurrentLinkedQueue<Message> b = new ConcurrentLinkedQueue();
  protected volatile long c = -1L;
  protected ServiceConnection d = new RemoteVideoServiceHandler.2(this);
  private HashSet<String> f = new HashSet();
  private int g = 0;
  private String h;
  private Handler j = new RemoteVideoServiceHandler.1(this, QCircleHostQzoneThreadHelper.getBackGroundLooper());
  private Messenger k = null;
  private Messenger l = new Messenger(this.j);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("RemoteVideoServiceHandler");
    e = localStringBuilder.toString();
  }
  
  public static RemoteVideoServiceHandler a()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new RemoteVideoServiceHandler();
        }
      }
      finally {}
    }
    return i;
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("RemoteVideoServiceHandler sendFailedRespToTask clientkey:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(",msg:");
    ((StringBuilder)localObject2).append(paramString2);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("video_handle_result", false);
    ((Intent)localObject1).putExtra("video_error_msg", paramString2);
    ((Intent)localObject1).putExtra("video_error_code", paramInt);
    ((Intent)localObject1).putExtra("video_error_file_name", this.h);
    paramString2 = AUploadTaskQueue.a().b(paramString1);
    localObject2 = VideoCompressEngine.a().a(paramString1);
    if (paramString2 != null) {
      return;
    }
    if (localObject2 != null) {
      VideoCompressEngine.a().a(paramString1, (Intent)localObject1);
    }
  }
  
  protected void a(Message paramMessage)
  {
    this.k.send(paramMessage);
  }
  
  public void a(String paramString)
  {
    String str = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RemoteVideoServiceHandler attach clientKey=");
    localStringBuilder.append(paramString);
    QLog.i(str, 1, localStringBuilder.toString());
    try
    {
      if (this.f.add(paramString)) {
        this.g += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void b(Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:a	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 181	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:b	()Z
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 183	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:a	(Landroid/os/Message;)V
    //   19: goto +12 -> 31
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 185	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:c	(Landroid/os/Message;)V
    //   27: aload_0
    //   28: invokevirtual 187	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:d	()V
    //   31: aload_2
    //   32: monitorexit
    //   33: return
    //   34: astore_3
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 86	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:k	Landroid/os/Messenger;
    //   44: ifnonnull +9 -> 53
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 185	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:c	(Landroid/os/Message;)V
    //   52: return
    //   53: aload_2
    //   54: invokevirtual 190	java/lang/Exception:printStackTrace	()V
    //   57: return
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 185	com/tencent/mobileqq/winkpublish/service/video/RemoteVideoServiceHandler:c	(Landroid/os/Message;)V
    //   63: return
    //   64: astore_2
    //   65: goto -7 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	RemoteVideoServiceHandler
    //   0	68	1	paramMessage	Message
    //   39	15	2	localException	Exception
    //   64	1	2	localDeadObjectException	android.os.DeadObjectException
    //   34	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	34	finally
    //   22	31	34	finally
    //   31	33	34	finally
    //   35	37	34	finally
    //   0	7	39	java/lang/Exception
    //   37	39	39	java/lang/Exception
    //   0	7	64	android/os/DeadObjectException
    //   37	39	64	android/os/DeadObjectException
  }
  
  public void b(String paramString)
  {
    String str = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RemoteVideoServiceHandler detach clientKey=");
    localStringBuilder.append(paramString);
    QLog.i(str, 1, localStringBuilder.toString());
    try
    {
      boolean bool = this.f.remove(paramString);
      int n = 0;
      int m = n;
      if (bool)
      {
        int i1 = this.g - 1;
        this.g = i1;
        m = n;
        if (i1 == 0) {
          m = 1;
        }
      }
      if (m != 0) {
        f();
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.k != null;
  }
  
  protected void c()
  {
    QCircleHostQzoneThreadHelper.postRealTimeThread(new RemoteVideoServiceHandler.3(this));
  }
  
  protected void c(Message paramMessage)
  {
    this.b.add(paramMessage);
  }
  
  public void d()
  {
    long l1 = System.currentTimeMillis();
    if ((this.c != -1L) && (l1 - this.c <= 1000L))
    {
      QLog.i(e, 1, "RemoteVideoServiceHandler wait start service result, skiped...");
      return;
    }
    this.c = l1;
    e();
  }
  
  void e()
  {
    try
    {
      Intent localIntent = new Intent(RFApplication.getApplication(), PublishVideoPluginService.class);
      RFApplication.getApplication().bindService(localIntent, this.d, 1);
      QLog.i(e, 1, "RemoteVideoServiceHandler bind service finish");
      return;
    }
    catch (Exception localException)
    {
      QLog.e(e, 1, "RemoteVideoServiceHandler bind service error", localException);
    }
  }
  
  public void f()
  {
    try
    {
      RFApplication.getApplication().unbindService(this.d);
      this.k = null;
      QLog.i(e, 1, "RemoteVideoServiceHandler unbindService service finished");
      return;
    }
    catch (Exception localException)
    {
      QLog.e(e, 1, "RemoteVideoServiceHandler unbindService service error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.RemoteVideoServiceHandler
 * JD-Core Version:    0.7.0.1
 */