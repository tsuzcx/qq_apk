package com.tencent.mobileqq.microapp.widget.media;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;

final class d
  implements Camera.PictureCallback
{
  d(MiniAppCamera paramMiniAppCamera, String paramString1, String paramString2, WebviewContainer paramWebviewContainer, int paramInt) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    CameraSurfaceView.a.startPreview();
    ThreadManagerV2.excute(new e(this, paramArrayOfByte), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.d
 * JD-Core Version:    0.7.0.1
 */