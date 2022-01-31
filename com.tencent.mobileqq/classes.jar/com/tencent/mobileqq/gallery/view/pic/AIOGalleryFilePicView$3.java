package com.tencent.mobileqq.gallery.view.pic;

import android.net.Uri;
import aqmb;
import aqme;
import aqor;
import java.io.File;
import java.util.ArrayList;

public class AIOGalleryFilePicView$3
  implements Runnable
{
  public AIOGalleryFilePicView$3(aqor paramaqor, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile != null)
      {
        Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        aqor.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      aqmb.a().a().a("AIOGalleryFilePicView", 4, "add qr action sheet error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.pic.AIOGalleryFilePicView.3
 * JD-Core Version:    0.7.0.1
 */