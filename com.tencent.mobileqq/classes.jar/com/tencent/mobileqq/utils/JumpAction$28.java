package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class JumpAction$28
  implements Runnable
{
  JumpAction$28(JumpAction paramJumpAction, String paramString, long paramLong, JumpAction.AsyncShareCallback paramAsyncShareCallback) {}
  
  public void run()
  {
    String str = FileUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "opensdk_tmp");
    QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck save file to:", str, ", cost=", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("image_url", new String(Base64Util.encode(str.getBytes("UTF-8"), 0)));
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$AsyncShareCallback.a();
      JumpAction.d(this.this$0);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "gotoShareMsgCheck put exception:", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.28
 * JD-Core Version:    0.7.0.1
 */