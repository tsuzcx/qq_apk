package com.tencent.mobileqq.extendfriend.utils;

import acsd;
import acse;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ExtendFriendVoicePlayer
{
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new acsd(this);
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer$ExtendFriendVoicePlayerListener;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public ExtendFriendVoicePlayer(ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener paramExtendFriendVoicePlayerListener, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer$ExtendFriendVoicePlayerListener = paramExtendFriendVoicePlayerListener;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("audio"));
  }
  
  public void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
        }
        b();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoicePlayer", 1, "stop e=" + localException);
    }
  }
  
  public void a(String paramString)
  {
    if (!a(paramString)) {
      ThreadManager.executeOnFileThread(new acse(this, paramString));
    }
  }
  
  public boolean a(String arg1)
  {
    String str = ???;
    label196:
    for (;;)
    {
      try
      {
        if (!FileUtil.a(???))
        {
          str = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), MD5.toMD5(???), 23, null);
          File localFile = new File(str);
          if ((localFile.exists()) && (localFile.length() > 0L)) {
            break label196;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("ExtendFriendVoicePlayer", 2, String.format("playLocal file not exist : %s", new Object[] { ??? }));
            return false;
          }
        }
        else
        {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
              this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(str, new Handler(), 1);
            this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
            this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer$ExtendFriendVoicePlayerListener);
            this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
            if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
              this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
            }
            return true;
          }
        }
        return false;
      }
      catch (Exception ???)
      {
        QLog.e("ExtendFriendVoicePlayer", 1, "playLocal", ???);
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoicePlayer", 2, "abandonAudioFocus");
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer
 * JD-Core Version:    0.7.0.1
 */