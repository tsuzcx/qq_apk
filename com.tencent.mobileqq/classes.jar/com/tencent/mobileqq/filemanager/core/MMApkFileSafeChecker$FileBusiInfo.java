package com.tencent.mobileqq.filemanager.core;

import androidx.annotation.NonNull;

class MMApkFileSafeChecker$FileBusiInfo
{
  int a = 0;
  String b = "";
  String c = "";
  String d = "";
  String e = "";
  String f = "";
  String g = "";
  String h = "";
  
  private MMApkFileSafeChecker$FileBusiInfo(MMApkFileSafeChecker paramMMApkFileSafeChecker) {}
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("busiType:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" fileMd5:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" fileSha:");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.FileBusiInfo
 * JD-Core Version:    0.7.0.1
 */