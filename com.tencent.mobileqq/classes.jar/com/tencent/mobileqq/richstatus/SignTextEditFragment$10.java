package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.widget.QQToast;

class SignTextEditFragment$10
  implements IStatusListener
{
  SignTextEditFragment$10(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    SignTextEditFragment.a(this.a, this.a.a, paramBoolean);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (this.a.getActivity() == null) {
      return;
    }
    if (paramInt == -1) {
      QQToast.a(this.a.getActivity(), 2131719116, 1).a();
    }
    SignTextEditFragment.a(this.a, this.a.a, SignTextEditFragment.a(this.a).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.10
 * JD-Core Version:    0.7.0.1
 */