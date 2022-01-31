package com.tencent.mobileqq.transfile.filebrowser;

import java.util.HashMap;
import java.util.Map;

public class MimeTypes
{
  private Map a = new HashMap();
  
  public String a(String paramString)
  {
    paramString = FileUtils.a(paramString);
    return (String)this.a.get(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.MimeTypes
 * JD-Core Version:    0.7.0.1
 */