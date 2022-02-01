package com.tencent.mobileqq.kandian.biz.daily.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.DailyFloatingWindowData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/impl/KandianDailyManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/daily/api/IKandianDailyManager;", "()V", "getDailyMsgBoxName", "", "message", "Lcom/tencent/imcore/message/Message;", "launchKandianDaily", "", "ctx", "Landroid/content/Context;", "clearTop", "", "b", "Landroid/os/Bundle;", "launchFrom", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KandianDailyManagerImpl
  implements IKandianDailyManager
{
  @Nullable
  public String getDailyMsgBoxName(@Nullable Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.msgtype == -2011))
    {
      Object localObject2 = paramMessage.lastMsg;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MessageForStructing)) {
        localObject1 = null;
      }
      localObject2 = (MessageForStructing)localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramMessage.msgData != null)
        {
          localObject1 = paramMessage.msgData;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "message.msgData");
          int i;
          if (localObject1.length == 0) {
            i = 1;
          } else {
            i = 0;
          }
          localObject1 = localObject2;
          if ((i ^ 0x1) != 0)
          {
            localObject1 = new MessageForStructing();
            ((MessageForStructing)localObject1).msgData = paramMessage.msgData;
          }
        }
      }
      return KandianDailyManager.a((MessageForStructing)localObject1);
    }
    return KandianDailyManager.a;
  }
  
  public void launchKandianDaily(@Nullable Context paramContext)
  {
    launchKandianDaily(paramContext, false, null, 5);
  }
  
  public void launchKandianDaily(@Nullable Context paramContext, boolean paramBoolean, @Nullable Bundle paramBundle, int paramInt)
  {
    Object localObject1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject1 != null)
    {
      localObject1 = (QQAppInterface)localObject1;
      Object localObject2 = AppConstants.KANDIAN_DAILY_UIN;
      Object localObject3 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
      if (localObject3 != null)
      {
        RIJMergeKanDianMessage.a((String)localObject2, (QQAppInterface)localObject3);
        localObject3 = RIJKanDianRedDotUtils.a(((QQAppInterface)localObject1).getMessageFacade().b(AppConstants.KANDIAN_DAILY_UIN, 1008), "kandian_daily_red_pnt");
        localObject1 = paramBundle;
        if (localObject3 != null)
        {
          localObject1 = paramBundle;
          if (((KandianRedDotInfo)localObject3).hasArticleID())
          {
            localObject1 = paramBundle;
            if (paramBundle == null) {
              localObject1 = new Bundle();
            }
            ((Bundle)localObject1).putSerializable("kandian_feeds_red_pnt_info", (Serializable)localObject3);
          }
        }
        paramBundle = new StringBuilder();
        paramBundle.append("launch daily feeds, redPnt : ");
        paramBundle.append(localObject3);
        QLog.d("KandianDailyManager", 1, paramBundle.toString());
        if (localObject3 != null) {
          localObject2 = ((KandianRedDotInfo)localObject3).floatingWinData;
        } else {
          localObject2 = null;
        }
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (((KandianRedDotInfo)localObject3).floatingWinData.type != 0)
          {
            try
            {
              if (((KandianRedDotInfo)localObject3).cookie != null)
              {
                localObject2 = new JSONObject(((KandianRedDotInfo)localObject3).cookie).optString("push_rowkey");
                Intrinsics.checkExpressionValueIsNotNull(localObject2, "actionJo.optString(\"push_rowkey\")");
              }
            }
            catch (JSONException paramBundle)
            {
              QLog.d("KandianDailyManager", 2, paramBundle.getMessage());
              localObject2 = "";
            }
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              QLog.d("KandianDailyManager", 1, "launchKandianDaily floating layer rowkey is null");
              return;
            }
            int i = ((KandianRedDotInfo)localObject3).floatingWinData.type;
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null) {
              paramBundle = new Bundle();
            }
            paramBundle.putString("floating_window_rowkey", (String)localObject2);
            paramBundle.putString("float_layer_article_url", ((KandianRedDotInfo)localObject3).floatingWinData.url);
            paramBundle.putString("float_layer_topic_id", ((KandianRedDotInfo)localObject3).floatingWinData.topicID);
            paramBundle.putInt("floating_window_scene", 1);
            paramBundle.putBoolean("open_floating_window", true);
            paramBundle.putInt("floating_window_business", i);
            ((KandianRedDotInfo)localObject3).floatingWinData.clear();
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("launch daily feeds by default mode ; bundle ");
        ((StringBuilder)localObject1).append(paramBundle);
        QLog.d("KandianDailyManager", 1, ((StringBuilder)localObject1).toString());
        localObject1 = (IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class);
        if (paramContext == null) {
          Intrinsics.throwNpe();
        }
        ((IReadInJoyActivityHelper)localObject1).launchKanDianDailyActivity(paramContext, paramInt, paramBundle, paramBoolean);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.impl.KandianDailyManagerImpl
 * JD-Core Version:    0.7.0.1
 */