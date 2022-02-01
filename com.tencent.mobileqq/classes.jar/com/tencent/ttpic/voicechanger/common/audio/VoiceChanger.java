package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class VoiceChanger
{
  public static final double FRAME_DURATION = 0.02D;
  private static final String TAG = "VoiceChanger";
  private long changer;
  private int environment;
  private int frameLength;
  private String outputPath;
  private int sampleRate;
  private int voiceKind;
  
  public VoiceChanger(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.outputPath = paramString;
    this.sampleRate = paramInt1;
    double d = paramInt1;
    Double.isNaN(d);
    this.frameLength = ((int)(d * 0.02D));
    this.voiceKind = paramInt2;
    this.environment = paramInt3;
    this.changer = initVoiceChanger(paramInt1, paramInt2, paramInt3);
  }
  
  private native short[] changeFrames(short[] paramArrayOfShort);
  
  public static native int changeVoice4File(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int demo(String paramString1, String paramString2, int paramInt);
  
  public static native long initVoiceChanger(int paramInt1, int paramInt2, int paramInt3);
  
  private native void releaseVoiceChanger();
  
  private byte[] short2Byte(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    byte[] arrayOfByte = new byte[j * 2];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      arrayOfByte[k] = ((byte)(paramArrayOfShort[i] & 0xFF));
      arrayOfByte[(k + 1)] = ((byte)(paramArrayOfShort[i] >> 8));
      paramArrayOfShort[i] = 0;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static native String stringFromJNI();
  
  public static byte[] toByteArray(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    byte[] arrayOfByte = new byte[j << 1];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      arrayOfByte[k] = ((byte)(paramArrayOfShort[i] >> 8));
      arrayOfByte[(k + 1)] = ((byte)(paramArrayOfShort[i] >> 0));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public byte[] getBytes(short paramShort, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean)
    {
      i = arrayOfByte.length - 1;
      while (i >= 0)
      {
        arrayOfByte[i] = ((byte)(paramShort & 0xFF));
        paramShort = (short)(paramShort >> 8);
        i -= 1;
      }
    }
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramShort & 0xFF));
      paramShort = (short)(paramShort >> 8);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public void release()
  {
    releaseVoiceChanger();
    LogUtils.i(TAG, "releaseVoiceChanger()");
  }
  
  public byte[] shorts2Bytes(short[] paramArrayOfShort)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfShort.length * 2];
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      byte[] arrayOfByte2 = getBytes(paramArrayOfShort[i], false);
      int j = 0;
      while (j < 2)
      {
        arrayOfByte1[(i * 2 + j)] = arrayOfByte2[j];
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public short[] writeVoiceFrameByShort(short[] paramArrayOfShort)
  {
    LogUtils.i(TAG, "writeVoiceFrames()");
    return changeFrames(paramArrayOfShort);
  }
  
  public byte[] writeVoiceFrames(short[] paramArrayOfShort)
  {
    LogUtils.i(TAG, "writeVoiceFrames()");
    paramArrayOfShort = changeFrames(paramArrayOfShort);
    if (paramArrayOfShort == null) {
      return null;
    }
    return short2Byte(paramArrayOfShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceChanger
 * JD-Core Version:    0.7.0.1
 */