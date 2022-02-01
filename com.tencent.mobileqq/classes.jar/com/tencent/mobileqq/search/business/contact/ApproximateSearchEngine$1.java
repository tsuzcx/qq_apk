package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.SearchMatchResult;
import java.util.Comparator;

final class ApproximateSearchEngine$1
  implements Comparator<IContactSearchModel>
{
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    if (paramIContactSearchModel2.a() == null) {
      return -1;
    }
    if (paramIContactSearchModel1.a() == null) {
      return 1;
    }
    int j = Integer.signum(paramIContactSearchModel2.a().c - paramIContactSearchModel1.a().c);
    int i = j;
    if (j == 0) {
      i = ApproximateSearchEngine.a(paramIContactSearchModel1, paramIContactSearchModel2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */