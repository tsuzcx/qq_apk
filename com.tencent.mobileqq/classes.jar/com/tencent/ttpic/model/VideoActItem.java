package com.tencent.ttpic.model;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import java.util.List;

public class VideoActItem
  extends FrameSourceItem
{
  private static final int FRAME_INTERVAL = 83;
  private static String TAG = VideoActItem.class.getSimpleName();
  private ActVideoDecoder decoder;
  private String path;
  private int[] texId = new int[1];
  
  public VideoActItem(String paramString, BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
    this.path = paramString;
  }
  
  public void clear()
  {
    if (this.decoder != null)
    {
      this.decoder.release();
      this.decoder = null;
    }
    GLES20.glDeleteTextures(this.texId.length, this.texId, 0);
  }
  
  public int getOrigHeight(int paramInt)
  {
    return this.decoder.getHeight();
  }
  
  public int getOrigWidth(int paramInt)
  {
    return this.decoder.getWidth() / 2;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.texId[0];
  }
  
  public void init()
  {
    GLES20.glGenTextures(this.texId.length, this.texId, 0);
    this.decoder = new ActVideoDecoder(this.path, this.texId[0]);
    this.decoder.decodeFrame(0L);
    this.decoder.updateFrame();
  }
  
  public void reset()
  {
    if (this.decoder != null) {
      this.decoder.reset();
    }
  }
  
  public void update(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    BenchUtil.benchStart(TAG + "[update]");
    super.update(paramFrame, paramLong, paramList, paramList1, paramInt);
    this.decoder.decodeFrame(paramLong);
    this.decoder.updateFrame();
    BenchUtil.benchEnd(TAG + "[update]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.VideoActItem
 * JD-Core Version:    0.7.0.1
 */