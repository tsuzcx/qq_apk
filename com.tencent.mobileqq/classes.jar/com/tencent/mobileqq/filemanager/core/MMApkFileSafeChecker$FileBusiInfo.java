package com.tencent.mobileqq.filemanager.core;

import androidx.annotation.NonNull;

class MMApkFileSafeChecker$FileBusiInfo
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  String c = "";
  String d = "";
  String e = "";
  String f = "";
  String g = "";
  
  private MMApkFileSafeChecker$FileBusiInfo(MMApkFileSafeChecker paramMMApkFileSafeChecker) {}
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("busiType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" fileMd5:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" fileSha:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.FileBusiInfo
 * JD-Core Version:    0.7.0.1
 */