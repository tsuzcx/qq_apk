package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView.DeleteIconClickListener;
import com.tencent.widget.XEditTextEx;

class ExtendFriendOldProfileEditFragment$5
  implements OldExpandVoiceView.DeleteIconClickListener
{
  ExtendFriendOldProfileEditFragment$5(ExtendFriendOldProfileEditFragment paramExtendFriendOldProfileEditFragment) {}
  
  public void a()
  {
    if (this.a.m.a()) {
      this.a.m.c();
    }
    Object localObject = this.a;
    ((ExtendFriendOldProfileEditFragment)localObject).n = "";
    ExtendFriendOldProfileEditFragment.c((ExtendFriendOldProfileEditFragment)localObject, 0);
    localObject = this.a.getParentFragment();
    if ((localObject != null) && ((localObject instanceof ExpandOldEditFragment))) {
      ((ExpandOldEditFragment)localObject).c = null;
    }
    ExtendFriendOldProfileEditFragment.a(this.a, null);
    ExtendFriendOldProfileEditFragment.l(this.a);
    if (ExtendFriendOldProfileEditFragment.m(this.a))
    {
      ExtendFriendOldProfileEditFragment.a(this.a, true);
      ExtendFriendOldProfileEditFragment.c(this.a);
    }
    else
    {
      ExtendFriendOldProfileEditFragment.a(this.a, false);
      if ((this.a.k != null) && (this.a.k.equals(this.a.b.getText().toString()))) {
        ExtendFriendOldProfileEditFragment.b(this.a);
      }
    }
    localObject = this.a;
    ((ExtendFriendOldProfileEditFragment)localObject).l = true;
    ExtendFriendOldProfileEditFragment.c((ExtendFriendOldProfileEditFragment)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment.5
 * JD-Core Version:    0.7.0.1
 */