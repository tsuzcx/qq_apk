package com.tencent.qqlive.tvkplayer.vinfo;

import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKPlayerCommonEnum;

class TVKPlaybackInfo$PlayerInfo
{
  private int audioDecoderType = TVKPlayerCommonEnum.PLAYER_DECODER_UNKNOWN;
  private boolean dumped;
  private int playerType = 0;
  private int videoDecoderType = TVKPlayerCommonEnum.PLAYER_DECODER_UNKNOWN;
  
  int audioDecoderType()
  {
    return this.audioDecoderType;
  }
  
  void audioDecoderType(int paramInt)
  {
    this.audioDecoderType = paramInt;
  }
  
  void dumped(boolean paramBoolean)
  {
    this.dumped = paramBoolean;
  }
  
  boolean dumped()
  {
    return this.dumped;
  }
  
  int playerType()
  {
    return this.playerType;
  }
  
  void playerType(int paramInt)
  {
    this.playerType = paramInt;
  }
  
  int videoDecoderType()
  {
    return this.videoDecoderType;
  }
  
  void videoDecoderType(int paramInt)
  {
    this.videoDecoderType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.PlayerInfo
 * JD-Core Version:    0.7.0.1
 */