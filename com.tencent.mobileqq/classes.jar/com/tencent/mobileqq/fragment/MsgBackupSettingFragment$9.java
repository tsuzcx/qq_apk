package com.tencent.mobileqq.fragment;

import java.io.File;
import java.io.FileFilter;

class MsgBackupSettingFragment$9
  implements FileFilter
{
  MsgBackupSettingFragment$9(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean accept(File paramFile)
  {
    if (paramFile.getName().endsWith(".png")) {}
    while (paramFile.getName().endsWith(".jpg")) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */