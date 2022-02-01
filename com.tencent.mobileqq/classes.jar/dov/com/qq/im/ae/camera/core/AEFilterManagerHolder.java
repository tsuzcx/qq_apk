package dov.com.qq.im.ae.camera.core;

import blnq;

public class AEFilterManagerHolder
{
  private static blnq instance;
  
  public static blnq getAEFilterManager()
  {
    return instance;
  }
  
  public static void setFilterProcess(blnq paramblnq)
  {
    instance = paramblnq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEFilterManagerHolder
 * JD-Core Version:    0.7.0.1
 */