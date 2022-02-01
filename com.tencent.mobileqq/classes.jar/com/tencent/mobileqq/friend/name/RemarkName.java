package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;

public class RemarkName
  implements IFriendName
{
  public String a(String paramString, Friends paramFriends, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.remark))) {
      return paramFriends.remark;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.name.RemarkName
 * JD-Core Version:    0.7.0.1
 */