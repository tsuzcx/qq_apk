package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class ContactSearchableSearchHistory
  extends IContactSearchable
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SearchHistory jdField_a_of_type_ComTencentMobileqqDataSearchHistory;
  
  public ContactSearchableSearchHistory(QQAppInterface paramQQAppInterface, SearchHistory paramSearchHistory)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory = paramSearchHistory;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public SearchHistory a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.extralInfo;
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return null;
  }
  
  public int c()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.type)
    {
    default: 
    case 3000: 
    case 1: 
    case 1006: 
    case 56938: 
    case 1008: 
      do
      {
        return 1;
        return 101;
        return 4;
        return 11;
      } while (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.uin, AppConstants.NEW_KANDIAN_UIN));
      return 110;
    }
    return 111;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.displayName;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.type == 1)
    {
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.uin);
      if ((localTroopInfo != null) && (!TextUtils.isEmpty(localTroopInfo.troopRemark))) {
        return "(" + localTroopInfo.troopRemark + ")";
      }
    }
    return "";
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableSearchHistory
 * JD-Core Version:    0.7.0.1
 */