package com.tencent.mobileqq.microapp.widget.media;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.qphone.base.util.QLog;

final class g
  implements MediaRecorder.OnInfoListener
{
  g(MiniAppCamera paramMiniAppCamera, WebviewContainer paramWebviewContainer, String paramString, int paramInt) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    QLog.i("MiniAppCamera", 2, "setOnInfoListener|reson: " + paramInt1);
    if (paramInt1 == 800) {
      this.d.b(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.g
 * JD-Core Version:    0.7.0.1
 */