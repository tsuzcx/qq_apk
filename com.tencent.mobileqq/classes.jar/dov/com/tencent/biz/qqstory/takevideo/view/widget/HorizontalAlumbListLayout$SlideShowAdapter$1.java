package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import azvv;
import bixp;
import bixq;
import wmt;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bixp parambixp, bixq parambixq) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bixq.a.getWidth();
    int j = this.jdField_a_of_type_Bixq.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bixp.a(this.jdField_a_of_type_Bixp) == null)
    {
      int k = azvv.a(bixp.a(this.jdField_a_of_type_Bixp), 1.0F);
      new Paint().setTextSize(azvv.a(bixp.a(this.jdField_a_of_type_Bixp), 11.0F));
      int m = azvv.a(bixp.a(this.jdField_a_of_type_Bixp), 2.0F);
      bixp.a(this.jdField_a_of_type_Bixp, wmt.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bixq.a.setBackgroundDrawable(new BitmapDrawable(bixp.a(this.jdField_a_of_type_Bixp).getResources(), bixp.a(this.jdField_a_of_type_Bixp)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */