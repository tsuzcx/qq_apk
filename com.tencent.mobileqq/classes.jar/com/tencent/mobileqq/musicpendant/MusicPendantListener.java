package com.tencent.mobileqq.musicpendant;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.IQQPlayerCallback;

public abstract interface MusicPendantListener
  extends IQQPlayerCallback
{
  public abstract void a();
  
  public abstract void a(Card paramCard);
  
  public abstract void b(Card paramCard);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.musicpendant.MusicPendantListener
 * JD-Core Version:    0.7.0.1
 */