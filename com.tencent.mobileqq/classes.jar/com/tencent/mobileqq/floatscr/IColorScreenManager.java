package com.tencent.mobileqq.floatscr;

import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import java.io.File;

public abstract interface IColorScreenManager
{
  public abstract int a(String paramString);
  
  public abstract File a(int paramInt);
  
  public abstract void a(int paramInt, VasManager.CompleteListener<ColorScreenConfig> paramCompleteListener);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract void c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.floatscr.IColorScreenManager
 * JD-Core Version:    0.7.0.1
 */