package com.tencent.qqpimsecure.wificore.api.connect;

public class a
{
  public a.b dt;
  public int du;
  
  public String toString()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.dt == a.b.dG)
    {
      localObject = a.c.k(this.du);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dt.toString());
      localStringBuilder.append(",原因:");
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    if (this.dt == a.b.dH)
    {
      localObject = a.d.l(this.du);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dt.toString());
      localStringBuilder.append(",原因:");
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    if (this.dt == a.b.dI)
    {
      localObject = a.a.j(this.du);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dt.toString());
      localStringBuilder.append(",原因:");
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    return this.dt.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.a
 * JD-Core Version:    0.7.0.1
 */