package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.HybridSearchFragment;

class ReadInJoySelectMemberFragment$2
  implements TextWatcher
{
  ReadInJoySelectMemberFragment$2(ReadInJoySelectMemberFragment paramReadInJoySelectMemberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      if (!ReadInJoySelectMemberFragment.c(this.a).isVisible()) {
        this.a.getChildFragmentManager().beginTransaction().add(2131433669, ReadInJoySelectMemberFragment.c(this.a)).addToBackStack(null).commit();
      }
      ReadInJoySelectMemberFragment.c(this.a).a(paramEditable.toString());
      return;
    }
    if (!ReadInJoySelectMemberFragment.c(this.a).isDetached()) {
      this.a.getChildFragmentManager().popBackStackImmediate();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */