package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import bjlc;
import com.tencent.mobileqq.widget.SlideDetectListView;

class BindGroupActivity$1
  implements Runnable
{
  BindGroupActivity$1(BindGroupActivity paramBindGroupActivity, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.this$0.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        bjlc localbjlc = (bjlc)this.this$0.a.getChildAt(i).getTag();
        if ((localbjlc != null) && (this.jdField_a_of_type_JavaLangString.equals(localbjlc.jdField_a_of_type_JavaLangString))) {
          localbjlc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.1
 * JD-Core Version:    0.7.0.1
 */