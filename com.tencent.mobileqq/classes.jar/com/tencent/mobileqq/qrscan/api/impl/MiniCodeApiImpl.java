package com.tencent.mobileqq.qrscan.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.OnMiniCodeDetectCallback;
import com.tencent.mobileqq.qrscan.OnMiniCodeInitCallback;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.minicode.MiniCodeController;
import com.tencent.mobileqq.qrscan.minicode.MiniCodeUtil;
import java.util.ArrayList;

public class MiniCodeApiImpl
  implements IMiniCodeApi
{
  public void addDetectCallback(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    MiniCodeController.a().a(paramOnMiniCodeDetectCallback);
  }
  
  public void addInitCallback(OnMiniCodeInitCallback paramOnMiniCodeInitCallback)
  {
    MiniCodeController.a().a(paramOnMiniCodeInitCallback);
  }
  
  public boolean bValidDecodeResult(String paramString)
  {
    return MiniCodeController.a(paramString);
  }
  
  public String decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return MiniCodeController.a().a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public String decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return MiniCodeController.a().a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public boolean detect(Bitmap paramBitmap, long paramLong)
  {
    return MiniCodeController.a().a(paramBitmap, paramLong);
  }
  
  public boolean detectSync(Bitmap paramBitmap, ArrayList<AIRect> paramArrayList)
  {
    return MiniCodeController.a().a(paramBitmap, paramArrayList);
  }
  
  public int getSupportDetectType()
  {
    return MiniCodeUtil.f();
  }
  
  public void init(Context paramContext, long paramLong, String paramString)
  {
    MiniCodeController.a().a(paramContext, paramLong, paramString);
  }
  
  public boolean isDecodeInited()
  {
    return MiniCodeController.b();
  }
  
  public boolean isDetectInited()
  {
    return MiniCodeController.c();
  }
  
  public boolean isDetectReady()
  {
    return MiniCodeController.a().d();
  }
  
  public void removeDetectCallback(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    MiniCodeController.a().b(paramOnMiniCodeDetectCallback);
  }
  
  public void removeInitCallback(OnMiniCodeInitCallback paramOnMiniCodeInitCallback)
  {
    MiniCodeController.a().b(paramOnMiniCodeInitCallback);
  }
  
  public void unInit(long paramLong, String paramString)
  {
    MiniCodeController.a().a(paramLong, paramString);
  }
  
  public int yuv2Rgba(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return MiniCodeController.a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.MiniCodeApiImpl
 * JD-Core Version:    0.7.0.1
 */