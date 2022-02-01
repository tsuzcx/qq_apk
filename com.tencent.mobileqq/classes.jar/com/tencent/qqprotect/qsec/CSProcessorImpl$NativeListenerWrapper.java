package com.tencent.qqprotect.qsec;

class CSProcessorImpl$NativeListenerWrapper
  implements ICSProcessor.ICSProcessorListener
{
  protected long a;
  
  public CSProcessorImpl$NativeListenerWrapper(CSProcessorImpl paramCSProcessorImpl, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    long l = this.jdField_a_of_type_Long;
    if (l != 0L) {
      QSecFramework.a(7L, l, paramInt, 0L, paramArrayOfByte1, paramArrayOfByte2, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CSProcessorImpl.NativeListenerWrapper
 * JD-Core Version:    0.7.0.1
 */