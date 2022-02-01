package org.light;

public enum Config$ConfigKeys
{
  ResourceDir("resource_dir");
  
  public String val;
  
  private Config$ConfigKeys(String paramString)
  {
    this.val = paramString;
  }
  
  public String value()
  {
    return this.val;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.Config.ConfigKeys
 * JD-Core Version:    0.7.0.1
 */