package com.tencent.mobileqq.newfriend.ui.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

class NewFriendMoreSysMsgAdapter$10
  extends DiscussionObserver
{
  NewFriendMoreSysMsgAdapter$10(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public void a(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      String str1 = (String)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      String str2 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getDiscussionNameCanNull(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong));
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        NewFriendMoreSysMsgAdapter.a(this.a, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate [uin: %d, pre: %s, cur: %s]", new Object[] { Long.valueOf(paramLong), str1, str2 }));
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      a(paramLong);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      Object localObject = null;
      if ((paramObject instanceof ArrayList)) {
        localObject = (ArrayList)paramObject;
      }
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramObject = ((ArrayList)localObject).iterator();
        while (paramObject.hasNext())
        {
          localObject = paramObject.next();
          if ((localObject instanceof Long)) {
            a(((Long)localObject).longValue());
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      try
      {
        a(Long.parseLong(paramString));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.10
 * JD-Core Version:    0.7.0.1
 */