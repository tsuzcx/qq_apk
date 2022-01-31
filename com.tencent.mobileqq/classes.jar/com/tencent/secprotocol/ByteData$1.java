package com.tencent.secprotocol;

import com.tencent.secprotocol.utils.ByteCodeCrashProtector.IProtectedMethod;

class ByteData$1
  implements ByteCodeCrashProtector.IProtectedMethod
{
  ByteData$1(ByteData paramByteData, Object paramObject) {}
  
  public void onCrashDetected()
  {
    this.this$0.logCat("poxy_java", "Something wrong when putbyte .");
  }
  
  public void run()
  {
    try
    {
      int i = ByteData.access$400(this.this$0, null, 1L, 0L, 0L, 0L, this.val$obj, "", null, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.1
 * JD-Core Version:    0.7.0.1
 */