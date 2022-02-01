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
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof EmotionPanelInfo)) {
      return false;
    }
    paramObject = (EmotionPanelInfo)paramObject;
    if ((this.type == paramObject.type) && (this.columnNum == paramObject.columnNum))
    {
      if ((this.emotionPkg == null) && (paramObject.emotionPkg == null)) {
        return true;
      }
      EmoticonPackage localEmoticonPackage = this.emotionPkg;
      if ((localEmoticonPackage != null) && (paramObject.emotionPkg != null) && (localEmoticonPackage.epId != null) && (this.emotionPkg.epId.equals(paramObject.emotionPkg.epId))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    Object localObject = this.emotionPkg;
    if (localObject != null) {
      localObject = ((EmoticonPackage)localObject).epId;
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmotionPanelInfo [type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", columnNum=");
    localStringBuilder.append(this.columnNum);
    localStringBuilder.append(", epid=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelInfo
 * JD-Core Version:    0.7.0.1
 */