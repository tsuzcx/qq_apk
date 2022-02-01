package com.tencent.mobileqq.filemanager.fileviewer.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class VideoForDisc
  extends VideoForC2C
{
  public VideoForDisc(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public void a(FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, new VideoForDisc.1(this, paramFileVideoManagerCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc
 * JD-Core Version:    0.7.0.1
 */