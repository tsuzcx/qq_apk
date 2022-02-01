package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class JumpActionLegacy$9
  implements Runnable
{
  JumpActionLegacy$9(JumpActionLegacy paramJumpActionLegacy, String paramString1, long paramLong, String paramString2, String paramString3, Runnable paramRunnable) {}
  
  public void run()
  {
    String str = FileUtils.saveFileUriToFile(this.this$0.b, this.a, "opensdk_tmp");
    QLog.d("JumpAction", 1, new Object[] { "-->executeOnSubThread shareFilePath=", str, ", cost=", Long.valueOf(System.currentTimeMillis() - this.b) });
    this.this$0.f.remove(this.c);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        str = new String(Base64Util.encode(str.getBytes("UTF-8"), 0));
        this.this$0.f.put(this.d, str);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.i("JumpAction", 1, "executeOnSubThread put exception:", localUnsupportedEncodingException);
      }
    }
    this.e.run();
    if ((!this.this$0.v) && ((this.this$0.b instanceof JumpActivity))) {
      ((JumpActivity)this.this$0.b).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.9
 * JD-Core Version:    0.7.0.1
 */