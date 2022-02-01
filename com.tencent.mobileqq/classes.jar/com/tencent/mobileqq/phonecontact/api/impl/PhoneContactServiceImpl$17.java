package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class PhoneContactServiceImpl$17
  implements Comparator<PhoneContact>
{
  PhoneContactServiceImpl$17(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    Object localObject2 = paramPhoneContact1.pinyinFirst;
    String str = paramPhoneContact2.pinyinFirst;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("#")) {
      localObject1 = "Za";
    }
    localObject2 = str;
    if (str.endsWith("#")) {
      localObject2 = "Za";
    }
    int j = ((String)localObject1).compareTo((String)localObject2);
    int i = j;
    if (j == 0) {
      i = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
    }
    j = i;
    if (i == 0) {
      j = paramPhoneContact1.contactID - paramPhoneContact2.contactID;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.17
 * JD-Core Version:    0.7.0.1
 */