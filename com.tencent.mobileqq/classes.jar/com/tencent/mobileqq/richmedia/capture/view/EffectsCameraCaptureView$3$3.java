package com.tencent.mobileqq.richmedia.capture.view;

import alin;
import alps;
import android.os.SystemClock;
import anni;
import bapo;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.util.List;

class EffectsCameraCaptureView$3$3
  implements Runnable
{
  EffectsCameraCaptureView$3$3(EffectsCameraCaptureView.3 param3, VideoMaterial paramVideoMaterial, QQFilterRenderManager paramQQFilterRenderManager, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.initAEDetector_sync();
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasAEDetectorInited()) {
        if (QLog.isColorLevel()) {
          QLog.e("EffectsCameraCaptureView", 2, "initFaceDetectorSDK_Sync failed!");
        }
      }
      while (!FeatureManager.ensureMaterialSoLoaded(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().clearPtvVideoActiveFilter();
      localObject2 = new AESticker(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getFaceDetector());
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = localObject2;
        if (((AESticker)localObject2).getFilters() != null) {
          QLog.d("EffectsCameraCaptureView", 2, "createFilters = " + ((AESticker)localObject2).getFilters().size() + " tempMaterail getShaderType=" + this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getShaderType());
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, null);
      EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, -1);
      long l = SystemClock.elapsedRealtime();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0.k) {
        com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = AdvancedProviderView.c();
      }
      boolean bool2;
      label349:
      boolean bool1;
      label390:
      label436:
      int i;
      if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getChildrenPendants() != null) && (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getChildrenPendants().isEmpty()))
      {
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, new GroupVideoFilterList(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getFaceDetector()));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setPtvGroupVideoFilterList(EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().mHasBackFilter = this.jdField_a_of_type_Boolean;
        if ((localObject1 == null) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial)) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0).b)) {
          break label674;
        }
        bool2 = true;
        if ((localObject1 == null) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial)) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0).jdField_a_of_type_Boolean)) {
          break label680;
        }
        bool1 = true;
        boolean bool3 = VideoMaterialUtil.isGestureDetectMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, bool2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
        if ((!bool2) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.mEnableFaceDetect)) {
          break label686;
        }
        bool2 = true;
        ((QQFilterRenderManager)localObject2).setFaceDetectFlags(bool2);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setGestureDetectectFlags(bool1);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setYTGestureDetectFlags(bool3);
        l = (SystemClock.elapsedRealtime() - l) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_changeFilter=" + l / 1000.0D + "ms]");
        }
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
        if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null)) {
          break label917;
        }
        localObject1 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.mGuideTips;
        if ((!this.jdField_a_of_type_Boolean) || (alin.jdField_a_of_type_Int == 2)) {
          break label692;
        }
        i = 1;
        label563:
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          break label697;
        }
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, (String)localObject1);
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, 2);
      }
      for (;;)
      {
        for (;;)
        {
          if (EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0).jdField_a_of_type_Int != 0) {
            break label815;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mNeedDoFaceDetect, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mDetectedFace, false, false, 0);
          return;
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setPtvVideoFilter((AESticker)localObject1, this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        break;
        label674:
        bool2 = false;
        break label349;
        label680:
        bool1 = false;
        break label390;
        label686:
        bool2 = false;
        break label436;
        label692:
        i = 0;
        break label563;
        label697:
        if ((i != 0) && (!this.b))
        {
          EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, anni.a(2131702769));
          EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, 0);
        }
        else if (this.b)
        {
          EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, alps.a());
          EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, 3);
        }
        else
        {
          EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, this.jdField_a_of_type_Int));
          EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0, 1);
        }
      }
      label815:
      if (EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0).jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0.a(false, false, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mNeedDoGestureDetect, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mDetectedGesture, 1);
        return;
      }
      if (EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0).jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mNeedDoFaceDetect, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mDetectedFace, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mNeedDoGestureDetect, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.mDetectedGesture, 2);
      return;
      label917:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$3.this$0.a(false, false, false, false, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.3.3
 * JD-Core Version:    0.7.0.1
 */