package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import bbzo;
import bcag;
import bcaj;
import bcak;
import bcam;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(bcaj parambcaj) {}
  
  public void run()
  {
    bcak localbcak;
    if (this.a.jdField_a_of_type_Bbzo.c < this.a.jdField_a_of_type_Bcag.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Bcag.jdField_a_of_type_Bcam.a(this.a.jdField_a_of_type_Bcag.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bbzo.c), true);
      localbcak = (bcak)this.a.jdField_a_of_type_Bcag.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bbzo.c);
      if (localbcak != null)
      {
        if (!this.a.jdField_a_of_type_Bbzo.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)bcag.a(this.a.jdField_a_of_type_Bcag).getResources().getDrawable(2130772263);
        localbcak.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localbcak.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbcak.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbcak.c.setVisibility(4);
      return;
      label171:
      localbcak.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */