package com.tencent.mobileqq.filemanager.bubble;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class DatalineFileBubbleModel$2
  implements FMDialogUtil.FMDialogInterface
{
  DatalineFileBubbleModel$2(DatalineFileBubbleModel paramDatalineFileBubbleModel) {}
  
  public void a()
  {
    DataLineMsgRecord localDataLineMsgRecord = DatalineFileBubbleModel.a(this.a);
    if (localDataLineMsgRecord == null) {
      return;
    }
    DatalineFileBubbleModel.a(this.a, localDataLineMsgRecord);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.DatalineFileBubbleModel.2
 * JD-Core Version:    0.7.0.1
 */