package com.tencent.secprotocol;

import com.tencent.secprotocol.utils.ByteCodeCrashProtector.IProtectedMethod;

class ByteData$1
  implements ByteCodeCrashProtector.IProtectedMethod
{
  ByteData$1(ByteData paramByteData) {}
  
  public void onCrashDetected()
  {
    this.this$0.logCat("poxy_java", "Something wrong when load native so.");
  }
  
  public void run()
  {
    if (ByteData.access$000(this.this$0)) {
      return;
    }
    try
    {
      if (!ByteData.access$100(this.this$0)) {
        System.loadLibrary("poxy");
      }
      ByteData.access$002(this.this$0, true);
      ByteData.access$202(this.this$0, true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ByteData.access$300(this.this$0)[1] = 1;
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.1
 * JD-Core Version:    0.7.0.1
 */