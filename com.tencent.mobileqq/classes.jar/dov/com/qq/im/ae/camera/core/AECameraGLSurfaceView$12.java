package dov.com.qq.im.ae.camera.core;

import android.os.Looper;
import android.text.TextUtils;
import anni;
import bamb;
import bnhe;
import bnhn;
import bnid;
import bnlm;
import bnpc;
import bnpt;
import bnpy;
import bnvg;
import bnzb;
import bqgu;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import java.io.File;
import mqq.os.MqqHandler;

public class AECameraGLSurfaceView$12
  implements Runnable
{
  AECameraGLSurfaceView$12(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString) {}
  
  public void run()
  {
    if (Looper.myLooper() == null)
    {
      bnzb.d("AECameraGLSurfaceView", "[setMaterial] Looper.myLooper() == null");
      Looper.prepare();
    }
    if ((this.this$0.b()) || (!AECameraGLSurfaceView.c(this.this$0)))
    {
      bnzb.d("AECameraGLSurfaceView", "[setMaterial]isRecording" + this.this$0.b());
      bnzb.d("AECameraGLSurfaceView", "[setMaterial]isAEKitAvailable" + AECameraGLSurfaceView.c(this.this$0));
      return;
    }
    Object localObject2 = this.a;
    bnid localbnid = (bnid)AECameraGLSurfaceView.a(this.this$0);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      AECameraGLSurfaceView.a(this.this$0).a(null);
      localbnid.a = true;
      AECameraGLSurfaceView.a(this.this$0, null);
      AECameraGLSurfaceView.c(this.this$0, false);
      this.this$0.queueEvent(new AECameraGLSurfaceView.12.1(this, localbnid));
      AECameraGLSurfaceView.a(this.this$0, localbnid);
      AECameraGLSurfaceView.a(this.this$0).a();
      AECameraGLSurfaceView.a(this.this$0, null);
      bnzb.d("AECameraGLSurfaceView", "[setMaterial] materialPath:" + (String)localObject2);
      return;
    }
    Object localObject1 = localObject2;
    if (!new File((String)localObject2).exists()) {
      localObject1 = (String)localObject2 + "Android";
    }
    if (!new File((String)localObject1).exists())
    {
      bnzb.d("AECameraGLSurfaceView", "[setMaterial] materialPath not exist");
      return;
    }
    localObject2 = AEMaterialConfigParser.a((String)localObject1);
    if (localObject2 == null)
    {
      bnzb.d("AECameraGLSurfaceView", "[setMaterial] videoMaterial null");
      return;
    }
    if (((VideoMaterial)localObject2).getGameParams() != null)
    {
      bnzb.d("AECameraGLSurfaceView", "[setMaterial] gameplay");
      return;
    }
    AECameraGLSurfaceView.a(this.this$0).a((VideoMaterial)localObject2);
    ((VideoMaterial)localObject2).setDataPath((String)localObject1);
    label526:
    label657:
    label688:
    label753:
    int i;
    if (bnpc.a((VideoMaterial)localObject2))
    {
      if (bnpy.a(bnpt.c))
      {
        if (!FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject2))
        {
          bnzb.d("AECameraGLSurfaceView", "[Special Material] load so failed");
          if ((VideoMaterialUtil.is3DMaterial((VideoMaterial)localObject2)) && (bnpc.a()))
          {
            bnpy.a(this.this$0.getContext());
            bnzb.d("AECameraGLSurfaceView", "[setMaterial] support 3D And StartDownLoad");
            AECameraGLSurfaceView.a(this.this$0, anni.a(2131689774));
            return;
          }
          if ((VideoMaterialUtil.is3DMaterial((VideoMaterial)localObject2)) && (!bnpc.a()))
          {
            bnzb.d("AECameraGLSurfaceView", "[setMaterial] Not support 3D !!");
            AECameraGLSurfaceView.a(this.this$0, anni.a(2131689773));
            return;
          }
          bnzb.d("AECameraGLSurfaceView", "[setMaterial] try download B package");
          AECameraGLSurfaceView.a(this.this$0, anni.a(2131689774));
          bnpy.a(this.this$0.getContext());
          return;
        }
        bnzb.d("AECameraGLSurfaceView", "[Special Material] load success");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject2))
      {
        LogicDataManager.getInstance().init((VideoMaterial)localObject2);
        if (AECameraGLSurfaceView.d(this.this$0)) {
          break label884;
        }
        AECameraGLSurfaceView.d(this.this$0, true);
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.12.2(this));
      }
      if (bnpc.a() != null) {
        bnpc.a().a = VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2);
      }
      if (AECameraGLSurfaceView.a(this.this$0) != null)
      {
        AECameraGLSurfaceView.a(this.this$0).a(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2), ((VideoMaterial)localObject2).getVoicekind(), ((VideoMaterial)localObject2).getEnvironment());
        if ((!AECameraGLSurfaceView.e(this.this$0)) || (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2))) {
          break label910;
        }
        localObject1 = AECameraGLSurfaceView.a(this.this$0).a + File.separator + System.currentTimeMillis() + ".aac";
        AECameraGLSurfaceView.a(this.this$0).a(true, (String)localObject1);
        AECameraGLSurfaceView.a(this.this$0).a(false, null);
      }
      if (!VideoMaterialUtil.isAudio2textMaterial((VideoMaterial)localObject2)) {
        break label1011;
      }
      AECameraGLSurfaceView.a(this.this$0).a(this.this$0.getContext(), AECameraGLSurfaceView.a(this.this$0));
      AECameraGLSurfaceView.c(this.this$0, ((VideoMaterial)localObject2).needFaceInfo());
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      AECameraGLSurfaceView.a(this.this$0, localbnid);
      if (!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "back")) {
        break label1024;
      }
      if (AECameraGLSurfaceView.a(this.this$0) != null) {
        AECameraGLSurfaceView.a(this.this$0).a(2);
      }
      if (!VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2)) {
        break label1063;
      }
      if ((AECameraGLSurfaceView.a(this.this$0) != null) && (AECameraGLSurfaceView.a(this.this$0).getId().equals(((VideoMaterial)localObject2).getId()))) {
        break label1068;
      }
      i = 1;
    }
    for (;;)
    {
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      if (i != 0) {
        this.this$0.queueEvent(new AECameraGLSurfaceView.12.4(this, (VideoMaterial)localObject2, localbnid));
      }
      if ((!bnlm.a()) || (TextUtils.isEmpty(this.a))) {
        break;
      }
      bnlm.a(this.this$0.a, 1500L);
      return;
      bnzb.d("AECameraGLSurfaceView", "[Special Material] version error");
      AECameraGLSurfaceView.a(this.this$0, anni.a(2131689774));
      bnpy.a(this.this$0.getContext());
      return;
      label884:
      bnzb.b("AECameraGLSurfaceView", "updateWMProps mIsTryLocationPermission false");
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.12.3(this));
      break label526;
      label910:
      if ((AECameraGLSurfaceView.e(this.this$0)) && (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2)))
      {
        localObject1 = AECameraGLSurfaceView.a(this.this$0).a + File.separator + System.currentTimeMillis() + ".aac";
        AECameraGLSurfaceView.a(this.this$0).a(false, null);
        AECameraGLSurfaceView.a(this.this$0).a(true, (String)localObject1);
        break label657;
      }
      AECameraGLSurfaceView.a(this.this$0).a(false, null);
      break label657;
      label1011:
      AECameraGLSurfaceView.a(this.this$0).a();
      break label688;
      label1024:
      if ((!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "front")) || (AECameraGLSurfaceView.a(this.this$0) == null)) {
        break label753;
      }
      AECameraGLSurfaceView.a(this.this$0).a(1);
      break label753;
      label1063:
      i = 1;
      continue;
      label1068:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.12
 * JD-Core Version:    0.7.0.1
 */