package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import java.util.Comparator;

final class PublicAccountSearchEngine$3
  implements Comparator<PublicAccountSearchResultModel>
{
  public int a(PublicAccountSearchResultModel paramPublicAccountSearchResultModel1, PublicAccountSearchResultModel paramPublicAccountSearchResultModel2)
  {
    int j = Long.signum(paramPublicAccountSearchResultModel2.u() - paramPublicAccountSearchResultModel1.u());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramPublicAccountSearchResultModel2.dk_() - paramPublicAccountSearchResultModel1.dk_());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(paramPublicAccountSearchResultModel1, paramPublicAccountSearchResultModel2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */