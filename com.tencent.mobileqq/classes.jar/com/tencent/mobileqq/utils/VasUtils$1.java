package com.tencent.mobileqq.utils;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

final class VasUtils$1
  implements Runnable
{
  VasUtils$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localFragmentActivity.getChatFragment() != null) && (localFragmentActivity.getChatFragment().a() != null))
      {
        localFragmentActivity.getChatFragment().a().Z();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, this.jdField_a_of_type_JavaLangString, 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasUtils.1
 * JD-Core Version:    0.7.0.1
 */