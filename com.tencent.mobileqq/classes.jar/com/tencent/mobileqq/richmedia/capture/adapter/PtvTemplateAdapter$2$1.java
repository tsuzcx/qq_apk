package com.tencent.mobileqq.richmedia.capture.adapter;

import avrn;
import avrp;
import avrv;
import avvv;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class PtvTemplateAdapter$2$1
  implements Runnable
{
  public PtvTemplateAdapter$2$1(avrp paramavrp, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
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
        localObject1 = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Avrp.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject1 == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject1).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).usable = this.jdField_a_of_type_Boolean;
      localObject2 = this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
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
      avrv.a().a(112, localObject1);
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)) {
        QLog.i("CapturePtvTemplateManager", 2, "onDownloadFinish mCurrentPtvTemplateInfo=" + this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id + " info=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      }
      if ((this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable))
      {
        localObject1 = avrv.a(this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, this.jdField_a_of_type_Avrp.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5);
        this.jdField_a_of_type_Avrp.a.jdField_a_of_type_JavaLangString = ((String)localObject1);
        avrv.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
        avrv.a().a(113, null);
        if (avrn.a(this.jdField_a_of_type_Avrp.a) != null) {
          avrn.a(this.jdField_a_of_type_Avrp.a).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_Avrp.a.jdField_a_of_type_JavaLangString);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */