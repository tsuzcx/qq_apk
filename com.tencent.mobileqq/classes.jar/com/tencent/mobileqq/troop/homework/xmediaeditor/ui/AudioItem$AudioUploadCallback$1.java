package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import bgef;
import bgex;
import bgfa;
import bgfb;
import bgfd;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(bgfa parambgfa) {}
  
  public void run()
  {
    bgfb localbgfb;
    if (this.a.jdField_a_of_type_Bgef.c < this.a.jdField_a_of_type_Bgex.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_Bgex.jdField_a_of_type_Bgfd.a(this.a.jdField_a_of_type_Bgex.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bgef.c), true);
      localbgfb = (bgfb)this.a.jdField_a_of_type_Bgex.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bgef.c);
      if (localbgfb != null)
      {
        if (!this.a.jdField_a_of_type_Bgef.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)bgex.a(this.a.jdField_a_of_type_Bgex).getResources().getDrawable(2130772273);
        localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localbgfb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbgfb.c.setVisibility(4);
      return;
      label171:
      localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */