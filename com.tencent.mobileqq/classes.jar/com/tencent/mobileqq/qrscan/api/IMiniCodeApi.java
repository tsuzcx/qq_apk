package com.tencent.mobileqq.qrscan.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.OnMiniCodeDetectCallback;
import com.tencent.mobileqq.qrscan.OnMiniCodeInitCallback;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IMiniCodeApi
  extends QRouteApi
{
  public abstract void addDetectCallback(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback);
  
  public abstract void addInitCallback(OnMiniCodeInitCallback paramOnMiniCodeInitCallback);
  
  public abstract boolean bValidDecodeResult(String paramString);
  
  public abstract String decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public abstract boolean detect(Bitmap paramBitmap, long paramLong);
  
  public abstract boolean detectSync(Bitmap paramBitmap, ArrayList<AIRect> paramArrayList);
  
  public abstract int getSupportDetectType();
  
  public abstract void init(Context paramContext, long paramLong, String paramString);
  
  public abstract boolean isDecodeInited();
  
  public abstract boolean isDetectInited();
  
  public abstract boolean isDetectReady();
  
  public abstract void removeDetectCallback(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback);
  
  public abstract void removeInitCallback(OnMiniCodeInitCallback paramOnMiniCodeInitCallback);
  
  public abstract void unInit(long paramLong, String paramString);
  
  public abstract int yuv2Rgba(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IMiniCodeApi
 * JD-Core Version:    0.7.0.1
 */