package com.tencent.mobileqq.triton.audio;

public class AudioNativeManager
{
  public static native void adJustSourceGain(int paramInt, float paramFloat);
  
  public static native void addGain();
  
  public static native void bindBufferToSource(int paramInt1, int paramInt2);
  
  public static native void closeAudioContext();
  
  public static native int copyToChannel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int createBuffer(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int createBufferSource();
  
  public static native void createScriptProcessorNode(int paramInt1, int paramInt2, int paramInt3);
  
  public static native byte[] getBufferChannelData(int paramInt1, int paramInt2);
  
  public static native float getChannelConeInnerAngle(int paramInt);
  
  public static native float getChannelConeOuterAngle(int paramInt);
  
  public static native float getChannelConeOuterGain(int paramInt);
  
  public static native float getCurrentGain(int paramInt);
  
  public static native void initAudioContext();
  
  public static native void initOpenAL();
  
  public static native boolean isSourceStopped(int paramInt);
  
  public static native int loadRawData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void lossGain();
  
  public static native int onAudioProcess(int paramInt);
  
  public static native void pauseSource(int paramInt);
  
  public static native void play(int paramInt, float paramFloat);
  
  public static native void resumeAudioContext();
  
  public static native void resumeSource(int paramInt);
  
  public static native void setBufferSourceLoop(int paramInt, boolean paramBoolean);
  
  public static native float setChannelConeInnerAngle(int paramInt, float paramFloat);
  
  public static native float setChannelConeOuterAngle(int paramInt, float paramFloat);
  
  public static native float setChannelConeOuterGain(int paramInt, float paramFloat);
  
  public static native void setChannelPosition(int paramInt, float[] paramArrayOfFloat);
  
  public static native void setCurrentGain(int paramInt, float paramFloat);
  
  public static native void setQueueBuffer(int paramInt1, int paramInt2);
  
  public static native void stopSource(int paramInt);
  
  public static native void suspendAudioContext();
  
  public static native void testEndFunction();
  
  public static native void testInitFunction();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.AudioNativeManager
 * JD-Core Version:    0.7.0.1
 */