package com.tencent.qqmini.miniapp.widget.camera;

import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppCamera$7$1
  implements ChannelProxy.ICommandListenr
{
  MiniAppCamera$7$1(MiniAppCamera.7 param7) {}
  
  public void onFailure(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compress failed ");
    localStringBuilder.append(paramString);
    QMLog.i("MiniAppCamera", localStringBuilder.toString());
    MiniAppCamera.access$700(this.this$1.this$0, this.this$1.val$srcPath, this.this$1.val$req);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compress finish ");
    localStringBuilder.append(paramBoolean);
    QMLog.i("MiniAppCamera", localStringBuilder.toString());
    MiniAppCamera.access$600(this.this$1.this$0);
  }
  
  public void onProgress(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compress progress ");
    localStringBuilder.append(paramString);
    QMLog.i("MiniAppCamera", localStringBuilder.toString());
  }
  
  public void onStart()
  {
    QMLog.i("MiniAppCamera", "compress start");
  }
  
  public void onSuccess(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compress success ");
    localStringBuilder.append(paramString);
    QMLog.i("MiniAppCamera", localStringBuilder.toString());
    MiniAppCamera.access$700(this.this$1.this$0, this.this$1.val$outPath, this.this$1.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.7.1
 * JD-Core Version:    0.7.0.1
 */