package com.tencent.mobileqq.shortvideo.ptvfilter;

import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.filter.TransformFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQSharpFaceFilter
{
  private static float jdField_a_of_type_Float;
  public static int a;
  public static boolean a;
  volatile TransformFilter jdField_a_of_type_ComTencentTtpicFilterTransformFilter;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Float = 1.3F;
    jdField_a_of_type_Boolean = false;
  }
  
  public VideoFilterList a(VideoFilterList paramVideoFilterList)
  {
    Object localObject;
    if ((paramVideoFilterList != null) && (paramVideoFilterList.a()))
    {
      this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter = null;
      localObject = paramVideoFilterList.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)((Iterator)localObject).next();
        if ((localVideoFilterBase instanceof TransformFilter))
        {
          this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter = ((TransformFilter)localVideoFilterBase);
          if (SLog.a()) {
            SLog.d("QQSharpFaceFilter", "change filter with transform");
          }
        }
      }
      localObject = paramVideoFilterList;
      if (this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter == null)
      {
        if (SLog.a()) {
          SLog.d("QQSharpFaceFilter", "change filter without transform");
        }
        this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter = new TransformFilter(VideoTemplateParser.parseVideoMaterial("{\n  \"shaderType\" : 6,\n  \"distortionList\" : [\n    {\n      \"radius\" : 500,\n      \"distortion\" : 3,\n      \"strength\" : 0.06,\n      \"position\" : 69,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 35,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 45,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 41,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 51,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 37,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 47,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 42,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 52,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 43,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 53,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 57,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 61,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 56,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 120,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 62,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 0,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 18,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 2,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 16,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 5,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 13,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 7,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 11,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.16,\n      \"position\" : 9,\n      \"direction\" : 2\n    }\n  ],\n  \"minAppVersion\" : 400\n}", null).getDistortionItemList(), null);
        paramVideoFilterList.a(this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter);
        localObject = paramVideoFilterList;
      }
    }
    while (this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter != null)
    {
      this.jdField_a_of_type_ArrayOfFloat = new float[this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter.getDistortionItems().size()];
      int i = 0;
      for (;;)
      {
        if (i < this.jdField_a_of_type_ArrayOfFloat.length)
        {
          this.jdField_a_of_type_ArrayOfFloat[i] = ((DistortionItem)this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter.getDistortionItems().get(i)).strength;
          i += 1;
          continue;
          if (SLog.a()) {
            SLog.d("QQSharpFaceFilter", "change filter null");
          }
          this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter = new TransformFilter(VideoTemplateParser.parseVideoMaterial("{\n  \"shaderType\" : 6,\n  \"distortionList\" : [\n    {\n      \"radius\" : 500,\n      \"distortion\" : 3,\n      \"strength\" : 0.06,\n      \"position\" : 69,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 35,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.13,\n      \"position\" : 45,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 41,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 51,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 37,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 47,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 42,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 52,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 43,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 70,\n      \"distortion\" : 1,\n      \"strength\" : 0.14,\n      \"position\" : 53,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 57,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 160,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 61,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 56,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 120,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"position\" : 62,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 0,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 18,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 2,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 16,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 5,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 250,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 13,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 7,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 11,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.16,\n      \"position\" : 9,\n      \"direction\" : 2\n    }\n  ],\n  \"minAppVersion\" : 400\n}", null).getDistortionItemList(), null);
          localObject = new VideoFilterList();
          paramVideoFilterList = new CopyOnWriteArrayList();
          paramVideoFilterList.add(this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter);
          ((VideoFilterList)localObject).a(paramVideoFilterList);
          paramVideoFilterList = new QQVideoMaterial();
          paramVideoFilterList.setMaxFaceCount(3);
          paramVideoFilterList.setShaderType(VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value);
          paramVideoFilterList.setSupportLandscape(true);
          ((VideoFilterList)localObject).a(paramVideoFilterList);
          break;
        }
      }
      a(jdField_a_of_type_Int);
    }
    return localObject;
  }
  
  public VideoFilterBase a()
  {
    return this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfFloat.length)
      {
        DistortionItem localDistortionItem1 = (DistortionItem)this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter.getDistortionItems().get(i);
        DistortionItem localDistortionItem2 = new DistortionItem();
        localDistortionItem2.strength = (this.jdField_a_of_type_ArrayOfFloat[i] * (paramInt / 100.0F * jdField_a_of_type_Float));
        localDistortionItem2.direction = localDistortionItem1.direction;
        localDistortionItem2.distortion = localDistortionItem1.distortion;
        localDistortionItem2.position = localDistortionItem1.position;
        localDistortionItem2.radius = localDistortionItem1.radius;
        localDistortionItem2.x = localDistortionItem1.x;
        localDistortionItem2.y = localDistortionItem1.y;
        localArrayList.add(localDistortionItem2);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentTtpicFilterTransformFilter.setDistortionItems(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter
 * JD-Core Version:    0.7.0.1
 */