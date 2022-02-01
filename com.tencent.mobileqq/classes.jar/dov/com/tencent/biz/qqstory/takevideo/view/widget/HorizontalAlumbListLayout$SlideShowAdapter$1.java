package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import aasa;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bggq;
import bpvu;
import bpvv;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bpvu parambpvu, bpvv parambpvv) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bpvv.a.getWidth();
    int j = this.jdField_a_of_type_Bpvv.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bpvu.a(this.jdField_a_of_type_Bpvu) == null)
    {
      int k = bggq.a(bpvu.a(this.jdField_a_of_type_Bpvu), 1.0F);
      new Paint().setTextSize(bggq.a(bpvu.a(this.jdField_a_of_type_Bpvu), 11.0F));
      int m = bggq.a(bpvu.a(this.jdField_a_of_type_Bpvu), 2.0F);
      bpvu.a(this.jdField_a_of_type_Bpvu, aasa.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bpvv.a.setBackgroundDrawable(new BitmapDrawable(bpvu.a(this.jdField_a_of_type_Bpvu).getResources(), bpvu.a(this.jdField_a_of_type_Bpvu)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */