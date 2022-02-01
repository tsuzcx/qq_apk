package com.tencent.trtc;

import org.json.JSONObject;

class TRTCSubCloud$8
  implements Runnable
{
  TRTCSubCloud$8(TRTCSubCloud paramTRTCSubCloud, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (this.a.equals("setSEIPayloadType"))
      {
        TRTCSubCloud.access$7100(this.d, this.b);
        return;
      }
      if (this.a.equals("setLocalAudioMuteMode")) {
        return;
      }
      if (this.a.equals("setVideoEncodeParamEx")) {
        return;
      }
      if (this.a.equals("setAudioSampleRate")) {
        return;
      }
      if (this.a.equals("muteRemoteAudioInSpeaker"))
      {
        TRTCSubCloud.access$7200(this.d, this.b);
        return;
      }
      if (this.a.equals("enableAudioAGC")) {
        return;
      }
      if (this.a.equals("enableAudioAEC")) {
        return;
      }
      if (this.a.equals("enableAudioANS")) {
        return;
      }
      if (this.a.equals("setPerformanceMode"))
      {
        TRTCSubCloud.access$7300(this.d, this.b);
        return;
      }
      if (this.a.equals("setCustomRenderMode")) {
        return;
      }
      if (this.a.equals("setMediaCodecConfig")) {
        return;
      }
      if (this.a.equals("setKeepAVCaptureOption")) {
        return;
      }
      if (this.a.equals("sendJsonCMD"))
      {
        TRTCSubCloud.access$7400(this.d, this.b, this.c);
        return;
      }
      if (this.a.equals("updatePrivateMapKey"))
      {
        TRTCSubCloud.access$7500(this.d, this.b);
        return;
      }
      if (this.a.equals("setRoomType"))
      {
        TRTCSubCloud.access$7600(this.d, this.b);
        return;
      }
      localTRTCSubCloud = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("callExperimentalAPI[illegal api]: ");
      localStringBuilder.append(this.a);
      TRTCSubCloud.access$7700(localTRTCSubCloud, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      TRTCSubCloud localTRTCSubCloud;
      StringBuilder localStringBuilder;
      label303:
      break label303;
    }
    localTRTCSubCloud = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("callExperimentalAPI[failed]: ");
    localStringBuilder.append(this.c);
    TRTCSubCloud.access$7800(localTRTCSubCloud, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.8
 * JD-Core Version:    0.7.0.1
 */