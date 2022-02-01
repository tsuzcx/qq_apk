package com.tencent.qqprotect.qsec;

final class CloudAVEngineImpl$NativeEventListenerWrapper
  implements ICloudAVEngine.IAVEngineEventListener
{
  private long a;
  
  public CloudAVEngineImpl$NativeEventListenerWrapper(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(int paramInt, ICloudAVEngine.DetectBundle paramDetectBundle, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    long l1 = 0L;
    if (this.a != 0L)
    {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4)) {
        break label46;
      }
      QSecFramework.a(5L, this.a, paramInt, 0L, null, null, null, null);
    }
    label46:
    while (paramInt != 3) {
      return;
    }
    int i = paramResultBundle.jdField_a_of_type_Int;
    int j = paramResultBundle.b;
    int k = paramResultBundle.c;
    int m = paramResultBundle.d;
    paramDetectBundle = paramResultBundle.jdField_a_of_type_ArrayOfByte;
    long l2 = this.a;
    long l3 = paramInt;
    if (paramResultBundle.jdField_a_of_type_Boolean) {
      l1 = 1L;
    }
    QSecFramework.a(5L, l2, l3, l1, null, null, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), paramDetectBundle }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.NativeEventListenerWrapper
 * JD-Core Version:    0.7.0.1
 */