package com.tencent.mobileqq.utils;

import com.tencent.common.app.BaseApplicationImpl;

final class FileUtils$1
  implements Runnable
{
  public void run()
  {
    FileUtils.checkFolder(BaseApplicationImpl.sApplication, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */