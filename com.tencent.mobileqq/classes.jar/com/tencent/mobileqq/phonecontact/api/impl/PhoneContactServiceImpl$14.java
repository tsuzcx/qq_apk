package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class PhoneContactServiceImpl$14
  implements Comparator<PhoneContact>
{
  PhoneContactServiceImpl$14(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
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
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.14
 * JD-Core Version:    0.7.0.1
 */