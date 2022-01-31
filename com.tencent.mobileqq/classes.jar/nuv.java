import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class nuv
  implements wxw
{
  public nuv(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
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
 * Qualified Name:     nuv
 * JD-Core Version:    0.7.0.1
 */