package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bawz;
import bkob;
import bkoc;
import xbw;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bkob parambkob, bkoc parambkoc) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bkoc.a.getWidth();
    int j = this.jdField_a_of_type_Bkoc.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bkob.a(this.jdField_a_of_type_Bkob) == null)
    {
      int k = bawz.a(bkob.a(this.jdField_a_of_type_Bkob), 1.0F);
      new Paint().setTextSize(bawz.a(bkob.a(this.jdField_a_of_type_Bkob), 11.0F));
      int m = bawz.a(bkob.a(this.jdField_a_of_type_Bkob), 2.0F);
      bkob.a(this.jdField_a_of_type_Bkob, xbw.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bkoc.a.setBackgroundDrawable(new BitmapDrawable(bkob.a(this.jdField_a_of_type_Bkob).getResources(), bkob.a(this.jdField_a_of_type_Bkob)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */