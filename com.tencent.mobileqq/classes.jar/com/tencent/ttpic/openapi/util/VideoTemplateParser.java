package com.tencent.ttpic.openapi.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.constant.MaterialType;
import com.tencent.ttpic.factory.ShakaFilterFactory.FILTER_TYPE;
import com.tencent.ttpic.filament.FilamentUtil;
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
import com.tencent.ttpic.model.FaceBeautyItem;
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
import com.tencent.ttpic.offlineset.beans.FilterConfigBean;
import com.tencent.ttpic.offlineset.beans.FilterConfigBean.FilterParam;
import com.tencent.ttpic.offlineset.beans.StyleFilterSettingJsonBean;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.filter.CustomFilterItem;
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
import com.tencent.ttpic.openapi.model.CustomMaterialItem;
import com.tencent.ttpic.openapi.model.CustomMaterialItem.CustomMaterialParams;
import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.model.DynamicBoneItem;
import com.tencent.ttpic.openapi.model.ExpressionItem;
import com.tencent.ttpic.openapi.model.EyeNodeItem;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem.CartoonFaceLine;
import com.tencent.ttpic.openapi.model.FaceStyleItem.ModelConfig;
import com.tencent.ttpic.openapi.model.FaceStyleItem.ModelConfigItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem.Process;
import com.tencent.ttpic.openapi.model.FaceStyleItem.Render;
import com.tencent.ttpic.openapi.model.FaceStyleItem.STYLE_CHANGE_TYPE;
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
import com.tencent.ttpic.openapi.model.VideoMaterial.DIYMaterialParams;
import com.tencent.ttpic.openapi.model.WMElementConfig;
import com.tencent.ttpic.openapi.model.WMGroupConfig;
import com.tencent.ttpic.openapi.model.WMLogic;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunGroupItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.PagIndexList;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import com.tencent.ttpic.particle.GPUParticleConfig;
import com.tencent.ttpic.particle.GPUParticleConfig.BackgroundConfig;
import com.tencent.ttpic.particle.GPUParticleConfig.SourcePositionPath;
import com.tencent.ttpic.particle.GPUParticleConfig.Sprite;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.ttpic.particle.ParticleJsonParser;
import com.tencent.ttpic.trigger.TriggerConfig;
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
import java.lang.reflect.Array;
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
  private static Comparator<Pair<Float, Integer>> mDivideValueComp = new VideoTemplateParser.10();
  private static Comparator<Pair<Float, ? extends Object>> mDivideValueCompForObject = new VideoTemplateParser.11();
  private static Comparator<GridModel> mGridModelComparator = new VideoTemplateParser.13();
  private static Comparator<Pair<Float, Double>> mRangeValueComp = new VideoTemplateParser.12();
  
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
          break label3567;
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
          if ((localStickerItem3D.type == VideoFilterFactory.POSITION_TYPE.CAT.type) || (localStickerItem3D.getTriggerTypeInt() == 700)) {
            paramVideoMaterial.addMaterialType(MaterialType.CAT_DETECT);
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
              break label982;
            }
            paramJsonObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;
            label823:
            localStickerItem3D.sourceType = paramJsonObject;
          }
          localStickerItem3D.width = GsonUtils.optInt(localJsonObject, "width");
          localStickerItem3D.height = GsonUtils.optInt(localJsonObject, "height");
          localStickerItem3D.extraTypeWidth = GsonUtils.optInt(localJsonObject, "extraTypeWidth");
          localStickerItem3D.extarTypeHeight = GsonUtils.optInt(localJsonObject, "extraTypeHeight");
          localStickerItem3D.support3D = GsonUtils.optInt(localJsonObject, "enable3D", 1);
          paramJsonObject = GsonUtils.optJsonArray(localJsonObject, "position");
          if (paramJsonObject == null) {
            break label989;
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
    label975:
    label982:
    label989:
    int m;
    label1059:
    label1573:
    label1910:
    do
    {
      bool = false;
      break;
      paramJsonObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
      break label823;
      localStickerItem3D.position = new double[] { 0.0D, 0.0D };
      localStickerItem3D.audio = GsonUtils.optString(localJsonObject, "audio");
      if ((!TextUtils.isEmpty(localStickerItem3D.audio)) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("assets://camera/camera_video/video_")) || (paramString.contains("/files/olm/camera/video_")))) {
        break label3515;
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
            break label3546;
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
              break label2646;
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
              break label3522;
            }
            bool = true;
            localWMElementConfig.fontBold = bool;
            if (GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
              break label3528;
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
              break label3534;
            }
            bool = true;
            localWMElementConfig.emboss = bool;
            if (GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.WATERMARK_ELEMENT.MULTI_ROW.value, 0) != 1) {
              break label3540;
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
              break label2776;
            }
            localObject2 = new WMLogic();
            ((WMLogic)localObject2).type = GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
            ((WMLogic)localObject2).setCompare(GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), localWMElementConfig.sid);
            ((WMLogic)localObject2).data = GsonUtils.optString((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
            localObject4 = GsonUtils.optJsonObject((JsonObject)localObject3, VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
            if (localObject4 == null) {
              break label2671;
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
          break label3546;
        }
        localStickerItem3D.wmGroupConfig = localWMGroupConfig;
      }
      localStickerItem3D.preTriggerType = localStickerItem3D.getTriggerTypeInt();
      localStickerItem3D.framePositionsBean = parseFramePosition(paramVideoMaterial, localJsonObject);
      localArrayList.add(localStickerItem3D);
      j = localStickerItem3D.getTriggerTypeInt();
      if (GsonUtils.optInt(localJsonObject, "isElementTriggerMVPart", 0) != 0) {
        i = localStickerItem3D.getTriggerTypeInt();
      }
      paramVideoMaterial.setMusicID(GsonUtils.optString(localJsonObject, "musicID"));
      if ((localStickerItem3D.getTriggerTypeInt() != PTFaceAttr.PTExpression.ALWAYS.value) || (TextUtils.isEmpty(localStickerItem3D.audio))) {
        break label3555;
      }
      paramVideoMaterial.setOverallAudio(localStickerItem3D.id + File.separator + localStickerItem3D.audio);
      break label3555;
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
    label1935:
    label2322:
    label2348:
    label2646:
    label2671:
    label2932:
    int j = 0;
    for (;;)
    {
      label2776:
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
          break label975;
        }
        paramVideoMaterial.nodeInitialTransform = paramVideoMaterial.nodeInitialTransform.substring(0, paramVideoMaterial.nodeInitialTransform.length() - 1);
        return;
        label3546:
        label3555:
        label3567:
        do
        {
          i = j;
          break label2932;
          paramArrayOfBoolean[0] = true;
          break label1059;
          bool = false;
          break label1910;
          bool = false;
          break label1935;
          bool = false;
          break label2322;
          bool = false;
          break label2348;
          j += 1;
          break label1573;
          k += 1;
          paramJsonObject = (JsonObject)localObject1;
          break;
        } while (i <= 0);
        break label2932;
      }
      label3515:
      label3522:
      label3528:
      label3534:
      label3540:
      j += 1;
    }
  }
  
  private static List<AnimationItem> parseAnimationItems(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    ArrayList localArrayList;
    int i;
    int k;
    int j;
    JsonObject localJsonObject;
    AnimationItem localAnimationItem;
    Object localObject2;
    boolean bool;
    label694:
    int m;
    Object localObject3;
    for (;;)
    {
      try
      {
        JsonArray localJsonArray1 = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.ANIMATION__LIST.value);
        new HashMap();
        new HashMap();
        localArrayList = new ArrayList();
        if (localJsonArray1 != null)
        {
          i = 0;
          k = 0;
          paramJsonObject = null;
          localObject1 = "";
          j = 0;
          if (k >= localJsonArray1.size()) {
            break label3815;
          }
          localJsonObject = GsonUtils.getJsonObjectUnsafe(localJsonArray1, k);
          localAnimationItem = new AnimationItem();
          localAnimationItem.id = GsonUtils.optString(localJsonObject, "id");
          localAnimationItem.subFolder = localAnimationItem.id;
          localAnimationItem.name = GsonUtils.optString(localJsonObject, "name");
          localAnimationItem.type = GsonUtils.optInt(localJsonObject, "type");
          localAnimationItem.scale = ((float)GsonUtils.optDouble(localJsonObject, "scale", 1.0D));
          localAnimationItem.angle = ((float)GsonUtils.optDouble(localJsonObject, "angle", 0.0D));
          localAnimationItem.dx = GsonUtils.optInt(localJsonObject, "dx", 0);
          localAnimationItem.dy = GsonUtils.optInt(localJsonObject, "dy", 0);
          localAnimationItem.personID = GsonUtils.optInt(localJsonObject, "personID", -1);
          localAnimationItem.genderType = GsonUtils.optInt(localJsonObject, "genderType", 0);
          localAnimationItem.alpha = ((float)GsonUtils.optDouble(localJsonObject, "alpha", 1.0D));
          localAnimationItem.snapshotTime = GsonUtils.optInt(localJsonObject, "snapshotTime", 0);
          if (localAnimationItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localAnimationItem.featureStatType = GsonUtils.optInt(localJsonObject, "featureStatType");
          localAnimationItem.frameType = GsonUtils.optInt(localJsonObject, "frameType");
          localAnimationItem.blendMode = GsonUtils.optInt(localJsonObject, "blendMode", -1);
          localAnimationItem.zIndex = GsonUtils.optInt(localJsonObject, "zIndex");
          localAnimationItem.audioLoopCount = GsonUtils.optInt(localJsonObject, "audioLoopCount", -1);
          localAnimationItem.randomGroupNum = GsonUtils.optInt(localJsonObject, "randomGroupNum");
          localAnimationItem.externalTriggerWords = GsonUtils.optString(localJsonObject, "externalTriggerWords");
          localObject2 = localAnimationItem.externalTriggerWords;
          localAnimationItem.triggerState = new ArrayList();
          localObject1 = GsonUtils.optJsonArray(localJsonObject, "triggerStateList");
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
            localObject1 = GsonUtils.optString(localJsonObject, "triggerState");
            if ((localObject1 != null) && (!"".equals(localObject1))) {
              localAnimationItem.triggerState.add(localObject1);
            }
          }
          localObject1 = GsonUtils.optJsonObject(localJsonObject, "triggerStateRange");
          if (localObject1 != null)
          {
            localAnimationItem.triggerStateRange = new StickerItem.ValueRange();
            localAnimationItem.triggerStateRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min", 1.0D);
            localAnimationItem.triggerStateRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max", 0.0D);
          }
          localObject1 = GsonUtils.optJsonObject(localJsonObject, "featureStatValueRange");
          if (localObject1 != null)
          {
            localAnimationItem.featureStatValueRange = new StickerItem.ValueRange();
            localAnimationItem.featureStatValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
            localAnimationItem.featureStatValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
          }
          localObject1 = GsonUtils.optJsonObject(localJsonObject, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject1 != null)
          {
            localAnimationItem.charmRange = new CharmRange();
            localAnimationItem.charmRange.min = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localAnimationItem.charmRange.max = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localAnimationItem.setTriggerType(GsonUtils.optString(localJsonObject, "triggerType"));
          localAnimationItem.audioTriggerType = GsonUtils.optInt(localJsonObject, "audioTriggerType");
          if (GsonUtils.optInt(localJsonObject, "audioNeedAdjust", 1) != 1) {
            break label3762;
          }
          bool = true;
          localAnimationItem.audioNeedAdjust = bool;
          if (GsonUtils.optInt(localJsonObject, "orderMode", 1) == 1)
          {
            localAnimationItem.orderMode = VideoMaterialUtil.STICKER_ORDER_MODE.AFTER_TRANSFORM;
            localObject1 = GsonUtils.optJsonObject(localJsonObject, "audioValueRange");
            if (localObject1 != null)
            {
              localAnimationItem.audioValueRange = new StickerItem.ValueRange();
              localAnimationItem.audioValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
              localAnimationItem.audioValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
            }
            if (GsonUtils.optInt(localJsonObject, "alwaysTriggered") == 1)
            {
              bool = true;
              localAnimationItem.alwaysTriggered = bool;
              localAnimationItem.playCount = GsonUtils.optInt(localJsonObject, "playCount");
              localAnimationItem.comicOrderMode = GsonUtils.optInt(localJsonObject, "comicOrderMode", 1);
              localAnimationItem.comicLutFilter = GsonUtils.optString(localJsonObject, "comicLutFilter");
              localAnimationItem.styleFilter = GsonUtils.optString(localJsonObject, "styleFilter");
              if (!TextUtils.isEmpty(localAnimationItem.styleFilter)) {
                paramVideoMaterial.addMaterialType(MaterialType.STYLE_MASK);
              }
              localAnimationItem.triggerFrameDurationTime = GsonUtils.optInt(localJsonObject, "triggerFrameDurationTime");
              localAnimationItem.triggedTimes = GsonUtils.optInt(localJsonObject, "triggeredTimes");
              localAnimationItem.delayedTriggedTime = GsonUtils.optInt(localJsonObject, "triggeredDelayTime");
              localAnimationItem.frameDuration = GsonUtils.optDouble(localJsonObject, "frameDuration");
              localObject1 = GsonUtils.optJsonArray(localJsonObject, "triggerFrameStartTime");
              if (localObject1 == null) {
                break label1378;
              }
              m = ((JsonArray)localObject1).size();
              if (m <= 1) {
                break label1364;
              }
              localObject3 = new long[m];
              j = 0;
              if (j >= m) {
                break;
              }
              localObject3[j] = ((GsonUtils.optInt((JsonArray)localObject1, j) * localAnimationItem.frameDuration));
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
    localAnimationItem.triggerTimeUpdater = new TriggerTimeUpdater((long[])localObject3, (localAnimationItem.delayedTriggedTime * localAnimationItem.frameDuration), (localAnimationItem.triggerFrameDurationTime * localAnimationItem.frameDuration));
    localAnimationItem.triggerFrameStartTime = ((int)(localAnimationItem.triggerTimeUpdater.updateCurTriggerTime(-1L, 0L, false) / localAnimationItem.frameDuration));
    localAnimationItem.stickerType = GsonUtils.optInt(localJsonObject, "stickerType");
    if ((localAnimationItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (localAnimationItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type)) {
      if (localAnimationItem.stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
        break label1394;
      }
    }
    Object localObject4;
    label1364:
    label1378:
    label1394:
    for (Object localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;; localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT)
    {
      localAnimationItem.sourceType = ((VideoMaterialUtil.ITEM_SOURCE_TYPE)localObject1);
      localAnimationItem.frames = GsonUtils.optInt(localJsonObject, "frames");
      localAnimationItem.width = GsonUtils.optInt(localJsonObject, "width");
      localAnimationItem.height = GsonUtils.optInt(localJsonObject, "height");
      localAnimationItem.extraTypeWidth = GsonUtils.optInt(localJsonObject, "extraTypeWidth");
      localAnimationItem.extarTypeHeight = GsonUtils.optInt(localJsonObject, "extraTypeHeight");
      localAnimationItem.maxScaledWidth = GsonUtils.optInt(localJsonObject, "maxScaledWidth");
      localAnimationItem.minScaledWidth = GsonUtils.optInt(localJsonObject, "minScaledWidth");
      localAnimationItem.support3D = GsonUtils.optInt(localJsonObject, "enable3D", 1);
      localAnimationItem.scaleDirection = GsonUtils.optInt(localJsonObject, "scaleDirection");
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "zoomScale");
      if (localObject1 == null) {
        break label1413;
      }
      localObject3 = ((JsonObject)localObject1).keySet().iterator();
      localAnimationItem.zoomScale = new ArrayList();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localAnimationItem.zoomScale.add(Pair.create(Float.valueOf((String)localObject4), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject4, 0.0D))));
      }
      localAnimationItem.triggerFrameStartTime = GsonUtils.optInt((JsonArray)localObject1, 0);
      break;
      localAnimationItem.triggerFrameStartTime = GsonUtils.optInt(localJsonObject, "triggerFrameStartTime");
      break;
    }
    Collections.sort(localAnimationItem.zoomScale, mRangeValueComp);
    label1413:
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "activeParts");
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
    localAnimationItem.zoomType = GsonUtils.optInt(localJsonObject, "zoomType");
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "zoomFocusPoint");
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
    localAnimationItem.zoomWidth = ((float)GsonUtils.optDouble(localJsonObject, "zoomWidth"));
    localAnimationItem.zoomHeight = ((float)GsonUtils.optDouble(localJsonObject, "zoomHeight"));
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "position");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "rotateType");
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
    localAnimationItem.audio = GsonUtils.optString(localJsonObject, "audio");
    localAnimationItem.lutFilterName = GsonUtils.optString(localJsonObject, "lutFilterName");
    localAnimationItem.filterOrderMode = GsonUtils.optInt(localJsonObject, "filterOrderMode", 0);
    localAnimationItem.filterAlphaGradientDuration = GsonUtils.optDouble(localJsonObject, "filterAlphaGradientDuration", 1.0D);
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "frameSize");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "anchorPoint");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "anchorPointAudio");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "alignFacePoints");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "scalePivots");
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
    localAnimationItem.scaleFactor = GsonUtils.optInt(localJsonObject, "scaleFactor");
    localAnimationItem.originalScaleFactor = localAnimationItem.scaleFactor;
    localAnimationItem.markMode = GsonUtils.optInt(localJsonObject, "markMode");
    localAnimationItem.lazyLoad = GsonUtils.optInt(localJsonObject, "lazyLoadFlag");
    localAnimationItem.activateTriggerType = GsonUtils.optInt(localJsonObject, "activateTriggerType", 0);
    localAnimationItem.activateTriggerCount = GsonUtils.optInt(localJsonObject, "activateTriggerCount", 0);
    localAnimationItem.activateTriggerTotalCount = GsonUtils.optInt(localJsonObject, "activateTriggerTotalCount", 0);
    localAnimationItem.lockTriggerCountUntilFail = GsonUtils.optInt(localJsonObject, "lockTriggerCountUntilFail", 0);
    localAnimationItem.bodyTriggerPoint = GsonUtils.optInt(localJsonObject, "bodyTriggerPoint", 0);
    localAnimationItem.bodyTriggerDirection = GsonUtils.optInt(localJsonObject, "bodyTriggerDirection", 0);
    localAnimationItem.bodyTriggerDistance = GsonUtils.optInt(localJsonObject, "bodyTriggerDistance", 0);
    localAnimationItem.bodyTriggerTimeGap = GsonUtils.optDouble(localJsonObject, "bodyTriggerTimeGap", 0.0D);
    localAnimationItem.relativeScaleType = GsonUtils.optInt(localJsonObject, "relativeScaleType");
    label2260:
    int n;
    if (GsonUtils.optInt(localJsonObject, "orienting") == 1)
    {
      bool = true;
      localAnimationItem.orienting = bool;
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "ageRange");
      if (localObject1 != null)
      {
        localAnimationItem.ageRange = new AgeRange();
        localAnimationItem.ageRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.ageRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "genderRange");
      if (localObject1 != null)
      {
        localAnimationItem.genderRange = new GenderRange();
        localAnimationItem.genderRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.genderRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "popularRange");
      if (localObject1 != null)
      {
        localAnimationItem.popularRange = new PopularRange();
        localAnimationItem.popularRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.popularRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "cpRange");
      if (localObject1 != null)
      {
        localAnimationItem.cpRange = new CpRange();
        localAnimationItem.cpRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localAnimationItem.cpRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "audioScaleFactor");
      if (localObject1 != null)
      {
        localObject3 = ((JsonObject)localObject1).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localAnimationItem.audioScaleFactorMap.add(Pair.create(Float.valueOf((String)localObject4), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject4, 0.0D))));
        }
      }
      Collections.sort(localAnimationItem.audioScaleFactorMap, mRangeValueComp);
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "transition");
      if (localObject1 != null)
      {
        localAnimationItem.transition = new Transition();
        localAnimationItem.transition.particleCountMax = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_COUNT_MAX.value);
        localAnimationItem.transition.life = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.LIFE.value);
        localAnimationItem.transition.emissionMode = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.EMISSION_MODE.value);
        localObject3 = localAnimationItem.transition;
        if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_ALWAYS_UPDATE.value) != 1) {
          break label3774;
        }
        bool = true;
        label2713:
        ((Transition)localObject3).particleAlwaysUpdate = bool;
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
      localAnimationItem.triggerWords = GsonUtils.optString(localJsonObject, "triggerWords");
      localAnimationItem.preTriggerType = localAnimationItem.getTriggerTypeInt();
      localAnimationItem.dexName = GsonUtils.optString(localJsonObject, "dexName");
      localArrayList.add(localAnimationItem);
      n = localAnimationItem.getTriggerTypeInt();
      if (GsonUtils.optInt(localJsonObject, "isElementTriggerMVPart", 0) != 0) {
        i = localAnimationItem.getTriggerTypeInt();
      }
      if (GsonUtils.optInt(localJsonObject, "followPhoneAngle", 0) != 1) {
        break label3780;
      }
      bool = true;
      label3020:
      localAnimationItem.followPhoneAngle = bool;
      localAnimationItem.strokeType = GsonUtils.optInt(localJsonObject, "strokeType", 0);
      localAnimationItem.strokeStyle = GsonUtils.optInt(localJsonObject, "strokeStyle", 0);
      localAnimationItem.strokeColor = StrokeUtil.parseRGBAColor(GsonUtils.optString(localJsonObject, "strokeColor", ""));
      localAnimationItem.strokeWidth = GsonUtils.optDouble(localJsonObject, "strokeWidth", 0.0D);
      localAnimationItem.strokeGap = GsonUtils.optDouble(localJsonObject, "strokeGap", 0.0D);
      if (GsonUtils.optInt(localJsonObject, "isStrokeBlur", 0) != 1) {
        break label3786;
      }
      bool = true;
      label3118:
      localAnimationItem.isStrokeBlur = bool;
      localAnimationItem.hairLutName = GsonUtils.optString(localJsonObject, "hairLutName");
      localAnimationItem.hairMaskType = Integer.valueOf(GsonUtils.optInt(localJsonObject, "hairMaskType", 0));
      localAnimationItem.needCrop = GsonUtils.optInt(localJsonObject, "needCrop", 0);
      localAnimationItem.maskType = GsonUtils.optString(localJsonObject, "maskType");
      localAnimationItem.maskLut = GsonUtils.optString(localJsonObject, "maskLut");
      localObject1 = GsonUtils.optJsonArray(localJsonObject, "hotArea");
      if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0))
      {
        localAnimationItem.hotArea = new double[((JsonArray)localObject1).size()];
        j = 0;
        while (j < ((JsonArray)localObject1).size())
        {
          localAnimationItem.hotArea[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
          j += 1;
        }
        paramVideoMaterial.addMaterialType(MaterialType.HOT_AREA);
      }
      localAnimationItem.redPacketStartFrame = GsonUtils.optInt(localJsonObject, "hotAreaStartFrame");
      localAnimationItem.redPacketEndFrame = GsonUtils.optInt(localJsonObject, "hotAreaEndFrame");
      localAnimationItem.activateTriggerCountOnce = GsonUtils.optInt(localJsonObject, "activateTriggerCountOnce");
      localAnimationItem.triggerHandPoint = GsonUtils.optInt(localJsonObject, "triggerHandPoint");
      localObject1 = GsonUtils.optJsonArray(localJsonObject, "triggerAreas");
      if (localObject1 != null)
      {
        localAnimationItem.triggerArea = new ArrayList();
        j = 0;
        label3349:
        if (j < ((JsonArray)localObject1).size())
        {
          localObject3 = new StickerItem.TriggerArea();
          localObject4 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
          if (localObject4 == null) {
            break label3792;
          }
          ((StickerItem.TriggerArea)localObject3).type = GsonUtils.optInt((JsonObject)localObject4, "type");
          JsonArray localJsonArray2 = GsonUtils.optJsonArray((JsonObject)localObject4, "rect");
          if (localJsonArray2 != null)
          {
            ((StickerItem.TriggerArea)localObject3).rect = new float[localJsonArray2.size()];
            m = 0;
            while (m < localJsonArray2.size())
            {
              ((StickerItem.TriggerArea)localObject3).rect[m] = GsonUtils.getFloatSafe(localJsonArray2, m);
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
          break label3792;
        }
        if (localAnimationItem.triggerArea.size() > 0)
        {
          paramJsonObject = localAnimationItem.triggerArea;
          label3552:
          localAnimationItem.isDefault = GsonUtils.optInt(localJsonObject, "isDefault");
          paramVideoMaterial.setMusicID(GsonUtils.optString(localJsonObject, "musicID"));
          if ((localAnimationItem.getTriggerTypeInt() == PTFaceAttr.PTExpression.ALWAYS.value) && (!TextUtils.isEmpty(localAnimationItem.audio))) {
            paramVideoMaterial.setOverallAudio(localAnimationItem.id + File.separator + localAnimationItem.audio);
          }
          if ((localAnimationItem.type != VideoFilterFactory.POSITION_TYPE.CAT.type) && (localAnimationItem.getTriggerTypeInt() != 700)) {
            break label3799;
          }
          paramVideoMaterial.addMaterialType(MaterialType.CAT_DETECT);
          break label3799;
        }
      }
    }
    for (;;)
    {
      label3673:
      paramVideoMaterial = localArrayList.iterator();
      while (paramVideoMaterial.hasNext())
      {
        localObject2 = (AnimationItem)paramVideoMaterial.next();
        if (((AnimationItem)localObject2).activateTriggerType == 0)
        {
          ((AnimationItem)localObject2).countTriggerType = i;
          ((AnimationItem)localObject2).activateTriggerArea = paramJsonObject;
          ((AnimationItem)localObject2).countExternalTriggerWords = ((String)localObject1);
        }
        else
        {
          ((AnimationItem)localObject2).playCount = 0;
          ((AnimationItem)localObject2).countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
        }
      }
      return localArrayList;
      label3762:
      label3774:
      label3780:
      label3786:
      label3792:
      label3799:
      label3815:
      do
      {
        i = j;
        break label3673;
        break label3552;
        bool = false;
        break label694;
        bool = false;
        break label2260;
        bool = false;
        break label2713;
        bool = false;
        break label3020;
        bool = false;
        break label3118;
        j += 1;
        break label3349;
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
    boolean bool2 = true;
    paramVideoMaterial.setId(VideoMaterialUtil.getMaterialId(paramString));
    paramVideoMaterial.setShaderType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.SHADER_TYPE.value));
    paramVideoMaterial.setMaxFaceCount(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
    paramVideoMaterial.setBlendMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.BLEND_MODE.value));
    paramVideoMaterial.setFilterId(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.FILTER_ID.value));
    paramVideoMaterial.setFilterBlurStrength(GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.FIELD.FILTER_BLUR_STRENGTH.value, 0.0D));
    label223:
    label246:
    int i;
    label270:
    label294:
    label318:
    label342:
    int j;
    label428:
    label446:
    int k;
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.SUPPORT_LANDSCAPE.value, 1) == 1)
    {
      bool1 = true;
      paramVideoMaterial.setSupportLandscape(bool1);
      paramVideoMaterial.setRandomGroupCount(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.RANDOM_GROUP_COUNT.value));
      paramVideoMaterial.setTipsText(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.TIPS_TEXT.value));
      paramVideoMaterial.setTipsIcon(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.TIPS_ICON.value));
      paramVideoMaterial.setHandBoostEnable(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.HAND_BOOST_ENABLE.value));
      paramVideoMaterial.setDetectorFlag(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.DETECTOR_FLAG.value));
      paramVideoMaterial.setTouchFlag(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.TOUCH_FLAG.value, 0));
      paramVideoMaterial.setStateVersion(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.STATE_VERSION.value, 1));
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.USE_MESH.value, 0) == 0) {
        break label943;
      }
      bool1 = true;
      paramVideoMaterial.setUseMesh(bool1);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.NOT_ALLOW_BEAUTY_SETTING.value, 0) == 0) {
        break label949;
      }
      bool1 = true;
      paramVideoMaterial.setNotAllowBeautySetting(bool1);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.RESET_WHEN_START_RECORD.value, 0) != 1) {
        break label955;
      }
      bool1 = true;
      paramVideoMaterial.setResetWhenStartRecord(bool1);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.SUPPORT_PAUSE.value, 0) != 1) {
        break label961;
      }
      bool1 = true;
      paramVideoMaterial.setSupportPause(bool1);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.IS_INTERNAL_RECORD.value, 0) != 1) {
        break label967;
      }
      bool1 = true;
      paramVideoMaterial.setIsInternalRecord(bool1);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.IS_AR_3D_Material.value, 0) != 1) {
        break label973;
      }
      bool1 = true;
      paramVideoMaterial.setIsAR3DMaterial(bool1);
      paramVideoMaterial.setArMaterialType(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.AR_Material_Type.value, 0));
      paramVideoMaterial.setVoicekind(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.VOICE_KIND.value, -999999));
      paramVideoMaterial.setEnvironment(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.ENVIRONMENT.value, -999999));
      paramVideoMaterial.setFaceExchangeImage(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE_FULL_FACE.value, 0) != 1) {
        break label979;
      }
      i = 1;
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE_DISABLE_OPACITY.value, 0) != 1) {
        break label984;
      }
      j = 1;
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE_DISABLE_FACECROP.value, 0) != 1) {
        break label990;
      }
      k = 1;
      label464:
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label996;
      }
      bool1 = true;
      label481:
      paramVideoMaterial.setFaceExchangeImageDisableFaceCrop(bool1);
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
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.NEED_RECALCULATE_FACE.value, 0) != 1) {
        break label1002;
      }
    }
    label943:
    label949:
    label955:
    label961:
    label967:
    label973:
    label979:
    label984:
    label990:
    label996:
    label1002:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoMaterial.setNeedReCaculateFace(bool1);
      paramVideoMaterial.setMinAppVersion(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
      paramVideoMaterial.setCategoryFlag(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.CATEGORY_FLAG.value, 0));
      paramVideoMaterial.setOrderMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.ORDER_MODE.value));
      paramVideoMaterial.setStickerOrderMode(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FIELD.STICKER_ORDER_MODE.value));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label223;
      bool1 = false;
      break label246;
      bool1 = false;
      break label270;
      bool1 = false;
      break label294;
      bool1 = false;
      break label318;
      bool1 = false;
      break label342;
      i = 0;
      break label428;
      j = 0;
      break label446;
      k = 0;
      break label464;
      bool1 = false;
      break label481;
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
  
  private static void parseCosFunParams(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.COS_FUN.value);
    if (paramJsonObject == null) {
      return;
    }
    CosFun localCosFun = new CosFun();
    localCosFun.setTipsAnim(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM.value));
    localCosFun.setTipsAnimFrames(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAMES.value));
    localCosFun.setTipsAnimFrameDuration(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAME_DURATION.value));
    localCosFun.setStartInterval(GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.START_INTERVAL.value));
    boolean bool;
    ArrayList localArrayList1;
    int i;
    label175:
    Object localObject1;
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.ENABLE_GAN.value) == 1)
    {
      bool = true;
      localCosFun.setEnableGAN(bool);
      if (localCosFun.getTipsAnim() != null) {
        paramVideoMaterial.createTipsDrawableInfo(AEModule.getContext().getResources(), paramVideoMaterial.getDataPath(), localCosFun.getTipsAnim(), localCosFun.getTipsAnimFrameDuration(), localCosFun.getTipsAnimFrames());
      }
      JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.COS_FUN_GROUP.value);
      localArrayList1 = new ArrayList();
      if (localJsonArray == null) {
        break label906;
      }
      i = 0;
      if (i >= localJsonArray.size()) {
        break label906;
      }
      localObject1 = GsonUtils.optJsonObject(localJsonArray, i);
      if (localObject1 != null) {
        break label214;
      }
    }
    for (;;)
    {
      i += 1;
      break label175;
      bool = false;
      break;
      label214:
      localCosFun.setTipsAnim(GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM.value));
      localCosFun.setTipsAnimFrames(GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAMES.value));
      localCosFun.setTipsAnimFrameDuration(GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.TIPS_ANIM_FRAME_DURATION.value));
      localCosFun.setStartInterval(GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_FIELD.START_INTERVAL.value));
      CosFun.CosFunGroupItem localCosFunGroupItem;
      ArrayList localArrayList2;
      int j;
      label386:
      Object localObject2;
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.COS_FUN_FIELD.ENABLE_GAN.value) == 1)
      {
        bool = true;
        localCosFun.setEnableGAN(bool);
        paramVideoMaterial.createTipsDrawableInfo(AEModule.getContext().getResources(), paramVideoMaterial.getDataPath(), localCosFun.getTipsAnim(), localCosFun.getTipsAnimFrameDuration(), localCosFun.getTipsAnimFrames());
        localCosFunGroupItem = new CosFun.CosFunGroupItem();
        localCosFunGroupItem.setLoopMode(GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_GROUP_FIELD.LOOP_MODE.value));
        localArrayList2 = new ArrayList();
        localObject1 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS.value);
        if (localObject1 == null) {
          continue;
        }
        j = 0;
        if (j >= ((JsonArray)localObject1).size()) {
          break label888;
        }
        localObject2 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
        if (localObject2 != null) {
          break label425;
        }
      }
      for (;;)
      {
        j += 1;
        break label386;
        bool = false;
        break;
        label425:
        CosFun.CosFunItem localCosFunItem = new CosFun.CosFunItem();
        localCosFunItem.setId(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_ID.value));
        localCosFunItem.setTriggerType(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRIGGER_TYPE.value));
        localCosFunItem.setExternalTriggerWords(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_EXTERNAL_TRIGGER_WORDS.value));
        localCosFunItem.setDuration(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_DURATION.value));
        localCosFunItem.setFreezeStart(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_FREEZE_START.value));
        localCosFunItem.setFreezeDuration(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_FREEZE_DURATION.value));
        localCosFunItem.setTransStart(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_START.value));
        localCosFunItem.setTransDuration(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_DURATION.value));
        localCosFunItem.setTransReverseStart(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_REVERSE_START.value));
        localCosFunItem.setTransReverseDuration(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TRANS_REVERSE_DURATION.value));
        localCosFunItem.setWaitInterval(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_WAIT_INTERVAL.value));
        localCosFunItem.setCrazyFacePath(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_CRAZY_FACE_PATH.value));
        localCosFunItem.setBackgroundMode1(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_BACKGROUND_MODE1.value));
        localCosFunItem.setBackgroundMode2(GsonUtils.optInt((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_BACKGROUND_MODE2.value));
        localCosFunItem.setPagPath(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_PAG_PATH.value));
        if (!TextUtils.isEmpty(GsonUtils.optString((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_CUSTOM_FILTER_CONFIG_FILE.value))) {
          localCosFunItem.setCustomFilterItemList(parseCustomFilterConfig(paramString, (JsonObject)localObject2, paramVideoMaterial, paramDecryptListener, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_CUSTOM_FILTER_CONFIG_FILE.value));
        }
        ArrayList localArrayList3 = new ArrayList();
        Object localObject3 = GsonUtils.optJsonArray((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_TEXTURE_MATERIALS_FOR_GAN.value);
        if (localObject3 != null)
        {
          k = 0;
          while (k < ((JsonArray)localObject3).size())
          {
            localArrayList3.add(GsonUtils.getStringUnsafe((JsonArray)localObject3, k));
            k += 1;
          }
          localCosFunItem.setTextureMaterialsForGAN(localArrayList3);
        }
        localObject3 = GsonUtils.optJsonObject((JsonObject)localObject2, VideoMaterialUtil.COS_FUN_GROUP_FIELD.COSFUN_ITEMS_PAG_INDEX_LIST.value);
        localObject2 = new CosFun.PagIndexList();
        localArrayList3 = new ArrayList();
        localObject3 = GsonUtils.optJsonArray((JsonObject)localObject3, VideoMaterialUtil.PAG_INDEX_LIST.COS_FUN.value);
        int k = 0;
        while (k < ((JsonArray)localObject3).size())
        {
          localArrayList3.add(Integer.valueOf(GsonUtils.optInt((JsonArray)localObject3, k)));
          k += 1;
        }
        ((CosFun.PagIndexList)localObject2).setCosFun(localArrayList3);
        localCosFunItem.setPagIndexList((CosFun.PagIndexList)localObject2);
        localArrayList2.add(localCosFunItem);
      }
      label888:
      localCosFunGroupItem.setCosFunItems(localArrayList2);
      localArrayList1.add(localCosFunGroupItem);
    }
    label906:
    localCosFun.setCosFunGroupItem(localArrayList1);
    paramVideoMaterial.setCosFun(localCosFun);
  }
  
  public static void parseCustomCosFunInnerFilterGroupConfigFile(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    paramVideoMaterial.setCustomCosFunInnerFilterGroupList(parseCustomFilterConfig(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener, VideoMaterialUtil.FIELD.CUSTOM_COSFUN_INNER_FILTER_CONFIG_FILE.value));
  }
  
  private static ArrayList<CustomFilterItem> parseCustomFilterConfig(String paramString1, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener, String paramString2)
  {
    paramVideoMaterial = GsonUtils.optString(paramJsonObject, paramString2);
    paramString2 = new ArrayList();
    if (TextUtils.isEmpty(paramVideoMaterial)) {
      return null;
    }
    int i = paramVideoMaterial.lastIndexOf(".");
    paramJsonObject = paramVideoMaterial;
    if (i >= 0) {
      paramJsonObject = paramVideoMaterial.substring(0, i);
    }
    paramJsonObject = parseVideoMaterialFileAsJSONObject(paramString1, paramJsonObject, true, paramDecryptListener);
    if (paramJsonObject == null) {
      return null;
    }
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "customFilterList");
    if (paramJsonObject == null) {
      return null;
    }
    if (paramJsonObject.size() <= 0) {
      return null;
    }
    i = 0;
    if (i < paramJsonObject.size())
    {
      paramVideoMaterial = GsonUtils.optJsonObject(paramJsonObject, i);
      if (paramVideoMaterial == null) {}
      for (;;)
      {
        i += 1;
        break;
        paramDecryptListener = new CustomFilterItem();
        paramDecryptListener.id = GsonUtils.optString(paramVideoMaterial, "id");
        Object localObject = GsonUtils.optJsonArray(paramVideoMaterial, "preFilterId");
        int j;
        if (localObject != null)
        {
          paramDecryptListener.preFilterId = new ArrayList();
          j = 0;
          while (j < ((JsonArray)localObject).size())
          {
            paramDecryptListener.preFilterId.add(GsonUtils.getStringUnsafe((JsonArray)localObject, j));
            j += 1;
          }
        }
        paramDecryptListener.filterType = GsonUtils.optInt(paramVideoMaterial, "filterType");
        localObject = GsonUtils.optString(paramVideoMaterial, "fragment");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramDecryptListener.fragment = FileUtils.load(AEModule.getContext(), FileUtils.genSeperateFileDir(paramString1) + (String)localObject);
        }
        localObject = GsonUtils.optString(paramVideoMaterial, "vertex");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramDecryptListener.vertex = FileUtils.load(AEModule.getContext(), FileUtils.genSeperateFileDir(paramString1) + (String)localObject);
        }
        localObject = GsonUtils.optJsonArray(paramVideoMaterial, "inputFrameSize");
        if (localObject != null)
        {
          paramDecryptListener.inputFrameSize = new int[((JsonArray)localObject).size()];
          j = 0;
          while (j < ((JsonArray)localObject).size())
          {
            paramDecryptListener.inputFrameSize[j] = GsonUtils.getIntUnsafe((JsonArray)localObject, j);
            j += 1;
          }
        }
        localObject = GsonUtils.optJsonArray(paramVideoMaterial, "outputFrameSize");
        if (localObject != null)
        {
          paramDecryptListener.outputFrameSize = new int[((JsonArray)localObject).size()];
          j = 0;
          while (j < ((JsonArray)localObject).size())
          {
            paramDecryptListener.outputFrameSize[j] = GsonUtils.getIntUnsafe((JsonArray)localObject, j);
            j += 1;
          }
        }
        paramDecryptListener.filterName = GsonUtils.optString(paramVideoMaterial, "filterName");
        paramDecryptListener.filterValue = GsonUtils.optFloat(paramVideoMaterial, "filterValue");
        paramDecryptListener.lutPaths = parseFaceStyleItemPaths(paramVideoMaterial, "lutPaths", paramString1);
        paramDecryptListener.materialPaths = parseFaceStyleItemPaths(paramVideoMaterial, "materialPaths", paramString1);
        paramString2.add(paramDecryptListener);
      }
    }
    return paramString2;
  }
  
  public static void parseCustomFilterGroupConfigFile(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    paramVideoMaterial.setCustomFilterGroupList(parseCustomFilterConfig(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener, VideoMaterialUtil.FIELD.CUSTOM_FILTER_CONFIG_FILE.value));
  }
  
  private static List<CustomMaterialItem> parseCustomMaterials(JsonObject paramJsonObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "customMaterials");
    if (paramJsonObject != null)
    {
      int i = 0;
      while (i < paramJsonObject.size())
      {
        Object localObject1 = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localObject1 != null)
        {
          CustomMaterialItem localCustomMaterialItem = new CustomMaterialItem();
          localCustomMaterialItem.matName = GsonUtils.optString((JsonObject)localObject1, "matName", "");
          Object localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, "nodeNameList");
          int j;
          if (localObject2 != null)
          {
            j = 0;
            while (j < ((JsonArray)localObject2).size())
            {
              localCustomMaterialItem.nodeNameList.add(GsonUtils.optString((JsonArray)localObject2, j));
              j += 1;
            }
          }
          localObject1 = GsonUtils.optJsonArray((JsonObject)localObject1, "params");
          if (localObject1 != null)
          {
            j = 0;
            while (j < ((JsonArray)localObject1).size())
            {
              localObject2 = new CustomMaterialItem.CustomMaterialParams();
              Object localObject3 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
              ((CustomMaterialItem.CustomMaterialParams)localObject2).type = GsonUtils.optString((JsonObject)localObject3, "type", "");
              ((CustomMaterialItem.CustomMaterialParams)localObject2).uniformName = GsonUtils.optString((JsonObject)localObject3, "uniformName", "");
              localObject3 = GsonUtils.optJsonArray((JsonObject)localObject3, "value");
              if (localObject3 != null)
              {
                int k = 0;
                while (k < ((JsonArray)localObject3).size())
                {
                  ((CustomMaterialItem.CustomMaterialParams)localObject2).value.add(GsonUtils.optString((JsonArray)localObject3, k));
                  k += 1;
                }
              }
              localCustomMaterialItem.params.add(localObject2);
              j += 1;
            }
          }
          localArrayList.add(localCustomMaterialItem);
        }
        i += 1;
      }
    }
    return localArrayList;
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
            localArrayList2.add(new VideoTemplateParser.4());
            localArrayList2.add(new VideoTemplateParser.5());
            localArrayList2.add(new VideoTemplateParser.6());
            localArrayList2.add(new VideoTemplateParser.7());
            localArrayList2.add(new VideoTemplateParser.8());
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
    ArrayList localArrayList = new ArrayList();
    JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.EXPRESSION_CONFIG_LIST.value);
    if (localJsonArray != null)
    {
      int i = 0;
      if (i < localJsonArray.size())
      {
        Object localObject = GsonUtils.optJsonObject(localJsonArray, i);
        AnimojiExpressionJava localAnimojiExpressionJava;
        if (localObject != null)
        {
          localAnimojiExpressionJava = new AnimojiExpressionJava();
          localAnimojiExpressionJava.shapeName = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.SHAPE_NAME.value, "");
          localAnimojiExpressionJava.controlledName = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.CONTROLLED_NAME.value, localAnimojiExpressionJava.shapeName);
          paramJsonObject = new Range();
          localObject = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.SHAPE_RANGE.value);
          if (((JsonArray)localObject).size() < 2) {
            break label166;
          }
          paramJsonObject.min = GsonUtils.getFloatUnsafe((JsonArray)localObject, 0);
          paramJsonObject.max = GsonUtils.getFloatUnsafe((JsonArray)localObject, 1);
        }
        for (;;)
        {
          localAnimojiExpressionJava.shapeRange = paramJsonObject;
          localArrayList.add(localAnimojiExpressionJava);
          i += 1;
          break;
          label166:
          paramJsonObject = FilamentUtil.getDefaultExpressionRange(localAnimojiExpressionJava.shapeName);
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
    boolean bool;
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
        int k;
        if (localObject5 != null)
        {
          localObject6 = new StickerItem();
          localObject1 = GsonUtils.optString((JsonObject)localObject5, "videoFile");
          localObject2 = GsonUtils.optString((JsonObject)localObject5, "imageName");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1936;
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
            bool = true;
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
            ((StickerItem)localObject6).isCanDiyPitcureVideo = GsonUtils.optInt((JsonObject)localObject5, "isCanDiyPitcureVideo");
            if (((StickerItem)localObject6).isCanDiyPitcureVideo == 1)
            {
              j = GsonUtils.optInt((JsonObject)localObject5, "width", 720);
              k = GsonUtils.optInt((JsonObject)localObject5, "height", 960);
              localObject1 = new VideoMaterial.DIYMaterialParams();
              ((VideoMaterial.DIYMaterialParams)localObject1).diyItemid = ((StickerItem)localObject6).id;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyImageWidth = j;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyImageHeight = k;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyFrameDuration = ((StickerItem)localObject6).frameDuration;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyVideoDuration = (((VideoMaterial.DIYMaterialParams)localObject1).diyFrameDuration * ((StickerItem)localObject6).frames);
              ((VideoMaterial.DIYMaterialParams)localObject1).diyType = GsonUtils.optInt((JsonObject)localObject5, "diyType", 3);
              ((VideoMaterial.DIYMaterialParams)localObject1).diyFilePath = GsonUtils.optString((JsonObject)localObject5, "diyFilePath", "");
              ((VideoMaterial.DIYMaterialParams)localObject1).diyIsVideoFile = bool;
              paramVideoMaterial.addDiyItemList((VideoMaterial.DIYMaterialParams)localObject1);
              paramVideoMaterial.addMaterialType(MaterialType.MATERIAL_REPLACE);
            }
            if (!bool) {
              break label2019;
            }
            ((StickerItem)localObject6).sourceType = VideoMaterialUtil.getItemSourceType(GsonUtils.optInt((JsonObject)localObject5, "videoAlphaType"));
            label668:
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
              break label2055;
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
            bool = true;
            label788:
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
            ((StickerItem)localObject6).isCanDiyPitcureVideo = GsonUtils.optInt((JsonObject)localObject5, "isCanDiyPitcureVideo");
            if (((StickerItem)localObject6).isCanDiyPitcureVideo == 1)
            {
              j = GsonUtils.optInt((JsonObject)localObject5, "width", 720);
              k = GsonUtils.optInt((JsonObject)localObject5, "height", 960);
              localObject1 = new VideoMaterial.DIYMaterialParams();
              ((VideoMaterial.DIYMaterialParams)localObject1).diyItemid = ((StickerItem)localObject6).id;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyImageWidth = j;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyImageHeight = k;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyFrameDuration = ((StickerItem)localObject6).frameDuration;
              ((VideoMaterial.DIYMaterialParams)localObject1).diyVideoDuration = (((VideoMaterial.DIYMaterialParams)localObject1).diyFrameDuration * ((StickerItem)localObject6).frames);
              ((VideoMaterial.DIYMaterialParams)localObject1).diyType = GsonUtils.optInt((JsonObject)localObject5, "diyType", 3);
              ((VideoMaterial.DIYMaterialParams)localObject1).diyFilePath = GsonUtils.optString((JsonObject)localObject5, "diyFilePath", "");
              ((VideoMaterial.DIYMaterialParams)localObject1).diyIsVideoFile = bool;
              paramVideoMaterial.addDiyItemList((VideoMaterial.DIYMaterialParams)localObject1);
              paramVideoMaterial.addMaterialType(MaterialType.MATERIAL_REPLACE);
            }
            if (!bool) {
              break label2133;
            }
            ((StickerItem)localObject6).sourceType = VideoMaterialUtil.getItemSourceType(GsonUtils.optInt((JsonObject)localObject5, "videoAlphaType"));
            label1169:
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
          label1736:
          Object localObject10;
          Object localObject11;
          Object localObject12;
          if (localObject2 != null)
          {
            localObject5 = new ShakaEffectItem();
            ((ShakaEffectItem)localObject5).setFilterType(GsonUtils.optInt((JsonObject)localObject2, "filterType"));
            if (((ShakaEffectItem)localObject5).getFilterType() == ShakaFilterFactory.FILTER_TYPE.CUSTOM.value) {
              paramVideoMaterial.addMaterialType(MaterialType.CUSTOM_SHADER);
            }
            if (((ShakaEffectItem)localObject5).getFilterType() != ShakaFilterFactory.FILTER_TYPE.CUSTOM.value) {
              break label2295;
            }
            localObject6 = GsonUtils.optString((JsonObject)localObject2, "customEffectVertexShader");
            localObject7 = GsonUtils.optString((JsonObject)localObject2, "customEffectFragmentShader");
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((ShakaEffectItem)localObject5).setCustomEffectVertexShader(FileUtils.genSeperateFileDir(paramString) + GsonUtils.optString((JsonObject)localObject2, "customEffectVertexShader"));
            }
            if (!TextUtils.isEmpty((CharSequence)localObject7)) {
              ((ShakaEffectItem)localObject5).setCustomEffectFragmentShader(FileUtils.genSeperateFileDir(paramString) + GsonUtils.optString((JsonObject)localObject2, "customEffectFragmentShader"));
            }
            localObject6 = new ArrayList();
            localObject7 = new HashMap();
            localObject8 = GsonUtils.optJsonArray((JsonObject)localObject2, "uniformList");
            if ((localObject8 != null) && (((JsonArray)localObject8).size() > 0))
            {
              j = 0;
              if (j < ((JsonArray)localObject8).size())
              {
                try
                {
                  String str1 = ((JsonArray)localObject8).get(j).getAsString();
                  ((List)localObject6).add(str1);
                  localObject10 = GsonUtils.optJsonObject((JsonObject)localObject2, str1);
                  LogUtils.d(TAG, "key = " + str1 + ", valueJson = " + localObject10);
                  if (localObject10 != null)
                  {
                    localObject11 = new ArrayList();
                    localObject12 = ((JsonObject)localObject10).keySet().iterator();
                    while (((Iterator)localObject12).hasNext())
                    {
                      String str2 = (String)((Iterator)localObject12).next();
                      LogUtils.d(TAG, "valueKey = " + str2);
                      ((List)localObject11).add(Pair.create(Float.valueOf(str2), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject10, str2, 0.0D))));
                    }
                  }
                  j += 1;
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
                for (;;)
                {
                  break label1736;
                  label1936:
                  localObject1 = localObject2;
                  if (((String)localObject2).endsWith("_")) {
                    localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                  }
                  j = ((String)localObject1).lastIndexOf("/");
                  ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                  if (j >= 0) {
                    ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
                  }
                  bool = false;
                  break;
                  label2019:
                  if (((StickerItem)localObject6).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type)
                  {
                    ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG;
                    break label668;
                  }
                  ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                  break label668;
                  label2055:
                  localObject1 = localObject2;
                  if (((String)localObject2).endsWith("_")) {
                    localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                  }
                  j = ((String)localObject1).lastIndexOf("/");
                  ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                  ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
                  bool = false;
                  break label788;
                  label2133:
                  if (((StickerItem)localObject6).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type)
                  {
                    ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG;
                    break label1169;
                  }
                  ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                  break label1169;
                  Collections.sort((List)localObject11, mRangeValueComp);
                  ((Map)localObject7).put(localException, localObject11);
                }
              }
            }
            ((ShakaEffectItem)localObject5).setCustomParams((Map)localObject7);
            ((ShakaEffectItem)localObject5).setUniformList((List)localObject6);
          }
          label2295:
          Object localObject9;
          for (;;)
          {
            localFabbyMvPart.setShakaEffectItem((ShakaEffectItem)localObject5);
            localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "scale");
            if (localObject2 == null) {
              break;
            }
            localObject5 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              localFabbyMvPart.scaleMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject2, (String)localObject6, 1.0D))));
            }
            localObject6 = new HashMap();
            localObject7 = ((JsonObject)localObject2).keySet().iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localObject8 = (String)((Iterator)localObject7).next();
              localObject9 = GsonUtils.optJsonObject((JsonObject)localObject2, (String)localObject8);
              LogUtils.d(TAG, "key = " + (String)localObject8 + ", valueJson = " + localObject9);
              if (localObject9 != null)
              {
                localObject10 = new ArrayList();
                localObject11 = ((JsonObject)localObject9).keySet().iterator();
                while (((Iterator)localObject11).hasNext())
                {
                  localObject12 = (String)((Iterator)localObject11).next();
                  LogUtils.d(TAG, "valueKey = " + (String)localObject12);
                  ((List)localObject10).add(Pair.create(Float.valueOf((String)localObject12), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject9, (String)localObject12, 0.0D))));
                }
                Collections.sort((List)localObject10, mRangeValueComp);
                ((Map)localObject6).put(localObject8, localObject10);
              }
            }
            ((ShakaEffectItem)localObject5).setValueMap((Map)localObject6);
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
        if (localObject5 != null)
        {
          localObject6 = new StickerItem();
          localObject1 = GsonUtils.optString((JsonObject)localObject5, "maskVideoFile");
          localObject2 = GsonUtils.optString((JsonObject)localObject5, "maskImageName");
          j = GsonUtils.optInt((JsonObject)localObject5, "transitionFunction", 0);
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label4971;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label4896;
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
            break label5001;
          }
          localFabbyMvPart.filterType = GsonUtils.optInt((JsonObject)localObject1, "type", 0);
          localFabbyMvPart.filterId = GsonUtils.optString((JsonObject)localObject1, "filter");
          localFabbyMvPart.lutFile = GsonUtils.optString((JsonObject)localObject1, "lutFile");
          localFabbyMvPart.filterAlpha = ((float)GsonUtils.optDouble((JsonObject)localObject1, "alpha", 1.0D));
          localFabbyMvPart.filterParamMap.clear();
          localObject1 = GsonUtils.optJsonObject((JsonObject)localObject1, "param");
          if (localObject1 == null) {
            break label5001;
          }
          localObject2 = ((JsonObject)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (String)((Iterator)localObject2).next();
            localFabbyMvPart.filterParamMap.add(Pair.create(Float.valueOf((String)localObject5), Integer.valueOf(GsonUtils.optInt((JsonObject)localObject1, (String)localObject5, 0))));
          }
          label4896:
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("_")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
          k = ((String)localObject1).lastIndexOf("/");
          ((StickerItem)localObject6).id = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
          ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, k);
          continue;
          label4971:
          ((StickerItem)localObject6).id = "";
          ((StickerItem)localObject6).subFolder = "";
        }
        Collections.sort(localFabbyMvPart.filterParamMap, mDivideValueComp);
        label5001:
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
            break label5414;
          }
        }
        label5414:
        for (bool = true;; bool = false)
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
  
  private static void parseFaceBeautyItemListParams(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial)
  {
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.FACE_BEAUTY_ITEM_LIST.value);
    if (paramJsonObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramJsonObject.size())
      {
        JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localJsonObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          FaceBeautyItem localFaceBeautyItem = new FaceBeautyItem();
          localFaceBeautyItem.id = GsonUtils.optString(localJsonObject, VideoMaterialUtil.FACE_MESH_ITEM_LIST.ID.value);
          localFaceBeautyItem.personID = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MESH_ITEM_LIST.PERSON_ID.value, -1);
          localFaceBeautyItem.genderType = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MESH_ITEM_LIST.GENDER_TYPE.value, 0);
          if (localFaceBeautyItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localFaceBeautyItem.frames = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.FACE_MESH_ITEM_LIST.FRAMES.value);
          Object localObject = GsonUtils.optJsonObject(localJsonObject, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject != null)
          {
            localFaceBeautyItem.charmRange = new CharmRange();
            localFaceBeautyItem.charmRange.min = GsonUtils.optDouble((JsonObject)localObject, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localFaceBeautyItem.charmRange.max = GsonUtils.optDouble((JsonObject)localObject, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localFaceBeautyItem.frameType = GsonUtils.optInt(localJsonObject, "frameType");
          localFaceBeautyItem.frameDuration = GsonUtils.optDouble(localJsonObject, "frameDuration");
          localFaceBeautyItem.setTriggerType(String.valueOf(Math.max(GsonUtils.optInt(localJsonObject, "triggerType"), 2)));
          if (VideoMaterialUtil.isActionTriggerType(localFaceBeautyItem.getTriggerTypeInt())) {
            paramVideoMaterial.setTriggerType(localFaceBeautyItem.getTriggerTypeInt());
          }
          if (GsonUtils.optInt(localJsonObject, "alwaysTriggered") == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localFaceBeautyItem.alwaysTriggered = bool;
            localFaceBeautyItem.externalTriggerWords = GsonUtils.optString(localJsonObject, "externalTriggerWords");
            localFaceBeautyItem.featureStatType = GsonUtils.optInt(localJsonObject, "featureStatType");
            localObject = GsonUtils.optJsonObject(localJsonObject, "featureStatValueRange");
            if (localObject != null)
            {
              localFaceBeautyItem.featureStatValueRange = new StickerItem.ValueRange();
              localFaceBeautyItem.featureStatValueRange.min = GsonUtils.optDouble((JsonObject)localObject, "min");
              localFaceBeautyItem.featureStatValueRange.max = GsonUtils.optDouble((JsonObject)localObject, "max");
            }
            localFaceBeautyItem.triggerState = new ArrayList();
            localObject = GsonUtils.optJsonArray(localJsonObject, "triggerStateList");
            if ((localObject == null) || (((JsonArray)localObject).size() <= 0)) {
              break;
            }
            int j = 0;
            while (j < ((JsonArray)localObject).size())
            {
              localFaceBeautyItem.triggerState.add(GsonUtils.getStringUnsafe((JsonArray)localObject, j));
              j += 1;
            }
          }
          localObject = GsonUtils.optString(localJsonObject, "triggerState");
          if ((localObject != null) && (!"".equals(localObject))) {
            localFaceBeautyItem.triggerState.add(localObject);
          }
          localJsonObject = GsonUtils.optJsonObject(localJsonObject, "beautyIds");
          if (localJsonObject != null)
          {
            localObject = localJsonObject.keySet().iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              LogUtils.d(TAG, "valueKey = " + str);
              localFaceBeautyItem.putBeautyValues(str, GsonUtils.optString(localJsonObject, str));
            }
          }
          localArrayList.add(localFaceBeautyItem);
        }
      }
      paramVideoMaterial.setFaceBeautyItemList(localArrayList);
    }
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
        Collections.sort(paramString, new VideoTemplateParser.9());
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
    paramVideoMaterial.addMaterialType(MaterialType.KOUWUGUAN);
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
      if (i < paramJsonObject.size())
      {
        Object localObject1 = GsonUtils.optJsonObject(paramJsonObject, i);
        if (localObject1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          FaceMeshItem localFaceMeshItem = new FaceMeshItem();
          localFaceMeshItem.id = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.ID.value);
          localFaceMeshItem.personID = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.PERSON_ID.value, -1);
          localFaceMeshItem.genderType = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.GENDER_TYPE.value, 0);
          if (localFaceMeshItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localFaceMeshItem.frames = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_MESH_ITEM_LIST.FRAMES.value);
          Object localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject2 != null)
          {
            localFaceMeshItem.charmRange = new CharmRange();
            localFaceMeshItem.charmRange.min = GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localFaceMeshItem.charmRange.max = GsonUtils.optDouble((JsonObject)localObject2, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localFaceMeshItem.frameType = GsonUtils.optInt((JsonObject)localObject1, "frameType");
          localFaceMeshItem.frameDuration = GsonUtils.optDouble((JsonObject)localObject1, "frameDuration");
          localFaceMeshItem.setTriggerType(String.valueOf(Math.max(GsonUtils.optInt((JsonObject)localObject1, "triggerType"), 2)));
          if (VideoMaterialUtil.isActionTriggerType(localFaceMeshItem.getTriggerTypeInt())) {
            paramVideoMaterial.setTriggerType(localFaceMeshItem.getTriggerTypeInt());
          }
          if (GsonUtils.optInt((JsonObject)localObject1, "alwaysTriggered") == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localFaceMeshItem.alwaysTriggered = bool;
            localFaceMeshItem.externalTriggerWords = GsonUtils.optString((JsonObject)localObject1, "externalTriggerWords");
            localFaceMeshItem.featureStatType = GsonUtils.optInt((JsonObject)localObject1, "featureStatType");
            localObject2 = GsonUtils.optJsonObject((JsonObject)localObject1, "featureStatValueRange");
            if (localObject2 != null)
            {
              localFaceMeshItem.featureStatValueRange = new StickerItem.ValueRange();
              localFaceMeshItem.featureStatValueRange.min = GsonUtils.optDouble((JsonObject)localObject2, "min");
              localFaceMeshItem.featureStatValueRange.max = GsonUtils.optDouble((JsonObject)localObject2, "max");
            }
            localFaceMeshItem.triggerState = new ArrayList();
            localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, "triggerStateList");
            if ((localObject2 == null) || (((JsonArray)localObject2).size() <= 0)) {
              break;
            }
            int j = 0;
            while (j < ((JsonArray)localObject2).size())
            {
              localFaceMeshItem.triggerState.add(GsonUtils.getStringUnsafe((JsonArray)localObject2, j));
              j += 1;
            }
          }
          localObject1 = GsonUtils.optString((JsonObject)localObject1, "triggerState");
          if ((localObject1 != null) && (!"".equals(localObject1))) {
            localFaceMeshItem.triggerState.add(localObject1);
          }
          localArrayList.add(localFaceMeshItem);
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
              break label376;
            }
          }
          int n;
          label376:
          for (boolean bool = true;; bool = false)
          {
            localFaceItem.disable3DCorrect = bool;
            localFaceItem.triggerState = new ArrayList();
            localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, "triggerStateList");
            if ((localObject2 == null) || (((JsonArray)localObject2).size() <= 0)) {
              break label382;
            }
            n = 0;
            while (n < ((JsonArray)localObject2).size())
            {
              localFaceItem.triggerState.add(GsonUtils.getStringUnsafe((JsonArray)localObject2, n));
              n += 1;
            }
            bool = false;
            break;
          }
          label382:
          Object localObject2 = GsonUtils.optString((JsonObject)localObject1, "triggerState");
          if ((localObject2 != null) && (!"".equals(localObject2))) {
            localFaceItem.triggerState.add(localObject2);
          }
          if (localFaceItem.is3DCos)
          {
            localFaceItem.grayScale = 1;
            localFaceItem.featureType = FaceOffUtil.FEATURE_TYPE.FACE_COS3D_MASK;
          }
          int i1;
          label479:
          int i2;
          if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE_FULL_FACE.value, 0) == 1)
          {
            n = 1;
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE_DISABLE_OPACITY.value, 0) != 1) {
              break label619;
            }
            i1 = 1;
            if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE_DISABLE_FACECROP.value, 0) != 1) {
              break label625;
            }
            i2 = 1;
            label498:
            if ((n == 0) && (i1 == 0) && (i2 == 0)) {
              break label631;
            }
          }
          label619:
          label625:
          label631:
          for (bool = true;; bool = false)
          {
            localFaceItem.faceExchangeImageDisableFaceCrop = bool;
            localFaceItem.lipsStyleMask = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.LIPS_STYLE_MASK.value, null);
            localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.LIPS_RGBA.value);
            if ((localObject2 == null) || (((JsonArray)localObject2).size() != 4)) {
              break label637;
            }
            localFaceItem.lipsRGBA = new float[4];
            n = 0;
            while (n < 4)
            {
              localFaceItem.lipsRGBA[n] = (GsonUtils.optInt((JsonArray)localObject2, n) / 255.0F);
              n += 1;
            }
            n = 0;
            break;
            i1 = 0;
            break label479;
            i2 = 0;
            break label498;
          }
          label637:
          localFaceItem.lipsRGBA = null;
          localObject2 = GsonUtils.optJsonArray((JsonObject)localObject1, VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_POINTS.value);
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
            label901:
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
              break label1116;
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
            break label901;
            label1116:
            j = Math.max(j, localFaceItem.getTriggerTypeInt());
          }
        }
      }
      if (i <= 0) {
        break label1207;
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
      label1207:
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
  
  private static FaceStyleItem parseFaceStyleItem(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, String paramString)
  {
    boolean bool2 = true;
    int j = 0;
    if (paramJsonObject == null) {
      return null;
    }
    FaceStyleItem localFaceStyleItem = new FaceStyleItem();
    localFaceStyleItem.dataPath = paramVideoMaterial.getDataPath();
    localFaceStyleItem.id = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.ID.value);
    localFaceStyleItem.modelName = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.MODEL_NAME.value);
    if (GsonUtils.optInt(paramJsonObject, "alwaysTriggered") == 1) {}
    int i;
    for (boolean bool1 = true;; bool1 = false)
    {
      localFaceStyleItem.alwaysTriggered = bool1;
      localFaceStyleItem.setTriggerType(GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TRIGGER_TYPE.value));
      localFaceStyleItem.styleChangeType = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.STYLE_CHANGE_TYPE.value);
      localFaceStyleItem.crazyFacePath = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.CRAY_FACE_PATH.value);
      localFaceStyleItem.externalTriggerWords = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.EXTERNAL_TRIGGER_WORDS.value);
      localFaceStyleItem.transformMask = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TRANSFORM_MASK.value);
      localFaceStyleItem.limitDeviceLevel = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.LIMIT_DEVICE_LEVEL.value);
      localFaceStyleItem.triggerState = new ArrayList();
      localObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TRIGGER_STATE_LIST.value);
      if ((localObject == null) || (((JsonArray)localObject).size() <= 0)) {
        break;
      }
      i = 0;
      while (i < ((JsonArray)localObject).size())
      {
        localFaceStyleItem.triggerState.add(GsonUtils.getStringUnsafe((JsonArray)localObject, i));
        i += 1;
      }
    }
    Object localObject = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TRIGGER_STATE.value);
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      localFaceStyleItem.triggerState.add(localObject);
    }
    localFaceStyleItem.playCount = GsonUtils.optInt(paramJsonObject, "playCount");
    localFaceStyleItem.initProcess = parseFaceStyleItemProcess(paramJsonObject, localFaceStyleItem, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.INIT_PROCESS.value);
    localFaceStyleItem.preProcess = parseFaceStyleItemProcess(paramJsonObject, localFaceStyleItem, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.PRE_PROCESS.value);
    localFaceStyleItem.postProcess = parseFaceStyleItemProcess(paramJsonObject, localFaceStyleItem, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.POST_PROCESS.value);
    localFaceStyleItem.postRender = parseFaceStyleItemRender(paramJsonObject, localFaceStyleItem, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.POST_RENDER.value);
    localFaceStyleItem.cartoonFaceLine = parseFaceStyleItemCartoonFaceLine(paramJsonObject, localFaceStyleItem, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.CARTOON_FACE_LINE.value);
    localFaceStyleItem.lutPaths = parseFaceStyleItemPaths(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.BACKGROUND_LUT_PATHS.value, paramString);
    localFaceStyleItem.materialPaths = parseFaceStyleItemPaths(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.BACKGROUND_MATERIAL_PATHS.value, paramString);
    localFaceStyleItem.faceFilterType = GsonUtils.optInt(paramJsonObject, "faceFilterType", 0);
    String str = GsonUtils.optString(paramJsonObject, "cartoonLut");
    localObject = str;
    if (!TextUtils.isEmpty(str)) {
      localObject = FileUtils.genSeperateFileDir(paramString) + str;
    }
    localFaceStyleItem.cartoonLut = ((String)localObject);
    str = GsonUtils.optString(paramJsonObject, "cartoonEnlightLut");
    localObject = str;
    if (!TextUtils.isEmpty(str)) {
      localObject = FileUtils.genSeperateFileDir(paramString) + str;
    }
    localFaceStyleItem.cartoonEnlightLut = ((String)localObject);
    localFaceStyleItem.horizontalMinRadius = GsonUtils.optInt(paramJsonObject, "horizontalMinRadius");
    localFaceStyleItem.verticalMinRadius = GsonUtils.optInt(paramJsonObject, "verticalMinRadius");
    localFaceStyleItem.horizontalFaceRadiusPercent = GsonUtils.optFloat(paramJsonObject, "horizontalFaceRadiusPercent");
    localFaceStyleItem.verticalFaceRadiusPercent = GsonUtils.optFloat(paramJsonObject, "verticalFaceRadiusPercent");
    paramString = GsonUtils.optJsonArray(paramJsonObject, "featureMaskSize");
    if (paramString != null)
    {
      localFaceStyleItem.featureMaskSize = new int[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        localFaceStyleItem.featureMaskSize[i] = GsonUtils.getIntUnsafe(paramString, i);
        i += 1;
      }
    }
    localFaceStyleItem.stickerItemList = parseItemListParams(null, GsonUtils.optJsonArray(paramJsonObject, "textureMaterialsElements"), VideoFilterFactory.STICKER_TYPE.NORMAL.type, paramVideoMaterial, paramVideoMaterial.getBlendMode(), null, null, null);
    paramString = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.IMAGE_SIZE.value);
    if (paramString != null)
    {
      i = 0;
      while (i < paramString.size())
      {
        localFaceStyleItem.imageSize[i] = GsonUtils.optInt(paramString, i);
        i += 1;
      }
    }
    paramString = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.MODEL_CONFIG.value);
    if (paramString != null)
    {
      localFaceStyleItem.modelConfig = ((FaceStyleItem.ModelConfig)GsonUtils.json2Obj(paramString.toString(), FaceStyleItem.ModelConfig.class));
      localFaceStyleItem.getClass();
      paramString = new FaceStyleItem.ModelConfigItem(localFaceStyleItem);
      switch (OfflineConfig.getPhonePerfLevel())
      {
      }
    }
    for (;;)
    {
      localFaceStyleItem.modelName = paramString.modelName;
      localFaceStyleItem.imageSize = paramString.imageSize;
      if (paramString.initprocess == null)
      {
        localFaceStyleItem.getClass();
        paramString.initprocess = new FaceStyleItem.Process(localFaceStyleItem);
      }
      localFaceStyleItem.initProcess = paramString.initprocess;
      if (paramString.preprocess == null)
      {
        localFaceStyleItem.getClass();
        paramString.preprocess = new FaceStyleItem.Process(localFaceStyleItem);
      }
      localFaceStyleItem.preProcess = paramString.preprocess;
      if (paramString.postprocess == null)
      {
        localFaceStyleItem.getClass();
        paramString.postprocess = new FaceStyleItem.Process(localFaceStyleItem);
      }
      localFaceStyleItem.postProcess = paramString.postprocess;
      if (paramString.postRender == null)
      {
        localFaceStyleItem.getClass();
        paramString.postRender = new FaceStyleItem.Render(localFaceStyleItem);
      }
      localFaceStyleItem.postRender = paramString.postRender;
      localFaceStyleItem.faceCropType = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.FACE_CROP_TYPE.value);
      localFaceStyleItem.cropBorderColorRGBA = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.CROP_BORDER_COLOR_RGBA.value);
      localFaceStyleItem.faceExpandFactor = GsonUtils.optFloat(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.FACE_EXPAND_FACTOR.value, 0.0F);
      paramString = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.FACE_CROP_EXPAND_INSET.value);
      if (paramString == null) {
        break;
      }
      i = 0;
      while (i < paramString.size())
      {
        localFaceStyleItem.faceCropExpandInset[i] = GsonUtils.getFloatSafe(paramString, i);
        i += 1;
      }
      paramString = localFaceStyleItem.modelConfig.vlow;
      continue;
      paramString = localFaceStyleItem.modelConfig.low;
      continue;
      paramString = localFaceStyleItem.modelConfig.middle;
      continue;
      paramString = localFaceStyleItem.modelConfig.mhigh;
      continue;
      paramString = localFaceStyleItem.modelConfig.high;
    }
    localFaceStyleItem.libraryPath = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.LIBRARY_PATH.value);
    if (!TextUtils.isEmpty(localFaceStyleItem.libraryPath))
    {
      paramString = FileUtils.genSeperateFileDir(localFaceStyleItem.dataPath) + localFaceStyleItem.libraryPath;
      if (FileUtils.isFileExist(paramString)) {
        localFaceStyleItem.libraryText = FileUtils.load(AEModule.getContext(), paramString);
      }
    }
    else
    {
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.RETURN_POST_PROCESS_TEXTURE.value) != 1) {
        break label1310;
      }
    }
    label1310:
    for (bool1 = bool2;; bool1 = false)
    {
      localFaceStyleItem.returnPostProcessTexture = bool1;
      localFaceStyleItem.textureMaterials = new ArrayList();
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FACE_STYLE_ITEM_FIELD.TEXTURE_MATERIALS.value);
      if (paramJsonObject == null) {
        break label1316;
      }
      i = j;
      while (i < paramJsonObject.size())
      {
        localFaceStyleItem.textureMaterials.add(GsonUtils.getStringUnsafe(paramJsonObject, i));
        i += 1;
      }
      paramString = "assets://" + FileUtils.genSeperateFileDir("faceStyleKernel") + localFaceStyleItem.libraryPath;
      localFaceStyleItem.libraryText = FileUtils.load(AEModule.getContext(), paramString);
      break;
    }
    label1316:
    if (!TextUtils.isEmpty(localFaceStyleItem.modelName))
    {
      if (localFaceStyleItem.styleChangeType != FaceStyleItem.STYLE_CHANGE_TYPE.FACE_CHANGE.value) {
        break label1351;
      }
      paramVideoMaterial.addMaterialType(MaterialType.STYLE_BEAUTY);
    }
    for (;;)
    {
      return localFaceStyleItem;
      label1351:
      if (localFaceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.CHILD_STYLE.value) {
        paramVideoMaterial.addMaterialType(MaterialType.STYLE_CHILD);
      } else if (localFaceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.CARTOON_STYLE.value) {
        paramVideoMaterial.addMaterialType(MaterialType.STYLE_CARTOON);
      }
    }
  }
  
  private static FaceStyleItem.CartoonFaceLine parseFaceStyleItemCartoonFaceLine(JsonObject paramJsonObject, FaceStyleItem paramFaceStyleItem, String paramString)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, paramString);
    if (paramJsonObject != null) {
      return (FaceStyleItem.CartoonFaceLine)GsonUtils.json2Obj(paramJsonObject.toString(), FaceStyleItem.CartoonFaceLine.class);
    }
    return null;
  }
  
  private static HashMap<String, String> parseFaceStyleItemPaths(JsonObject paramJsonObject, String paramString1, String paramString2)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, paramString1);
    paramString1 = new HashMap();
    if (paramJsonObject != null)
    {
      Iterator localIterator = paramJsonObject.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJsonObject.get(str1).toString();
        int i = str2.length();
        paramString1.put(str1, paramString2 + File.separator + str2.substring(1, i - 1));
      }
    }
    return paramString1;
  }
  
  private static FaceStyleItem.Process parseFaceStyleItemProcess(JsonObject paramJsonObject, FaceStyleItem paramFaceStyleItem, String paramString)
  {
    int j = 0;
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, paramString);
    paramFaceStyleItem.getClass();
    paramFaceStyleItem = new FaceStyleItem.Process(paramFaceStyleItem);
    if (paramJsonObject != null)
    {
      paramFaceStyleItem.function = GsonUtils.optString(paramJsonObject, "function");
      paramFaceStyleItem.blobNames = new ArrayList();
      paramString = GsonUtils.optJsonArray(paramJsonObject, "blobNames");
      int i;
      if (paramString != null)
      {
        i = 0;
        while (i < paramString.size())
        {
          paramFaceStyleItem.blobNames.add(GsonUtils.optString(paramString, i));
          i += 1;
        }
      }
      GsonUtils.optString(paramJsonObject, "blobNames");
      paramString = GsonUtils.optJsonArray(paramJsonObject, "scale");
      if (paramString != null)
      {
        paramFaceStyleItem.scale = new float[paramString.size()];
        i = 0;
        while (i < paramString.size())
        {
          paramFaceStyleItem.scale[i] = GsonUtils.getFloatSafe(paramString, i);
          i += 1;
        }
      }
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "bias");
      if (paramJsonObject != null)
      {
        paramFaceStyleItem.bias = new float[paramJsonObject.size()];
        i = j;
        while (i < paramJsonObject.size())
        {
          paramFaceStyleItem.bias[i] = GsonUtils.getFloatSafe(paramJsonObject, i);
          i += 1;
        }
      }
    }
    return paramFaceStyleItem;
  }
  
  private static FaceStyleItem.Render parseFaceStyleItemRender(JsonObject paramJsonObject, FaceStyleItem paramFaceStyleItem, String paramString)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, paramString);
    if (paramJsonObject != null) {
      return (FaceStyleItem.Render)GsonUtils.json2Obj(paramJsonObject.toString(), FaceStyleItem.Render.class);
    }
    return null;
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
      int j = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.FILTER_EFFECT_FIELD.ORDER.value);
      int i;
      if (j != 1)
      {
        i = j;
        if (j != 2) {}
      }
      else
      {
        i = j + 99;
      }
      localVideoFilterEffect.order = i;
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
  
  private static List<FilterConfigBean.FilterParam> parseFiltersConfig(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if ((paramVideoMaterial == null) || (paramJsonObject == null)) {}
    do
    {
      do
      {
        return null;
        paramJsonObject = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.FILTER_CONFIG_FILE.value, null);
      } while (paramJsonObject == null);
      paramVideoMaterial = FileOfflineUtil.readJsonStringFromFile(paramVideoMaterial.getDataPath() + File.separator + paramJsonObject);
    } while (paramVideoMaterial == null);
    paramVideoMaterial = (FilterConfigBean)GsonUtils.json2Obj(paramVideoMaterial, new VideoTemplateParser.2().getType());
    if ((paramVideoMaterial != null) && (paramVideoMaterial.filterConfigList != null)) {}
    for (paramVideoMaterial = paramVideoMaterial.filterConfigList;; paramVideoMaterial = null) {
      return paramVideoMaterial;
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
      paramVideoMaterial = (FramePositionsBean)GsonUtils.json2Obj(paramVideoMaterial, new VideoTemplateParser.14().getType());
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
    Object localObject1;
    int i;
    int j;
    int k;
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0)
    {
      bool = true;
      paramVideoMaterial.setFlattenEar(bool);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
        break label431;
      }
      bool = true;
      paramVideoMaterial.setFlattenNose(bool);
      if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GLB_FIELD.HIDE_USER_HEAD_MODEL.value, 0) != 1) {
        break label437;
      }
      bool = true;
      paramVideoMaterial.setHideUserHeadModel(bool);
      paramVideoMaterial.setTransformAdjustAlpha((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.GLB_FIELD.TRANSFORM_ADJUST_ALPHA.value, 1.0D));
      paramVideoMaterial.setFov((float)GsonUtils.optDouble(paramJsonObject, VideoMaterialUtil.GLB_FIELD.FOV.value, 60.0D));
      localObject1 = new ArrayList();
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.GLB_LIST.value);
      i = 0;
      j = 0;
      if (paramJsonObject == null) {
        break label999;
      }
      k = 0;
      i = j;
      j = k;
    }
    for (;;)
    {
      if (j >= paramJsonObject.size()) {
        break label992;
      }
      JsonObject localJsonObject = GsonUtils.optJsonObject(paramJsonObject, j);
      if (localJsonObject != null)
      {
        GLBItemJava localGLBItemJava = new GLBItemJava();
        localGLBItemJava.folder = paramString;
        Object localObject2 = GsonUtils.optString(localJsonObject, VideoMaterialUtil.GLB_FIELD.PATH.value, "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localGLBItemJava.path = getFullPath(paramString, (String)localObject2);
        }
        localObject2 = GsonUtils.optString(localJsonObject, VideoMaterialUtil.GLB_FIELD.IBLPATH.value, "");
        localGLBItemJava.blendShapeAdjustAlpha = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.GLB_FIELD.BLEND_ALPHA.value, 0.7D));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localGLBItemJava.iblPath = getFullPath(paramString, (String)localObject2);
        }
        localGLBItemJava.faceMeshTextureKey = GsonUtils.optString(localJsonObject, "faceMeshTextureKey");
        localGLBItemJava.iblIntensity = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.IBL_INTENSITY.value, 110000);
        localGLBItemJava.order = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.ORDER.value, 0);
        localGLBItemJava.iblRotation = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.IBL_ROTATION.value, 0);
        localGLBItemJava.enableSSAO = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.ENABLE_SSAO.value, 0);
        localGLBItemJava.positionType = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.GLB_FIELD.POSITION_TYPE.value, 0);
        localObject2 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.TRANSLATE.value);
        if (localObject2 != null)
        {
          i = 0;
          for (;;)
          {
            if ((i < ((JsonArray)localObject2).size()) && (i < 3))
            {
              localGLBItemJava.translate[i] = ((float)GsonUtils.optDouble((JsonArray)localObject2, i));
              i += 1;
              continue;
              bool = false;
              break;
              label431:
              bool = false;
              break label40;
              label437:
              bool = false;
              break label64;
            }
          }
        }
        localObject2 = GsonUtils.optJsonArray(localJsonObject, "scaleRange");
        if (localObject2 != null)
        {
          i = 0;
          while ((i < ((JsonArray)localObject2).size()) && (i < 2))
          {
            localGLBItemJava.scaleRange[i] = ((float)GsonUtils.optDouble((JsonArray)localObject2, i));
            i += 1;
          }
        }
        localObject2 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.SCALE.value);
        if (localObject2 != null)
        {
          i = 0;
          while ((i < ((JsonArray)localObject2).size()) && (i < 3))
          {
            localGLBItemJava.scale[i] = ((float)GsonUtils.optDouble((JsonArray)localObject2, i));
            i += 1;
          }
        }
        localObject2 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.ROTATE.value);
        if (localObject2 != null)
        {
          i = 0;
          while ((i < ((JsonArray)localObject2).size()) && (i < 3))
          {
            localGLBItemJava.rotate[i] = ((float)GsonUtils.optDouble((JsonArray)localObject2, i));
            i += 1;
          }
        }
        localObject2 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.ROTATE_TYPE.value);
        if (localObject2 != null)
        {
          i = 0;
          while ((i < ((JsonArray)localObject2).size()) && (i < 3))
          {
            localGLBItemJava.rotateType[i] = GsonUtils.optInt((JsonArray)localObject2, i, 1);
            i += 1;
          }
        }
        localObject2 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.FLIP.value);
        if (localObject2 != null)
        {
          i = 0;
          while ((i < ((JsonArray)localObject2).size()) && (i < 3))
          {
            localGLBItemJava.flip[i] = GsonUtils.optInt((JsonArray)localObject2, i);
            i += 1;
          }
        }
        localObject2 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.EYE_NODE_LIST.value);
        if (localObject2 != null)
        {
          i = 0;
          while (i < ((JsonArray)localObject2).size())
          {
            localObject3 = new EyeNodeItem();
            Object localObject4 = GsonUtils.optJsonObject((JsonArray)localObject2, i);
            ((EyeNodeItem)localObject3).name = GsonUtils.optString((JsonObject)localObject4, VideoMaterialUtil.GLB_FIELD.NAME.value, "");
            localObject4 = GsonUtils.optJsonArray((JsonObject)localObject4, VideoMaterialUtil.GLB_FIELD.EULER_ANGLES.value);
            if (localObject4 != null)
            {
              k = 0;
              while ((k < ((JsonArray)localObject2).size()) && (k < 3))
              {
                ((EyeNodeItem)localObject3).eulerAngles[i] = ((float)GsonUtils.optDouble((JsonArray)localObject4, k, 0.0D));
                k += 1;
              }
            }
            localGLBItemJava.eyeNodeList.add(localObject3);
            i += 1;
          }
        }
        localObject2 = parseNodeItems(localJsonObject);
        Object localObject3 = parseDynamicBoneItems(localJsonObject);
        localGLBItemJava.lightItem = parseLightItem(localJsonObject);
        localGLBItemJava.nodeList = ((List)localObject2);
        localGLBItemJava.dynamicBoneItems = ((List)localObject3);
        localGLBItemJava.bloom = parseBloomParam(localJsonObject);
        localGLBItemJava.charmRange = parseCharmRange(localJsonObject);
        localGLBItemJava.triggerConfig = parseTriggerConfig(localJsonObject);
        localGLBItemJava.triggerCtrlItem = new TriggerCtrlItem(localGLBItemJava);
        localGLBItemJava.customMaterialItems = parseCustomMaterials(localJsonObject);
        localGLBItemJava.animationList = parseAnimationItems(paramVideoMaterial, localJsonObject);
        i = localGLBItemJava.triggerConfig.getTriggerTypeInt();
        ((List)localObject1).add(localGLBItemJava);
      }
      j += 1;
    }
    label992:
    paramVideoMaterial.addMaterialType(MaterialType.THREE_DIM_IBL);
    label999:
    paramString = new ArrayList();
    paramJsonObject = ((List)localObject1).iterator();
    label1102:
    while (paramJsonObject.hasNext())
    {
      localObject1 = (GLBItemJava)paramJsonObject.next();
      if (((GLBItemJava)localObject1).triggerConfig.activateTriggerType == 0) {}
      for (((GLBItemJava)localObject1).triggerConfig.countTriggerType = i;; ((GLBItemJava)localObject1).triggerConfig.countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value)
      {
        if (TextUtils.isEmpty(((GLBItemJava)localObject1).path)) {
          break label1102;
        }
        paramString.add(localObject1);
        break;
        ((GLBItemJava)localObject1).triggerConfig.playCount = 0;
      }
    }
    paramVideoMaterial.setGlbList(paramString);
  }
  
  public static GPUParticleConfig parseGpuParticleConfig(JsonObject paramJsonObject, String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    String str = readMaterialFile(paramString1, paramString2, true, paramDecryptListener);
    LogUtils.i(TAG, "[parseVideoMaterialFileAsJSONObject] dataStr = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        paramString2 = GsonUtils.json2JsonObject(str);
        if (paramString2 == null) {
          break;
        }
        GPUParticleConfig localGPUParticleConfig = new GPUParticleConfig();
        localGPUParticleConfig.jsonBytes = str.getBytes();
        localGPUParticleConfig.startColorReference = GsonUtils.optString(paramString2, "startColorReference");
        localGPUParticleConfig.backgroundConfig = parsegpuParticleBackgroundConfig(paramString1, GsonUtils.optString(paramJsonObject, "gpuParticleBackgroundConfig"), paramDecryptListener);
        localGPUParticleConfig.sourcePositionPath = parsegpuParticleSourcePositionPath(paramString1, GsonUtils.optString(paramJsonObject, "gpuParticleSourcePositionPath"), paramDecryptListener);
        localGPUParticleConfig.emitterType = GsonUtils.optInt(paramString2, "emitterType", 0);
        localGPUParticleConfig.sprites = parseGpuSpriteList(paramString2);
        localGPUParticleConfig.svg = GsonUtils.optString(paramString2, "particlePath", "");
        return localGPUParticleConfig;
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
      paramString2 = null;
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
            break label796;
          }
          Object localObject2 = GsonUtils.getJsonObjectUnsafe((JsonArray)localObject1, m);
          StickerItem localStickerItem = new StickerItem();
          localStickerItem.id = GsonUtils.optString((JsonObject)localObject2, "id");
          localStickerItem.subFolder = localStickerItem.id;
          localStickerItem.type = GsonUtils.optInt((JsonObject)localObject2, "type");
          localStickerItem.setTriggerType(GsonUtils.optString((JsonObject)localObject2, "triggerType"));
          if ((localStickerItem.type == VideoFilterFactory.POSITION_TYPE.CAT.type) || (localStickerItem.getTriggerTypeInt() == 700)) {
            paramVideoMaterial.addMaterialType(MaterialType.CAT_DETECT);
          }
          if (localStickerItem.getTriggerTypeInt() == 700) {
            paramVideoMaterial.addMaterialType(MaterialType.CAT_DETECT);
          }
          if (GsonUtils.optInt((JsonObject)localObject2, "alwaysTriggered") != 1) {
            break label767;
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
              break label773;
            }
            j = localStickerItem.getTriggerTypeInt();
            break label773;
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
      label767:
      boolean bool = false;
      continue;
      label773:
      int n = m + 1;
      int m = k;
      int k = i;
      int i = m;
      m = n;
      continue;
      label796:
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
    int k;
    ArrayList localArrayList1;
    int j;
    JsonObject localJsonObject;
    StickerItem localStickerItem;
    String str;
    boolean bool;
    label930:
    int m;
    Object localObject2;
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
          k = 0;
          localArrayList1 = null;
          localObject1 = "";
          j = 0;
          if (k >= paramJsonArray.size()) {
            break label4936;
          }
          localJsonObject = GsonUtils.getJsonObjectUnsafe(paramJsonArray, k);
          localStickerItem = new StickerItem();
          localStickerItem.id = GsonUtils.optString(localJsonObject, "id");
          localStickerItem.subFolder = localStickerItem.id;
          localStickerItem.name = GsonUtils.optString(localJsonObject, "name");
          localStickerItem.type = GsonUtils.optInt(localJsonObject, "type");
          localStickerItem.scale = ((float)GsonUtils.optDouble(localJsonObject, "scale", 1.0D));
          localStickerItem.angle = ((float)GsonUtils.optDouble(localJsonObject, "angle", 0.0D));
          localStickerItem.dx = GsonUtils.optInt(localJsonObject, "dx", 0);
          localStickerItem.dy = GsonUtils.optInt(localJsonObject, "dy", 0);
          localStickerItem.personID = GsonUtils.optInt(localJsonObject, "personID", -1);
          localStickerItem.genderType = GsonUtils.optInt(localJsonObject, "genderType", 0);
          localStickerItem.alpha = ((float)GsonUtils.optDouble(localJsonObject, "alpha", 1.0D));
          localStickerItem.snapshotTime = GsonUtils.optInt(localJsonObject, "snapshotTime", 0);
          if (localStickerItem.genderType > 0) {
            paramVideoMaterial.setDetectGender(true);
          }
          localStickerItem.featureStatType = GsonUtils.optInt(localJsonObject, "featureStatType");
          localStickerItem.frameType = GsonUtils.optInt(localJsonObject, "frameType");
          localStickerItem.blendMode = GsonUtils.optInt(localJsonObject, "blendMode", -1);
          localStickerItem.zIndex = GsonUtils.optInt(localJsonObject, "zIndex");
          localStickerItem.audioLoopCount = GsonUtils.optInt(localJsonObject, "audioLoopCount", -1);
          localStickerItem.randomGroupNum = GsonUtils.optInt(localJsonObject, "randomGroupNum");
          localStickerItem.externalTriggerWords = GsonUtils.optString(localJsonObject, "externalTriggerWords");
          str = localStickerItem.externalTriggerWords;
          localStickerItem.displacementLutPath = GsonUtils.optString(localJsonObject, "displacementLutPath");
          localObject1 = GsonUtils.optJsonArray(localJsonObject, "displacement");
          if ((localObject1 != null) && (((JsonArray)localObject1).size() > 0))
          {
            localStickerItem.displacementX = GsonUtils.getFloatSafe((JsonArray)localObject1, 0);
            localStickerItem.displacementY = GsonUtils.getFloatSafe((JsonArray)localObject1, 1);
          }
          if ((!TextUtils.isEmpty(localStickerItem.displacementLutPath)) || (localObject1 != null)) {
            paramVideoMaterial.addMaterialType(MaterialType.DISPLACEMENT);
          }
          localStickerItem.triggerState = new ArrayList();
          localObject1 = GsonUtils.optJsonArray(localJsonObject, "triggerStateList");
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
            localObject1 = GsonUtils.optString(localJsonObject, "triggerState");
            if ((localObject1 != null) && (!"".equals(localObject1))) {
              localStickerItem.triggerState.add(localObject1);
            }
          }
          localStickerItem.triggerMode = GsonUtils.optInt(localJsonObject, "triggerMode", 0);
          localStickerItem.playMode = GsonUtils.optInt(localJsonObject, "playMode", 0);
          localStickerItem.triggerFingerIndex = GsonUtils.optInt(localJsonObject, "triggerFingerIndex", 0);
          localStickerItem.fingerMusicClockTime = GsonUtils.optFloat(localJsonObject, "playBPM", 0.0F);
          localStickerItem.playBPM = GsonUtils.optInt(localJsonObject, "playBPM", 0);
          if (localStickerItem.playBPM > 0) {
            paramVideoMaterial.addMaterialType(MaterialType.FINGER_MUSIC);
          }
          if (localStickerItem.fingerMusicClockTime > 0.0F) {
            TouchTriggerManager.getInstance().setBgmClockTime(localStickerItem.fingerMusicClockTime);
          }
          localObject1 = GsonUtils.optJsonObject(localJsonObject, "triggerStateRange");
          if (localObject1 != null)
          {
            localStickerItem.triggerStateRange = new StickerItem.ValueRange();
            localStickerItem.triggerStateRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min", 1.0D);
            localStickerItem.triggerStateRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max", 0.0D);
          }
          localObject1 = GsonUtils.optJsonObject(localJsonObject, "featureStatValueRange");
          if (localObject1 != null)
          {
            localStickerItem.featureStatValueRange = new StickerItem.ValueRange();
            localStickerItem.featureStatValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
            localStickerItem.featureStatValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
          }
          localObject1 = GsonUtils.optJsonObject(localJsonObject, VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject1 != null)
          {
            localStickerItem.charmRange = new CharmRange();
            localStickerItem.charmRange.min = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localStickerItem.charmRange.max = GsonUtils.optDouble((JsonObject)localObject1, VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          if (localStickerItem.blendMode == -1) {
            localStickerItem.blendMode = paramInt2;
          }
          localStickerItem.setTriggerType(GsonUtils.optString(localJsonObject, "triggerType"));
          localObject1 = GsonUtils.optJsonArray(localJsonObject, "textureMaterials");
          if (localObject1 != null) {
            localStickerItem.textureMaterials = GsonUtils.getStringUnsafe((JsonArray)localObject1, 0);
          }
          localStickerItem.crazyFacePath = GsonUtils.optString(localJsonObject, "crazyFacePath");
          localStickerItem.audioTriggerType = GsonUtils.optInt(localJsonObject, "audioTriggerType");
          if (GsonUtils.optInt(localJsonObject, "audioNeedAdjust", 1) != 1) {
            break label4874;
          }
          bool = true;
          localStickerItem.audioNeedAdjust = bool;
          if (GsonUtils.optInt(localJsonObject, "orderMode", 1) == 1)
          {
            localStickerItem.orderMode = VideoMaterialUtil.STICKER_ORDER_MODE.AFTER_TRANSFORM;
            localObject1 = GsonUtils.optJsonObject(localJsonObject, "audioValueRange");
            if (localObject1 != null)
            {
              localStickerItem.audioValueRange = new StickerItem.ValueRange();
              localStickerItem.audioValueRange.min = GsonUtils.optDouble((JsonObject)localObject1, "min");
              localStickerItem.audioValueRange.max = GsonUtils.optDouble((JsonObject)localObject1, "max");
            }
            if ((VideoMaterialUtil.isActionTriggerType(localStickerItem.getTriggerTypeInt())) && (paramArrayOfInt != null)) {
              paramArrayOfInt[0] = localStickerItem.getTriggerTypeInt();
            }
            if (GsonUtils.optInt(localJsonObject, "alwaysTriggered") == 1)
            {
              bool = true;
              localStickerItem.alwaysTriggered = bool;
              localStickerItem.playCount = GsonUtils.optInt(localJsonObject, "playCount");
              localStickerItem.comicOrderMode = GsonUtils.optInt(localJsonObject, "comicOrderMode", 1);
              localStickerItem.comicLutFilter = GsonUtils.optString(localJsonObject, "comicLutFilter");
              localStickerItem.styleFilter = GsonUtils.optString(localJsonObject, "styleFilter");
              if (!TextUtils.isEmpty(localStickerItem.styleFilter)) {
                paramVideoMaterial.addMaterialType(MaterialType.STYLE_MASK);
              }
              localStickerItem.triggerFrameDurationTime = GsonUtils.optInt(localJsonObject, "triggerFrameDurationTime");
              localStickerItem.triggedTimes = GsonUtils.optInt(localJsonObject, "triggeredTimes");
              localStickerItem.delayedTriggedTime = GsonUtils.optInt(localJsonObject, "triggeredDelayTime");
              localStickerItem.frameDuration = GsonUtils.optDouble(localJsonObject, "frameDuration");
              localObject1 = GsonUtils.optJsonArray(localJsonObject, "triggerFrameStartTime");
              if (localObject1 == null) {
                break label1513;
              }
              m = ((JsonArray)localObject1).size();
              if (m <= 1) {
                break label1499;
              }
              localObject2 = new long[m];
              j = 0;
              if (j >= m) {
                break;
              }
              localObject2[j] = ((GsonUtils.optInt((JsonArray)localObject1, j) * localStickerItem.frameDuration));
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
    localStickerItem.triggerTimeUpdater = new TriggerTimeUpdater((long[])localObject2, (localStickerItem.delayedTriggedTime * localStickerItem.frameDuration), (localStickerItem.triggerFrameDurationTime * localStickerItem.frameDuration));
    localStickerItem.triggerFrameStartTime = ((int)(localStickerItem.triggerTimeUpdater.updateCurTriggerTime(-1L, 0L, false) / localStickerItem.frameDuration));
    for (;;)
    {
      localStickerItem.stickerType = GsonUtils.optInt(localJsonObject, "stickerType", paramInt1);
      localStickerItem.transformType = GsonUtils.optInt(localJsonObject, "transformType", 0);
      localStickerItem.needHandRotation = GsonUtils.optInt(localJsonObject, "needHandRotation", 0);
      if ((localStickerItem.type == VideoFilterFactory.POSITION_TYPE.CAT.type) || (localStickerItem.getTriggerTypeInt() == 700)) {
        paramVideoMaterial.addMaterialType(MaterialType.CAT_DETECT);
      }
      localObject1 = GsonUtils.optJsonArray(localJsonObject, "disableDetectors");
      if ((localObject1 == null) || (((JsonArray)localObject1).size() <= 0)) {
        break;
      }
      localStickerItem.disableDetectors = new String[((JsonArray)localObject1).size()];
      j = 0;
      while (j < ((JsonArray)localObject1).size())
      {
        localStickerItem.disableDetectors[j] = GsonUtils.getStringUnsafe((JsonArray)localObject1, j);
        j += 1;
      }
      label1499:
      localStickerItem.triggerFrameStartTime = GsonUtils.optInt((JsonArray)localObject1, 0);
      continue;
      label1513:
      localStickerItem.triggerFrameStartTime = GsonUtils.optInt(localJsonObject, "triggerFrameStartTime");
    }
    if ((localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type)) {
      if (localStickerItem.stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
        break label1814;
      }
    }
    Object localObject3;
    label1814:
    for (Object localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;; localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT)
    {
      localStickerItem.sourceType = ((VideoMaterialUtil.ITEM_SOURCE_TYPE)localObject1);
      if (VideoFilterFactory.STICKER_TYPE.FREEZE_FRAME.type == localStickerItem.stickerType) {
        paramVideoMaterial.setNeedFreezeFrame(true);
      }
      localStickerItem.frames = GsonUtils.optInt(localJsonObject, "frames");
      localStickerItem.width = GsonUtils.optInt(localJsonObject, "width");
      localStickerItem.height = GsonUtils.optInt(localJsonObject, "height");
      localStickerItem.extraTypeWidth = GsonUtils.optInt(localJsonObject, "extraTypeWidth");
      localStickerItem.extarTypeHeight = GsonUtils.optInt(localJsonObject, "extraTypeHeight");
      localStickerItem.maxScaledWidth = GsonUtils.optInt(localJsonObject, "maxScaledWidth");
      localStickerItem.minScaledWidth = GsonUtils.optInt(localJsonObject, "minScaledWidth");
      localStickerItem.support3D = GsonUtils.optInt(localJsonObject, "enable3D", 1);
      localStickerItem.scaleDirection = GsonUtils.optInt(localJsonObject, "scaleDirection");
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "zoomScale");
      if (localObject1 == null) {
        break label1833;
      }
      localObject2 = ((JsonObject)localObject1).keySet().iterator();
      localStickerItem.zoomScale = new ArrayList();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localStickerItem.zoomScale.add(Pair.create(Float.valueOf((String)localObject3), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject3, 0.0D))));
      }
    }
    Collections.sort(localStickerItem.zoomScale, mRangeValueComp);
    label1833:
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "activeParts");
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
    localStickerItem.zoomType = GsonUtils.optInt(localJsonObject, "zoomType");
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "zoomFocusPoint");
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
    localStickerItem.zoomWidth = ((float)GsonUtils.optDouble(localJsonObject, "zoomWidth"));
    localStickerItem.zoomHeight = ((float)GsonUtils.optDouble(localJsonObject, "zoomHeight"));
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "position");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "rotateType");
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
    localStickerItem.audio = GsonUtils.optString(localJsonObject, "audio");
    localStickerItem.lutFilterName = GsonUtils.optString(localJsonObject, "lutFilterName");
    localStickerItem.filterOrderMode = GsonUtils.optInt(localJsonObject, "filterOrderMode", 0);
    localStickerItem.filterAlphaGradientDuration = GsonUtils.optDouble(localJsonObject, "filterAlphaGradientDuration", 1.0D);
    if ((!TextUtils.isEmpty(localStickerItem.audio)) && (paramArrayOfBoolean != null)) {
      paramArrayOfBoolean[0] = true;
    }
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "frameSize");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "anchorPoint");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "anchorPointAudio");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "alignFacePoints");
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
    localObject1 = GsonUtils.optJsonArray(localJsonObject, "scalePivots");
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
    localStickerItem.scaleFactor = GsonUtils.optInt(localJsonObject, "scaleFactor");
    localStickerItem.originalScaleFactor = localStickerItem.scaleFactor;
    localStickerItem.markMode = GsonUtils.optInt(localJsonObject, "markMode");
    localStickerItem.lazyLoad = GsonUtils.optInt(localJsonObject, "lazyLoadFlag");
    localStickerItem.activateTriggerType = GsonUtils.optInt(localJsonObject, "activateTriggerType", 0);
    localStickerItem.activateTriggerCount = GsonUtils.optInt(localJsonObject, "activateTriggerCount", 0);
    localStickerItem.activateTriggerTotalCount = GsonUtils.optInt(localJsonObject, "activateTriggerTotalCount", 0);
    localStickerItem.lockTriggerCountUntilFail = GsonUtils.optInt(localJsonObject, "lockTriggerCountUntilFail", 0);
    localStickerItem.bodyTriggerPoint = GsonUtils.optInt(localJsonObject, "bodyTriggerPoint", 0);
    localStickerItem.bodyTriggerDirection = GsonUtils.optInt(localJsonObject, "bodyTriggerDirection", 0);
    localStickerItem.bodyTriggerDistance = GsonUtils.optInt(localJsonObject, "bodyTriggerDistance", 0);
    localStickerItem.bodyTriggerTimeGap = GsonUtils.optDouble(localJsonObject, "bodyTriggerTimeGap", 0.0D);
    localStickerItem.relativeScaleType = GsonUtils.optInt(localJsonObject, "relativeScaleType");
    label2755:
    int n;
    if (GsonUtils.optInt(localJsonObject, "orienting") == 1)
    {
      bool = true;
      localStickerItem.orienting = bool;
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "ageRange");
      if (localObject1 != null)
      {
        localStickerItem.ageRange = new AgeRange();
        localStickerItem.ageRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.ageRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "genderRange");
      if (localObject1 != null)
      {
        localStickerItem.genderRange = new GenderRange();
        localStickerItem.genderRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.genderRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "popularRange");
      if (localObject1 != null)
      {
        localStickerItem.popularRange = new PopularRange();
        localStickerItem.popularRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.popularRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "cpRange");
      if (localObject1 != null)
      {
        localStickerItem.cpRange = new CpRange();
        localStickerItem.cpRange.min = ((float)GsonUtils.optDouble((JsonObject)localObject1, "min"));
        localStickerItem.cpRange.max = ((float)GsonUtils.optDouble((JsonObject)localObject1, "max"));
      }
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "audioScaleFactor");
      if (localObject1 != null)
      {
        localObject2 = ((JsonObject)localObject1).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localStickerItem.audioScaleFactorMap.add(Pair.create(Float.valueOf((String)localObject3), Double.valueOf(GsonUtils.optDouble((JsonObject)localObject1, (String)localObject3, 0.0D))));
        }
      }
      Collections.sort(localStickerItem.audioScaleFactorMap, mRangeValueComp);
      localObject1 = GsonUtils.optJsonObject(localJsonObject, "transition");
      if (localObject1 != null)
      {
        localStickerItem.transition = new Transition();
        localStickerItem.transition.particleCountMax = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_COUNT_MAX.value);
        localStickerItem.transition.life = GsonUtils.optString((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.LIFE.value);
        localStickerItem.transition.emissionMode = GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.EMISSION_MODE.value);
        localObject2 = localStickerItem.transition;
        if (GsonUtils.optInt((JsonObject)localObject1, VideoMaterialUtil.TRANSITION.PARTICLE_ALWAYS_UPDATE.value) != 1) {
          break label4886;
        }
        bool = true;
        label3208:
        ((Transition)localObject2).particleAlwaysUpdate = bool;
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
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
        if (localObject1 != null)
        {
          localStickerItem.wmGroupConfigCopies = new ArrayList();
          j = 0;
          for (;;)
          {
            n = localStickerItem.transition.particleCountMax / localStickerItem.transition.repeatCount;
            if (localStickerItem.transition.clearMode != VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) {
              break label4892;
            }
            m = 1;
            label3500:
            if (j >= m + n) {
              break;
            }
            localObject2 = parseWMGroupConfig((JsonArray)localObject1, paramVideoMaterial);
            ((WMGroupConfig)localObject2).id = j;
            localStickerItem.wmGroupConfigCopies.add(localObject2);
            j += 1;
          }
        }
      }
      else
      {
        localObject1 = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
        if (localObject1 != null) {
          localStickerItem.wmGroupConfig = parseWMGroupConfig((JsonArray)localObject1, paramVideoMaterial);
        }
      }
      localStickerItem.triggerWords = GsonUtils.optString(localJsonObject, "triggerWords");
      localStickerItem.preTriggerType = localStickerItem.getTriggerTypeInt();
      localStickerItem.dexName = GsonUtils.optString(localJsonObject, "dexName");
      localArrayList2.add(localStickerItem);
      n = localStickerItem.getTriggerTypeInt();
      if (GsonUtils.optInt(localJsonObject, "isElementTriggerMVPart", 0) != 0) {
        i = localStickerItem.getTriggerTypeInt();
      }
      localObject1 = paramString + File.separator + localStickerItem.id + File.separator + GsonUtils.optString(localJsonObject, "dexName");
      if (localHashMap1.containsKey(localObject1))
      {
        localStickerItem.particleConfig = ((ParticleConfig)localHashMap1.get(localObject1));
        localObject1 = paramString + File.separator + localStickerItem.id + File.separator + GsonUtils.optString(localJsonObject, "gpuParticleConfigFile");
        if (!localHashMap2.containsKey(localObject1)) {
          break label4198;
        }
        localStickerItem.gpuParticleConfig = ((GPUParticleConfig)localHashMap2.get(localObject1));
      }
      for (;;)
      {
        if (localStickerItem.gpuParticleConfig != null)
        {
          paramVideoMaterial.addMaterialType(MaterialType.PARTICLE3D);
          if (("*".equals(localStickerItem.gpuParticleConfig.startColorReference)) || ((localStickerItem.gpuParticleConfig.backgroundConfig != null) && ("*".equals(localStickerItem.gpuParticleConfig.backgroundConfig.texture)))) {
            paramVideoMaterial.addMaterialType(MaterialType.PARTICLE_DISMISS);
          }
        }
        if (GsonUtils.optInt(localJsonObject, "followPhoneAngle", 0) != 1) {
          break label4898;
        }
        bool = true;
        label3878:
        localStickerItem.followPhoneAngle = bool;
        localStickerItem.strokeType = GsonUtils.optInt(localJsonObject, "strokeType", 0);
        localStickerItem.strokeStyle = GsonUtils.optInt(localJsonObject, "strokeStyle", 0);
        localStickerItem.strokeColor = StrokeUtil.parseRGBAColor(GsonUtils.optString(localJsonObject, "strokeColor", ""));
        localStickerItem.strokeWidth = GsonUtils.optDouble(localJsonObject, "strokeWidth", 0.0D);
        localStickerItem.strokeGap = GsonUtils.optDouble(localJsonObject, "strokeGap", 0.0D);
        if (GsonUtils.optInt(localJsonObject, "isStrokeBlur", 0) != 1) {
          break label4904;
        }
        bool = true;
        label3976:
        localStickerItem.isStrokeBlur = bool;
        localStickerItem.hairLutName = GsonUtils.optString(localJsonObject, "hairLutName");
        localStickerItem.hairMaskType = Integer.valueOf(GsonUtils.optInt(localJsonObject, "hairMaskType", 0));
        localStickerItem.needCrop = GsonUtils.optInt(localJsonObject, "needCrop", 0);
        localStickerItem.maskType = GsonUtils.optString(localJsonObject, "maskType");
        localStickerItem.maskLut = GsonUtils.optString(localJsonObject, "maskLut");
        localStickerItem.framePositionsBean = parseFramePosition(paramVideoMaterial, localJsonObject);
        localObject1 = GsonUtils.optJsonArray(localJsonObject, "hotArea");
        if ((localObject1 == null) || (((JsonArray)localObject1).size() <= 0)) {
          break label4269;
        }
        localStickerItem.hotArea = new double[((JsonArray)localObject1).size()];
        j = 0;
        while (j < ((JsonArray)localObject1).size())
        {
          localStickerItem.hotArea[j] = GsonUtils.getDoubleUnsafe((JsonArray)localObject1, j);
          j += 1;
        }
        localStickerItem.particleConfig = parseParticleConfig(paramString + File.separator + localStickerItem.id, GsonUtils.optString(localJsonObject, "dexName"), paramDecryptListener);
        localHashMap1.put(localObject1, localStickerItem.particleConfig);
        break;
        label4198:
        localStickerItem.gpuParticleConfig = parseGpuParticleConfig(localJsonObject, paramString + File.separator + localStickerItem.id, GsonUtils.optString(localJsonObject, "gpuParticleConfigFile"), paramDecryptListener);
        localHashMap2.put(localObject1, localStickerItem.gpuParticleConfig);
      }
      paramVideoMaterial.addMaterialType(MaterialType.HOT_AREA);
      label4269:
      localStickerItem.redPacketStartFrame = GsonUtils.optInt(localJsonObject, "hotAreaStartFrame");
      localStickerItem.redPacketEndFrame = GsonUtils.optInt(localJsonObject, "hotAreaEndFrame");
      localStickerItem.activateTriggerCountOnce = GsonUtils.optInt(localJsonObject, "activateTriggerCountOnce");
      localStickerItem.triggerHandPoint = GsonUtils.optInt(localJsonObject, "triggerHandPoint");
      localObject1 = GsonUtils.optJsonArray(localJsonObject, "triggerAreas");
      if (localObject1 != null)
      {
        localStickerItem.triggerArea = new ArrayList();
        j = 0;
        label4351:
        if (j < ((JsonArray)localObject1).size())
        {
          localObject2 = new StickerItem.TriggerArea();
          localObject3 = GsonUtils.optJsonObject((JsonArray)localObject1, j);
          if (localObject3 == null) {
            break label4910;
          }
          ((StickerItem.TriggerArea)localObject2).type = GsonUtils.optInt((JsonObject)localObject3, "type");
          JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject3, "rect");
          if (localJsonArray != null)
          {
            ((StickerItem.TriggerArea)localObject2).rect = new float[localJsonArray.size()];
            m = 0;
            while (m < localJsonArray.size())
            {
              ((StickerItem.TriggerArea)localObject2).rect[m] = GsonUtils.getFloatSafe(localJsonArray, m);
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
          break label4910;
        }
        if (localStickerItem.triggerArea.size() > 0)
        {
          localArrayList1 = localStickerItem.triggerArea;
          label4557:
          localStickerItem.isCanDiyPitcureVideo = GsonUtils.optInt(localJsonObject, "isCanDiyPitcureVideo");
          if (localStickerItem.isCanDiyPitcureVideo == 1)
          {
            j = GsonUtils.optInt(localJsonObject, "width", 720);
            m = GsonUtils.optInt(localJsonObject, "height", 960);
            localObject1 = new VideoMaterial.DIYMaterialParams();
            ((VideoMaterial.DIYMaterialParams)localObject1).diyItemid = localStickerItem.id;
            ((VideoMaterial.DIYMaterialParams)localObject1).diyImageWidth = j;
            ((VideoMaterial.DIYMaterialParams)localObject1).diyImageHeight = m;
            ((VideoMaterial.DIYMaterialParams)localObject1).diyFrameDuration = localStickerItem.frameDuration;
            ((VideoMaterial.DIYMaterialParams)localObject1).diyVideoDuration = (((VideoMaterial.DIYMaterialParams)localObject1).diyFrameDuration * localStickerItem.frames);
            ((VideoMaterial.DIYMaterialParams)localObject1).diyType = GsonUtils.optInt(localJsonObject, "diyType", 3);
            ((VideoMaterial.DIYMaterialParams)localObject1).diyFilePath = GsonUtils.optString(localJsonObject, "diyFilePath", "");
            ((VideoMaterial.DIYMaterialParams)localObject1).diyIsVideoFile = false;
            paramVideoMaterial.addDiyItemList((VideoMaterial.DIYMaterialParams)localObject1);
            paramVideoMaterial.addMaterialType(MaterialType.MATERIAL_REPLACE);
          }
          paramVideoMaterial.setMusicID(GsonUtils.optString(localJsonObject, "musicID"));
          if ((localStickerItem.getTriggerTypeInt() != PTFaceAttr.PTExpression.ALWAYS.value) || (TextUtils.isEmpty(localStickerItem.audio))) {
            break label4919;
          }
          paramVideoMaterial.setOverallAudio(localStickerItem.id + File.separator + localStickerItem.audio);
          break label4919;
        }
      }
    }
    for (;;)
    {
      label4790:
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
      label4874:
      label4886:
      label4892:
      label4898:
      label4904:
      label4910:
      label4919:
      label4936:
      do
      {
        paramInt1 = j;
        break label4790;
        break label4557;
        bool = false;
        break label930;
        bool = false;
        break label2755;
        bool = false;
        break label3208;
        m = 0;
        break label3500;
        bool = false;
        break label3878;
        bool = false;
        break label3976;
        j += 1;
        break label4351;
        k += 1;
        j = n;
        localObject1 = str;
        break;
      } while (i <= 0);
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
          if (GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ALWAYS_TRIGGERED.value, 1) == 1)
          {
            bool = true;
            localNodeItemJava.alwaysTriggered = bool;
            localNodeItemJava.playCount = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.PLAY_COUNT.value, 0);
            localNodeItemJava.rotateRequied = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ROTATE_REQUIRED.value, 1);
            localNodeItemJava.material = GsonUtils.optString((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.MATERIAL.value, "baseColorMap");
            localNodeItemJava.activateTriggerCount = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_COUNT.value, 0);
            localNodeItemJava.activateTriggerType = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_TYPE.value, 0);
            localNodeItemJava.activateTriggerTotalCount = GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_TOTAL_COUNT.value, 0);
            localNodeItemJava.expressionConfigList = parseExpressionList((JsonObject)localObject);
            if (GsonUtils.optDouble((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.EXPRESSION_CONFIG_VERSION.value) < 1.1D) {
              break label496;
            }
            bool = true;
            label369:
            localNodeItemJava.enableExpressionConfigRemap = bool;
            if (GsonUtils.optInt((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.NEED_SHOW.value, 1) != 1) {
              break label502;
            }
          }
          HashMap localHashMap;
          label496:
          label502:
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
              break label508;
            }
            j = 0;
            while (j < ((JsonArray)localObject).size())
            {
              localHashMap.put(GsonUtils.optString((JsonArray)localObject, j), Integer.valueOf(j));
              j += 1;
            }
            bool = false;
            break;
            bool = false;
            break label369;
          }
          label508:
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
      paramVideoMaterial.setFiltersConfig(parseFiltersConfig(paramVideoMaterial, paramJsonObject));
      paramVideoMaterial.setStyleFilterList(parseStyleFilterList(paramString, GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.FIELD.STYLE_FILTER_LIST.value), paramVideoMaterial));
      localObject = new boolean[1];
      localObject[0] = 0;
      parse3DItemListParams(paramString, paramJsonObject, paramVideoMaterial, (boolean[])localObject);
      if ((i == 0) && (localObject[0] == 0)) {
        break label531;
      }
    }
    label531:
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
        ((List)localObject).add(new FaceItem(paramVideoMaterial.getFaceExchangeImage(), paramVideoMaterial.isFaceExchangeImageDisableFaceCrop(), (float)paramVideoMaterial.getBlendAlpha(), paramVideoMaterial.getGrayScale(), paramVideoMaterial.getFeatureType(), paramVideoMaterial.getFacePoints()));
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
      parseRapidNetFaceStyleItemList(paramJsonObject, paramVideoMaterial, paramString);
      parseCosFunParams(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener);
      parseShowTipsItem(paramJsonObject, paramVideoMaterial);
      parseFaceBeautyItemListParams(paramJsonObject, paramVideoMaterial);
      parseTriggerStateEdgeItemList(paramJsonObject, paramVideoMaterial);
      parseTriggerStateActionItemList(paramJsonObject, paramVideoMaterial);
      parseStyleFilterConfigFile(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener);
      parseCustomFilterGroupConfigFile(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener);
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
  
  private static void parseRapidNetFaceStyleItemList(JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, String paramString)
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
        localObject = parseFaceStyleItem((JsonObject)localObject, paramVideoMaterial, paramString);
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
  
  private static void parseStyleFilterConfigFile(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    paramVideoMaterial.setCustomFilterList(parseCustomFilterConfig(paramString, paramJsonObject, paramVideoMaterial, paramDecryptListener, VideoMaterialUtil.FIELD.CUSTOM_STYLE_FILTER_CONFIG_FILE.value));
  }
  
  private static Map<String, StyleFilterSettingJsonBean> parseStyleFilterList(String paramString, JsonArray paramJsonArray, VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramJsonArray != null)
    {
      int i = 0;
      localObject2 = localObject1;
      if (i < paramJsonArray.size())
      {
        localObject2 = paramJsonArray.get(i).toString();
        Object localObject3;
        if (localObject2 == null) {
          localObject3 = localObject1;
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject3;
          break;
          StyleFilterSettingJsonBean localStyleFilterSettingJsonBean = (StyleFilterSettingJsonBean)GsonUtils.json2Obj((String)localObject2, new VideoTemplateParser.3().getType());
          localObject3 = localObject1;
          if (localStyleFilterSettingJsonBean != null)
          {
            localStyleFilterSettingJsonBean.updatePath(paramString);
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new HashMap();
            }
            ((Map)localObject2).put(localStyleFilterSettingJsonBean.id, localStyleFilterSettingJsonBean);
            localObject3 = localObject2;
            if (localStyleFilterSettingJsonBean.type == 6)
            {
              paramVideoMaterial.addMaterialType(MaterialType.CYBERPUNK);
              localObject3 = localObject2;
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  private static void parseSubstitute(String paramString, JsonObject paramJsonObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    paramJsonObject = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.FIELD.SUBSTITUTE.value);
    paramVideoMaterial.setSubstitue(paramJsonObject);
    if (!TextUtils.isEmpty(paramJsonObject)) {
      paramVideoMaterial.setSubstituteMaterial(parseVideoMaterial(paramString, paramJsonObject, true, paramDecryptListener));
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
  
  private static TriggerConfig parseTriggerConfig(JsonObject paramJsonObject)
  {
    boolean bool = true;
    TriggerConfig localTriggerConfig = new TriggerConfig();
    if (paramJsonObject == null) {
      return localTriggerConfig;
    }
    localTriggerConfig.triggerType = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GLB_FIELD.TRIGGER_TYPE.value, "1");
    localTriggerConfig.preTriggerType = TriggerConfig.getTriggerTypeInt(localTriggerConfig.triggerType);
    localTriggerConfig.externalTriggerWords = GsonUtils.optString(paramJsonObject, VideoMaterialUtil.GLB_FIELD.EXTERNAL_TRIGGER_WORDS.value, "");
    if (GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GLB_FIELD.ALWAYS_TRIGGERED.value, 1) == 1) {}
    for (;;)
    {
      localTriggerConfig.alwaysTriggered = bool;
      localTriggerConfig.playCount = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GLB_FIELD.PLAY_COUNT.value, 0);
      localTriggerConfig.activateTriggerCount = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_COUNT.value, 0);
      localTriggerConfig.activateTriggerType = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_TYPE.value, 0);
      localTriggerConfig.activateTriggerTotalCount = GsonUtils.optInt(paramJsonObject, VideoMaterialUtil.GLB_FIELD.ACTIVE_TOTAL_COUNT.value, 0);
      return localTriggerConfig;
      bool = false;
    }
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
      parseSubstitute(paramString, paramJsonObject, localVideoMaterial, paramDecryptListener);
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
  
  public static GPUParticleConfig.BackgroundConfig parsegpuParticleBackgroundConfig(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = readMaterialFile(paramString1, paramString2, true, paramDecryptListener);
    LogUtils.i(TAG, "[parseVideoMaterialFileAsJSONObject] dataStr = " + paramString1);
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      try
      {
        paramString1 = GsonUtils.json2JsonObject(paramString1);
        if (paramString1 == null) {
          break;
        }
        paramString2 = new GPUParticleConfig.BackgroundConfig();
        paramString2.texture = GsonUtils.optString(paramString1, "texture");
        paramString1 = GsonUtils.optJsonObject(paramString1, "dismissConfig");
        if (paramString1 == null) {
          break label159;
        }
        paramString2.type = GsonUtils.optInt(paramString1, "type", 0);
        paramString2.duration = GsonUtils.optFloat(paramString1, "duration", 0.0F);
        paramString2.startSide = GsonUtils.optInt(paramString1, "startSide", 0);
        paramString2.strokeWidth = GsonUtils.optFloat(paramString1, "strokeWidth", 10.0F);
        return paramString2;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      paramString1 = null;
    }
    label159:
    paramString2.type = 0;
    paramString2.duration = 0.0F;
    paramString2.startSide = 0;
    paramString2.strokeWidth = 10.0F;
    return paramString2;
  }
  
  public static GPUParticleConfig.SourcePositionPath parsegpuParticleSourcePositionPath(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    int k = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = readMaterialFile(paramString1, paramString2, true, paramDecryptListener);
    LogUtils.i(TAG, "[parseVideoMaterialFileAsJSONObject] dataStr = " + paramString1);
    if (!TextUtils.isEmpty(paramString1)) {}
    int i;
    for (;;)
    {
      try
      {
        paramString1 = GsonUtils.json2JsonObject(paramString1);
        if (paramString1 == null) {
          break;
        }
        paramString2 = new GPUParticleConfig.SourcePositionPath();
        paramString2.scale = GsonUtils.optInt(paramString1, "scale");
        paramString2.looped = GsonUtils.optInt(paramString1, "looped");
        paramString2.duration = GsonUtils.optFloat(paramString1, "duration");
        paramDecryptListener = GsonUtils.optJsonArray(paramString1, "anchorPoint");
        if (paramDecryptListener == null) {
          break label161;
        }
        i = 0;
        if (i >= paramDecryptListener.size()) {
          break label161;
        }
        paramString2.anchorPoint[i] = GsonUtils.optInt(paramDecryptListener, i);
        i += 1;
        continue;
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    label161:
    paramDecryptListener = GsonUtils.optJsonArray(paramString1, "path");
    if (paramDecryptListener != null)
    {
      i = paramDecryptListener.size();
      paramString2.path = ((float[][])Array.newInstance(Float.TYPE, new int[] { i, 3 }));
      i = 0;
      while (i < paramDecryptListener.size())
      {
        JsonArray localJsonArray = GsonUtils.optJsonArray(paramDecryptListener, i);
        int j = 0;
        while (j < localJsonArray.size())
        {
          paramString2.path[i][j] = ((float)GsonUtils.optDouble(localJsonArray, j));
          j += 1;
        }
        i += 1;
      }
    }
    paramString1 = GsonUtils.optJsonArray(paramString1, "canvas");
    if (paramString1 != null)
    {
      paramString2.canvas = new float[paramString1.size()];
      i = k;
      while (i < paramString1.size())
      {
        paramString2.canvas[i] = ((float)GsonUtils.optDouble(paramString1, i));
        i += 1;
      }
    }
    return paramString2;
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
    //   4: astore 6
    //   6: aload_0
    //   7: invokestatic 188	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_0
    //   11: new 190	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 1052
    //   25: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 5
    //   37: new 190	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 1052
    //   51: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 7
    //   63: iload_2
    //   64: ifeq +353 -> 417
    //   67: aload 5
    //   69: astore_0
    //   70: aload 5
    //   72: ldc 34
    //   74: invokevirtual 2871	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   77: ifne +25 -> 102
    //   80: new 190	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   87: aload 5
    //   89: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 5839
    //   95: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_0
    //   102: aload_0
    //   103: astore_1
    //   104: aload 7
    //   106: ldc 31
    //   108: invokevirtual 2871	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   111: ifne +884 -> 995
    //   114: new 190	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   121: aload 7
    //   123: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 5841
    //   129: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_1
    //   136: new 197	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 5842	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore 7
    //   146: new 197	java/io/File
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 5842	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: astore 5
    //   156: aload 7
    //   158: invokevirtual 5845	java/io/File:exists	()Z
    //   161: ifeq +11 -> 172
    //   164: aload 7
    //   166: invokevirtual 5848	java/io/File:isFile	()Z
    //   169: ifne +19 -> 188
    //   172: aload 5
    //   174: invokevirtual 5845	java/io/File:exists	()Z
    //   177: ifeq +357 -> 534
    //   180: aload 5
    //   182: invokevirtual 5848	java/io/File:isFile	()Z
    //   185: ifeq +349 -> 534
    //   188: aload 7
    //   190: invokevirtual 5845	java/io/File:exists	()Z
    //   193: ifeq +296 -> 489
    //   196: aload 7
    //   198: invokevirtual 5848	java/io/File:isFile	()Z
    //   201: ifeq +288 -> 489
    //   204: new 5850	java/io/FileInputStream
    //   207: dup
    //   208: aload 7
    //   210: invokespecial 5853	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   213: astore_1
    //   214: iload_2
    //   215: ifne +314 -> 529
    //   218: aload_1
    //   219: aload_3
    //   220: invokestatic 5742	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   223: astore_0
    //   224: aload_1
    //   225: astore 5
    //   227: aload_0
    //   228: astore 8
    //   230: aload_1
    //   231: astore_3
    //   232: aload_0
    //   233: astore 7
    //   235: aload_1
    //   236: invokestatic 5856	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   239: aload_0
    //   240: ifnull +454 -> 694
    //   243: aload_1
    //   244: astore 5
    //   246: aload_0
    //   247: astore 8
    //   249: aload_1
    //   250: astore_3
    //   251: aload_0
    //   252: astore 7
    //   254: new 5729	java/io/InputStreamReader
    //   257: dup
    //   258: aload_0
    //   259: invokespecial 5745	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   262: astore 6
    //   264: new 5727	java/io/BufferedReader
    //   267: dup
    //   268: aload 6
    //   270: sipush 1024
    //   273: invokespecial 5748	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   276: astore_3
    //   277: aload_1
    //   278: astore 10
    //   280: aload 6
    //   282: astore 9
    //   284: aload_3
    //   285: astore 8
    //   287: aload_0
    //   288: astore 7
    //   290: new 190	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   297: astore 5
    //   299: aload_1
    //   300: astore 10
    //   302: aload 6
    //   304: astore 9
    //   306: aload_3
    //   307: astore 8
    //   309: aload_0
    //   310: astore 7
    //   312: aload_3
    //   313: invokevirtual 5751	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   316: astore 11
    //   318: aload 11
    //   320: ifnull +310 -> 630
    //   323: aload_1
    //   324: astore 10
    //   326: aload 6
    //   328: astore 9
    //   330: aload_3
    //   331: astore 8
    //   333: aload_0
    //   334: astore 7
    //   336: aload 5
    //   338: aload 11
    //   340: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: goto -45 -> 299
    //   347: astore 5
    //   349: aload_1
    //   350: astore 10
    //   352: aload 6
    //   354: astore 9
    //   356: aload_3
    //   357: astore 8
    //   359: aload_0
    //   360: astore 7
    //   362: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   365: aload 5
    //   367: invokevirtual 5835	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   370: aload 5
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 5859	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   379: aload_3
    //   380: ifnull +7 -> 387
    //   383: aload_3
    //   384: invokevirtual 5862	java/io/BufferedReader:close	()V
    //   387: aload 6
    //   389: ifnull +8 -> 397
    //   392: aload 6
    //   394: invokevirtual 5863	java/io/InputStreamReader:close	()V
    //   397: aload_0
    //   398: ifnull +7 -> 405
    //   401: aload_0
    //   402: invokevirtual 5866	java/io/InputStream:close	()V
    //   405: aload_1
    //   406: ifnull +7 -> 413
    //   409: aload_1
    //   410: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   413: aconst_null
    //   414: astore_0
    //   415: aload_0
    //   416: areturn
    //   417: aload 5
    //   419: astore_0
    //   420: aload 5
    //   422: ldc 31
    //   424: invokevirtual 2871	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   427: ifne +25 -> 452
    //   430: new 190	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   437: aload 5
    //   439: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 5841
    //   445: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore_0
    //   452: aload_0
    //   453: astore_1
    //   454: aload 7
    //   456: ldc 34
    //   458: invokevirtual 2871	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   461: ifne +534 -> 995
    //   464: new 190	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   471: aload 7
    //   473: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 5839
    //   479: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: astore_1
    //   486: goto -350 -> 136
    //   489: aload 5
    //   491: invokevirtual 5845	java/io/File:exists	()Z
    //   494: ifeq +496 -> 990
    //   497: aload 5
    //   499: invokevirtual 5848	java/io/File:isFile	()Z
    //   502: ifeq +488 -> 990
    //   505: new 5850	java/io/FileInputStream
    //   508: dup
    //   509: aload 5
    //   511: invokespecial 5853	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   514: astore_1
    //   515: iload_2
    //   516: ifne +8 -> 524
    //   519: iconst_1
    //   520: istore_2
    //   521: goto -307 -> 214
    //   524: iconst_0
    //   525: istore_2
    //   526: goto -5 -> 521
    //   529: aload_1
    //   530: astore_0
    //   531: goto -292 -> 239
    //   534: invokestatic 2235	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   537: invokevirtual 5871	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   540: aload_0
    //   541: invokevirtual 5877	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   544: astore 5
    //   546: iload_2
    //   547: ifne +20 -> 567
    //   550: aload 5
    //   552: aload_3
    //   553: invokestatic 5742	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   556: astore_0
    //   557: aload 5
    //   559: invokestatic 5856	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   562: aconst_null
    //   563: astore_1
    //   564: goto -325 -> 239
    //   567: aload 5
    //   569: astore_0
    //   570: goto -8 -> 562
    //   573: astore_0
    //   574: aconst_null
    //   575: astore_0
    //   576: invokestatic 2235	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   579: invokevirtual 5871	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   582: aload_1
    //   583: invokevirtual 5877	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   586: astore_1
    //   587: iload_2
    //   588: ifne +25 -> 613
    //   591: iload 4
    //   593: ifne +26 -> 619
    //   596: aload_1
    //   597: aload_3
    //   598: invokestatic 5742	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   601: astore_3
    //   602: aload_3
    //   603: astore_0
    //   604: aload_1
    //   605: invokestatic 5856	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   608: aconst_null
    //   609: astore_1
    //   610: goto -371 -> 239
    //   613: iconst_0
    //   614: istore 4
    //   616: goto -25 -> 591
    //   619: aload_1
    //   620: astore_0
    //   621: goto -13 -> 608
    //   624: astore_1
    //   625: aconst_null
    //   626: astore_1
    //   627: goto -388 -> 239
    //   630: aload_1
    //   631: astore 10
    //   633: aload 6
    //   635: astore 9
    //   637: aload_3
    //   638: astore 8
    //   640: aload_0
    //   641: astore 7
    //   643: aload 5
    //   645: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: astore 5
    //   650: aload_3
    //   651: ifnull +7 -> 658
    //   654: aload_3
    //   655: invokevirtual 5862	java/io/BufferedReader:close	()V
    //   658: aload 6
    //   660: ifnull +8 -> 668
    //   663: aload 6
    //   665: invokevirtual 5863	java/io/InputStreamReader:close	()V
    //   668: aload_0
    //   669: ifnull +7 -> 676
    //   672: aload_0
    //   673: invokevirtual 5866	java/io/InputStream:close	()V
    //   676: aload 5
    //   678: astore_0
    //   679: aload_1
    //   680: ifnull -265 -> 415
    //   683: aload_1
    //   684: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   687: aload 5
    //   689: areturn
    //   690: astore_0
    //   691: aload 5
    //   693: areturn
    //   694: iconst_0
    //   695: ifeq +11 -> 706
    //   698: new 5879	java/lang/NullPointerException
    //   701: dup
    //   702: invokespecial 5880	java/lang/NullPointerException:<init>	()V
    //   705: athrow
    //   706: iconst_0
    //   707: ifeq +11 -> 718
    //   710: new 5879	java/lang/NullPointerException
    //   713: dup
    //   714: invokespecial 5880	java/lang/NullPointerException:<init>	()V
    //   717: athrow
    //   718: aload_0
    //   719: ifnull +7 -> 726
    //   722: aload_0
    //   723: invokevirtual 5866	java/io/InputStream:close	()V
    //   726: aload_1
    //   727: ifnull -314 -> 413
    //   730: aload_1
    //   731: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   734: goto -321 -> 413
    //   737: astore_0
    //   738: goto -325 -> 413
    //   741: astore_1
    //   742: aconst_null
    //   743: astore_3
    //   744: aconst_null
    //   745: astore 5
    //   747: aconst_null
    //   748: astore_0
    //   749: aload 5
    //   751: ifnull +8 -> 759
    //   754: aload 5
    //   756: invokevirtual 5862	java/io/BufferedReader:close	()V
    //   759: aload_3
    //   760: ifnull +7 -> 767
    //   763: aload_3
    //   764: invokevirtual 5863	java/io/InputStreamReader:close	()V
    //   767: aload_0
    //   768: ifnull +7 -> 775
    //   771: aload_0
    //   772: invokevirtual 5866	java/io/InputStream:close	()V
    //   775: aload 6
    //   777: ifnull +8 -> 785
    //   780: aload 6
    //   782: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   785: aload_1
    //   786: athrow
    //   787: astore_0
    //   788: goto -3 -> 785
    //   791: astore 7
    //   793: aconst_null
    //   794: astore_3
    //   795: aconst_null
    //   796: astore 5
    //   798: aconst_null
    //   799: astore_0
    //   800: aload_1
    //   801: astore 6
    //   803: aload 7
    //   805: astore_1
    //   806: goto -57 -> 749
    //   809: astore_1
    //   810: aconst_null
    //   811: astore_3
    //   812: aconst_null
    //   813: astore_0
    //   814: aload 5
    //   816: astore 6
    //   818: aload_0
    //   819: astore 5
    //   821: aload 8
    //   823: astore_0
    //   824: goto -75 -> 749
    //   827: astore_1
    //   828: aconst_null
    //   829: astore_3
    //   830: aconst_null
    //   831: astore 5
    //   833: goto -84 -> 749
    //   836: astore_1
    //   837: aconst_null
    //   838: astore_3
    //   839: aconst_null
    //   840: astore 5
    //   842: goto -93 -> 749
    //   845: astore_1
    //   846: aconst_null
    //   847: astore_3
    //   848: aconst_null
    //   849: astore 5
    //   851: goto -102 -> 749
    //   854: astore_3
    //   855: aconst_null
    //   856: astore 5
    //   858: aload_1
    //   859: astore 7
    //   861: aload_3
    //   862: astore_1
    //   863: aload 6
    //   865: astore_3
    //   866: aload 7
    //   868: astore 6
    //   870: goto -121 -> 749
    //   873: astore_1
    //   874: aload 10
    //   876: astore 6
    //   878: aload 9
    //   880: astore_3
    //   881: aload 8
    //   883: astore 5
    //   885: aload 7
    //   887: astore_0
    //   888: goto -139 -> 749
    //   891: astore_0
    //   892: goto -479 -> 413
    //   895: astore 5
    //   897: aconst_null
    //   898: astore_1
    //   899: aconst_null
    //   900: astore 6
    //   902: aconst_null
    //   903: astore_3
    //   904: aconst_null
    //   905: astore_0
    //   906: goto -557 -> 349
    //   909: astore 5
    //   911: aconst_null
    //   912: astore 6
    //   914: aconst_null
    //   915: astore_3
    //   916: aconst_null
    //   917: astore_0
    //   918: goto -569 -> 349
    //   921: astore 5
    //   923: aconst_null
    //   924: astore 6
    //   926: aconst_null
    //   927: astore_0
    //   928: aload_3
    //   929: astore_1
    //   930: aload_0
    //   931: astore_3
    //   932: aload 7
    //   934: astore_0
    //   935: goto -586 -> 349
    //   938: astore 5
    //   940: aconst_null
    //   941: astore 6
    //   943: aconst_null
    //   944: astore_3
    //   945: aconst_null
    //   946: astore_1
    //   947: goto -598 -> 349
    //   950: astore 5
    //   952: aconst_null
    //   953: astore_1
    //   954: aconst_null
    //   955: astore 6
    //   957: aconst_null
    //   958: astore_3
    //   959: goto -610 -> 349
    //   962: astore 5
    //   964: aconst_null
    //   965: astore 6
    //   967: aconst_null
    //   968: astore_3
    //   969: aconst_null
    //   970: astore_1
    //   971: goto -622 -> 349
    //   974: astore 5
    //   976: aconst_null
    //   977: astore_3
    //   978: goto -629 -> 349
    //   981: astore_1
    //   982: goto -357 -> 625
    //   985: astore 5
    //   987: goto -411 -> 576
    //   990: aconst_null
    //   991: astore_1
    //   992: goto -778 -> 214
    //   995: aload_1
    //   996: astore_0
    //   997: aload 7
    //   999: astore_1
    //   1000: goto -864 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1003	0	paramString1	String
    //   0	1003	1	paramString2	String
    //   0	1003	2	paramBoolean	boolean
    //   0	1003	3	paramDecryptListener	DecryptListener
    //   1	614	4	i	int
    //   35	302	5	localObject1	Object
    //   347	163	5	localException1	Exception
    //   544	340	5	localObject2	Object
    //   895	1	5	localException2	Exception
    //   909	1	5	localException3	Exception
    //   921	1	5	localException4	Exception
    //   938	1	5	localException5	Exception
    //   950	1	5	localException6	Exception
    //   962	1	5	localException7	Exception
    //   974	1	5	localException8	Exception
    //   985	1	5	localIOException	java.io.IOException
    //   4	962	6	localObject3	Object
    //   61	581	7	localObject4	Object
    //   791	13	7	localObject5	Object
    //   859	139	7	str1	String
    //   228	654	8	localObject6	Object
    //   282	597	9	localObject7	Object
    //   278	597	10	str2	String
    //   316	23	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   290	299	347	java/lang/Exception
    //   312	318	347	java/lang/Exception
    //   336	344	347	java/lang/Exception
    //   643	650	347	java/lang/Exception
    //   534	546	573	java/io/IOException
    //   550	557	573	java/io/IOException
    //   576	587	624	java/io/IOException
    //   596	602	624	java/io/IOException
    //   654	658	690	java/io/IOException
    //   663	668	690	java/io/IOException
    //   672	676	690	java/io/IOException
    //   683	687	690	java/io/IOException
    //   698	706	737	java/io/IOException
    //   710	718	737	java/io/IOException
    //   722	726	737	java/io/IOException
    //   730	734	737	java/io/IOException
    //   136	172	741	finally
    //   172	188	741	finally
    //   188	214	741	finally
    //   489	515	741	finally
    //   534	546	741	finally
    //   550	557	741	finally
    //   754	759	787	java/io/IOException
    //   763	767	787	java/io/IOException
    //   771	775	787	java/io/IOException
    //   780	785	787	java/io/IOException
    //   218	224	791	finally
    //   235	239	809	finally
    //   254	264	809	finally
    //   557	562	827	finally
    //   576	587	836	finally
    //   596	602	836	finally
    //   604	608	845	finally
    //   264	277	854	finally
    //   290	299	873	finally
    //   312	318	873	finally
    //   336	344	873	finally
    //   362	379	873	finally
    //   643	650	873	finally
    //   383	387	891	java/io/IOException
    //   392	397	891	java/io/IOException
    //   401	405	891	java/io/IOException
    //   409	413	891	java/io/IOException
    //   136	172	895	java/lang/Exception
    //   172	188	895	java/lang/Exception
    //   188	214	895	java/lang/Exception
    //   489	515	895	java/lang/Exception
    //   534	546	895	java/lang/Exception
    //   550	557	895	java/lang/Exception
    //   218	224	909	java/lang/Exception
    //   235	239	921	java/lang/Exception
    //   254	264	921	java/lang/Exception
    //   557	562	938	java/lang/Exception
    //   576	587	950	java/lang/Exception
    //   596	602	950	java/lang/Exception
    //   604	608	962	java/lang/Exception
    //   264	277	974	java/lang/Exception
    //   604	608	981	java/io/IOException
    //   557	562	985	java/io/IOException
  }
  
  /* Error */
  private static String readPexFile(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: ldc 31
    //   12: invokevirtual 2871	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifne +327 -> 342
    //   18: iconst_1
    //   19: istore_3
    //   20: aload_0
    //   21: invokestatic 188	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 6
    //   26: new 190	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   33: aload 6
    //   35: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1052
    //   41: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_0
    //   52: new 190	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   59: aload 6
    //   61: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 1052
    //   67: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 6
    //   79: new 197	java/io/File
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 5842	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore_1
    //   88: new 197	java/io/File
    //   91: dup
    //   92: aload 6
    //   94: invokespecial 5842	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore 8
    //   99: aload_1
    //   100: invokevirtual 5845	java/io/File:exists	()Z
    //   103: ifeq +10 -> 113
    //   106: aload_1
    //   107: invokevirtual 5848	java/io/File:isFile	()Z
    //   110: ifne +19 -> 129
    //   113: aload 8
    //   115: invokevirtual 5845	java/io/File:exists	()Z
    //   118: ifeq +280 -> 398
    //   121: aload 8
    //   123: invokevirtual 5848	java/io/File:isFile	()Z
    //   126: ifeq +272 -> 398
    //   129: aload_1
    //   130: invokevirtual 5845	java/io/File:exists	()Z
    //   133: ifeq +214 -> 347
    //   136: aload_1
    //   137: invokevirtual 5848	java/io/File:isFile	()Z
    //   140: ifeq +207 -> 347
    //   143: new 5850	java/io/FileInputStream
    //   146: dup
    //   147: aload_1
    //   148: invokespecial 5853	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   151: astore_0
    //   152: aload_0
    //   153: astore 7
    //   155: iload_3
    //   156: ifne +235 -> 391
    //   159: aload 7
    //   161: aload_2
    //   162: invokestatic 5742	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   165: astore_0
    //   166: aload 7
    //   168: invokestatic 5856	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   171: aload_0
    //   172: astore 6
    //   174: aload 6
    //   176: ifnull +405 -> 581
    //   179: new 5729	java/io/InputStreamReader
    //   182: dup
    //   183: aload 6
    //   185: invokespecial 5745	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   188: astore_2
    //   189: new 5727	java/io/BufferedReader
    //   192: dup
    //   193: aload_2
    //   194: sipush 1024
    //   197: invokespecial 5748	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   200: astore_0
    //   201: aload 7
    //   203: astore 11
    //   205: aload_2
    //   206: astore 10
    //   208: aload_0
    //   209: astore 9
    //   211: aload 6
    //   213: astore 8
    //   215: new 190	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 191	java/lang/StringBuilder:<init>	()V
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
    //   238: invokevirtual 5751	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   265: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   291: invokevirtual 5835	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: aload_1
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 5859	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   302: aload_0
    //   303: ifnull +7 -> 310
    //   306: aload_0
    //   307: invokevirtual 5862	java/io/BufferedReader:close	()V
    //   310: aload_2
    //   311: ifnull +7 -> 318
    //   314: aload_2
    //   315: invokevirtual 5863	java/io/InputStreamReader:close	()V
    //   318: aload 6
    //   320: ifnull +8 -> 328
    //   323: aload 6
    //   325: invokevirtual 5866	java/io/InputStream:close	()V
    //   328: aload 7
    //   330: ifnull +8 -> 338
    //   333: aload 7
    //   335: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   338: aconst_null
    //   339: astore_0
    //   340: aload_0
    //   341: areturn
    //   342: iconst_0
    //   343: istore_3
    //   344: goto -324 -> 20
    //   347: aload 8
    //   349: invokevirtual 5845	java/io/File:exists	()Z
    //   352: ifeq +598 -> 950
    //   355: aload 8
    //   357: invokevirtual 5848	java/io/File:isFile	()Z
    //   360: ifeq +590 -> 950
    //   363: new 5850	java/io/FileInputStream
    //   366: dup
    //   367: aload 8
    //   369: invokespecial 5853	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   372: astore_0
    //   373: iload_3
    //   374: ifne +12 -> 386
    //   377: iload 5
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
    //   398: invokestatic 2235	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   401: invokevirtual 5871	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   404: aload_0
    //   405: invokevirtual 5877	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   408: astore_1
    //   409: iload_3
    //   410: ifne +22 -> 432
    //   413: aload_1
    //   414: aload_2
    //   415: invokestatic 5742	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   418: astore_0
    //   419: aload_1
    //   420: invokestatic 5856	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
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
    //   440: invokestatic 2235	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   443: invokevirtual 5871	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   446: aload 6
    //   448: invokevirtual 5877	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   451: astore_1
    //   452: iload_3
    //   453: ifne +31 -> 484
    //   456: iload 4
    //   458: istore_3
    //   459: iload_3
    //   460: ifne +29 -> 489
    //   463: aload_1
    //   464: aload_2
    //   465: invokestatic 5742	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   468: astore_2
    //   469: aload_2
    //   470: astore_0
    //   471: aload_1
    //   472: invokestatic 5856	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
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
    //   519: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: astore_1
    //   523: aload_0
    //   524: ifnull +7 -> 531
    //   527: aload_0
    //   528: invokevirtual 5862	java/io/BufferedReader:close	()V
    //   531: aload_2
    //   532: ifnull +7 -> 539
    //   535: aload_2
    //   536: invokevirtual 5863	java/io/InputStreamReader:close	()V
    //   539: aload 6
    //   541: ifnull +8 -> 549
    //   544: aload 6
    //   546: invokevirtual 5866	java/io/InputStream:close	()V
    //   549: aload_1
    //   550: astore_0
    //   551: aload 7
    //   553: ifnull -213 -> 340
    //   556: aload 7
    //   558: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   561: aload_1
    //   562: areturn
    //   563: astore_0
    //   564: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   567: aload_0
    //   568: invokevirtual 5881	java/io/IOException:getMessage	()Ljava/lang/String;
    //   571: aload_0
    //   572: iconst_0
    //   573: anewarray 4	java/lang/Object
    //   576: invokestatic 5859	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   579: aload_1
    //   580: areturn
    //   581: iconst_0
    //   582: ifeq +11 -> 593
    //   585: new 5879	java/lang/NullPointerException
    //   588: dup
    //   589: invokespecial 5880	java/lang/NullPointerException:<init>	()V
    //   592: athrow
    //   593: iconst_0
    //   594: ifeq +11 -> 605
    //   597: new 5879	java/lang/NullPointerException
    //   600: dup
    //   601: invokespecial 5880	java/lang/NullPointerException:<init>	()V
    //   604: athrow
    //   605: aload 6
    //   607: ifnull +8 -> 615
    //   610: aload 6
    //   612: invokevirtual 5866	java/io/InputStream:close	()V
    //   615: aload 7
    //   617: ifnull -279 -> 338
    //   620: aload 7
    //   622: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   625: goto -287 -> 338
    //   628: astore_0
    //   629: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   632: aload_0
    //   633: invokevirtual 5881	java/io/IOException:getMessage	()Ljava/lang/String;
    //   636: aload_0
    //   637: iconst_0
    //   638: anewarray 4	java/lang/Object
    //   641: invokestatic 5859	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   644: goto -306 -> 338
    //   647: astore_0
    //   648: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   651: aload_0
    //   652: invokevirtual 5881	java/io/IOException:getMessage	()Ljava/lang/String;
    //   655: aload_0
    //   656: iconst_0
    //   657: anewarray 4	java/lang/Object
    //   660: invokestatic 5859	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   679: invokevirtual 5862	java/io/BufferedReader:close	()V
    //   682: aload_1
    //   683: ifnull +7 -> 690
    //   686: aload_1
    //   687: invokevirtual 5863	java/io/InputStreamReader:close	()V
    //   690: aload 6
    //   692: ifnull +8 -> 700
    //   695: aload 6
    //   697: invokevirtual 5866	java/io/InputStream:close	()V
    //   700: aload 7
    //   702: ifnull +8 -> 710
    //   705: aload 7
    //   707: invokevirtual 5867	java/io/FileInputStream:close	()V
    //   710: aload_0
    //   711: athrow
    //   712: astore_1
    //   713: getstatic 56	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   716: aload_1
    //   717: invokevirtual 5881	java/io/IOException:getMessage	()Ljava/lang/String;
    //   720: aload_1
    //   721: iconst_0
    //   722: anewarray 4	java/lang/Object
    //   725: invokestatic 5859	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   757: astore_1
    //   758: aconst_null
    //   759: astore_2
    //   760: aload_0
    //   761: astore 6
    //   763: aconst_null
    //   764: astore 8
    //   766: aload_1
    //   767: astore_0
    //   768: aload 8
    //   770: astore_1
    //   771: goto -97 -> 674
    //   774: astore 8
    //   776: aconst_null
    //   777: astore_1
    //   778: aload_0
    //   779: astore 6
    //   781: aconst_null
    //   782: astore_2
    //   783: aload 8
    //   785: astore_0
    //   786: goto -112 -> 674
    //   789: astore 8
    //   791: aconst_null
    //   792: astore_1
    //   793: aconst_null
    //   794: astore_2
    //   795: aload_0
    //   796: astore 6
    //   798: aload 8
    //   800: astore_0
    //   801: goto -127 -> 674
    //   804: astore_0
    //   805: aconst_null
    //   806: astore_1
    //   807: aconst_null
    //   808: astore_2
    //   809: goto -135 -> 674
    //   812: astore_0
    //   813: aconst_null
    //   814: astore 8
    //   816: aload_2
    //   817: astore_1
    //   818: aload 8
    //   820: astore_2
    //   821: goto -147 -> 674
    //   824: astore_0
    //   825: aload 11
    //   827: astore 7
    //   829: aload 10
    //   831: astore_1
    //   832: aload 9
    //   834: astore_2
    //   835: aload 8
    //   837: astore 6
    //   839: goto -165 -> 674
    //   842: astore_1
    //   843: aconst_null
    //   844: astore 7
    //   846: aconst_null
    //   847: astore_2
    //   848: aconst_null
    //   849: astore_0
    //   850: aconst_null
    //   851: astore 6
    //   853: goto -580 -> 273
    //   856: astore_1
    //   857: aconst_null
    //   858: astore_2
    //   859: aconst_null
    //   860: astore_0
    //   861: aconst_null
    //   862: astore 6
    //   864: goto -591 -> 273
    //   867: astore_1
    //   868: aconst_null
    //   869: astore_2
    //   870: aload_0
    //   871: astore 6
    //   873: aconst_null
    //   874: astore_0
    //   875: goto -602 -> 273
    //   878: astore_1
    //   879: aconst_null
    //   880: astore 7
    //   882: aconst_null
    //   883: astore 8
    //   885: aload_0
    //   886: astore 6
    //   888: aconst_null
    //   889: astore_2
    //   890: aload 8
    //   892: astore_0
    //   893: goto -620 -> 273
    //   896: astore_1
    //   897: aconst_null
    //   898: astore 7
    //   900: aconst_null
    //   901: astore_2
    //   902: aload_0
    //   903: astore 6
    //   905: aconst_null
    //   906: astore_0
    //   907: goto -634 -> 273
    //   910: astore_1
    //   911: aconst_null
    //   912: astore_2
    //   913: aconst_null
    //   914: astore 8
    //   916: aload_0
    //   917: astore 6
    //   919: aconst_null
    //   920: astore 7
    //   922: aload 8
    //   924: astore_0
    //   925: goto -652 -> 273
    //   928: astore_1
    //   929: aconst_null
    //   930: astore_2
    //   931: aconst_null
    //   932: astore_0
    //   933: goto -660 -> 273
    //   936: astore_1
    //   937: aconst_null
    //   938: astore_0
    //   939: goto -666 -> 273
    //   942: astore_1
    //   943: goto -448 -> 495
    //   946: astore_1
    //   947: goto -507 -> 440
    //   950: aconst_null
    //   951: astore 7
    //   953: goto -798 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	956	0	paramString1	String
    //   0	956	1	paramString2	String
    //   0	956	2	paramDecryptListener	DecryptListener
    //   19	467	3	i	int
    //   1	456	4	j	int
    //   4	374	5	k	int
    //   24	894	6	localObject1	Object
    //   7	945	7	localObject2	Object
    //   97	420	8	localObject3	Object
    //   742	10	8	localObject4	Object
    //   764	5	8	localObject5	Object
    //   774	10	8	localObject6	Object
    //   789	10	8	localObject7	Object
    //   814	109	8	localObject8	Object
    //   209	624	9	str1	String
    //   206	624	10	localDecryptListener	DecryptListener
    //   203	623	11	localObject9	Object
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
    //   440	452	774	finally
    //   463	469	774	finally
    //   471	475	789	finally
    //   179	189	804	finally
    //   189	201	812	finally
    //   215	223	824	finally
    //   237	243	824	finally
    //   262	269	824	finally
    //   287	302	824	finally
    //   518	523	824	finally
    //   79	113	842	java/lang/Exception
    //   113	129	842	java/lang/Exception
    //   129	152	842	java/lang/Exception
    //   347	373	842	java/lang/Exception
    //   398	409	842	java/lang/Exception
    //   413	419	842	java/lang/Exception
    //   159	166	856	java/lang/Exception
    //   166	171	867	java/lang/Exception
    //   419	423	878	java/lang/Exception
    //   440	452	896	java/lang/Exception
    //   463	469	896	java/lang/Exception
    //   471	475	910	java/lang/Exception
    //   179	189	928	java/lang/Exception
    //   189	201	936	java/lang/Exception
    //   471	475	942	java/io/IOException
    //   419	423	946	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoTemplateParser
 * JD-Core Version:    0.7.0.1
 */