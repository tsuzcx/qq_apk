package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.ExtendFriendVoicePlayerListener;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class MatchChatAioVoicePlayerManager
  implements ExpandVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static volatile MatchChatAioVoicePlayerManager jdField_a_of_type_ComTencentMobileqqQqexpandChatMatchChatAioVoicePlayerManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  protected ExpandVoicePlayer a;
  private WeakReference<ExpandVoiceView> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static final void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqQqexpandChatMatchChatAioVoicePlayerManager != null)
      {
        if (jdField_a_of_type_ComTencentMobileqqQqexpandChatMatchChatAioVoicePlayerManager.a()) {
          jdField_a_of_type_ComTencentMobileqqQqexpandChatMatchChatAioVoicePlayerManager.b();
        }
        ExpandVoiceView localExpandVoiceView = jdField_a_of_type_ComTencentMobileqqQqexpandChatMatchChatAioVoicePlayerManager.a();
        if ((localExpandVoiceView != null) && (localExpandVoiceView.b())) {
          localExpandVoiceView.d();
        }
      }
      return;
    }
  }
  
  public ExpandVoiceView a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localWeakReference != null) {
      return (ExpandVoiceView)localWeakReference.get();
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
    if (paramString != null) {
      paramString.b();
    }
  }
  
  public void a(File paramFile) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "stopVoice");
    }
    ExpandVoicePlayer localExpandVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
    if (localExpandVoicePlayer != null)
    {
      localExpandVoicePlayer.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.MatchChatAioVoicePlayerManager
 * JD-Core Version:    0.7.0.1
 */