package dov.com.qq.im.ae.camera.core;

import bnaz;

public class AEFilterManagerHolder
{
  private static bnaz instance;
  
  public static bnaz getAEFilterManager()
  {
    return instance;
  }
  
  public static void setFilterProcess(bnaz parambnaz)
  {
    instance = parambnaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEFilterManagerHolder
 * JD-Core Version:    0.7.0.1
 */