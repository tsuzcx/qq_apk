import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateAdapter;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class lkk
  implements Runnable
{
  lkk(lki paramlki, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt) {}
  
  public void run()
  {
    int j = ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).getFirstVisiblePosition();
    int k = ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).getLastVisiblePosition();
    int i = j;
    Object localObject;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraTemplateAdapter", 2, "onProgressUpdate index: " + i + " progress: " + this.jdField_a_of_type_Int);
      }
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = true;
      localObject = ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_Lki.a).getChildAt(i - j);
      if ((localObject instanceof ReadInJoyCameraTemplateItemView))
      {
        localObject = (ReadInJoyCameraTemplateItemView)localObject;
        if (this.jdField_a_of_type_Int != 100) {
          break label189;
        }
      }
    }
    label189:
    for (i = 99;; i = this.jdField_a_of_type_Int)
    {
      ((ReadInJoyCameraTemplateItemView)localObject).b(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkk
 * JD-Core Version:    0.7.0.1
 */