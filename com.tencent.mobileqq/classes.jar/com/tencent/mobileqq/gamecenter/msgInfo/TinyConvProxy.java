package com.tencent.mobileqq.gamecenter.msgInfo;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TinyConvProxy
{
  public static TinyConvProxy a()
  {
    return TinyConvProxy.TinyConvProxyHolder.a;
  }
  
  private boolean a(ConversationInfo paramConversationInfo)
  {
    if (TextUtils.isEmpty(paramConversationInfo.extString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isValid() called, info is invalid!");
      localStringBuilder.append(paramConversationInfo);
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, localStringBuilder.toString());
      return false;
    }
    if ((paramConversationInfo.tinyInfo != null) && (!TextUtils.isEmpty(paramConversationInfo.tinyInfo.fromRoleId)) && (!TextUtils.isEmpty(paramConversationInfo.tinyInfo.toRoleId))) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isValid() called, info is invalid!");
    localStringBuilder.append(paramConversationInfo);
    QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, localStringBuilder.toString());
    return false;
  }
  
  public ConversationInfo a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if (paramAppInterface == null) {
      return null;
    }
    ConversationInfo localConversationInfo = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getConversationInfo(paramString, paramInt);
    if (localConversationInfo != null)
    {
      paramAppInterface = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (paramAppInterface == null) {
        return null;
      }
      paramAppInterface = paramAppInterface.getLastMessage(paramString, paramInt);
      if (paramAppInterface != null)
      {
        paramString = paramAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info");
        if (!TextUtils.isEmpty(paramString))
        {
          localConversationInfo.tinyInfo = new TinyInfo(paramString, paramAppInterface.isSend());
          localConversationInfo.extString = paramString;
        }
      }
      else if (!TextUtils.isEmpty(localConversationInfo.extString))
      {
        localConversationInfo.tinyInfo = new TinyInfo(localConversationInfo.extString);
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getTinyConvInfo info = ");
      paramAppInterface.append(localConversationInfo);
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, paramAppInterface.toString());
    }
    return localConversationInfo;
  }
  
  public List<ConversationInfo> a(AppInterface paramAppInterface)
  {
    Object localObject1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getConversationInfoSet();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject1).next();
      if (localConversationInfo.type == 10007)
      {
        Object localObject2 = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
        if (localObject2 == null) {
          return null;
        }
        localObject2 = ((IMessageFacade)localObject2).getLastMessage(localConversationInfo.uin, localConversationInfo.type);
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getTinyConvInfoList item = ");
            ((StringBuilder)localObject3).append(((MessageRecord)localObject2).getBaseInfoString());
            QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = ((MessageRecord)localObject2).getExtInfoFromExtStr("ext_key_game_msg_info");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localConversationInfo.extString = ((String)localObject3);
            localConversationInfo.tinyInfo = new TinyInfo((String)localObject3, ((MessageRecord)localObject2).isSend());
          }
        }
        else if (!TextUtils.isEmpty(localConversationInfo.extString))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getTinyConvInfoList info = ");
            ((StringBuilder)localObject2).append(localConversationInfo);
            QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, ((StringBuilder)localObject2).toString());
          }
          localConversationInfo.tinyInfo = new TinyInfo(localConversationInfo.extString);
        }
        if (a(localConversationInfo)) {
          localArrayList.add(localConversationInfo);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getTinyConvInfoList mock before = ");
      paramAppInterface.append(localArrayList);
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, paramAppInterface.toString());
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getTinyConvInfoList size = ");
      paramAppInterface.append(localArrayList.size());
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, paramAppInterface.toString());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msgInfo.TinyConvProxy
 * JD-Core Version:    0.7.0.1
 */