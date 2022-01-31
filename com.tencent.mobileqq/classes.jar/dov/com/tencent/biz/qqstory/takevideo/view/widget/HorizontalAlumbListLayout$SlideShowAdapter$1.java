package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bcwh;
import bnac;
import bnad;
import yqm;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bnac parambnac, bnad parambnad) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bnad.a.getWidth();
    int j = this.jdField_a_of_type_Bnad.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bnac.a(this.jdField_a_of_type_Bnac) == null)
    {
      int k = bcwh.a(bnac.a(this.jdField_a_of_type_Bnac), 1.0F);
      new Paint().setTextSize(bcwh.a(bnac.a(this.jdField_a_of_type_Bnac), 11.0F));
      int m = bcwh.a(bnac.a(this.jdField_a_of_type_Bnac), 2.0F);
      bnac.a(this.jdField_a_of_type_Bnac, yqm.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bnad.a.setBackgroundDrawable(new BitmapDrawable(bnac.a(this.jdField_a_of_type_Bnac).getResources(), bnac.a(this.jdField_a_of_type_Bnac)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */