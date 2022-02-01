package com.tencent.mobileqq.richmedia.capture.adapter;

import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.ProviderViewListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PtvTemplateAdapter$1
  implements PtvTemplateAdapter.IPtvTemplateItemCallback
{
  PtvTemplateAdapter$1(PtvTemplateAdapter paramPtvTemplateAdapter) {}
  
  public void a(int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.a.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.a.get(paramInt);
      if (!localPtvTemplateInfo.advertisement) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CapturePtvTemplateManager", 2, "info.advertisement is ture onItemClicked name: " + localPtvTemplateInfo.name);
      }
    } while (PtvTemplateAdapter.a(this.a) == null);
    PtvTemplateAdapter.a(this.a).a(localPtvTemplateInfo);
    return;
    this.a.a(paramInt);
    CaptureReportUtil.jdField_b_of_type_JavaLangString = PtvTemplateAdapter.a(this.a).a + "";
    CaptureReportUtil.c = localPtvTemplateInfo.id;
    CaptureReportUtil.a = localPtvTemplateInfo.hasGesture();
    boolean bool;
    if (localPtvTemplateInfo.kind == 3)
    {
      bool = true;
      CaptureReportUtil.jdField_b_of_type_Boolean = bool;
      if (CameraControl.a().a != 1) {
        break label228;
      }
    }
    label228:
    for (paramInt = i;; paramInt = 2)
    {
      CaptureReportUtil.c(paramInt);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.1
 * JD-Core Version:    0.7.0.1
 */