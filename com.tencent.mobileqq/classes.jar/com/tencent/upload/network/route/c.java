package com.tencent.upload.network.route;

public abstract interface c
{
  public abstract UploadRoute a();
  
  public abstract UploadRoute a(UploadRoute paramUploadRoute, int paramInt);
  
  public abstract boolean a(UploadRoute paramUploadRoute);
  
  public static enum a
  {
    private final int g;
    private final int h;
    private final String i;
    
    private a(int paramInt1, int paramInt2, String paramString)
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.i = paramString;
    }
    
    public int a()
    {
      return this.g;
    }
    
    public String b()
    {
      return this.i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.route.c
 * JD-Core Version:    0.7.0.1
 */