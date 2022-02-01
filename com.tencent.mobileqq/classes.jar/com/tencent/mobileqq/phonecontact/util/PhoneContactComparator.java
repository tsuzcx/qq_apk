package com.tencent.mobileqq.phonecontact.util;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import java.util.Comparator;
import java.util.Set;

public class PhoneContactComparator
  implements Comparator<PhoneContact>
{
  private final int[] a;
  private final Set<String> b;
  private IAddFriendServiceApi c;
  
  public PhoneContactComparator(int[] paramArrayOfInt, Set<String> paramSet, AppInterface paramAppInterface)
  {
    this.a = paramArrayOfInt;
    this.b = paramSet;
    if (paramAppInterface != null) {
      this.c = ((IAddFriendServiceApi)paramAppInterface.getRuntimeService(IAddFriendServiceApi.class, ""));
    }
  }
  
  private int a(PhoneContact paramPhoneContact)
  {
    int j = OnlineStatusUtils.a(paramPhoneContact.detalStatusFlag, paramPhoneContact.iTermType);
    int i;
    if ((j != 6) && (j != 0)) {
      i = 65536;
    } else {
      i = 131072;
    }
    if (j != 1)
    {
      if (j != 2) {
        if ((j != 3) && (j != 4))
        {
          if (j != 7) {
            return (int)a(paramPhoneContact.unifiedCode) | i;
          }
        }
        else {
          return i | 0x1;
        }
      }
      return i | 0x3;
    }
    return i | 0x2;
  }
  
  private int b(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    boolean bool = "0".equals(paramPhoneContact1.uin);
    int j = 1;
    int i;
    if ((!bool) && (!TextUtils.isEmpty(paramPhoneContact1.uin))) {
      i = 1;
    } else {
      i = 0;
    }
    if (("0".equals(paramPhoneContact2.uin)) || (TextUtils.isEmpty(paramPhoneContact2.uin))) {
      j = 0;
    }
    return j - i;
  }
  
  private int c(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    IAddFriendServiceApi localIAddFriendServiceApi = this.c;
    int i = 0;
    if (localIAddFriendServiceApi == null) {
      return 0;
    }
    boolean bool1 = localIAddFriendServiceApi.hasSendAddFriendReq(paramPhoneContact1.unifiedCode, true);
    boolean bool2 = this.c.hasSendAddFriendReq(paramPhoneContact2.unifiedCode, true);
    if (bool1) {
      return 1;
    }
    if (bool2) {
      i = -1;
    }
    return i;
  }
  
  private int d(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    if ((paramPhoneContact2.samFriend > 0) && (paramPhoneContact1.samFriend > 0)) {
      return 0;
    }
    if ((paramPhoneContact2.samFriend <= 0) && (paramPhoneContact1.samFriend <= 0)) {
      return 0;
    }
    return e(paramPhoneContact1, paramPhoneContact2);
  }
  
  private int e(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    if (paramPhoneContact2.samFriend > paramPhoneContact1.samFriend) {
      return 1;
    }
    if (paramPhoneContact2.samFriend < paramPhoneContact1.samFriend) {
      return -1;
    }
    return 0;
  }
  
  private int f(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    boolean bool1 = paramPhoneContact1.isNewRecommend;
    boolean bool2 = paramPhoneContact2.isNewRecommend;
    if (((!bool1) && (!bool2)) || ((bool1) && (bool2))) {
      return 0;
    }
    if (bool2) {
      return 1;
    }
    return -1;
  }
  
  private int g(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return a(paramPhoneContact1) - a(paramPhoneContact2);
  }
  
  private int h(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
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
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int i = 0;
    if ((paramPhoneContact1 != null) && (paramPhoneContact2 != null))
    {
      int j = 0;
      i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.a;
        if (j >= arrayOfInt.length) {
          break;
        }
        switch (arrayOfInt[j])
        {
        default: 
          i = 0;
          break;
        case 7: 
          i = d(paramPhoneContact1, paramPhoneContact2);
          break;
        case 6: 
          i = b(paramPhoneContact1, paramPhoneContact2);
          break;
        case 5: 
          i = c(paramPhoneContact1, paramPhoneContact2);
          break;
        case 4: 
          i = h(paramPhoneContact1, paramPhoneContact2);
          break;
        case 3: 
          i = e(paramPhoneContact1, paramPhoneContact2);
          break;
        case 2: 
          i = g(paramPhoneContact1, paramPhoneContact2);
          break;
        case 1: 
          i = f(paramPhoneContact1, paramPhoneContact2);
        }
        if (i != 0) {
          return i;
        }
        j += 1;
      }
      return i;
    }
    if (paramPhoneContact1 != null) {
      return 1;
    }
    if (paramPhoneContact2 != null) {
      i = -1;
    }
    return i;
  }
  
  public long a(String paramString)
  {
    Set localSet = this.b;
    if (localSet == null) {
      return 0L;
    }
    if (localSet.contains(paramString)) {
      return 1L;
    }
    return 10L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.PhoneContactComparator
 * JD-Core Version:    0.7.0.1
 */