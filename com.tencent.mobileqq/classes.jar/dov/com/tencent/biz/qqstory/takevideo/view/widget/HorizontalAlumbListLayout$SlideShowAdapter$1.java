package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import aaic;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bphl;
import bphm;
import com.tencent.mobileqq.util.DisplayUtil;

public class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  public HorizontalAlumbListLayout$SlideShowAdapter$1(bphl parambphl, bphm parambphm) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bphm.a.getWidth();
    int j = this.jdField_a_of_type_Bphm.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (bphl.a(this.jdField_a_of_type_Bphl) == null)
    {
      int k = DisplayUtil.dip2px(bphl.a(this.jdField_a_of_type_Bphl), 1.0F);
      new Paint().setTextSize(DisplayUtil.dip2px(bphl.a(this.jdField_a_of_type_Bphl), 11.0F));
      int m = DisplayUtil.dip2px(bphl.a(this.jdField_a_of_type_Bphl), 2.0F);
      bphl.a(this.jdField_a_of_type_Bphl, aaic.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_Bphm.a.setBackgroundDrawable(new BitmapDrawable(bphl.a(this.jdField_a_of_type_Bphl).getResources(), bphl.a(this.jdField_a_of_type_Bphl)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */