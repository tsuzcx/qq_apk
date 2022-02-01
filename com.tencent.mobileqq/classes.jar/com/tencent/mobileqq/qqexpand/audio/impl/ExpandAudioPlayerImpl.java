package com.tencent.mobileqq.qqexpand.audio.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qqexpand.audio.IAudioPlayerStatusListener;
import com.tencent.mobileqq.qqexpand.audio.IExpandAudioPlayer;
import com.tencent.mobileqq.qqexpand.audio.IMethodCallback;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class ExpandAudioPlayerImpl
  implements IExpandAudioPlayer
{
  private static final int PLAY_ERROR = 0;
  private static final int PLAY_SUCCESS = 1;
  private static final String TAG = "ExpandAudioPlayerImpl";
  private VoicePlayer mPlayer;
  private PlayerStatusManager mStatusManager = new PlayerStatusManager();
  private String mUrl;
  VoicePlayer.VoicePlayerListener mVoicePlayerListener = new ExpandAudioPlayerImpl.1(this);
  private final Object playerLock = new Object();
  
  private String getResourceFile(String paramString)
  {
    String str;
    try
    {
      if (!FileUtil.d(paramString))
      {
        str = VFSAssistantUtils.getSDKPrivatePath(TransFileUtil.getTransferFilePath(BaseApplicationImpl.sApplication.getRuntime().getCurrentAccountUin(), MD5.toMD5(paramString), 23, null));
        File localFile = new File(str);
        if (localFile.exists()) {
          if (localFile.length() > 0L) {
            return str;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExpandAudioPlayerImpl", 2, String.format("playLocal file not exist : %s", new Object[] { paramString }));
        }
        return null;
      }
      else
      {
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ExpandAudioPlayerImpl", 1, "playLocal check resource file error ", paramString);
      return null;
    }
    return str;
  }
  
  private int playAudioFile(String paramString)
  {
    try
    {
      synchronized (this.playerLock)
      {
        if (this.mPlayer != null)
        {
          this.mPlayer.f();
          this.mPlayer = null;
        }
        this.mPlayer = new VoicePlayer(paramString, new Handler(Looper.getMainLooper()), 1);
        this.mPlayer.a(this.mVoicePlayerListener);
        this.mPlayer.c();
        this.mStatusManager.onAudioStartPlay(this.mUrl);
        return 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      this.mStatusManager.onAudioPlayFailed(this.mUrl, 3, "播放异常");
      QLog.e("ExpandAudioPlayerImpl", 1, "playAudioFile error ", paramString);
    }
  }
  
  public void audioPreDownLoad(String paramString, IMethodCallback paramIMethodCallback)
  {
    ThreadManager.excute(new ExpandAudioPlayerImpl.2(this, paramString, paramIMethodCallback), 128, null, true);
  }
  
  public void continueAudioPlay(IMethodCallback paramIMethodCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExpandAudioPlayerImpl", 2, "continueAudioPlay");
    }
    synchronized (this.playerLock)
    {
      if (this.mPlayer == null)
      {
        paramIMethodCallback.setResult(false);
        QLog.e("ExpandAudioPlayerImpl", 2, "continueAudioPlay mPlayer is null");
        return;
      }
      this.mPlayer.c();
      paramIMethodCallback.setResult(true);
      return;
    }
  }
  
  public void pauseAudioPlay(IMethodCallback paramIMethodCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExpandAudioPlayerImpl", 2, "pauseAudioPlay");
    }
    synchronized (this.playerLock)
    {
      if (this.mPlayer == null)
      {
        QLog.e("ExpandAudioPlayerImpl", 2, "pauseAudioPlay mPlayer is null");
        paramIMethodCallback.setResult(false);
        return;
      }
      this.mPlayer.e();
      paramIMethodCallback.setResult(true);
      return;
    }
  }
  
  public void removeAudioPlayerListener()
  {
    this.mStatusManager.a();
  }
  
  public void setAudioPlayerListener(@NotNull IAudioPlayerStatusListener paramIAudioPlayerStatusListener)
  {
    this.mStatusManager.a(paramIAudioPlayerStatusListener);
  }
  
  public void startAudioPlay(String paramString, IMethodCallback paramIMethodCallback)
  {
    this.mUrl = paramString;
    ThreadManager.excute(new ExpandAudioPlayerImpl.3(this, paramString, paramIMethodCallback), 64, null, true);
  }
  
  public void stopAudioPlay(IMethodCallback paramIMethodCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExpandAudioPlayerImpl", 2, "stopAudioPlay");
    }
    try
    {
      synchronized (this.playerLock)
      {
        if (this.mPlayer != null)
        {
          this.mPlayer.f();
          this.mPlayer = null;
        }
        paramIMethodCallback.setResult(true);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      paramIMethodCallback.setResult(false);
      paramIMethodCallback = new StringBuilder();
      paramIMethodCallback.append("stop e=");
      paramIMethodCallback.append(localException);
      QLog.e("ExpandAudioPlayerImpl", 1, paramIMethodCallback.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.ExpandAudioPlayerImpl
 * JD-Core Version:    0.7.0.1
 */