package com.tencent.qgplayer.rtmpsdk;

public class QGAVProfile
{
  public int audioBitrate;
  public int audioBufferSize;
  public String cpuUsage;
  public float downloadSpeed;
  public float firstVideoDelay;
  public int fps;
  public boolean isAudioHWDecoder;
  public boolean isH265;
  public boolean isVideoHwDecoder;
  public int resolution_x;
  public int resolution_y;
  public String serverIp;
  public int videoBitrate;
  public int videoBufferSize;
  
  public String toString()
  {
    return "QGAVProfile{isVideoHwDecoder=" + this.isVideoHwDecoder + ", isAudioHWDecoder=" + this.isAudioHWDecoder + ", cpuUsage=" + this.cpuUsage + ", fps=" + this.fps + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", resolution_x=" + this.resolution_x + ", resolution_y=" + this.resolution_y + ", firstVideoDelay=" + this.firstVideoDelay + ", videoBufferSize=" + this.videoBufferSize + ", audioBufferSize=" + this.audioBufferSize + ", downloadSpeed=" + this.downloadSpeed + ", isH265=" + this.isH265 + ", serverIp='" + this.serverIp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGAVProfile
 * JD-Core Version:    0.7.0.1
 */