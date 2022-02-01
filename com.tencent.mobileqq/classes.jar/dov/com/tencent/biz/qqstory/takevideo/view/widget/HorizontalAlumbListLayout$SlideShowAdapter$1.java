package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bnrt;
import bnru;
import com.tencent.mobileqq.util.DisplayUtil;
import zsq;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bnrt parambnrt, bnru parambnru) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bnru.a.getWidth();
    int j = this.jdField_a_of_type_Bnru.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bnrt.a(this.jdField_a_of_type_Bnrt) == null)
    {
      int k = DisplayUtil.dip2px(bnrt.a(this.jdField_a_of_type_Bnrt), 1.0F);
      new Paint().setTextSize(DisplayUtil.dip2px(bnrt.a(this.jdField_a_of_type_Bnrt), 11.0F));
      int m = DisplayUtil.dip2px(bnrt.a(this.jdField_a_of_type_Bnrt), 2.0F);
      bnrt.a(this.jdField_a_of_type_Bnrt, zsq.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bnru.a.setBackgroundDrawable(new BitmapDrawable(bnrt.a(this.jdField_a_of_type_Bnrt).getResources(), bnrt.a(this.jdField_a_of_type_Bnrt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */