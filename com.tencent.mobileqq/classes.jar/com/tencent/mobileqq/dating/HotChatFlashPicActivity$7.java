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
    Object localObject = HotChatFlashPicActivity.a(this.this$0).c(1);
    if (localObject != null)
    {
      ((File)localObject).delete();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete, thumb  :");
        localStringBuilder.append(((File)localObject).getPath());
        QLog.d("Q.hotchat", 2, localStringBuilder.toString());
      }
    }
    FileUtils.deleteFile(HotChatFlashPicActivity.c(this.this$0));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete :");
      ((StringBuilder)localObject).append(HotChatFlashPicActivity.c(this.this$0));
      QLog.d("Q.hotchat", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.7
 * JD-Core Version:    0.7.0.1
 */