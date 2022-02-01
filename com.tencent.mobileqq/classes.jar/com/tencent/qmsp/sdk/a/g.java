package com.tencent.qmsp.sdk.a;

public class g
{
  private StringBuilder a;
  private boolean b;
  
  public g()
  {
    a();
  }
  
  private void b()
  {
    b(",");
  }
  
  private void b(String paramString)
  {
    if (this.b) {
      this.a.append(paramString);
    }
    this.b = true;
  }
  
  public g a()
  {
    this.a = new StringBuilder();
    this.b = false;
    return this;
  }
  
  public g a(int paramInt)
  {
    return a(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public g a(String paramString)
  {
    b();
    paramString = paramString.replace(',', ';');
    this.a.append(paramString);
    return this;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.a.g
 * JD-Core Version:    0.7.0.1
 */