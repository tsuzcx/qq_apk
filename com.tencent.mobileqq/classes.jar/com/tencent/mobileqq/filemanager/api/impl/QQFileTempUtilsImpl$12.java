package com.tencent.mobileqq.filemanager.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQFileTempUtilsImpl$12
  implements View.OnClickListener
{
  QQFileTempUtilsImpl$12(QQFileTempUtilsImpl paramQQFileTempUtilsImpl, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface) {}
  
  public void onClick(View paramView)
  {
    QQFileManagerUtil.TipsClickedInterface localTipsClickedInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$TipsClickedInterface;
    if (localTipsClickedInterface != null) {
      localTipsClickedInterface.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl.12
 * JD-Core Version:    0.7.0.1
 */