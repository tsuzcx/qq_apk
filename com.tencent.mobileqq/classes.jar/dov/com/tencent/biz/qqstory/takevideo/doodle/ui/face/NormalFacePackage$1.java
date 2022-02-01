package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import java.io.File;
import java.io.FileFilter;

class NormalFacePackage$1
  implements FileFilter
{
  NormalFacePackage$1(NormalFacePackage paramNormalFacePackage) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp")) || (paramFile.endsWith(".apng")) || (paramFile.endsWith(".gif"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage.1
 * JD-Core Version:    0.7.0.1
 */