package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.inject.FriendInjectFactory;
import com.tencent.mobileqq.friend.inject.IPubAccountInjectService;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountName
  implements IFriendName
{
  public String a(String paramString, Friends paramFriends, AppInterface paramAppInterface)
  {
    paramFriends = FriendInjectFactory.a();
    if (paramFriends != null)
    {
      paramString = paramFriends.a(paramAppInterface, paramString);
      if (!TextUtils.isEmpty(paramString)) {
        return paramString;
      }
    }
    else
    {
      QLog.e("IMCore.friend..PublicAccountName", 1, "pubAccountService == null");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.name.PublicAccountName
 * JD-Core Version:    0.7.0.1
 */