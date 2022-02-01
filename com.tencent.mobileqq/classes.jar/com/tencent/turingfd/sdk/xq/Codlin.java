package com.tencent.turingfd.sdk.xq;

public class Codlin
{
  public boolean Ah;
  public int Bh;
  public long Ch;
  public long Dh;
  public long fg;
  
  public Codlin(Codlin.do paramdo)
  {
    this.fg = paramdo.fg;
    this.Ah = paramdo.Ah;
    this.Bh = paramdo.Bh;
    this.Ch = paramdo.Ch;
    this.Dh = paramdo.Dh;
  }
  
  public String y()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.fg);
    localStringBuilder.append("_");
    if (this.Ah) {}
    for (String str = "1";; str = "2")
    {
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(this.Bh);
      localStringBuilder.append("_");
      localStringBuilder.append(this.Ch);
      localStringBuilder.append("_");
      localStringBuilder.append(this.Dh);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Codlin
 * JD-Core Version:    0.7.0.1
 */