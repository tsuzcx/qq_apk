package com.tencent.qqmini.miniapp.widget.camera;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.util.Log;

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
    }
    catch (Exception localException)
    {
      Log.i("MiniAppCamera", "onPictureTaken: ", localException);
    }
    paramCamera.startPreview();
    MiniAppCamera.access$000(this.this$0, paramArrayOfByte, this.val$adapt, this.val$quality, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.2
 * JD-Core Version:    0.7.0.1
 */