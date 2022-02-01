package com.tencent.mobileqq.search.mostused;

import java.util.Comparator;

final class MostUsedCache$1
  implements Comparator<MostUsedCache.MostUsedSearchItemModel>
{
  public int a(MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel1, MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel2)
  {
    int j = Long.signum(paramMostUsedSearchItemModel2.jdField_a_of_type_Int - paramMostUsedSearchItemModel1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(paramMostUsedSearchItemModel2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - paramMostUsedSearchItemModel1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedCache.1
 * JD-Core Version:    0.7.0.1
 */