package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class HotChatFlashPicActivity$7
  implements Runnable
{
  HotChatFlashPicActivity$7(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public void run()
  {
    File localFile = HotChatFlashPicActivity.a(this.this$0).a(1);
    if (localFile != null)
    {
      localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "delete, thumb  :" + localFile.getPath());
      }
    }
    FileUtils.e(HotChatFlashPicActivity.b(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "delete :" + HotChatFlashPicActivity.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.7
 * JD-Core Version:    0.7.0.1
 */