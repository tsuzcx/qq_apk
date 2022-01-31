import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class mxh
  implements PublicAccountImageDownListener
{
  mxh(mxc parammxc, boolean paramBoolean, long paramLong, ImageProgressCircle paramImageProgressCircle) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadSuccessed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(true, this.jdField_a_of_type_Long);
    }
    mxc.a(this.jdField_a_of_type_Mxc, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadFailed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(false, this.jdField_a_of_type_Long);
    }
    mxc.a(this.jdField_a_of_type_Mxc, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxh
 * JD-Core Version:    0.7.0.1
 */