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
    int i = this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.type;
    if (i != 1)
    {
      if (i != 1006) {
        if (i != 1008)
        {
          if (i != 3000)
          {
            if (i != 7220)
            {
              if (i != 56938) {
                return 1;
              }
            }
            else {
              return 111;
            }
          }
          else {
            return 101;
          }
        }
        else
        {
          if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.uin, AppConstants.NEW_KANDIAN_UIN)) {
            return 110;
          }
          return 1;
        }
      }
      return 11;
    }
    return 4;
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
      if ((localTroopInfo != null) && (!TextUtils.isEmpty(localTroopInfo.troopRemark)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(");
        localStringBuilder.append(localTroopInfo.troopRemark);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
    }
    return "";
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableSearchHistory
 * JD-Core Version:    0.7.0.1
 */