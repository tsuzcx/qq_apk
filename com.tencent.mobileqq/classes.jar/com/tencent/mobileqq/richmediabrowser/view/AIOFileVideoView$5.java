package com.tencent.mobileqq.richmediabrowser.view;

import aiqi;
import aiqo;
import android.widget.SeekBar;
import android.widget.TextView;
import axyt;
import axzv;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import mqq.os.MqqHandler;

public class AIOFileVideoView$5
  implements Runnable
{
  public AIOFileVideoView$5(axzv paramaxzv) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Axyt.getSelectedItem();
    int i;
    long l1;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 103))
    {
      localObject = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
      i = ((AIOFileVideoData)localObject).status;
      l1 = ((AIOFileVideoData)localObject).c;
      if ((this.this$0.jdField_a_of_type_Aiqi != null) && (this.this$0.jdField_a_of_type_Aiqi.c())) {}
    }
    else
    {
      return;
    }
    long l2;
    if (i == 3)
    {
      l2 = this.this$0.jdField_a_of_type_Aiqi.c();
      if (l2 > 0L)
      {
        localObject = ShortVideoUtils.a(this.this$0.mContext, l2 * 1024L);
        this.this$0.c.setText((String)localObject + "/s");
        this.this$0.c.setVisibility(0);
        if ((this.this$0.jdField_a_of_type_Aiqi == null) || (this.this$0.jdField_a_of_type_Aiqi.a == null) || (!this.this$0.jdField_a_of_type_Aiqi.a.a)) {
          break label340;
        }
      }
    }
    label340:
    for (float f = (int)((float)this.this$0.jdField_a_of_type_Aiqi.d() / (float)l1 * 10000.0F);; f = 10000.0F)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress((int)f);
      this.this$0.jdField_a_of_type_Axyt.a.postDelayed(this.this$0.b, 100L);
      return;
      this.this$0.c.setVisibility(8);
      break;
      l2 = this.this$0.jdField_a_of_type_Aiqi.a();
      i = (int)(l2 / this.this$0.jdField_a_of_type_Aiqi.b() * 10000.0D);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l2));
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.5
 * JD-Core Version:    0.7.0.1
 */