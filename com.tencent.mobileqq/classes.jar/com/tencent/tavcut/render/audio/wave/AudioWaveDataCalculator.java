package com.tencent.tavcut.render.audio.wave;

import com.tencent.tavcut.render.log.TavLogger;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/wave/AudioWaveDataCalculator;", "Lcom/tencent/tavcut/render/audio/wave/IAudioWaveDataCalculator;", "sampleRate", "", "channelCount", "encodingPcmBit", "perSecondSample", "(IIII)V", "getChannelCount", "()I", "getEncodingPcmBit", "filterLength", "getPerSecondSample", "sampleCount", "getSampleRate", "sumSample", "", "waveFormData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioPcmToWaveData", "", "pcmByteBuffer", "Ljava/nio/ByteBuffer;", "decimateByteSample", "", "input", "decimateFloatSample", "Ljava/nio/FloatBuffer;", "decimateShortSample", "Ljava/nio/ShortBuffer;", "getWaveDataList", "putData", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class AudioWaveDataCalculator
  implements IAudioWaveDataCalculator
{
  public static final AudioWaveDataCalculator.Companion a = new AudioWaveDataCalculator.Companion(null);
  private final ArrayList<Float> b;
  private int c;
  private double d;
  private int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  
  public AudioWaveDataCalculator(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramInt4;
    this.b = new ArrayList();
    this.e = -1;
    this.e = (this.f * this.g / this.i);
  }
  
  private final void a(FloatBuffer paramFloatBuffer)
  {
    while (paramFloatBuffer.hasRemaining())
    {
      float f1 = paramFloatBuffer.get();
      double d1 = this.d;
      double d2 = Math.abs(f1);
      Double.isNaN(d2);
      this.d = (d1 + d2);
      b();
    }
  }
  
  private final void a(ShortBuffer paramShortBuffer)
  {
    while (paramShortBuffer.hasRemaining())
    {
      int j = paramShortBuffer.get();
      double d1 = this.d;
      double d2 = Math.abs(j);
      Double.isNaN(d2);
      this.d = (d1 + d2);
      b();
    }
  }
  
  private final void b()
  {
    this.c += 1;
    int j = this.c;
    if (j >= this.e)
    {
      int k = this.h;
      double d1;
      double d2;
      if (k != 2) {
        if (k != 3) {
          if (k != 4)
          {
            d1 = this.d;
            d2 = j * 32767;
            Double.isNaN(d2);
          }
        }
      }
      for (;;)
      {
        d1 /= d2;
        break;
        d1 = this.d;
        d2 = j * FloatCompanionObject.INSTANCE.getMAX_VALUE();
        Double.isNaN(d2);
        continue;
        d1 = this.d;
        d2 = j * 127;
        Double.isNaN(d2);
        continue;
        d1 = this.d;
        d2 = j * 32767;
        Double.isNaN(d2);
      }
      this.b.add(Float.valueOf(Math.abs((float)d1)));
      this.c = 0;
      this.d = 0.0D;
    }
  }
  
  private final void b(ByteBuffer paramByteBuffer)
  {
    while (paramByteBuffer.hasRemaining())
    {
      int j = paramByteBuffer.get();
      double d1 = this.d;
      double d2 = Math.abs(j);
      Double.isNaN(d2);
      this.d = (d1 + d2);
      b();
    }
  }
  
  @NotNull
  public List<Float> a()
  {
    return (List)this.b;
  }
  
  @NotNull
  public List<Float> a(@NotNull ByteBuffer paramByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "pcmByteBuffer");
    int j = this.h;
    if (j != 2)
    {
      if (j != 3)
      {
        if (j != 4)
        {
          paramByteBuffer = new StringBuilder();
          paramByteBuffer.append("not support bitWidth  = ");
          paramByteBuffer.append(this.h);
          paramByteBuffer.append(' ');
          TavLogger.e("WaveDataCalculator", paramByteBuffer.toString());
        }
        else
        {
          paramByteBuffer = paramByteBuffer.asFloatBuffer();
          Intrinsics.checkExpressionValueIsNotNull(paramByteBuffer, "pcmByteBuffer.asFloatBuffer()");
          a(paramByteBuffer);
        }
      }
      else {
        b(paramByteBuffer);
      }
    }
    else
    {
      paramByteBuffer = paramByteBuffer.asShortBuffer();
      Intrinsics.checkExpressionValueIsNotNull(paramByteBuffer, "pcmByteBuffer.asShortBuffer()");
      a(paramByteBuffer);
    }
    return (List)this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.wave.AudioWaveDataCalculator
 * JD-Core Version:    0.7.0.1
 */