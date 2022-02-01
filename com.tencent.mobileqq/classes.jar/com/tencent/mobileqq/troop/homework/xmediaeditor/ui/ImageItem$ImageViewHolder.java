package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.MessageProgressView;

public class ImageItem$ImageViewHolder
  extends EditorViewHolderManager.EditViewHolderBase<EditItemInfoBase>
{
  public View a;
  public ImageView a;
  public RoundCornerImageView a;
  public URLDrawable a;
  public MessageProgressView a;
  public ImageView b;
  public ImageView c;
  
  public ImageItem$ImageViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368226);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131368228));
    RoundCornerImageView localRoundCornerImageView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
    localRoundCornerImageView.a = 1;
    localRoundCornerImageView.setCorner(10);
    this.b = ((ImageView)paramView.findViewById(2131368231));
    this.c = ((ImageView)paramView.findViewById(2131368229));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368227));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)paramView.findViewById(2131368230));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(10.0F, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDisplayInTextView(ViewUtils.b(17.0F), -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ImageItem.ImageViewHolder.1(this));
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    this.b.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder
 * JD-Core Version:    0.7.0.1
 */