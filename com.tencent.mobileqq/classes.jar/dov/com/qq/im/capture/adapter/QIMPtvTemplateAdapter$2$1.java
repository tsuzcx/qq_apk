package dov.com.qq.im.capture.adapter;

import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;

class QIMPtvTemplateAdapter$2$1
  implements Runnable
{
  QIMPtvTemplateAdapter$2$1(QIMPtvTemplateAdapter.2 param2, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localPtvTemplateInfo == null) || (!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      localPtvTemplateInfo.downloading = false;
      localPtvTemplateInfo.usable = this.jdField_a_of_type_Boolean;
      localObject = this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
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
        this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(112, localPtvTemplateInfo);
      }
    }
    if ((QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a) < 0) || (QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a) >= this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label217:
    do
    {
      return;
      i = -1;
      break;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_JavaUtilArrayList.get(QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a));
    } while ((!localPtvTemplateInfo.id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (!this.jdField_a_of_type_Boolean) || (QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a) == null));
    Object localObject = QIMPtvTemplateManager.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString = (String)localObject;
    QIMPtvTemplateAdapter.jdField_b_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId;
    QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id;
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
    {
      QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString = "";
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a).a((String)localObject);
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a).a(null, "");
    }
    for (;;)
    {
      i = AdvancedProviderView.b();
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a).a(i);
      i = AdvancedProviderView.c();
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a).b(i);
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(113, null);
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString);
      return;
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a).a(localPtvTemplateInfo, (String)localObject);
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$2.a).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */