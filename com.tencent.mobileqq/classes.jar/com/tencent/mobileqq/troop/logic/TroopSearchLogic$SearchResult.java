package com.tencent.mobileqq.troop.logic;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopSearchLogic$SearchResult
  implements Comparable<SearchResult>
{
  int jdField_a_of_type_Int;
  public TroopInfo a;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public int a(@NonNull SearchResult paramSearchResult)
  {
    if (this.b != paramSearchResult.b) {
      return this.b - paramSearchResult.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime != paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime) {
      return (int)(paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime);
    }
    if (paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime) {
      return (int)(paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != paramSearchResult.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - paramSearchResult.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(paramSearchResult.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopSearchLogic.SearchResult
 * JD-Core Version:    0.7.0.1
 */