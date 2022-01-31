package com.tencent.ttpic.model;

public class Audio2Text
{
  public static final int MODE_FIFO = 2;
  public static final int MODE_LOOP_REPLACE = 1;
  public int segmentCount;
  public double segmentTime;
  public int sentenceCount;
  public int sentenceMode = 2;
  public double silenceTime;
  public String triggerWords;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.Audio2Text
 * JD-Core Version:    0.7.0.1
 */