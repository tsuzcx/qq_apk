package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.AudioPlayerManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VAudioView;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VAudio
  extends VComponent<VAudioView>
{
  public static final int AUDIO_STATUE_BUFFERING = 5;
  public static final int AUDIO_STATUE_COMPLETE = 3;
  public static final int AUDIO_STATUE_ERROR = 4;
  public static final int AUDIO_STATUE_PAUSE = 1;
  public static final int AUDIO_STATUE_PLAY = 0;
  public static final int AUDIO_STATUE_RESUME = 2;
  private AudioPlayerManager mAudioPlayerManager;
  private String mSrc = "";
  private int mUniqueId;
  
  public VAudio(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    if (ViolaSDKManager.getInstance().getAudioPlayerManager() == null) {
      ViolaSDKManager.getInstance().setAudioPlayerManager(new AudioPlayerManager());
    }
    this.mAudioPlayerManager = ViolaSDKManager.getInstance().getAudioPlayerManager();
    this.mUniqueId = paramDomObject.hashCode();
  }
  
  public void addEvent(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        super.addEvent(paramString);
        return;
        if (paramString.equals("change"))
        {
          i = 0;
          continue;
          if (paramString.equals("playTimeChange")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
  }
  
  public void audioChangeFireEvent(int paramInt, String paramString)
  {
    if (!this.mAppendEvents.contains("change")) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("data", paramString);
      }
      paramString = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          paramString.put(str);
        }
      }
      paramString.put("change");
      fireEvent("change", paramString, localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      ViolaLogUtils.e("VComponent", "audioChangeFireEvent error :" + paramString.getMessage());
    }
  }
  
  @JSMethod(uiThread=false)
  public void getCurrentDuration(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", this.mAudioPlayerManager.getCurrentDuration());
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void getTotalDuration(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", this.mAudioPlayerManager.getTotalDuration());
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public VAudioView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VAudioView(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  @JSMethod(uiThread=false)
  public void pause()
  {
    this.mAudioPlayerManager.pause(this.mUniqueId);
  }
  
  @JSMethod(uiThread=false)
  public void play()
  {
    this.mAudioPlayerManager.play(this.mUniqueId);
  }
  
  public void playTimeChangeFireEvent(int paramInt1, int paramInt2)
  {
    if (!this.mAppendEvents.contains("playTimeChange")) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentPlayTime", paramInt1);
      localJSONObject.put("totalTime", paramInt2);
      JSONArray localJSONArray = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
      }
      localJSONArray.put("playTimeChange");
      fireEvent("playTimeChange", localJSONArray, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VComponent", "playTimeChangeFireEvent error :" + localException.getMessage());
    }
  }
  
  @JSMethod(uiThread=false)
  public void resumePlay()
  {
    this.mAudioPlayerManager.play(this.mUniqueId);
  }
  
  @VComponentProp(name="src")
  public void setSrc(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.mSrc.equals(paramString)))
    {
      this.mSrc = paramString;
      this.mAudioPlayerManager.prepareData(this.mUniqueId, this.mSrc, new VAudio.1(this));
    }
  }
  
  @VComponentProp(name="timeInterval")
  public void setTimeInterval(int paramInt)
  {
    this.mAudioPlayerManager.setTimeInterval(this.mUniqueId, paramInt);
  }
  
  @JSMethod(uiThread=false)
  public void stop()
  {
    this.mAudioPlayerManager.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VAudio
 * JD-Core Version:    0.7.0.1
 */