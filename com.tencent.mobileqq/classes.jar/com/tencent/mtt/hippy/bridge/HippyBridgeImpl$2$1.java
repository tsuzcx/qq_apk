package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.a.g;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

class HippyBridgeImpl$2$1
  implements g
{
  HippyBridgeImpl$2$1(HippyBridgeImpl.2 param2) {}
  
  public void onDevBundleLoadReady(InputStream paramInputStream)
  {
    try
    {
      localObject = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[2048];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
      }
      paramInputStream = ((ByteArrayOutputStream)localObject).toByteArray();
      if (paramInputStream != null)
      {
        localObject = ByteBuffer.allocateDirect(paramInputStream.length);
        ((ByteBuffer)localObject).put(paramInputStream);
        this.a.c.onResourceReady((ByteBuffer)localObject, HippyBridgeImpl.access$200(this.a.c), this.a.b);
        return;
      }
      LogUtils.e("HippyBridgeImpl", "fetchResourceWithUri: output buffer length==0!!!");
      this.a.c.onResourceReady(null, HippyBridgeImpl.access$200(this.a.c), this.a.b);
      return;
    }
    catch (Throwable paramInputStream)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchResourceWithUri: load failed!!! ");
      ((StringBuilder)localObject).append(paramInputStream.getMessage());
      LogUtils.e("HippyBridgeImpl", ((StringBuilder)localObject).toString());
      this.a.c.onResourceReady(null, HippyBridgeImpl.access$200(this.a.c), this.a.b);
    }
  }
  
  public void onDevBundleReLoad() {}
  
  public void onInitDevError(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requireSubResource: ");
    localStringBuilder.append(paramThrowable.getMessage());
    LogUtils.e("hippy", localStringBuilder.toString());
    this.a.c.onResourceReady(null, HippyBridgeImpl.access$200(this.a.c), this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl.2.1
 * JD-Core Version:    0.7.0.1
 */