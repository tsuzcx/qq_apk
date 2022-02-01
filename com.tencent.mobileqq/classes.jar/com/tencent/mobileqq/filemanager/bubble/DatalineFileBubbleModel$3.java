package com.tencent.mobileqq.filemanager.bubble;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.VideoThumbInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class DatalineFileBubbleModel$3
  implements Runnable
{
  DatalineFileBubbleModel$3(DatalineFileBubbleModel paramDatalineFileBubbleModel, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void run()
  {
    FileManagerUtil.VideoThumbInfo localVideoThumbInfo = FileManagerUtil.a(this.a.path);
    if (FileUtil.b(localVideoThumbInfo.a))
    {
      this.a.thumbPath = localVideoThumbInfo.a;
      this.this$0.a.getFileManagerNotifyCenter().a(true, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.DatalineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */