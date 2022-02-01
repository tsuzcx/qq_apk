package com.tencent.mobileqq.search.business.contact.model;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.util.LruCache;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class ContactSearchModelPhoneContact
  extends IContactSearchModel
{
  private static LruCache<String, String> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(3);
  private long jdField_a_of_type_Long;
  public PhoneContact a;
  public ChnToSpell.ChnSpelling a;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  public ChnToSpell.ChnSpelling b;
  
  public ContactSearchModelPhoneContact(AppInterface paramAppInterface, int paramInt, PhoneContact paramPhoneContact)
  {
    super(paramAppInterface, paramInt, 0L);
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
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return ((IAddFriendServiceApi)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public int a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0"))) {
      return 1;
    }
    return 11;
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
    l = this.jdField_a_of_type_Long;
    if (l != -9223372036854775808L) {
      this.jdField_a_of_type_Long = (l + this.jdField_b_of_type_Long);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public CharSequence a()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return HardCodeUtil.a(2131702699);
    }
    if ((this.jdField_b_of_type_Int != 17) && (this.jdField_b_of_type_Int != 19)) {
      return HardCodeUtil.a(2131702738);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equalsIgnoreCase("0"))) {
      return HardCodeUtil.a(2131702721);
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, true)) {
      return HardCodeUtil.a(2131702745);
    }
    return null;
  }
  
  public Object a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    if (TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mn:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (str.equals("0")) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
    }
    return localObject;
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    if (TextUtils.isEmpty(str2)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    String str1 = str2;
    if (str2.equals("0")) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
    }
    return str1;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    int i;
    int j;
    Object localObject1;
    if ((paramView.getId() == 2131376477) && (this.jdField_b_of_type_Int == 17))
    {
      if (!((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 3, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
        i = 3075;
        j = 1;
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 3, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
        i = 3006;
        j = 13;
      }
      localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramView.getContext(), 2, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, null, i, j, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, null, null, HardCodeUtil.a(2131702741), null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramView.getContext(), (Intent)localObject1);
    }
    else
    {
      j = this.jdField_b_of_type_Int;
      i = 56940;
      Object localObject2;
      if (j == 17)
      {
        PhoneContact localPhoneContact = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        localObject1 = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!"0".equals(localPhoneContact.uin)))
        {
          localObject2 = localPhoneContact.unifiedCode;
          localObject1 = new AllInOne((String)localObject2, 53);
          i = 56939;
        }
        else if ("0".equals(localPhoneContact.uin))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
          if (((IPhoneContactService)localObject1).isBindedIgnoreUpload())
          {
            localObject1 = new AllInOne((String)localObject2, 53);
            i = 56941;
          }
          else
          {
            localObject1 = new AllInOne((String)localObject2, 29);
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
          localObject1 = new AllInOne((String)localObject2, 53);
          i = 56942;
        }
        ((AllInOne)localObject1).contactName = localPhoneContact.name;
        ((AllInOne)localObject1).nickname = localPhoneContact.name;
        ((AllInOne)localObject1).profileEntryType = 103;
        ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject1);
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
        SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), (String)localObject2, "", i);
      }
      else if (SearchUtils.a(this.jdField_b_of_type_Int))
      {
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
        if (!((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
        {
          if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            localObject2 = new AllInOne((String)localObject1, 29);
            ((AllInOne)localObject2).contactArray = new ArrayList();
            ((AllInOne)localObject2).contactName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((AllInOne)localObject2).nickname = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((AllInOne)localObject2).chatAbility = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((AllInOne)localObject2).lastActivity = 3;
            ((AllInOne)localObject2).profileEntryType = 103;
            ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject2);
            ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
            SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), (String)localObject1, "", 56940);
            return;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject2 = new AllInOne((String)localObject1, 53);
            ((AllInOne)localObject2).contactArray = new ArrayList();
            ((AllInOne)localObject2).contactName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((AllInOne)localObject2).nickname = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((AllInOne)localObject2).chatAbility = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((AllInOne)localObject2).lastActivity = 3;
            ((AllInOne)localObject2).profileEntryType = 103;
            ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject2);
            ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
            SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), (String)localObject1, "", 56942);
          }
        }
        else
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject2 = new AllInOne((String)localObject1, 53);
            ((AllInOne)localObject2).contactArray = new ArrayList();
            ((AllInOne)localObject2).contactName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((AllInOne)localObject2).nickname = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((AllInOne)localObject2).chatAbility = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((AllInOne)localObject2).lastActivity = 3;
            ((AllInOne)localObject2).profileEntryType = 103;
            ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject2);
            ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
            SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), (String)localObject1, "", 56942);
            return;
          }
          if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            i = 1006;
            break label1031;
          }
        }
        i = 0;
        label1031:
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject1, i, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, false);
        SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
        SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), (String)localObject1, "", i);
        SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
        SearchUtils.a(this, paramView);
        if (SearchConfigManager.needSeparate) {
          SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
        }
      }
      else
      {
        SearchUtils.a(paramView, this);
      }
    }
    if ((SearchUtils.a(this.jdField_b_of_type_Int)) && ((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
      SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
    }
    if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
    {
      if ((this.i != null) && (!TextUtils.isEmpty(this.i)))
      {
        UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        return;
      }
      UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (this.jdField_b_of_type_Int == 17)
    {
      String str = d();
      if (!TextUtils.isEmpty(str))
      {
        if ((!str.equals(this.k)) || (!TextUtils.equals(this.j, b())))
        {
          this.k = str;
          this.j = b();
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131702705));
          localSpannableStringBuilder.append(SearchUtils.a(str, b(), 10));
          this.jdField_b_of_type_JavaLangCharSequence = localSpannableStringBuilder;
        }
        return this.jdField_b_of_type_JavaLangCharSequence;
      }
      this.k = null;
      return null;
    }
    return super.c();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
  }
  
  public int d()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) {
      return 56938;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0")) {
      return 1006;
    }
    return 0;
  }
  
  public CharSequence d()
  {
    if ((this.jdField_b_of_type_Int == 17) && (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.samFriend > 0)) {
      return String.format(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getResources().getString(2131691093), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.samFriend) });
    }
    return null;
  }
  
  public String d()
  {
    if (this.jdField_b_of_type_Int == 17) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
  }
  
  public int e()
  {
    return 4;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact
 * JD-Core Version:    0.7.0.1
 */