package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import bhcu;
import bheh;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class JumpAction$18
  implements Runnable
{
  public JumpAction$18(bheh parambheh, String paramString) {}
  
  public void run()
  {
    String str = FileUtils.saveFileUriToFile(this.this$0.jdField_a_of_type_AndroidContentContext, this.a, "opensdk_tmp");
    try
    {
      str = new String(bhcu.encode(str.getBytes("UTF-8"), 0));
      if (!TextUtils.isEmpty(str)) {
        this.this$0.jdField_a_of_type_JavaUtilHashMap.put("videoPath", str);
      }
      bheh.a(this.this$0, false);
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
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.18
 * JD-Core Version:    0.7.0.1
 */