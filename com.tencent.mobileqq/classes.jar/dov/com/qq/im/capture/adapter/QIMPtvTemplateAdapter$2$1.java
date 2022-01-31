package dov.com.qq.im.capture.adapter;

import bhfv;
import bhfx;
import bhpp;
import bjin;
import com.tencent.widget.GridView;
import dov.com.qq.im.AECamera.View.AEBeautyProviderView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class QIMPtvTemplateAdapter$2$1
  implements Runnable
{
  public QIMPtvTemplateAdapter$2$1(bhfx parambhfx, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localPtvTemplateInfo == null) || (!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      localPtvTemplateInfo.downloading = false;
      localPtvTemplateInfo.usable = this.jdField_a_of_type_Boolean;
      localObject = this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
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
        this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_Bjin.a(112, localPtvTemplateInfo);
      }
    }
    if ((bhfv.a(this.jdField_a_of_type_Bhfx.a) < 0) || (bhfv.a(this.jdField_a_of_type_Bhfx.a) >= this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label217:
    do
    {
      return;
      i = -1;
      break;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_JavaUtilArrayList.get(bhfv.a(this.jdField_a_of_type_Bhfx.a));
    } while ((!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (!this.jdField_a_of_type_Boolean) || (bhfv.a(this.jdField_a_of_type_Bhfx.a) == null));
    Object localObject = bjin.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    bhfv.jdField_a_of_type_JavaLangString = (String)localObject;
    bhfv.jdField_b_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId;
    bhfv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id;
    if (this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
    {
      bhfv.jdField_a_of_type_JavaLangString = "";
      bhfv.a(this.jdField_a_of_type_Bhfx.a).a((String)localObject);
      bhfv.a(this.jdField_a_of_type_Bhfx.a).a(null, "");
      if (!this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_Boolean) {
        break label554;
      }
      i = AEBeautyProviderView.a();
      label415:
      bhfv.a(this.jdField_a_of_type_Bhfx.a).b(i);
      if (!this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_Boolean) {
        break label561;
      }
    }
    label554:
    label561:
    for (i = AEBeautyProviderView.b();; i = AdvancedProviderView.c())
    {
      bhfv.a(this.jdField_a_of_type_Bhfx.a).c(i);
      this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_Bjin.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_Bjin.a(113, null);
      this.jdField_a_of_type_Bhfx.a.jdField_a_of_type_Bjin.a(bhfv.jdField_b_of_type_JavaLangString);
      return;
      bhfv.a(this.jdField_a_of_type_Bhfx.a).a(localPtvTemplateInfo, (String)localObject);
      bhfv.a(this.jdField_a_of_type_Bhfx.a).a(null);
      break;
      i = AdvancedProviderView.b();
      break label415;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */