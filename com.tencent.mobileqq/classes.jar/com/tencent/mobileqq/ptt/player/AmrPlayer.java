package com.tencent.mobileqq.ptt.player;

import agto;
import agtp;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.WeakReferenceHandler;

public final class AmrPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, Handler.Callback, IPttPlayer
{
  private int jdField_a_of_type_Int = -1;
  private agtp jdField_a_of_type_Agtp;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private IPttPlayerListener jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  Runnable jdField_a_of_type_JavaLangRunnable = new agto(this);
  private String jdField_a_of_type_JavaLangString;
  
  public AmrPlayer()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public AmrPlayer(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(paramContext, paramInt);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    if (this.jdField_a_of_type_Agtp == null)
    {
      this.jdField_a_of_type_Agtp = new agtp(this, null);
      this.jdField_a_of_type_Agtp.start();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void a(int paramInt, byte paramByte) {}
  
  public void a(IPttPlayerListener paramIPttPlayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener = paramIPttPlayerListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    this.jdField_a_of_type_Agtp = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a(this, 0, 0);
      }
    }
    while ((paramMessage.what != 2) || (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener == null)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a();
    return true;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Agtp = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Agtp = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a(this, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.AmrPlayer
 * JD-Core Version:    0.7.0.1
 */