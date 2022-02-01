package com.tencent.mobileqq.richmediabrowser.view;

import android.net.Uri;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import java.io.File;
import java.util.ArrayList;

class AIOPictureView$3
  implements Runnable
{
  AIOPictureView$3(AIOPictureView paramAIOPictureView, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ZhuoXusManager.a().b()) {}
    while ((this.this$0.b == null) || (!this.this$0.b.equals(this.jdField_a_of_type_JavaIoFile.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    AIOPictureView.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.3
 * JD-Core Version:    0.7.0.1
 */