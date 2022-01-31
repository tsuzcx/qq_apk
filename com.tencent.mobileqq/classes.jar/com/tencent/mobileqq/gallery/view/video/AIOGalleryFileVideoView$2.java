package com.tencent.mobileqq.gallery.view.video;

import android.widget.SeekBar;
import android.widget.TextView;
import apsm;
import apsp;
import apsr;
import aptk;
import apvm;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;

public class AIOGalleryFileVideoView$2
  implements Runnable
{
  public AIOGalleryFileVideoView$2(apvm paramapvm, long paramLong, float paramFloat, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.a();
    if ((localObject != null) && (((apsr)localObject).a != null) && (this.jdField_a_of_type_Long == ((apsr)localObject).a.jdField_a_of_type_Long) && (((apsr)localObject).a.a() == 4))
    {
      localObject = (AIOFileVideoData)((apsr)localObject).a;
      ((AIOFileVideoData)localObject).i = true;
      ((AIOFileVideoData)localObject).j = true;
      ((AIOFileVideoData)localObject).e = 1;
      ((AIOFileVideoData)localObject).g = (((float)((AIOFileVideoData)localObject).c * this.jdField_a_of_type_Float));
      this.this$0.d.setText(this.jdField_a_of_type_JavaLangString);
      int i = (int)(10000.0F * this.jdField_a_of_type_Float);
      this.this$0.b.setProgress(i);
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onDownlodProgress progress = " + this.jdField_a_of_type_Float);
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onDownlodProgress pos = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.video.AIOGalleryFileVideoView.2
 * JD-Core Version:    0.7.0.1
 */