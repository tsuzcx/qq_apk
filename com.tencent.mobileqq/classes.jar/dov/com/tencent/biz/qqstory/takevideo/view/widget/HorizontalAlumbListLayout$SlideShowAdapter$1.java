package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import com.tencent.biz.troopgift.GridListAdapter;
import com.tencent.mobileqq.util.DisplayUtil;

class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  HorizontalAlumbListLayout$SlideShowAdapter$1(HorizontalAlumbListLayout.SlideShowAdapter paramSlideShowAdapter, HorizontalAlumbListLayout.SlideShowViewHolder paramSlideShowViewHolder) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowViewHolder.a.getWidth();
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowViewHolder.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (HorizontalAlumbListLayout.SlideShowAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowAdapter) == null)
    {
      int k = DisplayUtil.a(HorizontalAlumbListLayout.SlideShowAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowAdapter), 1.0F);
      new Paint().setTextSize(DisplayUtil.a(HorizontalAlumbListLayout.SlideShowAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowAdapter), 11.0F));
      int m = DisplayUtil.a(HorizontalAlumbListLayout.SlideShowAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowAdapter), 2.0F);
      HorizontalAlumbListLayout.SlideShowAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowAdapter, GridListAdapter.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowViewHolder.a.setBackgroundDrawable(new BitmapDrawable(HorizontalAlumbListLayout.SlideShowAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowAdapter).getResources(), HorizontalAlumbListLayout.SlideShowAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$SlideShowAdapter)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */