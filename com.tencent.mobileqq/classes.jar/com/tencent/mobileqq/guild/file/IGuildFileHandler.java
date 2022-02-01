package com.tencent.mobileqq.guild.file;

public abstract interface IGuildFileHandler
{
  public abstract void a(UFTGuildDownloadReq paramUFTGuildDownloadReq, IGuildDownloadReqCallback paramIGuildDownloadReqCallback);
  
  public abstract void a(UFTGuildPreviewThumbReq paramUFTGuildPreviewThumbReq, IGuildPreviewThumbReqCallback paramIGuildPreviewThumbReqCallback);
  
  public abstract void a(UFTGuildUploadReq paramUFTGuildUploadReq, IGuildUploadReqCallback paramIGuildUploadReqCallback);
  
  public abstract void a(UFTGuildUploadSuccReq paramUFTGuildUploadSuccReq, IGuildUploadSuccReqCallback paramIGuildUploadSuccReqCallback);
  
  public abstract void b(UFTGuildPreviewThumbReq paramUFTGuildPreviewThumbReq, IGuildPreviewThumbReqCallback paramIGuildPreviewThumbReqCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.IGuildFileHandler
 * JD-Core Version:    0.7.0.1
 */