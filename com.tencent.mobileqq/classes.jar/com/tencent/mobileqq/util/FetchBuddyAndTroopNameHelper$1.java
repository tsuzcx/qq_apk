package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
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
    if ((paramInt != 1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("fetchInfoBatch size:").append(paramList.size()).append("  [");
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FetchInfoReq localFetchInfoReq = (FetchInfoReq)paramList.next();
        if ((localFetchInfoReq != null) && (localFetchInfoReq.jdField_a_of_type_Int == 1) && (localFetchInfoReq.a()))
        {
          if ((localFetchInfoReq.jdField_a_of_type_JavaLangString != null) && (localFetchInfoReq.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localFetchInfoReq.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localFetchInfoReq.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (paramList == null) {
        break;
      }
      paramList.getFriendInfoBatch(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(FetchInfoReq paramFetchInfoReq)
  {
    if ((paramFetchInfoReq == null) || (!paramFetchInfoReq.a())) {}
    Object localObject;
    do
    {
      do
      {
        TroopMemberInfoHandler localTroopMemberInfoHandler;
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("FetchBuddyAndTroopNameHelper", 2, StringUtil.a(new Object[] { "fetchInfo()", paramFetchInfoReq.toString() }));
              }
              if (paramFetchInfoReq.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (TroopHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            } while (localObject == null);
            ((TroopHandler)localObject).l(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
            return;
            if (paramFetchInfoReq.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          } while (localObject == null);
          ((FriendListHandler)localObject).getFriendInfo(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
          return;
          if (paramFetchInfoReq.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (TroopHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          localTroopMemberInfoHandler = (TroopMemberInfoHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
        } while ((localObject == null) || (localTroopMemberInfoHandler == null));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        if ((paramFetchInfoReq.jdField_a_of_type_AndroidOsBundle != null) && (paramFetchInfoReq.jdField_a_of_type_AndroidOsBundle.getInt(ContactUtils.jdField_a_of_type_JavaLangString) == ContactUtils.b))
        {
          ((TroopHandler)localObject).a(paramFetchInfoReq.b, localArrayList, false, paramFetchInfoReq.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        localTroopMemberInfoHandler.a(paramFetchInfoReq.b, (String)paramFetchInfoReq.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (paramFetchInfoReq.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    } while (localObject == null);
    ((FriendListHandler)localObject).getFriendInfo(paramFetchInfoReq.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper.1
 * JD-Core Version:    0.7.0.1
 */