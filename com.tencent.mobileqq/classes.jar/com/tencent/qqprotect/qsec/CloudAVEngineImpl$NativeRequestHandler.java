package com.tencent.qqprotect.qsec;

final class CloudAVEngineImpl$NativeRequestHandler
  implements QSecFramework.IGoingUpHandler
{
  private CloudAVEngineImpl$NativeRequestHandler(CloudAVEngineImpl paramCloudAVEngineImpl) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramLong1 == 2L) {}
    try
    {
      this.a.flushRequest();
      return 0;
    }
    catch (Exception paramObject1)
    {
      do
      {
        int j;
        int i;
        break label249;
      } while (paramArrayOfObject1[0] != null);
      return 13;
    }
    j = 13;
    i = j;
    boolean bool2;
    if (paramObject1 != null)
    {
      i = j;
      if (paramObject2 != null)
      {
        i = j;
        if (paramArrayOfObject1 != null)
        {
          if (paramArrayOfObject1.length >= 6) {
            break label265;
          }
          return 13;
          paramArrayOfObject2 = null;
          if (paramLong2 == 0L) {
            break label275;
          }
          paramArrayOfObject2 = new CloudAVEngineImpl.NativeEventListenerWrapper(paramLong2);
          break label275;
          if (((Integer)paramObject1).intValue() == 0) {
            break label294;
          }
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      if (((Integer)paramObject2).intValue() == 1)
      {
        paramObject1 = new ICloudAVEngine.ApkDetectBundle((String)paramArrayOfObject1[2]);
      }
      else
      {
        paramObject1 = new ICloudAVEngine.DetectBundle();
        paramObject1.jdField_a_of_type_Int = ((Integer)paramObject2).intValue();
        paramObject1.b = ((Integer)paramArrayOfObject1[0]).intValue();
        paramObject1.jdField_a_of_type_JavaLangString = ((String)paramArrayOfObject1[1]);
        paramObject1.c = ((String)paramArrayOfObject1[2]);
        paramObject1.d = ((String)paramArrayOfObject1[3]);
        paramObject1.e = ((String)paramArrayOfObject1[4]);
        paramObject1.jdField_a_of_type_ArrayOfByte = ((byte[])paramArrayOfObject1[5]);
      }
      i = this.a.cloudDetect(paramObject1, bool1, bool2, paramArrayOfObject2);
      return i;
      label249:
      paramObject1.printStackTrace();
      i = -1;
      return i;
      label265:
      label275:
      if (paramLong3 != 0L)
      {
        bool1 = true;
        break;
      }
      boolean bool1 = false;
      break;
      label294:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.NativeRequestHandler
 * JD-Core Version:    0.7.0.1
 */