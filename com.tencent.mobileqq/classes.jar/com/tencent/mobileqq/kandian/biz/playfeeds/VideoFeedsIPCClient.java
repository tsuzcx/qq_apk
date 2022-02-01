package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient.Observer;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class VideoFeedsIPCClient
  implements IVideoFeedsIPCClient
{
  public static final String TAG = "Q.pubaccount.video.feedsVideoFeedsIPCClient";
  private static VideoFeedsIPCClient mInstance;
  private Set<String> mAsyncCallModuleSet = new HashSet();
  private List<IVideoFeedsIPCClient.Observer> mObservers = new Vector();
  private QIPCModule serverCallbackModule = new VideoFeedsIPCClient.1(this, "Module_VideoFeedsIPCServer");
  
  private VideoFeedsIPCClient()
  {
    QIPCClientHelper.getInstance().register(this.serverCallbackModule);
    registerAsyncModule();
  }
  
  public static VideoFeedsIPCClient getInstance()
  {
    if (mInstance == null) {
      try
      {
        mInstance = new VideoFeedsIPCClient();
      }
      finally {}
    }
    return mInstance;
  }
  
  private void registerAsyncModule()
  {
    this.mAsyncCallModuleSet.add("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD");
    this.mAsyncCallModuleSet.add("CMD_SHORTVIDEO_REQUEST_CLEAR");
    this.mAsyncCallModuleSet.add("CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ");
    this.mAsyncCallModuleSet.add("CMD_HANDLE_FORWARD_DATA");
    this.mAsyncCallModuleSet.add("CMD_INIT_READINJOY_MANAGER");
    this.mAsyncCallModuleSet.add("CMD_FOLLOW_PUB_ACCOUNT");
    this.mAsyncCallModuleSet.add("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET");
    this.mAsyncCallModuleSet.add("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG");
    this.mAsyncCallModuleSet.add("CMD_NETWORK_CHANGE");
    this.mAsyncCallModuleSet.add("CMD_IGNORE_VOLUME_CHANGE");
    this.mAsyncCallModuleSet.add("CMD_CANCEL_IGNORE_VOLUME_CHANGE");
    this.mAsyncCallModuleSet.add("CMD_CAMERA_CAPTURE_SO_DOWNLOAD");
    this.mAsyncCallModuleSet.add("CMD_GET_NICK_NAME_BY_UIN_CANCLE");
    this.mAsyncCallModuleSet.add("CMD_REPORT_START_TIME");
    this.mAsyncCallModuleSet.add("CMD_SET_VIDEO_LATEST_BRIGHTNESS");
  }
  
  public void addObserver(IVideoFeedsIPCClient.Observer paramObserver)
  {
    synchronized (this.mObservers)
    {
      this.mObservers.add(paramObserver);
      return;
    }
  }
  
  public Bundle callServer(String paramString, Bundle paramBundle)
  {
    boolean bool = this.mAsyncCallModuleSet.contains(paramString);
    Object localObject = null;
    if (bool)
    {
      QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", paramString, paramBundle, null);
      return null;
    }
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", paramString, paramBundle);
    paramString = localObject;
    if (paramBundle != null)
    {
      paramString = localObject;
      if (paramBundle.isSuccess()) {
        paramString = paramBundle.data;
      }
    }
    return paramString;
  }
  
  public void removeObserver(IVideoFeedsIPCClient.Observer paramObserver)
  {
    synchronized (this.mObservers)
    {
      this.mObservers.remove(paramObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsIPCClient
 * JD-Core Version:    0.7.0.1
 */