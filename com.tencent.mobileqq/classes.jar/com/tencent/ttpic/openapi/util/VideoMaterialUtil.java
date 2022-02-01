package com.tencent.ttpic.openapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.constant.CategoryType;
import com.tencent.ttpic.filter.juyoujinggame.UKYOGameSetting;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.ImagesSetting;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.offlineset.beans.StyleFilterSettingJsonBean;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.MediaConfig.ENCODE_SIZE;
import com.tencent.ttpic.openapi.facedetect.FaceDetector.DetectType;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.model.AnimationItem;
import com.tencent.ttpic.openapi.model.AnimojiExpressionJava;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem.StyleChangeType;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.Point3D;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.TriggerActionItem;
import com.tencent.ttpic.openapi.model.TriggerExpression;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterialMetaData;
import com.tencent.ttpic.openapi.model.WMElementConfig;
import com.tencent.ttpic.openapi.model.WMGroupConfig;
import com.tencent.ttpic.util.PointWithIndex;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.VideoLocalDataInitializer;
import com.tencent.ttpic.video.R.string;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VideoMaterialUtil
{
  public static final String CRAZYFACE_ANTI_WRINKLE = "antiWrinkle";
  public static final String CRAZYFACE_BLEND_ALPHA = "blendAlpha";
  public static final String CRAZYFACE_CANVAS = "canvas";
  public static final String CRAZYFACE_DISTORTION_ALPHA = "distortionAlpha";
  public static final String CRAZYFACE_DISTORTION_LIST = "distortionList";
  public static final String CRAZYFACE_FACE_COLOR = "imageFaceColor";
  public static final String CRAZYFACE_FACE_COLOR2 = "imageFaceColor2";
  public static final String CRAZYFACE_FACE_COLOR_RANGE = "faceColorRange";
  public static final String CRAZYFACE_FACE_LAYER = "faceImageLayer";
  public static final String CRAZYFACE_FACE_MASK = "faceMaskImage";
  public static final String CRAZYFACE_FACE_MASK_POINTS = "faceMaskFacePoint";
  public static final String CRAZYFACE_FACE_POINTS = "imageFacePoint";
  public static final String CRAZYFACE_FACE_RIANGLE = "faceTriangle";
  public static final String CRAZYFACE_FACE_TRIANGLE_ID = "faceTriangleID";
  public static final String CRAZYFACE_HEIGHT = "height";
  public static final String CRAZYFACE_IMAGE_LAYER = "imageLayer";
  public static final String CRAZYFACE_IMAGE_PATH = "image";
  public static final String CRAZYFACE_LAYER_TYPE = "type";
  public static final String CRAZYFACE_STK_TYPE = "stkType";
  public static final String CRAZYFACE_WIDTH = "width";
  public static final String CRAZYFACE_X = "x";
  public static final String CRAZYFACE_Y = "y";
  public static final String[] DEVICE_NEED_COPY_TRANSFORM = { "A1001", "SM-N9006", "vivo_X5Max_L", "vivo_X5Max_L", "vivo_X5V", "vivo_Y23L" };
  public static final String[] DEVICE_NEED_SMALL_SIZE;
  public static final List<Integer> EMPTY_ANGLES_LIST;
  public static final List<PointF> EMPTY_POINTS_LIST;
  public static boolean ENABLE_FAST_RENDER = false;
  public static final String FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_ANDROID = "filterFragment_android.glsl";
  public static final String FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_COMMON = "filterFragment.glsl";
  public static final String FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_ANDROID = "filterVertex_android.glsl";
  public static final String FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_COMMON = "filterVertex.glsl";
  public static final String FILE_NAME_FACE_OFF_FRAGMENT_SHADER_COMMON = "faceoff_fragment.glsl";
  public static final String FILE_NAME_FACE_OFF_VERTEX_SHADER_COMMON = "faceoff_vertex.glsl";
  public static final String FILE_NAME_FRAGMENT_SHADER_ANDROID = "fragment_android.glsl";
  public static final String FILE_NAME_FRAGMENT_SHADER_COMMON = "fragment.glsl";
  public static final String FILE_NAME_VERTEX_SHADER_ANDROID = "vertex_android.glsl";
  public static final String FILE_NAME_VERTEX_SHADER_COMMON = "vertex.glsl";
  public static final String FRAMES_ID_SEPARATOR_3D = ":";
  public static final int INVALID_INT_FIELD_VALUE = -999999;
  public static final int INVALID_ONLY_ONE_GESTURE = -1;
  public static final String ITEM_ID_CUSTOM = "nothing";
  public static final String MATERIAL_PREFIX = "video_";
  public static final String MP4_SUFFIX = ".mp4";
  public static final String PARAMS_FILE_NAME = "params";
  public static final String PNG_SUFFIX = ".png";
  public static final double RATIO_CANVAS = 0.75D;
  public static final double SCALE_DIFF = 100.0D;
  public static final double SCALE_Y = 0.25D;
  public static final int SIZE_FACE_ANGLE = 3;
  public static final int SIZE_FACE_POINT = 90;
  private static final String TAG = VideoMaterialUtil.class.getSimpleName();
  public static final Map<Integer, String> blendshapeIndex2Name;
  public static FilenameFilter mMp4Filter;
  public static FilenameFilter mPngFilter;
  
  static
  {
    ENABLE_FAST_RENDER = true;
    EMPTY_POINTS_LIST = new ArrayList();
    EMPTY_ANGLES_LIST = new ArrayList();
    mPngFilter = new VideoMaterialUtil.2();
    mMp4Filter = new VideoMaterialUtil.3();
    blendshapeIndex2Name = new VideoMaterialUtil.4();
    DEVICE_NEED_SMALL_SIZE = new String[] { "A1001" };
  }
  
  public static float angleToRadian(float paramFloat)
  {
    return (float)(paramFloat * 3.141592653589793D / 180.0D);
  }
  
  public static List<Point3D> arrayTo3DPointList(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length / 3)
    {
      localArrayList.add(new Point3D(paramArrayOfFloat[(i * 3)], paramArrayOfFloat[(i * 3 + 1)], paramArrayOfFloat[(i * 3 + 2)]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<Float> arrayToList(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat == null) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
        i += 1;
      }
    }
  }
  
  public static List<PointF> arrayToPointList(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length / 2)
    {
      localArrayList.add(new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<PointF> arrayToPointList(int[][] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      localArrayList.add(new PointF(paramArrayOfInt[i][0], paramArrayOfInt[i][1]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static int calSampleSize(long paramLong1, long paramLong2)
  {
    int j;
    if (paramLong1 <= 0L)
    {
      j = 128;
      return j;
    }
    int i = 1;
    for (;;)
    {
      j = i;
      if (paramLong2 <= paramLong1) {
        break;
      }
      i <<= 1;
      paramLong2 >>= 2;
    }
  }
  
  public static boolean canMaterialUseFastRender(VideoMaterial paramVideoMaterial)
  {
    boolean bool = false;
    paramVideoMaterial = paramVideoMaterial.getItemList().iterator();
    int i = 0;
    if (paramVideoMaterial.hasNext())
    {
      if (!canStickerItemUseFastRender((StickerItem)paramVideoMaterial.next())) {
        break label55;
      }
      i += 1;
    }
    label55:
    for (;;)
    {
      break;
      if (i <= 7) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static boolean canStickerItemUseFastBodyRender(StickerItem paramStickerItem)
  {
    return (canStickerItemUseFastRender(paramStickerItem)) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type) && (!isBody4AnchorItem(paramStickerItem));
  }
  
  public static boolean canStickerItemUseFastFaceRender(StickerItem paramStickerItem)
  {
    return (canStickerItemUseFastRender(paramStickerItem)) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type);
  }
  
  public static boolean canStickerItemUseFastRender(StickerItem paramStickerItem)
  {
    return (ENABLE_FAST_RENDER) && (paramStickerItem != null) && (paramStickerItem.markMode == 0) && (paramStickerItem.personID < 0) && (paramStickerItem.genderType == 0) && (paramStickerItem.stickerType == 0) && ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type)) && ((paramStickerItem.blendMode < 2) || (paramStickerItem.blendMode > 12)) && (paramStickerItem.zIndex == 0) && (paramStickerItem.charmRange == null) && (paramStickerItem.ageRange == null) && (paramStickerItem.popularRange == null) && (paramStickerItem.genderRange == null) && (paramStickerItem.cpRange == null) && (paramStickerItem.randomGroupNum == 0) && (paramStickerItem.audioTriggerType == 0) && (paramStickerItem.particleConfig == null) && (paramStickerItem.gpuParticleConfig == null) && (!paramStickerItem.isDisplacementMaterial());
  }
  
  public static boolean canUseLongLeg(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial == null) || ((!paramVideoMaterial.isSegmentRequired()) && (!isParticleMaterial(paramVideoMaterial)));
  }
  
  private static boolean checkTNNElement(VideoMaterial paramVideoMaterial, FaceStyleItem.StyleChangeType paramStyleChangeType)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getFaceStyleItemList();
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext())
      {
        FaceStyleItem localFaceStyleItem = (FaceStyleItem)paramVideoMaterial.next();
        if ((!TextUtils.isEmpty(localFaceStyleItem.modelName)) && (localFaceStyleItem.styleChangeType == paramStyleChangeType.value)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void copyArrayToArray(PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2)
  {
    if ((paramArrayOfPointF1 == null) || (paramArrayOfPointF2 == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < Math.min(paramArrayOfPointF1.length, paramArrayOfPointF2.length))
      {
        paramArrayOfPointF2[i].x = paramArrayOfPointF1[i].x;
        paramArrayOfPointF2[i].y = paramArrayOfPointF1[i].y;
        i += 1;
      }
    }
  }
  
  public static int copyList(List<PointF> paramList1, List<PointF> paramList2)
  {
    int k = 0;
    if ((paramList2 == null) || (paramList1 == null))
    {
      i = -1;
      return i;
    }
    int m = paramList2.size();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= paramList1.size()) {
        break;
      }
      ((PointF)paramList1.get(i)).x = ((PointF)paramList2.get(i)).x;
      ((PointF)paramList1.get(i)).y = ((PointF)paramList2.get(i)).y;
      i += 1;
    }
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      paramList1.add(new PointF(((PointF)paramList2.get(j)).x, ((PointF)paramList2.get(j)).y));
      j += 1;
    }
  }
  
  public static List<PointF> copyList(List<PointF> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localArrayList.add(new PointF(localPointF.x, localPointF.y));
    }
    return localArrayList;
  }
  
  public static void copyListToArray(List<PointF> paramList, PointF[] paramArrayOfPointF)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfPointF == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < Math.min(paramList.size(), paramArrayOfPointF.length))
      {
        paramArrayOfPointF[i].x = ((PointF)paramList.get(i)).x;
        paramArrayOfPointF[i].y = ((PointF)paramList.get(i)).y;
        i += 1;
      }
    }
  }
  
  public static void flipYPoints(List<PointF> paramList, int paramInt) {}
  
  public static float[] flipYPoints(float[] paramArrayOfFloat, int paramInt)
  {
    return paramArrayOfFloat;
  }
  
  public static int genFullScreenVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = 1;
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return -1;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    paramArrayOfFloat[0] = getCoordinate(paramFloat1, paramFloat2, 0);
    paramArrayOfFloat[1] = getCoordinate(paramFloat3, paramFloat4, 0);
    int j = 0;
    if (j < paramInt1)
    {
      int k;
      if (j % 2 == 0)
      {
        int m = 0;
        k = i;
        i = m;
        while (i < paramInt2)
        {
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i);
          k += 1;
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i + 1);
          k += 1;
          i += 1;
        }
        paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
        paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, paramInt2);
      }
      for (i = k + 1;; i = k + 1)
      {
        j += 1;
        break;
        k = i;
        i = paramInt2;
        while (i > 0)
        {
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i);
          k += 1;
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i - 1);
          k += 1;
          i -= 1;
        }
        paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
        paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, 0);
      }
    }
    return 0;
  }
  
  public static List<PointF> genFullScreenVertices(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return localArrayList;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, 0), getCoordinate(paramFloat3, paramFloat4, 0)));
    int i = 0;
    label69:
    int j;
    if (i < paramInt1)
    {
      if (i % 2 != 0) {
        break label207;
      }
      j = 0;
      while (j < paramInt2)
      {
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, j)));
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i), getCoordinate(paramFloat3, paramFloat4, j + 1)));
        j += 1;
      }
      localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, paramInt2)));
    }
    for (;;)
    {
      i += 1;
      break label69;
      break;
      label207:
      j = paramInt2;
      while (j > 0)
      {
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, j)));
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i), getCoordinate(paramFloat3, paramFloat4, j - 1)));
        j -= 1;
      }
      localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, 0)));
    }
  }
  
  public static String getActionTipString(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return AEModule.getContext().getString(R.string.action_open_mouth);
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return AEModule.getContext().getString(R.string.action_raise_eyebrows);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return AEModule.getContext().getString(R.string.action_blink);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return AEModule.getContext().getString(R.string.action_shake_head);
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return AEModule.getContext().getString(R.string.action_kiss);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value) {
      return AEModule.getContext().getString(R.string.action_blink_left_eye);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value) {
      return AEModule.getContext().getString(R.string.action_blink_right_eye);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return AEModule.getContext().getString(R.string.action_nod_head);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value) {
      return AEModule.getContext().getString(R.string.action_shake_head);
    }
    if (paramInt == PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value) {
      return AEModule.getContext().getString(R.string.ar_try_click);
    }
    return "";
  }
  
  public static int getAllImageSize(VideoMaterial paramVideoMaterial)
  {
    int j;
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getDataPath() == null))
    {
      j = 0;
      return j;
    }
    Object localObject = new ArrayList();
    if (paramVideoMaterial.getItemList() != null) {
      ((List)localObject).addAll(paramVideoMaterial.getItemList());
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      ((List)localObject).addAll(paramVideoMaterial.getHeadCropItemList());
    }
    localObject = ((List)localObject).iterator();
    StickerItem localStickerItem;
    for (int i = 0;; i = getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + localStickerItem.subFolder) + i)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localStickerItem = (StickerItem)((Iterator)localObject).next();
    }
  }
  
  public static int getAllImageSize(String paramString)
  {
    int j = 0;
    String[] arrayOfString;
    int i;
    if (paramString.startsWith("assets://"))
    {
      try
      {
        arrayOfString = AEModule.getContext().getAssets().list(FileUtils.getRealPath(paramString));
        i = j;
        if (arrayOfString == null) {
          return i;
        }
        if (arrayOfString.length == 0) {
          return 0;
        }
        paramString = BitmapUtils.getBitmapSize(AEModule.getContext(), paramString + File.separator + arrayOfString[0]);
        i = j;
        if (paramString == null) {
          return i;
        }
        i = paramString.x;
        j = paramString.y;
        int k = arrayOfString.length;
        return 0 + k * (j * i * 4);
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return 0;
      }
    }
    else
    {
      arrayOfString = new File(paramString).list(mPngFilter);
      i = j;
      if (arrayOfString != null)
      {
        i = j;
        if (arrayOfString.length != 0)
        {
          paramString = BitmapUtils.getBitmapSize(AEModule.getContext(), paramString + File.separator + arrayOfString[0]);
          i = j;
          if (paramString != null)
          {
            i = paramString.x;
            j = paramString.y;
            i = 0 + arrayOfString.length * (j * i * 4);
          }
        }
      }
    }
    return i;
  }
  
  public static List<Integer> getAllIndex(PointWithIndex[][] paramArrayOfPointWithIndex, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      localObject = null;
    }
    ArrayList localArrayList;
    int i;
    do
    {
      return localObject;
      localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[0][0].index));
      i = 0;
      localObject = localArrayList;
    } while (i >= paramInt1);
    int j;
    if (i % 2 == 0)
    {
      j = 0;
      while (j < paramInt2)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[j][(i + 1)].index));
        localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[(j + 1)][i].index));
        j += 1;
      }
      localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[paramInt2][(i + 1)].index));
    }
    for (;;)
    {
      i += 1;
      break;
      j = paramInt2;
      while (j > 0)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[j][(i + 1)].index));
        localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[(j - 1)][i].index));
        j -= 1;
      }
      localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[0][(i + 1)].index));
    }
  }
  
  public static PointWithIndex[][] getAllPoints(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject;
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localObject = (PointWithIndex[][])null;
      return localObject;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    PointWithIndex[][] arrayOfPointWithIndex = (PointWithIndex[][])Array.newInstance(PointWithIndex.class, new int[] { paramInt2 + 1, paramInt1 + 1 });
    int j = 0;
    int i = 0;
    for (;;)
    {
      localObject = arrayOfPointWithIndex;
      if (i > paramInt2) {
        break;
      }
      int k = 0;
      while (k <= paramInt1)
      {
        arrayOfPointWithIndex[i][k] = new PointWithIndex(getCoordinate(paramFloat1, paramFloat2, k), getCoordinate(paramFloat3, paramFloat4, i), j);
        k += 1;
        j += 1;
      }
      i += 1;
    }
  }
  
  private static float getCoordinate(float paramFloat1, float paramFloat2, int paramInt)
  {
    return paramInt * paramFloat2 + paramFloat1;
  }
  
  public static int getDepthMaskType(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (paramVideoMaterial.needDepthMask()) {
        return paramVideoMaterial.getDepthMaskType();
      }
      paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
      if (paramVideoMaterial == null) {
        return -1;
      }
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext())
      {
        MultiViewerItem localMultiViewerItem = (MultiViewerItem)paramVideoMaterial.next();
        if ((localMultiViewerItem != null) && (localMultiViewerItem.videoMaterial != null) && (localMultiViewerItem.videoMaterial.needDepthMask())) {
          return localMultiViewerItem.videoMaterial.getDepthMaskType();
        }
      }
    }
    return -1;
  }
  
  public static VideoMaterialUtil.ITEM_SOURCE_TYPE getItemSourceType(int paramInt)
  {
    if (paramInt == 1) {
      return VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
    }
    if (paramInt == 2) {
      return VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;
    }
    return VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_NORMAL;
  }
  
  public static String getMaterialId(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      paramString = paramString.split(File.separator);
      int i = paramString.length - 1;
      while (i >= 0)
      {
        if (!TextUtils.isEmpty(paramString[i])) {
          return paramString[i];
        }
        i -= 1;
      }
    }
  }
  
  public static String getMusicMaterialM4aPath(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString + File.separator + getMaterialId(paramString) + ".m4a";
  }
  
  public static int getNormalEncodeWidth()
  {
    if (needSmallSize()) {
      return MediaConfig.ENCODE_SIZE.MEDIUM.width;
    }
    return VideoPrefsUtil.getNormalEncodeWidth();
  }
  
  public static int getOnlyOneGestureDetectMaterial(VideoMaterial paramVideoMaterial)
  {
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    if (paramVideoMaterial != null)
    {
      localObject2 = paramVideoMaterial.getItemList();
      localObject1 = paramVideoMaterial.getItemList3D();
      Object localObject3 = paramVideoMaterial.getHeadCropItemList();
      paramVideoMaterial = paramVideoMaterial.getFaceOffItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject2 != null) {
        localArrayList.addAll((Collection)localObject2);
      }
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      localObject2 = localArrayList.iterator();
      j = 0;
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject2).next();
        if (((StickerItem)localObject3).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) {
          j = 1;
        }
        if (!isGestureTriggerType(((StickerItem)localObject3).getTriggerTypeInt())) {
          break label362;
        }
        if ((((StickerItem)localObject3).getTriggerTypeInt() != i) && (i != 0))
        {
          i = -1;
          label143:
          return i;
        }
        j = ((StickerItem)localObject3).getTriggerTypeInt();
        i = 1;
      }
    }
    for (;;)
    {
      int k = j;
      j = i;
      i = k;
      break;
      k = j;
      int m = i;
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        for (;;)
        {
          k = j;
          m = i;
          if (!paramVideoMaterial.hasNext()) {
            break;
          }
          localObject2 = (FaceItem)paramVideoMaterial.next();
          if (isGestureTriggerType(((FaceItem)localObject2).getTriggerTypeInt()))
          {
            if ((((FaceItem)localObject2).getTriggerTypeInt() != i) && (i != 0)) {
              return -1;
            }
            i = ((FaceItem)localObject2).getTriggerTypeInt();
            j = 1;
          }
        }
      }
      if (localObject1 != null)
      {
        paramVideoMaterial = ((List)localObject1).iterator();
        i = m;
        j = k;
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (StickerItem3D)paramVideoMaterial.next();
          if (((StickerItem3D)localObject1).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) {
            j = 1;
          }
          if (!isGestureTriggerType(((StickerItem3D)localObject1).getTriggerTypeInt())) {
            break label345;
          }
          if ((((StickerItem3D)localObject1).getTriggerTypeInt() != i) && (i != 0)) {
            return -1;
          }
          j = ((StickerItem3D)localObject1).getTriggerTypeInt();
          i = 1;
          k = j;
          j = i;
          i = k;
        }
      }
      for (;;)
      {
        if (j != 0) {
          break label360;
        }
        return -1;
        return -1;
        label345:
        k = i;
        i = j;
        j = k;
        break;
        i = m;
        j = k;
      }
      label360:
      break label143;
      label362:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public static PTFaceAttr.PTExpression getOppositeTriggerType(int paramInt)
  {
    return getTriggerType(paramInt).opposite;
  }
  
  public static PTFaceAttr.PTExpression getTriggerType(int paramInt)
  {
    PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.values();
    int j = arrayOfPTExpression.length;
    int i = 0;
    while (i < j)
    {
      PTFaceAttr.PTExpression localPTExpression = arrayOfPTExpression[i];
      if (localPTExpression.value == paramInt) {
        return localPTExpression;
      }
      i += 1;
    }
    return PTFaceAttr.PTExpression.UNKNOW;
  }
  
  /* Error */
  public static int[] getVideoIndexMap(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: newarray int
    //   5: astore 7
    //   7: new 710	java/io/RandomAccessFile
    //   10: dup
    //   11: aload_0
    //   12: ldc_w 712
    //   15: invokespecial 715	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: astore 9
    //   20: aload 9
    //   22: astore_0
    //   23: aload 7
    //   25: astore 8
    //   27: aload 9
    //   29: invokevirtual 719	java/io/RandomAccessFile:length	()J
    //   32: lstore_3
    //   33: aload 9
    //   35: astore_0
    //   36: aload 7
    //   38: astore 8
    //   40: aload 9
    //   42: lload_3
    //   43: ldc2_w 720
    //   46: lsub
    //   47: invokevirtual 725	java/io/RandomAccessFile:seek	(J)V
    //   50: aload 9
    //   52: astore_0
    //   53: aload 7
    //   55: astore 8
    //   57: iconst_4
    //   58: newarray byte
    //   60: astore 10
    //   62: aload 9
    //   64: astore_0
    //   65: aload 7
    //   67: astore 8
    //   69: aload 9
    //   71: aload 10
    //   73: invokevirtual 729	java/io/RandomAccessFile:read	([B)I
    //   76: pop
    //   77: aload 9
    //   79: astore_0
    //   80: aload 7
    //   82: astore 8
    //   84: aload 10
    //   86: invokestatic 734	com/tencent/ttpic/util/ByteUtil:readInt	([B)I
    //   89: istore_2
    //   90: iload_2
    //   91: bipush 12
    //   93: if_icmple +10 -> 103
    //   96: iload_2
    //   97: sipush 400
    //   100: if_icmplt +41 -> 141
    //   103: aload 9
    //   105: astore_0
    //   106: aload 7
    //   108: astore 8
    //   110: aload 9
    //   112: invokevirtual 737	java/io/RandomAccessFile:close	()V
    //   115: aload 7
    //   117: astore_0
    //   118: aload 9
    //   120: ifnull +11 -> 131
    //   123: aload 9
    //   125: invokevirtual 737	java/io/RandomAccessFile:close	()V
    //   128: aload 7
    //   130: astore_0
    //   131: aload_0
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 579	java/io/IOException:printStackTrace	()V
    //   138: aload 7
    //   140: areturn
    //   141: iload_2
    //   142: i2l
    //   143: lstore 5
    //   145: aload 9
    //   147: astore_0
    //   148: aload 7
    //   150: astore 8
    //   152: aload 9
    //   154: lload_3
    //   155: lload 5
    //   157: lsub
    //   158: ldc2_w 738
    //   161: ladd
    //   162: invokevirtual 725	java/io/RandomAccessFile:seek	(J)V
    //   165: aload 9
    //   167: astore_0
    //   168: aload 7
    //   170: astore 8
    //   172: iload_2
    //   173: bipush 12
    //   175: isub
    //   176: iconst_4
    //   177: idiv
    //   178: newarray int
    //   180: astore 7
    //   182: aload 9
    //   184: astore_0
    //   185: aload 7
    //   187: astore 8
    //   189: iload_1
    //   190: aload 7
    //   192: arraylength
    //   193: if_icmpge +41 -> 234
    //   196: aload 9
    //   198: astore_0
    //   199: aload 7
    //   201: astore 8
    //   203: aload 9
    //   205: aload 10
    //   207: invokevirtual 729	java/io/RandomAccessFile:read	([B)I
    //   210: pop
    //   211: aload 9
    //   213: astore_0
    //   214: aload 7
    //   216: astore 8
    //   218: aload 7
    //   220: iload_1
    //   221: aload 10
    //   223: invokestatic 734	com/tencent/ttpic/util/ByteUtil:readInt	([B)I
    //   226: iastore
    //   227: iload_1
    //   228: iconst_1
    //   229: iadd
    //   230: istore_1
    //   231: goto -49 -> 182
    //   234: aload 7
    //   236: astore_0
    //   237: aload 9
    //   239: ifnull -108 -> 131
    //   242: aload 9
    //   244: invokevirtual 737	java/io/RandomAccessFile:close	()V
    //   247: aload 7
    //   249: areturn
    //   250: astore_0
    //   251: aload_0
    //   252: invokevirtual 579	java/io/IOException:printStackTrace	()V
    //   255: aload 7
    //   257: areturn
    //   258: astore 10
    //   260: aconst_null
    //   261: astore 8
    //   263: aload 8
    //   265: astore_0
    //   266: aload 10
    //   268: invokevirtual 740	java/lang/Exception:printStackTrace	()V
    //   271: aload 7
    //   273: astore_0
    //   274: aload 8
    //   276: ifnull -145 -> 131
    //   279: aload 8
    //   281: invokevirtual 737	java/io/RandomAccessFile:close	()V
    //   284: aload 7
    //   286: areturn
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual 579	java/io/IOException:printStackTrace	()V
    //   292: aload 7
    //   294: areturn
    //   295: astore 7
    //   297: aconst_null
    //   298: astore_0
    //   299: aload_0
    //   300: ifnull +7 -> 307
    //   303: aload_0
    //   304: invokevirtual 737	java/io/RandomAccessFile:close	()V
    //   307: aload 7
    //   309: athrow
    //   310: astore_0
    //   311: aload_0
    //   312: invokevirtual 579	java/io/IOException:printStackTrace	()V
    //   315: goto -8 -> 307
    //   318: astore 7
    //   320: goto -21 -> 299
    //   323: astore 10
    //   325: aload 8
    //   327: astore 7
    //   329: aload 9
    //   331: astore 8
    //   333: goto -70 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramString	String
    //   1	230	1	i	int
    //   89	87	2	j	int
    //   32	123	3	l1	long
    //   143	13	5	l2	long
    //   5	288	7	arrayOfInt	int[]
    //   295	13	7	localObject1	Object
    //   318	1	7	localObject2	Object
    //   327	1	7	localObject3	Object
    //   25	307	8	localObject4	Object
    //   18	312	9	localRandomAccessFile	java.io.RandomAccessFile
    //   60	162	10	arrayOfByte	byte[]
    //   258	9	10	localException1	java.lang.Exception
    //   323	1	10	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   123	128	133	java/io/IOException
    //   242	247	250	java/io/IOException
    //   7	20	258	java/lang/Exception
    //   279	284	287	java/io/IOException
    //   7	20	295	finally
    //   303	307	310	java/io/IOException
    //   27	33	318	finally
    //   40	50	318	finally
    //   57	62	318	finally
    //   69	77	318	finally
    //   84	90	318	finally
    //   110	115	318	finally
    //   152	165	318	finally
    //   172	182	318	finally
    //   189	196	318	finally
    //   203	211	318	finally
    //   218	227	318	finally
    //   266	271	318	finally
    //   27	33	323	java/lang/Exception
    //   40	50	323	java/lang/Exception
    //   57	62	323	java/lang/Exception
    //   69	77	323	java/lang/Exception
    //   84	90	323	java/lang/Exception
    //   110	115	323	java/lang/Exception
    //   152	165	323	java/lang/Exception
    //   172	182	323	java/lang/Exception
    //   189	196	323	java/lang/Exception
    //   203	211	323	java/lang/Exception
    //   218	227	323	java/lang/Exception
  }
  
  public static boolean hasGlbList(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getGlbList() == null)) {
      return false;
    }
    if (paramVideoMaterial.getGlbList() != null)
    {
      paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
      while (paramVideoMaterial.hasNext()) {
        if (!TextUtils.isEmpty(((GLBItemJava)paramVideoMaterial.next()).path)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean hasValidFaceOffItem(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getFaceOffItemList() != null))
    {
      paramVideoMaterial = paramVideoMaterial.getFaceOffItemList().iterator();
      while (paramVideoMaterial.hasNext()) {
        if (!isEmptyItem((FaceItem)paramVideoMaterial.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean is3DCosMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    if ((paramVideoMaterial.getFaceOffItemList() == null) || (paramVideoMaterial.getFaceOffItemList().isEmpty())) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getFaceOffItemList().iterator();
    while (paramVideoMaterial.hasNext()) {
      if (((FaceItem)paramVideoMaterial.next()).is3DCos > 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean is3DMaterial(VideoMaterial paramVideoMaterial)
  {
    return (isGameplayMaterial(paramVideoMaterial)) || (isFilamentMaterial(paramVideoMaterial));
  }
  
  public static boolean isAR3DMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getIsAR3DMaterial());
  }
  
  public static boolean isARMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getArParticleList() != null) && (!paramVideoMaterial.getArParticleList().isEmpty());
  }
  
  public static boolean isActionTriggerType(int paramInt)
  {
    boolean bool2 = false;
    PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.ACTION_TRIGGER_TYPE;
    int j = arrayOfPTExpression.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfPTExpression[i].value) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isAllFreezeFrameTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value;
  }
  
  public static boolean isAnimojiMaterial(VideoMaterial paramVideoMaterial)
  {
    return (isOldAnimojiMaterial(paramVideoMaterial)) || (isFilamentAnimojiMaterial(paramVideoMaterial));
  }
  
  public static boolean isAnimojiTongueMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getGlbList() == null)) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
    label23:
    if (paramVideoMaterial.hasNext())
    {
      Iterator localIterator2;
      label77:
      do
      {
        Iterator localIterator1 = ((GLBItemJava)paramVideoMaterial.next()).nodeList.iterator();
        break label77;
        if (!localIterator1.hasNext()) {
          break label23;
        }
        localIterator2 = ((NodeItemJava)localIterator1.next()).expressionConfigList.iterator();
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!((AnimojiExpressionJava)localIterator2.next()).shapeName.contains("tongue"));
      return true;
    }
    return false;
  }
  
  public static boolean isAudio2textMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getAudio2Text() != null) && (paramVideoMaterial.getAudio2Text().sentenceCount > 0);
  }
  
  public static boolean isAudioTextTriggerType(int paramInt)
  {
    return (300 <= paramInt) && (paramInt <= 311);
  }
  
  public static boolean isBody2AnchorItem(StickerItem paramStickerItem)
  {
    return (isBodyDetectItem(paramStickerItem)) && (paramStickerItem.anchorPoint != null) && (paramStickerItem.anchorPoint.length >= 4) && (paramStickerItem.alignFacePoints != null) && (paramStickerItem.alignFacePoints.length >= 2);
  }
  
  public static boolean isBody4AnchorItem(StickerItem paramStickerItem)
  {
    return (isBodyDetectItem(paramStickerItem)) && (paramStickerItem.anchorPoint != null) && (paramStickerItem.anchorPoint.length >= 8) && (paramStickerItem.alignFacePoints != null) && (paramStickerItem.alignFacePoints.length >= 4);
  }
  
  public static boolean isBodyDetectItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type);
  }
  
  public static boolean isBodyDetectMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject4 = paramVideoMaterial.getItemList();
      Object localObject2 = paramVideoMaterial.getItemList3D();
      Object localObject5 = paramVideoMaterial.getHeadCropItemList();
      Object localObject1 = paramVideoMaterial.getFaceFeatureItemList();
      Object localObject3 = paramVideoMaterial.getFaceOffItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject4 != null) {
        localArrayList.addAll((Collection)localObject4);
      }
      if (localObject5 != null) {
        localArrayList.addAll((Collection)localObject5);
      }
      localObject4 = localArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (StickerItem)((Iterator)localObject4).next();
        if (((StickerItem)localObject5).type == VideoFilterFactory.POSITION_TYPE.BODY.type) {
          return true;
        }
        if (isBodyTriggerType(((StickerItem)localObject5).getTriggerTypeInt())) {
          return true;
        }
      }
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          if (isBodyTriggerType(((FaceItem)((Iterator)localObject3).next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (StickerItem3D)((Iterator)localObject2).next();
          if (((StickerItem3D)localObject3).type == VideoFilterFactory.POSITION_TYPE.BODY.type) {
            return true;
          }
          if (isBodyTriggerType(((StickerItem3D)localObject3).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (paramVideoMaterial.getGlbList() != null)
      {
        do
        {
          paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!paramVideoMaterial.hasNext()) {
                break;
              }
              localObject2 = (GLBItemJava)paramVideoMaterial.next();
            } while (((GLBItemJava)localObject2).animationList == null);
            localObject2 = ((GLBItemJava)localObject2).animationList.iterator();
          }
          localObject3 = (AnimationItem)((Iterator)localObject2).next();
          if (((AnimationItem)localObject3).type == VideoFilterFactory.POSITION_TYPE.BODY.type) {
            return true;
          }
        } while (!isBodyTriggerType(((AnimationItem)localObject3).getTriggerTypeInt()));
        return true;
      }
      if (localObject1 != null)
      {
        do
        {
          paramVideoMaterial = ((List)localObject1).iterator();
          while (!((Iterator)localObject1).hasNext())
          {
            if (!paramVideoMaterial.hasNext()) {
              break;
            }
            localObject1 = ((FaceFeatureItem)paramVideoMaterial.next()).getStickerItems().iterator();
          }
        } while (((StickerItem)((Iterator)localObject1).next()).type != VideoFilterFactory.POSITION_TYPE.BODY.type);
        return true;
      }
    }
    return false;
  }
  
  public static boolean isBodyDetectType(int paramInt)
  {
    return paramInt == 400;
  }
  
  public static boolean isBodyTriggerType(int paramInt)
  {
    return paramInt == 401;
  }
  
  public static boolean isCartoonFrozenMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    do
    {
      return false;
      paramVideoMaterial = paramVideoMaterial.getFaceStyleItemList();
    } while ((paramVideoMaterial == null) || (paramVideoMaterial.size() <= 0));
    if (((FaceStyleItem)paramVideoMaterial.get(0)).styleChangeType == FaceStyleItem.StyleChangeType.CARTOON_STYLE.value) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isCatItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.CAT.type);
  }
  
  public static boolean isCatMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject2 = paramVideoMaterial.getItemList();
      Object localObject1 = paramVideoMaterial.getItemList3D();
      Object localObject3 = paramVideoMaterial.getHeadCropItemList();
      paramVideoMaterial = paramVideoMaterial.getFaceOffItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject2 != null) {
        localArrayList.addAll((Collection)localObject2);
      }
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject2).next();
        if (((StickerItem)localObject3).type == VideoFilterFactory.POSITION_TYPE.CAT.type) {
          return true;
        }
        if (isBodyTriggerType(((StickerItem)localObject3).getTriggerTypeInt())) {
          return true;
        }
      }
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext()) {
          if (isBodyTriggerType(((FaceItem)paramVideoMaterial.next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject1 != null)
      {
        paramVideoMaterial = ((List)localObject1).iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (StickerItem3D)paramVideoMaterial.next();
          if (((StickerItem3D)localObject1).type == VideoFilterFactory.POSITION_TYPE.CAT.type) {
            return true;
          }
          if (isBodyTriggerType(((StickerItem3D)localObject1).getTriggerTypeInt())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isCatTriggerType(int paramInt)
  {
    return paramInt == 700;
  }
  
  public static boolean isChangeFaceMaterial(VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoMaterial != null)
    {
      bool1 = bool2;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value)
      {
        bool1 = bool2;
        if (paramVideoMaterial.getFaceoffType() == VideoMaterialUtil.FACE_OFF_TYPE.BY_IMAGE.value) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean isContainHandBonePoint(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i] > 8) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isCosFunMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getCosFun() != null);
  }
  
  public static boolean isCosMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && ((paramVideoMaterial.getDetectorFlag() == 1) || (paramVideoMaterial.getDetectorFlag() == 2) || (!TextUtils.isEmpty(paramVideoMaterial.getLipsLutPath())));
  }
  
  public static boolean isCpValueMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.getItemList();
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext())
        {
          StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
          if ((localStickerItem.markMode == FaceDetector.DetectType.DETECT_TYPE_CP.value) || (localStickerItem.cpRange != null)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isCyberpunkMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    List localList;
    do
    {
      return false;
      localList = paramVideoMaterial.getItemList();
      paramVideoMaterial = paramVideoMaterial.getStyleFilterList();
    } while ((paramVideoMaterial == null) || (localList == null));
    int i = 0;
    label26:
    Object localObject;
    if (i < localList.size())
    {
      localObject = (StickerItem)localList.get(i);
      if ((!TextUtils.isEmpty(((StickerItem)localObject).styleFilter)) && (paramVideoMaterial.containsKey(((StickerItem)localObject).styleFilter)))
      {
        localObject = (StyleFilterSettingJsonBean)paramVideoMaterial.get(((StickerItem)localObject).styleFilter);
        if (localObject != null) {
          break label95;
        }
      }
    }
    label95:
    while (((StyleFilterSettingJsonBean)localObject).type != 6)
    {
      i += 1;
      break label26;
      break;
    }
    return true;
  }
  
  public static boolean isDistortionFilter(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.NORMAL.value) {
      return false;
    }
    return true;
  }
  
  public static boolean isDoodlerMaskMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getMaskPaintType() != 0);
  }
  
  public static boolean isDownloaded(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    return paramVideoMaterial.getDataPath().startsWith("/");
  }
  
  public static boolean isEmojiMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (paramVideoMaterial.getCategoryFlag() != CategoryType.EMOJI.value) {
      return false;
    }
    return true;
  }
  
  public static boolean isEmotionDectectMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject1 = paramVideoMaterial.getItemList();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StickerItem)((Iterator)localObject1).next();
          if (PTFaceAttr.PTExpression.SMILE.value == ((StickerItem)localObject2).getTriggerTypeInt()) {
            return true;
          }
        }
      }
      localObject1 = paramVideoMaterial.getHeadCropItemList();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StickerItem)((Iterator)localObject1).next();
          if (PTFaceAttr.PTExpression.SMILE.value == ((StickerItem)localObject2).getTriggerTypeInt()) {
            return true;
          }
        }
      }
      localObject1 = paramVideoMaterial.getItemList3D();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StickerItem)((Iterator)localObject1).next();
          if (PTFaceAttr.PTExpression.SMILE.value == ((StickerItem)localObject2).getTriggerTypeInt()) {
            return true;
          }
        }
      }
      localObject1 = paramVideoMaterial.getFaceOffItemList();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FaceItem)((Iterator)localObject1).next();
          if (PTFaceAttr.PTExpression.SMILE.value == ((FaceItem)localObject2).getTriggerTypeInt()) {
            return true;
          }
        }
      }
      if (paramVideoMaterial.getGlbList() != null)
      {
        do
        {
          paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
          while (!((Iterator)localObject1).hasNext())
          {
            do
            {
              if (!paramVideoMaterial.hasNext()) {
                break;
              }
              localObject1 = (GLBItemJava)paramVideoMaterial.next();
            } while (((GLBItemJava)localObject1).animationList == null);
            localObject1 = ((GLBItemJava)localObject1).animationList.iterator();
          }
          localObject2 = (AnimationItem)((Iterator)localObject1).next();
        } while (PTFaceAttr.PTExpression.SMILE.value != ((AnimationItem)localObject2).getTriggerTypeInt());
        return true;
      }
    }
    return false;
  }
  
  public static boolean isEmptyItem(FaceItem paramFaceItem)
  {
    return (paramFaceItem == null) || ((TextUtils.isEmpty(paramFaceItem.id)) && (TextUtils.isEmpty(paramFaceItem.faceExchangeImage))) || ((!TextUtils.isEmpty(paramFaceItem.id)) && (paramFaceItem.id.equals("action"))) || ((!TextUtils.isEmpty(paramFaceItem.id)) && (paramFaceItem.id.equals("audio")));
  }
  
  public static boolean isEmptyItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem == null) || (TextUtils.isEmpty(paramStickerItem.id)) || (paramStickerItem.id.equals("action")) || (paramStickerItem.id.equals("audio"));
  }
  
  public static boolean isExternalWordsTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.EXTERNAL_WORDS.value;
  }
  
  public static boolean isFabbyMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (paramVideoMaterial.getFabbyParts() == null) {
      return false;
    }
    return true;
  }
  
  public static boolean isFaceCopyMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while ((paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_COPY.value) && ((paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value) || (paramVideoMaterial.getFaceSwapType() != VideoMaterialUtil.FACE_SWAP_TYPE.FACE_COPY.value))) {
      return false;
    }
    return true;
  }
  
  public static boolean isFaceCountTriggerItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (2 <= paramStickerItem.countTriggerType) && (paramStickerItem.countTriggerType <= 107);
  }
  
  public static boolean isFaceDetectMaterial(VideoMaterial paramVideoMaterial)
  {
    return isCyberpunkMaterial(paramVideoMaterial);
  }
  
  public static boolean isFaceItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.TRANSPARENT.type));
  }
  
  public static boolean isFaceMorphingMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_MORPHING.value) {
      return false;
    }
    return true;
  }
  
  public static boolean isFaceStyleMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getFaceStyleItemList() != null) && (paramVideoMaterial.getFaceStyleItemList().size() > 0);
  }
  
  public static boolean isFaceSwitchMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (((paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value) && (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH_DUP.value)) || (paramVideoMaterial.getFaceSwapType() != VideoMaterialUtil.FACE_SWAP_TYPE.FACE_SWITCH.value)) {
      return false;
    }
    return true;
  }
  
  public static boolean isFaceTriggerType(int paramInt)
  {
    return paramInt < 200;
  }
  
  public static boolean isFilamentAnimojiMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getGlbList() == null)) {
      return false;
    }
    Iterator localIterator;
    Object localObject;
    do
    {
      localIterator = paramVideoMaterial.getGlbList().iterator();
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = ((GLBItemJava)localIterator.next()).nodeList.iterator();
      }
    } while (((NodeItemJava)((Iterator)localObject).next()).expressionConfigList.isEmpty());
    return true;
    if (paramVideoMaterial.getMultiViewerItemList() != null)
    {
      localIterator = paramVideoMaterial.getMultiViewerItemList().iterator();
      while (localIterator.hasNext())
      {
        localObject = (MultiViewerItem)localIterator.next();
        if ((isFilamentAnimojiMaterial(((MultiViewerItem)localObject).videoMaterial)) || ((((MultiViewerItem)localObject).videoMaterial != null) && (((MultiViewerItem)localObject).videoMaterial.isKapuMaterial()))) {
          return true;
        }
      }
    }
    return paramVideoMaterial.isKapuMaterial();
  }
  
  public static boolean isFilamentBloomMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getGlbList() == null)) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
    while (paramVideoMaterial.hasNext()) {
      if (((GLBItemJava)paramVideoMaterial.next()).bloom != null) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isFilamentMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getGlbList() == null)) {
      return false;
    }
    if (paramVideoMaterial.getGlbList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getGlbList().iterator();
      while (localIterator.hasNext()) {
        if (!TextUtils.isEmpty(((GLBItemJava)localIterator.next()).path)) {
          return true;
        }
      }
    }
    if (paramVideoMaterial.getMultiViewerItemList() != null)
    {
      paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
      while (paramVideoMaterial.hasNext()) {
        if (isFilamentMaterial(((MultiViewerItem)paramVideoMaterial.next()).videoMaterial)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isFilamentParticleMaterial(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getFilamentParticleList() != null) && (!paramVideoMaterial.getFilamentParticleList().isEmpty());
  }
  
  public static boolean isGameplayMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (paramVideoMaterial.getGameParams() == null) {
      return false;
    }
    return true;
  }
  
  public static boolean isGenderDetect(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    return paramVideoMaterial.isDetectGender();
  }
  
  public static boolean isGenderSwitchMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getFaceStyleItemList();
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext()) {
        if (!TextUtils.isEmpty(((FaceStyleItem)paramVideoMaterial.next()).modelName)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isGestureCountTriggerItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (200 <= paramStickerItem.countTriggerType) && (paramStickerItem.countTriggerType <= 212);
  }
  
  public static boolean isGestureDetectMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject8 = paramVideoMaterial.getItemList();
      Object localObject6 = paramVideoMaterial.getItemList3D();
      Object localObject9 = paramVideoMaterial.getHeadCropItemList();
      Object localObject3 = paramVideoMaterial.getFaceFeatureItemList();
      Object localObject7 = paramVideoMaterial.getFaceOffItemList();
      Object localObject4 = paramVideoMaterial.getFaceStyleItemList();
      ArrayList localArrayList = new ArrayList();
      Object localObject5 = paramVideoMaterial.getFaceMeshItemList();
      Object localObject2 = paramVideoMaterial.getFabbyParts();
      Object localObject1 = paramVideoMaterial.getTriggerActionItemList();
      if (localObject8 != null) {
        localArrayList.addAll((Collection)localObject8);
      }
      if (localObject9 != null) {
        localArrayList.addAll((Collection)localObject9);
      }
      localObject8 = localArrayList.iterator();
      while (((Iterator)localObject8).hasNext())
      {
        localObject9 = (StickerItem)((Iterator)localObject8).next();
        if (((StickerItem)localObject9).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) {
          return true;
        }
        if (isGestureTriggerType(((StickerItem)localObject9).getTriggerTypeInt())) {
          return true;
        }
      }
      if (localObject7 != null)
      {
        localObject7 = ((List)localObject7).iterator();
        while (((Iterator)localObject7).hasNext()) {
          if (isGestureTriggerType(((FaceItem)((Iterator)localObject7).next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject6 != null)
      {
        localObject6 = ((List)localObject6).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (StickerItem3D)((Iterator)localObject6).next();
          if (((StickerItem3D)localObject7).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) {
            return true;
          }
          if (isGestureTriggerType(((StickerItem3D)localObject7).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject5 != null)
      {
        localObject5 = ((List)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          if (isGestureTriggerType(((FaceMeshItem)((Iterator)localObject5).next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject4 != null)
      {
        localObject5 = ((List)localObject4).iterator();
        break label369;
        label324:
        do
        {
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          if (isGestureTriggerType(((FaceStyleItem)((Iterator)localObject5).next()).getTriggerTypeInt())) {
            return true;
          }
        } while (localObject4 == null);
        localObject6 = ((List)localObject4).iterator();
        for (;;)
        {
          label369:
          if (!((Iterator)localObject6).hasNext()) {
            break label324;
          }
          localObject7 = (FaceStyleItem)((Iterator)localObject6).next();
          if (((FaceStyleItem)localObject7).stickerItemList == null) {
            break;
          }
          localObject7 = ((FaceStyleItem)localObject7).stickerItemList;
          int i = PTFaceAttr.PTExpression.FACE_DETECT.value;
          i = 0;
          while ((localObject7 != null) && (i < ((List)localObject7).size()))
          {
            localObject8 = ((List)localObject7).iterator();
            while (((Iterator)localObject8).hasNext()) {
              if (isGestureTriggerType(((StickerItem)((Iterator)localObject8).next()).getTriggerTypeInt())) {
                return true;
              }
            }
            i += 1;
          }
        }
      }
      if (paramVideoMaterial.getGlbList() != null)
      {
        do
        {
          paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
          while (!((Iterator)localObject4).hasNext())
          {
            do
            {
              if (!paramVideoMaterial.hasNext()) {
                break;
              }
              localObject4 = (GLBItemJava)paramVideoMaterial.next();
            } while (((GLBItemJava)localObject4).animationList == null);
            localObject4 = ((GLBItemJava)localObject4).animationList.iterator();
          }
          localObject5 = (AnimationItem)((Iterator)localObject4).next();
          if (((AnimationItem)localObject5).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) {
            return true;
          }
        } while (!isGestureTriggerType(((AnimationItem)localObject5).getTriggerTypeInt()));
        return true;
      }
      if (localObject3 != null)
      {
        do
        {
          paramVideoMaterial = ((List)localObject3).iterator();
          while (!((Iterator)localObject3).hasNext())
          {
            if (!paramVideoMaterial.hasNext()) {
              break;
            }
            localObject3 = ((FaceFeatureItem)paramVideoMaterial.next()).getStickerItems().iterator();
          }
        } while (((StickerItem)((Iterator)localObject3).next()).type != VideoFilterFactory.POSITION_TYPE.GESTURE.type);
        return true;
      }
      if (localObject2 != null)
      {
        paramVideoMaterial = ((FabbyParts)localObject2).getParts().iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject2 = ((FabbyMvPart)paramVideoMaterial.next()).transitionItem;
          if ((localObject2 != null) && (((StickerItem)localObject2).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type)) {
            return true;
          }
          if ((localObject2 != null) && (isGestureTriggerType(((StickerItem)localObject2).getTriggerTypeInt()))) {
            return true;
          }
        }
      }
      if (localObject1 != null)
      {
        paramVideoMaterial = ((List)localObject1).iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (TriggerActionItem)paramVideoMaterial.next();
          if ((((TriggerActionItem)localObject1).mTriggerExpression != null) && (isGestureTriggerType(((TriggerActionItem)localObject1).mTriggerExpression.mTriggerType))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isGestureItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.GESTURE.type);
  }
  
  public static boolean isGestureTriggerType(int paramInt)
  {
    return ((200 <= paramInt) && (paramInt <= 212)) || (paramInt == 220);
  }
  
  public static boolean isGpuParticleMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext()) {
        if (((StickerItem)paramVideoMaterial.next()).gpuParticleConfig != null) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isHairSegMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getItemList() != null))
    {
      Object localObject1 = paramVideoMaterial.getItemList().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((StickerItem)((Iterator)localObject1).next()).type == VideoFilterFactory.POSITION_TYPE.HAIR.type)
        {
          LogUtils.d(TAG, "[isHairSegMaterial] normal case, return true");
          return true;
        }
      }
      localObject1 = paramVideoMaterial.getMultiViewerItemList();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        return false;
      }
      Object localObject2;
      do
      {
        localObject1 = ((List)localObject1).iterator();
        while (!((Iterator)localObject2).hasNext())
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((MultiViewerItem)((Iterator)localObject1).next()).videoMaterial;
          if ((localObject2 == null) || (((VideoMaterial)localObject2).getItemList() == null) || (((VideoMaterial)localObject2).getItemList().isEmpty())) {
            return false;
          }
          localObject2 = ((VideoMaterial)localObject2).getItemList().iterator();
        }
      } while (((StickerItem)((Iterator)localObject2).next()).type != VideoFilterFactory.POSITION_TYPE.HAIR.type);
      LogUtils.d(TAG, "[isHairSegMaterial] multi-view case, return true");
      return true;
      if (paramVideoMaterial.getGlbList() != null)
      {
        do
        {
          paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
          while (!((Iterator)localObject1).hasNext())
          {
            do
            {
              if (!paramVideoMaterial.hasNext()) {
                break;
              }
              localObject1 = (GLBItemJava)paramVideoMaterial.next();
            } while (((GLBItemJava)localObject1).animationList == null);
            localObject1 = ((GLBItemJava)localObject1).animationList.iterator();
          }
        } while (((AnimationItem)((Iterator)localObject1).next()).type != VideoFilterFactory.POSITION_TYPE.HAIR.type);
        return true;
      }
    }
    return false;
  }
  
  public static boolean isHeadCropMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) {
      return false;
    }
    return true;
  }
  
  public static boolean isHotAreaTriggerItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {}
    while ((paramStickerItem.triggerArea == null) || (paramStickerItem.triggerArea.size() <= 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean isHumanSegMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getItemList() != null))
    {
      paramVideoMaterial = paramVideoMaterial.getItemList().iterator();
      while (paramVideoMaterial.hasNext()) {
        if ("human".equals(((StickerItem)paramVideoMaterial.next()).maskType)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isKissMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject7 = paramVideoMaterial.getItemList();
      Object localObject5 = paramVideoMaterial.getItemList3D();
      List localList = paramVideoMaterial.getHeadCropItemList();
      Object localObject6 = paramVideoMaterial.getFaceOffItemList();
      Object localObject3 = paramVideoMaterial.getFaceStyleItemList();
      ArrayList localArrayList = new ArrayList();
      Object localObject4 = paramVideoMaterial.getFaceMeshItemList();
      Object localObject2 = paramVideoMaterial.getFabbyParts();
      Object localObject1 = paramVideoMaterial.getTriggerActionItemList();
      if (localObject7 != null) {
        localArrayList.addAll((Collection)localObject7);
      }
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      localObject7 = localArrayList.iterator();
      while (((Iterator)localObject7).hasNext()) {
        if (isKissTriggerType(((StickerItem)((Iterator)localObject7).next()).getTriggerTypeInt())) {
          return true;
        }
      }
      if (localObject6 != null)
      {
        localObject6 = ((List)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          if (isKissTriggerType(((FaceItem)((Iterator)localObject6).next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject5 != null)
      {
        localObject5 = ((List)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          if (isKissTriggerType(((StickerItem3D)((Iterator)localObject5).next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject4 != null)
      {
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          if (isKissTriggerType(((FaceMeshItem)((Iterator)localObject4).next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          if (isKissTriggerType(((FaceStyleItem)((Iterator)localObject3).next()).getTriggerTypeInt())) {
            return true;
          }
        }
      }
      if (paramVideoMaterial.getGlbList() != null)
      {
        do
        {
          paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!paramVideoMaterial.hasNext()) {
                break;
              }
              localObject3 = (GLBItemJava)paramVideoMaterial.next();
            } while (((GLBItemJava)localObject3).animationList == null);
            localObject3 = ((GLBItemJava)localObject3).animationList.iterator();
          }
        } while (!isKissTriggerType(((AnimationItem)((Iterator)localObject3).next()).getTriggerTypeInt()));
        return true;
      }
      if (localObject2 != null)
      {
        paramVideoMaterial = ((FabbyParts)localObject2).getParts().iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject2 = ((FabbyMvPart)paramVideoMaterial.next()).transitionItem;
          if ((localObject2 != null) && (isKissTriggerType(((StickerItem)localObject2).getTriggerTypeInt()))) {
            return true;
          }
        }
      }
      if (localObject1 != null)
      {
        paramVideoMaterial = ((List)localObject1).iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (TriggerActionItem)paramVideoMaterial.next();
          if ((((TriggerActionItem)localObject1).mTriggerExpression != null) && (isKissTriggerType(((TriggerActionItem)localObject1).mTriggerExpression.mTriggerType))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isKissTriggerType(int paramInt)
  {
    return PTFaceAttr.PTExpression.KISS.value == paramInt;
  }
  
  public static boolean isMeshUsed(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.isUseMesh());
  }
  
  public static boolean isMultiViewerMaterial(VideoMaterial paramVideoMaterial)
  {
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
    return (paramVideoMaterial != null) && (!paramVideoMaterial.isEmpty());
  }
  
  public static boolean isNeedDepthMask(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (paramVideoMaterial.needDepthMask()) {
        return true;
      }
      paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
      if (paramVideoMaterial == null) {
        return false;
      }
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext())
      {
        MultiViewerItem localMultiViewerItem = (MultiViewerItem)paramVideoMaterial.next();
        if ((localMultiViewerItem != null) && (localMultiViewerItem.videoMaterial != null) && (localMultiViewerItem.videoMaterial.needDepthMask())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isNeedHandBonePoint(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject3 = paramVideoMaterial.getItemList();
      Object localObject2 = paramVideoMaterial.getItemList3D();
      Object localObject4 = paramVideoMaterial.getHeadCropItemList();
      Object localObject1 = paramVideoMaterial.getFaceFeatureItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      if (localObject4 != null) {
        localArrayList.addAll((Collection)localObject4);
      }
      localObject3 = localArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (StickerItem)((Iterator)localObject3).next();
        if (((((StickerItem)localObject4).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (isGestureTriggerType(((StickerItem)localObject4).getTriggerTypeInt()))) && (isContainHandBonePoint(((StickerItem)localObject4).alignFacePoints))) {
          return true;
        }
        if ((((StickerItem)localObject4).triggerArea != null) && (((StickerItem)localObject4).triggerArea.size() > 0)) {
          return true;
        }
      }
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (StickerItem3D)((Iterator)localObject2).next();
          if (((((StickerItem3D)localObject3).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (isGestureTriggerType(((StickerItem3D)localObject3).getTriggerTypeInt()))) && (isContainHandBonePoint(((StickerItem3D)localObject3).alignFacePoints))) {
            return true;
          }
          if ((((StickerItem3D)localObject3).triggerArea != null) && (((StickerItem3D)localObject3).triggerArea.size() > 0)) {
            return true;
          }
        }
      }
      paramVideoMaterial = paramVideoMaterial.getTriggerActionItemList();
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject2 = (TriggerActionItem)paramVideoMaterial.next();
          if ((localObject2 != null) && (((TriggerActionItem)localObject2).mTriggerExpression != null) && (((TriggerActionItem)localObject2).mTriggerExpression.triggerArea != null) && (((TriggerActionItem)localObject2).mTriggerExpression.triggerArea.size() > 0)) {
            return true;
          }
        }
      }
      if (localObject1 != null)
      {
        do
        {
          paramVideoMaterial = ((List)localObject1).iterator();
          while (!((Iterator)localObject1).hasNext())
          {
            if (!paramVideoMaterial.hasNext()) {
              break;
            }
            localObject1 = ((FaceFeatureItem)paramVideoMaterial.next()).getStickerItems().iterator();
          }
        } while (((StickerItem)((Iterator)localObject1).next()).type != VideoFilterFactory.POSITION_TYPE.GESTURE.type);
        return true;
      }
    }
    return false;
  }
  
  public static boolean isOldAnimojiMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getGameParams() == null)) {}
    while (TextUtils.isEmpty(paramVideoMaterial.getGameParams().animojiBaseNodeId)) {
      return false;
    }
    return true;
  }
  
  public static boolean isPagMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject = paramVideoMaterial.getItemList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((StickerItem)((Iterator)localObject).next()).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
            return true;
          }
        }
      }
      localObject = paramVideoMaterial.getHeadCropItemList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((StickerItem)((Iterator)localObject).next()).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
            return true;
          }
        }
      }
      localObject = paramVideoMaterial.getItemList3D();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((StickerItem)((Iterator)localObject).next()).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
            return true;
          }
        }
      }
      if (paramVideoMaterial.getCosFun() != null) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isParticleMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) {
      return true;
    }
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if ((paramVideoMaterial != null) && (paramVideoMaterial.size() > 0))
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext()) {
        if (((StickerItem)paramVideoMaterial.next()).particleConfig != null) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isPhantomMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    do
    {
      return false;
      paramVideoMaterial = paramVideoMaterial.getPhantomItemList();
    } while ((paramVideoMaterial == null) || (paramVideoMaterial.isEmpty()));
    return true;
  }
  
  public static boolean isRapidNetMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((isHairSegMaterial(paramVideoMaterial)) || (isSkySegMaterial(paramVideoMaterial))) {}
    while ((paramVideoMaterial != null) && (paramVideoMaterial.getFaceStyleItemList() != null) && (!paramVideoMaterial.getFaceStyleItemList().isEmpty())) {
      return true;
    }
    return false;
  }
  
  public static boolean isSegStrokeItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.SEG_STROKE.type);
  }
  
  public static boolean isSegStrokeTriggerItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.SEG_STROKE_TRIGGER.type);
  }
  
  public static boolean isSegmentMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    return paramVideoMaterial.isSegmentRequired();
  }
  
  public static boolean isSkySegMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    Object localObject;
    if (paramVideoMaterial.getItemList() != null)
    {
      localObject = paramVideoMaterial.getItemList().iterator();
      while (((Iterator)localObject).hasNext()) {
        if ("sky".equals(((StickerItem)((Iterator)localObject).next()).maskType)) {
          return true;
        }
      }
    }
    if (paramVideoMaterial.getGlbList() != null)
    {
      do
      {
        paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!paramVideoMaterial.hasNext()) {
              break;
            }
            localObject = (GLBItemJava)paramVideoMaterial.next();
          } while (((GLBItemJava)localObject).animationList == null);
          localObject = ((GLBItemJava)localObject).animationList.iterator();
        }
      } while (!"sky".equals(((AnimationItem)((Iterator)localObject).next()).maskType));
      return true;
    }
    return false;
  }
  
  public static boolean isStarItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STAR.type);
  }
  
  public static boolean isStarMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    return needRenderStar(paramVideoMaterial.getStarParam());
  }
  
  public static boolean isTNNMaterial(VideoMaterial paramVideoMaterial, FaceStyleItem.StyleChangeType paramStyleChangeType)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    if (!isMultiViewerMaterial(paramVideoMaterial)) {
      return checkTNNElement(paramVideoMaterial, paramStyleChangeType);
    }
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
    while (paramVideoMaterial.hasNext()) {
      if (checkTNNElement(((MultiViewerItem)paramVideoMaterial.next()).videoMaterial, paramStyleChangeType)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isTimeTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.TIME_TRIGGER.value;
  }
  
  public static boolean isTouchTriggerEvent(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getTouchFlag() != 0);
  }
  
  public static boolean isTouchTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.TAP_SCREEN.value;
  }
  
  public static boolean isValidOutputFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static boolean isWatermarkEditable(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject1 = paramVideoMaterial.getItemList();
      if (localObject1 != null)
      {
        Object localObject2;
        do
        {
          localObject1 = ((List)localObject1).iterator();
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (StickerItem)((Iterator)localObject1).next();
            } while (((StickerItem)localObject2).wmGroupConfig == null);
            localObject2 = ((StickerItem)localObject2).wmGroupConfig.wmElementConfigs.iterator();
          }
        } while (((WMElementConfig)((Iterator)localObject2).next()).edittype != 1);
        return true;
      }
      if (paramVideoMaterial.getMultiViewerItemList() != null)
      {
        paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
        while (paramVideoMaterial.hasNext()) {
          if (isWatermarkEditable(((MultiViewerItem)paramVideoMaterial.next()).videoMaterial)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isWatermarkMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject = paramVideoMaterial.getItemList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((StickerItem)((Iterator)localObject).next()).stickerType == VideoFilterFactory.STICKER_TYPE.WATERMARK.type) {
            return true;
          }
        }
      }
      if (paramVideoMaterial.getMultiViewerItemList() != null)
      {
        paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
        while (paramVideoMaterial.hasNext()) {
          if (isWatermarkMaterial(((MultiViewerItem)paramVideoMaterial.next()).videoMaterial)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static float[] listToArray(List<Float> paramList)
  {
    if (paramList == null) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat[i] = ((Float)paramList.get(i)).floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static float[][] listToFloatArray(List<PointF> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = new float[0][];
      return localObject;
    }
    int i = paramList.size();
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { i, 2 });
    i = 0;
    for (;;)
    {
      localObject = arrayOfFloat;
      if (i >= paramList.size()) {
        break;
      }
      arrayOfFloat[i][0] = ((PointF)paramList.get(i)).x;
      arrayOfFloat[i][1] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
  }
  
  public static int[][] listToIntArray(List<PointF> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = new int[0][];
      return localObject;
    }
    int i = paramList.size();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    i = 0;
    for (;;)
    {
      localObject = arrayOfInt;
      if (i >= paramList.size()) {
        break;
      }
      arrayOfInt[i][0] = ((int)((PointF)paramList.get(i)).x);
      arrayOfInt[i][1] = ((int)((PointF)paramList.get(i)).y);
      i += 1;
    }
  }
  
  public static String loadFaceOffFragmentShader(String paramString)
  {
    return FileUtils.load(AEModule.getContext(), paramString, "faceoff_fragment.glsl");
  }
  
  public static String loadFaceOffVertexShader(String paramString)
  {
    return FileUtils.load(AEModule.getContext(), paramString, "faceoff_vertex.glsl");
  }
  
  public static String loadFragmentShader(String paramString)
  {
    String str2 = FileUtils.load(AEModule.getContext(), paramString, "fragment_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(AEModule.getContext(), paramString, "fragment.glsl");
    }
    return str1;
  }
  
  public static List<VideoMaterialMetaData> loadLocalMaterials()
  {
    List localList = VideoLocalDataInitializer.buildVideoMaterials();
    if (localList == null) {
      return new ArrayList();
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      VideoMaterialMetaData localVideoMaterialMetaData = (VideoMaterialMetaData)localIterator.next();
      if (TextUtils.isEmpty(localVideoMaterialMetaData.path)) {
        localVideoMaterialMetaData.path = VideoPrefsUtil.getDefaultPrefs().getString(localVideoMaterialMetaData.id, "");
      }
    }
    return localList;
  }
  
  public static String loadVertexShader(String paramString)
  {
    String str2 = FileUtils.load(AEModule.getContext(), paramString, "vertex_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(AEModule.getContext(), paramString, "vertex.glsl");
    }
    return str1;
  }
  
  public static String loadVideoCustomEffectFilterFragmentShader(String paramString)
  {
    String str2 = FileUtils.load(AEModule.getContext(), paramString, "filterFragment_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(AEModule.getContext(), paramString, "filterFragment.glsl");
    }
    return str1;
  }
  
  public static String loadVideoCustomEffectFilterVertexShader(String paramString)
  {
    String str2 = FileUtils.load(AEModule.getContext(), paramString, "filterVertex_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(AEModule.getContext(), paramString, "filterVertex.glsl");
    }
    return str1;
  }
  
  public static List<PointF> makeFacePoints(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList(90);
    int j = Math.min(paramArrayOfFloat.length / 2, 90);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean needCopyTransform()
  {
    boolean bool2 = false;
    String str1 = DeviceInstance.getInstance().getDeviceName().trim();
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = DEVICE_NEED_COPY_TRANSFORM;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str2 = arrayOfString[i];
        if (str1.toLowerCase().endsWith(str2.toLowerCase())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean needDetectFace(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getTriggerType() != 0) && (paramVideoMaterial.getTriggerType() != 1);
  }
  
  public static boolean needFaceTips(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if (paramVideoMaterial == null) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.iterator();
    while (paramVideoMaterial.hasNext()) {
      if (((StickerItem)paramVideoMaterial.next()).getTriggerTypeInt() >= 2) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean needOpenRefine(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && ((paramVideoMaterial.getDetectorFlag() == 1) || ((paramVideoMaterial.getDetectorFlag() == 2) && (DeviceUtils.hasDeviceHigh(AEModule.getContext()))));
  }
  
  public static boolean needRenderStar(StarParam paramStarParam)
  {
    return (paramStarParam != null) && (paramStarParam.starStrength >= 0.0F);
  }
  
  public static boolean needSmallSize()
  {
    boolean bool2 = false;
    String str1 = DeviceInstance.getInstance().getDeviceName().trim();
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = DEVICE_NEED_SMALL_SIZE;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str2 = arrayOfString[i];
        if (str1.toLowerCase().endsWith(str2.toLowerCase())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean needVoiceChange(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.getVoicekind() != -999999) && (paramVideoMaterial.getEnvironment() != -999999);
  }
  
  public static void sort(List<StickerItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return;
    }
    Collections.sort(paramList, new VideoMaterialUtil.1());
  }
  
  public static boolean supportLandscape(VideoMaterial paramVideoMaterial)
  {
    return (paramVideoMaterial != null) && (paramVideoMaterial.isSupportLandscape());
  }
  
  public static float[] toFlatArray(List<PointF> paramList)
  {
    if (paramList == null) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[paramList.size() * 2];
    int i = 0;
    if (i < paramList.size())
    {
      PointF localPointF = (PointF)paramList.get(i);
      if (localPointF == null) {}
      for (;;)
      {
        i += 1;
        break;
        arrayOfFloat[(i * 2)] = localPointF.x;
        arrayOfFloat[(i * 2 + 1)] = localPointF.y;
      }
    }
    return arrayOfFloat;
  }
  
  public static float[] toFlatArray(PointF[] paramArrayOfPointF)
  {
    Object localObject;
    if (paramArrayOfPointF == null)
    {
      localObject = new float[0];
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        float[] arrayOfFloat = new float[paramArrayOfPointF.length * 2];
        i = 0;
        localObject = arrayOfFloat;
        if (i >= paramArrayOfPointF.length) {
          break;
        }
        if (paramArrayOfPointF[i] != null)
        {
          arrayOfFloat[(i * 2)] = paramArrayOfPointF[i].x;
          arrayOfFloat[(i * 2 + 1)] = paramArrayOfPointF[i].y;
        }
      }
      catch (OutOfMemoryError paramArrayOfPointF)
      {
        paramArrayOfPointF.printStackTrace();
        return new float[0];
      }
      i += 1;
    }
  }
  
  public static void updateCharmRangeType(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject6 = paramVideoMaterial.getItemList();
      Object localObject4 = paramVideoMaterial.getItemList3D();
      Object localObject7 = paramVideoMaterial.getHeadCropItemList();
      Object localObject5 = paramVideoMaterial.getFaceOffItemList();
      Object localObject3 = paramVideoMaterial.getFaceMeshItemList();
      Object localObject1 = paramVideoMaterial.getFaceFeatureItemList();
      Object localObject2 = paramVideoMaterial.getFaceStyleItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject6 != null) {
        localArrayList.addAll((Collection)localObject6);
      }
      if (localObject7 != null) {
        localArrayList.addAll((Collection)localObject7);
      }
      localObject6 = localArrayList.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (StickerItem)((Iterator)localObject6).next();
        if (((StickerItem)localObject7).charmRange != null) {
          if ((((StickerItem)localObject7).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (isGestureTriggerType(((StickerItem)localObject7).getTriggerTypeInt()))) {
            paramVideoMaterial.setHandCharmRangeMaterial(true);
          } else {
            paramVideoMaterial.setFaceCharmRangeMaterial(true);
          }
        }
      }
      if (localObject5 != null)
      {
        localObject5 = ((List)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (FaceItem)((Iterator)localObject5).next();
          if (((FaceItem)localObject6).charmRange != null) {
            if (isGestureTriggerType(((FaceItem)localObject6).getTriggerTypeInt())) {
              paramVideoMaterial.setHandCharmRangeMaterial(true);
            } else {
              paramVideoMaterial.setFaceCharmRangeMaterial(true);
            }
          }
        }
      }
      if (localObject4 != null)
      {
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (StickerItem3D)((Iterator)localObject4).next();
          if (((StickerItem3D)localObject5).charmRange != null) {
            if ((((StickerItem3D)localObject5).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (isGestureTriggerType(((StickerItem3D)localObject5).getTriggerTypeInt()))) {
              paramVideoMaterial.setHandCharmRangeMaterial(true);
            } else {
              paramVideoMaterial.setFaceCharmRangeMaterial(true);
            }
          }
        }
      }
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FaceMeshItem)((Iterator)localObject3).next();
          if (((FaceMeshItem)localObject4).charmRange != null) {
            if (isGestureTriggerType(((FaceMeshItem)localObject4).getTriggerTypeInt())) {
              paramVideoMaterial.setHandCharmRangeMaterial(true);
            } else {
              paramVideoMaterial.setFaceCharmRangeMaterial(true);
            }
          }
        }
      }
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FaceStyleItem)((Iterator)localObject2).next();
          if (((FaceStyleItem)localObject3).stickerItemList != null)
          {
            localObject3 = ((FaceStyleItem)localObject3).stickerItemList;
            int i = 0;
            while ((localObject3 != null) && (i < ((List)localObject3).size()))
            {
              localObject4 = ((List)localObject3).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (StickerItem)((Iterator)localObject4).next();
                if (((StickerItem)localObject5).charmRange != null) {
                  if (isGestureTriggerType(((StickerItem)localObject5).getTriggerTypeInt())) {
                    paramVideoMaterial.setHandCharmRangeMaterial(true);
                  } else {
                    paramVideoMaterial.setFaceCharmRangeMaterial(true);
                  }
                }
              }
              i += 1;
            }
          }
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FaceFeatureItem)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((FaceFeatureItem)localObject2).getStickerItems() != null))
          {
            localObject2 = ((FaceFeatureItem)localObject2).getStickerItems().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (StickerItem)((Iterator)localObject2).next();
              if (((StickerItem)localObject3).charmRange != null) {
                if ((((StickerItem)localObject3).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (isGestureTriggerType(((StickerItem)localObject3).getTriggerTypeInt()))) {
                  paramVideoMaterial.setHandCharmRangeMaterial(true);
                } else {
                  paramVideoMaterial.setFaceCharmRangeMaterial(true);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void updateFaceValueDetectType(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getItemList() == null)) {
      return;
    }
    Iterator localIterator = paramVideoMaterial.getItemList().iterator();
    StickerItem localStickerItem;
    for (int j = 0; localIterator.hasNext(); j = localStickerItem.markMode | j)
    {
      localStickerItem = (StickerItem)localIterator.next();
      int i = j;
      if (localStickerItem.ageRange != null) {
        i = j | 0x1;
      }
      j = i;
      if (localStickerItem.genderRange != null) {
        j = i | 0x2;
      }
      i = j;
      if (localStickerItem.popularRange != null) {
        i = j | 0x4;
      }
      j = i;
      if (localStickerItem.cpRange != null) {
        j = i | 0x8;
      }
    }
    paramVideoMaterial.setFaceValueDetectType(j);
  }
  
  public static void updateItemImageType(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    for (;;)
    {
      return;
      Object localObject1 = new ArrayList();
      if (paramVideoMaterial.getItemList() != null) {
        ((List)localObject1).addAll(paramVideoMaterial.getItemList());
      }
      Object localObject2;
      Object localObject3;
      if (paramVideoMaterial.getFaceFeatureItemList() != null)
      {
        localObject2 = paramVideoMaterial.getFaceFeatureItemList().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FaceFeatureItem)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((FaceFeatureItem)localObject3).getFaceOffItemList() != null)) {
            ((List)localObject1).addAll(((FaceFeatureItem)localObject3).getStickerItems());
          }
        }
      }
      if (paramVideoMaterial.getHeadCropItemList() != null) {
        ((List)localObject1).addAll(paramVideoMaterial.getHeadCropItemList());
      }
      if (paramVideoMaterial.getUkyoGameSetting() != null) {
        ((List)localObject1).addAll(paramVideoMaterial.getUkyoGameSetting().getItems());
      }
      if ((paramVideoMaterial.getImageSetting() != null) && (paramVideoMaterial.getImageSetting().getStickerItems() != null)) {
        ((List)localObject1).addAll(paramVideoMaterial.getImageSetting().getStickerItems());
      }
      if (paramVideoMaterial.getFabbyParts() != null)
      {
        localObject2 = paramVideoMaterial.getFabbyParts().getParts().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FabbyMvPart)((Iterator)localObject2).next();
          if (((FabbyMvPart)localObject3).bgItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).bgItem);
          }
          if (((FabbyMvPart)localObject3).fgItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).fgItem);
          }
          if (((FabbyMvPart)localObject3).coverItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).coverItem);
          }
          if (((FabbyMvPart)localObject3).transitionItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).transitionItem);
          }
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StickerItem)((Iterator)localObject1).next();
        if (((StickerItem)localObject2).sourceType == null) {
          if (((StickerItem)localObject2).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
            ((StickerItem)localObject2).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG;
          } else {
            ((StickerItem)localObject2).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
          }
        }
      }
      paramVideoMaterial = paramVideoMaterial.getItemList3D();
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (StickerItem)paramVideoMaterial.next();
          if (((StickerItem)localObject1).sourceType == null) {
            if (((StickerItem)localObject1).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
              ((StickerItem)localObject1).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG;
            } else {
              ((StickerItem)localObject1).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
            }
          }
        }
      }
    }
  }
  
  public static void updateMaxFaceCount(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) {
      return;
    }
    paramVideoMaterial.setMaxFaceCount(1);
  }
  
  public static void updateNeedBodyInfo(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return;
    }
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type)
        {
          paramVideoMaterial.setNeedBodyInfo(true);
          return;
        }
        if (isBodyTriggerType(localStickerItem.getTriggerTypeInt()))
        {
          paramVideoMaterial.setNeedBodyInfo(true);
          return;
        }
      }
    }
    paramVideoMaterial.setNeedBodyInfo(false);
  }
  
  public static void updateNeedFaceInfo(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return;
    }
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH_DUP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_COPY.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_MORPHING.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.GAMEPLAY_3D.value))
    {
      paramVideoMaterial.setNeedFaceInfo(true);
      return;
    }
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((localStickerItem.getTriggerTypeInt() != 1) && (isFaceTriggerType(localStickerItem.getTriggerTypeInt())))
        {
          paramVideoMaterial.setNeedFaceInfo(true);
          return;
        }
      }
    }
    paramVideoMaterial.setNeedFaceInfo(false);
  }
  
  public static void updatePointList(List<PointF> paramList1, List<PointF> paramList2)
  {
    if (paramList2 == null) {}
    for (;;)
    {
      return;
      Object localObject = paramList1;
      if (paramList1 == null) {
        localObject = new ArrayList();
      }
      int j = paramList2.size();
      while (((List)localObject).size() > j) {
        ((List)localObject).remove(((List)localObject).size() - 1);
      }
      while (((List)localObject).size() < j) {
        ((List)localObject).add(new PointF());
      }
      int i = 0;
      while (i < j)
      {
        ((PointF)((List)localObject).get(i)).x = ((PointF)paramList2.get(i)).x;
        ((PointF)((List)localObject).get(i)).y = ((PointF)paramList2.get(i)).y;
        i += 1;
      }
    }
  }
  
  public static void updatePointListOfList(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    if (paramList2 == null) {}
    for (;;)
    {
      return;
      Object localObject = paramList1;
      if (paramList1 == null) {
        localObject = new ArrayList();
      }
      int j = paramList2.size();
      while (((List)localObject).size() > j) {
        ((List)localObject).remove(((List)localObject).size() - 1);
      }
      while (((List)localObject).size() < j) {
        ((List)localObject).add(new ArrayList());
      }
      int i = 0;
      while (i < j)
      {
        updatePointList((List)((List)localObject).get(i), (List)paramList2.get(i));
        i += 1;
      }
    }
  }
  
  public static void updateSupportLandscape(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while ((paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value) && (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) && (!isFaceMorphingMaterial(paramVideoMaterial))) {
      return;
    }
    paramVideoMaterial.setSupportLandscape(false);
  }
  
  public static void updateWatermarkInfo(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getItemList() == null)) {
      label11:
      return;
    } else {
      paramVideoMaterial = paramVideoMaterial.getItemList().iterator();
    }
    for (;;)
    {
      if (!paramVideoMaterial.hasNext()) {
        break label11;
      }
      StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
      if (localStickerItem.wmGroupConfig != null)
      {
        localStickerItem.wmGroupConfig.setItemId(localStickerItem.id);
        localStickerItem.wmGroupConfig.setSize(localStickerItem.width, localStickerItem.height);
      }
      if (localStickerItem.wmGroupConfigCopies == null) {
        break;
      }
      Iterator localIterator = localStickerItem.wmGroupConfigCopies.iterator();
      while (localIterator.hasNext())
      {
        WMGroupConfig localWMGroupConfig = (WMGroupConfig)localIterator.next();
        localWMGroupConfig.setItemId(localStickerItem.id);
        localWMGroupConfig.setSize(localStickerItem.width, localStickerItem.height);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoMaterialUtil
 * JD-Core Version:    0.7.0.1
 */