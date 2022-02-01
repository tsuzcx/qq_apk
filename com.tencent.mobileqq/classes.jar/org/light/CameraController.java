package org.light;

import android.graphics.PointF;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.light.bean.ArFrameInfo;

public class CameraController
  extends Controller
{
  private native void nGetFilamentAssetPosition(CameraController.FilaPositionCallback paramFilaPositionCallback);
  
  private native void nGetHitTestFilamentAssets(float[] paramArrayOfFloat, CameraController.HitTestFilaCallback paramHitTestFilaCallback);
  
  private native void nUpdateCameraTextureTimestamp(long paramLong);
  
  private native void nativeRelease();
  
  private native void nativeUpdateTouchEvent(int paramInt1, long paramLong1, long paramLong2, int paramInt2, float[][] paramArrayOfFloat, int paramInt3, int paramInt4);
  
  protected void finalize()
  {
    super.finalize();
    release();
  }
  
  public void getFilamentAssetPosition(CameraController.FilaPositionCallback paramFilaPositionCallback)
  {
    nGetFilamentAssetPosition(paramFilaPositionCallback);
  }
  
  public void getHitTestFilamentAssets(float[] paramArrayOfFloat, CameraController.HitTestFilaCallback paramHitTestFilaCallback)
  {
    nGetHitTestFilamentAssets(paramArrayOfFloat, paramHitTestFilaCallback);
  }
  
  public boolean needCyberpunkStyleAbility()
  {
    return needStylizedAbility("CyberpunkStyleFilter");
  }
  
  public native boolean needStylizedAbility(String paramString);
  
  public native void pause3DAnimation();
  
  public native void register3DAnimation(List<String> paramList);
  
  public void release()
  {
    nativeRelease();
  }
  
  public native void resume3DAnimation();
  
  public native void rotateArModelToFront(int paramInt);
  
  public native void setARFrameInfo(ArFrameInfo paramArFrameInfo);
  
  public native void setHitTestAfterUnprojection(float[] paramArrayOfFloat);
  
  public native void setKapuAnimation(String paramString, CameraController.CmShowCallback paramCmShowCallback);
  
  public native void setKapuCameraViewType(CameraController.CameraViewType paramCameraViewType);
  
  public native void setKapuDisplayType(CameraController.DisplayType paramDisplayType);
  
  public native void setKapuModel(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback);
  
  public native void setSegmentationFastMode(boolean paramBoolean);
  
  public int type()
  {
    return 1;
  }
  
  public void updateCameraTextureTimestamp(long paramLong)
  {
    long l2 = SystemClock.elapsedRealtimeNanos() / 1000000L;
    long l3 = SystemClock.uptimeMillis();
    long l1 = paramLong;
    if (Math.abs(l2 - paramLong) > Math.abs(l3 - paramLong)) {
      l1 = paramLong + (l2 - l3);
    }
    nUpdateCameraTextureTimestamp(l1);
  }
  
  public native void updateKapuMorph(CameraController.MorphType paramMorphType);
  
  public void updateTouchEvent(int paramInt1, long paramLong1, long paramLong2, ArrayList<PointF> paramArrayList, int paramInt2, int paramInt3)
  {
    int j = paramArrayList.size();
    if (j <= 0) {
      return;
    }
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { j, 2 });
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[i][0] = ((PointF)paramArrayList.get(i)).x;
      arrayOfFloat[i][1] = ((PointF)paramArrayList.get(i)).y;
      i += 1;
    }
    nativeUpdateTouchEvent(paramInt1, paramLong1, paramLong2, j, arrayOfFloat, paramInt2, paramInt3);
  }
  
  public native void updateTouchRotate(float[] paramArrayOfFloat);
  
  public native void updateTouchScale(float paramFloat);
  
  public native void updateViewParams(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.CameraController
 * JD-Core Version:    0.7.0.1
 */