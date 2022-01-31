package com.tencent.secprotocol;

import com.tencent.secprotocol.utils.ByteCodeCrashProtector.IProtectedMethod;

class ByteData$2
  implements ByteCodeCrashProtector.IProtectedMethod
{
  ByteData$2(ByteData paramByteData, Object paramObject) {}
  
  public void onCrashDetected()
  {
    this.this$0.logCat("poxy_java", "Something wrong when putbyte .");
  }
  
  public void run()
  {
    try
    {
      int i = ByteData.access$800(this.this$0, null, 1L, 0L, 0L, 0L, this.val$obj, "", null, null);
      if (i != 0) {
        this.this$0.logCat("poxy_java", "report log err！ ret: " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.2
 * JD-Core Version:    0.7.0.1
 */