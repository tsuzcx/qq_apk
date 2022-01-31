package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import ayzz;
import azar;
import azau;
import azav;
import azax;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(azau paramazau) {}
  
  public void run()
  {
    azav localazav;
    if (this.a.jdField_a_of_type_Ayzz.c < this.a.jdField_a_of_type_Azar.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Azar.jdField_a_of_type_Azax.a(this.a.jdField_a_of_type_Azar.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Ayzz.c), true);
      localazav = (azav)this.a.jdField_a_of_type_Azar.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Ayzz.c);
      if (localazav != null)
      {
        if (!this.a.jdField_a_of_type_Ayzz.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)azar.a(this.a.jdField_a_of_type_Azar).getResources().getDrawable(2130772248);
        localazav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localazav.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localazav.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localazav.c.setVisibility(4);
      return;
      label171:
      localazav.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */