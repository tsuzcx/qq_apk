package com.tencent.mobileqq.phonecontact.api.impl;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class PhoneContactServiceImpl$LoadContactFriendListTask
  extends AsyncTask<RespondQueryQQBindingStat, Void, List<PhoneContact>>
{
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private PhoneContactServiceImpl$LoadContactFriendListTask(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  protected List<PhoneContact> a(RespondQueryQQBindingStat... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.ContactFriendTask", 2, "doInBackground");
    }
    Object localObject = paramVarArgs[0];
    paramVarArgs = new ArrayList();
    paramVarArgs.addAll(PhoneContactServiceImpl.access$1700(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiImplPhoneContactServiceImpl).values());
    Collections.sort(paramVarArgs, new PhoneContactServiceImpl.LoadContactFriendListTask.1(this));
    ArrayList localArrayList = new ArrayList();
    IFriendDataService localIFriendDataService = (IFriendDataService)PhoneContactServiceImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiImplPhoneContactServiceImpl).getRuntimeService(IFriendDataService.class, "");
    IAddFriendServiceApi localIAddFriendServiceApi = (IAddFriendServiceApi)PhoneContactServiceImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiImplPhoneContactServiceImpl).getRuntimeService(IAddFriendServiceApi.class, "");
    if (paramVarArgs.size() > 0)
    {
      localObject = ((RespondQueryQQBindingStat)localObject).mobileNo;
      Iterator localIterator = paramVarArgs.iterator();
      while (localIterator.hasNext())
      {
        paramVarArgs = (PhoneContact)localIterator.next();
        if (isCancelled()) {
          break;
        }
        if ((localObject == null) || (!((String)localObject).endsWith(paramVarArgs.mobileNo.trim())))
        {
          PhoneContact localPhoneContact = (PhoneContact)paramVarArgs.clone();
          if (!TextUtils.isEmpty(localPhoneContact.uin))
          {
            if (localPhoneContact.uin.equals("0")) {
              paramVarArgs = null;
            } else {
              paramVarArgs = localIFriendDataService.getFriend(localPhoneContact.uin, true, true);
            }
            if ((paramVarArgs != null) && (paramVarArgs.groupid >= 0))
            {
              localPhoneContact.nickName = paramVarArgs.getFriendNick();
              localPhoneContact.remark = paramVarArgs.remark;
              localPhoneContact.sortWeight = 262144;
            }
            else
            {
              localPhoneContact.uin = "0";
              paramVarArgs = new StringBuilder();
              paramVarArgs.append(localPhoneContact.nationCode);
              paramVarArgs.append(localPhoneContact.mobileCode);
              if (localIAddFriendServiceApi.hasSendAddFriendReq(paramVarArgs.toString()))
              {
                localPhoneContact.sortWeight = 131072;
                localPhoneContact.hasSendAddReq = true;
              }
              else
              {
                paramVarArgs = this.jdField_a_of_type_JavaUtilList;
                if ((paramVarArgs != null) && (paramVarArgs.contains(localPhoneContact.mobileNo))) {
                  localPhoneContact.sortWeight = this.jdField_a_of_type_JavaUtilList.indexOf(localPhoneContact.mobileNo);
                } else {
                  localPhoneContact.sortWeight = 65536;
                }
              }
            }
            localArrayList.add(localPhoneContact);
          }
        }
      }
      Collections.sort(localArrayList, new PhoneContactServiceImpl.LoadContactFriendListTask.2(this));
    }
    return localArrayList;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected void b(List<PhoneContact> paramList)
  {
    if (!isCancelled()) {
      PhoneContactServiceImpl.access$3800(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiImplPhoneContactServiceImpl, paramList);
    }
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.ContactFriendTask", 2, "on cancelled");
    }
    PhoneContactServiceImpl.access$3702(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiImplPhoneContactServiceImpl, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.LoadContactFriendListTask
 * JD-Core Version:    0.7.0.1
 */