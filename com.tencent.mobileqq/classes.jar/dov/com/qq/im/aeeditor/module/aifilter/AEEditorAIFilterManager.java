package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import dov.com.qq.im.ae.config.CameraPeakServiceHandler;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AEEditorAIFilterManager
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorAIFilterManager.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private ConcurrentHashMap<Integer, AIFilterProxyBase> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private long b;
  
  private AEEditorAIFilterManager()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(AEEditorResourceManager.a().b() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static AEEditorAIFilterManager a()
  {
    return AEEditorAIFilterManager.InstanceHolder.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      AEQLog.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
    }
    while (paramImageStatisticsData == null) {
      return localHashMap;
    }
    localHashMap.put("brightValue", String.valueOf(paramImageStatisticsData.lightness));
    localHashMap.put("contrastValue", String.valueOf(paramImageStatisticsData.contrast));
    localHashMap.put("saturationValue", String.valueOf(paramImageStatisticsData.saturation));
    localHashMap.put("scaleCValue", String.valueOf(paramImageStatisticsData.temperature));
    localHashMap.put("sharpenValue", String.valueOf(paramImageStatisticsData.sharpness));
    localHashMap.put("highlightValue", String.valueOf(paramImageStatisticsData.overexposure));
    localHashMap.put("shadowValue", String.valueOf(paramImageStatisticsData.underexposure));
    localHashMap.put("fadeValue", String.valueOf(paramImageStatisticsData.colorfulness));
    return localHashMap;
  }
  
  private void a(AppInterface paramAppInterface, ArrayList<SmartFilterReqItem> paramArrayList, AEEditorAIFilterManager.AIRequestCallback paramAIRequestCallback)
  {
    if (paramAppInterface == null)
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((CameraPeakServiceHandler)paramAppInterface.getBusinessHandler(PeakAppInterface.d)).a(paramArrayList, paramAIRequestCallback);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      AEQLog.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
    }
    while (paramImageStatisticsData == null) {
      return arrayOfFloat;
    }
    arrayOfFloat[0] = ((float)paramImageStatisticsData.lightness);
    arrayOfFloat[1] = ((float)paramImageStatisticsData.temperature);
    arrayOfFloat[2] = ((float)paramImageStatisticsData.overexposure);
    arrayOfFloat[3] = ((float)paramImageStatisticsData.underexposure);
    arrayOfFloat[4] = ((float)paramImageStatisticsData.contrast);
    arrayOfFloat[5] = ((float)paramImageStatisticsData.saturation);
    arrayOfFloat[6] = ((float)paramImageStatisticsData.sharpness);
    arrayOfFloat[7] = ((float)paramImageStatisticsData.colorfulness);
    return arrayOfFloat;
  }
  
  public void a()
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry != null) && (localEntry.getValue() != null)) {
          ((AIFilterProxyBase)localEntry.getValue()).a();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AEQLog.d(jdField_a_of_type_JavaLangString, "onResponseFailed: errorCode=" + paramInt1);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {}
    AIFilterProxyBase localAIFilterProxyBase;
    do
    {
      return;
      localAIFilterProxyBase = (AIFilterProxyBase)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2));
    } while (localAIFilterProxyBase == null);
    localAIFilterProxyBase.b();
    AEEditorAIFilterManager.AIFilterObserver localAIFilterObserver = localAIFilterProxyBase.a();
    if (localAIFilterObserver != null)
    {
      localAIFilterObserver.a(paramInt1, localAIFilterProxyBase.a());
      return;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, AIFilterProxyBase paramAIFilterProxyBase)
  {
    if (paramAIFilterProxyBase == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "processAIFilter: " + paramAIFilterProxyBase.getClass().getSimpleName());
    AEEditorAIFilterManager.AIFilterObserver localAIFilterObserver = paramAIFilterProxyBase.a();
    boolean bool;
    if (paramAIFilterProxyBase.a())
    {
      bool = AEEditorResourceManager.a().b();
      if (bool) {
        break label104;
      }
      AEQLog.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
      if (localAIFilterObserver != null) {
        localAIFilterObserver.aJ_();
      }
    }
    label104:
    do
    {
      do
      {
        return;
        bool = AEEditorResourceManager.a().a();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label135;
        }
        AEQLog.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (localAIFilterObserver == null);
      localAIFilterObserver.aJ_();
      return;
      if (NetworkUtil.a()) {
        break label160;
      }
    } while (localAIFilterObserver == null);
    label135:
    localAIFilterObserver.a(-4, paramAIFilterProxyBase.a());
    return;
    label160:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramAIFilterProxyBase.a(paramContext, new AEEditorAIFilterManager.1(this, paramAppInterface, paramAIFilterProxyBase, localAIFilterObserver));
  }
  
  public void a(List<AIFilterResponse> paramList, int paramInt)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {}
    AIFilterProxyBase localAIFilterProxyBase;
    do
    {
      return;
      localAIFilterProxyBase = (AIFilterProxyBase)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    } while (localAIFilterProxyBase == null);
    AEQLog.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
    paramList = localAIFilterProxyBase.a(paramList);
    localAIFilterProxyBase.b();
    this.b = System.currentTimeMillis();
    AEQLog.b(jdField_a_of_type_JavaLangString, "AIFilterPref: cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    AEEditorAIFilterManager.AIFilterObserver localAIFilterObserver = localAIFilterProxyBase.a();
    if (localAIFilterObserver != null)
    {
      AEQLog.b(jdField_a_of_type_JavaLangString, "has observer");
      if (paramList != null)
      {
        AEQLog.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
        localAIFilterObserver.a(0, paramList);
      }
      for (;;)
      {
        localAIFilterProxyBase.a();
        return;
        AEQLog.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
        localAIFilterObserver.a(-5, localAIFilterProxyBase.a());
      }
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager
 * JD-Core Version:    0.7.0.1
 */