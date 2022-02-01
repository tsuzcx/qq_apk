package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CERenderService$onFrameCallback$2
  implements Runnable
{
  CERenderService$onFrameCallback$2(CERenderService paramCERenderService, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    IRecordFrameListener localIRecordFrameListener = CERenderService.d(this.this$0);
    if (localIRecordFrameListener != null)
    {
      byte[] arrayOfByte = this.a;
      int i = this.b;
      int j = this.c;
      localIRecordFrameListener.a(arrayOfByte, i / j / 4, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService.onFrameCallback.2
 * JD-Core Version:    0.7.0.1
 */