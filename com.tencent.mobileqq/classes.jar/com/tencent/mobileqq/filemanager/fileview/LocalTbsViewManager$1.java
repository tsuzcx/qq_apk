package com.tencent.mobileqq.filemanager.fileview;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class LocalTbsViewManager$1
  implements TbsReaderView.ReaderCallback
{
  LocalTbsViewManager$1(LocalTbsViewManager paramLocalTbsViewManager, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel())
    {
      paramObject2 = new StringBuilder();
      paramObject2.append("recv actionType[");
      paramObject2.append(paramInteger);
      paramObject2.append("]");
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, paramObject2.toString());
    }
    if (paramInteger.intValue() == 5012)
    {
      int i = ((Integer)paramObject1).intValue();
      if (QLog.isColorLevel())
      {
        paramInteger = new StringBuilder();
        paramInteger.append("err Code[");
        paramInteger.append(i);
        paramInteger.append("]");
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, paramInteger.toString());
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "canOpenFile return ok 1-------");
        }
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback;
        if (paramInteger != null) {
          paramInteger.b(true);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "canOpenFile return ok 2-------");
      }
      paramInteger = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback;
      if (paramInteger != null) {
        paramInteger.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.1
 * JD-Core Version:    0.7.0.1
 */