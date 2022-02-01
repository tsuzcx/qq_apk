package dov.com.qq.im.aeeditor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.weseevideo.common.utils.GsonUtils;
import com.tencent.weseevideo.model.MediaModel;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver.AEEditorOrderListener;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorVideoInfo;
import dov.com.qq.im.aeeditor.listener.AETavSessionStatusListener;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AEEditorProcessManager
  implements AEEditorOrderBroadcastReceiver.AEEditorOrderListener, AETavSessionStatusListener
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, AEEditorVideoInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<AEEditorVideoInfo> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean = false;
  private final long b;
  
  private AEEditorProcessManager()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.registerSelf(BaseApplicationImpl.getContext());
  }
  
  public static AEEditorProcessManager a()
  {
    return AEEditorProcessManager.InstanceHolder.a;
  }
  
  private void a(@NonNull AEEditorVideoInfo paramAEEditorVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEEditorVideoInfo);
      paramAEEditorVideoInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      paramAEEditorVideoInfo.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    long l = System.currentTimeMillis();
    if ((localAEEditorVideoInfo != null) && (Math.abs(l - localAEEditorVideoInfo.jdField_b_of_type_Long) > 5000L))
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localAEEditorVideoInfo);
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEEditorVideoInfo);
      c();
      return;
    }
    AEQLog.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(paramAEEditorVideoInfo);
  }
  
  private void b(@NonNull AEEditorVideoInfo paramAEEditorVideoInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEEditorVideoInfo.jdField_e_of_type_JavaLangString);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_materialid", paramAEEditorVideoInfo.g);
    localIntent.putExtra("generate_materialname", paramAEEditorVideoInfo.h);
    localIntent.putExtra("generate_filterid", paramAEEditorVideoInfo.i);
    localIntent.putExtra("generate_scheme", paramAEEditorVideoInfo.j);
    localIntent.putExtra("generate_show_circle_take_same", paramAEEditorVideoInfo.jdField_b_of_type_Int);
    localIntent.putExtra("generate_path", paramAEEditorVideoInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", paramAEEditorVideoInfo.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("generate_progress", paramAEEditorVideoInfo.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", paramAEEditorVideoInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("generate_errorcode", paramAEEditorVideoInfo.jdField_a_of_type_Int);
    localIntent.putExtra("generate_source_path", paramAEEditorVideoInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("generate_KuolieId", paramAEEditorVideoInfo.k);
    localIntent.putExtra("generate_centerX", paramAEEditorVideoInfo.jdField_b_of_type_Float);
    localIntent.putExtra("generate_centerY", paramAEEditorVideoInfo.jdField_c_of_type_Float);
    localIntent.putExtra("generate_widthScale", paramAEEditorVideoInfo.jdField_e_of_type_Float);
    localIntent.putExtra("generate_HeightScale", paramAEEditorVideoInfo.jdField_f_of_type_Float);
    localIntent.putExtra("generate_rotate", paramAEEditorVideoInfo.jdField_d_of_type_Float);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0) {
      AEQLog.b("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    AEEditorVideoInfo localAEEditorVideoInfo;
    do
    {
      return;
      localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    } while (localAEEditorVideoInfo == null);
    AEQLog.b("AEEditorProcessManager", "[tryStartNext] next mission");
    localAEEditorVideoInfo.jdField_b_of_type_Long = System.currentTimeMillis();
    localAEEditorVideoInfo.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  private void d(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!paramString.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      paramString = paramString.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.a();
      if (paramString != null) {
        paramString.cancel();
      }
    }
  }
  
  private void e(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[save mission]");
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAEEditorVideoInfo != null)
    {
      AECameraPrefsUtil.a().a(paramString, localAEEditorVideoInfo.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 4);
      AECameraPrefsUtil.a().a(paramString + "sourcePath", localAEEditorVideoInfo.jdField_b_of_type_JavaLangString, 4);
      AECameraPrefsUtil.a().a(paramString + "outputPath", localAEEditorVideoInfo.jdField_c_of_type_JavaLangString, 4);
      AECameraPrefsUtil.a().a(paramString + "thumbPath", localAEEditorVideoInfo.jdField_d_of_type_JavaLangString, 4);
      AECameraPrefsUtil.a().a(paramString + "status", localAEEditorVideoInfo.jdField_e_of_type_JavaLangString, 4);
      AECameraPrefsUtil.a().a(paramString + "materialID", localAEEditorVideoInfo.g, 4);
      AECameraPrefsUtil.a().a(paramString + "materialName", localAEEditorVideoInfo.h, 4);
      AECameraPrefsUtil.a().a(paramString + "filterID", localAEEditorVideoInfo.i, 4);
      AECameraPrefsUtil.a().a(paramString + "scheme", localAEEditorVideoInfo.j, 4);
      AECameraPrefsUtil.a().a(paramString + "showCircleTakeSame", localAEEditorVideoInfo.jdField_b_of_type_Int, 4);
      AECameraPrefsUtil.a().a(paramString + "mKuolieId", localAEEditorVideoInfo.k, 4);
      AECameraPrefsUtil.a().a(paramString + "mKuolieCenterX", localAEEditorVideoInfo.jdField_b_of_type_Float, 4);
      AECameraPrefsUtil.a().a(paramString + "mKuolieCenterY", localAEEditorVideoInfo.jdField_c_of_type_Float, 4);
      AECameraPrefsUtil.a().a(paramString + "mKuolieWidthScale", localAEEditorVideoInfo.jdField_e_of_type_Float, 4);
      AECameraPrefsUtil.a().a(paramString + "mKuolieHeightScale", localAEEditorVideoInfo.jdField_f_of_type_Float, 4);
      AECameraPrefsUtil.a().a(paramString + "mKuolieRotate", localAEEditorVideoInfo.jdField_d_of_type_Float, 4);
    }
  }
  
  private void f(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[remove mission]");
    AECameraPrefsUtil.a().a(paramString, 4);
    AECameraPrefsUtil.a().a(paramString + "sourcePath", 4);
    AECameraPrefsUtil.a().a(paramString + "outputPath", 4);
    AECameraPrefsUtil.a().a(paramString + "thumbPath", 4);
    AECameraPrefsUtil.a().a(paramString + "status", 4);
    AECameraPrefsUtil.a().a(paramString + "mKuolieId", 4);
    AECameraPrefsUtil.a().a(paramString + "mKuolieCenterX", 4);
    AECameraPrefsUtil.a().a(paramString + "mKuolieCenterY", 4);
    AECameraPrefsUtil.a().a(paramString + "mKuolieWidthScale", 4);
    AECameraPrefsUtil.a().a(paramString + "mKuolieHeightScale", 4);
    AECameraPrefsUtil.a().a(paramString + "mKuolieRotate", 4);
  }
  
  @Nullable
  public MediaModel a(@NonNull String paramString)
  {
    paramString = AECameraPrefsUtil.a().a(paramString, "", 4);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  public AEEditorVideoInfo a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!AEKitForQQ.a()) {
      AEQLog.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AEEditorProcessManager.1(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        AEQLog.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        AEQLog.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        AEQLog.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAEEditorVideoInfo == null)
    {
      String str1 = AECameraPrefsUtil.a().a(paramString + "sourcePath", "", 4);
      String str2 = AECameraPrefsUtil.a().a(paramString + "outputPath", "", 4);
      String str3 = AECameraPrefsUtil.a().a(paramString + "thumbPath", "", 4);
      Object localObject = AECameraPrefsUtil.a().a(paramString + "status", "", 4);
      String str4 = AECameraPrefsUtil.a().a(paramString + "materialID", "", 4);
      String str5 = AECameraPrefsUtil.a().a(paramString + "materialName", "", 4);
      String str6 = AECameraPrefsUtil.a().a(paramString + "filterID", "", 4);
      String str7 = AECameraPrefsUtil.a().a(paramString + "scheme", "", 4);
      int i = AECameraPrefsUtil.a().a(paramString + "showCircleTakeSame", 0, 4);
      String str8 = AECameraPrefsUtil.a().a(paramString + "mKuolieId", "", 4);
      float f1 = AECameraPrefsUtil.a().a(paramString + "mKuolieCenterX", 0.0F, 4);
      float f2 = AECameraPrefsUtil.a().a(paramString + "mKuolieCenterY", 0.0F, 4);
      float f3 = AECameraPrefsUtil.a().a(paramString + "mKuolieWidthScale", 0.0F, 4);
      float f4 = AECameraPrefsUtil.a().a(paramString + "mKuolieHeightScale", 0.0F, 4);
      float f5 = AECameraPrefsUtil.a().a(paramString + "mKuolieRotate", 0.0F, 4);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new AEEditorVideoInfo(str4, str5, str6, str7, i, paramString, str1, str2, str3, null, str8, f1, f2, f3, f4, f5);
        paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.jdField_a_of_type_Int = -2;
        AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new AEEditorVideoInfo(str4, str5, str6, str7, i, paramString, str1, str2, str3, null, str8, f1, f2, f3, f4, f5);
        paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localAEEditorVideoInfo.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_ERROR";
        localAEEditorVideoInfo.jdField_a_of_type_Int = -2;
        AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localAEEditorVideoInfo);
        return;
      }
      a(str4, str5, str6, str7, i, paramString, str1, str2, str3, (MediaModel)localObject, str8, f1, f2, f3, f4, f5);
      return;
    }
    AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(localAEEditorVideoInfo.g, localAEEditorVideoInfo.h, localAEEditorVideoInfo.i, localAEEditorVideoInfo.j, localAEEditorVideoInfo.jdField_b_of_type_Int, paramString, localAEEditorVideoInfo.jdField_b_of_type_JavaLangString, localAEEditorVideoInfo.jdField_c_of_type_JavaLangString, localAEEditorVideoInfo.jdField_d_of_type_JavaLangString, localAEEditorVideoInfo.jdField_a_of_type_ComTencentWeseevideoModelMediaModel, localAEEditorVideoInfo.k, localAEEditorVideoInfo.jdField_b_of_type_Float, localAEEditorVideoInfo.jdField_c_of_type_Float, localAEEditorVideoInfo.jdField_e_of_type_Float, localAEEditorVideoInfo.jdField_f_of_type_Float, localAEEditorVideoInfo.jdField_d_of_type_Float);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.jdField_a_of_type_Float = paramFloat;
      long l = System.currentTimeMillis();
      if (Math.abs(l - paramString.jdField_a_of_type_Long) > 1000L)
      {
        paramString.jdField_a_of_type_Long = l;
        b(paramString);
      }
    }
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_ERROR";
      paramString.jdField_a_of_type_Float = 0.0F;
      paramString.jdField_a_of_type_Int = paramInt;
      b(paramString);
      this.jdField_a_of_type_JavaUtilQueue.remove(paramString);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localAEEditorVideoInfo != null)
    {
      localAEEditorVideoInfo.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_READY";
      localAEEditorVideoInfo.jdField_a_of_type_JavaLangString = paramString2;
      localAEEditorVideoInfo.jdField_a_of_type_Float = 1.0F;
      b(localAEEditorVideoInfo);
      AECameraPrefsUtil.a().a(paramString1 + "status", localAEEditorVideoInfo.jdField_e_of_type_JavaLangString, 4);
      this.jdField_a_of_type_JavaUtilQueue.remove(localAEEditorVideoInfo);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt, @NonNull String paramString5, @NonNull String paramString6, @NonNull String paramString7, @NonNull String paramString8, @NonNull MediaModel paramMediaModel, String paramString9, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString5) == null)
    {
      paramString1 = new AEEditorVideoInfo(paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramMediaModel, paramString9, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
      this.jdField_a_of_type_JavaUtilMap.put(paramString5, paramString1);
      e(paramString5);
    }
    for (;;)
    {
      paramString1.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable = new AEEditorGenerateRunnable(paramString5, paramString6, paramString7, paramMediaModel, this);
      a(paramString1);
      do
      {
        return;
        paramString1 = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString5);
        if ((paramString1.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_ERROR")) || (paramString1.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_CANEL"))) {
          break;
        }
      } while (!paramString1.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_READY"));
      b(paramString1);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((AEEditorVideoInfo)localEntry.getValue()).jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((AEEditorVideoInfo)localEntry.getValue()).jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.unRegisterSelf(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_JavaUtilQueue.clear();
  }
  
  public void b(@NonNull String paramString)
  {
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
  
  public void c(@NonNull String paramString)
  {
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_CANEL";
      paramString.jdField_a_of_type_Float = 0.0F;
      this.jdField_a_of_type_JavaUtilQueue.remove(paramString);
      c();
    }
  }
  
  public void onAEEditorCancel(String paramString)
  {
    d(paramString);
  }
  
  public void onAEEditorRemove(String paramString)
  {
    f(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorProcessManager
 * JD-Core Version:    0.7.0.1
 */