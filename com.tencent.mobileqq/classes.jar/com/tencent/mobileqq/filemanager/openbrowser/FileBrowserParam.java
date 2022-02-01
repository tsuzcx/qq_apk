package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.filebrowser.IFileBrowserParam;

public class FileBrowserParam
  implements IFileBrowserParam
{
  private int a = 0;
  private String b = null;
  
  public int a()
  {
    return this.a;
  }
  
  public FileBrowserParam a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public FileBrowserParam a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam
 * JD-Core Version:    0.7.0.1
 */