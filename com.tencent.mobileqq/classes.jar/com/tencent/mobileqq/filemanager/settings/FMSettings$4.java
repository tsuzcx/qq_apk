package com.tencent.mobileqq.filemanager.settings;

import java.io.File;

class FMSettings$4
  implements Runnable
{
  FMSettings$4(FMSettings paramFMSettings, String paramString, File paramFile, int paramInt, FMSettingInterface.MoveFileCallback paramMoveFileCallback) {}
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    FMSettings.a(this.this$0, localFile, this.jdField_a_of_type_JavaIoFile, new FMSettings.4.1(this));
    localFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.4
 * JD-Core Version:    0.7.0.1
 */