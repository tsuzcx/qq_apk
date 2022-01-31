import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.util.GalleryShareHelper;
import java.util.Map;

class mug
  implements Runnable
{
  mug(muf parammuf) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)this.a.jdField_a_of_type_JavaUtilMap.remove("image");
    this.a.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper.a(GalleryShareHelper.b(this.a.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper), GalleryShareHelper.c(this.a.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper), GalleryShareHelper.d(this.a.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper), localBitmap, this.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mug
 * JD-Core Version:    0.7.0.1
 */