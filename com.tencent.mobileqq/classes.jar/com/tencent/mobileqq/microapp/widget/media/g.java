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
    paramMediaRecorder = new StringBuilder();
    paramMediaRecorder.append("setOnInfoListener|reson: ");
    paramMediaRecorder.append(paramInt1);
    QLog.i("MiniAppCamera", 2, paramMediaRecorder.toString());
    if (paramInt1 == 800) {
      this.d.b(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.g
 * JD-Core Version:    0.7.0.1
 */