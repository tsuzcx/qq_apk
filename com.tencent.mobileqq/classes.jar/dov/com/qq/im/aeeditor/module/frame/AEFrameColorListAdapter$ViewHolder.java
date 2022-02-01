package dov.com.qq.im.aeeditor.module.frame;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

class AEFrameColorListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  final GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  final LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ImageView b;
  ImageView c;
  
  AEFrameColorListAdapter$ViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369617));
    this.b = ((ImageView)paramView.findViewById(2131369628));
    this.c = ((ImageView)paramView.findViewById(2131369803));
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131362294));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.frame.AEFrameColorListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */