package com.tencent.mobileqq.flutter.channel.expand.chat;

import com.tencent.mobileqq.flutter.channel.expand.JsonBean;
import java.util.List;

public class ExpandConverListResponse
  extends JsonBean
{
  public List<ExpandConversation> conversations;
  public String cursor;
  public boolean finishFlag;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandConverListResponse
 * JD-Core Version:    0.7.0.1
 */