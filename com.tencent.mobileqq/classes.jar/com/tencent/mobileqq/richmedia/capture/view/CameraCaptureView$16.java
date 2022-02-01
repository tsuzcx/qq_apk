package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.io.IOException;

class CameraCaptureView$16
  implements Runnable
{
  CameraCaptureView$16(CameraCaptureView paramCameraCaptureView, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.this$0.N.h);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.createFileIfNotExits((String)localObject);
    File localFile = new File((String)localObject);
    try
    {
      ImageUtil.b(this.a, localFile);
      ImageUtil.b(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      this.this$0.a(new CameraCaptureView.PhotoCaptureResult(0, 0, (String)localObject, null, this.this$0.P));
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      CameraCaptureView localCameraCaptureView = this.this$0;
      localCameraCaptureView.a(new CameraCaptureView.PhotoCaptureResult(0, -1, (String)localObject, null, localCameraCaptureView.P));
    }
    this.a.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.16
 * JD-Core Version:    0.7.0.1
 */