package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.Emoticon;

public class PicEmoticonInfoConstant
{
  public static String getFictionPath(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEmoticon.epId);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEmoticon.eId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfoConstant
 * JD-Core Version:    0.7.0.1
 */