package com.tencent.mobileqq.utils;

public class NoiseSuppression
{
  public static int a;
  private static NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int b = com.tencent.mobileqq.qqaudio.QQAudioUtils.a[0];
  private int c = 0;
  
  static
  {
    jdField_a_of_type_Int = 160;
  }
  
  private native int nativeCreate();
  
  private native int nativeInit(int paramInt1, int paramInt2);
  
  private native int nativeProcess(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private native int nativeRelease(int paramInt);
  
  private native int nativeSetPolicy(int paramInt1, int paramInt2);
  
  public int a()
  {
    int i = this.c;
    if (i != 0) {
      return nativeRelease(i);
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 80) && (paramInt2 != 160) && (paramInt2 != jdField_a_of_type_Int)) {
      throw new IllegalArgumentException();
    }
    int i = this.c;
    if (i != 0) {
      return nativeProcess(i, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
  
  protected void finalize()
  {
    super.finalize();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NoiseSuppression
 * JD-Core Version:    0.7.0.1
 */