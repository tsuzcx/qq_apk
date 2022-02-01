package dov.com.qq.im.capture.adapter;

import bplz;
import bpmb;
import bpvt;
import brhn;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class QIMPtvTemplateAdapter$2$1
  implements Runnable
{
  public QIMPtvTemplateAdapter$2$1(bpmb parambpmb, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localPtvTemplateInfo == null) || (!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      localPtvTemplateInfo.downloading = false;
      localPtvTemplateInfo.usable = this.jdField_a_of_type_Boolean;
      localObject = this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
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
        this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_Brhn.a(112, localPtvTemplateInfo);
      }
    }
    if ((bplz.a(this.jdField_a_of_type_Bpmb.a) < 0) || (bplz.a(this.jdField_a_of_type_Bpmb.a) >= this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label217:
    do
    {
      return;
      i = -1;
      break;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_JavaUtilArrayList.get(bplz.a(this.jdField_a_of_type_Bpmb.a));
    } while ((!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (!this.jdField_a_of_type_Boolean) || (bplz.a(this.jdField_a_of_type_Bpmb.a) == null));
    Object localObject = brhn.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    bplz.jdField_a_of_type_JavaLangString = (String)localObject;
    bplz.jdField_b_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId;
    bplz.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id;
    if (this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
    {
      bplz.jdField_a_of_type_JavaLangString = "";
      bplz.a(this.jdField_a_of_type_Bpmb.a).a((String)localObject);
      bplz.a(this.jdField_a_of_type_Bpmb.a).a(null, "");
    }
    for (;;)
    {
      i = AdvancedProviderView.b();
      bplz.a(this.jdField_a_of_type_Bpmb.a).b(i);
      i = AdvancedProviderView.c();
      bplz.a(this.jdField_a_of_type_Bpmb.a).c(i);
      this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_Brhn.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_Brhn.a(113, null);
      this.jdField_a_of_type_Bpmb.a.jdField_a_of_type_Brhn.a(bplz.jdField_b_of_type_JavaLangString);
      return;
      bplz.a(this.jdField_a_of_type_Bpmb.a).a(localPtvTemplateInfo, (String)localObject);
      bplz.a(this.jdField_a_of_type_Bpmb.a).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */