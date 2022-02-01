package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import expand.common.GetMatchSrcReq;
import expand.common.MatchedInfo;
import java.util.ArrayList;
import java.util.Collection;

public class LimitChatMatchInfoHelper
{
  public static int a(MatchedInfo paramMatchedInfo)
  {
    if ((paramMatchedInfo != null) && (paramMatchedInfo.get() != null))
    {
      if (!((MatchedInfo)paramMatchedInfo.get()).MatchSrcId.has()) {
        return 11;
      }
      int i = ((MatchedInfo)paramMatchedInfo.get()).MatchSrcId.get();
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            if (i != 4)
            {
              if (i == 12) {
                break label88;
              }
              if (i != 15) {
                return 11;
              }
            }
            else
            {
              return 10;
            }
          }
          return 9;
        }
        else
        {
          return 8;
        }
      }
      label88:
      return 7;
    }
    return 11;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, IExpandCmdCallback paramIExpandCmdCallback)
  {
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramString);
    GetMatchSrcReq localGetMatchSrcReq = new GetMatchSrcReq();
    localGetMatchSrcReq.UinList.addAll((Collection)localObject);
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start getMatchInfoRequest uin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("expand.chat.LimitChatMatchInfoHelper", 1, ((StringBuilder)localObject).toString());
    }
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(paramBaseQQAppInterface, "QQExpand.ExpandRelation.GetMatchSrc", localGetMatchSrcReq.toByteArray(), paramIExpandCmdCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.LimitChatMatchInfoHelper
 * JD-Core Version:    0.7.0.1
 */