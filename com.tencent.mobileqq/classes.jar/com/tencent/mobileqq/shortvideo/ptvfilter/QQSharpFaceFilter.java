package com.tencent.mobileqq.shortvideo.ptvfilter;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.TransformFilter;
import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQSharpFaceFilter
{
  public static final String SHARP_FACE_JSON = "{\n  \"shaderType\" : 6,\n  \"useMesh\" : 1,\n  \"distortionList\" : [\n    {\n      \"radius\" : 500,\n      \"distortion\" : 3,\n      \"strength\" : 0.06,\n      \"position\" : 69,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 35,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 45,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 41,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 51,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 37,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 47,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 42,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 52,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 43,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 53,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 57,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 61,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 56,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 120,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 62,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 0,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 18,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 2,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 16,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 5,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 13,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 7,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 11,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.16,\n      \"position\" : 9,\n      \"direction\" : 2\n    }\n  ],\n  \"minAppVersion\" : 400\n}";
  private static final String TAG = "QQSharpFaceFilter";
  private static float maxSharpFaceRate = 1.3F;
  public static int sSharpFaceLevel = -1;
  public static boolean sSharpFaceOpen = false;
  volatile TransformFilter mSharpFaceFilter;
  private float[] originalDistortionStrengthList;
  
  public AESticker createFilterWithSharpFace(AESticker paramAESticker, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramAESticker != null)
    {
      this.mSharpFaceFilter = null;
      paramVideoPreviewFaceOutlineDetector = paramAESticker.getTransformFilters().iterator();
      while (paramVideoPreviewFaceOutlineDetector.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramVideoPreviewFaceOutlineDetector.next();
        if ((localVideoFilterBase instanceof TransformFilter))
        {
          this.mSharpFaceFilter = ((TransformFilter)localVideoFilterBase);
          if (SLog.isEnable()) {
            SLog.d("QQSharpFaceFilter", "change filter with transform");
          }
        }
      }
      paramVideoPreviewFaceOutlineDetector = paramAESticker;
      if (this.mSharpFaceFilter == null)
      {
        if (SLog.isEnable()) {
          SLog.d("QQSharpFaceFilter", "change filter without transform");
        }
        this.mSharpFaceFilter = new TransformFilter(VideoTemplateParser.parseVideoMaterial("{\n  \"shaderType\" : 6,\n  \"useMesh\" : 1,\n  \"distortionList\" : [\n    {\n      \"radius\" : 500,\n      \"distortion\" : 3,\n      \"strength\" : 0.06,\n      \"position\" : 69,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 35,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 45,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 41,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 51,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 37,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 47,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 42,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 52,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 43,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 53,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 57,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 61,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 56,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 120,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 62,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 0,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 18,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 2,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 16,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 5,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 13,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 7,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 11,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.16,\n      \"position\" : 9,\n      \"direction\" : 2\n    }\n  ],\n  \"minAppVersion\" : 400\n}", null).getDistortionItemList(), null);
        paramAESticker.addFilter(this.mSharpFaceFilter);
        paramAESticker.addTransformFilter(this.mSharpFaceFilter);
        paramVideoPreviewFaceOutlineDetector = paramAESticker;
      }
    }
    while (this.mSharpFaceFilter != null)
    {
      this.originalDistortionStrengthList = new float[this.mSharpFaceFilter.getDistortionItems().size()];
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < this.originalDistortionStrengthList.length)
        {
          this.originalDistortionStrengthList[paramInt1] = ((DistortionItem)this.mSharpFaceFilter.getDistortionItems().get(paramInt1)).strength;
          paramInt1 += 1;
          continue;
          if (SLog.isEnable()) {
            SLog.d("QQSharpFaceFilter", "change filter null");
          }
          paramAESticker = VideoTemplateParser.parseVideoMaterial("{\n  \"shaderType\" : 6,\n  \"useMesh\" : 1,\n  \"distortionList\" : [\n    {\n      \"radius\" : 500,\n      \"distortion\" : 3,\n      \"strength\" : 0.06,\n      \"position\" : 69,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 35,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 45,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 41,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 51,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 37,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 47,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 42,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 52,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 43,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 53,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 57,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 61,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 56,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 120,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 62,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 0,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 18,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 2,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 16,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 5,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 13,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 7,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 11,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.16,\n      \"position\" : 9,\n      \"direction\" : 2\n    }\n  ],\n  \"minAppVersion\" : 400\n}", null);
          paramVideoPreviewFaceOutlineDetector = new AESticker(paramAESticker, paramVideoPreviewFaceOutlineDetector);
          this.mSharpFaceFilter = new TransformFilter(paramAESticker.getDistortionItemList(), null);
          paramVideoPreviewFaceOutlineDetector.clearFilters();
          paramVideoPreviewFaceOutlineDetector.addFilter(this.mSharpFaceFilter);
          paramVideoPreviewFaceOutlineDetector.clearTransformFilters();
          paramVideoPreviewFaceOutlineDetector.addTransformFilter(this.mSharpFaceFilter);
          break;
        }
      }
      setSharpFaceStrength(sSharpFaceLevel);
    }
    return paramVideoPreviewFaceOutlineDetector;
  }
  
  public VideoFilterBase getFilter()
  {
    return this.mSharpFaceFilter;
  }
  
  public int getSharpFaceLevel()
  {
    return sSharpFaceLevel;
  }
  
  public void setSharpFaceStrength(int paramInt)
  {
    if ((this.mSharpFaceFilter != null) && (this.mSharpFaceFilter.getDistortionItems() != null) && (this.originalDistortionStrengthList != null))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.originalDistortionStrengthList.length)
      {
        DistortionItem localDistortionItem1 = (DistortionItem)this.mSharpFaceFilter.getDistortionItems().get(i);
        DistortionItem localDistortionItem2 = new DistortionItem();
        localDistortionItem2.strength = (this.originalDistortionStrengthList[i] * (paramInt / 100.0F * maxSharpFaceRate));
        localDistortionItem2.direction = localDistortionItem1.direction;
        localDistortionItem2.distortion = localDistortionItem1.distortion;
        localDistortionItem2.position = localDistortionItem1.position;
        localDistortionItem2.radius = localDistortionItem1.radius;
        localDistortionItem2.x = localDistortionItem1.x;
        localDistortionItem2.y = localDistortionItem1.y;
        localArrayList.add(localDistortionItem2);
        i += 1;
      }
      this.mSharpFaceFilter.setDistortionItems(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter
 * JD-Core Version:    0.7.0.1
 */