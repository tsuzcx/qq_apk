package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class JumpAction$21
  implements Runnable
{
  JumpAction$21(JumpAction paramJumpAction, String paramString) {}
  
  public void run()
  {
    String str = FileUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.a, "opensdk_tmp");
    try
    {
      str = new String(Base64Util.encode(str.getBytes("UTF-8"), 0));
      if (!TextUtils.isEmpty(str)) {
        this.this$0.jdField_a_of_type_JavaUtilHashMap.put("videoPath", str);
      }
      JumpAction.a(this.this$0, false);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "gotoQzonePublishMoodCheck exception:", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.21
 * JD-Core Version:    0.7.0.1
 */