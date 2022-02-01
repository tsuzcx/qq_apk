package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class MultiCardManager$MyFriendObserver
  extends FriendListObserver
{
  private MultiCardManager$MyFriendObserver(MultiCardManager paramMultiCardManager) {}
  
  public void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardManager", 2, "onAddFriend " + paramString);
    }
    ArrayList localArrayList;
    if ((!MultiCardManager.a(this.a)) && (MultiCardManager.a(this.a) != null))
    {
      localArrayList = (ArrayList)MultiCardManager.a(this.a).get(Long.valueOf(MultiCardManager.a(this.a)));
      if (localArrayList == null) {}
    }
    try
    {
      long l = Long.parseLong(paramString);
      if (localArrayList.indexOf(Long.valueOf(l)) != -1)
      {
        paramString = new ArrayList(1);
        paramString.add(Long.valueOf(l));
        localArrayList = new ArrayList(1);
        localArrayList.add(Long.valueOf(MultiCardManager.a(this.a)));
        HashMap localHashMap = new HashMap(5);
        localHashMap.put("notRequest", paramString);
        localHashMap.put("groupUin", localArrayList);
        ((IntimateInfoHandler)MultiCardManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)).a(MultiCardManager.a(this.a), paramString, localHashMap);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiCardManager", 2, "onAddFriend error " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.MyFriendObserver
 * JD-Core Version:    0.7.0.1
 */