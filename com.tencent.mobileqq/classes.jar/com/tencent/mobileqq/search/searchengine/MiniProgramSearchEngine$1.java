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
    int i = paramMiniProgramSearchResultModel2.c[2] - paramMiniProgramSearchResultModel1.c[2];
    if (i != 0) {
      return i;
    }
    i = paramMiniProgramSearchResultModel1.c[0] - paramMiniProgramSearchResultModel2.c[0];
    if (i != 0) {
      return i;
    }
    paramMiniProgramSearchResultModel1 = paramMiniProgramSearchResultModel1.m().substring(paramMiniProgramSearchResultModel1.c[0] + paramMiniProgramSearchResultModel1.c[1]);
    paramMiniProgramSearchResultModel2 = paramMiniProgramSearchResultModel2.m().substring(paramMiniProgramSearchResultModel2.c[0] + paramMiniProgramSearchResultModel2.c[1]);
    return ChnToSpell.b(paramMiniProgramSearchResultModel1, 2).compareTo(ChnToSpell.b(paramMiniProgramSearchResultModel2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */