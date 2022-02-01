package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;

public class EngineChannel
  implements Parcelable
{
  public static final Parcelable.Creator<EngineChannel> CREATOR = new EngineChannel.1();
  public static final String KEY_BUNDLE_BASE_LIBTYPE = "baseLibType";
  public static final String KEY_BUNDLE_ENGINE_CHANNEL = "engineChannel";
  public static final String KEY_BUNDLE_ENGINE_INSTALLER_MESSAGE = "engineInstallerMessage";
  public static final String KEY_BUNDLE_ENGINE_INSTALLER_PROGRESS = "engineInstallerProgress";
  public static final String KEY_BUNDLE_ENGINE_PID = "enginePid";
  public static final String KEY_BUNDLE_INSTALLED_ENGINE_LIST = "installedEngineList";
  public static final String KEY_BUNDLE_INVALID_ENGINE = "invalidEngine";
  public static final String LOG_TAG = "EngineChannel";
  public static final int WHAT_EVENT_ACK = 55;
  public static final int WHAT_EVENT_BASE = 50;
  public static final int WHAT_EVENT_DELETE_INVALID_ENGINE = 56;
  public static final int WHAT_EVENT_INSTALLED_ENGINE_LIST = 51;
  public static final int WHAT_EVENT_INSTALL_LATEST_ENGINE_BEGIN = 52;
  public static final int WHAT_EVENT_INSTALL_LATEST_ENGINE_FINISH = 54;
  public static final int WHAT_EVENT_INSTALL_LATEST_ENGINE_PROCESS = 53;
  public static final int WHAT_GET_INSTALLED_ENGINE_LIST = 1;
  public static final int WHAT_INSTALL_LATEST_ENGINE = 3;
  public static final int WHAT_UPGRADE_ENGINE = 5;
  private String mChannelName = "Unknown";
  private EngineChannel.Receiver mReceiver;
  private ResultReceiver mResultReceiver;
  
  public EngineChannel()
  {
    this.mResultReceiver = new EngineChannel.MyReceiver(this, new EngineChannel.EngineChannelHandler(TTHandleThread.getInstance().getLooper()));
  }
  
  private EngineChannel(ResultReceiver paramResultReceiver)
  {
    this.mResultReceiver = paramResultReceiver;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void send(int paramInt, Bundle paramBundle)
  {
    ResultReceiver localResultReceiver = this.mResultReceiver;
    if (localResultReceiver != null) {
      localResultReceiver.send(paramInt, paramBundle);
    }
  }
  
  public void setName(String paramString)
  {
    this.mChannelName = paramString;
  }
  
  public void setReceiver(EngineChannel.Receiver paramReceiver)
  {
    this.mReceiver = paramReceiver;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EngineChannel{channelName=");
    localStringBuilder.append(this.mChannelName);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.mResultReceiver.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mChannelName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineChannel
 * JD-Core Version:    0.7.0.1
 */