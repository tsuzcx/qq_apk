package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.WeakHashMap;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

public class VideoVolumeControl
  implements IVideoVolumeControl
{
  public static final String SET_MUTE_REASON_FROM_CLICK_VIDEO_NO_AUTO_PLAY = "noAutoPlayClickVideoInReadInjoy";
  public static final String SET_MUTE_REASON_FROM_KANDIAN_FEED = "jumpFromKandianFeed";
  private static final String TAG = "Q.readinjoy.video.VideoVolumeControl";
  private static VideoVolumeControl sIns;
  private AudioManager audioManager;
  private boolean audioSwithSet = false;
  private boolean dynamicPauseReceive = false;
  private boolean formDynamicTo1T3 = false;
  private Handler handler = new Handler(Looper.getMainLooper());
  private boolean isFocusAudio = false;
  private String mCurrentActivity;
  private int mCurrentWhat = 0;
  private String mFirstModuleActivity = "";
  private boolean mInKandianResume = true;
  private Timer mInKandianResumeTimer;
  private int mOriginalRingMode = -1;
  private int mOriginalRingVolume = -1;
  private VideoVolumeControl.VideoStateListener mPlayStateListener;
  private int mPreRingDode = -1;
  private Runnable mRequestOrAbandonAudioFocusCallBack = new VideoVolumeControl.1(this);
  private VideoVolumeControl.MyPhoneStateListener phoneStateListener;
  private VideoVolumeControl.VolumeReceiver receiver;
  private boolean shieldFirstOne = true;
  private boolean shieldVolumeChange = false;
  private boolean shouldIgnoreVolumeReceiver = false;
  private boolean shouldMute = true;
  private boolean shouldMuteFromConfig = true;
  private boolean shouldMuteInReadInJoy = true;
  private boolean shouldMuteInVideoFeed = false;
  private boolean shouleIgnoreVolumeReceiverFristTime = true;
  private Map<VideoPlayManager, Boolean> videoManagers = new WeakHashMap();
  private Map<VideoFeedsPlayManager, Boolean> videoMgrs = new WeakHashMap();
  private ArrayList<WeakReference<ImageView>> videoVolumeImageView = new ArrayList();
  
  public static VideoVolumeControl getInstance()
  {
    if (sIns == null) {
      try
      {
        if (sIns == null) {
          sIns = new VideoVolumeControl();
        }
      }
      finally {}
    }
    return sIns;
  }
  
  public static boolean isInCall(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getCallState();
      if ((i == 1) || (i == 2)) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("obtain inCall info failed ");
      localStringBuilder.append(paramContext.toString());
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public void adjustMediaVolume(int paramInt)
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null)
    {
      localAudioManager.adjustStreamVolume(3, paramInt, 0);
      if (this.audioManager.getStreamVolume(3) == 0)
      {
        setMute(true, "system volume 0", this.mCurrentWhat);
        return;
      }
      setMute(false, "system volume change", this.mCurrentWhat);
    }
  }
  
  public void attachVideoManager(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null)
    {
      paramVideoPlayManager.c(shouldMuteInReadInJoy());
      if (!this.videoManagers.containsKey(paramVideoPlayManager)) {
        this.videoManagers.put(paramVideoPlayManager, Boolean.valueOf(true));
      }
      paramVideoPlayManager.a(this.mPlayStateListener);
      this.mCurrentWhat = 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoManager :");
      localStringBuilder.append(paramVideoPlayManager);
      localStringBuilder.append(" list:");
      localStringBuilder.append(this.videoManagers);
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
    }
  }
  
  public void attachVideoMgr(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoFeedsPlayManager != null)
    {
      paramVideoFeedsPlayManager.d(shouldMuteInVideoFeed(false));
      if (!this.videoMgrs.containsKey(paramVideoFeedsPlayManager)) {
        this.videoMgrs.put(paramVideoFeedsPlayManager, Boolean.valueOf(true));
      }
      this.mCurrentWhat = 2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoMgr :");
      localStringBuilder.append(paramVideoFeedsPlayManager);
      localStringBuilder.append(" list:");
      localStringBuilder.append(this.videoMgrs);
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
    }
  }
  
  void checkPlayStateAfterPhoneCall()
  {
    Iterator localIterator = this.videoManagers.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (VideoPlayManager)localIterator.next();
      if (localObject != null) {
        ((VideoPlayManager)localObject).f();
      }
    }
    localIterator = this.videoMgrs.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (VideoFeedsPlayManager)localIterator.next();
      if (localObject != null) {
        ((VideoFeedsPlayManager)localObject).g();
      }
    }
  }
  
  void checkPlayStateWhenPhoneCome(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.videoManagers.keySet().iterator();
      Object localObject;
      StringBuilder localStringBuilder;
      while (localIterator.hasNext())
      {
        localObject = (VideoPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoPlayManager)localObject).a()))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkPlayStateWhenPhoneCome:");
            localStringBuilder.append(localObject);
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
          }
          if (((VideoPlayManager)localObject).a() != 5) {
            ((VideoPlayManager)localObject).b(true);
          }
          ((VideoPlayManager)localObject).a();
        }
      }
      localIterator = this.videoMgrs.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoFeedsPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoFeedsPlayManager)localObject).d()))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkPlayStateWhenPhoneCome:");
            localStringBuilder.append(localObject);
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
          }
          if (((VideoFeedsPlayManager)localObject).a() != 5) {
            ((VideoFeedsPlayManager)localObject).b(true);
          }
          ((VideoFeedsPlayManager)localObject).b();
        }
      }
    }
  }
  
  public int getMaxMediaVolume()
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null) {
      return localAudioManager.getStreamMaxVolume(3);
    }
    return 0;
  }
  
  public int getMediaVolume()
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null) {
      return localAudioManager.getStreamVolume(3);
    }
    return 0;
  }
  
  public float getMediaVolumeProgress()
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null) {
      return localAudioManager.getStreamVolume(3) / this.audioManager.getStreamMaxVolume(3);
    }
    return 0.0F;
  }
  
  public void inKandianModule(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "inKandianModule errParam，activity == null");
      return;
    }
    this.mCurrentActivity = paramActivity.toString();
    StringBuilder localStringBuilder;
    if (!"".equals(this.mFirstModuleActivity))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("inKandianModule origin:");
        localStringBuilder.append(this.mFirstModuleActivity);
        localStringBuilder.append(" act:");
        localStringBuilder.append(paramActivity.toString());
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("real inKandianModule origin:");
      localStringBuilder.append(this.mFirstModuleActivity);
      localStringBuilder.append(" act:");
      localStringBuilder.append(paramActivity.toString());
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
    }
    this.mFirstModuleActivity = paramActivity.toString();
    this.audioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    if (this.receiver == null) {
      this.receiver = new VideoVolumeControl.VolumeReceiver(this, null);
    }
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramActivity.addAction("android.intent.action.HEADSET_PLUG");
    paramActivity.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramActivity.addAction("android.media.RINGER_MODE_CHANGED");
    this.shieldFirstOne = true;
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.receiver, paramActivity);
    if (this.phoneStateListener == null) {
      this.phoneStateListener = new VideoVolumeControl.MyPhoneStateListener(this);
    }
    ThreadManager.excute(new VideoVolumeControl.2(this), 16, null, true);
    if (this.mPlayStateListener == null) {
      this.mPlayStateListener = new VideoVolumeControl.VideoStateListener(this);
    }
    this.mOriginalRingMode = this.audioManager.getRingerMode();
    this.mPreRingDode = this.mOriginalRingMode;
  }
  
  public boolean isInPhoneCall(@Nullable Context paramContext)
  {
    return isInCall(paramContext);
  }
  
  public boolean isMute()
  {
    return this.shouldMute;
  }
  
  public boolean needSmoothVideo()
  {
    return this.audioSwithSet ^ true;
  }
  
  public void outKandianModule(Activity paramActivity)
  {
    Object localObject;
    if (this.mFirstModuleActivity.equals(paramActivity.toString()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("really outKandianModule origin is:");
        ((StringBuilder)localObject).append(this.mFirstModuleActivity);
        ((StringBuilder)localObject).append(" act:");
        ((StringBuilder)localObject).append(paramActivity.toString());
        ((StringBuilder)localObject).append(",formDynamicTo1T3:");
        ((StringBuilder)localObject).append(this.formDynamicTo1T3);
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.audioManager;
      if (localObject != null) {
        ((AudioManager)localObject).abandonAudioFocus(null);
      }
      if (!"".equals(this.mFirstModuleActivity))
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.receiver);
        ThreadManager.excute(new VideoVolumeControl.4(this), 16, null, true);
      }
      this.mPlayStateListener = null;
      this.receiver = null;
      this.mFirstModuleActivity = "";
      this.audioManager = null;
      if (!this.formDynamicTo1T3)
      {
        setMute(false, "outKandianModule", 2);
        setMute(this.shouldMuteFromConfig, "outKandianModule", 1);
        this.audioSwithSet = false;
      }
      else
      {
        this.formDynamicTo1T3 = false;
        this.shouleIgnoreVolumeReceiverFristTime = false;
      }
      if ((paramActivity instanceof ReadInJoyNewFeedsActivity)) {
        ((IImageManager)QRoute.api(IImageManager.class)).clean();
      }
      paramActivity = this.mInKandianResumeTimer;
      if (paramActivity != null)
      {
        paramActivity.cancel();
        this.mInKandianResumeTimer.purge();
        this.mInKandianResumeTimer = null;
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("outKandianModule origin:");
      ((StringBuilder)localObject).append(this.mFirstModuleActivity);
      ((StringBuilder)localObject).append(" act:");
      ((StringBuilder)localObject).append(paramActivity.toString());
      QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void removeVideoManager(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null) {
      this.videoManagers.remove(paramVideoPlayManager);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeVideoManager :");
      localStringBuilder.append(paramVideoPlayManager);
      localStringBuilder.append(" list:");
      localStringBuilder.append(this.videoManagers);
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
    }
  }
  
  public void removeVideoMgr(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoFeedsPlayManager != null) {
      this.videoMgrs.remove(paramVideoFeedsPlayManager);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeVideoMgr :");
      localStringBuilder.append(paramVideoFeedsPlayManager);
      localStringBuilder.append(" list:");
      localStringBuilder.append(this.videoMgrs);
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
    }
  }
  
  public void requestOrAbandonAudioFocus(boolean paramBoolean, String paramString)
  {
    try
    {
      this.isFocusAudio = paramBoolean;
      if ((this.handler != null) && (this.mRequestOrAbandonAudioFocusCallBack != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestOrAbandonAudioFocus isFocus:");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(" ;what:");
          localStringBuilder.append(paramString);
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, localStringBuilder.toString());
        }
        this.handler.removeCallbacks(this.mRequestOrAbandonAudioFocusCallBack);
        if (this.isFocusAudio) {
          this.handler.post(this.mRequestOrAbandonAudioFocusCallBack);
        } else {
          this.handler.postDelayed(this.mRequestOrAbandonAudioFocusCallBack, 2000L);
        }
      }
      return;
    }
    finally {}
  }
  
  public void restoreFeedsVideoView(ImageView paramImageView)
  {
    this.videoVolumeImageView.add(new WeakReference(paramImageView));
  }
  
  public void resumeInKandianModule()
  {
    if (this.mInKandianResumeTimer == null) {
      this.mInKandianResumeTimer = new Timer();
    }
    this.mInKandianResume = false;
    this.mInKandianResumeTimer.schedule(new VideoVolumeControl.3(this), 2000L);
  }
  
  public void saveConfig(boolean paramBoolean)
  {
    this.shouldMuteFromConfig = paramBoolean;
  }
  
  public void setDynamicPauseReceive(boolean paramBoolean)
  {
    this.dynamicPauseReceive = paramBoolean;
  }
  
  public void setFormDynamicTo1T3(boolean paramBoolean)
  {
    this.formDynamicTo1T3 = paramBoolean;
    if (paramBoolean) {
      this.shouleIgnoreVolumeReceiverFristTime = true;
    }
  }
  
  public void setMute(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!this.audioSwithSet) {
      this.audioSwithSet = true;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setMute :");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", oldValue:");
      ((StringBuilder)localObject).append(this.shouldMute);
      ((StringBuilder)localObject).append(" reason:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" what:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    boolean bool;
    if ((paramInt != 1) && (paramInt != 0))
    {
      bool = false;
    }
    else
    {
      paramString = this.videoManagers.keySet().iterator();
      bool = false;
      while (paramString.hasNext())
      {
        localObject = (VideoPlayManager)paramString.next();
        if (localObject != null)
        {
          ((VideoPlayManager)localObject).c(paramBoolean);
          bool |= ((VideoPlayManager)localObject).a();
        }
      }
      this.shouldMuteInReadInJoy = paramBoolean;
    }
    if (bool) {
      requestOrAbandonAudioFocus(this.shouldMuteInReadInJoy ^ true, "by user click mute btn ");
    }
    if ((paramInt == 2) || (paramInt == 0))
    {
      paramString = this.videoMgrs.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (VideoFeedsPlayManager)paramString.next();
        if (localObject != null)
        {
          ((VideoFeedsPlayManager)localObject).d(paramBoolean);
          ((VideoFeedsPlayManager)localObject).d();
        }
      }
      this.shouldMuteInVideoFeed = paramBoolean;
    }
    this.shouldMute = paramBoolean;
    paramString = this.videoVolumeImageView;
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramInt = i;
      try
      {
        while (paramInt < this.videoVolumeImageView.size())
        {
          paramString = (WeakReference)this.videoVolumeImageView.get(paramInt);
          if ((paramString != null) && (paramString.get() != null)) {
            if (paramBoolean)
            {
              ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130843178));
              ((ImageView)paramString.get()).setContentDescription(HardCodeUtil.a(2131716186));
            }
            else
            {
              ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130843179));
              ((ImageView)paramString.get()).setContentDescription(HardCodeUtil.a(2131716187));
            }
          }
          paramInt += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("failed to update volume view:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void setShouldMuteInVideoFeed(boolean paramBoolean)
  {
    this.shouldMuteInVideoFeed = paramBoolean;
  }
  
  public void setshouldIgnoreVolumeReceiver(boolean paramBoolean)
  {
    this.shouldIgnoreVolumeReceiver = paramBoolean;
  }
  
  public boolean shouldMute()
  {
    return this.shouldMute;
  }
  
  public boolean shouldMuteInReadInJoy()
  {
    return this.shouldMuteInReadInJoy;
  }
  
  public boolean shouldMuteInVideoFeed(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.shouldMuteInVideoFeed;
    }
    if (this.audioManager == null) {
      this.audioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    }
    if (this.audioManager.getStreamVolume(3) <= 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.shouldMuteInVideoFeed = paramBoolean;
    return this.shouldMuteInVideoFeed;
  }
  
  public void startAudioPlay()
  {
    if (!this.audioSwithSet) {
      setMute(this.shouldMuteFromConfig, "start auto play", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl
 * JD-Core Version:    0.7.0.1
 */