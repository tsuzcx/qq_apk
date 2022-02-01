package com.tencent.mobileqq.filemanager.bubble;

import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class DatalineFileBubbleModel$4
  implements Runnable
{
  DatalineFileBubbleModel$4(DatalineFileBubbleModel paramDatalineFileBubbleModel, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void run()
  {
    String str = FilePicURLDrawlableHelper.a(this.a.path);
    if (FileUtil.a(str))
    {
      this.a.thumbPath = str;
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    FilePicURLDrawlableHelper.a(this.a.path, localOptions);
    FilePicURLDrawlableHelper.a(this.a.path, str, 1);
    if (FileUtil.a(str))
    {
      this.a.thumbPath = str;
      this.this$0.a.getFileManagerNotifyCenter().a(true, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.DatalineFileBubbleModel.4
 * JD-Core Version:    0.7.0.1
 */