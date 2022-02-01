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
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = new AmrPlayer();
      this.jdField_b_of_type_Int = 2;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = new SilkPlayer();
      this.jdField_b_of_type_Int = 3;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    int i = 0;
    int j = 0;
    if (bool) {
      QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Int = 8;
    } else {
      this.jdField_a_of_type_Int = 4;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localObject != null)
    {
      i = j;
      if (this.jdField_a_of_type_Int == 4) {
        i = ((IAudioFilePlayer)localObject).b();
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VoicePlayer.VoicePlayerListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, i);
    }
  }
  
  private int b()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localIAudioFilePlayer != null) {
      return localIAudioFilePlayer.a();
    }
    return 0;
  }
  
  private int c()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localIAudioFilePlayer != null) {
      return localIAudioFilePlayer.b();
    }
    return 0;
  }
  
  private void g()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCompletion duration=");
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append(" current=");
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(" enableEndBuffer=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" thread=");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = 7;
        ((Handler)localObject).postDelayed(new VoicePlayer.2(this), 500L);
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
    if (QLog.isColorLevel())
    {
      paramIAudioFilePlayer = new StringBuilder();
      paramIAudioFilePlayer.append("onError what=");
      paramIAudioFilePlayer.append(paramInt1);
      paramIAudioFilePlayer.append(" extra=");
      paramIAudioFilePlayer.append(paramInt2);
      QLog.d("Q.profilecard.VoicePlayer", 2, paramIAudioFilePlayer.toString());
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
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    return (localIAudioFilePlayer != null) && ((localIAudioFilePlayer instanceof SilkPlayer));
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
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
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
        localException.printStackTrace();
        a(true);
      }
      if (this.jdField_b_of_type_Boolean) {
        QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start to play...  for test time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
    }
    else if (i == 3)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a();
      if (this.jdField_b_of_type_Boolean) {
        QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("continue to play... for test time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void b(int paramInt) {}
  
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
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if ((localObject instanceof AmrPlayer))
    {
      this.jdField_a_of_type_Int = 2;
      ((AmrPlayer)localObject).b();
      if (this.jdField_b_of_type_Boolean) {
        QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("continue to play... for test time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int == 7) {
      return;
    }
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
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    this.jdField_a_of_type_Int = 6;
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localIAudioFilePlayer != null)
    {
      localIAudioFilePlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = null;
    }
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer
 * JD-Core Version:    0.7.0.1
 */