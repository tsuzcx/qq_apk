package com.tencent.mobileqq.profile.PersonalityLabel;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class PersonalityLabelGalleryActivity$HorizontalSpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  private final int jdField_a_of_type_Int = (int)(PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity) * 3.0F);
  
  private PersonalityLabelGalleryActivity$HorizontalSpaceItemDecoration(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.right = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.HorizontalSpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */