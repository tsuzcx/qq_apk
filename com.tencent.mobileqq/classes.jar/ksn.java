import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class ksn
  implements Runnable
{
  public ksn(AccountDetailActivity paramAccountDetailActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      int i = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, 110.0F);
      Bitmap localBitmap = ImageUtil.a(this.jdField_a_of_type_JavaLangString, i, i);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(ImageUtil.c(localBitmap, i, i));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksn
 * JD-Core Version:    0.7.0.1
 */