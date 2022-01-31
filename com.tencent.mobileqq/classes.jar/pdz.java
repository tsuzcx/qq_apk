import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.pts.nativemodule.IPTSDailyRequest;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

public class pdz
  implements IPTSDailyRequest
{
  private final String jdField_a_of_type_JavaLangString = "PTSDailyRequestModule";
  private pdm jdField_a_of_type_Pdm = new pea(this);
  
  public pdz()
  {
    pdl.a().a(this.jdField_a_of_type_Pdm);
  }
  
  private void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    if (!odm.c(paramInt)) {
      QLog.i("PTSDailyRequestModule", 1, "[handleResponse], not daily channel, channelID = " + paramInt);
    }
    StringBuilder localStringBuilder;
    do
    {
      return;
      if (paramToServiceMsg == null)
      {
        QLog.i("PTSDailyRequestModule", 1, "[handleResponse], req is null.");
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleResponse] channelID = ").append(paramInt).append(", success = ").append(paramBoolean1).append("\n");
      paramToServiceMsg = (Bundle)paramToServiceMsg.getAttribute("request_extra_data_key");
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.containsKey("request_callback_ptr_key"))) {
        break;
      }
      paramList = ogy.a().a(Integer.valueOf(paramInt), paramList);
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        localStringBuilder.append("articleInfo [").append(paramInt).append("]: ").append(paramList.get(paramInt)).append("\n");
        paramInt += 1;
      }
      long l = paramToServiceMsg.getLong("request_callback_ptr_key");
      paramList = peb.a(paramBoolean1, paramList);
      PTSJNIHandler.jsFunctionCallbackAsync(Long.valueOf(l).longValue(), new Object[] { paramList });
    } while (!QLog.isColorLevel());
    QLog.i("PTSDailyRequestModule", 1, localStringBuilder.toString());
    return;
    QLog.i("PTSDailyRequestModule", 1, localStringBuilder.toString());
    QLog.i("PTSDailyRequestModule", 1, "[handleResponse], request extra data is null.");
  }
  
  public void makeDailyRequest(long paramLong, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)obz.a();
    KandianRedDotInfo localKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(localQQAppInterface.a().b(ajed.aQ, 1008), "kandian_daily_red_pnt");
    Object localObject2 = null;
    long l3 = 0L;
    long l4 = 0L;
    Object localObject3 = null;
    int j = -1;
    Object localObject1 = localObject2;
    int i = j;
    long l2 = l3;
    long l1 = l4;
    paramBundle = localObject3;
    if (localKandianRedDotInfo != null)
    {
      localObject1 = localObject2;
      i = j;
      l2 = l3;
      l1 = l4;
      paramBundle = localObject3;
      if (localKandianRedDotInfo.hasArticleID())
      {
        QLog.i("PTSDailyRequestModule", 1, "[requestDailyFeeds], has redDotInfo.");
        l2 = localKandianRedDotInfo.algorithmID;
        l1 = localKandianRedDotInfo.strategyID;
        localObject1 = localKandianRedDotInfo.articleIDList;
        i = 1;
        paramBundle = localKandianRedDotInfo.cookie;
      }
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putLong("request_callback_ptr_key", paramLong);
    ((ohd)localQQAppInterface.getManager(163)).a().a(odm.b(), (List)localObject1, i, true, false, 1, null, -1L, null, 0, l2, l1, paramBundle, 1, false, null, 0, null, null, (Bundle)localObject2);
    localObject2 = new StringBuilder().append(" [requestDailyFeeds] , algorithmID = ").append(l2).append(", strategyID = ").append(l1).append(", articleID = ");
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {}
    for (localObject1 = (Serializable)((List)localObject1).get(0);; localObject1 = "null")
    {
      QLog.i("PTSDailyRequestModule", 1, localObject1 + ", pushContext = " + paramBundle + ", articleListFrom = " + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdz
 * JD-Core Version:    0.7.0.1
 */