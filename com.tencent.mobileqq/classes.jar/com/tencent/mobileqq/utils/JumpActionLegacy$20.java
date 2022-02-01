package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class JumpActionLegacy$20
  implements Runnable
{
  JumpActionLegacy$20(JumpActionLegacy paramJumpActionLegacy, String paramString) {}
  
  public void run()
  {
    String str = FileUtils.saveFileUriToFile(this.this$0.jdField_a_of_type_AndroidContentContext, this.a, "opensdk_tmp");
    try
    {
      str = new String(Base64Util.encode(str.getBytes("UTF-8"), 0));
      if (!TextUtils.isEmpty(str)) {
        this.this$0.jdField_a_of_type_JavaUtilHashMap.put("videoPath", str);
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QLog.e("JumpAction", 1, "gotoQzonePublishMoodCheck exception:", localUnsupportedEncodingException);
    }
    JumpActionLegacy.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.20
 * JD-Core Version:    0.7.0.1
 */