package com.tencent.mobileqq.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

final class VasUtils$1
  implements Runnable
{
  VasUtils$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject != null) && ((localObject instanceof BaseActivity)))
    {
      localObject = (BaseActivity)localObject;
      if ((((BaseActivity)localObject).getChatFragment() != null) && (((BaseActivity)localObject).getChatFragment().a() != null))
      {
        ((BaseActivity)localObject).getChatFragment().a().G();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, this.jdField_a_of_type_JavaLangString, 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasUtils.1
 * JD-Core Version:    0.7.0.1
 */