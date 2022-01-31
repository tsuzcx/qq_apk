package com.tencent.mobileqq.richmediabrowser.view;

import android.net.Uri;
import asmt;
import axvr;
import java.io.File;
import java.util.ArrayList;

public class AIOPictureView$3
  implements Runnable
{
  public AIOPictureView$3(axvr paramaxvr, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (asmt.a().b()) {}
    while ((this.this$0.b == null) || (!this.this$0.b.equals(this.jdField_a_of_type_JavaIoFile.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    axvr.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.3
 * JD-Core Version:    0.7.0.1
 */