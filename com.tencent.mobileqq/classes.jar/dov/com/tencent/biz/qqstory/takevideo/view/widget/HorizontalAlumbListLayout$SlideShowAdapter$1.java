package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bdaq;
import bneo;
import bnep;
import yvb;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bneo parambneo, bnep parambnep) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bnep.a.getWidth();
    int j = this.jdField_a_of_type_Bnep.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bneo.a(this.jdField_a_of_type_Bneo) == null)
    {
      int k = bdaq.a(bneo.a(this.jdField_a_of_type_Bneo), 1.0F);
      new Paint().setTextSize(bdaq.a(bneo.a(this.jdField_a_of_type_Bneo), 11.0F));
      int m = bdaq.a(bneo.a(this.jdField_a_of_type_Bneo), 2.0F);
      bneo.a(this.jdField_a_of_type_Bneo, yvb.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bnep.a.setBackgroundDrawable(new BitmapDrawable(bneo.a(this.jdField_a_of_type_Bneo).getResources(), bneo.a(this.jdField_a_of_type_Bneo)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */