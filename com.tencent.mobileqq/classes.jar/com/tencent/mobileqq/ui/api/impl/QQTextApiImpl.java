package com.tencent.mobileqq.ui.api.impl;

import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.ui.api.IQQTextApi;

public class QQTextApiImpl
  implements IQQTextApi
{
  public CharSequence buildQQText(CharSequence paramCharSequence)
  {
    return new QQText(paramCharSequence, 3, 16);
  }
  
  public int getEmojiTypeEmoji()
  {
    return 0;
  }
  
  public int getEmojiTypeSmall()
  {
    return 2;
  }
  
  public int getEmojiTypeSystem()
  {
    return 1;
  }
  
  public int getGrabEmotcation()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ui.api.impl.QQTextApiImpl
 * JD-Core Version:    0.7.0.1
 */