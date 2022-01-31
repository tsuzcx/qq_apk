package com.tencent.mobileqq.gallery.view.pic;

import android.net.Uri;
import aqoz;
import aqwf;
import java.io.File;
import java.util.ArrayList;

public class AIOGalleryPicView$3
  implements Runnable
{
  public AIOGalleryPicView$3(aqoz paramaqoz, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (aqwf.a().b()) {}
    while ((this.this$0.b == null) || (!this.this$0.b.equals(this.jdField_a_of_type_JavaIoFile.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    aqoz.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.pic.AIOGalleryPicView.3
 * JD-Core Version:    0.7.0.1
 */