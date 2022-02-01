package com.tencent.mobileqq.qqexpand.widget.voice;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ExpandVoicePlayer$2
  implements Runnable
{
  ExpandVoicePlayer$2(ExpandVoicePlayer paramExpandVoicePlayer, String paramString) {}
  
  public void run()
  {
    if ((ExpandVoicePlayer.a(this.this$0) != null) && (ExpandVoicePlayer.a(this.this$0).isFinishing()))
    {
      QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file not exist download on executeOnFileThread but activity isFinishing");
      return;
    }
    QLog.i("ExtendFriendVoicePlayer", 2, "playLocal file not exist executeOnFileThread");
    String str = VFSAssistantUtils.getSDKPrivatePath(TransFileUtil.getTransferFilePath(ExpandVoicePlayer.a(this.this$0), MD5.toMD5(this.a), 23, null));
    File localFile = new File(str);
    int i = HttpDownloadUtil.downloadData(ExpandVoicePlayer.a(this.this$0), this.a, localFile);
    if (i == 0)
    {
      ExpandVoicePlayer.a(this.this$0).a(localFile);
      this.this$0.a(str);
      return;
    }
    ExpandVoicePlayer.a(this.this$0).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.2
 * JD-Core Version:    0.7.0.1
 */