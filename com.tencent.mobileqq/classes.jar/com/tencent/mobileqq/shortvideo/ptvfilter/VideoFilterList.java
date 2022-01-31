package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.SparseArray;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraARFilterGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.StaticGestureFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceInfo;
import com.tencent.ttpic.filter.FabbyFilter;
import com.tencent.ttpic.filter.FabbyFilter2;
import com.tencent.ttpic.filter.FabbyMvFilters;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.FaceCopyFilter;
import com.tencent.ttpic.filter.FaceCropFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.StaticNumFilter;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.filter.SwitchFaceFilter;
import com.tencent.ttpic.filter.TransformFilterNew;
import com.tencent.ttpic.filter.TransitionFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

public class VideoFilterList
{
  public int a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame jdField_a_of_type_ComTencentFilterFrame = new Frame();
  private CameraARFilterGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraARFilterGesture;
  private FabbyFilter2 jdField_a_of_type_ComTencentTtpicFilterFabbyFilter2 = new FabbyFilter2();
  private FabbyFilter jdField_a_of_type_ComTencentTtpicFilterFabbyFilter;
  private FabbyStrokeFilter jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter;
  private TransitionFilter jdField_a_of_type_ComTencentTtpicFilterTransitionFilter = new TransitionFilter();
  private VideoMaterial jdField_a_of_type_ComTencentTtpicModelVideoMaterial;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  public List a;
  private Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private Frame[] jdField_a_of_type_ArrayOfComTencentFilterFrame = new Frame[2];
  public int b;
  private Frame jdField_b_of_type_ComTencentFilterFrame = new Frame();
  private List jdField_b_of_type_JavaUtilList;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  public int c;
  private Frame jdField_c_of_type_ComTencentFilterFrame = new Frame();
  private List jdField_c_of_type_JavaUtilList;
  private int[] jdField_c_of_type_ArrayOfInt = new int[1];
  private int jdField_d_of_type_Int = -1;
  private Frame jdField_d_of_type_ComTencentFilterFrame = new Frame();
  private List jdField_d_of_type_JavaUtilList;
  private int jdField_e_of_type_Int = 0;
  private Frame jdField_e_of_type_ComTencentFilterFrame = new Frame();
  private List jdField_e_of_type_JavaUtilList = new ArrayList();
  private int jdField_f_of_type_Int = -1;
  private Frame jdField_f_of_type_ComTencentFilterFrame = new Frame();
  
  public VideoFilterList()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private int a(LinkedList paramLinkedList, FaceDetector paramFaceDetector)
  {
    int j = 0;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 1))
    {
      a("shookHeadCount analysisShookHead empty!");
      return 0;
    }
    FaceInfo localFaceInfo = (FaceInfo)paramLinkedList.getFirst();
    String str = "";
    int i;
    if ((localFaceInfo.yaw > 25.0F) && (a(paramLinkedList)))
    {
      paramFaceDetector = "向右";
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramLinkedList.clear();
        paramLinkedList.addFirst(localFaceInfo);
      }
      a("shookHeadCount analysisShookHead shookType:" + i + ", direction:" + paramFaceDetector + ", currentSize:" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      return i;
      i = j;
      paramFaceDetector = str;
      if (localFaceInfo.yaw < -25.0F)
      {
        i = j;
        paramFaceDetector = str;
        if (b(paramLinkedList))
        {
          i = 2;
          paramFaceDetector = "向左";
        }
      }
    }
  }
  
  private int a(LinkedList paramLinkedList, List paramList)
  {
    int j;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      a("shookHeadCount selectFace empty!");
      j = -1;
      return j;
    }
    float f1 = ((PointF)((FaceInfo)paramLinkedList.getFirst()).points.get(9)).x;
    int i = 0;
    label49:
    if (i < paramList.size())
    {
      paramLinkedList = (LinkedList)paramList.get(i);
      float f2;
      boolean bool;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        f2 = ((PointF)((FaceInfo)paramLinkedList.getFirst()).points.get(9)).x;
        if (this.jdField_e_of_type_Int != 1) {
          break label207;
        }
        if (f2 <= f1) {
          break label228;
        }
        bool = true;
      }
      for (;;)
      {
        j = i;
        if (bool) {
          break;
        }
        a("shookHeadCount selectDrawFaceIndex trigger:" + bool + ", index:" + -1 + ", shookType: " + this.jdField_e_of_type_Int + ", currentX:" + f1 + ", userX:" + f2);
        i += 1;
        break label49;
        label207:
        if ((this.jdField_e_of_type_Int == 2) && (f2 < f1)) {
          bool = true;
        } else {
          label228:
          bool = false;
        }
      }
    }
    return -1;
  }
  
  private List a(List paramList)
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
  
  private List a(List paramList1, List paramList2)
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
  
  public static void a(String paramString)
  {
    if (SLog.a()) {
      SLog.a("VideoFilterList", paramString);
    }
  }
  
  private boolean a(VideoFilterBase paramVideoFilterBase)
  {
    Object localObject;
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      localObject = paramVideoFilterBase.getStickerItem();
      if ((localObject == null) || (!((NormalVideoFilter)paramVideoFilterBase).isRenderReady())) {
        return false;
      }
      if (this.jdField_d_of_type_Int == -1) {
        return true;
      }
      if ((((StickerItem)localObject).personID != -1) && (((StickerItem)localObject).personID != this.jdField_d_of_type_Int)) {
        return false;
      }
      if (((((StickerItem)localObject).charmRange != null) && (!((StickerItem)localObject).charmRange.isHit())) || ((((StickerItem)localObject).ageRange != null) && (!((StickerItem)localObject).ageRange.isHit())) || ((((StickerItem)localObject).genderRange != null) && (!((StickerItem)localObject).genderRange.isHit())) || ((((StickerItem)localObject).popularRange != null) && (!((StickerItem)localObject).popularRange.isHit())) || ((((StickerItem)localObject).cpRange != null) && (!((StickerItem)localObject).cpRange.isHit()))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceOffFilter))
    {
      localObject = ((FaceOffFilter)paramVideoFilterBase).getFaceOffItem();
      if ((localObject != null) && (((((FaceItem)localObject).personID != -1) && (this.jdField_d_of_type_Int != -1) && (((FaceItem)localObject).personID != this.jdField_d_of_type_Int)) || ((this.jdField_d_of_type_Int != -1) && (((FaceItem)localObject).charmRange != null) && (!((FaceItem)localObject).charmRange.isHit())))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof TransformFilterNew))
    {
      localObject = ((TransformFilterNew)paramVideoFilterBase).getFaceMeshItem();
      if ((localObject != null) && (((((FaceMeshItem)localObject).personID != -1) && (this.jdField_d_of_type_Int != -1) && (((FaceMeshItem)localObject).personID != this.jdField_d_of_type_Int)) || ((this.jdField_d_of_type_Int != -1) && (((FaceMeshItem)localObject).charmRange != null) && (!((FaceMeshItem)localObject).charmRange.isHit())))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceCropFilter)) {
      return ((FaceCropFilter)paramVideoFilterBase).isNeedRender();
    }
    if ((paramVideoFilterBase instanceof BuckleFaceFilter)) {
      return ((BuckleFaceFilter)paramVideoFilterBase).a();
    }
    return true;
  }
  
  private boolean a(LinkedList paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      return false;
    }
    FaceInfo localFaceInfo1 = (FaceInfo)paramLinkedList.getFirst();
    paramLinkedList = paramLinkedList.listIterator();
    FaceInfo localFaceInfo2;
    do
    {
      if (!paramLinkedList.hasNext()) {
        break;
      }
      localFaceInfo2 = (FaceInfo)paramLinkedList.next();
    } while (localFaceInfo1.yaw - localFaceInfo2.yaw <= 12.0F);
    for (boolean bool = true;; bool = false)
    {
      a("shookHeadCount hasShookToRight hasShook:" + bool);
      return bool;
    }
  }
  
  private List b(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
        if (((localVideoFilterBase instanceof StaticStickerFilter)) && ((localVideoFilterBase instanceof StaticCountFilter))) {
          localArrayList.add((StaticCountFilter)localVideoFilterBase);
        }
      }
    }
    return localArrayList;
  }
  
  private boolean b(LinkedList paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      return false;
    }
    FaceInfo localFaceInfo1 = (FaceInfo)paramLinkedList.getFirst();
    paramLinkedList = paramLinkedList.listIterator();
    FaceInfo localFaceInfo2;
    do
    {
      if (!paramLinkedList.hasNext()) {
        break;
      }
      localFaceInfo2 = (FaceInfo)paramLinkedList.next();
    } while (localFaceInfo1.yaw - localFaceInfo2.yaw >= -12.0F);
    for (boolean bool = true;; bool = false)
    {
      a("shookHeadCount hasShookToLeft hasShook:" + bool);
      return bool;
    }
  }
  
  public Frame a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, FaceDetector paramFaceDetector, long paramLong)
  {
    Frame localFrame = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!a()) {}
    while (paramFaceDetector == null) {
      return localFrame;
    }
    com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil.a(true);
    Object localObject2;
    Object localObject1;
    if (VideoMaterialUtil.isFaceCopyMaterial(a()))
    {
      localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        localObject1 = localFrame;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (VideoFilterBase)((Iterator)localObject2).next();
        if ((localObject1 instanceof FaceCopyFilter))
        {
          localObject1 = (FaceCopyFilter)localObject1;
          ((FaceCopyFilter)localObject1).setFaceParams(paramFaceDetector.getAllFaces(), localFrame.getTextureId());
          ((FaceCopyFilter)localObject1).renderProcess();
        }
      }
    }
    if (VideoMaterialUtil.isFaceSwitchMaterial(a()))
    {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, this.jdField_a_of_type_ArrayOfComTencentFilterFrame[0]);
      GLES20.glBindFramebuffer(36160, localFrame.getFBO());
      GLES20.glViewport(0, 0, localFrame.width, localFrame.height);
      localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        localObject1 = localFrame;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (VideoFilterBase)((Iterator)localObject2).next();
        if ((localObject1 instanceof SwitchFaceFilter))
        {
          localObject1 = (SwitchFaceFilter)localObject1;
          ((SwitchFaceFilter)localObject1).setFaceParams(paramFaceDetector.getAllFaces(), this.jdField_a_of_type_ArrayOfComTencentFilterFrame[0].getTextureId());
          ((SwitchFaceFilter)localObject1).renderProcess();
        }
      }
    }
    int k = paramFaceDetector.getFaceCount();
    Map localMap = paramFaceDetector.getFaceActionCounter();
    List localList = paramFaceDetector.getAllFaces();
    if (c())
    {
      localObject1 = paramFaceDetector.getFaceInfos();
      a("shookHeadCount allSize:" + ((List)localObject1).size() + ", lastDetectCount:" + this.jdField_c_of_type_Int);
      if (((List)localObject1).size() > 1)
      {
        if ((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0) || (this.jdField_c_of_type_Int != ((List)localObject1).size()))
        {
          this.jdField_a_of_type_JavaUtilLinkedList = ((LinkedList)((List)localObject1).get(0));
          this.jdField_f_of_type_Int = 0;
          this.jdField_e_of_type_Int = 0;
          a("shookHeadCount apply new value!");
        }
        int j = 0;
        int i = j;
        if (this.jdField_e_of_type_Int != 0)
        {
          i = j;
          if (this.jdField_a_of_type_JavaUtilLinkedList != null)
          {
            i = j;
            if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
            {
              this.jdField_f_of_type_Int = a(this.jdField_a_of_type_JavaUtilLinkedList, (List)localObject1);
              i = j;
              if (this.jdField_f_of_type_Int >= 0)
              {
                i = j;
                if (this.jdField_f_of_type_Int < ((List)localObject1).size())
                {
                  this.jdField_a_of_type_JavaUtilLinkedList = ((LinkedList)((List)localObject1).get(this.jdField_f_of_type_Int));
                  this.jdField_b_of_type_Int += 1;
                  i = 1;
                  a("shookHeadCount count:" + this.jdField_b_of_type_Int + ", selectFaceIndex:" + this.jdField_f_of_type_Int);
                }
              }
            }
          }
        }
        this.jdField_e_of_type_Int = 0;
        if (i == 0) {
          this.jdField_e_of_type_Int = a(this.jdField_a_of_type_JavaUtilLinkedList, paramFaceDetector);
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = ((List)localObject1).size();
        if (this.jdField_b_of_type_Int > 99) {
          this.jdField_b_of_type_Int = 99;
        }
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StaticCountFilter)((Iterator)localObject1).next()).a(this.jdField_b_of_type_Int);
        }
        if (((List)localObject1).size() == 1)
        {
          this.jdField_a_of_type_JavaUtilLinkedList = ((LinkedList)((List)localObject1).get(0));
          this.jdField_f_of_type_Int = 0;
        }
        else if (((List)localObject1).size() <= 0)
        {
          this.jdField_a_of_type_JavaUtilLinkedList = null;
          this.jdField_f_of_type_Int = -1;
        }
      }
    }
    if (k <= 0)
    {
      a(-1);
      a(null, null, localMap, paramFloat, this.jdField_b_of_type_JavaUtilList, paramLong);
      localFrame = a(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_d_of_type_JavaUtilList);
    }
    for (;;)
    {
      paramInt1 = 0;
      if (paramInt1 < Math.min(k, a().getMaxFaceCount()))
      {
        if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_f_of_type_Int >= 0) && (this.jdField_f_of_type_Int < localList.size())) {
          localObject1 = (List)localList.get(this.jdField_f_of_type_Int);
        }
        for (localObject2 = (float[])paramFaceDetector.getAllFaceAngles().get(this.jdField_f_of_type_Int);; localObject2 = (float[])paramFaceDetector.getAllFaceAngles().get(paramInt1))
        {
          a(paramInt1);
          a((List)localObject1, (float[])localObject2, localMap, 0.0F, this.jdField_b_of_type_JavaUtilList, paramLong);
          localFrame = a(localFrame.getFBO(), localFrame.getTextureId(), paramInt3, paramInt4, this.jdField_d_of_type_JavaUtilList);
          paramInt1 += 1;
          break;
          localObject1 = (List)localList.get(paramInt1);
        }
      }
      localObject1 = localFrame;
      com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil.a(false);
      return localObject1;
    }
  }
  
  public Frame a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, FaceDetector paramFaceDetector, long paramLong)
  {
    Frame localFrame = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 <= 0)
    {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramInt2, paramInt3, paramInt4, -1, 0.0D, this.jdField_a_of_type_ArrayOfComTencentFilterFrame[0]);
      localFrame = this.jdField_a_of_type_ArrayOfComTencentFilterFrame[0];
    }
    List localList1 = VideoPreviewFaceOutlineDetector.getInstance().getAllFaces();
    List localList2 = VideoPreviewFaceOutlineDetector.getInstance().getAllFaceAngles();
    Map localMap = VideoPreviewFaceOutlineDetector.getInstance().getFaceActionCounter();
    a(paramInt3, paramInt4, paramDouble);
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramFaceDetector = a(a(localFrame.getFBO(), localFrame.getTextureId(), 0.0F, paramInt3, paramInt4, paramFaceDetector, paramLong), localList1, localList2, localMap, paramDouble, 0, this.jdField_c_of_type_JavaUtilList, paramLong);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return paramFaceDetector;
  }
  
  public Frame a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List paramList)
  {
    Frame localFrame3 = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((VideoUtil.isEmpty(paramList)) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    Object localObject;
    Frame localFrame1;
    do
    {
      return localFrame3;
      localObject = this.jdField_a_of_type_ArrayOfComTencentFilterFrame[0];
      localFrame1 = this.jdField_a_of_type_ArrayOfComTencentFilterFrame[1];
    } while ((localObject == null) || (localFrame1 == null));
    label97:
    VideoFilterBase localVideoFilterBase;
    if (localFrame3.getTextureId() == ((Frame)localObject).getTextureId())
    {
      localObject = localFrame1;
      GLES20.glBindFramebuffer(36160, paramInt1);
      GLES20.glViewport(0, 0, paramInt3, paramInt4);
      paramInt1 = 0;
      localFrame1 = localFrame3;
      if (paramInt1 >= paramList.size()) {
        break label444;
      }
      localVideoFilterBase = (VideoFilterBase)paramList.get(paramInt1);
      if (a(localVideoFilterBase)) {
        break label140;
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label97;
      break;
      label140:
      if ((localVideoFilterBase instanceof ARParticleFilter))
      {
        while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) {
          ((ARParticleFilter)localVideoFilterBase).addTouchPoint((PointF)this.jdField_a_of_type_JavaUtilQueue.poll());
        }
        if (((ARParticleFilter)localVideoFilterBase).needCopyTex()) {
          ((ARParticleFilter)localVideoFilterBase).setInputFrame(new Frame(localFrame1.getFBO(), localFrame1.getTextureId(), paramInt3, paramInt4));
        }
        ((ARParticleFilter)localVideoFilterBase).updateAndRender(localFrame1.getTextureId());
        BenchUtil.benchEnd("[showPreview]ARParticleFilter preview!");
      }
      else
      {
        if (!com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil.a(localVideoFilterBase))
        {
          Frame localFrame2 = localFrame1;
          if (VideoFileUtil.needCopy(localVideoFilterBase)) {
            localFrame2 = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), paramInt3, paramInt4, this.jdField_a_of_type_ComTencentFilterBaseFilter, localFrame3, (Frame)localObject);
          }
          BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
          if ((com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil.b(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform())) {}
          for (localFrame1 = FrameUtil.renderProcessByCopy(localFrame2.getTextureId(), paramInt3, paramInt4, localVideoFilterBase, this.jdField_a_of_type_ComTencentFilterBaseFilter, localFrame3, (Frame)localObject);; localFrame1 = FrameUtil.renderProcessBySwitchFbo(localFrame2.getTextureId(), paramInt3, paramInt4, localVideoFilterBase, localFrame3, (Frame)localObject))
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
    label444:
    return localFrame1;
  }
  
  public Frame a(Frame paramFrame1, Frame paramFrame2)
  {
    a("fabby doFabbyStroke start!");
    if (this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getSegmentStrokeWidth() > 0.0D)
    {
      this.jdField_c_of_type_ComTencentFilterFrame.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
      FrameUtil.clearFrame(this.jdField_c_of_type_ComTencentFilterFrame, 0.0F, 0.0F, 0.0F, 0.0F);
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.setmMaskTex(paramFrame2.getTextureId());
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.setStepX(1.0F / paramFrame1.width);
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.setStepY(1.0F / paramFrame1.height);
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.setStrokeGapInPixel((float)this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getSegmentStrokeGap() * Math.min(paramFrame1.width, paramFrame1.height));
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.setStrokeWidthInPixel((float)this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getSegmentStrokeWidth() * Math.min(paramFrame1.width, paramFrame1.height));
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.setStrokeColor(this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getSegmentStrokeColor());
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.setFeather(this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getSegmentFeather());
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.jdField_c_of_type_ComTencentFilterFrame);
    }
    for (;;)
    {
      a("fabby doFabbyStroke end!");
      return this.jdField_c_of_type_ComTencentFilterFrame;
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter.setTex(paramFrame2.getTextureId());
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.jdField_c_of_type_ComTencentFilterFrame);
    }
  }
  
  public Frame a(Frame paramFrame1, Frame paramFrame2, List paramList1, List paramList2, Map paramMap, double paramDouble)
  {
    paramList2 = null;
    int i = 0;
    long l = System.currentTimeMillis();
    Iterator localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
    paramList1 = paramFrame2;
    FabbyMvFilters localFabbyMvFilters;
    List localList;
    if (localIterator.hasNext())
    {
      localFabbyMvFilters = (FabbyMvFilters)localIterator.next();
      a("fabby FabbyMvFilters start:" + this.jdField_e_of_type_JavaUtilList.indexOf(localFabbyMvFilters));
      int j = localFabbyMvFilters.renderState(paramMap, this.jdField_e_of_type_JavaUtilList.size(), l, this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getDataPath());
      if (j == 1)
      {
        if (localFabbyMvFilters.getGridMode(l) == 1)
        {
          a("fabby bg!");
          paramList1 = localFabbyMvFilters.renderBgFilter(paramFrame1, l);
          a("fabby bg!");
          a("fabby grid!");
          paramList1 = localFabbyMvFilters.updateAndRender(paramList1, paramFrame2, l);
          a("fabby grid!");
          a("fabby cover!");
          paramList1 = localFabbyMvFilters.renderCoverFilter(paramList1, l);
          a("fabby cover!");
          a("fabby fg!");
          paramList2 = localFabbyMvFilters.renderFgFilter(paramList1, l);
          a("fabby fg!");
        }
        for (;;)
        {
          paramList1 = localFabbyMvFilters;
          a("fabby FabbyMvFilters end:" + this.jdField_e_of_type_JavaUtilList.indexOf(localFabbyMvFilters));
          localList = paramList1;
          paramList1 = paramList2;
          paramList2 = localList;
          break;
          a("fabby bg!");
          paramList1 = localFabbyMvFilters.renderBgFilter(paramFrame1, l);
          a("fabby bg!");
          a("fabby merge!");
          com.tencent.ttpic.util.VideoFilterUtil.setBlendMode(true);
          this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter2.setTex(paramFrame2.getTextureId());
          this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter2.ApplyGLSLFilter(false, paramFrame2.width, paramFrame2.height);
          this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter2.OnDrawFrameGLSL();
          this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter2.renderTexture(paramList1.getTextureId(), paramList1.width, paramList1.height);
          com.tencent.ttpic.util.VideoFilterUtil.setBlendMode(false);
          a("fabby merge!");
          a("fabby cover!");
          paramList1 = localFabbyMvFilters.renderCoverFilter(paramList1, l);
          a("fabby cover!");
          a("fabby fg!");
          paramList1 = localFabbyMvFilters.renderFgFilter(paramList1, l);
          a("fabby fg!");
          a("fabby grid!");
          this.jdField_e_of_type_ComTencentFilterFrame.bindFrame(-1, paramList1.width, paramList1.height, 0.0D);
          FrameUtil.clearFrame(this.jdField_e_of_type_ComTencentFilterFrame, 0.0F, 0.0F, 0.0F, 0.0F);
          paramList2 = localFabbyMvFilters.updateAndRender(this.jdField_e_of_type_ComTencentFilterFrame, paramList1, l);
          a("fabby grid!");
        }
      }
      if (j != 2) {
        break label651;
      }
      i = 1;
    }
    label651:
    for (;;)
    {
      localFabbyMvFilters.resetFilter();
      localList = paramList2;
      paramList2 = paramList1;
      paramList1 = localList;
      break;
      if ((paramList2 != null) && (paramList2.updateProgress(l, paramMap, this.jdField_e_of_type_JavaUtilList.size())))
      {
        a("fabby setTransitionParam start!");
        this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramList1.getTextureId(), paramList1.width, paramList1.height, -1, 0.0D, this.jdField_f_of_type_ComTencentFilterFrame);
        this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.setMvPart(paramList2.mvPart);
        this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.setDataPath(this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getDataPath());
        this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.setLastTex(this.jdField_f_of_type_ComTencentFilterFrame.getTextureId());
        a("fabby setTransitionParam end!");
      }
      if (i != 0)
      {
        a("fabby transition start!");
        this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.updatePreview(l);
        this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.RenderProcess(paramList1.getLastRenderTextureId(), paramList1.width, paramList1.height, -1, 0.0D, this.jdField_d_of_type_ComTencentFilterFrame);
        paramFrame1 = this.jdField_d_of_type_ComTencentFilterFrame;
        a("fabby transition end!");
        return paramFrame1;
      }
      this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.reset();
      return paramList1;
    }
  }
  
  public Frame a(Frame paramFrame, List paramList1, List paramList2, Map paramMap, double paramDouble, int paramInt, List paramList3, long paramLong)
  {
    paramInt = (paramInt + 360) % 360;
    if (((paramInt == 90) || (paramInt == 270)) && (!this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.isSupportLandscape())) {
      return paramFrame;
    }
    a(paramFrame.width, paramFrame.height, paramDouble);
    com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil.a(true);
    if (paramList1.size() <= 0) {
      a(null, null, paramMap, 0.0F, paramList3, paramLong);
    }
    for (paramFrame = a(paramFrame.getFBO(), paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramList3);; paramFrame = a(paramFrame.getFBO(), paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramList3))
    {
      com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil.a(false);
      return paramFrame;
      a((List)paramList1.get(0), (float[])paramList2.get(0), paramMap, 0.0F, paramList3, paramLong);
    }
  }
  
  public VideoMaterial a()
  {
    return this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial;
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentFilterFrame.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentFilterFrame[i] = new Frame();
      i += 1;
    }
    this.jdField_d_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, double paramDouble)
  {
    if (!a()) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseFilter localBaseFilter = (BaseFilter)localIterator.next();
      if ((localBaseFilter instanceof VideoFilterBase)) {
        ((VideoFilterBase)localBaseFilter).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
    localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilters)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public void a(PointF paramPointF)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramPointF);
  }
  
  public void a(VideoFilterBase paramVideoFilterBase)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramVideoFilterBase);
    a(this.jdField_b_of_type_JavaUtilList);
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial = paramVideoMaterial;
  }
  
  public void a(List paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_JavaUtilList = a(paramList);
    this.jdField_d_of_type_JavaUtilList = a(paramList, this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList = b(this.jdField_c_of_type_JavaUtilList);
  }
  
  public void a(List paramList1, float[] paramArrayOfFloat, Map paramMap, float paramFloat, List paramList2, long paramLong)
  {
    if (!a()) {}
    for (;;)
    {
      return;
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        ((VideoFilterBase)paramList2.next()).updatePreview(paramList1, paramArrayOfFloat, paramMap, paramFloat, paramLong);
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    int k = 0;
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    while (!a()) {
      return;
    }
    c();
    if (!VideoUtil.isEmpty(this.jdField_b_of_type_JavaUtilList))
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof ARParticleFilter)) {
          ((ARParticleFilter)localVideoFilterBase).clear();
        } else {
          localVideoFilterBase.clearGLSLSelf();
        }
      }
    }
    Iterator localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilters)localIterator.next()).clear();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ArrayOfComTencentFilterFrame.length) {
        break;
      }
      if (this.jdField_a_of_type_ArrayOfComTencentFilterFrame[i] != null) {
        this.jdField_a_of_type_ArrayOfComTencentFilterFrame[i].clear();
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((Frame)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(j)).clear();
      j += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    this.jdField_e_of_type_ComTencentFilterFrame.clear();
    this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.ClearGLSL();
    this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter2.ClearGLSL();
    if (this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter.ClearGLSL();
    }
    if (this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.ClearGLSL();
    }
    f();
  }
  
  public void b(int paramInt1, int paramInt2, double paramDouble)
  {
    if (!a()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BaseFilter localBaseFilter = (BaseFilter)localIterator.next();
        if ((localBaseFilter instanceof VideoFilterBase)) {
          ((VideoFilterBase)localBaseFilter).updateVideoSize(paramInt1, paramInt2, paramDouble);
        }
      }
    }
  }
  
  public void b(List paramList)
  {
    this.jdField_e_of_type_JavaUtilList = paramList;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.isSegmentRequired();
  }
  
  public void c()
  {
    if (!a()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BaseFilter localBaseFilter = (BaseFilter)localIterator.next();
        if ((localBaseFilter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localBaseFilter).destroyAudio();
        }
        if ((localBaseFilter instanceof NonFit2DFilter)) {
          ((NonFit2DFilter)localBaseFilter).b();
        }
        if ((localBaseFilter instanceof StaticGestureFilter)) {
          ((StaticGestureFilter)localBaseFilter).c();
        }
        if ((localBaseFilter instanceof GestureFilterManager)) {
          ((GestureFilterManager)localBaseFilter).b();
        }
        if ((localBaseFilter instanceof ARParticleFilter)) {
          ((ARParticleFilter)localBaseFilter).destroyAudioPlayer();
        }
      }
      localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((FabbyMvFilters)localIterator.next()).destroyAudioPlayer();
      }
    }
  }
  
  public boolean c()
  {
    return (a() != null) && ((a() instanceof QQVideoMaterial)) && (((QQVideoMaterial)a()).c());
  }
  
  public void d()
  {
    if (!a()) {
      if (SLog.a()) {
        SLog.a("VideoFilterList", "ApplyGLSLFilter filters empty!");
      }
    }
    do
    {
      return;
      a();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
      }
      localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((FabbyMvFilters)localIterator.next()).ApplyGLSLFilter();
      }
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter = new FabbyFilter();
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter = new FabbyStrokeFilter();
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyFilter.ApplyGLSLFilter();
      this.jdField_a_of_type_ComTencentTtpicFilterFabbyStrokeFilter.ApplyGLSLFilter();
      if (this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter != null) {
        this.jdField_a_of_type_ComTencentTtpicFilterTransitionFilter.ApplyGLSLFilter();
      }
    } while (this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial == null);
    VideoPreviewFaceOutlineDetector.getInstance().setFaceValueDetectType(this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getFaceValueDetectType());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraARFilterGesture == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraARFilterGesture = new CameraARFilterGesture(this);
    }
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraARFilterGesture);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraARFilterGesture != null) {
      GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraARFilterGesture);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial != null) && (this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) && ((this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial instanceof QQVideoMaterial)) && (((QQVideoMaterial)this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial).b()))
    {
      f();
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList
 * JD-Core Version:    0.7.0.1
 */