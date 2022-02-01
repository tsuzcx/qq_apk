package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.widget.QQToast;

class SignTextEditFragment$10
  implements IStatusListener
{
  SignTextEditFragment$10(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    SignTextEditFragment localSignTextEditFragment = this.a;
    SignTextEditFragment.a(localSignTextEditFragment, localSignTextEditFragment.a, paramBoolean);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (this.a.getBaseActivity() == null) {
      return;
    }
    if (paramInt == -1) {
      QQToast.a(this.a.getBaseActivity(), 2131718834, 1).a();
    }
    SignTextEditFragment localSignTextEditFragment = this.a;
    SignTextEditFragment.a(localSignTextEditFragment, localSignTextEditFragment.a, SignTextEditFragment.a(this.a).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.10
 * JD-Core Version:    0.7.0.1
 */