package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView.DeleteIconClickListener;

class ExpandProfileEditFragment$5
  implements ExpandVoiceView.DeleteIconClickListener
{
  ExpandProfileEditFragment$5(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public void a()
  {
    if (this.a.k.a()) {
      this.a.k.c();
    }
    Object localObject = this.a;
    ((ExpandProfileEditFragment)localObject).l = "";
    ExpandProfileEditFragment.c((ExpandProfileEditFragment)localObject, 0);
    localObject = this.a.getParentFragment();
    if ((localObject != null) && ((localObject instanceof ExpandEditFragment))) {
      ((ExpandEditFragment)localObject).b = null;
    }
    ExpandProfileEditFragment.a(this.a, null);
    ExpandProfileEditFragment.i(this.a);
    if (ExpandProfileEditFragment.j(this.a)) {
      ExpandProfileEditFragment.a(this.a, true);
    } else {
      ExpandProfileEditFragment.a(this.a, false);
    }
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.5
 * JD-Core Version:    0.7.0.1
 */