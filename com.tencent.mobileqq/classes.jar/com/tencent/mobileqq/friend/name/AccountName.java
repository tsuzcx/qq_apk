package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class AccountName
  implements IFriendName
{
  public String a(String paramString, Friends paramFriends, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    do
    {
      return paramString;
      paramFriends = MobileQQ.sMobileQQ.getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
      paramString = paramFriends;
    } while (!TextUtils.isEmpty(paramFriends));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.name.AccountName
 * JD-Core Version:    0.7.0.1
 */