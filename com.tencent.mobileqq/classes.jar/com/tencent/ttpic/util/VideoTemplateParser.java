package com.tencent.ttpic.util;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.ExpressionItem;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.ImageWMElement;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.model.TextWMElement;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.model.VideoMaterial.FaceImageLayer;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.model.WMElement.WMType;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.ttpic.model.WMLogic;
import com.tencent.ttpic.model.WMLogicPair;
import com.tencent.util.IOUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class VideoTemplateParser
{
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  
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
  
  private static InputStream drinkACupOfCoffee(InputStream paramInputStream, DecryptListener paramDecryptListener)
    throws IOException
  {
    byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (paramDecryptListener != null) {
      paramInputStream = paramDecryptListener.decrypt(arrayOfByte);
    }
    return new ByteArrayInputStream(paramInputStream);
  }
  
  private static void parseFabbyMvItems(String paramString, JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    Object localObject1 = paramJSONObject.optString("mvTemplateFile");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      do
      {
        return;
        i = ((String)localObject1).lastIndexOf(".");
        paramJSONObject = (JSONObject)localObject1;
        if (i >= 0) {
          paramJSONObject = ((String)localObject1).substring(0, i);
        }
        paramDecryptListener = parseVideoMaterialFile(paramString, paramJSONObject, true, paramDecryptListener);
      } while (paramDecryptListener == null);
      localObject1 = paramDecryptListener.optJSONArray("parts");
    } while (localObject1 == null);
    boolean bool = false;
    if (((JSONArray)localObject1).length() == 1) {
      bool = true;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      FabbyMvPart localFabbyMvPart = new FabbyMvPart();
      JSONObject localJSONObject = ((JSONArray)localObject1).optJSONObject(i);
      if (localJSONObject == null)
      {
        i += 1;
      }
      else
      {
        double d = localJSONObject.optDouble("duration");
        Object localObject2 = localJSONObject.optJSONObject("background");
        Object localObject3;
        int j;
        if (localObject2 != null)
        {
          localObject3 = new StickerItem();
          paramString = ((JSONObject)localObject2).optString("videoFile");
          paramJSONObject = ((JSONObject)localObject2).optString("imageName");
          if ((!TextUtils.isEmpty(paramString)) || (!TextUtils.isEmpty(paramJSONObject)))
          {
            j = 0;
            if (TextUtils.isEmpty(paramString)) {
              break label1041;
            }
            j = paramString.lastIndexOf("/");
            ((StickerItem)localObject3).id = paramString.substring(j + 1, paramString.length());
            ((StickerItem)localObject3).subFolder = paramString.substring(0, j);
            j = 1;
            ((StickerItem)localObject3).type = 1;
            ((StickerItem)localObject3).alwaysTriggered = true;
            ((StickerItem)localObject3).frames = ((JSONObject)localObject2).optInt("imageCount", 1);
            ((StickerItem)localObject3).frameDuration = (((JSONObject)localObject2).optDouble("imageDuration", d) / ((StickerItem)localObject3).frames * 1000.0D);
            ((StickerItem)localObject3).aspectMode = ((JSONObject)localObject2).optInt("aspectMode", 0);
            ((StickerItem)localObject3).blendMode = ((JSONObject)localObject2).optInt("blendMode", 0);
            ((StickerItem)localObject3).width = ((JSONObject)localObject2).optInt("width", 720);
            ((StickerItem)localObject3).height = ((JSONObject)localObject2).optInt("height", 1280);
            ((StickerItem)localObject3).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject3).isFabbyMvItem = true;
            ((StickerItem)localObject3).fabbyTotalParts = ((JSONArray)localObject1).length();
            ((StickerItem)localObject3).fabbyPart = i;
            if (j == 0) {
              break label1105;
            }
            ((StickerItem)localObject3).sourceType = VideoMaterialUtil.getItemSourceType(((JSONObject)localObject2).optInt(VideoMaterialUtil.FIELD.VIDEO_ALPHA_TYPE.value));
            label418:
            localFabbyMvPart.bgItem = ((StickerItem)localObject3);
          }
        }
        localObject2 = localJSONObject.optJSONObject("foreground");
        if (localObject2 != null)
        {
          localObject3 = new StickerItem();
          paramString = ((JSONObject)localObject2).optString("videoFile");
          paramJSONObject = ((JSONObject)localObject2).optString("imageName");
          if ((!TextUtils.isEmpty(paramString)) || (!TextUtils.isEmpty(paramJSONObject)))
          {
            j = 0;
            if (TextUtils.isEmpty(paramString)) {
              break label1116;
            }
            j = paramString.lastIndexOf("/");
            ((StickerItem)localObject3).id = paramString.substring(j + 1, paramString.length());
            ((StickerItem)localObject3).subFolder = paramString.substring(0, j);
            j = 1;
            label529:
            ((StickerItem)localObject3).type = 1;
            ((StickerItem)localObject3).alwaysTriggered = true;
            ((StickerItem)localObject3).frames = ((JSONObject)localObject2).optInt("imageCount", 1);
            ((StickerItem)localObject3).frameDuration = (((JSONObject)localObject2).optDouble("imageDuration", d) / ((StickerItem)localObject3).frames * 1000.0D);
            ((StickerItem)localObject3).aspectMode = ((JSONObject)localObject2).optInt("aspectMode", 0);
            ((StickerItem)localObject3).blendMode = ((JSONObject)localObject2).optInt("blendMode", 0);
            ((StickerItem)localObject3).width = ((JSONObject)localObject2).optInt("width", 720);
            ((StickerItem)localObject3).height = ((JSONObject)localObject2).optInt("height", 1280);
            ((StickerItem)localObject3).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject3).isFabbyMvItem = true;
            ((StickerItem)localObject3).fabbyTotalParts = ((JSONArray)localObject1).length();
            ((StickerItem)localObject3).fabbyPart = i;
            if (j == 0) {
              break label1180;
            }
          }
        }
        label1041:
        int k;
        label1180:
        for (((StickerItem)localObject3).sourceType = VideoMaterialUtil.getItemSourceType(((JSONObject)localObject2).optInt(VideoMaterialUtil.FIELD.VIDEO_ALPHA_TYPE.value));; ((StickerItem)localObject3).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
        {
          localFabbyMvPart.fgItem = ((StickerItem)localObject3);
          localObject2 = localJSONObject.optJSONObject("cover");
          if (localObject2 != null)
          {
            localObject3 = new StickerItem();
            paramJSONObject = ((JSONObject)localObject2).optString("imageFile");
            if (!TextUtils.isEmpty(paramJSONObject))
            {
              paramString = paramJSONObject;
              if (paramJSONObject.endsWith("_")) {
                paramString = paramJSONObject.substring(0, paramJSONObject.length() - 1);
              }
              j = paramString.lastIndexOf("/");
              ((StickerItem)localObject3).id = paramString.substring(j + 1, paramString.lastIndexOf("_"));
              ((StickerItem)localObject3).subFolder = paramString.substring(0, j);
              ((StickerItem)localObject3).type = 1;
              ((StickerItem)localObject3).alwaysTriggered = true;
              ((StickerItem)localObject3).frames = 1;
              ((StickerItem)localObject3).frameDuration = (1000.0D * d);
              ((StickerItem)localObject3).aspectMode = ((JSONObject)localObject2).optInt("aspectMode", 0);
              ((StickerItem)localObject3).blendMode = ((JSONObject)localObject2).optInt("blendMode", 0);
              ((StickerItem)localObject3).width = ((JSONObject)localObject2).optInt("width", 720);
              ((StickerItem)localObject3).height = ((JSONObject)localObject2).optInt("height", 1280);
              ((StickerItem)localObject3).position = new double[] { 0.0D, 0.0D };
              ((StickerItem)localObject3).isFabbyMvItem = true;
              ((StickerItem)localObject3).fabbyTotalParts = ((JSONArray)localObject1).length();
              ((StickerItem)localObject3).fabbyPart = i;
              localFabbyMvPart.coverItem = ((StickerItem)localObject3);
            }
          }
          paramString = localJSONObject.optJSONObject("cameraFrame");
          if (paramString == null) {
            break label1413;
          }
          localFabbyMvPart.easeCurve = paramString.optInt("easeCurve", 0);
          localFabbyMvPart.scaleMap.clear();
          paramJSONObject = paramString.optJSONObject("scale");
          if (paramJSONObject == null) {
            break label1191;
          }
          localObject2 = paramJSONObject.keys();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localFabbyMvPart.scaleMap.put(Float.valueOf((String)localObject3), Double.valueOf(paramJSONObject.optDouble((String)localObject3, 1.0D)));
          }
          paramString = paramJSONObject;
          if (paramJSONObject.endsWith("_")) {
            paramString = paramJSONObject.substring(0, paramJSONObject.length() - 1);
          }
          k = paramString.lastIndexOf("/");
          ((StickerItem)localObject3).id = paramString.substring(k + 1, paramString.length());
          ((StickerItem)localObject3).subFolder = paramString.substring(0, k);
          break;
          label1105:
          ((StickerItem)localObject3).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
          break label418;
          label1116:
          paramString = paramJSONObject;
          if (paramJSONObject.endsWith("_")) {
            paramString = paramJSONObject.substring(0, paramJSONObject.length() - 1);
          }
          k = paramString.lastIndexOf("/");
          ((StickerItem)localObject3).id = paramString.substring(k + 1, paramString.length());
          ((StickerItem)localObject3).subFolder = paramString.substring(0, k);
          break label529;
        }
        label1191:
        localFabbyMvPart.degreeMap.clear();
        paramJSONObject = paramString.optJSONObject("rotate");
        if (paramJSONObject != null)
        {
          localObject2 = paramJSONObject.keys();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localFabbyMvPart.degreeMap.put(Float.valueOf((String)localObject3), Double.valueOf(paramJSONObject.optDouble((String)localObject3, 0.0D)));
          }
        }
        localFabbyMvPart.gridTypeMap.clear();
        paramJSONObject = paramString.optJSONObject("gridType");
        if (paramJSONObject != null)
        {
          localObject2 = paramJSONObject.keys();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localFabbyMvPart.gridTypeMap.put(Float.valueOf((String)localObject3), Integer.valueOf(paramJSONObject.optInt((String)localObject3, 0)));
          }
        }
        localFabbyMvPart.gridModeMap.clear();
        paramString = paramString.optJSONObject("gridMode");
        if (paramString != null)
        {
          paramJSONObject = paramString.keys();
          while (paramJSONObject.hasNext())
          {
            localObject2 = (String)paramJSONObject.next();
            localFabbyMvPart.gridModeMap.put(Float.valueOf((String)localObject2), Integer.valueOf(paramString.optInt((String)localObject2, 0)));
          }
        }
        label1413:
        localObject2 = localJSONObject.optJSONObject("finishTransition");
        if (localObject2 != null)
        {
          localObject3 = new StickerItem();
          paramString = ((JSONObject)localObject2).optString("maskVideoFile");
          paramJSONObject = ((JSONObject)localObject2).optString("maskImageName");
          j = ((JSONObject)localObject2).optInt("transitionFunction", 0);
          if (j == 0)
          {
            if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(paramJSONObject))) {
              break label1891;
            }
            if (TextUtils.isEmpty(paramString)) {
              break label1827;
            }
            k = paramString.lastIndexOf("/");
            ((StickerItem)localObject3).id = paramString.substring(k + 1, paramString.length());
            ((StickerItem)localObject3).subFolder = paramString.substring(0, k);
          }
        }
        for (;;)
        {
          ((StickerItem)localObject3).frames = ((JSONObject)localObject2).optInt("maskImageCount", 1);
          ((StickerItem)localObject3).frameDuration = (((JSONObject)localObject2).optDouble("maskImageDuration", 0.0D) / ((StickerItem)localObject3).frames * 1000.0D);
          ((StickerItem)localObject3).triggerType = ((JSONObject)localObject2).optInt("triggerType", 0);
          if ((((StickerItem)localObject3).triggerType == 1) && (paramVideoMaterial.getItemList() != null) && (paramVideoMaterial.getItemList().size() != 0)) {
            ((StickerItem)localObject3).triggerType = ((StickerItem)paramVideoMaterial.getItemList().get(paramVideoMaterial.getItemList().size() - 1)).triggerType;
          }
          localFabbyMvPart.transitionItem = ((StickerItem)localObject3);
          localFabbyMvPart.transitionDuration = ((((JSONObject)localObject2).optDouble("duration", 0.0D) * 1000.0D));
          localFabbyMvPart.transitionEase = ((JSONObject)localObject2).optInt("easeCurve", 0);
          localFabbyMvPart.transitionMaskType = ((JSONObject)localObject2).optInt("maskType", 1);
          localFabbyMvPart.transitionFunction = j;
          paramString = localJSONObject.optJSONObject("filterEffect");
          if (paramString != null)
          {
            localFabbyMvPart.filterType = paramString.optInt("type", 0);
            localFabbyMvPart.fid = paramString.optInt("fid");
            localFabbyMvPart.lutFile = paramString.optString("lutFile");
          }
          localFabbyMvPart.duration = ((1000.0D * d));
          localFabbyMvPart.partIndex = i;
          localArrayList.add(localFabbyMvPart);
          if (i != 0) {
            break;
          }
          localFabbyMvPart.audio = paramDecryptListener.optString("bgmAudio", "");
          if (!TextUtils.isEmpty(localFabbyMvPart.audio)) {
            paramVideoMaterial.setHasAudio(true);
          }
          localFabbyMvPart.singlePart = bool;
          break;
          label1827:
          paramString = paramJSONObject;
          if (paramJSONObject.endsWith("_")) {
            paramString = paramJSONObject.substring(0, paramJSONObject.length() - 1);
          }
          k = paramString.lastIndexOf("/");
          ((StickerItem)localObject3).id = paramString.substring(k + 1, paramString.length());
          ((StickerItem)localObject3).subFolder = paramString.substring(0, k);
          continue;
          label1891:
          ((StickerItem)localObject3).id = "";
          ((StickerItem)localObject3).subFolder = "";
        }
      }
    }
    paramVideoMaterial.setFabbyMvParts(localArrayList);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(null, parseVideoMaterialString(paramString, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener);
  }
  
  private static VideoMaterial parseVideoMaterial(String paramString, JSONObject paramJSONObject, DecryptListener paramDecryptListener)
  {
    VideoMaterial localVideoMaterial = new VideoMaterial();
    localVideoMaterial.setDataPath(paramString);
    if (paramJSONObject == null) {
      return localVideoMaterial;
    }
    boolean bool1;
    label298:
    Object localObject1;
    Object localObject2;
    int i;
    boolean bool2;
    Object localObject3;
    int j;
    int k;
    label509:
    Object localObject4;
    Object localObject5;
    label832:
    int m;
    label1075:
    Object localObject6;
    label1595:
    Object localObject7;
    label1937:
    label1962:
    label2240:
    Object localObject9;
    Object localObject10;
    String str1;
    for (;;)
    {
      try
      {
        localVideoMaterial.setId(VideoMaterialUtil.getMaterialId(paramString));
        localVideoMaterial.setMinAppVersion(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
        localVideoMaterial.setShaderType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.SHADER_TYPE.value));
        localVideoMaterial.setFaceoffType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_OFF_TYPE.value));
        localVideoMaterial.setFaceSwapType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_SWAP_TYPE.value));
        localVideoMaterial.setMaxFaceCount(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
        localVideoMaterial.setFaceExchangeImage(paramJSONObject.optString(VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
        localVideoMaterial.setImageFacePointsFileName(paramJSONObject.optString(VideoMaterialUtil.FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
        localVideoMaterial.setBlendAlpha(paramJSONObject.optDouble(VideoMaterialUtil.FIELD.BLEND_ALPHA.value));
        localVideoMaterial.setGrayScale(paramJSONObject.optInt(VideoMaterialUtil.FIELD.GRAY_SCALE.value));
        localVideoMaterial.setOrderMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.ORDER_MODE.value));
        localVideoMaterial.setBlendMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.BLEND_MODE.value));
        localVideoMaterial.setFeatureType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FEATURE_TYPE.value));
        localVideoMaterial.setFilterId(paramJSONObject.optString(VideoMaterialUtil.FIELD.FILTER_ID.value));
        localVideoMaterial.setArParticleType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.AR_PARTICLE_TYPE.value));
        if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.SUPPORT_LANDSCAPE.value, 1) != 1) {
          break label6721;
        }
        bool1 = true;
        localVideoMaterial.setSupportLandscape(bool1);
        localVideoMaterial.setTipsText(paramJSONObject.optString(VideoMaterialUtil.FIELD.TIPS_TEXT.value));
        if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.USE_MESH.value, 0) == 0) {
          break label6727;
        }
        bool1 = true;
        localVideoMaterial.setUseMesh(bool1);
        localVideoMaterial.setAdIcon(paramString + File.separator + paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_ICON.value));
        localVideoMaterial.setAdLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_LINK.value));
        localVideoMaterial.setAdAppLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_APP_LINK.value));
        localVideoMaterial.setWeiboTag(paramJSONObject.optString("weiboTag"));
        localVideoMaterial.setDetectorFlag(paramJSONObject.optInt(VideoMaterialUtil.FIELD.DETECTOR_FLAG.value));
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.RESOURCE_LIST.value);
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            ((List)localObject1).add(((JSONArray)localObject2).optString(i));
            i += 1;
            continue;
          }
          localVideoMaterial.setResourceList((List)localObject1);
        }
        bool1 = false;
        bool2 = false;
        localObject2 = new ArrayList();
        localObject3 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.ITEM_LIST.value);
        if (localObject3 == null) {
          break label2779;
        }
        j = -1;
        k = 0;
        i = 0;
        bool1 = bool2;
        if (i >= ((JSONArray)localObject3).length()) {
          break label2724;
        }
        localObject1 = ((JSONArray)localObject3).getJSONObject(i);
        localObject4 = new StickerItem();
        ((StickerItem)localObject4).id = ((JSONObject)localObject1).optString("id");
        ((StickerItem)localObject4).subFolder = ((StickerItem)localObject4).id;
        ((StickerItem)localObject4).name = ((JSONObject)localObject1).optString("name");
        ((StickerItem)localObject4).type = ((JSONObject)localObject1).optInt("type");
        ((StickerItem)localObject4).personID = ((JSONObject)localObject1).optInt("personID", -1);
        ((StickerItem)localObject4).featureStatType = ((JSONObject)localObject1).optInt("featureStatType");
        ((StickerItem)localObject4).frameType = ((JSONObject)localObject1).optInt("frameType");
        ((StickerItem)localObject4).blendMode = ((JSONObject)localObject1).optInt("blendMode", -1);
        localObject5 = ((JSONObject)localObject1).optJSONObject("featureStatValueRange");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).featureStatValueRange = new StickerItem.FeatureStatValueRange();
          ((StickerItem)localObject4).featureStatValueRange.min = ((JSONObject)localObject5).optDouble("min");
          ((StickerItem)localObject4).featureStatValueRange.max = ((JSONObject)localObject5).optDouble("max");
        }
        localObject5 = ((JSONObject)localObject1).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).charmRange = new CharmRange();
          ((StickerItem)localObject4).charmRange.min = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
          ((StickerItem)localObject4).charmRange.max = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
        }
        if (((StickerItem)localObject4).blendMode == -1) {
          ((StickerItem)localObject4).blendMode = localVideoMaterial.getBlendMode();
        }
        ((StickerItem)localObject4).triggerType = ((JSONObject)localObject1).optInt("triggerType");
        if (VideoMaterialUtil.isActionTriggerType(((StickerItem)localObject4).triggerType)) {
          localVideoMaterial.setTriggerType(((StickerItem)localObject4).triggerType);
        }
        if (((JSONObject)localObject1).optInt("alwaysTriggered") != 1) {
          break label6733;
        }
        bool2 = true;
        ((StickerItem)localObject4).alwaysTriggered = bool2;
        ((StickerItem)localObject4).playCount = ((JSONObject)localObject1).optInt("playCount");
        ((StickerItem)localObject4).frameDuration = ((JSONObject)localObject1).optDouble("frameDuration");
        ((StickerItem)localObject4).stickerType = ((JSONObject)localObject1).optInt("stickerType");
        ((StickerItem)localObject4).frames = ((JSONObject)localObject1).optInt("frames");
        ((StickerItem)localObject4).width = ((JSONObject)localObject1).optInt("width");
        ((StickerItem)localObject4).height = ((JSONObject)localObject1).optInt("height");
        ((StickerItem)localObject4).support3D = ((JSONObject)localObject1).optInt("enable3D", 1);
        localObject5 = ((JSONObject)localObject1).optJSONArray("position");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).position = new double[((JSONArray)localObject5).length()];
          m = 0;
          if (m < ((JSONArray)localObject5).length())
          {
            ((StickerItem)localObject4).position[m] = ((JSONArray)localObject5).getDouble(m);
            m += 1;
            continue;
          }
        }
        else
        {
          ((StickerItem)localObject4).position = new double[] { 0.0D, 0.0D };
        }
        ((StickerItem)localObject4).audio = ((JSONObject)localObject1).optString("audio");
        bool2 = bool1;
        if (!TextUtils.isEmpty(((StickerItem)localObject4).audio))
        {
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramString))
          {
            if (paramString.startsWith("assets://camera/camera_video/video_")) {
              break label6739;
            }
            bool2 = bool1;
            if (paramString.contains("/files/olm/camera/video_")) {
              break label6739;
            }
          }
        }
        localObject5 = ((JSONObject)localObject1).optJSONArray("anchorPoint");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).anchorPoint = new int[((JSONArray)localObject5).length()];
          m = 0;
          if (m < ((JSONArray)localObject5).length())
          {
            ((StickerItem)localObject4).anchorPoint[m] = ((JSONArray)localObject5).getInt(m);
            m += 1;
            continue;
          }
        }
        localObject5 = ((JSONObject)localObject1).optJSONArray("alignFacePoints");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).alignFacePoints = new int[((JSONArray)localObject5).length()];
          m = 0;
          if (m < ((JSONArray)localObject5).length())
          {
            ((StickerItem)localObject4).alignFacePoints[m] = ((JSONArray)localObject5).getInt(m);
            m += 1;
            continue;
          }
        }
        localObject5 = ((JSONObject)localObject1).optJSONArray("scalePivots");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).scalePivots = new int[((JSONArray)localObject5).length()];
          m = 0;
          if (m < ((JSONArray)localObject5).length())
          {
            ((StickerItem)localObject4).scalePivots[m] = ((JSONArray)localObject5).getInt(m);
            m += 1;
            continue;
          }
        }
        ((StickerItem)localObject4).scaleFactor = ((JSONObject)localObject1).optInt("scaleFactor");
        ((StickerItem)localObject4).markMode = ((JSONObject)localObject1).optInt("markMode");
        ((StickerItem)localObject4).activateTriggerCount = ((JSONObject)localObject1).optInt("activateTriggerCount", 0);
        ((StickerItem)localObject4).activateTriggerTotalCount = ((JSONObject)localObject1).optInt("activateTriggerTotalCount", 0);
        localObject5 = ((JSONObject)localObject1).optJSONObject("ageRange");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).ageRange = new AgeRange();
          ((StickerItem)localObject4).ageRange.min = ((float)((JSONObject)localObject5).optDouble("min"));
          ((StickerItem)localObject4).ageRange.max = ((float)((JSONObject)localObject5).optDouble("max"));
        }
        localObject5 = ((JSONObject)localObject1).optJSONObject("genderRange");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).genderRange = new GenderRange();
          ((StickerItem)localObject4).genderRange.min = ((float)((JSONObject)localObject5).optDouble("min"));
          ((StickerItem)localObject4).genderRange.max = ((float)((JSONObject)localObject5).optDouble("max"));
        }
        localObject5 = ((JSONObject)localObject1).optJSONObject("popularRange");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).popularRange = new PopularRange();
          ((StickerItem)localObject4).popularRange.min = ((float)((JSONObject)localObject5).optDouble("min"));
          ((StickerItem)localObject4).popularRange.max = ((float)((JSONObject)localObject5).optDouble("max"));
        }
        localObject5 = ((JSONObject)localObject1).optJSONObject("cpRange");
        if (localObject5 != null)
        {
          ((StickerItem)localObject4).cpRange = new CpRange();
          ((StickerItem)localObject4).cpRange.min = ((float)((JSONObject)localObject5).optDouble("min"));
          ((StickerItem)localObject4).cpRange.max = ((float)((JSONObject)localObject5).optDouble("max"));
        }
        localObject5 = ((JSONObject)localObject1).optJSONArray(VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
        if (localObject5 == null) {
          break label2683;
        }
        localObject6 = new WMGroup();
        m = 0;
        if (m >= ((JSONArray)localObject5).length()) {
          break label2676;
        }
        localObject7 = ((JSONArray)localObject5).optJSONObject(m);
        if (localObject7 == null) {
          break label6763;
        }
        int n = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
        if (n != WMElement.WMType.TEXT.value) {
          break label2498;
        }
        localObject1 = new TextWMElement();
        ((WMElement)localObject1).sid = localVideoMaterial.getId();
        ((WMElement)localObject1).id = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
        ((WMElement)localObject1).relativeID = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
        localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
        if ((localObject8 == null) || (((JSONArray)localObject8).length() != 2)) {
          break label2510;
        }
        ((WMElement)localObject1).relativeAnchor = new PointF((float)((JSONArray)localObject8).getDouble(0), (float)((JSONArray)localObject8).getDouble(1));
        localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
        if ((localObject8 == null) || (((JSONArray)localObject8).length() != 2)) {
          break label2527;
        }
        ((WMElement)localObject1).anchor = new PointF((float)((JSONArray)localObject8).getDouble(0), (float)((JSONArray)localObject8).getDouble(1));
        ((WMElement)localObject1).offsetX = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETX.value);
        ((WMElement)localObject1).offsetY = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETY.value);
        ((WMElement)localObject1).width = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WIDTH.value);
        ((WMElement)localObject1).height = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.HEIGHT.value);
        ((WMElement)localObject1).wmtype = n;
        ((WMElement)localObject1).edittype = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.EDITTYPE.value);
        ((WMElement)localObject1).fmtstr = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FMTSTR.value);
        ((WMElement)localObject1).fontName = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_NAME.value);
        if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_BOLD.value) != 1) {
          break label6745;
        }
        bool1 = true;
        ((WMElement)localObject1).fontBold = bool1;
        if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
          break label6751;
        }
        bool1 = true;
        ((WMElement)localObject1).fontItalics = bool1;
        ((WMElement)localObject1).fontTexture = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_TEXTURE.value);
        ((WMElement)localObject1).fontSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_SIZE.value, -1.0D));
        ((WMElement)localObject1).fontFit = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_FIT.value);
        ((WMElement)localObject1).imgPath = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.IMG_PATH.value);
        ((WMElement)localObject1).frameDuration = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAME_DURATION.value);
        ((WMElement)localObject1).frames = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAMES.value);
        ((WMElement)localObject1).color = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
        ((WMElement)localObject1).strokeColor = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
        ((WMElement)localObject1).strokeSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0D));
        ((WMElement)localObject1).shadowColor = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
        ((WMElement)localObject1).shadowSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0D));
        ((WMElement)localObject1).shadowDx = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DX.value, -1.0D));
        ((WMElement)localObject1).shadowDy = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DY.value, -1.0D));
        ((WMElement)localObject1).alignment = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ALIGNMENT.value);
        if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.VERTICAL.value) != 1) {
          break label6757;
        }
        bool1 = true;
        ((WMElement)localObject1).vertical = bool1;
        ((WMElement)localObject1).rotate = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.ROTATE.value);
        ((WMElement)localObject1).animateType = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
        localObject8 = ((JSONObject)localObject7).optJSONObject(VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
        if (localObject8 == null) {
          break label2660;
        }
        localObject7 = new WMLogic();
        ((WMLogic)localObject7).type = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
        ((WMLogic)localObject7).setCompare(((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), ((WMElement)localObject1).sid);
        ((WMLogic)localObject7).data = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
        localObject9 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
        if (localObject9 == null) {
          break label2552;
        }
        ((WMLogic)localObject7).range = new ArrayList();
        localObject10 = ((JSONObject)localObject9).keys();
        if (!((Iterator)localObject10).hasNext()) {
          break;
        }
        str1 = (String)((Iterator)localObject10).next();
        String str2 = ((JSONObject)localObject9).optString(str1);
        ((WMLogic)localObject7).range.add(new WMLogicPair(str1, str2));
        continue;
        VideoMaterialUtil.updateSupportLandscape(localVideoMaterial);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      VideoMaterialUtil.updateMaxFaceCount(localVideoMaterial);
      VideoMaterialUtil.updateFaceValueDetectType(localVideoMaterial);
      VideoMaterialUtil.updateItemImageType(localVideoMaterial);
      VideoMaterialUtil.updateWatermarkInfo(localVideoMaterial);
      try
      {
        checkValid(localVideoMaterial);
        return localVideoMaterial;
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        return localVideoMaterial;
      }
      label2498:
      localObject1 = new ImageWMElement();
      continue;
      label2510:
      ((WMElement)localObject1).relativeAnchor = new PointF(0.0F, 0.0F);
      continue;
      label2527:
      ((WMElement)localObject1).anchor = new PointF(0.0F, 0.0F);
    }
    Collections.sort(((WMLogic)localObject7).range);
    label2552:
    Object localObject8 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
    if (localObject8 != null)
    {
      ((WMLogic)localObject7).wmcase = new ArrayList();
      localObject9 = ((JSONObject)localObject8).keys();
      while (((Iterator)localObject9).hasNext())
      {
        localObject10 = (String)((Iterator)localObject9).next();
        str1 = ((JSONObject)localObject8).optString((String)localObject10);
        ((WMLogic)localObject7).wmcase.add(new WMLogicPair((String)localObject10, str1));
      }
      Collections.sort(((WMLogic)localObject7).wmcase);
    }
    ((WMElement)localObject1).logic = ((WMLogic)localObject7);
    label2660:
    ((WMGroup)localObject6).wmElements.add(localObject1);
    break label6763;
    label2676:
    ((StickerItem)localObject4).wmGroup = ((WMGroup)localObject6);
    label2683:
    ((List)localObject2).add(localObject4);
    if (j == -1)
    {
      j = ((StickerItem)localObject4).triggerType;
    }
    else
    {
      k = Math.max(k, ((StickerItem)localObject4).triggerType);
      break label6772;
      label2724:
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject1).next();
        ((StickerItem)localObject3).preTriggerType = j;
        ((StickerItem)localObject3).countTriggerType = k;
      }
      localVideoMaterial.setItemList((List)localObject2);
      label2779:
      localObject1 = new ArrayList();
      localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_HEAD_CROP_ITEM_LIST.value);
      if (localObject2 != null)
      {
        j = -1;
        k = 0;
        i = 0;
        label2813:
        if (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new StickerItem();
          ((StickerItem)localObject4).id = ((JSONObject)localObject3).optString("id");
          ((StickerItem)localObject4).subFolder = ((StickerItem)localObject4).id;
          ((StickerItem)localObject4).type = ((JSONObject)localObject3).optInt("type");
          ((StickerItem)localObject4).triggerType = ((JSONObject)localObject3).optInt("triggerType");
          if (((JSONObject)localObject3).optInt("alwaysTriggered") != 1) {
            break label6783;
          }
          bool2 = true;
          ((StickerItem)localObject4).alwaysTriggered = bool2;
          ((StickerItem)localObject4).featureStatType = ((JSONObject)localObject3).optInt("featureStatType");
          ((StickerItem)localObject4).playCount = ((JSONObject)localObject3).optInt("playCount");
          if (VideoMaterialUtil.isActionTriggerType(((StickerItem)localObject4).triggerType)) {
            localVideoMaterial.setTriggerType(((StickerItem)localObject4).triggerType);
          }
          ((StickerItem)localObject4).frameType = ((JSONObject)localObject3).optInt("frameType");
          ((StickerItem)localObject4).frameDuration = ((JSONObject)localObject3).optDouble("frameDuration");
          ((StickerItem)localObject4).frames = ((JSONObject)localObject3).optInt("frames");
          ((StickerItem)localObject4).width = ((JSONObject)localObject3).optInt("width");
          ((StickerItem)localObject4).height = ((JSONObject)localObject3).optInt("height");
          localObject5 = ((JSONObject)localObject3).optJSONArray("position");
          if (localObject5 != null)
          {
            ((StickerItem)localObject4).position = new double[((JSONArray)localObject5).length()];
            m = 0;
            while (m < ((JSONArray)localObject5).length())
            {
              ((StickerItem)localObject4).position[m] = ((JSONArray)localObject5).getDouble(m);
              m += 1;
            }
          }
          ((StickerItem)localObject4).position = new double[] { 0.0D, 0.0D };
          localObject5 = ((JSONObject)localObject3).optJSONArray("scalePivots");
          if (localObject5 != null)
          {
            ((StickerItem)localObject4).scalePivots = new int[((JSONArray)localObject5).length()];
            m = 0;
            while (m < ((JSONArray)localObject5).length())
            {
              ((StickerItem)localObject4).scalePivots[m] = ((JSONArray)localObject5).getInt(m);
              m += 1;
            }
          }
          ((StickerItem)localObject4).scaleFactor = ((JSONObject)localObject3).optInt("scaleFactor");
          ((StickerItem)localObject4).blendMode = ((JSONObject)localObject3).optInt("blendMode", -1);
          if (((StickerItem)localObject4).blendMode == -1) {
            ((StickerItem)localObject4).blendMode = localVideoMaterial.getBlendMode();
          }
          ((StickerItem)localObject4).support3D = ((JSONObject)localObject3).optInt("enable3D", 1);
          ((StickerItem)localObject4).personID = ((JSONObject)localObject3).optInt("personID", -1);
          ((StickerItem)localObject4).activateTriggerCount = ((JSONObject)localObject3).optInt("activateTriggerCount", 0);
          ((StickerItem)localObject4).activateTriggerTotalCount = ((JSONObject)localObject3).optInt("activateTriggerTotalCount", 0);
          ((List)localObject1).add(localObject4);
          if (j == -1)
          {
            j = ((StickerItem)localObject4).triggerType;
            break label6789;
          }
          k = Math.max(k, ((StickerItem)localObject4).triggerType);
          break label6789;
        }
        label2903:
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (StickerItem)((Iterator)localObject2).next();
          ((StickerItem)localObject3).preTriggerType = j;
          ((StickerItem)localObject3).countTriggerType = k;
        }
        localVideoMaterial.setHeadCropItemList((List)localObject1);
      }
      localObject1 = new ArrayList();
      localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new DistortionItem();
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          ((DistortionItem)localObject3).position = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
          ((DistortionItem)localObject3).distortion = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
          ((DistortionItem)localObject3).direction = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
          ((DistortionItem)localObject3).radius = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
          ((DistortionItem)localObject3).strength = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
          ((DistortionItem)localObject3).x = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
          ((DistortionItem)localObject3).y = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
          ((List)localObject1).add(localObject3);
          i += 1;
        }
        localVideoMaterial.setDistortionItemList((List)localObject1);
      }
      localObject1 = new ArrayList();
      localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_LIST.value);
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new FaceMoveItem();
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          ((FaceMoveItem)localObject3).position = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POSITION.value);
          ((FaceMoveItem)localObject3).pos1 = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS1.value);
          ((FaceMoveItem)localObject3).pos2 = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS2.value);
          ((FaceMoveItem)localObject3).ratio1 = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO1.value));
          ((FaceMoveItem)localObject3).ratio2 = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO2.value));
          ((FaceMoveItem)localObject3).dx = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.X.value);
          ((FaceMoveItem)localObject3).dy = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.Y.value);
          ((List)localObject1).add(localObject3);
          i += 1;
        }
        localVideoMaterial.setFaceMoveItemList((List)localObject1);
      }
      localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_TRIANGLE.value);
      if (localObject1 != null)
      {
        localObject2 = new int[((JSONArray)localObject1).length()];
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2[i] = ((JSONArray)localObject1).getInt(i);
          i += 1;
        }
        localVideoMaterial.setFaceMoveTriangles((int[])localObject2);
      }
      localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_POINTS_LIST.value);
      localObject2 = new ArrayList();
      if (localObject1 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          ((List)localObject2).add(Float.valueOf((float)((JSONArray)localObject1).optDouble(i)));
          i += 1;
        }
        localVideoMaterial.setFacePoints((List)localObject2);
      }
      localObject1 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FILTER_EFFECT.value);
      if (localObject1 != null)
      {
        localObject2 = new VideoFilterEffect();
        ((VideoFilterEffect)localObject2).type = ((JSONObject)localObject1).optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.TYPE.value);
        ((VideoFilterEffect)localObject2).order = ((JSONObject)localObject1).optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.ORDER.value);
        localVideoMaterial.setVideoFilterEffect((VideoFilterEffect)localObject2);
      }
      localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_OFF_ITEM_LIST.value);
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject4 = ((JSONArray)localObject1).getJSONObject(i);
          localObject3 = new FaceItem();
          ((FaceItem)localObject3).faceExchangeImage = ((JSONObject)localObject4).optString(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE.value);
          ((FaceItem)localObject3).blendAlpha = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_ALPHA.value));
          ((FaceItem)localObject3).featureType = FaceOffUtil.getFeatureType(((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FEATURE_TYPE.value));
          ((FaceItem)localObject3).grayScale = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.GRAY_SCALE.value);
          ((FaceItem)localObject3).blendMode = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_MODE.value);
          ((FaceItem)localObject3).personID = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.PERSON_ID.value, -1);
          localObject5 = ((JSONObject)localObject4).optJSONArray(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_POINTS.value);
          if (localObject5 != null)
          {
            localObject6 = new ArrayList();
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              ((List)localObject6).add(Float.valueOf((float)((JSONArray)localObject5).optDouble(j)));
              j += 1;
            }
            ((FaceItem)localObject3).facePoints = ((List)localObject6);
          }
          localObject4 = ((JSONObject)localObject4).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject4 != null)
          {
            ((FaceItem)localObject3).charmRange = new CharmRange();
            ((FaceItem)localObject3).charmRange.min = ((JSONObject)localObject4).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            ((FaceItem)localObject3).charmRange.max = ((JSONObject)localObject4).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          ((List)localObject2).add(localObject3);
          i += 1;
        }
        localVideoMaterial.setFaceOffItemList((List)localObject2);
      }
      localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MESH_ITEM_LIST.value);
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject4 = ((JSONArray)localObject1).getJSONObject(i);
          localObject3 = new FaceMeshItem();
          ((FaceMeshItem)localObject3).id = ((JSONObject)localObject4).optString(VideoMaterialUtil.FACE_MESH_ITEM_LIST.ID.value);
          ((FaceMeshItem)localObject3).personID = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MESH_ITEM_LIST.PERSON_ID.value, -1);
          ((FaceMeshItem)localObject3).frames = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MESH_ITEM_LIST.FRAMES.value);
          localObject5 = ((JSONObject)localObject4).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject5 != null)
          {
            ((FaceMeshItem)localObject3).charmRange = new CharmRange();
            ((FaceMeshItem)localObject3).charmRange.min = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            ((FaceMeshItem)localObject3).charmRange.max = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          ((FaceMeshItem)localObject3).frameType = ((JSONObject)localObject4).optInt("frameType");
          ((FaceMeshItem)localObject3).frameDuration = ((JSONObject)localObject4).optDouble("frameDuration");
          ((FaceMeshItem)localObject3).triggerType = ((JSONObject)localObject4).optInt("triggerType");
          if (VideoMaterialUtil.isActionTriggerType(((FaceMeshItem)localObject3).triggerType)) {
            localVideoMaterial.setTriggerType(((FaceMeshItem)localObject3).triggerType);
          }
          if (((JSONObject)localObject4).optInt("alwaysTriggered") != 1) {
            break label6796;
          }
          bool2 = true;
          label4508:
          ((FaceMeshItem)localObject3).alwaysTriggered = bool2;
          ((FaceMeshItem)localObject3).featureStatType = ((JSONObject)localObject4).optInt("featureStatType");
          localObject4 = ((JSONObject)localObject4).optJSONObject("featureStatValueRange");
          if (localObject4 != null)
          {
            ((FaceMeshItem)localObject3).featureStatValueRange = new StickerItem.FeatureStatValueRange();
            ((FaceMeshItem)localObject3).featureStatValueRange.min = ((JSONObject)localObject4).optDouble("min");
            ((FaceMeshItem)localObject3).featureStatValueRange.max = ((JSONObject)localObject4).optDouble("max");
          }
          ((List)localObject2).add(localObject3);
          i += 1;
        }
        localVideoMaterial.setFaceMeshItemList((List)localObject2);
      }
      localObject2 = paramJSONObject.optJSONObject("faceAverage");
      if (localObject2 != null)
      {
        localObject1 = new VideoMaterial.FaceImageLayer();
        ((VideoMaterial.FaceImageLayer)localObject1).width = ((JSONObject)localObject2).optDouble("width");
        ((VideoMaterial.FaceImageLayer)localObject1).height = ((JSONObject)localObject2).optDouble("height");
        ((VideoMaterial.FaceImageLayer)localObject1).x = ((JSONObject)localObject2).optDouble("x");
        ((VideoMaterial.FaceImageLayer)localObject1).y = ((JSONObject)localObject2).optDouble("y");
        ((VideoMaterial.FaceImageLayer)localObject1).type = ((JSONObject)localObject2).optInt("type");
        ((VideoMaterial.FaceImageLayer)localObject1).imagePath = ((JSONObject)localObject2).optString("image");
        localObject3 = ((JSONObject)localObject2).optJSONArray("imageFacePoint");
        if (localObject3 != null)
        {
          localObject4 = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject3).length())
          {
            ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
            i += 1;
          }
          ((VideoMaterial.FaceImageLayer)localObject1).imageFacePoint = ((List)localObject4);
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("imageFaceColor");
        if (localObject3 != null)
        {
          localObject4 = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject3).length())
          {
            ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
            i += 1;
          }
          ((VideoMaterial.FaceImageLayer)localObject1).imageFaceColor = ((List)localObject4);
        }
        ((VideoMaterial.FaceImageLayer)localObject1).blendAlpha = ((JSONObject)localObject2).optDouble("blendAlpha", 0.5D);
        ((VideoMaterial.FaceImageLayer)localObject1).distortionAlpha = ((JSONObject)localObject2).optDouble("distortionAlpha", 0.5D);
        localObject3 = ((JSONObject)localObject2).optJSONArray("distortionList");
        if (localObject3 != null)
        {
          localObject4 = new ArrayList();
          i = 0;
          label4900:
          if (i < ((JSONArray)localObject3).length())
          {
            localObject5 = ((JSONArray)localObject3).opt(i);
            if (!(localObject5 instanceof JSONObject)) {
              break label6802;
            }
            localObject5 = (JSONObject)localObject5;
            localObject6 = new DistortionItem();
            ((DistortionItem)localObject6).position = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
            ((DistortionItem)localObject6).distortion = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
            ((DistortionItem)localObject6).direction = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
            ((DistortionItem)localObject6).radius = ((float)((JSONObject)localObject5).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
            ((DistortionItem)localObject6).strength = ((float)((JSONObject)localObject5).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
            ((DistortionItem)localObject6).x = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value, 0);
            ((DistortionItem)localObject6).y = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value, 0);
            ((List)localObject4).add(localObject6);
            break label6802;
          }
          ((VideoMaterial.FaceImageLayer)localObject1).distortionList = ((List)localObject4);
        }
        ((VideoMaterial.FaceImageLayer)localObject1).faceMaskImagePath = ((JSONObject)localObject2).optString("faceMaskImage", null);
        localObject3 = ((JSONObject)localObject2).optJSONArray("faceMaskFacePoint");
        if (localObject3 != null)
        {
          localObject4 = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject3).length())
          {
            ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
            i += 1;
          }
          ((VideoMaterial.FaceImageLayer)localObject1).faceMaskFacePoint = ((List)localObject4);
        }
        localObject2 = ((JSONObject)localObject2).optJSONArray("faceTriangle");
        if (localObject2 != null)
        {
          localObject3 = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            ((List)localObject3).add(Integer.valueOf(((JSONArray)localObject2).optInt(i)));
            i += 1;
          }
          ((VideoMaterial.FaceImageLayer)localObject1).faceTriangle = ((List)localObject3);
        }
        localVideoMaterial.setFaceImageLayer((VideoMaterial.FaceImageLayer)localObject1);
      }
      localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.AR_PARTICLE_LIST.value);
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          ((List)localObject2).add(((JSONArray)localObject1).getString(i));
          i += 1;
        }
        localVideoMaterial.setArParticleList((List)localObject2);
      }
      localObject2 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FACE_EXPRESSION.value);
      bool2 = bool1;
      if (localObject2 != null)
      {
        localObject1 = new FaceExpression();
        ((FaceExpression)localObject1).id = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.ID.value);
        ((FaceExpression)localObject1).videoID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.VIDEO_ID.value);
        ((FaceExpression)localObject1).frameDuration = ((JSONObject)localObject2).optDouble(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAME_DURATION.value);
        ((FaceExpression)localObject1).frames = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAMES.value);
        ((FaceExpression)localObject1).audioID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.AUDIO_ID.value);
        if (bool1) {
          break label6809;
        }
        if (TextUtils.isEmpty(((FaceExpression)localObject1).audioID)) {
          break label6815;
        }
        break label6809;
      }
    }
    for (;;)
    {
      localObject3 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_SIZE.value);
      if ((localObject3 != null) && (((JSONArray)localObject3).length() == 2))
      {
        ((FaceExpression)localObject1).canvasSize = new SizeI();
        ((FaceExpression)localObject1).canvasSize.width = ((JSONArray)localObject3).optInt(0);
        ((FaceExpression)localObject1).canvasSize.height = ((JSONArray)localObject3).optInt(1);
      }
      ((FaceExpression)localObject1).canvasResizeMode = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_RESIZE_MODE.value);
      ((FaceExpression)localObject1).scoreImageID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
      ((FaceExpression)localObject1).expressionNumber = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_NUMBER.value);
      localObject3 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_LIST.value);
      if (localObject3 != null)
      {
        ((FaceExpression)localObject1).expressionList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject3).length())
        {
          localObject4 = new ExpressionItem();
          localObject5 = ((JSONArray)localObject3).getJSONObject(i);
          ((ExpressionItem)localObject4).expressionTime = ((JSONObject)localObject5).optInt(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_TIME.value);
          ((ExpressionItem)localObject4).expressionID = ((JSONObject)localObject5).optString(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ID.value);
          localObject6 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT_SIZE.value);
          if ((localObject6 != null) && (((JSONArray)localObject6).length() == 2))
          {
            ((ExpressionItem)localObject4).expressionFeatSize = new SizeI();
            ((ExpressionItem)localObject4).expressionFeatSize.width = ((JSONArray)localObject6).optInt(0);
            ((ExpressionItem)localObject4).expressionFeatSize.height = ((JSONArray)localObject6).optInt(1);
          }
          localObject6 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT.value);
          if (localObject6 != null)
          {
            ((ExpressionItem)localObject4).expressionFeat = new ArrayList();
            j = 0;
            while (j < ((JSONArray)localObject6).length() / 2)
            {
              ((ExpressionItem)localObject4).expressionFeat.add(new PointF(((JSONArray)localObject6).optInt(j * 2), ((JSONArray)localObject6).optInt(j * 2 + 1)));
              j += 1;
            }
          }
          localObject6 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ANGLE.value);
          if ((localObject6 != null) && (((JSONArray)localObject6).length() == 3))
          {
            ((ExpressionItem)localObject4).expressionAngle = new float[3];
            ((ExpressionItem)localObject4).expressionAngle[0] = ((float)((JSONArray)localObject6).optDouble(0));
            ((ExpressionItem)localObject4).expressionAngle[1] = ((float)((JSONArray)localObject6).optDouble(1));
            ((ExpressionItem)localObject4).expressionAngle[2] = ((float)((JSONArray)localObject6).optDouble(2));
          }
          ((ExpressionItem)localObject4).scoreImageID = ((JSONObject)localObject5).optString(VideoMaterialUtil.EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
          localObject5 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_WEIGHT.value);
          if ((localObject5 != null) && (((JSONArray)localObject5).length() == 7))
          {
            ((ExpressionItem)localObject4).expressionWeight = new double[7];
            j = 0;
          }
          while (j < 7)
          {
            ((ExpressionItem)localObject4).expressionWeight[j] = ((JSONArray)localObject5).optDouble(j);
            j += 1;
            continue;
            ((ExpressionItem)localObject4).expressionWeight = ActUtil.WEIGHT;
          }
          ((FaceExpression)localObject1).expressionList.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_ITEM_LIST.value);
      if (localObject2 != null)
      {
        ((FaceExpression)localObject1).canvasItemList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new CanvasItem();
          ((CanvasItem)localObject4).type = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.TYPE.value);
          ((CanvasItem)localObject4).index = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.INDEX.value);
          ((CanvasItem)localObject4).startTime = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.START_TIME.value);
          ((CanvasItem)localObject4).endTime = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.END_TIME.value);
          ((CanvasItem)localObject4).zIndex = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.Z_INDEX.value);
          localObject5 = ((JSONObject)localObject3).optJSONArray(VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RECT.value);
          if ((localObject5 != null) && (((JSONArray)localObject5).length() == 4))
          {
            ((CanvasItem)localObject4).itemRect = new Rect();
            ((CanvasItem)localObject4).itemRect.x = ((JSONArray)localObject5).optInt(0);
            ((CanvasItem)localObject4).itemRect.y = ((JSONArray)localObject5).optInt(1);
            ((CanvasItem)localObject4).itemRect.width = ((JSONArray)localObject5).optInt(2);
            ((CanvasItem)localObject4).itemRect.height = ((JSONArray)localObject5).optInt(3);
          }
          ((CanvasItem)localObject4).itemResizeMode = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RESIZE_MODE.value);
          ((FaceExpression)localObject1).canvasItemList.add(localObject4);
          i += 1;
        }
      }
      localVideoMaterial.setFaceExpression((FaceExpression)localObject1);
      bool2 = bool1;
      localObject2 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FACE_CROP.value);
      if (localObject2 != null)
      {
        localObject1 = new FaceCropItem();
        ((FaceCropItem)localObject1).frameDuration = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_CROP_ITEM.FRAME_DURATION.value);
        ((FaceCropItem)localObject1).frames = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_CROP_ITEM.FRAMES.value);
        ((FaceCropItem)localObject1).frameList = new ArrayList();
        localObject2 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM.FRAME_LIST.value);
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            localObject4 = ((JSONArray)localObject2).getJSONObject(i);
            localObject3 = new FaceCropItem.CropFrame();
            ((FaceCropItem.CropFrame)localObject3).faceAngle = ((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_ANGLE.value);
            ((FaceCropItem.CropFrame)localObject3).faceWidth = ((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_WIDTH.value);
            ((FaceCropItem.CropFrame)localObject3).index = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.INDEX.value);
            localObject5 = ((JSONObject)localObject4).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.NOSE_POINT.value);
            if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
            {
              ((FaceCropItem.CropFrame)localObject3).noseX = ((JSONArray)localObject5).getDouble(0);
              ((FaceCropItem.CropFrame)localObject3).noseY = ((JSONArray)localObject5).getDouble(1);
            }
            localObject4 = ((JSONObject)localObject4).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.SIZE.value);
            if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
            {
              ((FaceCropItem.CropFrame)localObject3).width = ((JSONArray)localObject4).getDouble(0);
              ((FaceCropItem.CropFrame)localObject3).height = ((JSONArray)localObject4).getDouble(1);
            }
            ((FaceCropItem)localObject1).frameList.add(localObject3);
            i += 1;
          }
        }
        localVideoMaterial.setFaceCropItem((FaceCropItem)localObject1);
      }
      localVideoMaterial.setHasAudio(bool2);
      parseFabbyMvItems(paramString, paramJSONObject, localVideoMaterial, paramDecryptListener);
      localVideoMaterial.setSegmentFeather(paramJSONObject.optInt("SegmentFeathering", 0));
      if (paramJSONObject.optInt("SegmentRequired", 0) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        localVideoMaterial.setSegmentRequired(bool1);
        localVideoMaterial.setSegmentStrokeWidth(paramJSONObject.optDouble("SegmentStrokeWidth", 0.0D));
        localVideoMaterial.setSegmentStrokeGap(paramJSONObject.optDouble("SegmentStrokeGap", 0.0D));
        paramString = paramJSONObject.optString("SegmentStrokeColor", "");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        i = Color.parseColor(paramString);
        localVideoMaterial.setSegmentStrokeColor(new float[] { Color.red(i) / 255.0F, Color.green(i) / 255.0F, Color.blue(i) / 255.0F, Color.alpha(i) / 255.0F });
        break;
      }
      label6721:
      bool1 = false;
      break;
      label6727:
      bool1 = false;
      break label298;
      label6733:
      bool2 = false;
      break label832;
      label6739:
      bool2 = true;
      break label1075;
      label6745:
      bool1 = false;
      break label1937;
      label6751:
      bool1 = false;
      break label1962;
      label6757:
      bool1 = false;
      break label2240;
      label6763:
      m += 1;
      break label1595;
      label6772:
      i += 1;
      bool1 = bool2;
      break label509;
      label6783:
      bool2 = false;
      break label2903;
      label6789:
      i += 1;
      break label2813;
      label6796:
      bool2 = false;
      break label4508;
      label6802:
      i += 1;
      break label4900;
      label6809:
      bool1 = true;
      continue;
      label6815:
      bool1 = false;
    }
  }
  
  /* Error */
  public static JSONObject parseVideoMaterialFile(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 14
    //   6: aload_0
    //   7: invokestatic 1689	com/tencent/ttpic/util/VideoUtil:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 6
    //   12: new 548	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 549	java/lang/StringBuilder:<init>	()V
    //   19: aload 6
    //   21: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 177
    //   26: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 123
    //   35: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: astore 7
    //   40: iload_2
    //   41: ifeq +617 -> 658
    //   44: ldc 11
    //   46: astore_0
    //   47: aload 7
    //   49: aload_0
    //   50: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 26
    //   58: new 548	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 549	java/lang/StringBuilder:<init>	()V
    //   65: aload 6
    //   67: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 177
    //   72: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 123
    //   81: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: astore_1
    //   85: iload_2
    //   86: ifne +578 -> 664
    //   89: ldc 11
    //   91: astore_0
    //   92: aload_1
    //   93: aload_0
    //   94: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 27
    //   102: aconst_null
    //   103: astore 24
    //   105: aconst_null
    //   106: astore 25
    //   108: aconst_null
    //   109: astore 7
    //   111: aconst_null
    //   112: astore 20
    //   114: aconst_null
    //   115: astore 17
    //   117: aconst_null
    //   118: astore 16
    //   120: aconst_null
    //   121: astore 13
    //   123: aconst_null
    //   124: astore 19
    //   126: aconst_null
    //   127: astore 18
    //   129: aconst_null
    //   130: astore 15
    //   132: aconst_null
    //   133: astore 21
    //   135: aconst_null
    //   136: astore 22
    //   138: aconst_null
    //   139: astore 23
    //   141: aconst_null
    //   142: astore_0
    //   143: aload 17
    //   145: astore 10
    //   147: aload 24
    //   149: astore_1
    //   150: aload 22
    //   152: astore 8
    //   154: aload 18
    //   156: astore 11
    //   158: aload 25
    //   160: astore 6
    //   162: aload 23
    //   164: astore 9
    //   166: new 555	java/io/File
    //   169: dup
    //   170: aload 26
    //   172: invokespecial 1690	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: astore 29
    //   177: aload 17
    //   179: astore 10
    //   181: aload 24
    //   183: astore_1
    //   184: aload 22
    //   186: astore 8
    //   188: aload 18
    //   190: astore 11
    //   192: aload 25
    //   194: astore 6
    //   196: aload 23
    //   198: astore 9
    //   200: new 555	java/io/File
    //   203: dup
    //   204: aload 27
    //   206: invokespecial 1690	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore 28
    //   211: aload 17
    //   213: astore 10
    //   215: aload 24
    //   217: astore_1
    //   218: aload 22
    //   220: astore 8
    //   222: aload 18
    //   224: astore 11
    //   226: aload 25
    //   228: astore 6
    //   230: aload 23
    //   232: astore 9
    //   234: aload 29
    //   236: invokevirtual 1693	java/io/File:exists	()Z
    //   239: ifeq +34 -> 273
    //   242: aload 17
    //   244: astore 10
    //   246: aload 24
    //   248: astore_1
    //   249: aload 22
    //   251: astore 8
    //   253: aload 18
    //   255: astore 11
    //   257: aload 25
    //   259: astore 6
    //   261: aload 23
    //   263: astore 9
    //   265: aload 29
    //   267: invokevirtual 1696	java/io/File:isFile	()Z
    //   270: ifne +65 -> 335
    //   273: aload 17
    //   275: astore 10
    //   277: aload 24
    //   279: astore_1
    //   280: aload 22
    //   282: astore 8
    //   284: aload 18
    //   286: astore 11
    //   288: aload 25
    //   290: astore 6
    //   292: aload 23
    //   294: astore 9
    //   296: aload 28
    //   298: invokevirtual 1693	java/io/File:exists	()Z
    //   301: ifeq +500 -> 801
    //   304: aload 17
    //   306: astore 10
    //   308: aload 24
    //   310: astore_1
    //   311: aload 22
    //   313: astore 8
    //   315: aload 18
    //   317: astore 11
    //   319: aload 25
    //   321: astore 6
    //   323: aload 23
    //   325: astore 9
    //   327: aload 28
    //   329: invokevirtual 1696	java/io/File:isFile	()Z
    //   332: ifeq +469 -> 801
    //   335: aload 17
    //   337: astore 10
    //   339: aload 24
    //   341: astore_1
    //   342: aload 22
    //   344: astore 8
    //   346: aload 18
    //   348: astore 11
    //   350: aload 25
    //   352: astore 6
    //   354: aload 23
    //   356: astore 9
    //   358: aload 29
    //   360: invokevirtual 1693	java/io/File:exists	()Z
    //   363: ifeq +307 -> 670
    //   366: aload 17
    //   368: astore 10
    //   370: aload 24
    //   372: astore_1
    //   373: aload 22
    //   375: astore 8
    //   377: aload 18
    //   379: astore 11
    //   381: aload 25
    //   383: astore 6
    //   385: aload 23
    //   387: astore 9
    //   389: aload 29
    //   391: invokevirtual 1696	java/io/File:isFile	()Z
    //   394: ifeq +276 -> 670
    //   397: aload 17
    //   399: astore 10
    //   401: aload 24
    //   403: astore_1
    //   404: aload 22
    //   406: astore 8
    //   408: aload 18
    //   410: astore 11
    //   412: aload 25
    //   414: astore 6
    //   416: aload 23
    //   418: astore 9
    //   420: new 1698	java/io/FileInputStream
    //   423: dup
    //   424: aload 29
    //   426: invokespecial 1701	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   429: astore 7
    //   431: iload_2
    //   432: istore 5
    //   434: iload 5
    //   436: ifne +359 -> 795
    //   439: aload 17
    //   441: astore 10
    //   443: aload 24
    //   445: astore_1
    //   446: aload 7
    //   448: astore 8
    //   450: aload 18
    //   452: astore 11
    //   454: aload 25
    //   456: astore 6
    //   458: aload 7
    //   460: astore 9
    //   462: aload 7
    //   464: aload_3
    //   465: invokestatic 1703	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   468: astore_0
    //   469: aload 17
    //   471: astore 10
    //   473: aload_0
    //   474: astore_1
    //   475: aload 7
    //   477: astore 8
    //   479: aload 18
    //   481: astore 11
    //   483: aload_0
    //   484: astore 6
    //   486: aload 7
    //   488: astore 9
    //   490: aload 7
    //   492: invokestatic 1707	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   495: aload 20
    //   497: astore_3
    //   498: aload 12
    //   500: astore_1
    //   501: aload 19
    //   503: astore 6
    //   505: aload_0
    //   506: ifnull +607 -> 1113
    //   509: aload 17
    //   511: astore 10
    //   513: aload_0
    //   514: astore_1
    //   515: aload 7
    //   517: astore 8
    //   519: aload 18
    //   521: astore 11
    //   523: aload_0
    //   524: astore 6
    //   526: aload 7
    //   528: astore 9
    //   530: new 1709	java/io/InputStreamReader
    //   533: dup
    //   534: aload_0
    //   535: invokespecial 1711	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   538: astore_3
    //   539: new 1713	java/io/BufferedReader
    //   542: dup
    //   543: aload_3
    //   544: sipush 1024
    //   547: invokespecial 1716	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   550: astore_1
    //   551: new 1718	java/lang/StringBuffer
    //   554: dup
    //   555: invokespecial 1719	java/lang/StringBuffer:<init>	()V
    //   558: astore 6
    //   560: aload_1
    //   561: invokevirtual 1722	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   564: astore 8
    //   566: aload 8
    //   568: ifnull +505 -> 1073
    //   571: aload 6
    //   573: aload 8
    //   575: invokevirtual 1725	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   578: pop
    //   579: goto -19 -> 560
    //   582: astore 13
    //   584: aload_1
    //   585: astore 12
    //   587: aload 12
    //   589: astore 10
    //   591: aload_0
    //   592: astore_1
    //   593: aload 7
    //   595: astore 8
    //   597: aload_3
    //   598: astore 11
    //   600: ldc_w 1727
    //   603: aload 13
    //   605: invokevirtual 1730	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   608: aload 13
    //   610: invokestatic 1736	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   613: pop
    //   614: aload 12
    //   616: ifnull +8 -> 624
    //   619: aload 12
    //   621: invokevirtual 1739	java/io/BufferedReader:close	()V
    //   624: aload_3
    //   625: ifnull +7 -> 632
    //   628: aload_3
    //   629: invokevirtual 1740	java/io/InputStreamReader:close	()V
    //   632: aload_0
    //   633: ifnull +7 -> 640
    //   636: aload_0
    //   637: invokevirtual 1743	java/io/InputStream:close	()V
    //   640: aload 14
    //   642: astore_0
    //   643: aload 7
    //   645: ifnull +11 -> 656
    //   648: aload 7
    //   650: invokevirtual 1744	java/io/FileInputStream:close	()V
    //   653: aload 14
    //   655: astore_0
    //   656: aload_0
    //   657: areturn
    //   658: ldc 8
    //   660: astore_0
    //   661: goto -614 -> 47
    //   664: ldc 8
    //   666: astore_0
    //   667: goto -575 -> 92
    //   670: aload_0
    //   671: astore 7
    //   673: iload_2
    //   674: istore 5
    //   676: aload 17
    //   678: astore 10
    //   680: aload 24
    //   682: astore_1
    //   683: aload 22
    //   685: astore 8
    //   687: aload 18
    //   689: astore 11
    //   691: aload 25
    //   693: astore 6
    //   695: aload 23
    //   697: astore 9
    //   699: aload 28
    //   701: invokevirtual 1693	java/io/File:exists	()Z
    //   704: ifeq -270 -> 434
    //   707: aload_0
    //   708: astore 7
    //   710: iload_2
    //   711: istore 5
    //   713: aload 17
    //   715: astore 10
    //   717: aload 24
    //   719: astore_1
    //   720: aload 22
    //   722: astore 8
    //   724: aload 18
    //   726: astore 11
    //   728: aload 25
    //   730: astore 6
    //   732: aload 23
    //   734: astore 9
    //   736: aload 28
    //   738: invokevirtual 1696	java/io/File:isFile	()Z
    //   741: ifeq -307 -> 434
    //   744: aload 17
    //   746: astore 10
    //   748: aload 24
    //   750: astore_1
    //   751: aload 22
    //   753: astore 8
    //   755: aload 18
    //   757: astore 11
    //   759: aload 25
    //   761: astore 6
    //   763: aload 23
    //   765: astore 9
    //   767: new 1698	java/io/FileInputStream
    //   770: dup
    //   771: aload 28
    //   773: invokespecial 1701	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   776: astore 7
    //   778: iload_2
    //   779: ifne +11 -> 790
    //   782: iconst_1
    //   783: istore_2
    //   784: iload_2
    //   785: istore 5
    //   787: goto -353 -> 434
    //   790: iconst_0
    //   791: istore_2
    //   792: goto -8 -> 784
    //   795: aload 7
    //   797: astore_0
    //   798: goto -303 -> 495
    //   801: aload 7
    //   803: astore_0
    //   804: aload 17
    //   806: astore 10
    //   808: aload 24
    //   810: astore_1
    //   811: aload 22
    //   813: astore 8
    //   815: aload 18
    //   817: astore 11
    //   819: aload 25
    //   821: astore 6
    //   823: aload 23
    //   825: astore 9
    //   827: invokestatic 1750	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   830: invokevirtual 1756	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   833: aload 26
    //   835: invokevirtual 1762	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   838: astore 26
    //   840: iload_2
    //   841: ifne +206 -> 1047
    //   844: aload 7
    //   846: astore_0
    //   847: aload 17
    //   849: astore 10
    //   851: aload 24
    //   853: astore_1
    //   854: aload 22
    //   856: astore 8
    //   858: aload 18
    //   860: astore 11
    //   862: aload 25
    //   864: astore 6
    //   866: aload 23
    //   868: astore 9
    //   870: aload 26
    //   872: aload_3
    //   873: invokestatic 1703	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   876: astore 7
    //   878: aload 7
    //   880: astore_0
    //   881: aload 17
    //   883: astore 10
    //   885: aload 7
    //   887: astore_1
    //   888: aload 22
    //   890: astore 8
    //   892: aload 18
    //   894: astore 11
    //   896: aload 7
    //   898: astore 6
    //   900: aload 23
    //   902: astore 9
    //   904: aload 26
    //   906: invokestatic 1707	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   909: aload 7
    //   911: astore_0
    //   912: aload 21
    //   914: astore 7
    //   916: goto -421 -> 495
    //   919: astore_1
    //   920: aload_0
    //   921: astore 7
    //   923: aload 17
    //   925: astore 10
    //   927: aload_0
    //   928: astore_1
    //   929: aload 22
    //   931: astore 8
    //   933: aload 18
    //   935: astore 11
    //   937: aload_0
    //   938: astore 6
    //   940: aload 23
    //   942: astore 9
    //   944: invokestatic 1750	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   947: invokevirtual 1756	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   950: aload 27
    //   952: invokevirtual 1762	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   955: astore 24
    //   957: iload_2
    //   958: ifne +99 -> 1057
    //   961: iconst_1
    //   962: istore 4
    //   964: iload 4
    //   966: ifne +97 -> 1063
    //   969: aload_0
    //   970: astore 7
    //   972: aload 17
    //   974: astore 10
    //   976: aload_0
    //   977: astore_1
    //   978: aload 22
    //   980: astore 8
    //   982: aload 18
    //   984: astore 11
    //   986: aload_0
    //   987: astore 6
    //   989: aload 23
    //   991: astore 9
    //   993: aload 24
    //   995: aload_3
    //   996: invokestatic 1703	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   999: astore_0
    //   1000: aload_0
    //   1001: astore 7
    //   1003: aload 17
    //   1005: astore 10
    //   1007: aload_0
    //   1008: astore_1
    //   1009: aload 22
    //   1011: astore 8
    //   1013: aload 18
    //   1015: astore 11
    //   1017: aload_0
    //   1018: astore 6
    //   1020: aload 23
    //   1022: astore 9
    //   1024: aload 24
    //   1026: invokestatic 1707	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   1029: aload 21
    //   1031: astore 7
    //   1033: goto -538 -> 495
    //   1036: astore_0
    //   1037: aload 7
    //   1039: astore_0
    //   1040: aload 21
    //   1042: astore 7
    //   1044: goto -549 -> 495
    //   1047: aload 26
    //   1049: astore_0
    //   1050: aload 21
    //   1052: astore 7
    //   1054: goto -559 -> 495
    //   1057: iconst_0
    //   1058: istore 4
    //   1060: goto -96 -> 964
    //   1063: aload 24
    //   1065: astore_0
    //   1066: aload 21
    //   1068: astore 7
    //   1070: goto -575 -> 495
    //   1073: aload 6
    //   1075: invokevirtual 1763	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1078: astore 6
    //   1080: aload 6
    //   1082: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1085: ifne +188 -> 1273
    //   1088: new 1765	org/json/JSONTokener
    //   1091: dup
    //   1092: aload 6
    //   1094: invokespecial 1766	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   1097: invokevirtual 1769	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   1100: checkcast 111	org/json/JSONObject
    //   1103: astore 8
    //   1105: aload_3
    //   1106: astore 6
    //   1108: aload_1
    //   1109: astore_3
    //   1110: aload 8
    //   1112: astore_1
    //   1113: aload_3
    //   1114: ifnull +7 -> 1121
    //   1117: aload_3
    //   1118: invokevirtual 1739	java/io/BufferedReader:close	()V
    //   1121: aload 6
    //   1123: ifnull +8 -> 1131
    //   1126: aload 6
    //   1128: invokevirtual 1740	java/io/InputStreamReader:close	()V
    //   1131: aload_0
    //   1132: ifnull +7 -> 1139
    //   1135: aload_0
    //   1136: invokevirtual 1743	java/io/InputStream:close	()V
    //   1139: aload_1
    //   1140: astore_0
    //   1141: aload 7
    //   1143: ifnull -487 -> 656
    //   1146: aload 7
    //   1148: invokevirtual 1744	java/io/FileInputStream:close	()V
    //   1151: aload_1
    //   1152: areturn
    //   1153: astore_0
    //   1154: aload_1
    //   1155: areturn
    //   1156: astore_0
    //   1157: aload 8
    //   1159: astore 7
    //   1161: aload 10
    //   1163: ifnull +8 -> 1171
    //   1166: aload 10
    //   1168: invokevirtual 1739	java/io/BufferedReader:close	()V
    //   1171: aload 11
    //   1173: ifnull +8 -> 1181
    //   1176: aload 11
    //   1178: invokevirtual 1740	java/io/InputStreamReader:close	()V
    //   1181: aload_1
    //   1182: ifnull +7 -> 1189
    //   1185: aload_1
    //   1186: invokevirtual 1743	java/io/InputStream:close	()V
    //   1189: aload 7
    //   1191: ifnull +8 -> 1199
    //   1194: aload 7
    //   1196: invokevirtual 1744	java/io/FileInputStream:close	()V
    //   1199: aload_0
    //   1200: athrow
    //   1201: astore_1
    //   1202: goto -3 -> 1199
    //   1205: astore 6
    //   1207: aload 16
    //   1209: astore 10
    //   1211: aload_0
    //   1212: astore_1
    //   1213: aload_3
    //   1214: astore 11
    //   1216: aload 6
    //   1218: astore_0
    //   1219: goto -58 -> 1161
    //   1222: astore 6
    //   1224: aload_1
    //   1225: astore 10
    //   1227: aload_0
    //   1228: astore_1
    //   1229: aload_3
    //   1230: astore 11
    //   1232: aload 6
    //   1234: astore_0
    //   1235: goto -74 -> 1161
    //   1238: astore_0
    //   1239: aconst_null
    //   1240: areturn
    //   1241: astore_0
    //   1242: aload 13
    //   1244: astore 12
    //   1246: aload_0
    //   1247: astore 13
    //   1249: aload 6
    //   1251: astore_0
    //   1252: aload 9
    //   1254: astore 7
    //   1256: aload 15
    //   1258: astore_3
    //   1259: goto -672 -> 587
    //   1262: astore_1
    //   1263: aload 13
    //   1265: astore 12
    //   1267: aload_1
    //   1268: astore 13
    //   1270: goto -683 -> 587
    //   1273: aload_3
    //   1274: astore 6
    //   1276: aload_1
    //   1277: astore_3
    //   1278: aload 12
    //   1280: astore_1
    //   1281: goto -168 -> 1113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1284	0	paramString1	String
    //   0	1284	1	paramString2	String
    //   0	1284	2	paramBoolean	boolean
    //   0	1284	3	paramDecryptListener	DecryptListener
    //   962	97	4	i	int
    //   432	354	5	bool	boolean
    //   10	1117	6	localObject1	Object
    //   1205	12	6	localObject2	Object
    //   1222	28	6	localObject3	Object
    //   1274	1	6	localDecryptListener	DecryptListener
    //   38	1217	7	localObject4	Object
    //   152	1006	8	localObject5	Object
    //   164	1089	9	localObject6	Object
    //   145	1081	10	localObject7	Object
    //   156	1075	11	localObject8	Object
    //   1	1278	12	localObject9	Object
    //   121	1	13	localObject10	Object
    //   582	661	13	localException	Exception
    //   1247	22	13	str1	String
    //   4	650	14	localObject11	Object
    //   130	1127	15	localObject12	Object
    //   118	1090	16	localObject13	Object
    //   115	889	17	localObject14	Object
    //   127	887	18	localObject15	Object
    //   124	378	19	localObject16	Object
    //   112	384	20	localObject17	Object
    //   133	934	21	localObject18	Object
    //   136	874	22	localObject19	Object
    //   139	882	23	localObject20	Object
    //   103	961	24	localInputStream	InputStream
    //   106	757	25	localObject21	Object
    //   56	992	26	localObject22	Object
    //   100	851	27	str2	String
    //   209	563	28	localFile1	File
    //   175	250	29	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   551	560	582	java/lang/Exception
    //   560	566	582	java/lang/Exception
    //   571	579	582	java/lang/Exception
    //   1073	1105	582	java/lang/Exception
    //   827	840	919	java/io/IOException
    //   870	878	919	java/io/IOException
    //   904	909	919	java/io/IOException
    //   944	957	1036	java/io/IOException
    //   993	1000	1036	java/io/IOException
    //   1024	1029	1036	java/io/IOException
    //   1117	1121	1153	java/io/IOException
    //   1126	1131	1153	java/io/IOException
    //   1135	1139	1153	java/io/IOException
    //   1146	1151	1153	java/io/IOException
    //   166	177	1156	finally
    //   200	211	1156	finally
    //   234	242	1156	finally
    //   265	273	1156	finally
    //   296	304	1156	finally
    //   327	335	1156	finally
    //   358	366	1156	finally
    //   389	397	1156	finally
    //   420	431	1156	finally
    //   462	469	1156	finally
    //   490	495	1156	finally
    //   530	539	1156	finally
    //   600	614	1156	finally
    //   699	707	1156	finally
    //   736	744	1156	finally
    //   767	778	1156	finally
    //   827	840	1156	finally
    //   870	878	1156	finally
    //   904	909	1156	finally
    //   944	957	1156	finally
    //   993	1000	1156	finally
    //   1024	1029	1156	finally
    //   1166	1171	1201	java/io/IOException
    //   1176	1181	1201	java/io/IOException
    //   1185	1189	1201	java/io/IOException
    //   1194	1199	1201	java/io/IOException
    //   539	551	1205	finally
    //   551	560	1222	finally
    //   560	566	1222	finally
    //   571	579	1222	finally
    //   1073	1105	1222	finally
    //   619	624	1238	java/io/IOException
    //   628	632	1238	java/io/IOException
    //   636	640	1238	java/io/IOException
    //   648	653	1238	java/io/IOException
    //   166	177	1241	java/lang/Exception
    //   200	211	1241	java/lang/Exception
    //   234	242	1241	java/lang/Exception
    //   265	273	1241	java/lang/Exception
    //   296	304	1241	java/lang/Exception
    //   327	335	1241	java/lang/Exception
    //   358	366	1241	java/lang/Exception
    //   389	397	1241	java/lang/Exception
    //   420	431	1241	java/lang/Exception
    //   462	469	1241	java/lang/Exception
    //   490	495	1241	java/lang/Exception
    //   530	539	1241	java/lang/Exception
    //   699	707	1241	java/lang/Exception
    //   736	744	1241	java/lang/Exception
    //   767	778	1241	java/lang/Exception
    //   827	840	1241	java/lang/Exception
    //   870	878	1241	java/lang/Exception
    //   904	909	1241	java/lang/Exception
    //   944	957	1241	java/lang/Exception
    //   993	1000	1241	java/lang/Exception
    //   1024	1029	1241	java/lang/Exception
    //   539	551	1262	java/lang/Exception
  }
  
  public static JSONObject parseVideoMaterialString(String paramString, DecryptListener paramDecryptListener)
  {
    String str2 = paramString.trim();
    paramString = str2;
    String str1 = paramString;
    if (str2 != null)
    {
      str1 = paramString;
      try
      {
        if (str2.charAt(0) != '{')
        {
          paramString = new BufferedReader(new InputStreamReader(drinkACupOfCoffee(new ByteArrayInputStream(str2.getBytes(Charset.forName("UTF-8"))), paramDecryptListener)), 1024);
          paramDecryptListener = new StringBuffer();
          for (;;)
          {
            str1 = paramString.readLine();
            if (str1 == null) {
              break;
            }
            paramDecryptListener.append(str1);
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    while (TextUtils.isEmpty(str1)) {
      str1 = paramDecryptListener.toString();
    }
    paramString = (JSONObject)new JSONTokener(str1).nextValue();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser
 * JD-Core Version:    0.7.0.1
 */