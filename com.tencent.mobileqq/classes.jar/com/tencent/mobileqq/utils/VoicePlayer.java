package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFileDataListener;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFilePlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFilePlayerListener;
import com.tencent.mobileqq.qqaudio.audioplayer.SilkPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer
  implements IAudioFilePlayerListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IAudioFilePlayer jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VoicePlayer.1(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VoicePlayer.VoicePlayerListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  public VoicePlayer(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = new AmrPlayer(paramContext, paramInt);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
  }
  
  public VoicePlayer(String paramString, Handler paramHandler)
  {
    this(paramString, paramHandler, 0);
  }
  
  public VoicePlayer(String paramString, Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = new AmrPlayer();
    }
    for (this.jdField_b_of_type_Int = 2;; this.jdField_b_of_type_Int = 3)
    {
      this.jdField_a_of_type_Int = 1;
      return;
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = new SilkPlayer();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (this.jdField_b_of_type_Boolean) {
      QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Int = 8;; this.jdField_a_of_type_Int = 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null)
      {
        i = j;
        if (this.jdField_a_of_type_Int == 4) {
          i = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.b();
        }
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.e();
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, i);
      }
    }
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a();
    }
    return 0;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.b();
    }
    return 0;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onCompletion duration=" + c() + " current=" + b() + " enableEndBuffer=" + this.jdField_a_of_type_Boolean + " thread=" + Thread.currentThread().getName());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VoicePlayer.2(this), 500L);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.b(paramInt);
  }
  
  public void a(IAudioFileDataListener paramIAudioFileDataListener)
  {
    if (a()) {
      ((SilkPlayer)this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer).a(paramIAudioFileDataListener);
    }
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onError what=" + paramInt1 + " extra=" + paramInt2);
    }
    a(true);
  }
  
  public void a(VoicePlayer.VoicePlayerListener paramVoicePlayerListener)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramVoicePlayerListener)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramVoicePlayerListener);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof SilkPlayer));
  }
  
  public boolean a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      try
      {
        this.jdField_a_of_type_Int = 2;
        if (this.jdField_b_of_type_Int != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.g();
        }
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          a(true);
        }
      }
      if (this.jdField_b_of_type_Boolean) {
        QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "start to play...  for test time=" + System.currentTimeMillis());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a();
        if (this.jdField_b_of_type_Boolean) {
          QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
        }
        QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof AmrPlayer))
    {
      this.jdField_a_of_type_Int = 2;
      ((AmrPlayer)this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer).b();
      if (this.jdField_b_of_type_Boolean) {
        QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 7) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_Boolean) {
        QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, false);
      }
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).b(this.jdField_a_of_type_JavaLangString, c(), b());
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Boolean) {
      QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    this.jdField_a_of_type_Int = 6;
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer
 * JD-Core Version:    0.7.0.1
 */