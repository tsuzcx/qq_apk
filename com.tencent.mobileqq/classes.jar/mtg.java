import com.tencent.biz.pubaccount.util.GalleryShareHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class mtg
  implements Runnable
{
  mtg(mte parammte) {}
  
  public void run()
  {
    GalleryShareHelper.a(this.a.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).dismiss();
    QQToast.a(this.a.jdField_a_of_type_AndroidAppActivity, 1, "分享失败，请稍后重试！", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtg
 * JD-Core Version:    0.7.0.1
 */