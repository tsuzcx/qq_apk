package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class JumpAction$29
  implements Runnable
{
  JumpAction$29(JumpAction paramJumpAction, String paramString, long paramLong, JumpAction.AsyncShareCallback paramAsyncShareCallback) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split(";");
    int i = 0;
    if (i < arrayOfString.length)
    {
      String str2 = JumpAction.a(this.this$0, arrayOfString[i]);
      QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck path=", str2 });
      if (TextUtils.isEmpty(str2)) {}
      for (;;)
      {
        i += 1;
        break;
        String str1 = str2;
        if (!str2.startsWith("http"))
        {
          str1 = FileUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, str2, "opensdk_tmp");
          QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck save file to:", str1, ", cost=", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
        }
        localStringBuilder.append(JumpAction.b(this.this$0, str1)).append(";");
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    try
    {
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("file_data", new String(Base64Util.encode(localStringBuilder.toString().getBytes("UTF-8"), 0)));
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
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.29
 * JD-Core Version:    0.7.0.1
 */