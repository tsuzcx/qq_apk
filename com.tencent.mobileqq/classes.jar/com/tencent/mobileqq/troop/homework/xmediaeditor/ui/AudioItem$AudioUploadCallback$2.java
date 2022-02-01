package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import benn;
import beof;
import beoi;
import beoj;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  public AudioItem$AudioUploadCallback$2(beoi parambeoi) {}
  
  public void run()
  {
    beoj localbeoj = (beoj)this.a.jdField_a_of_type_Beof.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Benn.c);
    if (localbeoj != null)
    {
      if (!this.a.jdField_a_of_type_Benn.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)beof.a(this.a.jdField_a_of_type_Beof).getResources().getDrawable(2130772271);
      localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localbeoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localbeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localbeoj.c.setVisibility(0);
      return;
      label103:
      localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */