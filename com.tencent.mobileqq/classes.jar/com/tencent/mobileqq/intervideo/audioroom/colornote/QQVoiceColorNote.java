package com.tencent.mobileqq.intervideo.audioroom.colornote;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;

public class QQVoiceColorNote
{
  public ColorNote mColorNote;
  
  public QQVoiceColorNote(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mColorNote = new ColorNote.Builder().d(paramString1).b(paramString2).c(paramString3).a(17301504).a(paramString4).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNote
 * JD-Core Version:    0.7.0.1
 */