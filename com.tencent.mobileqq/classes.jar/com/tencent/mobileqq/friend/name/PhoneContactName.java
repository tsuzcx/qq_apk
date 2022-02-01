package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.inject.FriendInjectFactory;
import com.tencent.mobileqq.friend.inject.IPhoneContactInjectService;
import com.tencent.qphone.base.util.QLog;

public class PhoneContactName
  implements IFriendName
{
  private IPhoneContactInjectService a = FriendInjectFactory.a();
  
  public String a(String paramString, Friends paramFriends, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramFriends = this.a;
    if (paramFriends != null)
    {
      paramString = paramFriends.a(paramAppInterface, paramString);
    }
    else
    {
      QLog.e("IMCore.friend..PhoneContactName", 1, "mPhoneContactService == null");
      paramString = null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.name.PhoneContactName
 * JD-Core Version:    0.7.0.1
 */