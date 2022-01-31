package com.tencent.mobileqq.richmedia.capture.view;

import ajli;
import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import axjr;
import axlk;
import axlo;
import axmx;
import axmy;
import axne;
import bnko;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.io.File;

public class EffectsCameraCaptureView$3
  implements Runnable
{
  EffectsCameraCaptureView$3(EffectsCameraCaptureView paramEffectsCameraCaptureView, String paramString) {}
  
  public void run()
  {
    if ((EffectsCameraCaptureView.c(this.this$0)) && (TextUtils.isEmpty(this.a))) {}
    Object localObject1;
    label151:
    long l;
    boolean bool2;
    boolean[] arrayOfBoolean;
    Object localObject2;
    boolean bool1;
    label259:
    label326:
    do
    {
      return;
      localObject1 = axmx.a(EffectsCameraCaptureView.a(this.this$0));
      if (this.this$0.a((axmx)localObject1))
      {
        EffectsCameraCaptureView.a(this.this$0).a();
        return;
      }
      EffectsCameraCaptureView.a(this.this$0, (axmx)localObject1);
      if ((this.a == null) || (this.a.equalsIgnoreCase("")) || (localObject1 == null)) {
        break;
      }
      EffectsCameraCaptureView.a(this.this$0).jdField_b_of_type_Boolean = ((axmx)localObject1).jdField_b_of_type_Boolean;
      EffectsCameraCaptureView.a(this.this$0).jdField_a_of_type_Boolean = ((axmx)localObject1).c;
      EffectsCameraCaptureView.a(this.this$0).jdField_a_of_type_Int = ((axmx)localObject1).jdField_b_of_type_Int;
      com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.sGestureType = ((axmx)localObject1).f;
      com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.sGestureTips = ((axmx)localObject1).g;
      i = PTFaceAttr.PTExpression.UNKNOW.value;
      l = SystemClock.elapsedRealtime();
      localObject1 = new File(this.a, "paramsback" + ".json");
      bool2 = ((File)localObject1).exists();
      arrayOfBoolean = new boolean[1];
      if ((this.a == null) || ("".equals(this.a))) {
        break label713;
      }
      axlo.g();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("parseVideoMaterial back? : ");
        if (ajli.jdField_a_of_type_Int != 2) {
          break label569;
        }
        bool1 = true;
        QLog.d("EffectsCameraCaptureView", 2, bool1);
      }
      if (ajli.jdField_a_of_type_Int != 2) {
        break label705;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial file : " + ((File)localObject1).getAbsolutePath());
      }
      if (!bool2) {
        break label705;
      }
      localObject1 = "paramsback";
      localObject1 = QQTemplateParser.parseVideoMaterial(this.a, (String)localObject1);
      ((VideoMaterial)localObject1).setDataPath(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial  tempMaterail type: " + ((VideoMaterial)localObject1).getShaderType() + " patternPath=" + this.a);
      }
    } while ((bnko.a((VideoMaterial)localObject1, this.this$0.jdField_a_of_type_Bnlu, this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture, (Activity)this.this$0.getContext(), this.a)) || (((VideoMaterial)localObject1).getGameParams() != null));
    if (EffectsCameraCaptureView.a(this.this$0).jdField_a_of_type_Int == 1) {
      ((VideoMaterial)localObject1).isNeedDecodeFaceFilter = false;
    }
    int i = ((VideoMaterial)localObject1).getTriggerType();
    for (;;)
    {
      if (localObject1 != null) {}
      for (localObject2 = ((VideoMaterial)localObject1).getId();; localObject2 = null)
      {
        axlo.a = (String)localObject2;
        l = (SystemClock.elapsedRealtime() - l) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
          break label581;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PtvFilterUtils", 2, "mQQFilterRenderManager == null");
        return;
        EffectsCameraCaptureView.a(this.this$0).a();
        break label151;
        label569:
        bool1 = false;
        break label259;
      }
      label581:
      localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
      int j = arrayOfBoolean[0];
      if (VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject1))
      {
        LogicDataManager.getInstance().init((VideoMaterial)localObject1);
        new axlk((Activity)this.this$0.getContext(), new axmy(this)).a();
      }
      if ((this.this$0.jdField_a_of_type_Axjr != null) && (localObject1 != null)) {
        this.this$0.jdField_a_of_type_Axjr.a(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject1), ((VideoMaterial)localObject1).getVoicekind(), ((VideoMaterial)localObject1).getEnvironment());
      }
      EffectsCameraCaptureView.a(this.this$0, new EffectsCameraCaptureView.3.3(this, (VideoMaterial)localObject1, (QQFilterRenderManager)localObject2, bool2, j, i));
      return;
      label705:
      localObject1 = "params";
      break label326;
      label713:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.3
 * JD-Core Version:    0.7.0.1
 */