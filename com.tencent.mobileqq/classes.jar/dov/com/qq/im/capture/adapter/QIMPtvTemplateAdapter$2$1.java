package dov.com.qq.im.capture.adapter;

import blra;
import blrc;
import bmau;
import bnpl;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class QIMPtvTemplateAdapter$2$1
  implements Runnable
{
  public QIMPtvTemplateAdapter$2$1(blrc paramblrc, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Blrc.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Blrc.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Blrc.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localPtvTemplateInfo == null) || (!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      localPtvTemplateInfo.downloading = false;
      localPtvTemplateInfo.usable = this.jdField_a_of_type_Boolean;
      localObject = this.jdField_a_of_type_Blrc.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
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
        this.jdField_a_of_type_Blrc.a.jdField_a_of_type_Bnpl.a(112, localPtvTemplateInfo);
      }
    }
    if ((blra.a(this.jdField_a_of_type_Blrc.a) < 0) || (blra.a(this.jdField_a_of_type_Blrc.a) >= this.jdField_a_of_type_Blrc.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label217:
    do
    {
      return;
      i = -1;
      break;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Blrc.a.jdField_a_of_type_JavaUtilArrayList.get(blra.a(this.jdField_a_of_type_Blrc.a));
    } while ((!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (!this.jdField_a_of_type_Boolean) || (blra.a(this.jdField_a_of_type_Blrc.a) == null));
    Object localObject = bnpl.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    blra.jdField_a_of_type_JavaLangString = (String)localObject;
    blra.jdField_b_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId;
    blra.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id;
    if (this.jdField_a_of_type_Blrc.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
    {
      blra.jdField_a_of_type_JavaLangString = "";
      blra.a(this.jdField_a_of_type_Blrc.a).a((String)localObject);
      blra.a(this.jdField_a_of_type_Blrc.a).a(null, "");
    }
    for (;;)
    {
      i = AdvancedProviderView.b();
      blra.a(this.jdField_a_of_type_Blrc.a).b(i);
      i = AdvancedProviderView.c();
      blra.a(this.jdField_a_of_type_Blrc.a).c(i);
      this.jdField_a_of_type_Blrc.a.jdField_a_of_type_Bnpl.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_Blrc.a.jdField_a_of_type_Bnpl.a(113, null);
      this.jdField_a_of_type_Blrc.a.jdField_a_of_type_Bnpl.a(blra.jdField_b_of_type_JavaLangString);
      return;
      blra.a(this.jdField_a_of_type_Blrc.a).a(localPtvTemplateInfo, (String)localObject);
      blra.a(this.jdField_a_of_type_Blrc.a).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */