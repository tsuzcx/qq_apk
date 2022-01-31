package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceAverageUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class VideoFilterList
{
  public static final String FABBY_LOG = "[FABBY]";
  public static final String PERF_LOG = "[showPreview]";
  private static String TAG = VideoFilterList.class.getSimpleName();
  private List<VideoFilterBase> bgFilters = new ArrayList();
  private Frame[] copyFrame = new Frame[2];
  private CrazyFaceFilters crazyFaceFilters;
  private FabbyFilter fabbyFilter;
  private FabbyFilter2 fabbyFilter2 = new FabbyFilter2();
  private Frame fabbyMergeFrame = new Frame();
  private List<FabbyMvFilters> fabbyMvFilters = new ArrayList();
  private FabbyStrokeFilter fabbyStrokeFilter;
  private Frame fabbyStrokeFrame = new Frame();
  private Frame fabbyTransitionResult = new Frame();
  private List<VideoFilterBase> filters;
  private HeadCropFilter headCropFilter;
  private ARParticleFilter mARParticleFilter;
  private Queue<PointF> mARTouchPointQueue = new LinkedList();
  private ActFilters mActFilters;
  private Map<Integer, Float> mAgeValueMap = new HashMap();
  private Map<Integer, Double> mCharmValueMap = new HashMap();
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Map<Integer, Float> mCpValueMap = new HashMap();
  private int mCurPersonId = -1;
  private VideoFilterBase mEffectFilter;
  private Frame mEffectFrame = new Frame();
  private int mEffectOrder = -1;
  private Comparator<Face> mFaceIndexComperator = new Comparator()
  {
    public int compare(Face paramAnonymousFace1, Face paramAnonymousFace2)
    {
      return paramAnonymousFace1.faceIndex - paramAnonymousFace2.faceIndex;
    }
  };
  private List<Face> mFaceList = new ArrayList();
  private Map<Integer, Float> mGenderValueMap = new HashMap();
  private Frame mHeadCropFrame = new Frame();
  private Frame mLastFabbyFrame = new Frame();
  private Map<Integer, Float> mPopularValueMap = new HashMap();
  private float mScaleFace = 1.0F;
  private List<List<PointF>> mTouchPoints = new ArrayList();
  private VideoMaterial material;
  private List<VideoFilterBase> otherFilters;
  private Frame renderFrame = new Frame();
  private List<VideoFilterBase> staticStickerFilters;
  private TransitionFilter transitionFilter = new TransitionFilter();
  
  private Frame RenderProcessForFilters(Frame paramFrame, List<VideoFilterBase> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return paramFrame;
    }
    Frame localFrame1 = paramFrame;
    Frame localFrame2;
    int i;
    label63:
    VideoFilterBase localVideoFilterBase;
    if (paramFrame.getTextureId() == this.copyFrame[0].getTextureId())
    {
      localFrame2 = this.copyFrame[1];
      GLES20.glBindFramebuffer(36160, localFrame1.getFBO());
      GLES20.glViewport(0, 0, localFrame1.width, localFrame1.height);
      i = 0;
      if (i >= paramList.size()) {
        break label334;
      }
      localVideoFilterBase = (VideoFilterBase)paramList.get(i);
      if (needRender(localVideoFilterBase)) {
        break label112;
      }
    }
    for (;;)
    {
      i += 1;
      break label63;
      localFrame2 = this.copyFrame[0];
      break;
      label112:
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        Frame localFrame3 = localFrame1;
        if (VideoFileUtil.needCopy(localVideoFilterBase)) {
          localFrame3 = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, this.mCopyFilter, paramFrame, localFrame2);
        }
        BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
        if ((VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform())) {}
        for (localFrame1 = FrameUtil.renderProcessByCopy(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, localVideoFilterBase, this.mCopyFilter, paramFrame, localFrame2);; localFrame1 = FrameUtil.renderProcessBySwitchFbo(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, localVideoFilterBase, paramFrame, localFrame2))
        {
          BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
          break;
        }
      }
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
    label334:
    return localFrame1;
  }
  
  private void clearAgeRangeItemStatus()
  {
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        StickerItem localStickerItem = ((VideoFilterBase)this.filters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.ageRange != null)) {
          localStickerItem.ageRange.clearStatus();
        }
        i += 1;
      }
    }
    this.mAgeValueMap.clear();
  }
  
  private void clearCharmRangeItemStatus()
  {
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        StickerItem localStickerItem = ((VideoFilterBase)this.filters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.charmRange != null)) {
          localStickerItem.charmRange.clearStatus();
        }
        i += 1;
      }
    }
    this.mCharmValueMap.clear();
  }
  
  private void clearCpRangeItemStatus()
  {
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        StickerItem localStickerItem = ((VideoFilterBase)this.filters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.cpRange != null)) {
          localStickerItem.cpRange.clearStatus();
        }
        i += 1;
      }
    }
    this.mCpValueMap.clear();
  }
  
  private void clearFaceMappingData()
  {
    this.mFaceList.clear();
  }
  
  private void clearGenderRangeItemStatus()
  {
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        StickerItem localStickerItem = ((VideoFilterBase)this.filters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.genderRange != null)) {
          localStickerItem.genderRange.clearStatus();
        }
        i += 1;
      }
    }
    this.mGenderValueMap.clear();
  }
  
  private void clearPopularRangeItemStatus()
  {
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        StickerItem localStickerItem = ((VideoFilterBase)this.filters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.popularRange != null)) {
          localStickerItem.popularRange.clearStatus();
        }
        i += 1;
      }
    }
    this.mPopularValueMap.clear();
  }
  
  private void clearValueRangeItemStates()
  {
    clearCharmRangeItemStatus();
    clearAgeRangeItemStatus();
    clearGenderRangeItemStatus();
    clearCpRangeItemStatus();
  }
  
  private void destroyNormalAudio()
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      BaseFilter localBaseFilter = (BaseFilter)localIterator.next();
      if ((localBaseFilter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localBaseFilter).destroyAudio();
      }
    }
  }
  
  private float getAdjustedAge(float paramFloat)
  {
    float f;
    if ((paramFloat >= 0.21D) && (paramFloat <= 0.25D)) {
      f = (float)(paramFloat * 0.8D);
    }
    do
    {
      do
      {
        return f;
        if ((paramFloat >= 0.26D) && (paramFloat <= 0.3D)) {
          return (float)(paramFloat * 0.7D);
        }
        if ((paramFloat >= 0.31D) && (paramFloat <= 0.49D)) {
          return (float)(paramFloat * 0.6D);
        }
        f = paramFloat;
      } while (paramFloat < 0.5D);
      f = paramFloat;
    } while (paramFloat > 0.7D);
    return (float)(paramFloat * 0.5D);
  }
  
  private List<VideoFilterBase> getExcludeFilters(List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList1.next();
      if (!paramList2.contains(localVideoFilterBase)) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  private List<Integer> getNewFaceIndexList(int paramInt, Set<Integer> paramSet, List<Face> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(Integer.valueOf(((Face)paramList.get(((Integer)paramSet.next()).intValue())).faceIndex));
    }
    int i = 0;
    while (localArrayList.size() < paramInt)
    {
      if (!localHashSet.contains(Integer.valueOf(i))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private List<VideoFilterBase> getStickerFilters(List<VideoFilterBase> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (((localVideoFilterBase instanceof StaticStickerFilter)) || ((localVideoFilterBase instanceof StaticNumFilter))) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  private void hitAgeRangeItem(int paramInt)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) {
      break label9;
    }
    for (;;)
    {
      label9:
      return;
      if (this.filters != null)
      {
        if ((!this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          f = getAdjustedAge(f);
          this.mAgeValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        while (i < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
          StickerItem localStickerItem = localVideoFilterBase.getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.ageRange != null) {
              localStickerItem.ageRange.setValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
            if (((localVideoFilterBase instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
              ((DynamicNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
            if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
              ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitCharmRangeItem(int paramInt)
  {
    if (this.filters != null)
    {
      if (!this.mCharmValueMap.containsKey(Integer.valueOf(paramInt))) {
        this.mCharmValueMap.put(Integer.valueOf(paramInt), Double.valueOf(new Random().nextDouble()));
      }
      int i = 0;
      while (i < this.filters.size())
      {
        Object localObject1 = (VideoFilterBase)this.filters.get(i);
        Object localObject2 = ((VideoFilterBase)localObject1).getStickerItem();
        if ((localObject2 != null) && (((StickerItem)localObject2).charmRange != null)) {
          ((StickerItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
        }
        if ((localObject1 instanceof FaceOffFilter))
        {
          localObject2 = ((FaceOffFilter)localObject1).getFaceOffItem();
          if ((localObject2 != null) && (((FaceItem)localObject2).charmRange != null)) {
            ((FaceItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        if ((localObject1 instanceof TransformFilterNew))
        {
          localObject1 = ((TransformFilterNew)localObject1).getFaceMeshItem();
          if ((localObject1 != null) && (((FaceMeshItem)localObject1).charmRange != null)) {
            ((FaceMeshItem)localObject1).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        i += 1;
      }
    }
  }
  
  private void hitCpRangeItem(int paramInt1, int paramInt2)
  {
    if ((!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) || (paramInt2 < 2)) {
      break label14;
    }
    for (;;)
    {
      label14:
      return;
      if (this.filters != null)
      {
        if ((!this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) || ((this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) && (((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt1, FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          this.mCpValueMap.put(Integer.valueOf(paramInt1), Float.valueOf(f));
        }
        paramInt2 = 0;
        while (paramInt2 < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt2);
          StickerItem localStickerItem = localVideoFilterBase.getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.cpRange != null) {
              localStickerItem.cpRange.setValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
            }
            if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value)) {
              ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() * 100.0F));
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
  
  private void hitGenderRangeItem(int paramInt)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) {
      break label9;
    }
    for (;;)
    {
      label9:
      return;
      if (this.filters != null)
      {
        if ((!this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          this.mGenderValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        while (i < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
          StickerItem localStickerItem = localVideoFilterBase.getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.genderRange != null) {
              localStickerItem.genderRange.setValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
            if (((localVideoFilterBase instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
              ((DynamicNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
            if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
              ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitPopularRangeItem(int paramInt)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) {
      break label9;
    }
    for (;;)
    {
      label9:
      return;
      if (this.filters != null)
      {
        if ((!this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          this.mPopularValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        while (i < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
          StickerItem localStickerItem = localVideoFilterBase.getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.popularRange != null) {
              localStickerItem.popularRange.setValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
            if (((localVideoFilterBase instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
              ((DynamicNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
            if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
              ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void initGLResource()
  {
    this.mCopyFilter.ApplyGLSLFilter();
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i] = new Frame();
      i += 1;
    }
    this.mCurPersonId = -1;
  }
  
  private void mappingFace(List<Face> paramList, List<List<PointF>> paramList1, List<float[]> paramList2, int paramInt)
  {
    Object localObject3 = new HashSet();
    Object localObject1 = new HashSet();
    int j = 0;
    Object localObject5;
    while (j < paramList1.size())
    {
      localObject2 = (List)paramList1.get(j);
      localObject4 = (float[])paramList2.get(j);
      localObject5 = (PointF)((List)localObject2).get(64);
      int k = -1;
      double d1 = paramInt * 0.1D;
      i = 0;
      if (i < paramList.size())
      {
        double d2;
        if (((Set)localObject3).contains(Integer.valueOf(i))) {
          d2 = d1;
        }
        for (;;)
        {
          i += 1;
          d1 = d2;
          break;
          double d3 = AlgoUtils.getDistance((PointF)localObject5, (PointF)((Face)paramList.get(i)).facePoints.get(64));
          d2 = d1;
          if (d3 < d1)
          {
            k = i;
            d2 = d3;
          }
        }
      }
      if (k != -1)
      {
        ((Set)localObject3).add(Integer.valueOf(k));
        ((Set)localObject1).add(Integer.valueOf(j));
        ((Face)paramList.get(k)).facePoints = ((List)localObject2);
        ((Face)paramList.get(k)).faceAngles = ((float[])localObject4);
      }
      j += 1;
    }
    Object localObject4 = new HashSet();
    Object localObject2 = new ArrayList();
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((Set)localObject4).add(Integer.valueOf(((Face)paramList.get(paramInt)).faceIndex));
      if (((Set)localObject3).contains(Integer.valueOf(paramInt))) {
        ((List)localObject2).add(paramList.get(paramInt));
      }
      paramInt += 1;
    }
    localObject3 = getNewFaceIndexList(paramList1.size() - ((Set)localObject1).size(), (Set)localObject3, paramList);
    paramInt = 0;
    for (int i = 0; paramInt < paramList1.size(); i = j)
    {
      j = i;
      if (!((Set)localObject1).contains(Integer.valueOf(paramInt)))
      {
        localObject5 = new Face();
        ((Face)localObject5).facePoints = ((List)paramList1.get(paramInt));
        ((Face)localObject5).faceAngles = ((float[])paramList2.get(paramInt));
        ((Face)localObject5).faceIndex = ((Integer)((List)localObject3).get(i)).intValue();
        this.mCharmValueMap.remove(Integer.valueOf(((Face)localObject5).faceIndex));
        ((List)localObject2).add(localObject5);
        j = i + 1;
      }
      paramInt += 1;
    }
    paramList1 = new HashSet();
    paramInt = 0;
    while (paramInt < ((List)localObject2).size())
    {
      paramList1.add(Integer.valueOf(((Face)((List)localObject2).get(paramInt)).faceIndex));
      paramInt += 1;
    }
    paramList2 = ((Set)localObject4).iterator();
    while (paramList2.hasNext())
    {
      localObject1 = (Integer)paramList2.next();
      if (!paramList1.contains(localObject1)) {
        removeValueRangeForFace(((Integer)localObject1).intValue());
      }
    }
    paramList.clear();
    paramList.addAll((Collection)localObject2);
  }
  
  private boolean needRender(VideoFilterBase paramVideoFilterBase)
  {
    Object localObject;
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      localObject = paramVideoFilterBase.getStickerItem();
      if ((localObject == null) || (!((NormalVideoFilter)paramVideoFilterBase).isRenderReady())) {
        return false;
      }
      if (this.mCurPersonId == -1) {
        return true;
      }
      if ((((StickerItem)localObject).personID != -1) && (((StickerItem)localObject).personID != this.mCurPersonId)) {
        return false;
      }
      if (((((StickerItem)localObject).charmRange != null) && (!((StickerItem)localObject).charmRange.isHit())) || ((((StickerItem)localObject).ageRange != null) && (!((StickerItem)localObject).ageRange.isHit())) || ((((StickerItem)localObject).genderRange != null) && (!((StickerItem)localObject).genderRange.isHit())) || ((((StickerItem)localObject).popularRange != null) && (!((StickerItem)localObject).popularRange.isHit())) || ((((StickerItem)localObject).cpRange != null) && (!((StickerItem)localObject).cpRange.isHit()))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceOffFilter))
    {
      localObject = ((FaceOffFilter)paramVideoFilterBase).getFaceOffItem();
      if ((localObject != null) && (((((FaceItem)localObject).personID != -1) && (this.mCurPersonId != -1) && (((FaceItem)localObject).personID != this.mCurPersonId)) || ((this.mCurPersonId != -1) && (((FaceItem)localObject).charmRange != null) && (!((FaceItem)localObject).charmRange.isHit())))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof TransformFilterNew))
    {
      localObject = ((TransformFilterNew)paramVideoFilterBase).getFaceMeshItem();
      if ((localObject != null) && (((((FaceMeshItem)localObject).personID != -1) && (this.mCurPersonId != -1) && (((FaceMeshItem)localObject).personID != this.mCurPersonId)) || ((this.mCurPersonId != -1) && (((FaceMeshItem)localObject).charmRange != null) && (!((FaceMeshItem)localObject).charmRange.isHit())))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceCropFilter)) {
      return ((FaceCropFilter)paramVideoFilterBase).isNeedRender();
    }
    return true;
  }
  
  private void removeValueRangeForFace(int paramInt)
  {
    this.mCharmValueMap.remove(Integer.valueOf(paramInt));
    this.mAgeValueMap.remove(Integer.valueOf(paramInt));
    this.mGenderValueMap.remove(Integer.valueOf(paramInt));
    this.mPopularValueMap.remove(Integer.valueOf(paramInt));
    this.mCpValueMap.remove(Integer.valueOf(paramInt));
  }
  
  public void ApplyGLSLFilter()
  {
    if (!isValid()) {
      return;
    }
    initGLResource();
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.bgFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilters)localIterator.next()).ApplyGLSLFilter();
    }
    if (this.headCropFilter != null) {
      this.headCropFilter.ApplyGLSLFilter();
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.ApplyGLSLFilter();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.ApplyGLSLFilter();
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.ApplyGLSLFilter();
    }
    if (this.mActFilters != null) {
      this.mActFilters.ApplyGLSLFilter();
    }
    this.fabbyFilter = new FabbyFilter();
    this.fabbyStrokeFilter = new FabbyStrokeFilter();
    this.fabbyFilter.ApplyGLSLFilter();
    this.fabbyStrokeFilter.ApplyGLSLFilter();
    if (this.transitionFilter != null) {
      this.transitionFilter.ApplyGLSLFilter();
    }
    VideoPreviewFaceOutlineDetector.getInstance().setFaceValueDetectType(this.material.getFaceValueDetectType());
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Frame localFrame2 = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    if ((VideoUtil.isEmpty(this.filters)) || (paramInt1 < 0) || (paramInt2 < 0)) {
      localObject = localFrame2;
    }
    Frame localFrame1;
    Frame localFrame3;
    label84:
    do
    {
      return localObject;
      localFrame1 = localFrame2;
      if (localFrame2.getTextureId() != this.copyFrame[0].getTextureId()) {
        break;
      }
      localFrame3 = this.copyFrame[1];
      GLES20.glBindFramebuffer(36160, paramInt1);
      GLES20.glViewport(0, 0, paramInt3, paramInt4);
      paramInt1 = 0;
      localObject = localFrame1;
    } while (paramInt1 >= this.filters.size());
    VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt1);
    if (!needRender(localVideoFilterBase)) {}
    for (;;)
    {
      paramInt1 += 1;
      break label84;
      localFrame3 = this.copyFrame[0];
      break;
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        localObject = localFrame1;
        if (VideoFileUtil.needCopy(localVideoFilterBase)) {
          localObject = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), paramInt3, paramInt4, this.mCopyFilter, localFrame2, localFrame3);
        }
        BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
        if ((VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform())) {}
        for (localFrame1 = FrameUtil.renderProcessByCopy(((Frame)localObject).getTextureId(), paramInt3, paramInt4, localVideoFilterBase, this.mCopyFilter, localFrame2, localFrame3);; localFrame1 = FrameUtil.renderProcessBySwitchFbo(((Frame)localObject).getTextureId(), paramInt3, paramInt4, localVideoFilterBase, localFrame2, localFrame3))
        {
          BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
          break;
        }
      }
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(localFrame1.getTextureId(), paramInt3, paramInt4);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    this.mARTouchPointQueue.offer(paramPointF);
  }
  
  public void addTouchPoint(PointF paramPointF, float paramFloat, boolean paramBoolean)
  {
    if (paramPointF == null) {
      return;
    }
    if ((paramBoolean) || (this.mTouchPoints.size() == 0)) {
      this.mTouchPoints.add(new ArrayList());
    }
    ((List)this.mTouchPoints.get(this.mTouchPoints.size() - 1)).add(paramPointF);
    this.mScaleFace = paramFloat;
  }
  
  public void destroy()
  {
    if (!isValid()) {}
    do
    {
      return;
      destroyAudio();
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
      }
      localIterator = this.bgFilters.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
      }
      localIterator = this.fabbyMvFilters.iterator();
      while (localIterator.hasNext()) {
        ((FabbyMvFilters)localIterator.next()).clear();
      }
      this.filters.clear();
      this.renderFrame.clear();
      this.mEffectFrame.clear();
      this.mHeadCropFrame.clear();
      this.fabbyStrokeFrame.clear();
      this.fabbyTransitionResult.clear();
      this.fabbyMergeFrame.clear();
      int i = 0;
      while (i < this.copyFrame.length)
      {
        this.copyFrame[i].clear();
        i += 1;
      }
      this.mCopyFilter.ClearGLSL();
      this.transitionFilter.ClearGLSL();
      this.fabbyFilter2.ClearGLSL();
      if (this.headCropFilter != null) {
        this.headCropFilter.clearGLSLSelf();
      }
      if (this.crazyFaceFilters != null) {
        this.crazyFaceFilters.clear();
      }
      if (this.mARParticleFilter != null) {
        this.mARParticleFilter.clear();
      }
      if (this.mActFilters != null) {
        this.mActFilters.clear();
      }
      if (this.mEffectFilter != null) {
        this.mEffectFilter.ClearGLSL();
      }
      if (this.fabbyFilter != null) {
        this.fabbyFilter.ClearGLSL();
      }
      if (this.fabbyStrokeFilter != null) {
        this.fabbyStrokeFilter.ClearGLSL();
      }
      destroyAudio();
      clearValueRangeItemStates();
    } while (!LogicDataManager.getInstance().needDecibel());
    LogicDataManager.getInstance().destroy();
  }
  
  public void destroyAudio()
  {
    if (!isValid()) {}
    for (;;)
    {
      return;
      destroyNormalAudio();
      if (this.mARParticleFilter != null) {
        this.mARParticleFilter.destroyAudioPlayer();
      }
      if (this.mActFilters != null) {
        this.mActFilters.destroyAudio();
      }
      Iterator localIterator = this.fabbyMvFilters.iterator();
      while (localIterator.hasNext()) {
        ((FabbyMvFilters)localIterator.next()).destroyAudioPlayer();
      }
    }
  }
  
  public Frame doFabbyStroke(Frame paramFrame1, Frame paramFrame2)
  {
    BenchUtil.benchStart("[showPreview][FABBY] doFabbyStroke");
    if (this.material.getSegmentStrokeWidth() > 0.0D)
    {
      this.fabbyStrokeFilter.setmMaskTex(paramFrame2.getTextureId());
      this.fabbyStrokeFilter.setStepX(1.0F / paramFrame1.width);
      this.fabbyStrokeFilter.setStepY(1.0F / paramFrame1.height);
      this.fabbyStrokeFilter.setStrokeGapInPixel((float)this.material.getSegmentStrokeGap() * Math.min(paramFrame1.width, paramFrame1.height));
      this.fabbyStrokeFilter.setStrokeWidthInPixel((float)this.material.getSegmentStrokeWidth() * Math.min(paramFrame1.width, paramFrame1.height));
      this.fabbyStrokeFilter.setStrokeColor(this.material.getSegmentStrokeColor());
      this.fabbyStrokeFilter.setFeather(this.material.getSegmentFeather());
      this.fabbyStrokeFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
    }
    for (;;)
    {
      BenchUtil.benchEnd("[showPreview][FABBY] doFabbyStroke");
      return this.fabbyStrokeFrame;
      this.fabbyFilter.setTex(paramFrame2.getTextureId());
      this.fabbyFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
    }
  }
  
  public List<VideoFilterBase> getBgFilters()
  {
    return this.bgFilters;
  }
  
  public CrazyFaceFilters getCrazyFaceFilters()
  {
    return this.crazyFaceFilters;
  }
  
  public List<VideoFilterBase> getFilters()
  {
    return this.filters;
  }
  
  public VideoMaterial getMaterial()
  {
    return this.material;
  }
  
  public List<VideoFilterBase> getStaticStickerFilters()
  {
    return this.staticStickerFilters;
  }
  
  public boolean isFabbyMaterial()
  {
    return !VideoUtil.isEmpty(this.fabbyMvFilters);
  }
  
  public boolean isSegmentRequired()
  {
    return this.material.isSegmentRequired();
  }
  
  public boolean isValid()
  {
    return true;
  }
  
  public boolean needFaceInfo(int paramInt)
  {
    paramInt = (paramInt + 360) % 360;
    return ((paramInt != 90) && (paramInt != 270)) || (this.material.isSupportLandscape());
  }
  
  public void onPause()
  {
    destroyAudio();
  }
  
  public void onResume()
  {
    if (this.mActFilters != null) {
      this.mActFilters.reset(System.currentTimeMillis());
    }
  }
  
  public Frame process(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, double paramDouble, byte[] paramArrayOfByte)
  {
    if ((paramFrame.width > paramFrame.height) && (!getMaterial().isSupportLandscape()))
    {
      destroyNormalAudio();
      return paramFrame;
    }
    if (VideoPreviewFaceOutlineDetector.getInstance().getFaceCount() > 0) {
      setImageData(paramArrayOfByte);
    }
    updateVideoSize(paramFrame.width, paramFrame.height, paramDouble);
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramFrame = updateAndRender(paramFrame, paramList, paramList1, paramMap, paramDouble);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return paramFrame;
  }
  
  public void renderARFilterIfNeeded(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mARParticleFilter != null)
    {
      VideoFilterUtil.setBlendMode(true);
      GLES20.glBindFramebuffer(36160, paramInt1);
      GLES20.glViewport(0, 0, paramInt3, paramInt4);
      while (!this.mARTouchPointQueue.isEmpty())
      {
        PointF localPointF = (PointF)this.mARTouchPointQueue.poll();
        if (localPointF != null) {
          this.mARParticleFilter.addTouchPoint(localPointF);
        }
      }
      if (this.mARParticleFilter.needCopyTex()) {
        this.mARParticleFilter.setInputFrame(new Frame(paramInt1, paramInt2, paramInt3, paramInt4));
      }
      this.mARParticleFilter.updateAndRender(paramInt2);
      VideoFilterUtil.setBlendMode(false);
    }
  }
  
  public Bitmap renderForBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.filters == null) {
      return RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3);
    }
    VideoFilterUtil.setBlendMode(true);
    Frame localFrame2 = new Frame();
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localFrame2);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    paramInt1 = 0;
    Frame localFrame1 = localFrame2;
    if (paramInt1 < this.filters.size())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt1);
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        localObject = localFrame1;
        if (VideoFileUtil.needCopy(localVideoFilterBase)) {
          localObject = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), paramInt2, paramInt3, this.mCopyFilter, localFrame2, this.copyFrame[0]);
        }
        localFrame1 = FrameUtil.renderProcessBySwitchFbo(((Frame)localObject).getTextureId(), paramInt2, paramInt3, localVideoFilterBase, localFrame2, this.copyFrame[0]);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localVideoFilterBase.OnDrawFrameGLSL();
        localVideoFilterBase.renderTexture(localFrame1.getTextureId(), paramInt2, paramInt3);
      }
    }
    VideoFilterUtil.setBlendMode(false);
    Object localObject = RendererUtils.saveTexture(localFrame1.getTextureId(), paramInt2, paramInt3);
    localFrame1.clear();
    return localObject;
  }
  
  public void setARParticleFilter(ARParticleFilter paramARParticleFilter)
  {
    this.mARParticleFilter = paramARParticleFilter;
  }
  
  public void setActFilter(ActFilters paramActFilters)
  {
    this.mActFilters = paramActFilters;
  }
  
  public void setBgFilters(List<VideoFilterBase> paramList)
  {
    this.bgFilters = paramList;
  }
  
  public void setCrazyFaceFilters(CrazyFaceFilters paramCrazyFaceFilters)
  {
    this.crazyFaceFilters = paramCrazyFaceFilters;
  }
  
  public void setCurPersonId(int paramInt)
  {
    this.mCurPersonId = paramInt;
  }
  
  public void setFabbyMvFilters(List<FabbyMvFilters> paramList)
  {
    this.fabbyMvFilters = paramList;
  }
  
  public void setFilters(List<VideoFilterBase> paramList)
  {
    this.filters = paramList;
    this.staticStickerFilters = getStickerFilters(paramList);
    this.otherFilters = getExcludeFilters(paramList, this.staticStickerFilters);
  }
  
  public void setHeadCropFilter(HeadCropFilter paramHeadCropFilter)
  {
    this.headCropFilter = paramHeadCropFilter;
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setImageData(paramArrayOfByte);
    }
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setImageData(paramArrayOfByte);
      }
    }
  }
  
  public void setIsRenderForBitmap(boolean paramBoolean)
  {
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        ((VideoFilterBase)this.filters.get(i)).setIsRenderForBitmap(paramBoolean);
        i += 1;
      }
    }
  }
  
  public void setMaterial(VideoMaterial paramVideoMaterial)
  {
    this.material = paramVideoMaterial;
  }
  
  public void setRenderMode(int paramInt)
  {
    VideoFilterUtil.setRenderMode(this.filters, paramInt);
    VideoFilterUtil.setRenderMode(this.bgFilters, paramInt);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilters)localIterator.next()).setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
    if (this.headCropFilter != null) {
      this.headCropFilter.setRenderMode(paramInt);
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setRenderMode(paramInt);
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.setRenderMode(paramInt);
    }
    if (this.mActFilters != null) {
      this.mActFilters.setRenderMode(paramInt);
    }
    if (this.transitionFilter != null) {
      this.transitionFilter.setRenderMode(paramInt);
    }
    if (this.fabbyFilter != null) {
      this.fabbyFilter.setRenderMode(paramInt);
    }
    if (this.fabbyFilter2 != null) {
      this.fabbyFilter2.setRenderMode(paramInt);
    }
    if (this.fabbyStrokeFilter != null) {
      this.fabbyStrokeFilter.setRenderMode(paramInt);
    }
  }
  
  public void setVideoEffect(VideoFilterEffect paramVideoFilterEffect)
  {
    if (paramVideoFilterEffect != null) {
      this.mEffectOrder = paramVideoFilterEffect.order;
    }
  }
  
  public void setVideoEffectFilter(VideoFilterBase paramVideoFilterBase)
  {
    this.mEffectFilter = paramVideoFilterBase;
  }
  
  public void updateAllFilters(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat)
  {
    updateFilters(paramList, paramArrayOfFloat, paramMap, paramFloat, this.filters);
  }
  
  public Frame updateAndRender(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, double paramDouble)
  {
    if (!isValid()) {
      localFrame = paramFrame;
    }
    int j;
    float[] arrayOfFloat;
    List localList;
    do
    {
      return localFrame;
      localFrame = paramFrame;
      VideoFilterUtil.setBlendMode(true);
      GLES20.glBindFramebuffer(36160, localFrame.getFBO());
      GLES20.glViewport(0, 0, localFrame.width, localFrame.height);
      paramFrame = localFrame;
      if (this.mEffectOrder == 1)
      {
        paramFrame = localFrame;
        if (this.mEffectFilter != null)
        {
          this.mEffectFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, this.mEffectFrame);
          paramFrame = this.mEffectFrame;
        }
      }
      if (VideoMaterialUtil.isFaceCopyMaterial(getMaterial()))
      {
        paramMap = this.filters.iterator();
        for (;;)
        {
          paramList1 = paramFrame;
          if (!paramMap.hasNext()) {
            break;
          }
          paramList1 = (VideoFilterBase)paramMap.next();
          if ((paramList1 instanceof FaceCopyFilter))
          {
            paramList1 = (FaceCopyFilter)paramList1;
            paramList1.setFaceParams(paramList, paramFrame.getTextureId());
            paramList1.renderProcess();
          }
        }
      }
      if (VideoMaterialUtil.isFaceSwitchMaterial(getMaterial()))
      {
        this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.copyFrame[0]);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
        paramMap = this.filters.iterator();
        for (;;)
        {
          paramList1 = paramFrame;
          if (!paramMap.hasNext()) {
            break;
          }
          paramList1 = (VideoFilterBase)paramMap.next();
          if ((paramList1 instanceof SwitchFaceFilter))
          {
            paramList1 = (SwitchFaceFilter)paramList1;
            paramList1.setFaceParams(paramList, this.copyFrame[0].getTextureId());
            paramList1.renderProcess();
          }
        }
      }
      if (getMaterial().getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value)
      {
        paramMap = this.filters.iterator();
        for (;;)
        {
          paramList1 = paramFrame;
          if (!paramMap.hasNext()) {
            break;
          }
          paramList1 = (VideoFilterBase)paramMap.next();
          if ((paramList1 instanceof DoodleFilter))
          {
            paramList1 = (DoodleFilter)paramList1;
            paramList1.setTouchPoints(paramList, this.mTouchPoints, paramFrame.width, paramFrame.height, this.mScaleFace);
            paramList1.renderProcess();
          }
        }
      }
      j = Math.min(paramList.size(), getMaterial().getMaxFaceCount());
      localFrame = paramFrame;
      if (this.crazyFaceFilters == null) {
        break;
      }
      localFrame = paramFrame;
      if (j <= 0) {
        break;
      }
      arrayOfFloat = (float[])paramList1.get(0);
      localList = (List)paramList.get(0);
      localFrame = paramFrame;
    } while (!FaceAverageUtil.isPositiveFace(arrayOfFloat, localList, paramFrame.width, paramFrame.height, paramDouble));
    Frame localFrame = this.crazyFaceFilters.updateAndRender(paramFrame, paramFrame.width, paramFrame.height, localList, arrayOfFloat, paramMap);
    if (!this.mFaceList.isEmpty())
    {
      mappingFace(this.mFaceList, paramList, paramList1, localFrame.width);
      Collections.sort(this.mFaceList, this.mFaceIndexComperator);
    }
    for (;;)
    {
      paramFrame = localFrame;
      if (j <= 0)
      {
        setCurPersonId(-1);
        updateAllFilters(null, null, paramMap, 0.0F);
        paramFrame = RenderProcessForFilters(localFrame, this.otherFilters);
        clearCharmRangeItemStatus();
        clearGenderRangeItemStatus();
        clearPopularRangeItemStatus();
        clearAgeRangeItemStatus();
        clearFaceMappingData();
      }
      if (j < 2) {
        clearCpRangeItemStatus();
      }
      int i = 0;
      for (;;)
      {
        paramList1 = paramFrame;
        if (i >= j) {
          break;
        }
        paramList = (Face)this.mFaceList.get(i);
        setCurPersonId(paramList.faceIndex);
        hitCharmRangeItem(paramList.faceIndex);
        hitAgeRangeItem(paramList.faceIndex);
        hitGenderRangeItem(paramList.faceIndex);
        hitPopularRangeItem(paramList.faceIndex);
        hitCpRangeItem(paramList.faceIndex, j);
        BenchUtil.benchStart("[showPreview]updateAllFilters");
        updateAllFilters(paramList.facePoints, paramList.faceAngles, paramMap, 0.0F);
        BenchUtil.benchEnd("[showPreview]updateAllFilters");
        BenchUtil.benchStart("[showPreview]RenderProcess");
        paramFrame = RenderProcessForFilters(paramFrame, this.otherFilters);
        BenchUtil.benchEnd("[showPreview]RenderProcess");
        i += 1;
      }
      i = 0;
      while (i < paramList.size())
      {
        paramFrame = new Face();
        paramFrame.facePoints = ((List)paramList.get(i));
        paramFrame.faceAngles = ((float[])paramList1.get(i));
        paramFrame.faceIndex = i;
        this.mFaceList.add(paramFrame);
        i += 1;
      }
    }
    VideoFilterUtil.setBlendMode(false);
    return paramList1;
  }
  
  public Frame updateAndRenderActMaterial(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, int paramInt)
  {
    Frame localFrame = paramFrame;
    if (this.mActFilters != null)
    {
      long l = System.currentTimeMillis();
      VideoFilterUtil.setBlendMode(true);
      localFrame = this.mActFilters.updateAndRender(paramFrame, l, paramList, paramList1, paramDouble, paramInt);
      VideoFilterUtil.setBlendMode(false);
    }
    return localFrame;
  }
  
  public Frame updateAndRenderAllStickers(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    Frame localFrame = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 <= 0)
    {
      this.mCopyFilter.RenderProcess(paramInt2, paramInt3, paramInt4, -1, 0.0D, this.copyFrame[0]);
      localFrame = this.copyFrame[0];
    }
    List localList1 = VideoPreviewFaceOutlineDetector.getInstance().getAllFaces();
    List localList2 = VideoPreviewFaceOutlineDetector.getInstance().getAllFaceAngles();
    Map localMap = VideoPreviewFaceOutlineDetector.getInstance().getFaceActionCounter();
    updateVideoSize(paramInt3, paramInt4, paramDouble);
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    localFrame = updateAndRenderStaticStickers(updateAndRender(localFrame, localList1, localList2, localMap, paramDouble), localList1, localList2, localMap, paramDouble, 0, this.staticStickerFilters);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return localFrame;
  }
  
  public Frame updateAndRenderBgStickers(Frame paramFrame1, Frame paramFrame2, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, double paramDouble, int paramInt, List<VideoFilterBase> paramList2)
  {
    paramInt = (paramInt + 360) % 360;
    if (((paramInt == 90) || (paramInt == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame1;
    }
    updateVideoSize(paramFrame1.width, paramFrame1.height, paramDouble);
    VideoFilterUtil.setBlendMode(true);
    if (this.headCropFilter != null)
    {
      this.mCopyFilter.RenderProcess(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, -1, 0.0D, this.mHeadCropFrame);
      this.headCropFilter.setInputFrame(this.mHeadCropFrame);
      paramFrame1.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
    }
    if (paramList.size() <= 0) {
      updateFilters(null, null, paramMap, 0.0F, paramList2);
    }
    for (paramFrame1 = RenderProcessForFilters(paramFrame1, paramList2);; paramFrame1 = RenderProcessForFilters(paramFrame1, paramList2))
    {
      VideoFilterUtil.setBlendMode(false);
      return paramFrame1;
      updateFilters((List)paramList.get(0), (float[])paramList1.get(0), paramMap, 0.0F, paramList2);
    }
  }
  
  public Frame updateAndRenderFabbyMV(Frame paramFrame1, Frame paramFrame2, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, double paramDouble)
  {
    paramList1 = null;
    int i = 0;
    paramList = paramFrame2;
    long l = System.currentTimeMillis();
    Iterator localIterator = this.fabbyMvFilters.iterator();
    if (localIterator.hasNext())
    {
      FabbyMvFilters localFabbyMvFilters = (FabbyMvFilters)localIterator.next();
      BenchUtil.benchStart("[showPreview][FABBY] FabbyMvFilters " + this.fabbyMvFilters.indexOf(localFabbyMvFilters));
      int j = localFabbyMvFilters.renderState(paramMap, this.fabbyMvFilters.size(), l, this.material.getDataPath());
      if (j == 1)
      {
        paramList1 = localFabbyMvFilters;
        if (localFabbyMvFilters.getGridMode(l) == 1)
        {
          BenchUtil.benchStart("[showPreview][FABBY] bg");
          paramList = paramList1.renderBgFilter(paramFrame1, l);
          BenchUtil.benchEnd("[showPreview][FABBY] bg");
          BenchUtil.benchStart("[showPreview][FABBY] grid");
          paramList = localFabbyMvFilters.updateAndRender(paramList, paramFrame2, l);
          BenchUtil.benchEnd("[showPreview][FABBY] grid");
          BenchUtil.benchStart("[showPreview][FABBY] cover");
          paramList = paramList1.renderCoverFilter(paramList, l);
          BenchUtil.benchEnd("[showPreview][FABBY] cover");
          BenchUtil.benchStart("[showPreview][FABBY] fg");
          paramList = paramList1.renderFgFilter(paramList, l);
          BenchUtil.benchEnd("[showPreview][FABBY] fg");
        }
      }
      for (;;)
      {
        BenchUtil.benchEnd("[showPreview][FABBY] FabbyMvFilters " + this.fabbyMvFilters.indexOf(localFabbyMvFilters));
        break;
        BenchUtil.benchStart("[showPreview][FABBY] bg");
        paramList = paramList1.renderBgFilter(paramFrame1, l);
        BenchUtil.benchEnd("[showPreview][FABBY] bg");
        BenchUtil.benchStart("[showPreview][FABBY] merge");
        VideoFilterUtil.setBlendMode(true);
        this.fabbyFilter2.setTex(paramFrame2.getTextureId());
        this.fabbyFilter2.ApplyGLSLFilter(false, paramFrame2.width, paramFrame2.height);
        this.fabbyFilter2.OnDrawFrameGLSL();
        this.fabbyFilter2.renderTexture(paramList.getTextureId(), paramList.width, paramList.height);
        VideoFilterUtil.setBlendMode(false);
        BenchUtil.benchEnd("[showPreview][FABBY] merge");
        BenchUtil.benchStart("[showPreview][FABBY] cover");
        paramList = paramList1.renderCoverFilter(paramList, l);
        BenchUtil.benchEnd("[showPreview][FABBY] cover");
        BenchUtil.benchStart("[showPreview][FABBY] fg");
        paramList = paramList1.renderFgFilter(paramList, l);
        BenchUtil.benchEnd("[showPreview][FABBY] fg");
        BenchUtil.benchStart("[showPreview][FABBY] grid");
        this.fabbyMergeFrame.bindFrame(-1, paramList.width, paramList.height, 0.0D);
        FrameUtil.clearFrame(this.fabbyMergeFrame, 0.0F, 0.0F, 0.0F, 0.0F);
        paramList = localFabbyMvFilters.updateAndRender(this.fabbyMergeFrame, paramList, l);
        BenchUtil.benchEnd("[showPreview][FABBY] grid");
        continue;
        if (j == 2) {
          i = 1;
        }
        localFabbyMvFilters.resetFilter();
      }
    }
    if ((paramList1 != null) && (paramList1.updateProgress(l, paramMap, this.fabbyMvFilters.size())))
    {
      BenchUtil.benchStart("[showPreview][FABBY] setTransitionParam");
      this.mCopyFilter.RenderProcess(paramList.getTextureId(), paramList.width, paramList.height, -1, 0.0D, this.mLastFabbyFrame);
      this.transitionFilter.setMvPart(paramList1.mvPart);
      this.transitionFilter.setDataPath(this.material.getDataPath());
      this.transitionFilter.setLastTex(this.mLastFabbyFrame.getTextureId());
      BenchUtil.benchEnd("[showPreview][FABBY] setTransitionParam");
    }
    if (i != 0)
    {
      BenchUtil.benchStart("[showPreview][FABBY] transition");
      this.transitionFilter.updatePreview(l);
      this.transitionFilter.RenderProcess(paramList.getLastRenderTextureId(), paramList.width, paramList.height, -1, 0.0D, this.fabbyTransitionResult);
      paramFrame1 = this.fabbyTransitionResult;
      BenchUtil.benchEnd("[showPreview][FABBY] transition");
      return paramFrame1;
    }
    this.transitionFilter.reset();
    return paramList;
  }
  
  public Frame updateAndRenderStaticStickers(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, double paramDouble, int paramInt, List<VideoFilterBase> paramList2)
  {
    paramInt = (paramInt + 360) % 360;
    if (((paramInt == 90) || (paramInt == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame;
    }
    updateVideoSize(paramFrame.width, paramFrame.height, paramDouble);
    VideoFilterUtil.setBlendMode(true);
    if (paramList.size() <= 0) {
      updateFilters(null, null, paramMap, 0.0F, paramList2);
    }
    for (paramFrame = RenderProcessForFilters(paramFrame, paramList2);; paramFrame = RenderProcessForFilters(paramFrame, paramList2))
    {
      paramList = paramFrame;
      if (this.mEffectOrder == 2)
      {
        paramList = paramFrame;
        if (this.mEffectFilter != null)
        {
          this.mEffectFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mEffectFrame);
          paramList = this.mEffectFrame;
        }
      }
      VideoFilterUtil.setBlendMode(false);
      return paramList;
      updateFilters((List)paramList.get(0), (float[])paramList1.get(0), paramMap, 0.0F, paramList2);
    }
  }
  
  public void updateCosAlpha(int paramInt)
  {
    if (VideoMaterialUtil.isCosMaterial(getMaterial()))
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof FaceOffFilter)) {
          ((FaceOffFilter)localVideoFilterBase).setCosAlpha(paramInt / 100.0F);
        }
      }
    }
  }
  
  public void updateFilters(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, List<VideoFilterBase> paramList1)
  {
    long l = System.currentTimeMillis();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      ((VideoFilterBase)paramList1.next()).updatePreview(paramList, paramArrayOfFloat, paramMap, paramFloat, l);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (!isValid()) {}
    do
    {
      return;
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
      localIterator = this.bgFilters.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
      localIterator = this.fabbyMvFilters.iterator();
      while (localIterator.hasNext()) {
        ((FabbyMvFilters)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
      if (this.headCropFilter != null) {
        this.headCropFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
      if (this.crazyFaceFilters != null) {
        this.crazyFaceFilters.updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    } while (this.mARParticleFilter == null);
    this.mARParticleFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
  
  private class FaceData
  {
    public float mFaceAngle;
    public List<PointF> mFacePoints;
    public float mPhoneAngle;
    public long mTimeStamp;
    
    private FaceData() {}
    
    public void init(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
    {
      this.mFacePoints = paramList;
      this.mFaceAngle = paramFloat1;
      this.mPhoneAngle = paramFloat2;
      this.mTimeStamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterList
 * JD-Core Version:    0.7.0.1
 */