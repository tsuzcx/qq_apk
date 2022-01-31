package dov.com.qq.im.capture.adapter;

import bjbe;
import bjbg;
import bjky;
import bkzp;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class QIMPtvTemplateAdapter$2$1
  implements Runnable
{
  public QIMPtvTemplateAdapter$2$1(bjbg parambjbg, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localPtvTemplateInfo == null) || (!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      localPtvTemplateInfo.downloading = false;
      localPtvTemplateInfo.usable = this.jdField_a_of_type_Boolean;
      localObject = this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
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
        this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_Bkzp.a(112, localPtvTemplateInfo);
      }
    }
    if ((bjbe.a(this.jdField_a_of_type_Bjbg.a) < 0) || (bjbe.a(this.jdField_a_of_type_Bjbg.a) >= this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label217:
    do
    {
      return;
      i = -1;
      break;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_JavaUtilArrayList.get(bjbe.a(this.jdField_a_of_type_Bjbg.a));
    } while ((!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (!this.jdField_a_of_type_Boolean) || (bjbe.a(this.jdField_a_of_type_Bjbg.a) == null));
    Object localObject = bkzp.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    bjbe.jdField_a_of_type_JavaLangString = (String)localObject;
    bjbe.jdField_b_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId;
    bjbe.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id;
    if (this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
    {
      bjbe.jdField_a_of_type_JavaLangString = "";
      bjbe.a(this.jdField_a_of_type_Bjbg.a).a((String)localObject);
      bjbe.a(this.jdField_a_of_type_Bjbg.a).a(null, "");
    }
    for (;;)
    {
      i = AdvancedProviderView.b();
      bjbe.a(this.jdField_a_of_type_Bjbg.a).b(i);
      i = AdvancedProviderView.c();
      bjbe.a(this.jdField_a_of_type_Bjbg.a).c(i);
      this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_Bkzp.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_Bkzp.a(113, null);
      this.jdField_a_of_type_Bjbg.a.jdField_a_of_type_Bkzp.a(bjbe.jdField_b_of_type_JavaLangString);
      return;
      bjbe.a(this.jdField_a_of_type_Bjbg.a).a(localPtvTemplateInfo, (String)localObject);
      bjbe.a(this.jdField_a_of_type_Bjbg.a).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */