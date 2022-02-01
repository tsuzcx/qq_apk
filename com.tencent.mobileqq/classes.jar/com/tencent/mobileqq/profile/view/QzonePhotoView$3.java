package com.tencent.mobileqq.profile.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzonePhotoView$3
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  QzonePhotoView$3(QzonePhotoView paramQzonePhotoView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      if ((paramView != null) && ((paramView.getTag() instanceof DataTag)))
      {
        Object localObject = (DataTag)paramView.getTag();
        if (localObject != null)
        {
          int i = ((DataTag)localObject).a;
          localObject = QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a.a;
          switch (i)
          {
          default: 
            break;
          case 25: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "2", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.QzonePhotoView", 2, "View.OnClickListener click type is photo wall view");
            }
            QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.3
 * JD-Core Version:    0.7.0.1
 */