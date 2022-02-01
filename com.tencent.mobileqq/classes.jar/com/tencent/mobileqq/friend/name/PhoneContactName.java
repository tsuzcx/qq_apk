package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.inject.IPhoneContactService;
import com.tencent.mobileqq.friend.phonecontact.PhoneContactInjectFactory;

public class PhoneContactName
  implements IFriendName
{
  private IPhoneContactService a = PhoneContactInjectFactory.a();
  
  public String a(String paramString, Friends paramFriends, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramFriends = "";
      return paramFriends;
    }
    if (this.a != null) {}
    for (paramString = this.a.a(paramAppInterface, paramString);; paramString = null)
    {
      paramFriends = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.name.PhoneContactName
 * JD-Core Version:    0.7.0.1
 */