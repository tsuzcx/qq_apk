package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.model.IContactSearchModel;
import java.util.Comparator;

final class ContactSearchEngine$2
  implements Comparator<IContactSearchModel>
{
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int j = Long.signum(paramIContactSearchModel2.b() - paramIContactSearchModel1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramIContactSearchModel2.a() - paramIContactSearchModel1.a());
    }
    j = i;
    if (i == 0) {
      j = ContactSearchEngine.a(paramIContactSearchModel1, paramIContactSearchModel2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */