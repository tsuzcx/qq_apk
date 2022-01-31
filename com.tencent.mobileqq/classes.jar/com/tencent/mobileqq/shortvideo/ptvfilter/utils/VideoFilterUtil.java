package com.tencent.mobileqq.shortvideo.ptvfilter.utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.filter.ttpic.TTPicFilterFactory;
import com.tencent.mobileqq.shortvideo.ptvfilter.BuckleFaceFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.NonFit2DFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.StaticCountFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.StaticGestureFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.BuckleFaceItem;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.filter.CustomVertexFilter;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.FabbyMvFilters;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FaceCopyFilter;
import com.tencent.ttpic.filter.FaceMoveFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.SnakeFaceFilter;
import com.tencent.ttpic.filter.SwitchFaceFilter;
import com.tencent.ttpic.filter.ThreeDimFilter;
import com.tencent.ttpic.filter.TransformFilter;
import com.tencent.ttpic.filter.TransformFilterNew;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.FabbyFilterFactory;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_OFF_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoFilterUtil
{
  public static final String a = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonVertexShader.dat");
  public static final String b;
  public static final String c;
  
  static
  {
    if (VideoModule.es_GL_EXT_shader_framebuffer_fetch) {}
    for (String str = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImageExt.dat");; str = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImage.dat"))
    {
      b = str;
      c = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat");
      return;
    }
  }
  
  private static BuckleFaceFilter a(QQVideoMaterial paramQQVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((!paramQQVideoMaterial.a()) && (paramQQVideoMaterial.getShaderType() != 2001))
    {
      localObject1 = localObject2;
      if (paramQQVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) {}
    }
    else
    {
      localObject1 = localObject2;
      if (paramQQVideoMaterial.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem != null)
      {
        localObject1 = localObject2;
        if (paramQQVideoMaterial.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem.a.size() > 0) {
          localObject1 = new BuckleFaceFilter(paramQQVideoMaterial.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem, paramQQVideoMaterial.getDataPath());
        }
      }
    }
    return localObject1;
  }
  
  private static NonFit2DFilter a(QQVideoMaterial paramQQVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1;
    if (!paramQQVideoMaterial.a())
    {
      localObject1 = localObject2;
      if (paramQQVideoMaterial.getShaderType() != 2000) {}
    }
    else
    {
      localObject1 = localObject2;
      if (paramQQVideoMaterial.a() != null)
      {
        localObject1 = localObject2;
        if (paramQQVideoMaterial.a().length > 0) {
          localObject1 = new NonFit2DFilter(paramQQVideoMaterial.a(), paramQQVideoMaterial.getDataPath());
        }
      }
    }
    return localObject1;
  }
  
  public static VideoFilterList a(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial.a())
    {
      if (SLog.a()) {
        SLog.d(VideoFilterUtil.class.getName(), "createFiltersByFilterList");
      }
      return c(paramQQVideoMaterial);
    }
    if (SLog.a()) {
      SLog.d(VideoFilterUtil.class.getName(), "createFiltersByShaderType");
    }
    return b(paramQQVideoMaterial);
  }
  
  private static ARParticleFilter a(QQVideoMaterial paramQQVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQVideoMaterial.getArParticleList() != null)
    {
      localObject1 = localObject2;
      if (paramQQVideoMaterial.getArParticleList().size() > 0) {
        localObject1 = new ARParticleFilter(paramQQVideoMaterial.getArParticleList(), paramQQVideoMaterial.getDataPath());
      }
    }
    return localObject1;
  }
  
  private static CustomVertexFilter a(QQVideoMaterial paramQQVideoMaterial)
  {
    if ((paramQQVideoMaterial.a()) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value))
    {
      Object localObject2 = VideoMaterialUtil.loadVertexShader(paramQQVideoMaterial.getDataPath());
      String str = VideoMaterialUtil.loadFragmentShader(paramQQVideoMaterial.getDataPath());
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = c;
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = SnakeFaceFilter.FRAGMENT_SHADER;
      }
      if (!VideoUtil.isEmpty(paramQQVideoMaterial.getItemList())) {
        return new CustomVertexFilter((String)localObject1, (String)localObject2, null);
      }
    }
    return null;
  }
  
  private static CustomVideoFilter a(QQVideoMaterial paramQQVideoMaterial)
  {
    String str;
    if ((paramQQVideoMaterial.a()) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value))
    {
      localObject2 = VideoMaterialUtil.loadVertexShader(paramQQVideoMaterial.getDataPath());
      str = VideoMaterialUtil.loadFragmentShader(paramQQVideoMaterial.getDataPath());
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty(str))) {}
    }
    else
    {
      return null;
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = VideoFilterFactory.VERTEX_SHADER_COMMON;
    }
    Object localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = VideoFilterFactory.FRAGMENT_SHADER_IMAGE;
    }
    return new CustomVideoFilter((String)localObject1, (String)localObject2, paramQQVideoMaterial.getResourceList(), a(paramQQVideoMaterial.getItemList()), paramQQVideoMaterial.getDataPath());
  }
  
  private static SnakeFaceFilter a(QQVideoMaterial paramQQVideoMaterial)
  {
    SnakeFaceFilter localSnakeFaceFilter = null;
    if ((paramQQVideoMaterial.a()) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value)) {
      localSnakeFaceFilter = new SnakeFaceFilter();
    }
    return localSnakeFaceFilter;
  }
  
  private static VideoFilterBase a(QQVideoMaterial paramQQVideoMaterial)
  {
    SwitchFaceFilter localSwitchFaceFilter = null;
    if ((paramQQVideoMaterial.a()) || (VideoMaterialUtil.isFaceSwitchMaterial(paramQQVideoMaterial))) {
      localSwitchFaceFilter = new SwitchFaceFilter();
    }
    return localSwitchFaceFilter;
  }
  
  private static VideoMaterialUtil.TRIGGER_TYPE a(List paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return VideoMaterialUtil.TRIGGER_TYPE.UNKNOW;
    }
    int i = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramList.next();
      if (localStickerItem.triggerType <= i) {
        break label65;
      }
      i = localStickerItem.triggerType;
    }
    label65:
    for (;;)
    {
      break;
      return VideoMaterialUtil.getTriggerType(i);
    }
  }
  
  private static List a(QQVideoMaterial paramQQVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramQQVideoMaterial.a()) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value))
    {
      List localList = paramQQVideoMaterial.getFaceMeshItemList();
      if (!VideoUtil.isEmpty(localList))
      {
        int i = 0;
        while (i < localList.size())
        {
          localArrayList.add(new TransformFilterNew((FaceMeshItem)localList.get(i), paramQQVideoMaterial.getDataPath()));
          i += 1;
        }
      }
      if (VideoUtil.isEmpty(paramQQVideoMaterial.getDistortionItemList())) {
        break label180;
      }
      if (!paramQQVideoMaterial.isSegmentRequired()) {
        localArrayList.add(new TransformFilter(paramQQVideoMaterial.getDistortionItemList(), paramQQVideoMaterial.getItemList()));
      }
    }
    label180:
    while (VideoUtil.isEmpty(paramQQVideoMaterial.getFaceMoveItemList())) {
      return localArrayList;
    }
    localArrayList.add(new FaceMoveFilter(paramQQVideoMaterial.getFaceMoveItemList(), paramQQVideoMaterial.getItemList(), paramQQVideoMaterial.getFaceMoveTriangles()));
    return localArrayList;
  }
  
  private static List a(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getFabbyMvParts() != null)
    {
      Iterator localIterator = paramVideoMaterial.getFabbyMvParts().iterator();
      if (localIterator.hasNext())
      {
        FabbyMvPart localFabbyMvPart = (FabbyMvPart)localIterator.next();
        FabbyMvFilters localFabbyMvFilters = new FabbyMvFilters();
        if (localFabbyMvPart.bgItem != null) {
          localFabbyMvFilters.bgFilter = FabbyFilterFactory.createFilter(localFabbyMvPart.bgItem, paramVideoMaterial.getDataPath());
        }
        if (localFabbyMvPart.fgItem != null) {
          localFabbyMvFilters.fgFilter = FabbyFilterFactory.createFilter(localFabbyMvPart.fgItem, paramVideoMaterial.getDataPath());
        }
        if (localFabbyMvPart.coverItem != null) {
          localFabbyMvFilters.coverFilter = FabbyFilterFactory.createFilter(localFabbyMvPart.coverItem, paramVideoMaterial.getDataPath());
        }
        if (localFabbyMvPart.filterType == 1) {
          localFabbyMvFilters.filter = TTPicFilterFactory.creatFilterById(localFabbyMvPart.fid);
        }
        for (;;)
        {
          localFabbyMvFilters.mvPart = localFabbyMvPart;
          localArrayList.add(localFabbyMvFilters);
          break;
          if (localFabbyMvPart.filterType == 2)
          {
            localFabbyMvFilters.filter = new GPUImageLookupFilter();
            Bitmap localBitmap = VideoBitmapUtil.decodeSampledBitmapFromFile(paramVideoMaterial.getDataPath() + File.separator + localFabbyMvPart.lutFile, 1);
            localFabbyMvFilters.filter.addParam(new Param.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static void a(QQVideoMaterial paramQQVideoMaterial, List paramList1, List paramList2)
  {
    if (paramQQVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramQQVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (localStickerItem.triggerType == 1001)
        {
          Object localObject;
          if (localStickerItem.type == 1)
          {
            localObject = new StaticGestureFilter(localStickerItem, paramQQVideoMaterial.getDataPath());
            ((StaticGestureFilter)localObject).a(paramQQVideoMaterial.jdField_a_of_type_Int, paramQQVideoMaterial.b, paramQQVideoMaterial.c);
            paramList1.add(localObject);
            if (SLog.a()) {
              SLog.d("GesturetestUse", "static normalFirst is item:" + localStickerItem.toString() + "dataPath is:" + paramQQVideoMaterial.getDataPath() + ":" + ((StaticGestureFilter)localObject).a());
            }
          }
          else if (localStickerItem.type == 2)
          {
            localObject = new GestureFilterManager(localStickerItem, paramQQVideoMaterial.getDataPath());
            ((GestureFilterManager)localObject).a(paramQQVideoMaterial.jdField_a_of_type_Int, paramQQVideoMaterial.b, paramQQVideoMaterial.c);
            paramList2.add(localObject);
            if (SLog.a()) {
              SLog.d("GesturetestUse", "dynamic normalFirst is item:" + localStickerItem.toString() + "dataPath is:" + paramQQVideoMaterial.getDataPath() + ":markMode:" + localStickerItem.markMode + ":" + ((GestureFilterManager)localObject).a());
            }
          }
        }
      }
    }
  }
  
  public static void a(List paramList1, List paramList2)
  {
    paramList2.addAll(paramList1);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      return;
    }
    GLES20.glDisable(3042);
  }
  
  public static boolean a(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && ((((paramVideoFilterBase instanceof NormalVideoFilter)) && ((((NormalVideoFilter)paramVideoFilterBase).canUseBlendMode()) || (VideoModule.es_GL_EXT_shader_framebuffer_fetch))) || ((paramVideoFilterBase instanceof FaceOffByImageFilter)) || ((paramVideoFilterBase instanceof ThreeDimFilter)) || ((paramVideoFilterBase instanceof ARParticleFilter)) || ((paramVideoFilterBase instanceof HeadCropFilter)) || ((paramVideoFilterBase instanceof NonFit2DFilter)) || ((paramVideoFilterBase instanceof StaticGestureFilter)) || ((paramVideoFilterBase instanceof GestureFilterManager)));
  }
  
  public static VideoFilterList b(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial == null)
    {
      localObject1 = null;
      return localObject1;
    }
    CustomVideoFilter localCustomVideoFilter = a(paramQQVideoMaterial);
    CustomVertexFilter localCustomVertexFilter = a(paramQQVideoMaterial);
    SnakeFaceFilter localSnakeFaceFilter = a(paramQQVideoMaterial);
    Object localObject1 = d(paramQQVideoMaterial);
    List localList2 = a(paramQQVideoMaterial);
    VideoFilterBase localVideoFilterBase1 = a(paramQQVideoMaterial);
    VideoFilterBase localVideoFilterBase2 = b(paramQQVideoMaterial);
    List localList3 = b(paramQQVideoMaterial);
    List localList4 = c(paramQQVideoMaterial);
    NonFit2DFilter localNonFit2DFilter = a(paramQQVideoMaterial);
    BuckleFaceFilter localBuckleFaceFilter = a(paramQQVideoMaterial);
    List localList1 = a(paramQQVideoMaterial);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    a(paramQQVideoMaterial, (List)localObject2, (List)localObject3);
    localArrayList.addAll((Collection)localObject2);
    localArrayList.addAll(localList4);
    localArrayList.addAll((Collection)localObject3);
    if (!paramQQVideoMaterial.jdField_a_of_type_Boolean) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localCustomVideoFilter != null) {
        localCustomVideoFilter.setNormalFilters(localList4);
      }
      if (SLog.a()) {
        SLog.d(VideoFilterUtil.class.getName(), "createFiltersByShaderType  shaderType= " + paramQQVideoMaterial.getShaderType());
      }
      localObject2 = new VideoFilterList();
      localObject3 = new CopyOnWriteArrayList();
      if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.NORMAL.value) {
        ((List)localObject3).addAll(localArrayList);
      }
      for (;;)
      {
        ((VideoFilterList)localObject2).b(localList1);
        ((VideoFilterList)localObject2).a((List)localObject3);
        ((VideoFilterList)localObject2).a(paramQQVideoMaterial);
        localObject1 = localObject2;
        if (!SLog.a()) {
          break;
        }
        SLog.d(VideoFilterUtil.class.getName(), "createFiltersByShaderType  allFilters= " + ((List)localObject3).size() + " material=" + paramQQVideoMaterial);
        return localObject2;
        if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value)
        {
          ((List)localObject3).addAll(localArrayList);
          if (localCustomVideoFilter != null) {
            ((List)localObject3).add(localCustomVideoFilter);
          }
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value)
        {
          if (localCustomVideoFilter != null) {
            ((List)localObject3).add(localCustomVideoFilter);
          }
          ((List)localObject3).addAll(localArrayList);
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value)
        {
          if (localSnakeFaceFilter != null) {
            ((List)localObject3).add(localSnakeFaceFilter);
          }
          ((List)localObject3).addAll(localArrayList);
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
        {
          if (localCustomVertexFilter != null) {
            ((List)localObject3).add(localCustomVertexFilter);
          }
          ((List)localObject3).addAll(localArrayList);
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value)
        {
          if (localObject1 != null) {
            ((List)localObject3).addAll((Collection)localObject1);
          }
          ((List)localObject3).addAll(localArrayList);
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value)
        {
          if (paramQQVideoMaterial.getOrderMode() <= 1)
          {
            if (localList2 != null) {
              a(localList2, (List)localObject3);
            }
            ((List)localObject3).addAll(localArrayList);
          }
          else if (paramQQVideoMaterial.getOrderMode() == 2)
          {
            ((List)localObject3).addAll(localArrayList);
            if (localList2 != null) {
              a(localList2, (List)localObject3);
            }
          }
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value)
        {
          if (paramQQVideoMaterial.getOrderMode() <= 1)
          {
            if (localObject1 != null) {
              ((List)localObject3).addAll((Collection)localObject1);
            }
            if (localList2 != null) {
              a(localList2, (List)localObject3);
            }
            ((List)localObject3).addAll(localArrayList);
          }
          else if (paramQQVideoMaterial.getOrderMode() == 2)
          {
            ((List)localObject3).addAll(localArrayList);
            if (localObject1 != null) {
              ((List)localObject3).addAll((Collection)localObject1);
            }
            if (localList2 != null) {
              a(localList2, (List)localObject3);
            }
          }
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value)
        {
          ((List)localObject3).addAll(localList3);
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_COPY.value)
        {
          if (localVideoFilterBase2 != null) {
            ((List)localObject3).add(localVideoFilterBase2);
          }
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value)
        {
          if (localVideoFilterBase1 != null) {
            ((List)localObject3).add(localVideoFilterBase1);
          }
        }
        else if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value)
        {
          ((List)localObject3).addAll(localArrayList);
          localObject1 = a(paramQQVideoMaterial);
          if (localObject1 != null) {
            ((List)localObject3).add(localObject1);
          }
        }
        else if (paramQQVideoMaterial.getShaderType() == 2000)
        {
          ((List)localObject3).addAll(localArrayList);
          if (localNonFit2DFilter != null) {
            ((List)localObject3).add(localNonFit2DFilter);
          }
        }
        else if ((paramQQVideoMaterial.getShaderType() == 2001) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value))
        {
          if (localObject1 != null) {
            ((List)localObject3).addAll((Collection)localObject1);
          }
          if (localList2 != null) {
            ((List)localObject3).addAll(localList2);
          }
          if (localBuckleFaceFilter != null)
          {
            ((List)localObject3).add(localBuckleFaceFilter);
            localBuckleFaceFilter.a(localList4);
          }
          ((List)localObject3).addAll(localArrayList);
        }
      }
    }
  }
  
  private static VideoFilterBase b(QQVideoMaterial paramQQVideoMaterial)
  {
    FaceCopyFilter localFaceCopyFilter = null;
    if ((paramQQVideoMaterial.a()) || (VideoMaterialUtil.isFaceCopyMaterial(paramQQVideoMaterial))) {
      localFaceCopyFilter = new FaceCopyFilter();
    }
    return localFaceCopyFilter;
  }
  
  private static List b(QQVideoMaterial paramQQVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (((paramQQVideoMaterial.a()) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value)) && (paramQQVideoMaterial.getItemList() != null))
    {
      Iterator localIterator = paramQQVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new ThreeDimFilter((StickerItem)localIterator.next(), paramQQVideoMaterial.getDataPath()));
      }
    }
    return localArrayList;
  }
  
  public static boolean b(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && (((paramVideoFilterBase instanceof TransformFilter)) || ((paramVideoFilterBase instanceof CustomVideoFilter)));
  }
  
  private static VideoFilterList c(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial == null) {
      return null;
    }
    Object localObject1 = a(paramQQVideoMaterial);
    a(paramQQVideoMaterial);
    SnakeFaceFilter localSnakeFaceFilter = a(paramQQVideoMaterial);
    List localList1 = d(paramQQVideoMaterial);
    List localList2 = a(paramQQVideoMaterial);
    VideoFilterBase localVideoFilterBase1 = a(paramQQVideoMaterial);
    VideoFilterBase localVideoFilterBase2 = b(paramQQVideoMaterial);
    List localList3 = b(paramQQVideoMaterial);
    Object localObject2 = c(paramQQVideoMaterial);
    NonFit2DFilter localNonFit2DFilter = a(paramQQVideoMaterial);
    BuckleFaceFilter localBuckleFaceFilter = a(paramQQVideoMaterial);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = new ArrayList();
    a(paramQQVideoMaterial, localArrayList2, (List)localObject3);
    localArrayList1.addAll(localArrayList2);
    localArrayList1.addAll((Collection)localObject2);
    localArrayList1.addAll((Collection)localObject3);
    if (!paramQQVideoMaterial.jdField_a_of_type_Boolean) {
      localList1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((CustomVideoFilter)localObject1).setNormalFilters((List)localObject2);
      }
      localObject1 = new StringBuffer();
      localObject2 = new VideoFilterList();
      localArrayList2 = new ArrayList();
      localObject3 = paramQQVideoMaterial.a().iterator();
      if (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if ("FaceOff".equals(str)) {
          if (localList1 != null) {
            localArrayList2.addAll(localList1);
          }
        }
        for (;;)
        {
          ((StringBuffer)localObject1).append(str).append(" ");
          break;
          if ("MeshDistortion".equals(str))
          {
            if (paramQQVideoMaterial.getOrderMode() <= 1)
            {
              if (localList2 != null) {
                a(localList2, localArrayList2);
              }
            }
            else if ((paramQQVideoMaterial.getOrderMode() == 2) && (localList2 != null)) {
              a(localList2, localArrayList2);
            }
          }
          else if ("Sticker".equals(str)) {
            localArrayList2.addAll(localArrayList1);
          } else if (!"Graffiti".equals(str)) {
            if ("SnakeFace".equals(str))
            {
              if (localSnakeFaceFilter != null) {
                localArrayList2.add(localSnakeFaceFilter);
              }
            }
            else if ("ThreeDim".equals(str))
            {
              localArrayList2.addAll(localList3);
            }
            else if ("FaceCopy".equals(str))
            {
              if (localVideoFilterBase2 != null) {
                localArrayList2.add(localVideoFilterBase2);
              }
            }
            else if ("FaceSwitch".equals(str))
            {
              if (localVideoFilterBase1 != null) {
                localArrayList2.add(localVideoFilterBase1);
              }
            }
            else if ("ARParticle".equals(str))
            {
              ARParticleFilter localARParticleFilter = a(paramQQVideoMaterial);
              if (localARParticleFilter != null) {
                localArrayList2.add(localARParticleFilter);
              }
            }
            else if (!"3DAccessory".equals(str))
            {
              if ("Model2dAnimation".equals(str))
              {
                if (localNonFit2DFilter != null) {
                  localArrayList2.add(localNonFit2DFilter);
                }
              }
              else if (("BuckleFace".equals(str)) && (localBuckleFaceFilter != null)) {
                localArrayList2.add(localBuckleFaceFilter);
              }
            }
          }
        }
      }
      if (SLog.a()) {
        SLog.d(VideoFilterUtil.class.getName(), "createFiltersByFilterList= " + localObject1);
      }
      ((VideoFilterList)localObject2).a(localArrayList2);
      ((VideoFilterList)localObject2).a(paramQQVideoMaterial);
      return localObject2;
    }
  }
  
  private static List c(QQVideoMaterial paramQQVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramQQVideoMaterial.getItemList().iterator();
      label97:
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if (paramQQVideoMaterial.jdField_a_of_type_Boolean)
        {
          if (((StickerItem)localObject).type == 3) {}
          for (localObject = new StaticCountFilter((StickerItem)localObject, paramQQVideoMaterial.getDataPath());; localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramQQVideoMaterial.getDataPath()))
          {
            if (localObject == null) {
              break label97;
            }
            localArrayList.add(localObject);
            break;
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static List d(QQVideoMaterial paramQQVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str;
    if ((paramQQVideoMaterial.a()) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) || (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value))
    {
      localObject3 = paramQQVideoMaterial.getFaceOffItemList();
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        int i = 0;
        if (i < ((List)localObject3).size())
        {
          FaceItem localFaceItem = (FaceItem)((List)localObject3).get(i);
          if (paramQQVideoMaterial.getFaceoffType() == VideoMaterialUtil.FACE_OFF_TYPE.BY_IMAGE.value) {}
          for (localObject1 = new FaceOffByImageFilter(localFaceItem);; localObject1 = new FaceOffFilter((String)localObject1, (String)localObject2, localFaceItem, paramQQVideoMaterial.getDataPath()))
          {
            localArrayList.add(localObject1);
            i += 1;
            break;
            localObject2 = VideoMaterialUtil.loadVertexShader(paramQQVideoMaterial.getDataPath());
            str = VideoMaterialUtil.loadFragmentShader(paramQQVideoMaterial.getDataPath());
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = FaceOffFilter.VERTEX_SHADER;
            }
            localObject2 = str;
            if (TextUtils.isEmpty(str)) {
              localObject2 = FaceOffFilter.FRAGMENT_SHADER;
            }
          }
        }
      }
      else if (!TextUtils.isEmpty(paramQQVideoMaterial.getFaceExchangeImage()))
      {
        localObject3 = new FaceItem(paramQQVideoMaterial.getFaceExchangeImage(), (float)paramQQVideoMaterial.getBlendAlpha(), paramQQVideoMaterial.getGrayScale(), paramQQVideoMaterial.getFeatureType(), paramQQVideoMaterial.getFacePoints());
        ((FaceItem)localObject3).blendMode = paramQQVideoMaterial.getBlendMode();
        if (paramQQVideoMaterial.getFaceoffType() != VideoMaterialUtil.FACE_OFF_TYPE.BY_IMAGE.value) {
          break label302;
        }
      }
    }
    for (paramQQVideoMaterial = new FaceOffByImageFilter((FaceItem)localObject3);; paramQQVideoMaterial = new FaceOffFilter((String)localObject1, (String)localObject2, (FaceItem)localObject3, paramQQVideoMaterial.getDataPath()))
    {
      localArrayList.add(paramQQVideoMaterial);
      return localArrayList;
      label302:
      localObject2 = VideoMaterialUtil.loadVertexShader(paramQQVideoMaterial.getDataPath());
      str = VideoMaterialUtil.loadFragmentShader(paramQQVideoMaterial.getDataPath());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = FaceOffFilter.VERTEX_SHADER;
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = FaceOffFilter.FRAGMENT_SHADER;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil
 * JD-Core Version:    0.7.0.1
 */