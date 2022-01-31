package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.util.LruCache;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class ContactSearchModelPhoneContact
  extends IContactSearchModel
{
  private static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(3);
  private long jdField_a_of_type_Long;
  public PhoneContact a;
  public ChnToSpell.ChnSpelling a;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  public ChnToSpell.ChnSpelling b;
  
  public ContactSearchModelPhoneContact(QQAppInterface paramQQAppInterface, int paramInt, PhoneContact paramPhoneContact)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = IContactSearchable.I;
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    if (TextUtils.isEmpty(paramPhoneContact.uin)) {
      this.jdField_b_of_type_Long = IContactSearchable.Q;
    }
    if (!TextUtils.isEmpty(paramPhoneContact.name))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = ChnToSpell.a(paramPhoneContact.name, 1);
      this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = ChnToSpell.a(paramPhoneContact.name, 2);
    }
  }
  
  public int a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) || (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0"))) {
      return 11;
    }
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, IContactSearchable.m);
    if (l > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l;
    }
    String str2 = (String)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramString.replaceAll("-", "");
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, str1);
    }
    l = SearchUtils.a(str1, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo, IContactSearchable.p, true);
    if (l > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l;
    }
    l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName, IContactSearchable.l, false);
    if (l > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L) {
      this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "mn:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    int i;
    Object localObject1;
    if ((paramView.getId() == 2131368907) && (this.jdField_b_of_type_Int == 17))
    {
      int j;
      if (!((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).g())
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 3, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
        j = 1;
      }
      for (i = 3075;; i = 3006)
      {
        localObject1 = AddFriendLogicActivity.a(paramView.getContext(), 2, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, null, i, j, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, null, null, "返回", null);
        paramView.getContext().startActivity((Intent)localObject1);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 3, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
        j = 0;
      }
    }
    Object localObject2;
    if (this.jdField_b_of_type_Int == 17)
    {
      PhoneContact localPhoneContact = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!"0".equals(localPhoneContact.uin)))
      {
        localObject2 = localPhoneContact.unifiedCode;
        localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
        i = 56939;
      }
      for (;;)
      {
        ((ProfileActivity.AllInOne)localObject1).k = localPhoneContact.name;
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = localPhoneContact.name;
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 103;
        ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject1);
        SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject2, "", i);
        return;
        if ("0".equals(localPhoneContact.uin))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
          if (((PhoneContactManagerImp)localObject1).g())
          {
            localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
            i = 56941;
          }
          else
          {
            localObject1 = new ProfileActivity.AllInOne((String)localObject2, 29);
            i = 56940;
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
          localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
          i = 56942;
        }
      }
    }
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      RecentUtil.a = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
      i = 0;
      if (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).g())
      {
        if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
          localObject2 = new ProfileActivity.AllInOne((String)localObject1, 29);
          ((ProfileActivity.AllInOne)localObject2).a = new ArrayList();
          ((ProfileActivity.AllInOne)localObject2).k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
          ((ProfileActivity.AllInOne)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
          ((ProfileActivity.AllInOne)localObject2).g = 3;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 103;
          ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
          SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", 56940);
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
          localObject2 = new ProfileActivity.AllInOne((String)localObject1, 53);
          ((ProfileActivity.AllInOne)localObject2).a = new ArrayList();
          ((ProfileActivity.AllInOne)localObject2).k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
          ((ProfileActivity.AllInOne)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
          ((ProfileActivity.AllInOne)localObject2).g = 3;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 103;
          ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
          SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", 56942);
        }
      }
      else
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
          localObject2 = new ProfileActivity.AllInOne((String)localObject1, 53);
          ((ProfileActivity.AllInOne)localObject2).a = new ArrayList();
          ((ProfileActivity.AllInOne)localObject2).k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
          ((ProfileActivity.AllInOne)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
          ((ProfileActivity.AllInOne)localObject2).g = 3;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 103;
          ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
          SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", 56942);
          return;
        }
        if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
          i = 1006;
        }
      }
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, false);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", i);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
      return;
    }
    SearchUtils.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) {
      return 56938;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0")) {
      return 1006;
    }
    return 0;
  }
  
  public CharSequence b()
  {
    if (this.jdField_b_of_type_Int == 17)
    {
      String str = d();
      if (!TextUtils.isEmpty(str))
      {
        if ((!str.equals(this.j)) || (!TextUtils.equals(this.i, b())))
        {
          this.j = str;
          this.i = b();
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("昵称：");
          localSpannableStringBuilder.append(SearchUtils.a(str, b(), 10));
          this.jdField_b_of_type_JavaLangCharSequence = localSpannableStringBuilder;
        }
        return this.jdField_b_of_type_JavaLangCharSequence;
      }
      this.j = null;
      return null;
    }
    return super.b();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return "来自:手机通讯录";
    }
    if ((this.jdField_b_of_type_Int == 17) || (this.jdField_b_of_type_Int == 19))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equalsIgnoreCase("0"))) {
        return "已添加";
      }
      if (localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, true)) {
        return "等待验证";
      }
      return null;
    }
    return "手机通讯录";
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
  }
  
  public CharSequence d()
  {
    if ((this.jdField_b_of_type_Int == 17) && (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.samFriend > 0)) {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131433294), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.samFriend) });
    }
    return null;
  }
  
  public String d()
  {
    if (this.jdField_b_of_type_Int == 17) {
      return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact
 * JD-Core Version:    0.7.0.1
 */