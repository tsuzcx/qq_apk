package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.filter.ttpic.HightlightFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.CyberpunkBlendFilter;
import com.tencent.ttpic.filter.CyberpunkDarkFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.stylizefilter.IStlylizeFilterIniter;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CyberpunkFilter
  extends AEChainI
  implements AEFilterI, IStlylizeFilterIniter
{
  private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(AEModule.getContext(), "DrawPoints.glsl");
  private static final String TAG = "CyberpunkFilter";
  private static final int averageHistogramDayORNight = 80;
  public static int mode = -1;
  public int CYBERPUNK_FACEWIDTH = 65;
  public int CYBERPUNK_HIGHTLIGHT_THREADHOLD = 128;
  public int CYBERPUNK_NIGHT_HISTOGRAM = 90;
  private int FACE_DETECT_WIDTH_REAL = 720;
  private int FACE_DETECT_WIDTH_SCALE = 180;
  private BlurRealFilter blurMaskFilter = new BlurRealFilter(30.0F);
  private String currentLut = "";
  private CyberpunkDarkFilter cyberpunkDarkFilter = new CyberpunkDarkFilter();
  private Bitmap darkCornerBitmap = null;
  private String dayDarkCorner = "dark_corner_cyberpunk.png";
  private String dayLut = "cyberpunk_lut_day.png";
  private PTFaceAttr faceAttr = null;
  private String faceDarkCorner = "dark_corner_cyberpunk.png";
  private String faceLut = "cyberpunk_lut_face.png";
  private HightlightFilter hightlightFilter = new HightlightFilter();
  private String imagePath;
  private GPUImageLookupFilter mGpuImageLookupFilter = new GPUImageLookupFilter();
  private CyberpunkBlendFilter maskBlendFilter = new CyberpunkBlendFilter();
  private String nightDarkCorner = "dark_corner_cyberpunk.png";
  private String nightLut = "cyberpunk_lut_night.png";
  private String preDarkCornerPath = "";
  
  public static String getCurrentMode()
  {
    switch (mode)
    {
    default: 
      return "";
    case 0: 
      return "人像";
    case 1: 
      return "白天";
    }
    return "夜晚";
  }
  
  private boolean isContainFace(PTFaceAttr paramPTFaceAttr)
  {
    if (paramPTFaceAttr == null) {
      return false;
    }
    paramPTFaceAttr = paramPTFaceAttr.getFaceRectList().iterator();
    while (paramPTFaceAttr.hasNext())
    {
      Rect localRect = (Rect)paramPTFaceAttr.next();
      int i = Math.abs(localRect.right - localRect.left);
      LogUtils.d("CyberpunkFilter", "fordebug isContainFace: " + this.imagePath + " :" + i);
      if (i / this.FACE_DETECT_WIDTH_SCALE > getCyberpunkFacewidth() / this.FACE_DETECT_WIDTH_REAL) {
        return true;
      }
    }
    return false;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void apply()
  {
    if (this.mGpuImageLookupFilter != null) {
      this.mGpuImageLookupFilter.apply();
    }
    if (this.hightlightFilter != null) {
      this.hightlightFilter.apply();
    }
    if (this.blurMaskFilter != null) {
      this.blurMaskFilter.applyFilterChain(true, 360.0F, 640.0F);
    }
    if (this.maskBlendFilter != null) {
      this.maskBlendFilter.ApplyGLSLFilter();
    }
    if (this.cyberpunkDarkFilter != null) {
      this.cyberpunkDarkFilter.ApplyGLSLFilter();
    }
    super.apply();
  }
  
  public void clear()
  {
    if (this.mGpuImageLookupFilter != null) {
      this.mGpuImageLookupFilter.clearGLSLSelf();
    }
    if (this.hightlightFilter != null) {
      this.hightlightFilter.clearGLSLSelf();
    }
    if (this.blurMaskFilter != null) {
      this.blurMaskFilter.clearGLSLSelf();
    }
    if (this.maskBlendFilter != null) {
      this.maskBlendFilter.clearGLSLSelf();
    }
    if (this.cyberpunkDarkFilter != null) {
      this.cyberpunkDarkFilter.clearGLSLSelf();
    }
    this.faceAttr = null;
    if (this.darkCornerBitmap != null) {
      this.darkCornerBitmap.recycle();
    }
  }
  
  public int getCyberpunkFacewidth()
  {
    return this.CYBERPUNK_FACEWIDTH;
  }
  
  public int getCyberpunkNightHistogram()
  {
    return this.CYBERPUNK_NIGHT_HISTOGRAM;
  }
  
  public Frame render(Frame paramFrame)
  {
    int i = AlgoUtils.getAverageHistogram(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramFrame.getTextureId(), paramFrame.width, paramFrame.height), paramFrame.width, paramFrame.height);
    LogUtils.d("CyberpunkFilter", "fordebug averageHistogram: " + this.imagePath + " :" + i);
    if (isContainFace(this.faceAttr))
    {
      setLut(this.faceLut);
      setDarkCorner(this.faceDarkCorner);
      mode = 0;
    }
    Frame localFrame1;
    for (;;)
    {
      LogUtils.d("CyberpunkFilter", "fordebug render: current mode:" + mode);
      localFrame1 = this.mGpuImageLookupFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      if (localFrame1 != paramFrame) {
        paramFrame.unlock();
      }
      if (mode != 2) {
        break;
      }
      paramFrame = this.hightlightFilter.render(localFrame1);
      Frame localFrame2 = this.blurMaskFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      Frame localFrame3 = this.maskBlendFilter.render(localFrame1, localFrame2, null, 4);
      Frame localFrame4 = this.maskBlendFilter.render(localFrame3, localFrame2, null, 4);
      Frame localFrame5 = this.cyberpunkDarkFilter.render(localFrame4, null, this.darkCornerBitmap, 4);
      paramFrame.unlock();
      localFrame2.unlock();
      localFrame3.unlock();
      localFrame4.unlock();
      localFrame1.unlock();
      return localFrame5;
      if (i >= getCyberpunkNightHistogram())
      {
        setLut(this.dayLut);
        setDarkCorner(this.dayDarkCorner);
        mode = 1;
      }
      else
      {
        setLut(this.nightLut);
        setDarkCorner(this.nightDarkCorner);
        mode = 2;
      }
    }
    paramFrame = this.cyberpunkDarkFilter.render(localFrame1, null, this.darkCornerBitmap, 4);
    localFrame1.unlock();
    return paramFrame;
  }
  
  public void setCyberpunkFacewidth(int paramInt)
  {
    this.CYBERPUNK_FACEWIDTH = paramInt;
  }
  
  public void setCyberpunkNightHistogram(int paramInt)
  {
    this.CYBERPUNK_NIGHT_HISTOGRAM = paramInt;
  }
  
  public void setCyberpunkPath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public void setDarkCorner(String paramString)
  {
    if ((paramString == null) || (this.preDarkCornerPath.equals(paramString))) {
      return;
    }
    this.darkCornerBitmap = BitmapUtils.decodeBitmap(paramString, true);
    this.cyberpunkDarkFilter.loadBitmap(this.darkCornerBitmap);
    this.preDarkCornerPath = paramString;
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.faceAttr = paramPTFaceAttr;
  }
  
  public void setLut(String paramString)
  {
    if (this.currentLut.equals(paramString)) {
      return;
    }
    this.currentLut = paramString;
    this.mGpuImageLookupFilter.updateLut(paramString);
  }
  
  public void updateLutPaths(Map<String, String> paramMap)
  {
    LogUtils.d("CyberpunkFilter", "updateLutPaths:lut1 " + (String)paramMap.get("lut1"));
    LogUtils.d("CyberpunkFilter", "updateLutPaths:lut2 " + (String)paramMap.get("lut2"));
    LogUtils.d("CyberpunkFilter", "updateLutPaths:lut3 " + (String)paramMap.get("lut3"));
    this.dayLut = ((String)paramMap.get("lut1"));
    this.nightLut = ((String)paramMap.get("lut2"));
    this.faceLut = ((String)paramMap.get("lut3"));
  }
  
  public void updateMateriaPaths(Map<String, String> paramMap)
  {
    LogUtils.d("CyberpunkFilter", "updateMateriaPaths:MATERIAL_1:" + (String)paramMap.get("material1") + " material2:" + (String)paramMap.get("material2") + " material3:" + (String)paramMap.get("material3"));
    this.dayDarkCorner = ((String)paramMap.get("material1"));
    this.nightDarkCorner = ((String)paramMap.get("material2"));
    this.faceDarkCorner = ((String)paramMap.get("material3"));
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateThresholdValue(int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtils.d("CyberpunkFilter", "updateThresholdValue:  " + paramInt1 + " " + paramInt2 + " " + paramInt3);
    this.CYBERPUNK_FACEWIDTH = paramInt1;
    this.CYBERPUNK_NIGHT_HISTOGRAM = paramInt2;
    this.CYBERPUNK_HIGHTLIGHT_THREADHOLD = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CyberpunkFilter
 * JD-Core Version:    0.7.0.1
 */