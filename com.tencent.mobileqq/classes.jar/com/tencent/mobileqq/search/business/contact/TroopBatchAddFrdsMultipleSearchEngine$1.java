package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.model.TroopBatchAddFrdsSearchModelMember;
import java.util.Comparator;

class TroopBatchAddFrdsMultipleSearchEngine$1
  implements Comparator<IContactSearchModel>
{
  TroopBatchAddFrdsMultipleSearchEngine$1(TroopBatchAddFrdsMultipleSearchEngine paramTroopBatchAddFrdsMultipleSearchEngine) {}
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    paramIContactSearchModel1 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel1;
    paramIContactSearchModel2 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel2;
    boolean bool1 = TroopBatchAddFrdsMultipleSearchEngine.a(this.a, (String)paramIContactSearchModel1.a());
    boolean bool2 = TroopBatchAddFrdsMultipleSearchEngine.a(this.a, (String)paramIContactSearchModel2.a());
    int j;
    int i;
    if ((!bool1) && (!bool2))
    {
      bool1 = TroopBatchAddFrdsMultipleSearchEngine.b(this.a, (String)paramIContactSearchModel1.a());
      bool2 = TroopBatchAddFrdsMultipleSearchEngine.b(this.a, (String)paramIContactSearchModel2.a());
      if ((!bool1) && (!bool2))
      {
        j = paramIContactSearchModel2.f();
        i = paramIContactSearchModel1.f();
      }
    }
    for (;;)
    {
      return j - i;
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      j = paramIContactSearchModel2.f();
      i = paramIContactSearchModel1.f();
      continue;
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      j = paramIContactSearchModel2.f();
      i = paramIContactSearchModel1.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.TroopBatchAddFrdsMultipleSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */