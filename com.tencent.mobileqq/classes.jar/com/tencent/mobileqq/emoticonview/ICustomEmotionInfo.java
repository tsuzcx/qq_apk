package com.tencent.mobileqq.emoticonview;

public abstract interface ICustomEmotionInfo
{
  public abstract int getEmoId();
  
  public abstract int getEmoType();
  
  public abstract String getPath();
  
  public abstract String getRoamingType();
  
  public abstract boolean isChecked();
  
  public abstract void setIsChecked(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ICustomEmotionInfo
 * JD-Core Version:    0.7.0.1
 */