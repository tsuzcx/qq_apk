import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Locale;

public class lmh
  implements Runnable
{
  public lmh(ReadInJoyLogicEngine paramReadInJoyLogicEngine, int paramInt) {}
  
  public void run()
  {
    Pair localPair = ReadInJoyHelper.a(ReadInJoyLogicEngine.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine));
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L - ((Long)localPair.first).longValue();
    long l3 = ReadInJoyLogicEngine.a() / 1000L;
    Object localObject2 = (Long)ReadInJoyLogicEngine.b().get(Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    if (((BaseActivity.sTopActivity instanceof ReadInJoyNewFeedsActivity)) || (l1 - ((Long)localObject1).longValue() < ((Long)localPair.first).longValue()) || (l1 - l3 < ((Long)localPair.first).longValue())) {
      return;
    }
    if (ReadInJoyLogicEngine.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine) != null) {
      ReadInJoyLogicEngine.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine).a(this.jdField_a_of_type_Int, l2, ((Integer)localPair.second).intValue());
    }
    localObject1 = ReadInJoyLogicEngine.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine).createEntityManager();
    localObject2 = String.format(Locale.CHINA, "delete from %s where mRecommendSeq not in ( select mRecommendSeq from %s where mChannelID = %d order by mRecommendSeq desc limit %d ) and mRecommendTime < %d  and mChannelID = %d ", new Object[] { ArticleInfo.TABLE_NAME, ArticleInfo.TABLE_NAME, Integer.valueOf(this.jdField_a_of_type_Int), localPair.second, Long.valueOf(l2), Integer.valueOf(this.jdField_a_of_type_Int) });
    if (!((EntityManager)localObject1).b((String)localObject2)) {
      QLog.d("ArticleInfoModule", 2, "delete main outdated article fail !");
    }
    for (;;)
    {
      ReadInJoyLogicEngine.b().put(Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(l1));
      return;
      QLog.d("ArticleInfoModule", 2, "delete outdated article successful ! Sql is : " + (String)localObject2 + ", nowTime : " + l1 + ", interval : " + localPair.first + ", feedsCnt : " + localPair.second);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmh
 * JD-Core Version:    0.7.0.1
 */