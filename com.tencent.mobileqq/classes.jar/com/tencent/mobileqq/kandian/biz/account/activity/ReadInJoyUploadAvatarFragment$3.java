package com.tencent.mobileqq.kandian.biz.account.activity;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.HashMap;

class ReadInJoyUploadAvatarFragment$3
  implements Runnable
{
  ReadInJoyUploadAvatarFragment$3(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, String paramString, Bundle paramBundle, Handler paramHandler) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    byte[] arrayOfByte = FileUtils.readFile(this.jdField_a_of_type_JavaLangString);
    if (arrayOfByte != null) {
      this.jdField_a_of_type_AndroidOsBundle.putString("data", Base64Util.encodeToString(arrayOfByte, 0));
    }
    localHashMap.put("BUNDLE", this.jdField_a_of_type_AndroidOsBundle);
    localHashMap.put("CONTEXT", this.this$0.getBaseActivity());
    new HttpWebCgiAsyncTask2("https://kandian.qq.com/cgi-bin/settings/upload_img", "POST", new ReadInJoyUploadAvatarFragment.3.1(this), 1000, null).a(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment.3
 * JD-Core Version:    0.7.0.1
 */