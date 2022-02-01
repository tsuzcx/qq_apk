package com.tencent.mobileqq.shortvideo;

class ShortVideoSoManager$CfgParser
{
  private String a;
  private String[] b;
  
  ShortVideoSoManager$CfgParser(String paramString)
  {
    this.a = paramString;
  }
  
  int a(char paramChar)
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
  
  String a()
  {
    return this.b[0].trim();
  }
  
  String b()
  {
    return this.b[1].trim();
  }
  
  String c()
  {
    return this.b[0].trim();
  }
  
  String d()
  {
    return this.b[1].trim();
  }
  
  int e()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoManager.CfgParser
 * JD-Core Version:    0.7.0.1
 */