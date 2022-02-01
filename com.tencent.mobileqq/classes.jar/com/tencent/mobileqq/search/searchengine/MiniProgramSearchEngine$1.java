package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class MiniProgramSearchEngine$1
  implements Comparator<MiniProgramSearchResultModel>
{
  MiniProgramSearchEngine$1(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(MiniProgramSearchResultModel paramMiniProgramSearchResultModel1, MiniProgramSearchResultModel paramMiniProgramSearchResultModel2)
  {
    int i = paramMiniProgramSearchResultModel2.a[2] - paramMiniProgramSearchResultModel1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramMiniProgramSearchResultModel1.a[0] - paramMiniProgramSearchResultModel2.a[0];
      i = j;
    } while (j != 0);
    paramMiniProgramSearchResultModel1 = paramMiniProgramSearchResultModel1.c().substring(paramMiniProgramSearchResultModel1.a[0] + paramMiniProgramSearchResultModel1.a[1]);
    paramMiniProgramSearchResultModel2 = paramMiniProgramSearchResultModel2.c().substring(paramMiniProgramSearchResultModel2.a[0] + paramMiniProgramSearchResultModel2.a[1]);
    return ChnToSpell.a(paramMiniProgramSearchResultModel1, 2).compareTo(ChnToSpell.a(paramMiniProgramSearchResultModel2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */