package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import aawd;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bhgr;
import bqxp;
import bqxq;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bqxp parambqxp, bqxq parambqxq) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bqxq.a.getWidth();
    int j = this.jdField_a_of_type_Bqxq.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bqxp.a(this.jdField_a_of_type_Bqxp) == null)
    {
      int k = bhgr.a(bqxp.a(this.jdField_a_of_type_Bqxp), 1.0F);
      new Paint().setTextSize(bhgr.a(bqxp.a(this.jdField_a_of_type_Bqxp), 11.0F));
      int m = bhgr.a(bqxp.a(this.jdField_a_of_type_Bqxp), 2.0F);
      bqxp.a(this.jdField_a_of_type_Bqxp, aawd.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bqxq.a.setBackgroundDrawable(new BitmapDrawable(bqxp.a(this.jdField_a_of_type_Bqxp).getResources(), bqxp.a(this.jdField_a_of_type_Bqxp)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */