package com.tencent.mobileqq.richmedia.capture.view;

import ahhj;
import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import ausi;
import auua;
import auue;
import auvf;
import auvg;
import auvm;
import bjic;
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
      localObject1 = auvf.a(EffectsCameraCaptureView.a(this.this$0));
      if (this.this$0.a((auvf)localObject1))
      {
        EffectsCameraCaptureView.a(this.this$0).a();
        return;
      }
      EffectsCameraCaptureView.a(this.this$0, (auvf)localObject1);
      if ((this.a == null) || (this.a.equalsIgnoreCase("")) || (localObject1 == null)) {
        break;
      }
      EffectsCameraCaptureView.a(this.this$0).jdField_b_of_type_Boolean = ((auvf)localObject1).jdField_b_of_type_Boolean;
      EffectsCameraCaptureView.a(this.this$0).jdField_a_of_type_Boolean = ((auvf)localObject1).c;
      EffectsCameraCaptureView.a(this.this$0).jdField_a_of_type_Int = ((auvf)localObject1).jdField_b_of_type_Int;
      com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.sGestureType = ((auvf)localObject1).f;
      com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.sGestureTips = ((auvf)localObject1).g;
      i = PTFaceAttr.PTExpression.UNKNOW.value;
      l = SystemClock.elapsedRealtime();
      localObject1 = new File(this.a, "paramsback" + ".json");
      bool2 = ((File)localObject1).exists();
      arrayOfBoolean = new boolean[1];
      if ((this.a == null) || ("".equals(this.a))) {
        break label705;
      }
      auue.g();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("parseVideoMaterial back? : ");
        if (ahhj.jdField_a_of_type_Int != 2) {
          break label561;
        }
        bool1 = true;
        QLog.d("EffectsCameraCaptureView", 2, bool1);
      }
      if (ahhj.jdField_a_of_type_Int != 2) {
        break label697;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial file : " + ((File)localObject1).getAbsolutePath());
      }
      if (!bool2) {
        break label697;
      }
      localObject1 = "paramsback";
      localObject1 = QQTemplateParser.parseVideoMaterial(this.a, (String)localObject1);
      ((VideoMaterial)localObject1).setDataPath(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial  tempMaterail type: " + ((VideoMaterial)localObject1).getShaderType() + " patternPath=" + this.a);
      }
    } while (bjic.a((VideoMaterial)localObject1, this.this$0.jdField_a_of_type_Bjji, this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture, (Activity)this.this$0.getContext(), this.a));
    if (EffectsCameraCaptureView.a(this.this$0).jdField_a_of_type_Int == 1) {
      ((VideoMaterial)localObject1).isNeedDecodeFaceFilter = false;
    }
    int i = ((VideoMaterial)localObject1).getTriggerType();
    for (;;)
    {
      if (localObject1 != null) {}
      for (localObject2 = ((VideoMaterial)localObject1).getId();; localObject2 = null)
      {
        auue.a = (String)localObject2;
        l = (SystemClock.elapsedRealtime() - l) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
          break label573;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PtvFilterUtils", 2, "mQQFilterRenderManager == null");
        return;
        EffectsCameraCaptureView.a(this.this$0).a();
        break label151;
        label561:
        bool1 = false;
        break label259;
      }
      label573:
      localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
      int j = arrayOfBoolean[0];
      if (VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject1))
      {
        LogicDataManager.getInstance().init((VideoMaterial)localObject1);
        new auua((Activity)this.this$0.getContext(), new auvg(this)).a();
      }
      if ((this.this$0.jdField_a_of_type_Ausi != null) && (localObject1 != null)) {
        this.this$0.jdField_a_of_type_Ausi.a(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject1), ((VideoMaterial)localObject1).getVoicekind(), ((VideoMaterial)localObject1).getEnvironment());
      }
      EffectsCameraCaptureView.a(this.this$0, new EffectsCameraCaptureView.3.2(this, (VideoMaterial)localObject1, (QQFilterRenderManager)localObject2, bool2, j, i));
      return;
      label697:
      localObject1 = "params";
      break label326;
      label705:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.3
 * JD-Core Version:    0.7.0.1
 */