package com.tencent.mobileqq.qqaudio.audioprocessor;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.utils.QPipedInputStream;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class AudioComponentProcessor
  extends InputStream
  implements IAudioProcessor
{
  protected Context a;
  protected PipedOutputStream b;
  protected PipedInputStream c;
  protected byte[] d;
  protected byte[] e;
  protected byte[] f;
  protected IAudioProcessor.ProcessData g;
  protected byte[] h = new byte[1];
  protected int i;
  
  public AudioComponentProcessor(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return read(paramArrayOfByte, paramInt, paramArrayOfByte.length);
  }
  
  public IAudioProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.g.a = 0;
    while (paramInt2 > 0)
    {
      int j;
      if (paramInt2 > 1920 - this.c.available()) {
        j = 1920 - this.c.available();
      } else {
        j = paramInt2;
      }
      b(paramArrayOfByte, paramInt1, j);
      paramInt1 += j;
      paramInt2 -= j;
    }
    return this.g;
  }
  
  public void a()
  {
    PipedOutputStream localPipedOutputStream = this.b;
    if (localPipedOutputStream != null)
    {
      localPipedOutputStream.close();
      this.b = null;
    }
    close();
  }
  
  @TargetApi(9)
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = new PipedOutputStream();
    if (Build.VERSION.SDK_INT <= 8)
    {
      this.c = new QPipedInputStream(this.b, 1920);
      return;
    }
    this.c = new PipedInputStream(this.b, 1920);
  }
  
  protected void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.b.write(paramArrayOfByte, paramInt1, paramInt2);
    while (this.c.available() >= this.i)
    {
      paramInt1 = a(this.f, this.g.a);
      paramArrayOfByte = this.g;
      paramArrayOfByte.a += paramInt1;
    }
  }
  
  public void close()
  {
    PipedInputStream localPipedInputStream = this.c;
    if (localPipedInputStream != null)
    {
      localPipedInputStream.close();
      this.c = null;
    }
  }
  
  public int read()
  {
    if (read(this.h, 0, 1) == 1) {
      return this.h[0] & 0xFF;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor
 * JD-Core Version:    0.7.0.1
 */