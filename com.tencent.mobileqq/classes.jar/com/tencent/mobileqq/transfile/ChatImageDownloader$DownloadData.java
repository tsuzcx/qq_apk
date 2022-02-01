package com.tencent.mobileqq.transfile;

import aydl;
import ayds;
import ayeb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import java.io.OutputStream;
import java.net.URL;

public class ChatImageDownloader$DownloadData
{
  QQAppInterface app;
  BaseApplicationImpl application;
  public aydl downInfo;
  int fileSizeType;
  URLDrawableHandler handler;
  String host;
  public String logId = ayds.a();
  public int mPrioty = 1;
  public int netWorkType = -1;
  OutputStream out;
  public MessageForPic pic;
  boolean sendFromLoacal;
  String sendPath;
  public long startOffset;
  public int uinType = -1;
  public ayeb upInfo;
  URL url;
  
  public ChatImageDownloader$DownloadData(ChatImageDownloader paramChatImageDownloader) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ChatImageDownloader.DownloadData
 * JD-Core Version:    0.7.0.1
 */