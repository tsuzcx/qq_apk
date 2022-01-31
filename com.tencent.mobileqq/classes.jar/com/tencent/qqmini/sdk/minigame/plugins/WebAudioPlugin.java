package com.tencent.qqmini.sdk.minigame.plugins;

import android.os.Build.VERSION;
import bgho;
import bgkd;
import bgki;
import bglb;
import bgtj;
import bgwc;
import bgwp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAudioPlugin
  extends BaseJsPlugin
{
  public static final String API_CLOSE_WEB_AUDIO_CONTEXT = "closeWebAudioContext";
  public static final String API_COPY_FROM_CHANNEL = "audioBufferCopyFromChannel";
  public static final String API_COPY_TO_CHANNEL = "audioBufferCopyToChannel";
  public static final String API_CREATE_AUDIO_CONTEXT = "createWebAudioContext";
  public static final String API_CREATE_BUFFER = "createWebAudioContextBuffer";
  public static final String API_CREATE_BUFFER_SOURCE = "createWebAudioBufferSource";
  public static final String API_CREATE_GAIN = "createWebAudioGain";
  public static final String API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR = "createWebAudioScriptProcessor";
  public static final String API_DECODE_AUDIO_DATA = "decodeWebAudioData";
  public static final String API_GET_BUFFTER_CHANNEL_DATA = "getWebAudioBufferChannelData";
  public static final String API_GET_CURRENT_GAIN = "getWebAudioCurrentGain";
  public static final String API_GET_WEBAUDIO_SAMPLE_RATE = "getWebAudioSampleRate";
  public static final String API_GET_WEB_AUDIO_CURRENT_TIME = "getWebAudioCurrentTime";
  public static final String API_GET_WEB_AUDIO_DESTINATION = "getWebAudioDestination";
  public static final String API_ON_DECODE_AUDIO_DATA_DONE = "onDecodeWebAudioDataDone";
  public static final String API_ON_SOURCE_ENDED = "onWebAudioSourceEnded";
  public static final String API_ON_WEB_AUDIO_SCRIPT_PROCESSOR = "onWebAudioScriptProcessorAudioProcess";
  public static final String API_OPERATE_WEB_AUDIO_CONTEXT = "operateWebAudioContext";
  public static final String API_SET_BUFFER_SOURCE_LOOP = "setWebAudioBufferSourceLoop";
  public static final String API_SET_CURRENT_GAIN = "setWebAudioCurrentGain";
  public static final String API_SET_QUEUE_BUFFER = "audioProcessingEventSetQueueBuffer";
  public static final String API_SET_SOURCE_BUFFER = "setWebAudioSourceBuffer";
  public static final String API_SOURCE_START = "sourceStart";
  public static final String API_SOURCE_STOP = "sourceStop";
  public static final String API_WEB_AUDIO_CONNECT_AUDIO_NODE = "webAudioConnectAudioNode";
  private static final String TAG = "WebAudioPlugin";
  private ITTEngine mTTEngine;
  private bgwp mWebAudioManager;
  private AtomicInteger sId = new AtomicInteger();
  
  public String audioBufferCopyFromChannel(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    return "{}";
  }
  
  public String audioBufferCopyToChannel(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).optInt("sourceId", -1);
      int k = ((JSONObject)localObject).getInt("channelId");
      int m = ((JSONObject)localObject).optInt("startInChannel", 0);
      localObject = bglb.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((bglb)localObject).jdField_a_of_type_ArrayOfByte;
        if ((localObject != null) && (localObject.length != 0))
        {
          bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL data.length " + localObject.length);
          i = bgwp.a().a((byte[])localObject, i, j, k, m);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("bufferId", i);
          bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL newBufferId: " + i);
          parambgkd = bgki.a(parambgkd.a, (JSONObject)localObject).toString();
          return parambgkd;
        }
      }
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
    }
    return "{}";
  }
  
  public String audioProcessingEventSetQueueBuffer(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      parambgkd = new JSONObject(parambgkd.b);
      int i = parambgkd.optInt("channelId", -2);
      int j = parambgkd.optInt("bufferId");
      bgwp.a().a(i, j);
      return "{}";
    }
    catch (JSONException parambgkd)
    {
      for (;;)
      {
        parambgkd.printStackTrace();
      }
    }
  }
  
  public String closeWebAudioContext(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambgkd.b).getInt("audioId");
      bgwp.a().a(i);
      parambgkd = bgki.a(parambgkd.a, null).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_CLOSE_WEB_AUDIO_CONTEXT error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioBufferSource(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambgkd.b).getInt("audioId");
      JSONObject localJSONObject = bgwp.a().a(i);
      parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioContext(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    JSONObject localJSONObject = bgwp.a().a(parambgkd.b);
    return bgki.a(parambgkd.a, localJSONObject).toString();
  }
  
  public String createWebAudioContextBuffer(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.optInt("numOfChannels", 1);
      int j = localJSONObject.optInt("length");
      int k = localJSONObject.optInt("sampleRate");
      int m = localJSONObject.getInt("audioId");
      localJSONObject = bgwp.a().a(m, i, j, k);
      parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioGain(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 5);
      localJSONObject.put("channelId", -1);
      parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_CREATE_GAIN error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioScriptProcessor(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.optInt("bufferSize");
      int j = localJSONObject.optInt("inputChannelNum");
      int k = localJSONObject.optInt("outputChannelNum");
      int m = localJSONObject.getInt("audioId");
      bgwp.a().a(parambgkd, m, i, j, k);
      return "{}";
    }
    catch (JSONException parambgkd)
    {
      for (;;)
      {
        parambgkd.printStackTrace();
      }
    }
  }
  
  public String decodeWebAudioData(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      int i = this.sId.incrementAndGet();
      localObject = bglb.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((bglb)localObject).jdField_a_of_type_ArrayOfByte;
        if (Build.VERSION.SDK_INT >= 16) {
          bgwp.a().a(i, (byte[])localObject, parambgkd);
        }
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("decodeId", i);
      parambgkd = bgki.a(parambgkd.a, (JSONObject)localObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioBufferChannelData(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).getInt("channelId");
      localObject = bgwp.a().a(i, j);
      JSONObject localJSONObject = new JSONObject();
      bglb.a(this.mMiniAppContext, (byte[])localObject, bglb.jdField_a_of_type_Int, "data", localJSONObject);
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA data.length " + localObject.length);
      parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentGain(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      parambgkd = new JSONObject(parambgkd.b);
      int i = parambgkd.getInt("channelId");
      int j = parambgkd.getInt("audioId");
      parambgkd = bgwp.a().a(j, i) + "";
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentTime(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambgkd.b).getInt("audioId");
      parambgkd = bgwp.a().a(i) + "";
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioDestination(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 4);
      parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public void onCreate(bgho parambgho)
  {
    super.onCreate(parambgho);
    if ((this.mMiniAppContext instanceof bgtj)) {
      this.mTTEngine = ((bgtj)this.mMiniAppContext).a();
    }
    bgwp.a().a(this.mTTEngine);
  }
  
  public String operateWebAudioContext(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      parambgkd = new JSONObject(parambgkd.b).getString("operationType");
      if (parambgkd.equals("suspend")) {
        bgwp.a().c(this.mTTEngine);
      }
      for (;;)
      {
        return "{}";
        if (parambgkd.equals("resume")) {
          bgwp.a().d(this.mTTEngine);
        }
      }
    }
    catch (Throwable parambgkd)
    {
      for (;;)
      {
        bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_OPERATE_WEB_AUDIO_CONTEXT error " + parambgkd.getMessage());
      }
    }
  }
  
  public String setWebAudioBufferSourceLoop(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      boolean bool = localJSONObject.getBoolean("loop");
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.getInt("audioId");
      bgwp.a().a(j, i, bool);
      parambgkd = bgki.a(parambgkd.a, null).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioCurrentGain(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.getInt("channelId");
      double d = localJSONObject.getDouble("data");
      int j = localJSONObject.getInt("audioId");
      bgwp.a().a(j, i, d);
      parambgkd = bgki.a(parambgkd.a, null).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioSourceBuffer(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.optInt("bufferId", -1);
      int k = localJSONObject.optInt("decodeId", -1);
      if (j != -1)
      {
        localJSONObject = bgwp.a().a(i, j);
        return bgki.a(parambgkd.a, localJSONObject).toString();
      }
      if (k != -1)
      {
        localJSONObject = bgwp.a().b(i, k);
        parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
        return parambgkd;
      }
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String sourceStart(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      int m = localJSONObject.optInt("offset", 0);
      int n = localJSONObject.optInt("duration", -1);
      localJSONObject = bgwp.a().a(parambgkd, i, j, k, m, n);
      parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_START error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String sourceStop(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      localJSONObject = bgwp.a().a(i, j, k);
      parambgkd = bgki.a(parambgkd.a, localJSONObject).toString();
      return parambgkd;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_STOP error " + parambgkd.getMessage());
    }
    return "{}";
  }
  
  public String webAudioConnectAudioNode(bgkd parambgkd)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgki.b(parambgkd.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.optInt("oriAudioNodeType", -1);
      localJSONObject.optInt("channelId", -2);
      localJSONObject.optInt("audioNodeType");
      int j = localJSONObject.getInt("audioId");
      if (i == bgwp.jdField_a_of_type_Int) {
        bgwp.a().a(parambgkd, j);
      }
      return "{}";
    }
    catch (JSONException parambgkd)
    {
      for (;;)
      {
        parambgkd.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.WebAudioPlugin
 * JD-Core Version:    0.7.0.1
 */