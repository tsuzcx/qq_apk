package com.tencent.tkd.topicsdk.ucrop.handler;

import com.tencent.tkd.topicsdk.ucrop.callback.BitmapCropCallback;

class CropHandler$2
  implements Runnable
{
  CropHandler$2(CropHandler paramCropHandler, boolean paramBoolean, BitmapCropCallback paramBitmapCropCallback, String paramString) {}
  
  public void run()
  {
    if (this.a)
    {
      this.b.a(this.c);
      return;
    }
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.CropHandler.2
 * JD-Core Version:    0.7.0.1
 */