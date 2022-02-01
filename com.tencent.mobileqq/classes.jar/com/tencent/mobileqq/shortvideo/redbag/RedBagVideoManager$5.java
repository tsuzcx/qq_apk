package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;

class RedBagVideoManager$5
  implements Runnable
{
  RedBagVideoManager$5(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void run()
  {
    String str1 = null;
    if (RedBagVideoManager.a(this.this$0) == null) {}
    while (RedBagVideoManager.a(this.this$0).jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
      return;
    }
    String str2 = RedBagVideoManager.a(this.this$0).d;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VALUE_USER_UIN_TO_GET_NICK_NAME", str2);
    localObject = VideoPlayIPCClient.a().a("CMD_GET_NICK_NAME_BY_UIN", (Bundle)localObject);
    if ((localObject == null) && (QLog.isColorLevel())) {
      QLog.d("RedBagVideoManager", 2, "getNickName VideoPlayIPCClient.callServer value=null");
    }
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("VALUE_USER_NICK_NAME");; localObject = "")
    {
      Bundle localBundle = VideoPlayIPCClient.a().a("CMD_GET_CURRENT_NICK_NAME", null);
      if (localBundle != null) {
        str1 = localBundle.getString("VALUE_GET_CURRENT_NICK_NAME");
      }
      this.this$0.a(RedBagVideoManager.a(this.this$0), str2, (String)localObject, str1, RedBagVideoManager.a(this.this$0).c, RedBagVideoManager.a(this.this$0).g, RedBagVideoManager.a(this.this$0).jdField_e_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.5
 * JD-Core Version:    0.7.0.1
 */