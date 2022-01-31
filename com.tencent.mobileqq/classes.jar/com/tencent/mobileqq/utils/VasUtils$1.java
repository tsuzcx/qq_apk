package com.tencent.mobileqq.utils;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import bcpw;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

public final class VasUtils$1
  implements Runnable
{
  public VasUtils$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localFragmentActivity.getChatFragment() != null) && (localFragmentActivity.getChatFragment().a() != null))
      {
        localFragmentActivity.getChatFragment().a().aa();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, this.jdField_a_of_type_JavaLangString, 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasUtils.1
 * JD-Core Version:    0.7.0.1
 */