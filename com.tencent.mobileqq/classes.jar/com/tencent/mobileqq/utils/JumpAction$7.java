package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import bdfr;
import bdhb;
import bdhk;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class JumpAction$7
  implements Runnable
{
  public JumpAction$7(bdhk parambdhk, String paramString1, long paramLong, String paramString2, String paramString3, Runnable paramRunnable) {}
  
  public void run()
  {
    String str = bdhb.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "opensdk_tmp");
    QLog.d("JumpAction", 1, new Object[] { "-->executeOnSubThread shareFilePath=", str, ", cost=", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    this.this$0.jdField_a_of_type_JavaUtilHashMap.remove(this.b);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      str = new String(bdfr.encode(str.getBytes("UTF-8"), 0));
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put(this.c, str);
      this.jdField_a_of_type_JavaLangRunnable.run();
      if ((!this.this$0.b) && ((this.this$0.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
        ((JumpActivity)this.this$0.jdField_a_of_type_AndroidContentContext).finish();
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "executeOnSubThread put exception:", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.7
 * JD-Core Version:    0.7.0.1
 */