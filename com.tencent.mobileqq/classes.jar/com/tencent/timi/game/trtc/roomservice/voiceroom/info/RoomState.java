package com.tencent.timi.game.trtc.roomservice.voiceroom.info;

public class RoomState
{
  public int a = 4;
  
  public String a()
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return "未连接";
        }
        return "重连中";
      }
      return "断线";
    }
    return "正常";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState
 * JD-Core Version:    0.7.0.1
 */