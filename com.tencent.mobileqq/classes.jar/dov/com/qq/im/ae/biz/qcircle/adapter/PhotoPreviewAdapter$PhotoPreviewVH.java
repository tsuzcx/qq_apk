package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import dov.com.qq.im.ae.biz.qcircle.widget.AECircleVideoPreviewItemView;
import dov.com.qq.im.ae.biz.qcircle.widget.MultiTouchImageView;

public class PhotoPreviewAdapter$PhotoPreviewVH
  extends RecyclerView.ViewHolder
{
  public AECircleVideoPreviewItemView a;
  public MultiTouchImageView a;
  
  public PhotoPreviewAdapter$PhotoPreviewVH(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetMultiTouchImageView = ((MultiTouchImageView)paramView.findViewById(2131373060));
    if ((paramView instanceof AECircleVideoPreviewItemView)) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView = ((AECircleVideoPreviewItemView)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoPreviewAdapter.PhotoPreviewVH
 * JD-Core Version:    0.7.0.1
 */