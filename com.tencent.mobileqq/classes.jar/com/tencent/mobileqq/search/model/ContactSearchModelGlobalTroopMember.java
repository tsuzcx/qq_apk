package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;

public class ContactSearchModelGlobalTroopMember
  extends IContactSearchModel
{
  protected int a;
  protected long a;
  protected TroopInfo a;
  public String a;
  protected long b;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  public ContactSearchModelGlobalTroopMember(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = IContactSearchable.V;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)paramQQAppInterface.getManager(51)).b(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
      this.jdField_b_of_type_Long = IContactSearchable.G;
    }
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.e = "";
      this.f = null;
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.c))
      {
        this.e = this.c;
        this.f = this.jdField_b_of_type_JavaLangString;
        return;
      }
      if (!TextUtils.isEmpty(this.d))
      {
        this.e = this.d;
        this.f = this.jdField_b_of_type_JavaLangString;
        return;
      }
      this.e = this.jdField_b_of_type_JavaLangString;
      this.f = null;
      return;
    case 2: 
      this.e = this.c;
      if (!TextUtils.isEmpty(this.d))
      {
        this.f = this.d;
        return;
      }
      this.f = this.jdField_b_of_type_JavaLangString;
      return;
    }
    if (!TextUtils.isEmpty(this.c))
    {
      this.e = this.c;
      this.f = this.d;
      return;
    }
    this.e = this.d;
    this.f = this.jdField_b_of_type_JavaLangString;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.g = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop())
    {
      bool = false;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        break label188;
      }
      l = IContactSearchable.i;
      label38:
      l = SearchUtils.a(paramString, this.c, l, false, false, bool);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 2;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        break label195;
      }
    }
    label188:
    label195:
    for (long l = IContactSearchable.h;; l = IContactSearchable.l)
    {
      l = SearchUtils.a(paramString, this.d, l, false, false, bool);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 1;
      }
      l = SearchUtils.a(paramString, this.jdField_b_of_type_JavaLangString, IContactSearchable.o, false, true, true);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Long != -9223372036854775808L)
      {
        this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
        a();
      }
      return this.jdField_a_of_type_Long;
      bool = true;
      break;
      l = IContactSearchable.q;
      break label38;
    }
  }
  
  public Object a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    String str;
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      RecentUtil.a = true;
      str = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_JavaLangString);
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_b_of_type_JavaLangString);
      if ((localFriends == null) || (!localFriends.isFriend())) {
        break label149;
      }
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, 0, ContactUtils.a(localFriends), false);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ContactUtils.a(localFriends), this.jdField_b_of_type_JavaLangString, "", 0);
    }
    for (;;)
    {
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
      SearchUtils.a(this.g, 20, 1, paramView);
      SearchUtils.a(this.g, 20, paramView, false);
      SearchUtils.a(this, paramView);
      return;
      label149:
      RecentUtil.a(paramView.getContext(), this.jdField_b_of_type_JavaLangString, str, 1000, a().toString(), false);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_b_of_type_JavaLangString, str, 1000);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 1000;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public CharSequence c()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
    if (str != null) {
      return "来自群:" + str;
    }
    return "来自:群成员";
  }
  
  public String c()
  {
    return this.e;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroopMember
 * JD-Core Version:    0.7.0.1
 */