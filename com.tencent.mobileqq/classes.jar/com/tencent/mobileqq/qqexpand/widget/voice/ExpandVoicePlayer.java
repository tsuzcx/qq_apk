package com.tencent.mobileqq.qqexpand.widget.voice;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ExpandVoicePlayer
{
  private VoicePlayer a;
  private final QBaseActivity b;
  private final AudioManager c;
  private final ExpandVoicePlayer.ExtendFriendVoicePlayerListener d;
  private final boolean e = false;
  private final Object f = new Object();
  private final AudioManager.OnAudioFocusChangeListener g = new ExpandVoicePlayer.1(this);
  
  public ExpandVoicePlayer(ExpandVoicePlayer.ExtendFriendVoicePlayerListener paramExtendFriendVoicePlayerListener, QBaseActivity paramQBaseActivity)
  {
    this.d = paramExtendFriendVoicePlayerListener;
    this.b = paramQBaseActivity;
    this.c = ((AudioManager)this.b.getSystemService("audio"));
  }
  
  private AppRuntime c()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  private String d()
  {
    if (c() != null) {
      return c().getCurrentAccountUin();
    }
    return "";
  }
  
  public void a()
  {
    try
    {
      synchronized (this.f)
      {
        if (this.a != null)
        {
          this.a.f();
          this.a = null;
        }
        b();
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop e=");
      localStringBuilder.append(localException);
      QLog.e("ExtendFriendVoicePlayer", 1, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    if (!b(paramString)) {
      ThreadManager.executeOnFileThread(new ExpandVoicePlayer.2(this, paramString));
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoicePlayer", 2, "abandonAudioFocus");
    }
    AudioManager localAudioManager = this.c;
    if (localAudioManager != null) {
      localAudioManager.abandonAudioFocus(this.g);
    }
  }
  
  public boolean b(String arg1)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((QBaseActivity)localObject1).isFinishing()))
    {
      QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file but activity isFinish");
      return false;
    }
    localObject1 = ???;
    try
    {
      if (!FileUtil.d(???))
      {
        localObject1 = ???;
        if (this.b != null)
        {
          localObject1 = VFSAssistantUtils.getSDKPrivatePath(TransFileUtil.getTransferFilePath(d(), MD5.toMD5(???), 23, null));
          File localFile = new File((String)localObject1);
          if (localFile.exists()) {
            if (localFile.length() > 0L) {
              break label231;
            }
          }
          if (!QLog.isColorLevel()) {
            break label234;
          }
          QLog.e("ExtendFriendVoicePlayer", 2, String.format("playLocal file not exist : %s", new Object[] { ??? }));
          return false;
        }
      }
      for (;;)
      {
        synchronized (this.f)
        {
          if (this.a != null)
          {
            this.a.f();
            this.a = null;
          }
          this.a = new VoicePlayer((String)localObject1, new Handler(), 1);
          this.a.h();
          this.a.a(this.d);
          this.a.c();
          if (this.c != null) {
            this.c.requestAudioFocus(this.g, 3, 2);
          }
          return true;
        }
      }
    }
    catch (Exception ???)
    {
      QLog.e("ExtendFriendVoicePlayer", 1, "playLocal", ???);
      return false;
    }
    label231:
    label234:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer
 * JD-Core Version:    0.7.0.1
 */