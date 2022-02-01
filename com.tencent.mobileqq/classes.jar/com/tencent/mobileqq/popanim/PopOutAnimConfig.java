package com.tencent.mobileqq.popanim;

import android.graphics.Typeface;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;

public abstract class PopOutAnimConfig
{
  public boolean apngSoLoaded;
  public int[] itemCountRecShowAppear;
  public int[] itemCountShowAppear;
  public int maxSendCount;
  public boolean supportFeedBack;
  public Typeface typeface;
  
  public abstract void sendPopEmoMsg(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo, int paramInt);
  
  public abstract void startShakeAnimation();
  
  public abstract void stopShakeAnimation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutAnimConfig
 * JD-Core Version:    0.7.0.1
 */