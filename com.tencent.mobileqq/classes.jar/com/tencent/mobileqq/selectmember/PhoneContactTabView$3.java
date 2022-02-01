package com.tencent.mobileqq.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class PhoneContactTabView$3
  extends ContactBindObserver
{
  PhoneContactTabView$3(PhoneContactTabView paramPhoneContactTabView) {}
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.unRegistObserver(this);
    int i = PhoneContactTabView.a(this.a).getSelfBindState();
    if ((i != 0) && (i != 1) && (i != 5)) {
      if (i != 6)
      {
        if (i != 7)
        {
          if (i != 9)
          {
            PhoneContactTabView.b(this.a);
            return;
          }
          this.a.d();
        }
      }
      else
      {
        if (PhoneContactTabView.a(this.a).getSelfBindInfo().lastUsedFlag == 2L)
        {
          this.a.d();
          return;
        }
        PhoneContactTabView.a(this.a);
        return;
      }
    }
    PhoneContactTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView.3
 * JD-Core Version:    0.7.0.1
 */