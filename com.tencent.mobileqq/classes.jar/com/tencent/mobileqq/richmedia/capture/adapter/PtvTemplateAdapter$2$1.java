package com.tencent.mobileqq.richmedia.capture.adapter;

import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.ProviderViewListener;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;

class PtvTemplateAdapter$2$1
  implements Runnable
{
  PtvTemplateAdapter$2$1(PtvTemplateAdapter.2 param2, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    Object localObject1;
    Object localObject2;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject1 = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject1 == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject1).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).usable = this.jdField_a_of_type_Boolean;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
      if ((localObject2 instanceof PtvTemplateItemView))
      {
        localObject2 = (PtvTemplateItemView)localObject2;
        localPtvTemplateInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
        if (!this.jdField_a_of_type_Boolean) {
          break label396;
        }
      }
    }
    label396:
    for (i = 1000;; i = -1)
    {
      ((PtvTemplateItemView)localObject2).a(localPtvTemplateInfo, i);
      CapturePtvTemplateManager.a().a(112, localObject1);
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)) {
        QLog.i("CapturePtvTemplateManager", 2, "onDownloadFinish mCurrentPtvTemplateInfo=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id + " info=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable))
      {
        localObject1 = CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_JavaLangString = ((String)localObject1);
        CapturePtvTemplateManager.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
        CapturePtvTemplateManager.a().a(113, null);
        if (PtvTemplateAdapter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a) != null) {
          PtvTemplateAdapter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$2.a.jdField_a_of_type_JavaLangString);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */