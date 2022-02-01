package com.tencent.mobileqq.relation.friend.inject;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.inject.IPhoneContactInjectService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

public class PhoneContactService
  implements IPhoneContactInjectService
{
  public String a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.queryPhoneContactByUin(paramString);
      if (paramAppInterface != null) {
        return paramAppInterface.name;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.friend.inject.PhoneContactService
 * JD-Core Version:    0.7.0.1
 */