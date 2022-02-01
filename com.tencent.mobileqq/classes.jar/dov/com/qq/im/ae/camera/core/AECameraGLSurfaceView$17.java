package dov.com.qq.im.ae.camera.core;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView.AEEditMaterialSelectedListener;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.perf.IAEFpsManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoVoiceRecognizer;
import java.io.File;
import mqq.os.MqqHandler;

class AECameraGLSurfaceView$17
  implements Runnable
{
  AECameraGLSurfaceView$17(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString) {}
  
  public void run()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (Looper.myLooper() == null)
    {
      AEQLog.d("AECameraGLSurfaceView", "[setMaterial] Looper.myLooper() == null");
      Looper.prepare();
    }
    if ((this.this$0.isRecording()) || (!AECameraGLSurfaceView.access$1300(this.this$0))) {
      if (FeatureManager.Features.LIGHT_SDK.isFunctionReady()) {
        break label1013;
      }
    }
    label517:
    label561:
    label739:
    label1008:
    label1013:
    for (bool1 = FeatureManager.Features.LIGHT_SDK.init();; bool1 = true)
    {
      if ((AECameraGLSurfaceView.access$1400(this.this$0)) && (bool1)) {
        AEFilterProcessTex.a(AECameraGLSurfaceView.access$1500(this.this$0), VideoSDKMaterialParser.parseVideoMaterial(this.val$path, "params"));
      }
      AEQLog.d("AECameraGLSurfaceView", "[setMaterial]isRecording" + this.this$0.isRecording());
      AEQLog.d("AECameraGLSurfaceView", "[setMaterial]isAEKitAvailable" + AECameraGLSurfaceView.access$1300(this.this$0));
      return;
      Object localObject2 = this.val$path;
      AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)AECameraGLSurfaceView.access$000(this.this$0);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        AECameraGLSurfaceView.access$1600(this.this$0).a(null);
        localAEFilterProcessTex.jdField_a_of_type_Boolean = true;
        this.this$0.onSelectFaceEffect(null);
        AECameraGLSurfaceView.access$1702(this.this$0, false);
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.1(this, localAEFilterProcessTex));
        AECameraGLSurfaceView.access$1800(this.this$0, localAEFilterProcessTex);
        AECameraGLSurfaceView.access$1900(this.this$0).a();
        AECameraGLSurfaceView.access$502(this.this$0, null);
        AEQLog.d("AECameraGLSurfaceView", "[setMaterial] materialPath:" + (String)localObject2);
        return;
      }
      Object localObject1 = localObject2;
      if (!new File((String)localObject2).exists()) {
        localObject1 = (String)localObject2 + "Android";
      }
      if (!new File((String)localObject1).exists())
      {
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.2(this, localAEFilterProcessTex));
        AEQLog.d("AECameraGLSurfaceView", "[setMaterial] materialPath not exist");
        return;
      }
      localObject1 = VideoMaterial.loadLightAsset(this.val$path);
      if (localObject1 == null)
      {
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.3(this, localAEFilterProcessTex));
        AEQLog.d("AECameraGLSurfaceView", "[setMaterial] videoMaterial null");
        return;
      }
      AECameraGLSurfaceView.access$1600(this.this$0).a((VideoMaterial)localObject1);
      if (AEMaterialManager.a((VideoMaterial)localObject1))
      {
        AEQLog.a("PreCheckAERes", "[setMaterial] set special template");
        if (!AEResUtil.a(AEResInfo.c)) {
          break label912;
        }
        AEQLog.a("PreCheckAERes", "[setMaterial] version check success");
        if (FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject1))
        {
          AEQLog.a("PreCheckAERes", "[setMaterial] so load success");
          long l = AEResUtil.a((VideoMaterial)localObject1);
          if (l != 0L)
          {
            AEQLog.a("PreCheckAERes", "[setMaterial] bundleStatus not ready, go fetch bundles ...");
            AECameraGLSurfaceView.access$2000(this.this$0, HardCodeUtil.a(2131689839));
            AEResUtil.a(this.this$0.getContext(), l);
            return;
          }
          AEQLog.a("PreCheckAERes", "[setMaterial] bundleStatus ready, apply material...");
        }
      }
      else
      {
        if (((VideoMaterial)localObject1).isWatermarkMaterial())
        {
          if (AECameraGLSurfaceView.access$2100(this.this$0)) {
            break label967;
          }
          if (!AECameraGLSurfaceView.access$1400(this.this$0)) {
            break label923;
          }
          AECameraGLSurfaceView.access$2202(this.this$0, true);
          AEQLog.b("AECameraGLSurfaceView", "updateWMProps requestLocationPermission true, but is paused, skip");
        }
        localObject2 = AEMaterialManager.b();
        boolean bool3;
        if (localObject2 != null)
        {
          bool3 = ((VideoMaterial)localObject1).isEditableWatermark();
          ((AEMaterialMetaData)localObject2).jdField_a_of_type_Boolean = bool3;
          AEQLog.b("AECameraGLSurfaceView", "editable id: " + ((AEMaterialMetaData)localObject2).jdField_a_of_type_JavaLangString + " enable: " + bool3);
        }
        if (AEMaterialManager.a() != null)
        {
          localObject2 = AEMaterialManager.a();
          bool3 = ((VideoMaterial)localObject1).isEditableWatermark();
          ((AEMaterialMetaData)localObject2).jdField_a_of_type_Boolean = bool3;
          if (AECameraGLSurfaceView.access$2600(this.this$0) != null)
          {
            AEQLog.b("AECameraGLSurfaceView", "editable id: " + ((AEMaterialMetaData)localObject2).jdField_a_of_type_JavaLangString + " enable: " + bool3);
            AECameraGLSurfaceView.access$2600(this.this$0).a(bool3);
          }
        }
        if (!((VideoMaterial)localObject1).isAudio2textMaterial()) {
          break label995;
        }
        AECameraGLSurfaceView.access$1900(this.this$0).a(this.this$0.getContext(), this.this$0.audioCapture);
        AECameraGLSurfaceView.access$1702(this.this$0, ((VideoMaterial)localObject1).needFaceInfo());
        this.this$0.onSelectFaceEffect((VideoMaterial)localObject1);
        AECameraGLSurfaceView.access$1800(this.this$0, localAEFilterProcessTex);
        if (((VideoMaterial)localObject1).isEditableWatermark())
        {
          bool1 = bool2;
          if (AECameraGLSurfaceView.access$500(this.this$0) != null) {
            if (AECameraGLSurfaceView.access$500(this.this$0).getId().equals(((VideoMaterial)localObject1).getId())) {
              break label1008;
            }
          }
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        AEQLog.b("AECameraGLSurfaceView", "[setMaterial] isWatermarkEditable case, applyMaterial=" + bool1);
        AECameraGLSurfaceView.access$502(this.this$0, (VideoMaterial)localObject1);
        if (bool1) {
          this.this$0.queueEvent(new AECameraGLSurfaceView.17.6(this, (VideoMaterial)localObject1, localAEFilterProcessTex));
        }
        if ((!AEDashboardUtil.a()) || (TextUtils.isEmpty(this.val$path))) {
          break;
        }
        AEDashboardUtil.a(this.this$0.debugInfoCallback, 1500L);
        return;
        AEQLog.d("PreCheckAERes", "[setMaterial] so load failed");
        break label517;
        AEQLog.d("PreCheckAERes", "[setMaterial] version check failed");
        break label517;
        AECameraGLSurfaceView.access$2202(this.this$0, false);
        AECameraGLSurfaceView.access$2102(this.this$0, true);
        AEQLog.b("AECameraGLSurfaceView", "updateWMProps requestLocationPermission true");
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.17.4(this));
        break label561;
        if (!AECameraGLSurfaceView.access$2400(this.this$0)) {
          break label561;
        }
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.17.5(this));
        break label561;
        AECameraGLSurfaceView.access$1900(this.this$0).a();
        break label739;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.17
 * JD-Core Version:    0.7.0.1
 */