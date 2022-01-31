package com.tencent.mobileqq.richmediabrowser.view;

import android.net.Uri;
import axvg;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.io.File;
import java.util.ArrayList;

public class AIOFilePictureView$3
  implements Runnable
{
  public AIOFilePictureView$3(axvg paramaxvg, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile != null)
      {
        Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        axvg.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "add qr action sheet error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.3
 * JD-Core Version:    0.7.0.1
 */