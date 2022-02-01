package org.light;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import org.light.bean.BodyData;
import org.light.bean.FaceData;
import org.light.bean.HandData;
import org.light.listener.AIDataListener;
import org.light.listener.TipsListener;

public class VideoOutput
{
  private static AIDataListener aiDataListener;
  private long nativeContext;
  
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  private static native void nativeGetBodyPoints(Object paramObject, int paramInt);
  
  private static native void nativeGetFacePoints(Object paramObject, int paramInt);
  
  private static native void nativeGetHandPoints(Object paramObject, int paramInt);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeSetAIDataListener();
  
  private native void nativeSetTipsListener(TipsListener paramTipsListener);
  
  public static void onBodyDataUpdated(int paramInt1, int paramInt2)
  {
    if (aiDataListener != null)
    {
      ArrayList localArrayList = new ArrayList();
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2 * 4).order(ByteOrder.nativeOrder());
      int i = 0;
      while (i < paramInt1)
      {
        localByteBuffer.position(0);
        nativeGetBodyPoints(localByteBuffer, i);
        BodyData localBodyData = new BodyData();
        localBodyData.points = new float[paramInt2];
        localByteBuffer.asFloatBuffer().get(localBodyData.points);
        localArrayList.add(localBodyData);
        i += 1;
      }
      aiDataListener.onBodyDataUpdated(localArrayList);
    }
  }
  
  public static void onFaceDataUpdated(int paramInt1, int paramInt2)
  {
    if (aiDataListener != null)
    {
      ArrayList localArrayList = new ArrayList();
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2 * 4).order(ByteOrder.nativeOrder());
      int i = 0;
      while (i < paramInt1)
      {
        localByteBuffer.position(0);
        nativeGetFacePoints(localByteBuffer, i);
        FaceData localFaceData = new FaceData();
        localFaceData.points = new float[paramInt2];
        localByteBuffer.asFloatBuffer().get(localFaceData.points);
        localArrayList.add(localFaceData);
        i += 1;
      }
      aiDataListener.onFaceDataUpdated(localArrayList);
    }
  }
  
  public static void onHandDataUpdated(int paramInt1, int paramInt2)
  {
    if (aiDataListener != null)
    {
      ArrayList localArrayList = new ArrayList();
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2 * 4).order(ByteOrder.nativeOrder());
      int i = 0;
      while (i < paramInt1)
      {
        localByteBuffer.position(0);
        nativeGetHandPoints(localByteBuffer, i);
        HandData localHandData = new HandData();
        localHandData.points = new float[paramInt2];
        localByteBuffer.asFloatBuffer().get(localHandData.points);
        localArrayList.add(localHandData);
        i += 1;
      }
      aiDataListener.onHandDataUpdated(localArrayList);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize();
  }
  
  public final native void nativeFinalize();
  
  public native void readSample(long paramLong);
  
  public void release()
  {
    nativeRelease();
  }
  
  public void setAIDataListener(AIDataListener paramAIDataListener)
  {
    aiDataListener = paramAIDataListener;
    nativeSetAIDataListener();
  }
  
  public void setTipsListener(TipsListener paramTipsListener)
  {
    nativeSetTipsListener(paramTipsListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.VideoOutput
 * JD-Core Version:    0.7.0.1
 */