package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;

public class AliasName
  implements IFriendName
{
  public String a(String paramString, Friends paramFriends, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.alias))) {
      return paramFriends.alias;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.name.AliasName
 * JD-Core Version:    0.7.0.1
 */