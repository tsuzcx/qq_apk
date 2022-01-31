package com.tencent.qqmini.sdk.minigame.plugins;

import android.os.Build.VERSION;
import begz;
import beka;
import bekg;
import beku;
import beuh;
import bewt;
import bexf;
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
  private AtomicInteger sId = new AtomicInteger();
  
  public String audioBufferCopyFromChannel(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    return "{}";
  }
  
  public String audioBufferCopyToChannel(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).optInt("sourceId", -1);
      int k = ((JSONObject)localObject).getInt("channelId");
      int m = ((JSONObject)localObject).optInt("startInChannel", 0);
      localObject = beku.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((beku)localObject).jdField_a_of_type_ArrayOfByte;
        if ((localObject != null) && (localObject.length != 0))
        {
          bewt.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL data.length " + localObject.length);
          i = bexf.a().a((byte[])localObject, i, j, k, m);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("bufferId", i);
          bewt.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL newBufferId: " + i);
          parambeka = bekg.a(parambeka.a, (JSONObject)localObject).toString();
          return parambeka;
        }
      }
    }
    catch (JSONException parambeka)
    {
      parambeka.printStackTrace();
    }
    return "{}";
  }
  
  public String audioProcessingEventSetQueueBuffer(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      parambeka = new JSONObject(parambeka.b);
      int i = parambeka.optInt("channelId", -2);
      int j = parambeka.optInt("bufferId");
      bexf.a().a(i, j);
      return "{}";
    }
    catch (JSONException parambeka)
    {
      for (;;)
      {
        parambeka.printStackTrace();
      }
    }
  }
  
  public String closeWebAudioContext(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    bexf.a().a();
    return bekg.a(parambeka.a, null).toString();
  }
  
  public String createWebAudioBufferSource(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambeka.b).getInt("audioId");
      JSONObject localJSONObject = bexf.a().a(i);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioContext(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    JSONObject localJSONObject = bexf.a().a(parambeka.b);
    return bekg.a(parambeka.a, localJSONObject).toString();
  }
  
  public String createWebAudioContextBuffer(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int i = localJSONObject.optInt("numOfChannels", 1);
      int j = localJSONObject.optInt("length");
      int k = localJSONObject.optInt("sampleRate");
      localJSONObject = bexf.a().a(i, j, k);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioGain(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 5);
      localJSONObject.put("channelId", -1);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_CREATE_GAIN error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioScriptProcessor(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int i = localJSONObject.optInt("bufferSize");
      int j = localJSONObject.optInt("inputChannelNum");
      int k = localJSONObject.optInt("outputChannelNum");
      bexf.a().a(parambeka, i, j, k);
      return "{}";
    }
    catch (JSONException parambeka)
    {
      for (;;)
      {
        parambeka.printStackTrace();
      }
    }
  }
  
  public String decodeWebAudioData(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      int i = this.sId.incrementAndGet();
      localObject = beku.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((beku)localObject).jdField_a_of_type_ArrayOfByte;
        if (Build.VERSION.SDK_INT >= 16) {
          bexf.a().a(i, (byte[])localObject, parambeka);
        }
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("decodeId", i);
      parambeka = bekg.a(parambeka.a, (JSONObject)localObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioBufferChannelData(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).getInt("channelId");
      localObject = bexf.a().a(i, j);
      JSONObject localJSONObject = new JSONObject();
      beku.a(this.mMiniAppContext, (byte[])localObject, beku.jdField_a_of_type_Int, "data", localJSONObject);
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA data.length " + localObject.length);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentGain(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambeka.b).getInt("channelId");
      parambeka = bexf.a().a(i) + "";
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentTime(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambeka.b).getInt("audioId");
      parambeka = bexf.a().a(i) + "";
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioDestination(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 4);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    if ((this.mMiniAppContext instanceof beuh)) {
      this.mTTEngine = ((beuh)this.mMiniAppContext).a();
    }
  }
  
  public String operateWebAudioContext(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      parambeka = new JSONObject(parambeka.b).getString("operationType");
      if (parambeka.equals("suspend")) {
        bexf.a().b();
      }
      for (;;)
      {
        return "{}";
        if (parambeka.equals("resume")) {
          bexf.a().c();
        }
      }
    }
    catch (Throwable parambeka)
    {
      for (;;)
      {
        bewt.a().e("WebAudioPlugin", "handleNativeRequest API_OPERATE_WEB_AUDIO_CONTEXT error " + parambeka.getMessage());
      }
    }
  }
  
  public String setWebAudioBufferSourceLoop(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      boolean bool = localJSONObject.getBoolean("loop");
      int i = localJSONObject.getInt("channelId");
      bexf.a().a(i, bool);
      parambeka = bekg.a(parambeka.a, null).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioCurrentGain(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int i = localJSONObject.getInt("channelId");
      double d = localJSONObject.getDouble("data");
      bexf.a().a(i, d);
      parambeka = bekg.a(parambeka.a, null).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioSourceBuffer(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.getInt("bufferId");
      localJSONObject = bexf.a().a(i, j);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String sourceStart(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      int m = localJSONObject.optInt("offset", 0);
      int n = localJSONObject.optInt("duration", -1);
      localJSONObject = bexf.a().a(parambeka, i, j, k, m, n);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_START error " + parambeka.getMessage());
    }
    return "{}";
  }
  
  public String sourceStop(beka parambeka)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekg.b(parambeka.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      localJSONObject = bexf.a().b(i, j, k);
      parambeka = bekg.a(parambeka.a, localJSONObject).toString();
      return parambeka;
    }
    catch (Throwable parambeka)
    {
      bewt.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_STOP error " + parambeka.getMessage());
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.WebAudioPlugin
 * JD-Core Version:    0.7.0.1
 */