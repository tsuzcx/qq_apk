import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class lrw
  implements Runnable
{
  public lrw(AdvertisementInfoModule paramAdvertisementInfoModule, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "loadChannelAdvertisementFromDB channelID=" + this.jdField_a_of_type_Int);
    }
    List localList = AdvertisementInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule, this.jdField_a_of_type_Int);
    ConcurrentHashMap localConcurrentHashMap;
    if (localList.size() > 0)
    {
      localConcurrentHashMap = (ConcurrentHashMap)AdvertisementInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule).get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localConcurrentHashMap != null) {
        break label326;
      }
      localConcurrentHashMap = new ConcurrentHashMap();
      AdvertisementInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule).put(Integer.valueOf(this.jdField_a_of_type_Int), localConcurrentHashMap);
    }
    label326:
    for (;;)
    {
      localConcurrentHashMap.clear();
      StringBuilder localStringBuilder = new StringBuilder("\n");
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
        localConcurrentHashMap.put(Integer.valueOf(localAdvertisementInfo.mAdKdPos), localAdvertisementInfo);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append(", fetchTime=").append(localAdvertisementInfo.mAdFetchTime).append("]\n");
        }
      }
      long l = ((AdvertisementInfo)localList.get(0)).mAdFetchTime;
      AdvertisementInfoModule.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule).put(Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "loadChannelAdvertisementFromDB channelID=" + this.jdField_a_of_type_Int + ", fetchTime=" + l + localStringBuilder.toString());
      }
      AdvertisementInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule, NetConnInfoCenter.getServerTimeMillis(), localConcurrentHashMap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrw
 * JD-Core Version:    0.7.0.1
 */