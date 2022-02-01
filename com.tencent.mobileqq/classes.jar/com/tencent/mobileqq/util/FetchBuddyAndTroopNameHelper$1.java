package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FetchBuddyAndTroopNameHelper$1
  implements FetchInfoListManager.FetchInfoListener
{
  FetchBuddyAndTroopNameHelper$1(FetchBuddyAndTroopNameHelper paramFetchBuddyAndTroopNameHelper) {}
  
  public void a(int paramInt, List<FetchInfoReq> paramList)
  {
    if ((paramInt == 1) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      StringBuilder localStringBuilder = null;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder(200);
        localStringBuilder.append("fetchInfoBatch size:");
        localStringBuilder.append(paramList.size());
        localStringBuilder.append("  [");
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FetchInfoReq localFetchInfoReq = (FetchInfoReq)paramList.next();
        if ((localFetchInfoReq != null) && (localFetchInfoReq.a == 1) && (localFetchInfoReq.a()))
        {
          if ((localFetchInfoReq.b != null) && (localFetchInfoReq.b.length() > 0)) {
            localArrayList.add(localFetchInfoReq.b);
          }
          if (localStringBuilder != null)
          {
            localStringBuilder.append(localFetchInfoReq.b);
            localStringBuilder.append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (paramList != null) {
        paramList.getFriendInfoBatch(localArrayList, false);
      }
    }
  }
  
  public void a(FetchInfoReq paramFetchInfoReq)
  {
    if (paramFetchInfoReq != null)
    {
      if (!paramFetchInfoReq.a()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FetchBuddyAndTroopNameHelper", 2, StringUtil.makeLogMsg(new Object[] { "fetchInfo()", paramFetchInfoReq.toString() }));
      }
      Object localObject;
      if (paramFetchInfoReq.a == 2)
      {
        localObject = (ITroopMngHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
        if (localObject != null) {
          ((ITroopMngHandler)localObject).c(paramFetchInfoReq.b);
        }
      }
      else if (paramFetchInfoReq.a == 1)
      {
        localObject = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localObject != null) {
          ((FriendListHandler)localObject).getFriendInfo(paramFetchInfoReq.b);
        }
      }
      else if (paramFetchInfoReq.a == 3)
      {
        localObject = (ITroopMemberInfoHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
        ITroopMemberCardHandler localITroopMemberCardHandler = (ITroopMemberCardHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
        if ((localObject != null) && (localITroopMemberCardHandler != null))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramFetchInfoReq.b);
          if ((paramFetchInfoReq.e != null) && (paramFetchInfoReq.e.getInt(ContactUtils.a) == ContactUtils.c))
          {
            ((ITroopMemberInfoHandler)localObject).a(paramFetchInfoReq.c, localArrayList, false, paramFetchInfoReq.e);
            return;
          }
          localITroopMemberCardHandler.a(paramFetchInfoReq.c, (String)paramFetchInfoReq.d, localArrayList);
        }
      }
      else if (paramFetchInfoReq.a == 4)
      {
        localObject = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localObject != null) {
          ((FriendListHandler)localObject).getFriendInfo(paramFetchInfoReq.b, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper.1
 * JD-Core Version:    0.7.0.1
 */