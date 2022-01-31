package com.tencent.ttpic.filter.aifilter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.filter.Renderer;
import com.tencent.view.Photo;
import com.tencent.view.RendererUtils;
import java.util.Iterator;
import java.util.List;

public class FilterChain
{
  private float alpha = 1.0F;
  private AlphaAdjustFilter alphaFilter;
  private boolean debugMode;
  private int index = 0;
  private List<Renderer> mFilterList;
  
  public FilterChain(List<Renderer> paramList)
  {
    this.mFilterList = paramList;
    this.alpha = 1.0F;
    this.alphaFilter = new AlphaAdjustFilter();
  }
  
  public final Bitmap process(Bitmap paramBitmap)
  {
    paramBitmap = Photo.create(paramBitmap);
    Bitmap localBitmap = RendererUtils.saveTexture(process(paramBitmap));
    paramBitmap.clear();
    FrameBufferCache.getInstance().destroy();
    return localBitmap;
  }
  
  public final Frame process(Frame paramFrame1, Frame paramFrame2)
  {
    this.alphaFilter.apply();
    this.alphaFilter.setFilterTexture(paramFrame1.getTextureId());
    return this.alphaFilter.RenderProcess(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height);
  }
  
  public Frame process(Photo paramPhoto)
  {
    paramPhoto = new Frame(0, paramPhoto.texture(), paramPhoto.width(), paramPhoto.height());
    Iterator localIterator = this.mFilterList.iterator();
    while (localIterator.hasNext())
    {
      paramPhoto = ((Renderer)localIterator.next()).process(paramPhoto);
      FrameBufferCache.getInstance().destroyReserveFrame(paramPhoto);
    }
    GLES20.glFinish();
    localIterator = this.mFilterList.iterator();
    while (localIterator.hasNext()) {
      ((Renderer)localIterator.next()).release();
    }
    return paramPhoto;
  }
  
  public final FilterChain setAlpha(float paramFloat)
  {
    this.alphaFilter.setAdjustParam(paramFloat);
    return this;
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    this.debugMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FilterChain
 * JD-Core Version:    0.7.0.1
 */