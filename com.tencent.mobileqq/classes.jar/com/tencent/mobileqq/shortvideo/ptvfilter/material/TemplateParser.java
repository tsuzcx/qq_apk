package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import aicu;
import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleItem;
import com.tencent.mobileqq.shortvideo.ptvfilter.NonFitItem;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
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
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.CANVAS_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.CHARM_RANGE_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.EXPRESSION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_CROP_ITEM;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_CROP_ITEM_FRAME;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_MESH_ITEM_LIST;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_MOVE_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_OFF_ITEM_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.FILTER_EFFECT_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.WATERMARK_ELEMENT;
import com.tencent.ttpic.util.VideoMaterialUtil.WATERMARK_LOGIC;
import com.tencent.ttpic.util.VideoTemplateParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TemplateParser
{
  private static final DecryptListener a = new aicu();
  
  /* Error */
  public static MovieMaterial a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 22	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: new 24	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   16: aload_1
    //   17: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 31
    //   22: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +19 -> 54
    //   38: aload 4
    //   40: invokevirtual 42	java/io/File:exists	()Z
    //   43: ifeq +11 -> 54
    //   46: aload 4
    //   48: invokevirtual 45	java/io/File:isDirectory	()Z
    //   51: ifeq +5 -> 56
    //   54: aconst_null
    //   55: areturn
    //   56: aload_0
    //   57: aload_1
    //   58: iconst_1
    //   59: getstatic 15	com/tencent/mobileqq/shortvideo/ptvfilter/material/TemplateParser:a	Lcom/tencent/ttpic/util/DecryptListener;
    //   62: invokestatic 51	com/tencent/ttpic/util/VideoTemplateParser:parseVideoMaterialFile	(Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/ttpic/util/DecryptListener;)Lorg/json/JSONObject;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull -13 -> 54
    //   70: aload_3
    //   71: astore_1
    //   72: aload_0
    //   73: ldc 53
    //   75: invokevirtual 59	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +143 -> 225
    //   85: aload_3
    //   86: astore_1
    //   87: aload 4
    //   89: invokevirtual 65	org/json/JSONArray:length	()I
    //   92: ifle +133 -> 225
    //   95: aload_3
    //   96: astore_1
    //   97: new 67	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial
    //   100: dup
    //   101: invokespecial 68	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:<init>	()V
    //   104: astore_0
    //   105: aload 4
    //   107: iconst_0
    //   108: invokevirtual 72	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   111: astore_1
    //   112: aload_0
    //   113: aload_1
    //   114: ldc 74
    //   116: iconst_0
    //   117: invokevirtual 78	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   120: putfield 81	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_a_of_type_Boolean	Z
    //   123: aload_0
    //   124: aload_1
    //   125: ldc 83
    //   127: iconst_0
    //   128: invokevirtual 78	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   131: putfield 86	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_b_of_type_Boolean	Z
    //   134: aload_0
    //   135: aload_1
    //   136: ldc 88
    //   138: iconst_0
    //   139: invokevirtual 78	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   142: putfield 91	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_c_of_type_Boolean	Z
    //   145: aload_0
    //   146: aload_1
    //   147: ldc 93
    //   149: iconst_0
    //   150: invokevirtual 78	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   153: putfield 96	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_d_of_type_Boolean	Z
    //   156: aload_0
    //   157: aload_1
    //   158: ldc 98
    //   160: aconst_null
    //   161: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: putfield 105	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   167: aload_0
    //   168: aload_1
    //   169: ldc 107
    //   171: aconst_null
    //   172: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   175: putfield 109	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   178: aload_0
    //   179: aload_1
    //   180: ldc 111
    //   182: aconst_null
    //   183: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: putfield 113	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   189: aload_0
    //   190: aload_1
    //   191: ldc 115
    //   193: aconst_null
    //   194: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   197: putfield 117	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   200: aload_0
    //   201: areturn
    //   202: astore_1
    //   203: aload_2
    //   204: astore_0
    //   205: aload_1
    //   206: astore_2
    //   207: aload_0
    //   208: astore_1
    //   209: aload_2
    //   210: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   213: aload_0
    //   214: areturn
    //   215: astore_0
    //   216: aload_1
    //   217: areturn
    //   218: astore_1
    //   219: aload_0
    //   220: areturn
    //   221: astore_2
    //   222: goto -15 -> 207
    //   225: aconst_null
    //   226: astore_0
    //   227: goto -27 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramString1	String
    //   0	230	1	paramString2	String
    //   3	207	2	str	String
    //   221	1	2	localException	Exception
    //   1	95	3	localObject1	Object
    //   31	75	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   72	80	202	java/lang/Exception
    //   87	95	202	java/lang/Exception
    //   97	105	202	java/lang/Exception
    //   72	80	215	finally
    //   87	95	215	finally
    //   97	105	215	finally
    //   209	213	215	finally
    //   105	200	218	finally
    //   105	200	221	java/lang/Exception
  }
  
  public static QQVideoMaterial a(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return paramQQVideoMaterial;
    }
    try
    {
      paramQQVideoMaterial.jdField_b_of_type_Int = paramJSONObject.optInt("gestureAnimGapTime");
      paramQQVideoMaterial.jdField_a_of_type_Int = paramJSONObject.optInt("gestureAnimType");
      paramQQVideoMaterial.jdField_c_of_type_Int = paramJSONObject.optInt("gesturePointIndex");
      return paramQQVideoMaterial;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject = paramJSONObject;
      paramJSONObject.printStackTrace();
      return paramQQVideoMaterial;
    }
    finally {}
    return paramQQVideoMaterial;
  }
  
  public static QQVideoMaterial a(String paramString1, String paramString2)
  {
    boolean bool = false;
    QQVideoMaterial localQQVideoMaterial2 = a(paramString1, paramString2, false, a);
    QQVideoMaterial localQQVideoMaterial1 = localQQVideoMaterial2;
    if (localQQVideoMaterial2.getMinAppVersion() == 0)
    {
      bool = true;
      localQQVideoMaterial1 = a(paramString1, paramString2, true, a);
    }
    paramString1 = VideoTemplateParser.parseVideoMaterialFile(paramString1, paramString2, bool, a);
    a(localQQVideoMaterial1, paramString1);
    b(localQQVideoMaterial1, paramString1);
    c(localQQVideoMaterial1, paramString1);
    d(localQQVideoMaterial1, paramString1);
    a(localQQVideoMaterial1, paramString1);
    g(localQQVideoMaterial1, paramString1);
    e(localQQVideoMaterial1, paramString1);
    f(localQQVideoMaterial1, paramString1);
    return localQQVideoMaterial1;
  }
  
  public static QQVideoMaterial a(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    return a(paramString1, VideoTemplateParser.parseVideoMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener);
  }
  
  private static QQVideoMaterial a(String paramString, JSONObject paramJSONObject, DecryptListener paramDecryptListener)
  {
    QQVideoMaterial localQQVideoMaterial = new QQVideoMaterial();
    localQQVideoMaterial.setDataPath(paramString);
    if (paramJSONObject == null) {
      return localQQVideoMaterial;
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
    label835:
    int m;
    try
    {
      localQQVideoMaterial.setId(VideoMaterialUtil.getMaterialId(paramString));
      localQQVideoMaterial.setMinAppVersion(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
      localQQVideoMaterial.setShaderType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.SHADER_TYPE.value));
      localQQVideoMaterial.setFaceoffType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_OFF_TYPE.value));
      localQQVideoMaterial.setFaceSwapType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_SWAP_TYPE.value));
      localQQVideoMaterial.setMaxFaceCount(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
      localQQVideoMaterial.setFaceExchangeImage(paramJSONObject.optString(VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
      localQQVideoMaterial.setImageFacePointsFileName(paramJSONObject.optString(VideoMaterialUtil.FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
      localQQVideoMaterial.setBlendAlpha(paramJSONObject.optDouble(VideoMaterialUtil.FIELD.BLEND_ALPHA.value));
      localQQVideoMaterial.setGrayScale(paramJSONObject.optInt(VideoMaterialUtil.FIELD.GRAY_SCALE.value));
      localQQVideoMaterial.setOrderMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.ORDER_MODE.value));
      localQQVideoMaterial.setBlendMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.BLEND_MODE.value));
      localQQVideoMaterial.setFeatureType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FEATURE_TYPE.value));
      localQQVideoMaterial.setFilterId(paramJSONObject.optString(VideoMaterialUtil.FIELD.FILTER_ID.value));
      localQQVideoMaterial.setArParticleType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.AR_PARTICLE_TYPE.value));
      if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.SUPPORT_LANDSCAPE.value, 1) != 1) {
        break label6713;
      }
      bool1 = true;
      localQQVideoMaterial.setSupportLandscape(bool1);
      localQQVideoMaterial.setTipsText(paramJSONObject.optString(VideoMaterialUtil.FIELD.TIPS_TEXT.value));
      if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.USE_MESH.value, 0) == 0) {
        break label6719;
      }
      bool1 = true;
      localQQVideoMaterial.setUseMesh(bool1);
      localQQVideoMaterial.setAdIcon(paramString + File.separator + paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_ICON.value));
      localQQVideoMaterial.setAdLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_LINK.value));
      localQQVideoMaterial.setAdAppLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_APP_LINK.value));
      localQQVideoMaterial.setWeiboTag(paramJSONObject.optString("weiboTag"));
      localQQVideoMaterial.setDetectorFlag(paramJSONObject.optInt(VideoMaterialUtil.FIELD.DETECTOR_FLAG.value));
      localObject1 = new ArrayList();
      localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.RESOURCE_LIST.value);
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          ((List)localObject1).add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
        localQQVideoMaterial.setResourceList((List)localObject1);
      }
      bool1 = false;
      bool2 = false;
      localObject2 = new ArrayList();
      localObject3 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.ITEM_LIST.value);
      if (localObject3 == null) {
        break label2761;
      }
      j = -1;
      i = 0;
      k = 0;
      bool1 = bool2;
      if (k >= ((JSONArray)localObject3).length()) {
        break label2707;
      }
      localObject1 = ((JSONArray)localObject3).getJSONObject(k);
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
        ((StickerItem)localObject4).blendMode = localQQVideoMaterial.getBlendMode();
      }
      ((StickerItem)localObject4).triggerType = ((JSONObject)localObject1).optInt("triggerType");
      if (VideoMaterialUtil.isActionTriggerType(((StickerItem)localObject4).triggerType)) {
        localQQVideoMaterial.setTriggerType(((StickerItem)localObject4).triggerType);
      }
      if (((JSONObject)localObject1).optInt("alwaysTriggered") != 1) {
        break label6725;
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
        while (m < ((JSONArray)localObject5).length())
        {
          ((StickerItem)localObject4).position[m] = ((JSONArray)localObject5).getDouble(m);
          m += 1;
        }
      }
      ((StickerItem)localObject4).position = new double[] { 0.0D, 0.0D };
      ((StickerItem)localObject4).audio = ((JSONObject)localObject1).optString("audio");
      if ((TextUtils.isEmpty(((StickerItem)localObject4).audio)) || (TextUtils.isEmpty(paramString))) {
        break label6710;
      }
      if (paramString.startsWith("assets://camera/camera_video/video_")) {
        break label6731;
      }
      if (!paramString.contains("/files/olm/camera/video_")) {
        break label6710;
      }
    }
    catch (JSONException paramString)
    {
      label1068:
      int n;
      paramString.printStackTrace();
    }
    Object localObject5 = ((JSONObject)localObject1).optJSONArray("anchorPoint");
    if (localObject5 != null)
    {
      ((StickerItem)localObject4).anchorPoint = new int[((JSONArray)localObject5).length()];
      m = 0;
      while (m < ((JSONArray)localObject5).length())
      {
        ((StickerItem)localObject4).anchorPoint[m] = ((JSONArray)localObject5).getInt(m);
        m += 1;
      }
    }
    localObject5 = ((JSONObject)localObject1).optJSONArray("alignFacePoints");
    if (localObject5 != null)
    {
      ((StickerItem)localObject4).alignFacePoints = new int[((JSONArray)localObject5).length()];
      m = 0;
      while (m < ((JSONArray)localObject5).length())
      {
        ((StickerItem)localObject4).alignFacePoints[m] = ((JSONArray)localObject5).getInt(m);
        m += 1;
      }
    }
    localObject5 = ((JSONObject)localObject1).optJSONArray("scalePivots");
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
    Object localObject6;
    label1588:
    Object localObject7;
    label1645:
    Object localObject8;
    label1740:
    Object localObject9;
    label1793:
    label1930:
    label1955:
    label2233:
    Object localObject10;
    String str1;
    if (localObject5 != null)
    {
      localObject6 = new WMGroup();
      m = 0;
      if (m < ((JSONArray)localObject5).length())
      {
        localObject7 = ((JSONArray)localObject5).optJSONObject(m);
        if (localObject7 == null) {
          break label6755;
        }
        n = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
        if (n == WMElement.WMType.TEXT.value)
        {
          localObject1 = new TextWMElement();
          ((WMElement)localObject1).sid = localQQVideoMaterial.getId();
          ((WMElement)localObject1).id = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
          ((WMElement)localObject1).relativeID = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
          localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
          if ((localObject8 == null) || (((JSONArray)localObject8).length() != 2)) {
            break label2495;
          }
          ((WMElement)localObject1).relativeAnchor = new PointF((float)((JSONArray)localObject8).getDouble(0), (float)((JSONArray)localObject8).getDouble(1));
          localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
          if ((localObject8 == null) || (((JSONArray)localObject8).length() != 2)) {
            break label2512;
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
            break label6737;
          }
          bool2 = true;
          ((WMElement)localObject1).fontBold = bool2;
          if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
            break label6743;
          }
          bool2 = true;
          ((WMElement)localObject1).fontItalics = bool2;
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
            break label6749;
          }
          bool2 = true;
          ((WMElement)localObject1).vertical = bool2;
          ((WMElement)localObject1).rotate = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.ROTATE.value);
          ((WMElement)localObject1).animateType = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
          localObject8 = ((JSONObject)localObject7).optJSONObject(VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
          if (localObject8 == null) {
            break label2645;
          }
          localObject7 = new WMLogic();
          ((WMLogic)localObject7).type = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
          ((WMLogic)localObject7).setCompare(((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), ((WMElement)localObject1).sid);
          ((WMLogic)localObject7).data = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
          localObject9 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
          if (localObject9 == null) {
            break label2537;
          }
          ((WMLogic)localObject7).range = new ArrayList();
          localObject10 = ((JSONObject)localObject9).keys();
          while (((Iterator)localObject10).hasNext())
          {
            str1 = (String)((Iterator)localObject10).next();
            String str2 = ((JSONObject)localObject9).optString(str1);
            ((WMLogic)localObject7).range.add(new WMLogicPair(str1, str2));
            continue;
            label2450:
            VideoMaterialUtil.updateSupportLandscape(localQQVideoMaterial);
            VideoMaterialUtil.updateMaxFaceCount(localQQVideoMaterial);
            VideoMaterialUtil.updateFaceValueDetectType(localQQVideoMaterial);
            VideoMaterialUtil.updateItemImageType(localQQVideoMaterial);
            VideoMaterialUtil.updateWatermarkInfo(localQQVideoMaterial);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        a(localQQVideoMaterial);
        return localQQVideoMaterial;
        localObject1 = new ImageWMElement();
        break label1645;
        label2495:
        ((WMElement)localObject1).relativeAnchor = new PointF(0.0F, 0.0F);
        break label1740;
        label2512:
        ((WMElement)localObject1).anchor = new PointF(0.0F, 0.0F);
        break label1793;
        Collections.sort(((WMLogic)localObject7).range);
        label2537:
        localObject8 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
        if (localObject8 != null)
        {
          ((WMLogic)localObject7).wmcase = new ArrayList();
          localObject9 = ((JSONObject)localObject8).keys();
          if (((Iterator)localObject9).hasNext())
          {
            localObject10 = (String)((Iterator)localObject9).next();
            str1 = ((JSONObject)localObject8).optString((String)localObject10);
            ((WMLogic)localObject7).wmcase.add(new WMLogicPair((String)localObject10, str1));
            continue;
          }
          Collections.sort(((WMLogic)localObject7).wmcase);
        }
        ((WMElement)localObject1).logic = ((WMLogic)localObject7);
        label2645:
        ((WMGroup)localObject6).wmElements.add(localObject1);
        break label6755;
        ((StickerItem)localObject4).wmGroup = ((WMGroup)localObject6);
        ((List)localObject2).add(localObject4);
        if (j == -1)
        {
          j = ((StickerItem)localObject4).triggerType;
          break label6764;
        }
        i = Math.max(i, ((StickerItem)localObject4).triggerType);
        break label6764;
        label2707:
        localObject1 = ((List)localObject2).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (StickerItem)((Iterator)localObject1).next();
          ((StickerItem)localObject3).preTriggerType = j;
          ((StickerItem)localObject3).countTriggerType = i;
          continue;
        }
        localQQVideoMaterial.setItemList((List)localObject2);
        label2761:
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_HEAD_CROP_ITEM_LIST.value);
        if (localObject2 != null)
        {
          j = -1;
          i = 0;
          k = 0;
          if (k < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(k);
            localObject4 = new StickerItem();
            ((StickerItem)localObject4).id = ((JSONObject)localObject3).optString("id");
            ((StickerItem)localObject4).subFolder = ((StickerItem)localObject4).id;
            ((StickerItem)localObject4).type = ((JSONObject)localObject3).optInt("type");
            ((StickerItem)localObject4).triggerType = ((JSONObject)localObject3).optInt("triggerType");
            if (((JSONObject)localObject3).optInt("alwaysTriggered") != 1) {
              break label6773;
            }
            bool2 = true;
            ((StickerItem)localObject4).alwaysTriggered = bool2;
            ((StickerItem)localObject4).featureStatType = ((JSONObject)localObject3).optInt("featureStatType");
            ((StickerItem)localObject4).playCount = ((JSONObject)localObject3).optInt("playCount");
            if (VideoMaterialUtil.isActionTriggerType(((StickerItem)localObject4).triggerType)) {
              localQQVideoMaterial.setTriggerType(((StickerItem)localObject4).triggerType);
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
            localObject5 = ((JSONObject)localObject3).optJSONArray("scalePivots");
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
            ((StickerItem)localObject4).scaleFactor = ((JSONObject)localObject3).optInt("scaleFactor");
            ((StickerItem)localObject4).blendMode = ((JSONObject)localObject3).optInt("blendMode", -1);
            if (((StickerItem)localObject4).blendMode == -1) {
              ((StickerItem)localObject4).blendMode = localQQVideoMaterial.getBlendMode();
            }
            ((StickerItem)localObject4).support3D = ((JSONObject)localObject3).optInt("enable3D", 1);
            ((StickerItem)localObject4).personID = ((JSONObject)localObject3).optInt("personID", -1);
            ((StickerItem)localObject4).activateTriggerCount = ((JSONObject)localObject3).optInt("activateTriggerCount", 0);
            ((StickerItem)localObject4).activateTriggerTotalCount = ((JSONObject)localObject3).optInt("activateTriggerTotalCount", 0);
            ((List)localObject1).add(localObject4);
            if (j == -1)
            {
              j = ((StickerItem)localObject4).triggerType;
              break label6779;
            }
            i = Math.max(i, ((StickerItem)localObject4).triggerType);
            break label6779;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (StickerItem)((Iterator)localObject2).next();
            ((StickerItem)localObject3).preTriggerType = j;
            ((StickerItem)localObject3).countTriggerType = i;
            continue;
          }
          localQQVideoMaterial.setHeadCropItemList((List)localObject1);
        }
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
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
            continue;
          }
          localQQVideoMaterial.setDistortionItemList((List)localObject1);
        }
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_LIST.value);
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
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
            continue;
          }
          localQQVideoMaterial.setFaceMoveItemList((List)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_TRIANGLE.value);
        if (localObject1 != null)
        {
          localObject2 = new int[((JSONArray)localObject1).length()];
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2[i] = ((JSONArray)localObject1).getInt(i);
            i += 1;
            continue;
          }
          localQQVideoMaterial.setFaceMoveTriangles((int[])localObject2);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_POINTS_LIST.value);
        localObject2 = new ArrayList();
        if (localObject1 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            ((List)localObject2).add(Float.valueOf((float)((JSONArray)localObject1).optDouble(i)));
            i += 1;
            continue;
          }
          localQQVideoMaterial.setFacePoints((List)localObject2);
        }
        localObject1 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FILTER_EFFECT.value);
        if (localObject1 != null)
        {
          localObject2 = new VideoFilterEffect();
          ((VideoFilterEffect)localObject2).type = ((JSONObject)localObject1).optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.TYPE.value);
          ((VideoFilterEffect)localObject2).order = ((JSONObject)localObject1).optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.ORDER.value);
          localQQVideoMaterial.setVideoFilterEffect((VideoFilterEffect)localObject2);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_OFF_ITEM_LIST.value);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
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
              if (j < ((JSONArray)localObject5).length())
              {
                ((List)localObject6).add(Float.valueOf((float)((JSONArray)localObject5).optDouble(j)));
                j += 1;
                continue;
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
            continue;
          }
          localQQVideoMaterial.setFaceOffItemList((List)localObject2);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MESH_ITEM_LIST.value);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
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
              localQQVideoMaterial.setTriggerType(((FaceMeshItem)localObject3).triggerType);
            }
            if (((JSONObject)localObject4).optInt("alwaysTriggered") != 1) {
              break label6788;
            }
            bool2 = true;
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
            continue;
          }
          localQQVideoMaterial.setFaceMeshItemList((List)localObject2);
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
            if (i < ((JSONArray)localObject3).length())
            {
              ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
              i += 1;
              continue;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).imageFacePoint = ((List)localObject4);
          }
          localObject3 = ((JSONObject)localObject2).optJSONArray("imageFaceColor");
          if (localObject3 != null)
          {
            localObject4 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
              i += 1;
              continue;
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
            if (i < ((JSONArray)localObject3).length())
            {
              localObject5 = ((JSONArray)localObject3).opt(i);
              if (!(localObject5 instanceof JSONObject)) {
                break label6794;
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
              break label6794;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).distortionList = ((List)localObject4);
          }
          ((VideoMaterial.FaceImageLayer)localObject1).faceMaskImagePath = ((JSONObject)localObject2).optString("faceMaskImage", null);
          localObject3 = ((JSONObject)localObject2).optJSONArray("faceMaskFacePoint");
          if (localObject3 != null)
          {
            localObject4 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
              i += 1;
              continue;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).faceMaskFacePoint = ((List)localObject4);
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("faceTriangle");
          if (localObject2 != null)
          {
            localObject3 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              ((List)localObject3).add(Integer.valueOf(((JSONArray)localObject2).optInt(i)));
              i += 1;
              continue;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).faceTriangle = ((List)localObject3);
          }
          localQQVideoMaterial.setFaceImageLayer((VideoMaterial.FaceImageLayer)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.AR_PARTICLE_LIST.value);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            ((List)localObject2).add(((JSONArray)localObject1).getString(i));
            i += 1;
            continue;
          }
          localQQVideoMaterial.setArParticleList((List)localObject2);
        }
        localObject2 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FACE_EXPRESSION.value);
        if (localObject2 != null)
        {
          localObject1 = new FaceExpression();
          ((FaceExpression)localObject1).id = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.ID.value);
          ((FaceExpression)localObject1).videoID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.VIDEO_ID.value);
          ((FaceExpression)localObject1).frameDuration = ((JSONObject)localObject2).optDouble(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAME_DURATION.value);
          ((FaceExpression)localObject1).frames = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAMES.value);
          ((FaceExpression)localObject1).audioID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.AUDIO_ID.value);
          if (bool1) {
            break label6801;
          }
          if (TextUtils.isEmpty(((FaceExpression)localObject1).audioID)) {
            break label6807;
          }
          break label6801;
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
            if (i < ((JSONArray)localObject3).length())
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
                if (j < ((JSONArray)localObject6).length() / 2)
                {
                  ((ExpressionItem)localObject4).expressionFeat.add(new PointF(((JSONArray)localObject6).optInt(j * 2), ((JSONArray)localObject6).optInt(j * 2 + 1)));
                  j += 1;
                  continue;
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
                if (j < 7)
                {
                  ((ExpressionItem)localObject4).expressionWeight[j] = ((JSONArray)localObject5).optDouble(j);
                  j += 1;
                  continue;
                }
              }
              else
              {
                ((ExpressionItem)localObject4).expressionWeight = ActUtil.WEIGHT;
              }
              ((FaceExpression)localObject1).expressionList.add(localObject4);
              i += 1;
              continue;
            }
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_ITEM_LIST.value);
          if (localObject2 != null)
          {
            ((FaceExpression)localObject1).canvasItemList = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject2).length())
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
              continue;
            }
          }
          localQQVideoMaterial.setFaceExpression((FaceExpression)localObject1);
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
              if (i < ((JSONArray)localObject2).length())
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
                continue;
              }
            }
            localQQVideoMaterial.setFaceCropItem((FaceCropItem)localObject1);
          }
          localQQVideoMaterial.setHasAudio(bool1);
          a(paramString, paramJSONObject, localQQVideoMaterial, paramDecryptListener);
          localQQVideoMaterial.setSegmentFeather(paramJSONObject.optInt("SegmentFeathering", 0));
          if (paramJSONObject.optInt("SegmentRequired", 0) == 1)
          {
            bool1 = true;
            localQQVideoMaterial.setSegmentRequired(bool1);
            localQQVideoMaterial.setSegmentStrokeWidth(paramJSONObject.optDouble("SegmentStrokeWidth", 0.0D));
            localQQVideoMaterial.setSegmentStrokeGap(paramJSONObject.optDouble("SegmentStrokeGap", 0.0D));
            paramString = paramJSONObject.optString("SegmentStrokeColor", "");
            if (TextUtils.isEmpty(paramString)) {
              break label2450;
            }
            i = Color.parseColor(paramString);
            localQQVideoMaterial.setSegmentStrokeColor(new float[] { Color.red(i) / 255.0F, Color.green(i) / 255.0F, Color.blue(i) / 255.0F, Color.alpha(i) / 255.0F });
            break label2450;
          }
          bool1 = false;
          continue;
        }
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        continue;
        continue;
      }
      label6710:
      break label1068;
      label6713:
      bool1 = false;
      break;
      label6719:
      bool1 = false;
      break label298;
      label6725:
      bool2 = false;
      break label835;
      label6731:
      bool1 = true;
      break label1068;
      label6737:
      bool2 = false;
      break label1930;
      label6743:
      bool2 = false;
      break label1955;
      label6749:
      bool2 = false;
      break label2233;
      label6755:
      m += 1;
      break label1588;
      label6764:
      k += 1;
      break label509;
      label6773:
      bool2 = false;
      continue;
      label6779:
      k += 1;
      continue;
      label6788:
      bool2 = false;
      continue;
      label6794:
      i += 1;
      continue;
      label6801:
      bool1 = true;
      continue;
      label6807:
      bool1 = false;
    }
  }
  
  private static void a(VideoMaterial paramVideoMaterial)
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
  
  private static void a(String paramString, JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    Object localObject1 = paramJSONObject.optString("mvTemplateFile");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    int i;
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
        paramDecryptListener = VideoTemplateParser.parseVideoMaterialFile(paramString, paramJSONObject, true, paramDecryptListener);
      } while (paramDecryptListener == null);
      localObject1 = paramDecryptListener.optJSONArray("parts");
    } while (localObject1 == null);
    if (((JSONArray)localObject1).length() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ArrayList localArrayList = new ArrayList();
      i = 0;
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
              if (TextUtils.isEmpty(paramString)) {
                break label1060;
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
                break label1128;
              }
              ((StickerItem)localObject3).sourceType = VideoMaterialUtil.getItemSourceType(((JSONObject)localObject2).optInt(VideoMaterialUtil.FIELD.VIDEO_ALPHA_TYPE.value));
              label426:
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
              if (TextUtils.isEmpty(paramString)) {
                break label1139;
              }
              j = paramString.lastIndexOf("/");
              ((StickerItem)localObject3).id = paramString.substring(j + 1, paramString.length());
              ((StickerItem)localObject3).subFolder = paramString.substring(0, j);
              j = 1;
              label537:
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
                break label1207;
              }
            }
          }
          label1060:
          label1207:
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
              break label1440;
            }
            localFabbyMvPart.easeCurve = paramString.optInt("easeCurve", 0);
            localFabbyMvPart.scaleMap.clear();
            paramJSONObject = paramString.optJSONObject("scale");
            if (paramJSONObject == null) {
              break label1218;
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
            j = paramString.lastIndexOf("/");
            ((StickerItem)localObject3).id = paramString.substring(j + 1, paramString.length());
            ((StickerItem)localObject3).subFolder = paramString.substring(0, j);
            j = 0;
            break;
            label1128:
            ((StickerItem)localObject3).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
            break label426;
            label1139:
            paramString = paramJSONObject;
            if (paramJSONObject.endsWith("_")) {
              paramString = paramJSONObject.substring(0, paramJSONObject.length() - 1);
            }
            j = paramString.lastIndexOf("/");
            ((StickerItem)localObject3).id = paramString.substring(j + 1, paramString.length());
            ((StickerItem)localObject3).subFolder = paramString.substring(0, j);
            j = 0;
            break label537;
          }
          label1218:
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
          label1440:
          localObject2 = localJSONObject.optJSONObject("finishTransition");
          int k;
          if (localObject2 != null)
          {
            localObject3 = new StickerItem();
            paramString = ((JSONObject)localObject2).optString("maskVideoFile");
            paramJSONObject = ((JSONObject)localObject2).optString("maskImageName");
            j = ((JSONObject)localObject2).optInt("transitionFunction", 0);
            if (j == 0)
            {
              if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(paramJSONObject))) {
                break label1921;
              }
              if (TextUtils.isEmpty(paramString)) {
                break label1856;
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
            label1856:
            paramString = paramJSONObject;
            if (paramJSONObject.endsWith("_")) {
              paramString = paramJSONObject.substring(0, paramJSONObject.length() - 1);
            }
            k = paramString.lastIndexOf("/");
            ((StickerItem)localObject3).id = paramString.substring(k + 1, paramString.length());
            ((StickerItem)localObject3).subFolder = paramString.substring(0, k);
            continue;
            label1921:
            ((StickerItem)localObject3).id = "";
            ((StickerItem)localObject3).subFolder = "";
          }
        }
      }
      paramVideoMaterial.setFabbyMvParts(localArrayList);
      return;
    }
  }
  
  public static boolean a(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if (paramJSONObject == null) {
      return false;
    }
    paramQQVideoMaterial.jdField_c_of_type_Boolean = paramJSONObject.optBoolean("enableFaceDetect", true);
    paramQQVideoMaterial.jdField_d_of_type_Boolean = false;
    if (paramJSONObject.optInt("faceDetectorType", 0) == 1) {
      paramQQVideoMaterial.jdField_d_of_type_Boolean = true;
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("itemList");
        if ((paramJSONObject != null) && (paramQQVideoMaterial.jdField_c_of_type_Boolean))
        {
          i = 0;
          boolean bool1 = bool2;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            if ((localJSONObject == null) || (localJSONObject.optInt("triggerType") == 1)) {
              continue;
            }
            bool1 = true;
          }
          paramQQVideoMaterial.jdField_c_of_type_Boolean = bool1;
        }
      }
      catch (JSONException paramQQVideoMaterial)
      {
        int i;
        SdkContext.a().a().b("TemplateParser", paramQQVideoMaterial.toString());
        continue;
      }
      return true;
      i += 1;
    }
  }
  
  public static QQVideoMaterial b(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return paramQQVideoMaterial;
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("doodleImage");
        if (paramJSONObject != null)
        {
          DoodleItem localDoodleItem = new DoodleItem();
          localDoodleItem.jdField_a_of_type_Int = paramJSONObject.optInt("count");
          localDoodleItem.width = paramJSONObject.optInt("width");
          localDoodleItem.height = paramJSONObject.optInt("height");
          paramQQVideoMaterial.a(localDoodleItem);
          return paramQQVideoMaterial;
        }
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject = paramJSONObject;
        SdkContext.a().a().a("TemplateParser", "parseDoodleMaterial ", paramJSONObject);
        return paramQQVideoMaterial;
      }
      finally {}
    }
    return paramQQVideoMaterial;
  }
  
  public static QQVideoMaterial c(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return paramQQVideoMaterial;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("filterList");
        paramQQVideoMaterial.jdField_a_of_type_JavaUtilList.clear();
        if (paramJSONObject == null) {
          continue;
        }
        int i = 0;
        while (i < paramJSONObject.length())
        {
          paramQQVideoMaterial.jdField_a_of_type_JavaUtilList.add(paramJSONObject.getString(i));
          i += 1;
        }
        return paramQQVideoMaterial;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject = paramJSONObject;
        paramJSONObject.printStackTrace();
        return paramQQVideoMaterial;
      }
      finally {}
    }
  }
  
  public static QQVideoMaterial d(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return paramQQVideoMaterial;
    }
    for (;;)
    {
      NonFitItem[] arrayOfNonFitItem;
      int i;
      NonFitItem localNonFitItem;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("model2dAnimationList");
        if (paramJSONObject == null) {
          break;
        }
        arrayOfNonFitItem = new NonFitItem[paramJSONObject.length()];
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.getJSONObject(i);
          localNonFitItem = new NonFitItem();
          localNonFitItem.id = ((JSONObject)localObject).optString("id");
          localNonFitItem.name = ((JSONObject)localObject).optString("name");
          localNonFitItem.subFolder = localNonFitItem.id;
          localNonFitItem.stickerType = ((JSONObject)localObject).optInt("stickerType");
          localNonFitItem.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("triggerMode");
          localNonFitItem.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("clickMode");
          localNonFitItem.playCount = ((JSONObject)localObject).optInt("playCount");
          localNonFitItem.audio = ((JSONObject)localObject).optString("audio");
          localNonFitItem.blendMode = ((JSONObject)localObject).optInt("blendMode", -1);
          if (localNonFitItem.blendMode == -1) {
            localNonFitItem.blendMode = paramQQVideoMaterial.getBlendMode();
          }
          localNonFitItem.frameDuration = ((JSONObject)localObject).optDouble("frameDuration");
          localNonFitItem.frames = ((JSONObject)localObject).optInt("frames");
          localNonFitItem.width = ((JSONObject)localObject).optInt("width");
          localNonFitItem.height = ((JSONObject)localObject).optInt("height");
          localNonFitItem.sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
          localObject = ((JSONObject)localObject).optJSONArray("position");
          if (localObject != null)
          {
            localNonFitItem.position = new double[((JSONArray)localObject).length()];
            int j = 0;
            if (j < ((JSONArray)localObject).length())
            {
              localNonFitItem.position[j] = ((JSONArray)localObject).getDouble(j);
              j += 1;
              continue;
            }
          }
          else
          {
            localNonFitItem.position = new double[] { 0.0D, 0.0D };
          }
        }
        else
        {
          paramQQVideoMaterial.a(arrayOfNonFitItem);
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      finally
      {
        return paramQQVideoMaterial;
      }
      arrayOfNonFitItem[i] = localNonFitItem;
      i += 1;
    }
  }
  
  public static QQVideoMaterial e(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return paramQQVideoMaterial;
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("isShookHead", 0) == 1) {
          paramQQVideoMaterial.a(bool);
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      finally
      {
        return paramQQVideoMaterial;
      }
      bool = false;
    }
  }
  
  public static QQVideoMaterial f(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return paramQQVideoMaterial;
    }
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("children");
        if (paramJSONObject == null) {
          break;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.optJSONObject(i);
          if (localObject != null)
          {
            QQVideoMaterial.ChildPendant localChildPendant = new QQVideoMaterial.ChildPendant();
            localChildPendant.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
            localChildPendant.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("jumpType");
            localChildPendant.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("randomType");
            localChildPendant.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("maxPlayTime", 0L);
            localChildPendant.jdField_a_of_type_JavaUtilList = new ArrayList();
            JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("depends");
            int j;
            if (localJSONArray != null)
            {
              j = 0;
              if (j < localJSONArray.length())
              {
                localChildPendant.jdField_a_of_type_JavaUtilList.add(localJSONArray.optString(j));
                j += 1;
                continue;
              }
            }
            localChildPendant.jdField_b_of_type_JavaUtilList = new ArrayList();
            localObject = ((JSONObject)localObject).optJSONArray("next");
            if (localObject != null)
            {
              j = 0;
              if (j < ((JSONArray)localObject).length())
              {
                localChildPendant.jdField_b_of_type_JavaUtilList.add(((JSONArray)localObject).optString(j));
                j += 1;
                continue;
              }
            }
            localArrayList.add(localChildPendant);
          }
        }
        else
        {
          paramQQVideoMaterial.a(localArrayList);
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      finally
      {
        return paramQQVideoMaterial;
      }
      i += 1;
    }
  }
  
  private static QQVideoMaterial g(QQVideoMaterial paramQQVideoMaterial, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return paramQQVideoMaterial;
      try
      {
        Object localObject1 = paramJSONObject.optJSONObject("videoFaceCrop");
        if (localObject1 != null)
        {
          paramJSONObject = new BuckleFaceItem();
          paramJSONObject.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("frameDuration", 0);
          paramJSONObject.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("frames", 0);
          localObject1 = ((JSONObject)localObject1).optJSONArray("frameList");
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            BuckleFrameItem localBuckleFrameItem = new BuckleFrameItem();
            localBuckleFrameItem.jdField_a_of_type_Double = ((JSONObject)localObject2).optDouble("faceAngle", 0.0D);
            localBuckleFrameItem.jdField_b_of_type_Double = ((JSONObject)localObject2).optDouble("faceWidth", 0.0D);
            localBuckleFrameItem.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("index", 0);
            JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("nosePoint");
            int j;
            if (localJSONArray != null)
            {
              localBuckleFrameItem.jdField_a_of_type_ArrayOfDouble = new double[localJSONArray.length()];
              j = 0;
              while (j < localJSONArray.length())
              {
                localBuckleFrameItem.jdField_a_of_type_ArrayOfDouble[j] = localJSONArray.optDouble(j, 0.0D);
                j += 1;
              }
            }
            localBuckleFrameItem.jdField_a_of_type_ArrayOfDouble = new double[] { 0.0D, 0.0D };
            localObject2 = ((JSONObject)localObject2).optJSONArray("size");
            if (localObject2 != null)
            {
              localBuckleFrameItem.jdField_b_of_type_ArrayOfDouble = new double[((JSONArray)localObject2).length()];
              j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                localBuckleFrameItem.jdField_b_of_type_ArrayOfDouble[j] = ((JSONArray)localObject2).optDouble(j, 0.0D);
                j += 1;
              }
            }
            localBuckleFrameItem.jdField_b_of_type_ArrayOfDouble = new double[] { 0.0D, 0.0D };
            paramJSONObject.jdField_a_of_type_JavaUtilList.add(localBuckleFrameItem);
            i += 1;
          }
          paramQQVideoMaterial.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialBuckleFaceItem = paramJSONObject;
          return paramQQVideoMaterial;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return paramQQVideoMaterial;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser
 * JD-Core Version:    0.7.0.1
 */