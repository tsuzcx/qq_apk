import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleSinglePic;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import java.net.URL;

public class kxm
  implements PublicAccountImageDownListener
{
  public kxm(AdModuleSinglePic paramAdModuleSinglePic, View paramView, ResizeURLImageView paramResizeURLImageView) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleSinglePic.a = 2;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366494).setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setPublicAccountImageDownListener(null);
    AdModuleSinglePic.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleSinglePic, null);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleSinglePic.a = 3;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366494).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131367201).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131367201).setOnClickListener(new kxn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxm
 * JD-Core Version:    0.7.0.1
 */