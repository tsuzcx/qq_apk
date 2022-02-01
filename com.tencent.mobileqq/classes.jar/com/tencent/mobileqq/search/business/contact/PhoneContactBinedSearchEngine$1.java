package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import java.util.Comparator;

class PhoneContactBinedSearchEngine$1
  implements Comparator<IContactSearchModel>
{
  PhoneContactBinedSearchEngine$1(PhoneContactBinedSearchEngine paramPhoneContactBinedSearchEngine) {}
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.a.a.getRuntimeService(IPhoneContactService.class, "");
    paramIContactSearchModel1 = localIPhoneContactService.queryContactByCodeNumber(((ContactSearchModelPhoneContact)paramIContactSearchModel1).e());
    paramIContactSearchModel2 = localIPhoneContactService.queryContactByCodeNumber(((ContactSearchModelPhoneContact)paramIContactSearchModel2).e());
    if ((paramIContactSearchModel1 != null) && (paramIContactSearchModel2 != null))
    {
      if ((paramIContactSearchModel1.uin.equals("0")) && (paramIContactSearchModel2.uin.equals("0")))
      {
        if (paramIContactSearchModel1.uin.equals("0"))
        {
          boolean bool1 = PhoneContactBinedSearchEngine.a(this.a, paramIContactSearchModel1.unifiedCode, true);
          boolean bool2 = PhoneContactBinedSearchEngine.a(this.a, paramIContactSearchModel2.unifiedCode, true);
          if ((bool1) || (bool2))
          {
            if ((bool1) && (bool2)) {
              return 0;
            }
            if (bool2) {
              return -1;
            }
            return 1;
          }
        }
        return 0;
      }
      if ((!paramIContactSearchModel1.uin.equals("0")) && (!paramIContactSearchModel2.uin.equals("0"))) {
        return 0;
      }
      if (!paramIContactSearchModel2.uin.equals("0")) {
        return -1;
      }
      return 1;
    }
    if ((paramIContactSearchModel1 == null) && (paramIContactSearchModel2 == null)) {
      return 0;
    }
    if (paramIContactSearchModel2 == null) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.PhoneContactBinedSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */