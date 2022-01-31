package com.tencent.mobileqq.gallery.view.video;

import agez;
import agfe;
import android.widget.SeekBar;
import android.widget.TextView;
import apsr;
import aptm;
import apvq;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class AIOGalleryVideoView$3
  implements Runnable
{
  public AIOGalleryVideoView$3(apvq paramapvq) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Aptm.a();
    int i;
    long l1;
    if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 2))
    {
      localObject = (AIOShortVideoData)((apsr)localObject).a;
      i = ((AIOShortVideoData)localObject).l;
      l1 = ((AIOShortVideoData)localObject).c;
      if ((this.this$0.jdField_a_of_type_Agez != null) && (this.this$0.jdField_a_of_type_Agez.c())) {}
    }
    else
    {
      return;
    }
    long l2;
    if (i == 3)
    {
      l2 = this.this$0.jdField_a_of_type_Agez.c();
      if (l2 > 0L)
      {
        localObject = ShortVideoUtils.a(this.this$0.jdField_a_of_type_AndroidAppActivity, l2 * 1024L);
        this.this$0.c.setText((String)localObject + "/s");
        this.this$0.c.setVisibility(0);
        if ((this.this$0.jdField_a_of_type_Agez == null) || (this.this$0.jdField_a_of_type_Agez.a == null) || (!this.this$0.jdField_a_of_type_Agez.a.a)) {
          break label339;
        }
      }
    }
    label339:
    for (float f = (int)((float)this.this$0.jdField_a_of_type_Agez.d() / (float)l1 * 10000.0F);; f = 10000.0F)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress((int)f);
      this.this$0.jdField_a_of_type_Aptm.a.postDelayed(this.this$0.b, 100L);
      return;
      this.this$0.c.setVisibility(8);
      break;
      l2 = this.this$0.jdField_a_of_type_Agez.a();
      i = (int)(l2 / this.this$0.jdField_a_of_type_Agez.b() * 10000.0D);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l2));
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.video.AIOGalleryVideoView.3
 * JD-Core Version:    0.7.0.1
 */