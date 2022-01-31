package com.tencent.mobileqq.troop.logic;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.TroopInfo;

public class TroopSearchLogic$SearchResult
  implements Comparable
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull SearchResult paramSearchResult)
  {
    if (this.b != paramSearchResult.b) {
      return this.b - paramSearchResult.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime != paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime) {
      return (int)(paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime);
    }
    if (paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime) {
      return (int)(paramSearchResult.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != paramSearchResult.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - paramSearchResult.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(paramSearchResult.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopSearchLogic.SearchResult
 * JD-Core Version:    0.7.0.1
 */