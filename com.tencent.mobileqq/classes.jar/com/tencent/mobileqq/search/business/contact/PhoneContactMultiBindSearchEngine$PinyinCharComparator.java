package com.tencent.mobileqq.search.business.contact;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import java.util.Comparator;

final class PhoneContactMultiBindSearchEngine$PinyinCharComparator
  implements Comparator<IContactSearchModel>
{
  AppInterface a;
  private final IPhoneContactService b;
  
  PhoneContactMultiBindSearchEngine$PinyinCharComparator(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, ""));
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return ((IAddFriendServiceApi)this.a.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    paramIContactSearchModel1 = this.b.queryContactByCodeNumber(((ContactSearchModelPhoneContact)paramIContactSearchModel1).s());
    paramIContactSearchModel2 = this.b.queryContactByCodeNumber(((ContactSearchModelPhoneContact)paramIContactSearchModel2).s());
    if ((paramIContactSearchModel1 != null) && (paramIContactSearchModel2 != null))
    {
      if ((paramIContactSearchModel1.uin.equals("0")) && (paramIContactSearchModel2.uin.equals("0")))
      {
        boolean bool1 = a(paramIContactSearchModel1.unifiedCode, true);
        boolean bool2 = a(paramIContactSearchModel2.unifiedCode, true);
        if ((!bool1) && (!bool2))
        {
          bool1 = TextUtils.isEmpty(paramIContactSearchModel1.pinyinFirst);
          bool2 = TextUtils.isEmpty(paramIContactSearchModel2.pinyinFirst);
          if ((!bool1) && (!bool2)) {
            return paramIContactSearchModel1.pinyinFirst.toLowerCase().charAt(0) - paramIContactSearchModel2.pinyinFirst.toLowerCase().charAt(0);
          }
          if ((bool1) && (bool2)) {
            return 0;
          }
          if (bool2) {
            return -1;
          }
          return 1;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
        if (bool2) {
          return -1;
        }
        return 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.PhoneContactMultiBindSearchEngine.PinyinCharComparator
 * JD-Core Version:    0.7.0.1
 */