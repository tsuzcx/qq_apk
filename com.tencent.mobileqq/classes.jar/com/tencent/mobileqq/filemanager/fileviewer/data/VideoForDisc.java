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
    this.a.nOpType = 1;
    this.b.getFileTransferHandler().a(this.a.nSessionId, this.a.fileName, Long.parseLong(this.a.peerUin), this.a.Uuid, new VideoForDisc.1(this, paramFileVideoManagerCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc
 * JD-Core Version:    0.7.0.1
 */