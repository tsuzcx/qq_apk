package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.TroopBatchAddFrdsSearchModelMember;
import java.util.Comparator;

class TroopBatchAddFrdsSearchEngine$1
  implements Comparator<IContactSearchModel>
{
  TroopBatchAddFrdsSearchEngine$1(TroopBatchAddFrdsSearchEngine paramTroopBatchAddFrdsSearchEngine) {}
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i = -1;
    paramIContactSearchModel1 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel1;
    paramIContactSearchModel2 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel2;
    FriendsManager localFriendsManager = (FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool1 = localFriendsManager.b((String)paramIContactSearchModel1.a());
    boolean bool2 = localFriendsManager.b((String)paramIContactSearchModel2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localFriendsManager.d((String)paramIContactSearchModel1.a());
      bool2 = localFriendsManager.d((String)paramIContactSearchModel2.a());
      if ((!bool1) && (!bool2)) {
        return paramIContactSearchModel2.f() - paramIContactSearchModel1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramIContactSearchModel2.f() - paramIContactSearchModel1.f();
    }
    if (bool1 != bool2)
    {
      if (bool2) {}
      for (;;)
      {
        return i;
        i = 1;
      }
    }
    return paramIContactSearchModel2.f() - paramIContactSearchModel1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.TroopBatchAddFrdsSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */