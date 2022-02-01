package com.tencent.mobileqq.filemanager.fileview;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.ITbsReaderCallback;

class LocalTbsViewManager$3
  implements ITbsReaderCallback
{
  LocalTbsViewManager$3(LocalTbsViewManager paramLocalTbsViewManager) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    paramObject2 = new StringBuilder();
    paramObject2.append("initTbsReaderEntry: eventType[");
    paramObject2.append(paramInteger);
    paramObject2.append("] code[");
    paramObject2.append(paramObject1.toString());
    paramObject2.append("]");
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, paramObject2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.3
 * JD-Core Version:    0.7.0.1
 */