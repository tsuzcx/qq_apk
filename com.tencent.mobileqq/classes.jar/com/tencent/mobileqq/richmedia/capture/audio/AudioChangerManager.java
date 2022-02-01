package com.tencent.mobileqq.richmedia.capture.audio;

import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.videocodec.audio.AudioCapture.AudioCaptureListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder.AudioEncodeListener;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceChanger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class AudioChangerManager
  implements HWAudioEncoder.AudioEncodeListener
{
  public static int b = com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.SAMPLE_RATES[4];
  public static int c;
  protected VoiceChanger a;
  HWAudioEncoder d;
  private final String e = "AudioChangerManager";
  private RandomAccessFile f = null;
  private int g;
  private boolean h = false;
  private boolean i = false;
  private String j;
  private int k;
  private String l = null;
  private String m = null;
  private AudioCapture.AudioCaptureListener n;
  private byte[] o = null;
  private int p = 0;
  
  static
  {
    double d1 = b;
    Double.isNaN(d1);
    c = (int)(d1 * 0.02D * 1.0D * 4.0D);
  }
  
  public AudioChangerManager(String paramString, int paramInt, AudioCapture.AudioCaptureListener paramAudioCaptureListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtils.genSeperateFileDir(paramString));
    localStringBuilder.append("audio_data_cache");
    localStringBuilder.append(File.separator);
    this.m = localStringBuilder.toString();
    this.n = paramAudioCaptureListener;
  }
  
  private boolean f()
  {
    return (g()) && (!TextUtils.isEmpty(this.m)) && (this.n != null);
  }
  
  private boolean g()
  {
    try
    {
      File localFile = new File(this.m);
      if (!localFile.exists()) {
        return localFile.mkdir();
      }
      if (localFile.isFile())
      {
        localFile.delete();
        boolean bool = localFile.mkdir();
        return bool;
      }
      return true;
    }
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    return false;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.h = paramBoolean;
    this.g = paramInt1;
    this.k = paramInt2;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.i = paramBoolean;
    this.j = paramString;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((a()) && (f()))
    {
      paramInt1 = 0;
      Object localObject;
      for (;;)
      {
        int i1 = c;
        if (paramInt2 < i1) {
          break;
        }
        localObject = this.o;
        if (localObject == null) {
          return;
        }
        int i2 = this.p;
        System.arraycopy(paramArrayOfByte, paramInt1, localObject, i2, i1 - i2);
        localObject = new short[c / 2];
        ByteBuffer.wrap(this.o).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])localObject);
        localObject = this.a.writeVoiceFrames((short[])localObject);
        if (localObject == null) {
          return;
        }
        try
        {
          if (!this.i) {
            this.f.write((byte[])localObject, 0, localObject.length);
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        if ((this.d != null) && (this.i))
        {
          byte[] arrayOfByte = new byte[localObject.length];
          System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
          this.d.a(arrayOfByte, 0L);
        }
        i1 = c;
        i2 = this.p;
        paramInt1 += i1 - i2;
        paramInt2 -= i1 - i2;
        this.p = 0;
      }
      if (paramInt2 > 0)
      {
        localObject = this.o;
        if (localObject == null) {
          return;
        }
        System.arraycopy(paramArrayOfByte, paramInt1, localObject, this.p, paramInt2);
        this.p = paramInt2;
      }
    }
  }
  
  public boolean a()
  {
    return (this.h) && (FeatureManager.Features.LIGHT_SDK.isFunctionReady());
  }
  
  public void b()
  {
    if (!f()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m);
    localStringBuilder.append(VidUtil.generateVid());
    localStringBuilder.append(".pcm");
    this.l = localStringBuilder.toString();
    this.a = new VoiceChanger(this.l, b, this.g, this.k);
    try
    {
      this.f = new RandomAccessFile(this.l, "rw");
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    if (this.o == null) {
      this.o = new byte[c];
    }
    this.p = 0;
    if ((this.i) && (this.d == null))
    {
      this.d = new HWAudioEncoder();
      this.d.a(CodecParam.mAudioSampleRate);
      this.d.a(this);
      this.d.a(this.j);
      AEQLog.a("AudioChangerManager", "New mHwAudioEncoder");
    }
  }
  
  public void c()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((VoiceChanger)localObject).release();
    }
    localObject = this.f;
    if (localObject != null) {
      try
      {
        ((RandomAccessFile)localObject).close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    this.o = null;
    HWAudioEncoder localHWAudioEncoder = this.d;
    if (localHWAudioEncoder != null) {
      localHWAudioEncoder.c();
    }
    if (!this.i) {
      this.n.onAudioChangeCaptured(this.l);
    }
  }
  
  public void d()
  {
    AEQLog.a("AudioChangerManager", "[onAudioFileEncoded]");
    this.n.onAudioChangeCaptured(this.j);
    this.d = null;
  }
  
  public void e()
  {
    AEQLog.a("AudioChangerManager", "[onAudioFileEncodeFailed]");
    AudioCapture.AudioCaptureListener localAudioCaptureListener = this.n;
    if (localAudioCaptureListener != null) {
      localAudioCaptureListener.onAudioError(-6);
    }
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioChangerManager
 * JD-Core Version:    0.7.0.1
 */