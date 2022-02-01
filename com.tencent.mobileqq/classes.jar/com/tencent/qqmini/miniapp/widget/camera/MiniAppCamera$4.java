package com.tencent.qqmini.miniapp.widget.camera;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class MiniAppCamera$4
  implements MediaRecorder.OnErrorListener
{
  MiniAppCamera$4(MiniAppCamera paramMiniAppCamera, RequestEvent paramRequestEvent) {}
  
  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    Log.i("MiniAppCamera", "onError: " + paramInt1);
    this.val$req.fail();
    MiniAppCamera.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.4
 * JD-Core Version:    0.7.0.1
 */