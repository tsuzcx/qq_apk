package com.tencent.mobileqq.uniformdownload.filemanager;

public class LocalTbsViewManager
{
  private static LocalTbsViewManager a = null;
  
  public static LocalTbsViewManager a()
  {
    if (a == null) {
      a = new LocalTbsViewManager();
    }
    return a;
  }
  
  public void a(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.filemanager.LocalTbsViewManager
 * JD-Core Version:    0.7.0.1
 */