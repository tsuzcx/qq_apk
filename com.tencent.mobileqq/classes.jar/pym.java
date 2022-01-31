import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.concurrent.ConcurrentHashMap;

class pym
  extends Handler
{
  pym(pyl parampyl, Looper paramLooper)
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
    pyl.a(this.a).remove(Integer.valueOf(paramMessage.jdField_a_of_type_Int));
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramMessage.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if (localAdvertisementInfo != null) {
      localAdvertisementInfo.isShowingGuide = false;
    }
    this.a.a(null, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pym
 * JD-Core Version:    0.7.0.1
 */