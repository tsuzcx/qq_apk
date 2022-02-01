package com.tencent.mobileqq.ptt.player;

import agkq;
import android.app.Application;
import android.media.AudioTrack;
import android.os.Process;
import azcg;
import azci;
import bfyl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.ptt.pttspeed.Sonic;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;

class SilkPlayer$SilkPlayerThread
  extends Thread
{
  int jdField_a_of_type_Int;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private SilkCodecWrapper jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int c;
  private int d;
  
  public SilkPlayer$SilkPlayerThread(SilkPlayer paramSilkPlayer, Application paramApplication)
  {
    this.d = bfyl.a(SilkPlayer.a(paramSilkPlayer));
    this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(paramApplication, false);
    this.c = bfyl.a(this.d);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.c];
    this.jdField_b_of_type_ArrayOfByte = new byte[this.c];
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "SilkPlayerThread sampleRate=" + this.d + ", oneFrameSize=" + this.c + ", currenttime:" + System.currentTimeMillis());
    }
  }
  
  private FileInputStream a()
  {
    if (SilkPlayer.d(this.this$0) != -1)
    {
      if (SilkPlayer.d(this.this$0) != this.this$0.a()) {
        break label102;
      }
      this.jdField_b_of_type_Int = SilkPlayer.c(this.this$0);
      this.jdField_a_of_type_Int = SilkPlayer.c(this.this$0);
      SilkPlayer.a(this.this$0, -1);
    }
    FileInputStream localFileInputStream;
    for (;;)
    {
      localFileInputStream = new FileInputStream(SilkPlayer.a(this.this$0));
      if (this.jdField_b_of_type_Int != 0) {
        break;
      }
      localFileInputStream.skip(10L);
      this.jdField_a_of_type_Int += 10;
      return localFileInputStream;
      label102:
      SilkPlayer.b(this.this$0, 0);
      SilkPlayer.c(this.this$0, 0);
    }
    localFileInputStream.skip(this.jdField_b_of_type_Int);
    return localFileInputStream;
  }
  
  private void a(int paramInt)
  {
    try
    {
      SilkPlayer.c(this.this$0, paramInt);
      SilkPlayer.e(this.this$0);
      if (SilkPlayer.d(this.this$0) == -1) {
        this.this$0.d(SilkPlayer.b(this.this$0) * 20);
      }
      if ((SilkPlayer.d(this.this$0) != -1) && (this.this$0.a() >= SilkPlayer.d(this.this$0))) {
        SilkPlayer.a(this.this$0, -1);
      }
      return;
    }
    finally {}
  }
  
  private void a(Sonic paramSonic, int paramInt, byte[] paramArrayOfByte)
  {
    if ((MediaPlayerManager.a(SilkPlayer.a(this.this$0))) && (paramArrayOfByte != null) && (agkq.c)) {
      if (paramInt > 0)
      {
        paramSonic.a(this.jdField_b_of_type_ArrayOfByte, paramInt);
        paramInt = paramSonic.a();
        if (paramInt > 0)
        {
          byte[] arrayOfByte = paramArrayOfByte;
          if (paramArrayOfByte.length < paramInt) {
            arrayOfByte = new byte[paramInt * 2];
          }
          paramSonic.a(arrayOfByte, paramInt);
          this.jdField_a_of_type_AndroidMediaAudioTrack.write(arrayOfByte, 0, paramInt);
        }
      }
    }
    do
    {
      return;
      paramSonic.b();
      break;
      this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_b_of_type_ArrayOfByte, 0, this.c);
    } while (SilkPlayer.a(this.this$0) == null);
    SilkPlayer.a(this.this$0).a(this.jdField_b_of_type_ArrayOfByte);
  }
  
  private void a(boolean paramBoolean, FileInputStream paramFileInputStream)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidMediaAudioTrack != null) && (this.jdField_a_of_type_AndroidMediaAudioTrack.getState() != 0)) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
      this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
      this.jdField_a_of_type_AndroidMediaAudioTrack.release();
      if (QLog.isColorLevel()) {
        QLog.d("SilkPlayer", 2, "SilkPlayerThread onEnd, release mAudioTrack.");
      }
      this.jdField_a_of_type_AndroidMediaAudioTrack = null;
      this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.b();
      if (paramBoolean) {
        this.this$0.b();
      }
      if (paramFileInputStream == null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramFileInputStream.close();
          return;
        }
        catch (IOException paramFileInputStream)
        {
          paramFileInputStream.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  private boolean a(FileInputStream paramFileInputStream, int paramInt, Sonic paramSonic, byte[] paramArrayOfByte)
  {
    if (SilkPlayer.d(this.this$0) == -1)
    {
      int i = paramFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
      this.jdField_a_of_type_Int += paramInt;
      if (i == -1)
      {
        this.this$0.c(2);
        if (QLog.isColorLevel()) {
          QLog.d("SilkPlayer", 2, "silk decode error: failed to read frameSize=" + paramInt);
        }
      }
      do
      {
        do
        {
          return false;
        } while (!this.jdField_a_of_type_Boolean);
        paramInt = this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, paramInt, this.jdField_b_of_type_ArrayOfByte.length);
        if (paramInt != 0) {
          break;
        }
        this.this$0.c(3);
      } while (!QLog.isColorLevel());
      QLog.d("SilkPlayer", 2, "silk decode jni error");
      return false;
      if (this.jdField_a_of_type_Boolean) {
        a(paramSonic, paramInt, paramArrayOfByte);
      }
      return true;
    }
    this.jdField_a_of_type_Int += paramInt;
    paramFileInputStream.skip(paramInt);
    return true;
  }
  
  public void run()
  {
    byte[] arrayOfByte = new byte[2];
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    Process.setThreadPriority(-19);
    j = 0;
    i = j;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(this.d, 0, 1);
      i = j;
      if (!MediaPlayerManager.a(SilkPlayer.a(this.this$0))) {
        break label600;
      }
      i = j;
      if (!agkq.c) {
        break label600;
      }
      i = j;
      localSonic = new Sonic(this.d, 1);
      i = j;
      localSonic.a(SilkPlayer.a(this.this$0));
      i = j;
      localObject1 = new byte[2048];
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject1;
        boolean bool3;
        FileInputStream localFileInputStream = null;
        boolean bool1 = false;
        continue;
        bool1 = false;
        Object localObject3 = localFileInputStream;
        continue;
        localObject3 = null;
        Sonic localSonic = null;
      }
    }
    i = j;
    if (SilkPlayer.a(this.this$0) != null)
    {
      i = j;
      SilkPlayer.a(this.this$0).f();
    }
    i = j;
    j = AudioTrack.getMinBufferSize(this.d, 4, 2);
    i = j;
    this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(SilkPlayer.a(this.this$0), this.d, 4, 2, j, 1);
    i = j;
    if (QLog.isColorLevel())
    {
      i = j;
      QLog.d("SilkPlayer", 2, "start play silk mStreamType=" + SilkPlayer.a(this.this$0) + ", rate=" + this.d + ", playBufferSize = " + j + ", currentTime:" + System.currentTimeMillis());
    }
    i = j;
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
    i = j;
    localFileInputStream = a();
    for (;;)
    {
      try
      {
        if ((!this.jdField_a_of_type_Boolean) || (localFileInputStream == null)) {
          break label591;
        }
        i = localFileInputStream.read(arrayOfByte, 0, 2);
        this.jdField_a_of_type_Int += 2;
        if (i == -1)
        {
          bool3 = true;
          bool2 = true;
          bool1 = bool2;
          localObject1 = localFileInputStream;
        }
      }
      catch (Exception localException1)
      {
        boolean bool2;
        bool1 = false;
        i = j;
        QLog.e("SilkPlayer", 1, "silk play exception " + localException1.toString());
        this.this$0.a(localException1, this.jdField_a_of_type_AndroidMediaAudioTrack, this.d, i);
        this.this$0.c(4);
        Object localObject2 = localFileInputStream;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SilkPlayer", 2, "silk decode completed mCurrentPlayFrame=" + SilkPlayer.b(this.this$0) + ", mCurrentFileOffset" + SilkPlayer.c(this.this$0));
          localObject1 = localFileInputStream;
          bool1 = bool2;
        }
        a(bool1, (FileInputStream)localObject1);
        return;
      }
      catch (Exception localException3)
      {
        bool1 = bool3;
        i = j;
        continue;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        bool1 = false;
        localObject1 = localFileInputStream;
      }
      else
      {
        i = bfyl.a(arrayOfByte);
        if (i <= 0)
        {
          this.this$0.c(1);
          if (!QLog.isColorLevel()) {
            break label591;
          }
          QLog.d("SilkPlayer", 2, "silk decode error: error frame size=" + i);
          bool1 = false;
          localObject1 = localFileInputStream;
        }
        else if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = false;
          localObject1 = localFileInputStream;
        }
        else if (!a(localFileInputStream, i, localSonic, (byte[])localObject1))
        {
          bool1 = false;
          localObject1 = localFileInputStream;
        }
        else
        {
          a(this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void start()
  {
    this.jdField_a_of_type_Boolean = true;
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.SilkPlayer.SilkPlayerThread
 * JD-Core Version:    0.7.0.1
 */