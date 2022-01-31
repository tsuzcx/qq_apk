package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import bcdx;
import bcep;
import bces;
import bcet;
import bcev;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(bces parambces) {}
  
  public void run()
  {
    bcet localbcet;
    if (this.a.jdField_a_of_type_Bcdx.c < this.a.jdField_a_of_type_Bcep.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Bcep.jdField_a_of_type_Bcev.a(this.a.jdField_a_of_type_Bcep.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bcdx.c), true);
      localbcet = (bcet)this.a.jdField_a_of_type_Bcep.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bcdx.c);
      if (localbcet != null)
      {
        if (!this.a.jdField_a_of_type_Bcdx.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)bcep.a(this.a.jdField_a_of_type_Bcep).getResources().getDrawable(2130772264);
        localbcet.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localbcet.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbcet.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbcet.c.setVisibility(4);
      return;
      label171:
      localbcet.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846579);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */