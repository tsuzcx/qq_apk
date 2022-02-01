package org.xwalk.core;

public abstract class XWalkUpdater$EmbededUpdateConfig
  extends XWalkUpdater.UpdateConfig
{
  boolean isCopySuc = false;
  
  public XWalkUpdater$EmbededUpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    super("", false, paramInt, XWalkEnvironment.getRuntimeAbi(), 0);
  }
  
  public boolean checkValid()
  {
    return this.apkVer > 0;
  }
  
  public abstract boolean copyPackageToLocal(String paramString1, String paramString2);
  
  public boolean copySuc()
  {
    return this.isCopySuc;
  }
  
  public String getDownloadPath()
  {
    return super.getDownloadPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.EmbededUpdateConfig
 * JD-Core Version:    0.7.0.1
 */