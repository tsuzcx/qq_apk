package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import java.util.Comparator;

final class ContactSearchEngine$1
  implements Comparator<IContactSearchModel>
{
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int j = Long.signum(paramIContactSearchModel2.b() - paramIContactSearchModel1.b());
    int i = j;
    if (j == 0) {
      i = ContactSearchEngine.a(paramIContactSearchModel1, paramIContactSearchModel2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ContactSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */