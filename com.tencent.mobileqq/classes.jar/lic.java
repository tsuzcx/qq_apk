import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateAdapter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class lic
  implements Runnable
{
  public lic(ReadInJoyCameraTemplateAdapter paramReadInJoyCameraTemplateAdapter, ArrayList paramArrayList) {}
  
  public void run()
  {
    ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter).clear();
    ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter).addAll(this.jdField_a_of_type_JavaUtilArrayList);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
      if (localPtvTemplateInfo.isSelected) {
        ReadInJoyCameraTemplateAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter, localPtvTemplateInfo);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lic
 * JD-Core Version:    0.7.0.1
 */