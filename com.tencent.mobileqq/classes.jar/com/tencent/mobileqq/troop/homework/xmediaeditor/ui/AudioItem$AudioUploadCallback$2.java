package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import ayzz;
import azar;
import azau;
import azav;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  public AudioItem$AudioUploadCallback$2(azau paramazau) {}
  
  public void run()
  {
    azav localazav = (azav)this.a.jdField_a_of_type_Azar.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Ayzz.c);
    if (localazav != null)
    {
      if (!this.a.jdField_a_of_type_Ayzz.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)azar.a(this.a.jdField_a_of_type_Azar).getResources().getDrawable(2130772248);
      localazav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localazav.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localazav.c.setVisibility(0);
      return;
      label103:
      localazav.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */