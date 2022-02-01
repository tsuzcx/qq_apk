package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

class JumpAction$23
  implements Runnable
{
  JumpAction$23(JumpAction paramJumpAction, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new StringBuffer();
    String[] arrayOfString = this.a.split(";");
    int i = 0;
    while (i < arrayOfString.length)
    {
      String str = URLDecoder.decode(arrayOfString[i]);
      if (!TextUtils.isEmpty(str))
      {
        str = FileUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, str, "opensdk_tmp");
        if (!TextUtils.isEmpty(str))
        {
          ((StringBuffer)localObject).append(URLEncoder.encode(str));
          if (i != arrayOfString.length - 1) {
            ((StringBuffer)localObject).append(";");
          }
        }
      }
      i += 1;
    }
    try
    {
      localObject = new String(Base64Util.encode(((StringBuffer)localObject).toString().getBytes("UTF-8"), 0));
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("image_url", localObject);
      JumpAction.a(this.this$0, this.b, false);
      if (((this.this$0.jdField_a_of_type_AndroidContentContext instanceof GesturePWDUnlockActivity)) && (this.this$0.g)) {
        ((GesturePWDUnlockActivity)this.this$0.jdField_a_of_type_AndroidContentContext).finish();
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "gotoShareMsgCheck put exception:", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.23
 * JD-Core Version:    0.7.0.1
 */