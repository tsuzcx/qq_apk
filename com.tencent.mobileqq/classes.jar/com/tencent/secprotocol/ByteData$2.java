package com.tencent.secprotocol;

import com.tencent.secprotocol.utils.ByteCodeCrashProtector.IProtectedMethod;

class ByteData$2
  implements ByteCodeCrashProtector.IProtectedMethod
{
  ByteData$2(ByteData paramByteData, byte[][] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {}
  
  public void onCrashDetected()
  {
    this.this$0.logCat("poxy_java", "Something wrong when getCode .");
    this.val$ret[0] = new byte[4];
    this.val$ret[0][3] = 1;
  }
  
  public void run()
  {
    if (ByteData.access$500(this.this$0)) {
      this.val$ret[0] = ByteData.access$700(this.this$0, ByteData.access$600(this.this$0), this.val$cmd, this.val$arg1, this.val$arg2, this.val$arg3, this.val$arg4, this.val$arg5, this.val$arg6, this.val$arg7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.2
 * JD-Core Version:    0.7.0.1
 */