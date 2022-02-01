package com.tencent.mobileqq.hiboom;

import java.io.Serializable;

public class FontBubble
  implements Serializable
{
  public static final int TYPE_ACTIVITY = 6;
  public static final int TYPE_FREE = 1;
  public static final int TYPE_FREE0 = 0;
  public static final int TYPE_SVIP = 5;
  public static final int TYPE_VIP = 4;
  public static final int TYPE_YEAR_SVIP = 22;
  public static final int TYPE_YEAR_VIP = 21;
  public String btn;
  public int bubbleId;
  public int engine;
  public int feeType;
  public int fontId;
  public String msg;
  public String name;
  public int panelType;
  public String payUrl;
  public String picUrl;
  public String title;
  public int viewType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FontBubble{viewType=");
    localStringBuilder.append(this.viewType);
    localStringBuilder.append(", fontId=");
    localStringBuilder.append(this.fontId);
    localStringBuilder.append(", bubbleId=");
    localStringBuilder.append(this.bubbleId);
    localStringBuilder.append(", engine=");
    localStringBuilder.append(this.engine);
    localStringBuilder.append(", feeType=");
    localStringBuilder.append(this.feeType);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.msg);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubble
 * JD-Core Version:    0.7.0.1
 */