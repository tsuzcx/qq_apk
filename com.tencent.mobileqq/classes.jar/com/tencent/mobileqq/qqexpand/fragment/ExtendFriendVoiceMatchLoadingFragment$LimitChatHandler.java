package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ExtendFriendVoiceMatchLoadingFragment$LimitChatHandler
  extends Handler
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  public static int e = 5200;
  private final WeakReference<ExtendFriendVoiceMatchLoadingFragment> f;
  
  public ExtendFriendVoiceMatchLoadingFragment$LimitChatHandler(ExtendFriendVoiceMatchLoadingFragment paramExtendFriendVoiceMatchLoadingFragment)
  {
    this.f = new WeakReference(paramExtendFriendVoiceMatchLoadingFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == d)
    {
      paramMessage = (ExtendFriendVoiceMatchLoadingFragment)this.f.get();
      if (paramMessage != null) {
        ExtendFriendVoiceMatchLoadingFragment.d(paramMessage);
      }
    }
    else if (paramMessage.what == a)
    {
      paramMessage = (ExtendFriendVoiceMatchLoadingFragment)this.f.get();
      if (paramMessage != null)
      {
        QLog.e("ExtendFriendVoiceMatchLoadingFragment", 1, "limitchat matching time out from ui");
        ExtendFriendVoiceMatchLoadingFragment.a(paramMessage, true);
      }
    }
    else if (paramMessage.what == b)
    {
      paramMessage = (ExtendFriendVoiceMatchLoadingFragment)this.f.get();
      if (paramMessage != null)
      {
        ExtendFriendVoiceMatchLoadingFragment.e(paramMessage);
        paramMessage = paramMessage.getBaseActivity();
        if (paramMessage != null) {
          paramMessage.finish();
        }
      }
    }
    else
    {
      int i = paramMessage.what;
      i = c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler
 * JD-Core Version:    0.7.0.1
 */