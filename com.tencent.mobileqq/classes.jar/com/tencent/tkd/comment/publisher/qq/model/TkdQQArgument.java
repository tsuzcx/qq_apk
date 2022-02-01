package com.tencent.tkd.comment.publisher.qq.model;

public class TkdQQArgument
{
  public static final int ACTION_CLICK_AT = 2;
  public static final int ACTION_SHOW_EMOTION_PANEL = 1;
  public static final int ACTION_SHOW_SOFTINPUT = 0;
  public CharSequence defaultTxt;
  public int firstAction = 0;
  public boolean forceHideAt;
  public boolean forceHideTopic;
  public int maxCharCount;
  public String placeHolder;
  public boolean showGif;
  public boolean showLink;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TkdQQArgument{defaultTxt=");
    localStringBuilder.append(this.defaultTxt);
    localStringBuilder.append(", placeHolder='");
    localStringBuilder.append(this.placeHolder);
    localStringBuilder.append('\'');
    localStringBuilder.append(", maxCharCount=");
    localStringBuilder.append(this.maxCharCount);
    localStringBuilder.append(", showGif=");
    localStringBuilder.append(this.showGif);
    localStringBuilder.append(", showLink=");
    localStringBuilder.append(this.showLink);
    localStringBuilder.append(", forceHideTopic=");
    localStringBuilder.append(this.forceHideTopic);
    localStringBuilder.append(", forceHideAt=");
    localStringBuilder.append(this.forceHideAt);
    localStringBuilder.append(", firstAction=");
    localStringBuilder.append(this.firstAction);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument
 * JD-Core Version:    0.7.0.1
 */