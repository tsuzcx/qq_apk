package com.tencent.mobileqq.gallery.view.video;

import agqv;
import agra;
import android.widget.SeekBar;
import android.widget.TextView;
import aqmi;
import aqnm;
import aqpp;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class AIOGalleryFileVideoView$4
  implements Runnable
{
  public AIOGalleryFileVideoView$4(aqpp paramaqpp) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Aqnm.a();
    int i;
    long l1;
    if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 4))
    {
      localObject = (AIOFileVideoData)((aqmi)localObject).a;
      i = ((AIOFileVideoData)localObject).e;
      l1 = ((AIOFileVideoData)localObject).c;
      if ((this.this$0.jdField_a_of_type_Agqv != null) && (this.this$0.jdField_a_of_type_Agqv.c())) {}
    }
    else
    {
      return;
    }
    long l2;
    if (i == 3)
    {
      l2 = this.this$0.jdField_a_of_type_Agqv.c();
      if (l2 > 0L)
      {
        localObject = ShortVideoUtils.a(this.this$0.jdField_a_of_type_AndroidAppActivity, l2 * 1024L);
        this.this$0.c.setText((String)localObject + "/s");
        this.this$0.c.setVisibility(0);
        if ((this.this$0.jdField_a_of_type_Agqv == null) || (this.this$0.jdField_a_of_type_Agqv.a == null) || (!this.this$0.jdField_a_of_type_Agqv.a.a)) {
          break label339;
        }
      }
    }
    label339:
    for (float f = (int)((float)this.this$0.jdField_a_of_type_Agqv.d() / (float)l1 * 10000.0F);; f = 10000.0F)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress((int)f);
      this.this$0.jdField_a_of_type_Aqnm.a.postDelayed(this.this$0.b, 100L);
      return;
      this.this$0.c.setVisibility(8);
      break;
      l2 = this.this$0.jdField_a_of_type_Agqv.a();
      i = (int)(l2 / this.this$0.jdField_a_of_type_Agqv.b() * 10000.0D);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l2));
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.video.AIOGalleryFileVideoView.4
 * JD-Core Version:    0.7.0.1
 */