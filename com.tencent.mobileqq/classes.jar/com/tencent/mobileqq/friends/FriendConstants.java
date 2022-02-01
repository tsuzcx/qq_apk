package com.tencent.mobileqq.friends;

import android.text.TextUtils;

public class FriendConstants
{
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.friends.FriendConstants
 * JD-Core Version:    0.7.0.1
 */