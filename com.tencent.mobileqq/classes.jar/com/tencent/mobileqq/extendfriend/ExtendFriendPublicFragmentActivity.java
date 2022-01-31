package com.tencent.mobileqq.extendfriend;

import abju;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class ExtendFriendPublicFragmentActivity
  extends PublicFragmentActivity
{
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    abju.a(paramContext, new Intent(), ExtendFriendPublicFragmentActivity.class, ExtendFriendFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */