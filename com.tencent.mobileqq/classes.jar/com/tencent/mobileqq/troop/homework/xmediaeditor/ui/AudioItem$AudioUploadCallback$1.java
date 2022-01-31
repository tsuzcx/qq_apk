package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import babf;
import babx;
import baca;
import bacb;
import bacd;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(baca parambaca) {}
  
  public void run()
  {
    bacb localbacb;
    if (this.a.jdField_a_of_type_Babf.c < this.a.jdField_a_of_type_Babx.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Babx.jdField_a_of_type_Bacd.a(this.a.jdField_a_of_type_Babx.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Babf.c), true);
      localbacb = (bacb)this.a.jdField_a_of_type_Babx.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Babf.c);
      if (localbacb != null)
      {
        if (!this.a.jdField_a_of_type_Babf.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)babx.a(this.a.jdField_a_of_type_Babx).getResources().getDrawable(2130772249);
        localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localbacb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbacb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbacb.c.setVisibility(4);
      return;
      label171:
      localbacb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */