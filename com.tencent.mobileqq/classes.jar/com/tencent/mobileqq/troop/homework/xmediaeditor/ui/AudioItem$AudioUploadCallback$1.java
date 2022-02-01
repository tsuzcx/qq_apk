package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import benn;
import beof;
import beoi;
import beoj;
import beol;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(beoi parambeoi) {}
  
  public void run()
  {
    beoj localbeoj;
    if (this.a.jdField_a_of_type_Benn.c < this.a.jdField_a_of_type_Beof.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Beof.jdField_a_of_type_Beol.a(this.a.jdField_a_of_type_Beof.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Benn.c), true);
      localbeoj = (beoj)this.a.jdField_a_of_type_Beof.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Benn.c);
      if (localbeoj != null)
      {
        if (!this.a.jdField_a_of_type_Benn.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)beof.a(this.a.jdField_a_of_type_Beof).getResources().getDrawable(2130772271);
        localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localbeoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbeoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbeoj.c.setVisibility(4);
      return;
      label171:
      localbeoj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */