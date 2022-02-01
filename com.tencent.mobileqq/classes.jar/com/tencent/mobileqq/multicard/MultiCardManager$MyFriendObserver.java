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
  
  protected void onAddFriend(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAddFriend ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MultiCardManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((!MultiCardManager.c(this.a)) && (MultiCardManager.b(this.a) != null))
    {
      localObject = (ArrayList)MultiCardManager.b(this.a).get(Long.valueOf(MultiCardManager.d(this.a)));
      if (localObject != null) {
        try
        {
          long l = Long.parseLong(paramString);
          if (((ArrayList)localObject).indexOf(Long.valueOf(l)) != -1)
          {
            paramString = new ArrayList(1);
            paramString.add(Long.valueOf(l));
            localObject = new ArrayList(1);
            ((ArrayList)localObject).add(Long.valueOf(MultiCardManager.d(this.a)));
            HashMap localHashMap = new HashMap(5);
            localHashMap.put("notRequest", paramString);
            localHashMap.put("groupUin", localObject);
            ((IntimateInfoHandler)MultiCardManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)).a(MultiCardManager.d(this.a), paramString, localHashMap);
            return;
          }
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onAddFriend error ");
            ((StringBuilder)localObject).append(paramString.toString());
            QLog.d("MultiCardManager", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.MyFriendObserver
 * JD-Core Version:    0.7.0.1
 */