package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import bfuq;
import bfvi;
import bfvl;
import bfvm;
import bfvo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(bfvl parambfvl) {}
  
  public void run()
  {
    bfvm localbfvm;
    if (this.a.jdField_a_of_type_Bfuq.c < this.a.jdField_a_of_type_Bfvi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Bfvi.jdField_a_of_type_Bfvo.a(this.a.jdField_a_of_type_Bfvi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bfuq.c), true);
      localbfvm = (bfvm)this.a.jdField_a_of_type_Bfvi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bfuq.c);
      if (localbfvm != null)
      {
        if (!this.a.jdField_a_of_type_Bfuq.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)bfvi.a(this.a.jdField_a_of_type_Bfvi).getResources().getDrawable(2130772270);
        localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localbfvm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbfvm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbfvm.c.setVisibility(4);
      return;
      label171:
      localbfvm.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */