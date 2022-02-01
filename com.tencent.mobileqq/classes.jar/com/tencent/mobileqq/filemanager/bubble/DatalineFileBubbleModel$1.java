package com.tencent.mobileqq.filemanager.bubble;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.wifi.FreeWifiDialogListener;

class DatalineFileBubbleModel$1
  implements FreeWifiDialogListener
{
  DatalineFileBubbleModel$1(DatalineFileBubbleModel paramDatalineFileBubbleModel) {}
  
  public void a(int paramInt)
  {
    DataLineMsgRecord localDataLineMsgRecord = DatalineFileBubbleModel.a(this.a);
    if (localDataLineMsgRecord == null) {
      return;
    }
    DatalineFileBubbleModel.a(this.a, localDataLineMsgRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.DatalineFileBubbleModel.1
 * JD-Core Version:    0.7.0.1
 */