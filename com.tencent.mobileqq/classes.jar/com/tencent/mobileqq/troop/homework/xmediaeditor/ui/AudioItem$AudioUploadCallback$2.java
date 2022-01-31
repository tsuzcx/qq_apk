package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import babf;
import babx;
import baca;
import bacb;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  public AudioItem$AudioUploadCallback$2(baca parambaca) {}
  
  public void run()
  {
    bacb localbacb = (bacb)this.a.jdField_a_of_type_Babx.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Babf.c);
    if (localbacb != null)
    {
      if (!this.a.jdField_a_of_type_Babf.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)babx.a(this.a.jdField_a_of_type_Babx).getResources().getDrawable(2130772249);
      localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localbacb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localbacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localbacb.c.setVisibility(0);
      return;
      label103:
      localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */