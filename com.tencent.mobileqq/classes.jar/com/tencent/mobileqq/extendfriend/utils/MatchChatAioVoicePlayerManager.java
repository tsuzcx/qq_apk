package com.tencent.mobileqq.extendfriend.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class MatchChatAioVoicePlayerManager
  implements ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static volatile MatchChatAioVoicePlayerManager jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  protected ExtendFriendVoicePlayer a;
  private WeakReference<BaseActivity> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private WeakReference<ExtendFriendVoiceView> b;
  
  private MatchChatAioVoicePlayerManager(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public static final MatchChatAioVoicePlayerManager a(BaseActivity paramBaseActivity)
  {
    if (jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager == null) {
        jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager = new MatchChatAioVoicePlayerManager(paramBaseActivity);
      }
      return jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager;
    }
  }
  
  public static final void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      b();
      jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager = null;
      return;
    }
  }
  
  public static final void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager != null)
      {
        if (jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager.a()) {
          jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager.c();
        }
        ExtendFriendVoiceView localExtendFriendVoiceView = jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsMatchChatAioVoicePlayerManager.a();
        if ((localExtendFriendVoiceView != null) && (localExtendFriendVoiceView.b())) {
          localExtendFriendVoiceView.d();
        }
      }
      return;
    }
  }
  
  public ExtendFriendVoiceView a()
  {
    if (this.b != null) {
      return (ExtendFriendVoiceView)this.b.get();
    }
    return null;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.b();
    }
  }
  
  public void a(ExtendFriendVoiceView paramExtendFriendVoiceView)
  {
    if (paramExtendFriendVoiceView != null) {
      this.b = new WeakReference(paramExtendFriendVoiceView);
    }
  }
  
  public void a(File paramFile) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "playVoice " + paramString);
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localBaseActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer == null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer = new ExtendFriendVoicePlayer(this, localBaseActivity);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a(paramString);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "stopVoice");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void f(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.MatchChatAioVoicePlayerManager
 * JD-Core Version:    0.7.0.1
 */