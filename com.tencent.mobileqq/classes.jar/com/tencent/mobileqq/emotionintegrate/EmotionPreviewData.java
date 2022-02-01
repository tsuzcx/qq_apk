package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class EmotionPreviewData
{
  public MessageRecord a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public EmotionPreviewData(MessageRecord paramMessageRecord)
  {
    this.a = paramMessageRecord;
    this.b = (paramMessageRecord instanceof MessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionPreviewData
 * JD-Core Version:    0.7.0.1
 */