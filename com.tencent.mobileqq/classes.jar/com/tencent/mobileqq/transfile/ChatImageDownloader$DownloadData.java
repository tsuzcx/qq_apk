package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import java.io.OutputStream;
import java.net.URL;

public class ChatImageDownloader$DownloadData
{
  QQAppInterface app;
  BaseApplicationImpl application;
  public PicDownloadInfo downInfo;
  int fileSizeType;
  URLDrawableHandler handler;
  String host;
  public String logId = PicReq.a();
  public int mPrioty = 1;
  public int netWorkType = -1;
  OutputStream out;
  public MessageForPic pic;
  boolean sendFromLoacal;
  String sendPath;
  public long startOffset;
  public int uinType = -1;
  public PicUploadInfo upInfo;
  URL url;
  
  public ChatImageDownloader$DownloadData(ChatImageDownloader paramChatImageDownloader) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ChatImageDownloader.DownloadData
 * JD-Core Version:    0.7.0.1
 */