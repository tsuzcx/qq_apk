package com.tencent.mobileqq.tritonaudio.webaudio;

import java.util.ArrayList;

class WebAudioManager$DecodeAsPlayStatus
{
  public static final int STATUS_DECODE_DONE = 3;
  public static final int STATUS_DECODING_WITHOUT_SET_QUEUE = 1;
  public static final int STATUS_DECODING_WITH_ALREADY_SETTED_QUEUE = 2;
  public static final int STATUS_INIT = 0;
  private ArrayList<Integer> channelIdList = new ArrayList();
  private int decodeId = -1;
  private int status = 0;
  
  public WebAudioManager$DecodeAsPlayStatus(WebAudioManager paramWebAudioManager) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.DecodeAsPlayStatus
 * JD-Core Version:    0.7.0.1
 */