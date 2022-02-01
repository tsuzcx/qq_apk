package com.tencent.mobileqq.fts.v1;

public class FTSQueryArgs
{
  public String a = null;
  public String[] b = new String[0];
  public boolean c = false;
  public boolean d = false;
  public int e = 0;
  public int f = -1;
  public String g = null;
  public String h = null;
  public int i = 0;
  
  public FTSQueryArgs(String paramString, Class<? extends FTSEntity> paramClass, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    this.a = paramString;
    this.h = paramClass.getName().replace('.', '/');
    this.b = paramArrayOfString;
    this.c = paramBoolean;
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v1.FTSQueryArgs
 * JD-Core Version:    0.7.0.1
 */