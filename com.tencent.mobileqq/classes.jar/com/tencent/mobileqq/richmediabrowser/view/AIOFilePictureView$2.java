package com.tencent.mobileqq.richmediabrowser.view;

import android.net.Uri;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.io.File;
import java.util.ArrayList;

class AIOFilePictureView$2
  implements Runnable
{
  AIOFilePictureView$2(AIOFilePictureView paramAIOFilePictureView, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file://");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        localObject = Uri.parse(((StringBuilder)localObject).toString());
        AIOFilePictureView.a(this.this$0, (Uri)localObject, this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
    }
    catch (Exception localException)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add qr action sheet error: ");
      localStringBuilder.append(localException.getMessage());
      localIBrowserLog.d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.2
 * JD-Core Version:    0.7.0.1
 */