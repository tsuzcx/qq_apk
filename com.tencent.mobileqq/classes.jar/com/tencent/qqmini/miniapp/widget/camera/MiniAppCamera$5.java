package com.tencent.qqmini.miniapp.widget.camera;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppCamera$5
  implements MediaRecorder.OnInfoListener
{
  MiniAppCamera$5(MiniAppCamera paramMiniAppCamera, RequestEvent paramRequestEvent) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    paramMediaRecorder = new StringBuilder();
    paramMediaRecorder.append("onInfo: ");
    paramMediaRecorder.append(paramInt1);
    Log.i("MiniAppCamera", paramMediaRecorder.toString());
    paramMediaRecorder = new StringBuilder();
    paramMediaRecorder.append("setOnInfoListener|reson: ");
    paramMediaRecorder.append(paramInt1);
    QMLog.i("MiniAppCamera", paramMediaRecorder.toString());
    if (paramInt1 == 800) {
      this.this$0.stopRecord(this.val$req);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.5
 * JD-Core Version:    0.7.0.1
 */