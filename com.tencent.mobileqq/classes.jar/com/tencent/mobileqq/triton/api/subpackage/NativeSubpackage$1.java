package com.tencent.mobileqq.triton.api.subpackage;

import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.ITSubPackage;

class NativeSubpackage$1
  implements ITSubPackage
{
  NativeSubpackage$1(NativeSubpackage paramNativeSubpackage) {}
  
  public void loadFinish(long paramLong, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      TTLog.e("NativeSubpackage", "NativeSubpackage loadfinish not success");
    }
    NativeSubpackage.access$000(this.this$0, paramString);
    NativeSubpackage.access$100(paramLong, paramBoolean);
  }
  
  public void onProgressChange(long paramLong1, float paramFloat, long paramLong2, long paramLong3)
  {
    NativeSubpackage.access$200(paramLong1, paramFloat, paramLong2, paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.subpackage.NativeSubpackage.1
 * JD-Core Version:    0.7.0.1
 */