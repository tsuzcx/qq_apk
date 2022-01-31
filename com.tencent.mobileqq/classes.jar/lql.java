import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class lql
  implements Runnable
{
  public lql(ChannelCoverInfoModule paramChannelCoverInfoModule, int paramInt) {}
  
  public void run()
  {
    List localList = ChannelCoverInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule, this.jdField_a_of_type_Int);
    if ((localList != null) && (localList.size() > 0))
    {
      localStringBuilder = new StringBuilder("loadChannelCoverListFromDB size = " + localList.size() + "\n");
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo.mArticleId).append(", mChannelType=").append(localChannelCoverInfo.mChannelType).append("]\n");
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.b(localList, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.d(localList, this.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      Iterator localIterator;
      ChannelCoverInfo localChannelCoverInfo;
      return;
    }
    QLog.d("ChannelCoverInfoModule", 2, "loadChannelCoverListFromDB list is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lql
 * JD-Core Version:    0.7.0.1
 */