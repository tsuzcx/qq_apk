package com.tencent.mobileqq.kandian.biz.xtab.msgboard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardRedUtil;", "", "()V", "ACTION_NAME_MESSAGE_BOARD_CLICK", "", "ACTION_NAME_MESSAGE_BOARD_EXPOSURE", "MESSAGE_BOARD_IS_SHOW_RED", "MESSAGE_BOARD_LAST_UPDATE_TIME_KEY", "TAG", "redInfo", "Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardRedUtil$MessageBoardRedInfo;", "getRedInfo", "()Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardRedUtil$MessageBoardRedInfo;", "setRedInfo", "(Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardRedUtil$MessageBoardRedInfo;)V", "clearRedInfo", "", "getReportR5", "isShowRed", "", "reportData", "actionName", "r5", "requestMessageBoardRedInfo", "updateMessageBoardLastUpdateTime", "timeInSeconds", "", "updateRedInfo", "MessageBoardRedInfo", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabMessageBoardRedUtil
{
  public static final RIJXTabMessageBoardRedUtil a = new RIJXTabMessageBoardRedUtil();
  @NotNull
  private static RIJXTabMessageBoardRedUtil.MessageBoardRedInfo b;
  
  static
  {
    RIJXTabMessageBoardRedUtil.MessageBoardRedInfo localMessageBoardRedInfo = new RIJXTabMessageBoardRedUtil.MessageBoardRedInfo();
    Object localObject = RIJSPUtils.b("rij_message_board_is_show_red", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…BOARD_IS_SHOW_RED, false)");
    localMessageBoardRedInfo.a(((Boolean)localObject).booleanValue());
    b = localMessageBoardRedInfo;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[init] redInfo = ");
    ((StringBuilder)localObject).append(localMessageBoardRedInfo);
    QLog.i("RIJXTabMessageBoardRedUtil", 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(long paramLong)
  {
    RIJSPUtils.a("rij_message_board_last_update_time_key", Long.valueOf(paramLong));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[updateMessageBoardLastUpdateTime] lastUpdateTime = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("RIJXTabMessageBoardModule", 1, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new Date(paramLong * 1000);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateMessageBoardLastUpdateTime] date = ");
      localStringBuilder.append(localObject);
      QLog.i("RIJXTabMessageBoardRedUtil", 1, localStringBuilder.toString());
    }
  }
  
  public final void a(@NotNull RIJXTabMessageBoardRedUtil.MessageBoardRedInfo paramMessageBoardRedInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageBoardRedInfo, "redInfo");
    b = paramMessageBoardRedInfo;
    RIJSPUtils.a("rij_message_board_is_show_red", Boolean.valueOf(paramMessageBoardRedInfo.a()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateRedInfo] redInfo = ");
    localStringBuilder.append(paramMessageBoardRedInfo);
    QLog.i("RIJXTabMessageBoardRedUtil", 1, localStringBuilder.toString());
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "actionName");
    Intrinsics.checkParameterIsNotNull(paramString2, "r5");
    ThreadManager.getSubThreadHandler().post((Runnable)new RIJXTabMessageBoardRedUtil.reportData.1(paramString1, paramString2));
  }
  
  public final boolean a()
  {
    if (!RIJXTabMessageBoardConfigUtil.a.b()) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isShowRed] res = ");
    localStringBuilder.append(b.a());
    QLog.i("RIJXTabMessageBoardRedUtil", 1, localStringBuilder.toString());
    return b.a();
  }
  
  public final void b()
  {
    b.a(false);
    RIJSPUtils.a("rij_message_board_is_show_red", Boolean.valueOf(false));
    QLog.i("RIJXTabMessageBoardRedUtil", 1, "[isShowRed] clear redInfo.");
  }
  
  public final boolean c()
  {
    if (b.a())
    {
      QLog.i("RIJXTabMessageBoardRedUtil", 1, "[requestMessageBoardRedInfo] isShowRed, do not request redInfo.");
      return false;
    }
    if (!RIJXTabMessageBoardConfigUtil.a.b())
    {
      QLog.i("RIJXTabMessageBoardRedUtil", 1, "[requestMessageBoardRedInfo] message board button is hidden, do not request redInfo.");
      return false;
    }
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject != null) {
      localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    } else {
      localObject = null;
    }
    localObject = (ReadInJoyLogicManager)localObject;
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicEngine)localObject).ah();
        if (localObject != null) {
          ((RIJXTabMessageBoardModule)localObject).a();
        }
      }
    }
    return true;
  }
  
  @NotNull
  public final String d()
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (a())
        {
          String str1 = "1";
          ((JSONObject)localObject).put("is_reddot", str1);
          str1 = ((JSONObject)localObject).toString();
          Intrinsics.checkExpressionValueIsNotNull(str1, "json.toString()");
          return str1;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getReportR5] e = ");
        ((StringBuilder)localObject).append(localJSONException);
        QLog.e("RIJXTabMessageBoardRedUtil", 1, ((StringBuilder)localObject).toString());
        return "";
      }
      String str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardRedUtil
 * JD-Core Version:    0.7.0.1
 */