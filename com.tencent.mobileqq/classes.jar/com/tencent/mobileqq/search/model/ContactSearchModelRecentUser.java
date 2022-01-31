package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Map;

public class ContactSearchModelRecentUser
  extends IContactSearchModel
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1000, 1004, 1005, 1006, 1001, 10002, 10004 };
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String k;
  private String l;
  
  public ContactSearchModelRecentUser(QQAppInterface paramQQAppInterface, int paramInt, RecentUser paramRecentUser, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    b();
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.k = this.c;
      this.l = SearchUtils.a(new String[] { this.e, this.f });
      return;
    case 3: 
      this.k = this.d;
      this.l = SearchUtils.a(new String[] { this.e, this.f });
      return;
    case 1: 
      this.k = SearchUtils.a(new String[] { this.c, this.d });
      if (!TextUtils.isEmpty(this.k))
      {
        this.l = this.e;
        return;
      }
      this.k = this.e;
      this.l = this.f;
      return;
    case 4: 
      this.k = this.g;
      this.l = this.f;
      return;
    }
    this.k = SearchUtils.a(new String[] { this.c, this.d, this.e });
    this.l = this.f;
  }
  
  private void b()
  {
    this.f = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
    this.e = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName;
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
    {
    default: 
      localObject1 = "临时会话";
      if (!SearchUtils.a(this.jdField_b_of_type_Int)) {
        break;
      }
    }
    for (this.jdField_a_of_type_JavaLangString = ("来自:" + (String)localObject1);; this.jdField_a_of_type_JavaLangString = ((String)localObject1))
    {
      if ((TextUtils.isEmpty(this.e)) || (this.e.equals(this.f))) {
        this.e = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.f, true);
      }
      return;
      localObject1 = ((TroopManager)localObject1).b(((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) {
          this.c = ((TroopMemberInfo)localObject1).troopnick;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark)) {
          this.d = ((TroopMemberInfo)localObject1).autoremark;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick)) {
          this.e = ((TroopMemberInfo)localObject1).friendnick;
        }
      }
      localObject1 = "群临时会话";
      break;
      localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
      if (localObject1 != null)
      {
        localObject1 = (DiscussionMemberInfo)((Map)localObject1).get(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (localObject1 != null)
        {
          localObject2 = ((DiscussionMemberInfo)localObject1).memberName;
          if (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark)) {
            this.d = ((DiscussionMemberInfo)localObject1).inteRemark;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.e = ((String)localObject2);
          }
        }
      }
      Object localObject2 = "多人聊天临时会话";
      localObject1 = localObject2;
      if (this.e == null) {
        break;
      }
      localObject1 = localObject2;
      if (!this.e.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
        break;
      }
      this.e = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
      localObject1 = localObject2;
      break;
      localObject1 = "wap临时会话";
      break;
      this.g = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName;
      this.e = null;
      localObject1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      localObject2 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localObject2 != null) {
        this.g = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        localObject1 = "通讯录临时会话";
        break;
        if (localObject1 != null) {
          this.g = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
      }
      localObject1 = "附近的人临时会话";
      break;
      localObject1 = "兴趣部落临时会话";
      break;
      localObject1 = "QQ电影票临时会话";
      break;
    }
  }
  
  public int a()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
    {
    case 1000: 
    case 1004: 
    case 1005: 
    default: 
      return 1;
    case 1006: 
      return 11;
    }
    return 32;
  }
  
  protected long a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l1 = SearchUtils.b(paramString, this.c, IContactSearchable.g);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 2;
    }
    l1 = SearchUtils.b(paramString, this.d, IContactSearchable.k);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 3;
    }
    l1 = SearchUtils.b(paramString, this.e, IContactSearchable.l);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 1;
    }
    l1 = SearchUtils.b(paramString, this.g, IContactSearchable.m);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 4;
    }
    l1 = SearchUtils.a(paramString, this.f, IContactSearchable.o, false);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += IContactSearchable.z;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      RecentUtil.a = true;
      QQAppInterface localQQAppInterface;
      String str2;
      String str3;
      switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
      {
      default: 
        SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, 1, paramView);
        SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str2 = a().toString();
        str3 = this.f;
        if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin != null) {
          break;
        }
      }
      for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin)
      {
        SearchUtils.a(localQQAppInterface, str2, str3, str1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
        SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
        SearchUtils.a(this, paramView);
        return;
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, this.k, false);
        break;
        RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, this.k, false);
        break;
      }
    }
    SearchUtils.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.k;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.l;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelRecentUser
 * JD-Core Version:    0.7.0.1
 */