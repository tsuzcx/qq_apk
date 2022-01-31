package com.tencent.ttpic.filter.aifilter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.filter.FaceColorCombineFilter;
import com.tencent.ttpic.openapi.filter.Renderer;
import com.tencent.ttpic.openapi.filter.VideoFilterRenderer;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class FilterChainFactory
{
  private static final String TAG = FilterChainFactory.class.getSimpleName();
  private int[] brightnessCurve;
  private float mAlpha = 1.0F;
  private List<List<PointF>> mFacePoints;
  private ArrayList<Renderer> mFilterList = new ArrayList();
  
  private final Renderer createBaseFilter(FilterBean paramFilterBean, float paramFloat1, float paramFloat2)
  {
    int j = 0;
    FilterBean localFilterBean = null;
    Object localObject = paramFilterBean.id;
    String str = paramFilterBean.group;
    int i;
    switch (((String)localObject).hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label59:
        switch (str.hashCode())
        {
        default: 
          label112:
          i = -1;
          switch (i)
          {
          default: 
            label115:
            str = "assets://filter/" + str;
            localObject = MultiFilterParamConnect.createFilter(FilterChainParser.parseFilterMaterial(str + File.separator + (String)localObject, (String)localObject), paramFloat1, paramFloat2, null);
            if (localObject != null)
            {
              localObject = new BaseFilterRenderer((BaseFilter)localObject);
              ((BaseFilterRenderer)localObject).addParams(paramFilterBean.params);
              paramFilterBean = (FilterBean)localObject;
            }
            break;
          }
          break;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (paramFilterBean != null) {
        localFilterBean = paramFilterBean;
      }
      do
      {
        do
        {
          return localFilterBean;
          if (!((String)localObject).equals("faceColor")) {
            break;
          }
          i = 0;
          break label59;
          if (!((String)localObject).equals("adjust")) {
            break;
          }
          i = 1;
          break label59;
          if (!((String)localObject).equals("faceBeauty")) {
            break;
          }
          i = 2;
          break label59;
        } while (this.brightnessCurve == null);
        paramFilterBean = new FaceColorCombineFilter();
        paramFilterBean.ApplyGLSLFilter();
        LogUtils.d(TAG, Arrays.toString(this.brightnessCurve));
        paramFilterBean.updateCurve(this.brightnessCurve, true);
        paramFilterBean.enableBrightness(1);
        return new VideoFilterRenderer(paramFilterBean);
        return new AdjustFilterRenderer(AdjustFilterHelper.getInitialedFilterList(paramFilterBean.params));
      } while (this.mFacePoints == null);
      return new FaceBeautyFilterRenderer(FaceBeautyFilterHelper.getInitialedFilterList(paramFilterBean.params), this.mFacePoints);
      if (!str.equals("")) {
        break label112;
      }
      i = j;
      break label115;
      paramFilterBean = null;
      continue;
      paramFilterBean = null;
    }
  }
  
  public final FilterChainFactory addFilter(FilterBean paramFilterBean, float paramFloat1, float paramFloat2)
  {
    paramFilterBean = createBaseFilter(paramFilterBean, paramFloat1, paramFloat2);
    if ((paramFilterBean != null) && (this != null) && (this.mFilterList != null)) {
      this.mFilterList.add(paramFilterBean);
    }
    return this;
  }
  
  public final FilterChain build()
  {
    return new FilterChain(this.mFilterList).setAlpha(this.mAlpha);
  }
  
  public final FilterChainFactory from(String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    paramString1 = (FilterMaterialNew)GsonUtils.json2Obj(VideoTemplateParser.readMaterialFile(paramString1, paramString2, false, VideoTemplateParser.decryptListener), FilterMaterialNew.class);
    if (paramString1 != null)
    {
      LogUtils.d(TAG, paramString1.toString());
      this.mAlpha = (paramString1.strength / 100.0F);
      paramString1 = paramString1.baseFilterMaterials.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = createBaseFilter((FilterBean)paramString1.next(), paramFloat1, paramFloat2);
        if (paramString2 != null) {
          this.mFilterList.add(paramString2);
        }
      }
    }
    return this;
  }
  
  public final FilterChainFactory setAlpha(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {
      this.mAlpha = paramFloat;
    }
    return this;
  }
  
  public final FilterChainFactory setBrightnessCurve(int[] paramArrayOfInt)
  {
    this.brightnessCurve = paramArrayOfInt;
    return this;
  }
  
  public final FilterChainFactory setFacePoints(List<List<PointF>> paramList)
  {
    this.mFacePoints = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FilterChainFactory
 * JD-Core Version:    0.7.0.1
 */