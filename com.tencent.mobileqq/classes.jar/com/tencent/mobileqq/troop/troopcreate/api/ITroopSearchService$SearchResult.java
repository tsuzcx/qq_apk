package com.tencent.mobileqq.troop.troopcreate.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class ITroopSearchService$SearchResult
  implements Comparable<SearchResult>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull SearchResult paramSearchResult)
  {
    int i = this.b;
    int j = paramSearchResult.b;
    if (i != j) {
      return i - j;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime != paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime) {
      return (int)(paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime);
    }
    if (paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime) {
      return (int)(paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime);
    }
    i = this.jdField_a_of_type_Int;
    j = paramSearchResult.jdField_a_of_type_Int;
    if (i != j) {
      return i - j;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(paramSearchResult.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult
 * JD-Core Version:    0.7.0.1
 */