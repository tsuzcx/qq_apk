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
    long l2 = this.a;
    long l1 = 0L;
    if (l2 != 0L) {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4))
      {
        if (paramInt == 3)
        {
          int i = paramResultBundle.a;
          int j = paramResultBundle.b;
          int k = paramResultBundle.c;
          int m = paramResultBundle.e;
          paramDetectBundle = paramResultBundle.g;
          l2 = this.a;
          long l3 = paramInt;
          if (paramResultBundle.f) {
            l1 = 1L;
          }
          QSecFramework.a(5L, l2, l3, l1, null, null, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), paramDetectBundle }, null);
        }
      }
      else {
        QSecFramework.a(5L, this.a, paramInt, 0L, null, null, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.NativeEventListenerWrapper
 * JD-Core Version:    0.7.0.1
 */