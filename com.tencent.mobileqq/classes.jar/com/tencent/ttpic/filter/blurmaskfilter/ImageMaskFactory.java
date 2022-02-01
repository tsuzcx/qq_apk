package com.tencent.ttpic.filter.blurmaskfilter;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.model.ImageMaskItem;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ImageMaskFactory
  implements BlurMaskFilter.IBlurMaskFactory
{
  private static final int HEIGHT_IMAGE = 480;
  public static final String TAG = "ImageMaskFactory";
  private static final int WIDTH_IMAGE = 360;
  private String mDataPath;
  private int mDuration = 0;
  private int mFrameIndex = 0;
  private HashMap<Integer, Frame> mFrameMap = new HashMap();
  private int mFramesCount = 0;
  private boolean mIsPaused = false;
  private int mLastFrameIndex = 0;
  private long mLastTimestamp = 0L;
  private String mMaskId;
  private int mPlayCount = 0;
  
  public ImageMaskFactory(ImageMaskItem paramImageMaskItem)
  {
    if (paramImageMaskItem == null) {
      return;
    }
    this.mDuration = paramImageMaskItem.getFrameDurationn();
    this.mPlayCount = paramImageMaskItem.getPlayCount();
    this.mFramesCount = paramImageMaskItem.getFrames();
    this.mDataPath = paramImageMaskItem.getDataPath();
    this.mMaskId = paramImageMaskItem.getMaskId();
    int i = 0;
    while (i < 1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramImageMaskItem.getDataPath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.mMaskId);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.mMaskId);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      if (!FileUtils.exists((String)localObject)) {
        return;
      }
      if (((String)localObject).startsWith("assets://")) {
        localObject = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
      } else {
        localObject = BitmapUtils.decodeSampledBitmapFromFile((String)localObject, 360, 480);
      }
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        Frame localFrame = new Frame(0, RendererUtils.createTexture((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        this.mFrameMap.put(Integer.valueOf(i), localFrame);
        this.mLastFrameIndex = i;
      }
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      i += 1;
    }
  }
  
  public void apply() {}
  
  public void clear()
  {
    Iterator localIterator = this.mFrameMap.values().iterator();
    while (localIterator.hasNext())
    {
      Frame localFrame = (Frame)localIterator.next();
      RendererUtils.clearTexture(localFrame.getTextureId());
      localFrame.clear();
    }
    this.mFrameMap.clear();
  }
  
  public Frame getNextFrame(long paramLong)
  {
    long l = this.mLastTimestamp;
    int i = 0;
    if (l == 0L)
    {
      this.mLastTimestamp = paramLong;
      this.mFrameIndex = 0;
    }
    else
    {
      j = this.mPlayCount;
      if ((j != 0) && (j * this.mFramesCount <= this.mFrameIndex)) {
        return loadImage(this.mLastFrameIndex);
      }
      if ((paramLong - this.mLastTimestamp >= this.mDuration) && (!this.mIsPaused))
      {
        this.mLastTimestamp = paramLong;
        this.mFrameIndex += 1;
      }
    }
    int j = this.mFramesCount;
    if (j != 0) {
      i = this.mFrameIndex % j;
    }
    if (((this.mFrameIndex != 0) && (i == 0)) || (i > this.mFrameMap.size())) {
      return loadImage(this.mLastFrameIndex);
    }
    return loadImage(i);
  }
  
  public Frame loadImage(int paramInt)
  {
    if (this.mFrameMap.size() == 0) {
      return null;
    }
    if (this.mFrameMap.containsKey(Integer.valueOf(paramInt))) {
      return (Frame)this.mFrameMap.get(Integer.valueOf(paramInt));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mDataPath);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.mMaskId);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.mMaskId);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    if (!FileUtils.exists((String)localObject))
    {
      localObject = this.mFrameMap;
      return (Frame)((HashMap)localObject).get(Integer.valueOf(((HashMap)localObject).size() - 1));
    }
    if (((String)localObject).startsWith("assets://")) {
      localObject = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
    } else {
      localObject = BitmapUtils.decodeSampledBitmapFromFile((String)localObject, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
    }
    if (BitmapUtils.isLegal((Bitmap)localObject))
    {
      Frame localFrame = new Frame(0, RendererUtils.createTexture((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      this.mFrameMap.put(Integer.valueOf(paramInt), localFrame);
      this.mLastFrameIndex = paramInt;
      if (((Bitmap)localObject).isRecycled()) {
        ((Bitmap)localObject).recycle();
      }
      return localFrame;
    }
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      ((Bitmap)localObject).recycle();
    }
    return (Frame)this.mFrameMap.get(Integer.valueOf(this.mLastFrameIndex));
  }
  
  public void pause()
  {
    if (!this.mIsPaused) {
      this.mIsPaused = true;
    }
  }
  
  public Frame renderMask(PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    if (this.mFrameMap != null) {
      return getNextFrame(paramPTFaceAttr.getTimeStamp());
    }
    return null;
  }
  
  public void reset()
  {
    this.mLastTimestamp = 0L;
  }
  
  public void resume()
  {
    if (this.mIsPaused) {
      this.mIsPaused = false;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.ImageMaskFactory
 * JD-Core Version:    0.7.0.1
 */