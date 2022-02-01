package cooperation.weiyun;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class WeiyunSaveTipsFactory$1
  implements Runnable
{
  WeiyunSaveTipsFactory$1(Activity paramActivity, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, 2131697370, 1).b(this.jdField_a_of_type_Int);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, 2131691378, 1).b(this.jdField_a_of_type_Int, 2131563259, new WeiyunSaveTipsFactory.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.WeiyunSaveTipsFactory.1
 * JD-Core Version:    0.7.0.1
 */