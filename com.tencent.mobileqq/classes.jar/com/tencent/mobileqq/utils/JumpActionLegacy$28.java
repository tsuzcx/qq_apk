package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class JumpActionLegacy$28
  implements Runnable
{
  JumpActionLegacy$28(JumpActionLegacy paramJumpActionLegacy, String paramString, long paramLong, JumpActionLegacy.AsyncShareCallback paramAsyncShareCallback) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split(";");
    int i = 0;
    while (i < arrayOfString.length)
    {
      String str2 = JumpActionLegacy.a(this.this$0, arrayOfString[i]);
      QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck path=", str2 });
      if (!TextUtils.isEmpty(str2))
      {
        String str1 = str2;
        if (!str2.startsWith("http"))
        {
          str1 = FileUtils.saveFileUriToFile(this.this$0.jdField_a_of_type_AndroidContentContext, str2, "opensdk_tmp");
          QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck save file to:", str1, ", cost=", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
        }
        localStringBuilder.append(JumpActionLegacy.b(this.this$0, str1));
        localStringBuilder.append(";");
      }
      i += 1;
    }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      try
      {
        this.this$0.jdField_a_of_type_JavaUtilHashMap.put("file_data", new String(Base64Util.encode(localStringBuilder.toString().getBytes("UTF-8"), 0)));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("JumpAction", 1, "gotoShareMsgCheck put exception:", localUnsupportedEncodingException);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$AsyncShareCallback.a();
    JumpActionLegacy.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.28
 * JD-Core Version:    0.7.0.1
 */