package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView.DeleteIconClickListener;
import com.tencent.widget.XEditTextEx;

class ExpandProfileEditFragment$5
  implements ExpandVoiceView.DeleteIconClickListener
{
  ExpandProfileEditFragment$5(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.a()) {
      this.a.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b();
    }
    Object localObject = this.a;
    ((ExpandProfileEditFragment)localObject).b = "";
    ExpandProfileEditFragment.c((ExpandProfileEditFragment)localObject, 0);
    localObject = this.a.getParentFragment();
    if ((localObject != null) && ((localObject instanceof ExpandEditFragment))) {
      ((ExpandEditFragment)localObject).a = null;
    }
    ExpandProfileEditFragment.a(this.a, null);
    ExpandProfileEditFragment.g(this.a);
    if (ExpandProfileEditFragment.b(this.a))
    {
      ExpandProfileEditFragment.a(this.a, true);
      ExpandProfileEditFragment.b(this.a);
    }
    else
    {
      ExpandProfileEditFragment.a(this.a, false);
      if ((this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()))) {
        ExpandProfileEditFragment.a(this.a);
      }
    }
    localObject = this.a;
    ((ExpandProfileEditFragment)localObject).c = true;
    ExpandProfileEditFragment.b((ExpandProfileEditFragment)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.5
 * JD-Core Version:    0.7.0.1
 */