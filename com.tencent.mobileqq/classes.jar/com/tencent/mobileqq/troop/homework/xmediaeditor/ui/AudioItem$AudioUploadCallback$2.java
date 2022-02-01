package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import bgef;
import bgex;
import bgfa;
import bgfb;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  public AudioItem$AudioUploadCallback$2(bgfa parambgfa) {}
  
  public void run()
  {
    bgfb localbgfb = (bgfb)this.a.jdField_a_of_type_Bgex.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_Bgef.c);
    if (localbgfb != null)
    {
      if (!this.a.jdField_a_of_type_Bgef.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)bgex.a(this.a.jdField_a_of_type_Bgex).getResources().getDrawable(2130772273);
      localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localbgfb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localbgfb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localbgfb.c.setVisibility(0);
      return;
      label103:
      localbgfb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */