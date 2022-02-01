package com.tencent.ttpic.filter.aifilter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.microrapid.opencv.ImageAutoProcessor;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.facebeauty.FaceParam;
import com.tencent.facebeauty.NormalizedFaceParam;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.AdjustRealConfig.TYPE;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.view.Photo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PhotoAIFilter
  extends AEChainI
  implements AICache
{
  public static AIImageFilterResult mAIImageFilterResult = new AIImageFilterResult();
  public static String mAIImageJsonPath = null;
  public static String mLutImagePath = null;
  private static String mTemperatureStatisticsPath = "";
  private float alpha = 1.0F;
  ExecutorService asyncThreadPool = Executors.newFixedThreadPool(4);
  private Frame cacheFrame;
  private NewEnhanceCategories curCategory = NewEnhanceCategories.COMMON;
  private int[] curve;
  private List<List<PointF>> facePoints;
  private AtomicBoolean isCancel = new AtomicBoolean(false);
  private boolean isFirstTime = true;
  private boolean lightnessProcessComplete = false;
  private String lutMessage;
  private PhotoAIFilter.AdjustLutListener mAdjustLutListener;
  private PTFaceAttr mFaceAttr;
  private FilterChain mFilterChain = new FilterChain(new ArrayList());
  private NetworkRequest mNetworkRequestListener;
  private Photo photo;
  @Nullable
  private PhotoAIFilter.PhotoAIFilterListener photoAiFilterListener;
  private Bitmap preProcessedBmp;
  private long startTime;
  private Semaphore stepProcessLock = new Semaphore(0);
  
  public PhotoAIFilter()
  {
    if (AEModule.getNetworkRequest() != null) {
      this.mNetworkRequestListener = AEModule.getNetworkRequest();
    }
  }
  
  private Bitmap flipVertical(Bitmap paramBitmap)
  {
    if (!BitmapUtils.isLegal(paramBitmap)) {
      return paramBitmap;
    }
    float f1 = paramBitmap.getWidth() / 2.0F;
    float f2 = paramBitmap.getHeight() / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, -1.0F, f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static List<AIImageFilterResult> getAIFilterConfigList(AIFilterConfigBean paramAIFilterConfigBean, String paramString)
  {
    if ((paramAIFilterConfigBean != null) && (paramAIFilterConfigBean.filters != null) && (!TextUtils.isEmpty(paramString)))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramAIFilterConfigBean.filters.iterator();
      for (;;)
      {
        paramAIFilterConfigBean = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramAIFilterConfigBean = (AIImageFilterResult)localIterator.next();
        if (paramString.equals(paramAIFilterConfigBean.sceneLabel))
        {
          if ("lookup".equals(paramAIFilterConfigBean.fid))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("assets://");
            localStringBuilder.append(paramAIFilterConfigBean.lutPath);
            paramAIFilterConfigBean.lutPath = localStringBuilder.toString();
          }
          localArrayList.add(paramAIFilterConfigBean);
        }
      }
    }
    paramAIFilterConfigBean = null;
    return paramAIFilterConfigBean;
  }
  
  public static RectF getFaceRectF(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      float f4 = 3.4028235E+38F;
      float f3 = 3.4028235E+38F;
      float f2 = 1.4E-45F;
      PointF localPointF;
      for (float f1 = 1.4E-45F; paramList.hasNext(); f1 = Math.max(f1, localPointF.y))
      {
        localPointF = (PointF)paramList.next();
        f4 = Math.min(f4, localPointF.x);
        f2 = Math.max(f2, localPointF.x);
        f3 = Math.min(f3, localPointF.y);
      }
      return new RectF(f4, f3, f2, f1);
    }
    return null;
  }
  
  public static final String getMultiPhotoClassifyUrl()
  {
    return "https://api.pengyou.com/go-cgi-bin/smart_filter/multi_image_classify";
  }
  
  private final JSONArray getNormalizedFaceRectsJson(PTFaceAttr paramPTFaceAttr)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator;
    if (paramPTFaceAttr != null) {
      localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
    }
    for (;;)
    {
      RectF localRectF;
      if (localIterator.hasNext())
      {
        localRectF = getFaceRectF((List)localIterator.next());
        if (localRectF == null) {}
      }
      else
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("x", localRectF.left / paramPTFaceAttr.getFaceDetWidth());
          localJSONObject.put("y", localRectF.top / paramPTFaceAttr.getFaceDetHeight());
          localJSONObject.put("w", Math.abs(localRectF.right - localRectF.left) / paramPTFaceAttr.getFaceDetWidth());
          localJSONObject.put("h", Math.abs(localRectF.bottom - localRectF.top) / paramPTFaceAttr.getFaceDetHeight());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException) {}
        return localJSONArray;
      }
    }
  }
  
  private final JSONArray getNormalizedFaceRectsJson(List<FaceParam> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if (paramList.hasNext())
      {
        localObject1 = (FaceParam)paramList.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Face origin(");
        ((StringBuilder)localObject2).append(((FaceParam)localObject1).mFace.left);
        ((StringBuilder)localObject2).append(", ");
        ((StringBuilder)localObject2).append(((FaceParam)localObject1).mFace.top);
        ((StringBuilder)localObject2).append(", ");
        ((StringBuilder)localObject2).append(((FaceParam)localObject1).mFace.width());
        ((StringBuilder)localObject2).append(", ");
        ((StringBuilder)localObject2).append(((FaceParam)localObject1).mFace.height());
        ((StringBuilder)localObject2).append(')');
        LogUtils.d("NewEnhance_Batch", ((StringBuilder)localObject2).toString());
        localObject1 = ((FaceParam)localObject1).normalizeFace();
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("x", ((NormalizedFaceParam)localObject1).getX());
        ((JSONObject)localObject2).put("y", ((NormalizedFaceParam)localObject1).getY());
        ((JSONObject)localObject2).put("w", ((NormalizedFaceParam)localObject1).getW());
        ((JSONObject)localObject2).put("h", ((NormalizedFaceParam)localObject1).getH());
        localJSONArray.put(localObject2);
      }
      catch (JSONException localJSONException) {}
      return localJSONArray;
    }
  }
  
  public static final String getSinglePhotoClassifyUrl()
  {
    return "https://api.pengyou.com/go-cgi-bin/smart_filter/single_image_classify";
  }
  
  private static String getTemperatureStatisticsFilePath()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getTemperatureStatisticsPath());
    ((StringBuilder)localObject).append("temperature.csv");
    localObject = ((StringBuilder)localObject).toString();
    if (!new File((String)localObject).exists()) {
      FileUtils.copyAssets(AEModule.getContext(), "statistics/temperature.csv", (String)localObject);
    }
    return localObject;
  }
  
  public static String getTemperatureStatisticsPath()
  {
    return mTemperatureStatisticsPath;
  }
  
  private final boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static AIFilterConfigBean parseAIFilterConfigParam(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString = FileOfflineUtil.readStringFromAssets(paramString);
    } else {
      paramString = FileOfflineUtil.readJsonStringFromFile(paramString);
    }
    if (paramString == null) {
      return null;
    }
    return (AIFilterConfigBean)GsonUtils.json2Obj(paramString, new PhotoAIFilter.1().getType());
  }
  
  public static List<AIImageFilterResult> parseAIFilterConfigParamLabel(String paramString)
  {
    Object localObject1 = NewEnhanceCategories.COMMON;
    Object localObject3 = NewEnhanceCategories.newEnhanceTypes.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (NewEnhanceCategories)((Iterator)localObject3).next();
      if (((NewEnhanceCategories)localObject2).serverLabel.equals(paramString))
      {
        mAIImageFilterResult.setSceneLabel(((NewEnhanceCategories)localObject2).filterType);
        localObject1 = localObject2;
      }
    }
    paramString = mAIImageJsonPath;
    localObject1 = ((NewEnhanceCategories)localObject1).filterType;
    Object localObject2 = VideoTemplateParser.decryptListener;
    int i = 0;
    localObject1 = VideoTemplateParser.readMaterialFile(paramString, (String)localObject1, false, (DecryptListener)localObject2);
    paramString = new ArrayList();
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      while (i < ((JSONObject)localObject1).getJSONArray("filters").length())
      {
        localObject3 = (String)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("fid");
        localObject2 = new AIImageFilterResult();
        ((AIImageFilterResult)localObject2).fid = ((String)localObject3);
        boolean bool = ((String)localObject3).equals("adjust");
        Object localObject4;
        if (bool)
        {
          localObject3 = new HashMap();
          localObject4 = (JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params");
          Iterator localIterator = ((JSONObject)localObject4).keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((HashMap)localObject3).put(str, ((JSONObject)localObject4).getString(str));
          }
          ((AIImageFilterResult)localObject2).setAdjustParam((HashMap)localObject3);
          paramString.add(localObject2);
        }
        else
        {
          bool = ((String)localObject3).equals("lookup");
          if (bool)
          {
            localObject3 = (JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params");
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(mLutImagePath);
            ((StringBuilder)localObject4).append(((JSONObject)localObject3).get("lut"));
            ((AIImageFilterResult)localObject2).setLutPath(((StringBuilder)localObject4).toString());
            ((AIImageFilterResult)localObject2).setLutStrengt(Float.parseFloat(((JSONObject)localObject3).getString("strength")) / 100.0F);
            paramString.add(localObject2);
          }
          else if (((String)localObject3).equals("faceBeauty"))
          {
            ((AIImageFilterResult)localObject2).setSmoothLevel(Float.parseFloat(((JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params")).getString("smooth")));
            paramString.add(localObject2);
          }
          else if (((String)localObject3).equals("xuanlan"))
          {
            ((AIImageFilterResult)localObject2).setLutStrengt(Float.parseFloat(((JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params")).getString("strength")) / 100.0F);
            paramString.add(localObject2);
          }
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static AIImageFilterResult parseAIImageParamsBySceneLabel(String paramString)
  {
    localAIImageFilterResult = new AIImageFilterResult();
    Object localObject1 = NewEnhanceCategories.COMMON;
    Object localObject3 = NewEnhanceCategories.newEnhanceTypes.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (NewEnhanceCategories)((Iterator)localObject3).next();
      if (((NewEnhanceCategories)localObject2).serverLabel.equals(paramString))
      {
        localAIImageFilterResult.setSceneLabel(((NewEnhanceCategories)localObject2).filterType);
        localObject1 = localObject2;
      }
    }
    paramString = new HashMap();
    Object localObject2 = mAIImageJsonPath;
    localObject1 = ((NewEnhanceCategories)localObject1).filterType;
    localObject3 = VideoTemplateParser.decryptListener;
    int i = 0;
    localObject1 = VideoTemplateParser.readMaterialFile((String)localObject2, (String)localObject1, false, (DecryptListener)localObject3);
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      while (i < ((JSONObject)localObject1).getJSONArray("filters").length())
      {
        localObject2 = (String)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("fid");
        boolean bool = ((String)localObject2).equals("adjust");
        Object localObject4;
        if (bool)
        {
          localObject3 = (JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params");
          localObject4 = ((JSONObject)localObject3).keys();
          while (((Iterator)localObject4).hasNext())
          {
            String str = (String)((Iterator)localObject4).next();
            paramString.put(str, ((JSONObject)localObject3).getString(str));
          }
          localAIImageFilterResult.setAdjustParam(paramString);
        }
        bool = ((String)localObject2).equals("lookup");
        if (bool)
        {
          localObject3 = (JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params");
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(mLutImagePath);
          ((StringBuilder)localObject4).append(((JSONObject)localObject3).get("lut"));
          localAIImageFilterResult.setLutPath(((StringBuilder)localObject4).toString());
          localAIImageFilterResult.setLutStrengt(Float.parseFloat(((JSONObject)localObject3).getString("strength")) / 100.0F);
        }
        if (((String)localObject2).equals("xuanlan")) {
          localAIImageFilterResult.setGlowStrength(Float.parseFloat(((JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params")).getString("strength")) / 100.0F);
        }
        if (((String)localObject2).equals("faceBeauty")) {
          localAIImageFilterResult.setSmoothLevel(Float.parseFloat(((JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params")).getString("smooth")));
        }
        i += 1;
      }
      return localAIImageFilterResult;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private final boolean parseClassifyResult(PhotoResult paramPhotoResult, ReportInfo paramReportInfo, boolean paramBoolean)
  {
    if (paramPhotoResult != null)
    {
      if (paramPhotoResult != null)
      {
        paramReportInfo.setExtInt2(Integer.parseInt(paramPhotoResult.getRetcode()));
        if (paramPhotoResult.getRetcode().equals("0"))
        {
          paramReportInfo = null;
          Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
          while (localIterator.hasNext())
          {
            NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
            if (localNewEnhanceCategories.serverLabel.equals(paramPhotoResult.getPituLabel())) {
              paramReportInfo = localNewEnhanceCategories;
            }
          }
          if (paramReportInfo != null) {
            this.curCategory = paramReportInfo;
          }
          if ((paramPhotoResult.getDisplayLabels() != null) && (paramPhotoResult.getDisplayLabels().length >= 2))
          {
            paramReportInfo = new StringBuilder();
            paramReportInfo.append(paramPhotoResult.getPituLabel());
            paramReportInfo.append(":");
            paramReportInfo.append(paramPhotoResult.getDisplayLabels()[0].getLabel());
            paramReportInfo.append(":");
            paramReportInfo.append(paramPhotoResult.getDisplayLabels()[1].getLabel());
            this.lutMessage = paramReportInfo.toString();
            paramReportInfo = this.photoAiFilterListener;
            if (paramReportInfo != null)
            {
              paramReportInfo.onReqSuccess(paramPhotoResult.getPituLabel(), paramPhotoResult.getDisplayLabels()[0].getLabel(), paramPhotoResult.getDisplayLabels()[1].getLabel());
              return true;
            }
          }
          else
          {
            paramReportInfo = this.photoAiFilterListener;
            if (paramReportInfo != null) {
              paramReportInfo.onReqSuccess(paramPhotoResult.getPituLabel(), paramPhotoResult.getPituLabel(), paramPhotoResult.getPituLabel());
            }
          }
          return true;
        }
        paramPhotoResult = this.photoAiFilterListener;
        if (paramPhotoResult != null)
        {
          paramPhotoResult.onAIFilterEnd(false);
          return false;
        }
      }
      else
      {
        paramPhotoResult = this.photoAiFilterListener;
        if (paramPhotoResult != null)
        {
          paramPhotoResult.onAIFilterEnd(false);
          return false;
        }
      }
    }
    else
    {
      paramPhotoResult = this.photoAiFilterListener;
      if (paramPhotoResult != null) {
        paramPhotoResult.onAIFilterEnd(false);
      }
    }
    return false;
  }
  
  public static ImageStatisticsData preprocessImages(List<Bitmap> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      String str = getTemperatureStatisticsFilePath();
      ImageStatisticsData localImageStatisticsData1 = new ImageStatisticsData(null);
      ImageStatisticsData localImageStatisticsData2 = new ImageStatisticsData(null);
      int i = 0;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ImageStatisticsData localImageStatisticsData3 = ImageAutoProcessor.getImageStatistics((Bitmap)localIterator.next(), str);
        localImageStatisticsData1.lightness += localImageStatisticsData3.lightness;
        localImageStatisticsData1.contrast += localImageStatisticsData3.contrast;
        localImageStatisticsData1.overexposure += localImageStatisticsData3.overexposure;
        localImageStatisticsData1.underexposure += localImageStatisticsData3.underexposure;
        if (localImageStatisticsData3.temperature > 0.0D)
        {
          i += 1;
          localImageStatisticsData1.temperature += localImageStatisticsData3.temperature;
        }
      }
      int j = paramList.size();
      double d2 = localImageStatisticsData1.lightness;
      double d1 = j;
      Double.isNaN(d1);
      localImageStatisticsData1.lightness = (d2 / d1);
      d2 = localImageStatisticsData1.contrast;
      Double.isNaN(d1);
      localImageStatisticsData1.contrast = (d2 / d1);
      d2 = localImageStatisticsData1.overexposure;
      Double.isNaN(d1);
      localImageStatisticsData1.overexposure = (d2 / d1);
      d2 = localImageStatisticsData1.underexposure;
      Double.isNaN(d1);
      localImageStatisticsData1.underexposure = (d2 / d1);
      if (i > 0)
      {
        d1 = localImageStatisticsData1.temperature;
        d2 = i;
        Double.isNaN(d2);
        localImageStatisticsData1.temperature = (d1 / d2);
      }
      localImageStatisticsData2.lightness = (localImageStatisticsData1.lightness * -99.129000000000005D * localImageStatisticsData1.lightness + localImageStatisticsData1.lightness * 44.652999999999999D + 18.248999999999999D);
      localImageStatisticsData2.contrast = (localImageStatisticsData1.contrast * -28.879000000000001D + 29.146000000000001D);
      localImageStatisticsData2.overexposure = (localImageStatisticsData1.overexposure * 10.445D * localImageStatisticsData1.overexposure + localImageStatisticsData1.overexposure * 0.632D - 26.337D);
      localImageStatisticsData2.underexposure = (localImageStatisticsData1.underexposure * 16.786999999999999D + 21.591999999999999D);
      localImageStatisticsData2.temperature = 0.0D;
      d1 = Math.min(localImageStatisticsData1.temperature, 10000.0D);
      if ((0.0D < d1) && (d1 < 3500.0D)) {
        localImageStatisticsData2.temperature = ((3500.0D - d1) * -0.02D);
      } else if (d1 > 7000.0D) {
        localImageStatisticsData2.temperature = ((d1 - 7000.0D) * 0.01D);
      }
      localImageStatisticsData2.lightness = Math.max(Math.min(localImageStatisticsData2.lightness, 30.0D), -30.0D);
      localImageStatisticsData2.contrast = Math.max(Math.min(localImageStatisticsData2.contrast, 30.0D), 0.0D);
      localImageStatisticsData2.overexposure = Math.max(Math.min(localImageStatisticsData2.overexposure, 0.0D), -50.0D);
      localImageStatisticsData2.underexposure = Math.max(Math.min(localImageStatisticsData2.underexposure, 40.0D), 0.0D);
      localImageStatisticsData2.temperature = Math.max(Math.min(localImageStatisticsData2.temperature, 30.0D), -100.0D);
      localImageStatisticsData2.saturation = 10.0D;
      return localImageStatisticsData2;
    }
    return null;
  }
  
  private final Triple<ReportInfo, Boolean, PhotoResult> requestClassify(Bitmap paramBitmap, PTFaceAttr paramPTFaceAttr)
  {
    paramBitmap = BitmapUtils.resizeBySidesRange(paramBitmap, 256, 640);
    ReportInfo localReportInfo = new ReportInfo("perf_cgi_request", "app_launch", "none");
    return new Triple(localReportInfo, Boolean.valueOf(false), requestPhotoClassifySingle(paramBitmap, getNormalizedFaceRectsJson(paramPTFaceAttr), localReportInfo));
  }
  
  private final Triple<ReportInfo, Boolean, PhotoResult> requestClassifyMulti(List<Bitmap> paramList, List<PTFaceAttr> paramList1)
  {
    ReportInfo localReportInfo = new ReportInfo("perf_cgi_request", "app_launch", "none");
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(BitmapUtils.resizeBySidesRange((Bitmap)paramList.next(), 256, 640));
      }
    }
    paramList = new ArrayList();
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext()) {
        paramList.add(getNormalizedFaceRectsJson((PTFaceAttr)paramList1.next()));
      }
    }
    return new Triple(localReportInfo, Boolean.valueOf(false), requestPhotoClassifyMulti(localArrayList, paramList, localReportInfo));
  }
  
  /* Error */
  private PhotoResult requestPhotoClassifyMulti(List<Bitmap> paramList, List<JSONArray> paramList1, ReportInfo paramReportInfo)
  {
    // Byte code:
    //   0: invokestatic 380	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   3: invokestatic 701	org/light/device/LightDeviceUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 263	org/json/JSONObject
    //   14: dup
    //   15: invokespecial 264	org/json/JSONObject:<init>	()V
    //   18: astore 10
    //   20: new 252	org/json/JSONArray
    //   23: dup
    //   24: invokespecial 253	org/json/JSONArray:<init>	()V
    //   27: astore 11
    //   29: iconst_0
    //   30: istore 6
    //   32: iload 6
    //   34: aload_1
    //   35: invokeinterface 218 1 0
    //   40: if_icmpge +209 -> 249
    //   43: aload_1
    //   44: iload 6
    //   46: invokeinterface 704 2 0
    //   51: checkcast 130	android/graphics/Bitmap
    //   54: iconst_2
    //   55: bipush 90
    //   57: invokestatic 708	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:getBase64FromBitmap	(Landroid/graphics/Bitmap;II)Ljava/lang/String;
    //   60: astore 9
    //   62: new 263	org/json/JSONObject
    //   65: dup
    //   66: invokespecial 264	org/json/JSONObject:<init>	()V
    //   69: astore 12
    //   71: aload 9
    //   73: invokevirtual 709	java/lang/String:length	()I
    //   76: istore 7
    //   78: iload 7
    //   80: i2d
    //   81: dstore 4
    //   83: dload 4
    //   85: invokestatic 605	java/lang/Double:isNaN	(D)Z
    //   88: pop
    //   89: dload 4
    //   91: ldc2_w 710
    //   94: dmul
    //   95: d2i
    //   96: istore 7
    //   98: aload 9
    //   100: invokevirtual 709	java/lang/String:length	()I
    //   103: istore 8
    //   105: iload 8
    //   107: i2d
    //   108: dstore 4
    //   110: dload 4
    //   112: invokestatic 605	java/lang/Double:isNaN	(D)Z
    //   115: pop
    //   116: dload 4
    //   118: ldc2_w 712
    //   121: dmul
    //   122: d2i
    //   123: istore 8
    //   125: new 194	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   132: astore 13
    //   134: aload 13
    //   136: aload 9
    //   138: iload 7
    //   140: iload 8
    //   142: iload 7
    //   144: iadd
    //   145: invokevirtual 717	java/lang/String:substring	(II)Ljava/lang/String;
    //   148: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 13
    //   154: ldc_w 719
    //   157: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 13
    //   163: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 724	com/tencent/ttpic/baseutils/encrypt/MD5Util:GetMD5Code	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 13
    //   171: aload 12
    //   173: ldc_w 726
    //   176: aload 9
    //   178: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload 12
    //   184: ldc_w 731
    //   187: aload 13
    //   189: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: aload_2
    //   194: ifnull +458 -> 652
    //   197: aload_2
    //   198: invokeinterface 218 1 0
    //   203: iload 6
    //   205: if_icmple +447 -> 652
    //   208: aload_2
    //   209: iload 6
    //   211: invokeinterface 704 2 0
    //   216: astore 9
    //   218: goto +3 -> 221
    //   221: aload 12
    //   223: ldc_w 733
    //   226: aload 9
    //   228: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload 11
    //   234: aload 12
    //   236: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   239: pop
    //   240: iload 6
    //   242: iconst_1
    //   243: iadd
    //   244: istore 6
    //   246: goto -214 -> 32
    //   249: aload 10
    //   251: ldc_w 735
    //   254: aload 11
    //   256: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload 10
    //   262: ldc_w 737
    //   265: aload_1
    //   266: invokeinterface 218 1 0
    //   271: invokevirtual 740	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   274: pop
    //   275: aload_0
    //   276: getfield 120	com/tencent/ttpic/filter/aifilter/PhotoAIFilter:mNetworkRequestListener	Lcom/tencent/ttpic/filter/aifilter/NetworkRequest;
    //   279: ifnull +380 -> 659
    //   282: aload_0
    //   283: getfield 120	com/tencent/ttpic/filter/aifilter/PhotoAIFilter:mNetworkRequestListener	Lcom/tencent/ttpic/filter/aifilter/NetworkRequest;
    //   286: invokestatic 742	com/tencent/ttpic/filter/aifilter/PhotoAIFilter:getMultiPhotoClassifyUrl	()Ljava/lang/String;
    //   289: aload 10
    //   291: invokevirtual 743	org/json/JSONObject:toString	()Ljava/lang/String;
    //   294: invokeinterface 749 3 0
    //   299: astore_1
    //   300: goto +3 -> 303
    //   303: aload_1
    //   304: ifnull +317 -> 621
    //   307: new 263	org/json/JSONObject
    //   310: dup
    //   311: aload_1
    //   312: invokespecial 445	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc_w 751
    //   320: invokevirtual 462	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   323: invokevirtual 754	java/lang/Object:toString	()Ljava/lang/String;
    //   326: astore 9
    //   328: aload_1
    //   329: ldc_w 756
    //   332: invokevirtual 462	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   335: checkcast 263	org/json/JSONObject
    //   338: ldc_w 758
    //   341: invokevirtual 761	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   344: astore_1
    //   345: aload_1
    //   346: ifnull +275 -> 621
    //   349: new 81	java/util/ArrayList
    //   352: dup
    //   353: invokespecial 82	java/util/ArrayList:<init>	()V
    //   356: astore 10
    //   358: new 81	java/util/ArrayList
    //   361: dup
    //   362: invokespecial 82	java/util/ArrayList:<init>	()V
    //   365: astore 11
    //   367: iconst_0
    //   368: istore 6
    //   370: iload 6
    //   372: aload_1
    //   373: invokevirtual 453	org/json/JSONArray:length	()I
    //   376: if_icmpge +215 -> 591
    //   379: aload_1
    //   380: iload 6
    //   382: invokevirtual 457	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   385: astore_2
    //   386: aload_2
    //   387: ifnonnull +6 -> 393
    //   390: goto +283 -> 673
    //   393: aload_2
    //   394: ldc_w 763
    //   397: invokevirtual 462	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   400: invokevirtual 754	java/lang/Object:toString	()Ljava/lang/String;
    //   403: astore 12
    //   405: aload_2
    //   406: ldc_w 765
    //   409: invokevirtual 761	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   412: astore 14
    //   414: iconst_2
    //   415: anewarray 552	com/tencent/ttpic/filter/aifilter/DisplayLabel
    //   418: astore 13
    //   420: aload_1
    //   421: astore_2
    //   422: aload 14
    //   424: ifnull +142 -> 566
    //   427: iconst_0
    //   428: istore 7
    //   430: aload_1
    //   431: astore_2
    //   432: iload 7
    //   434: aload 14
    //   436: invokevirtual 453	org/json/JSONArray:length	()I
    //   439: if_icmpge +127 -> 566
    //   442: aload 14
    //   444: iload 7
    //   446: invokevirtual 457	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   449: astore_2
    //   450: aload_2
    //   451: ifnonnull +6 -> 457
    //   454: goto +210 -> 664
    //   457: iload 7
    //   459: ifne +52 -> 511
    //   462: aload_3
    //   463: aload_2
    //   464: ldc_w 767
    //   467: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   470: ldc_w 772
    //   473: ldc_w 774
    //   476: invokevirtual 778	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   479: invokevirtual 781	com/tencent/ttpic/filter/aifilter/ReportInfo:setExtStr1	(Ljava/lang/String;)V
    //   482: aload 13
    //   484: iconst_0
    //   485: new 552	com/tencent/ttpic/filter/aifilter/DisplayLabel
    //   488: dup
    //   489: aload_2
    //   490: ldc_w 767
    //   493: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   496: aload_2
    //   497: ldc_w 783
    //   500: invokevirtual 787	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   503: d2f
    //   504: invokespecial 790	com/tencent/ttpic/filter/aifilter/DisplayLabel:<init>	(Ljava/lang/String;F)V
    //   507: aastore
    //   508: goto +156 -> 664
    //   511: iload 7
    //   513: iconst_1
    //   514: if_icmpne +150 -> 664
    //   517: aload_3
    //   518: aload_2
    //   519: ldc_w 767
    //   522: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: ldc_w 772
    //   528: ldc_w 774
    //   531: invokevirtual 778	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   534: invokevirtual 793	com/tencent/ttpic/filter/aifilter/ReportInfo:setExtStr2	(Ljava/lang/String;)V
    //   537: aload 13
    //   539: iconst_1
    //   540: new 552	com/tencent/ttpic/filter/aifilter/DisplayLabel
    //   543: dup
    //   544: aload_2
    //   545: ldc_w 767
    //   548: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   551: aload_2
    //   552: ldc_w 783
    //   555: invokevirtual 787	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   558: d2f
    //   559: invokespecial 790	com/tencent/ttpic/filter/aifilter/DisplayLabel:<init>	(Ljava/lang/String;F)V
    //   562: aastore
    //   563: goto +101 -> 664
    //   566: aload_2
    //   567: astore_1
    //   568: aload 10
    //   570: aload 13
    //   572: invokeinterface 211 2 0
    //   577: pop
    //   578: aload 11
    //   580: aload 12
    //   582: invokeinterface 211 2 0
    //   587: pop
    //   588: goto +85 -> 673
    //   591: new 525	com/tencent/ttpic/filter/aifilter/PhotoResult
    //   594: dup
    //   595: aload 9
    //   597: aload_0
    //   598: aload 11
    //   600: invokevirtual 797	com/tencent/ttpic/filter/aifilter/PhotoAIFilter:voteLable	(Ljava/util/List;)Ljava/lang/String;
    //   603: aload 10
    //   605: iconst_0
    //   606: invokeinterface 704 2 0
    //   611: checkcast 799	[Lcom/tencent/ttpic/filter/aifilter/DisplayLabel;
    //   614: invokespecial 802	com/tencent/ttpic/filter/aifilter/PhotoResult:<init>	(Ljava/lang/String;Ljava/lang/String;[Lcom/tencent/ttpic/filter/aifilter/DisplayLabel;)V
    //   617: astore_1
    //   618: goto +5 -> 623
    //   621: aconst_null
    //   622: astore_1
    //   623: aload_1
    //   624: areturn
    //   625: astore_1
    //   626: goto +14 -> 640
    //   629: getstatic 807	com/tencent/ttpic/openapi/util/FaceDetectUtil:TAG	Ljava/lang/String;
    //   632: ldc_w 809
    //   635: invokestatic 812	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aconst_null
    //   639: areturn
    //   640: goto +5 -> 645
    //   643: aload_1
    //   644: athrow
    //   645: goto -2 -> 643
    //   648: astore_1
    //   649: goto -20 -> 629
    //   652: ldc 14
    //   654: astore 9
    //   656: goto -435 -> 221
    //   659: aconst_null
    //   660: astore_1
    //   661: goto -358 -> 303
    //   664: iload 7
    //   666: iconst_1
    //   667: iadd
    //   668: istore 7
    //   670: goto -240 -> 430
    //   673: iload 6
    //   675: iconst_1
    //   676: iadd
    //   677: istore 6
    //   679: goto -309 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	PhotoAIFilter
    //   0	682	1	paramList	List<Bitmap>
    //   0	682	2	paramList1	List<JSONArray>
    //   0	682	3	paramReportInfo	ReportInfo
    //   81	36	4	d	double
    //   30	648	6	i	int
    //   76	593	7	j	int
    //   103	42	8	k	int
    //   60	595	9	localObject1	Object
    //   18	586	10	localObject2	Object
    //   27	572	11	localObject3	Object
    //   69	512	12	localObject4	Object
    //   132	439	13	localObject5	Object
    //   412	31	14	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   11	29	625	finally
    //   32	78	625	finally
    //   98	105	625	finally
    //   125	193	625	finally
    //   197	218	625	finally
    //   221	240	625	finally
    //   249	300	625	finally
    //   307	345	625	finally
    //   349	367	625	finally
    //   370	386	625	finally
    //   393	420	625	finally
    //   432	450	625	finally
    //   462	508	625	finally
    //   517	563	625	finally
    //   568	588	625	finally
    //   591	618	625	finally
    //   629	638	625	finally
    //   11	29	648	java/lang/Exception
    //   32	78	648	java/lang/Exception
    //   98	105	648	java/lang/Exception
    //   125	193	648	java/lang/Exception
    //   197	218	648	java/lang/Exception
    //   221	240	648	java/lang/Exception
    //   249	300	648	java/lang/Exception
    //   307	345	648	java/lang/Exception
    //   349	367	648	java/lang/Exception
    //   370	386	648	java/lang/Exception
    //   393	420	648	java/lang/Exception
    //   432	450	648	java/lang/Exception
    //   462	508	648	java/lang/Exception
    //   517	563	648	java/lang/Exception
    //   568	588	648	java/lang/Exception
    //   591	618	648	java/lang/Exception
  }
  
  /* Error */
  private PhotoResult requestPhotoClassifySingle(Bitmap paramBitmap, JSONArray paramJSONArray, ReportInfo paramReportInfo)
  {
    // Byte code:
    //   0: invokestatic 380	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   3: invokestatic 701	org/light/device/LightDeviceUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: iconst_2
    //   13: bipush 90
    //   15: invokestatic 708	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:getBase64FromBitmap	(Landroid/graphics/Bitmap;II)Ljava/lang/String;
    //   18: astore_1
    //   19: invokestatic 819	java/lang/System:currentTimeMillis	()J
    //   22: pop2
    //   23: new 263	org/json/JSONObject
    //   26: dup
    //   27: invokespecial 264	org/json/JSONObject:<init>	()V
    //   30: astore 8
    //   32: aload_1
    //   33: invokevirtual 709	java/lang/String:length	()I
    //   36: istore 6
    //   38: iload 6
    //   40: i2d
    //   41: dstore 4
    //   43: dload 4
    //   45: invokestatic 605	java/lang/Double:isNaN	(D)Z
    //   48: pop
    //   49: dload 4
    //   51: ldc2_w 710
    //   54: dmul
    //   55: d2i
    //   56: istore 6
    //   58: aload_1
    //   59: invokevirtual 709	java/lang/String:length	()I
    //   62: istore 7
    //   64: iload 7
    //   66: i2d
    //   67: dstore 4
    //   69: dload 4
    //   71: invokestatic 605	java/lang/Double:isNaN	(D)Z
    //   74: pop
    //   75: dload 4
    //   77: ldc2_w 712
    //   80: dmul
    //   81: d2i
    //   82: istore 7
    //   84: new 194	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   91: astore 9
    //   93: aload 9
    //   95: aload_1
    //   96: iload 6
    //   98: iload 7
    //   100: iload 6
    //   102: iadd
    //   103: invokevirtual 717	java/lang/String:substring	(II)Ljava/lang/String;
    //   106: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 9
    //   112: ldc_w 719
    //   115: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 9
    //   121: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 724	com/tencent/ttpic/baseutils/encrypt/MD5Util:GetMD5Code	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 9
    //   129: aload 8
    //   131: ldc_w 726
    //   134: aload_1
    //   135: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 8
    //   141: ldc_w 731
    //   144: aload 9
    //   146: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: aload 8
    //   152: ldc_w 733
    //   155: aload_2
    //   156: invokevirtual 729	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload_0
    //   161: getfield 120	com/tencent/ttpic/filter/aifilter/PhotoAIFilter:mNetworkRequestListener	Lcom/tencent/ttpic/filter/aifilter/NetworkRequest;
    //   164: ifnull +286 -> 450
    //   167: aload_0
    //   168: getfield 120	com/tencent/ttpic/filter/aifilter/PhotoAIFilter:mNetworkRequestListener	Lcom/tencent/ttpic/filter/aifilter/NetworkRequest;
    //   171: invokestatic 821	com/tencent/ttpic/filter/aifilter/PhotoAIFilter:getSinglePhotoClassifyUrl	()Ljava/lang/String;
    //   174: aload 8
    //   176: invokevirtual 743	org/json/JSONObject:toString	()Ljava/lang/String;
    //   179: invokeinterface 749 3 0
    //   184: astore_1
    //   185: goto +3 -> 188
    //   188: aload_1
    //   189: ifnull +247 -> 436
    //   192: new 263	org/json/JSONObject
    //   195: dup
    //   196: aload_1
    //   197: invokespecial 445	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   200: astore_2
    //   201: aload_2
    //   202: ldc_w 751
    //   205: invokevirtual 462	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   208: invokevirtual 754	java/lang/Object:toString	()Ljava/lang/String;
    //   211: astore_1
    //   212: new 263	org/json/JSONObject
    //   215: dup
    //   216: aload_2
    //   217: ldc_w 756
    //   220: invokevirtual 462	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   223: invokevirtual 754	java/lang/Object:toString	()Ljava/lang/String;
    //   226: invokespecial 445	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   229: astore 8
    //   231: aload 8
    //   233: ldc_w 763
    //   236: invokevirtual 462	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   239: invokevirtual 754	java/lang/Object:toString	()Ljava/lang/String;
    //   242: astore_2
    //   243: aload 8
    //   245: ldc_w 765
    //   248: invokevirtual 761	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   251: astore 8
    //   253: iconst_2
    //   254: anewarray 552	com/tencent/ttpic/filter/aifilter/DisplayLabel
    //   257: astore 9
    //   259: aload 8
    //   261: ifnull +175 -> 436
    //   264: iconst_0
    //   265: istore 6
    //   267: iload 6
    //   269: aload 8
    //   271: invokevirtual 453	org/json/JSONArray:length	()I
    //   274: if_icmpge +135 -> 409
    //   277: aload 8
    //   279: iload 6
    //   281: invokevirtual 457	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   284: astore 10
    //   286: aload 10
    //   288: ifnonnull +6 -> 294
    //   291: goto +164 -> 455
    //   294: iload 6
    //   296: ifne +55 -> 351
    //   299: aload_3
    //   300: aload 10
    //   302: ldc_w 767
    //   305: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   308: ldc_w 772
    //   311: ldc_w 774
    //   314: invokevirtual 778	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   317: invokevirtual 781	com/tencent/ttpic/filter/aifilter/ReportInfo:setExtStr1	(Ljava/lang/String;)V
    //   320: aload 9
    //   322: iconst_0
    //   323: new 552	com/tencent/ttpic/filter/aifilter/DisplayLabel
    //   326: dup
    //   327: aload 10
    //   329: ldc_w 767
    //   332: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: aload 10
    //   337: ldc_w 783
    //   340: invokevirtual 787	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   343: d2f
    //   344: invokespecial 790	com/tencent/ttpic/filter/aifilter/DisplayLabel:<init>	(Ljava/lang/String;F)V
    //   347: aastore
    //   348: goto +107 -> 455
    //   351: iload 6
    //   353: iconst_1
    //   354: if_icmpne +101 -> 455
    //   357: aload_3
    //   358: aload 10
    //   360: ldc_w 767
    //   363: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   366: ldc_w 772
    //   369: ldc_w 774
    //   372: invokevirtual 778	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   375: invokevirtual 793	com/tencent/ttpic/filter/aifilter/ReportInfo:setExtStr2	(Ljava/lang/String;)V
    //   378: aload 9
    //   380: iconst_1
    //   381: new 552	com/tencent/ttpic/filter/aifilter/DisplayLabel
    //   384: dup
    //   385: aload 10
    //   387: ldc_w 767
    //   390: invokevirtual 770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   393: aload 10
    //   395: ldc_w 783
    //   398: invokevirtual 787	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   401: d2f
    //   402: invokespecial 790	com/tencent/ttpic/filter/aifilter/DisplayLabel:<init>	(Ljava/lang/String;F)V
    //   405: aastore
    //   406: goto +49 -> 455
    //   409: new 525	com/tencent/ttpic/filter/aifilter/PhotoResult
    //   412: dup
    //   413: aload_1
    //   414: aload_2
    //   415: aload 9
    //   417: invokespecial 802	com/tencent/ttpic/filter/aifilter/PhotoResult:<init>	(Ljava/lang/String;Ljava/lang/String;[Lcom/tencent/ttpic/filter/aifilter/DisplayLabel;)V
    //   420: astore_1
    //   421: aload_1
    //   422: areturn
    //   423: astore_1
    //   424: goto +14 -> 438
    //   427: getstatic 807	com/tencent/ttpic/openapi/util/FaceDetectUtil:TAG	Ljava/lang/String;
    //   430: ldc_w 809
    //   433: invokestatic 812	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aconst_null
    //   437: areturn
    //   438: goto +5 -> 443
    //   441: aload_1
    //   442: athrow
    //   443: goto -2 -> 441
    //   446: astore_1
    //   447: goto -20 -> 427
    //   450: aconst_null
    //   451: astore_1
    //   452: goto -264 -> 188
    //   455: iload 6
    //   457: iconst_1
    //   458: iadd
    //   459: istore 6
    //   461: goto -194 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	PhotoAIFilter
    //   0	464	1	paramBitmap	Bitmap
    //   0	464	2	paramJSONArray	JSONArray
    //   0	464	3	paramReportInfo	ReportInfo
    //   41	35	4	d	double
    //   36	424	6	i	int
    //   62	41	7	j	int
    //   30	248	8	localObject1	Object
    //   91	325	9	localObject2	Object
    //   284	110	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   23	38	423	finally
    //   58	64	423	finally
    //   84	185	423	finally
    //   192	259	423	finally
    //   267	286	423	finally
    //   299	348	423	finally
    //   357	406	423	finally
    //   409	421	423	finally
    //   427	436	423	finally
    //   23	38	446	java/lang/Exception
    //   58	64	446	java/lang/Exception
    //   84	185	446	java/lang/Exception
    //   192	259	446	java/lang/Exception
    //   267	286	446	java/lang/Exception
    //   299	348	446	java/lang/Exception
    //   357	406	446	java/lang/Exception
    //   409	421	446	java/lang/Exception
  }
  
  public static void setAIImageJsonPath(String paramString)
  {
    mAIImageJsonPath = paramString;
  }
  
  public static void setLutImagePath(String paramString)
  {
    mLutImagePath = paramString;
  }
  
  public static void setTemperatureStatisticsPath(String paramString)
  {
    mTemperatureStatisticsPath = paramString;
  }
  
  public void apply()
  {
    if (!this.mIsApplied) {
      this.mIsApplied = true;
    }
  }
  
  public void clear()
  {
    Frame localFrame = this.cacheFrame;
    if (localFrame != null) {
      localFrame.clear();
    }
    this.cacheFrame = null;
  }
  
  public final PTFaceAttr doFaceDetect(Bitmap paramBitmap)
  {
    paramBitmap = AEStaticDetector.detectFace(paramBitmap);
    if (paramBitmap != null)
    {
      this.facePoints = paramBitmap.getAllFacePoints();
      return paramBitmap;
    }
    this.facePoints = new ArrayList();
    return paramBitmap;
  }
  
  public NewEnhanceCategories getCurCategory()
  {
    return this.curCategory;
  }
  
  public String getLutMessage()
  {
    return this.lutMessage;
  }
  
  @Nullable
  public final PhotoAIFilter.PhotoAIFilterListener getPhotoAiFilterListener()
  {
    return this.photoAiFilterListener;
  }
  
  public boolean hasCache()
  {
    return this.cacheFrame != null;
  }
  
  public void init(@NotNull String paramString) {}
  
  public boolean isAIFilterCancelled()
  {
    return this.isCancel.get();
  }
  
  public boolean isApplied()
  {
    return this.mIsApplied;
  }
  
  public Frame render(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public boolean requestClassifyLut(Bitmap paramBitmap)
  {
    paramBitmap = requestClassify(paramBitmap, this.mFaceAttr);
    ReportInfo localReportInfo = (ReportInfo)paramBitmap.getFirst();
    boolean bool = ((Boolean)paramBitmap.getSecond()).booleanValue();
    return parseClassifyResult((PhotoResult)paramBitmap.getThird(), localReportInfo, bool);
  }
  
  public boolean requestClassifyMultiLut(List<Bitmap> paramList, List<PTFaceAttr> paramList1)
  {
    paramList = requestClassifyMulti(paramList, paramList1);
    paramList1 = (ReportInfo)paramList.getFirst();
    boolean bool = ((Boolean)paramList.getSecond()).booleanValue();
    return parseClassifyResult((PhotoResult)paramList.getThird(), paramList1, bool);
  }
  
  public void resetCacheFrame()
  {
    Frame localFrame = this.cacheFrame;
    if (localFrame != null) {
      localFrame.clear();
    }
    this.cacheFrame = null;
  }
  
  public void setAdjustLutListener(PhotoAIFilter.AdjustLutListener paramAdjustLutListener)
  {
    this.mAdjustLutListener = paramAdjustLutListener;
  }
  
  public void setAlphaParam(float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public void setCancel(boolean paramBoolean)
  {
    this.isCancel.set(paramBoolean);
    if (paramBoolean) {
      this.stepProcessLock.release();
    }
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public final void setNetworkRequestListener(NetworkRequest paramNetworkRequest)
  {
    this.mNetworkRequestListener = paramNetworkRequest;
  }
  
  public final void setPhotoAiFilterListener(@Nullable PhotoAIFilter.PhotoAIFilterListener paramPhotoAIFilterListener)
  {
    this.photoAiFilterListener = paramPhotoAIFilterListener;
  }
  
  public void updateAdjustValue(ImageStatisticsData paramImageStatisticsData)
  {
    if (paramImageStatisticsData != null)
    {
      PhotoAIFilter.AdjustLutListener localAdjustLutListener = this.mAdjustLutListener;
      if (localAdjustLutListener != null)
      {
        localAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.COLOR_TEMPERATURE, (int)paramImageStatisticsData.temperature, false);
        this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.LIGHTNESS, (int)paramImageStatisticsData.lightness, false);
        this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.HIGHLIGHT, (int)paramImageStatisticsData.overexposure, false);
        this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.SHADOW, (int)paramImageStatisticsData.underexposure, false);
        this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.COMPARE, (int)paramImageStatisticsData.contrast, false);
        this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.SHARP, (int)paramImageStatisticsData.sharpness, false);
        this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.SATURATION, (int)paramImageStatisticsData.saturation, false);
        this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.FADE, (int)paramImageStatisticsData.colorfulness, false);
      }
    }
  }
  
  public String voteLable(List<String> paramList)
  {
    Object localObject1 = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      if (((Map)localObject1).containsKey(paramList.get(i))) {
        ((Map)localObject1).put(paramList.get(i), Integer.valueOf(((Integer)((Map)localObject1).get(paramList.get(i))).intValue() + 1));
      } else {
        ((Map)localObject1).put(paramList.get(i), Integer.valueOf(0));
      }
      i += 1;
    }
    Iterator localIterator = ((Map)localObject1).entrySet().iterator();
    paramList = (Map.Entry)localIterator.next();
    localObject1 = (String)paramList.getKey();
    paramList = (Integer)paramList.getValue();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Integer)((Map.Entry)localObject2).getValue();
      if (paramList.intValue() < ((Integer)localObject2).intValue())
      {
        paramList = (List<String>)localObject2;
        localObject1 = str;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.PhotoAIFilter
 * JD-Core Version:    0.7.0.1
 */