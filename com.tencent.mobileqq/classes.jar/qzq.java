import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.concurrent.ConcurrentHashMap;

class qzq
  extends Handler
{
  qzq(qzp paramqzp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      return;
      paramMessage = this.a.a(false);
    } while (paramMessage == null);
    qzp.a(this.a).remove(Integer.valueOf(paramMessage.jdField_a_of_type_Int));
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if (localAdvertisementInfo != null) {
      localAdvertisementInfo.isShowingGuide = false;
    }
    this.a.a(null, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzq
 * JD-Core Version:    0.7.0.1
 */