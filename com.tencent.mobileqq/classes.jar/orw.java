import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class orw
  implements Runnable
{
  public orw(QRDisplayActivity paramQRDisplayActivity, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getLeft();
    int j = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getRight();
    Rect localRect = new Rect(i, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getTop(), j, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getBottom());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setClickable(false);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setTouchDelegate(new orx(this, localRect, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setClickable(true);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setOnClickListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setTouchDelegate(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orw
 * JD-Core Version:    0.7.0.1
 */