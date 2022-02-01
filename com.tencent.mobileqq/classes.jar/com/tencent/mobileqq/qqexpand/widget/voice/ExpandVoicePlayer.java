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
  private final AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ExpandVoicePlayer.1(this);
  private final AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private final QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private final ExpandVoicePlayer.ExtendFriendVoicePlayerListener jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer$ExtendFriendVoicePlayerListener;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final boolean jdField_a_of_type_Boolean = false;
  
  public ExpandVoicePlayer(ExpandVoicePlayer.ExtendFriendVoicePlayerListener paramExtendFriendVoicePlayerListener, QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer$ExtendFriendVoicePlayerListener = paramExtendFriendVoicePlayerListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("audio"));
  }
  
  private String a()
  {
    if (a() != null) {
      return a().getCurrentAccountUin();
    }
    return "";
  }
  
  private AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
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
    if (!a(paramString)) {
      ThreadManager.executeOnFileThread(new ExpandVoicePlayer.2(this, paramString));
    }
  }
  
  public boolean a(String arg1)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if ((localObject1 != null) && (((QBaseActivity)localObject1).isFinishing()))
    {
      QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file but activity isFinish");
      return false;
    }
    localObject1 = ???;
    try
    {
      if (!FileUtil.b(???))
      {
        localObject1 = ???;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
        {
          localObject1 = VFSAssistantUtils.getSDKPrivatePath(TransFileUtil.getTransferFilePath(a(), MD5.toMD5(???), 23, null));
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
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
            this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer((String)localObject1, new Handler(), 1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer$ExtendFriendVoicePlayerListener);
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
          if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
            this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoicePlayer", 2, "abandonAudioFocus");
    }
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager != null) {
      localAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer
 * JD-Core Version:    0.7.0.1
 */