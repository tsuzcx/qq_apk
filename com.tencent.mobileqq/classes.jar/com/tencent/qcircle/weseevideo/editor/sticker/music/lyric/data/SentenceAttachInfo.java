package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Color;

public class SentenceAttachInfo
{
  public Bitmap mBitmap;
  public int mPadding;
  public int mSentenceColor = Color.parseColor("#FFFF0000");
  
  public SentenceAttachInfo() {}
  
  public SentenceAttachInfo(SentenceAttachInfo paramSentenceAttachInfo)
  {
    this.mSentenceColor = paramSentenceAttachInfo.mSentenceColor;
    this.mBitmap = paramSentenceAttachInfo.mBitmap;
    this.mPadding = paramSentenceAttachInfo.mPadding;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.SentenceAttachInfo
 * JD-Core Version:    0.7.0.1
 */