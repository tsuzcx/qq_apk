package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class QQGamePreDownloadServiceImpl$1
  extends QQGamePreDownloadServiceImpl.DownloadListenerWrapper
{
  QQGamePreDownloadServiceImpl$1(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl, DownloadListener paramDownloadListener, DownloadParam paramDownloadParam)
  {
    super(paramDownloadListener);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    QQGamePreDownloadServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiImplQQGamePreDownloadServiceImpl, paramDownloadTask, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */