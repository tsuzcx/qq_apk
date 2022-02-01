package com.tencent.mobileqq.mini.widget.media;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import android.util.Log;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.qphone.base.util.QLog;

class MiniAppCamera$4
  implements MediaRecorder.OnInfoListener
{
  MiniAppCamera$4(MiniAppCamera paramMiniAppCamera, WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    Log.i("MiniAppCamera", "onInfo: " + paramInt1);
    QLog.i("MiniAppCamera", 2, "setOnInfoListener|reson: " + paramInt1);
    if (paramInt1 == 800) {
      this.this$0.stopRecord(this.val$wc, this.val$event, MiniAppCamera.access$100());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.4
 * JD-Core Version:    0.7.0.1
 */