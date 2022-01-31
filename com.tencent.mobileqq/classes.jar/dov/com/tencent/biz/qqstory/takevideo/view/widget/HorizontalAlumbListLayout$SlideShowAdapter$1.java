package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import baxn;
import bkos;
import bkot;
import xbt;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bkos parambkos, bkot parambkot) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bkot.a.getWidth();
    int j = this.jdField_a_of_type_Bkot.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bkos.a(this.jdField_a_of_type_Bkos) == null)
    {
      int k = baxn.a(bkos.a(this.jdField_a_of_type_Bkos), 1.0F);
      new Paint().setTextSize(baxn.a(bkos.a(this.jdField_a_of_type_Bkos), 11.0F));
      int m = baxn.a(bkos.a(this.jdField_a_of_type_Bkos), 2.0F);
      bkos.a(this.jdField_a_of_type_Bkos, xbt.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bkot.a.setBackgroundDrawable(new BitmapDrawable(bkos.a(this.jdField_a_of_type_Bkos).getResources(), bkos.a(this.jdField_a_of_type_Bkos)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */