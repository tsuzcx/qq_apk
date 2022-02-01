package com.tencent.mobileqq.profile.PersonalityLabel;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class PersonalityLabelGalleryActivity$RecyclerViewAdapter$1
  implements ActionSheet.OnButtonClickListener
{
  PersonalityLabelGalleryActivity$RecyclerViewAdapter$1(PersonalityLabelGalleryActivity.RecyclerViewAdapter paramRecyclerViewAdapter, PLUploadManager.UploadItem paramUploadItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter.a).get(Long.valueOf(PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter)));
        if (paramView == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter.a.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
          return;
        }
        int j = -1;
        paramInt = 0;
        int i;
        for (;;)
        {
          i = j;
          if (paramInt >= paramView.personalityLabelPhotos.size()) {
            break;
          }
          if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadItem.a.uniseq)
          {
            paramView.personalityLabelPhotos.remove(paramInt);
            i = paramInt;
            break;
          }
          paramInt += 1;
        }
        if (i < 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter.a.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
          return;
        }
        paramView.photoCount -= 1;
        PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter.a, PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter), paramView);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.b(PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter), this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadItem.a);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter), this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadItem.a);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$RecyclerViewAdapter.a.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.RecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */