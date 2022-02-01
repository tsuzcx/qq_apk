package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.ITbsReaderCallback;

class LocalTbsViewManager$3
  implements ITbsReaderCallback
{
  LocalTbsViewManager$3(LocalTbsViewManager paramLocalTbsViewManager) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "initTbsReaderEntry: eventType[" + paramInteger + "] code[" + paramObject1.toString() + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.3
 * JD-Core Version:    0.7.0.1
 */