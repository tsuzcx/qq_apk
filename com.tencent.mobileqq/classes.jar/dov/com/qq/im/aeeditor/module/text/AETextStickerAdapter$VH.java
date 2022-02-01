package dov.com.qq.im.aeeditor.module.text;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class AETextStickerAdapter$VH
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  AEDownLoadingView jdField_a_of_type_DovComQqImAeViewAEDownLoadingView;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  View d;
  
  public AETextStickerAdapter$VH(AETextStickerAdapter paramAETextStickerAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364763);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368754));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377706));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131381092);
    this.d = paramView.findViewById(2131381093);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373580));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369627));
    int i = AIOUtils.a(6.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int j = AIOUtils.a(2.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int k = AIOUtils.a(16.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(1.0F * k / 2.0F);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.VH
 * JD-Core Version:    0.7.0.1
 */