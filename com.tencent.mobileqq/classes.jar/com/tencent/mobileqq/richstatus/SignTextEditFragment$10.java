package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.widget.QQToast;

class SignTextEditFragment$10
  implements IStatusListener
{
  SignTextEditFragment$10(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.a.getBaseActivity() == null) {
      return;
    }
    if (paramInt == -1) {
      QQToast.makeText(this.a.getBaseActivity(), 2131916364, 1).show();
    }
    SignTextEditFragment localSignTextEditFragment = this.a;
    SignTextEditFragment.a(localSignTextEditFragment, localSignTextEditFragment.m, SignTextEditFragment.c(this.a).d());
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    SignTextEditFragment localSignTextEditFragment = this.a;
    SignTextEditFragment.a(localSignTextEditFragment, localSignTextEditFragment.m, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.10
 * JD-Core Version:    0.7.0.1
 */