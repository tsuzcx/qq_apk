import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import java.net.MalformedURLException;
import java.net.URL;

public class mkm
  implements Runnable
{
  public mkm(ReadinjoyTabFrame paramReadinjoyTabFrame, ZImageView paramZImageView, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setRound(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.a(ImageUtil.a()).a(new URL(ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo)));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkm
 * JD-Core Version:    0.7.0.1
 */