package dov.com.qq.im.ae.camera.core;

import ajyc;
import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import avrr;
import bijj;
import bijp;
import bimt;
import biqk;
import biwg;
import bkyn;
import bkzt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
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
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    if ((this.this$0.b()) || (!AECameraGLSurfaceView.b(this.this$0))) {
      QLog.d("AECameraGLSurfaceView", 1, new Object[] { "setFaceEffect fail ", Boolean.valueOf(this.this$0.b()) });
    }
    Object localObject2;
    bijp localbijp;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = this.a;
        localbijp = (bijp)AECameraGLSurfaceView.a(this.this$0);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          AECameraGLSurfaceView.a(this.this$0).a(null);
          AECameraGLSurfaceView.a(this.this$0, null);
          AECameraGLSurfaceView.a(this.this$0, false);
          this.this$0.queueEvent(new AECameraGLSurfaceView.12.1(this, localbijp));
          AECameraGLSurfaceView.a(this.this$0).a();
          AECameraGLSurfaceView.a(this.this$0, null);
          return;
        }
        localObject1 = localObject2;
        if (!new File((String)localObject2).exists()) {
          localObject1 = (String)localObject2 + "Android";
        }
      } while (!new File((String)localObject1).exists());
      localObject2 = AEMaterialConfigParser.a((String)localObject1);
    } while ((localObject2 == null) || (((VideoMaterial)localObject2).getGameParams() != null));
    AECameraGLSurfaceView.a(this.this$0).a((VideoMaterial)localObject2);
    ((VideoMaterial)localObject2).setDataPath((String)localObject1);
    if ((!FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject2)) || ((bkyn.a((VideoMaterial)localObject2)) && (!bkyn.a())))
    {
      AECameraGLSurfaceView.a(this.this$0, ajyc.a(2131689826));
      bkyn.a((VideoMaterial)localObject2, (Activity)this.this$0.getContext(), ((VideoMaterial)localObject2).getDataPath());
      return;
    }
    if ((VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject2)) && (!AECameraGLSurfaceView.c(this.this$0)))
    {
      AECameraGLSurfaceView.b(this.this$0, true);
      LogicDataManager.getInstance().init((VideoMaterial)localObject2);
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.12.2(this));
    }
    if (biqk.a() != null) {
      biqk.a().a = VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2);
    }
    if (AECameraGLSurfaceView.a(this.this$0) != null) {
      AECameraGLSurfaceView.a(this.this$0).a(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2), ((VideoMaterial)localObject2).getVoicekind(), ((VideoMaterial)localObject2).getEnvironment());
    }
    label412:
    label466:
    int i;
    if (VideoMaterialUtil.isAudio2textMaterial((VideoMaterial)localObject2))
    {
      AECameraGLSurfaceView.a(this.this$0).a(this.this$0.getContext(), AECameraGLSurfaceView.a(this.this$0));
      AECameraGLSurfaceView.a(this.this$0, ((VideoMaterial)localObject2).needFaceInfo());
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      if (!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "back")) {
        break label579;
      }
      if (bijj.a().b()) {
        bijj.a().c(AECameraGLSurfaceView.d(this.this$0));
      }
      if (!VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2)) {
        break label617;
      }
      if ((AECameraGLSurfaceView.a(this.this$0) != null) && (AECameraGLSurfaceView.a(this.this$0).getId().equals(((VideoMaterial)localObject2).getId()))) {
        break label622;
      }
      i = 1;
    }
    for (;;)
    {
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      if (i != 0) {
        this.this$0.queueEvent(new AECameraGLSurfaceView.12.3(this, localbijp, (VideoMaterial)localObject2));
      }
      if ((!bimt.a()) || (TextUtils.isEmpty(this.a))) {
        break;
      }
      bimt.a(this.this$0.a, 1500L);
      return;
      AECameraGLSurfaceView.a(this.this$0).a();
      break label412;
      label579:
      if ((!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "front")) || (bijj.a().b())) {
        break label466;
      }
      bijj.a().c(AECameraGLSurfaceView.d(this.this$0));
      break label466;
      label617:
      i = 1;
      continue;
      label622:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.12
 * JD-Core Version:    0.7.0.1
 */