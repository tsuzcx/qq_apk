package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmoticonPackage;

public class EmotionPanelInfo
{
  public int columnNum;
  public EmoticonPackage emotionPkg;
  public int type;
  
  public EmotionPanelInfo(int paramInt1, int paramInt2, EmoticonPackage paramEmoticonPackage)
  {
    this.type = paramInt1;
    this.columnNum = paramInt2;
    this.emotionPkg = paramEmoticonPackage;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof EmotionPanelInfo)) {
        return false;
      }
      paramObject = (EmotionPanelInfo)paramObject;
      if ((this.type != paramObject.type) || (this.columnNum != paramObject.columnNum)) {
        break;
      }
    } while (((this.emotionPkg == null) && (paramObject.emotionPkg == null)) || ((this.emotionPkg != null) && (paramObject.emotionPkg != null) && (this.emotionPkg.epId != null) && (this.emotionPkg.epId.equals(paramObject.emotionPkg.epId))));
    return false;
    return false;
  }
  
  public String toString()
  {
    String str = "";
    if (this.emotionPkg != null) {
      str = this.emotionPkg.epId;
    }
    return "EmotionPanelInfo [type=" + this.type + ", columnNum=" + this.columnNum + ", epid=" + str + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelInfo
 * JD-Core Version:    0.7.0.1
 */