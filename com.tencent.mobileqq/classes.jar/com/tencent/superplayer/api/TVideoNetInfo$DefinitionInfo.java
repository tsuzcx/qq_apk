package com.tencent.superplayer.api;

public class TVideoNetInfo$DefinitionInfo
  implements Cloneable
{
  private String mDefn = "";
  private String mDefnName = "";
  private String mDefnRate = "";
  private String mDefnShowName = "";
  
  public TVideoNetInfo$DefinitionInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mDefn = paramString1;
    this.mDefnName = paramString2;
    this.mDefnRate = paramString3;
    this.mDefnShowName = paramString4;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public String getDefn()
  {
    return this.mDefn;
  }
  
  public String getDefnName()
  {
    return this.mDefnName;
  }
  
  public String getDefnRate()
  {
    return this.mDefnRate;
  }
  
  public String getDefnShowName()
  {
    return this.mDefnShowName;
  }
  
  public void setDefn(String paramString)
  {
    this.mDefn = paramString;
  }
  
  public void setDefnName(String paramString)
  {
    this.mDefnName = paramString;
  }
  
  public void setDefnRate(String paramString)
  {
    this.mDefnRate = paramString;
  }
  
  public void setDefnShowName(String paramString)
  {
    this.mDefnShowName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo
 * JD-Core Version:    0.7.0.1
 */