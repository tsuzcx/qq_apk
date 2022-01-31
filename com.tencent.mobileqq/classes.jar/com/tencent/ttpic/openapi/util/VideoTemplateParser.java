package com.tencent.ttpic.openapi.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.Range;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.BlurEffectItem;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceMaskItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ImageMaskItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.NonFitItem;
import com.tencent.ttpic.model.PhantomItem;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.WMLogicPair;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.AnimationItem;
import com.tencent.ttpic.openapi.model.AnimojiExpressionJava;
import com.tencent.ttpic.openapi.model.BigAnimationParam;
import com.tencent.ttpic.openapi.model.BigItem;
import com.tencent.ttpic.openapi.model.BloomParam;
import com.tencent.ttpic.openapi.model.BuckleFaceItem;
import com.tencent.ttpic.openapi.model.BuckleFrameItem;
import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.model.DynamicBoneItem;
import com.tencent.ttpic.openapi.model.ExpressionItem;
import com.tencent.ttpic.openapi.model.EyeNodeItem;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.GridViewerItem;
import com.tencent.ttpic.openapi.model.LightItem;
import com.tencent.ttpic.openapi.model.MaterialStateEdgeItem;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.Rect;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.TriggerArea;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TriggerActionItem;
import com.tencent.ttpic.openapi.model.TriggerExpression;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.ChildPendant;
import com.tencent.ttpic.openapi.model.WMElementConfig;
import com.tencent.ttpic.openapi.model.WMGroupConfig;
import com.tencent.ttpic.openapi.model.WMLogic;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunGroupItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.PagIndexList;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import com.tencent.ttpic.particle.GPUParticleConfig;
import com.tencent.ttpic.particle.GPUParticleConfig.Sprite;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.ttpic.particle.ParticleJsonParser;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerTimeUpdater;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.ttpic.util.StrokeUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.XmlParseUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VideoTemplateParser
{
  public static final String DELAYED_TIP = "delayTips";
  public static final String DOUBLE_POUBLE = "isDualPeople";
  public static final String ENABLE_FACE_DETECT = "enableFaceDetect";
  public static final String FACE_DETECT_TYPE = "faceDetectorType";
  public static final int FaceDetector_FaceU = 0;
  public static final int FaceDetector_Ulsee = 1;
  public static final String ITEM_LIST = "itemList";
  public static final String ITEM_TIPS = "itemTips";
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  private static final String TAG = VideoTemplateParser.class.getSimpleName();
  public static final DecryptListener decryptListener = new VideoTemplateParser.1();
  private static Comparator<Pair<Float, Integer>> mDivideValueComp = new VideoTemplateParser.8();
  private static Comparator<Pair<Float, ? extends Object>> mDivideValueCompForObject = new VideoTemplateParser.9();
  private static Comparator<GridModel> mGridModelComparator = new VideoTemplateParser.11();
  private static Comparator<Pair<Float, Double>> mRangeValueComp = new VideoTemplateParser.10();
  
  private static boolean checkNeedDetectGender(List<FaceItem> paramList)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FaceItem localFaceItem = (FaceItem)paramList.next();
      if ((localFaceItem != null) && (localFaceItem.genderType > 0)) {
        return true;
      }
    }
    return false;
  }
  
  private static void checkValid(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    StickerItem localStickerItem;
    do
    {
      do
      {
        do
        {
          return;
          while (!paramVideoMaterial.hasNext())
          {
            do
            {
              paramVideoMaterial = paramVideoMaterial.getItemList();
            } while (paramVideoMaterial == null);
            paramVideoMaterial = paramVideoMaterial.iterator();
          }
          localStickerItem = (StickerItem)paramVideoMaterial.next();
          if (localStickerItem.type != VideoFilterFactory.POSITION_TYPE.STATIC.type) {
            break;
          }
        } while ((localStickerItem.position != null) && (localStickerItem.position.length >= 2));
        throw new IllegalArgumentException("No \"position\" field in static sticker");
      } while (localStickerItem.type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type);
      if ((localStickerItem.scalePivots == null) || (localStickerItem.scalePivots.length < 2)) {
        throw new IllegalArgumentException("No \"scalePivot\" field in dynamic sticker");
      }
      if ((localStickerItem.alignFacePoints == null) || (localStickerItem.alignFacePoints.length == 0)) {
        throw new IllegalArgumentException("No \"alignFacePoints\" field in dynamic sticker");
      }
    } while ((localStickerItem.anchorPoint != null) && (localStickerItem.anchorPoint.length >= 2));
    throw new IllegalArgumentException("No \"anchorPoint\" field in dynamic sticker");
  }
  
  public static InputStream drinkACupOfCoffee(InputStream paramInputStream, DecryptListener paramDecryptListener)
  {
    byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (paramDecryptListener != null) {
      paramInputStream = paramDecryptListener.decrypt(arrayOfByte);
    }
    return new ByteArrayInputStream(paramInputStream);
  }
  
  public static String getFullPath(String paramString1, String paramString2)
  {
    paramString1 = FileUtils.getRealPath(paramString1);
    return paramString1 + File.separator + paramString2;
  }
  
  public static VideoMaterial parse2DMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {
      return paramVideoMaterial;
    }
    for (;;)
    {
      NonFitItem[] arrayOfNonFitItem;
      int i;
      NonFitItem localNonFitItem;
      try
      {
        JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "model2dAnimationList");
        if (localJsonArray == null) {
          break;
        }
        arrayOfNonFitItem = new NonFitItem[localJsonArray.size()];
        i = 0;
        if (i < localJsonArray.size())
        {
          JsonObject localJsonObject = GsonUtils.getJsonObjectUnsafe(localJsonArray, i);
          localNonFitItem = new NonFitItem();
          localNonFitItem.id = GsonUtils.optString(localJsonObject, "id");
          localNonFitItem.name = GsonUtils.optString(localJsonObject, "name");
          localNonFitItem.subFolder = localNonFitItem.id;
          localNonFitItem.stickerType = GsonUtils.optInt(localJsonObject, "stickerType");
          localNonFitItem.triggerMode = GsonUtils.optInt(localJsonObject, "triggerMode");
          localNonFitItem.clickMode = GsonUtils.optInt(localJsonObject, "clickMode");
          localNonFitItem.playCount = GsonUtils.optInt(localJsonObject, "playCount");
          localNonFitItem.audio = GsonUtils.optString(localJsonObject, "audio");
          localNonFitItem.blendMode = GsonUtils.optInt(localJsonObject, "blendMode", -1);
          if (localNonFitItem.blendMode == -1) {
            localNonFitItem.blendMode = paramVideoMaterial.getBlendMode();
          }
          localNonFitItem.frameDuration = GsonUtils.optDouble(localJsonObject, "frameDuration");
          localNonFitItem.frames = GsonUtils.optInt(localJsonObject, "frames");
          localNonFitItem.width = GsonUtils.optInt(localJsonObject, "width");
          localNonFitItem.height = GsonUtils.optInt(localJsonObject, "height");
          localNonFitItem.extraTypeWidth = GsonUtils.optInt(localJsonObject, "extraTypeWidth");
          localNonFitItem.extarTypeHeight = GsonUtils.optInt(localJsonObject, "extraTypeHeight");
          if (localNonFitItem.stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type)
          {
            paramJsonObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG;
            localNonFitItem.sourceType = paramJsonObject;
            localNonFitItem.framePositionsBean = parseFramePosition(paramVideoMaterial, localJsonObject);
            paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "position");
            if (paramJsonObject != null)
            {
              localNonFitItem.position = new double[paramJsonObject.size()];
              int j = 0;
              if (j >= paramJsonObject.size()) {
                break label396;
              }
              localNonFitItem.position[j] = GsonUtils.getDoubleUnsafe(paramJsonObject, j);
              j += 1;
              continue;
            }
          }
          else
          {
            paramJsonObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
            continue;
          }
          localNonFitItem.position = new double[] { 0.0D, 0.0D };
        }
        else
        {
          paramVideoMaterial.setNonFitItems(arrayOfNonFitItem);
        }
      }
      catch (Exception paramJsonObject)
      {
        paramJsonObject.printStackTrace();
      }
      finally
      {
        return paramVideoMaterial;
      }
      label396:
      arrayOfNonFitItem[i] = localNonFitItem;
      i += 1;
    }
  }
  
  private static void parse3DItemListParams(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, boolean[] paramArrayOfBoolean)
  {
    ArrayList localArrayList;
    int i;
    int k;
    JsonObject localJsonObject;
    StickerItem3D localStickerItem3D;
    boolean bool;
    Object localObject1;
    try
    {
      localArrayList = new ArrayList();
      JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "itemList3D");
      if (localJsonArray != null)
      {
        j = 0;
        paramJsonObject = "";
        i = 0;
        k = 0;
        if (k >= localJsonArray.size()) {
          break label3465;
        }
        localJsonObject = GsonUtils.getJsonObjectUnsafe(localJsonArray, k);
        localStickerItem3D = new StickerItem3D();
        paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "scale");
        if (paramJsonObject != null)
        {
          localStickerItem3D.nodeScale = new float[paramJsonObject.size()];
          j = 0;
          while (j < paramJsonObject.size())
          {
            localStickerItem3D.nodeScale[j] = ((float)GsonUtils.getDoubleUnsafe(paramJsonObject, j));
            j += 1;
          }
        }
        paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "position");
        if (paramJsonObject != null)
        {
          localStickerItem3D.nodePosition = new float[paramJsonObject.size()];
          j = 0;
          while (j < paramJsonObject.size())
          {
            localStickerItem3D.nodePosition[j] = ((float)GsonUtils.getDoubleUnsafe(paramJsonObject, j));
            j += 1;
          }
        }
        paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "eulerAngles");
        if (paramJsonObject != null)
        {
          localStickerItem3D.nodeEulerAngles = new float[paramJsonObject.size()];
          j = 0;
          while (j < paramJsonObject.size())
          {
            localStickerItem3D.nodeEulerAngles[j] = ((float)GsonUtils.getDoubleUnsafe(paramJsonObject, j));
            j += 1;
          }
        }
        paramJsonObject = GsonUtils.optString(localJsonObject, "glbModelName");
        if (!TextUtils.isEmpty(paramJsonObject))
        {
          localStickerItem3D.glbModePath = getFullPath(paramString, paramJsonObject);
          LogUtils.d(TAG, "glbModePath = " + localStickerItem3D.glbModePath);
        }
        localStickerItem3D.id = GsonUtils.optString(localJsonObject, "id");
        localStickerItem3D.frames = GsonUtils.optInt(localJsonObject, "frames");
        localStickerItem3D.frameDuration = GsonUtils.optDouble(localJsonObject, "frameDuration");
        if (localStickerItem3D.frames > 0)
        {
          paramJsonObject = new NodeParameter();
          paramJsonObject.nodeId = localStickerItem3D.id;
          paramJsonObject.frames = localStickerItem3D.frames;
          paramJsonObject.frameDuration = ((int)localStickerItem3D.frameDuration);
          localStickerItem3D.nodeParameter = paramJsonObject;
        }
        if (localStickerItem3D.id.contains(":"))
        {
          paramJsonObject = localStickerItem3D.id.split(":");
          if (paramJsonObject.length != 2) {}
        }
        for (localStickerItem3D.subFolder = paramJsonObject[1];; localStickerItem3D.subFolder = localStickerItem3D.id)
        {
          localStickerItem3D.name = GsonUtils.optString(localJsonObject, "name");
          localStickerItem3D.type = GsonUtils.optInt(localJsonObject, "type");
          localStickerItem3D.personID = GsonUtils.optInt(localJsonObject, "personID", -1);
          localStickerItem3D.genderType = GsonUtils.optInt(localJsonObject, "genderType", 0);
          if (localStickerItem3D.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localStickerItem3D.featureStatType = GsonUtils.optInt(localJsonObject, "featureStatType");
          localStickerItem3D.frameType = GsonUtils.optInt(localJsonObject, "frameType");
          localStickerItem3D.blendMode = GsonUtils.optInt(localJsonObject, "blendMode", -1);
          localStickerItem3D.zIndex = GsonUtils.optInt(localJsonObject, "zIndex", 0);
          localStickerItem3D.audioLoopCount = GsonUtils.optInt(localJsonObject, "audioLoopCount", -1);
          paramJsonObject = GsonUtils.optJsonObject(localJsonObject, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (paramJsonObject != null)
          {
            localStickerItem3D.charmRange = new CharmRange();
            localStickerItem3D.charmRange.min = GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localStickerItem3D.charmRange.max = GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          if (localStickerItem3D.blendMode == -1) {
            localStickerItem3D.blendMode = paramVideoMaterial.getBlendMode();
          }
          localStickerItem3D.setTriggerType(GsonUtils.optString(localJsonObject, "triggerType"));
          if (VideoMaterialUtil.isActionTriggerType(localStickerItem3D.getTriggerTypeInt())) {
            paramVideoMaterial.setTriggerType(localStickerItem3D.getTriggerTypeInt());
          }
          if (GsonUtils.optInt(localJsonObject, "alwaysTriggered") != 1) {
            break;
          }
          bool = true;
          localStickerItem3D.alwaysTriggered = bool;
          localStickerItem3D.playCount = GsonUtils.optInt(localJsonObject, "playCount");
          localStickerItem3D.externalTriggerWords = GsonUtils.optString(localJsonObject, "externalTriggerWords");
          localObject1 = localStickerItem3D.externalTriggerWords;
          localStickerItem3D.stickerType = GsonUtils.optInt(localJsonObject, "stickerType", 0);
          if ((localStickerItem3D.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (localStickerItem3D.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type))
          {
            if (localStickerItem3D.stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
              break label950;
            }
            paramJsonObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;
            label791:
            localStickerItem3D.sourceType = paramJsonObject;
          }
          localStickerItem3D.width = GsonUtils.optInt(localJsonObject, "width");
          localStickerItem3D.height = GsonUtils.optInt(localJsonObject, "height");
          localStickerItem3D.extraTypeWidth = GsonUtils.optInt(localJsonObject, "extraTypeWidth");
          localStickerItem3D.extarTypeHeight = GsonUtils.optInt(localJsonObject, "extraTypeHeight");
          localStickerItem3D.support3D = GsonUtils.optInt(localJsonObject, "enable3D", 1);
          paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "position");
          if (paramJsonObject == null) {
            break label957;
          }
          localStickerItem3D.position = new double[paramJsonObject.size()];
          j = 0;
          while (j < paramJsonObject.size())
          {
            localStickerItem3D.position[j] = GsonUtils.getDoubleUnsafe(paramJsonObject, j);
            j += 1;
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      LogUtils.e(TAG, paramString);
    }
    label943:
    label950:
    label957:
    int m;
    label1027:
    label1541:
    label1878:
    label1903:
    label2290:
    do
    {
      bool = false;
      break;
      paramJsonObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
      break label791;
      localStickerItem3D.position = new double[] { 0.0D, 0.0D };
      localStickerItem3D.audio = GsonUtils.optString(localJsonObject, "audio");
      if ((!TextUtils.isEmpty(localStickerItem3D.audio)) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("assets://camera/camera_video/video_")) || (paramString.contains("/files/olm/camera/video_")))) {
        break label3413;
      }
      paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "anchorPoint");
      if (paramJsonObject != null)
      {
        localStickerItem3D.anchorPoint = new int[paramJsonObject.size()];
        j = 0;
        while (j < paramJsonObject.size())
        {
          localStickerItem3D.anchorPoint[j] = GsonUtils.getIntUnsafe(paramJsonObject, j);
          j += 1;
        }
      }
      paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "alignFacePoints");
      if (paramJsonObject != null)
      {
        localStickerItem3D.alignFacePoints = new int[paramJsonObject.size()];
        j = 0;
        while (j < paramJsonObject.size())
        {
          localStickerItem3D.alignFacePoints[j] = GsonUtils.getIntUnsafe(paramJsonObject, j);
          j += 1;
        }
      }
      paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "scalePivots");
      if (paramJsonObject != null)
      {
        localStickerItem3D.scalePivots = new int[paramJsonObject.size()];
        j = 0;
        while (j < paramJsonObject.size())
        {
          localStickerItem3D.scalePivots[j] = GsonUtils.getIntUnsafe(paramJsonObject, j);
          j += 1;
        }
      }
      localStickerItem3D.scaleFactor = GsonUtils.optInt(localJsonObject, "scaleFactor");
      localStickerItem3D.markMode = GsonUtils.optInt(localJsonObject, "markMode");
      localStickerItem3D.lazyLoad = GsonUtils.optInt(localJsonObject, "lazyLoadFlag");
      localStickerItem3D.activateTriggerType = GsonUtils.optInt(localJsonObject, "activateTriggerType", 0);
      localStickerItem3D.activateTriggerCount = GsonUtils.optInt(localJsonObject, "activateTriggerCount", 0);
      localStickerItem3D.activateTriggerTotalCount = GsonUtils.optInt(localJsonObject, "activateTriggerTotalCount", 0);
      paramJsonObject = GsonUtils.optJsonObject(localJsonObject, "ageRange");
      if (paramJsonObject != null)
      {
        localStickerItem3D.ageRange = new AgeRange();
        localStickerItem3D.ageRange.min = ((float)GsonUtils.optDouble(paramJsonObject, "min"));
        localStickerItem3D.ageRange.max = ((float)GsonUtils.optDouble(paramJsonObject, "max"));
      }
      paramJsonObject = GsonUtils.optJsonObject(localJsonObject, "genderRange");
      if (paramJsonObject != null)
      {
        localStickerItem3D.genderRange = new GenderRange();
        localStickerItem3D.genderRange.min = ((float)GsonUtils.optDouble(paramJsonObject, "min"));
        localStickerItem3D.genderRange.max = ((float)GsonUtils.optDouble(paramJsonObject, "max"));
      }
      paramJsonObject = GsonUtils.optJsonObject(localJsonObject, "popularRange");
      if (paramJsonObject != null)
      {
        localStickerItem3D.popularRange = new PopularRange();
        localStickerItem3D.popularRange.min = ((float)GsonUtils.optDouble(paramJsonObject, "min"));
        localStickerItem3D.popularRange.max = ((float)GsonUtils.optDouble(paramJsonObject, "max"));
      }
      paramJsonObject = GsonUtils.optJsonObject(localJsonObject, "cpRange");
      if (paramJsonObject != null)
      {
        localStickerItem3D.cpRange = new CpRange();
        localStickerItem3D.cpRange.min = ((float)GsonUtils.optDouble(paramJsonObject, "min"));
        localStickerItem3D.cpRange.max = ((float)GsonUtils.optDouble(paramJsonObject, "max"));
      }
      paramJsonObject = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
      if (paramJsonObject != null)
      {
        WMGroupConfig localWMGroupConfig = new WMGroupConfig();
        j = 0;
        if (j < paramJsonObject.size())
        {
          Object localObject2 = GsonUtils.optJsonObject(paramJsonObject, j);
          if (localObject2 == null) {
            break label3444;
          }
          m = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
          WMElementConfig localWMElementConfig = new WMElementConfig();
          localWMElementConfig.dataPath = paramVideoMaterial.getDataPath();
          localWMElementConfig.sid = paramVideoMaterial.getId();
          localWMElementConfig.id = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
          localWMElementConfig.relativeID = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
          Object localObject3 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
          if ((localObject3 != null) && (((JsonArray)localObject3).size() == 2))
          {
            localWMElementConfig.relativeAnchor = new PointF((float)GsonUtils.getDoubleUnsafe((JsonArray)localObject3, 0), (float)GsonUtils.getDoubleUnsafe((JsonArray)localObject3, 1));
            localObject3 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
            if ((localObject3 == null) || (((JsonArray)localObject3).size() != 2)) {
              break label2614;
            }
          }
          Object localObject4;
          Object localObject5;
          String str1;
          for (localWMElementConfig.anchor = new PointF((float)GsonUtils.getDoubleUnsafe((JsonArray)localObject3, 0), (float)GsonUtils.getDoubleUnsafe((JsonArray)localObject3, 1));; localWMElementConfig.anchor = new PointF(0.0F, 0.0F))
          {
            localWMElementConfig.offsetX = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETX.value);
            localWMElementConfig.offsetY = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETY.value);
            localWMElementConfig.width = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.WIDTH.value);
            localWMElementConfig.height = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.HEIGHT.value);
            localWMElementConfig.wmtype = m;
            localWMElementConfig.edittype = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.EDITTYPE.value);
            localWMElementConfig.fmtstr = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FMTSTR.value);
            localWMElementConfig.fontName = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_NAME.value);
            if (GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_BOLD.value) != 1) {
              break label3420;
            }
            bool = true;
            localWMElementConfig.fontBold = bool;
            if (GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
              break label3426;
            }
            bool = true;
            localWMElementConfig.fontItalics = bool;
            localWMElementConfig.fontTexture = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_TEXTURE.value);
            localWMElementConfig.fontSize = ((float)GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_SIZE.value, 60.0D));
            localWMElementConfig.fontFit = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_FIT.value);
            localWMElementConfig.kern = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.KERN.value);
            localWMElementConfig.imgPath = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.IMG_PATH.value);
            localWMElementConfig.frameDuration = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FRAME_DURATION.value);
            localWMElementConfig.frames = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FRAMES.value);
            localWMElementConfig.color = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
            localWMElementConfig.strokeColor = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
            localWMElementConfig.strokeSize = ((float)GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0D));
            localWMElementConfig.shadowColor = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
            localWMElementConfig.shadowSize = ((float)GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0D));
            localWMElementConfig.shadowDx = ((float)GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DX.value, -1.0D));
            localWMElementConfig.shadowDy = ((float)GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DY.value, -1.0D));
            localWMElementConfig.blurAmount = ((float)GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.BLUR_AMOUNT.value, -1.0D));
            localWMElementConfig.alignment = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.ALIGNMENT.value);
            localWMElementConfig.vertical = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.VERTICAL.value);
            localWMElementConfig.outerStrokeColor = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_COLOR.value, "#FFFFFFFF");
            localWMElementConfig.outerStrokeSize = ((float)GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_SIZE.value, -1.0D));
            localWMElementConfig.shaderBmp = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.SHADER_BMP.value, null);
            if (GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.EMBOSS.value, 0) != 1) {
              break label3432;
            }
            bool = true;
            localWMElementConfig.emboss = bool;
            if (GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.MULTI_ROW.value, 0) != 1) {
              break label3438;
            }
            bool = true;
            localWMElementConfig.multiRow = bool;
            localWMElementConfig.animateType = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
            localWMElementConfig.persistence = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.PERSISTENCE.value);
            localWMElementConfig.numberSource = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.NUMBERSOURCE.value);
            localWMElementConfig.showCaseMin = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.SHOWCASEMIN.value);
            localWMElementConfig.showCaseMax = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.SHOWCASEMAX.value);
            localWMElementConfig.textSource = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.TEXTSOURCE.value);
            localObject3 = GsonUtils.optJsonObject((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
            if (localObject3 == null) {
              break label2744;
            }
            localObject2 = new WMLogic();
            ((WMLogic)localObject2).type = GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
            ((WMLogic)localObject2).setCompare(GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), localWMElementConfig.sid);
            ((WMLogic)localObject2).data = GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
            localObject4 = GsonUtils.optJsonObject((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
            if (localObject4 == null) {
              break label2639;
            }
            ((WMLogic)localObject2).range = new ArrayList();
            localObject5 = ((JsonObject)localObject4).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              str1 = (String)((Iterator)localObject5).next();
              String str2 = GsonUtils.optString((JsonObject)localObject4, str1);
              ((WMLogic)localObject2).range.add(new WMLogicPair(str1, str2));
            }
            localWMElementConfig.relativeAnchor = new PointF(0.0F, 0.0F);
            break;
          }
          Collections.sort(((WMLogic)localObject2).range);
          localObject3 = GsonUtils.optJsonObject((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
          if (localObject3 != null)
          {
            ((WMLogic)localObject2).wmcase = new ArrayList();
            localObject4 = ((JsonObject)localObject3).keySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (String)((Iterator)localObject4).next();
              str1 = GsonUtils.optString((JsonObject)localObject3, (String)localObject5);
              ((WMLogic)localObject2).wmcase.add(new WMLogicPair((String)localObject5, str1));
            }
          }
          localWMElementConfig.logic = ((WMLogic)localObject2);
          localWMGroupConfig.wmElementConfigs.add(localWMElementConfig);
          break label3444;
        }
        localStickerItem3D.wmGroupConfig = localWMGroupConfig;
      }
      localStickerItem3D.preTriggerType = localStickerItem3D.getTriggerTypeInt();
      localStickerItem3D.framePositionsBean = parseFramePosition(paramVideoMaterial, localJsonObject);
      localArrayList.add(localStickerItem3D);
      j = localStickerItem3D.getTriggerTypeInt();
      if (GsonUtils.optInt(localJsonObject, "isElementTriggerMVPart", 0) == 0) {
        break label3410;
      }
      i = localStickerItem3D.getTriggerTypeInt();
      break label3453;
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayOfBoolean = (StickerItem3D)paramString.next();
        if (paramArrayOfBoolean.activateTriggerType == 0)
        {
          paramArrayOfBoolean.countTriggerType = i;
          paramArrayOfBoolean.countExternalTriggerWords = paramJsonObject;
        }
        else
        {
          paramArrayOfBoolean.playCount = 0;
          paramArrayOfBoolean.countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
        }
      }
      paramVideoMaterial.setItemList3D(localArrayList);
      paramVideoMaterial = paramVideoMaterial.getGameParams();
    } while (paramVideoMaterial == null);
    label2316:
    label2614:
    label2639:
    int j = 0;
    label3465:
    for (;;)
    {
      label2744:
      if (j < localArrayList.size())
      {
        paramArrayOfBoolean = (StickerItem3D)localArrayList.get(j);
        i = 0;
        paramJsonObject = "";
        int n;
        float f;
        if ((paramArrayOfBoolean.nodePosition != null) && (paramArrayOfBoolean.nodePosition.length == 3))
        {
          m = 1;
          localObject1 = paramArrayOfBoolean.nodePosition;
          n = localObject1.length;
          k = 0;
          for (;;)
          {
            i = m;
            paramString = paramJsonObject;
            if (k >= n) {
              break;
            }
            f = localObject1[k];
            paramJsonObject = paramJsonObject + f + "/";
            k += 1;
          }
        }
        paramString = "" + "0/0/0/";
        if (paramArrayOfBoolean.id.equals("head")) {
          paramString = paramString + "180/0/0/";
        }
        while ((paramArrayOfBoolean.nodeScale != null) && (paramArrayOfBoolean.nodeScale.length == 3))
        {
          m = 1;
          localObject1 = paramArrayOfBoolean.nodeScale;
          n = localObject1.length;
          i = 0;
          for (;;)
          {
            paramJsonObject = paramString;
            k = m;
            if (i >= n) {
              break;
            }
            f = localObject1[i];
            paramString = paramString + f + "/";
            i += 1;
          }
          if ((paramArrayOfBoolean.nodeEulerAngles != null) && (paramArrayOfBoolean.nodeEulerAngles.length == 3))
          {
            m = 1;
            localObject1 = paramArrayOfBoolean.nodeEulerAngles;
            n = localObject1.length;
            k = 0;
            paramJsonObject = paramString;
            for (;;)
            {
              i = m;
              paramString = paramJsonObject;
              if (k >= n) {
                break;
              }
              f = localObject1[k];
              paramJsonObject = paramJsonObject + f + "/";
              k += 1;
            }
          }
          paramString = paramString + "0/0/0/";
        }
        paramJsonObject = paramString + "1/1/1/";
        k = i;
        if (k != 0)
        {
          paramString = paramArrayOfBoolean.id.split(":");
          paramVideoMaterial.nodeInitialTransform = (paramVideoMaterial.nodeInitialTransform + paramString[0] + "/" + paramJsonObject);
        }
      }
      else
      {
        if (TextUtils.isEmpty(paramVideoMaterial.nodeInitialTransform)) {
          break label943;
        }
        paramVideoMaterial.nodeInitialTransform = paramVideoMaterial.nodeInitialTransform.substring(0, paramVideoMaterial.nodeInitialTransform.length() - 1);
        return;
        label3410:
        label3413:
        label3420:
        label3426:
        label3432:
        label3438:
        label3444:
        label3453:
        do
        {
          i = j;
          break label2827;
          break label3453;
          paramArrayOfBoolean[0] = true;
          break label1027;
          bool = false;
          break label1878;
          bool = false;
          break label1903;
          bool = false;
          break label2290;
          bool = false;
          break label2316;
          j += 1;
          break label1541;
          k += 1;
          paramJsonObject = (JsonObject)localObject1;
          break;
        } while (i <= 0);
        break label2827;
      }
      label2827:
      j += 1;
    }
  }
  
  private static List<AnimationItem> parseAnimationItems(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    ArrayList localArrayList;
    int i;
    int k;
    int j;
    Object localObject3;
    AnimationItem localAnimationItem;
    Object localObject2;
    boolean bool;
    label694:
    int m;
    Object localObject4;
    for (;;)
    {
      try
      {
        JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.ANIMATION__LIST.value);
        new HashMap();
        new HashMap();
        localArrayList = new ArrayList();
        if (localJsonArray != null)
        {
          i = 0;
          paramJsonObject = null;
          k = 0;
          j = 0;
          localObject1 = "";
          if (k >= localJsonArray.size()) {
            break label3659;
          }
          localObject3 = GsonUtils.getJsonObjectUnsafe(localJsonArray, k);
          localAnimationItem = new AnimationItem();
          localAnimationItem.id = GsonUtils.optString((JsonObject)localObject3, "id");
          localAnimationItem.subFolder = localAnimationItem.id;
          localAnimationItem.name = GsonUtils.optString((JsonObject)localObject3, "name");
          localAnimationItem.type = GsonUtils.optInt((JsonObject)localObject3, "type");
          localAnimationItem.scale = ((float)GsonUtils.optDouble((JsonObject)localObject3, "scale", 1.0D));
          localAnimationItem.angle = ((float)GsonUtils.optDouble((JsonObject)localObject3, "angle", 0.0D));
          localAnimationItem.dx = GsonUtils.optInt((JsonObject)localObject3, "dx", 0);
          localAnimationItem.dy = GsonUtils.optInt((JsonObject)localObject3, "dy", 0);
          localAnimationItem.personID = GsonUtils.optInt((JsonObject)localObject3, "personID", -1);
          localAnimationItem.genderType = GsonUtils.optInt((JsonObject)localObject3, "genderType", 0);
          localAnimationItem.alpha = ((float)GsonUtils.optDouble((JsonObject)localObject3, "alpha", 1.0D));
          localAnimationItem.snapshotTime = GsonUtils.optInt((JsonObject)localObject3, "snapshotTime", 0);
          if (localAnimationItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localAnimationItem.featureStatType = GsonUtils.optInt((JsonObject)localObject3, "featureStatType");
          localAnimationItem.frameType = GsonUtils.optInt((JsonObject)localObject3, "frameType");
          localAnimationItem.blendMode = GsonUtils.optInt((JsonObject)localObject3, "blendMode", -1);
          localAnimationItem.zIndex = GsonUtils.optInt((JsonObject)localObject3, "zIndex");
          localAnimationItem.audioLoopCount = GsonUtils.optInt((JsonObject)localObject3, "audioLoopCount", -1);
          localAnimationItem.randomGroupNum = GsonUtils.optInt((JsonObject)localObject3, "randomGroupNum");
          localAnimationItem.externalTriggerWords = GsonUtils.optString((JsonObject)localObject3, "externalTriggerWords");
          localObject2 = localAnimationItem.externalTriggerWords;
          localAnimationItem.triggerState = new ArrayList();
          localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "triggerStateList");
          if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0))
          {
            j = 0;
            if (j < ((JsonArray)localObject1).size())
            {
              localAnimationItem.triggerState.add(GsonUtils.getStringUnsafe((JsonArray)localObject1, j));
              j += 1;
              continue;
            }
          }
          else
          {
            localObject1 = GsonUtils.optString((JsonObject)localObject3, "triggerState");
            if ((localObject1 != null) && (!"".equals(localObject1))) {
              localAnimationItem.triggerState.add(localObject1);
            }
          }
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "triggerStateRange");
          if (localObject1 != null)
          {
            localAnimationItem.triggerStateRange = new StickerItem.ValueRange();
            localAnimationItem.triggerStateRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min", 1.0D);
            localAnimationItem.triggerStateRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max", 0.0D);
          }
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "featureStatValueRange");
          if (localObject1 != null)
          {
            localAnimationItem.featureStatValueRange = new StickerItem.ValueRange();
            localAnimationItem.featureStatValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
            localAnimationItem.featureStatValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
          }
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject1 != null)
          {
            localAnimationItem.charmRange = new CharmRange();
            localAnimationItem.charmRange.min = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localAnimationItem.charmRange.max = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localAnimationItem.setTriggerType(GsonUtils.optString((JsonObject)localObject3, "triggerType"));
          localAnimationItem.audioTriggerType = GsonUtils.optInt((JsonObject)localObject3, "audioTriggerType");
          if (GsonUtils.optInt((JsonObject)localObject3, "audioNeedAdjust", 1) != 1) {
            break label3606;
          }
          bool = true;
          localAnimationItem.audioNeedAdjust = bool;
          if (GsonUtils.optInt((JsonObject)localObject3, "orderMode", 1) == 1)
          {
            localAnimationItem.orderMode = VideoMaterialUtil.STICKER_ORDER_MODE.AFTER_TRANSFORM;
            localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "audioValueRange");
            if (localObject1 != null)
            {
              localAnimationItem.audioValueRange = new StickerItem.ValueRange();
              localAnimationItem.audioValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
              localAnimationItem.audioValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
            }
            if (GsonUtils.optInt((JsonObject)localObject3, "alwaysTriggered") == 1)
            {
              bool = true;
              localAnimationItem.alwaysTriggered = bool;
              localAnimationItem.playCount = GsonUtils.optInt((JsonObject)localObject3, "playCount");
              localAnimationItem.comicOrderMode = GsonUtils.optInt((JsonObject)localObject3, "comicOrderMode", 1);
              localAnimationItem.comicLutFilter = GsonUtils.optString((JsonObject)localObject3, "comicLutFilter");
              localAnimationItem.triggerFrameDurationTime = GsonUtils.optInt((JsonObject)localObject3, "triggerFrameDurationTime");
              localAnimationItem.triggedTimes = GsonUtils.optInt((JsonObject)localObject3, "triggeredTimes");
              localAnimationItem.delayedTriggedTime = GsonUtils.optInt((JsonObject)localObject3, "triggeredDelayTime");
              localAnimationItem.frameDuration = GsonUtils.optDouble((JsonObject)localObject3, "frameDuration");
              localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "triggerFrameStartTime");
              if (localObject1 == null) {
                break label1347;
              }
              m = ((JsonArray)localObject1).size();
              if (m <= 1) {
                break label1333;
              }
              localObject4 = new long[m];
              j = 0;
              if (j >= m) {
                break;
              }
              localObject4[j] = ((GsonUtils.optInt((JsonArray)localObject1, j) * localAnimationItem.frameDuration));
              j += 1;
              continue;
            }
          }
          else
          {
            localAnimationItem.orderMode = VideoMaterialUtil.STICKER_ORDER_MODE.BEFORE_TRANSFORM;
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramVideoMaterial)
      {
        LogUtils.e(TAG, paramVideoMaterial);
      }
      bool = false;
    }
    localAnimationItem.triggerTimeUpdater = new TriggerTimeUpdater((long[])localObject4, (localAnimationItem.delayedTriggedTime * localAnimationItem.frameDuration), (localAnimationItem.triggerFrameDurationTime * localAnimationItem.frameDuration));
    localAnimationItem.triggerFrameStartTime = ((int)(localAnimationItem.triggerTimeUpdater.updateCurTriggerTime(-1L, 0L, false) / localAnimationItem.frameDuration));
    localAnimationItem.stickerType = GsonUtils.optInt((JsonObject)localObject3, "stickerType");
    if ((localAnimationItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (localAnimationItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type)) {
      if (localAnimationItem.stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
        break label1363;
      }
    }
    Object localObject5;
    label1333:
    label1347:
    label1363:
    for (Object localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;; localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT)
    {
      localAnimationItem.sourceType = ((VideoMaterialUtil.ITEM_SOURCE_TYPE)localObject1);
      localAnimationItem.frames = GsonUtils.optInt((JsonObject)localObject3, "frames");
      localAnimationItem.width = GsonUtils.optInt((JsonObject)localObject3, "width");
      localAnimationItem.height = GsonUtils.optInt((JsonObject)localObject3, "height");
      localAnimationItem.extraTypeWidth = GsonUtils.optInt((JsonObject)localObject3, "extraTypeWidth");
      localAnimationItem.extarTypeHeight = GsonUtils.optInt((JsonObject)localObject3, "extraTypeHeight");
      localAnimationItem.maxScaledWidth = GsonUtils.optInt((JsonObject)localObject3, "maxScaledWidth");
      localAnimationItem.minScaledWidth = GsonUtils.optInt((JsonObject)localObject3, "minScaledWidth");
      localAnimationItem.support3D = GsonUtils.optInt((JsonObject)localObject3, "enable3D", 1);
      localAnimationItem.scaleDirection = GsonUtils.optInt((JsonObject)localObject3, "scaleDirection");
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "zoomScale");
      if (localObject1 == null) {
        break label1382;
      }
      localObject4 = ((JsonObject)localObject1).keySet().iterator();
      localAnimationItem.zoomScale = new ArrayList();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        localAnimationItem.zoomScale.add(Pair.create(Float.valueOf((String)localObject5), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject5, 0.0D))));
      }
      localAnimationItem.triggerFrameStartTime = GsonUtils.optInt((JsonArray)localObject1, 0);
      break;
      localAnimationItem.triggerFrameStartTime = GsonUtils.optInt((JsonObject)localObject3, "triggerFrameStartTime");
      break;
    }
    Collections.sort(localAnimationItem.zoomScale, mRangeValueComp);
    label1382:
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "activeParts");
    if (localObject1 != null)
    {
      localAnimationItem.activeParts = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.activeParts[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localAnimationItem.zoomType = GsonUtils.optInt((JsonObject)localObject3, "zoomType");
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "zoomFocusPoint");
    if (localObject1 != null)
    {
      localAnimationItem.zoomFocusPoint = new float[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.zoomFocusPoint[j] = ((float)GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j));
        j += 1;
      }
    }
    localAnimationItem.zoomWidth = ((float)GsonUtils.optDouble((JsonObject)localObject3, "zoomWidth"));
    localAnimationItem.zoomHeight = ((float)GsonUtils.optDouble((JsonObject)localObject3, "zoomHeight"));
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "position");
    if (localObject1 != null)
    {
      localAnimationItem.position = new double[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.position[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localAnimationItem.position = new double[] { 0.0D, 0.0D };
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "rotateType");
    localAnimationItem.rotateType = new int[] { 0, 0 };
    if (localObject1 != null)
    {
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.rotateType[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localAnimationItem.audio = GsonUtils.optString((JsonObject)localObject3, "audio");
    localAnimationItem.lutFilterName = GsonUtils.optString((JsonObject)localObject3, "lutFilterName");
    localAnimationItem.filterOrderMode = GsonUtils.optInt((JsonObject)localObject3, "filterOrderMode", 0);
    localAnimationItem.filterAlphaGradientDuration = GsonUtils.optDouble((JsonObject)localObject3, "filterAlphaGradientDuration", 1.0D);
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "frameSize");
    if (localObject1 != null)
    {
      localAnimationItem.frameSize = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.frameSize[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "anchorPoint");
    if (localObject1 != null)
    {
      localAnimationItem.anchorPoint = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.anchorPoint[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "anchorPointAudio");
    if (localObject1 != null)
    {
      localAnimationItem.anchorPointAudio = new double[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.anchorPointAudio[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localAnimationItem.anchorPointAudio = new double[] { 0.5D, 0.5D };
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "alignFacePoints");
    if (localObject1 != null)
    {
      localAnimationItem.alignFacePoints = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.alignFacePoints[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "scalePivots");
    if (localObject1 != null)
    {
      localAnimationItem.scalePivots = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localAnimationItem.scalePivots[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localAnimationItem.scaleFactor = GsonUtils.optInt((JsonObject)localObject3, "scaleFactor");
    localAnimationItem.originalScaleFactor = localAnimationItem.scaleFactor;
    localAnimationItem.markMode = GsonUtils.optInt((JsonObject)localObject3, "markMode");
    localAnimationItem.lazyLoad = GsonUtils.optInt((JsonObject)localObject3, "lazyLoadFlag");
    localAnimationItem.activateTriggerType = GsonUtils.optInt((JsonObject)localObject3, "activateTriggerType", 0);
    localAnimationItem.activateTriggerCount = GsonUtils.optInt((JsonObject)localObject3, "activateTriggerCount", 0);
    localAnimationItem.activateTriggerTotalCount = GsonUtils.optInt((JsonObject)localObject3, "activateTriggerTotalCount", 0);
    localAnimationItem.lockTriggerCountUntilFail = GsonUtils.optInt((JsonObject)localObject3, "lockTriggerCountUntilFail", 0);
    localAnimationItem.bodyTriggerPoint = GsonUtils.optInt((JsonObject)localObject3, "bodyTriggerPoint", 0);
    localAnimationItem.bodyTriggerDirection = GsonUtils.optInt((JsonObject)localObject3, "bodyTriggerDirection", 0);
    localAnimationItem.bodyTriggerDistance = GsonUtils.optInt((JsonObject)localObject3, "bodyTriggerDistance", 0);
    localAnimationItem.bodyTriggerTimeGap = GsonUtils.optDouble((JsonObject)localObject3, "bodyTriggerTimeGap", 0.0D);
    localAnimationItem.relativeScaleType = GsonUtils.optInt((JsonObject)localObject3, "relativeScaleType");
    label2229:
    label2682:
    int n;
    if (GsonUtils.optInt((JsonObject)localObject3, "orienting") == 1)
    {
      bool = true;
      localAnimationItem.orienting = bool;
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "ageRange");
      if (localObject1 != null)
      {
        localAnimationItem.ageRange = new AgeRange();
        localAnimationItem.ageRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.ageRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "genderRange");
      if (localObject1 != null)
      {
        localAnimationItem.genderRange = new GenderRange();
        localAnimationItem.genderRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.genderRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "popularRange");
      if (localObject1 != null)
      {
        localAnimationItem.popularRange = new PopularRange();
        localAnimationItem.popularRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.popularRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "cpRange");
      if (localObject1 != null)
      {
        localAnimationItem.cpRange = new CpRange();
        localAnimationItem.cpRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.cpRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "audioScaleFactor");
      if (localObject1 != null)
      {
        localObject4 = ((JsonObject)localObject1).keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          localAnimationItem.audioScaleFactorMap.add(Pair.create(Float.valueOf((String)localObject5), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject5, 0.0D))));
        }
      }
      Collections.sort(localAnimationItem.audioScaleFactorMap, mRangeValueComp);
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject3, "transition");
      if (localObject1 != null)
      {
        localAnimationItem.transition = new Transition();
        localAnimationItem.transition.particleCountMax = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_COUNT_MAX.value);
        localAnimationItem.transition.life = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.LIFE.value);
        localAnimationItem.transition.emissionMode = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.EMISSION_MODE.value);
        localObject4 = localAnimationItem.transition;
        if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_ALWAYS_UPDATE.value) != 1) {
          break label3618;
        }
        bool = true;
        ((Transition)localObject4).particleAlwaysUpdate = bool;
        localAnimationItem.transition.emissionRate = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.EMISSION_RATE.value);
        localAnimationItem.transition.scale = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.SCALE.value);
        localAnimationItem.transition.rotate = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.ROTATE.value);
        localAnimationItem.transition.positionX = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.POSITION_X.value);
        localAnimationItem.transition.positionY = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.POSITION_Y.value);
        localAnimationItem.transition.p0 = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.P0.value);
        localAnimationItem.transition.p1 = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.P1.value);
        localAnimationItem.transition.p2 = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.P2.value);
        localAnimationItem.transition.repeatCount = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.REPEAT_COUNT.value, 1);
        localAnimationItem.transition.minUpdateInterval = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.MIN_UPDATE_INTERVAL.value, 1);
        localAnimationItem.transition.clearMode = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.CLEAR_MODE.value, 0);
      }
      localAnimationItem.triggerWords = GsonUtils.optString((JsonObject)localObject3, "triggerWords");
      localAnimationItem.preTriggerType = localAnimationItem.getTriggerTypeInt();
      localAnimationItem.dexName = GsonUtils.optString((JsonObject)localObject3, "dexName");
      localArrayList.add(localAnimationItem);
      n = localAnimationItem.getTriggerTypeInt();
      if (GsonUtils.optInt((JsonObject)localObject3, "isElementTriggerMVPart", 0) != 0) {
        i = localAnimationItem.getTriggerTypeInt();
      }
      if (GsonUtils.optInt((JsonObject)localObject3, "followPhoneAngle", 0) != 1) {
        break label3624;
      }
      bool = true;
      label2989:
      localAnimationItem.followPhoneAngle = bool;
      localAnimationItem.strokeType = GsonUtils.optInt((JsonObject)localObject3, "strokeType", 0);
      localAnimationItem.strokeStyle = GsonUtils.optInt((JsonObject)localObject3, "strokeStyle", 0);
      localAnimationItem.strokeColor = StrokeUtil.parseRGBAColor(GsonUtils.optString((JsonObject)localObject3, "strokeColor", ""));
      localAnimationItem.strokeWidth = GsonUtils.optDouble((JsonObject)localObject3, "strokeWidth", 0.0D);
      localAnimationItem.strokeGap = GsonUtils.optDouble((JsonObject)localObject3, "strokeGap", 0.0D);
      if (GsonUtils.optInt((JsonObject)localObject3, "isStrokeBlur", 0) != 1) {
        break label3630;
      }
      bool = true;
      label3087:
      localAnimationItem.isStrokeBlur = bool;
      localAnimationItem.hairLutName = GsonUtils.optString((JsonObject)localObject3, "hairLutName");
      localAnimationItem.hairMaskType = Integer.valueOf(GsonUtils.optInt((JsonObject)localObject3, "hairMaskType", 0));
      localAnimationItem.needCrop = GsonUtils.optInt((JsonObject)localObject3, "needCrop", 0);
      localAnimationItem.maskType = GsonUtils.optString((JsonObject)localObject3, "maskType");
      localAnimationItem.maskLut = GsonUtils.optString((JsonObject)localObject3, "maskLut");
      localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "hotArea");
      if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0))
      {
        localAnimationItem.hotArea = new double[((JsonArray)localObject1).size()];
        j = 0;
        while (j < ((JsonArray)localObject1).size())
        {
          localAnimationItem.hotArea[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
          j += 1;
        }
      }
      localAnimationItem.redPacketStartFrame = GsonUtils.optInt((JsonObject)localObject3, "hotAreaStartFrame");
      localAnimationItem.redPacketEndFrame = GsonUtils.optInt((JsonObject)localObject3, "hotAreaEndFrame");
      localAnimationItem.activateTriggerCountOnce = GsonUtils.optInt((JsonObject)localObject3, "activateTriggerCountOnce");
      localAnimationItem.triggerHandPoint = GsonUtils.optInt((JsonObject)localObject3, "triggerHandPoint");
      localObject1 = GsonUtils.optJsonArray((JsonObject)localObject3, "triggerAreas");
      if (localObject1 != null)
      {
        localAnimationItem.triggerArea = new ArrayList();
        j = 0;
        label3311:
        if (j < ((JsonArray)localObject1).size())
        {
          localObject3 = new StickerItem.TriggerArea();
          localObject4 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
          if (localObject4 == null) {
            break label3636;
          }
          ((StickerItem.TriggerArea)localObject3).type = GsonUtils.optInt((JsonObject)localObject4, "type");
          localObject5 = GsonUtils.optJsonArray((JsonObject)localObject4, "rect");
          if (localObject5 != null)
          {
            ((StickerItem.TriggerArea)localObject3).rect = new float[((JsonArray)localObject5).size()];
            m = 0;
            while (m < ((JsonArray)localObject5).size())
            {
              ((StickerItem.TriggerArea)localObject3).rect[m] = GsonUtils.getFloatSafe((JsonArray)localObject5, m);
              m += 1;
            }
          }
          localObject4 = GsonUtils.optJsonArray((JsonObject)localObject4, "anchorPoints");
          if (localObject4 != null)
          {
            ((StickerItem.TriggerArea)localObject3).anchorPoint = new int[((JsonArray)localObject4).size()];
            m = 0;
            while (m < ((JsonArray)localObject4).size())
            {
              ((StickerItem.TriggerArea)localObject3).anchorPoint[m] = GsonUtils.getIntUnsafe((JsonArray)localObject4, m);
              m += 1;
            }
          }
          localAnimationItem.triggerArea.add(localObject3);
          break label3636;
        }
        if (localAnimationItem.triggerArea.size() > 0)
        {
          paramJsonObject = localAnimationItem.triggerArea;
          break label3643;
        }
      }
    }
    for (;;)
    {
      label3517:
      paramVideoMaterial = localArrayList.iterator();
      while (paramVideoMaterial.hasNext())
      {
        localObject2 = (StickerItem)paramVideoMaterial.next();
        if (((StickerItem)localObject2).activateTriggerType == 0)
        {
          ((StickerItem)localObject2).countTriggerType = i;
          ((StickerItem)localObject2).activateTriggerArea = paramJsonObject;
          ((StickerItem)localObject2).countExternalTriggerWords = ((String)localObject1);
        }
        else
        {
          ((StickerItem)localObject2).playCount = 0;
          ((StickerItem)localObject2).countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
        }
      }
      return localArrayList;
      label3606:
      label3618:
      label3624:
      label3630:
      label3636:
      label3643:
      label3659:
      do
      {
        i = j;
        break label3517;
        break label3643;
        bool = false;
        break label694;
        bool = false;
        break label2229;
        bool = false;
        break label2682;
        bool = false;
        break label2989;
        bool = false;
        break label3087;
        j += 1;
        break label3311;
        k += 1;
        j = n;
        localObject1 = localObject2;
        break;
      } while (i <= 0);
    }
  }
  
  private static void parseAnimojiParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    GameParams localGameParams = new GameParams();
    localGameParams.mGameName = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GAME_FIELD.GAME_NAME.value);
    localGameParams.fov = ((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.GAME_FIELD.FOV.value, 60.0D));
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0)
    {
      bool1 = true;
      localGameParams.flattenEar = bool1;
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
        break label101;
      }
    }
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localGameParams.flattenNose = bool1;
      paramVideoMaterial.setGameParams(localGameParams);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void parseArParticleListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramVideoMaterial.setArParticleType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.AR_PARTICLE_TYPE.value));
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.AR_PARTICLE_LIST.value);
    if (paramJsonObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJsonObject.size())
      {
        String str = GsonUtils.optString(paramJsonObject, i);
        if (str != null) {
          localArrayList.add(str);
        }
        i += 1;
      }
      paramVideoMaterial.setArParticleList(localArrayList);
    }
  }
  
  private static void parseAudio2TextParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.FIELD.AUDIO_2_TEXT.value);
    if (paramJsonObject != null)
    {
      Audio2Text localAudio2Text = new Audio2Text();
      localAudio2Text.sentenceCount = GsonUtils.optInt(paramJsonObject, "sentenceCount", 0);
      localAudio2Text.sentenceMode = GsonUtils.optInt(paramJsonObject, "sentenceMode", 0);
      localAudio2Text.silenceTime = GsonUtils.optDouble(paramJsonObject, "silenceTime", 0.0D);
      localAudio2Text.segmentCount = GsonUtils.optInt(paramJsonObject, "segmentCount", 0);
      localAudio2Text.segmentTime = GsonUtils.optDouble(paramJsonObject, "segmentTime", 0.0D);
      localAudio2Text.triggerWords = GsonUtils.optString(paramJsonObject, "triggerWords", null);
      paramVideoMaterial.setAudio2Text(localAudio2Text);
    }
  }
  
  private static void parseAudio3DParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    GameParams localGameParams = new GameParams();
    localGameParams.mGameName = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GAME_FIELD.GAME_NAME.value);
    localGameParams.fov = ((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.GAME_FIELD.FOV.value, 60.0D));
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0)
    {
      bool1 = true;
      localGameParams.flattenEar = bool1;
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
        break label101;
      }
    }
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localGameParams.flattenNose = bool1;
      paramVideoMaterial.setAudio3DParams(localGameParams);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void parseBasicParams(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramVideoMaterial.setId(VideoMaterialUtil.getMaterialId(paramString));
    paramVideoMaterial.setShaderType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.SHADER_TYPE.value));
    paramVideoMaterial.setMaxFaceCount(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
    paramVideoMaterial.setBlendMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.BLEND_MODE.value));
    paramVideoMaterial.setFilterId(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.FILTER_ID.value));
    paramVideoMaterial.setFilterBlurStrength(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.FIELD.FILTER_BLUR_STRENGTH.value, 0.0D));
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.SUPPORT_LANDSCAPE.value, 1) == 1)
    {
      bool = true;
      paramVideoMaterial.setSupportLandscape(bool);
      paramVideoMaterial.setRandomGroupCount(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.RANDOM_GROUP_COUNT.value));
      paramVideoMaterial.setTipsText(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.TIPS_TEXT.value));
      paramVideoMaterial.setTipsIcon(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.TIPS_ICON.value));
      paramVideoMaterial.setHandBoostEnable(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.HAND_BOOST_ENABLE.value));
      paramVideoMaterial.setDetectorFlag(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.DETECTOR_FLAG.value));
      paramVideoMaterial.setTouchFlag(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.TOUCH_FLAG.value, 0));
      paramVideoMaterial.setStateVersion(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.STATE_VERSION.value, 1));
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.USE_MESH.value, 0) == 0) {
        break label788;
      }
      bool = true;
      label217:
      paramVideoMaterial.setUseMesh(bool);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.RESET_WHEN_START_RECORD.value, 0) != 1) {
        break label793;
      }
      bool = true;
      label239:
      paramVideoMaterial.setResetWhenStartRecord(bool);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.SUPPORT_PAUSE.value, 0) != 1) {
        break label798;
      }
      bool = true;
      label261:
      paramVideoMaterial.setSupportPause(bool);
      paramVideoMaterial.setVoicekind(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.VOICE_KIND.value, -999999));
      paramVideoMaterial.setEnvironment(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.ENVIRONMENT.value, -999999));
      paramVideoMaterial.setFaceExchangeImage(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE_FULL_FACE.value, 0) != 1) {
        break label803;
      }
      bool = true;
      label331:
      paramVideoMaterial.setFaceExchangeImageFullFace(bool);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE_DISABLE_OPACITY.value, 0) != 1) {
        break label808;
      }
    }
    label788:
    label793:
    label798:
    label803:
    label808:
    for (boolean bool = true;; bool = false)
    {
      paramVideoMaterial.setFaceExchangeImageDisableOpacity(bool);
      paramVideoMaterial.setCosmeticShelterSwitchClose(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.COSMETIC_SHELTER_SWITCH_CLOSE.value));
      paramVideoMaterial.setCosmeticChangeSwitch(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.COSMETIC_CHANGE_SWITCH.value));
      paramVideoMaterial.setCosmeticChangeMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.COSMETIC_CHANGE_MODE.value));
      paramVideoMaterial.setFaceoffType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FACE_OFF_TYPE.value));
      paramVideoMaterial.setFaceSwapType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FACE_SWAP_TYPE.value));
      paramVideoMaterial.setImageFacePointsFileName(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
      paramVideoMaterial.setBlendAlpha(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.FIELD.BLEND_ALPHA.value));
      paramVideoMaterial.setGrayScale(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.GRAY_SCALE.value));
      paramVideoMaterial.setFeatureType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FEATURE_TYPE.value));
      if (!TextUtils.isEmpty(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.AD_ICON.value))) {
        paramVideoMaterial.setAdIcon(paramString + File.separator + GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.AD_ICON.value));
      }
      paramVideoMaterial.setAdLink(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.AD_LINK.value));
      paramVideoMaterial.setAdAppLink(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.AD_APP_LINK.value));
      paramVideoMaterial.setWeiboTag(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.WEIBO_TAG.value));
      paramVideoMaterial.setLipsLutPath(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.LIPS_LUT.value));
      paramVideoMaterial.setLipsLutStyleMaskPath(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.LIPS_STYLE_MASK.value, null));
      paramVideoMaterial.setLipsSegType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.LIPS_SEG_TYPE.value, 0));
      paramVideoMaterial.setSplitScreen((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.FIELD.SPLIT_SCREEN.value, 0.0D));
      paramVideoMaterial.setMaskType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MASK_TYPE.value, 1));
      paramVideoMaterial.setMaskPaintType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MASK_PAINT_TYPE.value, 0));
      paramVideoMaterial.setMaskPaintSize(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MASK_PAINT_SIZE.value));
      paramVideoMaterial.setMaskPaintImage(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.MASK_PAINT_IMAGE.value));
      paramVideoMaterial.setMaskPaintRenderId(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MASK_PAINT_RENDER_ID.value));
      paramVideoMaterial.setPreferCameraId(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.PREFER_CAMERA_ID.value));
      paramVideoMaterial.setMinAppVersion(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
      paramVideoMaterial.setCategoryFlag(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.CATEGORY_FLAG.value, 0));
      paramVideoMaterial.setOrderMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.ORDER_MODE.value));
      paramVideoMaterial.setStickerOrderMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.STICKER_ORDER_MODE.value));
      return;
      bool = false;
      break;
      bool = false;
      break label217;
      bool = false;
      break label239;
      bool = false;
      break label261;
      bool = false;
      break label331;
    }
  }
  
  public static void parseBigHeadAnimationMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    int i = 0;
    if (paramJsonObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = GsonUtils.optJsonObject(paramJsonObject, "bigHead");
        if (localObject == null) {
          break;
        }
        paramJsonObject = new BigAnimationParam();
        paramJsonObject.repeatCount = GsonUtils.optInt((JsonObject)localObject, "repeatCount", 0);
        paramJsonObject.tipsText = GsonUtils.optString((JsonObject)localObject, "tips", "");
        localObject = GsonUtils.optJsonArray((JsonObject)localObject, "animation");
        if ((localObject != null) && (((JsonArray)localObject).size() > 0))
        {
          paramJsonObject.animation = new ArrayList();
          if (i < ((JsonArray)localObject).size())
          {
            JsonObject localJsonObject = GsonUtils.optJsonObject((JsonArray)localObject, i);
            if (localJsonObject == null) {
              break label250;
            }
            BigItem localBigItem = new BigItem();
            localBigItem.beginTime = GsonUtils.optLong(localJsonObject, "beginTime", 0L);
            localBigItem.endTime = GsonUtils.optLong(localJsonObject, "endTime", 0L);
            localBigItem.beginScale = ((float)GsonUtils.optDouble(localJsonObject, "beginScale", 1.0D));
            localBigItem.endScale = ((float)GsonUtils.optDouble(localJsonObject, "endScale", 1.0D));
            if ((localBigItem.beginScale < 1.0F) || (localBigItem.beginScale > 2.0F)) {
              localBigItem.beginScale = 1.0F;
            }
            if ((localBigItem.endScale < 1.0F) || (localBigItem.endScale > 2.0F)) {
              localBigItem.endScale = 1.0F;
            }
            paramJsonObject.animation.add(localBigItem);
            break label250;
          }
        }
        paramVideoMaterial.mBigHeadParam = paramJsonObject;
        return;
      }
      catch (Exception paramVideoMaterial)
      {
        paramVideoMaterial = paramVideoMaterial;
        paramVideoMaterial.printStackTrace();
        return;
      }
      finally {}
      label250:
      i += 1;
    }
  }
  
  private static BloomParam parseBloomParam(JsonObject paramJsonObject)
  {
    if (GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.GLB_FIELD.BLOOM.value) == null) {
      return null;
    }
    return new BloomParam();
  }
  
  private static BlurEffectItem parseBlurItem(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    parseImageMaskItemListParams(paramJsonObject, paramVideoMaterial);
    parseFaceMaskItemListParams(paramJsonObject, paramVideoMaterial);
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, "blurEffect");
    if (paramJsonObject == null)
    {
      paramVideoMaterial.setBlurEffectItem(null);
      return null;
    }
    BlurEffectItem localBlurEffectItem = new BlurEffectItem();
    localBlurEffectItem.setBlurType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.BLUR_EFFECT_ITEM_FIELD.BLUR_TYPE.value));
    localBlurEffectItem.setBlurStrength(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.BLUR_EFFECT_ITEM_FIELD.BLUR_STRENGTH.value));
    localBlurEffectItem.setRenderOrder(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.BLUR_EFFECT_ITEM_FIELD.RENDER_ORDER.value));
    localBlurEffectItem.setMaskType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.BLUR_EFFECT_ITEM_FIELD.MASK_TYPE.value));
    localBlurEffectItem.setImageMaskId(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.BLUR_EFFECT_ITEM_FIELD.IMAGE_MASK_ID.value));
    localBlurEffectItem.setImageMaskItem(paramVideoMaterial.getImageMaskItemById(localBlurEffectItem.getImageMaskId()));
    localBlurEffectItem.setFaceMaskItem(paramVideoMaterial.getFaceMaskItemById(localBlurEffectItem.getImageMaskId()));
    paramVideoMaterial.setBlurEffectItem(localBlurEffectItem);
    return localBlurEffectItem;
  }
  
  private static VideoMaterial parseBuckleFaceMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {}
    for (;;)
    {
      return paramVideoMaterial;
      try
      {
        Object localObject1 = GsonUtils.optJsonObject(paramJsonObject, "videoFaceCrop");
        if (localObject1 != null)
        {
          paramJsonObject = new BuckleFaceItem();
          paramJsonObject.frameDuration = GsonUtils.optInt((JsonObject)localObject1, "frameDuration", 0);
          paramJsonObject.frames = GsonUtils.optInt((JsonObject)localObject1, "frames", 0);
          localObject1 = GsonUtils.optJsonArray((JsonObject)localObject1, "frameList");
          int i = 0;
          while (i < ((JsonArray)localObject1).size())
          {
            Object localObject2 = GsonUtils.getJsonObjectUnsafe((JsonArray)localObject1, i);
            BuckleFrameItem localBuckleFrameItem = new BuckleFrameItem();
            localBuckleFrameItem.faceAngle = GsonUtils.optDouble((JsonObject)localObject2, "faceAngle", 0.0D);
            localBuckleFrameItem.faceWidth = GsonUtils.optDouble((JsonObject)localObject2, "faceWidth", 0.0D);
            localBuckleFrameItem.index = GsonUtils.optInt((JsonObject)localObject2, "index", 0);
            JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, "nosePoint");
            int j;
            if (localJsonArray != null)
            {
              localBuckleFrameItem.nosePoint = new double[localJsonArray.size()];
              j = 0;
              while (j < localJsonArray.size())
              {
                localBuckleFrameItem.nosePoint[j] = GsonUtils.optDouble(localJsonArray, j, 0.0D);
                j += 1;
              }
            }
            localBuckleFrameItem.nosePoint = new double[] { 0.0D, 0.0D };
            localObject2 = GsonUtils.optJsonArray((JsonObject)localObject2, "size");
            if (localObject2 != null)
            {
              localBuckleFrameItem.size = new double[((JsonArray)localObject2).size()];
              j = 0;
              while (j < ((JsonArray)localObject2).size())
              {
                localBuckleFrameItem.size[j] = GsonUtils.optDouble((JsonArray)localObject2, j, 0.0D);
                j += 1;
              }
            }
            localBuckleFrameItem.size = new double[] { 0.0D, 0.0D };
            paramJsonObject.frameList.add(localBuckleFrameItem);
            i += 1;
          }
          paramVideoMaterial.videoFaceCrop = paramJsonObject;
          return paramVideoMaterial;
        }
      }
      catch (Exception paramJsonObject)
      {
        paramJsonObject.printStackTrace();
      }
    }
    return paramVideoMaterial;
  }
  
  private static CharmRange parseCharmRange(JsonObject paramJsonObject)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, "charmRange");
    if (paramJsonObject == null) {
      return null;
    }
    CharmRange localCharmRange = new CharmRange();
    localCharmRange.min = GsonUtils.optFloat(paramJsonObject, "min", 0.0F);
    localCharmRange.max = GsonUtils.optFloat(paramJsonObject, "max", 0.0F);
    return localCharmRange;
  }
  
  private static void parseCosFunParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    Object localObject1 = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.COS_FUN.value);
    if (localObject1 == null) {
      return;
    }
    paramJsonObject = new CosFun();
    paramJsonObject.setTipsAnim(GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM.value));
    paramJsonObject.setTipsAnimFrames(GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAMES.value));
    paramJsonObject.setTipsAnimFrameDuration(GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAME_DURATION.value));
    paramJsonObject.setStartInterval(GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.START_INTERVAL.value));
    if (paramJsonObject.getTipsAnim() != null) {
      paramVideoMaterial.createTipsDrawableInfo(AEModule.getContext().getResources(), paramVideoMaterial.getDataPath(), paramJsonObject.getTipsAnim(), paramJsonObject.getTipsAnimFrameDuration(), paramJsonObject.getTipsAnimFrames());
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.COS_FUN_GROUP.value);
    ArrayList localArrayList1 = new ArrayList();
    if (localObject1 != null)
    {
      int i = 0;
      if (i < ((JsonArray)localObject1).size())
      {
        Object localObject2 = GsonUtils.optJsonObject((JsonArray)localObject1, i);
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramJsonObject.setTipsAnim(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM.value));
          paramJsonObject.setTipsAnimFrames(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAMES.value));
          paramJsonObject.setTipsAnimFrameDuration(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAME_DURATION.value));
          paramJsonObject.setStartInterval(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_FIELD.START_INTERVAL.value));
          paramVideoMaterial.createTipsDrawableInfo(AEModule.getContext().getResources(), paramVideoMaterial.getDataPath(), paramJsonObject.getTipsAnim(), paramJsonObject.getTipsAnimFrameDuration(), paramJsonObject.getTipsAnimFrames());
          CosFun.CosFunGroupItem localCosFunGroupItem = new CosFun.CosFunGroupItem();
          localCosFunGroupItem.setLoopMode(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.LOOP_MODE.value));
          ArrayList localArrayList2 = new ArrayList();
          localObject2 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS.value);
          if (localObject2 != null)
          {
            int j = 0;
            if (j < ((JsonArray)localObject2).size())
            {
              Object localObject3 = GsonUtils.optJsonObject((JsonArray)localObject2, j);
              if (localObject3 == null) {}
              for (;;)
              {
                j += 1;
                break;
                CosFun.CosFunItem localCosFunItem = new CosFun.CosFunItem();
                localCosFunItem.setId(GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_ID.value));
                localCosFunItem.setTriggerType(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRIGGER_TYPE.value));
                localCosFunItem.setExternalTriggerWords(GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_EXTERNAL_TRIGGER_WORDS.value));
                localCosFunItem.setDuration(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_DURATION.value));
                localCosFunItem.setFreezeStart(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_FREEZE_START.value));
                localCosFunItem.setFreezeDuration(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_FREEZE_DURATION.value));
                localCosFunItem.setTransStart(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_START.value));
                localCosFunItem.setTransDuration(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_DURATION.value));
                localCosFunItem.setTransReverseStart(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_REVERSE_START.value));
                localCosFunItem.setTransReverseDuration(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_REVERSE_DURATION.value));
                localCosFunItem.setWaitInterval(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_WAIT_INTERVAL.value));
                localCosFunItem.setCrazyFacePath(GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_CRAZY_FACE_PATH.value));
                localCosFunItem.setBackgroundMode1(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_BACKGROUND_MODE1.value));
                localCosFunItem.setBackgroundMode2(GsonUtils.optInt((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_BACKGROUND_MODE2.value));
                localCosFunItem.setPagPath(GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_PAG_PATH.value));
                Object localObject4 = GsonUtils.optJsonObject((JsonObject)localObject3, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_PAG_INDEX_LIST.value);
                localObject3 = new CosFun.PagIndexList();
                ArrayList localArrayList3 = new ArrayList();
                localObject4 = GsonUtils.optJsonArray((JsonObject)localObject4, VideoMaterialUtil.PAG_INDEX_LIST.COS_FUN.value);
                int k = 0;
                while (k < ((JsonArray)localObject4).size())
                {
                  localArrayList3.add(Integer.valueOf(GsonUtils.optInt((JsonArray)localObject4, k)));
                  k += 1;
                }
                ((CosFun.PagIndexList)localObject3).setCosFun(localArrayList3);
                localCosFunItem.setPagIndexList((CosFun.PagIndexList)localObject3);
                localArrayList2.add(localCosFunItem);
              }
            }
            localCosFunGroupItem.setCosFunItems(localArrayList2);
            localArrayList1.add(localCosFunGroupItem);
          }
        }
      }
    }
    paramJsonObject.setCosFunGroupItem(localArrayList1);
    paramVideoMaterial.setCosFun(paramJsonObject);
  }
  
  private static void parseDependenciesParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.DEPENDENCY_LIST.value);
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        localArrayList.add(GsonUtils.optString(paramJsonObject, i));
        i += 1;
      }
      paramVideoMaterial.setDependencies(localArrayList);
    }
  }
  
  private static List<DistortionItem> parseDistortionItemListParams(JsonArray paramJsonArray)
  {
    Object localObject;
    if (paramJsonArray != null) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= paramJsonArray.size()) {
            break;
          }
          localObject = new DistortionItem();
          JsonObject localJsonObject = GsonUtils.getJsonObjectUnsafe(paramJsonArray, i);
          ((DistortionItem)localObject).position = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
          ((DistortionItem)localObject).distortion = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
          ((DistortionItem)localObject).direction = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
          ((DistortionItem)localObject).radius = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
          ((DistortionItem)localObject).strength = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
          ((DistortionItem)localObject).x = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
          ((DistortionItem)localObject).y = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
          localArrayList.add(localObject);
          i += 1;
        }
        localObject = null;
      }
      catch (Exception paramJsonArray)
      {
        LogUtils.e(TAG, paramJsonArray);
      }
    }
    return localObject;
  }
  
  public static VideoMaterial parseDoodleMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {}
    for (;;)
    {
      return paramVideoMaterial;
      try
      {
        paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, "doodleImage");
        if (paramJsonObject != null)
        {
          DoodleItem localDoodleItem = new DoodleItem();
          localDoodleItem.count = GsonUtils.optInt(paramJsonObject, "count");
          localDoodleItem.width = GsonUtils.optInt(paramJsonObject, "width");
          localDoodleItem.height = GsonUtils.optInt(paramJsonObject, "height");
          localDoodleItem.extraTypeWidth = GsonUtils.optInt(paramJsonObject, "extraTypeWidth");
          localDoodleItem.extarTypeHeight = GsonUtils.optInt(paramJsonObject, "extraTypeHeight");
          paramVideoMaterial.setDoodleItem(localDoodleItem);
          return paramVideoMaterial;
        }
      }
      catch (Throwable paramJsonObject)
      {
        paramJsonObject = paramJsonObject;
        LogUtils.w(TAG, "parseDoodleMaterial");
        return paramVideoMaterial;
      }
      finally {}
    }
    return paramVideoMaterial;
  }
  
  private static List<DynamicBoneItem> parseDynamicBoneItems(JsonObject paramJsonObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.DYNAMICBONE_LIST.value);
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localObject != null)
        {
          DynamicBoneItem localDynamicBoneItem = new DynamicBoneItem();
          localDynamicBoneItem.rootNames = Arrays.asList(GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ROOTNAME.value, "").split(";"));
          localDynamicBoneItem.boneCount = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.BONE_COUNT.value, 0);
          boolean bool;
          int j;
          HashMap localHashMap;
          JsonObject localJsonObject;
          Iterator localIterator;
          String str;
          if (GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.NO_ROTATE_UPDATE.value, 0) != 0)
          {
            bool = true;
            localDynamicBoneItem.noRotateUpdate = bool;
            localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.BONE_PARAM_LIST.value);
            localArrayList2 = new ArrayList();
            if (localJsonArray != null) {
              j = 0;
            }
          }
          else
          {
            for (;;)
            {
              if (j >= localJsonArray.size()) {
                break label254;
              }
              localHashMap = new HashMap();
              localJsonObject = GsonUtils.optJsonObject(localJsonArray, j);
              localIterator = localJsonObject.keySet().iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  str = (String)localIterator.next();
                  localHashMap.put(str, GsonUtils.optString(localJsonObject, str));
                  continue;
                  bool = false;
                  break;
                }
              }
              localArrayList2.add(localHashMap);
              j += 1;
            }
          }
          label254:
          localDynamicBoneItem.boneParamsList = localArrayList2;
          JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.COLLIDER_LIST.value);
          ArrayList localArrayList2 = new ArrayList();
          if (localJsonArray != null)
          {
            j = 0;
            while (j < localJsonArray.size())
            {
              localHashMap = new HashMap();
              localJsonObject = GsonUtils.optJsonObject(localJsonArray, j);
              localIterator = localJsonObject.keySet().iterator();
              while (localIterator.hasNext())
              {
                str = (String)localIterator.next();
                localHashMap.put(str, GsonUtils.optString(localJsonObject, str));
              }
              localArrayList2.add(localHashMap);
              j += 1;
            }
          }
          if (localArrayList2.isEmpty())
          {
            localArrayList2.add(new VideoTemplateParser.2());
            localArrayList2.add(new VideoTemplateParser.3());
            localArrayList2.add(new VideoTemplateParser.4());
            localArrayList2.add(new VideoTemplateParser.5());
            localArrayList2.add(new VideoTemplateParser.6());
          }
          localDynamicBoneItem.colliderList = localArrayList2;
          localObject = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.GRAVITY.value);
          if (localObject != null)
          {
            j = 0;
            while ((j < ((JsonArray)localObject).size()) && (j < 3))
            {
              localDynamicBoneItem.gravity[j] = ((float)GsonUtils.optDouble((JsonArray)localObject, j));
              j += 1;
            }
          }
          localArrayList1.add(localDynamicBoneItem);
        }
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  private static List<AnimojiExpressionJava> parseExpressionList(JsonObject paramJsonObject)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.EXPRESSION_CONFIG_LIST.value);
    for (;;)
    {
      if ((paramJsonObject != null) && (i < paramJsonObject.size()))
      {
        Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
        AnimojiExpressionJava localAnimojiExpressionJava;
        if (localObject != null)
        {
          localAnimojiExpressionJava = new AnimojiExpressionJava();
          localAnimojiExpressionJava.shapeName = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.SHAPE_NAME.value, "");
          localAnimojiExpressionJava.controlledName = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.CONTROLLED_NAME.value, localAnimojiExpressionJava.shapeName);
        }
        try
        {
          Range localRange = new Range();
          localObject = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.SHAPE_RANGE.value);
          localRange.min = GsonUtils.getFloatUnsafe((JsonArray)localObject, 0);
          localRange.max = GsonUtils.getFloatUnsafe((JsonArray)localObject, 1);
          localAnimojiExpressionJava.shapeRange = localRange;
          localArrayList.add(localAnimojiExpressionJava);
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localAnimojiExpressionJava.shapeRange = null;
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static void parseExtensionAttributes(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() == 0)) {}
    for (;;)
    {
      return;
      Gson localGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = paramHashMap.next();
        try
        {
          JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, ((Class)localObject).getSimpleName());
          if (localJsonObject != null) {
            paramVideoMaterial.addExtAttribute(localGson.fromJson(localJsonObject.toString(), (Class)localObject));
          }
        }
        catch (JsonSyntaxException localJsonSyntaxException)
        {
          localJsonSyntaxException.printStackTrace();
        }
      }
    }
  }
  
  private static void parseFabbyMvItems(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    Object localObject2 = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.MV_TEMPLATE_FILE.value);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    Object localObject4;
    JsonArray localJsonArray;
    do
    {
      do
      {
        return;
        i = ((String)localObject2).lastIndexOf(".");
        localObject1 = localObject2;
        if (i >= 0) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
        localObject4 = parseVideoMaterialFileAsJSONObject(paramString, (String)localObject1, true, paramDecryptListener);
      } while (localObject4 == null);
      localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject4, "parts");
    } while ((localJsonArray == null) || (localJsonArray.size() <= 0));
    if (localJsonArray.size() == 1) {}
    Object localObject3 = new ArrayList();
    int i = 0;
    int j;
    if (i < localJsonArray.size())
    {
      FabbyMvPart localFabbyMvPart = new FabbyMvPart();
      JsonObject localJsonObject = GsonUtils.optJsonObject(localJsonArray, i);
      if (localJsonObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        double d = GsonUtils.optDouble(localJsonObject, "duration");
        Object localObject5 = GsonUtils.optJsonObject(localJsonObject, "background");
        Object localObject6;
        if (localObject5 != null)
        {
          localObject6 = new StickerItem();
          localObject1 = GsonUtils.optString((JsonObject)localObject5, "videoFile");
          localObject2 = GsonUtils.optString((JsonObject)localObject5, "imageName");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1434;
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
            j = 1;
            ((StickerItem)localObject6).type = 1;
            ((StickerItem)localObject6).alwaysTriggered = true;
            ((StickerItem)localObject6).lazyLoad = GsonUtils.optInt((JsonObject)localObject5, "lazyLoadFlag", 0);
            ((StickerItem)localObject6).frames = GsonUtils.optInt((JsonObject)localObject5, "imageCount", 1);
            ((StickerItem)localObject6).frameDuration = (GsonUtils.optDouble((JsonObject)localObject5, "imageDuration", d) / ((StickerItem)localObject6).frames * 1000.0D);
            ((StickerItem)localObject6).aspectMode = GsonUtils.optInt((JsonObject)localObject5, "aspectMode", 0);
            ((StickerItem)localObject6).blendMode = GsonUtils.optInt((JsonObject)localObject5, "blendMode", 0);
            ((StickerItem)localObject6).width = GsonUtils.optInt((JsonObject)localObject5, "width", 720);
            ((StickerItem)localObject6).height = GsonUtils.optInt((JsonObject)localObject5, "height", 960);
            ((StickerItem)localObject6).extraTypeWidth = GsonUtils.optInt((JsonObject)localObject5, "extraTypeWidth");
            ((StickerItem)localObject6).extarTypeHeight = GsonUtils.optInt((JsonObject)localObject5, "extraTypeHeight");
            ((StickerItem)localObject6).name = GsonUtils.optString((JsonObject)localObject5, "name", null);
            ((StickerItem)localObject6).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject6).isFabbyMvItem = true;
            ((StickerItem)localObject6).fabbyTotalParts = localJsonArray.size();
            ((StickerItem)localObject6).fabbyPart = i;
            ((StickerItem)localObject6).framePositionsBean = parseFramePosition(paramVideoMaterial, (JsonObject)localObject5);
            if (j == 0) {
              break label1512;
            }
            ((StickerItem)localObject6).sourceType = VideoMaterialUtil.getItemSourceType(GsonUtils.optInt((JsonObject)localObject5, "videoAlphaType"));
            label510:
            localFabbyMvPart.bgItem = ((StickerItem)localObject6);
          }
        }
        localObject5 = GsonUtils.optJsonObject(localJsonObject, "foreground");
        if (localObject5 != null)
        {
          localObject6 = new StickerItem();
          localObject1 = GsonUtils.optString((JsonObject)localObject5, "videoFile");
          localObject2 = GsonUtils.optString((JsonObject)localObject5, "imageName");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1548;
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
            j = 1;
            label630:
            ((StickerItem)localObject6).type = 1;
            ((StickerItem)localObject6).alwaysTriggered = true;
            ((StickerItem)localObject6).lazyLoad = GsonUtils.optInt((JsonObject)localObject5, "lazyLoadFlag", 0);
            ((StickerItem)localObject6).frames = GsonUtils.optInt((JsonObject)localObject5, "imageCount", 1);
            ((StickerItem)localObject6).frameDuration = (GsonUtils.optDouble((JsonObject)localObject5, "imageDuration", d) / ((StickerItem)localObject6).frames * 1000.0D);
            ((StickerItem)localObject6).aspectMode = GsonUtils.optInt((JsonObject)localObject5, "aspectMode", 0);
            ((StickerItem)localObject6).blendMode = GsonUtils.optInt((JsonObject)localObject5, "blendMode", 0);
            ((StickerItem)localObject6).width = GsonUtils.optInt((JsonObject)localObject5, "width", 720);
            ((StickerItem)localObject6).height = GsonUtils.optInt((JsonObject)localObject5, "height", 1280);
            ((StickerItem)localObject6).extraTypeWidth = GsonUtils.optInt((JsonObject)localObject5, "extraTypeWidth");
            ((StickerItem)localObject6).extarTypeHeight = GsonUtils.optInt((JsonObject)localObject5, "extraTypeHeight");
            ((StickerItem)localObject6).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject6).isFabbyMvItem = true;
            ((StickerItem)localObject6).fabbyTotalParts = localJsonArray.size();
            ((StickerItem)localObject6).fabbyPart = i;
            ((StickerItem)localObject6).framePositionsBean = parseFramePosition(paramVideoMaterial, (JsonObject)localObject5);
            if (j == 0) {
              break label1626;
            }
            ((StickerItem)localObject6).sourceType = VideoMaterialUtil.getItemSourceType(GsonUtils.optInt((JsonObject)localObject5, "videoAlphaType"));
            label853:
            localFabbyMvPart.fgItem = ((StickerItem)localObject6);
          }
        }
        localObject5 = GsonUtils.optJsonObject(localJsonObject, "cover");
        if (localObject5 != null)
        {
          localObject6 = new StickerItem();
          localObject2 = GsonUtils.optString((JsonObject)localObject5, "imageFile");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (((String)localObject2).endsWith("_")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).lastIndexOf("_"));
            ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
            ((StickerItem)localObject6).type = 1;
            ((StickerItem)localObject6).alwaysTriggered = true;
            ((StickerItem)localObject6).frames = 1;
            ((StickerItem)localObject6).frameDuration = (1000.0D * d);
            ((StickerItem)localObject6).lazyLoad = GsonUtils.optInt((JsonObject)localObject5, "lazyLoadFlag", 0);
            ((StickerItem)localObject6).aspectMode = GsonUtils.optInt((JsonObject)localObject5, "aspectMode", 0);
            ((StickerItem)localObject6).blendMode = GsonUtils.optInt((JsonObject)localObject5, "blendMode", 0);
            ((StickerItem)localObject6).width = GsonUtils.optInt((JsonObject)localObject5, "width", 720);
            ((StickerItem)localObject6).height = GsonUtils.optInt((JsonObject)localObject5, "height", 1280);
            ((StickerItem)localObject6).extraTypeWidth = GsonUtils.optInt((JsonObject)localObject5, "extraTypeWidth");
            ((StickerItem)localObject6).extarTypeHeight = GsonUtils.optInt((JsonObject)localObject5, "extraTypeHeight");
            ((StickerItem)localObject6).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject6).isFabbyMvItem = true;
            ((StickerItem)localObject6).fabbyTotalParts = localJsonArray.size();
            ((StickerItem)localObject6).fabbyPart = i;
            ((StickerItem)localObject6).framePositionsBean = parseFramePosition(paramVideoMaterial, (JsonObject)localObject5);
            localFabbyMvPart.coverItem = ((StickerItem)localObject6);
          }
        }
        localObject1 = GsonUtils.optJsonObject(localJsonObject, "cameraFrame");
        if (localObject1 != null)
        {
          localFabbyMvPart.easeCurve = GsonUtils.optInt((JsonObject)localObject1, "easeCurve", 0);
          localFabbyMvPart.scaleMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "shakaEffect");
          Object localObject7;
          Object localObject8;
          Object localObject9;
          Object localObject10;
          Object localObject11;
          Object localObject12;
          if (localObject2 != null)
          {
            localObject5 = new ShakaEffectItem();
            ((ShakaEffectItem)localObject5).setFilterType(GsonUtils.optInt((JsonObject)localObject2, "filterType"));
            localObject6 = new HashMap();
            localObject7 = ((JsonObject)localObject2).keySet().iterator();
            for (;;)
            {
              if (!((Iterator)localObject7).hasNext()) {
                break label1685;
              }
              localObject8 = (String)((Iterator)localObject7).next();
              localObject9 = GsonUtils.optJsonObject((JsonObject)localObject2, (String)localObject8);
              LogUtils.d(TAG, "key = " + (String)localObject8 + ", valueJson = " + localObject9);
              if (localObject9 != null)
              {
                localObject10 = new ArrayList();
                localObject11 = ((JsonObject)localObject9).keySet().iterator();
                for (;;)
                {
                  if (((Iterator)localObject11).hasNext())
                  {
                    localObject12 = (String)((Iterator)localObject11).next();
                    LogUtils.d(TAG, "valueKey = " + (String)localObject12);
                    ((List)localObject10).add(Pair.create(Float.valueOf((String)localObject12), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject9, (String)localObject12, 0.0D))));
                    continue;
                    label1434:
                    localObject1 = localObject2;
                    if (((String)localObject2).endsWith("_")) {
                      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                    }
                    j = ((String)localObject1).lastIndexOf("/");
                    ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                    ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
                    j = 0;
                    break;
                    label1512:
                    if (((StickerItem)localObject6).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type)
                    {
                      ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG;
                      break label510;
                    }
                    ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                    break label510;
                    label1548:
                    localObject1 = localObject2;
                    if (((String)localObject2).endsWith("_")) {
                      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                    }
                    j = ((String)localObject1).lastIndexOf("/");
                    ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                    ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
                    j = 0;
                    break label630;
                    label1626:
                    if (((StickerItem)localObject6).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type)
                    {
                      ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG;
                      break label853;
                    }
                    ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                    break label853;
                  }
                }
                Collections.sort((List)localObject10, mRangeValueComp);
                ((Map)localObject6).put(localObject8, localObject10);
              }
            }
            label1685:
            ((ShakaEffectItem)localObject5).setValueMap((Map)localObject6);
            localFabbyMvPart.setShakaEffectItem((ShakaEffectItem)localObject5);
          }
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "scale");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.scaleMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 1.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.scaleMap, mRangeValueComp);
          localFabbyMvPart.degreeMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "rotate");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.degreeMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.degreeMap, mRangeValueComp);
          localFabbyMvPart.isRelativeXMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "isRelativeX");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.isRelativeXMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.isRelativeXMap, mRangeValueComp);
          localFabbyMvPart.isRelativeYMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "isRelativeY");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.isRelativeYMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.isRelativeYMap, mRangeValueComp);
          localFabbyMvPart.translateXMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "translateX");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.translateXMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.translateXMap, mRangeValueComp);
          localFabbyMvPart.translateYMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "translateY");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.translateYMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.translateYMap, mRangeValueComp);
          localFabbyMvPart.anchorXMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "anchorX");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.anchorXMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.anchorXMap, mRangeValueComp);
          localFabbyMvPart.anchorYMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "anchorY");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.anchorYMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.anchorYMap, mRangeValueComp);
          localFabbyMvPart.alphaMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "alpha");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.alphaMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 1.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.alphaMap, mRangeValueComp);
          localFabbyMvPart.blurRadiusMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "blurRadius");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.blurRadiusMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.blurRadiusMap, mRangeValueComp);
          localFabbyMvPart.blurDirectionMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "blurDirection");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.blurDirectionMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.blurDirectionMap, mRangeValueComp);
          localFabbyMvPart.gridTypeMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "gridType");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.gridTypeMap.add(Pair.create(Float.valueOf((String)localObject6), Integer.valueOf(GsonUtils.optInt((JsonObject)localObject2, (String)localObject6, 0))));
            }
          }
          Collections.sort(localFabbyMvPart.gridTypeMap, mDivideValueComp);
          localFabbyMvPart.gridSettingMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "gridSettingFile");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localObject7 = GsonUtils.optString((JsonObject)localObject2, (String)localObject6);
              if (!TextUtils.isEmpty((CharSequence)localObject7))
              {
                localObject9 = parseVideoMaterialFileAsJSONObject(paramString, (String)localObject7, true, paramDecryptListener);
                if (localObject9 != null)
                {
                  localObject7 = new GridSettingModel();
                  localObject8 = new Rect(0, 0, 720, 1280);
                  localObject10 = GsonUtils.optJsonObject((JsonObject)localObject9, "canvasSize");
                  if (localObject10 != null)
                  {
                    ((Rect)localObject8).width = ((int)GsonUtils.optDouble((JsonObject)localObject10, "width", 720.0D));
                    ((Rect)localObject8).height = ((int)GsonUtils.optDouble((JsonObject)localObject10, "height", 1280.0D));
                  }
                  localObject9 = GsonUtils.optJsonArray((JsonObject)localObject9, "canvasRectList");
                  if ((localObject9 != null) && (((JsonArray)localObject9).size() > 0))
                  {
                    j = 0;
                    while (j < ((JsonArray)localObject9).size())
                    {
                      localObject10 = new GridModel();
                      localObject11 = new Rect(0, 0, 720, 1280);
                      localObject12 = GsonUtils.optJsonObject((JsonArray)localObject9, j);
                      if (localObject12 != null)
                      {
                        ((Rect)localObject11).x = ((int)GsonUtils.optDouble((JsonObject)localObject12, "left", 0.0D));
                        ((Rect)localObject11).y = ((int)GsonUtils.optDouble((JsonObject)localObject12, "top", 0.0D));
                        ((Rect)localObject11).width = ((int)GsonUtils.optDouble((JsonObject)localObject12, "width", 720.0D));
                        ((Rect)localObject11).height = ((int)GsonUtils.optDouble((JsonObject)localObject12, "height", 1280.0D));
                        ((GridModel)localObject10).renderId = GsonUtils.optInt((JsonObject)localObject12, "renderId", 0);
                        ((GridModel)localObject10).zIndex = GsonUtils.optInt((JsonObject)localObject12, "zIndex", 0);
                        ((GridModel)localObject10).aspectMode = GsonUtils.optInt((JsonObject)localObject12, "aspectMode", 0);
                        ((GridModel)localObject10).positionMode = GsonUtils.optInt((JsonObject)localObject12, "positionMode", 0);
                        ((GridModel)localObject10).transformType = GsonUtils.optInt((JsonObject)localObject12, "transformType", 0);
                        ((GridModel)localObject10).alpha = ((float)GsonUtils.optDouble((JsonObject)localObject12, "alpha", 1.0D));
                        ((GridModel)localObject10).rotate = ((float)GsonUtils.optDouble((JsonObject)localObject12, "rotate", 0.0D));
                      }
                      ((GridModel)localObject10).canvasRect = ((Rect)localObject11);
                      ((GridSettingModel)localObject7).canvasRectList.add(localObject10);
                      j += 1;
                    }
                    Collections.sort(((GridSettingModel)localObject7).canvasRectList, mGridModelComparator);
                  }
                  ((GridSettingModel)localObject7).canvasRect = ((Rect)localObject8);
                  localFabbyMvPart.gridSettingMap.add(Pair.create(Float.valueOf((String)localObject6), localObject7));
                }
              }
            }
          }
          Collections.sort(localFabbyMvPart.gridSettingMap, mDivideValueCompForObject);
          localFabbyMvPart.gridModeMap.clear();
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "gridMode");
          if (localObject2 != null)
          {
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.gridModeMap.add(Pair.create(Float.valueOf((String)localObject6), Integer.valueOf(GsonUtils.optInt((JsonObject)localObject2, (String)localObject6, 0))));
            }
          }
          Collections.sort(localFabbyMvPart.gridModeMap, mDivideValueComp);
          localFabbyMvPart.gridOrderMap.clear();
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject1, "gridOrder");
          if (localObject1 != null)
          {
            localObject2 = ((JsonObject)localObject1).keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject5 = (String)((Iterator)localObject2).next();
              localFabbyMvPart.gridOrderMap.add(Pair.create(Float.valueOf((String)localObject5), Integer.valueOf(GsonUtils.optInt((JsonObject)localObject1, (String)localObject5, 0))));
            }
          }
          Collections.sort(localFabbyMvPart.gridOrderMap, mDivideValueComp);
        }
        localObject5 = GsonUtils.optJsonObject(localJsonObject, "finishTransition");
        int k;
        if (localObject5 != null)
        {
          localObject6 = new StickerItem();
          localObject1 = GsonUtils.optString((JsonObject)localObject5, "maskVideoFile");
          localObject2 = GsonUtils.optString((JsonObject)localObject5, "maskImageName");
          j = GsonUtils.optInt((JsonObject)localObject5, "transitionFunction", 0);
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label4229;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label4154;
          }
          k = ((String)localObject1).lastIndexOf("/");
          ((StickerItem)localObject6).id = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
          ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, k);
        }
        for (;;)
        {
          ((StickerItem)localObject6).frames = GsonUtils.optInt((JsonObject)localObject5, "maskImageCount", 1);
          ((StickerItem)localObject6).frameDuration = (GsonUtils.optDouble((JsonObject)localObject5, "maskImageDuration", 0.0D) / ((StickerItem)localObject6).frames * 1000.0D);
          ((StickerItem)localObject6).setTriggerType(GsonUtils.optString((JsonObject)localObject5, "triggerType"));
          k = GsonUtils.optInt((JsonObject)localObject5, "mvTransitionTriggerType", 0);
          if (((StickerItem)localObject6).getTriggerTypeInt() == 1)
          {
            if ((paramVideoMaterial.getItemList() != null) && (paramVideoMaterial.getItemList().size() != 0))
            {
              localObject1 = (StickerItem)paramVideoMaterial.getItemList().get(paramVideoMaterial.getItemList().size() - 1);
              ((StickerItem)localObject6).setTriggerType(String.valueOf(((StickerItem)localObject1).getTriggerTypeInt()));
              ((StickerItem)localObject6).triggerArea = ((StickerItem)localObject1).triggerArea;
              ((StickerItem)localObject6).triggerHandPoint = ((StickerItem)localObject1).triggerHandPoint;
            }
            if (k > 0) {
              ((StickerItem)localObject6).setTriggerType(String.valueOf(k));
            }
          }
          ((StickerItem)localObject6).externalTriggerWords = GsonUtils.optString((JsonObject)localObject5, "externalTriggerWords");
          localFabbyMvPart.transitionItem = ((StickerItem)localObject6);
          localFabbyMvPart.transitionDuration = ((GsonUtils.optDouble((JsonObject)localObject5, "duration", 0.0D) * 1000.0D));
          localFabbyMvPart.transitionEase = GsonUtils.optInt((JsonObject)localObject5, "easeCurve", 0);
          localFabbyMvPart.transitionMaskType = GsonUtils.optInt((JsonObject)localObject5, "maskType", 1);
          localFabbyMvPart.transitionFunction = j;
          localFabbyMvPart.triggerDelay = GsonUtils.optInt((JsonObject)localObject5, "triggerDelay", 1);
          localObject1 = GsonUtils.optJsonObject(localJsonObject, "filterEffect");
          if (localObject1 == null) {
            break label4259;
          }
          localFabbyMvPart.filterType = GsonUtils.optInt((JsonObject)localObject1, "type", 0);
          localFabbyMvPart.filterId = GsonUtils.optString((JsonObject)localObject1, "filter");
          localFabbyMvPart.lutFile = GsonUtils.optString((JsonObject)localObject1, "lutFile");
          localFabbyMvPart.filterAlpha = ((float)GsonUtils.optDouble((JsonObject)localObject1, "alpha", 1.0D));
          localFabbyMvPart.filterParamMap.clear();
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject1, "param");
          if (localObject1 == null) {
            break label4259;
          }
          localObject2 = ((JsonObject)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (String)((Iterator)localObject2).next();
            localFabbyMvPart.filterParamMap.add(Pair.create(Float.valueOf((String)localObject5), Integer.valueOf(GsonUtils.optInt((JsonObject)localObject1, (String)localObject5, 0))));
          }
          label4154:
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("_")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
          k = ((String)localObject1).lastIndexOf("/");
          ((StickerItem)localObject6).id = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
          ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, k);
          continue;
          label4229:
          ((StickerItem)localObject6).id = "";
          ((StickerItem)localObject6).subFolder = "";
        }
        Collections.sort(localFabbyMvPart.filterParamMap, mDivideValueComp);
        label4259:
        localObject1 = GsonUtils.optJsonObject(localJsonObject, "bgFilterEffect");
        if (localObject1 != null)
        {
          localFabbyMvPart.bgFilterId = GsonUtils.optString((JsonObject)localObject1, "filter");
          localFabbyMvPart.bgLutFile = GsonUtils.optString((JsonObject)localObject1, "lutFile");
          localFabbyMvPart.bgFilterAlpha = ((float)GsonUtils.optDouble((JsonObject)localObject1, "alpha", 1.0D));
        }
        localObject1 = GsonUtils.optJsonObject(localJsonObject, "fgFilterEffect");
        if (localObject1 != null)
        {
          localFabbyMvPart.fgFilterId = GsonUtils.optString((JsonObject)localObject1, "filter");
          localFabbyMvPart.fgLutFile = GsonUtils.optString((JsonObject)localObject1, "lutFile");
          localFabbyMvPart.fgFilterAlpha = ((float)GsonUtils.optDouble((JsonObject)localObject1, "alpha", 1.0D));
        }
        localFabbyMvPart.duration = ((1000.0D * d));
        localFabbyMvPart.partIndex = i;
        ((List)localObject3).add(localFabbyMvPart);
      }
    }
    Object localObject1 = GsonUtils.optString((JsonObject)localObject4, "bgmAudio", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramVideoMaterial.setHasAudio(true);
    }
    paramVideoMaterial.setFabbyParts(new FabbyParts((List)localObject3, (String)localObject1));
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.MULTI_VIEWER.value);
    localObject1 = new ArrayList();
    if (paramJsonObject != null)
    {
      i = 0;
      if (i < paramJsonObject.size())
      {
        localObject2 = new MultiViewerItem();
        localObject3 = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localObject3 != null)
        {
          ((MultiViewerItem)localObject2).videoMaterial = parseVideoMaterial(paramString, GsonUtils.optString((JsonObject)localObject3, "importMaterial"), true, paramDecryptListener);
          if (((MultiViewerItem)localObject2).videoMaterial.isNeedFreezeFrame()) {
            paramVideoMaterial.setNeedFreezeFrame(true);
          }
          if (VideoMaterialUtil.isWatermarkMaterial(((MultiViewerItem)localObject2).videoMaterial)) {
            LogicDataManager.getInstance().init(((MultiViewerItem)localObject2).videoMaterial);
          }
          ((MultiViewerItem)localObject2).renderId = GsonUtils.optInt((JsonObject)localObject3, "renderId");
          localObject4 = GsonUtils.optJsonArray((JsonObject)localObject3, "activeParts");
          if (localObject4 != null)
          {
            j = 0;
            while (j < ((JsonArray)localObject4).size())
            {
              ((MultiViewerItem)localObject2).activeParts.add(Integer.valueOf(GsonUtils.optInt((JsonArray)localObject4, j)));
              j += 1;
            }
          }
          if (GsonUtils.optInt((JsonObject)localObject3, "needOriginFrame", 1) != 1) {
            break label4672;
          }
        }
        label4672:
        for (boolean bool = true;; bool = false)
        {
          ((MultiViewerItem)localObject2).needOriginFrame = bool;
          ((List)localObject1).add(localObject2);
          i += 1;
          break;
        }
      }
    }
    paramVideoMaterial.setMultiViewerItemList((List)localObject1);
  }
  
  private static void parseFaceCropParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    int i = 0;
    try
    {
      Object localObject1 = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.FIELD.FACE_CROP.value);
      if (localObject1 != null)
      {
        paramJsonObject = new FaceCropItem();
        paramJsonObject.frameDuration = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_CROP_ITEM.FRAME_DURATION.value);
        paramJsonObject.frames = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_CROP_ITEM.FRAMES.value);
        paramJsonObject.frameList = new ArrayList();
        localObject1 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.FACE_CROP_ITEM.FRAME_LIST.value);
        if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0)) {
          while (i < ((JsonArray)localObject1).size())
          {
            Object localObject2 = GsonUtils.getJsonObjectUnsafe((JsonArray)localObject1, i);
            FaceCropItem.CropFrame localCropFrame = new FaceCropItem.CropFrame();
            localCropFrame.faceAngle = GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_ANGLE.value);
            localCropFrame.faceWidth = GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_WIDTH.value);
            localCropFrame.index = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.FACE_CROP_ITEM_FRAME.INDEX.value);
            JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.FACE_CROP_ITEM_FRAME.NOSE_POINT.value);
            if ((localJsonArray != null) && (localJsonArray.size() > 0))
            {
              localCropFrame.noseX = GsonUtils.getDoubleUnsafe(localJsonArray, 0);
              localCropFrame.noseY = GsonUtils.getDoubleUnsafe(localJsonArray, 1);
            }
            localObject2 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.FACE_CROP_ITEM_FRAME.SIZE.value);
            if ((localObject2 != null) && (((JsonArray)localObject2).size() > 0))
            {
              localCropFrame.width = GsonUtils.getDoubleUnsafe((JsonArray)localObject2, 0);
              localCropFrame.height = GsonUtils.getDoubleUnsafe((JsonArray)localObject2, 1);
            }
            paramJsonObject.frameList.add(localCropFrame);
            i += 1;
          }
        }
        paramVideoMaterial.setFaceCropItem(paramJsonObject);
      }
      return;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
  }
  
  private static void parseFaceExpressionParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, boolean[] paramArrayOfBoolean)
  {
    JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXPRESSION.value);
    if (localJsonObject != null)
    {
      paramJsonObject = new FaceExpression();
      paramJsonObject.id = GsonUtils.optString(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.ID.value);
      paramJsonObject.videoID = GsonUtils.optString(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.VIDEO_ID.value);
      paramJsonObject.frameDuration = GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAME_DURATION.value);
      paramJsonObject.frames = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAMES.value);
      paramJsonObject.audioID = GsonUtils.optString(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.AUDIO_ID.value);
      int k;
      int i;
      label251:
      Object localObject1;
      Object localObject2;
      if (!TextUtils.isEmpty(paramJsonObject.audioID))
      {
        k = 1;
        paramArrayOfBoolean[0] = k;
        paramArrayOfBoolean = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_SIZE.value);
        if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean.size() == 2))
        {
          paramJsonObject.canvasSize = new SizeI();
          paramJsonObject.canvasSize.width = GsonUtils.optInt(paramArrayOfBoolean, 0);
          paramJsonObject.canvasSize.height = GsonUtils.optInt(paramArrayOfBoolean, 1);
        }
        paramJsonObject.canvasResizeMode = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_RESIZE_MODE.value);
        paramJsonObject.scoreImageID = GsonUtils.optString(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
        paramJsonObject.expressionNumber = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_NUMBER.value);
        paramArrayOfBoolean = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_LIST.value);
        if (paramArrayOfBoolean == null) {
          break label673;
        }
        paramJsonObject.expressionList = new ArrayList();
        i = 0;
        if (i >= paramArrayOfBoolean.size()) {
          break label673;
        }
        localObject1 = new ExpressionItem();
        localObject2 = GsonUtils.optJsonObject(paramArrayOfBoolean, i);
        if (localObject2 != null) {
          break label293;
        }
      }
      for (;;)
      {
        i += 1;
        break label251;
        k = 0;
        break;
        label293:
        ((ExpressionItem)localObject1).expressionTime = GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_TIME.value);
        ((ExpressionItem)localObject1).expressionID = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ID.value);
        JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT_SIZE.value);
        if ((localJsonArray != null) && (localJsonArray.size() == 2))
        {
          ((ExpressionItem)localObject1).expressionFeatSize = new SizeI();
          ((ExpressionItem)localObject1).expressionFeatSize.width = GsonUtils.optInt(localJsonArray, 0);
          ((ExpressionItem)localObject1).expressionFeatSize.height = GsonUtils.optInt(localJsonArray, 1);
        }
        localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT.value);
        int j;
        if (localJsonArray != null)
        {
          ((ExpressionItem)localObject1).expressionFeat = new ArrayList();
          j = 0;
          while (j < localJsonArray.size() / 2)
          {
            ((ExpressionItem)localObject1).expressionFeat.add(new PointF(GsonUtils.optInt(localJsonArray, j * 2), GsonUtils.optInt(localJsonArray, j * 2 + 1)));
            j += 1;
          }
        }
        localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ANGLE.value);
        if ((localJsonArray != null) && (localJsonArray.size() == 3))
        {
          ((ExpressionItem)localObject1).expressionAngle = new float[3];
          ((ExpressionItem)localObject1).expressionAngle[0] = ((float)GsonUtils.optDouble(localJsonArray, 0));
          ((ExpressionItem)localObject1).expressionAngle[1] = ((float)GsonUtils.optDouble(localJsonArray, 1));
          ((ExpressionItem)localObject1).expressionAngle[2] = ((float)GsonUtils.optDouble(localJsonArray, 2));
        }
        ((ExpressionItem)localObject1).scoreImageID = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
        localObject2 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_WEIGHT.value);
        if ((localObject2 != null) && (((JsonArray)localObject2).size() == 7))
        {
          ((ExpressionItem)localObject1).expressionWeight = new double[7];
          j = 0;
        }
        while (j < 7)
        {
          ((ExpressionItem)localObject1).expressionWeight[j] = GsonUtils.optDouble((JsonArray)localObject2, j);
          j += 1;
          continue;
          ((ExpressionItem)localObject1).expressionWeight = ActUtil.WEIGHT;
        }
        paramJsonObject.expressionList.add(localObject1);
      }
      label673:
      paramArrayOfBoolean = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_ITEM_LIST.value);
      if (paramArrayOfBoolean != null)
      {
        paramJsonObject.canvasItemList = new ArrayList();
        i = 0;
        if (i < paramArrayOfBoolean.size())
        {
          localJsonObject = GsonUtils.optJsonObject(paramArrayOfBoolean, i);
          if (localJsonObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            localObject1 = new CanvasItem();
            ((CanvasItem)localObject1).type = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.CANVAS_ITEM_FILED.TYPE.value);
            ((CanvasItem)localObject1).index = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.CANVAS_ITEM_FILED.INDEX.value);
            ((CanvasItem)localObject1).startTime = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.CANVAS_ITEM_FILED.START_TIME.value);
            ((CanvasItem)localObject1).endTime = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.CANVAS_ITEM_FILED.END_TIME.value);
            ((CanvasItem)localObject1).zIndex = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.CANVAS_ITEM_FILED.Z_INDEX.value);
            localObject2 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RECT.value);
            if ((localObject2 != null) && (((JsonArray)localObject2).size() == 4))
            {
              ((CanvasItem)localObject1).itemRect = new Rect();
              ((CanvasItem)localObject1).itemRect.x = GsonUtils.optInt((JsonArray)localObject2, 0);
              ((CanvasItem)localObject1).itemRect.y = GsonUtils.optInt((JsonArray)localObject2, 1);
              ((CanvasItem)localObject1).itemRect.width = GsonUtils.optInt((JsonArray)localObject2, 2);
              ((CanvasItem)localObject1).itemRect.height = GsonUtils.optInt((JsonArray)localObject2, 3);
            }
            ((CanvasItem)localObject1).itemResizeMode = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RESIZE_MODE.value);
            paramJsonObject.canvasItemList.add(localObject1);
          }
        }
      }
      paramVideoMaterial.setFaceExpression(paramJsonObject);
    }
  }
  
  private static FaceFeatureItem parseFaceFeatureItem(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    if (paramJsonObject == null) {
      return null;
    }
    FaceFeatureItem localFaceFeatureItem = new FaceFeatureItem();
    localFaceFeatureItem.setId(GsonUtils.optString(paramJsonObject, "id"));
    localFaceFeatureItem.setMaskAnchorPoint(GsonUtils.optInt(paramJsonObject, "maskAnchorPoint", -1));
    String str = FileUtils.genSeperateFileDir(paramString) + localFaceFeatureItem.getId();
    localFaceFeatureItem.setDataPath(str);
    Object localObject = GsonUtils.optString(paramJsonObject, "distortionFile");
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = ((String)localObject).lastIndexOf(".");
      paramString = (String)localObject;
      if (i >= 0) {
        paramString = ((String)localObject).substring(0, i);
      }
      paramString = parseVideoMaterialFileAsJSONObject(str, paramString, true, paramDecryptListener);
      if (paramString != null)
      {
        paramString = GsonUtils.optJsonArray(paramString, "distortionList");
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = parseDistortionItemListParams(paramString);
          if (paramString != null) {
            localFaceFeatureItem.setDistortionItemList(paramString);
          }
        }
      }
    }
    localObject = GsonUtils.optString(paramJsonObject, "faceOffFile");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = ((String)localObject).lastIndexOf(".");
      paramString = (String)localObject;
      if (i >= 0) {
        paramString = ((String)localObject).substring(0, i);
      }
      paramString = parseVideoMaterialFileAsJSONObject(str, paramString, true, paramDecryptListener);
      if (paramString != null)
      {
        localObject = new JsonArray();
        ((JsonArray)localObject).add(paramString);
        paramString = parseFaceOffItemListParams((JsonArray)localObject);
        if (paramString != null) {
          localFaceFeatureItem.setFaceOffItemList(paramString);
        }
        if (checkNeedDetectGender(paramString)) {
          paramVideoMaterial.setDetectGender(true);
        }
      }
    }
    paramString = GsonUtils.optJsonArray(paramJsonObject, "itemList");
    if (paramString != null)
    {
      paramString = parseItemListParams(str, paramString, VideoFilterFactory.STICKER_TYPE.FACE_FEATURE.type, paramVideoMaterial, paramVideoMaterial.getBlendMode(), null, null, paramDecryptListener);
      if (paramString != null)
      {
        Collections.sort(paramString, new VideoTemplateParser.7());
        localFaceFeatureItem.setStickerItems(paramString);
      }
    }
    return localFaceFeatureItem;
  }
  
  private static void parseFaceFeatureItemListParams(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "faceFeatureItemList");
    if (paramJsonObject == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJsonObject.size())
    {
      Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
      if (localObject != null)
      {
        localObject = parseFaceFeatureItem(paramString, (JsonObject)localObject, paramVideoMaterial, paramDecryptListener);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramVideoMaterial.setFaceFeatureItemList(localArrayList);
  }
  
  private static void parseFaceImageLayerParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    int j = 0;
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.FIELD.FACE_AVERAGE.value);
    if (paramJsonObject != null)
    {
      FaceImageLayer localFaceImageLayer = new FaceImageLayer();
      localFaceImageLayer.width = GsonUtils.optDouble(paramJsonObject, "width");
      localFaceImageLayer.height = GsonUtils.optDouble(paramJsonObject, "height");
      localFaceImageLayer.x = GsonUtils.optDouble(paramJsonObject, "x");
      localFaceImageLayer.y = GsonUtils.optDouble(paramJsonObject, "y");
      localFaceImageLayer.type = GsonUtils.optInt(paramJsonObject, "type");
      localFaceImageLayer.imagePath = GsonUtils.optString(paramJsonObject, "image");
      JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "imageFacePoint");
      ArrayList localArrayList;
      int i;
      if (localJsonArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
          i += 1;
        }
        localFaceImageLayer.imageFacePoint = localArrayList;
      }
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "imageFaceColor");
      if (localJsonArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
          i += 1;
        }
        localFaceImageLayer.imageFaceColor = localArrayList;
      }
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "imageFaceColor2");
      if (localJsonArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
          i += 1;
        }
        localFaceImageLayer.imageFaceColor2 = localArrayList;
      }
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "faceColorRange");
      if (localJsonArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
          i += 1;
        }
        localFaceImageLayer.faceColorRange = localArrayList;
      }
      localFaceImageLayer.blendAlpha = GsonUtils.optDouble(paramJsonObject, "blendAlpha", 0.5D);
      localFaceImageLayer.distortionAlpha = GsonUtils.optDouble(paramJsonObject, "distortionAlpha", 0.5D);
      localFaceImageLayer.faceTriangleID = GsonUtils.optInt(paramJsonObject, "faceTriangleID", 0);
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "distortionList");
      if (localJsonArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          Object localObject = localJsonArray.get(i);
          if ((localObject instanceof JsonObject))
          {
            localObject = (JsonObject)localObject;
            DistortionItem localDistortionItem = new DistortionItem();
            localDistortionItem.position = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
            localDistortionItem.distortion = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
            localDistortionItem.direction = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
            localDistortionItem.radius = ((float)GsonUtils.optDouble((JsonObject)localObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
            localDistortionItem.strength = ((float)GsonUtils.optDouble((JsonObject)localObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
            localDistortionItem.x = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value, 0);
            localDistortionItem.y = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value, 0);
            localArrayList.add(localDistortionItem);
          }
          i += 1;
        }
        localFaceImageLayer.distortionList = localArrayList;
      }
      localFaceImageLayer.faceMaskImagePath = GsonUtils.optString(paramJsonObject, "faceMaskImage", null);
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "faceMaskFacePoint");
      if (localJsonArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
          i += 1;
        }
        localFaceImageLayer.faceMaskFacePoint = localArrayList;
      }
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "faceTriangle");
      if (localJsonArray != null)
      {
        localArrayList = new ArrayList();
        i = j;
        while (i < localJsonArray.size())
        {
          localArrayList.add(Integer.valueOf(GsonUtils.optInt(localJsonArray, i)));
          i += 1;
        }
        localFaceImageLayer.faceTriangle = localArrayList;
      }
      localFaceImageLayer.antiWrinkle = GsonUtils.optDouble(paramJsonObject, "antiWrinkle");
      paramVideoMaterial.setFaceImageLayer(localFaceImageLayer);
    }
  }
  
  private static FaceMaskItem parseFaceMask(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    if (paramJsonObject == null) {
      return null;
    }
    return new FaceMaskItem(paramJsonObject, paramVideoMaterial.getDataPath());
  }
  
  private static void parseFaceMaskItemListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "faceMaskList");
    if (paramJsonObject == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJsonObject.size())
      {
        Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localObject != null)
        {
          localObject = parseFaceMask((JsonObject)localObject, paramVideoMaterial);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    paramVideoMaterial.setFaceMaskItemList(localArrayList);
  }
  
  private static void parseFaceMeshItemListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_MESH_ITEM_LIST.value);
    if (paramJsonObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJsonObject.size())
      {
        JsonObject localJsonObject1 = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localJsonObject1 == null)
        {
          i += 1;
        }
        else
        {
          FaceMeshItem localFaceMeshItem = new FaceMeshItem();
          localFaceMeshItem.id = GsonUtils.optString(localJsonObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.ID.value);
          localFaceMeshItem.personID = GsonUtils.optInt(localJsonObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.PERSON_ID.value, -1);
          localFaceMeshItem.genderType = GsonUtils.optInt(localJsonObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.GENDER_TYPE.value, 0);
          if (localFaceMeshItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localFaceMeshItem.frames = GsonUtils.optInt(localJsonObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.FRAMES.value);
          JsonObject localJsonObject2 = GsonUtils.optJsonObject(localJsonObject1, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localJsonObject2 != null)
          {
            localFaceMeshItem.charmRange = new CharmRange();
            localFaceMeshItem.charmRange.min = GsonUtils.optDouble(localJsonObject2, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localFaceMeshItem.charmRange.max = GsonUtils.optDouble(localJsonObject2, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localFaceMeshItem.frameType = GsonUtils.optInt(localJsonObject1, "frameType");
          localFaceMeshItem.frameDuration = GsonUtils.optDouble(localJsonObject1, "frameDuration");
          localFaceMeshItem.setTriggerType(String.valueOf(Math.max(GsonUtils.optInt(localJsonObject1, "triggerType"), 2)));
          if (VideoMaterialUtil.isActionTriggerType(localFaceMeshItem.getTriggerTypeInt())) {
            paramVideoMaterial.setTriggerType(localFaceMeshItem.getTriggerTypeInt());
          }
          if (GsonUtils.optInt(localJsonObject1, "alwaysTriggered") == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localFaceMeshItem.alwaysTriggered = bool;
            localFaceMeshItem.externalTriggerWords = GsonUtils.optString(localJsonObject1, "externalTriggerWords");
            localFaceMeshItem.featureStatType = GsonUtils.optInt(localJsonObject1, "featureStatType");
            localJsonObject1 = GsonUtils.optJsonObject(localJsonObject1, "featureStatValueRange");
            if (localJsonObject1 != null)
            {
              localFaceMeshItem.featureStatValueRange = new StickerItem.ValueRange();
              localFaceMeshItem.featureStatValueRange.min = GsonUtils.optDouble(localJsonObject1, "min");
              localFaceMeshItem.featureStatValueRange.max = GsonUtils.optDouble(localJsonObject1, "max");
            }
            localArrayList.add(localFaceMeshItem);
            break;
          }
        }
      }
      paramVideoMaterial.setFaceMeshItemList(localArrayList);
    }
  }
  
  @Deprecated
  private static void parseFaceMoveItemListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    try
    {
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_MOVE_LIST.value);
      if (paramJsonObject != null)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramJsonObject.size())
        {
          FaceMoveItem localFaceMoveItem = new FaceMoveItem();
          JsonObject localJsonObject = GsonUtils.getJsonObjectUnsafe(paramJsonObject, i);
          localFaceMoveItem.position = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POSITION.value);
          localFaceMoveItem.pos1 = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS1.value);
          localFaceMoveItem.pos2 = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS2.value);
          localFaceMoveItem.ratio1 = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO1.value));
          localFaceMoveItem.ratio2 = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO2.value));
          localFaceMoveItem.dx = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MOVE_ITEM_FILED.X.value);
          localFaceMoveItem.dy = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MOVE_ITEM_FILED.Y.value);
          localArrayList.add(localFaceMoveItem);
          i += 1;
        }
        paramVideoMaterial.setFaceMoveItemList(localArrayList);
      }
      return;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
  }
  
  @Deprecated
  private static void parseFaceMoveTrianglesParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    try
    {
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_MOVE_TRIANGLE.value);
      if (paramJsonObject != null)
      {
        int[] arrayOfInt = new int[paramJsonObject.size()];
        int i = 0;
        while (i < paramJsonObject.size())
        {
          arrayOfInt[i] = GsonUtils.getIntUnsafe(paramJsonObject, i);
          i += 1;
        }
        paramVideoMaterial.setFaceMoveTriangles(arrayOfInt);
      }
      return;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
  }
  
  private static List<FaceItem> parseFaceOffItemListParams(JsonArray paramJsonArray)
  {
    ArrayList localArrayList1 = new ArrayList();
    int k;
    int j;
    int i;
    Object localObject1;
    if (paramJsonArray != null)
    {
      k = -1;
      j = 0;
      i = 0;
      int m = 0;
      while (m < paramJsonArray.size())
      {
        localObject1 = GsonUtils.optJsonObject(paramJsonArray, m);
        if (localObject1 == null)
        {
          m += 1;
        }
        else
        {
          FaceItem localFaceItem = new FaceItem();
          localFaceItem.id = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.ID.value);
          localFaceItem.faceExchangeImage = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE.value);
          localFaceItem.irisImage = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.IRIS_IMAGE.value);
          localFaceItem.blendAlpha = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_ALPHA.value));
          localFaceItem.featureType = FaceOffUtil.getFeatureType(GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FEATURE_TYPE.value));
          localFaceItem.grayScale = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.GRAY_SCALE.value);
          localFaceItem.blendMode = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_MODE.value);
          localFaceItem.blendIris = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_IRIS.value, 0);
          localFaceItem.personID = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.PERSON_ID.value, -1);
          localFaceItem.genderType = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.GENDER_TYPE.value, 0);
          localFaceItem.randomGroupNum = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.RANDOM_GROUP_NUM.value);
          if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.COS_3D.value, 0) == 1)
          {
            bool = true;
            localFaceItem.is3DCos = bool;
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.DISABLE_3D_CORRECT.value, 0) != 1) {
              break label467;
            }
            bool = true;
            label290:
            localFaceItem.disable3DCorrect = bool;
            if (localFaceItem.is3DCos)
            {
              localFaceItem.grayScale = 1;
              localFaceItem.featureType = FaceOffUtil.FEATURE_TYPE.FACE_COS3D_MASK;
            }
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE_FULL_FACE.value, 0) != 1) {
              break label473;
            }
            bool = true;
            label338:
            localFaceItem.faceExchangeImageFullFace = bool;
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE_DISABLE_OPACITY.value, 0) != 1) {
              break label479;
            }
          }
          int n;
          label467:
          label473:
          label479:
          for (boolean bool = true;; bool = false)
          {
            localFaceItem.faceExchangeImageDisableOpacity = bool;
            localFaceItem.lipsStyleMask = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.LIPS_STYLE_MASK.value, null);
            localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.LIPS_RGBA.value);
            if ((localObject2 == null) || (((JsonArray)localObject2).size() != 4)) {
              break label485;
            }
            localFaceItem.lipsRGBA = new float[4];
            n = 0;
            while (n < 4)
            {
              localFaceItem.lipsRGBA[n] = (GsonUtils.optInt((JsonArray)localObject2, n) / 255.0F);
              n += 1;
            }
            bool = false;
            break;
            bool = false;
            break label290;
            bool = false;
            break label338;
          }
          label485:
          localFaceItem.lipsRGBA = null;
          Object localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_POINTS.value);
          if (localObject2 != null)
          {
            ArrayList localArrayList2 = new ArrayList();
            n = 0;
            while (n < ((JsonArray)localObject2).size())
            {
              localArrayList2.add(Float.valueOf((float)GsonUtils.optDouble((JsonArray)localObject2, n)));
              n += 1;
            }
            localFaceItem.facePoints = localArrayList2;
          }
          localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject2 != null)
          {
            localFaceItem.charmRange = new CharmRange();
            localFaceItem.charmRange.min = GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localFaceItem.charmRange.max = GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localFaceItem.frameType = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAME_TYPE.value);
          localFaceItem.frames = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAMES.value);
          localFaceItem.frameDuration = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAME_DURATION.value);
          localFaceItem.width = GsonUtils.optInt((JsonObject)localObject1, "width");
          localFaceItem.height = GsonUtils.optInt((JsonObject)localObject1, "height");
          localFaceItem.setTriggerType(GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.TRIGGER_TYPE.value, String.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value)));
          if (GsonUtils.optInt((JsonObject)localObject1, "alwaysTriggered", 1) == 1)
          {
            bool = true;
            label749:
            localFaceItem.alwaysTriggered = bool;
            localFaceItem.featureStatType = GsonUtils.optInt((JsonObject)localObject1, "featureStatType");
            localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "featureStatValueRange");
            if (localObject2 != null)
            {
              localFaceItem.featureStatValueRange = new StickerItem.ValueRange();
              localFaceItem.featureStatValueRange.min = GsonUtils.optDouble((JsonObject)localObject2, "min");
              localFaceItem.featureStatValueRange.max = GsonUtils.optDouble((JsonObject)localObject2, "max");
            }
            localFaceItem.activateTriggerType = GsonUtils.optInt((JsonObject)localObject1, "activateTriggerType", 0);
            localFaceItem.activateTriggerCount = GsonUtils.optInt((JsonObject)localObject1, "activateTriggerCount", 0);
            localFaceItem.activateTriggerTotalCount = GsonUtils.optInt((JsonObject)localObject1, "activateTriggerTotalCount", 0);
            localFaceItem.playCount = GsonUtils.optInt((JsonObject)localObject1, "playCount");
            localFaceItem.preTriggerType = localFaceItem.getTriggerTypeInt();
            localFaceItem.countTriggerType = localFaceItem.getTriggerTypeInt();
            localFaceItem.externalTriggerWords = GsonUtils.optString((JsonObject)localObject1, "externalTriggerWords");
            if (k != -1) {
              break label964;
            }
            k = localFaceItem.getTriggerTypeInt();
          }
          for (;;)
          {
            if (GsonUtils.optInt((JsonObject)localObject1, "isElementTriggerMVPart", 0) != 0) {
              i = localFaceItem.getTriggerTypeInt();
            }
            localArrayList1.add(localFaceItem);
            break;
            bool = false;
            break label749;
            label964:
            j = Math.max(j, localFaceItem.getTriggerTypeInt());
          }
        }
      }
      if (i <= 0) {
        break label1055;
      }
    }
    for (;;)
    {
      paramJsonArray = localArrayList1.iterator();
      while (paramJsonArray.hasNext())
      {
        localObject1 = (FaceItem)paramJsonArray.next();
        if (((FaceItem)localObject1).activateTriggerType == 0)
        {
          ((FaceItem)localObject1).countTriggerType = i;
          ((FaceItem)localObject1).preTriggerType = k;
        }
        else
        {
          ((FaceItem)localObject1).playCount = 0;
          ((FaceItem)localObject1).countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
        }
      }
      return localArrayList1;
      label1055:
      i = j;
    }
  }
  
  private static void parseFacePointsListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_POINTS_LIST.value);
    ArrayList localArrayList = new ArrayList();
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        localArrayList.add(Float.valueOf((float)GsonUtils.optDouble(paramJsonObject, i)));
        i += 1;
      }
      paramVideoMaterial.setFacePoints(localArrayList);
    }
  }
  
  private static FaceStyleItem parseFaceStyleItem(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    if (paramJsonObject == null) {
      return null;
    }
    FaceStyleItem localFaceStyleItem = new FaceStyleItem();
    localFaceStyleItem.dataPath = paramVideoMaterial.getDataPath();
    localFaceStyleItem.id = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.ID.value);
    localFaceStyleItem.modelName = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.MODEL_NAME.value);
    localFaceStyleItem.alwaysTriggered = GsonUtils.optBoolean(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.ALWAYS_TRIGGERD.value);
    localFaceStyleItem.setTriggerType(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TRIGGER_TYPE.value));
    localFaceStyleItem.externalTriggerWords = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.EXTERNAL_TRIGGER_WORDS.value);
    localFaceStyleItem.triggerState = new ArrayList();
    paramVideoMaterial = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TRIGGER_STATE_LIST.value);
    int i;
    if ((paramVideoMaterial != null) && (paramVideoMaterial.size() > 0)) {
      i = 0;
    }
    while (i < paramVideoMaterial.size())
    {
      localFaceStyleItem.triggerState.add(GsonUtils.getStringUnsafe(paramVideoMaterial, i));
      i += 1;
      continue;
      paramJsonObject = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TRIGGER_STATE.value);
      if ((paramJsonObject != null) && (paramJsonObject != "")) {
        localFaceStyleItem.triggerState.add(paramJsonObject);
      }
    }
    return localFaceStyleItem;
  }
  
  private static void parseFilamentParticleListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FILAMENT_PARTICLE_LIST.value);
    if (paramJsonObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJsonObject.size())
      {
        String str = GsonUtils.optString(paramJsonObject, i);
        if (str != null) {
          localArrayList.add(str);
        }
        i += 1;
      }
      paramVideoMaterial.setFilamentParticleList(localArrayList);
    }
  }
  
  private static void parseFilterEffectParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.FIELD.FILTER_EFFECT.value);
    if (paramJsonObject != null)
    {
      VideoFilterEffect localVideoFilterEffect = new VideoFilterEffect();
      localVideoFilterEffect.type = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FILTER_EFFECT_FIELD.TYPE.value);
      localVideoFilterEffect.order = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FILTER_EFFECT_FIELD.ORDER.value);
      localVideoFilterEffect.alpha = ((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.FILTER_EFFECT_FIELD.ALPHA.value, 1.0D));
      localVideoFilterEffect.lutName = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FILTER_EFFECT_FIELD.LUT_NAME.value);
      if (TextUtils.isEmpty(localVideoFilterEffect.lutName)) {
        localVideoFilterEffect.lutName = "filterEffect.lut";
      }
      paramVideoMaterial.setVideoFilterEffect(localVideoFilterEffect);
    }
  }
  
  public static VideoMaterial parseFilterListMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {}
    for (;;)
    {
      return paramVideoMaterial;
      try
      {
        paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "filterList");
        paramVideoMaterial.mFilterList.clear();
        if (paramJsonObject == null) {
          continue;
        }
        int i = 0;
        while (i < paramJsonObject.size())
        {
          paramVideoMaterial.mFilterList.add(GsonUtils.getStringUnsafe(paramJsonObject, i));
          i += 1;
        }
        return paramVideoMaterial;
      }
      catch (Exception paramJsonObject)
      {
        paramJsonObject = paramJsonObject;
        paramJsonObject.printStackTrace();
        return paramVideoMaterial;
      }
      finally {}
    }
  }
  
  private static FramePositionsBean parseFramePosition(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      if (paramJsonObject != null) {
        break label16;
      }
      localObject1 = localObject2;
    }
    label16:
    do
    {
      do
      {
        do
        {
          return localObject1;
          paramJsonObject = GsonUtils.optString(paramJsonObject, "positionsFile", null);
          localObject1 = localObject2;
        } while (paramJsonObject == null);
        paramVideoMaterial = FileOfflineUtil.readJsonStringFromFile(paramVideoMaterial.getDataPath() + File.separator + paramJsonObject);
        localObject1 = localObject2;
      } while (paramVideoMaterial == null);
      paramVideoMaterial = (FramePositionsBean)GsonUtils.json2Obj(paramVideoMaterial, new VideoTemplateParser.12().getType());
      localObject1 = paramVideoMaterial;
    } while (paramVideoMaterial == null);
    paramVideoMaterial.checkFrameOrder();
    return paramVideoMaterial;
  }
  
  private static void parseGameParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    GameParams localGameParams = new GameParams();
    localGameParams.mGameName = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GAME_FIELD.GAME_NAME.value);
    localGameParams.fov = ((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.GAME_FIELD.FOV.value, 60.0D));
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0)
    {
      bool = true;
      localGameParams.flattenEar = bool;
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
        break label146;
      }
    }
    int i;
    label146:
    for (boolean bool = true;; bool = false)
    {
      localGameParams.flattenNose = bool;
      localObject1 = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GAME_FIELD.FLIP.value);
      if (localObject1 == null) {
        break label151;
      }
      i = 0;
      while ((i < ((JsonArray)localObject1).size()) && (i < 3))
      {
        localGameParams.mFlip[i] = ((float)GsonUtils.optDouble((JsonArray)localObject1, i));
        i += 1;
      }
      bool = false;
      break;
    }
    label151:
    Object localObject1 = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GAME_FIELD.PRE_TRANSLATE.value);
    if (localObject1 != null)
    {
      i = 0;
      while ((i < ((JsonArray)localObject1).size()) && (i < 3))
      {
        localGameParams.mPreTranslate[i] = ((float)GsonUtils.optDouble((JsonArray)localObject1, i));
        i += 1;
      }
    }
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.ANIMOJI_FIELD.ANIMOJI.value);
    if (paramJsonObject != null)
    {
      localGameParams.animojiBaseNodeId = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GAME_FIELD.ANIMOJI_BASE_NODE_ID.value);
      localObject1 = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GAME_FIELD.ANIMOJI_EXPREESION_NODE_IDS.value);
      Object localObject2;
      if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0))
      {
        localObject2 = new StringBuilder();
        i = 0;
        while (i < ((JsonArray)localObject1).size())
        {
          ((StringBuilder)localObject2).append(GsonUtils.optString((JsonArray)localObject1, i));
          if (i != ((JsonArray)localObject1).size() - 1) {
            ((StringBuilder)localObject2).append("-");
          }
          i += 1;
        }
        localGameParams.animojiExpressionNodeIds = ((StringBuilder)localObject2).toString();
      }
      localGameParams.animojiExpressionMap = "";
      localGameParams.animojiExpressionMap += "browDownLeft-0-";
      localGameParams.animojiExpressionMap += "browDownRight-1-";
      localGameParams.animojiExpressionMap += "browInnerUp-2-";
      localGameParams.animojiExpressionMap += "browOuterUpLeft-3-";
      localGameParams.animojiExpressionMap += "browOuterUpRight-4-";
      localGameParams.animojiExpressionMap += "cheekPuff-5-";
      localGameParams.animojiExpressionMap += "mouthPucker-6-";
      localGameParams.animojiExpressionMap += "cheekSquintRight-7-";
      localGameParams.animojiExpressionMap += "eyeBlinkLeft-8-";
      localGameParams.animojiExpressionMap += "eyeBlinkRight-9-";
      localGameParams.animojiExpressionMap += "eyeLookDownLeft-10-";
      localGameParams.animojiExpressionMap += "eyeLookDownRight-11-";
      localGameParams.animojiExpressionMap += "eyeLookInLeft-12-";
      localGameParams.animojiExpressionMap += "eyeLookInRight-13-";
      localGameParams.animojiExpressionMap += "eyeLookOutLeft-14-";
      localGameParams.animojiExpressionMap += "eyeLookOutRight-15-";
      localGameParams.animojiExpressionMap += "eyeLookUpLeft-16-";
      localGameParams.animojiExpressionMap += "eyeLookUpRight-17-";
      localGameParams.animojiExpressionMap += "eyeSquintLeft-18-";
      localGameParams.animojiExpressionMap += "eyeSquintRight-19-";
      localGameParams.animojiExpressionMap += "eyeWideLeft-20-";
      localGameParams.animojiExpressionMap += "eyeWideRight-21-";
      localGameParams.animojiExpressionMap += "jawForward-22-";
      localGameParams.animojiExpressionMap += "jawLeft-23-";
      localGameParams.animojiExpressionMap += "jawOpen-24-";
      localGameParams.animojiExpressionMap += "jawRight-25-";
      localGameParams.animojiExpressionMap += "mouthClose-26-";
      localGameParams.animojiExpressionMap += "mouthDimpleLeft-27-";
      localGameParams.animojiExpressionMap += "mouthDimpleRight-28-";
      localGameParams.animojiExpressionMap += "mouthFrownLeft-29-";
      localGameParams.animojiExpressionMap += "mouthFrownRight-30-";
      localGameParams.animojiExpressionMap += "mouthFunnel-31-";
      localGameParams.animojiExpressionMap += "mouthLeft-32-";
      localGameParams.animojiExpressionMap += "mouthLowerDownLeft-33-";
      localGameParams.animojiExpressionMap += "mouthLowerDownRight-34-";
      localGameParams.animojiExpressionMap += "mouthPressLeft-35-";
      localGameParams.animojiExpressionMap += "mouthPressRight-36-";
      localGameParams.animojiExpressionMap += "mouthPucker-37-";
      localGameParams.animojiExpressionMap += "mouthRight-38-";
      localGameParams.animojiExpressionMap += "mouthRollLower-39-";
      localGameParams.animojiExpressionMap += "mouthRollUpper-40-";
      localGameParams.animojiExpressionMap += "mouthShrugLower-41-";
      localGameParams.animojiExpressionMap += "mouthShrugUpper-42-";
      localGameParams.animojiExpressionMap += "mouthSmileLeft-43-";
      localGameParams.animojiExpressionMap += "mouthSmileRight-44-";
      localGameParams.animojiExpressionMap += "mouthStretchLeft-45-";
      localGameParams.animojiExpressionMap += "mouthStretchRight-46-";
      localGameParams.animojiExpressionMap += "mouthUpperUpLeft-47-";
      localGameParams.animojiExpressionMap += "mouthUpperUpRight-48-";
      localGameParams.animojiExpressionMap += "noseSneerLeft-49-";
      localGameParams.animojiExpressionMap += "noseSneerRight-50";
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.ANIMOJI_FIELD.BLEND_SHAPE_ADJUST_FACTOR.value);
      if (paramJsonObject != null)
      {
        localGameParams.expressionAdjustFactorMap = new HashMap();
        i = 0;
        while (i < paramJsonObject.size())
        {
          localObject1 = new Range();
          localObject2 = GsonUtils.optJsonObject(paramJsonObject, i).getAsJsonArray(VideoMaterialUtil.ANIMOJI_FIELD.SHAPE_RANGE.value);
          ((Range)localObject1).min = ((float)GsonUtils.optDouble((JsonArray)localObject2, 0));
          ((Range)localObject1).max = ((float)GsonUtils.optDouble((JsonArray)localObject2, 1));
          localObject2 = GsonUtils.optString(GsonUtils.optJsonObject(paramJsonObject, i), VideoMaterialUtil.ANIMOJI_FIELD.SHAPE_NAME.value);
          localGameParams.expressionAdjustFactorMap.put(localObject2, localObject1);
          i += 1;
        }
      }
    }
    paramVideoMaterial.setGameParams(localGameParams);
  }
  
  public static VideoMaterial parseGestureMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {
      return paramVideoMaterial;
    }
    try
    {
      paramVideoMaterial.gestureAnimGapTime = GsonUtils.optInt(paramJsonObject, "gestureAnimGapTime");
      paramVideoMaterial.gestureAnimType = GsonUtils.optInt(paramJsonObject, "gestureAnimType");
      paramVideoMaterial.gesturePointIndex = GsonUtils.optInt(paramJsonObject, "gesturePointIndex");
      return paramVideoMaterial;
    }
    catch (Exception paramJsonObject)
    {
      paramJsonObject = paramJsonObject;
      paramJsonObject.printStackTrace();
      return paramVideoMaterial;
    }
    finally {}
    return paramVideoMaterial;
  }
  
  private static void parseGlbParams(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    boolean bool;
    label40:
    label64:
    ArrayList localArrayList;
    int i;
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0)
    {
      bool = true;
      paramVideoMaterial.setFlattenEar(bool);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
        break label398;
      }
      bool = true;
      paramVideoMaterial.setFlattenNose(bool);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GLB_FIELD.HIDE_USER_HEAD_MODEL.value, 0) != 1) {
        break label404;
      }
      bool = true;
      paramVideoMaterial.setHideUserHeadModel(bool);
      paramVideoMaterial.setTransformAdjustAlpha((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.GLB_FIELD.TRANSFORM_ADJUST_ALPHA.value, 1.0D));
      paramVideoMaterial.setFov((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.GLB_FIELD.FOV.value, 60.0D));
      localArrayList = new ArrayList();
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.GLB_LIST.value);
      if (paramJsonObject == null) {
        break label910;
      }
      i = 0;
    }
    for (;;)
    {
      if (i >= paramJsonObject.size()) {
        break label910;
      }
      JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, i);
      if (localJsonObject != null)
      {
        GLBItemJava localGLBItemJava = new GLBItemJava();
        localGLBItemJava.folder = paramString;
        localGLBItemJava.path = getFullPath(paramString, GsonUtils.optString(localJsonObject, VideoMaterialUtil.GLB_FIELD.PATH.value, ""));
        Object localObject1 = GsonUtils.optString(localJsonObject, VideoMaterialUtil.GLB_FIELD.IBLPATH.value, "");
        localGLBItemJava.blendShapeAdjustAlpha = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.GLB_FIELD.BLEND_ALPHA.value, 0.7D));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localGLBItemJava.iblPath = getFullPath(paramString, (String)localObject1);
        }
        localGLBItemJava.iblIntensity = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.IBL_INTENSITY.value, 110000);
        localGLBItemJava.order = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.ORDER.value, 0);
        localGLBItemJava.iblRotation = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.IBL_ROTATION.value, 0);
        localGLBItemJava.enableSSAO = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.ENABLE_SSAO.value, 0);
        localGLBItemJava.positionType = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.POSITION_TYPE.value, 0);
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.TRANSLATE.value);
        int j;
        if (localObject1 != null)
        {
          j = 0;
          for (;;)
          {
            if ((j < ((JsonArray)localObject1).size()) && (j < 3))
            {
              localGLBItemJava.translate[j] = ((float)GsonUtils.optDouble((JsonArray)localObject1, j));
              j += 1;
              continue;
              bool = false;
              break;
              label398:
              bool = false;
              break label40;
              label404:
              bool = false;
              break label64;
            }
          }
        }
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.SCALE.value);
        if (localObject1 != null)
        {
          j = 0;
          while ((j < ((JsonArray)localObject1).size()) && (j < 3))
          {
            localGLBItemJava.scale[j] = ((float)GsonUtils.optDouble((JsonArray)localObject1, j));
            j += 1;
          }
        }
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.ROTATE.value);
        if (localObject1 != null)
        {
          j = 0;
          while ((j < ((JsonArray)localObject1).size()) && (j < 3))
          {
            localGLBItemJava.rotate[j] = ((float)GsonUtils.optDouble((JsonArray)localObject1, j));
            j += 1;
          }
        }
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.ROTATE_TYPE.value);
        if (localObject1 != null)
        {
          j = 0;
          while ((j < ((JsonArray)localObject1).size()) && (j < 3))
          {
            localGLBItemJava.rotateType[j] = GsonUtils.optInt((JsonArray)localObject1, j, 1);
            j += 1;
          }
        }
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.FLIP.value);
        if (localObject1 != null)
        {
          j = 0;
          while ((j < ((JsonArray)localObject1).size()) && (j < 3))
          {
            localGLBItemJava.flip[j] = GsonUtils.optInt((JsonArray)localObject1, j);
            j += 1;
          }
        }
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.EYE_NODE_LIST.value);
        if (localObject1 != null)
        {
          j = 0;
          while (j < ((JsonArray)localObject1).size())
          {
            localObject2 = new EyeNodeItem();
            Object localObject3 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
            ((EyeNodeItem)localObject2).name = GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.GLB_FIELD.NAME.value, "");
            localObject3 = GsonUtils.optJsonArray((JsonObject)localObject3, VideoMaterialUtil.GLB_FIELD.EULER_ANGLES.value);
            if (localObject3 != null)
            {
              int k = 0;
              while ((k < ((JsonArray)localObject1).size()) && (k < 3))
              {
                ((EyeNodeItem)localObject2).eulerAngles[j] = ((float)GsonUtils.optDouble((JsonArray)localObject3, k, 0.0D));
                k += 1;
              }
            }
            localGLBItemJava.eyeNodeList.add(localObject2);
            j += 1;
          }
        }
        localObject1 = parseNodeItems(localJsonObject);
        Object localObject2 = parseDynamicBoneItems(localJsonObject);
        localGLBItemJava.lightItem = parseLightItem(localJsonObject);
        localGLBItemJava.nodeList = ((List)localObject1);
        localGLBItemJava.dynamicBoneItems = ((List)localObject2);
        localGLBItemJava.bloom = parseBloomParam(localJsonObject);
        localGLBItemJava.charmRange = parseCharmRange(localJsonObject);
        localGLBItemJava.triggerCtrlItem = new TriggerCtrlItem(localGLBItemJava);
        localGLBItemJava.animationList = parseAnimationItems(paramVideoMaterial, localJsonObject);
        localArrayList.add(localGLBItemJava);
      }
      i += 1;
    }
    label910:
    paramVideoMaterial.setGlbList(localArrayList);
  }
  
  public static GPUParticleConfig parseGpuParticleConfig(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString2 = readMaterialFile(paramString1, paramString2, true, paramDecryptListener);
    LogUtils.i(TAG, "[parseVideoMaterialFileAsJSONObject] dataStr = " + paramString2);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        paramString1 = GsonUtils.json2JsonObject(paramString2);
        if (paramString1 == null) {
          break;
        }
        paramDecryptListener = new GPUParticleConfig();
        paramDecryptListener.jsonBytes = paramString2.getBytes();
        paramDecryptListener.emitterType = GsonUtils.optInt(paramString1, "emitterType", 0);
        paramDecryptListener.sprites = parseGpuSpriteList(paramString1);
        paramDecryptListener.svg = GsonUtils.optString(paramString1, "particlePath", "");
        return paramDecryptListener;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      paramString1 = null;
    }
  }
  
  private static GPUParticleConfig.Sprite parseGpuSprite(JsonObject paramJsonObject)
  {
    GPUParticleConfig.Sprite localSprite = new GPUParticleConfig.Sprite();
    localSprite.path = GsonUtils.optString(paramJsonObject, "path");
    return localSprite;
  }
  
  private static List<GPUParticleConfig.Sprite> parseGpuSpriteList(JsonObject paramJsonObject)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "spriteList");
    ArrayList localArrayList = new ArrayList();
    if (paramJsonObject == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJsonObject.size())
    {
      JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, i);
      if (localJsonObject != null) {
        localArrayList.add(parseGpuSprite(localJsonObject));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static void parseGridViewerItems(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    paramVideoMaterial.setGridModel(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.GRID_MODEL.value));
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.GRID_VIEWER.value);
    ArrayList localArrayList = new ArrayList();
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        GridViewerItem localGridViewerItem = new GridViewerItem();
        JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localJsonObject != null)
        {
          localGridViewerItem.importMaterial = parseVideoMaterial(paramString, GsonUtils.optString(localJsonObject, "importMaterial"), true, paramDecryptListener);
          if (VideoMaterialUtil.isWatermarkMaterial(localGridViewerItem.importMaterial)) {
            LogicDataManager.getInstance().init(localGridViewerItem.importMaterial);
          }
          localGridViewerItem.renderId = GsonUtils.optInt(localJsonObject, "renderId");
        }
        localArrayList.add(localGridViewerItem);
        i += 1;
      }
    }
    paramVideoMaterial.setGridViewerItemList(localArrayList);
  }
  
  private static void parseHeadCropItemListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int j;
      try
      {
        localArrayList = new ArrayList();
        Object localObject1 = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_HEAD_CROP_ITEM_LIST.value);
        if (localObject1 != null)
        {
          k = -1;
          j = 0;
          paramJsonObject = "";
          i = 0;
          m = 0;
          if (m >= ((JsonArray)localObject1).size()) {
            break label746;
          }
          Object localObject2 = GsonUtils.getJsonObjectUnsafe((JsonArray)localObject1, m);
          StickerItem localStickerItem = new StickerItem();
          localStickerItem.id = GsonUtils.optString((JsonObject)localObject2, "id");
          localStickerItem.subFolder = localStickerItem.id;
          localStickerItem.type = GsonUtils.optInt((JsonObject)localObject2, "type");
          localStickerItem.setTriggerType(GsonUtils.optString((JsonObject)localObject2, "triggerType"));
          if (GsonUtils.optInt((JsonObject)localObject2, "alwaysTriggered") != 1) {
            break label717;
          }
          bool = true;
          localStickerItem.alwaysTriggered = bool;
          localStickerItem.featureStatType = GsonUtils.optInt((JsonObject)localObject2, "featureStatType");
          localStickerItem.playCount = GsonUtils.optInt((JsonObject)localObject2, "playCount");
          localStickerItem.externalTriggerWords = GsonUtils.optString((JsonObject)localObject2, "externalTriggerWords");
          paramJsonObject = localStickerItem.externalTriggerWords;
          if (VideoMaterialUtil.isActionTriggerType(localStickerItem.getTriggerTypeInt())) {
            paramVideoMaterial.setTriggerType(localStickerItem.getTriggerTypeInt());
          }
          localStickerItem.frameType = GsonUtils.optInt((JsonObject)localObject2, "frameType");
          localStickerItem.frameDuration = GsonUtils.optDouble((JsonObject)localObject2, "frameDuration");
          localStickerItem.frames = GsonUtils.optInt((JsonObject)localObject2, "frames");
          localStickerItem.width = GsonUtils.optInt((JsonObject)localObject2, "width");
          localStickerItem.height = GsonUtils.optInt((JsonObject)localObject2, "height");
          localStickerItem.extraTypeWidth = GsonUtils.optInt((JsonObject)localObject2, "extraTypeWidth");
          localStickerItem.extarTypeHeight = GsonUtils.optInt((JsonObject)localObject2, "extraTypeHeight");
          JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, "position");
          if (localJsonArray != null)
          {
            localStickerItem.position = new double[localJsonArray.size()];
            n = 0;
            if (n < localJsonArray.size())
            {
              localStickerItem.position[n] = GsonUtils.getDoubleUnsafe(localJsonArray, n);
              n += 1;
              continue;
            }
          }
          else
          {
            localStickerItem.position = new double[] { 0.0D, 0.0D };
          }
          localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, "scalePivots");
          if (localJsonArray != null)
          {
            localStickerItem.scalePivots = new int[localJsonArray.size()];
            n = 0;
            if (n < localJsonArray.size())
            {
              localStickerItem.scalePivots[n] = GsonUtils.getIntUnsafe(localJsonArray, n);
              n += 1;
              continue;
            }
          }
          localStickerItem.scaleFactor = GsonUtils.optInt((JsonObject)localObject2, "scaleFactor");
          localStickerItem.blendMode = GsonUtils.optInt((JsonObject)localObject2, "blendMode", -1);
          if (localStickerItem.blendMode == -1) {
            localStickerItem.blendMode = paramVideoMaterial.getBlendMode();
          }
          localStickerItem.support3D = GsonUtils.optInt((JsonObject)localObject2, "enable3D", 1);
          localStickerItem.personID = GsonUtils.optInt((JsonObject)localObject2, "personID", -1);
          localStickerItem.genderType = GsonUtils.optInt((JsonObject)localObject2, "genderType", 0);
          if (localStickerItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localStickerItem.activateTriggerCount = GsonUtils.optInt((JsonObject)localObject2, "activateTriggerCount", 0);
          localStickerItem.activateTriggerTotalCount = GsonUtils.optInt((JsonObject)localObject2, "activateTriggerTotalCount", 0);
          localStickerItem.framePositionsBean = parseFramePosition(paramVideoMaterial, (JsonObject)localObject2);
          localArrayList.add(localStickerItem);
          if (k == -1)
          {
            n = localStickerItem.getTriggerTypeInt();
            k = i;
            i = n;
            if (GsonUtils.optInt((JsonObject)localObject2, "isElementTriggerMVPart", 0) == 0) {
              break label723;
            }
            j = localStickerItem.getTriggerTypeInt();
            break label723;
          }
          n = Math.max(i, localStickerItem.getTriggerTypeInt());
          i = k;
          k = n;
          continue;
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StickerItem)((Iterator)localObject1).next();
            ((StickerItem)localObject2).preTriggerType = k;
            ((StickerItem)localObject2).countTriggerType = i;
            ((StickerItem)localObject2).countExternalTriggerWords = paramJsonObject;
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramJsonObject)
      {
        LogUtils.e(TAG, paramJsonObject);
      }
      paramVideoMaterial.setHeadCropItemList(localArrayList);
      return;
      label717:
      boolean bool = false;
      continue;
      label723:
      int n = m + 1;
      int m = k;
      int k = i;
      int i = m;
      m = n;
      continue;
      label746:
      if (j > 0) {
        i = j;
      }
    }
  }
  
  private static ImageMaskItem parseImageMask(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    if (paramJsonObject == null) {
      return null;
    }
    ImageMaskItem localImageMaskItem = new ImageMaskItem();
    localImageMaskItem.setDataPath(paramVideoMaterial.getDataPath());
    localImageMaskItem.setMaskId(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.IMAGE_MASK_ITEM_FIELD.MASK_ID.value));
    localImageMaskItem.setFrames(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.IMAGE_MASK_ITEM_FIELD.FRAMES_COUNT.value));
    localImageMaskItem.setFrameDurationn(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.IMAGE_MASK_ITEM_FIELD.FRAMES_DURATION.value));
    localImageMaskItem.setPlayCount(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.IMAGE_MASK_ITEM_FIELD.PLAY_COUNT.value));
    return localImageMaskItem;
  }
  
  private static void parseImageMaskItemListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "imageMaskList");
    ArrayList localArrayList = new ArrayList();
    if (paramJsonObject == null)
    {
      paramVideoMaterial.setImageMaskItemList(localArrayList);
      return;
    }
    int i = 0;
    while (i < paramJsonObject.size())
    {
      Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
      if (localObject != null)
      {
        localObject = parseImageMask((JsonObject)localObject, paramVideoMaterial);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramVideoMaterial.setImageMaskItemList(localArrayList);
  }
  
  private static List<StickerItem> parseItemListParams(String paramString, JsonArray paramJsonArray, int paramInt1, VideoMaterial paramVideoMaterial, int paramInt2, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt, DecryptListener paramDecryptListener)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    ArrayList localArrayList2;
    int i;
    ArrayList localArrayList1;
    int k;
    int j;
    Object localObject2;
    StickerItem localStickerItem;
    String str;
    boolean bool;
    label795:
    int m;
    Object localObject3;
    for (;;)
    {
      try
      {
        localHashMap1 = new HashMap();
        localHashMap2 = new HashMap();
        localArrayList2 = new ArrayList();
        if (paramJsonArray != null)
        {
          i = 0;
          localArrayList1 = null;
          k = 0;
          j = 0;
          localObject1 = "";
          if (k >= paramJsonArray.size()) {
            break label4356;
          }
          localObject2 = GsonUtils.getJsonObjectUnsafe(paramJsonArray, k);
          localStickerItem = new StickerItem();
          localStickerItem.id = GsonUtils.optString((JsonObject)localObject2, "id");
          localStickerItem.subFolder = localStickerItem.id;
          localStickerItem.name = GsonUtils.optString((JsonObject)localObject2, "name");
          localStickerItem.type = GsonUtils.optInt((JsonObject)localObject2, "type");
          localStickerItem.scale = ((float)GsonUtils.optDouble((JsonObject)localObject2, "scale", 1.0D));
          localStickerItem.angle = ((float)GsonUtils.optDouble((JsonObject)localObject2, "angle", 0.0D));
          localStickerItem.dx = GsonUtils.optInt((JsonObject)localObject2, "dx", 0);
          localStickerItem.dy = GsonUtils.optInt((JsonObject)localObject2, "dy", 0);
          localStickerItem.personID = GsonUtils.optInt((JsonObject)localObject2, "personID", -1);
          localStickerItem.genderType = GsonUtils.optInt((JsonObject)localObject2, "genderType", 0);
          localStickerItem.alpha = ((float)GsonUtils.optDouble((JsonObject)localObject2, "alpha", 1.0D));
          localStickerItem.snapshotTime = GsonUtils.optInt((JsonObject)localObject2, "snapshotTime", 0);
          if (localStickerItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localStickerItem.featureStatType = GsonUtils.optInt((JsonObject)localObject2, "featureStatType");
          localStickerItem.frameType = GsonUtils.optInt((JsonObject)localObject2, "frameType");
          localStickerItem.blendMode = GsonUtils.optInt((JsonObject)localObject2, "blendMode", -1);
          localStickerItem.zIndex = GsonUtils.optInt((JsonObject)localObject2, "zIndex");
          localStickerItem.audioLoopCount = GsonUtils.optInt((JsonObject)localObject2, "audioLoopCount", -1);
          localStickerItem.randomGroupNum = GsonUtils.optInt((JsonObject)localObject2, "randomGroupNum");
          localStickerItem.externalTriggerWords = GsonUtils.optString((JsonObject)localObject2, "externalTriggerWords");
          str = localStickerItem.externalTriggerWords;
          localStickerItem.triggerState = new ArrayList();
          localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "triggerStateList");
          if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0))
          {
            j = 0;
            if (j < ((JsonArray)localObject1).size())
            {
              localStickerItem.triggerState.add(GsonUtils.getStringUnsafe((JsonArray)localObject1, j));
              j += 1;
              continue;
            }
          }
          else
          {
            localObject1 = GsonUtils.optString((JsonObject)localObject2, "triggerState");
            if ((localObject1 != null) && (!"".equals(localObject1))) {
              localStickerItem.triggerState.add(localObject1);
            }
          }
          localStickerItem.triggerMode = GsonUtils.optInt((JsonObject)localObject2, "triggerMode", 0);
          localStickerItem.playMode = GsonUtils.optInt((JsonObject)localObject2, "playMode", 0);
          localStickerItem.triggerFingerIndex = GsonUtils.optInt((JsonObject)localObject2, "triggerFingerIndex", 0);
          localStickerItem.fingerMusicClockTime = GsonUtils.optFloat((JsonObject)localObject2, "playBPM", 0.0F);
          localStickerItem.playBPM = GsonUtils.optInt((JsonObject)localObject2, "playBPM", 0);
          if (localStickerItem.fingerMusicClockTime > 0.0F) {
            TouchTriggerManager.getInstance().setBgmClockTime(localStickerItem.fingerMusicClockTime);
          }
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "triggerStateRange");
          if (localObject1 != null)
          {
            localStickerItem.triggerStateRange = new StickerItem.ValueRange();
            localStickerItem.triggerStateRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min", 1.0D);
            localStickerItem.triggerStateRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max", 0.0D);
          }
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "featureStatValueRange");
          if (localObject1 != null)
          {
            localStickerItem.featureStatValueRange = new StickerItem.ValueRange();
            localStickerItem.featureStatValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
            localStickerItem.featureStatValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
          }
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject1 != null)
          {
            localStickerItem.charmRange = new CharmRange();
            localStickerItem.charmRange.min = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localStickerItem.charmRange.max = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          if (localStickerItem.blendMode == -1) {
            localStickerItem.blendMode = paramInt2;
          }
          localStickerItem.setTriggerType(GsonUtils.optString((JsonObject)localObject2, "triggerType"));
          localStickerItem.audioTriggerType = GsonUtils.optInt((JsonObject)localObject2, "audioTriggerType");
          if (GsonUtils.optInt((JsonObject)localObject2, "audioNeedAdjust", 1) != 1) {
            break label4294;
          }
          bool = true;
          localStickerItem.audioNeedAdjust = bool;
          if (GsonUtils.optInt((JsonObject)localObject2, "orderMode", 1) == 1)
          {
            localStickerItem.orderMode = VideoMaterialUtil.STICKER_ORDER_MODE.AFTER_TRANSFORM;
            localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "audioValueRange");
            if (localObject1 != null)
            {
              localStickerItem.audioValueRange = new StickerItem.ValueRange();
              localStickerItem.audioValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
              localStickerItem.audioValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
            }
            if ((VideoMaterialUtil.isActionTriggerType(localStickerItem.getTriggerTypeInt())) && (paramArrayOfInt != null)) {
              paramArrayOfInt[0] = localStickerItem.getTriggerTypeInt();
            }
            if (GsonUtils.optInt((JsonObject)localObject2, "alwaysTriggered") == 1)
            {
              bool = true;
              localStickerItem.alwaysTriggered = bool;
              localStickerItem.playCount = GsonUtils.optInt((JsonObject)localObject2, "playCount");
              localStickerItem.comicOrderMode = GsonUtils.optInt((JsonObject)localObject2, "comicOrderMode", 1);
              localStickerItem.comicLutFilter = GsonUtils.optString((JsonObject)localObject2, "comicLutFilter");
              localStickerItem.triggerFrameDurationTime = GsonUtils.optInt((JsonObject)localObject2, "triggerFrameDurationTime");
              localStickerItem.triggedTimes = GsonUtils.optInt((JsonObject)localObject2, "triggeredTimes");
              localStickerItem.delayedTriggedTime = GsonUtils.optInt((JsonObject)localObject2, "triggeredDelayTime");
              localStickerItem.frameDuration = GsonUtils.optDouble((JsonObject)localObject2, "frameDuration");
              localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "triggerFrameStartTime");
              if (localObject1 == null) {
                break label1527;
              }
              m = ((JsonArray)localObject1).size();
              if (m <= 1) {
                break label1513;
              }
              localObject3 = new long[m];
              j = 0;
              if (j >= m) {
                break;
              }
              localObject3[j] = ((GsonUtils.optInt((JsonArray)localObject1, j) * localStickerItem.frameDuration));
              j += 1;
              continue;
            }
          }
          else
          {
            localStickerItem.orderMode = VideoMaterialUtil.STICKER_ORDER_MODE.BEFORE_TRANSFORM;
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramString)
      {
        LogUtils.e(TAG, paramString);
      }
      bool = false;
    }
    localStickerItem.triggerTimeUpdater = new TriggerTimeUpdater((long[])localObject3, (localStickerItem.delayedTriggedTime * localStickerItem.frameDuration), (localStickerItem.triggerFrameDurationTime * localStickerItem.frameDuration));
    localStickerItem.triggerFrameStartTime = ((int)(localStickerItem.triggerTimeUpdater.updateCurTriggerTime(-1L, 0L, false) / localStickerItem.frameDuration));
    localStickerItem.stickerType = GsonUtils.optInt((JsonObject)localObject2, "stickerType", paramInt1);
    localStickerItem.transformType = GsonUtils.optInt((JsonObject)localObject2, "transformType", 0);
    localStickerItem.needHandRotation = GsonUtils.optInt((JsonObject)localObject2, "needHandRotation", 0);
    if ((localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type)) {
      if (localStickerItem.stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
        break label1543;
      }
    }
    Object localObject4;
    label1543:
    for (Object localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;; localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT)
    {
      localStickerItem.sourceType = ((VideoMaterialUtil.ITEM_SOURCE_TYPE)localObject1);
      if (VideoFilterFactory.STICKER_TYPE.FREEZE_FRAME.type == localStickerItem.stickerType) {
        paramVideoMaterial.setNeedFreezeFrame(true);
      }
      localStickerItem.frames = GsonUtils.optInt((JsonObject)localObject2, "frames");
      localStickerItem.width = GsonUtils.optInt((JsonObject)localObject2, "width");
      localStickerItem.height = GsonUtils.optInt((JsonObject)localObject2, "height");
      localStickerItem.extraTypeWidth = GsonUtils.optInt((JsonObject)localObject2, "extraTypeWidth");
      localStickerItem.extarTypeHeight = GsonUtils.optInt((JsonObject)localObject2, "extraTypeHeight");
      localStickerItem.maxScaledWidth = GsonUtils.optInt((JsonObject)localObject2, "maxScaledWidth");
      localStickerItem.minScaledWidth = GsonUtils.optInt((JsonObject)localObject2, "minScaledWidth");
      localStickerItem.support3D = GsonUtils.optInt((JsonObject)localObject2, "enable3D", 1);
      localStickerItem.scaleDirection = GsonUtils.optInt((JsonObject)localObject2, "scaleDirection");
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "zoomScale");
      if (localObject1 == null) {
        break label1562;
      }
      localObject3 = ((JsonObject)localObject1).keySet().iterator();
      localStickerItem.zoomScale = new ArrayList();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localStickerItem.zoomScale.add(Pair.create(Float.valueOf((String)localObject4), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject4, 0.0D))));
      }
      label1513:
      localStickerItem.triggerFrameStartTime = GsonUtils.optInt((JsonArray)localObject1, 0);
      break;
      label1527:
      localStickerItem.triggerFrameStartTime = GsonUtils.optInt((JsonObject)localObject2, "triggerFrameStartTime");
      break;
    }
    Collections.sort(localStickerItem.zoomScale, mRangeValueComp);
    label1562:
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "activeParts");
    if (localObject1 != null)
    {
      localStickerItem.activeParts = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.activeParts[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localStickerItem.zoomType = GsonUtils.optInt((JsonObject)localObject2, "zoomType");
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "zoomFocusPoint");
    if (localObject1 != null)
    {
      localStickerItem.zoomFocusPoint = new float[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.zoomFocusPoint[j] = ((float)GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j));
        j += 1;
      }
    }
    localStickerItem.zoomWidth = ((float)GsonUtils.optDouble((JsonObject)localObject2, "zoomWidth"));
    localStickerItem.zoomHeight = ((float)GsonUtils.optDouble((JsonObject)localObject2, "zoomHeight"));
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "position");
    if (localObject1 != null)
    {
      localStickerItem.position = new double[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.position[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localStickerItem.position = new double[] { 0.0D, 0.0D };
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "rotateType");
    localStickerItem.rotateType = new int[] { 0, 0 };
    if (localObject1 != null)
    {
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.rotateType[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localStickerItem.audio = GsonUtils.optString((JsonObject)localObject2, "audio");
    localStickerItem.lutFilterName = GsonUtils.optString((JsonObject)localObject2, "lutFilterName");
    localStickerItem.filterOrderMode = GsonUtils.optInt((JsonObject)localObject2, "filterOrderMode", 0);
    localStickerItem.filterAlphaGradientDuration = GsonUtils.optDouble((JsonObject)localObject2, "filterAlphaGradientDuration", 1.0D);
    if ((!TextUtils.isEmpty(localStickerItem.audio)) && (paramArrayOfBoolean != null)) {
      paramArrayOfBoolean[0] = true;
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "frameSize");
    if (localObject1 != null)
    {
      localStickerItem.frameSize = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.frameSize[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "anchorPoint");
    if (localObject1 != null)
    {
      localStickerItem.anchorPoint = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.anchorPoint[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "anchorPointAudio");
    if (localObject1 != null)
    {
      localStickerItem.anchorPointAudio = new double[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.anchorPointAudio[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localStickerItem.anchorPointAudio = new double[] { 0.5D, 0.5D };
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "alignFacePoints");
    if (localObject1 != null)
    {
      localStickerItem.alignFacePoints = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.alignFacePoints[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "scalePivots");
    if (localObject1 != null)
    {
      localStickerItem.scalePivots = new int[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.scalePivots[j] = GsonUtils.getIntUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
    }
    localStickerItem.scaleFactor = GsonUtils.optInt((JsonObject)localObject2, "scaleFactor");
    localStickerItem.originalScaleFactor = localStickerItem.scaleFactor;
    localStickerItem.markMode = GsonUtils.optInt((JsonObject)localObject2, "markMode");
    localStickerItem.lazyLoad = GsonUtils.optInt((JsonObject)localObject2, "lazyLoadFlag");
    localStickerItem.activateTriggerType = GsonUtils.optInt((JsonObject)localObject2, "activateTriggerType", 0);
    localStickerItem.activateTriggerCount = GsonUtils.optInt((JsonObject)localObject2, "activateTriggerCount", 0);
    localStickerItem.activateTriggerTotalCount = GsonUtils.optInt((JsonObject)localObject2, "activateTriggerTotalCount", 0);
    localStickerItem.lockTriggerCountUntilFail = GsonUtils.optInt((JsonObject)localObject2, "lockTriggerCountUntilFail", 0);
    localStickerItem.bodyTriggerPoint = GsonUtils.optInt((JsonObject)localObject2, "bodyTriggerPoint", 0);
    localStickerItem.bodyTriggerDirection = GsonUtils.optInt((JsonObject)localObject2, "bodyTriggerDirection", 0);
    localStickerItem.bodyTriggerDistance = GsonUtils.optInt((JsonObject)localObject2, "bodyTriggerDistance", 0);
    localStickerItem.bodyTriggerTimeGap = GsonUtils.optDouble((JsonObject)localObject2, "bodyTriggerTimeGap", 0.0D);
    localStickerItem.relativeScaleType = GsonUtils.optInt((JsonObject)localObject2, "relativeScaleType");
    label2484:
    label2937:
    int n;
    label3229:
    label4001:
    if (GsonUtils.optInt((JsonObject)localObject2, "orienting") == 1)
    {
      bool = true;
      localStickerItem.orienting = bool;
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "ageRange");
      if (localObject1 != null)
      {
        localStickerItem.ageRange = new AgeRange();
        localStickerItem.ageRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.ageRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "genderRange");
      if (localObject1 != null)
      {
        localStickerItem.genderRange = new GenderRange();
        localStickerItem.genderRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.genderRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "popularRange");
      if (localObject1 != null)
      {
        localStickerItem.popularRange = new PopularRange();
        localStickerItem.popularRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.popularRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "cpRange");
      if (localObject1 != null)
      {
        localStickerItem.cpRange = new CpRange();
        localStickerItem.cpRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.cpRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "audioScaleFactor");
      if (localObject1 != null)
      {
        localObject3 = ((JsonObject)localObject1).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localStickerItem.audioScaleFactorMap.add(Pair.create(Float.valueOf((String)localObject4), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject4, 0.0D))));
        }
      }
      Collections.sort(localStickerItem.audioScaleFactorMap, mRangeValueComp);
      localObject1 = GsonUtils.optJsonObject((JsonObject)localObject2, "transition");
      if (localObject1 != null)
      {
        localStickerItem.transition = new Transition();
        localStickerItem.transition.particleCountMax = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_COUNT_MAX.value);
        localStickerItem.transition.life = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.LIFE.value);
        localStickerItem.transition.emissionMode = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.EMISSION_MODE.value);
        localObject3 = localStickerItem.transition;
        if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_ALWAYS_UPDATE.value) != 1) {
          break label4306;
        }
        bool = true;
        ((Transition)localObject3).particleAlwaysUpdate = bool;
        localStickerItem.transition.emissionRate = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.EMISSION_RATE.value);
        localStickerItem.transition.scale = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.SCALE.value);
        localStickerItem.transition.rotate = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.ROTATE.value);
        localStickerItem.transition.positionX = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.POSITION_X.value);
        localStickerItem.transition.positionY = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.POSITION_Y.value);
        localStickerItem.transition.p0 = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.P0.value);
        localStickerItem.transition.p1 = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.P1.value);
        localStickerItem.transition.p2 = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.P2.value);
        localStickerItem.transition.repeatCount = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.REPEAT_COUNT.value, 1);
        localStickerItem.transition.minUpdateInterval = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.MIN_UPDATE_INTERVAL.value, 1);
        localStickerItem.transition.clearMode = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.CLEAR_MODE.value, 0);
        localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
        if (localObject1 != null)
        {
          localStickerItem.wmGroupConfigCopies = new ArrayList();
          j = 0;
          for (;;)
          {
            n = localStickerItem.transition.particleCountMax / localStickerItem.transition.repeatCount;
            if (localStickerItem.transition.clearMode != VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) {
              break label4312;
            }
            m = 1;
            if (j >= m + n) {
              break;
            }
            localObject3 = parseWMGroupConfig((JsonArray)localObject1, paramVideoMaterial);
            ((WMGroupConfig)localObject3).id = j;
            localStickerItem.wmGroupConfigCopies.add(localObject3);
            j += 1;
          }
        }
      }
      else
      {
        localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
        if (localObject1 != null) {
          localStickerItem.wmGroupConfig = parseWMGroupConfig((JsonArray)localObject1, paramVideoMaterial);
        }
      }
      localStickerItem.triggerWords = GsonUtils.optString((JsonObject)localObject2, "triggerWords");
      localStickerItem.preTriggerType = localStickerItem.getTriggerTypeInt();
      localStickerItem.dexName = GsonUtils.optString((JsonObject)localObject2, "dexName");
      localArrayList2.add(localStickerItem);
      n = localStickerItem.getTriggerTypeInt();
      if (GsonUtils.optInt((JsonObject)localObject2, "isElementTriggerMVPart", 0) != 0) {
        i = localStickerItem.getTriggerTypeInt();
      }
      localObject1 = paramString + File.separator + localStickerItem.id + File.separator + GsonUtils.optString((JsonObject)localObject2, "dexName");
      if (localHashMap1.containsKey(localObject1))
      {
        localStickerItem.particleConfig = ((ParticleConfig)localHashMap1.get(localObject1));
        localObject1 = paramString + File.separator + localStickerItem.id + File.separator + GsonUtils.optString((JsonObject)localObject2, "gpuParticleConfigFile");
        if (!localHashMap2.containsKey(localObject1)) {
          break label3857;
        }
        localStickerItem.gpuParticleConfig = ((GPUParticleConfig)localHashMap2.get(localObject1));
      }
      label3635:
      for (;;)
      {
        label3521:
        if (GsonUtils.optInt((JsonObject)localObject2, "followPhoneAngle", 0) == 1)
        {
          bool = true;
          label3537:
          localStickerItem.followPhoneAngle = bool;
          localStickerItem.strokeType = GsonUtils.optInt((JsonObject)localObject2, "strokeType", 0);
          localStickerItem.strokeStyle = GsonUtils.optInt((JsonObject)localObject2, "strokeStyle", 0);
          localStickerItem.strokeColor = StrokeUtil.parseRGBAColor(GsonUtils.optString((JsonObject)localObject2, "strokeColor", ""));
          localStickerItem.strokeWidth = GsonUtils.optDouble((JsonObject)localObject2, "strokeWidth", 0.0D);
          localStickerItem.strokeGap = GsonUtils.optDouble((JsonObject)localObject2, "strokeGap", 0.0D);
          if (GsonUtils.optInt((JsonObject)localObject2, "isStrokeBlur", 0) != 1) {
            break label4324;
          }
          bool = true;
          localStickerItem.isStrokeBlur = bool;
          localStickerItem.hairLutName = GsonUtils.optString((JsonObject)localObject2, "hairLutName");
          localStickerItem.hairMaskType = Integer.valueOf(GsonUtils.optInt((JsonObject)localObject2, "hairMaskType", 0));
          localStickerItem.needCrop = GsonUtils.optInt((JsonObject)localObject2, "needCrop", 0);
          localStickerItem.maskType = GsonUtils.optString((JsonObject)localObject2, "maskType");
          localStickerItem.maskLut = GsonUtils.optString((JsonObject)localObject2, "maskLut");
          localStickerItem.framePositionsBean = parseFramePosition(paramVideoMaterial, (JsonObject)localObject2);
          localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "hotArea");
          if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0))
          {
            localStickerItem.hotArea = new double[((JsonArray)localObject1).size()];
            j = 0;
            for (;;)
            {
              if (j < ((JsonArray)localObject1).size())
              {
                localStickerItem.hotArea[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
                j += 1;
                continue;
                localStickerItem.particleConfig = parseParticleConfig(paramString + File.separator + localStickerItem.id, GsonUtils.optString((JsonObject)localObject2, "dexName"), paramDecryptListener);
                localHashMap1.put(localObject1, localStickerItem.particleConfig);
                break;
                localStickerItem.gpuParticleConfig = parseGpuParticleConfig(paramString + File.separator + localStickerItem.id, GsonUtils.optString((JsonObject)localObject2, "gpuParticleConfigFile"), paramDecryptListener);
                localHashMap2.put(localObject1, localStickerItem.gpuParticleConfig);
                break label3521;
              }
            }
          }
          localStickerItem.redPacketStartFrame = GsonUtils.optInt((JsonObject)localObject2, "hotAreaStartFrame");
          localStickerItem.redPacketEndFrame = GsonUtils.optInt((JsonObject)localObject2, "hotAreaEndFrame");
          localStickerItem.activateTriggerCountOnce = GsonUtils.optInt((JsonObject)localObject2, "activateTriggerCountOnce");
          localStickerItem.triggerHandPoint = GsonUtils.optInt((JsonObject)localObject2, "triggerHandPoint");
          localObject1 = GsonUtils.optJsonArray((JsonObject)localObject2, "triggerAreas");
          if (localObject1 != null)
          {
            localStickerItem.triggerArea = new ArrayList();
            j = 0;
            if (j < ((JsonArray)localObject1).size())
            {
              localObject2 = new StickerItem.TriggerArea();
              localObject3 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
              if (localObject3 == null) {
                break label4330;
              }
              ((StickerItem.TriggerArea)localObject2).type = GsonUtils.optInt((JsonObject)localObject3, "type");
              localObject4 = GsonUtils.optJsonArray((JsonObject)localObject3, "rect");
              if (localObject4 != null)
              {
                ((StickerItem.TriggerArea)localObject2).rect = new float[((JsonArray)localObject4).size()];
                m = 0;
                while (m < ((JsonArray)localObject4).size())
                {
                  ((StickerItem.TriggerArea)localObject2).rect[m] = GsonUtils.getFloatSafe((JsonArray)localObject4, m);
                  m += 1;
                }
              }
              localObject3 = GsonUtils.optJsonArray((JsonObject)localObject3, "anchorPoints");
              if (localObject3 != null)
              {
                ((StickerItem.TriggerArea)localObject2).anchorPoint = new int[((JsonArray)localObject3).size()];
                m = 0;
                while (m < ((JsonArray)localObject3).size())
                {
                  ((StickerItem.TriggerArea)localObject2).anchorPoint[m] = GsonUtils.getIntUnsafe((JsonArray)localObject3, m);
                  m += 1;
                }
              }
              localStickerItem.triggerArea.add(localObject2);
              break label4330;
            }
            if (localStickerItem.triggerArea.size() > 0)
            {
              localArrayList1 = localStickerItem.triggerArea;
              break label4339;
            }
          }
        }
      }
    }
    for (;;)
    {
      label3857:
      label4210:
      paramString = localArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramJsonArray = (StickerItem)paramString.next();
        if (paramJsonArray.activateTriggerType == 0)
        {
          paramJsonArray.countTriggerType = paramInt1;
          paramJsonArray.activateTriggerArea = localArrayList1;
          paramJsonArray.countExternalTriggerWords = ((String)localObject1);
        }
        else
        {
          paramJsonArray.playCount = 0;
          paramJsonArray.countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
        }
      }
      return localArrayList2;
      label4294:
      label4306:
      label4312:
      label4324:
      label4330:
      label4339:
      do
      {
        paramInt1 = j;
        break label4210;
        break label4339;
        bool = false;
        break label795;
        bool = false;
        break label2484;
        bool = false;
        break label2937;
        m = 0;
        break label3229;
        bool = false;
        break label3537;
        bool = false;
        break label3635;
        j += 1;
        break label4001;
        k += 1;
        j = n;
        localObject1 = str;
        break;
      } while (i <= 0);
      label4356:
      paramInt1 = i;
    }
  }
  
  private static LightItem parseLightItem(JsonObject paramJsonObject)
  {
    int j = 0;
    Object localObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.GLB_FIELD.LIGHT.value);
    if (localObject == null) {
      return null;
    }
    paramJsonObject = new LightItem();
    paramJsonObject.castShadow = GsonUtils.optBoolean((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.CAST_SHADOW.value, false);
    paramJsonObject.intensity = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.INTENSITY.value, 110000);
    JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.COLOR.value);
    int i;
    if (localJsonArray != null)
    {
      i = 0;
      while ((i < localJsonArray.size()) && (i < 3))
      {
        paramJsonObject.color[i] = ((float)GsonUtils.optDouble(localJsonArray, i));
        i += 1;
      }
    }
    localObject = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.DIRECTION.value);
    if (localObject != null)
    {
      i = j;
      while ((i < ((JsonArray)localObject).size()) && (i < 3))
      {
        paramJsonObject.direction[i] = ((float)GsonUtils.optDouble((JsonArray)localObject, i));
        i += 1;
      }
    }
    return paramJsonObject;
  }
  
  public static VideoMaterial parseMultiPendantMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {
      return paramVideoMaterial;
    }
    for (;;)
    {
      int i;
      try
      {
        paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "children");
        if (paramJsonObject == null) {
          break;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < paramJsonObject.size())
        {
          Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
          if (localObject != null)
          {
            VideoMaterial.ChildPendant localChildPendant = new VideoMaterial.ChildPendant();
            localChildPendant.name = GsonUtils.optString((JsonObject)localObject, "name");
            localChildPendant.tips = GsonUtils.optString((JsonObject)localObject, "tips", "");
            localChildPendant.jumpType = GsonUtils.optInt((JsonObject)localObject, "jumpType");
            localChildPendant.randomType = GsonUtils.optInt((JsonObject)localObject, "randomType");
            localChildPendant.maxPlayTime = GsonUtils.optLong((JsonObject)localObject, "maxPlayTime", 0L);
            localChildPendant.depends = new ArrayList();
            JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, "depends");
            int j;
            if (localJsonArray != null)
            {
              j = 0;
              if (j < localJsonArray.size())
              {
                localChildPendant.depends.add(GsonUtils.optString(localJsonArray, j));
                j += 1;
                continue;
              }
            }
            localChildPendant.next = new ArrayList();
            localObject = GsonUtils.optJsonArray((JsonObject)localObject, "next");
            if (localObject != null)
            {
              j = 0;
              if (j < ((JsonArray)localObject).size())
              {
                localChildPendant.next.add(GsonUtils.optString((JsonArray)localObject, j));
                j += 1;
                continue;
              }
            }
            localArrayList.add(localChildPendant);
          }
        }
        else
        {
          paramVideoMaterial.setChildrenPendants(localArrayList);
        }
      }
      catch (Exception paramJsonObject)
      {
        paramJsonObject.printStackTrace();
      }
      finally
      {
        return paramVideoMaterial;
      }
      i += 1;
    }
  }
  
  private static List<NodeItemJava> parseNodeItems(JsonObject paramJsonObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.NODE_LIST.value);
    int i;
    int j;
    NodeItemJava localNodeItemJava;
    if (paramJsonObject != null)
    {
      int k = 0;
      i = 0;
      j = 0;
      while (k < paramJsonObject.size())
      {
        Object localObject = GsonUtils.optJsonObject(paramJsonObject, k);
        int m = i;
        if (localObject != null)
        {
          localNodeItemJava = new NodeItemJava();
          localNodeItemJava.name = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.NAME.value, "");
          localNodeItemJava.needFaceMesh = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.FACEMESH.value, 0);
          localNodeItemJava.content = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.CONTENT.value, "");
          localNodeItemJava.modelId = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.MODEL_ID.value, "");
          localNodeItemJava.triggerType = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.TRIGGER_TYPE.value, "");
          localNodeItemJava.externalTriggerWords = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.EXTERNAL_TRIGGER_WORDS.value, "");
          localNodeItemJava.frames = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.FRAMES.value, 1);
          localNodeItemJava.frameDuration = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.FRAME_DURATION.value, 1);
          localNodeItemJava.alwaysTriggered = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ALWAYS_TRIGGERED.value, 1);
          localNodeItemJava.playCount = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.PLAY_COUNT.value, 0);
          localNodeItemJava.rotateRequied = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ROTATE_REQUIRED.value, 1);
          localNodeItemJava.material = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.MATERIAL.value, "baseColorMap");
          localNodeItemJava.activateTriggerCount = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_COUNT.value, 0);
          localNodeItemJava.activateTriggerType = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_TYPE.value, 0);
          localNodeItemJava.activateTriggerTotalCount = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_TOTAL_COUNT.value, 0);
          localNodeItemJava.expressionConfigList = parseExpressionList((JsonObject)localObject);
          if (!GsonUtils.optBoolean((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.NEED_HIDE_ENTITY.value, false)) {}
          HashMap localHashMap;
          for (boolean bool = true;; bool = false)
          {
            localNodeItemJava.needShow = bool;
            m = localNodeItemJava.getTriggerTypeInt();
            if (GsonUtils.optInt((JsonObject)localObject, "isElementTriggerMVPart", 0) != 0) {
              i = localNodeItemJava.getTriggerTypeInt();
            }
            localHashMap = new HashMap();
            localObject = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.EXPRESSION_ORDER_LIST.value);
            if (localObject == null) {
              break;
            }
            j = 0;
            while (j < ((JsonArray)localObject).size())
            {
              localHashMap.put(GsonUtils.optString((JsonArray)localObject, j), Integer.valueOf(j));
              j += 1;
            }
          }
          localNodeItemJava.expressionOrderList = localHashMap;
          localArrayList.add(localNodeItemJava);
          j = m;
          m = i;
        }
        k += 1;
        i = m;
      }
    }
    for (;;)
    {
      if (i > 0) {
        j = i;
      }
      paramJsonObject = localArrayList.iterator();
      while (paramJsonObject.hasNext())
      {
        localNodeItemJava = (NodeItemJava)paramJsonObject.next();
        if (localNodeItemJava.activateTriggerType == 0)
        {
          localNodeItemJava.countTriggerType = j;
        }
        else
        {
          localNodeItemJava.playCount = 0;
          localNodeItemJava.countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
        }
      }
      return localArrayList;
      i = 0;
      j = 0;
    }
  }
  
  public static ParticleConfig parseParticleConfig(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    if (paramString2.endsWith("json")) {
      return ParticleJsonParser.parseParticleConfig(paramString1, paramString2);
    }
    return XmlParseUtils.parseParticleConfig(readPexFile(paramString1, paramString2, paramDecryptListener));
  }
  
  private static PhantomItem parsePhantomItem(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    if (paramJsonObject == null) {
      return null;
    }
    PhantomItem localPhantomItem = new PhantomItem();
    localPhantomItem.setDataPath(paramVideoMaterial.getDataPath());
    localPhantomItem.setId(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.ID.value));
    localPhantomItem.setMaskImage(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.MASK_IMAGE.value));
    localPhantomItem.setBlendMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.BLEND_MODE.value));
    localPhantomItem.setScale(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.SCALE.value));
    localPhantomItem.setOpacity(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.OPACITY.value));
    localPhantomItem.setxK(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_K.value));
    localPhantomItem.setxAsin(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_A_SIN.value));
    localPhantomItem.setxBcos(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_B_COS.value));
    localPhantomItem.setxPhase(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_PHASE.value));
    localPhantomItem.setxOffset(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_OFFSET.value));
    localPhantomItem.setxStep(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_STEP.value));
    paramVideoMaterial = new double[2];
    VideoMaterial tmp181_180 = paramVideoMaterial;
    tmp181_180[0] = 0.0D;
    VideoMaterial tmp185_181 = tmp181_180;
    tmp185_181[1] = 360.0D;
    tmp185_181;
    JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_RANGE.value);
    if (localJsonArray != null)
    {
      paramVideoMaterial[0] = GsonUtils.optDouble(localJsonArray, 0);
      paramVideoMaterial[1] = GsonUtils.optDouble(localJsonArray, 1);
    }
    localPhantomItem.setxRange(paramVideoMaterial);
    localPhantomItem.setyK(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_K.value));
    localPhantomItem.setyAsin(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_A_SIN.value));
    localPhantomItem.setyBcos(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_B_COS.value));
    localPhantomItem.setyPhase(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_PHASE.value));
    localPhantomItem.setyOffset(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_OFFSET.value));
    localPhantomItem.setyStep(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_STEP.value));
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_RANGE.value);
    paramVideoMaterial = new double[2];
    VideoMaterial tmp328_327 = paramVideoMaterial;
    tmp328_327[0] = 0.0D;
    VideoMaterial tmp332_328 = tmp328_327;
    tmp332_328[1] = 360.0D;
    tmp332_328;
    if (paramJsonObject != null)
    {
      paramVideoMaterial[0] = GsonUtils.optDouble(paramJsonObject, 0);
      paramVideoMaterial[1] = GsonUtils.optDouble(paramJsonObject, 1);
    }
    localPhantomItem.setyRange(paramVideoMaterial);
    return localPhantomItem;
  }
  
  private static void parsePhantomItemListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.PHANTOM_ITEM_LIST.value);
    if (paramJsonObject == null)
    {
      paramVideoMaterial.setPhantomItemList(new ArrayList());
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJsonObject.size())
    {
      Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
      if (localObject != null)
      {
        localObject = parsePhantomItem((JsonObject)localObject, paramVideoMaterial);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramVideoMaterial.setPhantomItemList(localArrayList);
  }
  
  private static VideoMaterial parsePituVideoMaterial(JsonObject paramJsonObject, String paramString, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    boolean bool = false;
    parseBasicParams(paramString, paramJsonObject, paramVideoMaterial);
    parseRenderOrder(paramJsonObject, paramVideoMaterial);
    parseSegmentParams(paramJsonObject, paramVideoMaterial);
    if (!TextUtils.isEmpty(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GAME_FIELD.GAME_NAME.value))) {
      parseGameParams(paramJsonObject, paramVideoMaterial);
    }
    parseGlbParams(paramString, paramJsonObject, paramVideoMaterial);
    if (!TextUtils.isEmpty(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GAME_FIELD.GAME_NAME.value))) {
      parseAudio3DParams(paramJsonObject, paramVideoMaterial);
    }
    parseResourceListParams(paramJsonObject, paramVideoMaterial);
    Object localObject = new int[1];
    localObject[0] = 0;
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    List localList = parseItemListParams(paramString, GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.ITEM_LIST.value), VideoFilterFactory.STICKER_TYPE.NORMAL.type, paramVideoMaterial, paramVideoMaterial.getBlendMode(), arrayOfBoolean, (int[])localObject, paramDecryptListener);
    paramVideoMaterial.setTriggerType(localObject[0]);
    paramVideoMaterial.setItemList(localList);
    if (arrayOfBoolean[0] != 0)
    {
      i = 1;
      localObject = new boolean[1];
      localObject[0] = 0;
      parse3DItemListParams(paramString, paramJsonObject, paramVideoMaterial, (boolean[])localObject);
      if ((i == 0) && (localObject[0] == 0)) {
        break label485;
      }
    }
    label485:
    for (int i = 1;; i = 0)
    {
      parseHeadCropItemListParams(paramJsonObject, paramVideoMaterial);
      paramVideoMaterial.setDistortionItemList(parseDistortionItemListParams(GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.DISTORTION_LIST.value)));
      parseFaceMoveItemListParams(paramJsonObject, paramVideoMaterial);
      parseFaceMoveTrianglesParams(paramJsonObject, paramVideoMaterial);
      parseFacePointsListParams(paramJsonObject, paramVideoMaterial);
      parseFilterEffectParams(paramJsonObject, paramVideoMaterial);
      localObject = parseFaceOffItemListParams(GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_OFF_ITEM_LIST.value));
      if (!TextUtils.isEmpty(paramVideoMaterial.getFaceExchangeImage())) {
        ((List)localObject).add(new FaceItem(paramVideoMaterial.getFaceExchangeImage(), paramVideoMaterial.isFaceExchangeImageFullFace(), paramVideoMaterial.isFaceExchangeImageDisableOpacity(), (float)paramVideoMaterial.getBlendAlpha(), paramVideoMaterial.getGrayScale(), paramVideoMaterial.getFeatureType(), paramVideoMaterial.getFacePoints()));
      }
      paramVideoMaterial.setFaceOffItemList((List)localObject);
      if (checkNeedDetectGender((List)localObject)) {
        paramVideoMaterial.setDetectGender(true);
      }
      parseFaceMeshItemListParams(paramJsonObject, paramVideoMaterial);
      parseFaceImageLayerParams(paramJsonObject, paramVideoMaterial);
      parseArParticleListParams(paramJsonObject, paramVideoMaterial);
      parseFilamentParticleListParams(paramJsonObject, paramVideoMaterial);
      localObject = new boolean[1];
      localObject[0] = 0;
      parseFaceExpressionParams(paramJsonObject, paramVideoMaterial, (boolean[])localObject);
      if ((i != 0) || (localObject[0] != 0)) {
        bool = true;
      }
      paramVideoMaterial.setHasAudio(bool);
      parseFaceCropParams(paramJsonObject, paramVideoMaterial);
      parseFabbyMvItems(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener);
      parseGridViewerItems(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener);
      parseFaceFeatureItemListParams(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener);
      parsePhantomItemListParams(paramJsonObject, paramVideoMaterial);
      parseBlurItem(paramJsonObject, paramVideoMaterial);
      parseAudio2TextParams(paramJsonObject, paramVideoMaterial);
      parseStarEffectParams(paramJsonObject, paramVideoMaterial);
      parseRapidNetFaceStyleItemList(paramJsonObject, paramVideoMaterial);
      parseCosFunParams(paramJsonObject, paramVideoMaterial);
      parseShowTipsItem(paramJsonObject, paramVideoMaterial);
      parseTriggerStateEdgeItemList(paramJsonObject, paramVideoMaterial);
      parseTriggerStateActionItemList(paramJsonObject, paramVideoMaterial);
      VideoMaterialUtil.updateSupportLandscape(paramVideoMaterial);
      VideoMaterialUtil.updateMaxFaceCount(paramVideoMaterial);
      VideoMaterialUtil.updateFaceValueDetectType(paramVideoMaterial);
      VideoMaterialUtil.updateItemImageType(paramVideoMaterial);
      VideoMaterialUtil.updateWatermarkInfo(paramVideoMaterial);
      VideoMaterialUtil.updateNeedFaceInfo(paramVideoMaterial);
      VideoMaterialUtil.updateNeedBodyInfo(paramVideoMaterial);
      VideoMaterialUtil.updateCharmRangeType(paramVideoMaterial);
      try
      {
        checkValid(paramVideoMaterial);
        return paramVideoMaterial;
      }
      catch (IllegalArgumentException paramJsonObject)
      {
        paramJsonObject.printStackTrace();
      }
      i = 0;
      break;
    }
    return paramVideoMaterial;
  }
  
  private static void parseQQVideoMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    parserFaceDetectMaterial(paramVideoMaterial, paramJsonObject);
    parseDoodleMaterial(paramVideoMaterial, paramJsonObject);
    parseFilterListMaterial(paramVideoMaterial, paramJsonObject);
    parse2DMaterial(paramVideoMaterial, paramJsonObject);
    parseGestureMaterial(paramVideoMaterial, paramJsonObject);
    parseBuckleFaceMaterial(paramVideoMaterial, paramJsonObject);
    parseShookHeadMaterial(paramVideoMaterial, paramJsonObject);
    parseMultiPendantMaterial(paramVideoMaterial, paramJsonObject);
    parseBigHeadAnimationMaterial(paramVideoMaterial, paramJsonObject);
    parseTipMaterial(paramVideoMaterial, paramJsonObject);
  }
  
  private static void parseRapidNetFaceStyleItemList(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_STYLE_ITEM_LIST.value);
    if (paramJsonObject == null)
    {
      paramVideoMaterial.setFaceStyleItemList(new ArrayList());
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJsonObject.size())
    {
      Object localObject = GsonUtils.optJsonObject(paramJsonObject, i);
      if (localObject != null)
      {
        localObject = parseFaceStyleItem((JsonObject)localObject, paramVideoMaterial);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramVideoMaterial.setFaceStyleItemList(localArrayList);
  }
  
  private static void parseRenderOrder(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.RENDER_ORDER.value);
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        localArrayList.add(GsonUtils.optString(paramJsonObject, i));
        i += 1;
      }
      paramVideoMaterial.setRenderOrderList(localArrayList);
    }
  }
  
  private static void parseResourceListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.RESOURCE_LIST.value);
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        localArrayList.add(GsonUtils.optString(paramJsonObject, i));
        i += 1;
      }
      paramVideoMaterial.setResourceList(localArrayList);
    }
  }
  
  private static void parseSegmentParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    boolean bool = true;
    paramVideoMaterial.setSegmentBorderType(GsonUtils.optInt(paramJsonObject, "SegmentBorderType", 1));
    paramVideoMaterial.setSegmentFeather(GsonUtils.optInt(paramJsonObject, "SegmentFeathering", 0));
    if (GsonUtils.optInt(paramJsonObject, "SegmentRequired", 0) == 1) {}
    for (;;)
    {
      paramVideoMaterial.setSegmentRequired(bool);
      paramVideoMaterial.setSegmentStrokeWidth(GsonUtils.optDouble(paramJsonObject, "SegmentStrokeWidth", 0.0D));
      paramVideoMaterial.setSegmentStrokeGap(GsonUtils.optDouble(paramJsonObject, "SegmentStrokeGap", 0.0D));
      paramVideoMaterial.setSegmentStrokeColor(StrokeUtil.parseColor(GsonUtils.optString(paramJsonObject, "SegmentStrokeColor", "")));
      return;
      bool = false;
    }
  }
  
  public static VideoMaterial parseShookHeadMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    boolean bool = true;
    if (paramJsonObject == null) {
      return paramVideoMaterial;
    }
    for (;;)
    {
      try
      {
        if (GsonUtils.optInt(paramJsonObject, "isShookHead", 0) == 1) {
          paramVideoMaterial.setShookHeadPendant(bool);
        }
      }
      catch (Exception paramJsonObject)
      {
        paramJsonObject.printStackTrace();
      }
      finally
      {
        return paramVideoMaterial;
      }
      bool = false;
    }
  }
  
  private static void parseShowTipsItem(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, "showTips");
    if (localJsonObject == null) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            paramJsonObject = GsonUtils.optString(localJsonObject, "tips");
          } while (TextUtils.isEmpty(paramJsonObject));
          localJsonObject = GsonUtils.optJsonObject(localJsonObject, "showPhone");
          if (localJsonObject == null) {
            break;
          }
          localIterator = localJsonObject.keySet().iterator();
          if ((localIterator == null) || (!localIterator.hasNext()))
          {
            paramVideoMaterial.setShowTips(paramJsonObject);
            return;
          }
        }
        str1 = (String)localIterator.next();
      } while (str1 == null);
      str2 = GsonUtils.optString(localJsonObject, str1, "*");
    } while ((!Build.BRAND.equals(str1)) || ((!Build.MODEL.equals(str2)) && (!"*".equals(str2))));
    paramVideoMaterial.setShowTips(paramJsonObject);
    return;
    paramVideoMaterial.setShowTips(paramJsonObject);
  }
  
  private static void parseStarEffectParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.FIELD.STAR_EFFECT.value);
    if (paramJsonObject != null)
    {
      StarParam localStarParam = new StarParam();
      localStarParam.materialId = paramVideoMaterial.getId();
      localStarParam.starType = GsonUtils.optInt(paramJsonObject, "starType", 0);
      localStarParam.starStrength = ((float)GsonUtils.optDouble(paramJsonObject, "starStrength", 0.0D));
      String str = GsonUtils.optString(paramJsonObject, "starBlurColorImage");
      if (!TextUtils.isEmpty(str)) {
        localStarParam.starBlurColorImage = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramVideoMaterial.getDataPath() + File.separator + str, 1);
      }
      localStarParam.starBlurMaxScale = ((float)GsonUtils.optDouble(paramJsonObject, "starBlurMaxScale", 0.0D));
      localStarParam.starBlurMinScale = ((float)GsonUtils.optDouble(paramJsonObject, "starBlurMinScale", 0.0D));
      localStarParam.starBlurScalePeriod = GsonUtils.optLong(paramJsonObject, "starBlurScalePeriod", 0L);
      localStarParam.starMinThreshold = ((float)GsonUtils.optDouble(paramJsonObject, "starMinThreshold", 0.4D));
      localStarParam.starMaxThreshold = ((float)GsonUtils.optDouble(paramJsonObject, "starMaxThreshold", 0.55D));
      paramVideoMaterial.setStarParam(localStarParam);
    }
  }
  
  public static boolean parseTipMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    boolean bool = false;
    if (paramJsonObject == null) {
      return false;
    }
    paramVideoMaterial.delayTips = GsonUtils.optString(paramJsonObject, "delayTips", null);
    paramVideoMaterial.itemTips = GsonUtils.optString(paramJsonObject, "itemTips", null);
    if (GsonUtils.optInt(paramJsonObject, "isDualPeople", 0) == 1) {
      bool = true;
    }
    paramVideoMaterial.isDualPeople = bool;
    return true;
  }
  
  private static void parseTriggerStateActionItemList(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "actionList");
    ArrayList localArrayList = new ArrayList();
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        Object localObject1 = GsonUtils.optJsonObject(paramJsonObject, i);
        TriggerActionItem localTriggerActionItem = new TriggerActionItem();
        localTriggerActionItem.id = GsonUtils.optString((JsonObject)localObject1, "id");
        localTriggerActionItem.mActionDelay = ((GsonUtils.optDouble((JsonObject)localObject1, "triggerDelay", 1.0D) * 1000.0D));
        localTriggerActionItem.mTriggerExpression = new TriggerExpression(GsonUtils.optInt((JsonObject)localObject1, "triggerExpression", -1));
        localTriggerActionItem.mTriggerExpression.externalTriggerWords = GsonUtils.optString((JsonObject)localObject1, "externalTriggerWords", "");
        localTriggerActionItem.mTriggerExpression.triggerHandPoint = GsonUtils.optInt((JsonObject)localObject1, "triggerHandPoint", 0);
        localObject1 = GsonUtils.optJsonArray((JsonObject)localObject1, "triggerAreas");
        if (localObject1 != null)
        {
          localTriggerActionItem.mTriggerExpression.triggerArea = new ArrayList();
          int j = 0;
          while (j < ((JsonArray)localObject1).size())
          {
            StickerItem.TriggerArea localTriggerArea = new StickerItem.TriggerArea();
            Object localObject2 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
            if (localObject2 != null)
            {
              localTriggerArea.type = GsonUtils.optInt((JsonObject)localObject2, "type");
              JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject2, "rect");
              int k;
              if (localJsonArray != null)
              {
                localTriggerArea.rect = new float[localJsonArray.size()];
                k = 0;
                while (k < localJsonArray.size())
                {
                  localTriggerArea.rect[k] = GsonUtils.getFloatSafe(localJsonArray, k);
                  k += 1;
                }
              }
              localObject2 = GsonUtils.optJsonArray((JsonObject)localObject2, "anchorPoints");
              if (localObject2 != null)
              {
                localTriggerArea.anchorPoint = new int[((JsonArray)localObject2).size()];
                k = 0;
                while (k < ((JsonArray)localObject2).size())
                {
                  localTriggerArea.anchorPoint[k] = GsonUtils.getIntUnsafe((JsonArray)localObject2, k);
                  k += 1;
                }
              }
              localTriggerActionItem.mTriggerExpression.triggerArea.add(localTriggerArea);
            }
            j += 1;
          }
        }
        localArrayList.add(localTriggerActionItem);
        i += 1;
      }
    }
    paramVideoMaterial.setTriggerActionItemList(localArrayList);
  }
  
  private static void parseTriggerStateEdgeItemList(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "stateList");
    ArrayList localArrayList = new ArrayList();
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, i);
        MaterialStateEdgeItem localMaterialStateEdgeItem = new MaterialStateEdgeItem();
        localMaterialStateEdgeItem.startState = GsonUtils.optString(localJsonObject, "startState");
        localMaterialStateEdgeItem.endState = GsonUtils.optString(localJsonObject, "endState");
        localMaterialStateEdgeItem.action = GsonUtils.optString(localJsonObject, "action");
        localArrayList.add(localMaterialStateEdgeItem);
        i += 1;
      }
    }
    paramVideoMaterial.setTriggerStateEdgeItemList(localArrayList);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString)
  {
    return parseVideoMaterial(paramString, "params", true, decryptListener);
  }
  
  private static VideoMaterial parseVideoMaterial(String paramString, JsonObject paramJsonObject, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString, paramJsonObject, paramDecryptListener, null);
  }
  
  private static VideoMaterial parseVideoMaterial(String paramString, JsonObject paramJsonObject, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    VideoMaterial localVideoMaterial = new VideoMaterial();
    localVideoMaterial.setDataPath(paramString);
    if (paramJsonObject == null) {}
    do
    {
      return localVideoMaterial;
      parseDependenciesParams(paramJsonObject, localVideoMaterial);
      parsePituVideoMaterial(paramJsonObject, paramString, localVideoMaterial, paramDecryptListener);
      parseQQVideoMaterial(localVideoMaterial, paramJsonObject);
    } while (paramHashMap == null);
    parseExtensionAttributes(paramJsonObject, localVideoMaterial, paramHashMap);
    return localVideoMaterial;
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(null, parseVideoMaterialString(paramString, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    return parseVideoMaterial(null, parseVideoMaterialString(paramString, paramDecryptListener), paramDecryptListener, paramHashMap);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialString(paramString2, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialString(paramString2, paramDecryptListener), paramDecryptListener, paramHashMap);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialFileAsJSONObject(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialFileAsJSONObject(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener, paramHashMap);
  }
  
  public static JsonObject parseVideoMaterialFileAsJSONObject(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    paramString1 = readMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener);
    LogUtils.i(TAG, "[parseVideoMaterialFileAsJSONObject] dataStr = " + paramString1);
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = GsonUtils.json2JsonObject(paramString1);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  private static JsonObject parseVideoMaterialString(String paramString, DecryptListener paramDecryptListener)
  {
    String str = paramString.trim();
    paramString = str;
    do
    {
      try
      {
        if (str.charAt(0) != '{')
        {
          paramString = new BufferedReader(new InputStreamReader(drinkACupOfCoffee(new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8"))), paramDecryptListener)), 1024);
          paramDecryptListener = new StringBuilder();
          for (;;)
          {
            str = paramString.readLine();
            if (str == null) {
              break;
            }
            paramDecryptListener.append(str);
          }
          paramString = paramDecryptListener.toString();
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    } while (TextUtils.isEmpty(paramString));
    paramString = GsonUtils.json2JsonObject(paramString);
    return paramString;
  }
  
  private static WMGroupConfig parseWMGroupConfig(JsonArray paramJsonArray, VideoMaterial paramVideoMaterial)
  {
    WMGroupConfig localWMGroupConfig = new WMGroupConfig();
    int i = 0;
    for (;;)
    {
      Object localObject1;
      WMElementConfig localWMElementConfig;
      Object localObject3;
      Object localObject4;
      String str1;
      try
      {
        if (i < paramJsonArray.size())
        {
          localObject1 = GsonUtils.optJsonObject(paramJsonArray, i);
          if (localObject1 == null) {
            break label1311;
          }
          int j = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
          localWMElementConfig = new WMElementConfig();
          localWMElementConfig.dataPath = paramVideoMaterial.getDataPath();
          localWMElementConfig.sid = paramVideoMaterial.getId();
          localWMElementConfig.id = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
          localWMElementConfig.relativeID = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
          localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
          if ((localObject2 != null) && (((JsonArray)localObject2).size() == 2))
          {
            localWMElementConfig.relativeAnchor = new PointF((float)GsonUtils.getDoubleUnsafe((JsonArray)localObject2, 0), (float)GsonUtils.getDoubleUnsafe((JsonArray)localObject2, 1));
            localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
            if ((localObject2 == null) || (((JsonArray)localObject2).size() != 2)) {
              break label1168;
            }
            localWMElementConfig.anchor = new PointF((float)GsonUtils.getDoubleUnsafe((JsonArray)localObject2, 0), (float)GsonUtils.getDoubleUnsafe((JsonArray)localObject2, 1));
            localWMElementConfig.offsetX = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETX.value);
            localWMElementConfig.offsetY = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETY.value);
            localWMElementConfig.width = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.WIDTH.value);
            localWMElementConfig.height = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.HEIGHT.value);
            localWMElementConfig.wmtype = j;
            localWMElementConfig.edittype = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.EDITTYPE.value);
            localWMElementConfig.fmtstr = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FMTSTR.value);
            localWMElementConfig.fontName = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_NAME.value);
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_BOLD.value) != 1) {
              break label1318;
            }
            bool = true;
            localWMElementConfig.fontBold = bool;
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
              break label1324;
            }
            bool = true;
            localWMElementConfig.fontItalics = bool;
            localWMElementConfig.fontTexture = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_TEXTURE.value);
            localWMElementConfig.fontSize = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_SIZE.value, 40.0D));
            localWMElementConfig.fontFit = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_FIT.value);
            localWMElementConfig.kern = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.KERN.value);
            localWMElementConfig.imgPath = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.IMG_PATH.value);
            localWMElementConfig.frameDuration = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FRAME_DURATION.value);
            localWMElementConfig.frames = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.FRAMES.value);
            localWMElementConfig.color = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
            localWMElementConfig.strokeColor = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
            localWMElementConfig.strokeSize = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0D));
            localWMElementConfig.shadowColor = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
            localWMElementConfig.shadowSize = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0D));
            localWMElementConfig.shadowDx = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DX.value, -1.0D));
            localWMElementConfig.shadowDy = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DY.value, -1.0D));
            localWMElementConfig.blurAmount = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.BLUR_AMOUNT.value, -1.0D));
            localWMElementConfig.alignment = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ALIGNMENT.value);
            localWMElementConfig.vertical = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.VERTICAL.value);
            localWMElementConfig.outerStrokeColor = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_COLOR.value, "#FFFFFFFF");
            localWMElementConfig.outerStrokeSize = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_SIZE.value, -1.0D));
            localWMElementConfig.shaderBmp = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.SHADER_BMP.value, null);
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.EMBOSS.value, 0) != 1) {
              break label1330;
            }
            bool = true;
            localWMElementConfig.emboss = bool;
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.MULTI_ROW.value, 0) != 1) {
              break label1336;
            }
            bool = true;
            localWMElementConfig.multiRow = bool;
            localWMElementConfig.animateType = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
            localWMElementConfig.animateAlphaStart0 = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATEALPHASTART0.value, -1.0D));
            localWMElementConfig.animateAlphaStart1 = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATEALPHASTART1.value, -1.0D));
            localWMElementConfig.animateAlphaEnd1 = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATEALPHAEND1.value, -1.0D));
            localWMElementConfig.animateAlphaEnd0 = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATEALPHAEND0.value, -1.0D));
            localWMElementConfig.persistence = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.PERSISTENCE.value);
            localWMElementConfig.numberSource = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.NUMBERSOURCE.value);
            localWMElementConfig.showCaseMin = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.SHOWCASEMIN.value);
            localWMElementConfig.showCaseMax = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.SHOWCASEMAX.value);
            localWMElementConfig.textSource = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.TEXTSOURCE.value);
            localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
            if (localObject2 == null) {
              break label1298;
            }
            localObject1 = new WMLogic();
            ((WMLogic)localObject1).type = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
            ((WMLogic)localObject1).setCompare(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), localWMElementConfig.sid);
            ((WMLogic)localObject1).data = GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
            localObject3 = GsonUtils.optJsonObject((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
            if (localObject3 == null) {
              break label1193;
            }
            ((WMLogic)localObject1).range = new ArrayList();
            localObject4 = ((JsonObject)localObject3).keySet().iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label1185;
            }
            str1 = (String)((Iterator)localObject4).next();
            String str2 = GsonUtils.optString((JsonObject)localObject3, str1);
            ((WMLogic)localObject1).range.add(new WMLogicPair(str1, str2));
            continue;
          }
        }
        else
        {
          return localWMGroupConfig;
        }
      }
      catch (Exception paramJsonArray)
      {
        LogUtils.e(paramJsonArray);
      }
      localWMElementConfig.relativeAnchor = new PointF(0.0F, 0.0F);
      continue;
      label1168:
      localWMElementConfig.anchor = new PointF(0.0F, 0.0F);
      continue;
      label1185:
      Collections.sort(((WMLogic)localObject1).range);
      label1193:
      Object localObject2 = GsonUtils.optJsonObject((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
      if (localObject2 != null)
      {
        ((WMLogic)localObject1).wmcase = new ArrayList();
        localObject3 = ((JsonObject)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          str1 = GsonUtils.optString((JsonObject)localObject2, (String)localObject4);
          ((WMLogic)localObject1).wmcase.add(new WMLogicPair((String)localObject4, str1));
        }
      }
      localWMElementConfig.logic = ((WMLogic)localObject1);
      label1298:
      localWMGroupConfig.wmElementConfigs.add(localWMElementConfig);
      label1311:
      i += 1;
      continue;
      label1318:
      boolean bool = false;
      continue;
      label1324:
      bool = false;
      continue;
      label1330:
      bool = false;
      continue;
      label1336:
      bool = false;
    }
  }
  
  public static boolean parserFaceDetectMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    boolean bool2 = false;
    if (paramJsonObject == null) {
      return false;
    }
    paramVideoMaterial.mEnableFaceDetect = GsonUtils.optBoolean(paramJsonObject, "enableFaceDetect", true);
    paramVideoMaterial.mUseUlseeSdk = false;
    if (GsonUtils.optInt(paramJsonObject, "faceDetectorType", 0) == 1) {
      paramVideoMaterial.mUseUlseeSdk = true;
    }
    for (;;)
    {
      try
      {
        paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "itemList");
        if ((paramJsonObject != null) && (paramVideoMaterial.mEnableFaceDetect))
        {
          i = 0;
          boolean bool1 = bool2;
          if (i < paramJsonObject.size())
          {
            JsonObject localJsonObject = GsonUtils.getJsonObjectUnsafe(paramJsonObject, i);
            if ((localJsonObject == null) || (GsonUtils.optInt(localJsonObject, "triggerType") == 1)) {
              continue;
            }
            bool1 = true;
          }
          paramVideoMaterial.mEnableFaceDetect = bool1;
        }
      }
      catch (Exception paramVideoMaterial)
      {
        int i;
        LogUtils.w(TAG, paramVideoMaterial.getMessage());
        continue;
      }
      return true;
      i += 1;
    }
  }
  
  /* Error */
  public static String readMaterialFile(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: invokestatic 187	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 6
    //   12: new 189	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   19: aload 6
    //   21: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 1027
    //   27: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 2550
    //   37: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 5
    //   42: iload_2
    //   43: ifeq +315 -> 358
    //   46: ldc 34
    //   48: astore_0
    //   49: aload 5
    //   51: aload_0
    //   52: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 5
    //   60: new 189	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   67: aload 6
    //   69: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 1027
    //   75: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 2550
    //   85: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore_1
    //   89: iload_2
    //   90: ifne +274 -> 364
    //   93: ldc 34
    //   95: astore_0
    //   96: aload_1
    //   97: aload_0
    //   98: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore 8
    //   106: new 196	java/io/File
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 5038	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: new 196	java/io/File
    //   119: dup
    //   120: aload 8
    //   122: invokespecial 5038	java/io/File:<init>	(Ljava/lang/String;)V
    //   125: astore_0
    //   126: aload_1
    //   127: invokevirtual 5041	java/io/File:exists	()Z
    //   130: ifeq +10 -> 140
    //   133: aload_1
    //   134: invokevirtual 5044	java/io/File:isFile	()Z
    //   137: ifne +17 -> 154
    //   140: aload_0
    //   141: invokevirtual 5041	java/io/File:exists	()Z
    //   144: ifeq +268 -> 412
    //   147: aload_0
    //   148: invokevirtual 5044	java/io/File:isFile	()Z
    //   151: ifeq +261 -> 412
    //   154: aload_1
    //   155: invokevirtual 5041	java/io/File:exists	()Z
    //   158: ifeq +212 -> 370
    //   161: aload_1
    //   162: invokevirtual 5044	java/io/File:isFile	()Z
    //   165: ifeq +205 -> 370
    //   168: new 5046	java/io/FileInputStream
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 5049	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore_1
    //   177: iload_2
    //   178: ifne +229 -> 407
    //   181: aload_1
    //   182: aload_3
    //   183: invokestatic 4988	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   186: astore_0
    //   187: aload_1
    //   188: invokestatic 5052	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   191: aload_0
    //   192: ifnull +416 -> 608
    //   195: new 4975	java/io/InputStreamReader
    //   198: dup
    //   199: aload_0
    //   200: invokespecial 4991	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   203: astore 6
    //   205: new 4973	java/io/BufferedReader
    //   208: dup
    //   209: aload 6
    //   211: sipush 1024
    //   214: invokespecial 4994	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   217: astore_3
    //   218: aload_1
    //   219: astore 10
    //   221: aload 6
    //   223: astore 9
    //   225: aload_3
    //   226: astore 8
    //   228: aload_0
    //   229: astore 7
    //   231: new 189	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   238: astore 5
    //   240: aload_1
    //   241: astore 10
    //   243: aload 6
    //   245: astore 9
    //   247: aload_3
    //   248: astore 8
    //   250: aload_0
    //   251: astore 7
    //   253: aload_3
    //   254: invokevirtual 4997	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   257: astore 11
    //   259: aload 11
    //   261: ifnull +283 -> 544
    //   264: aload_1
    //   265: astore 10
    //   267: aload 6
    //   269: astore 9
    //   271: aload_3
    //   272: astore 8
    //   274: aload_0
    //   275: astore 7
    //   277: aload 5
    //   279: aload 11
    //   281: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: goto -45 -> 240
    //   288: astore 5
    //   290: aload_1
    //   291: astore 10
    //   293: aload 6
    //   295: astore 9
    //   297: aload_3
    //   298: astore 8
    //   300: aload_0
    //   301: astore 7
    //   303: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   306: aload 5
    //   308: invokevirtual 5035	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   311: aload 5
    //   313: iconst_0
    //   314: anewarray 4	java/lang/Object
    //   317: invokestatic 5055	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   320: aload_3
    //   321: ifnull +7 -> 328
    //   324: aload_3
    //   325: invokevirtual 5058	java/io/BufferedReader:close	()V
    //   328: aload 6
    //   330: ifnull +8 -> 338
    //   333: aload 6
    //   335: invokevirtual 5059	java/io/InputStreamReader:close	()V
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 5062	java/io/InputStream:close	()V
    //   346: aload_1
    //   347: ifnull +7 -> 354
    //   350: aload_1
    //   351: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   354: aconst_null
    //   355: astore_0
    //   356: aload_0
    //   357: areturn
    //   358: ldc 31
    //   360: astore_0
    //   361: goto -312 -> 49
    //   364: ldc 31
    //   366: astore_0
    //   367: goto -271 -> 96
    //   370: aload_0
    //   371: invokevirtual 5041	java/io/File:exists	()Z
    //   374: ifeq +517 -> 891
    //   377: aload_0
    //   378: invokevirtual 5044	java/io/File:isFile	()Z
    //   381: ifeq +510 -> 891
    //   384: new 5046	java/io/FileInputStream
    //   387: dup
    //   388: aload_0
    //   389: invokespecial 5049	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   392: astore_1
    //   393: iload_2
    //   394: ifne +8 -> 402
    //   397: iconst_1
    //   398: istore_2
    //   399: goto -222 -> 177
    //   402: iconst_0
    //   403: istore_2
    //   404: goto -5 -> 399
    //   407: aload_1
    //   408: astore_0
    //   409: goto -218 -> 191
    //   412: invokestatic 2161	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   415: invokevirtual 5067	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   418: aload 5
    //   420: invokevirtual 5073	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   423: astore 6
    //   425: iload_2
    //   426: ifne +25 -> 451
    //   429: aload 6
    //   431: aload_3
    //   432: invokestatic 4988	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   435: astore_0
    //   436: aload_0
    //   437: astore 5
    //   439: aload_0
    //   440: astore_1
    //   441: aload 6
    //   443: invokestatic 5052	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -257 -> 191
    //   451: aload 6
    //   453: astore_0
    //   454: goto -8 -> 446
    //   457: astore_0
    //   458: aconst_null
    //   459: astore_0
    //   460: aload_0
    //   461: astore 6
    //   463: aload_0
    //   464: astore 5
    //   466: aload_0
    //   467: astore_1
    //   468: invokestatic 2161	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   471: invokevirtual 5067	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   474: aload 8
    //   476: invokevirtual 5073	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   479: astore 8
    //   481: iload_2
    //   482: ifne +41 -> 523
    //   485: iload 4
    //   487: ifne +42 -> 529
    //   490: aload_0
    //   491: astore 6
    //   493: aload_0
    //   494: astore 5
    //   496: aload_0
    //   497: astore_1
    //   498: aload 8
    //   500: aload_3
    //   501: invokestatic 4988	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   504: astore_0
    //   505: aload_0
    //   506: astore 6
    //   508: aload_0
    //   509: astore 5
    //   511: aload_0
    //   512: astore_1
    //   513: aload 8
    //   515: invokestatic 5052	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   518: aconst_null
    //   519: astore_1
    //   520: goto -329 -> 191
    //   523: iconst_0
    //   524: istore 4
    //   526: goto -41 -> 485
    //   529: aload 8
    //   531: astore_0
    //   532: goto -14 -> 518
    //   535: astore_0
    //   536: aconst_null
    //   537: astore_1
    //   538: aload 6
    //   540: astore_0
    //   541: goto -350 -> 191
    //   544: aload_1
    //   545: astore 10
    //   547: aload 6
    //   549: astore 9
    //   551: aload_3
    //   552: astore 8
    //   554: aload_0
    //   555: astore 7
    //   557: aload 5
    //   559: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: astore 5
    //   564: aload_3
    //   565: ifnull +7 -> 572
    //   568: aload_3
    //   569: invokevirtual 5058	java/io/BufferedReader:close	()V
    //   572: aload 6
    //   574: ifnull +8 -> 582
    //   577: aload 6
    //   579: invokevirtual 5059	java/io/InputStreamReader:close	()V
    //   582: aload_0
    //   583: ifnull +7 -> 590
    //   586: aload_0
    //   587: invokevirtual 5062	java/io/InputStream:close	()V
    //   590: aload 5
    //   592: astore_0
    //   593: aload_1
    //   594: ifnull -238 -> 356
    //   597: aload_1
    //   598: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   601: aload 5
    //   603: areturn
    //   604: astore_0
    //   605: aload 5
    //   607: areturn
    //   608: iconst_0
    //   609: ifeq +11 -> 620
    //   612: new 5075	java/lang/NullPointerException
    //   615: dup
    //   616: invokespecial 5076	java/lang/NullPointerException:<init>	()V
    //   619: athrow
    //   620: iconst_0
    //   621: ifeq +11 -> 632
    //   624: new 5075	java/lang/NullPointerException
    //   627: dup
    //   628: invokespecial 5076	java/lang/NullPointerException:<init>	()V
    //   631: athrow
    //   632: aload_0
    //   633: ifnull +7 -> 640
    //   636: aload_0
    //   637: invokevirtual 5062	java/io/InputStream:close	()V
    //   640: aload_1
    //   641: ifnull -287 -> 354
    //   644: aload_1
    //   645: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   648: goto -294 -> 354
    //   651: astore_0
    //   652: goto -298 -> 354
    //   655: astore_1
    //   656: aconst_null
    //   657: astore_3
    //   658: aconst_null
    //   659: astore 5
    //   661: aconst_null
    //   662: astore_0
    //   663: aload 7
    //   665: astore 6
    //   667: aload 5
    //   669: ifnull +8 -> 677
    //   672: aload 5
    //   674: invokevirtual 5058	java/io/BufferedReader:close	()V
    //   677: aload_3
    //   678: ifnull +7 -> 685
    //   681: aload_3
    //   682: invokevirtual 5059	java/io/InputStreamReader:close	()V
    //   685: aload_0
    //   686: ifnull +7 -> 693
    //   689: aload_0
    //   690: invokevirtual 5062	java/io/InputStream:close	()V
    //   693: aload 6
    //   695: ifnull +8 -> 703
    //   698: aload 6
    //   700: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   703: aload_1
    //   704: athrow
    //   705: astore_0
    //   706: goto -3 -> 703
    //   709: astore 7
    //   711: aconst_null
    //   712: astore_3
    //   713: aconst_null
    //   714: astore 5
    //   716: aconst_null
    //   717: astore_0
    //   718: aload_1
    //   719: astore 6
    //   721: aload 7
    //   723: astore_1
    //   724: goto -57 -> 667
    //   727: astore 7
    //   729: aconst_null
    //   730: astore 5
    //   732: aconst_null
    //   733: astore_3
    //   734: aload_1
    //   735: astore 6
    //   737: aload 7
    //   739: astore_1
    //   740: goto -73 -> 667
    //   743: astore_1
    //   744: aconst_null
    //   745: astore_3
    //   746: aconst_null
    //   747: astore 6
    //   749: aload 5
    //   751: astore_0
    //   752: aload 6
    //   754: astore 5
    //   756: aload 7
    //   758: astore 6
    //   760: goto -93 -> 667
    //   763: astore 7
    //   765: aconst_null
    //   766: astore_3
    //   767: aconst_null
    //   768: astore 5
    //   770: aload_1
    //   771: astore 6
    //   773: aload 7
    //   775: astore_1
    //   776: goto -109 -> 667
    //   779: astore_3
    //   780: aconst_null
    //   781: astore 5
    //   783: aload_1
    //   784: astore 7
    //   786: aload_3
    //   787: astore_1
    //   788: aload 6
    //   790: astore_3
    //   791: aload 7
    //   793: astore 6
    //   795: goto -128 -> 667
    //   798: astore_1
    //   799: aload 10
    //   801: astore 6
    //   803: aload 9
    //   805: astore_3
    //   806: aload 8
    //   808: astore 5
    //   810: aload 7
    //   812: astore_0
    //   813: goto -146 -> 667
    //   816: astore_0
    //   817: goto -463 -> 354
    //   820: astore 5
    //   822: aconst_null
    //   823: astore_1
    //   824: aconst_null
    //   825: astore 6
    //   827: aconst_null
    //   828: astore_3
    //   829: aconst_null
    //   830: astore_0
    //   831: goto -541 -> 290
    //   834: astore 5
    //   836: aconst_null
    //   837: astore 6
    //   839: aconst_null
    //   840: astore_3
    //   841: aconst_null
    //   842: astore_0
    //   843: goto -553 -> 290
    //   846: astore 5
    //   848: aconst_null
    //   849: astore_3
    //   850: aconst_null
    //   851: astore 6
    //   853: goto -563 -> 290
    //   856: astore 5
    //   858: aconst_null
    //   859: astore 6
    //   861: aconst_null
    //   862: astore_3
    //   863: aload_1
    //   864: astore_0
    //   865: aconst_null
    //   866: astore_1
    //   867: goto -577 -> 290
    //   870: astore 5
    //   872: aconst_null
    //   873: astore 6
    //   875: aconst_null
    //   876: astore_3
    //   877: goto -587 -> 290
    //   880: astore 5
    //   882: aconst_null
    //   883: astore_3
    //   884: goto -594 -> 290
    //   887: astore_1
    //   888: goto -428 -> 460
    //   891: aconst_null
    //   892: astore_1
    //   893: goto -716 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	896	0	paramString1	String
    //   0	896	1	paramString2	String
    //   0	896	2	paramBoolean	boolean
    //   0	896	3	paramDecryptListener	DecryptListener
    //   1	524	4	i	int
    //   40	238	5	localObject1	Object
    //   288	131	5	localException1	Exception
    //   437	372	5	localObject2	Object
    //   820	1	5	localException2	Exception
    //   834	1	5	localException3	Exception
    //   846	1	5	localException4	Exception
    //   856	1	5	localException5	Exception
    //   870	1	5	localException6	Exception
    //   880	1	5	localException7	Exception
    //   10	864	6	localObject3	Object
    //   4	660	7	str1	String
    //   709	13	7	localObject4	Object
    //   727	30	7	localObject5	Object
    //   763	11	7	localObject6	Object
    //   784	27	7	str2	String
    //   104	703	8	localObject7	Object
    //   223	581	9	localObject8	Object
    //   219	581	10	str3	String
    //   257	23	11	str4	String
    // Exception table:
    //   from	to	target	type
    //   231	240	288	java/lang/Exception
    //   253	259	288	java/lang/Exception
    //   277	285	288	java/lang/Exception
    //   557	564	288	java/lang/Exception
    //   412	425	457	java/io/IOException
    //   429	436	457	java/io/IOException
    //   468	481	535	java/io/IOException
    //   498	505	535	java/io/IOException
    //   513	518	535	java/io/IOException
    //   568	572	604	java/io/IOException
    //   577	582	604	java/io/IOException
    //   586	590	604	java/io/IOException
    //   597	601	604	java/io/IOException
    //   612	620	651	java/io/IOException
    //   624	632	651	java/io/IOException
    //   636	640	651	java/io/IOException
    //   644	648	651	java/io/IOException
    //   106	140	655	finally
    //   140	154	655	finally
    //   154	177	655	finally
    //   370	393	655	finally
    //   412	425	655	finally
    //   429	436	655	finally
    //   672	677	705	java/io/IOException
    //   681	685	705	java/io/IOException
    //   689	693	705	java/io/IOException
    //   698	703	705	java/io/IOException
    //   181	187	709	finally
    //   187	191	727	finally
    //   441	446	743	finally
    //   468	481	743	finally
    //   498	505	743	finally
    //   513	518	743	finally
    //   195	205	763	finally
    //   205	218	779	finally
    //   231	240	798	finally
    //   253	259	798	finally
    //   277	285	798	finally
    //   303	320	798	finally
    //   557	564	798	finally
    //   324	328	816	java/io/IOException
    //   333	338	816	java/io/IOException
    //   342	346	816	java/io/IOException
    //   350	354	816	java/io/IOException
    //   106	140	820	java/lang/Exception
    //   140	154	820	java/lang/Exception
    //   154	177	820	java/lang/Exception
    //   370	393	820	java/lang/Exception
    //   412	425	820	java/lang/Exception
    //   429	436	820	java/lang/Exception
    //   181	187	834	java/lang/Exception
    //   187	191	846	java/lang/Exception
    //   441	446	856	java/lang/Exception
    //   468	481	856	java/lang/Exception
    //   498	505	856	java/lang/Exception
    //   513	518	856	java/lang/Exception
    //   195	205	870	java/lang/Exception
    //   205	218	880	java/lang/Exception
    //   441	446	887	java/io/IOException
  }
  
  /* Error */
  private static String readPexFile(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: ldc 31
    //   12: invokevirtual 2629	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifne +327 -> 342
    //   18: iconst_1
    //   19: istore_3
    //   20: aload_0
    //   21: invokestatic 187	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 6
    //   26: new 189	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   33: aload 6
    //   35: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1027
    //   41: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_0
    //   52: new 189	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   59: aload 6
    //   61: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 1027
    //   67: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 6
    //   79: new 196	java/io/File
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 5038	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore_1
    //   88: new 196	java/io/File
    //   91: dup
    //   92: aload 6
    //   94: invokespecial 5038	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore 8
    //   99: aload_1
    //   100: invokevirtual 5041	java/io/File:exists	()Z
    //   103: ifeq +10 -> 113
    //   106: aload_1
    //   107: invokevirtual 5044	java/io/File:isFile	()Z
    //   110: ifne +19 -> 129
    //   113: aload 8
    //   115: invokevirtual 5041	java/io/File:exists	()Z
    //   118: ifeq +280 -> 398
    //   121: aload 8
    //   123: invokevirtual 5044	java/io/File:isFile	()Z
    //   126: ifeq +272 -> 398
    //   129: aload_1
    //   130: invokevirtual 5041	java/io/File:exists	()Z
    //   133: ifeq +214 -> 347
    //   136: aload_1
    //   137: invokevirtual 5044	java/io/File:isFile	()Z
    //   140: ifeq +207 -> 347
    //   143: new 5046	java/io/FileInputStream
    //   146: dup
    //   147: aload_1
    //   148: invokespecial 5049	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   151: astore_0
    //   152: aload_0
    //   153: astore 7
    //   155: iload_3
    //   156: ifne +235 -> 391
    //   159: aload 7
    //   161: aload_2
    //   162: invokestatic 4988	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   165: astore_0
    //   166: aload 7
    //   168: invokestatic 5052	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   171: aload_0
    //   172: astore 6
    //   174: aload 6
    //   176: ifnull +405 -> 581
    //   179: new 4975	java/io/InputStreamReader
    //   182: dup
    //   183: aload 6
    //   185: invokespecial 4991	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   188: astore_2
    //   189: new 4973	java/io/BufferedReader
    //   192: dup
    //   193: aload_2
    //   194: sipush 1024
    //   197: invokespecial 4994	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   200: astore_0
    //   201: aload 7
    //   203: astore 11
    //   205: aload_2
    //   206: astore 10
    //   208: aload_0
    //   209: astore 9
    //   211: aload 6
    //   213: astore 8
    //   215: new 189	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   222: astore_1
    //   223: aload 7
    //   225: astore 11
    //   227: aload_2
    //   228: astore 10
    //   230: aload_0
    //   231: astore 9
    //   233: aload 6
    //   235: astore 8
    //   237: aload_0
    //   238: invokevirtual 4997	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   241: astore 12
    //   243: aload 12
    //   245: ifnull +259 -> 504
    //   248: aload 7
    //   250: astore 11
    //   252: aload_2
    //   253: astore 10
    //   255: aload_0
    //   256: astore 9
    //   258: aload 6
    //   260: astore 8
    //   262: aload_1
    //   263: aload 12
    //   265: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: goto -46 -> 223
    //   272: astore_1
    //   273: aload 7
    //   275: astore 11
    //   277: aload_2
    //   278: astore 10
    //   280: aload_0
    //   281: astore 9
    //   283: aload 6
    //   285: astore 8
    //   287: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   290: aload_1
    //   291: invokevirtual 5035	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: aload_1
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 5055	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   302: aload_0
    //   303: ifnull +7 -> 310
    //   306: aload_0
    //   307: invokevirtual 5058	java/io/BufferedReader:close	()V
    //   310: aload_2
    //   311: ifnull +7 -> 318
    //   314: aload_2
    //   315: invokevirtual 5059	java/io/InputStreamReader:close	()V
    //   318: aload 6
    //   320: ifnull +8 -> 328
    //   323: aload 6
    //   325: invokevirtual 5062	java/io/InputStream:close	()V
    //   328: aload 7
    //   330: ifnull +8 -> 338
    //   333: aload 7
    //   335: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   338: aconst_null
    //   339: astore_0
    //   340: aload_0
    //   341: areturn
    //   342: iconst_0
    //   343: istore_3
    //   344: goto -324 -> 20
    //   347: aload 8
    //   349: invokevirtual 5041	java/io/File:exists	()Z
    //   352: ifeq +596 -> 948
    //   355: aload 8
    //   357: invokevirtual 5044	java/io/File:isFile	()Z
    //   360: ifeq +588 -> 948
    //   363: new 5046	java/io/FileInputStream
    //   366: dup
    //   367: aload 8
    //   369: invokespecial 5049	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   372: astore_0
    //   373: iload_3
    //   374: ifne +12 -> 386
    //   377: iload 4
    //   379: istore_3
    //   380: aload_0
    //   381: astore 7
    //   383: goto -228 -> 155
    //   386: iconst_0
    //   387: istore_3
    //   388: goto -8 -> 380
    //   391: aload 7
    //   393: astore 6
    //   395: goto -221 -> 174
    //   398: invokestatic 2161	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   401: invokevirtual 5067	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   404: aload_0
    //   405: invokevirtual 5073	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   408: astore_1
    //   409: iload_3
    //   410: ifne +22 -> 432
    //   413: aload_1
    //   414: aload_2
    //   415: invokestatic 4988	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   418: astore_0
    //   419: aload_1
    //   420: invokestatic 5052	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   423: aconst_null
    //   424: astore 7
    //   426: aload_0
    //   427: astore 6
    //   429: goto -255 -> 174
    //   432: aload_1
    //   433: astore_0
    //   434: goto -11 -> 423
    //   437: astore_0
    //   438: aconst_null
    //   439: astore_0
    //   440: invokestatic 2161	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   443: invokevirtual 5067	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   446: aload 6
    //   448: invokevirtual 5073	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   451: astore_1
    //   452: iload_3
    //   453: ifne +31 -> 484
    //   456: iload 5
    //   458: istore_3
    //   459: iload_3
    //   460: ifne +29 -> 489
    //   463: aload_1
    //   464: aload_2
    //   465: invokestatic 4988	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   468: astore_2
    //   469: aload_2
    //   470: astore_0
    //   471: aload_1
    //   472: invokestatic 5052	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   475: aconst_null
    //   476: astore 7
    //   478: aload_0
    //   479: astore 6
    //   481: goto -307 -> 174
    //   484: iconst_0
    //   485: istore_3
    //   486: goto -27 -> 459
    //   489: aload_1
    //   490: astore_0
    //   491: goto -16 -> 475
    //   494: astore_1
    //   495: aconst_null
    //   496: astore 7
    //   498: aload_0
    //   499: astore 6
    //   501: goto -327 -> 174
    //   504: aload 7
    //   506: astore 11
    //   508: aload_2
    //   509: astore 10
    //   511: aload_0
    //   512: astore 9
    //   514: aload 6
    //   516: astore 8
    //   518: aload_1
    //   519: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: astore_1
    //   523: aload_0
    //   524: ifnull +7 -> 531
    //   527: aload_0
    //   528: invokevirtual 5058	java/io/BufferedReader:close	()V
    //   531: aload_2
    //   532: ifnull +7 -> 539
    //   535: aload_2
    //   536: invokevirtual 5059	java/io/InputStreamReader:close	()V
    //   539: aload 6
    //   541: ifnull +8 -> 549
    //   544: aload 6
    //   546: invokevirtual 5062	java/io/InputStream:close	()V
    //   549: aload_1
    //   550: astore_0
    //   551: aload 7
    //   553: ifnull -213 -> 340
    //   556: aload 7
    //   558: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   561: aload_1
    //   562: areturn
    //   563: astore_0
    //   564: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   567: aload_0
    //   568: invokevirtual 5077	java/io/IOException:getMessage	()Ljava/lang/String;
    //   571: aload_0
    //   572: iconst_0
    //   573: anewarray 4	java/lang/Object
    //   576: invokestatic 5055	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   579: aload_1
    //   580: areturn
    //   581: iconst_0
    //   582: ifeq +11 -> 593
    //   585: new 5075	java/lang/NullPointerException
    //   588: dup
    //   589: invokespecial 5076	java/lang/NullPointerException:<init>	()V
    //   592: athrow
    //   593: iconst_0
    //   594: ifeq +11 -> 605
    //   597: new 5075	java/lang/NullPointerException
    //   600: dup
    //   601: invokespecial 5076	java/lang/NullPointerException:<init>	()V
    //   604: athrow
    //   605: aload 6
    //   607: ifnull +8 -> 615
    //   610: aload 6
    //   612: invokevirtual 5062	java/io/InputStream:close	()V
    //   615: aload 7
    //   617: ifnull -279 -> 338
    //   620: aload 7
    //   622: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   625: goto -287 -> 338
    //   628: astore_0
    //   629: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   632: aload_0
    //   633: invokevirtual 5077	java/io/IOException:getMessage	()Ljava/lang/String;
    //   636: aload_0
    //   637: iconst_0
    //   638: anewarray 4	java/lang/Object
    //   641: invokestatic 5055	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   644: goto -306 -> 338
    //   647: astore_0
    //   648: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   651: aload_0
    //   652: invokevirtual 5077	java/io/IOException:getMessage	()Ljava/lang/String;
    //   655: aload_0
    //   656: iconst_0
    //   657: anewarray 4	java/lang/Object
    //   660: invokestatic 5055	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   663: goto -325 -> 338
    //   666: astore_0
    //   667: aconst_null
    //   668: astore_1
    //   669: aconst_null
    //   670: astore_2
    //   671: aconst_null
    //   672: astore 6
    //   674: aload_2
    //   675: ifnull +7 -> 682
    //   678: aload_2
    //   679: invokevirtual 5058	java/io/BufferedReader:close	()V
    //   682: aload_1
    //   683: ifnull +7 -> 690
    //   686: aload_1
    //   687: invokevirtual 5059	java/io/InputStreamReader:close	()V
    //   690: aload 6
    //   692: ifnull +8 -> 700
    //   695: aload 6
    //   697: invokevirtual 5062	java/io/InputStream:close	()V
    //   700: aload 7
    //   702: ifnull +8 -> 710
    //   705: aload 7
    //   707: invokevirtual 5063	java/io/FileInputStream:close	()V
    //   710: aload_0
    //   711: athrow
    //   712: astore_1
    //   713: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   716: aload_1
    //   717: invokevirtual 5077	java/io/IOException:getMessage	()Ljava/lang/String;
    //   720: aload_1
    //   721: iconst_0
    //   722: anewarray 4	java/lang/Object
    //   725: invokestatic 5055	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   728: goto -18 -> 710
    //   731: astore_0
    //   732: aconst_null
    //   733: astore_1
    //   734: aconst_null
    //   735: astore_2
    //   736: aconst_null
    //   737: astore 6
    //   739: goto -65 -> 674
    //   742: astore 8
    //   744: aconst_null
    //   745: astore_1
    //   746: aload_0
    //   747: astore 6
    //   749: aconst_null
    //   750: astore_2
    //   751: aload 8
    //   753: astore_0
    //   754: goto -80 -> 674
    //   757: astore 8
    //   759: aconst_null
    //   760: astore_2
    //   761: aload_0
    //   762: astore 6
    //   764: aconst_null
    //   765: astore_1
    //   766: aload 8
    //   768: astore_0
    //   769: goto -95 -> 674
    //   772: astore 8
    //   774: aconst_null
    //   775: astore_1
    //   776: aload_0
    //   777: astore 6
    //   779: aconst_null
    //   780: astore_2
    //   781: aload 8
    //   783: astore_0
    //   784: goto -110 -> 674
    //   787: astore 8
    //   789: aconst_null
    //   790: astore_1
    //   791: aconst_null
    //   792: astore_2
    //   793: aload_0
    //   794: astore 6
    //   796: aload 8
    //   798: astore_0
    //   799: goto -125 -> 674
    //   802: astore_0
    //   803: aconst_null
    //   804: astore_1
    //   805: aconst_null
    //   806: astore_2
    //   807: goto -133 -> 674
    //   810: astore_0
    //   811: aconst_null
    //   812: astore 8
    //   814: aload_2
    //   815: astore_1
    //   816: aload 8
    //   818: astore_2
    //   819: goto -145 -> 674
    //   822: astore_0
    //   823: aload 11
    //   825: astore 7
    //   827: aload 10
    //   829: astore_1
    //   830: aload 9
    //   832: astore_2
    //   833: aload 8
    //   835: astore 6
    //   837: goto -163 -> 674
    //   840: astore_1
    //   841: aconst_null
    //   842: astore 7
    //   844: aconst_null
    //   845: astore_2
    //   846: aconst_null
    //   847: astore_0
    //   848: aconst_null
    //   849: astore 6
    //   851: goto -578 -> 273
    //   854: astore_1
    //   855: aconst_null
    //   856: astore_2
    //   857: aconst_null
    //   858: astore_0
    //   859: aconst_null
    //   860: astore 6
    //   862: goto -589 -> 273
    //   865: astore_1
    //   866: aconst_null
    //   867: astore_2
    //   868: aload_0
    //   869: astore 6
    //   871: aconst_null
    //   872: astore_0
    //   873: goto -600 -> 273
    //   876: astore_1
    //   877: aconst_null
    //   878: astore 7
    //   880: aconst_null
    //   881: astore 8
    //   883: aload_0
    //   884: astore 6
    //   886: aconst_null
    //   887: astore_2
    //   888: aload 8
    //   890: astore_0
    //   891: goto -618 -> 273
    //   894: astore_1
    //   895: aconst_null
    //   896: astore 7
    //   898: aconst_null
    //   899: astore_2
    //   900: aload_0
    //   901: astore 6
    //   903: aconst_null
    //   904: astore_0
    //   905: goto -632 -> 273
    //   908: astore_1
    //   909: aconst_null
    //   910: astore_2
    //   911: aconst_null
    //   912: astore 8
    //   914: aload_0
    //   915: astore 6
    //   917: aconst_null
    //   918: astore 7
    //   920: aload 8
    //   922: astore_0
    //   923: goto -650 -> 273
    //   926: astore_1
    //   927: aconst_null
    //   928: astore_2
    //   929: aconst_null
    //   930: astore_0
    //   931: goto -658 -> 273
    //   934: astore_1
    //   935: aconst_null
    //   936: astore_0
    //   937: goto -664 -> 273
    //   940: astore_1
    //   941: goto -446 -> 495
    //   944: astore_1
    //   945: goto -505 -> 440
    //   948: aconst_null
    //   949: astore 7
    //   951: goto -796 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	954	0	paramString1	String
    //   0	954	1	paramString2	String
    //   0	954	2	paramDecryptListener	DecryptListener
    //   19	467	3	i	int
    //   4	374	4	j	int
    //   1	456	5	k	int
    //   24	892	6	localObject1	Object
    //   7	943	7	localObject2	Object
    //   97	420	8	localObject3	Object
    //   742	10	8	localObject4	Object
    //   757	10	8	localObject5	Object
    //   772	10	8	localObject6	Object
    //   787	10	8	localObject7	Object
    //   812	109	8	localObject8	Object
    //   209	622	9	str1	String
    //   206	622	10	localDecryptListener	DecryptListener
    //   203	621	11	localObject9	Object
    //   241	23	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   215	223	272	java/lang/Exception
    //   237	243	272	java/lang/Exception
    //   262	269	272	java/lang/Exception
    //   518	523	272	java/lang/Exception
    //   398	409	437	java/io/IOException
    //   413	419	437	java/io/IOException
    //   440	452	494	java/io/IOException
    //   463	469	494	java/io/IOException
    //   527	531	563	java/io/IOException
    //   535	539	563	java/io/IOException
    //   544	549	563	java/io/IOException
    //   556	561	563	java/io/IOException
    //   585	593	628	java/io/IOException
    //   597	605	628	java/io/IOException
    //   610	615	628	java/io/IOException
    //   620	625	628	java/io/IOException
    //   306	310	647	java/io/IOException
    //   314	318	647	java/io/IOException
    //   323	328	647	java/io/IOException
    //   333	338	647	java/io/IOException
    //   79	113	666	finally
    //   113	129	666	finally
    //   129	152	666	finally
    //   347	373	666	finally
    //   398	409	666	finally
    //   413	419	666	finally
    //   678	682	712	java/io/IOException
    //   686	690	712	java/io/IOException
    //   695	700	712	java/io/IOException
    //   705	710	712	java/io/IOException
    //   159	166	731	finally
    //   166	171	742	finally
    //   419	423	757	finally
    //   440	452	772	finally
    //   463	469	772	finally
    //   471	475	787	finally
    //   179	189	802	finally
    //   189	201	810	finally
    //   215	223	822	finally
    //   237	243	822	finally
    //   262	269	822	finally
    //   287	302	822	finally
    //   518	523	822	finally
    //   79	113	840	java/lang/Exception
    //   113	129	840	java/lang/Exception
    //   129	152	840	java/lang/Exception
    //   347	373	840	java/lang/Exception
    //   398	409	840	java/lang/Exception
    //   413	419	840	java/lang/Exception
    //   159	166	854	java/lang/Exception
    //   166	171	865	java/lang/Exception
    //   419	423	876	java/lang/Exception
    //   440	452	894	java/lang/Exception
    //   463	469	894	java/lang/Exception
    //   471	475	908	java/lang/Exception
    //   179	189	926	java/lang/Exception
    //   189	201	934	java/lang/Exception
    //   471	475	940	java/io/IOException
    //   419	423	944	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoTemplateParser
 * JD-Core Version:    0.7.0.1
 */