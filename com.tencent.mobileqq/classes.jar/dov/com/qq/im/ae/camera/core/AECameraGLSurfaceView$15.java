package dov.com.qq.im.ae.camera.core;

import android.os.Looper;
import android.text.TextUtils;
import anvx;
import bbge;
import bnax;
import bnaz;
import bndr;
import bnep;
import bnkb;
import bnke;
import bnkt;
import bnky;
import bnqh;
import bnrh;
import bprj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import java.io.File;
import mqq.os.MqqHandler;

class AECameraGLSurfaceView$15
  implements Runnable
{
  AECameraGLSurfaceView$15(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString) {}
  
  public void run()
  {
    if (Looper.myLooper() == null)
    {
      bnrh.d("AECameraGLSurfaceView", "[setMaterial] Looper.myLooper() == null");
      Looper.prepare();
    }
    if ((this.this$0.isRecording()) || (!AECameraGLSurfaceView.access$1300(this.this$0)))
    {
      if (AECameraGLSurfaceView.access$1400(this.this$0)) {
        bnaz.a(AECameraGLSurfaceView.access$1500(this.this$0), VideoSDKMaterialParser.parseVideoMaterial(this.val$path, "params"));
      }
      bnrh.d("AECameraGLSurfaceView", "[setMaterial]isRecording" + this.this$0.isRecording());
      bnrh.d("AECameraGLSurfaceView", "[setMaterial]isAEKitAvailable" + AECameraGLSurfaceView.access$1300(this.this$0));
      return;
    }
    Object localObject2 = this.val$path;
    bnaz localbnaz = (bnaz)AECameraGLSurfaceView.access$000(this.this$0);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      AECameraGLSurfaceView.access$1600(this.this$0).a(null);
      localbnaz.jdField_a_of_type_Boolean = true;
      this.this$0.onSelectFaceEffect(null);
      AECameraGLSurfaceView.access$1702(this.this$0, false);
      this.this$0.queueEvent(new AECameraGLSurfaceView.15.1(this, localbnaz));
      AECameraGLSurfaceView.access$1800(this.this$0, localbnaz);
      AECameraGLSurfaceView.access$1900(this.this$0).a();
      AECameraGLSurfaceView.access$502(this.this$0, null);
      bnrh.d("AECameraGLSurfaceView", "[setMaterial] materialPath:" + (String)localObject2);
      return;
    }
    Object localObject1 = localObject2;
    if (!new File((String)localObject2).exists()) {
      localObject1 = (String)localObject2 + "Android";
    }
    if (!new File((String)localObject1).exists())
    {
      bnrh.d("AECameraGLSurfaceView", "[setMaterial] materialPath not exist");
      return;
    }
    localObject2 = AEMaterialConfigParser.a((String)localObject1);
    if (localObject2 == null)
    {
      bnrh.d("AECameraGLSurfaceView", "[setMaterial] videoMaterial null");
      return;
    }
    if (((VideoMaterial)localObject2).getGameParams() != null)
    {
      bnrh.d("AECameraGLSurfaceView", "[setMaterial] gameplay");
      return;
    }
    AECameraGLSurfaceView.access$1600(this.this$0).a((VideoMaterial)localObject2);
    ((VideoMaterial)localObject2).setDataPath((String)localObject1);
    if (bnkb.a((VideoMaterial)localObject2))
    {
      if (bnky.a(bnkt.c))
      {
        if (!FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject2))
        {
          bnrh.d("AECameraGLSurfaceView", "[Special Material] load so failed");
          if ((VideoMaterialUtil.is3DMaterial((VideoMaterial)localObject2)) && (bnkb.b()))
          {
            bnky.a(this.this$0.getContext());
            bnrh.d("AECameraGLSurfaceView", "[setMaterial] support 3D And StartDownLoad");
            AECameraGLSurfaceView.access$2000(this.this$0, anvx.a(2131689799));
            return;
          }
          if ((VideoMaterialUtil.is3DMaterial((VideoMaterial)localObject2)) && (!bnkb.b()))
          {
            bnrh.d("AECameraGLSurfaceView", "[setMaterial] Not support 3D !!");
            AECameraGLSurfaceView.access$2000(this.this$0, anvx.a(2131689798));
            return;
          }
          bnrh.d("AECameraGLSurfaceView", "[setMaterial] try download B package");
          AECameraGLSurfaceView.access$2000(this.this$0, anvx.a(2131689799));
          bnky.a(this.this$0.getContext());
          return;
        }
        bnrh.d("AECameraGLSurfaceView", "[Special Material] load success");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject2))
      {
        LogicDataManager.getInstance().init((VideoMaterial)localObject2);
        if (AECameraGLSurfaceView.access$2100(this.this$0)) {
          break label1069;
        }
        if (!AECameraGLSurfaceView.access$1400(this.this$0)) {
          break label1025;
        }
        AECameraGLSurfaceView.access$2202(this.this$0, true);
        bnrh.b("AECameraGLSurfaceView", "updateWMProps requestLocationPermission true, but is paused, skip");
      }
      label557:
      localObject1 = bnkb.b();
      if (localObject1 != null)
      {
        bool = VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2);
        ((bnke)localObject1).jdField_a_of_type_Boolean = bool;
        bnrh.b("AECameraGLSurfaceView", "editable id: " + ((bnke)localObject1).jdField_a_of_type_JavaLangString + " enable: " + bool);
      }
      if (bnkb.a() != null)
      {
        localObject1 = bnkb.a();
        bool = VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2);
        ((bnke)localObject1).jdField_a_of_type_Boolean = bool;
        if (AECameraGLSurfaceView.access$2400(this.this$0) != null)
        {
          bnrh.b("AECameraGLSurfaceView", "editable id: " + ((bnke)localObject1).jdField_a_of_type_JavaLangString + " enable: " + bool);
          AECameraGLSurfaceView.access$2400(this.this$0).a(bool);
        }
      }
      if (this.this$0.mAudioChangeCapture != null)
      {
        this.this$0.mAudioChangeCapture.a(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2), ((VideoMaterial)localObject2).getVoicekind(), ((VideoMaterial)localObject2).getEnvironment());
        if ((!AECameraGLSurfaceView.access$2500(this.this$0)) || (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2))) {
          break label1087;
        }
        localObject1 = AECameraGLSurfaceView.access$700(this.this$0).jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".aac";
        this.this$0.audioCapture.a(true, (String)localObject1);
        this.this$0.mAudioChangeCapture.a(false, null);
      }
      label809:
      if (!VideoMaterialUtil.isAudio2textMaterial((VideoMaterial)localObject2)) {
        break label1188;
      }
      AECameraGLSurfaceView.access$1900(this.this$0).a(this.this$0.getContext(), this.this$0.audioCapture);
      label840:
      AECameraGLSurfaceView.access$1702(this.this$0, ((VideoMaterial)localObject2).needFaceInfo());
      this.this$0.onSelectFaceEffect((VideoMaterial)localObject2);
      AECameraGLSurfaceView.access$1800(this.this$0, localbnaz);
      if (!VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2)) {
        break label1201;
      }
      if ((AECameraGLSurfaceView.access$500(this.this$0) != null) && (AECameraGLSurfaceView.access$500(this.this$0).getId().equals(((VideoMaterial)localObject2).getId()))) {
        break label1206;
      }
    }
    label1025:
    label1069:
    label1201:
    label1206:
    for (boolean bool = true;; bool = false)
    {
      bnrh.b("AECameraGLSurfaceView", "[setMaterial] isWatermarkEditable case, applyMaterial=" + bool);
      for (;;)
      {
        AECameraGLSurfaceView.access$502(this.this$0, (VideoMaterial)localObject2);
        if (bool) {
          this.this$0.queueEvent(new AECameraGLSurfaceView.15.4(this, (VideoMaterial)localObject2, localbnaz));
        }
        if ((!bnep.a()) || (TextUtils.isEmpty(this.val$path))) {
          break;
        }
        bnep.a(this.this$0.debugInfoCallback, 1500L);
        return;
        bnrh.d("AECameraGLSurfaceView", "[Special Material] version error");
        AECameraGLSurfaceView.access$2000(this.this$0, anvx.a(2131689799));
        bnky.a(this.this$0.getContext());
        return;
        AECameraGLSurfaceView.access$2202(this.this$0, false);
        AECameraGLSurfaceView.access$2102(this.this$0, true);
        bnrh.b("AECameraGLSurfaceView", "updateWMProps requestLocationPermission true");
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.15.2(this));
        break label557;
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.15.3(this));
        break label557;
        label1087:
        if ((AECameraGLSurfaceView.access$2500(this.this$0)) && (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2)))
        {
          localObject1 = AECameraGLSurfaceView.access$700(this.this$0).jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".aac";
          this.this$0.audioCapture.a(false, null);
          this.this$0.mAudioChangeCapture.a(true, (String)localObject1);
          break label809;
        }
        this.this$0.mAudioChangeCapture.a(false, null);
        break label809;
        AECameraGLSurfaceView.access$1900(this.this$0).a();
        break label840;
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.15
 * JD-Core Version:    0.7.0.1
 */