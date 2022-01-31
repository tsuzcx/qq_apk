package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import ajlc;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.MessageProgressView;

public class ImageItem$ImageViewHolder
  extends EditorViewHolderManager.EditViewHolderBase
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
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368418);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131368419));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.a = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(10);
    this.b = ((ImageView)paramView.findViewById(2131368422));
    this.c = ((ImageView)paramView.findViewById(2131368423));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368421));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)paramView.findViewById(2131368420));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(10.0F, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDisplayInTextView(AIOUtils.a(17.0F, paramView.getResources()), -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ajlc(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    this.b.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder
 * JD-Core Version:    0.7.0.1
 */