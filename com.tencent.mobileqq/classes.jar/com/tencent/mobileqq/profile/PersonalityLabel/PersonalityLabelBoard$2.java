package com.tencent.mobileqq.profile.PersonalityLabel;

import android.view.View;
import autg;
import mqq.util.WeakReference;

class PersonalityLabelBoard$2
  implements Runnable
{
  PersonalityLabelBoard$2(PersonalityLabelBoard paramPersonalityLabelBoard) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.isCloseByUser == 0)) {
      if (this.this$0.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label62;
      }
    }
    label62:
    for (autg localautg = null;; localautg = (autg)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (localautg != null)
      {
        int i = this.this$0.jdField_a_of_type_AndroidViewView.getTop();
        if (i >= 0) {
          localautg.e(i);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.2
 * JD-Core Version:    0.7.0.1
 */