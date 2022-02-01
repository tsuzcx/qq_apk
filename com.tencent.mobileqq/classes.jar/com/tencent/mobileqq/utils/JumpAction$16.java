package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import auuv;
import bhcu;
import bheh;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class JumpAction$16
  implements Runnable
{
  public JumpAction$16(bheh parambheh, String paramString, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    String str1 = FileUtils.saveFileUriToFile(this.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "opensdk_tmp");
    if (!TextUtils.isEmpty(str1)) {}
    try
    {
      String str2 = new String(bhcu.encode(str1.getBytes("UTF-8"), 0));
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("file_data", str2);
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      auuv.a("KEY_STAGE_1_SAVE_IMAGE", l, this.jdField_a_of_type_JavaUtilHashMap, true);
      QLog.i("JumpAction", 1, "gotoShareMsgCheck save file to:" + str1 + ",cost=" + l);
      bheh.e(this.this$0);
      if ((!this.this$0.f) && (!MiniProgramOpenSdkUtil.isSharingMiniProgram(this.this$0.jdField_a_of_type_JavaUtilHashMap)) && ((this.this$0.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
        ((JumpActivity)this.this$0.jdField_a_of_type_AndroidContentContext).finish();
      }
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
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.16
 * JD-Core Version:    0.7.0.1
 */