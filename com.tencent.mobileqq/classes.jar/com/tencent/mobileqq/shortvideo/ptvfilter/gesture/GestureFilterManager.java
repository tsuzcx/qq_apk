package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.PointF;
import com.tencent.filter.Param.IntParam;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GestureFilterManager
  extends VideoFilterBase
{
  public static int a;
  public static volatile String a;
  public static int b;
  public static volatile String b;
  public static int c = 1;
  public static volatile int d = jdField_b_of_type_Int;
  public long a;
  private GestureKeyInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = null;
  private GestureFilterManager.AnimationWrapper jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper = null;
  public StickerItem a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private long jdField_b_of_type_Long = 0L;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  public int e = -1;
  public int f = -1;
  public int g = -1;
  private int h = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
  }
  
  public GestureFilterManager(StickerItem paramStickerItem, String paramString)
  {
    super(VideoFilterUtil.VERTEX_SHADER_COMMON, VideoFilterUtil.FRAGMENT_SHADER_COMMON, null);
    this.jdField_a_of_type_ComTencentTtpicModelStickerItem = paramStickerItem;
    this.jdField_a_of_type_Boolean = true;
    this.dataPath = paramString;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
  }
  
  public String a()
  {
    return "mGestureAnimType:=" + this.e + ";" + this.f + ";" + this.g;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).c();
      this.h -= 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public void a(GestureFilterManager.AnimationWrapper paramAnimationWrapper)
  {
    if ((paramAnimationWrapper != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramAnimationWrapper)))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramAnimationWrapper);
      this.h -= 1;
      if (SLog.a()) {
        SLog.d("GestureFilterManager", "have remove animation here");
      }
    }
  }
  
  public void a(StickerItem paramStickerItem, GestureKeyInfo paramGestureKeyInfo, PointF paramPointF)
  {
    paramStickerItem = new GestureFilterManager.AnimationWrapper(paramStickerItem, this.dataPath, paramGestureKeyInfo, paramPointF, false);
    if ((this.h <= 3) && (this.jdField_a_of_type_Boolean))
    {
      paramStickerItem.a(this.width, this.height, this.mScreenScale);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramStickerItem);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper = paramStickerItem;
      this.h += 1;
      if (SLog.a()) {
        SLog.d("GestureFilterManager", "have add complete ok here");
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).b();
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).b();
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).c();
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).c();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.h = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("texNeedTransform", -1));
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
    return true;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    return super.setRenderMode(paramInt);
  }
  
  public void updatePreview(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = GestureMgrRecognize.a().a();
    int j = 1;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo != null)
    {
      i = j;
      if (((GestureKeyInfo)localObject1).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo.jdField_a_of_type_Long) {
        i = 0;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = ((GestureKeyInfo)localObject1);
    if ((localObject1 != null) && (((GestureKeyInfo)localObject1).jdField_a_of_type_Boolean) && (((GestureKeyInfo)localObject1).jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString)) && (i != 0))
    {
      if (SLog.a()) {
        SLog.d("GestureFilterManager", "gesture info is x" + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x + ":y =" + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y + "lastAnimation is " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper);
      }
      if (this.e == 1)
      {
        i = 0;
        if (i != 0) {
          break label565;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper == null) {
          break label545;
        }
        if (!GestureFilterManager.AnimationWrapper.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo, (GestureKeyInfo)localObject1, this.width * 0.08F)) {
          break label453;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.a(paramLong) != 2) {
          break label391;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.a();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.a((GestureKeyInfo)localObject1, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
        if (SLog.a()) {
          SLog.d("GestureFilterManager", "update old point position");
        }
      }
    }
    label256:
    label391:
    label905:
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject2;
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (GestureFilterManager.AnimationWrapper)((Iterator)localObject1).next();
          if (((GestureFilterManager.AnimationWrapper)localObject2).a(paramLong) == 2)
          {
            if (SLog.a()) {
              SLog.d("GestureFilterManager", "runQueue remove this item " + localObject2 + " animation status is" + ((GestureFilterManager.AnimationWrapper)localObject2).a(paramLong));
            }
            if (localObject2 == this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper) {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper = null;
            }
            ((GestureFilterManager.AnimationWrapper)localObject2).c();
            ((Iterator)localObject1).remove();
            this.h -= 1;
            continue;
            i = 1;
            break;
            if (!SLog.a()) {
              break label256;
            }
            SLog.d("GestureFilterManager", "old animation is play now " + this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper) + " animation status is" + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.a(paramLong));
            break label256;
            label453:
            if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.a(paramLong) == 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.c();
              a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper);
            }
            for (;;)
            {
              a(this.jdField_a_of_type_ComTencentTtpicModelStickerItem, (GestureKeyInfo)localObject1, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
              if (!SLog.a()) {
                break;
              }
              SLog.d("GestureFilterManager", "stop old point position");
              break;
              this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper.a(this.f + paramLong);
              this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper);
            }
            label545:
            a(this.jdField_a_of_type_ComTencentTtpicModelStickerItem, (GestureKeyInfo)localObject1, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
            break label256;
            label565:
            localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              GestureFilterManager.AnimationWrapper localAnimationWrapper = (GestureFilterManager.AnimationWrapper)((Iterator)localObject2).next();
              if (GestureFilterManager.AnimationWrapper.a(localAnimationWrapper.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo, (GestureKeyInfo)localObject1, this.width * 0.08F))
              {
                if (localAnimationWrapper.a(paramLong) == 2) {
                  localAnimationWrapper.a();
                }
                localAnimationWrapper.a((GestureKeyInfo)localObject1, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
                this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper = localAnimationWrapper;
              }
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label905;
        }
        a(this.jdField_a_of_type_ComTencentTtpicModelStickerItem, (GestureKeyInfo)localObject1, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
        break;
        if ((((GestureKeyInfo)localObject1).jdField_a_of_type_Boolean) && (((GestureKeyInfo)localObject1).jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString))) {
          break;
        }
        a();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureFilterManager$AnimationWrapper = null;
        break;
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (GestureFilterManager.AnimationWrapper)((Iterator)localObject1).next();
          if ((((GestureFilterManager.AnimationWrapper)localObject2).a(paramLong) == 2) || (((GestureFilterManager.AnimationWrapper)localObject2).a() >= paramLong))
          {
            if (SLog.a()) {
              SLog.d("GestureFilterManager", "deadQueue remove this item " + localObject2);
            }
            ((GestureFilterManager.AnimationWrapper)localObject2).c();
            ((Iterator)localObject1).remove();
          }
        }
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((GestureFilterManager.AnimationWrapper)((Iterator)localObject1).next()).a(paramList, paramArrayOfFloat, paramMap, paramFloat, paramLong);
        }
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((GestureFilterManager.AnimationWrapper)((Iterator)localObject1).next()).a(paramList, paramArrayOfFloat, paramMap, paramFloat, paramLong);
        }
        return;
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GestureFilterManager.AnimationWrapper)localIterator.next()).a(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager
 * JD-Core Version:    0.7.0.1
 */