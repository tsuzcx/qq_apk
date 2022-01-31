import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.pts.nativemodule.IPTSRequestFeeds;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

public class pwo
  implements IPTSRequestFeeds
{
  private final String jdField_a_of_type_JavaLangString = "PTSRequestFeedsModule";
  private pvj jdField_a_of_type_Pvj = new pwp(this);
  
  public pwo()
  {
    pvi.a().a(this.jdField_a_of_type_Pvj);
  }
  
  private void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      QLog.i("PTSRequestFeedsModule", 1, "[handleResponse], req is null.");
    }
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleResponse] channelID = ").append(paramInt).append(", success = ").append(paramBoolean1).append("\n");
      paramToServiceMsg = (Bundle)paramToServiceMsg.getAttribute("request_extra_data_key");
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.containsKey("request_callback_ptr_key"))) {
        break;
      }
      paramList = owy.a().a(Integer.valueOf(paramInt), paramList);
      long l = paramToServiceMsg.getLong("request_callback_ptr_key");
      paramToServiceMsg = pwh.a(paramBoolean1, paramList);
      PTSJsJniHandler.jsFunctionCallbackAsync(Long.valueOf(l).longValue(), new Object[] { paramToServiceMsg });
    } while (!QLog.isColorLevel());
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      localStringBuilder.append("articleInfo [").append(paramInt).append("]: ").append(paramList.get(paramInt)).append("\n");
      paramInt += 1;
    }
    QLog.i("PTSRequestFeedsModule", 1, localStringBuilder.toString());
    return;
    QLog.i("PTSRequestFeedsModule", 1, localStringBuilder.toString());
    QLog.i("PTSRequestFeedsModule", 1, "[handleResponse], request extra data is null.");
  }
  
  public void requestFeeds(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    KandianRedDotInfo localKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(localQQAppInterface.a().b(alof.aS, 1008), "kandian_daily_red_pnt");
    Object localObject3 = null;
    long l1 = 0L;
    long l2 = 0L;
    Object localObject4 = null;
    int j = -1;
    Object localObject2 = localObject3;
    int i = j;
    paramLong4 = l1;
    paramLong2 = l2;
    Object localObject1 = localObject4;
    if (localKandianRedDotInfo != null)
    {
      localObject2 = localObject3;
      i = j;
      paramLong4 = l1;
      paramLong2 = l2;
      localObject1 = localObject4;
      if (localKandianRedDotInfo.hasArticleID())
      {
        QLog.i("PTSRequestFeedsModule", 1, "[requestDailyFeeds], has redDotInfo.");
        paramLong4 = localKandianRedDotInfo.algorithmID;
        paramLong2 = localKandianRedDotInfo.strategyID;
        localObject2 = localKandianRedDotInfo.articleIDList;
        i = 1;
        localObject1 = localKandianRedDotInfo.cookie;
      }
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putLong("request_callback_ptr_key", paramLong3);
    ((oxd)localQQAppInterface.getManager(163)).a().a((int)paramLong1, (List)localObject2, i, true, false, 1, null, -1L, null, 0, paramLong4, paramLong2, (String)localObject1, 1, false, null, 0, null, null, (Bundle)localObject3);
    localObject3 = new StringBuilder().append(" [requestFeeds] , channelID = ").append(paramLong1).append(", algorithmID = ").append(paramLong4).append(", strategyID = ").append(paramLong2).append(", articleID = ");
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {}
    for (localObject2 = (Serializable)((List)localObject2).get(0);; localObject2 = "null")
    {
      QLog.i("PTSRequestFeedsModule", 1, localObject2 + ", pushContext = " + (String)localObject1 + ", articleListFrom = " + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwo
 * JD-Core Version:    0.7.0.1
 */