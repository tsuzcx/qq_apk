package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.model.TroopBatchAddFrdsSearchModelMember;
import java.util.Comparator;

class TroopBatchAddFrdsSearchEngine$1
  implements Comparator<IContactSearchModel>
{
  TroopBatchAddFrdsSearchEngine$1(TroopBatchAddFrdsSearchEngine paramTroopBatchAddFrdsSearchEngine) {}
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    paramIContactSearchModel1 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel1;
    paramIContactSearchModel2 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel2;
    boolean bool1 = TroopBatchAddFrdsSearchEngine.a(this.a, (String)paramIContactSearchModel1.i());
    boolean bool2 = TroopBatchAddFrdsSearchEngine.a(this.a, (String)paramIContactSearchModel2.i());
    int j;
    int i;
    if ((!bool1) && (!bool2))
    {
      bool1 = TroopBatchAddFrdsSearchEngine.b(this.a, (String)paramIContactSearchModel1.i());
      bool2 = TroopBatchAddFrdsSearchEngine.b(this.a, (String)paramIContactSearchModel2.i());
      if ((!bool1) && (!bool2))
      {
        j = paramIContactSearchModel2.s();
        i = paramIContactSearchModel1.s();
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
      j = paramIContactSearchModel2.s();
      i = paramIContactSearchModel1.s();
      continue;
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      j = paramIContactSearchModel2.s();
      i = paramIContactSearchModel1.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.TroopBatchAddFrdsSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */