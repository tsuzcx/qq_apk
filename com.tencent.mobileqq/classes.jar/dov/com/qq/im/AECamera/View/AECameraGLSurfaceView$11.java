package dov.com.qq.im.AECamera.View;

import ajjy;
import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import ausi;
import bgxl;
import bgxx;
import bgyf;
import bgys;
import bgyy;
import bjic;
import bjji;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.AECamera.AEMaterialConfigParser;
import java.io.File;
import mqq.os.MqqHandler;

public class AECameraGLSurfaceView$11
  implements Runnable
{
  AECameraGLSurfaceView$11(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString) {}
  
  public void run()
  {
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    if ((this.this$0.b()) || (!AECameraGLSurfaceView.a(this.this$0))) {
      QLog.d(AECameraGLSurfaceView.a(), 1, new Object[] { "setFaceEffect fail ", Boolean.valueOf(this.this$0.b()) });
    }
    Object localObject2;
    bgyy localbgyy;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = this.a;
        localbgyy = (bgyy)AECameraGLSurfaceView.a(this.this$0);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          AECameraGLSurfaceView.a(this.this$0).a(null);
          AECameraGLSurfaceView.a(this.this$0, null);
          AECameraGLSurfaceView.a(this.this$0, false);
          this.this$0.queueEvent(new AECameraGLSurfaceView.11.1(this, localbgyy));
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
    } while (localObject2 == null);
    AECameraGLSurfaceView.a(this.this$0).a((VideoMaterial)localObject2);
    ((VideoMaterial)localObject2).setDataPath((String)localObject1);
    if (!FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject2))
    {
      AECameraGLSurfaceView.a(this.this$0, ajjy.a(2131624281));
      bjic.a((VideoMaterial)localObject2, (Activity)this.this$0.getContext(), ((VideoMaterial)localObject2).getDataPath());
      return;
    }
    if ((VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject2)) && (!AECameraGLSurfaceView.b(this.this$0)))
    {
      AECameraGLSurfaceView.b(this.this$0, true);
      LogicDataManager.getInstance().init((VideoMaterial)localObject2);
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.11.2(this));
    }
    if (bgxx.a() != null) {
      bgxx.a().a = VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2);
    }
    if (AECameraGLSurfaceView.a(this.this$0) != null) {
      AECameraGLSurfaceView.a(this.this$0).a(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2), ((VideoMaterial)localObject2).getVoicekind(), ((VideoMaterial)localObject2).getEnvironment());
    }
    label393:
    label440:
    int i;
    if (VideoMaterialUtil.isAudio2textMaterial((VideoMaterial)localObject2))
    {
      AECameraGLSurfaceView.a(this.this$0).a(this.this$0.getContext(), AECameraGLSurfaceView.a(this.this$0));
      AECameraGLSurfaceView.a(this.this$0, ((VideoMaterial)localObject2).needFaceInfo());
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      if (!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "back")) {
        break label553;
      }
      if (bgys.a().a()) {
        bgys.a().d();
      }
      if (!VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2)) {
        break label584;
      }
      if ((AECameraGLSurfaceView.a(this.this$0) != null) && (AECameraGLSurfaceView.a(this.this$0).getId().equals(((VideoMaterial)localObject2).getId()))) {
        break label589;
      }
      i = 1;
    }
    for (;;)
    {
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      if (i != 0) {
        this.this$0.queueEvent(new AECameraGLSurfaceView.11.3(this, localbgyy, (VideoMaterial)localObject2));
      }
      if ((!bgxl.a()) || (TextUtils.isEmpty(this.a))) {
        break;
      }
      bgxl.a(this.this$0.a, 1500L);
      return;
      AECameraGLSurfaceView.a(this.this$0).a();
      break label393;
      label553:
      if ((!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "front")) || (bgys.a().a())) {
        break label440;
      }
      bgys.a().d();
      break label440;
      label584:
      i = 1;
      continue;
      label589:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraGLSurfaceView.11
 * JD-Core Version:    0.7.0.1
 */