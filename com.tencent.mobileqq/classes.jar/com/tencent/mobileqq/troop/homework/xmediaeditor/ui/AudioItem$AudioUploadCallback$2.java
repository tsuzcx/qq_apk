package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import bfel;
import bffd;
import bffg;
import bffh;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  public AudioItem$AudioUploadCallback$2(bffg parambffg) {}
  
  public void run()
  {
    bffh localbffh = (bffh)this.a.jdField_a_of_type_Bffd.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bfel.c);
    if (localbffh != null)
    {
      if (!this.a.jdField_a_of_type_Bfel.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)bffd.a(this.a.jdField_a_of_type_Bffd).getResources().getDrawable(2130772273);
      localbffh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localbffh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localbffh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localbffh.c.setVisibility(0);
      return;
      label103:
      localbffh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */