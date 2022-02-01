package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PicPreviewMoveAdapter$PicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private RoundCorneredRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout;
  
  public PicPreviewMoveAdapter$PicViewHolder(PicPreviewMoveAdapter paramPicPreviewMoveAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369746));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369633));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380325));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)paramView.findViewById(2131376493));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    int i = ViewUtils.a(3.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setRadius(i, i, i, i);
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if (paramView == this.jdField_a_of_type_ComTencentImageURLImageView) {
      if (PicPreviewMoveAdapter.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter) != null) {
        PicPreviewMoveAdapter.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter).a(paramView, i);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
        PicPreviewMoveAdapter.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PicPreviewMoveAdapter.PicViewHolder
 * JD-Core Version:    0.7.0.1
 */