package com.tencent.mobileqq.extendfriend.limitchat;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ExtendFriendVoiceMatchLoadingFragment$LimitChatHandler
  extends Handler
{
  public static int a;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  public static int e = 5200;
  private WeakReference<ExtendFriendVoiceMatchLoadingFragment> a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public ExtendFriendVoiceMatchLoadingFragment$LimitChatHandler(ExtendFriendVoiceMatchLoadingFragment paramExtendFriendVoiceMatchLoadingFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramExtendFriendVoiceMatchLoadingFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == d)
    {
      paramMessage = (ExtendFriendVoiceMatchLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramMessage != null) {
        ExtendFriendVoiceMatchLoadingFragment.a(paramMessage);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramMessage.what != jdField_a_of_type_Int) {
              break;
            }
            paramMessage = (ExtendFriendVoiceMatchLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          } while (paramMessage == null);
          QLog.e("ExtendFriendVoiceMatchLoadingFragment", 1, "limitchat matching time out from ui");
          ExtendFriendVoiceMatchLoadingFragment.a(paramMessage, true);
          return;
          if (paramMessage.what != b) {
            break;
          }
          paramMessage = (ExtendFriendVoiceMatchLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (paramMessage == null);
        ExtendFriendVoiceMatchLoadingFragment.b(paramMessage);
        paramMessage = paramMessage.getActivity();
      } while (paramMessage == null);
      paramMessage.finish();
      return;
    } while (paramMessage.what != c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler
 * JD-Core Version:    0.7.0.1
 */