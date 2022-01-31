import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

class shl
  implements Runnable
{
  shl(shk paramshk, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Shk.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QQToast.a(this.jdField_a_of_type_Shk.jdField_a_of_type_AndroidAppActivity, 1, 2131429985, 0).b(this.jdField_a_of_type_Shk.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(this.jdField_a_of_type_JavaLangString);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("title", this.jdField_a_of_type_Shk.c);
      localBundle.putString("desc", "");
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", this.jdField_a_of_type_Shk.b);
      localBundle.putStringArrayList("image_url", localArrayList);
      QZoneShareManager.a(this.jdField_a_of_type_Shk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Shk.jdField_a_of_type_AndroidAppActivity, localBundle, null);
    } while (!QLog.isColorLevel());
    QLog.i("DiscussionInfoCardActivity", 2, "shareToQzone.title:" + this.jdField_a_of_type_Shk.c + " filePath:" + this.jdField_a_of_type_JavaLangString + " shareLink:" + this.jdField_a_of_type_Shk.b + " desc:" + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shl
 * JD-Core Version:    0.7.0.1
 */