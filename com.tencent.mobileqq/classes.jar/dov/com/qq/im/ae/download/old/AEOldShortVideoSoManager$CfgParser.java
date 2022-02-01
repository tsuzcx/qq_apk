package dov.com.qq.im.ae.download.old;

public class AEOldShortVideoSoManager$CfgParser
{
  private String a;
  private String[] b;
  
  AEOldShortVideoSoManager$CfgParser(String paramString)
  {
    this.a = paramString;
  }
  
  public int a(char paramChar)
  {
    Object localObject = this.a;
    if ((localObject != null) && (!"".equals(localObject)))
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\");
      localStringBuilder.append(paramChar);
      this.b = ((String)localObject).split(localStringBuilder.toString());
      localObject = this.b;
      if (localObject == null) {
        return -1;
      }
      if (localObject.length < 2) {
        return -2;
      }
      return 0;
    }
    return -3;
  }
  
  public String a()
  {
    return this.b[1].trim();
  }
  
  public String b()
  {
    return this.b[0].trim();
  }
  
  public String c()
  {
    return this.b[1].trim();
  }
  
  public int d()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!"".equals(localObject)))
    {
      this.b = this.a.split("\\_");
      localObject = this.b;
      if (localObject == null) {
        return -1;
      }
      if (localObject.length < 2) {
        return -2;
      }
      return 0;
    }
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoSoManager.CfgParser
 * JD-Core Version:    0.7.0.1
 */