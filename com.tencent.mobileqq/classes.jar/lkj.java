import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateAdapter;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateItemView;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class lkj
  implements Runnable
{
  lkj(lki paramlki, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).getFirstVisiblePosition();
    int k = ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).getLastVisiblePosition();
    int i = j;
    Object localObject1;
    Object localObject2;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject1 = (PtvTemplateManager.PtvTemplateInfo)ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).get(i);
      } while ((localObject1 == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject1).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).usable = this.jdField_a_of_type_Boolean;
      if (ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).id.equals(((PtvTemplateManager.PtvTemplateInfo)localObject1).id)) {
        ((PtvTemplateManager.PtvTemplateInfo)localObject1).isSelected = true;
      }
      localObject2 = ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).getChildAt(i - j);
      if ((localObject2 instanceof ReadInJoyCameraTemplateItemView))
      {
        localObject2 = (ReadInJoyCameraTemplateItemView)localObject2;
        if (!this.jdField_a_of_type_Boolean) {
          break label269;
        }
      }
    }
    label269:
    for (i = 1000;; i = -1)
    {
      ((ReadInJoyCameraTemplateItemView)localObject2).b(i);
      ((ReadInJoyCameraTemplateItemView)localObject2).a(((PtvTemplateManager.PtvTemplateInfo)localObject1).isSelected);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals(ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).id))
      {
        localObject1 = PtvTemplateManager.a + ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).name;
        ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).setFaceEffect((String)localObject1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkj
 * JD-Core Version:    0.7.0.1
 */