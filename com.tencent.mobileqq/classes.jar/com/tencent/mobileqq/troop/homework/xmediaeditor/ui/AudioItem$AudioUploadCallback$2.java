package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import bfuq;
import bfvi;
import bfvl;
import bfvm;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  public AudioItem$AudioUploadCallback$2(bfvl parambfvl) {}
  
  public void run()
  {
    bfvm localbfvm = (bfvm)this.a.jdField_a_of_type_Bfvi.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bfuq.c);
    if (localbfvm != null)
    {
      if (!this.a.jdField_a_of_type_Bfuq.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)bfvi.a(this.a.jdField_a_of_type_Bfvi).getResources().getDrawable(2130772270);
      localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localbfvm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localbfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localbfvm.c.setVisibility(0);
      return;
      label103:
      localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */