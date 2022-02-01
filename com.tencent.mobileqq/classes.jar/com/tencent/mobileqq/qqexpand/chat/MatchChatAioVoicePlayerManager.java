package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.ExtendFriendVoicePlayerListener;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class MatchChatAioVoicePlayerManager
  implements ExpandVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static volatile MatchChatAioVoicePlayerManager b;
  private static final Object c = new Object();
  protected ExpandVoicePlayer a;
  private WeakReference<OldExpandVoiceView> d;
  private volatile boolean e;
  
  public static final void a()
  {
    synchronized (c)
    {
      if (b != null)
      {
        if (b.d()) {
          b.c();
        }
        OldExpandVoiceView localOldExpandVoiceView = b.b();
        if ((localOldExpandVoiceView != null) && (localOldExpandVoiceView.d())) {
          localOldExpandVoiceView.f();
        }
      }
      return;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.b();
    }
  }
  
  public void a(File paramFile) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean) {}
  
  public OldExpandVoiceView b()
  {
    WeakReference localWeakReference = this.d;
    if (localWeakReference != null) {
      return (OldExpandVoiceView)localWeakReference.get();
    }
    return null;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "stopVoice");
    }
    ExpandVoicePlayer localExpandVoicePlayer = this.a;
    if (localExpandVoicePlayer != null)
    {
      localExpandVoicePlayer.a();
      this.e = false;
    }
  }
  
  public boolean d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.MatchChatAioVoicePlayerManager
 * JD-Core Version:    0.7.0.1
 */