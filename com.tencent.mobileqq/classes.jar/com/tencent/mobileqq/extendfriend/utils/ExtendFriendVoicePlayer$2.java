package com.tencent.mobileqq.extendfriend.utils;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ExtendFriendVoicePlayer$2
  implements Runnable
{
  ExtendFriendVoicePlayer$2(ExtendFriendVoicePlayer paramExtendFriendVoicePlayer, String paramString) {}
  
  public void run()
  {
    if ((ExtendFriendVoicePlayer.a(this.this$0) != null) && (ExtendFriendVoicePlayer.a(this.this$0).isFinishing()))
    {
      QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file not exist download on executeOnFileThread but activity isFinishing");
      return;
    }
    QLog.i("ExtendFriendVoicePlayer", 2, "playLocal file not exist executeOnFileThread");
    String str = BuddyTransfileProcessor.getTransferFilePath(ExtendFriendVoicePlayer.a(this.this$0).app.getCurrentAccountUin(), MD5.toMD5(this.a), 23, null);
    File localFile = new File(str);
    int i = HttpDownloadUtil.downloadData(ExtendFriendVoicePlayer.a(this.this$0).app, this.a, localFile);
    if (i == 0)
    {
      ExtendFriendVoicePlayer.a(this.this$0).a(localFile);
      this.this$0.a(str);
      return;
    }
    ExtendFriendVoicePlayer.a(this.this$0).f(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.2
 * JD-Core Version:    0.7.0.1
 */