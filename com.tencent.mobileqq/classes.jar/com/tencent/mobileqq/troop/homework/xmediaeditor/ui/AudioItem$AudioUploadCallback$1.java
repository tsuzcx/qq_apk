package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import baar;
import babj;
import babm;
import babn;
import babp;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(babm parambabm) {}
  
  public void run()
  {
    babn localbabn;
    if (this.a.jdField_a_of_type_Baar.c < this.a.jdField_a_of_type_Babj.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Babj.jdField_a_of_type_Babp.a(this.a.jdField_a_of_type_Babj.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Baar.c), true);
      localbabn = (babn)this.a.jdField_a_of_type_Babj.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Baar.c);
      if (localbabn != null)
      {
        if (!this.a.jdField_a_of_type_Baar.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)babj.a(this.a.jdField_a_of_type_Babj).getResources().getDrawable(2130772249);
        localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localbabn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbabn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbabn.c.setVisibility(4);
      return;
      label171:
      localbabn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846121);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */