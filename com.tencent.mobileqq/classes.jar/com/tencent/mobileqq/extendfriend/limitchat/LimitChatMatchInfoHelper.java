package com.tencent.mobileqq.extendfriend.limitchat;

import com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler;
import com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler.ICallback;
import com.tencent.mobileqq.extendfriend.network.ExpandResponse;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import expand.common.GetMatchSrcReq;
import expand.common.MatchedInfo;
import java.util.ArrayList;
import java.util.Collection;

public class LimitChatMatchInfoHelper
{
  public static int a(MatchedInfo paramMatchedInfo)
  {
    if ((paramMatchedInfo == null) || (paramMatchedInfo.get() == null) || (!((MatchedInfo)paramMatchedInfo.get()).MatchSrcId.has())) {
      return 11;
    }
    switch (((MatchedInfo)paramMatchedInfo.get()).MatchSrcId.get())
    {
    default: 
      return 11;
    case 1: 
      return 7;
    case 2: 
      return 8;
    case 3: 
      return 9;
    }
    return 10;
  }
  
  public static void a(String paramString, ExpandCmdHandler.ICallback paramICallback)
  {
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramString);
    GetMatchSrcReq localGetMatchSrcReq = new GetMatchSrcReq();
    localGetMatchSrcReq.UinList.addAll((Collection)localObject);
    localObject = ExpandCmdHandler.a();
    if (localObject == null)
    {
      QLog.w("expand.chat.LimitChatMatchInfoHelper", 1, "start getMatchInfoRequest uin:" + paramString + " but handler is null!");
      paramICallback.a(null, new ExpandResponse(-1, "handler is null"));
    }
    do
    {
      return;
      ((ExpandCmdHandler)localObject).a("QQExpand.ExpandRelation.GetMatchSrc", localGetMatchSrcReq.toByteArray(), paramICallback);
    } while (!QLog.isDebugVersion());
    QLog.d("expand.chat.LimitChatMatchInfoHelper", 1, "start getMatchInfoRequest uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatMatchInfoHelper
 * JD-Core Version:    0.7.0.1
 */