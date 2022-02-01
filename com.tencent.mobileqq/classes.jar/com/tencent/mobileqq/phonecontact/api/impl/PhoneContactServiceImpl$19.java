package com.tencent.mobileqq.phonecontact.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class PhoneContactServiceImpl$19
  implements Comparator<PhoneContact>
{
  PhoneContactServiceImpl$19(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
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
    if (j == 0)
    {
      boolean bool2 = TextUtils.isEmpty(paramPhoneContact1.uin);
      int k = 1;
      int m = bool2 ^ true;
      if ((m != 0) && (!paramPhoneContact1.uin.equals("0"))) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool1 = TextUtils.isEmpty(paramPhoneContact2.uin) ^ true;
      if ((bool1) && (!paramPhoneContact2.uin.equals("0"))) {
        j = 1;
      } else {
        j = 0;
      }
      if (i != 0) {
        i = 0;
      } else if (m != 0) {
        i = 1;
      } else {
        i = 2;
      }
      if (j != 0) {
        j = 0;
      } else if (bool1) {
        j = k;
      } else {
        j = 2;
      }
      i -= j;
    }
    j = i;
    if (i == 0) {
      j = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.19
 * JD-Core Version:    0.7.0.1
 */