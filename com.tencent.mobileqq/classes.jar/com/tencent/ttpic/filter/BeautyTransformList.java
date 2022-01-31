package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BeautyTransformList
{
  private static final int MAX_TRANSFORMED_FACES = 5;
  private TransformFilter mBasic3 = null;
  private BeautyParam mBeautyParam;
  private TransformFilter mChinThinShorten;
  private BaseFilter mCopyFilter;
  private List<TransformFilter> mFilters;
  private TransformFilter mVFaceEyeNose;
  private Frame transFrame = new Frame();
  
  public BeautyTransformList()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create BeautyParam");
    this.mBeautyParam = new BeautyParam(false);
    BenchUtil.benchEnd("[onSurfaceCreated] create BeautyParam");
    this.mVFaceEyeNose = new TransformFilter(null, null);
    this.mChinThinShorten = new TransformFilter(null, null);
    this.mBasic3 = new TransformFilter(null, null);
    this.mFilters = new ArrayList();
    this.mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  }
  
  private void rebuildFilterList()
  {
    this.mFilters.clear();
    if ((this.mBeautyParam.vlian.getLevel() != 0) || (this.mBeautyParam.eye.getLevel() != 0) || (this.mBeautyParam.nose.getLevel() != 0)) {
      this.mFilters.add(this.mVFaceEyeNose);
    }
    if ((this.mBeautyParam.zhailian.getLevel() != 0) || (this.mBeautyParam.xiaba.getLevel() != 0) || (this.mBeautyParam.faceShorten.getLevel() != 0)) {
      this.mFilters.add(this.mChinThinShorten);
    }
    if (this.mBeautyParam.basic3.getLevel() != 0) {
      this.mFilters.add(this.mBasic3);
    }
    this.transFrame.clear();
  }
  
  public void clear()
  {
    this.transFrame.clear();
    this.mVFaceEyeNose.ClearGLSL();
    this.mChinThinShorten.ClearGLSL();
    this.mBasic3.ClearGLSL();
    this.mCopyFilter.ClearGLSL();
  }
  
  public BeautyParam getBeautyParam()
  {
    return this.mBeautyParam;
  }
  
  public void initial()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
    this.mVFaceEyeNose.ApplyGLSLFilter(true, 0.0F, 0.0F);
    this.mChinThinShorten.ApplyGLSLFilter(true, 0.0F, 0.0F);
    this.mBasic3.ApplyGLSLFilter(true, 0.0F, 0.0F);
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty mCopyFilter");
    this.mCopyFilter.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty mCopyFilter");
  }
  
  public boolean needFaceInfo()
  {
    return this.mFilters.size() != 0;
  }
  
  public Frame process(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, double paramDouble)
  {
    updateVideoSize(paramFrame.width, paramFrame.height, paramDouble);
    return updateAndRender(paramFrame.getFBO(), paramFrame.getTextureId(), 0.0F, paramFrame.width, paramFrame.height, paramList, paramList1, paramMap);
  }
  
  public void setBeautyParam(int paramInt, DistortParam paramDistortParam)
  {
    if (paramDistortParam == null) {
      return;
    }
    if ((paramInt == BeautyRealConfig.TYPE.FACE_V.value) || (paramInt == BeautyRealConfig.TYPE.EYE.value) || (paramInt == BeautyRealConfig.TYPE.NOSE.value)) {
      if (paramInt == BeautyRealConfig.TYPE.FACE_V.value)
      {
        this.mBeautyParam.vlian = paramDistortParam;
        paramDistortParam = new ArrayList();
        paramDistortParam.addAll(this.mBeautyParam.vlian.getItems());
        paramDistortParam.addAll(this.mBeautyParam.eye.getItems());
        paramDistortParam.addAll(this.mBeautyParam.nose.getItems());
        this.mVFaceEyeNose.setDistortionItems(paramDistortParam);
      }
    }
    for (;;)
    {
      rebuildFilterList();
      return;
      if (paramInt == BeautyRealConfig.TYPE.EYE.value)
      {
        this.mBeautyParam.eye = paramDistortParam;
        break;
      }
      if (paramInt != BeautyRealConfig.TYPE.NOSE.value) {
        break;
      }
      this.mBeautyParam.nose = paramDistortParam;
      break;
      if ((paramInt == BeautyRealConfig.TYPE.FACE_THIN.value) || (paramInt == BeautyRealConfig.TYPE.CHIN.value) || (paramInt == BeautyRealConfig.TYPE.FACE_SHORTEN.value))
      {
        if (paramInt == BeautyRealConfig.TYPE.FACE_THIN.value) {
          this.mBeautyParam.zhailian = paramDistortParam;
        }
        for (;;)
        {
          paramDistortParam = new ArrayList();
          paramDistortParam.addAll(this.mBeautyParam.zhailian.getItems());
          paramDistortParam.addAll(this.mBeautyParam.xiaba.getItems());
          paramDistortParam.addAll(this.mBeautyParam.faceShorten.getItems());
          this.mChinThinShorten.setDistortionItems(paramDistortParam);
          break;
          if (paramInt == BeautyRealConfig.TYPE.CHIN.value) {
            this.mBeautyParam.xiaba = paramDistortParam;
          } else if (paramInt == BeautyRealConfig.TYPE.FACE_SHORTEN.value) {
            this.mBeautyParam.faceShorten = paramDistortParam;
          }
        }
      }
      if (paramInt == BeautyRealConfig.TYPE.BASIC3.value)
      {
        this.mBeautyParam.basic3 = paramDistortParam;
        paramDistortParam = new ArrayList();
        paramDistortParam.addAll(this.mBeautyParam.basic3.getItems());
        this.mBasic3.setDistortionItems(paramDistortParam);
      }
    }
  }
  
  public void setBeautyParam(BeautyParam paramBeautyParam)
  {
    if (paramBeautyParam == null) {
      return;
    }
    setBeautyParam(BeautyRealConfig.TYPE.FACE_V.value, paramBeautyParam.vlian);
    setBeautyParam(BeautyRealConfig.TYPE.EYE.value, paramBeautyParam.eye);
    setBeautyParam(BeautyRealConfig.TYPE.NOSE.value, paramBeautyParam.nose);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_THIN.value, paramBeautyParam.zhailian);
    setBeautyParam(BeautyRealConfig.TYPE.CHIN.value, paramBeautyParam.xiaba);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_SHORTEN.value, paramBeautyParam.faceShorten);
    setBeautyParam(BeautyRealConfig.TYPE.BASIC3.value, paramBeautyParam.basic3);
    rebuildFilterList();
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mVFaceEyeNose.setRenderMode(paramInt);
    this.mChinThinShorten.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public Frame updateAndRender(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap)
  {
    Frame localFrame2 = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    Frame localFrame1 = localFrame2;
    Object localObject = localFrame1;
    if (paramList != null)
    {
      paramInt1 = 0;
      for (;;)
      {
        localObject = localFrame1;
        if (paramInt1 >= Math.min(paramList.size(), 5)) {
          break;
        }
        localObject = (List)paramList.get(paramInt1);
        float[] arrayOfFloat = (float[])paramList1.get(paramInt1);
        Iterator localIterator = this.mFilters.iterator();
        while (localIterator.hasNext())
        {
          TransformFilter localTransformFilter = (TransformFilter)localIterator.next();
          localTransformFilter.updatePreview((List)localObject, arrayOfFloat, paramMap, paramFloat, 0L);
          if (VideoMaterialUtil.needCopyTransform()) {
            localFrame1 = FrameUtil.renderProcessByCopy(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localTransformFilter, this.mCopyFilter, localFrame2, this.transFrame);
          } else {
            localFrame1 = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localTransformFilter, localFrame2, this.transFrame);
          }
        }
        paramInt1 += 1;
      }
    }
    return localObject;
  }
  
  public void updateAndRender(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, List<List<PointF>> paramList)
  {
    Frame localFrame2 = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    Frame localFrame1 = localFrame2;
    if (paramList != null)
    {
      int i = 0;
      while (i < Math.min(paramList.size(), 5))
      {
        Object localObject = this.mFilters.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TransformFilter localTransformFilter = (TransformFilter)((Iterator)localObject).next();
          localTransformFilter.updateAndRender((List)paramList.get(i), 1.0D);
          localFrame1 = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), paramInt3, paramInt4, localTransformFilter, localFrame2, this.transFrame);
        }
        if (localFrame1.getTextureId() != paramInt2)
        {
          localObject = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
          this.mCopyFilter.RenderProcess(localFrame1.getTextureId(), paramInt3, paramInt4, paramInt2, 0.0D, (Frame)localObject);
        }
        i += 1;
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mVFaceEyeNose.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mChinThinShorten.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mBasic3.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyTransformList
 * JD-Core Version:    0.7.0.1
 */