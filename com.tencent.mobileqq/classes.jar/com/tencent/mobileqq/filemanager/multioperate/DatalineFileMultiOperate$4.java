package com.tencent.mobileqq.filemanager.multioperate;

class DatalineFileMultiOperate$4
  implements Runnable
{
  DatalineFileMultiOperate$4(DatalineFileMultiOperate paramDatalineFileMultiOperate, QFileMultiOperateCallback paramQFileMultiOperateCallback, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QFileMultiOperateCallback localQFileMultiOperateCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback;
    if (localQFileMultiOperateCallback != null) {
      localQFileMultiOperateCallback.a(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.DatalineFileMultiOperate.4
 * JD-Core Version:    0.7.0.1
 */