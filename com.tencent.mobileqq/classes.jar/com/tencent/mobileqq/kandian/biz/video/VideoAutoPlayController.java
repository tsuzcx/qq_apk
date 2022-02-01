package com.tencent.mobileqq.kandian.biz.video;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

@Deprecated
public class VideoAutoPlayController
  implements IVideoAutoPlayController
{
  public static final long COMFIREINTERVAL = 600000L;
  public static final String TAG = "VideoAutoPlayController";
  private static String cuin;
  private static long mLastComfireTime = 0L;
  private static String mVideoAutoPlaySetting = "2";
  private static String mVideoAutoPlaySettingVideoFlow = "2";
  private static VideoAutoPlayController sInstance;
  public static boolean sPauseScrollToNextVideo;
  private int channelId;
  private long mChannelFrom;
  public boolean mConfirmCanPlayInXg;
  public Context mContext;
  protected boolean mDeviceAllowAutoPlayVideo;
  private boolean mIsRefreshingList;
  private boolean mIsWifi;
  public float mPlayableAreaHeigth = -1.0F;
  public float mScreenHeight = 0.0F;
  public float mVideoHeight = -1.0F;
  private boolean shouldCheckSrtting;
  
  private VideoAutoPlayController()
  {
    this(-1);
  }
  
  private VideoAutoPlayController(int paramInt)
  {
    boolean bool = true;
    this.mDeviceAllowAutoPlayVideo = true;
    this.mIsRefreshingList = false;
    this.shouldCheckSrtting = true;
    this.mConfirmCanPlayInXg = false;
    this.mChannelFrom = -1L;
    this.channelId = 0;
    this.mChannelFrom = paramInt;
    this.mContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.mScreenHeight = this.mContext.getResources().getDisplayMetrics().heightPixels;
    double d = this.mContext.getResources().getDisplayMetrics().widthPixels;
    Double.isNaN(d);
    this.mVideoHeight = ((int)(d / 16.0D * 9.0D));
    this.mPlayableAreaHeigth = (this.mVideoHeight * 2.0F * 1.2F);
    if (Build.VERSION.SDK_INT < 14) {
      bool = false;
    }
    this.mDeviceAllowAutoPlayVideo = bool;
    checkVideoPlaySetting();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mDeviceAutoPlaySwitch : ");
      localStringBuilder.append(this.mDeviceAllowAutoPlayVideo);
      QLog.d("Q.readinjoy.video", 2, localStringBuilder.toString());
    }
  }
  
  private void checkVideoPlaySetting()
  {
    if (this.shouldCheckSrtting) {
      mVideoAutoPlaySetting = RIJAppSetting.a();
    }
  }
  
  public static VideoAutoPlayController getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new VideoAutoPlayController();
      }
      VideoAutoPlayController localVideoAutoPlayController = sInstance;
      return localVideoAutoPlayController;
    }
    finally {}
  }
  
  public static boolean isAllowPlayInXgNetwork()
  {
    if (mLastComfireTime == -1L) {
      return false;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      if (!str.equals(cuin))
      {
        cuin = str;
        mLastComfireTime = -1L;
        return false;
      }
    }
    return System.currentTimeMillis() - mLastComfireTime < 600000L;
  }
  
  public boolean canAutoPlayVideo()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("canAutoPlayVideo：getKandianMode: ");
      ((StringBuilder)localObject).append(RIJAppSetting.b());
      QLog.d("VideoAutoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = RIJQQAppInterfaceUtil.a();
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    if ((localObject != null) && (((QQAppInterface)localObject).isVideoChatting())) {
      return false;
    }
    if (RIJAppSetting.b() == 6)
    {
      mVideoAutoPlaySettingVideoFlow = RIJAppSetting.a(this.mChannelFrom);
      if ("2".equals(mVideoAutoPlaySettingVideoFlow)) {
        return false;
      }
      if (("0".equals(mVideoAutoPlaySettingVideoFlow)) && (NetworkUtil.isNetworkAvailable(this.mContext))) {
        return this.mDeviceAllowAutoPlayVideo;
      }
      bool1 = bool2;
      if (this.mIsWifi)
      {
        bool1 = bool2;
        if (this.mDeviceAllowAutoPlayVideo) {
          bool1 = true;
        }
      }
      return bool1;
    }
    mVideoAutoPlaySetting = RIJAppSetting.a(this.mChannelFrom);
    if ("2".equals(mVideoAutoPlaySetting)) {
      return false;
    }
    if (("0".equals(mVideoAutoPlaySetting)) && (NetworkUtil.isNetworkAvailable(this.mContext))) {
      return this.mDeviceAllowAutoPlayVideo;
    }
    if (this.channelId == 0)
    {
      if (!this.mIsWifi)
      {
        bool1 = bool3;
        if (!((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isKingCardAutoPlay(getInstance().mContext)) {}
      }
      else
      {
        bool1 = bool3;
        if (this.mDeviceAllowAutoPlayVideo) {
          bool1 = true;
        }
      }
      return bool1;
    }
    boolean bool1 = bool4;
    if (this.mIsWifi)
    {
      bool1 = bool4;
      if (this.mDeviceAllowAutoPlayVideo) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void initVideoPlaySetting(String paramString)
  {
    mVideoAutoPlaySetting = paramString;
    this.shouldCheckSrtting = false;
  }
  
  public boolean isNeedNetWorkAlert()
  {
    boolean bool1 = "0".equals(mVideoAutoPlaySetting);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (!NetworkUtil.isWifiConnected(this.mContext))
    {
      bool1 = bool2;
      if (!isAllowPlayInXgNetwork()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isNeedNetWorkAlertForIPC()
  {
    boolean bool1 = "0".equals(mVideoAutoPlaySetting);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (!NetworkUtil.isWifiConnected(this.mContext))
    {
      bool1 = bool2;
      if (!this.mConfirmCanPlayInXg) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isRefreshingList()
  {
    return this.mIsRefreshingList;
  }
  
  public boolean isWifi()
  {
    return this.mIsWifi;
  }
  
  public void setChannelFrom(long paramLong)
  {
    this.mChannelFrom = paramLong;
  }
  
  public void setChannelId(int paramInt)
  {
    this.channelId = paramInt;
  }
  
  public void setIsRefreshingList(boolean paramBoolean)
  {
    this.mIsRefreshingList = paramBoolean;
  }
  
  public void updateNetworkChange(boolean paramBoolean)
  {
    this.mIsWifi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController
 * JD-Core Version:    0.7.0.1
 */