package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.microrapid.opencv.StrokeNativeProcessor;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.filter.BlurRealFilter;
import com.tencent.view.RendererUtils;

public class StrokeProcessor
{
  private BlurRealFilter blurFilter = new BlurRealFilter(5.0F);
  private BaseFilter copyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Frame copyFrame = new Frame();
  private Frame maskFrame = new Frame();
  private StrokeFilter strokeFilter = new StrokeFilter();
  private Frame strokeFrame = new Frame();
  private StrokeModel strokeModel;
  
  public StrokeProcessor(StrokeModel paramStrokeModel)
  {
    this.strokeModel = paramStrokeModel;
  }
  
  private StrokeProcessor.NativeStrokeResult processNativeStroke(Frame paramFrame, StrokeModel paramStrokeModel)
  {
    int i = paramStrokeModel.getStrokeType();
    int j = StrokeProcessor.StrokeType.access$200(StrokeProcessor.StrokeType.NativeStroke);
    int k = 0;
    if (i < j) {
      return new StrokeProcessor.NativeStrokeResult(this, paramFrame, new Rect(0, 0, paramFrame.width, paramFrame.height));
    }
    if (DeviceUtils.hasDeviceHigh(AEModule.getContext())) {
      i = 800;
    } else if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      i = 600;
    } else {
      i = 400;
    }
    float f = i;
    f = Math.min(Math.min(f / paramFrame.width, f / paramFrame.height), 1.0F);
    i = (int)(paramFrame.width * f);
    j = (int)(paramFrame.height * f);
    int m = Math.max(i, j);
    Pair localPair;
    if (m > 700) {
      localPair = new Pair(Integer.valueOf(5), Integer.valueOf(7));
    } else if (m > 500) {
      localPair = new Pair(Integer.valueOf(4), Integer.valueOf(6));
    } else {
      localPair = new Pair(Integer.valueOf(3), Integer.valueOf(5));
    }
    this.copyFilter.RenderProcess(paramFrame.getTextureId(), i, j, -1, 0.0D, this.copyFrame);
    paramFrame = RendererUtils.saveTexture(this.copyFrame);
    j = StrokeProcessor.StrokeType.access$300(StrokeProcessor.StrokeType.NativeStroke);
    double d = StrokeProcessor.StrokeType.access$400(StrokeProcessor.StrokeType.NativeStroke);
    Object localObject = StrokeProcessor.StrokeType.values();
    m = localObject.length;
    i = k;
    while (i < m)
    {
      StrokeProcessor.StrokeType localStrokeType = localObject[i];
      if (StrokeProcessor.StrokeType.access$200(localStrokeType) == paramStrokeModel.getStrokeType())
      {
        j = StrokeProcessor.StrokeType.access$300(localStrokeType);
        d = StrokeProcessor.StrokeType.access$400(localStrokeType);
      }
      i += 1;
    }
    localObject = new Rect();
    paramFrame = StrokeNativeProcessor.getOutlineImage(paramFrame, (Rect)localObject, paramStrokeModel.getStrokeWidth(), paramStrokeModel.getStrokeGap(), d, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue(), j, false);
    this.maskFrame.bindFrame(-1, paramFrame.getWidth(), paramFrame.getHeight(), 0.0D);
    GlUtil.loadTexture(this.maskFrame.getTextureId(), paramFrame);
    return new StrokeProcessor.NativeStrokeResult(this, this.maskFrame, (Rect)localObject);
  }
  
  public void clearFrame()
  {
    this.strokeFrame.clear();
    this.copyFrame.clear();
    this.maskFrame.clear();
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    this.strokeFilter.ApplyGLSLFilter();
    this.copyFilter.apply();
    this.blurFilter.applyFilterChain(false, paramInt1, paramInt2);
  }
  
  public Frame process(int paramInt1, int paramInt2, int paramInt3)
  {
    Frame localFrame1 = new Frame();
    this.blurFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localFrame1);
    Object localObject = processNativeStroke(localFrame1, this.strokeModel);
    Frame localFrame2 = StrokeProcessor.NativeStrokeResult.access$000((StrokeProcessor.NativeStrokeResult)localObject);
    localObject = StrokeProcessor.NativeStrokeResult.access$100((StrokeProcessor.NativeStrokeResult)localObject);
    this.strokeFilter.updateParams(this.strokeModel, localFrame2, (Rect)localObject, paramInt2, paramInt3);
    this.strokeFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.strokeFrame);
    localFrame1.clear();
    return this.strokeFrame;
  }
  
  public void release()
  {
    this.strokeFilter.clearGLSLSelf();
    this.blurFilter.clearGLSLSelf();
    this.strokeFrame.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.StrokeProcessor
 * JD-Core Version:    0.7.0.1
 */