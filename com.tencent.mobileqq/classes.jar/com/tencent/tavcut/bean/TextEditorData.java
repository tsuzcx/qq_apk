package com.tencent.tavcut.bean;

public class TextEditorData
{
  private String content;
  private String stickerId;
  private int textColor;
  
  public TextEditorData(String paramString1, int paramInt, String paramString2)
  {
    this.stickerId = paramString1;
    this.textColor = paramInt;
    this.content = paramString2;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getStickerId()
  {
    return this.stickerId;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setStickerId(String paramString)
  {
    this.stickerId = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.bean.TextEditorData
 * JD-Core Version:    0.7.0.1
 */