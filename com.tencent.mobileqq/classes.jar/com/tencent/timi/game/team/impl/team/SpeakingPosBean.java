package com.tencent.timi.game.team.impl.team;

import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

public class SpeakingPosBean
{
  private YoloRoomOuterClass.YoloRoomSpeakingPosInfo a;
  private String b;
  
  public SpeakingPosBean(YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, String paramString)
  {
    this.a = paramYoloRoomSpeakingPosInfo;
    this.b = paramString;
  }
  
  public YoloRoomOuterClass.YoloRoomSpeakingPosInfo a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.SpeakingPosBean
 * JD-Core Version:    0.7.0.1
 */