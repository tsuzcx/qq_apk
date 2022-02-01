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
  private SearchHistory a;
  private QQAppInterface b;
  
  public ContactSearchableSearchHistory(QQAppInterface paramQQAppInterface, SearchHistory paramSearchHistory)
  {
    this.b = paramQQAppInterface;
    this.a = paramSearchHistory;
  }
  
  public String a()
  {
    return this.a.extralInfo;
  }
  
  public void a(String paramString) {}
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    return this.a.displayName;
  }
  
  public String d()
  {
    if (this.a.type == 1)
    {
      TroopInfo localTroopInfo = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.a.uin);
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
  
  public SearchHistory e()
  {
    return this.a;
  }
  
  public int g()
  {
    return 0;
  }
  
  public Drawable i()
  {
    return null;
  }
  
  public String j()
  {
    return this.a.uin;
  }
  
  public int k()
  {
    int i = this.a.type;
    if (i != 1)
    {
      if (i != 1006) {
        if (i != 1008)
        {
          if (i != 3000)
          {
            if (i != 7220)
            {
              if (i != 10007)
              {
                if (i != 56938) {
                  return 1;
                }
              }
              else {
                return 119;
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
          if (TextUtils.equals(this.a.uin, AppConstants.NEW_KANDIAN_UIN)) {
            return 110;
          }
          return 1;
        }
      }
      return 11;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableSearchHistory
 * JD-Core Version:    0.7.0.1
 */