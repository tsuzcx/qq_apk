package com.tencent.mobileqq.gallery.view.pic;

import android.net.Uri;
import apux;
import aqcb;
import java.io.File;
import java.util.ArrayList;

public class AIOGalleryPicView$2
  implements Runnable
{
  public AIOGalleryPicView$2(apux paramapux, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (aqcb.a().b()) {}
    while ((this.this$0.b == null) || (!this.this$0.b.equals(this.jdField_a_of_type_JavaIoFile.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    apux.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.pic.AIOGalleryPicView.2
 * JD-Core Version:    0.7.0.1
 */