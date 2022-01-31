import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public final class lbu
  implements Runnable
{
  public lbu(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mOpSource = 5;
    localReportInfo.mSourceArticleId = -1L;
    localReportInfo.mInnerId = this.jdField_a_of_type_JavaLangString;
    localReportInfo.mChannelId = this.jdField_a_of_type_Int;
    localReportInfo.mAlgorithmId = this.b;
    localReportInfo.mStrategyId = this.c;
    localReportInfo.mOperation = this.d;
    localReportInfo.mPlayTimeLength = this.e;
    localReportInfo.mVideoExtraRepoerData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$VideoExtraRepoerData;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("reportVideoUserOperationByOidbOfMutilmUin:").append(localReportInfo.mUin).append("; mSource:").append(localReportInfo.mSource).append("; mOpSource:").append(localReportInfo.mOpSource).append("; mInnerId:").append(localReportInfo.mInnerId).append("; mChannelId:").append(localReportInfo.mChannelId).append("; mAlgorithmId:").append(localReportInfo.mAlgorithmId).append("; mStrategyId:").append(localReportInfo.mStrategyId).append("; mOperation:").append(localReportInfo.mOperation).append("; mPlayTimeLength:").append(localReportInfo.mPlayTimeLength).append("; videoExtraRepoerData:");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$VideoExtraRepoerData == null) {
        break label280;
      }
    }
    label280:
    for (String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$VideoExtraRepoerData.toString();; str = "null")
    {
      QLog.d("VideoReporter", 2, str);
      localArrayList.add(localReportInfo);
      new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbu
 * JD-Core Version:    0.7.0.1
 */