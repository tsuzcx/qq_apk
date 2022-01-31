package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;

class ApkgManager$7$ApkgUnpackFileInfo
{
  public String fileContent;
  public String filename;
  public int length;
  public int offset;
  
  ApkgManager$7$ApkgUnpackFileInfo(ApkgManager.7 param7) {}
  
  public boolean isCompleted()
  {
    return !TextUtils.isEmpty(this.fileContent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.7.ApkgUnpackFileInfo
 * JD-Core Version:    0.7.0.1
 */