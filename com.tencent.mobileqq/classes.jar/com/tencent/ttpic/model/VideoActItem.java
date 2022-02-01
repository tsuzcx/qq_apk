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
  private static String TAG = "VideoActItem";
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
    Object localObject = this.decoder;
    if (localObject != null)
    {
      ((ActVideoDecoder)localObject).release();
      this.decoder = null;
    }
    localObject = this.texId;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
  }
  
  public int getOrigHeight(int paramInt)
  {
    ActVideoDecoder localActVideoDecoder = this.decoder;
    if (localActVideoDecoder != null) {
      return localActVideoDecoder.getHeight();
    }
    return 0;
  }
  
  public int getOrigWidth(int paramInt)
  {
    ActVideoDecoder localActVideoDecoder = this.decoder;
    if (localActVideoDecoder != null) {
      return localActVideoDecoder.getWidth() / 2;
    }
    return 0;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.texId[0];
  }
  
  public void init()
  {
    int[] arrayOfInt = this.texId;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.decoder = new ActVideoDecoder(this.path, this.texId[0]);
    this.decoder.decodeFrame(0L);
    this.decoder.updateFrame();
  }
  
  public void reset()
  {
    ActVideoDecoder localActVideoDecoder = this.decoder;
    if (localActVideoDecoder != null) {
      localActVideoDecoder.reset();
    }
  }
  
  public void update(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append("[update]");
    BenchUtil.benchStart(localStringBuilder.toString());
    super.update(paramFrame, paramLong, paramList, paramList1, paramInt);
    paramFrame = this.decoder;
    if (paramFrame != null)
    {
      paramFrame.decodeFrame(paramLong);
      this.decoder.updateFrame();
    }
    paramFrame = new StringBuilder();
    paramFrame.append(TAG);
    paramFrame.append("[update]");
    BenchUtil.benchEnd(paramFrame.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.VideoActItem
 * JD-Core Version:    0.7.0.1
 */