package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import bbca;
import bbdj;
import bbds;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

public class JumpAction$17
  implements Runnable
{
  public JumpAction$17(bbds parambbds, String paramString1, String paramString2) {}
  
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
        str = bbdj.a(this.this$0.jdField_a_of_type_AndroidContentContext, str, "opensdk_tmp");
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
      localObject = new String(bbca.encode(((StringBuffer)localObject).toString().getBytes("UTF-8"), 0));
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("image_url", localObject);
      bbds.a(this.this$0, this.b, false);
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
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.17
 * JD-Core Version:    0.7.0.1
 */