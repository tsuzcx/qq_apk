package com.tencent.mobileqq.kandian.glue.video;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;

public class VideoVolumeController
  implements IVideoVolumeController
{
  private static final String TAG = "VideoVolumeController";
  private AudioManager audioManager;
  private boolean dynamicPauseReceive = false;
  private Handler handler = new Handler(Looper.getMainLooper());
  private boolean isFocusAudio = false;
  private ArrayList<IVideoVolumeController.EventListener> mEventListeners = new ArrayList();
  private boolean mInKandianResume = true;
  private Timer mInKandianResumeTimer;
  private Runnable mRequestOrAbandonAudioFocusCallBack = new VideoVolumeController.1(this);
  private VideoVolumeController.MyPhoneStateListener phoneStateListener;
  private VideoVolumeController.VolumeReceiver receiver;
  private int referenceCount = 0;
  private Set<String> referenceHis = new HashSet();
  private boolean shieldFirstOne = true;
  private boolean shieldVolumeChange = false;
  
  public static final VideoVolumeController getInstance()
  {
    return VideoVolumeController.VideoVolumeControllerHolder.a();
  }
  
  private void inKandianModule(String paramString)
  {
    StringBuilder localStringBuilder;
    if (this.referenceHis.contains(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("inKandianModule return for repeat call, hexString:");
      localStringBuilder.append(paramString);
      QLog.w("VideoVolumeController", 1, localStringBuilder.toString());
      return;
    }
    this.referenceHis.add(paramString);
    this.referenceCount += 1;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("inKandianModule: hexString:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" referenceCount:");
      localStringBuilder.append(this.referenceCount);
      localStringBuilder.append(" act:");
      localStringBuilder.append(paramString);
      QLog.d("VideoVolumeController", 2, localStringBuilder.toString());
    }
    if (this.audioManager == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("inKandianModule create audioManager, act:");
        localStringBuilder.append(paramString);
        QLog.d("VideoVolumeController", 2, localStringBuilder.toString());
      }
      this.audioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
      this.receiver = new VideoVolumeController.VolumeReceiver(this, null);
      paramString = new IntentFilter();
      paramString.addAction("android.media.VOLUME_CHANGED_ACTION");
      paramString.addAction("android.intent.action.HEADSET_PLUG");
      paramString.addAction("android.media.AUDIO_BECOMING_NOISY");
      paramString.addAction("android.media.RINGER_MODE_CHANGED");
      this.shieldFirstOne = true;
      BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.receiver, paramString);
      paramString = (TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone");
      this.phoneStateListener = new VideoVolumeController.MyPhoneStateListener(this);
      paramString.listen(this.phoneStateListener, 32);
    }
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
      QLog.d("VideoVolumeController", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  private void outKandianModule(String paramString)
  {
    StringBuilder localStringBuilder;
    if (!this.referenceHis.remove(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("outKandianModule call failed for act:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" not call inKandianModule, referenceCount:");
      localStringBuilder.append(this.referenceCount);
      QLog.w("VideoVolumeController", 1, localStringBuilder.toString());
      return;
    }
    int i = this.referenceCount;
    if (i <= 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("outKandianModule call failed for referenceCount is ");
      localStringBuilder.append(this.referenceCount);
      localStringBuilder.append(", act:");
      localStringBuilder.append(paramString);
      QLog.w("VideoVolumeController", 1, localStringBuilder.toString());
      return;
    }
    this.referenceCount = (i - 1);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("outKandianModule: hexString:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" referenceCount:");
      localStringBuilder.append(this.referenceCount);
      localStringBuilder.append(" act:");
      localStringBuilder.append(paramString);
      QLog.d("VideoVolumeController", 2, localStringBuilder.toString());
    }
    if (this.referenceCount == 0) {
      releaseAudioManager(paramString);
    }
  }
  
  private void releaseAudioManager(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseAudioManager..., act:");
      localStringBuilder.append(paramString);
      QLog.d("VideoVolumeController", 2, localStringBuilder.toString());
    }
    paramString = this.audioManager;
    if (paramString != null) {
      paramString.abandonAudioFocus(null);
    }
    BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.receiver);
    ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(this.phoneStateListener, 0);
    this.phoneStateListener = null;
    this.receiver = null;
    this.audioManager = null;
    paramString = this.mInKandianResumeTimer;
    if (paramString != null)
    {
      paramString.cancel();
      this.mInKandianResumeTimer.purge();
      this.mInKandianResumeTimer = null;
    }
  }
  
  public void addEventListener(IVideoVolumeController.EventListener paramEventListener)
  {
    this.mEventListeners.add(paramEventListener);
  }
  
  public void adjustMediaVolume(int paramInt)
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null)
    {
      localAudioManager.adjustStreamVolume(3, paramInt, 0);
      return;
    }
    QLog.e("VideoVolumeController", 1, "adjustMediaVolume failed for audioManager is null.");
  }
  
  void checkPlayStateWhenPhoneCome(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.mEventListeners.iterator();
      while (localIterator.hasNext()) {
        ((IVideoVolumeController.EventListener)localIterator.next()).onPhoneCome();
      }
    }
  }
  
  public int getMediaVolume()
  {
    return getStreamVolume(3);
  }
  
  public float getMediaVolumeProgress()
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null) {
      return localAudioManager.getStreamVolume(3) / this.audioManager.getStreamMaxVolume(3);
    }
    return 0.0F;
  }
  
  public int getStreamMaxVolume(int paramInt)
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null) {
      return localAudioManager.getStreamMaxVolume(paramInt);
    }
    return 0;
  }
  
  public int getStreamVolume(int paramInt)
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null) {
      return localAudioManager.getStreamVolume(paramInt);
    }
    return 0;
  }
  
  public void inKandianModule(Context paramContext)
  {
    if (paramContext != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("inKandianModule: context:");
        localStringBuilder.append(paramContext);
        QLog.d("VideoVolumeController", 2, localStringBuilder.toString());
      }
      inKandianModule(Integer.toHexString(System.identityHashCode(paramContext)));
    }
  }
  
  public void outKandianModule(Context paramContext)
  {
    if (paramContext != null) {
      outKandianModule(Integer.toHexString(System.identityHashCode(paramContext)));
    }
  }
  
  public void removeEventListener(IVideoVolumeController.EventListener paramEventListener)
  {
    this.mEventListeners.remove(paramEventListener);
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
          QLog.d("VideoVolumeController", 2, localStringBuilder.toString());
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
  
  public void setStreamVolume(int paramInt1, int paramInt2, int paramInt3)
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager != null) {
      localAudioManager.setStreamVolume(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeController
 * JD-Core Version:    0.7.0.1
 */