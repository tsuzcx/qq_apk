import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;

public class lbh
  implements TroopMemberApiClient.Callback
{
  public lbh(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public void a(Bundle paramBundle)
  {
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      ReadInJoyArticleDetailActivity.a(this.a, paramBundle.getByteArray("decryptResult"));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "请求返回时间" + System.currentTimeMillis());
      }
      if (ReadInJoyArticleDetailActivity.a(this.a) == null) {
        this.a.jdField_a_of_type_JavaLangString = null;
      }
      this.a.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbh
 * JD-Core Version:    0.7.0.1
 */