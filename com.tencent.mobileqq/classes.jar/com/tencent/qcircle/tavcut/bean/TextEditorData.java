package com.tencent.qcircle.tavcut.bean;

import java.util.HashMap;
import java.util.Map;

public class TextEditorData
{
  public static final String BACKGROUND = "bgcolor";
  private String blurTextPath;
  private String blurTexturePath;
  private Map<String, Integer> colorList = new HashMap();
  private String content;
  private String fontPath;
  private String interactive = "0";
  private String itemID;
  private String pagFilePath;
  private String stickerType;
  private int textColor;
  private int type;
  private String uniqueID;
  
  public TextEditorData() {}
  
  public TextEditorData(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    this.uniqueID = paramString1;
    this.itemID = paramString2;
    this.textColor = paramInt1;
    this.content = paramString3;
    this.pagFilePath = paramString4;
    this.fontPath = paramString5;
    this.colorList.put("bgcolor", Integer.valueOf(paramInt2));
  }
  
  public String getBlurTextPath()
  {
    return this.blurTextPath;
  }
  
  public String getBlurTexturePath()
  {
    return this.blurTexturePath;
  }
  
  public Map<String, Integer> getColorList()
  {
    return this.colorList;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getFontPath()
  {
    return this.fontPath;
  }
  
  public String getInteractive()
  {
    return this.interactive;
  }
  
  public String getItemID()
  {
    return this.itemID;
  }
  
  public String getPagFilePath()
  {
    return this.pagFilePath;
  }
  
  public String getStickerType()
  {
    return this.stickerType;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUniqueID()
  {
    return this.uniqueID;
  }
  
  public void setBackGroundColor(String paramString, int paramInt)
  {
    this.colorList.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void setBlurTextPath(String paramString)
  {
    this.blurTextPath = paramString;
  }
  
  public void setBlurTexturePath(String paramString)
  {
    this.blurTexturePath = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setFont(String paramString)
  {
    this.fontPath = paramString;
  }
  
  public void setInteractive(String paramString)
  {
    this.interactive = paramString;
  }
  
  public void setItemID(String paramString)
  {
    this.itemID = paramString;
  }
  
  public void setPagFilePath(String paramString)
  {
    this.pagFilePath = paramString;
  }
  
  public void setStickerType(String paramString)
  {
    this.stickerType = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUniqueID(String paramString)
  {
    this.uniqueID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.bean.TextEditorData
 * JD-Core Version:    0.7.0.1
 */