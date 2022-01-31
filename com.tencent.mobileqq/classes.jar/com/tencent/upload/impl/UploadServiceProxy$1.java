package com.tencent.upload.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.UploadLog;

class UploadServiceProxy$1
  extends Handler
{
  UploadServiceProxy$1(UploadServiceProxy paramUploadServiceProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = null;
    if ((paramMessage.obj instanceof AbstractUploadTask)) {
      localObject = (AbstractUploadTask)paramMessage.obj;
    }
    if (UploadServiceProxy.access$000(this.this$0) == null)
    {
      UploadLog.v("UploadServiceProxy", "handleMessage mServiceImpl == null !");
      UploadServiceProxy.access$002(this.this$0, UploadServiceImpl.getInstance());
    }
    switch (paramMessage.what)
    {
    default: 
    case 2: 
      do
      {
        return;
      } while (localObject == null);
      UploadLog.v("UploadServiceProxy", "receive MSG_UI_UPLOAD_TASK type: " + localObject.getClass().getSimpleName() + " flowId:" + ((AbstractUploadTask)localObject).flowId);
      UploadServiceProxy.access$000(this.this$0).upload((AbstractUploadTask)localObject);
      return;
    case 3: 
      UploadLog.v("UploadServiceProxy", "receive MSG_UI_CANCEL_TASK");
      UploadServiceProxy.access$000(this.this$0).cancel((AbstractUploadTask)localObject);
      return;
    case 4: 
      UploadLog.v("UploadServiceProxy", "receive MSG_UI_COMMIT_TASK");
      UploadServiceProxy.access$000(this.this$0).commit((AbstractUploadTask)localObject);
      return;
    case 6: 
      UploadLog.d("UploadServiceProxy", "receive MSG_UI_SET_BACKGROUND_MODE=" + paramMessage.arg1);
      localObject = UploadServiceProxy.access$000(this.this$0);
      if (paramMessage.arg1 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((UploadServiceImpl)localObject).setBackgroundMode(bool);
        UploadGlobalConfig.getUploadReport().batchComplete();
        return;
      }
    case 7: 
      paramMessage = (DebugServerRoute)paramMessage.obj;
      UploadLog.d("UploadServiceProxy", "receive MSG_UI_SET_TEST_SERVER=" + paramMessage);
      UploadServiceProxy.access$000(this.this$0).setDebugServerRoute(paramMessage);
      return;
    case 8: 
      UploadLog.v("UploadServiceProxy", "receive MSG_INNER_TIMEOUT_CLOSE");
      UploadServiceProxy.access$000(this.this$0).doClose();
      return;
    case 5: 
      UploadLog.v("UploadServiceProxy", "receive MSG_UI_PAUSE_ALL_TASK");
      UploadServiceProxy.access$000(this.this$0).pauseAllTask();
      return;
    }
    UploadLog.d("UploadServiceProxy", "receive MSG_UI_PREPARE");
    paramMessage = (TaskTypeConfig)paramMessage.obj;
    UploadServiceProxy.access$000(this.this$0).prepare(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.impl.UploadServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */