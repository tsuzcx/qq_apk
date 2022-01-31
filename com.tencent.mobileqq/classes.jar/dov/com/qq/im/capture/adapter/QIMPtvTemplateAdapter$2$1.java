package dov.com.qq.im.capture.adapter;

import bjan;
import bjap;
import bjkh;
import bkyy;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class QIMPtvTemplateAdapter$2$1
  implements Runnable
{
  public QIMPtvTemplateAdapter$2$1(bjap parambjap, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bjap.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Bjap.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bjap.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localPtvTemplateInfo == null) || (!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      localPtvTemplateInfo.downloading = false;
      localPtvTemplateInfo.usable = this.jdField_a_of_type_Boolean;
      localObject = this.jdField_a_of_type_Bjap.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (!this.jdField_a_of_type_Boolean) {
          break label217;
        }
        i = 1000;
        ((PtvTemplateItemView)localObject).a(i);
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bjap.a.jdField_a_of_type_Bkyy.a(112, localPtvTemplateInfo);
      }
    }
    if ((bjan.a(this.jdField_a_of_type_Bjap.a) < 0) || (bjan.a(this.jdField_a_of_type_Bjap.a) >= this.jdField_a_of_type_Bjap.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label217:
    do
    {
      return;
      i = -1;
      break;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bjap.a.jdField_a_of_type_JavaUtilArrayList.get(bjan.a(this.jdField_a_of_type_Bjap.a));
    } while ((!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (!this.jdField_a_of_type_Boolean) || (bjan.a(this.jdField_a_of_type_Bjap.a) == null));
    Object localObject = bkyy.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    bjan.jdField_a_of_type_JavaLangString = (String)localObject;
    bjan.jdField_b_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId;
    bjan.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id;
    if (this.jdField_a_of_type_Bjap.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
    {
      bjan.jdField_a_of_type_JavaLangString = "";
      bjan.a(this.jdField_a_of_type_Bjap.a).a((String)localObject);
      bjan.a(this.jdField_a_of_type_Bjap.a).a(null, "");
    }
    for (;;)
    {
      i = AdvancedProviderView.b();
      bjan.a(this.jdField_a_of_type_Bjap.a).b(i);
      i = AdvancedProviderView.c();
      bjan.a(this.jdField_a_of_type_Bjap.a).c(i);
      this.jdField_a_of_type_Bjap.a.jdField_a_of_type_Bkyy.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_Bjap.a.jdField_a_of_type_Bkyy.a(113, null);
      this.jdField_a_of_type_Bjap.a.jdField_a_of_type_Bkyy.a(bjan.jdField_b_of_type_JavaLangString);
      return;
      bjan.a(this.jdField_a_of_type_Bjap.a).a(localPtvTemplateInfo, (String)localObject);
      bjan.a(this.jdField_a_of_type_Bjap.a).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */