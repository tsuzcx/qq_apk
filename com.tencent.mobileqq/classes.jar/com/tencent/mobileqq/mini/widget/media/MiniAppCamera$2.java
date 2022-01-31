package com.tencent.mobileqq.mini.widget.media;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;

class MiniAppCamera$2
  implements Camera.PictureCallback
{
  MiniAppCamera$2(MiniAppCamera paramMiniAppCamera, boolean paramBoolean, String paramString, MiniAppCamera.GetPhotoCallback paramGetPhotoCallback) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Log.i("MiniAppCamera", "onPictureTaken: ");
    try
    {
      paramCamera.reconnect();
      paramCamera.startPreview();
      ThreadManagerV2.excute(new MiniAppCamera.2.1(this, paramArrayOfByte), 64, null, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MiniAppCamera", "onPictureTaken: ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.2
 * JD-Core Version:    0.7.0.1
 */