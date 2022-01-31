package com.tencent.youtu.android.segmenter;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class SegmenterLib
{
  private String modeFilePath;
  private long nativePtr;
  private String protoFilePath;
  private boolean sSegmentLibInited = false;
  
  public SegmenterLib(String paramString1, String paramString2)
  {
    this.protoFilePath = paramString1;
    this.modeFilePath = paramString2;
  }
  
  private native boolean initWithProto(String paramString1, String paramString2);
  
  public native void destroy();
  
  public boolean init()
  {
    if (this.sSegmentLibInited) {
      return this.sSegmentLibInited;
    }
    boolean bool = initWithProto(this.protoFilePath, this.modeFilePath);
    LogUtils.d("PTSegmenter", "initWithProto protoFilePath = " + this.protoFilePath);
    LogUtils.d("PTSegmenter", "initWithProto modeFilePath = " + this.modeFilePath);
    LogUtils.d("PTSegmenter", "initWithProto result  = " + bool);
    this.sSegmentLibInited = true;
    return this.sSegmentLibInited;
  }
  
  public void release()
  {
    this.sSegmentLibInited = false;
    destroy();
  }
  
  public native void segmentOnBit(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.android.segmenter.SegmenterLib
 * JD-Core Version:    0.7.0.1
 */