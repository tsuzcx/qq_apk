package com.tencent.mobileqq.kandian.repo.pts;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.pts.nativemodule.IPTSRequestFeeds;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

public class PTSRequestFeedsModule
  implements IPTSRequestFeeds
{
  private PTSEventDispatcher.PTSObserver a = new PTSRequestFeedsModule.1(this);
  
  public PTSRequestFeedsModule()
  {
    PTSEventDispatcher.a().a(this.a);
  }
  
  private void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      QLog.i("PTSRequestFeedsModule", 1, "[handleResponse], req is null.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleResponse] channelID = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", success = ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("\n");
    paramToServiceMsg = (Bundle)paramToServiceMsg.getAttribute("request_extra_data_key");
    if ((paramToServiceMsg != null) && (paramToServiceMsg.containsKey("request_callback_ptr_key")))
    {
      paramList = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt), paramList);
      long l = paramToServiceMsg.getLong("request_callback_ptr_key");
      paramToServiceMsg = PTSDataUtil.a(paramBoolean1, paramList);
      paramInt = 0;
      PTSJsJniHandler.jsFunctionCallbackAsync(Long.valueOf(l).longValue(), new Object[] { paramToServiceMsg });
      if (QLog.isColorLevel())
      {
        while (paramInt < paramList.size())
        {
          localStringBuilder.append("articleInfo [");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("]: ");
          localStringBuilder.append(paramList.get(paramInt));
          localStringBuilder.append("\n");
          paramInt += 1;
        }
        QLog.i("PTSRequestFeedsModule", 1, localStringBuilder.toString());
      }
      return;
    }
    QLog.i("PTSRequestFeedsModule", 1, localStringBuilder.toString());
    QLog.i("PTSRequestFeedsModule", 1, "[handleResponse], request extra data is null.");
  }
  
  public void requestFeeds(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4)
  {
    Object localObject3 = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    Object localObject1 = RIJKanDianRedDotUtils.a(((QQAppInterface)localObject3).getMessageFacade().b(AppConstants.KANDIAN_DAILY_UIN, 1008), "kandian_daily_red_pnt");
    paramLong4 = 0L;
    Object localObject2 = null;
    int i;
    if ((localObject1 != null) && (((KandianRedDotInfo)localObject1).hasArticleID()))
    {
      QLog.i("PTSRequestFeedsModule", 1, "[requestDailyFeeds], has redDotInfo.");
      paramLong4 = ((KandianRedDotInfo)localObject1).algorithmID;
      paramLong2 = ((KandianRedDotInfo)localObject1).strategyID;
      localObject2 = ((KandianRedDotInfo)localObject1).articleIDList;
      localObject1 = ((KandianRedDotInfo)localObject1).cookie;
      i = 1;
    }
    else
    {
      i = -1;
      paramLong2 = 0L;
      localObject1 = null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("request_callback_ptr_key", paramLong3);
    ((ReadInJoyLogicManager)((QQAppInterface)localObject3).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a((int)paramLong1, (List)localObject2, i, true, false, 1, null, -1L, null, 0, paramLong4, paramLong2, (String)localObject1, 1, false, null, 0, null, null, localBundle);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(" [requestFeeds] , channelID = ");
    ((StringBuilder)localObject3).append(paramLong1);
    ((StringBuilder)localObject3).append(", algorithmID = ");
    ((StringBuilder)localObject3).append(paramLong4);
    ((StringBuilder)localObject3).append(", strategyID = ");
    ((StringBuilder)localObject3).append(paramLong2);
    ((StringBuilder)localObject3).append(", articleID = ");
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      localObject2 = (Serializable)((List)localObject2).get(0);
    } else {
      localObject2 = "null";
    }
    ((StringBuilder)localObject3).append(localObject2);
    ((StringBuilder)localObject3).append(", pushContext = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", articleListFrom = ");
    ((StringBuilder)localObject3).append(i);
    QLog.i("PTSRequestFeedsModule", 1, ((StringBuilder)localObject3).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.PTSRequestFeedsModule
 * JD-Core Version:    0.7.0.1
 */