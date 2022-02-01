package dov.com.qq.im.ae.camera.core;

import amtj;
import android.os.Looper;
import android.text.TextUtils;
import azzv;
import blno;
import blnq;
import blqi;
import blrg;
import bluy;
import blvb;
import bmax;
import bmbx;
import bobr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.io.File;
import mqq.os.MqqHandler;

class AECameraGLSurfaceView$13
  implements Runnable
{
  AECameraGLSurfaceView$13(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString) {}
  
  public void run()
  {
    if (Looper.myLooper() == null)
    {
      bmbx.d("AECameraGLSurfaceView", "[setMaterial] Looper.myLooper() == null");
      Looper.prepare();
    }
    if ((this.this$0.isRecording()) || (!AECameraGLSurfaceView.access$1200(this.this$0)))
    {
      bmbx.d("AECameraGLSurfaceView", "[setMaterial]isRecording" + this.this$0.isRecording());
      bmbx.d("AECameraGLSurfaceView", "[setMaterial]isAEKitAvailable" + AECameraGLSurfaceView.access$1200(this.this$0));
      return;
    }
    Object localObject2 = this.val$path;
    blnq localblnq = (blnq)AECameraGLSurfaceView.access$000(this.this$0);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      AECameraGLSurfaceView.access$1300(this.this$0).a(null);
      localblnq.jdField_a_of_type_Boolean = true;
      this.this$0.onSelectFaceEffect(null);
      AECameraGLSurfaceView.access$1402(this.this$0, false);
      this.this$0.queueEvent(new AECameraGLSurfaceView.13.1(this, localblnq));
      AECameraGLSurfaceView.access$1500(this.this$0, localblnq);
      AECameraGLSurfaceView.access$1600(this.this$0).a();
      AECameraGLSurfaceView.access$1702(this.this$0, null);
      bmbx.d("AECameraGLSurfaceView", "[setMaterial] materialPath:" + (String)localObject2);
      return;
    }
    Object localObject1 = localObject2;
    if (!new File((String)localObject2).exists()) {
      localObject1 = (String)localObject2 + "Android";
    }
    if (!new File((String)localObject1).exists())
    {
      bmbx.d("AECameraGLSurfaceView", "[setMaterial] materialPath not exist");
      return;
    }
    localObject2 = AEMaterialConfigParser.a((String)localObject1);
    if (localObject2 == null)
    {
      bmbx.d("AECameraGLSurfaceView", "[setMaterial] videoMaterial null");
      return;
    }
    if (((VideoMaterial)localObject2).getGameParams() != null)
    {
      bmbx.d("AECameraGLSurfaceView", "[setMaterial] gameplay");
      return;
    }
    AECameraGLSurfaceView.access$1300(this.this$0).a((VideoMaterial)localObject2);
    ((VideoMaterial)localObject2).setDataPath((String)localObject1);
    label543:
    label744:
    int i;
    if (bluy.a((VideoMaterial)localObject2))
    {
      if (AEResUtil.checkAEResVersionOK(AEResInfo.AE_RES_ADDITIONAL_PACKAGE))
      {
        if (!FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject2))
        {
          bmbx.d("AECameraGLSurfaceView", "[Special Material] load so failed");
          if ((VideoMaterialUtil.is3DMaterial((VideoMaterial)localObject2)) && (bluy.b()))
          {
            AEResUtil.tryDownloadAEResAdditionPackage(this.this$0.getContext());
            bmbx.d("AECameraGLSurfaceView", "[setMaterial] support 3D And StartDownLoad");
            AECameraGLSurfaceView.access$1800(this.this$0, amtj.a(2131689790));
            return;
          }
          if ((VideoMaterialUtil.is3DMaterial((VideoMaterial)localObject2)) && (!bluy.b()))
          {
            bmbx.d("AECameraGLSurfaceView", "[setMaterial] Not support 3D !!");
            AECameraGLSurfaceView.access$1800(this.this$0, amtj.a(2131689789));
            return;
          }
          bmbx.d("AECameraGLSurfaceView", "[setMaterial] try download B package");
          AECameraGLSurfaceView.access$1800(this.this$0, amtj.a(2131689790));
          AEResUtil.tryDownloadAEResAdditionPackage(this.this$0.getContext());
          return;
        }
        bmbx.d("AECameraGLSurfaceView", "[Special Material] load success");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject2))
      {
        LogicDataManager.getInstance().init((VideoMaterial)localObject2);
        if (AECameraGLSurfaceView.access$1900(this.this$0)) {
          break label942;
        }
        AECameraGLSurfaceView.access$1902(this.this$0, true);
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.13.2(this));
      }
      if (bluy.a() != null)
      {
        localObject1 = bluy.a();
        boolean bool = VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2);
        ((blvb)localObject1).jdField_a_of_type_Boolean = bool;
        if (AECameraGLSurfaceView.access$2000(this.this$0) != null)
        {
          bmbx.b("AECameraGLSurfaceView", "editable id: " + ((blvb)localObject1).jdField_a_of_type_JavaLangString + " enable: " + bool);
          AECameraGLSurfaceView.access$2000(this.this$0).a(bool);
        }
      }
      if (this.this$0.mAudioChangeCapture != null)
      {
        this.this$0.mAudioChangeCapture.a(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2), ((VideoMaterial)localObject2).getVoicekind(), ((VideoMaterial)localObject2).getEnvironment());
        if ((!AECameraGLSurfaceView.access$2100(this.this$0)) || (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2))) {
          break label968;
        }
        localObject1 = AECameraGLSurfaceView.access$600(this.this$0).jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".aac";
        this.this$0.audioCapture.a(true, (String)localObject1);
        this.this$0.mAudioChangeCapture.a(false, null);
      }
      if (!VideoMaterialUtil.isAudio2textMaterial((VideoMaterial)localObject2)) {
        break label1070;
      }
      AECameraGLSurfaceView.access$1600(this.this$0).a(this.this$0.getContext(), this.this$0.audioCapture);
      label776:
      AECameraGLSurfaceView.access$1402(this.this$0, ((VideoMaterial)localObject2).needFaceInfo());
      this.this$0.onSelectFaceEffect((VideoMaterial)localObject2);
      AECameraGLSurfaceView.access$1500(this.this$0, localblnq);
      if (!VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2)) {
        break label1083;
      }
      if ((AECameraGLSurfaceView.access$1700(this.this$0) != null) && (AECameraGLSurfaceView.access$1700(this.this$0).getId().equals(((VideoMaterial)localObject2).getId()))) {
        break label1088;
      }
      i = 1;
    }
    for (;;)
    {
      AECameraGLSurfaceView.access$1702(this.this$0, (VideoMaterial)localObject2);
      if (i != 0) {
        this.this$0.queueEvent(new AECameraGLSurfaceView.13.4(this, (VideoMaterial)localObject2, localblnq));
      }
      if ((!blrg.a()) || (TextUtils.isEmpty(this.val$path))) {
        break;
      }
      blrg.a(this.this$0.debugInfoCallback, 1500L);
      return;
      bmbx.d("AECameraGLSurfaceView", "[Special Material] version error");
      AECameraGLSurfaceView.access$1800(this.this$0, amtj.a(2131689790));
      AEResUtil.tryDownloadAEResAdditionPackage(this.this$0.getContext());
      return;
      label942:
      bmbx.b("AECameraGLSurfaceView", "updateWMProps mIsTryLocationPermission false");
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.13.3(this));
      break label543;
      label968:
      if ((AECameraGLSurfaceView.access$2100(this.this$0)) && (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2)))
      {
        localObject1 = AECameraGLSurfaceView.access$600(this.this$0).jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".aac";
        this.this$0.audioCapture.a(false, null);
        this.this$0.mAudioChangeCapture.a(true, (String)localObject1);
        break label744;
      }
      this.this$0.mAudioChangeCapture.a(false, null);
      break label744;
      label1070:
      AECameraGLSurfaceView.access$1600(this.this$0).a();
      break label776;
      label1083:
      i = 1;
      continue;
      label1088:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.13
 * JD-Core Version:    0.7.0.1
 */