package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class JumpActionLegacy$27
  implements Runnable
{
  JumpActionLegacy$27(JumpActionLegacy paramJumpActionLegacy, String paramString, long paramLong, JumpActionLegacy.AsyncShareCallback paramAsyncShareCallback) {}
  
  public void run()
  {
    String str = FileUtils.saveFileUriToFile(this.this$0.b, this.a, "opensdk_tmp");
    QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck save file to:", str, ", cost=", Long.valueOf(System.currentTimeMillis() - this.b) });
    if (!TextUtils.isEmpty(str)) {
      try
      {
        this.this$0.f.put("image_url", new String(Base64Util.encode(str.getBytes("UTF-8"), 0)));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("JumpAction", 1, "gotoShareMsgCheck put exception:", localUnsupportedEncodingException);
      }
    }
    this.c.a();
    JumpActionLegacy.o(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.27
 * JD-Core Version:    0.7.0.1
 */