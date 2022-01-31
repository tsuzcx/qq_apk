package com.tencent.upload.utils;

public class FileUtils$UploaderMD5
{
  public static final int FAKE_FILE_MD5 = 0;
  public static final int REAL_FILE_MD5 = 1;
  public static final int REAL_SHA = 2;
  int type = 0;
  String value = "";
  
  public FileUtils$UploaderMD5(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.value = paramString;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.FileUtils.UploaderMD5
 * JD-Core Version:    0.7.0.1
 */