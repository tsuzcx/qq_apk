package com.tencent.smtt.utils;

class TbsCopyVerify$FileInfo
{
  private long mFileSize;
  private long mLastModify;
  private String mName;
  
  TbsCopyVerify$FileInfo(TbsCopyVerify paramTbsCopyVerify, String paramString, long paramLong1, long paramLong2)
  {
    this.mName = paramString;
    this.mFileSize = paramLong1;
    this.mLastModify = paramLong2;
  }
  
  long getFileSize()
  {
    return this.mFileSize;
  }
  
  long getLastModify()
  {
    return this.mLastModify;
  }
  
  String getName()
  {
    return this.mName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCopyVerify.FileInfo
 * JD-Core Version:    0.7.0.1
 */