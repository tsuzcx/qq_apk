import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class ler
  implements Runnable
{
  public ler(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void run()
  {
    ReadInJoySelfActivity.a(this.a);
    ReadInJoyWebDataManager localReadInJoyWebDataManager;
    String str;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localReadInJoyWebDataManager = ReadInJoyWebDataManager.a();
      str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0) {
        break label54;
      }
    }
    label54:
    for (int i = 0;; i = 1)
    {
      localReadInJoyWebDataManager.a(str, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ler
 * JD-Core Version:    0.7.0.1
 */