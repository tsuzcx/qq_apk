package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import baar;
import babj;
import babm;
import babn;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  public AudioItem$AudioUploadCallback$2(babm parambabm) {}
  
  public void run()
  {
    babn localbabn = (babn)this.a.jdField_a_of_type_Babj.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Baar.c);
    if (localbabn != null)
    {
      if (!this.a.jdField_a_of_type_Baar.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)babj.a(this.a.jdField_a_of_type_Babj).getResources().getDrawable(2130772249);
      localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localbabn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localbabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localbabn.c.setVisibility(0);
      return;
      label103:
      localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846121);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */