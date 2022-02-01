package com.tencent.trtc;

import org.json.JSONObject;

class TRTCSubCloud$8
  implements Runnable
{
  TRTCSubCloud$8(TRTCSubCloud paramTRTCSubCloud, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject3 = new JSONObject(this.a);
      if (!((JSONObject)localObject3).has("api"))
      {
        localObject1 = this.b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("callExperimentalAPI[lack api or illegal type]: ");
        ((StringBuilder)localObject2).append(this.a);
        TRTCSubCloud.access$6900((TRTCSubCloud)localObject1, ((StringBuilder)localObject2).toString());
        return;
      }
      localObject2 = ((JSONObject)localObject3).getString("api");
      localObject1 = null;
      if (((JSONObject)localObject3).has("params")) {
        localObject1 = ((JSONObject)localObject3).getJSONObject("params");
      }
      if (((String)localObject2).equals("setSEIPayloadType"))
      {
        TRTCSubCloud.access$7000(this.b, (JSONObject)localObject1);
        return;
      }
      if (((String)localObject2).equals("setLocalAudioMuteMode")) {
        return;
      }
      if (((String)localObject2).equals("setVideoEncodeParamEx")) {
        return;
      }
      if (((String)localObject2).equals("setAudioSampleRate")) {
        return;
      }
      if (((String)localObject2).equals("muteRemoteAudioInSpeaker"))
      {
        TRTCSubCloud.access$7100(this.b, (JSONObject)localObject1);
        return;
      }
      if (((String)localObject2).equals("enableAudioAGC")) {
        return;
      }
      if (((String)localObject2).equals("enableAudioAEC")) {
        return;
      }
      if (((String)localObject2).equals("enableAudioANS")) {
        return;
      }
      if (((String)localObject2).equals("setPerformanceMode"))
      {
        TRTCSubCloud.access$7200(this.b, (JSONObject)localObject1);
        return;
      }
      if (((String)localObject2).equals("setCustomRenderMode")) {
        return;
      }
      if (((String)localObject2).equals("setMediaCodecConfig")) {
        return;
      }
      if (((String)localObject2).equals("sendJsonCMD"))
      {
        TRTCSubCloud.access$7300(this.b, (JSONObject)localObject1, this.a);
        return;
      }
      if (((String)localObject2).equals("updatePrivateMapKey"))
      {
        TRTCSubCloud.access$7400(this.b, (JSONObject)localObject1);
        return;
      }
      localObject1 = this.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("callExperimentalAPI[illegal api]: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      TRTCSubCloud.access$7500((TRTCSubCloud)localObject1, ((StringBuilder)localObject3).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      label293:
      break label293;
    }
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("callExperimentalAPI[failed]: ");
    ((StringBuilder)localObject2).append(this.a);
    TRTCSubCloud.access$7600((TRTCSubCloud)localObject1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.8
 * JD-Core Version:    0.7.0.1
 */